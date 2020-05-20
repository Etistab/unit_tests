import java.util.Date;

public class EmailService {
    public boolean send(User recipient, String message) {
        return new Date().getTime() - 18 * 365.25 * 24 * 3600 > recipient.getBirthdate().getTime();
    }
}
