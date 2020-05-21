import java.time.LocalDate;
import java.util.ArrayList;

public class ToDoList {
    private User author;
    public ArrayList<Item> itemList = new ArrayList<>();
    private EmailService emailService = new EmailService();

    public ToDoList(User author) {
        this.author = author;
    }

    public void addItem(Item item) {
        if (canAddItem(item)) {
            itemList.add(item);
            emailService.send(author, "You added "+ item.getName() +" to your to-do list");
        }
    }

    private boolean canAddItem(Item item ){
        return itemList.size() < 10 &&
                item.getContent().length() < 1000 &&
                LocalDate.now().minusDays(1/48).isAfter(item.getCreationDate()) &&
                itemIsUnique(item);
    }

    public boolean itemIsUnique(Item item) {
        if (itemList == null) {
            return true;
        }
        for (Item i: itemList) {
            if(i != item && i.getName().equals(item.getName())) {
                return false;
            }
        }
        return true;
    }

    public boolean isValid() {
        return itemList != null && itemList.size() <= 10;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public EmailService getEmailService() {
        return emailService;
    }
}
