package fr.rli.foobarqix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FooBarQixConverterTest {

    private FooBarQixConverter fooBarQixConverter = new FooBarQixConverter();;

    private static Stream<Arguments> provide_numbers_for_foobarqix_conversion() {
        return Stream.of(
                Arguments.of(1, "1"), // No specific rule for conversion
                Arguments.of(9, "Foo"), // Divisible by 3
                Arguments.of(10, "Bar"), // Divisible by 5
                Arguments.of(60, "FooBar"), // Divisible by 3 and 5
                Arguments.of(13, "Foo"), // contains 3
                Arguments.of(25, "BarBar"), // contains 5 and Divisible by 5
                Arguments.of(17, "Qix"), // contains 7
                Arguments.of(33, "FooFooFoo"), // Divisible by 3 and contains 3
                Arguments.of(27, "FooQix"), // Divisible by 3 and contains 7
                Arguments.of(35, "BarFooBar"), // Divisible by 5 and contains 3 and 5
                Arguments.of(75, "FooBarQixBar") // Divisible by 5 and 3 and contains 7 and 5
        );
    }

    @ParameterizedTest
    @MethodSource("provide_numbers_for_foobarqix_conversion")
    public void should_apply_foobarqix_conversion_for_input_number(int inputNumber, String expected) {
        Assertions.assertEquals(expected, fooBarQixConverter.convert(inputNumber));
    }
}
