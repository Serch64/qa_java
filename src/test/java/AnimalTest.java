import com.example.Animal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AnimalTest {
    private static final String ASSERT_DESCRIPTION = "Метод возвращает отличный от ожидаемого результат";
    private static final String GET_FAMILY_ER_TEXT = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    private static final String EXCEPTION_MESSAGE = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
    private Animal animal;

    @Before
    public void getAnimal() {
        animal = new Animal();
    }

    @Test
    public void getFamilyTest() {
        Assert.assertEquals(ASSERT_DESCRIPTION, GET_FAMILY_ER_TEXT, animal.getFamily());
    }
    @Test
    public void getFoodExceptionTest() {
        Exception exception = Assert.assertThrows(Exception.class, () -> animal.getFood("Исключение"));
        Assert.assertEquals(EXCEPTION_MESSAGE, exception.getMessage());
    }
}