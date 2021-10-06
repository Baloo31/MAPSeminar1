package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        // I
        MatheAufgabe obj = new MatheAufgabe();

        // I.1.
        System.out.println(obj.add(3, 4));

        // I.2.
        System.out.println(obj.subtract(3, 4));

        // I.3.
        System.out.println(obj.multiply(3, 4));

        // I.4.
        System.out.println(obj.verifyPerfect(28));

        // II
        WetterStation obj2 = new WetterStation(new double[]{12, 14, 9, 12, 15, 16, 15, 15, 11, 8, 13, 13, 15, 12});

        // II.1
        System.out.println(obj2.avg());

        // II.2
        double[] diff = obj2.diff();
        System.out.println(diff[0]);
        System.out.println(diff[1]);

        // II.3
        double[] minMax = obj2.max_min();
        System.out.println(minMax[0]);
        System.out.println(minMax[1]);

        // II.4
        obj2.show();

        // III
        Fibonacci obj3 = new Fibonacci();

        // III.1
        System.out.println(obj3.fibonacci(10));

        // III.2
        System.out.println(obj3.fib_zahl(21));

        // III.3
        System.out.println(obj3.show_fibonacci(10));
    }
}



// Lege eine neue Klasse "MatheAufgabe" für einige (mathematische)-Methoden an.
class MatheAufgabe {

    // Schreibe eine Methode public double add(double x, double y) ,
    // die die Summe der beiden
    // übergebenen Zahlen x und y zurückgibt.
    public double add(double x, double y){
        return x + y;
    }

    // Schreibe eine Methode sub,
    // welche die Differenz zweier
    // übergebener Werte zurückgibt.
    public double subtract(double x, double y){
        return x - y;
    }

    // Überprüfe mit einer Methode,
    // ob eine Zahl perfekt ist.
    // Perfekte Zahl - Def: Die Summe der eigene Teiler dieser Zahl
    // ist gleich mit der Zahl selbst
    public boolean verifyPerfect(double x){
        int sum=0;
        for (int idx=0; idx<=x / 2; idx++) {
            if (x%idx==0) {
                sum += idx;
            }
        }
        return  sum==x;
    }

    // Schreibe nun eine mul-Methode für double.
    // Benutze dazu nicht den operator *,
    // sondern deine gerade
    // geschriebene add-Methode.
    public double multiply(double x, double y){
        double mul=0;
        for (int idx=0; idx<=x-1; idx++) {
            mul = add(mul, y);
        }
        return mul;
    }
}



// Eine Wetterstation hat für 14 Tage folgende Temperaturwerte aufgenommen.
class WetterStation{

    // Atribut
    private static double[] temp;

    // Constructor
    public WetterStation(double[] tem){
        temp=tem;
    }

    // Schreibe eine Methode, welche die
    // Durchschnittstemperatur für die zwei Wochen bestimmt.
    public double avg(){
        double sum=0;
        for(int i=0;i<=13;i++)
            sum=sum+temp[i];

        return sum/14;
    }

    // Schreibe eine Methode,
    // welche die maximale und
    // minimale Temperatur ausgibt.
    public double[] max_min(){
        double min=temp[0], max=temp[0];
        for(int i=1;i<14;i++){
            if(temp[i]<min)
                min=temp[i];
            if(temp[i]>max)
                max=temp[i];
        }
        return new double[] {min, max};
    }

    // Schreibe eine Methode, welche die beiden aufeinanderfolgenden Tage
    // angeben kann, an denen es den
    // größten Temperaturumschwung gab.
    public double[] diff() {
        double max_diff = 0, day1 = 0, day2 = 0;
        for (int i = 0; i < 13; i++) {
            double diff = Math.abs(temp[i] - temp[i + 1]);
            if (diff > max_diff) {
                max_diff = diff;
                day1 = temp[i];
                day2 = temp[i + 1];
            }
        }
        return new double[]{day1, day2};
    }

    // Schreibe eine Methode, welche die
    // Tabelle schön tabellarisch auf der Konsole ausgibt.
    public void show(){
        System.out.print("Tag:\t");
        for(int x=1; x<=14; x++){
            System.out.print(x);
            System.out.print("|");
        }

        System.out.print("\nTemperatur: ");
        for(int x=0; x<14; x++){
            System.out.print(temp[x]);
            System.out.print("|");
        }
        System.out.print("\n");
    }
}



// Fibonacci-Zahlen.
class Fibonacci{

    // Implementiere eine Methode mit dem Namen fibonacci.
    // Diese Methode soll genau eine Variable vom Typ int
    //und dem Namen n als Parameter bekommen.
    // Die Methode soll die n-te Zahl der Fibonacci-Folge zurückgeben.
    public int fibonacci(int n){
        int nr1=0;
        int nr2=1;
        int sum=0;
        for (int i=3;i<=n;i++) {
            sum = nr1 + nr2;
            nr1=nr2;
            nr2=sum;
        }
        return sum;
    }

    // Schreibe eine Methode, welche prüft ob eine Zahl
    // innerhalb der Fibonacci Reihe enthalten ist.
    public boolean fib_zahl(int x){
        int nr1=0;
        int nr2=1;
        int sum=0;
        while(sum<x) {
            sum = nr1 + nr2;
            nr1 = nr2;
            nr2 = sum;
        }
        return sum == x;
    }

    // Schreibe eine Methode, welche die ersten n
    // Folgenglieder der Fibonacci-Folge ausgibt.
    public List<Integer> show_fibonacci(int n){
        List<Integer> result = new ArrayList<>();
        if (n == 0) return result;
        if (n == 1) {
            result.add(0);
            return result;
        }

        int nr1=0;
        int nr2=1;
        int sum;
        result.add(0);
        result.add(1);

        for (int i=3;i<=n;i++) {
            sum = nr1 + nr2;
            result.add(sum);
            nr1=nr2;
            nr2=sum;
        }
        return result;
    }
}