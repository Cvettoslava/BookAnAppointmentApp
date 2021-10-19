package com.github.cvettoslava.courseproject.controller;

import java.util.List;

import com.github.cvettoslava.courseproject.model.ScheduledSession;
import com.github.cvettoslava.courseproject.service.ScheduleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminScheduleController {

    @Autowired
    public ScheduleService service;

    @GetMapping("/admin/schedule")
    public String index(Model model) {
        model.addAttribute("schedule", service.getAll());
        return "admin/schedule/index";
    }

    @GetMapping("/admin/schedule/{id}")
    public String view(Model model, @PathVariable("id") int id) {
        ScheduledSession session = service.getById(id);
        model.addAttribute("session", session);
        return "admin/schedule/view";
    }

    @GetMapping("/admin/schedule/create")
    public String create() {

        return "admin/schedule/create";
    }

    @PostMapping("/admin/schedule/create")
    public String save(@RequestParam("name") String name, @RequestParam("number") String number,
            @RequestParam("service") int service_id, @RequestParam("date") String date,
            @RequestParam("time") String time) {

        service.create(name, number, date, time, service_id);

        return "redirect:/admin/schedule";
    }

    @GetMapping("/admin/schedule/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        ScheduledSession session = service.getById(id);
        model.addAttribute("scheduledSession", session);
        return "admin/schedule/edit";
    }

    @PostMapping("/admin/schedule/{id}/edit")
    public String update(Model model, @PathVariable("id") int id, @RequestParam("name") String name,
            @RequestParam("number") String number, @RequestParam("service") int service_id,
            @RequestParam("date") String date, @RequestParam("time") String time) {

        ScheduledSession session = service.getById(id);
        model.addAttribute("session", session);

        session.setName(name);
        session.setPhone(number);
        session.setService_id(service_id);
        session.setDate(date);
        session.setTime(time);
        service.save(session);

        return "redirect:/admin/schedule";

    }

    @GetMapping("/admin/schedule/{id}/delete")
    public String delete(Model model, @PathVariable("id") int id) {
        ScheduledSession session = service.getById(id);
        model.addAttribute("session", session);
        model.addAttribute("id", id);

        return "admin/schedule/delete";
    }

    @PostMapping("/admin/schedule/{id}/delete")
    public String destroy(Model model, @PathVariable("id") int id) {
        ScheduledSession session = service.getById(id);
        model.addAttribute("session", session);

        service.delete(session);

        return "redirect:/admin/schedule";
    }

    @GetMapping("/admin/schedule/search")
    public String search(Model model, @RequestParam("q") String query) {
        List<ScheduledSession> searchResults = service.searchByPhone(query);
        model.addAttribute("schedule", searchResults);

        return "admin/schedule/index";
    }
}
