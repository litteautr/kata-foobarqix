package fr.rli.foobarqix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FooBarQixConverterTest {
    
    private static FooBarQixConverter fooBarQixConverter;

    @BeforeAll
    static void setUp() {
        fooBarQixConverter = new FooBarQixConverter();
    }

    @Test
    public void should_return_input_number_as_string() {
        assertEquals("1", fooBarQixConverter.convert(1));
    }


    @Test
    public void should_return_foo_when_divisible_by_3() {
        assertEquals("Foo", fooBarQixConverter.convert(9));
    }

    @Test
    public void should_return_bar_when_divisible_by_5() {
        assertEquals("Bar", fooBarQixConverter.convert(10));
    }

    @Test
    public void should_return_foo_when_contains_3() {
        assertEquals("Foo", fooBarQixConverter.convert(13));
    }

    @Test
    public void should_return_bar_when_contains_5() {
        assertEquals("Bar", fooBarQixConverter.convert(52));
    }

    @Test
    public void should_return_qix_when_contains_7() {
        assertEquals("Qix", fooBarQixConverter.convert(17));
    }

    private static Stream<Arguments> provide_numbers_for_divisor_preference() {
        return Stream.of(
                Arguments.of("FooBar", 51),
                Arguments.of("BarFooBar", 35),
                Arguments.of("FooBarQixBar", 75)
        );
    }

    @ParameterizedTest
    @MethodSource("provide_numbers_for_divisor_preference")
    public void should_give_preference_to_divisor(String expected, int input) {
        assertEquals(expected, fooBarQixConverter.convert(input));
    }


    private static Stream<Arguments> provide_numbers_for_preserve_order_analyzing_content() {
        return Stream.of(
                Arguments.of("BarFoo", 53),
                Arguments.of("QixFoo", 73),
                Arguments.of("FooQix", 37)
        );
    }

    @ParameterizedTest
    @MethodSource("provide_numbers_for_preserve_order_analyzing_content")
    public void should_preserve_order_analyzing_content(String expected, int input) {
        assertEquals(expected, fooBarQixConverter.convert(input));
    }


}
