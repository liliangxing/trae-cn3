package com.ss.android.socialbase.downloader.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadDirUtils {
    private static final String TAG = "DownloadDirUtils";
    public static String EXT_PUBLIC_DIR = "ByteDownload";
    private static final String EXTERNAL_DOWNLOAD_DIRECTORY = Environment.DIRECTORY_DOWNLOADS + File.separator + EXT_PUBLIC_DIR;
    public static final long CALL_TIME = SystemClock.uptimeMillis();
    private static String FAST_TEMP_PATH = null;
    private static volatile File externalCacheDir = null;
    private static volatile File obbDir = null;
    private static volatile File filesDir = null;
    private static volatile File externalFilesDir = null;
    private static volatile File externalStorageDirectory = null;
    private static volatile File dataDir = null;
    private static volatile File externalStoragePublicDirectory = null;
    private static volatile Boolean isExternalStorageLegacy = null;

    public static String getExternalRelativePath() {
        return EXTERNAL_DOWNLOAD_DIRECTORY;
    }

    public static String getDefaultExtPublicPath() {
        try {
            return getExternalStorageDirectory(false).getPath() + File.separator + DownloadSetting.obtainGlobal().optString(DownloadSettingKeys.DEFAULT_SAVE_DIR_NAME, EXT_PUBLIC_DIR);
        } catch (Exception e) {
            Logger.globalError(TAG, "getDefaultExtPublicPath", "Error:" + e);
            return null;
        }
    }

    public static String getExtPublicDownloadPath() {
        try {
            return getExternalStoragePublicDirectory(false).getAbsolutePath();
        } catch (Exception e) {
            Logger.globalError(TAG, "getExtPublicDownloadPath", "Error:" + e);
            return null;
        }
    }

    public static String getDefaultExtPrivatePath() {
        try {
            Context appContext = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
            if (appContext != null) {
                return getExternalFilesDir(appContext, false).getAbsolutePath();
            }
            return null;
        } catch (Exception e) {
            Logger.globalError(TAG, "getDefaultExtPrivatePath", "Error:" + e);
            return null;
        }
    }

    public static String getGlobalSavePath() {
        try {
            File globalSaveDir = Downloader.getInstance(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext()).getGlobalSaveDir();
            if (globalSaveDir != null) {
                return globalSaveDir.getAbsolutePath();
            }
            return null;
        } catch (Exception e) {
            Logger.globalError(TAG, "getGlobalSavePath", "Error:" + e);
            return null;
        }
    }

    public static String getDefaultDataPath() {
        File filesDir2;
        Context appContext = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (appContext == null || (filesDir2 = getFilesDir(appContext, false)) == null) {
            return null;
        }
        return filesDir2.getAbsolutePath();
    }

    public static String getDownloadPath() {
        return getValidDownloadPath(Downloader.getInstance(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext()).getGlobalSaveDir());
    }

    public static String getDownloadTempPath() {
        return getValidDownloadPath(Downloader.getInstance(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext()).getGlobalSaveTempDir());
    }

    public static String getValidDownloadPath(File file) {
        Context appContext = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (isValidDirectory(file)) {
            return file.getAbsolutePath();
        }
        if (appContext == null) {
            Logger.globalError(TAG, "getValidDownloadPath", "Context is null");
            return null;
        }
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FIX_SAVE_EXTERNAL_DIR) > 0) {
            return getDefaultDataPath();
        }
        File externalFilesDir2 = getExternalFilesDir(appContext, false);
        if (isValidDirectory(externalFilesDir2)) {
            return externalFilesDir2.getAbsolutePath();
        }
        return getDefaultDataPath();
    }

    public static boolean isValidDirectory(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.exists() || file.mkdirs()) {
                return file.isDirectory();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static Uri getRootContentUri() {
        return MediaStore.Files.getContentUri("external");
    }

    public static boolean isSavePathSecurity(String str) {
        Context appContext = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (appContext != null && !TextUtils.isEmpty(str)) {
            try {
                File dataDirectory = getDataDirectory(false);
                if (dataDirectory != null && str.startsWith(dataDirectory.getAbsolutePath())) {
                    return true;
                }
                File externalCacheDir2 = getExternalCacheDir(appContext, false);
                if (externalCacheDir2 != null) {
                    if (str.startsWith(externalCacheDir2.getParent())) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                Logger.globalError(TAG, "isSavePathSecurity", "Error:" + e);
            }
        }
        return false;
    }

    public static String getDownloadFastTempPath() {
        String str = FAST_TEMP_PATH;
        if (str != null) {
            return str;
        }
        try {
            String str2 = getFilesDir(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext(), false) + File.separator + "download" + File.separator + "temp_fast_download" + File.separator + CALL_TIME;
            FAST_TEMP_PATH = str2;
            return str2;
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.globalError(TAG, "getDownloadFastTempPath", "Error:" + th);
            return null;
        }
    }

    public static File getExternalCacheDir(Context context, boolean z) {
        if (externalCacheDir != null && !z) {
            return externalCacheDir;
        }
        try {
            externalCacheDir = context.getExternalCacheDir();
        } catch (Throwable th) {
            Logger.globalError(TAG, "getExternalCacheDir", "Error:" + th);
        }
        return externalCacheDir;
    }

    public static File getObbDirStr(Context context, boolean z) {
        if (obbDir != null && !z) {
            return obbDir;
        }
        try {
            obbDir = context.getObbDir();
        } catch (Throwable th) {
            Logger.globalError(TAG, "getObbDirStr", "Error:" + th);
        }
        return obbDir;
    }

    public static File getFilesDir(Context context, boolean z) {
        if (filesDir != null && !z) {
            return filesDir;
        }
        try {
            filesDir = context.getFilesDir();
        } catch (Throwable th) {
            Logger.globalError(TAG, "getFilesDir", "Error:" + th);
        }
        return filesDir;
    }

    public static File getExternalFilesDir(Context context, boolean z) {
        if (externalFilesDir != null && !z) {
            return externalFilesDir;
        }
        try {
            externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        } catch (Throwable th) {
            Logger.globalError(TAG, "getExternalFilesDir", "Error:" + th);
        }
        return externalFilesDir;
    }

    public static File getExternalStorageDirectory(boolean z) {
        if (externalStorageDirectory != null && !z) {
            return externalStorageDirectory;
        }
        try {
            externalStorageDirectory = Environment.getExternalStorageDirectory();
        } catch (Throwable th) {
            Logger.globalError(TAG, "getExternalStorageDirectory", "Error:" + th);
        }
        return externalStorageDirectory;
    }

    public static File getDataDirectory(boolean z) {
        if (dataDir != null && !z) {
            return dataDir;
        }
        try {
            dataDir = Environment.getDataDirectory();
        } catch (Throwable th) {
            Logger.globalError(TAG, "getDataDirectory", "Error:" + th);
        }
        return dataDir;
    }

    public static File getExternalStoragePublicDirectory(boolean z) {
        if (externalStoragePublicDirectory != null && !z) {
            return externalStoragePublicDirectory;
        }
        try {
            externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        } catch (Throwable th) {
            Logger.globalError(TAG, "getExternalStoragePublicDirectory", "Error:" + th);
        }
        return externalStoragePublicDirectory;
    }

    public static boolean isExternalStorageLegacy(boolean z) {
        if (isExternalStorageLegacy != null && !z) {
            return isExternalStorageLegacy.booleanValue();
        }
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                isExternalStorageLegacy = Boolean.valueOf(Environment.isExternalStorageLegacy());
            } else {
                isExternalStorageLegacy = false;
            }
        } catch (Throwable th) {
            Logger.globalError(TAG, "isExternalStorageLegacy", "Error:" + th);
        }
        return isExternalStorageLegacy.booleanValue();
    }

    public static void forceLoadStoragePathCache(Context context) {
        getExternalCacheDir(context, true);
        getObbDirStr(context, true);
        getFilesDir(context, true);
        getExternalFilesDir(context, true);
        getExternalStorageDirectory(true);
        getDataDirectory(true);
        getExternalStoragePublicDirectory(true);
        isExternalStorageLegacy(true);
    }
}
