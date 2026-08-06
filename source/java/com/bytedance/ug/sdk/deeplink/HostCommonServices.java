package com.bytedance.ug.sdk.deeplink;

import com.bytedance.ug.sdk.deeplink.fission.CallbackForFission;
import java.util.List;

/* loaded from: classes4.dex */
public class HostCommonServices {
    private static ZlinkDependAbility sZlinkDependAbility;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setZlinkDependAbility(ZlinkDependAbility zlinkDependAbility) {
        sZlinkDependAbility = zlinkDependAbility;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAutoCheck() {
        ZlinkDependAbility zlinkDependAbility = sZlinkDependAbility;
        return zlinkDependAbility != null && zlinkDependAbility.getAutoCheck();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isEnableHuaWeiReferrer() {
        ZlinkDependAbility zlinkDependAbility = sZlinkDependAbility;
        return zlinkDependAbility != null && zlinkDependAbility.isEnableHuaWeiReferrer();
    }

    public static boolean isDebug() {
        ZlinkDependAbility zlinkDependAbility = sZlinkDependAbility;
        return zlinkDependAbility != null && zlinkDependAbility.isDebug();
    }

    public static boolean isConfirmedPrivacy() {
        if (getZlinkDepend() != null) {
            return getZlinkDepend().isConfirmedPrivacy();
        }
        return false;
    }

    public static IZlinkDepend getZlinkDepend() {
        ZlinkDependAbility zlinkDependAbility = sZlinkDependAbility;
        if (zlinkDependAbility == null) {
            return null;
        }
        return zlinkDependAbility.getZlinkDepend();
    }

    public static CallBackForAppLink getCallBackForAppLink() {
        ZlinkDependAbility zlinkDependAbility = sZlinkDependAbility;
        if (zlinkDependAbility == null) {
            return null;
        }
        return zlinkDependAbility.getCallBackForAppLink();
    }

    public static boolean enableClipboardOutside() {
        ZlinkDependAbility zlinkDependAbility = sZlinkDependAbility;
        if (zlinkDependAbility == null) {
            return false;
        }
        return zlinkDependAbility.getEnableClipboardOutside();
    }

    public static boolean isForbiddenClipboardByHost() {
        ZlinkDependAbility zlinkDependAbility = sZlinkDependAbility;
        if (zlinkDependAbility == null) {
            return false;
        }
        return zlinkDependAbility.isForbiddenCheckClipBoard();
    }

    public static void setForbiddenClipboardByHost(boolean z) {
        ZlinkDependAbility zlinkDependAbility = sZlinkDependAbility;
        if (zlinkDependAbility == null) {
            return;
        }
        zlinkDependAbility.setForbiddenClipboardByHost(z);
    }

    public static CallbackForFission getCallbackForFission() {
        ZlinkDependAbility zlinkDependAbility = sZlinkDependAbility;
        if (zlinkDependAbility == null) {
            return null;
        }
        return zlinkDependAbility.getCallbackForFission();
    }

    public static List<String> getForbiddenActivityList() {
        ZlinkDependAbility zlinkDependAbility = sZlinkDependAbility;
        if (zlinkDependAbility == null) {
            return null;
        }
        return zlinkDependAbility.getForbiddenActivityList();
    }

    public static String getSettingHost() {
        ZlinkDependAbility zlinkDependAbility = sZlinkDependAbility;
        if (zlinkDependAbility == null) {
            return null;
        }
        return zlinkDependAbility.getSettingHost();
    }

    public static boolean enableLaunchLogForAppLink() {
        ZlinkDependAbility zlinkDependAbility = sZlinkDependAbility;
        if (zlinkDependAbility == null) {
            return false;
        }
        return zlinkDependAbility.enableLaunchLogForAppLink();
    }

    public static String entranceOfLaunchLogForAppLink() {
        ZlinkDependAbility zlinkDependAbility = sZlinkDependAbility;
        if (zlinkDependAbility == null) {
            return null;
        }
        return zlinkDependAbility.entranceOfLaunchLogForAppLink();
    }
}
