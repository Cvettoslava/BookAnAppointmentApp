package com.github.cvettoslava.courseproject.repository;

import java.util.List;

import com.github.cvettoslava.courseproject.model.ScheduledSession;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;

public interface ScheduleRepository extends JpaRepository<ScheduledSession, Integer> {
    List<ScheduledSession> findAllByPhoneContaining(String phone);

    List<ScheduledSession> findAll(Sort sort);

    // List<ScheduledSession> findByName(String name);

}
