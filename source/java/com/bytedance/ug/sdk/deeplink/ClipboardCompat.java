package com.bytedance.ug.sdk.deeplink;

import android.content.ClipData;
import android.content.Context;
import android.util.Pair;
import com.bytedance.ug.sdk.deeplink.interfaces.IClipboard;
import com.bytedance.ug.sdk.deeplink.settings.ZlinkSettingsApi;
import com.bytedance.ug.sdk.deeplink.utils.EventUtil;
import com.bytedance.ug.sdk.deeplink.utils.UGZlinkLogger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ClipboardCompat {
    public static ClipData getClipBoardContent(Context context) {
        if (ZlinkSettingsApi.isForbidCheckClipboard(GlobalContext.INSTANCE.getApplication())) {
            UGZlinkLogger.onForbidCheckClipBoard();
            return null;
        }
        Pair<Boolean, ClipData> shouldGetClipBoardContent = ClipboardUtils.shouldGetClipBoardContent(context);
        UGZlinkLogger.onGetClipData(shouldGetClipBoardContent);
        if (((Boolean) shouldGetClipBoardContent.first).booleanValue()) {
            if (HostCommonServices.enableClipboardOutside()) {
                IClipboard iClipboard = (IClipboard) ZlinkProviderManager.getProvider(IClipboard.class);
                if (iClipboard == null) {
                    return null;
                }
                EventUtil.sendGetClipboardEvent();
                return iClipboard.getClipBoardContent(context);
            }
            return ClipboardUtils.getClipBoardContent(context);
        }
        return (ClipData) shouldGetClipBoardContent.second;
    }

    public static void clearClipBoard(Context context, String str, ClipData clipData) {
        if (ZlinkSettingsApi.isForbidCheckClipboard(context)) {
            return;
        }
        if (HostCommonServices.enableClipboardOutside()) {
            IClipboard iClipboard = (IClipboard) ZlinkProviderManager.getProvider(IClipboard.class);
            if (iClipboard != null) {
                iClipboard.clearClipBoard(context, str, clipData);
                return;
            }
            return;
        }
        ClipboardUtils.clearClipBoard(context, str, clipData);
    }

    public static void clearClipBoard(Context context) {
        if (ZlinkSettingsApi.isForbidCheckClipboard(context)) {
            return;
        }
        if (HostCommonServices.enableClipboardOutside()) {
            IClipboard iClipboard = (IClipboard) ZlinkProviderManager.getProvider(IClipboard.class);
            if (iClipboard != null) {
                iClipboard.clearClipBoard(context);
                return;
            }
            return;
        }
        ClipboardUtils.clearClipBoard(context);
    }

    public static void appendTextToClipboard(Context context, CharSequence charSequence) {
        if (ZlinkSettingsApi.isForbidCheckClipboard(context)) {
            return;
        }
        if (HostCommonServices.enableClipboardOutside()) {
            IClipboard iClipboard = (IClipboard) ZlinkProviderManager.getProvider(IClipboard.class);
            if (iClipboard != null) {
                iClipboard.appendTextToClipboard(context, charSequence);
                return;
            }
            return;
        }
        ClipboardUtils.appendTextToClipboard(context, charSequence);
    }

    public static void writeClipBoard(Context context, CharSequence charSequence, CharSequence charSequence2) {
        if (ZlinkSettingsApi.isForbidCheckClipboard(context)) {
            return;
        }
        if (HostCommonServices.enableClipboardOutside()) {
            IClipboard iClipboard = (IClipboard) ZlinkProviderManager.getProvider(IClipboard.class);
            if (iClipboard != null) {
                iClipboard.writeClipBoard(context, charSequence, charSequence2);
                return;
            }
            return;
        }
        ClipboardUtils.writeClipBoard(context, charSequence, charSequence2);
    }
}
