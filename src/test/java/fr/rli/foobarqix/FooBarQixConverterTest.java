package fr.rli.foobarqix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FooBarQixConverterTest {

    private static FooBarQixConverter fbqConverter;

    @BeforeAll
    static void setUp() {
        fbqConverter = new FooBarQixConverter();
    }

    private static Stream<Arguments> provide_number_for_foobarqix_conversion() {
        return Stream.of(
                Arguments.of(1, "1"), // No specific rule for conversion
                Arguments.of(9, "Foo"), // Divisible by 3
                Arguments.of(10, "Bar"), // Divisible by 5
                Arguments.of(60, "FooBar"), // Divisible by 3 and 5
                Arguments.of(13, "Foo"), // contain 3
                Arguments.of(25, "BarBar"), // contain 5 and Divisible by 5
                Arguments.of(17, "Qix") // contain 7
        );
    }

    @ParameterizedTest
    @MethodSource("provide_number_for_foobarqix_conversion")
    public void should_apply_foobarqix_conversion_for_input_number(int input, String expected) {
        Assertions.assertEquals(expected, fbqConverter.convert(input));
    }
}
