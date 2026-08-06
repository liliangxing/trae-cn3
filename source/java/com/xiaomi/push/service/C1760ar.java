package com.xiaomi.push.service;

import com.ttnet.org.chromium.base.task.TaskTraits;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1490ax;

/* renamed from: com.xiaomi.push.service.ar */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1760ar {

    /* renamed from: a */
    private static int f3074a = 8;

    /* renamed from: d */
    private int f3078d = -666;

    /* renamed from: a */
    private byte[] f3075a = new byte[256];

    /* renamed from: c */
    private int f3077c = 0;

    /* renamed from: b */
    private int f3076b = 0;

    /* renamed from: a */
    public static int m3740a(byte b) {
        return b >= 0 ? b : b + TaskTraits.INVALID_EXTENSION_ID;
    }

    /* renamed from: a */
    private void m3742a(int i, byte[] bArr, boolean z) {
        int length = bArr.length;
        for (int i2 = 0; i2 < 256; i2++) {
            this.f3075a[i2] = (byte) i2;
        }
        this.f3077c = 0;
        this.f3076b = 0;
        while (true) {
            int i3 = this.f3076b;
            if (i3 >= i) {
                break;
            }
            int m3740a = ((this.f3077c + m3740a(this.f3075a[i3])) + m3740a(bArr[this.f3076b % length])) % 256;
            this.f3077c = m3740a;
            m3744a(this.f3075a, this.f3076b, m3740a);
            this.f3076b++;
        }
        if (i != 256) {
            this.f3078d = ((this.f3077c + m3740a(this.f3075a[i])) + m3740a(bArr[i % length])) % 256;
        }
        if (z) {
            StringBuilder sb = new StringBuilder("S_");
            int i4 = i - 1;
            sb.append(i4).append(Constants.COLON_SEPARATOR);
            for (int i5 = 0; i5 <= i; i5++) {
                sb.append(" ").append(m3740a(this.f3075a[i5]));
            }
            sb.append("   j_").append(i4).append("=").append(this.f3077c);
            sb.append("   j_").append(i).append("=").append(this.f3078d);
            sb.append("   S_").append(i4).append("[j_").append(i4).append("]=").append(m3740a(this.f3075a[this.f3077c]));
            sb.append("   S_").append(i4).append("[j_").append(i).append("]=").append(m3740a(this.f3075a[this.f3078d]));
            if (this.f3075a[1] != 0) {
                sb.append("   S[1]!=0");
            }
            AbstractC1417b.m1089a(sb.toString());
        }
    }

    /* renamed from: a */
    private void m3743a(byte[] bArr) {
        m3742a(256, bArr, false);
    }

    /* renamed from: a */
    private void m3741a() {
        this.f3077c = 0;
        this.f3076b = 0;
    }

    /* renamed from: a */
    byte m3749a() {
        int i = (this.f3076b + 1) % 256;
        this.f3076b = i;
        int m3740a = (this.f3077c + m3740a(this.f3075a[i])) % 256;
        this.f3077c = m3740a;
        m3744a(this.f3075a, this.f3076b, m3740a);
        byte[] bArr = this.f3075a;
        return bArr[(m3740a(bArr[this.f3076b]) + m3740a(this.f3075a[this.f3077c])) % 256];
    }

    /* renamed from: a */
    private static void m3744a(byte[] bArr, int i, int i2) {
        byte b = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b;
    }

    /* renamed from: a */
    public static byte[] m3747a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        C1760ar c1760ar = new C1760ar();
        c1760ar.m3743a(bArr);
        c1760ar.m3741a();
        for (int i = 0; i < bArr2.length; i++) {
            bArr3[i] = (byte) (bArr2[i] ^ c1760ar.m3749a());
        }
        return bArr3;
    }

    /* renamed from: a */
    public static byte[] m3748a(byte[] bArr, byte[] bArr2, boolean z, int i, int i2) {
        byte[] bArr3;
        int i3;
        if (i < 0 || i > bArr2.length || i + i2 > bArr2.length) {
            throw new IllegalArgumentException("start = " + i + " len = " + i2);
        }
        if (z) {
            bArr3 = bArr2;
            i3 = i;
        } else {
            bArr3 = new byte[i2];
            i3 = 0;
        }
        C1760ar c1760ar = new C1760ar();
        c1760ar.m3743a(bArr);
        c1760ar.m3741a();
        for (int i4 = 0; i4 < i2; i4++) {
            bArr3[i3 + i4] = (byte) (bArr2[i + i4] ^ c1760ar.m3749a());
        }
        return bArr3;
    }

    /* renamed from: a */
    public static byte[] m3746a(byte[] bArr, String str) {
        return m3747a(bArr, C1490ax.m1586a(str));
    }

    /* renamed from: a */
    public static byte[] m3745a(String str, String str2) {
        byte[] m1586a = C1490ax.m1586a(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[m1586a.length + 1 + bytes.length];
        for (int i = 0; i < m1586a.length; i++) {
            bArr[i] = m1586a[i];
        }
        bArr[m1586a.length] = 95;
        for (int i2 = 0; i2 < bytes.length; i2++) {
            bArr[m1586a.length + 1 + i2] = bytes[i2];
        }
        return bArr;
    }
}
