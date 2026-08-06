package com.ss.android.socialbase.appdownloader.util.package_info;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.ss.android.socialbase.appdownloader.service.AppDownloadServiceManager;
import com.ss.android.socialbase.appdownloader.service.IDownloadPackageInfoUtilsService;
import java.io.File;

/* loaded from: classes7.dex */
public class PackageInfoUtils {
    public static PackageInfo getPackageInfo(File file) {
        return ((IDownloadPackageInfoUtilsService) AppDownloadServiceManager.getService(IDownloadPackageInfoUtilsService.class)).getPackageInfo(file);
    }

    public static PackageInfo getPackageInfo(Context context, File file, int i) {
        return ((IDownloadPackageInfoUtilsService) AppDownloadServiceManager.getService(IDownloadPackageInfoUtilsService.class)).getPackageInfo(context, file, i);
    }

    public static String getAppNameByPackageInfo(Context context, PackageInfo packageInfo, String str) {
        return ((IDownloadPackageInfoUtilsService) AppDownloadServiceManager.getService(IDownloadPackageInfoUtilsService.class)).getAppNameByPackageInfo(context, packageInfo, str);
    }
}
