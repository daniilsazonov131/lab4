import java.util.Random;

//поток писатель
public class ThreadWriter implements Runnable{

        private Thread   thd = null;
        private volatile long done = 0L;

        public ThreadWriter(String name){
            thd   = new Thread(this, name);
            thd.start();
        }

        public void run(){
            Random rnd = new Random();
            long delay = 0L;

            while(done == 0L){
                try {
                    delay = 1000 + rnd.nextInt(2000);
                    Thread.sleep(delay);
                } catch(InterruptedException e){}

                SData.lrw.writeLock().lock();
                try {
                    System.out.println("\tПОДОЖДИТЕ, ПИСАТЕЛЬ - " + thd.getName() + ", ПИШЕТ!");
                    //пишем в общий буфер
                    SData.buffer = "ПРИВЕТ ОТ ПИСАТЕЛЯ " + thd.getName() + " !";
                    //для показательного примера сделаем задержку
                    Thread.sleep(delay);
                } catch(InterruptedException e){
                    e.printStackTrace();
                } finally {
                    System.out.println("\tИЗМЕНЕНИЕ ЗАВЕРШЕНО");
                    SData.lrw.writeLock().unlock();
                }
            }
        }
        public void quit(){
        done = 1L;
        try {
            thd.join();
        } catch(InterruptedException e){}
    }
}
