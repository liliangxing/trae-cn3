package cn.com.chinatelecom.account.api.p010e;

/* renamed from: cn.com.chinatelecom.account.api.e.l */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0705l {

    /* renamed from: a */
    private static final String f315a = "l";

    /* renamed from: b */
    private static byte[] f316b = {68, 64, 94, 49, 69, 35, 50, 83};

    /* renamed from: a */
    public static String m372a(byte[] bArr) {
        try {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr2[i] = bArr[i];
                for (byte b : f316b) {
                    bArr2[i] = (byte) (b ^ bArr2[i]);
                }
            }
            return new String(bArr2);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
