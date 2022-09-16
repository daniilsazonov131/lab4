//поток-читатель
public class ThreadReader implements Runnable{


        private Thread thd = null;
        private volatile long done = 0L;

        public ThreadReader(String name){
            thd   = new Thread(this, name);
            thd.start();
        }

        public void run(){
            while(done == 0L){
                try {
                    Thread.sleep(100L);
                } catch(InterruptedException e){}

                SData.lrw.readLock().lock();
                try {
                    System.out.println("Читатель - " + thd.getName() + " читает строку: " + SData.buffer);
                } finally {
                    SData.lrw.readLock().unlock();
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

