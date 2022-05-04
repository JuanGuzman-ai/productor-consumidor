/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package productorconsumidor;

/**
 *
 * @author juanguzman
 */
public class ProductorConsumidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Buffer b = new Buffer(10);

        Productor p = new Productor(b);
        Consumidor c = new Consumidor(b);

//        Consumidor c1 = new Consumidor(b);
//        Consumidor c2 = new Consumidor(b);

        p.start();
        c.start();
        
        //c1.start();
    }

}
