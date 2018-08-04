package atc.study.dao;

import atc.study.dao.mapping.UserRowMapper;
import atc.study.jdo.User;
import atc.study.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsersDaoImpl implements UsersDao {

    private static final Logger log = LoggerFactory.getLogger(UsersDaoImpl.class);

    private static final String CREATE_USERS_TABLE = FileUtils.loadScriptFromFile("/sql/create/users.sql");
    private static final String GET_USERS = FileUtils.loadScriptFromFile("/sql/users/get-users.sql");
    private static final String GET_ACTIVE_USERS = FileUtils.loadScriptFromFile("/sql/users/get-active-users.sql");

    @PostConstruct
    public void init() {
        createUsersTable();
    }

    @Override
    @Transactional
    public void createUsersTable() {
        jdbcTemplate.execute(CREATE_USERS_TABLE);
    }

    @Autowired
    @Qualifier("targetTemplate")
    JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("namedParameterTargetTemplate")
    NamedParameterJdbcTemplate namedParameterTargetTemplate;

    @Override
    @Transactional
    public List<User> getUsers() {
        log.info("calling getUsers");
        Map<String, Object> params = new HashMap<>();

        return namedParameterTargetTemplate.query(GET_USERS, params, new UserRowMapper());
    }

    @Override
    @Transactional
    public List<User> getActiveUsers(boolean userActive) {
        log.info("calling getUsers");
        Map<String, Object> params = new HashMap<>();
        params.put("userActive", userActive);

        return namedParameterTargetTemplate.query(GET_ACTIVE_USERS, params, new UserRowMapper());
    }
}
