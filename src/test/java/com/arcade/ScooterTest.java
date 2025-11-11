package com.arcade;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ScooterTest {

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private static Scooter scooterMock;


    @Test
    @Disabled("This test is passed")
    void do_notReturn_scooter() {
        when(scooterMock.say_Scooter()).thenReturn("Sheepish");
        assertEquals("Sheepish", scooterMock.say_Scooter());
    }

    @Test
    @Tag("Throw_dude")
    @Disabled("Passed")
    void throw_something() {
        when(scooterMock.say_Scooter()).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, scooterMock::say_Scooter);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    @Disabled("PASSED")
    public void trueIfAllEven(int number) {
        assertEquals(0, number % 2);
    }

    @Test
    @Disabled
    public void animalAndShepherd() {
        Animal monkey = mock(Animal.class);
        System.out.println(monkey.getShepherd());
        System.out.println(monkey.age);


        Animal parrot = mock(Animal.class, withSettings().defaultAnswer(RETURNS_SMART_NULLS));
        System.out.println("==================================================");
        System.out.println(parrot.age); // 0
        System.out.println(parrot.getShepherd()); // null

        System.out.println("==================================================");
        Shepherd shepherd = new Shepherd("James Potter"); // GIVING THE MOCK A RETURN VALUE
        Animal lion = mock(Animal.class, RETURNS_SMART_NULLS);
        when(lion.getShepherd()).thenReturn(shepherd);
        System.out.println(lion.age);
        System.out.println(lion.getShepherd().toString());
        System.out.println("==================================================");
        Animal Zibra = mock(Animal.class, RETURNS_MOCKS);
        when(Zibra.getShepherd()).thenReturn(mock(Shepherd.class));
        System.out.println(Zibra.age);
        System.out.println(Zibra.getShepherd());

    }


    @ParameterizedTest
    @CsvSource({
            "2,2 , 4",
            "2,3 , 8",
            "2,4 , 16",
            "3,4 , 81",
            "7,2 , 49"
    })
    @Disabled
    public void something(int a, int b, double expected) {
        RealOne realOne = new RealOne();
        double value = realOne.calc(a, b);
        assertEquals(expected, value, String.format("Expected %f but got %f", value, expected));
    }


    @Test
    @DisplayName("The sum of -10 And 40 will always be 30")
    @Disabled
    public void sum_negativeAndPositive_returnsCorrectResult() {
        RealOne realOne = new RealOne();
        int actualResult = realOne.sum(-10, 40);
        assertThat(actualResult)
                .isEqualTo(30)
                .isPositive()
                .isNotEqualTo(-50)
                .isGreaterThan(25)
                .isBetween(29, 31);

    }


    @Test
    @Disabled
    public void returnTheReverseSpy() {
        RealOne realOne = spy(new RealOne());
        // Prevent calling the real method
        doReturn("avaJ").when(realOne).reverser("Java");

        String vl = realOne.reverser("Java");
        assertThat(vl).isEqualTo("avaJ");
    }


    @Test
    public void throwsWhenIsCalled() {
        assertThrows(ArithmeticException.class, () -> new RealOne().theMethodWhoThrowsException(), "Zambrano");
    }


}
