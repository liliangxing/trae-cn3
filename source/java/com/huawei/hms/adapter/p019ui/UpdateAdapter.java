package com.huawei.hms.adapter.p019ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.availableupdate.C1039c;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.update.p031ui.UpdateBean;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class UpdateAdapter implements IBridgeActivityDelegate {

    /* renamed from: a */
    private WeakReference<Activity> f1039a;

    /* renamed from: b */
    private Context f1040b;

    /* renamed from: c */
    private int f1041c;

    /* renamed from: d */
    private UpdateBean f1042d;

    /* renamed from: e */
    private boolean f1043e = false;

    /* renamed from: a */
    private static Object m976a(String str, String str2, Object[] objArr) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            HMSLog.m2118e("UpdateAdapter", "className is empty.");
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            HMSLog.m2118e("UpdateAdapter", "methodName is empty.");
            return null;
        }
        if (objArr == null) {
            HMSLog.m2118e("UpdateAdapter", "args is null.");
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj instanceof Activity) {
                clsArr[i] = Activity.class;
            } else if (obj instanceof Context) {
                clsArr[i] = Context.class;
            } else if (obj instanceof UpdateBean) {
                clsArr[i] = UpdateBean.class;
            } else if (obj instanceof Integer) {
                clsArr[i] = Integer.TYPE;
            } else if (obj instanceof Boolean) {
                clsArr[i] = Boolean.TYPE;
            } else {
                HMSLog.m2118e("UpdateAdapter", "not set args[" + i + "] type");
            }
        }
        Class<?> cls = Class.forName(str);
        return cls.getMethod(str2, clsArr).invoke(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), objArr);
    }

    /* renamed from: b */
    private Activity m981b() {
        WeakReference<Activity> weakReference = this.f1039a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* renamed from: c */
    private void m982c() {
        SystemManager.getInstance().notifyUpdateResult(8);
        m977a();
    }

    public static Object invokeMethod(String str, String str2, Object[] objArr) {
        try {
            return m976a(str, str2, objArr);
        } catch (Throwable th) {
            HMSLog.m2118e("UpdateAdapter", "invoke " + str + "." + str2 + " fail. " + th.getMessage());
            return null;
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1001;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        if (activity == null) {
            HMSLog.m2120i("UpdateAdapter", "activity == null");
            m982c();
            return;
        }
        if (activity.isFinishing()) {
            HMSLog.m2120i("UpdateAdapter", "activity is finishing");
            m982c();
            return;
        }
        this.f1040b = activity.getApplicationContext();
        this.f1039a = new WeakReference<>(activity);
        C1039c.f1107b.m1036a(m981b());
        Intent intent = activity.getIntent();
        if (intent == null) {
            m982c();
            return;
        }
        try {
            this.f1041c = intent.getIntExtra(CommonCode.MapKey.UPDATE_VERSION, 0);
        } catch (Throwable th) {
            HMSLog.m2118e("UpdateAdapter", "get update_version:" + th.getMessage());
        }
        if (this.f1041c == 0) {
            m982c();
            return;
        }
        if (intent.hasExtra("installHMS")) {
            this.f1043e = true;
        }
        if (m980a(intent, activity)) {
            return;
        }
        try {
            if (AvailableUtil.isInstallerLibExist(this.f1040b)) {
                UpdateBean updateBean = (UpdateBean) m976a("com.huawei.hms.adapter.ui.InstallerAdapter", "setUpdateBean", new Object[]{activity, Integer.valueOf(this.f1041c), Boolean.valueOf(this.f1043e)});
                this.f1042d = updateBean;
                m976a("com.huawei.hms.adapter.ui.InstallerAdapter", "startUpdateHms", new Object[]{activity, updateBean, 1001});
                this.f1042d = null;
            }
        } catch (Throwable th2) {
            HMSLog.m2118e("UpdateAdapter", "InstallerAdapter.startUpdateHms is failed. message：" + th2.getMessage());
            m982c();
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.m2120i("UpdateAdapter", "onBridgeActivityDestroy");
        C1039c.f1107b.m1037b(m981b());
        this.f1039a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        int i3;
        if (i != getRequestCode()) {
            this.f1042d = null;
            return false;
        }
        HMSLog.m2120i("UpdateAdapter", "onBridgeActivityResult " + i2);
        if (AvailableUtil.isInstallerLibExist(this.f1040b) && i2 == 1214) {
            HMSLog.m2120i("UpdateAdapter", "Enter update escape route");
            Activity m981b = m981b();
            if (m981b == null) {
                HMSLog.m2118e("UpdateAdapter", "bridgeActivity is null, update escape failed ");
                this.f1042d = null;
                return true;
            }
            invokeMethod("com.huawei.hms.update.manager.UpdateManager", "startUpdate", new Object[]{m981b, 1001, this.f1042d});
            this.f1042d = null;
        }
        if (i2 == -1) {
            if (intent != null) {
                try {
                    i3 = intent.getIntExtra(KpmsConstant.KIT_UPDATE_RESULT, 0);
                } catch (Throwable unused) {
                    HMSLog.m2121w("UpdateAdapter", "get kit_update_result failed, throwable occur.");
                    i3 = 0;
                }
                if (i3 == 1) {
                    HMSLog.m2120i("UpdateAdapter", "new framework update process,Error resolved successfully!");
                    SystemManager.getInstance().notifyUpdateResult(0);
                    this.f1042d = null;
                    m977a();
                    return true;
                }
                m978a(intent);
            }
        } else if (i2 == 0) {
            HMSLog.m2120i("UpdateAdapter", "Activity.RESULT_CANCELED");
            this.f1042d = null;
            Activity m981b2 = m981b();
            if (m981b2 == null) {
                return true;
            }
            String hMSPackageName = HMSPackageManager.getInstance(m981b2.getApplicationContext()).getHMSPackageName();
            if (TextUtils.isEmpty(hMSPackageName)) {
                hMSPackageName = "com.huawei.hwid";
            }
            if (!this.f1043e && !m979a(m981b2, hMSPackageName, this.f1041c)) {
                SystemManager.getInstance().notifyUpdateResult(0);
            } else {
                HMSLog.m2120i("UpdateAdapter", "Resolve error, process canceled by user clicking back button!");
                SystemManager.getInstance().notifyUpdateResult(13);
            }
        } else if (i2 == 1) {
            SystemManager.getInstance().notifyUpdateResult(28);
        }
        m977a();
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.m2120i("UpdateAdapter", "onBridgeConfigurationChanged");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
        HMSLog.m2120i("UpdateAdapter", "On key up when resolve conn error");
    }

    /* renamed from: a */
    private boolean m980a(Intent intent, Activity activity) {
        if (!intent.getBooleanExtra(CommonCode.MapKey.NEW_UPDATE, false)) {
            return false;
        }
        HMSLog.m2120i("UpdateAdapter", "4.0 framework HMSCore upgrade process");
        String hMSPackageName = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName();
        if (TextUtils.isEmpty(hMSPackageName)) {
            HMSLog.m2121w("UpdateAdapter", "hmsPackageName is empty, update invalid.");
            m982c();
            return true;
        }
        ComponentName componentName = new ComponentName(hMSPackageName, "com.huawei.hms.fwksdk.stub.UpdateStubActivity");
        Intent intent2 = new Intent();
        intent2.putExtra(KpmsConstant.CALLER_PACKAGE_NAME, activity.getApplicationContext().getPackageName());
        intent2.putExtra(KpmsConstant.UPDATE_PACKAGE_NAME, hMSPackageName);
        intent2.setComponent(componentName);
        activity.startActivityForResult(intent2, 1001);
        return true;
    }

    /* renamed from: a */
    private void m978a(Intent intent) {
        int i = -1;
        try {
            i = intent.getIntExtra(BridgeActivity.EXTRA_RESULT, -1);
        } catch (Throwable unused) {
            HMSLog.m2121w("UpdateAdapter", "get extra_result failed, throwable occur.");
        }
        if (i == 0) {
            HMSLog.m2120i("UpdateAdapter", "Error resolved successfully!");
            SystemManager.getInstance().notifyUpdateResult(0);
        } else if (i == 13) {
            HMSLog.m2120i("UpdateAdapter", "Resolve error process canceled by user!");
            SystemManager.getInstance().notifyUpdateResult(13);
        } else if (i == 8) {
            HMSLog.m2120i("UpdateAdapter", "Internal error occurred, recommended retry.");
            SystemManager.getInstance().notifyUpdateResult(8);
        } else {
            HMSLog.m2120i("UpdateAdapter", "Other error codes.");
            SystemManager.getInstance().notifyUpdateResult(i);
        }
    }

    /* renamed from: a */
    private void m977a() {
        Activity m981b = m981b();
        if (m981b == null || m981b.isFinishing()) {
            return;
        }
        m981b.finish();
    }

    /* renamed from: a */
    private boolean m979a(Context context, String str, int i) {
        if (context != null && !TextUtils.isEmpty(str) && i != 0) {
            PackageManagerHelper packageManagerHelper = new PackageManagerHelper(context);
            return PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageManagerHelper.getPackageStates(str)) || packageManagerHelper.getPackageVersionCode(str) < i;
        }
        HMSLog.m2121w("UpdateAdapter", "Please check your params, one of params is invalid.");
        return false;
    }
}
