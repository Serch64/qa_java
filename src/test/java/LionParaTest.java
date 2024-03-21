import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class LionParaTest {
    private static final String ASSERT_DESCRIPTION = "Метод возвращает отличный от ожидаемого результат";
    private static final String EXCEPTION_MESSAGE = "Используйте допустимые значения пола животного - самей или самка";
    private Feline felineMock = Mockito.mock(Feline.class);
    private final String sex;
    private final boolean hasMane;
    public LionParaTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Исключение", false}
        };
    }
    @Test
    public void doesHaveManeTest() {
        try {
            Lion lion = new Lion(sex, felineMock);
            Assert.assertEquals(ASSERT_DESCRIPTION, hasMane,  lion.doesHaveMane());
        } catch (Exception exception) {
            Assert.assertEquals(EXCEPTION_MESSAGE, exception.getMessage());
        }

    }
}