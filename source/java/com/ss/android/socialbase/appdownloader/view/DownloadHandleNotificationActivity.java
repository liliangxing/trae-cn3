package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.ss.android.socialbase.appdownloader.constants.Constants;
import com.ss.android.socialbase.appdownloader.service.AppDownloadServiceManager;
import com.ss.android.socialbase.appdownloader.service.IDownloadHandlerService;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadHandleNotificationActivity extends Activity {
    private static final int GRANT_CODE = 1000;
    private static final String[] NOTIFICATION_PERMISSION = {"android.permission.POST_NOTIFICATIONS"};
    private static final String TAG = "DownloadNotificationJumpActivity";

    /* renamed from: com_ss_android_socialbase_appdownloader_view_DownloadHandleNotificationActivity__onStop$___twin___ */
    public void m118x39a97950() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        m117x190bcaab(this);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        int intExtra;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        if (Constants.ACTION_REQUEST_NOTIFICATION_PERMISSION.equals(intent.getAction())) {
            requestNotificationPermission();
        } else {
            if (DownloadUtils.optimizeMultiProcess() && (intExtra = intent.getIntExtra(Constants.EXTRA_NOTIFICATION_PID, -1)) != -1 && intExtra != DownloadUtils.getPid()) {
                Intent intent2 = new Intent();
                intent2.setAction(intent.getAction());
                intent2.putExtras(intent.getExtras());
                sendBroadcast(intent2);
                finish();
                return;
            }
            ((IDownloadHandlerService) AppDownloadServiceManager.getService(IDownloadHandlerService.class)).onStartCommand(getApplicationContext(), intent);
        }
        finish();
    }

    private void requestNotificationPermission() {
        try {
            requestPermissions(NOTIFICATION_PERMISSION, 1000);
        } catch (Throwable th) {
            Logger.globalError(TAG, "requestNotificationPermission", "Error:" + th);
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1000 && iArr != null && iArr.length > 0 && iArr[0] == 0) {
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "onRequestPermissionsResult", "Notification Permission grant");
            }
        } else if (Logger.debug()) {
            Logger.globalDebug(TAG, "onRequestPermissionsResult", "Notification Permission denied");
        }
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_ss_android_socialbase_appdownloader_view_DownloadHandleNotificationActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m117x190bcaab(DownloadHandleNotificationActivity downloadHandleNotificationActivity) {
        downloadHandleNotificationActivity.m118x39a97950();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                downloadHandleNotificationActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
