select userId as userId,
userName as userName,
userBirthday as userBirthday,
userActive as userActive
from cms.users where userActive = :userActive;