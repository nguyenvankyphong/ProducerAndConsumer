package doanhedieuhanh;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProductQueue extends JPanel {

    static Semaphore semProducer;
    static Semaphore semConsumer;

    private final int size;
//    private ArrayList<Integer> list = new ArrayList<>(size);
    private ArrayList<Product> list;

    public ProductQueue(int size, Semaphore semProducer, Semaphore semConsumer) {
        super(true);
        this.size = size;
        this.list = new ArrayList<>(size);
        this.semConsumer = semConsumer;
        this.semProducer = semProducer;
//        this.setSize(100, 300);
        this.setBackground(Color.red);
        
        
//        this.setBorder(border);
        this.setVisible(true);
    }

    public void putProductIntoQ() {
        try {
            semProducer.acquire();

            if (list.size() != size) {
                Random ran = new Random();
                int a = ran.nextInt(5);
                Product p = new Product(a + "");
                p.setLocation(0, list.size()*50);
                list.add(p);
                loadProduct();
//                JLabel b = new JLabel("sth");
//                b.setBackground(Color.GREEN);
//                b.setOpaque(true);
//                b.setForeground(Color.white);
//                b.setPreferredSize(new Dimension(100, 30));
//                b.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.black));
//                b.setSize(20, 100);
                
//                this.add(list);
                System.out.println("Produce: list = " + list.size());

                Thread.sleep(1000);
            } else {
                System.out.println("Producer is disable");
            }

            semProducer.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getProductFromQ() {
        try {
            semConsumer.acquire();

            if (list.size() != 0) {
                this.remove(list.get(0));
                list.remove(0);
                System.out.println("Consume: list = " + list.size());
                Thread.sleep(1000);
            } else {
                System.out.println("list is empty. Consumer is disable");
            }

            semConsumer.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void loadProduct() {
        for (Product p : this.list) {
            this.add(p);
        }
    }
}
