package addition;

public class AdditionShop {

    int number1=0;
    int number2=0;

    public AdditionShop(int a, int b) {
        this.number1=a;
        this.number2=b;
    }
    public int getNumber1() {
        return this.number1;
    }

    public int getNumber2() {
        return this.number2;
    }

    public int getAddition() {
        return this.number1+this.number2;
    }
}