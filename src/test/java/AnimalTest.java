import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AnimalTest {
    private static final String ASSERT_DESCRIPTION = "Метод возвращает отличный от ожидаемого результат";
    private static final String GET_FAMILY_ER_TEXT = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        Assert.assertEquals(ASSERT_DESCRIPTION, GET_FAMILY_ER_TEXT, animal.getFamily());
    }
}