package org.example;

public class Cons extends Thread {
    private Cola cola;
    private int n;
    public Cons (Cola c, int n){
        cola = c;
        this.n =n;
    }
    public void run() {
        int valor = 0;
        for (int i = 0; i<5; i++) {
            valor = cola.get(); //recoge el numero
            System.out.println(i+"=>Consumidor : " + n + ", consume: " + valor);
        }
    }
}
