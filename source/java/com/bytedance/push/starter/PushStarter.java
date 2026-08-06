package com.bytedance.push.starter;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.bytedance.push.BDPush;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.configuration.AbsBDPushConfiguration;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.third.PushChannelHelper;
import com.ss.android.common.applog.AppLog;
import com.ss.android.deviceregister.DeviceRegisterManager;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushStarter {
    private static boolean hasBdTracker;
    private static boolean hasDeviceRegister;
    public static boolean mEnableAutoInit;
    public static boolean mEnableAutoStart;

    /* renamed from: com_bytedance_push_starter_PushStarter_com_bytedance_bdinstall_oaid_Oaid_getOaidId */
    private static String m265xdeb29c39(Oaid oaid) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(10000008, "com/bytedance/bdinstall/oaid/Oaid", "getOaidId", oaid, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(10000008, "com/bytedance/bdinstall/oaid/Oaid", "getOaidId", oaid, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String oaidId = oaid.getOaidId();
        heliosApiHook.postInvoke(10000008, "com/bytedance/bdinstall/oaid/Oaid", "getOaidId", oaid, objArr, oaidId, extraInfo, true);
        return oaidId;
    }

    /* renamed from: com_bytedance_push_starter_PushStarter_com_ss_android_deviceregister_base_Oaid_getOaidId */
    private static String m266xa7cfdc18(com.ss.android.deviceregister.base.Oaid oaid) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(10000009, "com/ss/android/deviceregister/base/Oaid", "getOaidId", oaid, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(10000009, "com/ss/android/deviceregister/base/Oaid", "getOaidId", oaid, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String oaidId = oaid.getOaidId();
        heliosApiHook.postInvoke(10000009, "com/ss/android/deviceregister/base/Oaid", "getOaidId", oaid, objArr, oaidId, extraInfo, true);
        return oaidId;
    }

    public static void startPush() {
        Log.d("PushStarter", "startPush, mEnableAutoStart is " + mEnableAutoStart);
        if (mEnableAutoStart) {
            HashMap hashMap = new HashMap();
            if (hasDeviceRegister) {
                AppLog.getSSIDs(hashMap);
            }
            if (hasBdTracker && hashMap.isEmpty()) {
                com.bytedance.applog.AppLog.getSsidGroup(hashMap);
            }
            if (!hasDeviceRegister && !hasBdTracker) {
                throw new RuntimeException("no device_register or bdtracker find for push auto start, please set PushStarter.mEnableAutoStart=false and call BDPush.getPushService().start()");
            }
            try {
                Application application = PushSupporter.get().getConfiguration().mApplication;
                if (PushChannelHelper.inst(application).isLocalSupportChannel(23)) {
                    String str = "";
                    if (hasDeviceRegister) {
                        str = m266xa7cfdc18(com.ss.android.deviceregister.base.Oaid.instance(application));
                    } else if (hasBdTracker) {
                        str = m265xdeb29c39(Oaid.instance(application));
                    }
                    if (!TextUtils.isEmpty(str)) {
                        hashMap.put("oaid", str);
                    }
                }
            } catch (Throwable unused) {
            }
            BDPush.getPushService().start(hashMap, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void initPushOnApplication(Application application) {
        AbsBDPushConfiguration absBDPushConfiguration;
        String str = null;
        try {
            absBDPushConfiguration = (AbsBDPushConfiguration) Class.forName("com.bytedance.push.BDPushConfiguration").getConstructor(Application.class).newInstance(application);
            try {
                mEnableAutoInit = absBDPushConfiguration.enableAutoInit();
                mEnableAutoStart = absBDPushConfiguration.enableAutoStart();
            } catch (Throwable th) {
                th = th;
                Log.e("PushStarter", "error when init push:" + th.getLocalizedMessage());
                th.printStackTrace();
                Log.d("PushStarter", "initPushOnApplication, mEnableAutoInit is " + mEnableAutoInit + " mEnableAutoStart is " + mEnableAutoStart);
                if (mEnableAutoInit) {
                }
                if (mEnableAutoStart) {
                    return;
                } else {
                    return;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            absBDPushConfiguration = null;
        }
        Log.d("PushStarter", "initPushOnApplication, mEnableAutoInit is " + mEnableAutoInit + " mEnableAutoStart is " + mEnableAutoStart);
        if (mEnableAutoInit) {
            BDPush.getPushService().initOnApplication(absBDPushConfiguration);
        }
        if (mEnableAutoStart || !ToolUtils.isMainProcess(application)) {
            return;
        }
        try {
            str = DeviceRegisterManager.getDeviceId();
            hasDeviceRegister = true;
        } catch (NoClassDefFoundError unused) {
            hasDeviceRegister = false;
        }
        Log.d("PushStarter", "initPushOnApplication, hasDeviceRegister is " + hasDeviceRegister + " deviceId is " + str);
        if (hasDeviceRegister) {
            if (TextUtils.isEmpty(str)) {
                DeviceRegisterManager.addOnDeviceConfigUpdateListener(PushOnDeviceConfigUpdateListener.onDeviceConfigUpdateListener);
                str = DeviceRegisterManager.getDeviceId();
            }
            Log.d("PushStarter", "initPushOnApplication, deviceId from deviceRegister is " + str);
            if (!TextUtils.isEmpty(str)) {
                long autoStartPushDelayInMill = ((PushOnlineSettings) SettingsManager.obtain(application, PushOnlineSettings.class)).autoStartPushDelayInMill();
                Log.d("PushStarter", "did is not null,start push after " + autoStartPushDelayInMill + " mill");
                PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.starter.PushStarter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PushStarter.startPush();
                    }
                }, autoStartPushDelayInMill);
            }
        }
        try {
            str = com.bytedance.applog.AppLog.getDid();
            hasBdTracker = true;
        } catch (NoClassDefFoundError unused2) {
            hasBdTracker = false;
        }
        Log.d("PushStarter", "initPushOnApplication, hasBdTracker is " + hasBdTracker + " deviceId is " + str);
        if (hasBdTracker) {
            if (TextUtils.isEmpty(str)) {
                com.bytedance.applog.AppLog.addDataObserver(PushDataObserver.iDataObserver);
                str = com.bytedance.applog.AppLog.getDid();
                Log.d("PushStarter", "initPushOnApplication, deviceId from bdTracker is " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long autoStartPushDelayInMill2 = ((PushOnlineSettings) SettingsManager.obtain(application, PushOnlineSettings.class)).autoStartPushDelayInMill();
                Log.d("PushStarter", "did is not null,start push after " + autoStartPushDelayInMill2 + " mill");
                PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.starter.PushStarter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PushStarter.startPush();
                    }
                }, autoStartPushDelayInMill2);
            }
        }
        if (!hasBdTracker && !hasDeviceRegister) {
            throw new RuntimeException("no device_register or bdtracker find for push auto start, please set PushStarter.mEnableAutoStart=false and call BDPush.getPushService().start()");
        }
    }
}
