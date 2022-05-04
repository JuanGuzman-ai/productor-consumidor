/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productorconsumidor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanguzman
 */
public class Productor extends Thread {

    private final Buffer buffer;
    private final String letras = "abcdefghijklmnñopqrstuwxyz";

    public Productor(Buffer b) {
        this.buffer = b;
    }

    @Override
    public void run() {
        while (true) {
            try {
                char c = letras.charAt((int) (Math.random() * letras.length()));
                buffer.producir(c);
                System.out.println("Depositado el char " + c + " del buffer");
                
                sleep((int) Math.random() * 4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
