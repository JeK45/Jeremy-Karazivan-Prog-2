package Atelier1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Divers {

    @Test
    void test_triCroissantSSS() {
        int[] tab = {5,4,2,3,1};
        int[] expectedResult = {1,2,3,4,5};

        int[] actualResult = Tableaux.TriCroissantSSS(tab);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void test_triDecroissantSSS() {
        int[] tab = {5,4,2,3,1};
        int[] expectedResult = {5,4,3,2,1};

        int[] actualResult = Tableaux.TriDecroissantSSS(tab);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void test_maximum() {
        int[] tab = {-20,423,99,0,1};
        int expectedResult = 423;

        int actualResult = Tableaux.maximum(tab);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_minimum() {
        int[] tab = {-20,423,99,0,1};
        int expectedResult = -20;

        int actualResult = Tableaux.minimum(tab);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_somme() {
        int[] tab = {10,-2,5,9,0};
        int expectedResult = 22;

        int actualResult = Tableaux.somme(tab);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_moyenne() {
        int[] tab = {1,2,3,4,5,6,7,8,9,10};
        double expectedResult = 5.5;

        double actualResult = Tableaux.moyenne(tab);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_fouilleSeq() {
        int[] tab = {1,23,54,3,7,65,23,4,6,234};

        assertEquals(5, Tableaux.fouilleSeq(tab, 65));
    }
}