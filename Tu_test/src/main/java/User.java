import java.util.Date;

public class User {

    private String email;
    private String name;
    private String firstname;
    private Date birthdate;

    public User(String email, String name, String firstname, Date birthdate) {
        this.email = email;
        this.name = name;
        this.firstname = firstname;
        this.birthdate = birthdate;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int EmailValidate(){
        if(this.email != null){
            return 1;
        }
        return 0;
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

    public int BirthdateValidate(){
        if(this.birthdate != null){
            return 1;
        }
        return 0;
    }

    public void isValid(){
        if(EmailValidate() == 1 && NameValidate() == 1 && FirstnameValidate() == 1 && BirthdateValidate() == 1){
            //Ok
        }
    }

}
