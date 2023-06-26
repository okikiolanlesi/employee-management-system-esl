package controllers;

import com.ems.user.api.IAttendance;
import com.ems.user.api.IUser;
import com.ems.user.model.Attendance;
import com.ems.user.model.User;
import com.encentral.scaffold.commons.utils.MyObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;


@Transactional
@Api(value = "Attendance")
public class AttendanceController extends Controller {

    @Inject
    IAttendance IAttendance;

    @Inject
    FormFactory formFactory;

    @Inject
    MyObjectMapper objectMapper;

    @ApiOperation(value = "Mark Attendance")
    @ApiResponses(
            value= {@ApiResponse(code = 200, response = Attendance.class, message="Attendance marked successfully")}
    )
    public Result markAttendance(String userUuid) throws JsonProcessingException {
        String result = IAttendance.markAttendance(userUuid);

        if(result == null){
            return badRequest("user does not exist");
        }

        return ok(result);
    }

    @ApiOperation(value = "Get daily Attendance")
    @ApiResponses(
            value= {@ApiResponse(code = 200, response = Attendance.class, message="Attendance fetched successfully")}
    )
    public Result getDailyAttendance() throws JsonProcessingException{
        List<Attendance> result = IAttendance.getDailyAttendance();

        return ok(objectMapper.writeValueAsString(result));
    }


}
