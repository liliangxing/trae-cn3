package com.ss.bytertc.audio.device.webrtc.observer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.ttm.player.MediaFormat;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MicMuteChangedObserver {
    private static final String TAG = "MicMuteChangedObserver";
    private MicMuteBroadCastReceiver mMicMuteBroadCastReceiver;
    private OnMicMuteChangedListener mOnMicMuteChangedListener;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface OnMicMuteChangedListener {
        void onMicMuteChanged(boolean micMuted);
    }

    public MicMuteChangedObserver(OnMicMuteChangedListener listener) {
        this.mOnMicMuteChangedListener = listener;
        registerReceiver();
    }

    private void registerReceiver() {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            Log.e(TAG, "registerReceiver, context is null. unable to register broadcast receiver.");
            return;
        }
        MicMuteBroadCastReceiver micMuteBroadCastReceiver = new MicMuteBroadCastReceiver();
        this.mMicMuteBroadCastReceiver = micMuteBroadCastReceiver;
        m174xcd992fba(applicationContext, micMuteBroadCastReceiver, new IntentFilter("android.media.action.MICROPHONE_MUTE_CHANGED"));
    }

    private void unregisterReceiver() {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            Log.e(TAG, "unregisterReceiver, context is null. unable to register broadcast receiver.");
            return;
        }
        try {
            MicMuteBroadCastReceiver micMuteBroadCastReceiver = this.mMicMuteBroadCastReceiver;
            if (micMuteBroadCastReceiver != null) {
                m175xb0d98a53(applicationContext, micMuteBroadCastReceiver);
                this.mMicMuteBroadCastReceiver = null;
            }
        } catch (Exception e) {
            Log.e(TAG, "unregisterReceiver, exception: " + e.getMessage());
        }
    }

    public void release() {
        unregisterReceiver();
        this.mOnMicMuteChangedListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public final class MicMuteBroadCastReceiver extends BroadcastReceiver {
        private MicMuteBroadCastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            MicMuteChangedObserver micMuteChangedObserver = MicMuteChangedObserver.this;
            if (context == null || intent == null || micMuteChangedObserver == null || intent.getAction() != "android.media.action.MICROPHONE_MUTE_CHANGED") {
                return;
            }
            try {
                AudioManager audioManager = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO);
                if (audioManager == null || micMuteChangedObserver.mOnMicMuteChangedListener == null) {
                    return;
                }
                micMuteChangedObserver.mOnMicMuteChangedListener.onMicMuteChanged(audioManager.isMicrophoneMute());
            } catch (Exception e) {
                Log.e(MicMuteChangedObserver.TAG, "MicMuteBroadCastReceiver.onReceive, exception: " + e.getMessage());
            }
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_ss_bytertc_audio_device_webrtc_observer_MicMuteChangedObserver_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m174xcd992fba(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
    /* renamed from: INVOKEVIRTUAL_com_ss_bytertc_audio_device_webrtc_observer_MicMuteChangedObserver_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m175xb0d98a53(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}
