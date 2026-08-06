package net.bytedance.zdplib;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.ss.android.seccache.Encrypt;
import kotlin.UByte;

/* loaded from: classes8.dex */
public class Delta {
    public static final int InvalidSignature = -11;
    private static final String PrivateKeyConfigName = "DeltaPrivateKey";
    public static final int PrivateKeyLength = 32;
    public static final int PublicKeyLength = 33;
    public static final int SignatureMaxLength = 72;
    public static final int UncompressPublicKeyLength = 65;
    private final String TAG = getClass().getSimpleName();
    private byte[] aesKey;
    private long otherPublicKeyPointer;
    private long selfPrivateKeyPointer;

    private static native int decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3);

    private static native int encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3);

    private static native void free(long j);

    private static native int generateAesKey(byte[] bArr, long j, long j2);

    private static native int generatePrivateKey(byte[] bArr);

    private static native int getDecryptedLen(int i);

    private static native int getEncryptedLen(int i);

    private static native int getPublicKey(byte[] bArr, long j);

    private static native long initPrivateKey(byte[] bArr);

    private static native long initPubKey(byte[] bArr);

    static {
        System.loadLibrary("delta");
    }

    public Delta(String str, Context context) throws Exception {
        byte[] hexStringToByteArray = hexStringToByteArray(str);
        if (hexStringToByteArray.length != 33 && hexStringToByteArray.length != 65) {
            throw new Exception("other public key length error");
        }
        long initPubKey = initPubKey(hexStringToByteArray);
        this.otherPublicKeyPointer = initPubKey;
        if (initPubKey == 0) {
            throw new Exception("other public key invalid");
        }
        initPrivateKey(context);
        byte[] bArr = new byte[32];
        this.aesKey = bArr;
        int generateAesKey = generateAesKey(bArr, this.selfPrivateKeyPointer, this.otherPublicKeyPointer);
        if (generateAesKey != 0) {
            throw new Exception("generateAesKey error " + generateAesKey);
        }
    }

    public Delta(byte[] bArr, String str) throws Exception {
        byte[] hexStringToByteArray = hexStringToByteArray(str);
        if (hexStringToByteArray.length != 33 && hexStringToByteArray.length != 65) {
            throw new Exception("other public key length error");
        }
        long initPubKey = initPubKey(hexStringToByteArray);
        this.otherPublicKeyPointer = initPubKey;
        if (initPubKey == 0) {
            throw new Exception("other public key invalid");
        }
        long initPrivateKey = initPrivateKey(bArr);
        this.selfPrivateKeyPointer = initPrivateKey;
        byte[] bArr2 = new byte[32];
        this.aesKey = bArr2;
        int generateAesKey = generateAesKey(bArr2, initPrivateKey, this.otherPublicKeyPointer);
        if (generateAesKey != 0) {
            throw new Exception("generateAesKey error " + generateAesKey);
        }
    }

    private void initPrivateKey(Context context) throws Exception {
        byte[] bArr;
        MySharePreferences mySharePreferences = new MySharePreferences(context);
        String string = mySharePreferences.getString(PrivateKeyConfigName);
        if (string == null) {
            byte[] bArr2 = new byte[32];
            int generatePrivateKey = generatePrivateKey(bArr2);
            if (generatePrivateKey < 0) {
                throw new Exception("generate private key error " + generatePrivateKey);
            }
            this.selfPrivateKeyPointer = initPrivateKey(bArr2);
            mySharePreferences.setString(PrivateKeyConfigName, Encrypt.encryptString(bytearrayToHexString(bArr2)));
        } else {
            try {
                try {
                    bArr = hexStringToByteArray(Encrypt.decryptString(string, string));
                } catch (Exception e) {
                    Log.e(this.TAG, "decryptString error " + e);
                    bArr = null;
                }
                if (bArr != null && bArr.length == 32) {
                    this.selfPrivateKeyPointer = initPrivateKey(bArr);
                }
                byte[] bArr3 = new byte[32];
                int generatePrivateKey2 = generatePrivateKey(bArr3);
                if (generatePrivateKey2 < 0) {
                    throw new Exception("regenerate private key error " + generatePrivateKey2);
                }
                this.selfPrivateKeyPointer = initPrivateKey(bArr3);
                mySharePreferences.setString(PrivateKeyConfigName, Encrypt.encryptString(bytearrayToHexString(bArr3)));
            } catch (Exception e2) {
                throw new Exception(String.format("privateKey.length=%d,keyslice=%s, ex=%s", Integer.valueOf(string.length()), string.length() > 100 ? string.substring(0, 10) : "", e2));
            }
        }
        if (this.selfPrivateKeyPointer == 0) {
            throw new Exception("initPrivateKey error");
        }
    }

    public String GetPublicKey() throws Exception {
        byte[] bArr = new byte[33];
        int publicKey = getPublicKey(bArr, this.selfPrivateKeyPointer);
        if (publicKey != 0) {
            throw new Exception("getPublicKey error " + publicKey);
        }
        return bytearrayToHexString(bArr);
    }

    public byte[] Encrypt(byte[] bArr) throws Exception {
        if (this.aesKey == null) {
            throw new Exception("invalid aes key");
        }
        int encryptedLen = getEncryptedLen(bArr.length);
        byte[] bArr2 = new byte[encryptedLen];
        int encrypt = encrypt(bArr2, bArr, this.aesKey);
        if (encrypt < 0) {
            throw new Exception("encrypt error " + encrypt);
        }
        if (encrypt == encryptedLen) {
            return bArr2;
        }
        throw new Exception("data length error");
    }

    public byte[] Decrypt(byte[] bArr) throws Exception {
        if (this.aesKey == null) {
            throw new Exception("invalid aes key");
        }
        int decryptedLen = getDecryptedLen(bArr.length);
        if (decryptedLen <= 0) {
            throw new Exception("encryptedMessage is too short");
        }
        byte[] bArr2 = new byte[decryptedLen];
        int decrypt = decrypt(bArr2, bArr, this.aesKey);
        if (decrypt >= 0) {
            return bArr2;
        }
        throw new Exception("decrypt error " + decrypt);
    }

    public static byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static String bytearrayToHexString(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & UByte.MAX_VALUE;
            int i3 = i * 2;
            cArr2[i3] = cArr[i2 >>> 4];
            cArr2[i3 + 1] = cArr[i2 & 15];
        }
        return new String(cArr2);
    }

    public void freeResource() {
        long j = this.selfPrivateKeyPointer;
        if (j != 0) {
            free(j);
            this.selfPrivateKeyPointer = 0L;
        }
        long j2 = this.otherPublicKeyPointer;
        if (j2 != 0) {
            free(j2);
            this.otherPublicKeyPointer = 0L;
        }
    }

    /* loaded from: classes8.dex */
    public static class MySharePreferences {
        private static final String FILE_NAME = "DeltaConfig";
        private final SharedPreferences.Editor editor;
        private final SharedPreferences sp;

        protected MySharePreferences(Context context) {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(FILE_NAME, 0);
            this.sp = sharedPreferences;
            this.editor = sharedPreferences.edit();
        }

        public void setString(String str, String str2) {
            this.editor.putString(str, str2);
            this.editor.commit();
        }

        public String getString(String str) {
            return this.sp.getString(str, null);
        }
    }
}
