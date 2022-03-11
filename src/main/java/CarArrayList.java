import java.util.Arrays;

public class CarArrayList implements CarList{

    Car[] arrays = new Car[10];
    private int size = 0;

    @Override
    public Car get(int index) {
        checkIndex(index);
        return arrays[index];
    }

    @Override
    public void add(Car car) {

        increaseArray();
        arrays[size] = car;
        size++;
    }

    @Override
    public void add(Car car, int index) {
        increaseArray();
        if (size - index >= 0) {
            System.arraycopy(arrays, index, arrays, index + 1, size - index);
        }
        arrays[index] = car;
        size++;
    }

    @Override
    public boolean remove(Car car) {

        for ( int i =0; i< size ; i++)
        {
            if(arrays[i].equals(car))
            {
                return  removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        for ( int i =index; i< size - 1; i++)
        {
            arrays[i] = arrays[i+1];
        }
        size --;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

        arrays = new Car[10];
        size = 0;
    }

    private void checkIndex(int index)
    {
        if(index< 0 || index >=size)
        {
            throw new IndexOutOfBoundsException();
        }
    }
    private void increaseArray()
    {
        if (size >= arrays.length)
        {
            arrays = Arrays.copyOf(arrays, arrays.length* 2);
        }
    }
}
