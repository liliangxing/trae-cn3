package cn.com.chinatelecom.account.api.p006a;

import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import java.nio.charset.Charset;

/* renamed from: cn.com.chinatelecom.account.api.a.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0678d {

    /* renamed from: a */
    private static final String f122a = "d";

    /* renamed from: b */
    private static final Charset f123b = Charset.forName(UrlUtils.UTF_8);

    /* renamed from: c */
    private static byte[] f124c = {68, 64, 94, 49, 50, 83};

    /* renamed from: a */
    public static String m189a(byte[] bArr) {
        try {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr2[i] = bArr[i];
                for (byte b : f124c) {
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
