package com.bytedance.push.legacy;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.common.push.interfaze.IAccountService;
import com.bytedance.push.Configuration;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.alive.AliveKeeperProxy;
import com.bytedance.push.interfaze.ISDKMonitor;
import com.bytedance.push.monitor.PushSDKMonitor;
import com.bytedance.push.safe.IPassThoughMsgCache;
import com.bytedance.push.safe.PassThoughMsgCache;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.utils.RomVersionParamHelper;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.IMessageContext;
import com.ss.android.pushmanager.app.MessageAppHooks;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MessageData {
    public static void setLegacyImpl() {
        UgBusFramework.registerService(MessageAppHooks.InitHook.class, new MessageAppHooks.InitHook() { // from class: com.bytedance.push.legacy.MessageData.1
            public void tryInit(Context context) {
                AppProvider.initApp(Configuration.get().mApplication);
            }
        });
        UgBusFramework.registerService(MessageAppHooks.PushHook.class, new MessageAppHooks.PushHook() { // from class: com.bytedance.push.legacy.MessageData.2
            public String getMessageAction() {
                return "com.ss.android.message";
            }

            public String getMessageKeyData() {
                return "message_data";
            }

            public IMessageContext getMessageContext() {
                return MessageContext.getInstance();
            }

            public void onEvent(Context context, String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
                if (Configuration.get().mEventCallback != null) {
                    Configuration.get().mEventCallback.onEvent(context, str, str2, str3, j, j2, jSONObject);
                }
            }

            public void onEventV3(String str, JSONObject jSONObject) {
                if (Configuration.get().mEventCallback != null) {
                    Configuration.get().mEventCallback.onEventV3(str, jSONObject);
                }
            }

            public void onEventV3(String str, Bundle bundle) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                if (bundle != null) {
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject.put(str2, bundle.get(str2));
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                onEventV3(str, jSONObject);
            }

            public boolean isSswoActivityisFinish() {
                return AliveKeeperProxy.inst(Configuration.get().mApplication).isSswoActivityFinish();
            }

            public Map<String, String> getHttpCommonParams() {
                return PushSupporter.get().getCommonParams();
            }

            public boolean needControlFlares() {
                Application application = Configuration.get().mApplication;
                if (ToolUtils.isMainProcess(application)) {
                    if (((PushOnlineSettings) SettingsManager.obtain(Configuration.get().mApplication, PushOnlineSettings.class)).removeAllAutoBoot()) {
                        return true;
                    }
                    return ((PushOnlineSettings) SettingsManager.obtain(Configuration.get().mApplication, PushOnlineSettings.class)).needControlFlares() && RomVersionParamHelper.isMiui12();
                }
                SharedPreferences sharedPreferences = application.getSharedPreferences("push_multi_process_config", 0);
                if (sharedPreferences.getBoolean(PushOnlineSettings.KEY_REMOVE_AUTO_BOOT, false)) {
                    return true;
                }
                return sharedPreferences.getBoolean("need_control_miui_flares_v2", true) && RomVersionParamHelper.isMiui12();
            }
        });
        UgBusFramework.registerService(IPassThoughMsgCache.class, new PassThoughMsgCache());
        UgBusFramework.registerService(IAccountService.class, Configuration.get().mAccountService);
        UgBusFramework.registerService(ISDKMonitor.class, new PushSDKMonitor());
    }
}
