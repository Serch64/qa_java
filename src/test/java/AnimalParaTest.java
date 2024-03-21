import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class AnimalParaTest {
    private static final String ASSERT_DESCRIPTION = "Метод возвращает отличный от ожидаемого результат";
    private static final String EXCEPTION_MESSAGE = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
    private final String animalKind;
    private final List<String> list;

    public AnimalParaTest(String animalKind, List<String> list) {
        this.animalKind = animalKind;
        this.list = list;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Исключение", List.of("Животные", "Птицы", "Рыба")}
        };
    }
    @Test
    public void getFoodTest() {
        try {
            Animal animal = new Animal();
            Assert.assertEquals(ASSERT_DESCRIPTION, list,  animal.getFood(animalKind));
        } catch (Exception exception) {
            Assert.assertEquals(EXCEPTION_MESSAGE, exception.getMessage());
        }
    }
}