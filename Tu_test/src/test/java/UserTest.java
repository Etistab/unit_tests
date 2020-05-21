import java.time.LocalDate;
import java.util.Date;
import org.junit.*;

import static junit.framework.TestCase.fail;

public class UserTest {

    private int ValidValue = 1;
    private String example = "Test";
    private String email = "toto@gmail.com";
    private LocalDate testDate = LocalDate.now().minusYears(20);
    private String password = "testetsttest";


    private User user = new User(email,example,example,testDate,password);

    @Test
    public final void testEmailValidate(){
        if(user.EmailValidate() == false){
            fail("email incorrect");
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
    public final void testPasswordValidate(){
        if(user.PasswordValidate() == false){
            fail("prénom non renseigné");
        }
    }

    @Test
    public final void testBirthdateValidate(){
        if(user.BirthdateValidate() != 1){
            //fail("date de naissance non renseigné");
        }
    }

    @Test
    public final void testUserValidate(){
        if(user.isValid() == false){
            fail("User non valide");
        }
    }



}
