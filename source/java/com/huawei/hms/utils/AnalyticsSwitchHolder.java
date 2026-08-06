package com.huawei.hms.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.AndroidException;
import com.heytap.mcssdk.constant.C0878a;
import com.huawei.hms.stats.C1240a;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import java.sql.Timestamp;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AnalyticsSwitchHolder {
    public static final int ANALYTICS_DISABLED = 2;
    public static final int ANALYTICS_ENABLED = 1;

    /* renamed from: a */
    private static volatile int f1867a;

    /* renamed from: b */
    private static final Object f1868b = new Object();

    /* renamed from: c */
    private static volatile Long f1869c = 0L;

    /* renamed from: d */
    private static volatile boolean f1870d = false;

    /* renamed from: e */
    private static volatile boolean f1871e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.utils.AnalyticsSwitchHolder$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class RunnableC1270a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f1872a;

        RunnableC1270a(Context context) {
            this.f1872a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            AnalyticsSwitchHolder.m2138f(this.f1872a);
            HMSLog.m2120i("AnalyticsSwitchHolder", "getStateForHmsAnalyticsProvider");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.utils.AnalyticsSwitchHolder$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class RunnableC1271b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f1873a;

        RunnableC1271b(Context context) {
            this.f1873a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.m2120i("AnalyticsSwitchHolder", "enter setAnalyticsStateAndTimestamp");
            AnalyticsSwitchHolder.m2138f(this.f1873a);
            HMSLog.m2120i("AnalyticsSwitchHolder", "quit setAnalyticsStateAndTimestamp");
        }
    }

    /* renamed from: b */
    private static boolean m2134b(Context context) {
        Bundle bundle;
        if (context == null) {
            HMSLog.m2118e("AnalyticsSwitchHolder", "In getBiIsReportSetting, context is null.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                    return bundle.getBoolean("com.huawei.hms.client.bireport.setting");
                }
            } catch (AndroidException unused) {
                HMSLog.m2118e("AnalyticsSwitchHolder", "In getBiIsReportSetting, Failed to read meta data bi report setting.");
            } catch (RuntimeException e) {
                HMSLog.m2119e("AnalyticsSwitchHolder", "In getBiIsReportSetting, Failed to read meta data bi report setting.", e);
            }
        }
        HMSLog.m2120i("AnalyticsSwitchHolder", "In getBiIsReportSetting, configuration not found for bi report setting.");
        return false;
    }

    /* renamed from: c */
    private static void m2135c(Context context) {
        f1869c = Long.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
        new Thread(new RunnableC1270a(context), "Thread-getStateForHmsAnalyticsProvider").start();
    }

    /* renamed from: d */
    private static boolean m2136d(Context context) {
        return RegionUtils.isChinaROM(context);
    }

    /* renamed from: e */
    private static void m2137e(Context context) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if (timestamp.getTime() - f1869c.longValue() < C0878a.f520f || f1869c.longValue() <= 0) {
            return;
        }
        f1869c = Long.valueOf(timestamp.getTime());
        new Thread(new RunnableC1271b(context), "Thread-refreshOobeAnalyticsState").start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static void m2138f(Context context) {
        if (context == null) {
            HMSLog.m2118e("AnalyticsSwitchHolder", "In setAnalyticsState、, context is null.");
            return;
        }
        if (HiAnalyticsUtils.getInstance().getOobeAnalyticsState(context) == 1) {
            synchronized (f1868b) {
                f1867a = 1;
            }
            if (HiAnalyticsUtils.getInstance().getInitFlag() || f1870d) {
                return;
            }
            HMSBIInitializer.getInstance(context).initHaSDK();
            f1870d = true;
            return;
        }
        synchronized (f1868b) {
            f1867a = 2;
        }
        C1240a.m2058c().m2059a();
    }

    public static int getAndRefreshAnalyticsState(Context context) {
        int i;
        synchronized (f1868b) {
            isAnalyticsDisabled(context);
            i = f1867a;
        }
        return i;
    }

    public static boolean getBiSetting(Context context) {
        Bundle bundle;
        if (context == null) {
            HMSLog.m2118e("AnalyticsSwitchHolder", "In getBiSetting, context is null.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                    return bundle.getBoolean("com.huawei.hms.client.bi.setting");
                }
            } catch (AndroidException unused) {
                HMSLog.m2118e("AnalyticsSwitchHolder", "In getBiSetting, Failed to read meta data bisetting.");
            } catch (RuntimeException e) {
                HMSLog.m2119e("AnalyticsSwitchHolder", "In getBiSetting, Failed to read meta data bisetting.", e);
            }
        }
        HMSLog.m2120i("AnalyticsSwitchHolder", "In getBiSetting, configuration not found for bisetting.");
        return false;
    }

    public static boolean isAnalyticsDisabled(Context context) {
        synchronized (f1868b) {
            if (f1867a == 0) {
                if (context == null) {
                    return true;
                }
                if (m2134b(context)) {
                    HMSLog.m2120i("AnalyticsSwitchHolder", "Builder->biReportSetting :true");
                    f1867a = 1;
                } else if (getBiSetting(context)) {
                    HMSLog.m2120i("AnalyticsSwitchHolder", "Builder->biSetting :true");
                    f1867a = 2;
                } else if (m2136d(context)) {
                    f1867a = 1;
                } else {
                    HMSLog.m2120i("AnalyticsSwitchHolder", "not ChinaROM");
                    f1867a = 3;
                    f1871e = true;
                    m2135c(context);
                }
            } else if (f1871e) {
                m2137e(context);
            }
            return f1867a != 1;
        }
    }
}
