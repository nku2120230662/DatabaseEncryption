package encryption.function;

import encryption.parameter.MasterKey;
import encryption.parameter.PublicParameter;

public class InnerProductEncryption {
    // 输入安全参数λ——决定群的维度（即密钥和密文空间大小）和n(客户端数量）
    private int lambda;
    private int n;
    // pp参与形成密文(1, lambda)
    private PublicParameter mypp;
    // msk参与形成密钥(B, B*)
    private MasterKey mymsk;

    public void SetUp(int lambda, int n){
        this.lambda = lambda;
        this.n = n;
        System.out.println("lambda: " + lambda);
        GenerateParameters();
    }

    // 生成公共参数pp和msk
    public void GenerateParameters() {
//        byte[] B, BStar, paramv;
//        //Gob 随机双配对正交基生成器
//        B, BStar, paramv = Gob(lambda, n);
//        mypp.lambda1 = new boolean[]{false, false};
//        mypp.paramv = paramv;
//        mymsk.B = B;
    }

    // 为每个客户端生成私钥
        public void KeyGeneration(MasterKey myMsk, String x) {

    }

    public Object Encryption(PublicParameter mypp, String y) {
        return null;
    }

    public Object Decryption(PublicParameter mypp, MasterKey mymsk, Object ctx) {
        return null;
    }
}
