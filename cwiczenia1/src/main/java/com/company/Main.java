package com.company;

public class Main {
    public static int f(int x){
        assert x >= 0 : "Tylko wieksze niz 0";
        return x*x;
    }
    public static void main(String[] args) {
	System.out.println(f(10));
	System.out.println(f(-10));
    }
}
