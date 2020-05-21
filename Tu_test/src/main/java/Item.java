import java.time.LocalDate;

public class Item {
    private String name;
    private String content;
    private LocalDate creationDate;

    public String getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}
