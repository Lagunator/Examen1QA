package Ejercicio2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FlightBookingServiceTest {
    @Test
    public void shouldBookFlightWhenTicketsAvailable() {
        FlightBookingService flightService = Mockito.spy(new FlightBookingService());

        Mockito.doReturn(true).when(flightService).areTicketsAvailable("La Paz", 2);
        Mockito.doReturn("Lunes").when(flightService).getWeekday(29, 5, 2023);

        String response = flightService.bookFlight("La Paz", 2, 29, 5, 2023);
        Assertions.assertEquals("el dia Lunes 29 Mayo 2023 existen 2 pasajes para La Paz", response);
    }

    @Test
    public void shouldNotBookFlightWhenNoTicketsAvailable() {
        FlightBookingService flightService = Mockito.spy(new FlightBookingService());

        Mockito.doReturn(false).when(flightService).areTicketsAvailable("La Paz", 3);
        String response = flightService.bookFlight("La Paz", 3, 15, 6, 2023);
        Assertions.assertEquals("no existen suficientes pasajes para La Paz", response);
    }

    @Test
    public void shouldBookFlightForAnotherDestination() {
        FlightBookingService flightService = Mockito.spy(new FlightBookingService());

        Mockito.doReturn(true).when(flightService).areTicketsAvailable("Santa Cruz", 2);
        Mockito.doReturn("Viernes").when(flightService).getWeekday(1, 1, 2023);

        String response = flightService.bookFlight("Santa Cruz", 2, 1, 1, 2023);
        Assertions.assertEquals("el dia Viernes 1 Enero 2023 existen 2 pasajes para Santa Cruz", response);
    }

    @Test
    public void shouldConvertMonthCorrectly() {
        FlightBookingService flightService = Mockito.spy(new FlightBookingService());

        Mockito.doReturn(true).when(flightService).areTicketsAvailable("Oruro", 2);
        Mockito.doReturn("Miercoles").when(flightService).getWeekday(20, 4, 2023);

        String response = flightService.bookFlight("Oruro", 2, 20, 4, 2023);
        Assertions.assertEquals("el dia Miercoles 20 Abril 2023 existen 2 pasajes para Oruro", response);
    }
}
