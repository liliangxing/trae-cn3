package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.vmsdk.inspector_new.server.websocket.Utf8Charset;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.util.HiAnalyticTools;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.C1240a;
import com.huawei.hms.stats.HiAnalyticsOfCpUtils;
import com.huawei.hms.stats.HianalyticsExist;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.AnalyticsSwitchHolder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HiAnalyticsUtils {

    /* renamed from: c */
    private static final Object f1807c = new Object();

    /* renamed from: d */
    private static final Object f1808d = new Object();

    /* renamed from: e */
    private static HiAnalyticsUtils f1809e;

    /* renamed from: a */
    private int f1810a = 0;

    /* renamed from: b */
    private final boolean f1811b = HianalyticsExist.isHianalyticsExist();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.support.hianalytics.HiAnalyticsUtils$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class RunnableC1257a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f1812a;

        /* renamed from: b */
        final /* synthetic */ String f1813b;

        /* renamed from: c */
        final /* synthetic */ Map f1814c;

        RunnableC1257a(Context context, String str, Map map) {
            this.f1812a = context;
            this.f1813b = str;
            this.f1814c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onEvent(this.f1812a, this.f1813b, this.f1814c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.support.hianalytics.HiAnalyticsUtils$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class RunnableC1258b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f1816a;

        /* renamed from: b */
        final /* synthetic */ String f1817b;

        /* renamed from: c */
        final /* synthetic */ String f1818c;

        RunnableC1258b(Context context, String str, String str2) {
            this.f1816a = context;
            this.f1817b = str;
            this.f1818c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onEvent2(this.f1816a, this.f1817b, this.f1818c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.support.hianalytics.HiAnalyticsUtils$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class RunnableC1259c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f1820a;

        /* renamed from: b */
        final /* synthetic */ String f1821b;

        /* renamed from: c */
        final /* synthetic */ Map f1822c;

        RunnableC1259c(Context context, String str, Map map) {
            this.f1820a = context;
            this.f1821b = str;
            this.f1822c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onNewEvent(this.f1820a, this.f1821b, this.f1822c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.support.hianalytics.HiAnalyticsUtils$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class RunnableC1260d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f1824a;

        /* renamed from: b */
        final /* synthetic */ String f1825b;

        /* renamed from: c */
        final /* synthetic */ Map f1826c;

        /* renamed from: d */
        final /* synthetic */ int f1827d;

        RunnableC1260d(Context context, String str, Map map, int i) {
            this.f1824a = context;
            this.f1825b = str;
            this.f1826c = map;
            this.f1827d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onNewEvent(this.f1824a, this.f1825b, this.f1826c, this.f1827d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.support.hianalytics.HiAnalyticsUtils$e */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class RunnableC1261e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f1829a;

        /* renamed from: b */
        final /* synthetic */ String f1830b;

        /* renamed from: c */
        final /* synthetic */ Map f1831c;

        RunnableC1261e(Context context, String str, Map map) {
            this.f1829a = context;
            this.f1830b = str;
            this.f1831c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onReport(this.f1829a, this.f1830b, this.f1831c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.support.hianalytics.HiAnalyticsUtils$f */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class RunnableC1262f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f1833a;

        /* renamed from: b */
        final /* synthetic */ String f1834b;

        /* renamed from: c */
        final /* synthetic */ Map f1835c;

        /* renamed from: d */
        final /* synthetic */ int f1836d;

        RunnableC1262f(Context context, String str, Map map, int i) {
            this.f1833a = context;
            this.f1834b = str;
            this.f1835c = map;
            this.f1836d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onReport(this.f1833a, this.f1834b, this.f1835c, this.f1836d);
        }
    }

    private HiAnalyticsUtils() {
    }

    /* renamed from: a */
    private static LinkedHashMap<String, String> m2099a(Map<String, String> map) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    /* renamed from: b */
    private void m2105b(Context context) {
        synchronized (f1808d) {
            int i = this.f1810a;
            if (i < 60) {
                this.f1810a = i + 1;
            } else {
                this.f1810a = 0;
                if (!this.f1811b) {
                    HmsHiAnalyticsUtils.onReport();
                } else {
                    HiAnalyticsOfCpUtils.onReport(context, 0);
                    HiAnalyticsOfCpUtils.onReport(context, 1);
                }
            }
        }
    }

    /* renamed from: c */
    private void m2109c(Context context, String str, Map map) {
        try {
            C1240a.m2058c().m2060a(new RunnableC1261e(context.getApplicationContext(), str, map));
        } catch (Throwable th) {
            HMSLog.m2118e("HiAnalyticsUtils", "<addOnReportToCache> failed. " + th.getMessage());
        }
    }

    public static HiAnalyticsUtils getInstance() {
        HiAnalyticsUtils hiAnalyticsUtils;
        synchronized (f1807c) {
            if (f1809e == null) {
                f1809e = new HiAnalyticsUtils();
            }
            hiAnalyticsUtils = f1809e;
        }
        return hiAnalyticsUtils;
    }

    public static String versionCodeToName(String str) {
        if (!TextUtils.isEmpty(str) && (str.length() == 8 || str.length() == 9)) {
            try {
                Integer.parseInt(str);
                return Integer.parseInt(str.substring(0, str.length() - 7)) + "." + Integer.parseInt(str.substring(str.length() - 7, str.length() - 5)) + "." + Integer.parseInt(str.substring(str.length() - 5, str.length() - 3)) + "." + Integer.parseInt(str.substring(str.length() - 3));
            } catch (NumberFormatException unused) {
            }
        }
        return "";
    }

    public void enableLog(Context context) {
        HMSLog.m2120i("HiAnalyticsUtils", "Enable Log");
        if (!this.f1811b) {
            HmsHiAnalyticsUtils.enableLog();
        } else {
            HiAnalyticTools.enableLog(context);
        }
    }

    public boolean getInitFlag() {
        if (!this.f1811b) {
            return HmsHiAnalyticsUtils.getInitFlag();
        }
        return HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
    }

    public int getOobeAnalyticsState(Context context) {
        if (context == null) {
            return 0;
        }
        int m2098a = m2098a(context);
        if (m2098a == 1) {
            return m2098a;
        }
        Bundle bundle = new Bundle();
        bundle.putString("hms_cp_bundle_key", "content://com.huawei.hms.contentprovider/com.huawei.hms.privacy.HmsAnalyticsStateProvider");
        try {
            Bundle call = context.getApplicationContext().getContentResolver().call(Uri.parse("content://com.huawei.hms.contentprovider"), "getAnalyticsState", (String) null, bundle);
            if (call == null) {
                return m2098a;
            }
            m2098a = call.getInt("SWITCH_IS_CHECKED");
            HMSLog.m2120i("HiAnalyticsUtils", "get hms analyticsOobe state " + m2098a);
            return m2098a;
        } catch (IllegalArgumentException unused) {
            HMSLog.m2120i("HiAnalyticsUtils", "getOobeAnalyticsState IllegalArgumentException ");
            return m2098a;
        } catch (SecurityException unused2) {
            HMSLog.m2120i("HiAnalyticsUtils", "getOobeAnalyticsState SecurityException ");
            return m2098a;
        } catch (Exception unused3) {
            HMSLog.m2120i("HiAnalyticsUtils", "getOobeAnalyticsState Exception ");
            return m2098a;
        }
    }

    public boolean hasError(Context context) {
        return AnalyticsSwitchHolder.isAnalyticsDisabled(context);
    }

    public void onBuoyEvent(Context context, String str, String str2) {
        onEvent2(context, str, str2);
    }

    public void onEvent(Context context, String str, Map<String, String> map) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map != null && !map.isEmpty() && context != null) {
            boolean initFlag = getInitFlag();
            if (m2104a(initFlag, andRefreshAnalyticsState != 2, map)) {
                m2101a(context, str, map);
            }
            if (andRefreshAnalyticsState == 1 && initFlag) {
                if (!this.f1811b) {
                    HmsHiAnalyticsUtils.onEvent(0, str, m2099a(map));
                    HmsHiAnalyticsUtils.onEvent(1, str, m2099a(map));
                } else {
                    HiAnalyticsOfCpUtils.onEvent(context, 0, str, m2099a(map));
                    HiAnalyticsOfCpUtils.onEvent(context, 1, str, m2099a(map));
                }
                m2105b(context);
                return;
            }
            return;
        }
        HMSLog.m2118e("HiAnalyticsUtils", "<onEvent> map or context is null, state: " + andRefreshAnalyticsState);
    }

    public void onEvent2(Context context, String str, String str2) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (context == null) {
            HMSLog.m2118e("HiAnalyticsUtils", "<onEvent2> context is null, state: " + andRefreshAnalyticsState);
            return;
        }
        boolean initFlag = getInitFlag();
        if (!initFlag && andRefreshAnalyticsState != 2 && m2103a(str2)) {
            m2100a(context, str, str2);
        }
        if (andRefreshAnalyticsState == 1 && initFlag) {
            if (!this.f1811b) {
                HmsHiAnalyticsUtils.onEvent(context, str, str2);
            } else {
                HiAnalyticsOfCpUtils.onEvent(context, str, str2);
            }
        }
    }

    public void onNewEvent(Context context, String str, Map map) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map != null && !map.isEmpty() && context != null) {
            boolean initFlag = getInitFlag();
            if (m2104a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
                m2106b(context, str, map);
            }
            if (andRefreshAnalyticsState == 1 && initFlag) {
                if (!this.f1811b) {
                    HmsHiAnalyticsUtils.onEvent(0, str, m2099a((Map<String, String>) map));
                    HmsHiAnalyticsUtils.onEvent(1, str, m2099a((Map<String, String>) map));
                } else {
                    HiAnalyticsOfCpUtils.onEvent(context, 0, str, m2099a((Map<String, String>) map));
                    HiAnalyticsOfCpUtils.onEvent(context, 1, str, m2099a((Map<String, String>) map));
                }
                m2105b(context);
                return;
            }
            return;
        }
        HMSLog.m2118e("HiAnalyticsUtils", "<onNewEvent> map or context is null, state: " + andRefreshAnalyticsState);
    }

    public void onReport(Context context, String str, Map map) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map != null && !map.isEmpty() && context != null) {
            boolean initFlag = getInitFlag();
            if (m2104a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
                m2109c(context, str, map);
            }
            if (andRefreshAnalyticsState == 1 && initFlag) {
                if (!this.f1811b) {
                    HmsHiAnalyticsUtils.onStreamEvent(0, str, m2099a((Map<String, String>) map));
                    HmsHiAnalyticsUtils.onStreamEvent(1, str, m2099a((Map<String, String>) map));
                    return;
                } else {
                    HiAnalyticsOfCpUtils.onStreamEvent(context, 0, str, m2099a((Map<String, String>) map));
                    HiAnalyticsOfCpUtils.onStreamEvent(context, 1, str, m2099a((Map<String, String>) map));
                    return;
                }
            }
            return;
        }
        HMSLog.m2118e("HiAnalyticsUtils", "<onReport> map or context is null, state: " + andRefreshAnalyticsState);
    }

    public void enableLog() {
        HMSLog.m2120i("HiAnalyticsUtils", "Enable Log");
        if (!this.f1811b) {
            HmsHiAnalyticsUtils.enableLog();
        } else {
            HMSLog.m2120i("HiAnalyticsUtils", "cp needs to pass in the context, this method is not supported");
        }
    }

    /* renamed from: a */
    private int m2098a(Context context) {
        int i = 0;
        try {
            i = Settings.Secure.getInt(context.getContentResolver(), "hw_app_analytics_state");
            HMSLog.m2120i("HiAnalyticsUtils", "getOobeStateForSettings value is " + i);
            return i;
        } catch (Settings.SettingNotFoundException e) {
            HMSLog.m2120i("HiAnalyticsUtils", "Settings.SettingNotFoundException " + e.getMessage());
            return i;
        }
    }

    /* renamed from: a */
    private boolean m2104a(boolean z, boolean z2, Map<?, ?> map) {
        return !z && z2 && m2108b(map);
    }

    /* renamed from: a */
    private boolean m2103a(String str) {
        if (str == null) {
            return false;
        }
        try {
            return str.getBytes(Charset.forName(Utf8Charset.NAME)).length <= 512;
        } catch (Throwable th) {
            HMSLog.m2118e("HiAnalyticsUtils", "<isValidSize String> Exception: " + th.getMessage());
            return false;
        }
    }

    /* renamed from: b */
    private boolean m2108b(Map<?, ?> map) {
        try {
            Iterator<?> it = map.values().iterator();
            long j = 0;
            while (it.hasNext()) {
                if (it.next() instanceof String) {
                    j += ((String) r3).getBytes(Charset.forName(Utf8Charset.NAME)).length;
                }
            }
            return j <= 512;
        } catch (Throwable th) {
            HMSLog.m2118e("HiAnalyticsUtils", "<isValidSize map> Exception: " + th.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    private void m2101a(Context context, String str, Map<String, String> map) {
        try {
            C1240a.m2058c().m2060a(new RunnableC1257a(context.getApplicationContext(), str, map));
        } catch (Throwable th) {
            HMSLog.m2118e("HiAnalyticsUtils", "<addOnEventToCache> failed. " + th.getMessage());
        }
    }

    /* renamed from: b */
    private void m2106b(Context context, String str, Map map) {
        try {
            C1240a.m2058c().m2060a(new RunnableC1259c(context.getApplicationContext(), str, map));
        } catch (Throwable th) {
            HMSLog.m2118e("HiAnalyticsUtils", "<addOnNewEventToCache> failed. " + th.getMessage());
        }
    }

    public void onReport(Context context, String str, Map map, int i) {
        if (i != 0 && i != 1) {
            HMSLog.m2118e("HiAnalyticsUtils", "<onReport with type> Data reporting type is not supported");
            return;
        }
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map != null && !map.isEmpty() && context != null) {
            boolean initFlag = getInitFlag();
            if (m2104a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
                m2107b(context, str, map, i);
            }
            if (andRefreshAnalyticsState == 1 && initFlag) {
                if (!this.f1811b) {
                    HmsHiAnalyticsUtils.onStreamEvent(i, str, m2099a((Map<String, String>) map));
                    return;
                } else {
                    HiAnalyticsOfCpUtils.onStreamEvent(context, i, str, m2099a((Map<String, String>) map));
                    return;
                }
            }
            return;
        }
        HMSLog.m2118e("HiAnalyticsUtils", "<onReport with type> map or context is null, state: " + andRefreshAnalyticsState);
    }

    /* renamed from: a */
    private void m2100a(Context context, String str, String str2) {
        try {
            C1240a.m2058c().m2060a(new RunnableC1258b(context.getApplicationContext(), str, str2));
        } catch (Throwable th) {
            HMSLog.m2118e("HiAnalyticsUtils", "<addOnEvent2ToCache> Failed. " + th.getMessage());
        }
    }

    public void onNewEvent(Context context, String str, Map map, int i) {
        if (i != 0 && i != 1) {
            HMSLog.m2118e("HiAnalyticsUtils", "<onNewEvent with type> Data reporting type is not supported");
            return;
        }
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map != null && !map.isEmpty() && context != null) {
            boolean initFlag = getInitFlag();
            if (m2104a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
                m2102a(context, str, map, i);
            }
            if (andRefreshAnalyticsState == 1 && initFlag) {
                if (!this.f1811b) {
                    HmsHiAnalyticsUtils.onEvent(i, str, m2099a((Map<String, String>) map));
                } else {
                    HiAnalyticsOfCpUtils.onEvent(context, i, str, m2099a((Map<String, String>) map));
                }
                m2105b(context);
                return;
            }
            return;
        }
        HMSLog.m2118e("HiAnalyticsUtils", "<onNewEvent with type> map or context is null, state: " + andRefreshAnalyticsState);
    }

    /* renamed from: b */
    private void m2107b(Context context, String str, Map map, int i) {
        try {
            C1240a.m2058c().m2060a(new RunnableC1262f(context.getApplicationContext(), str, map, i));
        } catch (Throwable th) {
            HMSLog.m2118e("HiAnalyticsUtils", "<addOnReportToCache with type> failed. " + th.getMessage());
        }
    }

    /* renamed from: a */
    private void m2102a(Context context, String str, Map map, int i) {
        try {
            C1240a.m2058c().m2060a(new RunnableC1260d(context.getApplicationContext(), str, map, i));
        } catch (Throwable th) {
            HMSLog.m2118e("HiAnalyticsUtils", "<addOnNewEventToCache with type> failed. " + th.getMessage());
        }
    }
}
