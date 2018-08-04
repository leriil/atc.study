package atc.study.service;

import atc.study.dao.UsersDao;
import atc.study.jdo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersLogic {

    private static final Logger log = LoggerFactory.getLogger(UsersLogic.class);
    private static final boolean userActive = true;

    @Autowired
    private UsersDao usersDao;

    public List<User> getUsers() {
        log.info("getUsers has been called");
        List<User> users = usersDao.getActiveUsers(userActive);

        return users;
    }

}
