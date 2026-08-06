package com.ss.android.socialbase.appdownloader.util.parser;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.AppDownloadUtils;
import com.ss.android.socialbase.appdownloader.util.package_info.CustomGetPackageInfoFailedException;
import com.ss.android.socialbase.appdownloader.util.parser.manifest.AXmlResourceParser;
import com.ss.android.socialbase.appdownloader.util.parser.zip.ZipEntry;
import com.ss.android.socialbase.appdownloader.util.parser.zip.ZipFile;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PackageInfoParser {
    private static final String TAG = "PackageInfoParser";

    public static PackageInfo parseWithJarFile(File file) throws CustomGetPackageInfoFailedException {
        Closeable closeable;
        JarFile jarFile = null;
        try {
            JarFile jarFile2 = new JarFile(file);
            try {
                JarEntry jarEntry = jarFile2.getJarEntry("AndroidManifest.xml");
                if (jarEntry == null) {
                    throw new CustomGetPackageInfoFailedException("JarEntry is null");
                }
                InputStream inputStream = jarFile2.getInputStream(jarEntry);
                PackageInfo parsePackageInfo = parsePackageInfo(inputStream);
                DownloadUtils.safeClose(inputStream);
                DownloadUtils.safeClose(jarFile2);
                return parsePackageInfo;
            } catch (Throwable th) {
                th = th;
                closeable = null;
                jarFile = jarFile2;
                try {
                    Logger.globalError(TAG, "parseWithJarFile", "Error:" + th);
                    th.printStackTrace();
                    throw new CustomGetPackageInfoFailedException("Error: " + th);
                } catch (Throwable th2) {
                    DownloadUtils.safeClose(closeable);
                    DownloadUtils.safeClose(jarFile);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
        }
    }

    public static PackageInfo parseWithAntZipFile(File file) throws CustomGetPackageInfoFailedException {
        Closeable closeable;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("AndroidManifest.xml");
                if (entry == null) {
                    throw new CustomGetPackageInfoFailedException("ZipEntry is null");
                }
                InputStream inputStream = zipFile2.getInputStream(entry);
                PackageInfo parsePackageInfo = parsePackageInfo(inputStream);
                DownloadUtils.safeClose(inputStream);
                DownloadUtils.safeClose(zipFile2);
                return parsePackageInfo;
            } catch (Throwable th) {
                th = th;
                closeable = null;
                zipFile = zipFile2;
                try {
                    Logger.globalError(TAG, "parseWithAntZipFile", "Error:" + th);
                    th.printStackTrace();
                    throw new CustomGetPackageInfoFailedException("Error: " + th);
                } catch (Throwable th2) {
                    DownloadUtils.safeClose(closeable);
                    DownloadUtils.safeClose(zipFile);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
        }
    }

    public static PackageInfo parseWithAndroidApi(File file) throws CustomGetPackageInfoFailedException {
        if (Process.is64Bit()) {
            try {
                PackageInfo packageArchiveInfo = DownloadComponentManager.getAppContext().getPackageManager().getPackageArchiveInfo(file.getPath(), AppDownloadUtils.getPackageInfoFlag());
                if (Logger.debug()) {
                    Logger.globalDebug(TAG, "parseWithAndroidApi", "VersionName:" + packageArchiveInfo.versionName + " versionCodeStr:" + packageArchiveInfo.versionCode + " packageName:" + packageArchiveInfo.packageName);
                }
                return packageArchiveInfo;
            } catch (Throwable th) {
                Logger.globalError(TAG, "parseWithAndroidApi", "Error:" + th);
                return null;
            }
        }
        return parseWithJarFile(file);
    }

    private static PackageInfo parsePackageInfo(InputStream inputStream) {
        AXmlResourceParser aXmlResourceParser;
        int next;
        long j;
        AXmlResourceParser aXmlResourceParser2 = null;
        String str = null;
        try {
            aXmlResourceParser = new AXmlResourceParser();
        } catch (Throwable th) {
            th = th;
        }
        try {
            aXmlResourceParser.open(inputStream);
            do {
                next = aXmlResourceParser.next();
                if (next == 1) {
                    throw new CustomGetPackageInfoFailedException("END_DOCUMENT");
                }
            } while (next != 2);
            int attributeCount = aXmlResourceParser.getAttributeCount();
            String str2 = null;
            String str3 = null;
            for (int i = 0; i != attributeCount; i++) {
                if ("versionName".equals(aXmlResourceParser.getAttributeName(i))) {
                    str = aXmlResourceParser.getAttributeValue(i);
                } else if ("versionCode".equals(aXmlResourceParser.getAttributeName(i))) {
                    str3 = aXmlResourceParser.getAttributeValue(i);
                } else if ("package".equals(aXmlResourceParser.getAttributeName(i))) {
                    str2 = aXmlResourceParser.getAttributeValue(i);
                }
            }
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "parsePackageInfo", "VersionName:" + str + " versionCodeStr:" + str3 + " packageName:" + str2);
            }
            try {
                j = Long.parseLong(str3);
            } catch (Throwable th2) {
                Logger.globalError(TAG, "parsePackageInfo", "Error:" + th2);
                j = -1;
            }
            if (j == -1) {
                Logger.globalError(TAG, "parsePackageInfo", "Error versionCode:" + str3);
                throw new CustomGetPackageInfoFailedException("Error versionCode: " + str3);
            }
            if (TextUtils.isEmpty(str2)) {
                Logger.globalError(TAG, "parsePackageInfo", "PackageName is null");
                throw new CustomGetPackageInfoFailedException("PackageName is null");
            }
            PackageInfo packageInfo = new PackageInfo();
            packageInfo.versionName = str;
            if (Build.VERSION.SDK_INT >= 28) {
                packageInfo.setLongVersionCode(j);
            } else {
                packageInfo.versionCode = (int) j;
            }
            packageInfo.packageName = str2;
            aXmlResourceParser.close();
            return packageInfo;
        } catch (Throwable th3) {
            th = th3;
            aXmlResourceParser2 = aXmlResourceParser;
            try {
                Logger.globalError(TAG, "parsePackageInfo", "Error:" + th);
                th.printStackTrace();
                throw new CustomGetPackageInfoFailedException("Error: " + th);
            } catch (Throwable th4) {
                if (aXmlResourceParser2 != null) {
                    aXmlResourceParser2.close();
                }
                throw th4;
            }
        }
    }
}
