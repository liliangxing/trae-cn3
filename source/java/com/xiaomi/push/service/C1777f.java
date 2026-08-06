package com.xiaomi.push.service;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1488av;
import com.xiaomi.push.C1694j;
import com.xiaomi.push.C1702q;
import com.xiaomi.push.C1703r;
import com.xiaomi.push.service.C1749ag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.service.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1777f {

    /* renamed from: a */
    private static final SparseArray<C1749ag.a<String, String, String>> f3144a;

    /* renamed from: a */
    private static final int[] f3145a = {1, 2, 4, 8, 16};

    /* renamed from: b */
    private static final SparseArray<Integer> f3146b;

    /* renamed from: a */
    private static boolean m3844a(int i, int i2) {
        return i >= 4 || (i2 & 2) > 0 || (i2 & 1) > 0 || (i2 & 8) > 0 || (i2 & 16) > 0;
    }

    static {
        int i = 5;
        f3144a = new SparseArray<C1749ag.a<String, String, String>>(i) { // from class: com.xiaomi.push.service.f.1
            {
                put(1, C1749ag.f2963b);
                put(2, C1749ag.f2964c);
                put(4, C1749ag.f2965d);
                put(8, C1749ag.f2967f);
                put(16, C1749ag.f2966e);
            }
        };
        f3146b = new SparseArray<Integer>(i) { // from class: com.xiaomi.push.service.f.2
            {
                put(1, 32);
                put(2, 16);
                put(4, 8);
                put(8, 4);
                put(16, 2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m3832a(String str, String str2) {
        int i = m3845a(str, str2, 8) ? 8 : 0;
        if (m3845a(str, str2, 16)) {
            i |= 16;
        }
        if (m3845a(str, str2, 1)) {
            i |= 1;
        }
        if (m3845a(str, str2, 2)) {
            i |= 2;
        }
        return m3845a(str, str2, 4) ? i | 4 : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m3837a(Context context, String str, String str2, int i, String str3, boolean z, int i2) {
        if (C1694j.m3427a(context) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            int m3472a = C1703r.m3472a(str3, 0);
            boolean m3844a = m3844a(i, m3472a);
            if (z) {
                m3842a(str, str2, m3472a, i2);
                if (m3844a) {
                    synchronized (C1777f.class) {
                        m3838a(m3834a(context), m3472a, str2);
                    }
                    return;
                }
                return;
            }
            synchronized (C1777f.class) {
                SharedPreferences m3834a = m3834a(context);
                if (m3844a || m3834a.contains(str2)) {
                    m3839a(m3834a, m3472a, str, str2, i2);
                    if (m3844a) {
                        m3838a(m3834a, m3472a, str2);
                    } else {
                        m3840a(m3834a, str2);
                    }
                }
            }
            return;
        }
        if (C1694j.m3427a(context)) {
            AbstractC1417b.m1089a("ChannelPC: can`t setup permission with permissionCode:" + String.valueOf(str3) + " channelId:" + String.valueOf(str2) + " targetPkg:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m3836a(Context context, String str) {
        List<NotificationChannel> m3641a;
        if (!C1694j.m3427a(context) || TextUtils.isEmpty(str) || (m3641a = C1748af.m3625a(context, str).m3641a()) == null) {
            return;
        }
        synchronized (C1777f.class) {
            SharedPreferences m3834a = m3834a(context);
            ArrayList arrayList = new ArrayList();
            Iterator<NotificationChannel> it = m3641a.iterator();
            while (it.hasNext()) {
                String str2 = (String) C1488av.m1567a(it.next(), "mId");
                if (!TextUtils.isEmpty(str2) && m3834a.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            if (arrayList.size() > 0) {
                m3841a(m3834a, arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m3842a(String str, String str2, int i, int i2) {
        for (int i3 : f3145a) {
            if ((f3146b.get(i3).intValue() & i2) == 0) {
                m3843a(str, str2, i3, (i & i3) > 0);
            } else {
                AbstractC1417b.m1089a("ChannelPermissions.grantPermission:" + str + Constants.COLON_SEPARATOR + str2 + ": <" + i3 + "> :stoped by userLock");
            }
        }
    }

    /* renamed from: a */
    private static void m3843a(String str, String str2, int i, boolean z) {
        AbstractC1417b.m1089a("ChannelPermissions.grantPermission:" + str + Constants.COLON_SEPARATOR + str2 + ": <" + i + "=" + z + "> :" + C1749ag.m3668a(C1702q.m3462a(), str, str2, f3144a.get(i), z));
    }

    /* renamed from: a */
    public static int m3833a(String str, String str2, int i) {
        return C1749ag.m3652a(C1702q.m3462a(), str, str2, f3144a.get(i));
    }

    /* renamed from: a */
    public static Bundle m3835a(String str, String str2) {
        return C1749ag.m3653a(C1702q.m3462a(), str, str2);
    }

    /* renamed from: a */
    private static boolean m3845a(String str, String str2, int i) {
        boolean z = C1749ag.m3652a(C1702q.m3462a(), str, str2, f3144a.get(i)) == 1;
        AbstractC1417b.m1089a("ChannelPermissions.checkPermission:" + str + Constants.COLON_SEPARATOR + str2 + ": <" + i + "=" + z + ">");
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0080, code lost:
    
        if (r1 == 0) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0091  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m3830a(Context context, String str, NotificationChannel notificationChannel) {
        int m3833a;
        if (Build.VERSION.SDK_INT >= 26 && context != null && !TextUtils.isEmpty(str) && notificationChannel != null) {
            int i = (notificationChannel.getImportance() != 0 ? 1 : 2) | 0;
            if (C1749ag.m3665a()) {
                Bundle m3835a = m3835a(str, notificationChannel.getId());
                if (m3835a.containsKey(C1749ag.f2967f.f2972c)) {
                    i |= (!m3835a.getBoolean(C1749ag.f2967f.f2972c) || notificationChannel.getImportance() < 4) ? 8 : 4;
                }
                if (m3835a.containsKey(C1749ag.f2966e.f2972c)) {
                    i |= m3835a.getBoolean(C1749ag.f2966e.f2972c) ? 16 : 32;
                }
            } else {
                int m3833a2 = m3833a(str, notificationChannel.getId(), 8);
                if (m3833a2 == 1) {
                    if (notificationChannel.getImportance() >= 4) {
                        i |= 4;
                        m3833a = m3833a(str, notificationChannel.getId(), 16);
                        if (m3833a != 1) {
                            i |= 16;
                        } else if (m3833a == 0) {
                            i |= 32;
                        }
                    }
                    i |= 8;
                    m3833a = m3833a(str, notificationChannel.getId(), 16);
                    if (m3833a != 1) {
                    }
                }
            }
            return (notificationChannel.getSound() != null ? i | 64 : i | 128) | (notificationChannel.shouldVibrate() ? 256 : 512);
        }
        AbstractC1417b.m1089a("context|packageName|channel must not be null ");
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0040, code lost:
    
        if (r1 == 0) goto L21;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m3831a(Context context, String str, String str2) {
        int i;
        if (Build.VERSION.SDK_INT >= 26 && context != null && !TextUtils.isEmpty(str)) {
            C1748af m3625a = C1748af.m3625a(context, str);
            if (m3625a != null) {
                NotificationChannel m3637a = m3625a.m3637a(m3625a.m3640a(str2));
                if (m3637a != null) {
                    int i2 = (m3637a.getImportance() != 0 ? 1 : 2) | 0;
                    int m3833a = m3833a(str, m3637a.getId(), 8);
                    if (m3833a == 1) {
                        if (m3637a.getImportance() >= 4) {
                            i2 |= 4;
                        }
                        i2 |= 8;
                    }
                    int m3833a2 = m3833a(str, m3637a.getId(), 16);
                    if (m3833a2 == 1) {
                        i = i2 | 16;
                    } else {
                        if (m3833a2 != 0) {
                            return i2;
                        }
                        i = i2 | 32;
                    }
                    return i;
                }
                AbstractC1417b.m1089a("Channel must not be null");
                return 0;
            }
            AbstractC1417b.m1089a("create NMHelper error");
            return 0;
        }
        AbstractC1417b.m1089a("Must greater than or equal android O and context|packageName not be null");
        return 0;
    }

    /* renamed from: a */
    private static void m3839a(SharedPreferences sharedPreferences, int i, String str, String str2, int i2) {
        if (sharedPreferences.getInt(str2, 0) != i) {
            m3842a(str, str2, i, i2);
        }
    }

    /* renamed from: a */
    private static void m3838a(SharedPreferences sharedPreferences, int i, String str) {
        sharedPreferences.edit().putInt(str, i).commit();
    }

    /* renamed from: a */
    private static void m3840a(SharedPreferences sharedPreferences, String str) {
        m3841a(sharedPreferences, new ArrayList<String>(str) { // from class: com.xiaomi.push.service.f.3

            /* renamed from: a */
            final /* synthetic */ String f3147a;

            {
                this.f3147a = str;
                add(str);
            }
        });
    }

    /* renamed from: a */
    private static void m3841a(SharedPreferences sharedPreferences, List<String> list) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            edit.remove(it.next());
        }
        edit.commit();
    }

    /* renamed from: a */
    private static SharedPreferences m3834a(Context context) {
        return context.getSharedPreferences("ch_permission_cache_file", 0);
    }
}
