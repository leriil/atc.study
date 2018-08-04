package atc.study.dao.mapping;

import atc.study.jdo.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User location = new User();
        location.setUserId(rs.getLong("userId"));
        location.setUserName(rs.getString("userName"));
        location.setUserBirthday(rs.getDate("userBirthday"));
        location.setUserActive(rs.getBoolean("userActive"));
        return location;
    }
}
