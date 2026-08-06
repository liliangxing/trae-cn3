package com.bytedance.ug.sdk.share.impl.manager;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.depend.IDYShareConfig;
import com.bytedance.ug.sdk.share.api.depend.IShareImageTokenConfig;
import com.bytedance.ug.sdk.share.api.depend.IShareQrScanConfig;
import com.bytedance.ug.sdk.share.api.depend.IShareTokenRuleConfig;
import com.bytedance.ug.sdk.share.api.depend.IShareUIConfig;
import com.bytedance.ug.sdk.share.api.depend.IShareVideoWmConfig;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.constant.ShareChannelConstants;
import com.bytedance.ug.sdk.share.impl.share.api.IShareChannelDepend;
import com.bytedance.ug.sdk.share.impl.utils.Logger;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DependManager {
    private static IDYShareConfig sDYConfig;
    private static IShareImageTokenConfig sImageTokenConfig;
    private static IShareQrScanConfig sQrScanConfig;
    private static IShareTokenRuleConfig sTokenRuleConfig;
    private static IShareUIConfig sUIConfig;
    private static IShareVideoWmConfig sVideoWatermarkConfig;
    private static final ConcurrentHashMap<String, IShareChannelDepend> sChannels = new ConcurrentHashMap<>();
    private static boolean sIsIncludeQrScanLibrary = true;
    private static boolean sIsIncludeImageTokenLibrary = true;
    private static boolean sIsIncludeUILibrary = true;
    private static boolean sIsIncludeDouYinLibrary = true;

    public static IShareChannelDepend getChannel(ShareChannelType shareChannelType) {
        String str = ShareChannelConstants.sShareConfig.get(shareChannelType);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        IShareChannelDepend iShareChannelDepend = sChannels.get(str);
        if (iShareChannelDepend != null) {
            return iShareChannelDepend;
        }
        try {
            iShareChannelDepend = (IShareChannelDepend) Class.forName(str).getConstructor(Context.class).newInstance(ShareSdkManager.getInstance().getAppContext());
        } catch (Throwable th) {
            Logger.m465e(th.toString());
        }
        if (iShareChannelDepend != null) {
            sChannels.put(str, iShareChannelDepend);
        }
        return iShareChannelDepend;
    }

    public static IShareQrScanConfig getQrScanConfig() {
        if (!sIsIncludeQrScanLibrary) {
            return null;
        }
        IShareQrScanConfig iShareQrScanConfig = sQrScanConfig;
        if (iShareQrScanConfig != null) {
            return iShareQrScanConfig;
        }
        try {
            sQrScanConfig = (IShareQrScanConfig) Class.forName("com.bytedance.ug.sdk.share.keep.impl.QrScanConfigImpl").newInstance();
        } catch (Throwable unused) {
            sIsIncludeQrScanLibrary = false;
        }
        return sQrScanConfig;
    }

    public static IShareVideoWmConfig getVideoWatermarkConfig() {
        IShareVideoWmConfig iShareVideoWmConfig = sVideoWatermarkConfig;
        if (iShareVideoWmConfig != null) {
            return iShareVideoWmConfig;
        }
        try {
            sVideoWatermarkConfig = (IShareVideoWmConfig) Class.forName("com.bytedance.ug.sdk.share.keep.impl.VideoWatermarkConfigImpl").newInstance();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sVideoWatermarkConfig;
    }

    public static IShareImageTokenConfig getImageTokenConfig() {
        if (!sIsIncludeImageTokenLibrary) {
            return null;
        }
        IShareImageTokenConfig iShareImageTokenConfig = sImageTokenConfig;
        if (iShareImageTokenConfig != null) {
            return iShareImageTokenConfig;
        }
        try {
            sImageTokenConfig = (IShareImageTokenConfig) Class.forName("com.bytedance.ug.sdk.share.keep.impl.ImageTokenConfigImpl").newInstance();
        } catch (Throwable unused) {
            sIsIncludeImageTokenLibrary = false;
        }
        return sImageTokenConfig;
    }

    public static IShareTokenRuleConfig getTokenRuleConfig() {
        IShareTokenRuleConfig iShareTokenRuleConfig = sTokenRuleConfig;
        if (iShareTokenRuleConfig != null) {
            return iShareTokenRuleConfig;
        }
        try {
            sTokenRuleConfig = (IShareTokenRuleConfig) Class.forName("com.bytedance.ug.sdk.share.keep.impl.ShareTokenRuleConfigImpl").newInstance();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sTokenRuleConfig;
    }

    public static IShareUIConfig getUIConfig() {
        if (!sIsIncludeUILibrary) {
            return null;
        }
        IShareUIConfig iShareUIConfig = sUIConfig;
        if (iShareUIConfig != null) {
            return iShareUIConfig;
        }
        try {
            sUIConfig = (IShareUIConfig) Class.forName("com.bytedance.ug.sdk.share.keep.impl.UIConfigImpl").newInstance();
        } catch (Throwable unused) {
            sIsIncludeUILibrary = false;
        }
        return sUIConfig;
    }

    public static IDYShareConfig getDYShareConfig() {
        if (!sIsIncludeDouYinLibrary) {
            return null;
        }
        IDYShareConfig iDYShareConfig = sDYConfig;
        if (iDYShareConfig != null) {
            return iDYShareConfig;
        }
        try {
            sDYConfig = (IDYShareConfig) Class.forName("com.bytedance.ug.sdk.share.keep.impl.DouYinConfigImpl").newInstance();
        } catch (Throwable unused) {
            sIsIncludeDouYinLibrary = false;
        }
        return sDYConfig;
    }
}
