import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import daemons.BusinessFlight;
import daemons.EconomyFlight;
import daemons.Flight;
import daemons.Passanger;


public class AirportTest {
    @DisplayName("Given there is an economy FLigth")
    @Nested
    class EconomyFlightTest {
        private Flight economyFlight;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
        }

        @Test
        public void testEconomyFlightRegularPassanger(){
            Passanger mike = new Passanger("Mike", false);

            assertEquals("1", economyFlight.getId());
            assertEquals(true, economyFlight.addPassenger(mike));
            assertEquals(1, economyFlight.getPassangersList().size());
            assertEquals("Mike", economyFlight.getPassangersList().get(0).getName());
            assertEquals(true, economyFlight.removePassenger(mike));
            assertEquals(0, economyFlight.getPassangersList().size());

        }

        @Test
        public void testEconomyFlightVipPassanger() {
            Passanger james = new Passanger("James", true);

            assertEquals("1", economyFlight.getId());
            assertEquals(true, economyFlight.addPassenger(james));
            assertEquals(1, economyFlight.getPassangersList().size());
            assertEquals("James", economyFlight.getPassangersList().get(0).getName());
            assertEquals(false, economyFlight.removePassenger(james));
            assertEquals(1, economyFlight.getPassangersList().size());
        }
        
        @DisplayName("Given there is a business flight")
        @Nested
        class BusinessFlightTest {
            private Flight businessFlight;

            @BeforeEach
            void setUp() {
                businessFlight = new BusinessFlight("2");
            }

            @Test
            public void testBusinessFlightRegularPassanger() {
                Passanger mike = new Passanger("Mike", false);

                assertEquals(false, businessFlight.addPassenger(mike));
                assertEquals(0, businessFlight.getPassangersList().size());
                assertEquals(false, businessFlight.removePassenger(mike));
                assertEquals(0, businessFlight.getPassangersList().size());
            }

            @Test
            public void testBusinessFlightVipPassanger() {
                Passanger james = new Passanger("James", true);

                assertEquals(true, businessFlight.addPassenger(james));
                assertEquals(1, businessFlight.getPassangersList().size());
                assertEquals(false, businessFlight.removePassenger(james));
                assertEquals(1, businessFlight.getPassangersList().size());
            }
        }
    }
}