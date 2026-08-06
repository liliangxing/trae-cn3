package com.bytedance.push.third;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.alive.AliveKeeperProxy;
import com.bytedance.push.debug.ManifestChecker;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.app.MessageAppHooks;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushManager implements IPushAdapter {
    private static final String TAG = "PushManager";
    private static volatile PushManager sPushManager;

    @Override // com.bytedance.push.third.IPushAdapter
    public boolean requestRemoveVoipNotification(Context context, int i) {
        return false;
    }

    private PushManager() {
    }

    public static PushManager inst() {
        if (sPushManager == null) {
            synchronized (PushManager.class) {
                if (sPushManager == null) {
                    sPushManager = new PushManager();
                }
            }
        }
        return sPushManager;
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public boolean isPushAvailable(Context context, int i) {
        IPushAdapter adapterInstance = PushChannelHelper.inst(context).getAdapterInstance(i);
        if (adapterInstance == null) {
            return false;
        }
        try {
            return adapterInstance.isPushAvailable(context, i);
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void registerPush(Context context, int i) {
        IPushAdapter adapterInstance = PushChannelHelper.inst(context).getAdapterInstance(i);
        if (adapterInstance != null) {
            try {
                if (!needDisableChannelInvoke(context, i)) {
                    Logger.m278w(TAG, "allowPushProcess is true so allow start register " + i);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("channel", i);
                    UgBusFramework.getService(MessageAppHooks.PushHook.class).onEventV3("push_registered", jSONObject);
                    PushSupporter.monitor().monitorRegisterSender(i);
                    PushSupporter.get().getTokenRetryService().onPushAdapterRegister(i);
                    adapterInstance.registerPush(context, i);
                    PushSupporter.get().getIProfileIdService().onPushAdapterRegister(adapterInstance);
                } else {
                    Logger.m278w(TAG, "allowPushProcess is false so not register " + i);
                }
            } catch (Throwable th) {
                Logger.m271e(TAG, "the exception is occurred when registerPush for " + i + " and message is " + th.getMessage());
            }
        }
    }

    public boolean needDisableChannelInvoke(Context context, int i) {
        if (!PushChannelHelper.inst(context).isSysChannel(i)) {
            boolean z = ToolUtils.isSmpProcess(context) && !PushServiceManager.get().getIAllianceService().allowStartOthersProcessFromSmp();
            if (z && i == 21) {
                boolean allowSyncInSmpWhenProcessIsolate = PushServiceManager.get().getIAllianceService().allowSyncInSmpWhenProcessIsolate();
                Logger.m268d(TAG, "try register sync,allowSyncInSmpWhenProcessIsolate is " + allowSyncInSmpWhenProcessIsolate);
                if (allowSyncInSmpWhenProcessIsolate) {
                    z = false;
                }
            }
            boolean needDisableWhenStrictMode = PushChannelHelper.inst(context).needDisableWhenStrictMode(i);
            boolean z2 = needDisableWhenStrictMode && !PushSupporter.get().getProcessManagerService().allowStartNonMainProcess();
            r1 = z || z2;
            Logger.m278w(TAG, "allowPushProcess is " + (!r1) + " because needDisablePushProcessOnSmpProcess is " + z + " and needDisableWhenStrictMode is " + needDisableWhenStrictMode + " and needDisableNonMainProcess is " + z2);
        }
        return r1;
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void setAlias(Context context, String str, int i) {
        IPushAdapter adapterInstance = PushChannelHelper.inst(context).getAdapterInstance(i);
        if (adapterInstance != null) {
            try {
                adapterInstance.setAlias(context, str, i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void unregisterPush(Context context, int i) {
        IPushAdapter adapterInstance = PushChannelHelper.inst(context).getAdapterInstance(i);
        if (adapterInstance != null) {
            try {
                if (!needDisableChannelInvoke(context, i)) {
                    Logger.m278w(TAG, "allowPushProcess is true so allow start unregister " + i);
                    adapterInstance.unregisterPush(context, i);
                    PushSupporter.get().getIProfileIdService().onPushAdapterUnregister(adapterInstance);
                } else {
                    Logger.m278w(TAG, "allowPushProcess is false so not unregister " + i);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void trackPush(Context context, int i, Object obj) {
        IPushAdapter adapterInstance = PushChannelHelper.inst(context).getAdapterInstance(i);
        if (adapterInstance != null) {
            try {
                adapterInstance.trackPush(context, i, obj);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public boolean checkThirdPushConfig(String str, Context context) {
        Iterator it = PushChannelHelper.inst(context).getChannels().iterator();
        boolean z = true;
        while (it.hasNext()) {
            IPushAdapter adapterInstance = PushChannelHelper.inst(context).getAdapterInstance(((Integer) it.next()).intValue());
            if (adapterInstance != null) {
                try {
                    z &= adapterInstance.checkThirdPushConfig(str, context);
                } catch (Throwable th) {
                    th.printStackTrace();
                    Logger.m271e(str, "check pushType error: " + Log.getStackTraceString(th));
                    z = false;
                }
            }
        }
        try {
            return ManifestChecker.checkConfig(context, str) & z & AliveKeeperProxy.inst(context).checkConfig(str);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Logger.m271e(str, "check pushType error: " + Log.getStackTraceString(e));
            return false;
        }
    }
}
