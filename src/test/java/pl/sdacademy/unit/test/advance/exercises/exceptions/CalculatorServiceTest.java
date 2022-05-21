package pl.sdacademy.unit.test.advance.exercises.exceptions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    /*
     null, 123
     132, null
     null, null
     */

    @ParameterizedTest
    @MethodSource("provideData")
    void shouldThrowExceptionWhenAnyOfArgumentsIsNull(String firstDigit, String secondDigit) {
        //when & then
        //jUnit
        //assertThrows(IllegalArgumentException.class, () -> CalculatorService.add(firstDigit, secondDigit));
        //assertJ
        assertThatThrownBy(() -> CalculatorService.add(firstDigit, secondDigit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Arguments 'a' and 'b' are required.");
    }

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(null, "123"),
                Arguments.of("123", null),
                Arguments.of(null, null)
        );
    }
}