import org.junit.*;
import java.time.LocalDate;
import static junit.framework.TestCase.*;

public class ToDoListTest {

    private String example = "Test";
    private String email = "toto@gmail.com";
    private LocalDate testDate = LocalDate.now().minusYears(20);
    private String password = "testetsttest";


    private User user = new User(email,example,example,testDate,password);

    @Test
    public final void listValidate() {
        if(user.toDoList.getItemList().size() <= 10) {
            // success
        } else {
            fail("list invalide");
        }
    }

    @Test
    public final void itemsValidate() {
        Item lastItem = new Item();
        for (Item i: user.toDoList.getItemList()) {
            if(i.getContent().length() >= 1000
                    && !user.toDoList.itemIsUnique(i)
                    && i.getCreationDate().minusDays(1/48).isAfter(lastItem.getCreationDate())) {
                fail("item invalide");
            }
        }
        // success
    }

    @Test
    public final void sendValidate() {
        User testRecipient = new User();
        String testMessage = "test message";

        if(LocalDate.now().minusYears(18).isAfter(user.getBirthdate()) &&
                user.toDoList.getEmailService().send(testRecipient, testMessage)) {
            //success
        } else {
            fail("send invalide");
        }
    }
}
