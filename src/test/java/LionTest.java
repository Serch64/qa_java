import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private Lion lion;
    @Mock
    private Feline felineMock;

    @Before
    public void getLion() throws Exception {
        lion = new Lion("Самец", felineMock);
    }
    @Test
    public void getKittensTest() {
            lion.getKittens();
            Mockito.verify(felineMock, Mockito.times(1)).getKittens();
    }

    @Test
    public void getFoodTest() throws Exception{
            lion.getFood();
            Mockito.verify(felineMock, Mockito.times(1)).getFood("Хищник");
        }

}
