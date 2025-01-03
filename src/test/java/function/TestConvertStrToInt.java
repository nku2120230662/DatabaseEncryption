package function;

import encryption.function.ConvertStringToInt;
import org.junit.Test;

import java.util.Arrays;

public class TestConvertStrToInt {
    @Test
    public void testConvertStrToInt() {
//        System.out.println(ConvertStringToInt.function("zzy"));
        String condition1="id = 1";
        String condition2="id in [a,b,c]";
        String[] parts1=condition1.split("=");
        String[] parts2=condition2.split(" ");
        System.out.println(Arrays.toString(parts1));
        System.out.println(Arrays.toString(parts2));
    }
}
