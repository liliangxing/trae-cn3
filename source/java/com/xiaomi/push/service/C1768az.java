package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.lynx.tasm.utils.LynxConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1494ba;
import com.xiaomi.push.C1636gh;
import com.xiaomi.push.C1637gi;
import com.xiaomi.push.C1659hd;
import com.xiaomi.push.C1670ho;
import com.xiaomi.push.C1702q;
import com.xiaomi.push.C1801v;
import com.xiaomi.push.EnumC1643go;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.xiaomi.push.service.az */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1768az {

    /* renamed from: a */
    private static String f3111a;

    /* renamed from: a */
    private static SimpleDateFormat f3112a;

    /* renamed from: a */
    private static AtomicLong f3113a = new AtomicLong(0);

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f3112a = simpleDateFormat;
        f3111a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: a */
    public static synchronized String m3791a() {
        String str;
        synchronized (C1768az.class) {
            String format = f3112a.format(Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.equals(f3111a, format)) {
                f3113a.set(0L);
                f3111a = format;
            }
            str = format + Constants.ACCEPT_TIME_SEPARATOR_SERVER + f3113a.incrementAndGet();
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<C1659hd> m3792a(List<C1637gi> list, String str, String str2, int i) {
        int i2;
        if (list == null) {
            AbstractC1417b.m1103d("requests can not be null in TinyDataHelper.transToThriftObj().");
            return null;
        }
        if (list.size() == 0) {
            AbstractC1417b.m1103d("requests.length is 0 in TinyDataHelper.transToThriftObj().");
            return null;
        }
        ArrayList<C1659hd> arrayList = new ArrayList<>();
        C1636gh c1636gh = new C1636gh();
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            C1637gi c1637gi = list.get(i4);
            if (c1637gi != null) {
                if (c1637gi.m2731a() == null || !c1637gi.m2731a().containsKey("item_size")) {
                    i2 = 0;
                } else {
                    String str3 = c1637gi.m2731a().get("item_size");
                    if (!TextUtils.isEmpty(str3)) {
                        try {
                            i2 = Integer.parseInt(str3);
                        } catch (Exception unused) {
                        }
                        if (c1637gi.m2731a().size() != 1) {
                            c1637gi.m2728a((Map<String, String>) null);
                        } else {
                            c1637gi.m2731a().remove("item_size");
                        }
                    }
                    i2 = 0;
                    if (c1637gi.m2731a().size() != 1) {
                    }
                }
                if (i2 <= 0) {
                    i2 = C1670ho.m3313a(c1637gi).length;
                }
                if (i2 > i) {
                    AbstractC1417b.m1103d("TinyData is too big, ignore upload request item:" + c1637gi.m2747d());
                } else {
                    if (i3 + i2 > i) {
                        arrayList.add(m3790a(str, str2, c1636gh));
                        c1636gh = new C1636gh();
                        i3 = 0;
                    }
                    c1636gh.m2721a(c1637gi);
                    i3 += i2;
                }
            }
        }
        if (c1636gh.m2718a() != 0) {
            arrayList.add(m3790a(str, str2, c1636gh));
        }
        return arrayList;
    }

    /* renamed from: a */
    private static C1659hd m3790a(String str, String str2, C1636gh c1636gh) {
        return new C1659hd(LynxConstants.LYNX_DEFAULT_COMPONENT_ID, false).m3068d(str).m3060b(str2).m3051a(C1801v.m4111a(C1670ho.m3313a(c1636gh))).m3064c(EnumC1643go.UploadTinyData.f2208a);
    }

    /* renamed from: a */
    public static boolean m3794a(C1637gi c1637gi, boolean z) {
        if (c1637gi == null) {
            AbstractC1417b.m1089a("item is null, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!z && TextUtils.isEmpty(c1637gi.f1977a)) {
            AbstractC1417b.m1089a("item.channel is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (TextUtils.isEmpty(c1637gi.f1984d)) {
            AbstractC1417b.m1089a("item.category is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (TextUtils.isEmpty(c1637gi.f1983c)) {
            AbstractC1417b.m1089a("item.name is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!C1494ba.m1632a(c1637gi.f1984d)) {
            AbstractC1417b.m1089a("item.category can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!C1494ba.m1632a(c1637gi.f1983c)) {
            AbstractC1417b.m1089a("item.name can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (c1637gi.f1982b == null || c1637gi.f1982b.length() <= 30720) {
            return false;
        }
        AbstractC1417b.m1089a("item.data is too large(" + c1637gi.f1982b.length() + "), max size for data is 30720 , verfiy ClientUploadDataItem failed.");
        return true;
    }

    /* renamed from: a */
    public static void m3793a(Context context, String str, String str2, long j, String str3) {
        C1637gi c1637gi = new C1637gi();
        c1637gi.m2746d(str);
        c1637gi.m2742c(str2);
        c1637gi.m2726a(j);
        c1637gi.m2738b(str3);
        c1637gi.m2727a("push_sdk_channel");
        c1637gi.m2754g(context.getPackageName());
        c1637gi.m2749e(context.getPackageName());
        c1637gi.m2729a(true);
        c1637gi.m2737b(System.currentTimeMillis());
        c1637gi.m2752f(m3791a());
        C1770ba.m3803a(context, c1637gi);
    }

    /* renamed from: a */
    public static boolean m3795a(String str) {
        return !C1702q.m3469b() || Constants.HYBRID_PACKAGE_NAME.equals(str);
    }
}
