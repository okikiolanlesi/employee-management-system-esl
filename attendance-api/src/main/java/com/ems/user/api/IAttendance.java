package com.ems.user.api;

import com.ems.user.model.Attendance;

import java.util.List;
import java.util.Optional;

public interface IAttendance {
    String markAttendance(String userUuid);
    List<Attendance> getDailyAttendance();
}
