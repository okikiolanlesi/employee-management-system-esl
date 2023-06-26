package controllers;

import com.ems.user.api.IUser;
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


@Transactional
@Api(value = "Employee Management System")
public class UserController extends Controller {

    @Inject
    IUser iUser;

    @Inject
    FormFactory formFactory;

    @Inject
    MyObjectMapper objectMapper;

    @ApiOperation(value = "Register a user")
    @ApiResponses(
            value= {@ApiResponse(code = 200, response = User.class, message="User registered succcessfully")}
    )
    public Result register() throws JsonProcessingException {
        Form<User> userForm = formFactory.form(User.class).bindFromRequest();

        JsonNode json = request().body().asJson();
        System.out.println(json);

        if(userForm.hasErrors()){
            return badRequest(userForm.errorsAsJson());
        }

        String registeredUser = iUser.addEmployee(userForm.get());

        if(registeredUser == null){
            return badRequest("email already taken");
        }

        return ok(objectMapper.writeValueAsString(registeredUser));
    }

    public Result getUser(Long userId) throws JsonProcessingException {
        Form<User> userForm = formFactory.form(User.class).bindFromRequest();

        if(userForm.hasErrors()){
            return badRequest(userForm.errorsAsJson());
        }

        return ok(objectMapper.writeValueAsString(iUser.getUser(userId)));
    }
}
