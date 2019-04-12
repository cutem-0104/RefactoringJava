package chapter6;

import java.util.Enumeration;
import java.util.Vector;

public class MethodExtraction {
    private String _name = "name";
    private Vector<Order> _orders = new Vector<>();

    public Vector<Order> getOrders() {
        return _orders;
    }

    public void setOrders(Vector<Order> _orders) {
        this._orders = _orders;
    }

    void printOwing() {
        // バナーの印刷
//        System.out.println("*******************");
//        System.out.println("***Customer Owes***");
//        System.out.println("*******************");
        printBanner();

        // 未払い金の計算
//        Enumeration e = _orders.elements();
//        double outstanding = 0.0;
//        while (e.hasMoreElements()) {
//            Order each = (Order) e.nextElement();
//            outstanding += each.getAmount();
//        }
        double outstanding = getOutstanding();

        // 明細の印刷
//        System.out.println("name: " + _name);
//        System.out.println("amount: " + outstanding);
        printDetails(outstanding);
    }

    void printOwing(double previousAmount) {
        // バナーの印刷
        printBanner();

        // 未払い金の計算
//        double outstanding = previousAmount * 1.2;
//        Enumeration e = _orders.elements();
//        while (e.hasMoreElements()) {
//            Order each = (Order) e.nextElement();
//            outstanding += each.getAmount();
//        }
        double outstanding = getOutstanding(previousAmount * 1.2);

        // 明細の印刷
        printDetails(outstanding);
    }

    // ローカル変数を使わないメソッド抽出
    void printBanner() {
        System.out.println("*******************");
        System.out.println("***Customer Owes***");
        System.out.println("*******************");
    }

    // ローカル変数を使うメソッド抽出
    void printDetails(double outstanding) {
        System.out.println("name: " + _name);
        System.out.println("amount: " + outstanding);
    }

    // ローカル変数の再代入
    double getOutstanding() {
        double result = 0.0;
        Enumeration e = _orders.elements();
        while (e.hasMoreElements()) {
            Order each = (Order) e.nextElement();
            result += each.getAmount();
        }
        return result;
    }

    // ローカル変数の再代入 初期化
    double getOutstanding(double initialValue) {
        double result = initialValue;
        Enumeration e = _orders.elements();
        while (e.hasMoreElements()) {
            Order each = (Order) e.nextElement();
            result += each.getAmount();
        }
        return result;
    }
}
