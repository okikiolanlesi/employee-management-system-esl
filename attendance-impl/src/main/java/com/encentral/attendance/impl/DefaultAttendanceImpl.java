package com.encentral.attendance.impl;

import com.ems.entities.JpaAttendance;
import com.ems.entities.JpaUser;
import com.ems.user.api.IAttendance;
import com.ems.user.model.Attendance;
import com.google.inject.Inject;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;

import javax.persistence.TypedQuery;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DefaultAttendanceImpl implements IAttendance {
    private JPAApi jpaApi;

    @Inject
    public DefaultAttendanceImpl(JPAApi jpaApi){
        this.jpaApi = jpaApi;
    }

    @Override
    public String
    markAttendance(String userUuid){
        LocalDateTime currentDateTime = LocalDateTime.now();

        LocalTime closingTime = LocalTime.of(17, 0);
        LocalTime openingTime = LocalTime.of(9, 0);

        if(currentDateTime.getDayOfWeek().compareTo(DayOfWeek.MONDAY) >= 0 &&
                currentDateTime.getDayOfWeek().compareTo(DayOfWeek.FRIDAY) <= 0){
            return "Today is not a work day";
        } else if (
        currentDateTime.toLocalTime().isBefore(openingTime)) {
            return "To early to mark attendance";
        } else if (currentDateTime.toLocalTime().isAfter(closingTime)) {
            return "To late to mark attendance";
        }



        JpaAttendance newEntry  = new JpaAttendance();
        newEntry.setUser();

        jpaApi.em().persist(newEntry);
        return "Attendance marked successfully";
    };

    @Override
    public List<Attendance> getDailyAttendance(){

        return new ArrayList<Attendance>();
    };
}
