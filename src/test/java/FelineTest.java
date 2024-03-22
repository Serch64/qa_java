import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    private static final String ASSERT_DESCRIPTION = "Метод возвращает отличный от ожидаемого результат";
    private Feline feline;
    @Spy
    private Feline felineSpy;

    @Test
    public void eatMeatTest() throws Exception {
        felineSpy.eatMeat();
        Mockito.verify(felineSpy, Mockito.times(1)).getFood("Хищник");
    }
    @Test
    public void getFamilyTest() {
        feline = new Feline();
        Assert.assertEquals(ASSERT_DESCRIPTION,"Кошачьи", feline.getFamily());
    }
    @Test
    public void getKittensNoParamTest() {
        felineSpy.getKittens();
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(1);
    }
    @Test
    public void getKittensParamTest() {
        feline = new Feline();
        Assert.assertEquals(ASSERT_DESCRIPTION,1,  feline.getKittens(1));
    }
}
