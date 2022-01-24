import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Account implements Comparable<Account> {
    private String userName;
    private String password;

    public void output() {
        System.out.format("%-20s ", userName);
    }

    public Account(){

    }

    public Account(String userName,
                   String password) {
        this.userName = userName;
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public int compareTo(Account o) {
        return this.getUserName().compareTo(o.getUserName());
    }

}
