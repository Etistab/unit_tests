import org.apache.commons.validator.routines.EmailValidator;

import java.time.LocalDate;

public class User {

    private String email;
    private String name;
    private String firstname;
    private LocalDate birthdate;
    private String password;

    public User(String email, String name, String firstname, LocalDate birthdate,String password) {
        this.email = email;
        this.name = name;
        this.firstname = firstname;
        this.birthdate = birthdate;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean EmailValidate(){
        if(this.email != null){
            return false;
        }else{
            EmailValidator validator = EmailValidator.getInstance();
            return validator.isValid(email);
        }
    }

    public int NameValidate(){
        if(this.name != null){
            return 1;
        }
        return 0;
    }

    public int FirstnameValidate(){
        if(this.firstname != null){
            return 1;
        }
        return 0;
    }

    public boolean PasswordValidate(){
        if(this.password != null){
            if(this.password.length() <= 40 && this.password.length() >= 8){
                return true;
            }
        }
        return false;
    }

    public int BirthdateValidate(){
        if(this.birthdate != null){
            LocalDate.now().minusYears(13).isAfter(this.birthdate);
            return 1;
            // RAJOUTER VERIFICATION AGE
        }
        return 0;
    }

    public boolean isValid(){
        if(EmailValidate() == true && NameValidate() == 1 && FirstnameValidate() == 1 && BirthdateValidate() == 1 && PasswordValidate() == true){
            return true;
        }
        return false;
    }
}
