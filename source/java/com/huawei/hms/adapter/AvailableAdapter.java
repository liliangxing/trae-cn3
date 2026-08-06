package com.huawei.hms.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.p019ui.NotInstalledHmsAdapter;
import com.huawei.hms.adapter.p019ui.UpdateAdapter;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.availableupdate.C1039c;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.note.AppSpoofResolution;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.UIUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AvailableAdapter {

    /* renamed from: a */
    private final int f974a;

    /* renamed from: b */
    private AvailableCallBack f975b;

    /* renamed from: d */
    private SystemObserver f977d = new C1013a();

    /* renamed from: c */
    private boolean f976c = false;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface AvailableCallBack {
        void onComplete(int i);
    }

    /* renamed from: com.huawei.hms.adapter.AvailableAdapter$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    class C1013a implements SystemObserver {
        C1013a() {
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onNoticeResult(int i) {
            AvailableCallBack m902a = AvailableAdapter.this.m902a();
            if (m902a == null) {
                HMSLog.m2118e("AvailableAdapter", "onNoticeResult baseCallBack null");
                return true;
            }
            m902a.onComplete(i);
            return true;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onSolutionResult(Intent intent, String str) {
            return false;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onUpdateResult(int i) {
            AvailableCallBack m902a = AvailableAdapter.this.m902a();
            if (m902a == null) {
                HMSLog.m2118e("AvailableAdapter", "onUpdateResult baseCallBack null");
                return true;
            }
            m902a.onComplete(i);
            return true;
        }
    }

    public AvailableAdapter(int i) {
        this.f974a = i;
    }

    /* renamed from: b */
    private void m906b(Context context) {
        HMSBIInitializer.getInstance(context).initBI();
    }

    public int checkHuaweiMobileServicesForUpdate(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        int m901a = m901a(context);
        if (m901a != 0 || !HMSPackageManager.getInstance(context).isApkNeedUpdate(this.f974a)) {
            return m901a;
        }
        HMSLog.m2120i("AvailableAdapter", "The current version does not meet the target version requirements");
        return 2;
    }

    public int isHuaweiMobileServicesAvailable(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        int m901a = m901a(context);
        if (m901a != 0 || !HMSPackageManager.getInstance(context).isApkUpdateNecessary(this.f974a)) {
            return m901a;
        }
        HMSLog.m2120i("AvailableAdapter", "The current version does not meet the minimum version requirements");
        return 2;
    }

    public boolean isUserNoticeError(int i) {
        return i == 29;
    }

    public boolean isUserResolvableError(int i) {
        return i == 1 || i == 2;
    }

    public void setCalledBySolutionInstallHms(boolean z) {
        this.f976c = z;
    }

    public void startNotice(Activity activity, AvailableCallBack availableCallBack) {
        if (activity == null || availableCallBack == null) {
            return;
        }
        if (UIUtil.isBackground(activity)) {
            HMSLog.m2120i("AvailableAdapter", "current app is in Background");
            availableCallBack.onComplete(28);
        } else {
            HMSLog.m2120i("AvailableAdapter", "startNotice");
            this.f975b = availableCallBack;
            SystemManager.getSystemNotifier().registerObserver(this.f977d);
            activity.startActivity(BridgeActivity.getIntentStartBridgeActivity(activity, AppSpoofResolution.class.getName()));
        }
    }

    public void startResolution(Activity activity, AvailableCallBack availableCallBack) {
        if (activity == null || availableCallBack == null) {
            return;
        }
        m906b(activity);
        if (UIUtil.isBackground(activity)) {
            HMSLog.m2120i("AvailableAdapter", "current app is in Background");
            availableCallBack.onComplete(28);
            return;
        }
        boolean m905a = m905a(activity);
        if (!AvailableUtil.isInstallerLibExist(activity) && !m905a) {
            m904a(activity, availableCallBack);
            return;
        }
        if (C1039c.f1107b.m1038b()) {
            HMSLog.m2120i("AvailableAdapter", "startResolution");
            this.f975b = availableCallBack;
            SystemManager.getSystemNotifier().registerObserver(this.f977d);
            Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, UpdateAdapter.class.getName());
            intentStartBridgeActivity.putExtra(CommonCode.MapKey.UPDATE_VERSION, this.f974a);
            if (this.f976c) {
                intentStartBridgeActivity.putExtra("installHMS", "installHMS");
            }
            intentStartBridgeActivity.putExtra(CommonCode.MapKey.NEW_UPDATE, m905a);
            activity.startActivity(intentStartBridgeActivity);
        }
    }

    /* renamed from: a */
    private int m901a(Context context) {
        if (HMSPackageManager.getInstance(context).isUseOldCertificate()) {
            HMSLog.m2118e("AvailableAdapter", "The CP uses the old certificate to terminate the connection.");
            return 13;
        }
        PackageManagerHelper.PackageStates hMSPackageStatesForMultiService = HMSPackageManager.getInstance(context).getHMSPackageStatesForMultiService();
        if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(hMSPackageStatesForMultiService)) {
            HMSLog.m2120i("AvailableAdapter", "HMS is not installed");
            return 1;
        }
        if (PackageManagerHelper.PackageStates.SPOOF.equals(hMSPackageStatesForMultiService)) {
            HMSLog.m2120i("AvailableAdapter", "HMS is spoofed");
            return 29;
        }
        if (!PackageManagerHelper.PackageStates.DISABLED.equals(hMSPackageStatesForMultiService)) {
            return 0;
        }
        HMSLog.m2120i("AvailableAdapter", "HMS is disabled");
        return 3;
    }

    /* renamed from: a */
    private void m904a(Activity activity, AvailableCallBack availableCallBack) {
        HMSLog.m2120i("AvailableAdapter", "<showHmsApkNotInstalledDialog> startResolution");
        if (NotInstalledHmsAdapter.getShowLock()) {
            this.f975b = availableCallBack;
            SystemManager.getSystemNotifier().registerObserver(this.f977d);
            activity.startActivity(BridgeActivity.getIntentStartBridgeActivity(activity, NotInstalledHmsAdapter.class.getName()));
            return;
        }
        availableCallBack.onComplete(31);
    }

    /* renamed from: a */
    private boolean m905a(Activity activity) {
        if (HMSPackageManager.getInstance(activity).isUpdateHmsForThirdPartyDevice() || HMSPackageManager.getInstance(activity).getHmsVersionCode() < 40000000) {
            return false;
        }
        HMSLog.m2120i("AvailableAdapter", "enter 4.0 HmsCore upgrade process");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public AvailableCallBack m902a() {
        return this.f975b;
    }
}
