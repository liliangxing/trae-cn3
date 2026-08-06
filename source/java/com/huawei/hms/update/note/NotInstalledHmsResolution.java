package com.huawei.hms.update.note;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.availableupdate.C1038b;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.p031ui.NotInstalledHmsDialogHelper;
import com.huawei.hms.utils.UIUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class NotInstalledHmsResolution implements IBridgeActivityDelegate {

    /* renamed from: a */
    private Dialog f1852a;

    /* renamed from: b */
    private Activity f1853b;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.huawei.hms.update.note.NotInstalledHmsResolution$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class DialogInterfaceOnClickListenerC1269a implements DialogInterface.OnClickListener {

        /* renamed from: a */
        private final Activity f1854a;

        public DialogInterfaceOnClickListenerC1269a(Activity activity) {
            this.f1854a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            HMSLog.m2120i("NotInstalledHmsResolution", "<Dialog onClick>");
            this.f1854a.finish();
        }
    }

    /* renamed from: a */
    private void m2129a(Activity activity) {
        m2128a();
        AlertDialog create = NotInstalledHmsDialogHelper.getDialogBuilder(activity).setPositiveButton(NotInstalledHmsDialogHelper.getConfirmResId(activity), new DialogInterfaceOnClickListenerC1269a(activity)).create();
        this.f1852a = create;
        UIUtil.enableFocusedForButtonsInTV(create);
        this.f1852a.show();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        HMSLog.m2120i("NotInstalledHmsResolution", "<Resolution getRequestCode>");
        return 0;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        HMSLog.m2120i("NotInstalledHmsResolution", "<Resolution onBridgeActivityCreate>");
        if (activity != null && !activity.isFinishing()) {
            this.f1853b = activity;
            C1038b.f1104b.m1033a(activity);
            m2129a(activity);
            return;
        }
        HMSLog.m2118e("NotInstalledHmsResolution", "<Resolution onBridgeActivityCreate> activity is null or finishing");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.m2120i("NotInstalledHmsResolution", "<Resolution onBridgeActivityDestroy>");
        m2128a();
        C1038b.f1104b.m1034b(this.f1853b);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        HMSLog.m2120i("NotInstalledHmsResolution", "<Resolution onBridgeActivityResult>");
        return false;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.m2120i("NotInstalledHmsResolution", "<Resolution onBridgeConfigurationChanged>");
        Activity activity = this.f1853b;
        if (activity != null && !activity.isFinishing()) {
            m2129a(this.f1853b);
        } else {
            HMSLog.m2118e("NotInstalledHmsResolution", "<Resolution onBridgeActivityCreate> mActivity is null or finishing");
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
        HMSLog.m2120i("NotInstalledHmsResolution", "<Resolution onKeyUp>");
    }

    /* renamed from: a */
    private void m2128a() {
        Dialog dialog = this.f1852a;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f1852a.cancel();
    }
}
