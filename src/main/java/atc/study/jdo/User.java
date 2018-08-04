package atc.study.jdo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;

public class User {

    private Long userId;
    @JsonProperty(value = "name", required = true)
    private String userName;
    @JsonProperty(value = "userBirthday", required = true)
    private Date userBirthday;
//    @JsonProperty(value = "active", required = true)
    private boolean userActive;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public boolean getUserActive() {
        return userActive;
    }

    public void setUserActive(boolean userActive) {
        this.userActive = userActive;
    }
}