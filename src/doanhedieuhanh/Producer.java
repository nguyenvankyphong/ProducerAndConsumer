package doanhedieuhanh;

public class Producer extends Thread{
     
    ProductQueue q;
     
    public Producer(ProductQueue q){
        this.q=q;
//        this.start();
    }
    public void run(){
            q.putProductIntoQ();
            q.revalidate();
    }
 
}

interface ProducerInterface {
    public void didProduce(boolean isProduced, Product product);
    public void isAddedToStorage(Producer producer);
}
