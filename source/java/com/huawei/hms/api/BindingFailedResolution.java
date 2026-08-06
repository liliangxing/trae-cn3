package com.huawei.hms.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.heytap.mcssdk.constant.C0878a;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.api.FailedBinderCallBack;
import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.p030ui.AbstractDialog;
import com.huawei.hms.p030ui.AbstractPromptDialog;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class BindingFailedResolution implements IBridgeActivityDelegate, ServiceConnection {
    private static final Object LOCK_CONNECT_TIMEOUT_HANDLER = new Object();
    private static final int MSG_CONN_TIMEOUT = 2;
    private static final int MSG_SELF_DESTROY_TIMEOUT = 3;
    private static final int REQUEST_CODE = 2003;
    private static final String TAG = "BindingFailedResolution";
    private FailedBinderCallBack.BinderCallBack callBack;
    private Activity curActivity;
    private C1027d promptdlg;
    private boolean isStarting = true;
    private Handler mConnectTimeoutHandler = null;
    private Handler selfDestroyHandler = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.api.BindingFailedResolution$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class C1024a implements Handler.Callback {
        C1024a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null || message.what != 3) {
                return false;
            }
            HMSLog.m2120i(BindingFailedResolution.TAG, "selfDestroyHandle：MSG_SELF_DESTROY_TIMEOUT");
            BindingFailedResolution.this.noticeBindFailed();
            BindingFailedResolution.this.finishBridgeActivity(8);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.api.BindingFailedResolution$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class C1025b implements Handler.Callback {
        C1025b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null || message.what != 2) {
                return false;
            }
            HMSLog.m2118e(BindingFailedResolution.TAG, "In connect, bind core try timeout");
            BindingFailedResolution.this.fireStartResult(false);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.api.BindingFailedResolution$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class C1026c implements AbstractDialog.Callback {
        C1026c() {
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onCancel(AbstractDialog abstractDialog) {
            BindingFailedResolution.this.promptdlg = null;
            BindResolveClients.getInstance().unRegisterAll();
            BindingFailedResolution.this.finishBridgeActivity(8);
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onDoWork(AbstractDialog abstractDialog) {
            BindingFailedResolution.this.promptdlg = null;
            BindResolveClients.getInstance().unRegisterAll();
            BindingFailedResolution.this.finishBridgeActivity(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.huawei.hms.api.BindingFailedResolution$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class C1027d extends AbstractPromptDialog {
        private C1027d() {
        }

        @Override // com.huawei.hms.p030ui.AbstractDialog
        public String onGetMessageString(Context context) {
            String appName = Util.getAppName(context, null);
            String appName2 = Util.getAppName(context, HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService());
            Object[] objArr = new Object[2];
            objArr[0] = appName;
            if (TextUtils.isEmpty(appName2)) {
                appName2 = "com.huawei.hwid";
            }
            objArr[1] = appName2;
            return ResourceLoaderUtil.getString("hms_bindfaildlg_message", objArr);
        }

        @Override // com.huawei.hms.p030ui.AbstractDialog
        public String onGetPositiveButtonString(Context context) {
            return ResourceLoaderUtil.getString("hms_confirm");
        }

        /* synthetic */ C1027d(C1024a c1024a) {
            this();
        }
    }

    private void bindCoreService(boolean z) {
        Activity activity = getActivity();
        if (activity == null) {
            HMSLog.m2118e(TAG, "In connect, bind core try fail");
            fireStartResult(false);
            noticeBindResult(z, 8);
            return;
        }
        Intent intent = new Intent(HMSPackageManager.getInstance(activity.getApplicationContext()).getServiceAction());
        try {
            String hMSPackageNameForMultiService = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageNameForMultiService();
            if (TextUtils.isEmpty(hMSPackageNameForMultiService)) {
                HMSLog.m2118e(TAG, "servicePackageName is empty, Service is invalid.");
                fireStartResult(false);
                noticeBindResult(z, 1);
                return;
            }
            intent.setPackage(hMSPackageNameForMultiService);
            synchronized (LOCK_CONNECT_TIMEOUT_HANDLER) {
                if (activity.bindService(intent, this, 1)) {
                    postConnDelayHandle();
                    return;
                }
                HMSLog.m2118e(TAG, "In connect, bind core try fail");
                fireStartResult(false);
                noticeBindResult(z, 8);
            }
        } catch (IllegalArgumentException unused) {
            HMSLog.m2118e(TAG, "IllegalArgumentException when bindCoreService intent.setPackage");
            fireStartResult(false);
            noticeBindResult(z, 8);
        }
    }

    private void cancelConnDelayHandle() {
        synchronized (LOCK_CONNECT_TIMEOUT_HANDLER) {
            Handler handler = this.mConnectTimeoutHandler;
            if (handler != null) {
                handler.removeMessages(2);
                this.mConnectTimeoutHandler = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishBridgeActivity(int i) {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        HMSLog.m2120i(TAG, "finishBridgeActivity：" + i);
        Intent intent = new Intent();
        intent.putExtra(BridgeActivity.EXTRA_RESULT, i);
        activity.setResult(-1, intent);
        Util.unBindServiceCatchException(activity, this);
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireStartResult(boolean z) {
        if (this.isStarting) {
            this.isStarting = false;
            onStartResult(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void noticeBindFailed() {
        FailedBinderCallBack.BinderCallBack binderCallBack = this.callBack;
        if (binderCallBack != null) {
            binderCallBack.binderCallBack(8);
        }
    }

    private void noticeBindResult(boolean z, int i) {
        FailedBinderCallBack.BinderCallBack binderCallBack;
        if (!z || (binderCallBack = this.callBack) == null) {
            return;
        }
        binderCallBack.binderCallBack(i);
    }

    private void postConnDelayHandle() {
        Handler handler = this.mConnectTimeoutHandler;
        if (handler != null) {
            handler.removeMessages(2);
        } else {
            this.mConnectTimeoutHandler = new Handler(Looper.getMainLooper(), new C1025b());
        }
        this.mConnectTimeoutHandler.sendEmptyMessageDelayed(2, C0878a.f532r);
    }

    private void selfDestroyHandle() {
        Handler handler = this.selfDestroyHandler;
        if (handler != null) {
            handler.removeMessages(3);
        } else {
            this.selfDestroyHandler = new Handler(Looper.getMainLooper(), new C1024a());
        }
        this.selfDestroyHandler.sendEmptyMessageDelayed(3, 4000L);
    }

    private void showPromptdlg() {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        C1027d c1027d = this.promptdlg;
        if (c1027d == null) {
            this.promptdlg = new C1027d(null);
        } else {
            c1027d.dismiss();
        }
        HMSLog.m2120i(TAG, "showPromptdlg to resolve conn error");
        this.promptdlg.show(activity, new C1026c());
    }

    private void tryStartHmsActivity(Activity activity) {
        String hMSPackageNameForMultiService = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageNameForMultiService();
        if (TextUtils.isEmpty(hMSPackageNameForMultiService)) {
            HMSLog.m2121w(TAG, "servicePackageName is empty, Service is invalid.");
            Handler handler = this.selfDestroyHandler;
            if (handler != null) {
                handler.removeMessages(3);
                this.selfDestroyHandler = null;
            }
            bindCoreService(false);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(BridgeActivity.EXTRA_IS_FULLSCREEN, UIUtil.isActivityFullscreen(activity));
        intent.setClassName(hMSPackageNameForMultiService, HuaweiApiAvailability.ACTIVITY_NAME);
        HMSLog.m2120i(TAG, "onBridgeActivityCreate：try to start HMS");
        try {
            activity.startActivityForResult(intent, getRequestCode());
        } catch (Throwable th) {
            HMSLog.m2118e(TAG, "ActivityNotFoundException：" + th.getMessage());
            Handler handler2 = this.selfDestroyHandler;
            if (handler2 != null) {
                handler2.removeMessages(3);
                this.selfDestroyHandler = null;
            }
            bindCoreService(false);
        }
    }

    protected Activity getActivity() {
        return this.curActivity;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 2003;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        if (activity == null) {
            HMSLog.m2118e(TAG, "activity is null");
            selfDestroyHandle();
            return;
        }
        if (activity.isFinishing()) {
            HMSLog.m2118e(TAG, "activity is finishing");
            return;
        }
        Intent intent = activity.getIntent();
        if (intent != null && intent.hasExtra(FailedBinderCallBack.CALLER_ID)) {
            long j = 0;
            try {
                j = intent.getLongExtra(FailedBinderCallBack.CALLER_ID, 0L);
            } catch (Exception e) {
                HMSLog.m2118e(TAG, "getExtras for callId exception:" + e.getMessage());
            }
            this.callBack = FailedBinderCallBack.getInstance().getCallBack(Long.valueOf(j));
        }
        this.curActivity = activity;
        BindingFailedResolveMgr.f1047b.m985a(activity);
        selfDestroyHandle();
        tryStartHmsActivity(activity);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        cancelConnDelayHandle();
        BindingFailedResolveMgr.f1047b.m986b(this.curActivity);
        this.curActivity = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        if (i != getRequestCode()) {
            return false;
        }
        HMSLog.m2120i(TAG, "onBridgeActivityResult");
        Handler handler = this.selfDestroyHandler;
        if (handler != null) {
            handler.removeMessages(3);
            this.selfDestroyHandler = null;
        }
        bindCoreService(true);
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        if (this.promptdlg == null) {
            return;
        }
        HMSLog.m2120i(TAG, "re show prompt dialog");
        showPromptdlg();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
        HMSLog.m2120i(TAG, "On key up when resolve conn error");
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        cancelConnDelayHandle();
        fireStartResult(true);
        if (getActivity() == null) {
            return;
        }
        HMSLog.m2120i(TAG, "test connect success, try to reConnect and reply message");
        BindResolveClients.getInstance().notifyClientReconnect();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }

    protected void onStartResult(boolean z) {
        if (getActivity() == null) {
            return;
        }
        if (z) {
            finishBridgeActivity(0);
        } else {
            showPromptdlg();
        }
    }
}
