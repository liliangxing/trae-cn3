package com.ss.android.socialbase.appdownloader.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.appdownloader.DownloadReceiver;
import com.ss.android.socialbase.appdownloader.constants.Constants;
import com.ss.android.socialbase.appdownloader.depend.ITempAppInstallDownloadReceiverListener;
import com.ss.android.socialbase.appdownloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadReceiverService implements IDownloadReceiverService {
    private static final String TAG = "DownloadReceiverService";
    private static boolean mIsAppInstallRegistered;
    private static boolean mIsRegistered;
    private Future mAppInstallFuture;
    private int mAppInstallReceiverKeepTime;
    private DownloadReceiver mDownloadReceiver = new DownloadReceiver();
    private BroadcastReceiver mNotificationSubprocessReceiver;
    private ITempAppInstallDownloadReceiverListener mTempAppInstallDownloadReceiverListener;

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadReceiverService
    public void registerDownloadReceiver() {
        synchronized (this.mDownloadReceiver) {
            if (mIsRegistered) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter.addDataScheme("file");
                m113x336a98b1(DownloadComponentManager.getAppContext(), this.mDownloadReceiver, intentFilter);
                if (AppDownloader.isEnableAppInstallDownloadReceiver()) {
                    registerAppInstallDownloadReceiver();
                }
                if (DownloadUtils.optimizeMultiProcess() && !DownloadHelper.isMainProcess()) {
                    registerNotificationSubprocessReceiver();
                }
                mIsRegistered = true;
            } catch (Exception e) {
                e.printStackTrace();
                Logger.globalError(TAG, "registerDownloadReceiver", "Error:" + e);
            }
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "registerDownloadReceiver", "Run isRegistered:" + mIsRegistered);
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadReceiverService
    public void tryRegisterTempAppInstallDownloadReceiver(int i) {
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.ENABLE_APP_INSTALL_RECEIVER) <= 0) {
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "tryRegisterTempAppInstallDownloadReceiver", "Disable app install receiver");
            }
        } else {
            registerAppInstallDownloadReceiver();
            tryUnRegisterAppInstallDownloadReceiver(i);
        }
    }

    private void registerAppInstallDownloadReceiver() {
        synchronized (this.mDownloadReceiver) {
            if (mIsAppInstallRegistered) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                intentFilter.addDataScheme("package");
                m113x336a98b1(DownloadComponentManager.getAppContext(), this.mDownloadReceiver, intentFilter);
                mIsAppInstallRegistered = true;
                ITempAppInstallDownloadReceiverListener iTempAppInstallDownloadReceiverListener = this.mTempAppInstallDownloadReceiverListener;
                if (iTempAppInstallDownloadReceiverListener != null) {
                    iTempAppInstallDownloadReceiverListener.onRegister();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                Logger.globalError(TAG, "registerTempAppInstallDownloadReceiver", "Error:" + th);
            }
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "registerDownloadReceiver", "Run isAppInstallRegistered:" + mIsAppInstallRegistered);
            }
        }
    }

    private void tryUnRegisterAppInstallDownloadReceiver(int i) {
        this.mAppInstallReceiverKeepTime = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.APP_INSTALL_KEEP_RECEIVER_TIME_S);
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "tryUnRegisterTempAppInstallDownloadReceiver", "Run appInstallReceiverKeepTime:" + this.mAppInstallReceiverKeepTime);
        }
        if (this.mAppInstallReceiverKeepTime <= 0) {
            return;
        }
        if (i > 0) {
            this.mAppInstallReceiverKeepTime = i;
        }
        Future future = this.mAppInstallFuture;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
                th.printStackTrace();
                Logger.globalError(TAG, "tryUnRegisterTempAppInstallDownloadReceiver", "Error:" + th);
            }
        }
        this.mAppInstallFuture = DownloadComponentManager.submitScheduleTask(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.service.DownloadReceiverService.1
            @Override // java.lang.Runnable
            public void run() {
                if (Logger.debug()) {
                    Logger.globalDebug(DownloadReceiverService.TAG, "tryUnRegisterTempAppInstallDownloadReceiver", "Run inner");
                }
                DownloadReceiverService.this.unRegisterDownloadReceiver();
                DownloadReceiverService.this.registerDownloadReceiver();
            }
        }, this.mAppInstallReceiverKeepTime, TimeUnit.SECONDS);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadReceiverService
    public void unRegisterDownloadReceiver() {
        ITempAppInstallDownloadReceiverListener iTempAppInstallDownloadReceiverListener;
        synchronized (this.mDownloadReceiver) {
            Logger.globalError(TAG, "unRegisterDownloadReceiver", "Run:" + mIsRegistered);
            try {
                if (mIsRegistered) {
                    m115xe7f4918a(DownloadComponentManager.getAppContext(), this.mDownloadReceiver);
                    if (mIsAppInstallRegistered && (iTempAppInstallDownloadReceiverListener = this.mTempAppInstallDownloadReceiverListener) != null) {
                        iTempAppInstallDownloadReceiverListener.onUnRegister();
                    }
                    if (this.mNotificationSubprocessReceiver != null) {
                        m115xe7f4918a(DownloadComponentManager.getAppContext(), this.mNotificationSubprocessReceiver);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                Logger.globalError(TAG, "unRegisterDownloadReceiver", "Error:" + e);
            }
            mIsRegistered = false;
            mIsAppInstallRegistered = false;
        }
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "unRegisterDownloadReceiver", "Run");
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadReceiverService
    public void setTempAppInstallDownloadReceiverListener(ITempAppInstallDownloadReceiverListener iTempAppInstallDownloadReceiverListener) {
        this.mTempAppInstallDownloadReceiverListener = iTempAppInstallDownloadReceiverListener;
    }

    private void registerNotificationSubprocessReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Constants.ACTION_OPEN);
        intentFilter.addAction(Constants.ACTION_DELETE);
        intentFilter.addAction(Constants.ACTION_CLICK_CONTENT);
        intentFilter.addAction(Constants.ACTION_CLICK_BTN);
        intentFilter.addAction(Constants.ACTION_HIDE);
        this.mNotificationSubprocessReceiver = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.service.DownloadReceiverService.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                int intExtra;
                if (intent == null) {
                    return;
                }
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if ((action.equals(Constants.ACTION_OPEN) || action.equals(Constants.ACTION_DELETE) || action.equals(Constants.ACTION_CLICK_CONTENT) || action.equals(Constants.ACTION_CLICK_BTN) || action.equals(Constants.ACTION_HIDE)) && (intExtra = intent.getIntExtra(Constants.EXTRA_NOTIFICATION_PID, -1)) != -1 && intExtra == DownloadUtils.getPid()) {
                    ((IDownloadHandlerService) AppDownloadServiceManager.getService(IDownloadHandlerService.class)).onStartCommand(context, intent);
                }
            }
        };
        if (Build.VERSION.SDK_INT >= 26) {
            m114x336a98b1(DownloadComponentManager.getAppContext(), this.mNotificationSubprocessReceiver, intentFilter, 2);
        } else {
            m113x336a98b1(DownloadComponentManager.getAppContext(), this.mNotificationSubprocessReceiver, intentFilter);
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_ss_android_socialbase_appdownloader_service_DownloadReceiverService_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m113x336a98b1(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.iab.omid.library.bytedance.b.b"})
    /* renamed from: INVOKEVIRTUAL_com_ss_android_socialbase_appdownloader_service_DownloadReceiverService_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m114x336a98b1(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, i);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter, i);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter, i);
        }
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    /* renamed from: INVOKEVIRTUAL_com_ss_android_socialbase_appdownloader_service_DownloadReceiverService_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m115xe7f4918a(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}
