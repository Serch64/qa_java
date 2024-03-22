import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private static final String EXCEPTION_MESSAGE = "Используйте допустимые значения пола животного - самей или самка";
    private Lion lion;
    @Mock
    private Feline felineMock;

    @Test
    public void getKittensTest() throws Exception {
        lion = new Lion("Самец", felineMock);
        lion.getKittens();
        Mockito.verify(felineMock, Mockito.times(1)).getKittens();
    }

    @Test
    public void getFoodTest() throws Exception {
        lion = new Lion("Самец", felineMock);
        lion.getFood();
        Mockito.verify(felineMock, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getLionExceptionTest() {
        Exception exception = Assert.assertThrows(Exception.class, () -> new Lion("Исключение", felineMock));
        Assert.assertEquals(EXCEPTION_MESSAGE, exception.getMessage());
    }
}
