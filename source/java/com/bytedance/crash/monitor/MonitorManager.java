package com.bytedance.crash.monitor;

import android.content.Context;
import com.bytedance.crash.Flavor;
import com.bytedance.crash.Global;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.NpthCore;
import com.bytedance.crash.UserDataCenter;
import com.bytedance.crash.event.EnsureDeliverer;
import com.bytedance.crash.runtime.DefaultWorkThread;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class MonitorManager {
    private static AppMonitor sAppMonitor;
    private static EnsureDeliverer sDeliverer;

    public static AppMonitor createInnerAppMonitor(Context context, ICommonParams iCommonParams) {
        Global.setContext(context);
        synchronized (AppMonitor.class) {
            AppMonitor appMonitor = sAppMonitor;
            if (appMonitor != null) {
                return appMonitor;
            }
            InnerAppMonitor innerAppMonitor = new InnerAppMonitor(iCommonParams);
            sAppMonitor = innerAppMonitor;
            EnsureDeliverer ensureDeliverer = sDeliverer;
            if (ensureDeliverer != null) {
                ensureDeliverer.setMonitor(innerAppMonitor);
            }
            NpthCore.initForCrashMonitor(context, Global.getRootDirectory(context));
            return sAppMonitor;
        }
    }

    public static AppMonitor createAppMonitor(Context context, String str, String str2, long j) {
        Global.setContext(context);
        synchronized (AppMonitor.class) {
            AppMonitor appMonitor = sAppMonitor;
            if (appMonitor != null) {
                return appMonitor;
            }
            AppMonitor appMonitor2 = new AppMonitor(str, str2, j);
            sAppMonitor = appMonitor2;
            EnsureDeliverer ensureDeliverer = sDeliverer;
            if (ensureDeliverer != null) {
                ensureDeliverer.setMonitor(appMonitor2);
            }
            Flavor.startAppMonitor(context, sAppMonitor);
            return sAppMonitor;
        }
    }

    public static synchronized EventMonitor createEventMonitor(Context context, String str, long j, long j2, String str2) {
        final EventMonitor eventMonitor;
        synchronized (MonitorManager.class) {
            Global.setContext(context);
            eventMonitor = new EventMonitor(str, str2, j, j2, 0L);
            NpthCore.initForEventMonitor();
            DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.monitor.MonitorManager.1
                @Override // java.lang.Runnable
                public void run() {
                    new EventConfigService(EventMonitor.this).init();
                }
            });
        }
        return eventMonitor;
    }

    public static SdkMonitor createSdkMonitor(Context context, String str, String str2, long j, String[] strArr, String[] strArr2) {
        Global.setContext(context);
        SdkMonitor sdkMonitor = new SdkMonitor(str, str2, j, strArr, strArr2);
        Flavor.startEventMonitor(context, sdkMonitor);
        return sdkMonitor;
    }

    public static AppMonitor getAppMonitor() {
        return sAppMonitor;
    }

    public static EnsureDeliverer getAppEnsureManager() {
        if (sDeliverer == null) {
            synchronized (MonitorManager.class) {
                if (sDeliverer == null) {
                    sDeliverer = new EnsureDeliverer(sAppMonitor);
                }
            }
        }
        return sDeliverer;
    }

    public static String getAppMonitorAid() {
        AppMonitor appMonitor = sAppMonitor;
        if (appMonitor != null) {
            return appMonitor.getAppId();
        }
        return null;
    }

    public static EventMonitor getCrashListenerByAid(String str) {
        return CrashListener.getCrashListenerByAid(str);
    }

    public static ArrayList<CrashListener> getCrashListenerList() {
        return CrashListener.getCrashListenerList();
    }

    public static UserDataCenter getAppMonitorUserDataCenter() {
        return AppMonitor.getDefaultUserDataCenter();
    }
}
