package com.ss.android.socialbase.appdownloader.util.package_info;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.ss.android.socialbase.appdownloader.AppDownloadUtils;
import com.ss.android.socialbase.appdownloader.util.parser.PackageInfoParser;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes7.dex */
public class PackageInfoUtilsImpl {
    private static final String TAG = "PackageInfoUtilsImpl";

    private static String getPackage(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    public static PackageInfo getPackageInfo(File file) {
        FileInputStream fileInputStream;
        ZipInputStream zipInputStream;
        ZipEntry nextEntry;
        int next;
        long j;
        int optInt = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.APK_PARSER_ZIP_FILE);
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "getPackageInfo", "ParseType:" + optInt);
        }
        if (optInt == 1) {
            return PackageInfoParser.parseWithJarFile(file);
        }
        if (optInt == 2) {
            return PackageInfoParser.parseWithAntZipFile(file);
        }
        if (optInt == 3) {
            return PackageInfoParser.parseWithAndroidApi(file);
        }
        AXmlResourceParser aXmlResourceParser = null;
        String str = null;
        aXmlResourceParser = null;
        aXmlResourceParser = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                ZipInputStream zipInputStream2 = new ZipInputStream(fileInputStream);
                while (true) {
                    nextEntry = zipInputStream2.getNextEntry();
                    if (nextEntry == null) {
                        zipInputStream = null;
                        break;
                    }
                    if (nextEntry.isDirectory()) {
                        try {
                            zipInputStream2.closeEntry();
                        } catch (Throwable unused) {
                        }
                    } else {
                        if ("AndroidManifest.xml".equals(nextEntry.getName())) {
                            zipInputStream = zipInputStream2;
                            break;
                        }
                        zipInputStream2.closeEntry();
                    }
                }
                if (nextEntry != null) {
                    try {
                        if ("AndroidManifest.xml".equals(nextEntry.getName())) {
                            AXmlResourceParser aXmlResourceParser2 = new AXmlResourceParser();
                            try {
                                aXmlResourceParser2.open(zipInputStream);
                                do {
                                    next = aXmlResourceParser2.next();
                                    if (next == 1) {
                                        throw new CustomGetPackageInfoFailedException("已达到END_DOCUMENT");
                                    }
                                } while (next != 2);
                                int attributeCount = aXmlResourceParser2.getAttributeCount();
                                String str2 = null;
                                String str3 = null;
                                for (int i = 0; i != attributeCount; i++) {
                                    if ("versionName".equals(aXmlResourceParser2.getAttributeName(i))) {
                                        str3 = getAttributeValue(aXmlResourceParser2, i);
                                    } else if ("versionCode".equals(aXmlResourceParser2.getAttributeName(i))) {
                                        str = getAttributeValue(aXmlResourceParser2, i);
                                    } else if ("package".equals(aXmlResourceParser2.getAttributeName(i))) {
                                        str2 = getAttributeValue(aXmlResourceParser2, i);
                                    }
                                }
                                try {
                                    j = Long.parseLong(str);
                                } catch (CustomGetPackageInfoFailedException unused2) {
                                    j = -1;
                                }
                                if (j == -1) {
                                    throw new CustomGetPackageInfoFailedException("versionCode获取失败: " + str);
                                }
                                PackageInfo packageInfo = new PackageInfo();
                                packageInfo.versionName = str3;
                                packageInfo.versionCode = (int) j;
                                packageInfo.packageName = str2;
                                try {
                                    zipInputStream2.closeEntry();
                                } catch (Throwable unused3) {
                                }
                                try {
                                    aXmlResourceParser2.close();
                                } catch (Throwable unused4) {
                                }
                                if (zipInputStream != null) {
                                    try {
                                        zipInputStream.close();
                                    } catch (Throwable unused5) {
                                    }
                                }
                                try {
                                    fileInputStream.close();
                                } catch (Throwable unused6) {
                                }
                                return packageInfo;
                            } catch (Throwable th) {
                                th = th;
                                aXmlResourceParser = aXmlResourceParser2;
                                try {
                                    Logger.globalError(TAG, "getPackageInfo", "Error:" + th);
                                    throw new CustomGetPackageInfoFailedException("throwable: " + th.getMessage() + th.toString());
                                } finally {
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                throw new CustomGetPackageInfoFailedException("没有找到AndroidManifest.xml entry");
            } catch (Throwable th3) {
                th = th3;
                zipInputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            zipInputStream = null;
        }
    }

    public static PackageInfo getPackageInfo(Context context, File file, int i) {
        PackageInfo packageInfoByPackageManager;
        AppDownloadUtils.addStats("getPackageInfo_1", "ApkFile:" + (file != null ? file.getAbsolutePath() : "null"));
        int optInt = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.PARSE_PACKAGE_INFO_BY_READ_FILE_MODE);
        if (optInt == 1) {
            try {
                PackageInfo packageInfo = getPackageInfo(file);
                AppDownloadUtils.addStats("getPackageInfo_2", AppDownloadUtils.getPackageInfoLog(packageInfo));
                return packageInfo;
            } catch (Throwable th) {
                AppDownloadUtils.addStats("getPackageInfo_3", "Error:" + th);
                return null;
            }
        }
        if (optInt == 2) {
            try {
                AppDownloadUtils.addStats("getPackageInfo_4", AppDownloadUtils.getPackageInfoLog(getPackageInfo(file)));
            } catch (Throwable th2) {
                AppDownloadUtils.addStats("getPackageInfo_5", "packageInfo:" + th2);
                PackageInfo packageInfoByPackageManager2 = getPackageInfoByPackageManager(context, file, i);
                AppDownloadUtils.addStats("getPackageInfo_6", AppDownloadUtils.getPackageInfoLog(packageInfoByPackageManager2));
                return packageInfoByPackageManager2;
            }
        }
        if (Build.VERSION.SDK_INT <= 29) {
            try {
                packageInfoByPackageManager = getPackageInfo(file);
                AppDownloadUtils.addStats("getPackageInfo_7", AppDownloadUtils.getPackageInfoLog(packageInfoByPackageManager));
            } catch (Throwable th3) {
                AppDownloadUtils.addStats("getPackageInfo_8", "Error:" + th3);
                packageInfoByPackageManager = getPackageInfoByPackageManager(context, file, i);
                AppDownloadUtils.addStats("getPackageInfo_9", AppDownloadUtils.getPackageInfoLog(packageInfoByPackageManager));
            }
        } else {
            packageInfoByPackageManager = getPackageInfoByPackageManager(context, file, i);
            AppDownloadUtils.addStats("getPackageInfo_10", AppDownloadUtils.getPackageInfoLog(packageInfoByPackageManager));
            if (packageInfoByPackageManager == null) {
                try {
                    packageInfoByPackageManager = getPackageInfo(file);
                    AppDownloadUtils.addStats("getPackageInfo_11", AppDownloadUtils.getPackageInfoLog(packageInfoByPackageManager));
                } catch (Exception e) {
                    AppDownloadUtils.addStats("getPackageInfo_12", "Error:" + e);
                }
            }
        }
        AppDownloadUtils.addStats("getPackageInfo_13", AppDownloadUtils.getPackageInfoLog(packageInfoByPackageManager));
        return packageInfoByPackageManager;
    }

    private static PackageInfo getPackageInfoByPackageManager(Context context, File file, int i) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                Logger.globalError(TAG, "getPackageInfoByPackageManager", "PackageManager is null");
                AppDownloadUtils.addStats("getPackageInfoByPackageManager_1", "PackageManager is null");
                return null;
            }
            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(file.getPath(), i);
            AppDownloadUtils.addStats("getPackageInfoByPackageManager_2", AppDownloadUtils.getPackageInfoLog(packageArchiveInfo));
            return packageArchiveInfo;
        } catch (Throwable th) {
            Logger.globalError(TAG, "getPackageInfoByPackageManager", "Error:" + th);
            AppDownloadUtils.addStats("getPackageInfoByPackageManager_3", "Error:" + th);
            return null;
        }
    }

    private static String getAttributeValue(AXmlResourceParser aXmlResourceParser, int i) {
        int attributeValueType = aXmlResourceParser.getAttributeValueType(i);
        int attributeValueData = aXmlResourceParser.getAttributeValueData(i);
        if (attributeValueType == 3) {
            return aXmlResourceParser.getAttributeValue(i);
        }
        return attributeValueType == 2 ? String.format("?%s%08X", getPackage(attributeValueData), Integer.valueOf(attributeValueData)) : (attributeValueType < 16 || attributeValueType > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(attributeValueData), Integer.valueOf(attributeValueType)) : String.valueOf(attributeValueData);
    }

    public static String getAppNameByPackageInfo(Context context, PackageInfo packageInfo, String str) {
        if (packageInfo == null || packageInfo.applicationInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (OutOfMemoryError e) {
            Logger.globalError(TAG, "getAppNameByPackageInfo", " Error:" + e);
            return null;
        }
    }
}
