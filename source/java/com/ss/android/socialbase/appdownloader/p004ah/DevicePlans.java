package com.ss.android.socialbase.appdownloader.p004ah;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.AppDownloadUtils;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DevicePlans {
    public static final String DEVICE_PLAN_CUSTOM = "custom";
    public static final String DEVICE_PLAN_OPPO1 = "o1";
    public static final String DEVICE_PLAN_OPPO2 = "o2";
    public static final String DEVICE_PLAN_OPPO3 = "o3";
    public static final String DEVICE_PLAN_VIVO1 = "v1";
    public static final String DEVICE_PLAN_VIVO2 = "v2";
    public static final String DEVICE_PLAN_VIVO3 = "v3";
    public static final String DEVICE_PLAN_VIVO4 = "v4";
    public static final String DEVICE_PLAN_VIVO_BI = "vbi";

    public static AbsDevicePlan createDevicePlan(Context context, String str, JSONObject jSONObject, DownloadInfo downloadInfo) {
        File parentFile;
        if (downloadInfo == null || context == null || jSONObject == null || TextUtils.isEmpty(str)) {
            return null;
        }
        DownloadFile downloadFile = new DownloadFile(downloadInfo.getSavePath(), downloadInfo.getName());
        if (downloadFile.getFile() == null || (parentFile = downloadFile.getFile().getParentFile()) == null) {
            return null;
        }
        DownloadSetting obtain = DownloadSetting.obtain(downloadInfo);
        if (str.equals(DEVICE_PLAN_VIVO1)) {
            return new V1DevicePlan(context, obtain, downloadInfo.getTargetFilePath());
        }
        if (str.equals(DEVICE_PLAN_VIVO2)) {
            return new V2DevicePlan(context, obtain, parentFile.getAbsolutePath());
        }
        if (str.equals(DEVICE_PLAN_VIVO3)) {
            return new V3DevicePlan(context, obtain, parentFile.getAbsolutePath());
        }
        if (str.equals(DEVICE_PLAN_VIVO4)) {
            return new V4DevicePlan(context, obtain, parentFile.getAbsolutePath());
        }
        if (str.equals(DEVICE_PLAN_OPPO1)) {
            return new O1DevicePlan(context, obtain, parentFile.getAbsolutePath());
        }
        if (str.equals(DEVICE_PLAN_OPPO2)) {
            return new O2DevicePlan(context, obtain, parentFile.getAbsolutePath());
        }
        if (str.equals(DEVICE_PLAN_OPPO3)) {
            String dBJsonString = downloadInfo.getDBJsonString(DbJsonConstants.CONTENT_URI);
            if (TextUtils.isEmpty(dBJsonString)) {
                return null;
            }
            return new O3DevicePlan(context, obtain, parentFile.getAbsolutePath(), dBJsonString, downloadInfo.getName());
        }
        if (str.equals("custom")) {
            return new CustomJumpDevicePlan(context, obtain, parentFile.getAbsolutePath(), jSONObject);
        }
        if (!str.equals(DEVICE_PLAN_VIVO_BI)) {
            return null;
        }
        Uri uriForFile = AppDownloadUtils.getUriForFile(downloadInfo, Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, AppDownloader.getInstance().getFileProviderAuthority(), new DownloadFile(downloadInfo.getSavePath(), downloadInfo.getName()).getFile());
        if (uriForFile == null) {
            return new VbiDevicePlan(context, obtain, "");
        }
        return new VbiDevicePlan(context, obtain, uriForFile.toString());
    }

    public static boolean checkDevicePlanValid(Context context, String str, JSONObject jSONObject, DownloadSetting downloadSetting) {
        IAhDevicePlan vbiDevicePlan;
        if (context == null || str == null) {
            return false;
        }
        String appDownloadPath = AppDownloadUtils.getAppDownloadPath();
        if (TextUtils.isEmpty(appDownloadPath) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (RomUtils.isVivo() && str.equals(DEVICE_PLAN_VIVO1)) {
            vbiDevicePlan = new V1DevicePlan(context, downloadSetting, appDownloadPath);
        } else if (RomUtils.isVivo() && str.equals(DEVICE_PLAN_VIVO2)) {
            vbiDevicePlan = new V2DevicePlan(context, downloadSetting, appDownloadPath);
        } else if (RomUtils.isVivo() && str.equals(DEVICE_PLAN_VIVO3)) {
            vbiDevicePlan = new V3DevicePlan(context, downloadSetting, appDownloadPath);
        } else if (RomUtils.isVivo() && str.equals(DEVICE_PLAN_VIVO4)) {
            vbiDevicePlan = new V4DevicePlan(context, downloadSetting, appDownloadPath);
        } else if (RomUtils.isOppo() && str.equals(DEVICE_PLAN_OPPO1)) {
            vbiDevicePlan = new O1DevicePlan(context, downloadSetting, appDownloadPath);
        } else if (RomUtils.isOppo() && str.equals(DEVICE_PLAN_OPPO2)) {
            vbiDevicePlan = new O2DevicePlan(context, downloadSetting, appDownloadPath);
        } else if (RomUtils.isOppo() && str.equals(DEVICE_PLAN_OPPO3)) {
            vbiDevicePlan = new O3DevicePlan(context, downloadSetting, appDownloadPath, appDownloadPath, appDownloadPath);
        } else if (RomUtils.isVivo() && str.equals("custom")) {
            vbiDevicePlan = new CustomJumpDevicePlan(context, downloadSetting, appDownloadPath, jSONObject);
        } else {
            vbiDevicePlan = (RomUtils.isVivo() && str.equals(DEVICE_PLAN_VIVO_BI)) ? new VbiDevicePlan(context, downloadSetting, appDownloadPath) : null;
        }
        return vbiDevicePlan != null && vbiDevicePlan.isValid();
    }
}
