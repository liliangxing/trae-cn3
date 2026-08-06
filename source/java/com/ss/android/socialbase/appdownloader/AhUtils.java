package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.appdownloader.depend.AppGlobalListenerAdaptor;
import com.ss.android.socialbase.appdownloader.service.AppDownloadServiceManager;
import com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class AhUtils {

    /* loaded from: classes7.dex */
    public interface OnAhAttemptListener {
        void onAhAttemptResult(DownloadInfo downloadInfo, AhAttempt ahAttempt);
    }

    /* loaded from: classes7.dex */
    public interface Plan {
        public static final String CUSTOM_INSTALLER_MI = "plan_h";
        public static final String CUSTOM_SAVE_PATH = "plan_d";
        public static final String JUMP_BROWSER_INSTALLER = "plan_g";
        public static final String JUMP_FILE_MANAGER = "plan_a";
        public static final String JUMP_FILE_MANAGER2 = "plan_e";
        public static final String JUMP_FILE_MANAGER3 = "plan_f";
        public static final String JUMP_FILE_MANAGER4 = "plan_j";
        public static final String JUMP_FILE_MANAGER_CUSTOM = "plan_b";
        public static final String JUMP_UNKNOWN_SOURCE = "plan_c";
        public static final String JUMP_UNKNOWN_SOURCE_HW = "plan_i";
    }

    public static boolean antiHijack(Context context, DownloadInfo downloadInfo, Intent intent, boolean z) {
        return ((IDownloadAhUtilsService) AppDownloadServiceManager.getService(IDownloadAhUtilsService.class)).antiHijack(context, downloadInfo, intent, z);
    }

    public static int getSavePathRedirectedCode(DownloadSetting downloadSetting) {
        return ((IDownloadAhUtilsService) AppDownloadServiceManager.getService(IDownloadAhUtilsService.class)).getSavePathRedirectedCode(downloadSetting);
    }

    public static AhAttempt checkJumpFileManagerConfig(JSONObject jSONObject, DownloadSetting downloadSetting) {
        return ((IDownloadAhUtilsService) AppDownloadServiceManager.getService(IDownloadAhUtilsService.class)).checkJumpFileManagerConfig(jSONObject, downloadSetting);
    }

    public static AhAttempt checkBrowserInstallConfig(JSONObject jSONObject, DownloadSetting downloadSetting) {
        return ((IDownloadAhUtilsService) AppDownloadServiceManager.getService(IDownloadAhUtilsService.class)).checkBrowserInstallConfig(jSONObject, downloadSetting);
    }

    public static boolean tryShowUnknownSource(Context context, Intent intent, JSONObject jSONObject, int i, AhAttempt ahAttempt) {
        return ((IDownloadAhUtilsService) AppDownloadServiceManager.getService(IDownloadAhUtilsService.class)).tryShowUnknownSource(context, intent, jSONObject, i, ahAttempt);
    }

    public static boolean enableJumpUnKnownSource(Context context, JSONObject jSONObject) {
        return ((IDownloadAhUtilsService) AppDownloadServiceManager.getService(IDownloadAhUtilsService.class)).enableJumpUnKnownSource(context, jSONObject);
    }

    public static boolean isUnknownSourceEnabled(Context context) {
        return ((IDownloadAhUtilsService) AppDownloadServiceManager.getService(IDownloadAhUtilsService.class)).isUnknownSourceEnabled(context);
    }

    public static void setOnAhAttemptListener(OnAhAttemptListener onAhAttemptListener) {
        ((IDownloadAhUtilsService) AppDownloadServiceManager.getService(IDownloadAhUtilsService.class)).setOnAhAttemptListener(AppGlobalListenerAdaptor.addListener(onAhAttemptListener));
    }
}
