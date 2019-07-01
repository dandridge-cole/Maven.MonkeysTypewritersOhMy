package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonkeyTypewriterTest {

    @Test
    public void mainBureaucrats() {
        MonkeyTypewriter mt = new MonkeyTypewriter();
        mt.runExperiment();
        String unexpected=mt.introduction;
        String actual=mt.chimpy1.copied;
        Assert.assertNotEquals(unexpected,actual);
    }


    @Test
    public void mainAccountable() {
        MonkeyTypewriter mt = new MonkeyTypewriter();
        mt.runExperiment();
        String expected=mt.introduction;
        String actual=mt.chimpy2.copied;
        Assert.assertNotEquals(expected,actual);
    }
}