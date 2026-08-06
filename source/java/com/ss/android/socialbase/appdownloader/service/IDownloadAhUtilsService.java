package com.ss.android.socialbase.appdownloader.service;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.appdownloader.AhAttempt;
import com.ss.android.socialbase.appdownloader.AhUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface IDownloadAhUtilsService {
    boolean antiHijack(Context context, DownloadInfo downloadInfo, Intent intent, boolean z);

    AhAttempt checkBrowserInstallConfig(JSONObject jSONObject, DownloadSetting downloadSetting);

    AhAttempt checkJumpFileManagerConfig(JSONObject jSONObject, DownloadSetting downloadSetting);

    boolean enableJumpUnKnownSource(Context context, JSONObject jSONObject);

    int getSavePathRedirectedCode(DownloadSetting downloadSetting);

    boolean isUnknownSourceEnabled(Context context);

    void setOnAhAttemptListener(AhUtils.OnAhAttemptListener onAhAttemptListener);

    boolean tryShowUnknownSource(Context context, Intent intent, JSONObject jSONObject, int i, AhAttempt ahAttempt);

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class DefaultDownloadAhUtilsService implements IDownloadAhUtilsService {
        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
        public boolean antiHijack(Context context, DownloadInfo downloadInfo, Intent intent, boolean z) {
            return false;
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
        public boolean enableJumpUnKnownSource(Context context, JSONObject jSONObject) {
            return false;
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
        public int getSavePathRedirectedCode(DownloadSetting downloadSetting) {
            return -1;
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
        public boolean isUnknownSourceEnabled(Context context) {
            return false;
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
        public void setOnAhAttemptListener(AhUtils.OnAhAttemptListener onAhAttemptListener) {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
        public boolean tryShowUnknownSource(Context context, Intent intent, JSONObject jSONObject, int i, AhAttempt ahAttempt) {
            return false;
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
        public AhAttempt checkJumpFileManagerConfig(JSONObject jSONObject, DownloadSetting downloadSetting) {
            return new AhAttempt();
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
        public AhAttempt checkBrowserInstallConfig(JSONObject jSONObject, DownloadSetting downloadSetting) {
            return new AhAttempt();
        }
    }
}
