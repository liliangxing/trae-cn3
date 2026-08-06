package com.huawei.hms.adapter.p019ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.p031ui.NotInstalledHmsDialogHelper;
import com.huawei.hms.utils.UIUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class NotInstalledHmsAdapter implements IBridgeActivityDelegate {

    /* renamed from: c */
    private static final Object f1033c = new Object();

    /* renamed from: d */
    private static boolean f1034d;

    /* renamed from: a */
    private Activity f1035a;

    /* renamed from: b */
    private Dialog f1036b;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.huawei.hms.adapter.ui.NotInstalledHmsAdapter$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class DialogInterfaceOnCancelListenerC1022a implements DialogInterface.OnCancelListener {

        /* renamed from: a */
        private final Activity f1037a;

        public DialogInterfaceOnCancelListenerC1022a(Activity activity) {
            this.f1037a = activity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            HMSLog.m2120i("NotInstalledHmsAdapter", "<Dialog onCancel>");
            SystemManager.getInstance().notifyUpdateResult(13);
            this.f1037a.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.huawei.hms.adapter.ui.NotInstalledHmsAdapter$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class DialogInterfaceOnClickListenerC1023b implements DialogInterface.OnClickListener {

        /* renamed from: a */
        private final Activity f1038a;

        public DialogInterfaceOnClickListenerC1023b(Activity activity) {
            this.f1038a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            HMSLog.m2120i("NotInstalledHmsAdapter", "<Dialog onClick>");
            SystemManager.getInstance().notifyUpdateResult(30);
            this.f1038a.finish();
        }
    }

    /* renamed from: a */
    private void m975a(Activity activity) {
        Dialog dialog = this.f1036b;
        if (dialog != null && dialog.isShowing()) {
            this.f1036b.setOnCancelListener(null);
            this.f1036b.cancel();
        }
        AlertDialog create = NotInstalledHmsDialogHelper.getDialogBuilder(activity).setPositiveButton(NotInstalledHmsDialogHelper.getConfirmResId(activity), new DialogInterfaceOnClickListenerC1023b(activity)).setOnCancelListener(new DialogInterfaceOnCancelListenerC1022a(activity)).create();
        this.f1036b = create;
        UIUtil.enableFocusedForButtonsInTV(create);
        this.f1036b.show();
    }

    public static boolean getShowLock() {
        synchronized (f1033c) {
            HMSLog.m2120i("NotInstalledHmsAdapter", "<canShowDialog> sIsShowingDialog: " + f1034d);
            if (f1034d) {
                return false;
            }
            f1034d = true;
            return true;
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        HMSLog.m2120i("NotInstalledHmsAdapter", "<getRequestCode>");
        return 0;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        HMSLog.m2120i("NotInstalledHmsAdapter", "<onBridgeActivityCreate>");
        if (activity != null && !activity.isFinishing()) {
            this.f1035a = activity;
            m975a(activity);
        } else {
            HMSLog.m2118e("NotInstalledHmsAdapter", "<onBridgeActivityCreate> activity is null or finishing");
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.m2120i("NotInstalledHmsAdapter", "<onBridgeActivityDestroy>");
        synchronized (f1033c) {
            f1034d = false;
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        HMSLog.m2120i("NotInstalledHmsAdapter", "<onBridgeActivityResult>");
        return false;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.m2120i("NotInstalledHmsAdapter", "<onBridgeConfigurationChanged>");
        Activity activity = this.f1035a;
        if (activity != null && !activity.isFinishing()) {
            m975a(this.f1035a);
        } else {
            HMSLog.m2118e("NotInstalledHmsAdapter", "<onBridgeConfigurationChanged> mActivity is null or finishing");
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
        HMSLog.m2120i("NotInstalledHmsAdapter", "<onKeyUp>");
    }
}
