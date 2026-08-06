package com.ss.bytertc.audio.device.webrtc.observer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class VolumeChangedObserver {
    private static final String EXTRA_VOLUME_STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    private static final String EXTRA_VOLUME_STREAM_VALUE = "android.media.EXTRA_VOLUME_STREAM_VALUE";
    private static final int STREAM_BLUETOOTH_SCO = 6;
    private static final String TAG = "VolumeChangedObserver";
    private static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    private VolumeBroadcastReceiver mVolumeBroadcastReceiver;
    private OnVolumeChangedListener onVolumeChangedListener;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface OnVolumeChangedListener {
        void onVolumeChanged(int streamType, int volume);
    }

    public VolumeChangedObserver(OnVolumeChangedListener listener) {
        this.onVolumeChangedListener = listener;
        registerVolumeChangeAction();
    }

    private void registerVolumeChangeAction() {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            Log.e(TAG, "context is null. unable to register broadcast receiver.");
            return;
        }
        this.mVolumeBroadcastReceiver = new VolumeBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VOLUME_CHANGED_ACTION);
        m176x7894d98c(applicationContext, this.mVolumeBroadcastReceiver, intentFilter);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
    
        if (r5.onVolumeChangedListener == null) goto L9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void unregisterReceiver() {
        try {
            try {
                Context applicationContext = ContextUtils.getApplicationContext();
                VolumeBroadcastReceiver volumeBroadcastReceiver = this.mVolumeBroadcastReceiver;
                if (volumeBroadcastReceiver != null) {
                    m177x8b9207a5(applicationContext, volumeBroadcastReceiver);
                    this.mVolumeBroadcastReceiver = null;
                }
            } catch (Exception e) {
                Log.e(TAG, "unregisterReceiver failed. msg: " + e.getMessage());
            }
        } finally {
            if (this.onVolumeChangedListener != null) {
                this.onVolumeChangedListener = null;
            }
            this.mVolumeBroadcastReceiver = null;
        }
    }

    public void release() {
        unregisterReceiver();
        this.onVolumeChangedListener = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class VolumeBroadcastReceiver extends BroadcastReceiver {
        VolumeBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VolumeChangedObserver volumeChangedObserver = VolumeChangedObserver.this;
            if (volumeChangedObserver.onVolumeChangedListener != null && VolumeChangedObserver.VOLUME_CHANGED_ACTION.equals(intent.getAction())) {
                try {
                    int intExtra = intent.getIntExtra(VolumeChangedObserver.EXTRA_VOLUME_STREAM_TYPE, -1);
                    if (intExtra == 3 || intExtra == 0 || intExtra == 6) {
                        volumeChangedObserver.onVolumeChangedListener.onVolumeChanged(intExtra, intent.getIntExtra(VolumeChangedObserver.EXTRA_VOLUME_STREAM_VALUE, -1));
                    }
                } catch (Exception e) {
                    Log.e(VolumeChangedObserver.TAG, "getIntExtra failed. key: EXTRA_VOLUME_STREAM_TYPE, msg: " + e.getMessage());
                }
            }
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_ss_bytertc_audio_device_webrtc_observer_VolumeChangedObserver_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m176x7894d98c(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
    /* renamed from: INVOKEVIRTUAL_com_ss_bytertc_audio_device_webrtc_observer_VolumeChangedObserver_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m177x8b9207a5(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}
