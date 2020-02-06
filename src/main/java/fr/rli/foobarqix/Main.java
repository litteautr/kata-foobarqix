package fr.rli.foobarqix;

import java.util.stream.IntStream;

public class Main {

    /**
     * Convert and print conversion result for range of numbers, from 1 to 100.
     *
     * @param args no arg needed here
     * @see README.md for conversion rules.
     */
    public static void main(String[] args) {
        FooBarQixConverter fbqConverter = new FooBarQixConverter();

        IntStream.range(1, 500).forEach(
                input -> System.out.println(fbqConverter.convert(input))
        );
    }
}