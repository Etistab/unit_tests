import java.util.ArrayList;

public class ToDoList {
    private ArrayList<Item> itemList;

    public void addItem(Item item) {
        if (canAddItem(item)) {
            itemList.add(item);
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
