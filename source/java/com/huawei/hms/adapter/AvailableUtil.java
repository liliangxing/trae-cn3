package com.huawei.hms.adapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.AndroidException;
import com.huawei.hms.adapter.p019ui.UpdateAdapter;
import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.AgHmsUpdateState;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AvailableUtil {

    /* renamed from: a */
    private static final Object f979a = new Object();

    /* renamed from: b */
    private static boolean f980b;

    /* renamed from: c */
    private static boolean f981c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.adapter.AvailableUtil$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class RunnableC1014a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f982a;

        RunnableC1014a(Context context) {
            this.f982a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.m2120i("AvailableUtil", "enter asyncCheckHmsV3UpdateInfo");
            if (!AvailableUtil.isInstallerLibExist(this.f982a)) {
                AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
                HMSLog.m2118e("AvailableUtil", "asyncCheckHmsV3UpdateInfo installer is not exist");
            } else {
                UpdateAdapter.invokeMethod("com.huawei.hms.adapter.ui.InstallerAdapter", "checkHmsUpdateInfo", new Object[]{this.f982a});
                HMSLog.m2120i("AvailableUtil", "quit asyncCheckHmsV3UpdateInfo");
            }
        }
    }

    public static void asyncCheckHmsUpdateInfo(Context context) {
        if (HmsCheckedState.UNCHECKED != AgHmsUpdateState.getInstance().getCheckedState()) {
            HMSLog.m2120i("AvailableUtil", "asyncCheckHmsUpdateInfo, not need to check");
        } else {
            new Thread(new RunnableC1014a(context), "Thread-asyncCheckHmsV3UpdateInfo").start();
        }
    }

    public static boolean isInstallerLibExist(Context context) {
        Bundle bundle;
        Object obj;
        boolean z;
        if (f980b) {
            HMSLog.m2120i("AvailableUtil", "installerInit exist: " + f981c);
            return f981c;
        }
        synchronized (f979a) {
            if (!f980b) {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    HMSLog.m2118e("AvailableUtil", "In isAvailableLibExist, Failed to get 'PackageManager' instance.");
                    try {
                        Class.forName("com.huawei.hms.update.manager.UpdateManager");
                        z = true;
                    } catch (ClassNotFoundException unused) {
                        HMSLog.m2118e("AvailableUtil", "In isInstallerLibExist, Failed to find class UpdateManager.");
                    }
                } else {
                    try {
                        ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get("availableHMSCoreInstaller")) != null && String.valueOf(obj).equalsIgnoreCase("yes")) {
                            HMSLog.m2120i("AvailableUtil", "available exist: true");
                            z = true;
                        }
                    } catch (AndroidException unused2) {
                        HMSLog.m2118e("AvailableUtil", "In isInstallerLibExist, Failed to read meta data for the availableHMSCoreInstaller.");
                    } catch (RuntimeException e) {
                        HMSLog.m2119e("AvailableUtil", "In isInstallerLibExist, Failed to read meta data for the availableHMSCoreInstaller.", e);
                    }
                    z = false;
                }
                f981c = z;
                f980b = true;
            }
        }
        HMSLog.m2120i("AvailableUtil", "available exist: " + f981c);
        return f981c;
    }
}
