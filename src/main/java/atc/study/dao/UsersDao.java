package atc.study.dao;

import atc.study.jdo.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UsersDao {

    @Transactional
    void createUsersTable();

    @Transactional
    List<User> getUsers();

    @Transactional
    List<User> getActiveUsers(boolean userActive);
}
