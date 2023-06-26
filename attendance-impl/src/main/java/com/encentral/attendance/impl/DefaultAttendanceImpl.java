package com.encentral.attendance.impl;

import com.ems.entities.JpaUser;
import com.ems.user.api.IAttendance;
import com.google.inject.Inject;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;

import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class DefaultAttendanceImpl implements IAttendance {
    private JPAApi jpaApi;

    @Inject
    public DefaultAttendanceImpl(JPAApi jpaApi){
        this.jpaApi = jpaApi;
    }

    @Override
    public String
    getDailyAttendance(String user){
return "";
    };
}
