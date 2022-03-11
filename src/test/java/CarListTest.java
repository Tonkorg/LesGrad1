import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarListTest {

    private CarList carList;

    @Before
    public void setUp() throws Exception {
        carList = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));

        }
    }

    @Test
    public void whenAdd100elementThenSizeMustBe100() {
        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementDeleteTheSizeMustBeDecrease() {
        assertTrue(carList.removeAt(5));
        assertEquals(99, carList.size());

    }
    @Test
    public void  whenElementDeleteTheSizeMustBeDecreaseWithoutIndex()
    {
        Car car = new Car("Tayota", 15);
        carList.add(car);

        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());

    }

    @Test
    public void whenNotExistedElementDonNotDecreaseSizeAndReturnFalse()
    {
        Car car = new Car("Ford", 14);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }
    @Test
    public void WhenListClearThenSizeMustBeZero()
    {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test (expected =IndexOutOfBoundsException.class )
    public void whenIndexOutOfBoundsThrowException()
    {

        carList.get(100);

    }

    @Test
    public void getReturnRightValue()
    {
        Car car = carList.get(0);
        assertEquals("Brand0" , car.getMark());
    }
    @Test
    public void insertIntoMiddle()
    {
        Car car = new Car("BMW", 28);
        carList.add(car, 50);
        Car carfromList  = carList.get(50);
        assertEquals("BMW", carfromList.getMark());

    }
    @Test
    public void insertIntoFirstPosition()
    {
        Car car = new Car("BMW", 28);
        carList.add(car, 0);
        Car carfromList  = carList.get(0);
        assertEquals("BMW", carfromList.getMark());

    }
    @Test
    public void insertIntoLastPosition()
    {
        Car car = new Car("BMW", 28);
        carList.add(car, 100);
        Car carfromList  = carList.get(100);
        assertEquals("BMW", carfromList.getMark());

    }
}