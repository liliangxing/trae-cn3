package com.xiaomi.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1488av;
import com.xiaomi.push.C1628g;
import com.xiaomi.push.C1646gr;
import com.xiaomi.push.C1694j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.xiaomi.push.service.ac */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1745ac {

    /* renamed from: a */
    private static final boolean f2937a = Log.isLoggable("NCHelper", 3);

    /* renamed from: a */
    private static void m3587a(C1748af c1748af, NotificationChannel notificationChannel, String str) {
        int i;
        char c;
        int i2;
        Context m3638a = c1748af.m3638a();
        String id = notificationChannel.getId();
        String m3628a = C1748af.m3628a(id, c1748af.m3639a());
        boolean z = f2937a;
        if (z) {
            m3588a("appChannelId:" + id + " oldChannelId:" + m3628a);
        }
        if (C1694j.m3427a(m3638a) && !TextUtils.equals(id, m3628a)) {
            NotificationManager notificationManager = (NotificationManager) m3638a.getSystemService("notification");
            NotificationChannel notificationChannel2 = notificationManager.getNotificationChannel(m3628a);
            NotificationChannel m3637a = c1748af.m3637a(id);
            if (z) {
                m3588a("xmsfChannel:" + notificationChannel2);
                m3588a("appChannel:" + m3637a);
            }
            if (notificationChannel2 != null) {
                NotificationChannel m3580a = m3580a(id, notificationChannel2);
                if (z) {
                    m3588a("copyXmsf copyXmsfChannel:" + m3580a);
                }
                if (m3637a != null) {
                    i2 = m3579a(m3637a);
                    c1748af.m3645a(m3580a, i2 == 0);
                    c = 3;
                } else {
                    i2 = m3579a(notificationChannel2);
                    m3583a(m3638a, c1748af, m3580a, i2, notificationChannel2.getId());
                    c = 4;
                }
                m3591b(m3638a, id);
                notificationManager.deleteNotificationChannel(m3628a);
            } else if (m3637a != null) {
                if (m3590a(m3638a, id) || !m3589a(notificationChannel, m3637a)) {
                    i2 = 0;
                    c = 0;
                } else {
                    if (z) {
                        m3588a("appHack updateNotificationChannel:" + notificationChannel);
                    }
                    i2 = m3579a(m3637a);
                    c1748af.m3645a(notificationChannel, i2 == 0);
                    c = 2;
                }
            } else {
                if (z) {
                    m3588a("appHack createNotificationChannel:" + notificationChannel);
                }
                c1748af.m3644a(notificationChannel);
                c = 1;
                i2 = 0;
            }
            i = i2;
        } else {
            NotificationChannel m3637a2 = c1748af.m3637a(id);
            if (z) {
                m3588a("elseLogic getNotificationChannel:" + m3637a2);
            }
            if (m3637a2 == null) {
                c1748af.m3644a(notificationChannel);
            }
            i = 0;
            c = 0;
        }
        C1777f.m3837a(c1748af.m3638a(), c1748af.m3639a(), id, notificationChannel.getImportance(), str, c == 1 || c == 4 || c == 3, i);
    }

    /* renamed from: a */
    private static boolean m3589a(NotificationChannel notificationChannel, NotificationChannel notificationChannel2) {
        boolean z;
        if (notificationChannel == null || notificationChannel2 == null) {
            return false;
        }
        boolean z2 = true;
        if (TextUtils.equals(notificationChannel.getName(), notificationChannel2.getName())) {
            z = false;
        } else {
            if (f2937a) {
                m3588a("appHack channelConfigLowerCompare:getName");
            }
            z = true;
        }
        if (!TextUtils.equals(notificationChannel.getDescription(), notificationChannel2.getDescription())) {
            if (f2937a) {
                m3588a("appHack channelConfigLowerCompare:getDescription");
            }
            z = true;
        }
        if (notificationChannel.getImportance() != notificationChannel2.getImportance()) {
            notificationChannel.setImportance(Math.min(notificationChannel.getImportance(), notificationChannel2.getImportance()));
            if (f2937a) {
                m3588a("appHack channelConfigLowerCompare:getImportance  " + notificationChannel.getImportance() + " " + notificationChannel2.getImportance());
            }
            z = true;
        }
        if (notificationChannel.shouldVibrate() != notificationChannel2.shouldVibrate()) {
            notificationChannel.enableVibration(false);
            if (f2937a) {
                m3588a("appHack channelConfigLowerCompare:enableVibration");
            }
            z = true;
        }
        if (notificationChannel.shouldShowLights() != notificationChannel2.shouldShowLights()) {
            notificationChannel.enableLights(false);
            if (f2937a) {
                m3588a("appHack channelConfigLowerCompare:enableLights");
            }
            z = true;
        }
        if ((notificationChannel.getSound() != null) != (notificationChannel2.getSound() != null)) {
            notificationChannel.setSound(null, null);
            if (f2937a) {
                m3588a("appHack channelConfigLowerCompare:setSound");
            }
        } else {
            z2 = z;
        }
        if (f2937a) {
            m3588a("appHack channelConfigLowerCompare:isDifferent:" + z2);
        }
        return z2;
    }

    /* renamed from: a */
    private static int m3579a(NotificationChannel notificationChannel) {
        int i = 0;
        try {
            i = ((Integer) C1488av.m1577b((Object) notificationChannel, "getUserLockedFields", new Object[0])).intValue();
            if (f2937a) {
                m3588a("isUserLockedChannel:" + i + " " + notificationChannel);
            }
        } catch (Exception e) {
            AbstractC1417b.m1090a("NCHelper", "is user locked error" + e);
        }
        return i;
    }

    /* renamed from: a */
    private static NotificationChannel m3580a(String str, NotificationChannel notificationChannel) {
        NotificationChannel notificationChannel2 = new NotificationChannel(str, notificationChannel.getName(), notificationChannel.getImportance());
        notificationChannel2.setDescription(notificationChannel.getDescription());
        notificationChannel2.enableVibration(notificationChannel.shouldVibrate());
        notificationChannel2.enableLights(notificationChannel.shouldShowLights());
        notificationChannel2.setSound(notificationChannel.getSound(), notificationChannel.getAudioAttributes());
        notificationChannel2.setLockscreenVisibility(notificationChannel.getLockscreenVisibility());
        return notificationChannel2;
    }

    /* renamed from: b */
    private static void m3591b(Context context, String str) {
        if (f2937a) {
            m3588a("recordCopiedChannel:" + str);
        }
        m3581a(context).edit().putBoolean(str, true).apply();
    }

    /* renamed from: a */
    private static boolean m3590a(Context context, String str) {
        if (f2937a) {
            m3588a("checkCopeidChannel:newFullChannelId:" + str + "  " + m3581a(context).getBoolean(str, false));
        }
        return m3581a(context).getBoolean(str, false);
    }

    /* renamed from: a */
    private static void m3585a(Context context, List<String> list) {
        if (f2937a) {
            m3588a("deleteCopiedChannelRecord:" + list);
        }
        if (list.isEmpty()) {
            return;
        }
        SharedPreferences.Editor edit = m3581a(context).edit();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            edit.remove(it.next());
        }
        edit.apply();
    }

    /* renamed from: a */
    private static SharedPreferences m3581a(Context context) {
        return context.getSharedPreferences("mipush_channel_copy_sp", 0);
    }

    /* renamed from: a */
    public static String m3582a(C1748af c1748af, String str, CharSequence charSequence, String str2, int i, int i2, String str3, String str4) {
        String m3640a = c1748af.m3640a(str);
        boolean z = f2937a;
        if (z) {
            m3588a("createChannel: appChannelId:" + m3640a + " serverChannelId:" + str + " serverChannelName:" + ((Object) charSequence) + " serverChannelDesc:" + str2 + " serverChannelNotifyType:" + i + " serverChannelName:" + ((Object) charSequence) + " serverChannelImportance:" + i2 + " channelSoundStr:" + str3 + " channelPermissions:" + str4);
        }
        NotificationChannel notificationChannel = new NotificationChannel(m3640a, charSequence, i2);
        notificationChannel.setDescription(str2);
        notificationChannel.enableVibration((i & 2) != 0);
        notificationChannel.enableLights((i & 4) != 0);
        if ((i & 1) != 0) {
            if (!TextUtils.isEmpty(str3) && str3.startsWith("android.resource://" + c1748af.m3639a())) {
                notificationChannel.setSound(Uri.parse(str3), Notification.AUDIO_ATTRIBUTES_DEFAULT);
            }
        } else {
            notificationChannel.setSound(null, null);
        }
        if (z) {
            m3588a("create channel:" + notificationChannel);
        }
        m3587a(c1748af, notificationChannel, str4);
        return m3640a;
    }

    /* renamed from: a */
    private static void m3588a(String str) {
        AbstractC1417b.m1090a("NCHelper", str);
    }

    /* renamed from: a */
    public static void m3584a(Context context, String str) {
        if (!C1694j.m3427a(context) || TextUtils.isEmpty(str)) {
            return;
        }
        m3592c(context, str);
        C1777f.m3836a(context, str);
    }

    /* renamed from: c */
    private static void m3592c(Context context, String str) {
        try {
            C1748af m3625a = C1748af.m3625a(context, str);
            Set<String> keySet = m3581a(context).getAll().keySet();
            ArrayList arrayList = new ArrayList();
            for (String str2 : keySet) {
                if (m3625a.m3646a(str2)) {
                    arrayList.add(str2);
                    if (f2937a) {
                        m3588a("delete channel copy record:" + str2);
                    }
                }
            }
            m3585a(context, arrayList);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m3586a(C1646gr c1646gr) {
        if (c1646gr == null || c1646gr.f2281a == null || !c1646gr.f2281a.containsKey("REMOVE_CHANNEL_MARK")) {
            return;
        }
        c1646gr.f2277a = 0;
        c1646gr.f2281a.remove("channel_id");
        c1646gr.f2281a.remove("channel_importance");
        c1646gr.f2281a.remove("channel_name");
        c1646gr.f2281a.remove("channel_description");
        c1646gr.f2281a.remove("channel_perm");
        AbstractC1417b.m1089a("delete channel info by:" + c1646gr.f2281a.get("REMOVE_CHANNEL_MARK"));
        c1646gr.f2281a.remove("REMOVE_CHANNEL_MARK");
    }

    /* renamed from: a */
    static void m3583a(Context context, C1748af c1748af, NotificationChannel notificationChannel, int i, String str) {
        if (i > 0) {
            int m3832a = C1628g.m2676a(context) >= 2 ? C1777f.m3832a(context.getPackageName(), str) : 0;
            NotificationChannel m3580a = m3580a(notificationChannel.getId(), notificationChannel);
            if ((i & 32) != 0) {
                if (notificationChannel.getSound() != null) {
                    m3580a.setSound(null, null);
                } else {
                    m3580a.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
            }
            if ((i & 16) != 0) {
                if (notificationChannel.shouldVibrate()) {
                    m3580a.enableVibration(false);
                } else {
                    m3580a.enableVibration(true);
                }
            }
            if ((i & 8) != 0) {
                if (notificationChannel.shouldShowLights()) {
                    m3580a.enableLights(false);
                } else {
                    m3580a.enableLights(true);
                }
            }
            if ((i & 4) != 0) {
                int importance = notificationChannel.getImportance() - 1;
                if (importance <= 0) {
                    importance = 2;
                }
                m3580a.setImportance(importance);
            }
            if ((i & 2) != 0) {
                m3580a.setLockscreenVisibility(notificationChannel.getLockscreenVisibility() - 1);
            }
            c1748af.m3644a(m3580a);
            c1748af.m3645a(notificationChannel, true);
            C1777f.m3842a(c1748af.m3639a(), notificationChannel.getId(), m3832a, 0);
            return;
        }
        c1748af.m3644a(notificationChannel);
    }
}
