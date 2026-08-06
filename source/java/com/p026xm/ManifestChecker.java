package com.p026xm;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.utils.Component;
import com.bytedance.push.utils.ManifestUtils;
import com.ttnet.org.chromium.base.TTProcessUtils;
import java.util.Arrays;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class ManifestChecker {
    ManifestChecker() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean checkManifest(String str, Context context) throws PackageManager.NameNotFoundException {
        return checkComponents(context, str) & checkKeys(str) & checkPermission(context, str);
    }

    private static boolean checkPermission(Context context, String str) throws PackageManager.NameNotFoundException {
        return ManifestUtils.checkPermissions(context, str, "MiPush", Arrays.asList("android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.VIBRATE", context.getPackageName() + ".permission.MIPUSH_RECEIVE"));
    }

    private static boolean checkComponents(Context context, String str) throws PackageManager.NameNotFoundException {
        return ManifestUtils.checkReceiver(context, str, "MiPush Error", Arrays.asList(Component.Builder.create("com.xiaomi.push.service.receivers.PingReceiver").setProcess(new StringBuilder().append(context.getPackageName()).append(TTProcessUtils.MESSAGE_PROCESS_SERVICE_SUFFIX).toString()).addIntentFilter(new Component.IntentFilter(Arrays.asList("com.xiaomi.push.PING_TIMER"))).build(), Component.Builder.create("com.xiaomi.push.service.receivers.MIPushMessageHandler").setProcess(context.getPackageName()).addIntentFilter(new Component.IntentFilter(Arrays.asList("com.xiaomi.mipush.RECEIVE_MESSAGE"))).addIntentFilter(new Component.IntentFilter(Arrays.asList("com.xiaomi.mipush.MESSAGE_ARRIVED"))).addIntentFilter(new Component.IntentFilter(Arrays.asList("com.xiaomi.mipush.ERROR"))).build())) && ManifestUtils.checkService(context, str, "MiPush Error", Arrays.asList(Component.Builder.create("com.xiaomi.push.service.XMPushService").setProcess(new StringBuilder().append(context.getPackageName()).append(TTProcessUtils.MESSAGE_PROCESS_SERVICE_SUFFIX).toString()).build(), Component.Builder.create("com.xiaomi.push.service.XMJobService").setProcess(new StringBuilder().append(context.getPackageName()).append(TTProcessUtils.MESSAGE_PROCESS_SERVICE_SUFFIX).toString()).setPermission("android.permission.BIND_JOB_SERVICE").build(), Component.Builder.create("com.xiaomi.mipush.sdk.PushMessageHandler").setProcess(context.getPackageName()).build(), Component.Builder.create("com.xiaomi.mipush.sdk.MessageHandleService").setProcess(context.getPackageName()).build()));
    }

    private static boolean checkKeys(String str) {
        Pair pushConfig = PushSupporter.thirdService().getPushConfig(MiPushAdapter.getMiPush());
        if (pushConfig != null && !TextUtils.isEmpty((CharSequence) pushConfig.first) && !TextUtils.isEmpty((CharSequence) pushConfig.second)) {
            return true;
        }
        PushSupporter.logger().e(str, "Mipush key configuration error, missing key configuration");
        return false;
    }
}
