package chapter6;

public class MethodInlining {
    int _numberOfLateDeliveries;

    int getRating() {
//        return (moreThanFiveLateDiliveries()) ? 2 : 1;
        // メソッドのインライン化
        return (_numberOfLateDeliveries > 5) ? 2 : 1;
    }

    boolean moreThanFiveLateDiliveries() {
        return _numberOfLateDeliveries > 5;
    }
}
