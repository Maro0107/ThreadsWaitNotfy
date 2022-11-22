public class Main {
    public static void main(String[] args)throws InterruptedException {

        House house = new House();

        Thread customer = new Thread(new Runnable() {
            @Override
            public void run() {
                house.waitForDelivery();
            }
        });
        customer.start();

        Thread.sleep(3000);

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                house.pizzaGuy();
            }
        });
        producer.start();

        customer.join();
    }
}
