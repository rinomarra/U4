package it.epicode.be.utils;

import java.util.Random;
import java.util.function.Supplier;

public class Utils {
    private static final long ORIGIN = 10000;  // Definisci il valore di origine
    private static final long BOUND = 100000;  // Definisci il limite

    // Supplier per generare ID ordine casuali
    public static final Supplier<Long> randomOrderIdSupplier = () -> {
        Random random = new Random();
        return random.nextLong(ORIGIN, BOUND);
    };

    public static final Supplier<Long> randomOrderIdSupplier(long origin, long bound) {
        return () -> {
            Random random = new Random();
            return random.nextLong(origin, bound);
        };
    }

    // Metodo alternativo per ottenere un ID ordine casuale
    public static long getRandomOrderId() {
        return randomOrderIdSupplier.get();
    }
}
