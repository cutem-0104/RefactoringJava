package chapter1;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer (String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }
    public String getName() {
        return _name;
    }

//    public String statement1() {
//        double totalAmount = 0;
//        int frequentRenterPoints = 0;
//        Enumeration rentals = _rentals.elements();
//        String result = "Rental record for " + getName() + "\n";
//        while (rentals.hasMoreElements()) {
//            double thisAmount = 0;
//            Rental each = (Rental) rentals.nextElement();
//
//            // 一行ごとに金額を計算
//            switch (each.getMovie().getPriceCode()) {
//                case Movie.REGULAR:
//                    thisAmount += 2;
//                    if (each.getDaysRented() > 2)
//                        thisAmount += (each.getDaysRented() - 2) * 1.5;
//                    break;
//                case Movie.NEW_RELEASE:
//                    thisAmount += each.getDaysRented() * 3;
//                    break;
//                case Movie.CHILDRENS:
//                    thisAmount += 1.5;
//                    if (each.getDaysRented() > 3)
//                        thisAmount += (each.getDaysRented() - 3) * 1.5;
//                    break;
//            }
//
//            // レンタルポイントを加算
//            frequentRenterPoints++;
//            // 新作を二日以上かりた場合はボーナスポイント
//            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) frequentRenterPoints++;
//
//            // この貸し出しに関する数値の表示
//            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
//            totalAmount += thisAmount;
//        }
//
//        // フッタ部分の追加
//        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
//        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
//        return result;
//    }

    public String statement() {
        Enumeration rentals = _rentals.elements();
        String result = "Rental record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            // この貸し出しに関する数値の表示
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(each.getCharge()) + "\n";
        }

        // フッタ部分の追加
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
                " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        Enumeration rentals = _rentals.elements();
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            // この貸し出しに関する数値の表示
            result += each.getMovie().getTitle() + ": " +
                    String.valueOf(each.getCharge()) + "<BR>\n";
        }

        // フッタ部分の追加
        result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "On this rental you earned <EM>" +
                String.valueOf(getTotalFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    // publicでほかのクラスからも利用されている場合は残すのもアリ
//    private double amountFor(Rental aRental) {
//        return aRental.getCharge();
//    }
}
