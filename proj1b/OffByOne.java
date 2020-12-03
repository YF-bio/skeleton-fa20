import org.junit.Test;

public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs((int) x - (int) y) == 1;
    }

    @Test
    public void testcc() {
        OffByOne obo = new OffByOne();
        obo.equalChars('a', 'b');
        obo.equalChars('x', 'y');
        obo.equalChars('a', 'e');
    }
}
