package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ss.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.AbstractC1695k;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.C1470ad;
import com.xiaomi.push.C1479am;
import com.xiaomi.push.C1494ba;
import com.xiaomi.push.C1628g;
import com.xiaomi.push.C1646gr;
import com.xiaomi.push.C1659hd;
import com.xiaomi.push.C1682i;
import com.xiaomi.push.C1694j;
import com.xiaomi.push.C1804y;
import com.xiaomi.push.EnumC1633ge;
import com.xiaomi.push.EnumC1638gj;
import com.xiaomi.push.EnumC1643go;
import com.xiaomi.push.service.C1750ah;
import com.xiaomi.push.service.C1752aj;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.xiaomi.mipush.sdk.w */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1464w {
    /* renamed from: a */
    public static void m1427a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        long j = sharedPreferences.getLong("last_sync_info", -1L);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long m3678a = C1750ah.m3674a(context).m3678a(EnumC1638gj.SyncInfoFrequency.m2760a(), AVMDLDataLoaderConfigure.DEFAULT_MAX_CACHE_AGE);
        if (j == -1) {
            sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
        } else if (Math.abs(currentTimeMillis - j) > m3678a) {
            m1429a(context, true);
            sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
        }
    }

    /* renamed from: a */
    public static void m1429a(final Context context, final boolean z) {
        C1470ad.m1444a(context).m1449a(new Runnable() { // from class: com.xiaomi.mipush.sdk.w.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractC1417b.m1089a("do sync info");
                C1659hd c1659hd = new C1659hd(C1752aj.m3692a(), false);
                C1443b m1222a = C1443b.m1222a(context);
                c1659hd.m3064c(EnumC1643go.SyncInfo.f2208a);
                c1659hd.m3060b(m1222a.m1226a());
                c1659hd.m3068d(context.getPackageName());
                c1659hd.f2473a = new HashMap();
                Map<String, String> map = c1659hd.f2473a;
                Context context2 = context;
                AbstractC1695k.m3442a(map, "app_version", C1628g.m2683a(context2, context2.getPackageName()));
                Map<String, String> map2 = c1659hd.f2473a;
                Context context3 = context;
                AbstractC1695k.m3442a(map2, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(C1628g.m2677a(context3, context3.getPackageName())));
                AbstractC1695k.m3442a(c1659hd.f2473a, "push_sdk_vn", BuildConfig.VERSION_NAME);
                AbstractC1695k.m3442a(c1659hd.f2473a, "push_sdk_vc", Integer.toString(BuildConfig.VERSION_CODE));
                AbstractC1695k.m3442a(c1659hd.f2473a, "token", m1222a.m1236b());
                if (!C1694j.m3437d()) {
                    String m1625a = C1494ba.m1625a(C1682i.m3394c(context));
                    String m3398e = C1682i.m3398e(context);
                    if (!TextUtils.isEmpty(m3398e)) {
                        m1625a = m1625a + Constants.ACCEPT_TIME_SEPARATOR_SP + m3398e;
                    }
                    if (!TextUtils.isEmpty(m1625a)) {
                        AbstractC1695k.m3442a(c1659hd.f2473a, Constants.EXTRA_KEY_IMEI_MD5, m1625a);
                    }
                }
                C1479am.m1501a(context).m1504a(c1659hd.f2473a);
                AbstractC1695k.m3442a(c1659hd.f2473a, Constants.EXTRA_KEY_REG_ID, m1222a.m1241c());
                AbstractC1695k.m3442a(c1659hd.f2473a, Constants.EXTRA_KEY_REG_SECRET, m1222a.m1243d());
                AbstractC1695k.m3442a(c1659hd.f2473a, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(context).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, Constants.ACCEPT_TIME_SEPARATOR_SERVER));
                if (z) {
                    AbstractC1695k.m3442a(c1659hd.f2473a, Constants.EXTRA_KEY_ALIASES_MD5, C1464w.m1431c(MiPushClient.getAllAlias(context)));
                    AbstractC1695k.m3442a(c1659hd.f2473a, Constants.EXTRA_KEY_TOPICS_MD5, C1464w.m1431c(MiPushClient.getAllTopic(context)));
                    AbstractC1695k.m3442a(c1659hd.f2473a, Constants.EXTRA_KEY_ACCOUNTS_MD5, C1464w.m1431c(MiPushClient.getAllUserAccount(context)));
                } else {
                    AbstractC1695k.m3442a(c1659hd.f2473a, Constants.EXTRA_KEY_ALIASES, C1464w.m1432d(MiPushClient.getAllAlias(context)));
                    AbstractC1695k.m3442a(c1659hd.f2473a, Constants.EXTRA_KEY_TOPICS, C1464w.m1432d(MiPushClient.getAllTopic(context)));
                    AbstractC1695k.m3442a(c1659hd.f2473a, Constants.EXTRA_KEY_ACCOUNTS, C1464w.m1432d(MiPushClient.getAllUserAccount(context)));
                }
                C1462u.m1373a(context).m1407a((C1462u) c1659hd, EnumC1633ge.Notification, false, (C1646gr) null);
            }
        });
    }

    /* renamed from: a */
    public static void m1428a(Context context, C1659hd c1659hd) {
        AbstractC1417b.m1089a("need to update local info with: " + c1659hd.m3053a());
        String str = c1659hd.m3053a().get(Constants.EXTRA_KEY_ACCEPT_TIME);
        if (str != null) {
            MiPushClient.removeAcceptTime(context);
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split.length == 2) {
                MiPushClient.addAcceptTime(context, split[0], split[1]);
                if ("00:00".equals(split[0]) && "00:00".equals(split[1])) {
                    C1443b.m1222a(context).m1232a(true);
                } else {
                    C1443b.m1222a(context).m1232a(false);
                }
            }
        }
        String str2 = c1659hd.m3053a().get(Constants.EXTRA_KEY_ALIASES);
        if (str2 != null) {
            MiPushClient.removeAllAliases(context);
            if (!"".equals(str2)) {
                for (String str3 : str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    MiPushClient.addAlias(context, str3);
                }
            }
        }
        String str4 = c1659hd.m3053a().get(Constants.EXTRA_KEY_TOPICS);
        if (str4 != null) {
            MiPushClient.removeAllTopics(context);
            if (!"".equals(str4)) {
                for (String str5 : str4.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    MiPushClient.addTopic(context, str5);
                }
            }
        }
        String str6 = c1659hd.m3053a().get(Constants.EXTRA_KEY_ACCOUNTS);
        if (str6 != null) {
            MiPushClient.removeAllAccounts(context);
            if ("".equals(str6)) {
                return;
            }
            for (String str7 : str6.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                MiPushClient.addAccount(context, str7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static String m1431c(List<String> list) {
        String m1625a = C1494ba.m1625a(m1432d(list));
        return (TextUtils.isEmpty(m1625a) || m1625a.length() <= 4) ? "" : m1625a.substring(0, 4).toLowerCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static String m1432d(List<String> list) {
        String str = "";
        if (C1804y.m4119a(list)) {
            return "";
        }
        ArrayList<String> arrayList = new ArrayList(list);
        Collections.sort(arrayList, Collator.getInstance(Locale.CHINA));
        for (String str2 : arrayList) {
            if (!TextUtils.isEmpty(str)) {
                str = str + Constants.ACCEPT_TIME_SEPARATOR_SP;
            }
            str = str + str2;
        }
        return str;
    }
}
