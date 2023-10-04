package Ejercicio3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class FlightBookingServiceTest {

    @Test
    public void testBookFlightWithAvailableTickets() {
        try (MockedStatic<FlightServiceUtilities> utilities = Mockito.mockStatic(FlightServiceUtilities.class)) {
            utilities.when(() -> FlightServiceUtilities.areTicketsAvailable("La Paz", 2)).thenReturn(true);
            utilities.when(() -> FlightServiceUtilities.getWeekday(29, 5, 2023)).thenReturn("Lunes");

            FlightBookingService flightService = new FlightBookingService();
            String response = flightService.bookFlight("La Paz", 2, 29, 5, 2023);

            Assertions.assertEquals("el dia Lunes 29 Mayo 2023 existen 2 pasajes para La Paz", response);

            utilities.verify(() -> FlightServiceUtilities.areTicketsAvailable("La Paz", 2));
            utilities.verify(() -> FlightServiceUtilities.getWeekday(29, 5, 2023));
        }
    }

    @Test
    public void testBookFlightWithoutAvailableTickets() {
        try (MockedStatic<FlightServiceUtilities> utilities = Mockito.mockStatic(FlightServiceUtilities.class)) {
            utilities.when(() -> FlightServiceUtilities.areTicketsAvailable("La Paz", 3)).thenReturn(false);

            FlightBookingService flightService = new FlightBookingService();
            String response = flightService.bookFlight("La Paz", 3, 15, 6, 2023);

            Assertions.assertEquals("no existen suficientes pasajes para La Paz", response);

            utilities.verify(() -> FlightServiceUtilities.areTicketsAvailable("La Paz", 3));
        }
    }

    @Test
    public void testBookFlightForAnotherDestination() {
        try (MockedStatic<FlightServiceUtilities> utilities = Mockito.mockStatic(FlightServiceUtilities.class)) {
            utilities.when(() -> FlightServiceUtilities.areTicketsAvailable("Santa Cruz", 2)).thenReturn(true);
            utilities.when(() -> FlightServiceUtilities.getWeekday(1, 1, 2023)).thenReturn("Domingo");

            FlightBookingService flightService = new FlightBookingService();
            String response = flightService.bookFlight("Santa Cruz", 2, 1, 1, 2023);

            Assertions.assertEquals("el dia Domingo 1 Enero 2023 existen 2 pasajes para Santa Cruz", response);
        }
    }
    @Test
    public void shouldNotBookFlightWhenNoTicketsAvailable() {
        try (MockedStatic<FlightServiceUtilities> utilities = Mockito.mockStatic(FlightServiceUtilities.class)) {
            utilities.when(() -> FlightServiceUtilities.areTicketsAvailable("Cochabamba", 4)).thenReturn(false);

            FlightBookingService flightService = new FlightBookingService();
            String response = flightService.bookFlight("Cochabamba", 4, 10, 8, 2023);

            Assertions.assertEquals("no existen suficientes pasajes para Cochabamba", response);
        }
    }

    @Test
    public void shouldHandleFridayWeekdayCorrectly() {
        try (MockedStatic<FlightServiceUtilities> utilities = Mockito.mockStatic(FlightServiceUtilities.class)) {
            utilities.when(() -> FlightServiceUtilities.areTicketsAvailable("Oruro", 2)).thenReturn(true);
            utilities.when(() -> FlightServiceUtilities.getWeekday(5, 11, 2023)).thenReturn("Viernes");

            FlightBookingService flightService = new FlightBookingService();
            String response = flightService.bookFlight("Oruro", 2, 5, 11, 2023);

            Assertions.assertEquals("el dia Viernes 5 Noviembre 2023 existen 2 pasajes para Oruro", response);
        }
    }

    @Test
    public void shouldHandleSundayWeekdayAndDecemberMonthCorrectly() {
        try (MockedStatic<FlightServiceUtilities> utilities = Mockito.mockStatic(FlightServiceUtilities.class)) {
            utilities.when(() -> FlightServiceUtilities.areTicketsAvailable("Sucre", 3)).thenReturn(true);
            utilities.when(() -> FlightServiceUtilities.getWeekday(25, 12, 2023)).thenReturn("Domingo");

            FlightBookingService flightService = new FlightBookingService();
            String response = flightService.bookFlight("Sucre", 3, 25, 12, 2023);

            Assertions.assertEquals("el dia Domingo 25 Diciembre 2023 existen 3 pasajes para Sucre", response);
        }
    }

    @Test
    public void shouldNotAllowNegativeTicketCount() {
        try (MockedStatic<FlightServiceUtilities> utilities = Mockito.mockStatic(FlightServiceUtilities.class)) {
            FlightBookingService flightService = new FlightBookingService();
            String response = flightService.bookFlight("Santa Cruz", -1, 2, 3, 2023);

            Assertions.assertEquals("no existen suficientes pasajes para Santa Cruz", response);
        }
    }
}
