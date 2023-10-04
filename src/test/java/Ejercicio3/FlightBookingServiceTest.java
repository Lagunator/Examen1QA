package Ejercicio3;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class FlightBookingServiceTest {
    @Test
    public void testBookFlightWithAvailableTickets(){
        try (MockedStatic<FlightServiceUtilities>utilities = Mockito.mockStatic(FlightServiceUtilities.class)) {
            utilities.when(()-> FlightServiceUtilities.areTicketsAvailable("La Pax", 2)).thenReturn(true);
            utilities.when(()-> FlightServiceUtilities.getWeekday(29, 5,2023)).thenReturn("Lunes");
        }
    }
}
