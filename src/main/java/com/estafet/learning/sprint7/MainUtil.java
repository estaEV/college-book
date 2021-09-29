package com.estafet.learning.sprint7;

import java.util.Random;

public class MainUtil {
    public static String performExpensiveHamsterTraining() {
        System.out.println("Hamster training initiated");
        System.out.println("Expensive magic is happening in the background.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ;;
        }
        System.out.println("Hamster training completed");
        String port = MainUtil.randomPort();
        return port;
    }

    public static String randomPort() {
        Random rng = new Random();
        Integer basePortOffset = 30000;
        Integer port = basePortOffset + rng.nextInt(2000);

        return port.toString();
    }
}

}
