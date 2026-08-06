package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.AhUtils;
import com.ss.android.socialbase.appdownloader.constants.Constants;
import com.ss.android.socialbase.appdownloader.depend.IDownloadAppInstallHandler;
import com.ss.android.socialbase.appdownloader.p004ah.AbsDevicePlan;
import com.ss.android.socialbase.appdownloader.p004ah.AndroidUnknownSourcePlan;
import com.ss.android.socialbase.appdownloader.p004ah.DevicePlans;
import com.ss.android.socialbase.appdownloader.p004ah.M1UnknownSourcePlan;
import com.ss.android.socialbase.appdownloader.p004ah.V4DevicePlan;
import com.ss.android.socialbase.appdownloader.util.AnUtils;
import com.ss.android.socialbase.appdownloader.util.AppInstallStatsReporter;
import com.ss.android.socialbase.appdownloader.util.DecryptUtils;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.constants.SpJsonConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.WeakDownloadHandler;
import com.ss.android.token.TokenConstants;
import com.ss.ttm.player.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AhUtilsImpl {
    private static final String TAG = "AhUtilsImpl";
    private static AppStatusObserver sLastObserver;
    private static AhUtils.OnAhAttemptListener sOnAhAttemptListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface ConditionCheckCallable {
        boolean isConditionFit(Context context);
    }

    public static boolean antiHijack(Context context, DownloadInfo downloadInfo, Intent intent, boolean z) {
        JSONArray optJSONArray = DownloadSetting.obtain(downloadInfo.getId()).optJSONArray(DownloadSettingKeys.KEY_AH_PLANS);
        if (optJSONArray == null) {
            return false;
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (AnUtils.checkAnConfig(optJSONObject) && runAntiHijack(context, downloadInfo, intent, optJSONObject, z)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x00a9. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x020c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean runAntiHijack(Context context, DownloadInfo downloadInfo, Intent intent, JSONObject jSONObject, boolean z) {
        char c;
        AhAttempt checkJumpFileManagerConfig;
        boolean jumpFileManagerPage;
        AhAttempt checkJumpFileManagerConfig2;
        boolean z2 = false;
        if (jSONObject != null && downloadInfo != null) {
            AhAttempt ahAttempt = new AhAttempt();
            String optString = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE);
            if (!TextUtils.isEmpty(optString)) {
                DownloadSetting obtain = DownloadSetting.obtain(downloadInfo);
                ahAttempt.anti_plan_type = optString;
                optString.hashCode();
                switch (optString.hashCode()) {
                    case -985763637:
                        if (optString.equals(AhUtils.Plan.JUMP_FILE_MANAGER)) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case -985763636:
                        if (optString.equals(AhUtils.Plan.JUMP_FILE_MANAGER_CUSTOM)) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case -985763635:
                        if (optString.equals(AhUtils.Plan.JUMP_UNKNOWN_SOURCE)) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -985763634:
                        if (optString.equals(AhUtils.Plan.CUSTOM_SAVE_PATH)) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case -985763633:
                        if (optString.equals(AhUtils.Plan.JUMP_FILE_MANAGER2)) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case -985763632:
                        if (optString.equals(AhUtils.Plan.JUMP_FILE_MANAGER3)) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case -985763631:
                        if (optString.equals(AhUtils.Plan.JUMP_BROWSER_INSTALLER)) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case -985763630:
                        if (optString.equals(AhUtils.Plan.CUSTOM_INSTALLER_MI)) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case -985763629:
                        if (optString.equals(AhUtils.Plan.JUMP_UNKNOWN_SOURCE_HW)) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case -985763628:
                        if (optString.equals(AhUtils.Plan.JUMP_FILE_MANAGER4)) {
                            c = '\t';
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                    case 4:
                        if (!downloadInfo.isSavePathRedirected()) {
                            ahAttempt.error_code = downloadInfo.getAntiHijackErrorCode(-1);
                            if (z2) {
                                downloadInfo.getTempCacheData().put(AhAttempt.JSON_TITLE, ahAttempt.getJsonString());
                            }
                            if (sOnAhAttemptListener != null) {
                                downloadInfo.getTempCacheData().put(Constants.INTENT, intent);
                                sOnAhAttemptListener.onAhAttemptResult(downloadInfo, ahAttempt);
                                break;
                            }
                        }
                        checkJumpFileManagerConfig = checkJumpFileManagerConfig(jSONObject, obtain);
                        if (checkJumpFileManagerConfig.error_code == 0) {
                            ahAttempt = checkJumpFileManagerConfig;
                        } else if (optString.equals(AhUtils.Plan.JUMP_FILE_MANAGER3) && TextUtils.isEmpty(downloadInfo.getDBJsonString(DbJsonConstants.CONTENT_URI))) {
                            ahAttempt.error_code = downloadInfo.getAntiHijackErrorCode(10);
                        } else if (optString.equals(AhUtils.Plan.JUMP_FILE_MANAGER4) && !V4DevicePlan.isSavePathCorrect(downloadInfo)) {
                            ahAttempt.error_code = downloadInfo.getAntiHijackErrorCode(7);
                        } else {
                            jumpFileManagerPage = jumpFileManagerPage(context, downloadInfo, jSONObject, ahAttempt);
                            z2 = jumpFileManagerPage;
                        }
                        if (z2) {
                        }
                        if (sOnAhAttemptListener != null) {
                        }
                        break;
                    case 1:
                        checkJumpFileManagerConfig2 = checkJumpFileManagerConfig(jSONObject, obtain);
                        if (checkJumpFileManagerConfig2.error_code == 0) {
                            if (!downloadInfo.isSavePathRedirected()) {
                                ahAttempt.error_code = downloadInfo.getAntiHijackErrorCode(-1);
                                if (z2) {
                                }
                                if (sOnAhAttemptListener != null) {
                                }
                            } else {
                                jumpFileManagerPage = jumpCustomBrowserPage(context, downloadInfo, jSONObject, ahAttempt);
                                z2 = jumpFileManagerPage;
                                if (z2) {
                                }
                                if (sOnAhAttemptListener != null) {
                                }
                            }
                        }
                        ahAttempt = checkJumpFileManagerConfig2;
                        if (z2) {
                        }
                        if (sOnAhAttemptListener != null) {
                        }
                        break;
                    case 2:
                        if (Build.VERSION.SDK_INT >= 26 || RomUtils.isMiui()) {
                            if ((jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNOWN_SOURCE_ENABLE_FOR_ALL, 0) == 1) || z) {
                                if (!(jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1) && enableJumpUnKnownSource(context, jSONObject)) {
                                    jumpFileManagerPage = tryShowUnknownSource(context, intent, jSONObject, downloadInfo.getId(), ahAttempt);
                                    z2 = jumpFileManagerPage;
                                }
                            }
                        }
                        if (z2) {
                        }
                        if (sOnAhAttemptListener != null) {
                        }
                        break;
                    case 3:
                        ahAttempt.anti_plan_type = AhUtils.Plan.CUSTOM_SAVE_PATH;
                        if (!RomUtils.isVivo()) {
                            ahAttempt.error_code = 2;
                        } else {
                            try {
                                AppDownloadUtils.startPackageInstaller(context, intent);
                                ahAttempt.error_code = 0;
                                z2 = true;
                            } catch (Throwable th) {
                                ahAttempt.error_code = 4;
                                ahAttempt.error_msg = th.toString();
                            }
                        }
                        if (z2) {
                        }
                        if (sOnAhAttemptListener != null) {
                        }
                        break;
                    case 5:
                    case '\t':
                        checkJumpFileManagerConfig = checkJumpFileManagerConfig(jSONObject, obtain);
                        if (checkJumpFileManagerConfig.error_code == 0) {
                        }
                        if (z2) {
                        }
                        if (sOnAhAttemptListener != null) {
                        }
                        break;
                    case 6:
                        checkJumpFileManagerConfig2 = checkBrowserInstallConfig(jSONObject, obtain);
                        if (checkJumpFileManagerConfig2.error_code == 0) {
                            jumpFileManagerPage = tryBrowserInstaller(context, downloadInfo, jSONObject, ahAttempt, obtain);
                            z2 = jumpFileManagerPage;
                            if (z2) {
                            }
                            if (sOnAhAttemptListener != null) {
                            }
                        }
                        ahAttempt = checkJumpFileManagerConfig2;
                        if (z2) {
                        }
                        if (sOnAhAttemptListener != null) {
                        }
                        break;
                    case 7:
                        String decrypt = DecryptUtils.decrypt(obtain.optString("bh"), obtain.optString("s"));
                        AhAttempt checkMInstallConfig = checkMInstallConfig(jSONObject, decrypt, context, obtain);
                        if (checkMInstallConfig.error_code != 0) {
                            ahAttempt = checkMInstallConfig;
                        } else {
                            String packageName = context.getPackageName();
                            if (AnUtils.modifyPackageName(DownloadSetting.getGlobalSettings(), context, decrypt)) {
                                try {
                                    AppDownloadUtils.startPackageInstaller(context, intent);
                                    ahAttempt.error_code = 0;
                                    z2 = true;
                                } catch (Throwable th2) {
                                    try {
                                        ahAttempt.error_code = 1;
                                        ahAttempt.error_msg = th2.toString();
                                    } finally {
                                        AnUtils.modifyPackageName(DownloadSetting.getGlobalSettings(), context, packageName);
                                    }
                                }
                            } else {
                                ahAttempt.error_code = 11;
                            }
                        }
                        if (z2) {
                        }
                        if (sOnAhAttemptListener != null) {
                        }
                        break;
                    case '\b':
                        ahAttempt = checkHwUnknownSourceConfig(jSONObject);
                        if (ahAttempt.error_code == 0) {
                            if (enableJumpUnKnownSource(context, jSONObject)) {
                                jumpFileManagerPage = tryShowUnknownSource(context, intent, jSONObject, downloadInfo.getId(), ahAttempt);
                                z2 = jumpFileManagerPage;
                            } else {
                                downloadInfo.getTempCacheData().put(Constants.AhConstants.ANTI_CONFIG, jSONObject);
                            }
                        }
                        if (z2) {
                        }
                        if (sOnAhAttemptListener != null) {
                        }
                        break;
                    default:
                        if (z2) {
                        }
                        if (sOnAhAttemptListener != null) {
                        }
                        break;
                }
            }
        }
        return z2;
    }

    private static boolean tryBrowserInstaller(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, AhAttempt ahAttempt, DownloadSetting downloadSetting) {
        boolean z;
        String optString = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE);
        ahAttempt.anti_plan_type = optString;
        Intent jumpIntent = DevicePlans.createDevicePlan(context, DevicePlans.DEVICE_PLAN_VIVO_BI, jSONObject, downloadInfo).getJumpIntent();
        StringBuilder sb = new StringBuilder();
        try {
            z = tryStartActivity(context, jumpIntent);
        } catch (Throwable th) {
            sb.append(optString).append(" startActivity failed : ").append(parseThrowable(th));
            appendErrorCode(ahAttempt, 1);
            z = false;
        }
        if (!z) {
            ahAttempt.error_msg = sb.toString();
        } else {
            ahAttempt.error_code = 0;
        }
        return true;
    }

    private static boolean checkDeviceRomMatch(JSONObject jSONObject) {
        return AnUtils.checkDeviceRomMatch(jSONObject);
    }

    public static boolean checkOsApiLevel(JSONObject jSONObject) {
        return AnUtils.checkOsApiLevel(jSONObject);
    }

    public static boolean checkSecure(JSONObject jSONObject) {
        return AnUtils.checkSecure(jSONObject);
    }

    private static boolean jumpFileManagerPage(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, AhAttempt ahAttempt) {
        String str;
        boolean z;
        if (context != null && jSONObject != null) {
            String optString = jSONObject.optString("device_plans");
            ahAttempt.device_plans = optString;
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                String savePath = downloadInfo.getSavePath();
                if (TextUtils.isEmpty(savePath)) {
                    return false;
                }
                File file = new File(savePath);
                StringBuilder sb = new StringBuilder();
                int length = split.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        str = null;
                        z = false;
                        break;
                    }
                    str = split[i];
                    AbsDevicePlan createDevicePlan = DevicePlans.createDevicePlan(context, str, jSONObject, downloadInfo);
                    if (createDevicePlan != null) {
                        Intent jumpIntent = createDevicePlan.getJumpIntent();
                        if (jumpIntent != null) {
                            if (createDescFile(file, downloadInfo, jSONObject)) {
                                z = true;
                                try {
                                    tryStartActivity(context, jumpIntent, false);
                                    break;
                                } catch (Throwable th) {
                                    sb.append(str).append(" startActivity failed : ").append(parseThrowable(th));
                                    appendErrorCode(ahAttempt, 1);
                                }
                            } else {
                                appendErrorCode(ahAttempt, 6);
                                sb.append(str).append(" createDescFile failed! ");
                            }
                        } else {
                            appendErrorCode(ahAttempt, 3);
                            sb.append(str).append(" resolveActivity failed! ");
                        }
                    }
                    sb.append("  ");
                    i++;
                }
                if (!z) {
                    ahAttempt.error_msg = sb.toString();
                } else {
                    ahAttempt.real_device_plan = str;
                    ahAttempt.error_code = 0;
                }
                return z;
            }
        }
        return false;
    }

    private static boolean jumpCustomBrowserPage(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, AhAttempt ahAttempt) {
        if (context != null && jSONObject != null) {
            String savePath = downloadInfo.getSavePath();
            if (TextUtils.isEmpty(savePath)) {
                return false;
            }
            ahAttempt.real_device_plan = "custom";
            AbsDevicePlan createDevicePlan = DevicePlans.createDevicePlan(context, "custom", jSONObject, downloadInfo);
            if (createDevicePlan == null || !createDevicePlan.isValid()) {
                ahAttempt.error_code = 3;
            } else {
                Intent jumpIntent = createDevicePlan.getJumpIntent();
                if (jumpIntent == null) {
                    return false;
                }
                if (createDescFile(new File(savePath), downloadInfo, jSONObject)) {
                    if (tryStartActivity(context, jumpIntent)) {
                        ahAttempt.error_code = 0;
                        return true;
                    }
                    ahAttempt.error_code = 1;
                } else {
                    ahAttempt.error_code = 6;
                }
                return false;
            }
        }
        return false;
    }

    public static int getSavePathRedirectedCode(DownloadSetting downloadSetting) {
        int i;
        if (!(downloadSetting.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR) != null ? !TextUtils.isEmpty(r0.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME)) : false)) {
            return 5;
        }
        JSONArray optJSONArray = downloadSetting.optJSONArray(DownloadSettingKeys.KEY_AH_PLANS);
        int i2 = -1;
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (AnUtils.checkAnConfig(optJSONObject)) {
                    String optString = optJSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE);
                    if (AhUtils.Plan.JUMP_FILE_MANAGER.equals(optString) || AhUtils.Plan.JUMP_FILE_MANAGER_CUSTOM.equals(optString) || AhUtils.Plan.JUMP_FILE_MANAGER2.equals(optString) || AhUtils.Plan.JUMP_FILE_MANAGER3.equals(optString) || AhUtils.Plan.JUMP_FILE_MANAGER4.equals(optString)) {
                        AhAttempt checkJumpFileManagerConfig = checkJumpFileManagerConfig(optJSONObject, downloadSetting);
                        i = checkJumpFileManagerConfig.error_code;
                        if (checkJumpFileManagerConfig.error_code == 0) {
                            return 0;
                        }
                    } else {
                        if (!AhUtils.Plan.CUSTOM_SAVE_PATH.equalsIgnoreCase(optString) && !AhUtils.Plan.CUSTOM_INSTALLER_MI.equalsIgnoreCase(optString)) {
                            if (AhUtils.Plan.JUMP_BROWSER_INSTALLER.equalsIgnoreCase(optString)) {
                                AhAttempt checkBrowserInstallConfig = checkBrowserInstallConfig(optJSONObject, downloadSetting);
                                i = checkBrowserInstallConfig.error_code;
                                if (checkBrowserInstallConfig.error_code == 0) {
                                }
                            } else {
                                continue;
                            }
                        }
                        return 0;
                    }
                    i2 = i;
                }
            }
        }
        return i2;
    }

    public static AhAttempt checkJumpFileManagerConfig(JSONObject jSONObject, DownloadSetting downloadSetting) {
        AhAttempt ahAttempt = new AhAttempt();
        if (jSONObject == null) {
            return ahAttempt;
        }
        String optString = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE);
        ahAttempt.anti_plan_type = optString;
        if (AhUtils.Plan.JUMP_FILE_MANAGER_CUSTOM.equals(optString)) {
            ahAttempt.device_plans = "custom";
            if (DevicePlans.checkDevicePlanValid(DownloadComponentManager.getAppContext(), "custom", jSONObject, downloadSetting)) {
                ahAttempt.error_code = 0;
                return ahAttempt;
            }
            appendErrorCode(ahAttempt, 3);
        } else {
            String optString2 = jSONObject.optString("device_plans");
            ahAttempt.device_plans = optString2;
            if (!TextUtils.isEmpty(optString2)) {
                for (String str : optString2.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    if (DevicePlans.checkDevicePlanValid(DownloadComponentManager.getAppContext(), str, jSONObject, downloadSetting)) {
                        ahAttempt.error_code = 0;
                        return ahAttempt;
                    }
                    appendErrorCode(ahAttempt, 3);
                }
            }
        }
        return ahAttempt;
    }

    public static AhAttempt checkBrowserInstallConfig(JSONObject jSONObject, DownloadSetting downloadSetting) {
        AhAttempt ahAttempt = new AhAttempt();
        if (jSONObject == null) {
            return ahAttempt;
        }
        ahAttempt.anti_plan_type = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE);
        ahAttempt.device_plans = DevicePlans.DEVICE_PLAN_VIVO_BI;
        if (DevicePlans.checkDevicePlanValid(DownloadComponentManager.getAppContext(), DevicePlans.DEVICE_PLAN_VIVO_BI, jSONObject, downloadSetting)) {
            ahAttempt.error_code = 0;
        } else {
            appendErrorCode(ahAttempt, 3);
        }
        return ahAttempt;
    }

    private static AhAttempt checkHwUnknownSourceConfig(JSONObject jSONObject) {
        AhAttempt ahAttempt = new AhAttempt();
        if (jSONObject == null) {
            return ahAttempt;
        }
        ahAttempt.anti_plan_type = AhUtils.Plan.JUMP_UNKNOWN_SOURCE_HW;
        if (checkDeviceRomMatch(jSONObject)) {
            ahAttempt.error_code = 0;
        } else {
            ahAttempt.error_code = 2;
        }
        return ahAttempt;
    }

    private static AhAttempt checkMInstallConfig(JSONObject jSONObject, String str, Context context, DownloadSetting downloadSetting) {
        AhAttempt ahAttempt = new AhAttempt();
        if (jSONObject != null && RomUtils.isMiui()) {
            ahAttempt.anti_plan_type = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE);
            if (downloadSetting.optInt("bi", 0) == 1) {
                ahAttempt.error_code = 0;
                return ahAttempt;
            }
            if (isUnknownSourceEnabled(context)) {
                ahAttempt.error_code = 2;
            } else if (AnUtils.queryPackageInfo(str) != null) {
                ahAttempt.error_code = 0;
            } else {
                ahAttempt.error_code = 9;
            }
        }
        return ahAttempt;
    }

    private static void appendErrorCode(AhAttempt ahAttempt, int i) {
        if (ahAttempt.error_code != -1) {
            ahAttempt.error_code = (ahAttempt.error_code * 10) + i;
        } else {
            ahAttempt.error_code = i;
        }
    }

    private static boolean createDescFile(File file, DownloadInfo downloadInfo, JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject optJSONObject = DownloadSetting.obtain(downloadInfo.getId()).optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
        File file2 = null;
        String optString = optJSONObject != null ? optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_INSTALL_DESC) : null;
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString)) {
            file2 = new File(path + File.separator + optString);
        }
        if (file2 == null) {
            return true;
        }
        try {
            if (!file2.createNewFile()) {
                return true;
            }
            file2.deleteOnExit();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean tryShowUnknownSource(Context context, Intent intent, JSONObject jSONObject, int i, AhAttempt ahAttempt) {
        boolean z;
        if (context == null || jSONObject == null || isUnknownSourceEnabled(context)) {
            return false;
        }
        if (jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_SHOW_UNKNOWN_SOURCE_DIALOG, 0) == 1) {
            try {
                if (tryStartActivity(context, JumpUnknownSourceActivity.getIntent(context, intent, jSONObject, i), false, false)) {
                    sendGuideAuthDialogShowEvent(i, jSONObject);
                }
            } catch (Throwable th) {
                if (ahAttempt != null) {
                    ahAttempt.error_code = 1;
                    ahAttempt.error_msg = "tryShowUnknownSourceDialog" + parseThrowable(th);
                }
                z = false;
            }
        } else if (realJumpUnknownSource(context, intent, i, jSONObject)) {
            sendGuideAuthOpenSettingEvent(i, jSONObject);
        }
        z = true;
        if (z) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(DownloadConstants.SP_ANTI_HIJACK_CONFIG, 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            int i2 = (sharedPreferences.getInt(SpJsonConstants.KEY_JUMP_UNKNOWN_SOURCE_COUNT, 0) + 1) % 9;
            edit.putLong(SpJsonConstants.KEY_LAST_JUMP_UNKNOWN_SOURCE_TIME, System.currentTimeMillis());
            edit.putInt(SpJsonConstants.KEY_JUMP_UNKNOWN_SOURCE_COUNT, i2).apply();
        }
        return z;
    }

    public static boolean enableJumpUnKnownSource(Context context, JSONObject jSONObject) {
        long optLong;
        if (context == null || jSONObject == null) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(DownloadConstants.SP_ANTI_HIJACK_CONFIG, 0);
        long j = sharedPreferences.getLong(SpJsonConstants.KEY_LAST_JUMP_UNKNOWN_SOURCE_TIME, 0L);
        int i = sharedPreferences.getInt(SpJsonConstants.KEY_JUMP_UNKNOWN_SOURCE_COUNT, 0);
        if (jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_JUMP_INTERVAL_BY_SEQ) == 1) {
            optLong = new int[]{1, 1, 2, 3, 5, 8, 13, 21, 30}[i % 9] * 60 * 24;
        } else {
            optLong = jSONObject.optLong(DownloadSettingKeys.AhPlans.KEY_JUMP_INTERVAL, 0L);
        }
        return optLong > 0 && (System.currentTimeMillis() - j) / 60000 >= optLong;
    }

    public static boolean realJumpUnknownSource(Context context, Intent intent, int i, JSONObject jSONObject) {
        try {
            if (RomUtils.isMiui() && Build.VERSION.SDK_INT < 26 && !isXiaomiUnknownSourcesEnabled(context)) {
                M1UnknownSourcePlan m1UnknownSourcePlan = new M1UnknownSourcePlan(context);
                if (m1UnknownSourcePlan.isValid()) {
                    monitor(context, intent, i, jSONObject, new ConditionCheckCallable() { // from class: com.ss.android.socialbase.appdownloader.AhUtilsImpl.1
                        @Override // com.ss.android.socialbase.appdownloader.AhUtilsImpl.ConditionCheckCallable
                        public boolean isConditionFit(Context context2) {
                            return AhUtilsImpl.isXiaomiUnknownSourcesEnabled(context2);
                        }
                    });
                    return tryStartActivity(context, m1UnknownSourcePlan.getJumpIntent());
                }
            } else if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !isAndroidOUnknownSourcesEnabled(context)) {
                AndroidUnknownSourcePlan androidUnknownSourcePlan = new AndroidUnknownSourcePlan(context);
                if (androidUnknownSourcePlan.isValid()) {
                    monitor(context, intent, i, jSONObject, new ConditionCheckCallable() { // from class: com.ss.android.socialbase.appdownloader.AhUtilsImpl.2
                        @Override // com.ss.android.socialbase.appdownloader.AhUtilsImpl.ConditionCheckCallable
                        public boolean isConditionFit(Context context2) {
                            return AhUtilsImpl.isAndroidOUnknownSourcesEnabled(context2);
                        }
                    });
                    return tryStartActivity(context, androidUnknownSourcePlan.getJumpIntent());
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean isUnknownSourceEnabled(Context context) {
        if (context == null) {
            return true;
        }
        if (RomUtils.isMiui() && Build.VERSION.SDK_INT < 26) {
            return isXiaomiUnknownSourcesEnabled(context);
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            return isAndroidOUnknownSourcesEnabled(context);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isXiaomiUnknownSourcesEnabled(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAndroidOUnknownSourcesEnabled(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable unused) {
            return true;
        }
    }

    private static void sendGuideAuthDialogShowEvent(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put(TokenConstants.SCENE_KEY, i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i, MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_SHOW, jSONObject2);
    }

    public static void sendGuideAuthDialogConfirmEvent(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put(TokenConstants.SCENE_KEY, i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i, MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_CONFIRM, jSONObject2);
    }

    public static void sendGuideAuthDialogCancelEvent(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put(TokenConstants.SCENE_KEY, i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i, MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_CANCEL, jSONObject2);
    }

    public static void sendGuideAuthOpenSettingEvent(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put(TokenConstants.SCENE_KEY, i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i, MonitorConstants.UnityLabel.GUIDE_AUTH_OPEN_SETTING, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendGuideAuthResultEvent(int i, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        int i2 = 1;
        try {
            jSONObject.put(TokenConstants.SCENE_KEY, z ? 1 : 2);
            if (!z2) {
                i2 = 2;
            }
            jSONObject.put("result_code", i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i, MonitorConstants.UnityLabel.GUIDE_AUTH_RESULT, jSONObject);
    }

    private static void monitor(Context context, Intent intent, int i, JSONObject jSONObject, ConditionCheckCallable conditionCheckCallable) {
        if (sLastObserver != null) {
            AppStatusManager.getInstance().unregisterAppSwitchListener(sLastObserver);
            sLastObserver = null;
        }
        sLastObserver = new AppStatusObserver(context, intent, i, jSONObject, conditionCheckCallable);
        AppStatusManager.getInstance().registerAppSwitchListener(sLastObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean tryStartActivity(Context context, Intent intent) {
        return tryStartActivity(context, intent, true, true);
    }

    public static boolean tryStartActivity(Context context, Intent intent, boolean z) {
        return tryStartActivity(context, intent, z, true);
    }

    public static boolean tryStartActivity(Context context, Intent intent, boolean z, boolean z2) {
        if (context == null || intent == null) {
            return false;
        }
        if (AppInstallStatsReporter.isEnabled()) {
            AppInstallStatsReporter.report();
        }
        IDownloadAppInstallHandler appInstallHandler = AppDownloader.getInstance().getAppInstallHandler();
        if (z) {
            try {
                intent.putExtra("start_only_for_android", true);
                if (appInstallHandler != null && z2) {
                    appInstallHandler.startActivity(context, intent);
                } else {
                    context.startActivity(intent);
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        intent.putExtra("start_only_for_android", true);
        if (appInstallHandler != null && z2) {
            appInstallHandler.startActivity(context, intent);
        } else {
            context.startActivity(intent);
        }
        return true;
    }

    public static String parseThrowable(Throwable th) {
        String th2 = th.toString();
        return th2.length() > 800 ? th2.substring(0, MediaPlayer.MEDIA_PLAYER_OPTION_SET_MDL_PROTOCOL_HANDLE) : th2;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class QueryCallable implements Callable<Boolean> {
        private final ConditionCheckCallable mConditionCheck;
        private final Context mContext;
        private final Handler mainHandler;
        private final long queryInterval;

        public QueryCallable(Handler handler, Context context, ConditionCheckCallable conditionCheckCallable, long j) {
            this.mContext = context;
            this.mConditionCheck = conditionCheckCallable;
            this.mainHandler = handler;
            this.queryInterval = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            ConditionCheckCallable conditionCheckCallable;
            try {
                conditionCheckCallable = this.mConditionCheck;
            } catch (Throwable unused) {
            }
            if (conditionCheckCallable != null) {
                long j = this.queryInterval;
                if (j > 0 && j <= 10000) {
                    Context context = this.mContext;
                    boolean isConditionFit = context != null ? conditionCheckCallable.isConditionFit(context) : false;
                    Message obtain = Message.obtain();
                    if (isConditionFit) {
                        obtain.what = 2;
                        this.mainHandler.sendMessage(obtain);
                    } else {
                        obtain.what = 1;
                        this.mainHandler.sendMessageDelayed(obtain, this.queryInterval);
                    }
                    return false;
                }
            }
            return false;
        }
    }

    public static void setOnAhAttemptListener(AhUtils.OnAhAttemptListener onAhAttemptListener) {
        sOnAhAttemptListener = onAhAttemptListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class AppStatusObserver implements AppStatusManager.AppStatusChangeListener {
        private JSONObject antiConfig;
        private final QueryHandlerImpl queryHandlerImpl;
        private final int queryInterval;

        public AppStatusObserver(Context context, Intent intent, int i, JSONObject jSONObject, ConditionCheckCallable conditionCheckCallable) {
            this.antiConfig = jSONObject;
            int optInt = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNWON_SOURCE_QUERY_INTERVAL, 1000);
            this.queryInterval = optInt;
            this.queryHandlerImpl = new QueryHandlerImpl(context, intent, i, conditionCheckCallable, optInt);
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppForeground() {
            if (!this.queryHandlerImpl.isOriginActivityStarted) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                this.queryHandlerImpl.mainHandler.sendMessage(obtain);
            }
            AppStatusManager.getInstance().unregisterAppSwitchListener(this);
            AppStatusObserver unused = AhUtilsImpl.sLastObserver = null;
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppBackground() {
            int optInt = this.antiConfig.optInt(DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNWON_SOURCE_WAIT_TIME_OUT, 20);
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.queryHandlerImpl.mainHandler.sendMessage(obtain);
            if (optInt <= 0 || optInt >= 60) {
                return;
            }
            Message obtain2 = Message.obtain();
            obtain2.what = 2;
            this.queryHandlerImpl.mainHandler.sendMessageDelayed(obtain2, optInt * 1000);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class QueryHandlerImpl implements WeakDownloadHandler.IHandler {
        public static final int WHAT_CANCEL_FUTURE_AND_START_ACTIVITY = 2;
        public static final int WHAT_QUERY_NEXT = 1;
        public static int currentStatus;

        /* renamed from: id */
        private static int f58id;
        private final ConditionCheckCallable conditionCheck;
        private final Context context;
        private Future<Boolean> future;
        private boolean isOriginActivityStarted = false;
        private final Handler mainHandler;
        private final Intent originIntent;
        private final long queryInterval;

        public QueryHandlerImpl(Context context, Intent intent, int i, ConditionCheckCallable conditionCheckCallable, long j) {
            this.context = context;
            this.originIntent = intent;
            f58id = i;
            this.conditionCheck = conditionCheckCallable;
            this.mainHandler = new WeakDownloadHandler(Looper.getMainLooper(), this);
            this.queryInterval = j;
        }

        @Override // com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
        public void handleMsg(Message message) {
            if (message != null) {
                if (message.what == 1) {
                    long j = this.queryInterval;
                    if (j <= 0 || j > 10000) {
                        return;
                    }
                    currentStatus = 1;
                    this.future = DownloadComponentManager.getCPUThreadExecutor().submit(new QueryCallable(this.mainHandler, this.context, this.conditionCheck, this.queryInterval));
                    return;
                }
                if (message.what == 2) {
                    currentStatus = 2;
                    this.mainHandler.removeMessages(2);
                    this.mainHandler.removeMessages(1);
                    Future<Boolean> future = this.future;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.isOriginActivityStarted && (Build.VERSION.SDK_INT < 29 || AppStatusManager.getInstance().isAppForeground())) {
                        Intent intent = this.originIntent;
                        if (intent != null) {
                            AhUtilsImpl.tryStartActivity(this.context, intent);
                        } else {
                            DownloadInfo downloadInfo = Downloader.getInstance(this.context).getDownloadInfo(f58id);
                            if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                                AppDownloadUtils.proxyStartViewIntent(this.context, f58id, false);
                            }
                        }
                        this.isOriginActivityStarted = true;
                    }
                    AhUtilsImpl.sendGuideAuthResultEvent(f58id, this.originIntent == null, AhUtilsImpl.isUnknownSourceEnabled(this.context));
                }
            }
        }
    }
}
