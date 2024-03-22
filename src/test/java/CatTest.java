import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private static final String ASSERT_DESCRIPTION = "Метод возвращает отличный от ожидаемого результат";
    private Cat cat;
    @Mock
    private Feline felineMock;
    @Before
    public void getCat() {
        cat = new Cat(felineMock);
    }
    @Test
    public void getSoundTest() {
        Assert.assertEquals(ASSERT_DESCRIPTION,"Мяу", cat.getSound());
    }
    @Test
    public void getFoodTest() throws Exception {
        cat.getFood();
        Mockito.verify(felineMock, Mockito.times(1)).eatMeat();
    }
}

