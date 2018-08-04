package atc.study.controller;

import atc.study.jdo.User;
import atc.study.service.UsersLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UsersLogic usersLogic;

    @RequestMapping(value = "/getExpressUsersList",
            method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers(HttpServletRequest request,
                               HttpServletResponse response) {
        try {
            log.info("getExpressUsersList has been called");
            return usersLogic.getUsers();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return usersLogic.getUsers();
    }
}
