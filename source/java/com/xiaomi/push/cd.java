package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.net.InetSocketAddress;

/* loaded from: classes7.dex */
public final class cd {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private String f242a;

    public int a() {
        return this.a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m9704a() {
        return this.f242a;
    }

    public cd(String str, int i) {
        this.f242a = str;
        this.a = i;
    }

    public static cd a(String str, int i) {
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
        return new cd(str, i);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static InetSocketAddress m9703a(String str, int i) {
        cd a = a(str, i);
        return new InetSocketAddress(a.m9704a(), a.a());
    }

    public String toString() {
        if (this.a > 0) {
            return this.f242a + Constants.COLON_SEPARATOR + this.a;
        }
        return this.f242a;
    }
}
