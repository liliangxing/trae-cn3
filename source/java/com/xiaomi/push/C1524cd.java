package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.net.InetSocketAddress;

/* renamed from: com.xiaomi.push.cd */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1524cd {

    /* renamed from: a */
    private int f1156a;

    /* renamed from: a */
    private String f1157a;

    /* renamed from: a */
    public int m1809a() {
        return this.f1156a;
    }

    /* renamed from: a */
    public String m1810a() {
        return this.f1157a;
    }

    public C1524cd(String str, int i) {
        this.f1157a = str;
        this.f1156a = i;
    }

    /* renamed from: a */
    public static C1524cd m1807a(String str, int i) {
        int lastIndexOf = str.lastIndexOf(Constants.COLON_SEPARATOR);
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            try {
                int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
                if (parseInt > 0) {
                    i = parseInt;
                }
            } catch (NumberFormatException unused) {
            }
            str = substring;
        }
        return new C1524cd(str, i);
    }

    /* renamed from: a */
    public static InetSocketAddress m1808a(String str, int i) {
        C1524cd m1807a = m1807a(str, i);
        return new InetSocketAddress(m1807a.m1810a(), m1807a.m1809a());
    }

    public String toString() {
        if (this.f1156a > 0) {
            return this.f1157a + Constants.COLON_SEPARATOR + this.f1156a;
        }
        return this.f1157a;
    }
}
