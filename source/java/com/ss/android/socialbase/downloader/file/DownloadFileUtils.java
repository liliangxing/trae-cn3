package com.ss.android.socialbase.downloader.file;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.ss.android.download.api.constant.Downloads;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadFileUtils {
    private static SparseArray<MediaItem> MEDIA_STORE_DATA = null;
    public static final String MODE_READ = "r";
    public static final String MODE_WRITE = "w";
    private static final String TAG = "DownloadFileUtils";
    private static volatile Boolean mEnableExternalDownload;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class MediaItem {
        public String columnId;
        public Uri contentUri;
        public String contentUriString;

        MediaItem() {
        }

        static MediaItem build(Uri uri, String str) {
            MediaItem mediaItem = new MediaItem();
            mediaItem.contentUri = uri;
            mediaItem.contentUriString = uri.toString();
            mediaItem.columnId = str;
            return mediaItem;
        }
    }

    static {
        try {
            MEDIA_STORE_DATA = new SparseArray<>();
            if (isAtLeastAndroidQ()) {
                MEDIA_STORE_DATA.put(2, MediaItem.build(MediaStore.Images.Media.getContentUri("external_primary"), "_id"));
                MEDIA_STORE_DATA.put(3, MediaItem.build(MediaStore.Video.Media.getContentUri("external_primary"), "_id"));
                MEDIA_STORE_DATA.put(4, MediaItem.build(MediaStore.Audio.Media.getContentUri("external_primary"), "_id"));
                MEDIA_STORE_DATA.put(5, MediaItem.build(MediaStore.Downloads.EXTERNAL_CONTENT_URI, "_id"));
            } else {
                MEDIA_STORE_DATA.put(2, MediaItem.build(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id"));
                MEDIA_STORE_DATA.put(3, MediaItem.build(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, "_id"));
                MEDIA_STORE_DATA.put(4, MediaItem.build(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, "_id"));
            }
        } catch (Throwable th) {
            Logger.globalError(TAG, "init", "Error:" + th);
        }
        mEnableExternalDownload = null;
    }

    public static boolean isMediaUri(String str) {
        return getTypeByUri(str) > 1;
    }

    public static String getContentUriString(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("content")) {
            return null;
        }
        for (int i = 0; i < MEDIA_STORE_DATA.size(); i++) {
            MediaItem mediaItem = MEDIA_STORE_DATA.get(MEDIA_STORE_DATA.keyAt(i));
            if (str.startsWith(mediaItem.contentUriString)) {
                return mediaItem.contentUriString;
            }
        }
        return null;
    }

    public static int getTypeByUri(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (!str.startsWith("content")) {
            return 1;
        }
        for (int i = 0; i < MEDIA_STORE_DATA.size(); i++) {
            int keyAt = MEDIA_STORE_DATA.keyAt(i);
            if (str.startsWith(MEDIA_STORE_DATA.get(keyAt).contentUriString)) {
                return keyAt;
            }
        }
        return -1;
    }

    public static void checkUri(Uri uri, int i) throws Throwable {
        MediaItem mediaItem = MEDIA_STORE_DATA.get(i);
        if (mediaItem == null) {
            throw new Throwable("Fail to check Uri, type error :" + i);
        }
        String str = mediaItem.columnId + " = ?";
        String[] strArr = {uri.getLastPathSegment()};
        Cursor cursor = null;
        try {
            cursor = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext().getContentResolver().query(Build.VERSION.SDK_INT >= 29 ? MediaStore.setIncludePending(mediaItem.contentUri) : mediaItem.contentUri, null, str, strArr, null);
            if (cursor == null || !cursor.moveToFirst()) {
                throw new Throwable("Fail to check Uri with cursor.");
            }
            DownloadUtils.safeClose(cursor);
        } catch (Throwable th) {
            DownloadUtils.safeClose(cursor);
            throw th;
        }
    }

    public static void deleteUri(Uri uri) throws Throwable {
        ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext().getContentResolver().delete(uri, null, null);
    }

    public static ParcelFileDescriptor getParcelFileDescriptor(Uri uri, String str) throws IOException {
        if (uri == null) {
            throw new IOException("Fail to get ParcelFileDescriptor, uri is null");
        }
        try {
            ParcelFileDescriptor openFileDescriptor = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext().getContentResolver().openFileDescriptor(uri, str);
            if (openFileDescriptor != null) {
                return openFileDescriptor;
            }
            throw new IOException("Fail to get ParcelFileDescriptor, fileDescriptor is null");
        } catch (Exception e) {
            throw new IOException("Fail to get ParcelFileDescriptor", e);
        }
    }

    public static FileDescriptor getFileDescriptor(Uri uri, String str) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor = getParcelFileDescriptor(uri, str);
        if (parcelFileDescriptor != null) {
            return parcelFileDescriptor.getFileDescriptor();
        }
        throw new IOException("Fail to get FileDescriptor, ParcelFileDescriptor is null");
    }

    public static long getLength(Uri uri) {
        ParcelFileDescriptor parcelFileDescriptor = null;
        try {
            parcelFileDescriptor = getParcelFileDescriptor(uri, MODE_READ);
            long statSize = parcelFileDescriptor.getStatSize();
            DownloadUtils.safeClose(parcelFileDescriptor);
            return statSize;
        } catch (Throwable unused) {
            DownloadUtils.safeClose(parcelFileDescriptor);
            return -1L;
        }
    }

    public static boolean exists(Uri uri) {
        return getLength(uri) > 0;
    }

    public static boolean emptyFile(FileOutputStream fileOutputStream) {
        try {
            fileOutputStream.write(new byte[0]);
            fileOutputStream.close();
            return true;
        } catch (Throwable th) {
            Logger.globalError(TAG, "emptyFile", "Error:" + th);
            return false;
        }
    }

    public static boolean existsAndNotEmpty(DownloadFile downloadFile) {
        return downloadFile.exists() && downloadFile.length() > 0;
    }

    public static boolean isAtLeastAndroidQ() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static Uri getUriAtLeastQ(Uri uri, String str, String str2, String str3) {
        Uri queryUriAtLeastQ = queryUriAtLeastQ(uri, str, str2, str3);
        return queryUriAtLeastQ == null ? createUriAtLeastQ(uri, str, str2, str3) : queryUriAtLeastQ;
    }

    public static Uri queryUriAtLeastQ(Uri uri, String str, String str2, String str3) {
        Cursor cursor = null;
        if (uri == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (str.startsWith("/")) {
            str = str.substring(1);
        }
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        try {
            String concat = "relative_path = ? AND _display_name = ?".concat(TextUtils.isEmpty(str3) ? "" : " AND mime_type = ?");
            String[] strArr = TextUtils.isEmpty(str3) ? new String[]{str, str2} : new String[]{str, str2, str3};
            Bundle bundle = new Bundle();
            bundle.putString("android:query-arg-sql-selection", concat);
            bundle.putStringArray("android:query-arg-sql-selection-args", strArr);
            bundle.putString("android:query-arg-sql-sort-order", "_id DESC");
            if (Build.VERSION.SDK_INT > 30) {
                bundle.putInt("android:query-arg-match-pending", 1);
            }
            Cursor query = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext().getContentResolver().query(MediaStore.setIncludePending(uri), new String[]{"_id"}, bundle, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        Uri withAppendedId = ContentUris.withAppendedId(uri, query.getLong(query.getColumnIndexOrThrow("_id")));
                        DownloadUtils.safeClose(query);
                        return withAppendedId;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    DownloadUtils.safeClose(cursor);
                    throw th;
                }
            }
            DownloadUtils.safeClose(query);
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Uri createUriAtLeastQ(Uri uri, String str, String str2, String str3) {
        Context appContext = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (appContext == null) {
            return null;
        }
        return appContext.getContentResolver().insert(uri, createContentValues(str, str2, str3));
    }

    public static ContentValues createContentValues(String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, str);
        contentValues.put("_display_name", str2);
        contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str3)) {
            contentValues.put("mime_type", str3);
        }
        return contentValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String getFilePathFromUri(Uri uri) {
        String[] strArr = {Downloads.Impl._DATA};
        String str = null;
        try {
            Context appContext = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
            if (appContext != null) {
                Cursor query = appContext.getContentResolver().query(uri, strArr, null, null, null);
                if (query != 0) {
                    try {
                        if (query.moveToFirst()) {
                            str = query.getString(query.getColumnIndex(strArr[0]));
                        }
                    } catch (Throwable th) {
                        th = th;
                        str = query;
                        DownloadUtils.safeClose(str);
                        throw th;
                    }
                }
                DownloadUtils.safeClose(query);
                return str;
            }
            DownloadUtils.safeClose(null);
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Uri getUriFromFilePath(String str) {
        Uri rootContentUri = DownloadDirUtils.getRootContentUri();
        Cursor cursor = null;
        try {
            Cursor query = Build.VERSION.SDK_INT >= 29 ? ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext().getContentResolver().query(MediaStore.setIncludePending(rootContentUri), new String[]{"_id"}, "_data=? ", new String[]{str}, null) : null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        Uri withAppendedId = ContentUris.withAppendedId(rootContentUri, query.getInt(query.getColumnIndex("_id")));
                        DownloadUtils.safeClose(query);
                        return withAppendedId;
                    }
                } catch (Throwable th) {
                    cursor = query;
                    th = th;
                    DownloadUtils.safeClose(cursor);
                    throw th;
                }
            }
            DownloadUtils.safeClose(query);
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Pair<String, String> getParentAndNameFromUri(Uri uri) {
        return getParentAndNameFromRelativePath(getFilePathFromUri(uri));
    }

    public static Pair<String, String> getParentAndNameFromRelativePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        return new Pair<>(file.getParent(), file.getName());
    }

    public static boolean isScopedStorage() {
        Context appContext = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (appContext == null) {
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "isScopedStorage", "Context is null");
            }
            return false;
        }
        int i = appContext.getApplicationInfo().targetSdkVersion;
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "isScopedStorage", "SDK_INT:" + Build.VERSION.SDK_INT + " targetSdkVersion:" + i);
        }
        if (Build.VERSION.SDK_INT < 29) {
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "isScopedStorage", "SDK_INT < Android Q");
            }
            return false;
        }
        if (i == 29 && !DownloadDirUtils.isExternalStorageLegacy(false)) {
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "isScopedStorage", "SDK_INT = Android Q and isExternalStorageLegacy");
            }
            return true;
        }
        if (i > 29) {
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "isScopedStorage", "SDK_INT > Android Q");
            }
            return true;
        }
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "isScopedStorage", "ScopedStorage = False");
        }
        return false;
    }

    public static boolean checkUriInsert(String str) {
        try {
            checkUri(Uri.parse(str), getTypeByUri(str));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isFilePathInExternalPublicDir(String str) {
        if (isMediaUri(str)) {
            return true;
        }
        File externalStorageDirectory = DownloadDirUtils.getExternalStorageDirectory(false);
        if (externalStorageDirectory == null || !str.startsWith(externalStorageDirectory.getPath())) {
            return false;
        }
        Context appContext = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (appContext == null) {
            Logger.globalError(TAG, "isFilePathInExternalPublicDir", "Context is null");
            return false;
        }
        File externalCacheDir = DownloadDirUtils.getExternalCacheDir(appContext, false);
        if (externalCacheDir == null) {
            Logger.globalError(TAG, "isFilePathInExternalPublicDir", "ExternalCacheDir is null");
            return false;
        }
        String parent = externalCacheDir.getParent();
        if (parent != null && str.startsWith(parent)) {
            return false;
        }
        File obbDirStr = DownloadDirUtils.getObbDirStr(appContext, false);
        return (obbDirStr == null || !str.startsWith(obbDirStr.getAbsolutePath())) && DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.UNCHECK_EXTERNAL_PUBLIC_DIR, 0) <= 0;
    }

    public static boolean isExternalDownloadEnabled() {
        if (mEnableExternalDownload == null) {
            mEnableExternalDownload = Boolean.valueOf(Build.VERSION.SDK_INT > 29 && DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.ENABLE_EXTERNAL_DOWNLOAD) > 0);
        }
        return mEnableExternalDownload.booleanValue();
    }

    public static void setEnableExternalDownload(boolean z) {
        mEnableExternalDownload = Boolean.valueOf(z);
    }

    public static String getExternalUriPath(String str, String str2, String str3) {
        Context appContext;
        Uri uri;
        if (!isExternalDownloadEnabled() || (appContext = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext()) == null) {
            return null;
        }
        List<DownloadInfo> downloadInfoList = Downloader.getInstance(appContext).getDownloadInfoList(str);
        if (downloadInfoList != null && !downloadInfoList.isEmpty()) {
            String str4 = null;
            for (DownloadInfo downloadInfo : downloadInfoList) {
                String savePath = downloadInfo.getSavePath();
                if (!TextUtils.isEmpty(str4) || (TextUtils.isEmpty(str4) && isMediaUri(savePath) && !checkUriInsert(savePath))) {
                    Downloader.getInstance(appContext).clearDownloadData(downloadInfo.getId());
                } else {
                    str4 = savePath;
                }
            }
            if (!TextUtils.isEmpty(str4)) {
                return str4;
            }
        }
        try {
            uri = createUriAtLeastQ(MediaStore.Downloads.EXTERNAL_CONTENT_URI, DownloadDirUtils.getExternalRelativePath(), str2, str3);
        } catch (Throwable th) {
            Logger.globalError(TAG, "getExternalSavePath", "Error:" + th);
            uri = null;
        }
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }
}
