import java.util.ArrayList;
import java.util.List;

public class Client {
    private int age;
    private String name;
    private int IDnumber;
    private String adress;
    private List<BankAccount> accounts;

    private int bankID;

    private int pin;

    public Client(String name, int age, int IDnumber, String adress) {
        /***
         Constructor
         ***/
        this.name = name;
        this.age = age;
        this.IDnumber = IDnumber;
        this.adress = adress;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount bankAccount) {
        /***
         Add an account to the user
         ***/
        this.accounts.add(bankAccount);
    }

    public void removeAccount(BankAccount selectedAccount) {
        /***
         Remove an account from the user, think of edge cases. Can you always remove an account?
         ***/
        if (this.accounts.size() > 1) {
            this.accounts.remove(selectedAccount);
        } else {
            System.out.println("Can't remove primary account");
        }
    }

    public int getAge() {
        /***
         Getter
         ***/
        return this.age;
    }

    public String getName() {
        /***
         Getter
         ***/

        return this.name;
    }

    public List<BankAccount> getAccounts() {
        /***
         Getter
         ***/
        return this.accounts;
    }

    public void addBankID(int bankID) {
        /***
         Setter
         ***/
        this.bankID = bankID;
    }

    public int getBankID() {
        /***
         Getter
         ***/
        return this.bankID;
    }


    public void setPin(int pin) {
        /***
         Setter
         ***/
        this.pin = pin;
    }

    public int getPin() {
        /***
         Getter
         ***/
        return this.pin;
    }
}
