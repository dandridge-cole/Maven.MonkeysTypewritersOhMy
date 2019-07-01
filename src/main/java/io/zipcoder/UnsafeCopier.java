package io.zipcoder;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {
    ReentrantLock lock = new ReentrantLock();
    private String holder=new String();
    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        while (this.stringIterator.hasNext()){
          if(this.stringIterator.hasNext())  holder = this.stringIterator.next() + " ";
    //        if(!lock.isLocked()) lock.lock();
            try{Thread.sleep((int)(Math.random()*2));}
            catch(InterruptedException e) {System.out.println("MAIN INTERRUPTED");}
            this.copied += holder;
           //if(Math.random()>0.5&&lock.isLocked()) lock.unlock();
//            while(lock.isLocked()){
//                try{Thread.sleep((int)(Math.random()*10));}
//                catch(InterruptedException e) {System.out.println("MAIN INTERRUPTED");}
//                if(Math.random()>0.5)lock.unlock();
//            }
        }
    }
}
