import java.util.Date;
import org.junit.*;

public class UserTest {

    private int ValidValue = 1;
    private String example = "Test";
    private Date testDate = new Date(17/03/1996);


    private User user = new User("toto@gmail.com",example,example,testDate);

    @Test
    public final void testEmailValidate(){
        if(user.EmailValidate() != 1){
            //fail("email non renseigné");
        }
    }

    @Test
    public final void testNameValidate(){
        if(user.NameValidate() != 1){
            //fail("nom non renseigné");
        }
    }

    @Test
    public final void testFirstnameValidate(){
        if(user.FirstnameValidate() != 1){
            //fail("prénom non renseigné");
        }
    }

    @Test
    public final void testBirthdateValidate(){
        if(user.BirthdateValidate() != 1){
            //fail("date de naissance non renseigné");
        }
    }

}
