package com.ems.user.model;

import com.ems.entities.JpaAttendance;
import com.ems.entities.JpaUser;

public class AttendanceMapper {

    public static JpaAttendance attendanceToJpaAttendance(Attendance attendance){
        JpaAttendance jpaAttendance = new JpaAttendance();
        jpaAttendance.setCreatedAt(attendance.getCreatedAt());
        jpaAttendance.setUpdatedAt(attendance.getUpdatedAt());
        jpaAttendance.setId(attendance.getId());

        return jpaAttendance;
    }

    public static Attendance jpaAttendanceToAttendance(JpaAttendance jpaAttendance){
        Attendance attendance = new Attendance();
        attendance.setCreatedAt(jpaAttendance.getCreatedAt());
        attendance.setUpdatedAt(jpaAttendance.getUpdatedAt());
        attendance.setId(jpaAttendance.getId());
        return attendance;
    }
}
