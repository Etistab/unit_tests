import java.util.ArrayList;

public class ToDoList {
    private User author;
    private ArrayList<Item> itemList;
    private EmailService emailService = new EmailService();

    public void addItem(Item item) {
        if (canAddItem(item)) {
            itemList.add(item);
            emailService.send(author, "You added "+ item.getName() +" to your to-do list");
        }
    }

    private boolean canAddItem(Item item ){
        return itemList.size() < 10 &&
                item.getContent().length() < 1000 &&
                itemIsUnique(item);
    }

    private boolean itemIsUnique(Item item) {
        for (Item i: itemList) {
            if(i.getName().equals(item.getName())) {
                return false;
            }
        }
        return true;
    }
}
