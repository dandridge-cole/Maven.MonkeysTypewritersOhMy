package io.zipcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonkeyTypewriter {
    Copier chimpy1;
    Copier chimpy2;
    String introduction;

    public MonkeyTypewriter() {
        this.introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";
        this.chimpy1 = new UnsafeCopier(this.introduction);
        this.chimpy2 = new SafeCopier(this.introduction);
    }

    public static void main(String[] args) {
        MonkeyTypewriter mt=new MonkeyTypewriter();
        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.
        mt.runExperiment();
        System.out.println("Bureaucrats:\n\n"+mt.chimpy1.copied);
        System.out.println("\n\nAccountable and Motivated Employees:\n\n"+mt.chimpy2.copied);
        // Print out the copied versions here.
    }

    void runExperiment() {
        List<Thread> uncoordinatedChimps = new ArrayList<>();
        List<Thread> coordinatedChimps = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            uncoordinatedChimps.add(new Thread(this.chimpy1));
            coordinatedChimps.add(new Thread(this.chimpy2));
        }
        for(Thread chimp:uncoordinatedChimps) chimp.start();
        for(Thread chimp:coordinatedChimps) chimp.start();
//        Random chimpPicker=new Random();
//        while(chimpy1.stringIterator.hasNext()) {
//            Integer i=chimpPicker.nextInt(5)+1;
//            uncoordinatedChimps.get(i % 5).run();
//            coordinatedChimps.get(i % 5).run();
//        }

        //    uncoordinatedChimps.forEach(Thread::run);


        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }
    }
}