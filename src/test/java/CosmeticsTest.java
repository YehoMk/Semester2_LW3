import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CosmeticsTest {

    @Test
    public void testConstructorThrowsExceptionBrand() {
        assertThrows(IllegalArgumentException.class, () -> new Cosmetics("", "Ceramide Protect", "Догляд за шкірою", 400, 340));
    }

    @Test
    public void testConstructorThrowsExceptionName() {
        assertThrows(IllegalArgumentException.class, () -> new Cosmetics("Mixa", "    ", "Догляд за шкірою", 400, 340));
    }

    @Test
    public void testConstructorThrowsExceptionType() {
        assertThrows(IllegalArgumentException.class, () -> new Cosmetics("Mixa", "Ceramide Protect", " ", 400, 340));
    }

    @Test
    public void testConstructorThrowsExceptionVolumeMlisNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Cosmetics("Mixa", "Ceramide Protect", "Догляд за шкірою", -400, 340));
    }

    @Test
    public void testConstructorThrowsExceptionVolumeMlisZero() {
        assertThrows(IllegalArgumentException.class, () -> new Cosmetics("Mixa", "Ceramide Protect", "Догляд за шкірою", 400, 0));
    }

    @Test
    public void testGetters() {
        Cosmetics cosmetic = new Cosmetics("Mixa", "Ceramide Protect", "Догляд за шкірою", 400, 340);
        assertAll(() -> assertEquals("Mixa", cosmetic.getBrand()),
                () -> assertEquals("Ceramide Protect", cosmetic.getName()),
                () -> assertEquals("Догляд за шкірою", cosmetic.getType()),
                () -> assertEquals(400, cosmetic.getVolumeMl()),
                () -> assertEquals(340, cosmetic.getPriceUAH())
                );
    }

    @Test
    public void testEqualsIdentical() {
        Cosmetics cosmetic1 = new Cosmetics("Mixa", "Ceramide Protect", "Догляд за шкірою", 400, 340);
        Cosmetics cosmetic2 = new Cosmetics("Mixa", "Ceramide Protect", "Догляд за шкірою", 400, 340);
        assertTrue(cosmetic1.equals(cosmetic2));
    }

    @Test
    public void testEqualsDifferent() {
        Cosmetics cosmetic1 = new Cosmetics("Mixa", "Ceramide Protect", "Догляд за шкірою", 400, 340);
        Cosmetics cosmetic2 = new Cosmetics("Rexona", "Maximum Protection Antiperspirant", "Антиперспірант", 45, 220);
        assertFalse(cosmetic1.equals(cosmetic2));
    }

    @Test
    public void testEqualsSameObject() {
        Cosmetics cosmetic = new Cosmetics("Mixa", "Ceramide Protect", "Догляд за шкірою", 400, 340);
        assertTrue(cosmetic.equals(cosmetic));
    }

    @Test
    public void testEqualsOtherClass() {
        Cosmetics cosmetic = new Cosmetics("Mixa", "Ceramide Protect", "Догляд за шкірою", 400, 340);
        assertFalse(cosmetic.equals("String"));
    }

    @Test
    public void testEqualsNull() {
        Cosmetics cosmetic = new Cosmetics("Mixa", "Ceramide Protect", "Догляд за шкірою", 400, 340);
        assertFalse(cosmetic.equals(null));
    }
}