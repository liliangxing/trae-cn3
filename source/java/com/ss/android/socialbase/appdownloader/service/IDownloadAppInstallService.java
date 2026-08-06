package com.ss.android.socialbase.appdownloader.service;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.ss.android.socialbase.appdownloader.depend.IAppInstallDetectorListener;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface IDownloadAppInstallService {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class DefaultDownloadAppInstallService implements IDownloadAppInstallService {
        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAppInstallService
        public void handleApkInstalled(String str) {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAppInstallService
        public void setAppInstallDetectorListener(IAppInstallDetectorListener iAppInstallDetectorListener) {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAppInstallService
        public void startAppInstallDetector(Context context, PackageInfo packageInfo, JSONObject jSONObject) {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAppInstallService
        public void startInstall(DownloadInfo downloadInfo) {
        }
    }

    void handleApkInstalled(String str);

    void setAppInstallDetectorListener(IAppInstallDetectorListener iAppInstallDetectorListener);

    void startAppInstallDetector(Context context, PackageInfo packageInfo, JSONObject jSONObject);

    void startInstall(DownloadInfo downloadInfo);
}
