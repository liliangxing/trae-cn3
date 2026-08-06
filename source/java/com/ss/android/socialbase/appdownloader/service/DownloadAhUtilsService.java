package com.ss.android.socialbase.appdownloader.service;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.appdownloader.AhAttempt;
import com.ss.android.socialbase.appdownloader.AhUtils;
import com.ss.android.socialbase.appdownloader.AhUtilsImpl;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadAhUtilsService implements IDownloadAhUtilsService {
    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
    public boolean antiHijack(Context context, DownloadInfo downloadInfo, Intent intent, boolean z) {
        return AhUtilsImpl.antiHijack(context, downloadInfo, intent, z);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
    public int getSavePathRedirectedCode(DownloadSetting downloadSetting) {
        return AhUtilsImpl.getSavePathRedirectedCode(downloadSetting);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
    public AhAttempt checkJumpFileManagerConfig(JSONObject jSONObject, DownloadSetting downloadSetting) {
        return AhUtilsImpl.checkJumpFileManagerConfig(jSONObject, downloadSetting);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
    public AhAttempt checkBrowserInstallConfig(JSONObject jSONObject, DownloadSetting downloadSetting) {
        return AhUtilsImpl.checkBrowserInstallConfig(jSONObject, downloadSetting);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
    public boolean tryShowUnknownSource(Context context, Intent intent, JSONObject jSONObject, int i, AhAttempt ahAttempt) {
        return AhUtilsImpl.tryShowUnknownSource(context, intent, jSONObject, i, ahAttempt);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
    public boolean enableJumpUnKnownSource(Context context, JSONObject jSONObject) {
        return AhUtilsImpl.enableJumpUnKnownSource(context, jSONObject);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
    public boolean isUnknownSourceEnabled(Context context) {
        return AhUtilsImpl.isUnknownSourceEnabled(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
    public void setOnAhAttemptListener(AhUtils.OnAhAttemptListener onAhAttemptListener) {
        AhUtilsImpl.setOnAhAttemptListener(onAhAttemptListener);
    }
}
