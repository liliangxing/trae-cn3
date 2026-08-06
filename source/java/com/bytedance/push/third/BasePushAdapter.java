package com.bytedance.push.third;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import com.bytedance.platform.thread.Constants;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.RomVersionParamHelper;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class BasePushAdapter {
    public static final int REQUEST_CODE_REQUEST_NOTIFICATION_PERMISSION_BY_CUSTOM_DIALOG = 61521;
    public static final int REQUEST_CODE_REQUEST_NOTIFICATION_PERMISSION_BY_SYS_DIALOG = 61520;
    public static final int SYS_ALERT_STYLE_CUSTOM = 1;
    public static final int SYS_ALERT_STYLE_ORIGIN = 0;
    protected String mCurScenes;
    protected RequestResultCallback mRequestResultCallback;
    public final int PROFILE_STATUS_UNKNOWN = -1;
    public final int PROFILE_STATUS_SETTINGS_NOT_ENABLE = 0;
    public final int PROFILE_STATUS_SUCCESS = 1;
    public final int PROFILE_STATUS_PROFILE_ID_IS_EMPTY = 2;
    public final int PROFILE_STATUS_NOT_SUPPORT = 3;
    public final int PROFILE_STATUS_TIMEOUT = 4;
    public final int PROFILE_STATUS_EXCEPTION = 5;
    public final int PROFILE_STATUS_SYS_FAILED = 6;
    public final long PROFILE_ID_OPERATE_TIMEOUT = Constants.TASK_WAIT_THRESHOLD;
    protected boolean hasCallbackShowResult = false;
    protected boolean hasCallbackClickResult = false;

    public abstract int getPushType();

    public abstract String isBusinessAlertDialogAvailable(Context context, boolean z);

    public boolean setProfileId(Context context, String str) {
        Logger.m268d(getClass().getName(), "[setProfileId]default implement");
        return false;
    }

    public boolean deleteProfileId(Context context, String str) {
        Logger.m268d(getClass().getName(), "[deleteProfileId]default implement");
        return false;
    }

    public void onSetProfileIdResult(final int i, long j, final int i2, final String str) {
        final long currentTimeMillis = System.currentTimeMillis() - j;
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.third.BasePushAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                PushServiceManager.get().getPushExternalService().getPushSdkMonitorService().onProfileIdOperateResult(1, i, i2, currentTimeMillis, str);
            }
        });
    }

    public void onDeleteProfileIdResult(final int i, long j, final int i2, final String str) {
        final long currentTimeMillis = System.currentTimeMillis() - j;
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.third.BasePushAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                PushServiceManager.get().getPushExternalService().getPushSdkMonitorService().onProfileIdOperateResult(2, i, i2, currentTimeMillis, str);
            }
        });
    }

    public boolean requestNotificationPermission(String str, int i, int i2, RequestResultCallback requestResultCallback) {
        Logger.m268d(getClass().getName(), "[requestNotificationPermission]default implement");
        return false;
    }

    public boolean requestOpNotificationPermission(int i) {
        Logger.m268d(getClass().getName(), "[requestOpNotificationPermission]default implement");
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Logger.m268d(getClass().getName(), "[onActivityResult]default implement");
    }

    protected synchronized void onGuideRequestResult(String str, int i, String str2, boolean z, String str3, RequestResultCallback requestResultCallback) {
        onGuideRequestResult(str, i, str2, z, str3, 0, requestResultCallback);
    }

    protected void addCommonEventParams(JSONObject jSONObject) {
        try {
            jSONObject.put("os_detail_type", RomVersionParamHelper.isHarmonyOs() ? "harmony" : "android");
            String harmonyOsVersion = RomVersionParamHelper.getHarmonyOsVersion();
            if (!TextUtils.isEmpty(harmonyOsVersion)) {
                jSONObject.put("extra_rom_version", harmonyOsVersion);
            }
            jSONObject.put("device_manufacturer", Build.MANUFACTURER.toLowerCase());
        } catch (Throwable th) {
            Logger.m271e(getClass().getName(), "[addCommonEventParams]exception:" + th.getLocalizedMessage());
        }
    }

    protected synchronized void onGuideRequestResult(String str, int i, String str2, boolean z, String str3, int i2, RequestResultCallback requestResultCallback) {
        Logger.m268d(getClass().getName(), "[onGuideRequestResult]hasCallbackShowResult:" + this.hasCallbackShowResult);
        if (this.hasCallbackShowResult) {
            return;
        }
        this.hasCallbackShowResult = true;
        if (i2 == 0) {
            PushServiceManager.get().getIPermissionBootExternalService().onNotificationPermissionDialogRequestResultEvent(str, str2, i2, i, z, str3);
        }
        if (requestResultCallback != null) {
            requestResultCallback.onRequestResult(z, str3);
        }
    }
}
