package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int f(int x){
        assert x >= 0 : "Tylko wieksze niz 0";
        return x*x;
    }


    public static void main(String[] args) {
    Vector vector = new VectorImpl();
//	System.out.println(f(10));
//	System.out.println(f(-10));
	List<Double> VektorSum = new ArrayList<Double>();
	List<Double> Vektor1 = new ArrayList<Double>();
    List<Double> Vektor2 = new ArrayList<Double>();
    Vektor1.add(2.2);
    Vektor1.add(7.2);
    Vektor2.add(2.5);
    VektorSum.add(5.4);
    VektorSum.add(9.7);
        try {
            vector.add(Vektor1, Vektor2);
        } catch (MyOwnException e) {
            e.printStackTrace();
        }
    }
}
