package encryption;

import encryption.symmetric.SymmeticEncryption;
import org.junit.Test;

public class TestSymmteric {
    @Test
    public void testSymm() {
        SymmeticEncryption.Encrypt(123);
    }
}
