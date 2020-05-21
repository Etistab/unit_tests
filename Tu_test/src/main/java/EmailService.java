import java.time.LocalDate;
import java.util.Date;

public class EmailService {
    public boolean send(User recipient, String message) {
        return LocalDate.now().minusYears(18).isAfter(recipient.getBirthdate());
    }
}
