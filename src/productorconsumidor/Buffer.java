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
public class Buffer {
    private char[] buffer;
    private int siguiente;
    private boolean vacio;
    private boolean lleno;

    public Buffer(int tamaño) {
        this.buffer = new char[tamaño];
        this.siguiente = 0;
        this.vacio = true;
        this.lleno = false;
    }
    public synchronized char consumir(){
        while(this.vacio) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        siguiente --;
        this.lleno = false;
        
        if(siguiente == 0){
            this.vacio = true;
            System.out.println("Se dejo de consumir porque no hay productor");
        }
        
        
        notifyAll();
        return this.buffer[this.siguiente];
    }
    
    public synchronized char producir(char c){
        while(this.lleno){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        buffer[siguiente] = c;
        siguiente ++;
        this.vacio = false;
        
        if (siguiente == this.buffer.length) {
            this.lleno = true;
            System.out.println("Se dejo de producir porque no hay consumidor");
        }
        
        notifyAll();
        return 0;
    }
}
