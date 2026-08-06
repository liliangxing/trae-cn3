package com.ss.android.socialbase.downloader.p005db;

import android.database.Cursor;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class SqlDownloadHelper {
    private static int APP_VERSION_CODE_INDEX = -1;
    private static int AUXILIARY_JSONOBJECT_STRING_INDEX = -1;
    private static int BACKUP_URLS_STR_INDEX = -1;
    private static int BACKUP_URL_RETRY_COUNT_INDEX = -1;
    private static int BACK_CUR_BYTES_INDEX = -1;
    private static int CACHE_LIFE_TIME_MAX_INDEX = -1;
    private static int CDN_URLS_STR_INDEX = -1;
    private static int CHUNK_COUNT_INDEX = -1;
    private static int CUR_BYTES_INDEX = -1;
    private static int CUR_RETRY_TIME_INDEX = -1;
    private static int DEFAULT_HTTP_SERVICE_BACKUP_INDEX = -1;
    private static int DOWNLOAD_FINISH_TIMESTAMP_INDEX = -1;
    private static int DOWNLOAD_START_TIMESTAMP_INDEX = -1;
    private static int DOWNLOAD_TIME_INDEX = -1;
    private static int ETAG_INDEX = -1;
    private static int EXTRA_INDEX = -1;
    private static int FIRST_DOWNLOAD_INDEX = -1;
    private static int FIRST_SUCCESS_INDEX = -1;
    private static int FORCE_INDEX = -1;
    private static int HAS_DO_INSTALLATION_INDEX = -1;
    private static int ICON_URL_INDEX = -1;
    private static int ID_INDEX = -1;
    private static int INDEPENDENT_PROCESS_INDEX = -1;
    private static int INSTALLED_TIMESTAMP_INDEX = -1;
    private static int MD5_INDEX = -1;
    private static int MIME_TYPE_INDEX = -1;
    private static int MONITOR_SCENE_INDEX = -1;
    private static int NAME_INDEX = -1;
    private static int NEED_HTTPS_TO_HTTP_RETRY_INDEX = -1;
    private static int NOTIFICATION_ENABLE_INDEX = -1;
    private static int NOTIFICATION_VISIBILITY_INDEX = -1;
    private static int ONLY_WIFI_INDEX = -1;
    private static int PACKAGE_NAME_INDEX = -1;
    private static int PCDN_URLS_STR_INDEX = -1;
    private static int REAL_BACK_DOWNLOAD_TIME_INDEX = -1;
    private static int REAL_DOWNLOAD_TIME_INDEX = -1;
    private static int RETRY_COUNT_INDEX = -1;
    private static int SAVE_PATH_INDEX = -1;
    private static int STATUS_INDEX = -1;
    private static final String TAG = "SqlDownloadHelper";
    private static int TEMP_PATH_INDEX = -1;
    private static int TITLE_INDEX = -1;
    private static int TOTAL_BYTES_INDEX = -1;
    private static int URL_INDEX = -1;
    private static boolean isLoadIndex;

    public static boolean loadDownloadInfoIndex(Cursor cursor) {
        if (isLoadIndex) {
            return true;
        }
        try {
            ID_INDEX = cursor.getColumnIndex("_id");
            NAME_INDEX = cursor.getColumnIndex("name");
            TITLE_INDEX = cursor.getColumnIndex("title");
            URL_INDEX = cursor.getColumnIndex("url");
            SAVE_PATH_INDEX = cursor.getColumnIndex(DBDefinition.SAVE_PATH);
            TEMP_PATH_INDEX = cursor.getColumnIndex(DBDefinition.TEMP_PATH);
            STATUS_INDEX = cursor.getColumnIndex("status");
            CUR_BYTES_INDEX = cursor.getColumnIndex(DBDefinition.CUR_BYTES);
            FORCE_INDEX = cursor.getColumnIndex("force");
            MIME_TYPE_INDEX = cursor.getColumnIndex(DBDefinition.MIME_TYPE);
            CACHE_LIFE_TIME_MAX_INDEX = cursor.getColumnIndex(DBDefinition.CACHE_LIFE_TIME_MAX);
            AUXILIARY_JSONOBJECT_STRING_INDEX = cursor.getColumnIndex(DBDefinition.AUXILIARY_JSONOBJECT_STRING);
            DOWNLOAD_START_TIMESTAMP_INDEX = cursor.getColumnIndex(DBDefinition.DOWNLOAD_START_TIMESTAMP);
            MONITOR_SCENE_INDEX = cursor.getColumnIndex(DBDefinition.MONITOR_SCENE);
            CHUNK_COUNT_INDEX = cursor.getColumnIndex(DBDefinition.CHUNK_COUNT);
            BACK_CUR_BYTES_INDEX = cursor.getColumnIndex(DBDefinition.BACK_CUR_BYTES);
            TOTAL_BYTES_INDEX = cursor.getColumnIndex(DBDefinition.TOTAL_BYTES);
            ETAG_INDEX = cursor.getColumnIndex(DBDefinition.ETAG);
            ONLY_WIFI_INDEX = cursor.getColumnIndex(DBDefinition.ONLY_WIFI);
            RETRY_COUNT_INDEX = cursor.getColumnIndex(DBDefinition.RETRY_COUNT);
            EXTRA_INDEX = cursor.getColumnIndex("extra");
            NOTIFICATION_ENABLE_INDEX = cursor.getColumnIndex(DBDefinition.NOTIFICATION_ENABLE);
            NOTIFICATION_VISIBILITY_INDEX = cursor.getColumnIndex(DBDefinition.NOTIFICATION_VISIBILITY);
            FIRST_DOWNLOAD_INDEX = cursor.getColumnIndex(DBDefinition.FIRST_DOWNLOAD);
            FIRST_SUCCESS_INDEX = cursor.getColumnIndex(DBDefinition.FIRST_SUCCESS);
            NEED_HTTPS_TO_HTTP_RETRY_INDEX = cursor.getColumnIndex(DBDefinition.NEED_HTTPS_TO_HTTP_RETRY);
            DOWNLOAD_TIME_INDEX = cursor.getColumnIndex(DBDefinition.DOWNLOAD_TIME);
            PACKAGE_NAME_INDEX = cursor.getColumnIndex(DBDefinition.PACKAGE_NAME);
            MD5_INDEX = cursor.getColumnIndex("md5");
            CUR_RETRY_TIME_INDEX = cursor.getColumnIndex(DBDefinition.CUR_RETRY_TIME);
            DEFAULT_HTTP_SERVICE_BACKUP_INDEX = cursor.getColumnIndex(DBDefinition.DEFAULT_HTTP_SERVICE_BACKUP);
            BACKUP_URLS_STR_INDEX = cursor.getColumnIndex(DBDefinition.BACKUP_URLS_STR);
            BACKUP_URL_RETRY_COUNT_INDEX = cursor.getColumnIndex(DBDefinition.BACKUP_URL_RETRY_COUNT);
            REAL_DOWNLOAD_TIME_INDEX = cursor.getColumnIndex(DBDefinition.REAL_DOWNLOAD_TIME);
            REAL_BACK_DOWNLOAD_TIME_INDEX = cursor.getColumnIndex(DBDefinition.REAL_BACK_DOWNLOAD_TIME);
            INDEPENDENT_PROCESS_INDEX = cursor.getColumnIndex(DBDefinition.INDEPENDENT_PROCESS);
            ICON_URL_INDEX = cursor.getColumnIndex(DBDefinition.ICON_URL);
            APP_VERSION_CODE_INDEX = cursor.getColumnIndex(DBDefinition.APP_VERSION_CODE);
            DOWNLOAD_FINISH_TIMESTAMP_INDEX = cursor.getColumnIndex(DBDefinition.DOWNLOAD_FINISH_TIMESTAMP);
            INSTALLED_TIMESTAMP_INDEX = cursor.getColumnIndex(DBDefinition.INSTALLED_TIMESTAMP);
            HAS_DO_INSTALLATION_INDEX = cursor.getColumnIndex(DBDefinition.HAS_DO_INSTALLATION);
            PCDN_URLS_STR_INDEX = cursor.getColumnIndex(DBDefinition.PCDN_URLS_STR);
            CDN_URLS_STR_INDEX = cursor.getColumnIndex(DBDefinition.CDN_URLS_STR);
            isLoadIndex = true;
            return true;
        } catch (Exception e) {
            DownloadMonitorHelper.monitorDownloadOtherError(e);
            Logger.globalError(TAG, "loadDownloadInfoIndex", "Error:" + e);
            return false;
        }
    }

    public static DownloadInfo parsePartialDownloadInfo(Cursor cursor) {
        DownloadInfo downloadInfo = new DownloadInfo();
        parsePartialDownloadInfo(cursor, downloadInfo, parseMonitorScene(cursor, downloadInfo));
        return downloadInfo;
    }

    public static DownloadInfo parsePartialDownloadInfo(Cursor cursor, DownloadInfo downloadInfo, boolean z) {
        try {
            downloadInfo.setId(cursor.getInt(ID_INDEX));
            downloadInfo.setName(cursor.getString(NAME_INDEX));
            downloadInfo.setTitle(cursor.getString(TITLE_INDEX));
            downloadInfo.setUrl(cursor.getString(URL_INDEX));
            downloadInfo.setSavePath(cursor.getString(SAVE_PATH_INDEX));
            downloadInfo.setTempPath(cursor.getString(TEMP_PATH_INDEX));
            downloadInfo.setStatus(cursor.getInt(STATUS_INDEX));
            downloadInfo.setCurBytes(cursor.getLong(CUR_BYTES_INDEX));
            downloadInfo.setForce(cursor.getInt(FORCE_INDEX) != 0);
            downloadInfo.setMimeType(cursor.getString(MIME_TYPE_INDEX));
            downloadInfo.setCacheLifeTimeMax(cursor.getLong(CACHE_LIFE_TIME_MAX_INDEX));
            downloadInfo.setDownloadStartTimeStamp(cursor.getLong(DOWNLOAD_START_TIMESTAMP_INDEX));
            if (!z) {
                downloadInfo.setDbJsonDataString(cursor.getString(AUXILIARY_JSONOBJECT_STRING_INDEX));
            }
        } catch (Exception e) {
            DownloadMonitorHelper.monitorDownloadOtherError(e);
            Logger.globalError(TAG, "parsePartialDownloadInfo", "Error:" + e);
        }
        return downloadInfo;
    }

    public static boolean parseMonitorScene(Cursor cursor, DownloadInfo downloadInfo) {
        String string = cursor.getString(MONITOR_SCENE_INDEX);
        if (!TextUtils.isEmpty(string)) {
            downloadInfo.setMonitorScene(string);
            return false;
        }
        String string2 = cursor.getString(AUXILIARY_JSONOBJECT_STRING_INDEX);
        if (TextUtils.isEmpty(string2)) {
            return true;
        }
        downloadInfo.setDbJsonDataString(string2);
        downloadInfo.unsafeEnsureDBJsonData();
        downloadInfo.setMonitorScene(downloadInfo.getDBJsonString(DbJsonConstants.MONITOR_SCENE));
        return true;
    }

    public static void parseAllRemainingDownloadInfo(Cursor cursor, DownloadInfo downloadInfo) {
        try {
            downloadInfo.setChunkCount(cursor.getInt(CHUNK_COUNT_INDEX));
            downloadInfo.setBackCurBytes(cursor.getLong(BACK_CUR_BYTES_INDEX));
            downloadInfo.setTotalBytes(cursor.getLong(TOTAL_BYTES_INDEX));
            downloadInfo.seteTag(cursor.getString(ETAG_INDEX));
            downloadInfo.setOnlyWifi(cursor.getInt(ONLY_WIFI_INDEX) != 0);
            downloadInfo.setRetryCount(cursor.getInt(RETRY_COUNT_INDEX));
            downloadInfo.setExtra(cursor.getString(EXTRA_INDEX));
            downloadInfo.setShowNotification(cursor.getInt(NOTIFICATION_ENABLE_INDEX) != 0);
            downloadInfo.setNotificationVisibility(cursor.getInt(NOTIFICATION_VISIBILITY_INDEX));
            downloadInfo.setFirstDownload(cursor.getInt(FIRST_DOWNLOAD_INDEX) == 1);
            downloadInfo.setFirstSuccess(cursor.getInt(FIRST_SUCCESS_INDEX) == 1);
            downloadInfo.setNeedHttpsToHttpRetry(cursor.getInt(NEED_HTTPS_TO_HTTP_RETRY_INDEX) == 1);
            downloadInfo.setDownloadTime(cursor.getLong(DOWNLOAD_TIME_INDEX));
            downloadInfo.setPackageName(cursor.getString(PACKAGE_NAME_INDEX));
            downloadInfo.setMd5(cursor.getString(MD5_INDEX));
            downloadInfo.setCurRetryTime(cursor.getInt(CUR_RETRY_TIME_INDEX));
            downloadInfo.setNeedDefaultHttpServiceBackUp(cursor.getInt(DEFAULT_HTTP_SERVICE_BACKUP_INDEX) == 1);
            downloadInfo.setBackUpUrlsStr(cursor.getString(BACKUP_URLS_STR_INDEX));
            downloadInfo.setBackUpUrlRetryCount(cursor.getInt(BACKUP_URL_RETRY_COUNT_INDEX));
            downloadInfo.setRealDownloadTime(cursor.getLong(REAL_DOWNLOAD_TIME_INDEX));
            downloadInfo.setRealBackDownloadTime(cursor.getLong(REAL_BACK_DOWNLOAD_TIME_INDEX));
            downloadInfo.setNeedIndependentProcess(cursor.getInt(INDEPENDENT_PROCESS_INDEX) == 1);
            downloadInfo.setIconUrl(cursor.getString(ICON_URL_INDEX));
            downloadInfo.setAppVersionCode(cursor.getInt(APP_VERSION_CODE_INDEX));
            downloadInfo.setDownloadFinishTimeStamp(cursor.getLong(DOWNLOAD_FINISH_TIMESTAMP_INDEX));
            downloadInfo.setInstalledTimeStamp(cursor.getLong(INSTALLED_TIMESTAMP_INDEX));
            downloadInfo.setHasDoInstallation(cursor.getInt(HAS_DO_INSTALLATION_INDEX) == 1);
            downloadInfo.setPcdnUrlsStr(cursor.getString(PCDN_URLS_STR_INDEX));
            downloadInfo.setCdnUrlsStr(cursor.getString(CDN_URLS_STR_INDEX));
        } catch (Exception e) {
            DownloadMonitorHelper.monitorDownloadOtherError(e);
            Logger.globalError(TAG, "parseAllRemainingDownloadInfo", "Error:" + e);
        }
    }

    public static int parseDownloadId(Cursor cursor) {
        return cursor.getInt(ID_INDEX);
    }
}
