package com.bytedance.ug.sdk.deeplink.callback;

import android.content.ClipData;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ug.sdk.deeplink.CallBackForAppLink;
import com.bytedance.ug.sdk.deeplink.ClipboardCompat;
import com.bytedance.ug.sdk.deeplink.ClipboardTrace;
import com.bytedance.ug.sdk.deeplink.GlobalContext;
import com.bytedance.ug.sdk.deeplink.HostCommonServices;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import com.bytedance.ug.sdk.deeplink.IZlinkInitCallback;
import com.bytedance.ug.sdk.deeplink.LaunchLogManager;
import com.bytedance.ug.sdk.deeplink.settings.ZlinkSettingsApi;
import com.bytedance.ug.sdk.deeplink.utils.Logger;
import com.bytedance.ug.sdk.deeplink.utils.ThreadUtils;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CallbackManager {
    private static String lastJumpScheme;
    private static long lastJumpTimeMillis;
    private static long sAppLinkInterval = ZlinkSettingsApi.getAppLinkInterval(GlobalContext.INSTANCE.getApplication());
    private static final Set<IZlinkInitCallback> sZlinkInitCallbackSet = new CopyOnWriteArraySet();

    private CallbackManager() {
    }

    public static void addZlinkInitCallback(IZlinkInitCallback iZlinkInitCallback) {
        if (iZlinkInitCallback != null) {
            sZlinkInitCallbackSet.add(iZlinkInitCallback);
        }
    }

    public static void setAppLinkInterval(long j) {
        sAppLinkInterval = j;
    }

    public static void removeZlinkInitCallback(IZlinkInitCallback iZlinkInitCallback) {
        if (iZlinkInitCallback != null) {
            sZlinkInitCallbackSet.remove(iZlinkInitCallback);
        }
    }

    public static void notifyZlinkInit() {
        for (IZlinkInitCallback iZlinkInitCallback : sZlinkInitCallbackSet) {
            if (iZlinkInitCallback != null) {
                iZlinkInitCallback.onInitialized();
            }
        }
    }

    public static void callBackForCheckClipboard(String str, String str2, ClipData clipData) {
        callBackForCheckClipboard(str, str2, clipData, false);
    }

    public static void callBackForCheckClipboard(final String str, final String str2, final ClipData clipData, final boolean z) {
        if (ThreadUtils.isOnMainThread()) {
            doCallBackForCheckClipboard(clipData, str, str2, z);
        } else {
            ThreadUtils.postMainThread(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.callback.CallbackManager.1
                @Override // java.lang.Runnable
                public void run() {
                    CallbackManager.doCallBackForCheckClipboard(clipData, str, str2, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doCallBackForCheckClipboard(ClipData clipData, String str, String str2, boolean z) {
        boolean hasPrimaryClipCalled;
        if (HostCommonServices.enableClipboardOutside()) {
            hasPrimaryClipCalled = clipData == null;
        } else {
            hasPrimaryClipCalled = ClipboardTrace.getHasPrimaryClipCalled();
        }
        IZlinkDepend zlinkDepend = HostCommonServices.getZlinkDepend();
        Logger.m446d("doCallBackForCheckClipboard", "callback dealWithClipboard hasCheckedClipboard:" + hasPrimaryClipCalled + ",decodedText:" + str + ",fromDevicePrint:" + z);
        if (!(zlinkDepend != null ? zlinkDepend.dealWithClipboard(hasPrimaryClipCalled, str, z) : false) || TextUtils.isEmpty(str2)) {
            return;
        }
        ClipboardCompat.clearClipBoard(GlobalContext.INSTANCE.getApplication(), str2, clipData);
    }

    public static void callbackForAppLink(final CallBackForAppLink callBackForAppLink, final String str) {
        if (callBackForAppLink == null) {
            return;
        }
        if (ThreadUtils.isOnMainThread()) {
            if (isRepeatAppLink(str)) {
                return;
            }
            callBackForAppLink.dealWithSchema(str);
            sendLaunchLogForAppLink(str);
            return;
        }
        ThreadUtils.postMainThread(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.callback.CallbackManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (CallbackManager.isRepeatAppLink(str)) {
                    return;
                }
                callBackForAppLink.dealWithSchema(str);
                CallbackManager.sendLaunchLogForAppLink(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isRepeatAppLink(String str) {
        String str2;
        if (lastJumpTimeMillis != 0 && sAppLinkInterval != 0 && System.currentTimeMillis() - lastJumpTimeMillis < sAppLinkInterval && (str2 = lastJumpScheme) != null && str2.equals(str)) {
            Logger.m449i("callbackForAppLink", "callback repeat, scheme = " + str);
            return true;
        }
        lastJumpScheme = str;
        lastJumpTimeMillis = System.currentTimeMillis();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendLaunchLogForAppLink(String str) {
        if (HostCommonServices.enableLaunchLogForAppLink()) {
            Uri parse = Uri.parse(str);
            if (parse.isOpaque()) {
                return;
            }
            String entranceOfLaunchLogForAppLink = HostCommonServices.entranceOfLaunchLogForAppLink();
            LaunchLogManager.getInstance().reportLaunchLogEvent(LaunchLogManager.getInstance().getGdLabel(parse), parse, entranceOfLaunchLogForAppLink, null);
        }
    }
}
