package com.p026xm;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.third.IPushAdapter;
import com.bytedance.push.third.PushChannelHelper;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import com.xiaomi.MiPushSettings;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MiPushAdapter implements IPushAdapter {
    private static int MI_PUSH = -1;

    public boolean isPushAvailable(Context context, int i) {
        return true;
    }

    public void trackPush(Context context, int i, Object obj) {
    }

    public static int getMiPush() {
        if (MI_PUSH == -1) {
            MI_PUSH = PushChannelHelper.inst(AppProvider.getApp()).getChannelId(MiPushAdapter.class.getName());
        }
        return MI_PUSH;
    }

    public void registerPush(Context context, int i) {
        String str = null;
        if (context == null || i != getMiPush()) {
            if (context == null) {
                str = "context is null";
            } else if (i != getMiPush()) {
                str = "channel register failed";
            }
            PushSupporter.monitor().monitorRegisterSenderFailed(i, 101, "0", str);
            return;
        }
        PushSupporter.logger().i("MiPush", "registerMiPush");
        String curProcessName = ToolUtils.getCurProcessName(context);
        if (!TextUtils.isEmpty(curProcessName)) {
            if (curProcessName.endsWith(ToolUtils.SMP_PROCESS_SUFFIX)) {
                ToolUtils.setComponentEnable(context, "com.xiaomi.push.service.receivers.MIPushMessageHandler", false);
                ToolUtils.setComponentEnable(context, "com.xiaomi.push.service.receivers.WidgetProviderMIPushMessageHandler", false);
                ToolUtils.setComponentEnable(context, "com.xiaomi.push.service.receivers.SmpMIPushMessageHandler", true);
            } else if (curProcessName.endsWith(ToolUtils.SMP_PROCESS_SUFFIX_V2)) {
                ToolUtils.setComponentEnable(context, "com.xiaomi.push.service.receivers.MIPushMessageHandler", false);
                ToolUtils.setComponentEnable(context, "com.xiaomi.push.service.receivers.SmpMIPushMessageHandler", false);
                ToolUtils.setComponentEnable(context, "com.xiaomi.push.service.receivers.WidgetProviderMIPushMessageHandler", true);
            }
        }
        try {
            Pair pushConfig = PushSupporter.thirdService().getPushConfig(getMiPush());
            if (pushConfig == null) {
                PushSupporter.monitor().monitorRegisterSenderFailed(i, 106, "0", "configuration is null");
                return;
            }
            doUpgradeMiPush(context);
            MiPushClient.registerPush(context, (String) pushConfig.first, (String) pushConfig.second);
            MiPushClient.resumePush(context.getApplicationContext(), null);
            Logger.setLogger(context, new LoggerInterface() { // from class: com.xm.MiPushAdapter.1
                @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
                public void setTag(String str2) {
                }

                @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
                public void log(String str2, Throwable th) {
                    PushSupporter.logger().i("MiPush", str2, th);
                }

                @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
                public void log(String str2) {
                    PushSupporter.logger().i("MiPush", str2);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void doUpgradeMiPush(Context context) {
        MiPushSettings miPushSettings = (MiPushSettings) SettingsManager.obtain(context, MiPushSettings.class);
        if (miPushSettings.hasUpgradeTo3616()) {
            return;
        }
        miPushSettings.setUpgradeTo3616(true);
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        context.getSharedPreferences("mipush_extra", 0).edit().clear().commit();
        context.getSharedPreferences("mipush", 0).edit().clear().commit();
        context.getSharedPreferences("XMPushServiceConfig", 0).edit().clear().commit();
    }

    public void setAlias(Context context, String str, int i) {
        if (context == null || i != getMiPush()) {
            return;
        }
        PushSupporter.logger().i("MiPush", "setAlias");
        try {
            List<String> allAlias = MiPushClient.getAllAlias(context);
            if (allAlias != null) {
                for (String str2 : allAlias) {
                    if (!TextUtils.isEmpty(str2) && !str2.equals(str)) {
                        MiPushClient.unsetAlias(context, str2, null);
                    }
                }
            }
        } catch (Exception unused) {
        }
        try {
            MiPushClient.setAlias(context, str, null);
        } catch (Exception e) {
            PushSupporter.monitor().monitorRegisterSenderFailed(i, 105, "0", Log.getStackTraceString(e));
            e.printStackTrace();
        }
    }

    public void unregisterPush(Context context, int i) {
        if (context == null || i != getMiPush()) {
            return;
        }
        PushSupporter.logger().i("MiPush", "unregisterMiPush");
        try {
            MiPushClient.pausePush(context.getApplicationContext(), null);
            MiPushClient.unregisterPush(context.getApplicationContext());
        } catch (Throwable unused) {
        }
    }

    public boolean checkThirdPushConfig(String str, Context context) throws Exception {
        return ManifestChecker.checkManifest(str, context);
    }

    public boolean requestRemoveVoipNotification(Context context, int i) {
        MiPushClient.removeWindow(context);
        return true;
    }
}
