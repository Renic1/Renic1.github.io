import java.util.Random;
import java.util.Scanner;

public class Demp {
    public static void main(String[] args) throws InterruptedException {
        t t = new t();
        Thread thread = new Thread(t);
        Thread thread1=new Thread(new t1(t));
        thread.start();
        thread1.start();
    }
}
class t implements Runnable {
    private boolean loop =true;
    @Override
    public void run() {
        while(loop) {
            Random random=new Random();
            System.out.println(random.nextInt(100));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop=loop;

    }
}
class t1 extends Thread{
    private t t2;

    public t getT2() {
        return t2;
    }

    public void setT2(t t2) {
        this.t2 = t2;
    }

    public t1(t t2) {
        this.t2 = t2;
    }

    @Override
    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            char c=scanner.next().toUpperCase().charAt(0);
            if(c=='Q') {
                t2.setLoop(false);
                break;
            }
        }

    }
}

