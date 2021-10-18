package J1_S_P0073;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author HE140661
 */
public class Expense {

    private int id;
    private Date date;
    private int ammount;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        return String.format("%-5d%-15s%-10d%-20s\n", id,
                dateFormat.format(date), ammount, content);
    }
}
