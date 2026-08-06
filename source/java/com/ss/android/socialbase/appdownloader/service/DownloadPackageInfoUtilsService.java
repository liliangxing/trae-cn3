package com.ss.android.socialbase.appdownloader.service;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.ss.android.socialbase.appdownloader.util.package_info.PackageInfoUtilsImpl;
import java.io.File;

/* loaded from: classes7.dex */
public class DownloadPackageInfoUtilsService implements IDownloadPackageInfoUtilsService {
    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadPackageInfoUtilsService
    public PackageInfo getPackageInfo(File file) {
        return PackageInfoUtilsImpl.getPackageInfo(file);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadPackageInfoUtilsService
    public PackageInfo getPackageInfo(Context context, File file, int i) {
        return PackageInfoUtilsImpl.getPackageInfo(context, file, i);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadPackageInfoUtilsService
    public String getAppNameByPackageInfo(Context context, PackageInfo packageInfo, String str) {
        return PackageInfoUtilsImpl.getAppNameByPackageInfo(context, packageInfo, str);
    }
}
