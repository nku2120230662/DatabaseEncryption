package encryption;

import encryption.symmetric.SymmetricEncryption;
import org.junit.Test;

public class TestSymmetric {
    @Test
    public void testSymmetricEncryption() throws Exception {
        SymmetricEncryption.Encrypt(123);
    }
}
