package com.encentral.attendance.impl;

import com.ems.user.api.IAttendance;
import com.google.inject.AbstractModule;

public class AttendanceModule extends AbstractModule {

    @Override
    protected void configure(){
        bind(IAttendance.class).to(DefaultAttendanceImpl.class);
    }
}
