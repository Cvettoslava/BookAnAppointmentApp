package com.github.cvettoslava.courseproject.service;

import java.util.List;

import com.github.cvettoslava.courseproject.model.ScheduledSession;
import com.github.cvettoslava.courseproject.repository.ScheduleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository repository;

    public List<ScheduledSession> getAll() {
        return repository.findAll(Sort.by("date").ascending().ascending().and(Sort.by("time").ascending()));
    }

    /*
     * public List<ScheduledSession> getByName(String name) {
     * 
     * return repository.findByName(name); }
     */

    public ScheduledSession getById(int id) {
        return repository.findById(id).get();
    }

    public void create(String name, String phone, String date, String time, int serviceId) {
        ScheduledSession session = new ScheduledSession();
        session.setName(name);
        session.setPhone(phone);
        session.setDate(date);
        session.setTime(time);
        session.setService_id(serviceId);

        repository.save(session);
    }

    public void save(ScheduledSession session) {
        repository.save(session);
    }

    public void delete(ScheduledSession session) {
        repository.delete(session);
    }

    public List<ScheduledSession> searchByPhone(String phone) {
        return repository.findAllByPhoneContaining(phone);
    }

}
