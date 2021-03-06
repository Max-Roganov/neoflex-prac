package ru.neoflex.roganov;

public class Fraction {
    public static void main(String[] args) {
        Fraction dfr = new Fraction(13.125);
        System.out.println(dfr);
        Fraction fr1 = new Fraction("-5/3");
        Fraction fr2 = new Fraction("2/3");
        System.out.println("Сложение: " + Fraction.sum(fr1, fr2));
        System.out.println("Вычитание: " + Fraction.difference(fr1, fr2));
        System.out.println("Умножение: " + Fraction.mult(fr1, fr2));
        System.out.println("Деление: " + Fraction.division(fr1, fr2));
    }

    private int whole;
    private int numerator;
    private int denominator;

    Fraction(int whole, int numerator, int denominator) {
        this.whole = whole;
        this.numerator = numerator;
        this.denominator = denominator;
    }

    Fraction(int numerator, int denominator) {
        this(0, numerator, denominator);
    }

    Fraction(int number) {
        this(0, number, 1);
    }

    Fraction(String fraction) {
        String[] parts = fraction.split("[ \\/]", 3);
        if (parts.length < 3) {
            numerator = Integer.parseInt(parts[0]);
            denominator = Integer.parseInt(parts[1]);
        }
        else {
            whole = Integer.parseInt(parts[0]);
            numerator = Integer.parseInt(parts[1]);
            denominator = Integer.parseInt(parts[2]);
        }
    }

    Fraction(double number) {
        int d = 1;
        while(number % 1 != 0) {
            number *= 10;
            d *= 10;
        }
        numerator = (int)number;
        denominator = d;
        simplify();
    }

    public static Fraction sum(Fraction a, Fraction b) {
        Fraction result = new Fraction(a.whole + b.whole, a.numerator * b.denominator + b.numerator * a.denominator, a.denominator * b.denominator);
        result.simplify();
        return result;
    }

    public static Fraction difference(Fraction a, Fraction b) {
        Fraction result = new Fraction(a.whole - b.whole, a.numerator * b.denominator - b.numerator * a.denominator, a.denominator * b.denominator);
        result.simplify();
        return result;
    }

    public static Fraction mult(Fraction a, Fraction b) {
        Fraction result = new Fraction((a.numerator + a.denominator * a.whole) * (b.numerator + b.whole * b.denominator), a.denominator * b.denominator);
        result.simplify();
        return result;
    }

    public static Fraction division(Fraction a, Fraction b) {
        Fraction b2 = new Fraction(b.denominator, b.numerator + b.whole * b.denominator);
        return Fraction.mult(a, b2);
    }

    private int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    public void simplify() {
        whole += numerator / denominator;
        if ((numerator < 0 && denominator < 0) || ((numerator < 0 || denominator < 0) && numerator / denominator != 0)) {
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        }
        numerator %= denominator;

        if (numerator != 0 && denominator != 0) {
            int gcdNumber = gcd(Math.abs(numerator), Math.abs(denominator));
            numerator /= gcdNumber;
            denominator /= gcdNumber;
        }
        else {
            numerator = 0;
            denominator = 0;
        }
    }

    @Override
    public String toString() {
        String result = "";
        if (whole != 0) result += whole;
        if (numerator != 0 || denominator != 0) {
            if (whole != 0) result += " ";
            result += numerator + "/" + denominator;
        }
        return result.isEmpty() ? "0" : result;
    }
}
