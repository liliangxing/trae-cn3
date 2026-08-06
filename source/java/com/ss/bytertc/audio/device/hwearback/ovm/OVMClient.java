package com.ss.bytertc.audio.device.hwearback.ovm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.bytertc.audio.device.base.ManufacturerChecker;
import com.ss.bytertc.audio.device.hwearback.ovm.OVMAuthManager;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class OVMClient {
    private static final int OPEN_DELAY_TIME = 200;
    private static final String TAG = "OVMClient";
    private static final int WAIT_SERVICE_DELAY_TIME = 2500;
    private static volatile OVMClient sClient;
    private OVMAuthManager.AuthCallback mAuthCallback;
    private Context mContext;
    private OVMKaraokeMediaHelper mMediaHelper;
    private boolean mNeedDestroyWhenRelease;
    private boolean mIsSupport = false;
    private int mAuthResultCode = -2;
    private OperateStorage mStorage = new OperateStorage();
    private OVMAuthManager.AuthCallback mInitCallback = new OVMAuthManager.AuthCallback() { // from class: com.ss.bytertc.audio.device.hwearback.ovm.OVMClient.1
        @Override // com.ss.bytertc.audio.device.hwearback.ovm.OVMAuthManager.AuthCallback
        public void onResult(int resultCode) {
            if (OVMClient.this.mAuthResultCode == -2) {
                OVMClient.this.mAuthResultCode = resultCode;
                OVMAuthManager.AuthCallback authCallback = OVMClient.this.mAuthCallback;
                if (authCallback != null) {
                    authCallback.onResult(OVMClient.this.mAuthResultCode);
                }
            }
        }
    };
    private boolean mIsHeadsetConnected = false;
    private OVMAuthManager.AuthCallback mRestartAuthCallback = new OVMAuthManager.AuthCallback() { // from class: com.ss.bytertc.audio.device.hwearback.ovm.OVMClient.2
        @Override // com.ss.bytertc.audio.device.hwearback.ovm.OVMAuthManager.AuthCallback
        public void onResult(int resultCode) {
            OVMKaraokeMediaHelper lockMediaHelper;
            RXLogging.i(OVMClient.TAG, "onRestartListener result: " + resultCode);
            OVMAuthManager.getInstance().removeCallback(this);
            OVMClient.this.postHandler.removeCallbacks(OVMClient.this.restoreParamsRunnable);
            if (OVMClient.this.mStorage.isKTVDeviceOpen && resultCode == 1001 && (lockMediaHelper = OVMClient.this.lockMediaHelper()) != null) {
                RXLogging.i(OVMClient.TAG, "openKTVDevice duration restart.");
                lockMediaHelper.openKTVDevice();
                OVMClient.this.postHandler.postDelayed(OVMClient.this.restoreParamsRunnable, 200L);
            }
        }
    };
    private Handler postHandler = new Handler(Looper.getMainLooper());
    private Runnable restartRunnable = new Runnable() { // from class: com.ss.bytertc.audio.device.hwearback.ovm.OVMClient$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            OVMClient.this.m4149lambda$new$0$comssbytertcaudiodevicehwearbackovmOVMClient();
        }
    };
    private Runnable restoreParamsRunnable = new Runnable() { // from class: com.ss.bytertc.audio.device.hwearback.ovm.OVMClient$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            OVMClient.this.m4150lambda$new$1$comssbytertcaudiodevicehwearbackovmOVMClient();
        }
    };
    private BroadcastReceiver headsetPlugReceiver = new BroadcastReceiver() { // from class: com.ss.bytertc.audio.device.hwearback.ovm.OVMClient.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                RXLogging.e(OVMClient.TAG, "action is null");
                return;
            }
            RXLogging.i(OVMClient.TAG, "onReceive: " + intent);
            Bundle extras = intent.getExtras();
            if (extras != null) {
                for (String str : extras.keySet()) {
                    RXLogging.i(OVMClient.TAG, str + ": " + extras.get(str));
                }
            }
            if (action.equals("android.intent.action.HEADSET_PLUG")) {
                boolean z = intent.getIntExtra("state", -99) == 1;
                boolean z2 = OVMClient.this.mIsHeadsetConnected != z;
                OVMClient.this.mIsHeadsetConnected = z;
                if (!z2) {
                    RXLogging.i(OVMClient.TAG, "headset plug not changed, ignore");
                    return;
                }
                if (!z) {
                    OVMClient.this.clearRestartRunner();
                    OVMKaraokeMediaHelper lockMediaHelper = OVMClient.this.lockMediaHelper();
                    if (lockMediaHelper == null || !OVMClient.this.mStorage.isKTVDeviceOpen) {
                        return;
                    }
                    RXLogging.i(OVMClient.TAG, "closeKTVDevice and feedback with unplug headset");
                    lockMediaHelper.setPlayFeedbackParam(0);
                    lockMediaHelper.closeKTVDevice();
                    return;
                }
                RXLogging.i(OVMClient.TAG, "need restart media helper");
                OVMClient.this.restartKTVDevice(ManufacturerChecker.getManufacturerType() == ManufacturerChecker.Type.OP ? OVMClient.WAIT_SERVICE_DELAY_TIME : 200);
            }
        }
    };

    public static OVMClient initialize(Context context) {
        if (sClient == null) {
            synchronized (OVMClient.class) {
                Context applicationContext = context.getApplicationContext();
                if (sClient == null) {
                    sClient = new OVMClient(applicationContext);
                }
            }
        }
        return sClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class OperateStorage {
        int equalizerTypeParam;
        boolean isKTVDeviceOpen;
        int listenRecordSameParam;
        int micVolumeParam;
        int mixSoundTypeParam;
        int playFeedbackParam;

        private OperateStorage() {
        }

        void reset() {
            this.listenRecordSameParam = 0;
            this.playFeedbackParam = 0;
            this.micVolumeParam = 6;
            this.mixSoundTypeParam = 0;
            this.equalizerTypeParam = 0;
        }

        public String toString() {
            return "isKTVDeviceOpen: " + this.isKTVDeviceOpen + ", recordSame: " + this.listenRecordSameParam + ", playFeedback: " + this.playFeedbackParam + ", micVolume: " + this.micVolumeParam + ", mix: " + this.mixSoundTypeParam + ", eq: " + this.equalizerTypeParam;
        }
    }

    public boolean isSupported() {
        return this.mIsSupport;
    }

    public boolean isSupportedAndAuth() {
        return this.mIsSupport && this.mAuthResultCode == 1001;
    }

    public boolean isDeviceSupportKaraoke() {
        OVMKaraokeMediaHelper lockMediaHelper = lockMediaHelper();
        if (lockMediaHelper != null) {
            return lockMediaHelper.isDeviceSupportKaraoke();
        }
        return false;
    }

    public boolean isAppSupportKaraoke(String appName) {
        OVMKaraokeMediaHelper lockMediaHelper = lockMediaHelper();
        if (lockMediaHelper != null) {
            return lockMediaHelper.isAppSupportKaraoke(appName);
        }
        return false;
    }

    public String getKaraokeSupportParameters() {
        OVMKaraokeMediaHelper lockMediaHelper = lockMediaHelper();
        return lockMediaHelper != null ? lockMediaHelper.getKaraokeSupportParameters() : "";
    }

    public synchronized void openKTVDevice() {
        RXLogging.i(TAG, "openKTVDevice");
        this.mStorage.isKTVDeviceOpen = true;
        OVMKaraokeMediaHelper lockMediaHelper = lockMediaHelper();
        if (lockMediaHelper != null) {
            lockMediaHelper.openKTVDevice();
        }
    }

    public synchronized void closeKTVDevice() {
        RXLogging.i(TAG, "closeKTVDevice");
        this.mStorage.isKTVDeviceOpen = true;
        clearRestartRunner();
        OVMKaraokeMediaHelper lockMediaHelper = lockMediaHelper();
        if (lockMediaHelper != null) {
            lockMediaHelper.closeKTVDevice();
        }
    }

    public synchronized void resetKTVParamsAndUpdate() {
        RXLogging.i(TAG, "resetKTVParamsAndUpdate");
        this.mStorage.reset();
        this.postHandler.postDelayed(this.restoreParamsRunnable, 200L);
    }

    public void release() {
        RXLogging.i(TAG, "release()");
        OVMAuthManager.getInstance().removeCallback(this.mInitCallback);
        OVMAuthManager.getInstance().removeCallback(this.mRestartAuthCallback);
        unRegisterHeadsetPlugEvent();
        clearRestartRunner();
        if (this.mNeedDestroyWhenRelease) {
            synchronized (OVMClient.class) {
                RXLogging.i(TAG, "clear sClient");
                if (sClient == this) {
                    sClient = null;
                }
            }
        }
    }

    public synchronized void setAuthCallback(OVMAuthManager.AuthCallback listener) {
        this.mAuthCallback = listener;
        int i = this.mAuthResultCode;
        if (i != -2 && listener != null) {
            listener.onResult(i);
        }
    }

    public void setPlayFeedbackParam(int param) {
        RXLogging.i(TAG, "setPlayFeedbackParam: " + param);
        this.mStorage.playFeedbackParam = param;
        OVMKaraokeMediaHelper lockMediaHelper = lockMediaHelper();
        if (lockMediaHelper != null) {
            lockMediaHelper.setPlayFeedbackParam(param);
        }
    }

    public int getPlayFeedbackParam() {
        OVMKaraokeMediaHelper lockMediaHelper = lockMediaHelper();
        if (lockMediaHelper != null) {
            return lockMediaHelper.getPlayFeedbackParam();
        }
        return 0;
    }

    public void setMicVolParam(int param) {
        RXLogging.i(TAG, "setMicVolParam: " + param);
        this.mStorage.micVolumeParam = param;
        OVMKaraokeMediaHelper lockMediaHelper = lockMediaHelper();
        if (lockMediaHelper != null) {
            lockMediaHelper.setMicVolParam(param);
        }
    }

    public int getMicVolParam() {
        OVMKaraokeMediaHelper lockMediaHelper = lockMediaHelper();
        if (lockMediaHelper != null) {
            return lockMediaHelper.getMicVolParam();
        }
        return 0;
    }

    public void setMixerSoundType(int param) {
        RXLogging.i(TAG, "setMixerSoundType: " + param);
        this.mStorage.mixSoundTypeParam = param;
        OVMKaraokeMediaHelper lockMediaHelper = lockMediaHelper();
        if (lockMediaHelper != null) {
            lockMediaHelper.setMixerSoundType(param);
        }
    }

    public void setEqualizerType(int equalizerType) {
        RXLogging.i(TAG, "setEqualizerType: " + equalizerType);
        this.mStorage.equalizerTypeParam = equalizerType;
        OVMKaraokeMediaHelper lockMediaHelper = lockMediaHelper();
        if (lockMediaHelper != null) {
            lockMediaHelper.setEqualizerType(equalizerType);
        }
    }

    public void setListenRecordSame(int param) {
        RXLogging.i(TAG, "setListenRecordSame: " + param);
        this.mStorage.listenRecordSameParam = param;
        OVMKaraokeMediaHelper lockMediaHelper = lockMediaHelper();
        if (lockMediaHelper != null) {
            lockMediaHelper.setListenRecordSame(param);
        }
    }

    public int getListenRecordSame() {
        OVMKaraokeMediaHelper lockMediaHelper = lockMediaHelper();
        if (lockMediaHelper == null) {
            return 0;
        }
        lockMediaHelper.getListenRecordSame();
        return 0;
    }

    public int getVersion() {
        OVMKaraokeMediaHelper lockMediaHelper = lockMediaHelper();
        if (lockMediaHelper != null) {
            return lockMediaHelper.getVersion();
        }
        return -1;
    }

    private OVMClient(Context context) {
        this.mNeedDestroyWhenRelease = false;
        this.mNeedDestroyWhenRelease = ManufacturerChecker.getManufacturerType() == ManufacturerChecker.Type.OP;
        this.mContext = context.getApplicationContext();
        initClient(context);
    }

    private void initClient(Context context) {
        RXLogging.i(TAG, "initClient");
        boolean z = false;
        this.mIsSupport = false;
        this.mStorage.isKTVDeviceOpen = false;
        this.mStorage.reset();
        if (Build.VERSION.SDK_INT < 31) {
            return;
        }
        initMediaHelper(this.mInitCallback);
        boolean z2 = this.mMediaHelper != null;
        this.mIsSupport = z2;
        if (z2) {
            if (isDeviceSupportKaraoke() && isAppSupportKaraoke(context.getPackageName()) && getVersion() >= 10000) {
                z = true;
            }
            this.mIsSupport = z;
        }
        registerHeadsetPlugEvent();
    }

    private void initMediaHelper(OVMAuthManager.AuthCallback authCallback) {
        try {
            OVMKaraokeMediaHelper create = OVMKaraokeMediaHelper.create(this.mContext);
            this.mMediaHelper = create;
            if (create != null) {
                OVMAuthManager.getInstance().addCallback(authCallback);
                OVMAuthManager.getInstance().startAuth(this.mContext, "MEDIA_CLIENT");
            }
        } catch (Throwable th) {
            th.printStackTrace();
            RXLogging.e(TAG, "init media helper error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OVMKaraokeMediaHelper lockMediaHelper() {
        if (this.mIsSupport) {
            return this.mMediaHelper;
        }
        return null;
    }

    private void restoreParams(OVMKaraokeMediaHelper helper) {
        RXLogging.i(TAG, "restore params: " + this.mStorage.toString());
        helper.setPlayFeedbackParam(this.mStorage.playFeedbackParam);
        helper.setListenRecordSame(this.mStorage.listenRecordSameParam);
        helper.setMicVolParam(this.mStorage.micVolumeParam);
        helper.setEqualizerType(this.mStorage.equalizerTypeParam);
        helper.setMixerSoundType(this.mStorage.mixSoundTypeParam);
    }

    private void registerHeadsetPlugEvent() {
        if (this.mIsSupport && this.mContext != null && needRegisterHeadsetPlug()) {
            RXLogging.i(TAG, "registerHeadsetPlug");
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                boolean z = true;
                if (m169xc53529fe(this.mContext, this.headsetPlugReceiver, intentFilter).getIntExtra("state", -99) != 1) {
                    z = false;
                }
                this.mIsHeadsetConnected = z;
            } catch (Throwable th) {
                RXLogging.e(TAG, "registerReceiver error", th);
            }
        }
    }

    private void unRegisterHeadsetPlugEvent() {
        if (this.mContext == null || !needRegisterHeadsetPlug()) {
            return;
        }
        RXLogging.i(TAG, "unregisterHeadsetPlug");
        try {
            m170x31600397(this.mContext, this.headsetPlugReceiver);
        } catch (Throwable th) {
            RXLogging.e(TAG, "unregisterReceiver error", th);
        }
    }

    private boolean needRegisterHeadsetPlug() {
        ManufacturerChecker.Type manufacturerType = ManufacturerChecker.getManufacturerType();
        return manufacturerType == ManufacturerChecker.Type.OP || manufacturerType == ManufacturerChecker.Type.VO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-ss-bytertc-audio-device-hwearback-ovm-OVMClient, reason: not valid java name */
    public /* synthetic */ void m4149lambda$new$0$comssbytertcaudiodevicehwearbackovmOVMClient() {
        RXLogging.i(TAG, "restart media helper");
        if (!isSupported() || !this.mStorage.isKTVDeviceOpen) {
            RXLogging.e(TAG, "restart with error, return: " + isSupported() + ", " + this.mStorage.isKTVDeviceOpen);
            return;
        }
        int i = C08094.f94x4837e59[ManufacturerChecker.getManufacturerType().ordinal()];
        if (i == 1) {
            initMediaHelper(this.mRestartAuthCallback);
            return;
        }
        if (i != 2) {
            return;
        }
        OVMKaraokeMediaHelper lockMediaHelper = lockMediaHelper();
        if (!this.mStorage.isKTVDeviceOpen || lockMediaHelper == null) {
            return;
        }
        RXLogging.i(TAG, "closeKTVDevice duration restart.");
        lockMediaHelper.openKTVDevice();
        restoreParams(lockMediaHelper);
    }

    /* renamed from: com.ss.bytertc.audio.device.hwearback.ovm.OVMClient$4 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static /* synthetic */ class C08094 {

        /* renamed from: $SwitchMap$com$ss$bytertc$audio$device$base$ManufacturerChecker$Type */
        static final /* synthetic */ int[] f94x4837e59;

        static {
            int[] iArr = new int[ManufacturerChecker.Type.values().length];
            f94x4837e59 = iArr;
            try {
                iArr[ManufacturerChecker.Type.OP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f94x4837e59[ManufacturerChecker.Type.VO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$1$com-ss-bytertc-audio-device-hwearback-ovm-OVMClient, reason: not valid java name */
    public /* synthetic */ void m4150lambda$new$1$comssbytertcaudiodevicehwearbackovmOVMClient() {
        OVMKaraokeMediaHelper lockMediaHelper = lockMediaHelper();
        if (lockMediaHelper == null || !this.mStorage.isKTVDeviceOpen) {
            return;
        }
        RXLogging.i(TAG, "openKTVDevice duration restore params.");
        restoreParams(lockMediaHelper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restartKTVDevice(int time) {
        clearRestartRunner();
        this.postHandler.postDelayed(this.restartRunnable, time);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRestartRunner() {
        this.postHandler.removeCallbacks(this.restartRunnable);
        this.postHandler.removeCallbacks(this.restoreParamsRunnable);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_ss_bytertc_audio_device_hwearback_ovm_OVMClient_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m169xc53529fe(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    /* renamed from: INVOKEVIRTUAL_com_ss_bytertc_audio_device_hwearback_ovm_OVMClient_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m170x31600397(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}
