package com.huawei.hms.update.note;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.availableupdate.C1037a;
import com.huawei.hms.p030ui.AbstractDialog;
import com.huawei.hms.p030ui.AbstractPromptDialog;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AppSpoofResolution implements IBridgeActivityDelegate {

    /* renamed from: a */
    private Activity f1849a;

    /* renamed from: b */
    private C1268b f1850b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.update.note.AppSpoofResolution$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class C1267a implements AbstractDialog.Callback {
        C1267a() {
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onCancel(AbstractDialog abstractDialog) {
            C1037a.f1100c.m1031a(true);
            AppSpoofResolution.this.f1850b = null;
            AppSpoofResolution.this.m2125a();
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onDoWork(AbstractDialog abstractDialog) {
            C1037a.f1100c.m1031a(true);
            AppSpoofResolution.this.f1850b = null;
            AppSpoofResolution.this.m2125a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.huawei.hms.update.note.AppSpoofResolution$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class C1268b extends AbstractPromptDialog {
        private C1268b() {
        }

        @Override // com.huawei.hms.p030ui.AbstractDialog
        public String onGetMessageString(Context context) {
            String applicationName = new PackageManagerHelper(context).getApplicationName("com.huawei.hwid");
            String str = TextUtils.isEmpty(applicationName) ? "com.huawei.hwid" : applicationName;
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context);
            }
            return ResourceLoaderUtil.getString("hms_is_spoof", str);
        }

        @Override // com.huawei.hms.p030ui.AbstractDialog
        public String onGetPositiveButtonString(Context context) {
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context);
            }
            return ResourceLoaderUtil.getString("hms_confirm");
        }

        @Override // com.huawei.hms.p030ui.AbstractPromptDialog, com.huawei.hms.p030ui.AbstractDialog
        public String onGetTitleString(Context context) {
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context);
            }
            return ResourceLoaderUtil.getString("hms_spoof_hints");
        }

        /* synthetic */ C1268b(C1267a c1267a) {
            this();
        }
    }

    /* renamed from: b */
    private void m2127b() {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        C1268b c1268b = this.f1850b;
        if (c1268b == null) {
            this.f1850b = new C1268b(null);
        } else {
            c1268b.dismiss();
        }
        HMSLog.m2120i("AppSpoofResolution", "enter AppSpoofResolution showPromptdlg to resolve conn error");
        this.f1850b.show(activity, new C1267a());
    }

    protected Activity getActivity() {
        return this.f1849a;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 0;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        HMSLog.m2120i("AppSpoofResolution", "enter AppSpoofResolution onBridgeActivityCreate");
        if (activity != null && !activity.isFinishing()) {
            this.f1849a = activity;
            C1037a c1037a = C1037a.f1100c;
            c1037a.m1030a(activity);
            c1037a.m1031a(false);
            m2127b();
            return;
        }
        HMSLog.m2118e("AppSpoofResolution", "activity is null or finishing");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.m2120i("AppSpoofResolution", "enter AppSpoofResolution onBridgeActivityDestroy");
        C1037a c1037a = C1037a.f1100c;
        if (c1037a.m1029a().compareAndSet(true, false)) {
            SystemManager.getInstance().notifyNoticeResult(29);
        }
        c1037a.m1032b(this.f1849a);
        this.f1849a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        if (i != getRequestCode()) {
            return false;
        }
        HMSLog.m2120i("AppSpoofResolution", "enter AppSpoofResolution onBridgeActivityResult");
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        if (this.f1850b == null) {
            return;
        }
        HMSLog.m2120i("AppSpoofResolution", "enter AppSpoofResolution re show prompt dialog");
        m2127b();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
        HMSLog.m2120i("AppSpoofResolution", "enter AppSpoofResolution On key up when resolve spoof error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2125a() {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        HMSLog.m2120i("AppSpoofResolution", "enter AppSpoofResolution finishBridgeActivity：");
        if (C1037a.f1100c.m1029a().compareAndSet(true, false)) {
            SystemManager.getInstance().notifyNoticeResult(29);
        }
        activity.finish();
    }
}
