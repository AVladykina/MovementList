import com.sun.source.tree.IfTree;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    private static String accountFile = "data/movementList.csv";
    private static String dateFormat = "dd.MM.yy";

    public static void main(String[] args) {

        ArrayList<Transaction> transactions = loadStatementFromFile();

        HashMap<String,Double> typesExpensesMap = typesExpenses(transactions);

        System.out.println("Общий приход в рублях: " + sumArrival(transactions));
        System.out.println("Общий расход в рублях: " + sumExpense(transactions));

        System.out.println(typesExpensesMap);



    }


    private static ArrayList<Transaction> loadStatementFromFile()
    {
        ArrayList<Transaction> transaction = new ArrayList<>();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(accountFile));
            lines.remove(0);
            for(String line : lines) {
                String[] fragments = line.split(",",8);
                if (fragments.length != 8) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                transaction.add(new Transaction(
                        fragments[0],
                        fragments[1],
                        fragments[2],
                        (new SimpleDateFormat(dateFormat)).parse(fragments[3]),
                        fragments[4],
                        fragments[5],
                        Double.parseDouble(fragments[6].replaceAll("\"", "").replaceAll(",",".")),
                        Double.parseDouble(fragments[7].replaceAll("\"", "").replaceAll(",","."))
                ));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return transaction;
    }

    private static double sumArrival(ArrayList<Transaction> transactions) {
        double sum = 0;
        for (Transaction listTransaction : transactions)
            sum += listTransaction.getArrival();
        return sum;

    }

    private static double sumExpense(ArrayList<Transaction> transactions) {
        double sum = 0;
        for (Transaction listTransaction : transactions)
            sum += listTransaction.getExpense();
        return sum;
    }

    private static HashMap<String,Double> typesExpenses(ArrayList<Transaction> transactions){
        HashMap<String,Double> typesExpensesMap = new HashMap<>();
        for (Transaction listTransaction : transactions) {
            String typeExpense;
            if (listTransaction.getExpense() == 0) {
                continue;
            }

            String fragment = listTransaction
                    .getDescriptionOfTransaction()
                    .split("\\d{2}\\.\\d{2}\\.\\d{2}",2)[0]
                    .trim();

            int lastSlash = fragment.lastIndexOf("/");

            if (lastSlash == -1)
                lastSlash = fragment.lastIndexOf("\\");

            typeExpense = fragment.substring(lastSlash + 1).trim();

            typesExpensesMap.compute(typeExpense, (k, v) ->
                    listTransaction.getExpense() + (v == null ? 0 : v));
        }

        return typesExpensesMap;
    }
}
