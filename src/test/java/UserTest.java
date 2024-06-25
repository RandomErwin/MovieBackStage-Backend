import org.apache.catalina.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.web.dao.UserDao;
import org.web.entity.Users;
import org.web.service.UserService;


public class UserTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Transactional
    @Test
    public void saveUsers(){
        Users user1 = new Users();
        user1.setUserName("JavaMan");
        user1.setAccount("bycrypt1126");
        user1.setNickName("與神同行");
        userService.createUser(user1);
    }

}
