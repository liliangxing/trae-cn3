package com.coloros;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.utils.Component;
import com.bytedance.push.utils.ManifestUtils;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
class ManifestChecker {
    private static boolean checkPermission(Context context, String str) throws PackageManager.NameNotFoundException {
        return true;
    }

    ManifestChecker() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean checkManifest(String str, Context context) throws PackageManager.NameNotFoundException {
        return checkComponents(context, str) & checkKeys(str) & checkPermission(context, str);
    }

    private static boolean checkComponents(Context context, String str) throws PackageManager.NameNotFoundException {
        ArrayList arrayList = new ArrayList();
        Component build = Component.Builder.create("com.heytap.msp.push.service.DataMessageCallbackService").setProcess(context.getPackageName()).setPermission("com.heytap.mcs.permission.SEND_PUSH_MESSAGE").addIntentFilter(new Component.IntentFilter(Collections.singletonList("com.heytap.mcs.action.RECEIVE_MCS_MESSAGE"))).addIntentFilter(new Component.IntentFilter(Collections.singletonList("com.heytap.msp.push.RECEIVE_MCS_MESSAGE"))).build();
        Component build2 = Component.Builder.create("com.heytap.msp.push.service.CompatibleDataMessageCallbackService").setProcess(context.getPackageName()).setPermission("com.coloros.mcs.permission.SEND_MCS_MESSAGE").addIntentFilter(new Component.IntentFilter(Collections.singletonList("com.coloros.mcs.action.RECEIVE_MCS_MESSAGE"))).build();
        arrayList.add(build);
        arrayList.add(build2);
        return ManifestUtils.checkService(context, str, "OPPOPush", arrayList);
    }

    private static boolean checkKeys(String str) {
        Pair pushConfig = PushSupporter.thirdService().getPushConfig(OpPushAdapter.getOpPush());
        if (pushConfig != null && !TextUtils.isEmpty((CharSequence) pushConfig.first) && !TextUtils.isEmpty((CharSequence) pushConfig.second)) {
            return true;
        }
        PushSupporter.logger().e(str, "OPPO error，oppo key configuration is incorrect");
        return false;
    }
}
