import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusTest {


    private Bus bus;
    private Person person;
    private BusStop busStop;

    @Before
    public void before(){
        bus = new Bus("Glasgow", 3);
        person = new Person();
        busStop = new BusStop("Argyle St.");
        busStop.addToQueue(person);
    }

    @Test
    public void canReturnPassengers(){
        bus.addPassenger(person);
        bus.addPassenger(person);
        assertEquals(2, bus.passengerCount());
    }

    @Test
    public void canAddPassengerBelowCapacity(){
        bus.addPassenger(person);
        assertEquals(1, bus.passengerCount());
    }

    @Test
    public void cannotAddPassengerPastCapacity(){
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        assertEquals(3, bus.passengerCount());
    }

    @Test
    public void canRemovePassenger(){
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.removePassenger();
        assertEquals(1, bus.passengerCount());
    }

    @Test
    public void canPickUp(){
        bus.pickUp(busStop);
        assertEquals(1, bus.passengerCount());
    }
}
