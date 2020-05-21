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

    private User userNull = new User("","","",LocalDate.now().minusYears(10),"");

    private User userWrong = new User("aaaaaa","b","aaa",LocalDate.now().minusYears(9999),"test");

    @Test
    public final void testEmailValidate(){
        if(user.EmailValidate() == false){
            fail("email incorrect");
        }
    }

    @Test
    public final void testNameValidate(){
        if(user.NameValidate() != 1){
            fail("nom non renseigné");
        }
    }

    @Test
    public final void testFirstnameValidate(){
        if(user.FirstnameValidate() != 1){
            fail("prénom non renseigné");
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
            fail("date de naissance non renseigné");
        }
    }

    @Test
    public final void testUserValidate(){
        if(user.isValid() == false){
            fail("User non valide");
        }
    }

    @Test
    public final void testNameIsNull(){
        if(userNull.NameValidate() == 1){
            fail("le name est null");
        }
    }

    @Test
    public final void testFirstNameIsNull(){
        if(userNull.FirstnameValidate() == 1){
            fail("le firstname est null");
        }
    }

    @Test
    public final void testPasswordIsNull(){
        if(userNull.PasswordValidate() == true){
            fail("le password est trop court");
        }
    }

    @Test
    public final void testEmailIsNull(){
        if(userNull.EmailValidate() == true){
            fail("l'email est null");
        }
    }

    @Test
    public final void testUserTooYoung(){
        if(userNull.BirthdateValidate() == 1){
            fail("l'utilisateur est trop jeune");
        }
    }

    @Test
    public final void testUnvalidEmail(){
        if(userWrong.EmailValidate() == true){
            fail("l'email est incorrect");
        }
    }


}
