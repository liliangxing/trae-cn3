package com.ss.alive.monitor.util;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.common.utility.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class ToolUtils {
    private static List<String> sBlackListActivity;

    public static String getCurProcessName(Context context) {
        return com.ss.android.message.util.ToolUtils.getCurProcessName(context);
    }

    static {
        ArrayList arrayList = new ArrayList();
        sBlackListActivity = arrayList;
        arrayList.add("SswoActivity");
    }

    public static void addBlackListActivity(String str) {
        sBlackListActivity.add(str);
    }

    public static boolean isInBlackList(Activity activity) {
        String className = activity.getComponentName().getClassName();
        for (String str : sBlackListActivity) {
            if (StringUtils.equal(className, str) || className.contains(str)) {
                return true;
            }
        }
        return false;
    }

    public static int getScreenState(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
            if (powerManager == null) {
                return 0;
            }
            if (!powerManager.isInteractive()) {
                return 1;
            }
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (keyguardManager == null) {
                return 0;
            }
            return keyguardManager.inKeyguardRestrictedInputMode() ? 2 : 3;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }
}
