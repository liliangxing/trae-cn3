package com.ss.android.socialbase.appdownloader.service;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.io.File;

/* loaded from: classes7.dex */
public interface IDownloadPackageInfoUtilsService {
    String getAppNameByPackageInfo(Context context, PackageInfo packageInfo, String str);

    PackageInfo getPackageInfo(Context context, File file, int i);

    PackageInfo getPackageInfo(File file);

    /* loaded from: classes7.dex */
    public static class DefaultDownloadPackageInfoUtilsService implements IDownloadPackageInfoUtilsService {
        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadPackageInfoUtilsService
        public String getAppNameByPackageInfo(Context context, PackageInfo packageInfo, String str) {
            return null;
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadPackageInfoUtilsService
        public PackageInfo getPackageInfo(Context context, File file, int i) {
            return null;
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadPackageInfoUtilsService
        public PackageInfo getPackageInfo(File file) {
            return new PackageInfo();
        }
    }
}
