package com.arcade;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ScooterTest {

    private static final Scooter scooterMock = mock(Scooter.class);

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
    public void animalAndShepherd() {
        Animal monkey = mock(Animal.class);
        System.out.println(monkey.getShepherd());
        System.out.println(monkey.age);


        Animal parrot = mock(Animal.class, RETURNS_DEFAULTS);
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
}
