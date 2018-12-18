package doanhedieuhanh;

import java.awt.Color;
import java.util.concurrent.Semaphore;

public class GiaoDien extends javax.swing.JFrame {
    static Semaphore semProducer = new Semaphore(1);
    static Semaphore semConsumer = new Semaphore(1);
    int size = 5;

    private ProductQueue pq;

    public GiaoDien() {
        initComponents();
        pq = new ProductQueue(size, semProducer, semConsumer);
        pq.setBounds(100, 20, 100, this.size*30);
        add(pq);
        
        System.out.println("pq: " + pq.isDisplayable());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        producebtn_1 = new javax.swing.JButton();
        producebtn_2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Consume");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        producebtn_1.setText("Produce A");
        producebtn_1.setToolTipText("");
        producebtn_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                producebtn_1ActionPerformed(evt);
            }
        });

        producebtn_2.setText("Produce B");
        producebtn_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                producebtn_2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(producebtn_2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(producebtn_1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(producebtn_1)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(producebtn_2)
                .addContainerGap(268, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(302, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void producebtn_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_producebtn_2ActionPerformed
        System.out.println("Producer2");
        Producer producer2 = new Producer(pq);
        producer2.start();
    }//GEN-LAST:event_producebtn_2ActionPerformed

    private void producebtn_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_producebtn_1ActionPerformed
        System.out.println("Producer has produced:");
        Producer producer1 = new Producer(pq);
        producer1.start();
    }//GEN-LAST:event_producebtn_1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("Consumer has consumed:");
        Consumer consumer1 = new Consumer(pq);
        consumer1.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton producebtn_1;
    private javax.swing.JButton producebtn_2;
    // End of variables declaration//GEN-END:variables
}
