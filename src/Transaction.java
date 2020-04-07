import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    private String typeAccount;
    private String numberAccount;
    private String currency;
    private Date dateOfTransaction;
    private String postingReference;
    private String descriptionOfTransaction;
    private double arrival;
    private double expense;


    public Transaction(String typeAccount, String numberAccount, String currency, Date dateOfTransaction, String postingReference, String descriptionOfTransaction, double arrival, double expense){

        this.typeAccount = typeAccount;
        this.numberAccount = numberAccount;
        this.currency = currency;
        this.dateOfTransaction = dateOfTransaction;
        this.postingReference = postingReference;
        this.descriptionOfTransaction = descriptionOfTransaction;
        this.arrival = arrival;
        this.expense = expense;
    }


    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(Date dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public String getPostingReference() {
        return postingReference;
    }

    public void setPostingReference(String postingReference) {
        this.postingReference = postingReference;
    }

    public String getDescriptionOfTransaction() {
        return descriptionOfTransaction;
    }

    public void setDescriptionOfTransaction(String descriptionOfTransaction) {
        this.descriptionOfTransaction = descriptionOfTransaction;
    }

    public double getArrival() {
        return arrival;
    }

    public void setArrival(double arrival) {
        this.arrival = arrival;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public String toString()
    {
        return typeAccount + " - " + numberAccount + " - " +
                " - " + currency + " - " +
                (new SimpleDateFormat("dd.MM.yyyy")).format(dateOfTransaction)
                + " - " + postingReference + " - " + descriptionOfTransaction + " - " +
                arrival + " - " + expense;
    }
}
