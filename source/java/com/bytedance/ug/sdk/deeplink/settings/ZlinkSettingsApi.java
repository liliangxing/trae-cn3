package com.bytedance.ug.sdk.deeplink.settings;

import android.content.Context;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.bytedance.ug.sdk.deeplink.GlobalContext;
import com.bytedance.ug.sdk.deeplink.HostCommonServices;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import com.bytedance.ug.sdk.deeplink.fission.CallbackForFission;
import com.bytedance.ug.sdk.deeplink.utils.CollectionsUtils;
import com.bytedance.ug.sdk.deeplink.utils.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ZlinkSettingsApi {
    private static final String TAG = "ZlinkSettingsApi";
    private static List<WeakReference<SettingsUpdateListener>> sListenerRef = Collections.synchronizedList(new ArrayList());

    private ZlinkSettingsApi() {
    }

    public static boolean isRequested() {
        return RequestServiceImpl.isRequested();
    }

    public static boolean isRequestedOrHasSettingsCache() {
        IZlinkDepend zlinkDepend = HostCommonServices.getZlinkDepend();
        if (zlinkDepend == null || !zlinkDepend.settingsRefactorEnable()) {
            return RequestServiceImpl.isRequested();
        }
        return RequestServiceImpl.isRequested() || ZlinkSettingsCacheHelper.hasSettingsDataCache(GlobalContext.INSTANCE.getApplication());
    }

    public static void updateSettings() {
        ZlinkSettingsManager.updateSettings("host");
    }

    public static void updateSettingsIfNeed() {
        ZlinkSettingsManager.updateSettingsIfNeed();
    }

    public static List<String> getAppLinkHostList(Context context) {
        return ZlinkSettingsCacheHelper.getList(context, "deeplink_domains", new ArrayList());
    }

    public static Map<String, String> getRouterInfoList(Context context) {
        return ZlinkSettingsCacheHelper.getMap(context, "deeplink_router_info", new HashMap());
    }

    public static int getRequestTimeout(Context context) {
        return ZlinkSettingsCacheHelper.getInt(context, "deeplink_timeout", 60000);
    }

    public static long getSettingsUpdateInterval(Context context) {
        return ZlinkSettingsCacheHelper.getLong(context, "update_settings_interval", 3600L);
    }

    public static long getSettingsTime(Context context) {
        return ZlinkSettingsCacheHelper.getLong(context, CommonConstants.KEY_SETTINGS_TIME, 0L);
    }

    public static long getAppLinkInterval(Context context) {
        return ZlinkSettingsCacheHelper.getLong(context, "settings_app_link_interval", 1000L);
    }

    public static long getTimeoutForClipboardVerify(Context context) {
        return ZlinkSettingsCacheHelper.getLong(context, SettingsConstant.KEY_CLIPBOARD_VERIFY_TIMEOUT, 0L);
    }

    public static String getRouterScheme(Context context) {
        return ZlinkSettingsCacheHelper.getString(context, "deeplink_router_scheme", "");
    }

    public static long getValidTime(Context context) {
        return ZlinkSettingsCacheHelper.getLong(context, "deeplink_router_valid_time", 0L);
    }

    public static boolean isForbidCheckClipboard(Context context) {
        boolean z = ZlinkSettingsCacheHelper.getBoolean(context, "deeplink_forbid_check_clipboard", true);
        boolean isForbiddenClipboardByHost = HostCommonServices.isForbiddenClipboardByHost();
        Logger.m449i(TAG, "forbiddenBySettings= " + z + ", forbiddenByHost= " + isForbiddenClipboardByHost);
        return z || isForbiddenClipboardByHost;
    }

    public static boolean enableSDKMonitor(Context context) {
        return ZlinkSettingsCacheHelper.getBoolean(context, "enable_sdk_monitor", true);
    }

    public static boolean isEnableDevicePrint(Context context) {
        return ZlinkSettingsCacheHelper.getBoolean(context, "deeplink_enable_device_print", true);
    }

    public static boolean isEnableDevicePrintVerify(Context context) {
        return ZlinkSettingsCacheHelper.getBoolean(context, "deeplink_device_fingerprint_ab", true);
    }

    public static List<String> getTokenRegexForFission(Context context) {
        ArrayList arrayList = new ArrayList();
        CallbackForFission callbackForFission = HostCommonServices.getCallbackForFission();
        if (callbackForFission != null && !CollectionsUtils.isEmptyList(callbackForFission.getDefaultTokenRegex())) {
            arrayList.addAll(callbackForFission.getDefaultTokenRegex());
        } else {
            arrayList.add("【[0-9A-Za-z]{5,}】");
            arrayList.add("#[0-9A-Za-z]{5,}#");
            arrayList.add("@[0-9A-Za-z]{5,}@");
            arrayList.add("¥[0-9A-Za-z]{5,}¥");
        }
        return ZlinkSettingsCacheHelper.getList(context, "deeplink_fission_patterns", arrayList);
    }

    public static void addSettingsListener(SettingsUpdateListener settingsUpdateListener) {
        if (settingsUpdateListener != null) {
            for (WeakReference<SettingsUpdateListener> weakReference : sListenerRef) {
                if (weakReference != null && weakReference.get() == settingsUpdateListener) {
                    return;
                }
            }
            sListenerRef.add(new WeakReference<>(settingsUpdateListener));
        }
    }

    public static void removeSettingsListener(SettingsUpdateListener settingsUpdateListener) {
        if (settingsUpdateListener != null) {
            Iterator<WeakReference<SettingsUpdateListener>> it = sListenerRef.iterator();
            while (it.hasNext()) {
                WeakReference<SettingsUpdateListener> next = it.next();
                if (next != null && next.get() == settingsUpdateListener) {
                    it.remove();
                }
            }
        }
    }

    public static void notifySettingsListeners() {
        SettingsUpdateListener settingsUpdateListener;
        int size = sListenerRef.size();
        for (int i = 0; i < size; i++) {
            WeakReference<SettingsUpdateListener> weakReference = sListenerRef.get(i);
            if (weakReference != null && (settingsUpdateListener = weakReference.get()) != null) {
                try {
                    settingsUpdateListener.onSettingsUpdateListener();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
