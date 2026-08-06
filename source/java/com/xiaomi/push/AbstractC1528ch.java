package com.xiaomi.push;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.http.legacy.protocol.HTTP;
import com.ss.ttm.player.MediaPlayer;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.ch */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbstractC1528ch {

    /* renamed from: com.xiaomi.push.ch$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a extends AbstractC1527cg {
        public a() {
            super(1);
        }

        @Override // com.xiaomi.push.AbstractC1527cg
        /* renamed from: a */
        public String mo1846a(Context context, String str, List<InterfaceC1485as> list) {
            if (list == null) {
                return C1486at.m1536a(context, new URL(str));
            }
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            for (InterfaceC1485as interfaceC1485as : list) {
                buildUpon.appendQueryParameter(interfaceC1485as.mo1523a(), interfaceC1485as.mo1524b());
            }
            return C1486at.m1536a(context, new URL(buildUpon.toString()));
        }
    }

    /* renamed from: a */
    public static String m1853a(Context context, String str, List<InterfaceC1485as> list) {
        return m1854a(context, str, list, new a(), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00aa A[Catch: MalformedURLException -> 0x00c3, TRY_ENTER, TryCatch #4 {MalformedURLException -> 0x00c3, blocks: (B:6:0x000f, B:8:0x0016, B:10:0x0020, B:12:0x0027, B:14:0x002d, B:15:0x0030, B:16:0x0035, B:18:0x003b, B:20:0x0044, B:21:0x004c, B:23:0x0050, B:25:0x0058, B:27:0x005c, B:51:0x0064, B:42:0x00aa, B:43:0x00bc, B:30:0x007e, B:33:0x008f), top: B:5:0x000f }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m1854a(Context context, String str, List<InterfaceC1485as> list, AbstractC1527cg abstractC1527cg, boolean z) {
        C1522cb c1522cb;
        IOException iOException;
        String str2;
        String str3;
        if (C1486at.m1545a(context)) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                if (z) {
                    C1522cb m1822a = C1526cf.m1812a().m1822a(str);
                    if (m1822a != null) {
                        arrayList = m1822a.m1781a(str);
                    }
                    c1522cb = m1822a;
                } else {
                    c1522cb = null;
                }
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
                Iterator<String> it = arrayList.iterator();
                String str4 = null;
                while (it.hasNext()) {
                    String next = it.next();
                    ArrayList arrayList2 = list != null ? new ArrayList(list) : null;
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                    } catch (IOException e) {
                        iOException = e;
                        str2 = str4;
                    }
                    if (!abstractC1527cg.m1847a(context, next, (List<InterfaceC1485as>) arrayList2)) {
                        return str4;
                    }
                    String mo1846a = abstractC1527cg.mo1846a(context, next, (List<InterfaceC1485as>) arrayList2);
                    try {
                    } catch (IOException e2) {
                        e = e2;
                        str3 = mo1846a;
                    }
                    if (!TextUtils.isEmpty(mo1846a)) {
                        if (c1522cb != null) {
                            try {
                                c1522cb.m1789a(next, System.currentTimeMillis() - currentTimeMillis, m1850a(abstractC1527cg, next, arrayList2, mo1846a));
                            } catch (IOException e3) {
                                iOException = e3;
                                str2 = mo1846a;
                                if (c1522cb != null) {
                                    c1522cb.m1790a(next, System.currentTimeMillis() - currentTimeMillis, m1850a(abstractC1527cg, next, arrayList2, str2), iOException);
                                }
                                iOException.printStackTrace();
                                str4 = str2;
                            }
                        }
                        return mo1846a;
                    }
                    if (c1522cb != null) {
                        str3 = mo1846a;
                        try {
                            c1522cb.m1790a(next, System.currentTimeMillis() - currentTimeMillis, m1850a(abstractC1527cg, next, arrayList2, mo1846a), null);
                        } catch (IOException e4) {
                            e = e4;
                            String str5 = str3;
                            iOException = e;
                            str2 = str5;
                            if (c1522cb != null) {
                            }
                            iOException.printStackTrace();
                            str4 = str2;
                        }
                    } else {
                        str3 = mo1846a;
                    }
                    str4 = str3;
                }
                return str4;
            } catch (MalformedURLException e5) {
                e5.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    private static int m1850a(AbstractC1527cg abstractC1527cg, String str, List<InterfaceC1485as> list, String str2) {
        if (abstractC1527cg.m1845a() == 1) {
            return m1848a(str.length(), m1851a(str2));
        }
        if (abstractC1527cg.m1845a() != 2) {
            return -1;
        }
        return m1849a(str.length(), m1852a(list), m1851a(str2));
    }

    /* renamed from: a */
    static int m1852a(List<InterfaceC1485as> list) {
        int i = 0;
        for (InterfaceC1485as interfaceC1485as : list) {
            if (!TextUtils.isEmpty(interfaceC1485as.mo1523a())) {
                i += interfaceC1485as.mo1523a().length();
            }
            if (!TextUtils.isEmpty(interfaceC1485as.mo1524b())) {
                i += interfaceC1485as.mo1524b().length();
            }
        }
        return i * 2;
    }

    /* renamed from: a */
    static int m1851a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return str.getBytes(HTTP.UTF_8).length;
        } catch (UnsupportedEncodingException unused) {
            return 0;
        }
    }

    /* renamed from: a */
    static int m1848a(int i, int i2) {
        return (((i2 + MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE) / 1448) * 132) + 1080 + i + i2;
    }

    /* renamed from: a */
    static int m1849a(int i, int i2, int i3) {
        return (((i2 + 200) / 1448) * 132) + 1011 + i2 + i + i3;
    }
}
