package Ejercicio2;

public class FlightBookingService {
    public boolean areTicketsAvailable(String destination, int ticketCount) {
        return true;
    }

    public String getWeekday(int day, int month, int year) {
        return "Monday";
    }

    public String bookFlight(String destination, int ticketCount, int day, int month, int year) {
        if (areTicketsAvailable(destination, ticketCount)) {
            String weekday = getWeekday(day, month, year);
            String monthName = monthToName(month);
            return String.format("el dia %s %d %s %d existen %d pasajes para %s", weekday, day, monthName, year, ticketCount, destination);
        } else {
            return String.format("no existen suficientes pasajes para %s", destination);
        }
    }

    private String monthToName(int monthNumber) {
        String[] monthNames = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        return monthNames[monthNumber - 1];
    }
}
