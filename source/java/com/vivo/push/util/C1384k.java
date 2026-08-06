package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* compiled from: DefaultNotifyDataAdapter.java */
/* renamed from: com.vivo.push.util.k */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1384k implements BaseNotifyDataAdapter {

    /* renamed from: e */
    private static int f695e;

    /* renamed from: f */
    private static int f696f;

    /* renamed from: a */
    private Resources f697a;

    /* renamed from: b */
    private String f698b;

    /* renamed from: c */
    private String f699c;

    /* renamed from: d */
    private String f700d;

    /* renamed from: a */
    private static boolean m1006a(int i) {
        return (i == -1 || i == 0) ? false : true;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getNotifyMode(InsideNotificationItem insideNotificationItem) {
        return 2;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final void init(Context context) {
        this.f698b = context.getPackageName();
        this.f697a = context.getResources();
        this.f699c = C1386m.m1008a();
        this.f700d = Build.VERSION.RELEASE;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultNotifyIcon() {
        int m1005a;
        if (m1006a(f695e)) {
            return f695e;
        }
        String str = this.f700d;
        if (!m1007a(str)) {
            C1393t.m1048d("DefaultNotifyDataAdapter", "getNotifyIconByArdVersion isSystemCodeUsable is false ");
            m1005a = -1;
        } else {
            m1005a = m1005a(str, "_notifyicon");
        }
        f695e = m1005a;
        if (m1006a(m1005a)) {
            return f695e;
        }
        String str2 = this.f699c;
        while (true) {
            C1393t.m1048d("DefaultNotifyDataAdapter", "getNotifyIconByRomVersion codeReg = ".concat(String.valueOf(str2)));
            if (TextUtils.isEmpty(str2)) {
                return this.f697a.getIdentifier("vivo_push_notifyicon", "drawable", this.f698b);
            }
            int identifier = this.f697a.getIdentifier("vivo_push_rom" + str2 + "_notifyicon", "drawable", this.f698b);
            if (identifier > 0) {
                C1393t.m1048d("DefaultNotifyDataAdapter", "getNotifyIconByRomVersion find notifyicon = vivo_push_rom" + str2 + "_notifyicon");
                return identifier;
            }
            str2 = str2.substring(0, str2.length() - 1);
        }
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultSmallIconId() {
        int m1005a;
        if (m1006a(f696f)) {
            return f696f;
        }
        String str = this.f700d;
        if (!m1007a(str)) {
            C1393t.m1048d("DefaultNotifyDataAdapter", "getSmallIconByArdVersion isSystemCodeUsable is false ");
            m1005a = -1;
        } else {
            m1005a = m1005a(str, "_icon");
        }
        f696f = m1005a;
        if (m1006a(m1005a)) {
            return f696f;
        }
        String str2 = this.f699c;
        while (true) {
            C1393t.m1048d("DefaultNotifyDataAdapter", "getSmallIconByRomVersion codeReg = ".concat(String.valueOf(str2)));
            if (TextUtils.isEmpty(str2)) {
                return this.f697a.getIdentifier("vivo_push_icon", "drawable", this.f698b);
            }
            int identifier = this.f697a.getIdentifier("vivo_push_rom" + str2 + "_icon", "drawable", this.f698b);
            if (identifier > 0) {
                C1393t.m1048d("DefaultNotifyDataAdapter", "getSmallIconByRomVersion find smallIcon = vivo_push_rom" + str2 + "_icon");
                return identifier;
            }
            str2 = str2.substring(0, str2.length() - 1);
        }
    }

    /* renamed from: a */
    private static boolean m1007a(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        C1393t.m1048d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
        return false;
    }

    /* renamed from: a */
    private int m1005a(String str, String str2) {
        C1393t.m1048d("DefaultNotifyDataAdapter", "getIcon systemVersion = " + str + " suffix= " + str2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] split = str.split("\\.");
            if (split != null && split.length > 0) {
                str = split[0];
            }
            try {
                for (int parseInt = Integer.parseInt(str); parseInt > 0; parseInt--) {
                    String str3 = "vivo_push_ard" + parseInt + str2;
                    C1393t.m1046c("DefaultNotifyDataAdapter", "get notify icon : ".concat(String.valueOf(str3)));
                    int identifier = this.f697a.getIdentifier(str3, "drawable", this.f698b);
                    if (identifier > 0) {
                        C1393t.m1046c("DefaultNotifyDataAdapter", "find notify icon : ".concat(String.valueOf(str3)));
                        return identifier;
                    }
                }
            } catch (Exception e) {
                C1393t.m1036a("DefaultNotifyDataAdapter", e);
            }
        }
        return -1;
    }
}
