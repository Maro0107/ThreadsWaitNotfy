import java.util.LinkedList;

class House {
    public LinkedList<String> delivery = new LinkedList<>();

    public void waitForDelivery() {
        synchronized (delivery) {
            System.out.println("Waiting for delivery.");
            while(delivery.isEmpty()) {
                try {
                    delivery.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }

            System.out.println("Pizza received: " + delivery.poll());
        }
    }



    public void pizzaGuy() {
        synchronized (delivery) {
            System.out.println("Pizza delievery!");
            delivery.add("Special Pizza");
            delivery.notify();
        }
    }
}
