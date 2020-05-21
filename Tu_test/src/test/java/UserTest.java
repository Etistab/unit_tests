import java.time.LocalDate;
import org.junit.*;

import static junit.framework.TestCase.fail;

public class UserTest {

    private int ValidValue = 1;
    private String example = "Test";
    private String email = "toto@gmail.com";
    private LocalDate testDate = LocalDate.now().minusYears(20);
    private String password = "testetsttest";


    private User user = new User(email,example,example,testDate,password);

    private User userNull = new User("","","",LocalDate.now().minusYears(10),"");

    private User userWrong = new User("aaaaaa","b","aaa",LocalDate.now().minusYears(9999),"test");

    @Test
    public final void testEmailValidate(){
        Assert.assertTrue(user.EmailValidate());
    }

    @Test
    public final void testNameValidate(){
        Assert.assertTrue(user.NameValidate());
    }

    @Test
    public final void testFirstnameValidate(){
        Assert.assertTrue(user.FirstnameValidate());
    }

    @Test
    public final void testPasswordValidate(){
        Assert.assertTrue(user.PasswordValidate());
    }

    @Test
    public final void testBirthdateValidate(){
        Assert.assertTrue(user.BirthdateValidate());
    }

    @Test
    public final void testUserValidate(){
        Assert.assertTrue(user.isValid());
    }

    @Test
    public final void testNameIsNull(){
        Assert.assertTrue(userNull.NameValidate());
    }

    @Test
    public final void testFirstNameIsNull(){
        Assert.assertFalse(userNull.FirstnameValidate());
    }

    @Test
    public final void testPasswordIsNull(){
        Assert.assertFalse(userNull.PasswordValidate());
    }

    @Test
    public final void testEmailIsNull(){
        Assert.assertFalse(userNull.EmailValidate());
    }

    @Test
    public final void testUserTooYoung(){
        Assert.assertFalse(userNull.BirthdateValidate());
    }

    @Test
    public final void testUnvalidEmail(){
        Assert.assertFalse(userWrong.EmailValidate());
    }


}
