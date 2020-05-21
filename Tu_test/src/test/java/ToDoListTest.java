import org.junit.*;
import java.time.LocalDate;

public class ToDoListTest {
    private User user = new User("toto@gmail.com", "Test", "bob", LocalDate.now().minusYears(20), "azerty");

    @Test
    public final void listValidate() {
        ToDoList toDoList = new ToDoList(user);

        Assert.assertTrue(toDoList.isValid());
        for(int i = 0; i < 12; i++) {
            toDoList.itemList.add(new Item("test", "test", LocalDate.now()));
            if(i == 10) {
                Assert.assertTrue(toDoList.isValid());
            }
        }
        Assert.assertFalse(toDoList.isValid());
    }

    @Test
    public final void itemIsUnique() {
        ToDoList toDoList = new ToDoList(user);

        toDoList.itemList.add(new Item("test1", "test", LocalDate.now()));
        Assert.assertTrue(toDoList.itemIsUnique(toDoList.itemList.get(0)));
        toDoList.itemList.add(new Item("test2", "test", LocalDate.now()));
        Assert.assertTrue(toDoList.itemIsUnique(toDoList.itemList.get(1)));
        toDoList.itemList.add(new Item("test2", "test", LocalDate.now()));
        Assert.assertFalse(toDoList.itemIsUnique(toDoList.itemList.get(2)));
    }

    @Test
    public final void itemContentValidate() {
        ToDoList toDoList = new ToDoList(user);

        toDoList.itemList.add(new Item("test1", "test", LocalDate.now()));
        Assert.assertTrue(toDoList.itemList.get(0).getContent().length() >= 1000);
    }

    @Test
    public final void itemsDateValidate() {
        ToDoList toDoList = new ToDoList(user);

        toDoList.itemList.add(new Item("test1", "test", LocalDate.now()));
        toDoList.itemList.add(new Item("test2", "test", LocalDate.now().plusDays(1)));
        Assert.assertTrue(toDoList.itemList.get(1).getCreationDate().minusDays(1/48).isAfter(toDoList.itemList.get(2).getCreationDate()));
        toDoList.itemList.add(new Item("test2", "test", LocalDate.now().plusDays(1/100)));
        Assert.assertFalse(toDoList.itemList.get(2).getCreationDate().minusDays(1/48).isAfter(toDoList.itemList.get(1).getCreationDate()));
    }

    @Test
    public final void sendValidate() {
        User wrongRecipient = new User("toto@gmail.com", "Test", "bob", LocalDate.now().minusYears(17), "azerty");
        String testMessage = "test message";

        Assert.assertTrue(user.toDoList.getEmailService().send(user, testMessage));
        Assert.assertFalse(user.toDoList.getEmailService().send(wrongRecipient, testMessage));
    }
}
