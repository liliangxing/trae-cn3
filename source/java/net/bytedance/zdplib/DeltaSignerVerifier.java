package net.bytedance.zdplib;

import java.util.Arrays;

/* loaded from: classes8.dex */
public class DeltaSignerVerifier {
    private byte[] privateKey;
    private long selfPrivateKeyPointer;

    private static native void free(long j);

    private static native int generatePrivateKey(byte[] bArr);

    private static native int getPublicKey(byte[] bArr, long j);

    private static native int getPublicKeyUncompressed(byte[] bArr, long j);

    private static native long initPrivateKey(byte[] bArr);

    private static native int sign(byte[] bArr, long j, byte[] bArr2);

    private static native int verify(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public DeltaSignerVerifier(String str) throws Exception {
        byte[] hexStringToByteArray = Delta.hexStringToByteArray(str);
        if (hexStringToByteArray.length != 32) {
            throw new Exception("invalid private key :" + str);
        }
        this.selfPrivateKeyPointer = initPrivateKey(hexStringToByteArray);
        this.privateKey = hexStringToByteArray;
    }

    public Delta createDelta(String str) throws Exception {
        return new Delta(this.privateKey, str);
    }

    public String getPublicKey() throws Exception {
        byte[] bArr = new byte[33];
        int publicKey = getPublicKey(bArr, this.selfPrivateKeyPointer);
        if (publicKey != 0) {
            throw new Exception("getPublicKey error " + publicKey);
        }
        return Delta.bytearrayToHexString(bArr);
    }

    public String getPublicKeyUncompressed() throws Exception {
        byte[] bArr = new byte[65];
        int publicKeyUncompressed = getPublicKeyUncompressed(bArr, this.selfPrivateKeyPointer);
        if (publicKeyUncompressed != 0) {
            throw new Exception("getPublicKey error " + publicKeyUncompressed);
        }
        return Delta.bytearrayToHexString(bArr);
    }

    public void freeResource() {
        long j = this.selfPrivateKeyPointer;
        if (j != 0) {
            free(j);
            this.selfPrivateKeyPointer = 0L;
            Arrays.fill(this.privateKey, (byte) 0);
        }
    }

    public byte[] Sign(byte[] bArr) throws Exception {
        byte[] bArr2 = new byte[72];
        int sign = sign(bArr2, this.selfPrivateKeyPointer, bArr);
        if (sign < 0) {
            throw new Exception(String.format("sign error ret=%d", Integer.valueOf(sign)));
        }
        return Arrays.copyOfRange(bArr2, 0, sign);
    }

    public static Boolean VerifySignature(byte[] bArr, byte[] bArr2, String str) throws Exception {
        int verify = verify(bArr, bArr2, Delta.hexStringToByteArray(str));
        if (verify == -11) {
            return false;
        }
        if (verify < 0) {
            throw new Exception(String.format("verify error ret=%d", Integer.valueOf(verify)));
        }
        return true;
    }

    public static String GeneratePrivateKey() throws Exception {
        byte[] bArr = new byte[32];
        int generatePrivateKey = generatePrivateKey(bArr);
        if (generatePrivateKey < 0) {
            throw new Exception("GeneratePrivateKey  error " + generatePrivateKey);
        }
        return Delta.bytearrayToHexString(bArr);
    }

    static {
        System.loadLibrary("delta");
    }
}
