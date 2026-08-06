package com.ss.android.socialbase.downloader.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.BuildConfig;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.DownloadInnerConstants;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadThreadCheckListener;
import com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.model.RandomAccessOutputStream;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.http2.StreamResetException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadHelper {
    public static final String ACCEPT_ENCODING = "Accept-Encoding";
    public static final String ACCEPT_RANGES = "Accept-Ranges";
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_TYPE = "Content-Type";
    private static final String DEFAULT_SECURITY_VALUE = "StaticResource/file/Downloader";
    public static final String ETAG = "Etag";
    private static final long FILE_COPY_BUFFER_SIZE = 31457280;
    public static final String GZIP = "gzip";
    public static final String IDENTITY = "identity";
    public static final String IF_MATCH = "If-Match";
    public static final String IF_MODIFIED_SINCE = "if-modified-since";
    public static final String IF_NONE_MATCH = "If-None-Match";
    public static final String LAST_MODIFIED = "last-modified";
    public static final String LAST_MODIFIED_CASE = "Last-Modified";
    private static final long ONE_KB = 1024;
    private static final long ONE_MB = 1048576;
    private static final String SECURITY_ARGUS_KEY = "x-security-argus";
    private static final String TAG = "DownloadHelper";
    public static final String TRANSFER_ENCODING = "Transfer-Encoding";
    public static final String TTNET_PROTO_TYPE = "x-ttnet-http-proto-type";
    public static final String VALUE_CHUNKED = "chunked";
    public static final String X_CACHE = "X-Cache";
    public static final String X_CONTENT_LENGTH = "X-Content-Length";
    private static volatile String sAid;
    private static volatile String sChannel;
    private static volatile String sFullSecurityValue;
    private static Boolean sIsDownloaderProcess;
    private static Boolean sIsMainProcess;
    private static volatile SparseArray<Boolean> saveTempFileStatusMap = new SparseArray<>();
    private static volatile SparseArray<List<ITempFileSaveCompleteCallback>> saveTempFileListeners = new SparseArray<>();
    private static volatile boolean mSleepDownloadingTask = false;

    public static int convertToBytes(double d) {
        return (int) ((d * 1000.0d) / 8.0d);
    }

    public static boolean isResponseDataFromBegin(int i) {
        return i == 200 || i == 201 || i == 0;
    }

    public static void setAppInfo(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            sAid = str;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        sChannel = str2;
    }

    private static String getSecurityValue() {
        if (sFullSecurityValue != null) {
            return sFullSecurityValue;
        }
        if (TextUtils.isEmpty(sAid) || TextUtils.isEmpty(sChannel)) {
            return DEFAULT_SECURITY_VALUE;
        }
        sFullSecurityValue = "StaticResource/file/Downloader aid/" + sAid + "/" + sChannel + "/Android";
        return sFullSecurityValue;
    }

    public static void setSleepDownloadingTask(boolean z) {
        mSleepDownloadingTask = z;
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "setSleepDownloadingTask", "SleepDownloadingTask:" + mSleepDownloadingTask);
        }
    }

    public static void trySleepDownloadingTask(DownloadInfo downloadInfo) {
        if (!mSleepDownloadingTask || downloadInfo == null || downloadInfo.getTaskSleepTime() > 0) {
            return;
        }
        try {
            int optInt = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.DOWNLOADING_TASK_ANR_SLEEP_TIME_S);
            if (optInt <= 0) {
                return;
            }
            JSONArray optJSONArray = DownloadSetting.obtainGlobal().optJSONArray(DownloadSettingKeys.DOWNLOADING_TASK_ANR_SLEEP_PROHIBIT_SCENE_LIST);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString) && optString.equalsIgnoreCase(downloadInfo.getMonitorScene())) {
                        return;
                    }
                }
            }
            downloadInfo.setTaskSleepTime(optInt);
            if (Logger.debugScene(downloadInfo.getMonitorScene())) {
                Logger.taskDebug(TAG, downloadInfo.getId(), "trySleepDownloadingTask", "Sleep:" + optInt);
            }
            Thread.sleep(optInt * 1000);
        } catch (Throwable th) {
            Logger.taskError(TAG, downloadInfo.getId(), "trySleepDownloadingTask", "Error:" + th);
        }
    }

    public static long parseContentRangeOfInstanceLength(String str) {
        if (str == null) {
            return -1L;
        }
        String[] split = str.split("/");
        if (split.length >= 2) {
            try {
                return Long.parseLong(split[1]);
            } catch (NumberFormatException e) {
                Logger.globalError(TAG, "parseContentRangeOfInstanceLength", "Exception:" + e);
            }
        }
        return -1L;
    }

    public static RandomAccessOutputStream createOutputStream(DownloadInfo downloadInfo, String str, String str2, int i, boolean z) throws BaseException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new BaseException(1021, new IOException("path must be not empty"));
        }
        File file = new File(str, str2);
        boolean z2 = false;
        if (file.exists() && file.isDirectory()) {
            throw new BaseException(1035, new IOException(String.format("path is :%s, path is directory:%B:", str, Boolean.valueOf(file.isDirectory()))));
        }
        if (!file.exists()) {
            try {
                File file2 = new File(str);
                if (!file2.exists() || !file2.isDirectory()) {
                    if (!file2.exists()) {
                        if (!file2.mkdirs() && !file2.exists()) {
                            if (DownloadSetting.obtain(downloadInfo).optInt(DownloadSettingKeys.OPT_MKDIR_FAILED, 0) != 1) {
                                throw new BaseException(1030, "download savePath directory can not created:" + str);
                            }
                            int i2 = 0;
                            while (!z2) {
                                int i3 = i2 + 1;
                                if (i2 >= 3) {
                                    break;
                                }
                                try {
                                    Thread.sleep(10L);
                                    z2 = file2.mkdirs();
                                    i2 = i3;
                                } catch (InterruptedException unused) {
                                }
                            }
                            if (!z2) {
                                if (DownloadUtils.getAvailableSpaceBytes(downloadInfo.getSavePath()) < DownloadConstants.MK_DIR_MIN_SPACE) {
                                    throw new BaseException(1006, "download savePath directory can not created:" + str);
                                }
                                throw new BaseException(1030, "download savePath directory can not created:" + str);
                            }
                        }
                    } else {
                        file2.delete();
                        if (!file2.mkdirs() && !file2.exists()) {
                            throw new BaseException(DownloadErrorCode.ERROR_SAVE_PATH_NOT_DIRECTORY, "download savePath is not directory:path=" + str);
                        }
                        throw new BaseException(DownloadErrorCode.ERROR_SAVE_PATH_NOT_DIRECTORY, "download savePath is not directory:" + str);
                    }
                }
                file.createNewFile();
            } catch (IOException e) {
                throw new BaseException(1036, e);
            }
        }
        return new RandomAccessOutputStream(file, i, z);
    }

    public static boolean checkPermission(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true;
    }

    public static void saveFileAsTargetName(DownloadInfo downloadInfo, IDownloadMonitorDepend iDownloadMonitorDepend, ITempFileSaveCompleteCallback iTempFileSaveCompleteCallback) {
        boolean z;
        BaseException baseException;
        boolean z2;
        boolean z3;
        if (Logger.debugScene(downloadInfo)) {
            Logger.taskDebug(TAG, downloadInfo, "saveFileAsTargetName", "TargetName: " + downloadInfo.getTargetFilePath());
        }
        try {
            synchronized (saveTempFileStatusMap) {
                if (saveTempFileStatusMap.get(downloadInfo.getId()) == Boolean.TRUE) {
                    if (Logger.debugScene(downloadInfo)) {
                        Logger.taskDebug(TAG, downloadInfo, "saveFileAsTargetName", "Has another same task is saving temp file");
                    }
                    if (iTempFileSaveCompleteCallback != null) {
                        List<ITempFileSaveCompleteCallback> list = saveTempFileListeners.get(downloadInfo.getId());
                        if (list == null) {
                            list = new ArrayList<>();
                            saveTempFileListeners.put(downloadInfo.getId(), list);
                        }
                        list.add(iTempFileSaveCompleteCallback);
                        iTempFileSaveCompleteCallback.onSameTaskSave();
                    }
                    return;
                }
                if (Logger.debugScene(downloadInfo)) {
                    Logger.taskDebug(TAG, downloadInfo, "saveFileAsTargetName", "SaveTempFileStatusMap put id:" + downloadInfo.getId());
                }
                saveTempFileStatusMap.put(downloadInfo.getId(), Boolean.TRUE);
                DownloadFile downloadFile = new DownloadFile(downloadInfo.getTempPath(), downloadInfo.getTempName());
                DownloadFile downloadFile2 = new DownloadFile(downloadInfo.getSavePath(), downloadInfo.getName());
                if (!downloadInfo.isForce() && DownloadFileUtils.existsAndNotEmpty(downloadFile2) && DownloadUtils.checkFileLength(downloadInfo, downloadFile2)) {
                    if (Logger.debugScene(downloadInfo)) {
                        Logger.taskDebug(TAG, downloadInfo, "saveFileAsTargetName", "TargetFile exist");
                    }
                    long uptimeMillis = SystemClock.uptimeMillis();
                    int checkMd5Status = DownloadUtils.checkMd5Status(downloadFile2, downloadInfo.getMd5());
                    downloadInfo.setMd5Time(SystemClock.uptimeMillis() - uptimeMillis);
                    if (DownloadUtils.isMd5Valid(checkMd5Status)) {
                        if (Logger.debugScene(downloadInfo)) {
                            Logger.taskDebug(TAG, downloadInfo, "saveFileAsTargetName", "TempFile not exist , targetFile exists and md5 check valid");
                        }
                        downloadInfo.setTTMd5CheckStatus(checkMd5Status);
                        if (iTempFileSaveCompleteCallback != null) {
                            iTempFileSaveCompleteCallback.onSuccess();
                        }
                        handleTempSaveCallback(downloadInfo.getId(), true, null);
                    } else {
                        if (downloadFile.exists()) {
                            z3 = true;
                        } else {
                            BaseException baseException2 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName(), DownloadUtils.getMd5StatusMsg(checkMd5Status)));
                            if (iTempFileSaveCompleteCallback != null) {
                                iTempFileSaveCompleteCallback.onFailed(baseException2);
                            }
                            handleTempSaveCallback(downloadInfo.getId(), false, baseException2);
                            z3 = false;
                        }
                        if (!downloadFile2.delete()) {
                            if (z3) {
                                BaseException baseException3 = new BaseException(1037, "delete targetPath file existed with md5 check invalid status:" + DownloadUtils.getMd5StatusMsg(checkMd5Status));
                                if (iTempFileSaveCompleteCallback != null) {
                                    iTempFileSaveCompleteCallback.onFailed(baseException3);
                                }
                                handleTempSaveCallback(downloadInfo.getId(), false, baseException3);
                            } else if (iDownloadMonitorDepend != null) {
                                DownloadMonitorHelper.monitorSendWithTaskMonitor(iDownloadMonitorDepend, downloadInfo, new BaseException(1038, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), downloadInfo.getStatus());
                            }
                        }
                        z = z3;
                    }
                    z3 = false;
                    z = z3;
                } else if (downloadFile.exists()) {
                    z = true;
                } else {
                    BaseException baseException4 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                    if (iTempFileSaveCompleteCallback != null) {
                        iTempFileSaveCompleteCallback.onFailed(baseException4);
                    }
                    handleTempSaveCallback(downloadInfo.getId(), false, baseException4);
                    z = false;
                }
                if (z) {
                    try {
                        int optInt = DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.DOWNLOAD_FINISH_CHECK_TTMD5, 2);
                        if (optInt > 0) {
                            long uptimeMillis2 = SystemClock.uptimeMillis();
                            int checkMd5Status2 = DownloadUtils.checkMd5Status(downloadFile, downloadInfo.getMd5());
                            downloadInfo.setMd5Time(SystemClock.uptimeMillis() - uptimeMillis2);
                            downloadInfo.setTTMd5CheckStatus(checkMd5Status2);
                            if (optInt >= 2 && !DownloadUtils.isMd5Valid(checkMd5Status2)) {
                                BaseException baseException5 = new BaseException(1034, DownloadUtils.getMd5StatusMsg(checkMd5Status2));
                                if (iTempFileSaveCompleteCallback != null) {
                                    iTempFileSaveCompleteCallback.onFailed(baseException5);
                                }
                                handleTempSaveCallback(downloadInfo.getId(), false, baseException5);
                                DownloadUtils.deleteAllDownloadFiles(downloadInfo, DownloadDirUtils.isSavePathSecurity(downloadInfo.getSavePath()));
                                return;
                            }
                        }
                        z2 = !moveFile(downloadFile, downloadFile2);
                        baseException = null;
                    } catch (BaseException e) {
                        baseException = e;
                        z2 = true;
                    }
                    if (z2) {
                        if (baseException == null) {
                            baseException = new BaseException(1038, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                        }
                        if (iTempFileSaveCompleteCallback != null) {
                            iTempFileSaveCompleteCallback.onFailed(baseException);
                        }
                        handleTempSaveCallback(downloadInfo.getId(), false, baseException);
                        return;
                    }
                    if (iTempFileSaveCompleteCallback != null) {
                        iTempFileSaveCompleteCallback.onSuccess();
                    }
                    handleTempSaveCallback(downloadInfo.getId(), true, null);
                }
            }
        } catch (Throwable th) {
            BaseException baseException6 = new BaseException(1038, DownloadUtils.getErrorMsgWithTagPrefix(th, "saveFileAsTargetName") + " " + Log.getStackTraceString(th));
            if (Logger.debugScene(downloadInfo)) {
                Logger.taskDebug(TAG, downloadInfo, "saveFileAsTargetName", "Error: " + baseException6);
            }
            if (iTempFileSaveCompleteCallback != null) {
                iTempFileSaveCompleteCallback.onFailed(baseException6);
            }
            handleTempSaveCallback(downloadInfo.getId(), false, baseException6);
        }
    }

    private static void handleTempSaveCallback(int i, boolean z, BaseException baseException) {
        synchronized (saveTempFileStatusMap) {
            List<ITempFileSaveCompleteCallback> list = saveTempFileListeners.get(i);
            if (list != null) {
                for (ITempFileSaveCompleteCallback iTempFileSaveCompleteCallback : list) {
                    if (iTempFileSaveCompleteCallback != null) {
                        if (z) {
                            iTempFileSaveCompleteCallback.onSuccess();
                        } else {
                            iTempFileSaveCompleteCallback.onFailed(baseException);
                        }
                    }
                }
            }
            if (Logger.debug()) {
                Logger.taskDebug(TAG, i, "handleTempSaveCallback", "Run");
            }
            saveTempFileStatusMap.remove(i);
        }
    }

    public static void copyFileFromExistFileWithSameName(DownloadInfo downloadInfo, String str, String str2) throws BaseException {
        if (downloadInfo == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || str2.equals(downloadInfo.getName())) {
            return;
        }
        DownloadFile downloadFile = new DownloadFile(downloadInfo.getSavePath(), str2);
        DownloadFile downloadFile2 = new DownloadFile(downloadInfo.getSavePath(), downloadInfo.getName());
        if (Logger.debugScene(downloadInfo)) {
            Logger.taskDebug(TAG, downloadInfo, "copyFileFromExistFileWithSameName", "ExistFile:" + downloadFile.getPath() + " targetFile:" + downloadFile2.getPath());
        }
        if (downloadFile2.exists() && !downloadFile2.canWrite()) {
            throw new BaseException(1001, "targetPath file exists but read-only");
        }
        if (!copyFile(downloadFile, downloadFile2, true)) {
            throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", downloadInfo.getSavePath(), str2, downloadInfo.getSavePath(), downloadInfo.getName()));
        }
    }

    public static boolean copyFile(File file, File file2) throws BaseException {
        return copyFile(file, file2, true);
    }

    public static boolean copyFile(File file, File file2, boolean z) throws BaseException {
        return copyFile(new DownloadFile(file), new DownloadFile(file2), z);
    }

    public static boolean copyFile(DownloadFile downloadFile, DownloadFile downloadFile2, boolean z) throws BaseException {
        File parentFile;
        if (downloadFile != null && downloadFile2 != null) {
            try {
                if (downloadFile.exists() && !downloadFile.isDirectory() && !downloadFile.getAbsolutePath().equals(downloadFile2.getAbsolutePath())) {
                    if (downloadFile2.isTypeFile() && (parentFile = downloadFile2.getParentFile()) != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new BaseException(1053, "Destination '" + parentFile + "' directory cannot be created");
                    }
                    if (Logger.debug()) {
                        Logger.globalDebug(TAG, "copyFile", "SrcFile:" + downloadFile.getPath() + " DestFile:" + downloadFile2.getPath());
                    }
                    if (downloadFile2.exists() && !downloadFile2.canWrite()) {
                        throw new IOException("Destination '" + downloadFile2.getAbsolutePath() + "' exists but is read-only");
                    }
                    doCopyFile(downloadFile, downloadFile2, z);
                    return true;
                }
            } catch (BaseException e) {
                throw e;
            } catch (Throwable th) {
                parseException(th, "CopyFile");
                return false;
            }
        }
        return false;
    }

    private static void doCopyFile(DownloadFile downloadFile, DownloadFile downloadFile2, boolean z) throws IOException {
        if (downloadFile2.exists() && downloadFile2.isDirectory()) {
            throw new IOException("Destination '" + downloadFile2 + "' exists but is a directory");
        }
        if (DownloadFileUtils.isExternalDownloadEnabled() && downloadFile2.getFileType() > 1) {
            copyFileToExternal(DownloadComponentManager.getAppContext(), downloadFile.getPath(), Uri.parse(downloadFile2.getRealPath()));
            return;
        }
        if (Build.VERSION.SDK_INT >= 29 && DownloadFileUtils.isFilePathInExternalPublicDir(downloadFile2.getPath())) {
            Uri uriFromFilePath = DownloadFileUtils.getUriFromFilePath(downloadFile2.getPath());
            if (uriFromFilePath == null) {
                throw new IOException("Destination " + downloadFile2 + "exists but contentUri is null");
            }
            copyFileToExternal(DownloadComponentManager.getAppContext(), downloadFile.getPath(), uriFromFilePath);
            return;
        }
        FileInputStream obtainInputStream = downloadFile.obtainInputStream();
        try {
            FileChannel channel = obtainInputStream.getChannel();
            try {
                FileOutputStream obtainOutputStream = downloadFile2.obtainOutputStream();
                try {
                    FileChannel channel2 = obtainOutputStream.getChannel();
                    try {
                        long size = channel.size();
                        long j = 0;
                        while (j < size) {
                            long j2 = size - j;
                            long transferFrom = channel2.transferFrom(channel, j, j2 > FILE_COPY_BUFFER_SIZE ? 31457280L : j2);
                            if (transferFrom == 0) {
                                break;
                            } else {
                                j += transferFrom;
                            }
                        }
                        if (channel2 != null) {
                            channel2.close();
                        }
                        if (obtainOutputStream != null) {
                            obtainOutputStream.close();
                        }
                        if (channel != null) {
                            channel.close();
                        }
                        if (obtainInputStream != null) {
                            obtainInputStream.close();
                        }
                        long length = downloadFile.length();
                        long length2 = downloadFile2.length();
                        if (length != length2) {
                            throw new IOException("Failed to copy full contents from '" + downloadFile + "' to '" + downloadFile2 + "' Expected length: " + length + " Actual: " + length2);
                        }
                        if (z) {
                            downloadFile2.setLastModified(downloadFile.lastModified());
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.io.Closeable[]] */
    public static void copyFileToExternal(Context context, String str, Uri uri) {
        OutputStream outputStream;
        ContentResolver contentResolver = context.getContentResolver();
        OutputStream outputStream2 = null;
        try {
            ?? fileInputStream = new FileInputStream(new File(str));
            if (uri != null) {
                try {
                    outputStream2 = contentResolver.openOutputStream(uri);
                } catch (IOException e) {
                    e = e;
                    outputStream = outputStream2;
                    outputStream2 = fileInputStream;
                    try {
                        Logger.globalError(TAG, "copyFileToExternal", "Error:" + e);
                        DownloadUtils.safeClose(outputStream2);
                        DownloadUtils.safeClose(outputStream);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        DownloadUtils.safeClose(outputStream2);
                        DownloadUtils.safeClose(outputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = outputStream2;
                    outputStream2 = fileInputStream;
                    DownloadUtils.safeClose(outputStream2);
                    DownloadUtils.safeClose(outputStream);
                    throw th;
                }
            }
            if (outputStream2 != null) {
                byte[] bArr = new byte[DownloadComponentManager.getWriteBufferSize()];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        outputStream2.write(bArr, 0, read);
                    }
                }
            }
            DownloadUtils.safeClose((Closeable[]) new Closeable[]{fileInputStream});
            DownloadUtils.safeClose(outputStream2);
        } catch (IOException e2) {
            e = e2;
            outputStream = null;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
    }

    public static boolean moveFile(DownloadFile downloadFile, DownloadFile downloadFile2) throws BaseException {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "moveFile", "DownloadFile Src:" + downloadFile.getPath() + " Dest:" + downloadFile2.getPath());
        }
        boolean renameTo = (DownloadFileUtils.isScopedStorage() && !DownloadFileUtils.isFilePathInExternalPublicDir(downloadFile.getAbsolutePath()) && DownloadFileUtils.isFilePathInExternalPublicDir(downloadFile2.getAbsolutePath())) ? false : downloadFile.renameTo(downloadFile2);
        if (!renameTo) {
            renameTo = copyFile(downloadFile, downloadFile2, true);
            try {
                if (Logger.debug()) {
                    Logger.globalDebug(TAG, "moveFile", "Copy DownloadFile Src:" + downloadFile.getPath() + " Dest:" + downloadFile2.getPath());
                }
                downloadFile.delete();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return renameTo;
    }

    public static boolean canAcceptPartial(int i, String str) {
        if (i >= 400) {
            return false;
        }
        return i == 206 || i == 1 || "bytes".equals(str);
    }

    public static boolean isChunkedTask(IDownloadHeadHttpConnection iDownloadHeadHttpConnection) {
        if (iDownloadHeadHttpConnection == null) {
            return false;
        }
        return "chunked".equals(iDownloadHeadHttpConnection.getResponseHeaderField("Transfer-Encoding")) || DownloadUtils.getContentLength(iDownloadHeadHttpConnection) == -1;
    }

    public static List<HttpHeader> addRangeHeader(List<HttpHeader> list, String str, long j, long j2) {
        String format;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (HttpHeader httpHeader : list) {
                if (httpHeader != null && (!ACCEPT_ENCODING.equalsIgnoreCase(httpHeader.getName()) || !GZIP.equalsIgnoreCase(httpHeader.getValue()))) {
                    arrayList.add(httpHeader);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new HttpHeader(IF_MATCH, str));
        }
        arrayList.add(new HttpHeader(ACCEPT_ENCODING, "identity"));
        if (j2 <= 0) {
            format = String.format(Locale.US, "bytes=%d-", Long.valueOf(j));
        } else {
            format = String.format(Locale.US, "bytes=%d-%d", Long.valueOf(j), Long.valueOf(j2));
        }
        arrayList.add(new HttpHeader("Range", format));
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "addRangeHeader", "CurrentOffset:" + j + " EndOffset:" + j2 + ", range = " + format);
        }
        return arrayList;
    }

    public static boolean isMainProcess() {
        Boolean bool = sIsMainProcess;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = false;
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FORCE_INDEPENDENT_PROCESS) > 0) {
            Boolean bool2 = false;
            sIsMainProcess = bool2;
            return bool2.booleanValue();
        }
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FORCE_MAIN_PROCESS) > 0) {
            Boolean bool3 = true;
            sIsMainProcess = bool3;
            return bool3.booleanValue();
        }
        if (DownloadComponentManager.getAppContext() == null) {
            return true;
        }
        String curProcessName = DownloadUtils.getCurProcessName(DownloadComponentManager.getAppContext());
        if (curProcessName != null && curProcessName.contains(Constants.COLON_SEPARATOR)) {
            sIsMainProcess = false;
        } else {
            if (curProcessName != null && curProcessName.equals(DownloadComponentManager.getAppContext().getPackageName())) {
                z = true;
            }
            sIsMainProcess = Boolean.valueOf(z);
        }
        return sIsMainProcess.booleanValue();
    }

    public static boolean needNotifyDownloaderProcess() {
        return !isDownloaderProcess() && DownloadComponentManager.isDownloadInMultiProcess() && DownloadProxy.get(true).isServiceAlive();
    }

    public static boolean isDownloaderProcess() {
        Boolean bool = sIsDownloaderProcess;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (DownloadComponentManager.getAppContext() == null) {
            return false;
        }
        String curProcessName = DownloadUtils.getCurProcessName(DownloadComponentManager.getAppContext());
        if (curProcessName != null && curProcessName.equals(DownloadComponentManager.getAppContext().getPackageName() + ":downloader")) {
            sIsDownloaderProcess = true;
        } else {
            sIsDownloaderProcess = false;
        }
        return sIsDownloaderProcess.booleanValue();
    }

    public static boolean isTimeOutException(Throwable th) {
        if (th == null) {
            return false;
        }
        String throwableMsg = DownloadUtils.getThrowableMsg(th);
        if (!(th instanceof SocketTimeoutException)) {
            if (TextUtils.isEmpty(throwableMsg)) {
                return false;
            }
            if (!throwableMsg.contains("time out") && !throwableMsg.contains("Time-out")) {
                return false;
            }
        }
        return true;
    }

    public static boolean isForbiddenException(Throwable th) {
        DownloadHttpException downloadHttpException;
        if (th == null) {
            return false;
        }
        String throwableMsg = DownloadUtils.getThrowableMsg(th);
        if (!(th instanceof DownloadHttpException) || (((downloadHttpException = (DownloadHttpException) th) == null || downloadHttpException.getHttpStatusCode() != 403) && (TextUtils.isEmpty(throwableMsg) || !throwableMsg.contains("403")))) {
            return !TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("Forbidden");
        }
        return true;
    }

    public static boolean isNetNotAvailableException(Throwable th) {
        if (th == null) {
            return false;
        }
        String throwableMsg = DownloadUtils.getThrowableMsg(th);
        return !TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("network not available");
    }

    public static boolean isConnectionException(Throwable th) {
        if (th == null) {
            return false;
        }
        String throwableMsg = DownloadUtils.getThrowableMsg(th);
        return !TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("Exception in connect");
    }

    public static boolean isResponseCode412Error(Throwable th) {
        if (th == null) {
            return false;
        }
        if (DownloadComponentManager.getTTNetHandler().getResponseCode(th) == 412) {
            return true;
        }
        String throwableMsg = DownloadUtils.getThrowableMsg(th);
        return !TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("Precondition Failed");
    }

    public static boolean isResponseCode416Error(Throwable th) {
        if (th == null) {
            return false;
        }
        if (DownloadComponentManager.getTTNetHandler().getResponseCode(th) == 416) {
            return true;
        }
        String throwableMsg = DownloadUtils.getThrowableMsg(th);
        return !TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("Requested Range Not Satisfiable");
    }

    public static boolean isHttpDataDirtyError(BaseException baseException) {
        return baseException != null && (baseException.getErrorCode() == 1051 || baseException.getErrorCode() == 1027 || baseException.getErrorCode() == 1026 || baseException.getErrorCode() == 1044);
    }

    public static boolean isResponseCodeError(BaseException baseException) {
        if (baseException instanceof DownloadHttpException) {
            DownloadHttpException downloadHttpException = (DownloadHttpException) baseException;
            if (downloadHttpException.getHttpStatusCode() == 412 || downloadHttpException.getHttpStatusCode() == 416) {
                return true;
            }
        }
        return false;
    }

    public static boolean isInterceptError(Throwable th) {
        return th != null && (th instanceof BaseException) && ((BaseException) th).getErrorCode() == 1083;
    }

    public static boolean isHttpsError(BaseException baseException) {
        if (baseException == null) {
            return false;
        }
        return baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException));
    }

    public static void parseException(Throwable th, String str) throws BaseException {
        String str2 = !TextUtils.isEmpty(str) ? str : "";
        if (th instanceof BaseException) {
            BaseException baseException = (BaseException) th;
            baseException.setErrorMsg(str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + baseException.getErrorMessage());
            throw baseException;
        }
        if (th instanceof SSLHandshakeException) {
            throw new BaseException(1011, DownloadUtils.getErrorMsgWithTagPrefix(th, str2));
        }
        if (isTimeOutException(th)) {
            throw new BaseException(1048, DownloadUtils.getErrorMsgWithTagPrefix(th, str2));
        }
        if (isResponseCode412Error(th)) {
            throw new DownloadHttpException(1004, 412, DownloadUtils.getErrorMsgWithTagPrefix(th, str2));
        }
        if (isResponseCode416Error(th)) {
            throw new DownloadHttpException(1004, 416, DownloadUtils.getErrorMsgWithTagPrefix(th, str2));
        }
        if (isForbiddenException(th)) {
            throw new BaseException(1047, DownloadUtils.getErrorMsgWithTagPrefix(th, str2));
        }
        if (isNetNotAvailableException(th)) {
            throw new BaseException(1049, DownloadUtils.getErrorMsgWithTagPrefix(th, str2));
        }
        if (isConnectionException(th)) {
            throw new BaseException(1041, DownloadUtils.getErrorMsgWithTagPrefix(th, str2));
        }
        if (th instanceof IOException) {
            parseTTNetException(th, str);
            parseIOException((IOException) th, str);
            return;
        }
        throw new BaseException(1000, DownloadUtils.getErrorMsgWithTagPrefix(th, str2));
    }

    public static DownloadTTNetException getTTNetException(Throwable th, String str) {
        DownloadTTNetException translateTTNetException = DownloadComponentManager.getTTNetHandler().translateTTNetException(th, null);
        if (translateTTNetException == null) {
            translateTTNetException = DownloadComponentManager.getTTNetHandler().translateTTNetException(th.getCause(), null);
        }
        if (translateTTNetException == null) {
            return null;
        }
        return new DownloadTTNetException(translateTTNetException.getErrorCode(), DownloadUtils.getErrorMsgWithTagPrefix(translateTTNetException, str)).setRequestLog(translateTTNetException.getRequestLog()).setRemoteIp(translateTTNetException.getRemoteIp());
    }

    private static void parseTTNetException(Throwable th, String str) throws DownloadTTNetException {
        DownloadTTNetException tTNetException = getTTNetException(th, str);
        if (tTNetException != null) {
            throw tTNetException;
        }
    }

    public static void parseIOException(IOException iOException, String str) throws BaseException {
        if (str == null) {
            str = "";
        }
        String errorMsgWithTagPrefix = DownloadUtils.getErrorMsgWithTagPrefix(iOException, str);
        if (iOException instanceof ConnectException) {
            throw new BaseException(1041, errorMsgWithTagPrefix);
        }
        if (iOException instanceof UnknownHostException) {
            throw new BaseException(1055, errorMsgWithTagPrefix);
        }
        if (iOException instanceof NoRouteToHostException) {
            throw new BaseException(1056, errorMsgWithTagPrefix);
        }
        if (iOException instanceof UnknownServiceException) {
            throw new BaseException(1057, errorMsgWithTagPrefix);
        }
        if (iOException instanceof PortUnreachableException) {
            throw new BaseException(1058, errorMsgWithTagPrefix);
        }
        if (iOException instanceof SocketTimeoutException) {
            throw new BaseException(1048, errorMsgWithTagPrefix);
        }
        if (iOException instanceof SocketException) {
            throw new BaseException(1059, errorMsgWithTagPrefix);
        }
        if (iOException instanceof HttpRetryException) {
            throw new BaseException(1060, errorMsgWithTagPrefix);
        }
        if (iOException instanceof ProtocolException) {
            throw new BaseException(1061, errorMsgWithTagPrefix);
        }
        if (iOException instanceof MalformedURLException) {
            throw new BaseException(1062, errorMsgWithTagPrefix);
        }
        if (iOException instanceof FileNotFoundException) {
            throw new BaseException(1063, errorMsgWithTagPrefix);
        }
        if (iOException instanceof InterruptedIOException) {
            throw new BaseException(1064, errorMsgWithTagPrefix);
        }
        if (iOException instanceof UnsupportedEncodingException) {
            throw new BaseException(1065, errorMsgWithTagPrefix);
        }
        if (iOException instanceof EOFException) {
            throw new BaseException(1066, errorMsgWithTagPrefix);
        }
        if (iOException instanceof StreamResetException) {
            throw new BaseException(1067, errorMsgWithTagPrefix);
        }
        if (iOException instanceof SSLException) {
            throw new BaseException(1011, errorMsgWithTagPrefix);
        }
        if (DownloadUtils.isInsufficientSpaceError(iOException)) {
            throw new BaseException(1006, errorMsgWithTagPrefix);
        }
        throw new BaseException(1023, errorMsgWithTagPrefix);
    }

    public static ListenerType convertListenerType(int i) {
        ListenerType listenerType = ListenerType.MAIN;
        if (i == ListenerType.SUB.ordinal()) {
            return ListenerType.SUB;
        }
        return i == ListenerType.NOTIFICATION.ordinal() ? ListenerType.NOTIFICATION : listenerType;
    }

    public static <K> HashMap<Integer, K> sparseArrayToHashMap(SparseArray<K> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        HashMap<Integer, K> hashMap = new HashMap<>();
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int keyAt = sparseArray.keyAt(i);
            hashMap.put(Integer.valueOf(keyAt), sparseArray.valueAt(i));
        }
        return hashMap;
    }

    public static <K> void sparseArrayPutAll(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (map == null || sparseArray == null) {
            return;
        }
        for (Map.Entry<Integer, K> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                sparseArray.put(entry.getKey().intValue(), entry.getValue());
            }
        }
    }

    public static <K, V> void mapConvertToList(Map<K, V> map, List<V> list) {
        if (map == null || list == null) {
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                list.add(entry.getValue());
            }
        }
    }

    public static Map<Integer, DownloadInfo> listConvertToMap(List<DownloadInfo> list) {
        if (list == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (DownloadInfo downloadInfo : list) {
            if (downloadInfo.getId() != 0) {
                hashMap.put(Integer.valueOf(downloadInfo.getId()), downloadInfo);
            }
        }
        return hashMap;
    }

    public static List<Integer> setConvertToList(Set<Integer> set) {
        if (set == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static <K, V> void copyMap(Map<K, V> map, Map<K, V> map2) {
        if (map == null || map2 == null) {
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public static long getFirstOffset(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return -1L;
        }
        return downloadInfo.getCurBytes();
    }

    public static long getCurByte(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0L;
        }
        boolean isFileDataValid = downloadInfo.isFileDataValid();
        if (Logger.debugScene(downloadInfo)) {
            Logger.taskDebug(TAG, downloadInfo, "getCurByte", "ResumeAvailable:" + isFileDataValid);
        }
        if (isFileDataValid) {
            return downloadInfo.getCurBytes();
        }
        return 0L;
    }

    public static String getFixLengthString(String str, int i) {
        return i == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    public static void addTTNetParam(DownloadSetting downloadSetting, List<HttpHeader> list, DownloadInfo downloadInfo) {
        long throttleNetSpeed = downloadInfo.getThrottleNetSpeed();
        if (throttleNetSpeed > 0) {
            list.add(new HttpHeader(DownloadConstants.EXTRA_THROTTLE_NET_SPEED, String.valueOf(throttleNetSpeed)));
        }
        long ttnetProtectTimeout = downloadInfo.getTtnetProtectTimeout();
        if (ttnetProtectTimeout > 300) {
            list.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_PROTECT_TIMEOUT, String.valueOf(ttnetProtectTimeout)));
        }
        if (downloadInfo.isAddTTNetCommonParam()) {
            list.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_TTNET_COMMON_PARAMS, "true"));
        }
        if (downloadSetting.optInt(DownloadSettingKeys.ENABLE_DOWNLOAD_NETWORK_TAG, 0) > 0) {
            list.add(new HttpHeader(DownloadInnerConstants.TTNET_BIZ_ID_HEADER_NAME, "dl"));
            list.add(new HttpHeader(DownloadInnerConstants.TTNET_BIZ_VERSION_HEADER_NAME, BuildConfig.DL_VERSION_NAME));
        }
        int optInt = downloadSetting.optInt(DownloadSettingKeys.TTNET_ERROR_PROTO_TYPE, 0);
        if (optInt > 0) {
            list.add(new HttpHeader(TTNET_PROTO_TYPE, String.valueOf(optInt)));
        }
        if (downloadSetting.optInt(DownloadSettingKeys.FIX_VULNERABILITY_CSRF, 1) > 0) {
            list.add(new HttpHeader(SECURITY_ARGUS_KEY, getSecurityValue()));
        }
    }

    public static long parserMaxAge(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            Matcher matcher = Pattern.compile("max-age=([0-9]+)").matcher(str);
            if (matcher.find()) {
                return Long.parseLong(matcher.group(1));
            }
            return 0L;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public static HashMap<String, Integer> jsonObjectToHashMap(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next != null) {
                hashMap.put(next, Integer.valueOf(jSONObject.optInt(next, 0)));
            }
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    public static DownloadInfo parseDownloadInfo(Cursor cursor) {
        if (cursor == null) {
            return new DownloadInfo();
        }
        DownloadInfo.RawBuilder rawBuilder = new DownloadInfo.RawBuilder();
        try {
            int columnIndex = cursor.getColumnIndex("_id");
            if (columnIndex != -1) {
                rawBuilder.f76id = cursor.getInt(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("name");
            if (columnIndex2 != -1) {
                rawBuilder.name(cursor.getString(columnIndex2));
            }
            int columnIndex3 = cursor.getColumnIndex("title");
            if (columnIndex3 != -1) {
                rawBuilder.title(cursor.getString(columnIndex3));
            }
            int columnIndex4 = cursor.getColumnIndex("url");
            if (columnIndex4 != -1) {
                rawBuilder.url(cursor.getString(columnIndex4));
            }
            int columnIndex5 = cursor.getColumnIndex(DBDefinition.SAVE_PATH);
            if (columnIndex5 != -1) {
                rawBuilder.savePath(cursor.getString(columnIndex5));
            }
            int columnIndex6 = cursor.getColumnIndex(DBDefinition.TEMP_PATH);
            if (columnIndex6 != -1) {
                rawBuilder.tempPath(cursor.getString(columnIndex6));
            }
            int columnIndex7 = cursor.getColumnIndex(DBDefinition.CHUNK_COUNT);
            if (columnIndex7 != -1) {
                rawBuilder.chunkCount = cursor.getInt(columnIndex7);
            }
            int columnIndex8 = cursor.getColumnIndex("status");
            if (columnIndex8 != -1) {
                rawBuilder.status = cursor.getInt(columnIndex8);
            } else {
                rawBuilder.status = 0;
            }
            int columnIndex9 = cursor.getColumnIndex(DBDefinition.CUR_BYTES);
            if (columnIndex9 != -1) {
                rawBuilder.curBytes = cursor.getLong(columnIndex9);
            } else {
                rawBuilder.curBytes = 0L;
            }
            int columnIndex10 = cursor.getColumnIndex(DBDefinition.BACK_CUR_BYTES);
            if (columnIndex10 != -1) {
                rawBuilder.backCurBytes = cursor.getLong(columnIndex10);
            } else {
                rawBuilder.backCurBytes = 0L;
            }
            int columnIndex11 = cursor.getColumnIndex(DBDefinition.TOTAL_BYTES);
            if (columnIndex11 != -1) {
                rawBuilder.totalBytes = cursor.getLong(columnIndex11);
            }
            int columnIndex12 = cursor.getColumnIndex(DBDefinition.ETAG);
            if (columnIndex12 != -1) {
                rawBuilder.etag = cursor.getString(columnIndex12);
            }
            int columnIndex13 = cursor.getColumnIndex(DBDefinition.ONLY_WIFI);
            if (columnIndex13 != -1) {
                rawBuilder.onlyWifi(cursor.getInt(columnIndex13) != 0);
            }
            int columnIndex14 = cursor.getColumnIndex("force");
            if (columnIndex14 != -1) {
                rawBuilder.force(cursor.getInt(columnIndex14) != 0);
            }
            int columnIndex15 = cursor.getColumnIndex(DBDefinition.RETRY_COUNT);
            if (columnIndex15 != -1) {
                rawBuilder.retryCount(cursor.getInt(columnIndex15));
            }
            int columnIndex16 = cursor.getColumnIndex("extra");
            if (columnIndex16 != -1) {
                rawBuilder.extra(cursor.getString(columnIndex16));
            }
            int columnIndex17 = cursor.getColumnIndex(DBDefinition.MIME_TYPE);
            if (columnIndex17 != -1) {
                rawBuilder.mimeType(cursor.getString(columnIndex17));
            }
            int columnIndex18 = cursor.getColumnIndex(DBDefinition.NOTIFICATION_ENABLE);
            if (columnIndex18 != -1) {
                rawBuilder.showNotification(cursor.getInt(columnIndex18) != 0);
            }
            int columnIndex19 = cursor.getColumnIndex(DBDefinition.NOTIFICATION_VISIBILITY);
            if (columnIndex19 != -1) {
                rawBuilder.notificationVisibility = cursor.getInt(columnIndex19);
            }
            int columnIndex20 = cursor.getColumnIndex(DBDefinition.FIRST_DOWNLOAD);
            if (columnIndex20 != -1) {
                rawBuilder.isFirstDownload = cursor.getInt(columnIndex20) == 1;
            }
            int columnIndex21 = cursor.getColumnIndex(DBDefinition.FIRST_SUCCESS);
            if (columnIndex21 != -1) {
                rawBuilder.isFirstSuccess = cursor.getInt(columnIndex21) == 1;
            }
            int columnIndex22 = cursor.getColumnIndex(DBDefinition.NEED_HTTPS_TO_HTTP_RETRY);
            if (columnIndex22 != -1) {
                rawBuilder.needHttpsToHttpRetry(cursor.getInt(columnIndex22) == 1);
            }
            int columnIndex23 = cursor.getColumnIndex(DBDefinition.DOWNLOAD_TIME);
            if (columnIndex23 != -1) {
                rawBuilder.downloadTime = cursor.getLong(columnIndex23);
            }
            int columnIndex24 = cursor.getColumnIndex(DBDefinition.PACKAGE_NAME);
            if (columnIndex24 != -1) {
                rawBuilder.packageName(cursor.getString(columnIndex24));
            }
            int columnIndex25 = cursor.getColumnIndex("md5");
            if (columnIndex25 != -1) {
                rawBuilder.md5(cursor.getString(columnIndex25));
            }
            int columnIndex26 = cursor.getColumnIndex(DBDefinition.CUR_RETRY_TIME);
            if (columnIndex26 != -1) {
                rawBuilder.curRetryTime = cursor.getInt(columnIndex26);
            }
            int columnIndex27 = cursor.getColumnIndex(DBDefinition.DEFAULT_HTTP_SERVICE_BACKUP);
            if (columnIndex27 != -1) {
                rawBuilder.needDefaultHttpServiceBackUp(cursor.getInt(columnIndex27) == 1);
            }
            int columnIndex28 = cursor.getColumnIndex(DBDefinition.BACKUP_URLS_STR);
            if (columnIndex28 != -1) {
                rawBuilder.backUpUrlsStr = cursor.getString(columnIndex28);
            }
            int columnIndex29 = cursor.getColumnIndex(DBDefinition.BACKUP_URL_RETRY_COUNT);
            if (columnIndex29 != -1) {
                rawBuilder.backUpUrlRetryCount(cursor.getInt(columnIndex29));
            }
            int columnIndex30 = cursor.getColumnIndex(DBDefinition.REAL_DOWNLOAD_TIME);
            if (columnIndex30 != -1) {
                rawBuilder.realDownloadTime = cursor.getLong(columnIndex30);
            }
            int columnIndex31 = cursor.getColumnIndex(DBDefinition.REAL_BACK_DOWNLOAD_TIME);
            if (columnIndex31 != -1) {
                rawBuilder.realBackDownloadTime = cursor.getLong(columnIndex31);
            }
            int columnIndex32 = cursor.getColumnIndex(DBDefinition.INDEPENDENT_PROCESS);
            if (columnIndex32 != -1) {
                rawBuilder.needIndependentProcess(cursor.getInt(columnIndex32) == 1);
            }
            int columnIndex33 = cursor.getColumnIndex(DBDefinition.AUXILIARY_JSONOBJECT_STRING);
            if (columnIndex33 != -1) {
                rawBuilder.dbJsonDataString = cursor.getString(columnIndex33);
            }
            int columnIndex34 = cursor.getColumnIndex(DBDefinition.ICON_URL);
            if (columnIndex34 != -1) {
                rawBuilder.iconUrl(cursor.getString(columnIndex34));
            }
            int columnIndex35 = cursor.getColumnIndex(DBDefinition.APP_VERSION_CODE);
            if (columnIndex35 != -1) {
                rawBuilder.appVersionCode(cursor.getInt(columnIndex35));
            }
            int columnIndex36 = cursor.getColumnIndex(DBDefinition.DOWNLOAD_START_TIMESTAMP);
            if (columnIndex36 != -1) {
                rawBuilder.downloadStartTimeStamp = cursor.getLong(columnIndex36);
            }
            int columnIndex37 = cursor.getColumnIndex(DBDefinition.DOWNLOAD_FINISH_TIMESTAMP);
            if (columnIndex37 != -1) {
                rawBuilder.downloadFinishTimeStamp = cursor.getLong(columnIndex37);
            }
            int columnIndex38 = cursor.getColumnIndex(DBDefinition.INSTALLED_TIMESTAMP);
            if (columnIndex38 != -1) {
                rawBuilder.installedTimeStamp = cursor.getLong(columnIndex38);
            }
            int columnIndex39 = cursor.getColumnIndex(DBDefinition.CACHE_LIFE_TIME_MAX);
            if (columnIndex39 != -1) {
                rawBuilder.cacheLifeTimeMax(cursor.getLong(columnIndex39));
            }
            int columnIndex40 = cursor.getColumnIndex(DBDefinition.HAS_DO_INSTALLATION);
            if (columnIndex40 != -1) {
                rawBuilder.hasDoInstallation = cursor.getInt(columnIndex40) == 1;
            }
            int columnIndex41 = cursor.getColumnIndex(DBDefinition.PCDN_URLS_STR);
            if (columnIndex41 != -1) {
                rawBuilder.pcdnUrlsStr = cursor.getString(columnIndex41);
            }
            int columnIndex42 = cursor.getColumnIndex(DBDefinition.CDN_URLS_STR);
            if (columnIndex42 != -1) {
                rawBuilder.cdnUrlsStr = cursor.getString(columnIndex42);
            }
            int columnIndex43 = cursor.getColumnIndex(DBDefinition.MONITOR_SCENE);
            if (columnIndex43 != -1) {
                rawBuilder.monitorScene(cursor.getString(columnIndex43));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rawBuilder.build();
    }

    public static ContentValues toContentValues(DownloadInfo downloadInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(downloadInfo.getRawId()));
        contentValues.put("url", downloadInfo.getUrl());
        contentValues.put(DBDefinition.SAVE_PATH, downloadInfo.getSavePath());
        contentValues.put(DBDefinition.TEMP_PATH, downloadInfo.getRawTempPath());
        contentValues.put("name", downloadInfo.getName());
        contentValues.put(DBDefinition.CHUNK_COUNT, Integer.valueOf(downloadInfo.getChunkCount()));
        contentValues.put("status", Integer.valueOf(downloadInfo.getStatus()));
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(downloadInfo.getCurBytes()));
        contentValues.put(DBDefinition.BACK_CUR_BYTES, Long.valueOf(downloadInfo.getBackCurBytes()));
        contentValues.put(DBDefinition.TOTAL_BYTES, Long.valueOf(downloadInfo.getTotalBytes()));
        contentValues.put(DBDefinition.ETAG, downloadInfo.geteTag());
        contentValues.put(DBDefinition.ONLY_WIFI, Integer.valueOf(downloadInfo.isOnlyWifi() ? 1 : 0));
        contentValues.put("force", Integer.valueOf(downloadInfo.isForce() ? 1 : 0));
        contentValues.put(DBDefinition.RETRY_COUNT, Integer.valueOf(downloadInfo.getRetryCount()));
        contentValues.put("extra", downloadInfo.getExtra());
        contentValues.put(DBDefinition.MIME_TYPE, downloadInfo.getMimeType());
        contentValues.put("title", downloadInfo.getRawTitle());
        contentValues.put(DBDefinition.NOTIFICATION_ENABLE, Integer.valueOf(downloadInfo.isShowNotification() ? 1 : 0));
        contentValues.put(DBDefinition.NOTIFICATION_VISIBILITY, Integer.valueOf(downloadInfo.getNotificationVisibility()));
        contentValues.put(DBDefinition.FIRST_DOWNLOAD, Integer.valueOf(downloadInfo.getIsFirstDownload() ? 1 : 0));
        contentValues.put(DBDefinition.FIRST_SUCCESS, Integer.valueOf(downloadInfo.isFirstSuccess() ? 1 : 0));
        contentValues.put(DBDefinition.NEED_HTTPS_TO_HTTP_RETRY, Integer.valueOf(downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0));
        contentValues.put(DBDefinition.DOWNLOAD_TIME, Long.valueOf(downloadInfo.getDownloadTime()));
        contentValues.put(DBDefinition.PACKAGE_NAME, downloadInfo.getPackageName());
        contentValues.put("md5", downloadInfo.getMd5());
        contentValues.put(DBDefinition.CUR_RETRY_TIME, Integer.valueOf(downloadInfo.getCurRetryTime()));
        contentValues.put(DBDefinition.DEFAULT_HTTP_SERVICE_BACKUP, Integer.valueOf(downloadInfo.isNeedDefaultHttpServiceBackUp() ? 1 : 0));
        contentValues.put(DBDefinition.CHUNK_RUNNABLE_REUSE, (Integer) 0);
        contentValues.put(DBDefinition.CHUNK_DOWNGRADE_RETRY, (Integer) 0);
        contentValues.put(DBDefinition.BACKUP_URLS_STR, downloadInfo.getBackUpUrlsStr());
        contentValues.put(DBDefinition.BACKUP_URL_RETRY_COUNT, Integer.valueOf(downloadInfo.getBackUpUrlRetryCount()));
        contentValues.put(DBDefinition.REAL_DOWNLOAD_TIME, Long.valueOf(downloadInfo.getRawRealDownloadTime()));
        contentValues.put(DBDefinition.REAL_BACK_DOWNLOAD_TIME, Long.valueOf(downloadInfo.getRawRealBackDownloadTime()));
        contentValues.put(DBDefinition.INDEPENDENT_PROCESS, Integer.valueOf(downloadInfo.isNeedIndependentProcess() ? 1 : 0));
        contentValues.put(DBDefinition.AUXILIARY_JSONOBJECT_STRING, downloadInfo.getDBJsonDataString());
        contentValues.put(DBDefinition.ICON_URL, downloadInfo.getIconUrl());
        contentValues.put(DBDefinition.APP_VERSION_CODE, Integer.valueOf(downloadInfo.getAppVersionCode()));
        contentValues.put(DBDefinition.TASK_ID, (String) null);
        contentValues.put(DBDefinition.DOWNLOAD_START_TIMESTAMP, Long.valueOf(downloadInfo.getDownloadStartTimeStamp()));
        contentValues.put(DBDefinition.DOWNLOAD_FINISH_TIMESTAMP, Long.valueOf(downloadInfo.getDownloadFinishTimeStamp()));
        contentValues.put(DBDefinition.INSTALLED_TIMESTAMP, Long.valueOf(downloadInfo.getInstalledTimeStamp()));
        contentValues.put(DBDefinition.HAS_DO_INSTALLATION, Integer.valueOf(downloadInfo.isHasDoInstallation() ? 1 : 0));
        contentValues.put(DBDefinition.CACHE_LIFE_TIME_MAX, Long.valueOf(downloadInfo.getCacheLifeTimeMax()));
        contentValues.put(DBDefinition.PCDN_URLS_STR, downloadInfo.getPcdnUrlsStr());
        contentValues.put(DBDefinition.CDN_URLS_STR, downloadInfo.getCdnUrlsStr());
        contentValues.put(DBDefinition.MONITOR_SCENE, downloadInfo.getMonitorScene());
        return contentValues;
    }

    public static void injectRemoteIp(IDownloadHttpConnection iDownloadHttpConnection, BaseException baseException) {
        if (iDownloadHttpConnection == null || !(iDownloadHttpConnection instanceof AbsDownloadHttpConnection) || baseException == null || !(baseException instanceof DownloadTTNetException)) {
            return;
        }
        String hostIp = ((AbsDownloadHttpConnection) iDownloadHttpConnection).getHostIp();
        if (!TextUtils.isEmpty(hostIp)) {
            ((DownloadTTNetException) baseException).setRemoteIp(hostIp);
        }
        ((DownloadTTNetException) baseException).parseRemoteIp();
    }

    public static void checkWorkerThread(String str) {
        if (Logger.debug() && DownloadUtils.isMainThread()) {
            Logger.globalError(TAG, "checkWorkerThread", "This method:" + str + " cannot be executed on the main thread");
            IDownloadThreadCheckListener downloadThreadCheckListener = DownloadComponentManager.getDownloadThreadCheckListener();
            if (downloadThreadCheckListener != null) {
                downloadThreadCheckListener.onError(str);
            }
        }
    }

    public static boolean isCdnCacheHit(List<Pair<String, String>> list) {
        if (list == null) {
            return false;
        }
        for (Pair<String, String> pair : list) {
            if (!TextUtils.isEmpty((CharSequence) pair.second) && ((String) pair.second).toLowerCase().contains("hit")) {
                return true;
            }
        }
        return false;
    }

    public static void removeHeaderKey(List<HttpHeader> list, String str) {
        if (list == null || str == null) {
            return;
        }
        Iterator<HttpHeader> it = list.iterator();
        while (it.hasNext()) {
            HttpHeader next = it.next();
            if (next != null && !TextUtils.isEmpty(next.getName()) && next.getName().contains(str)) {
                it.remove();
                return;
            }
        }
    }

    public static void deleteDir(String str, String str2) {
        if (TextUtils.isEmpty(str) || str.contains(str2)) {
            return;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        file2.delete();
                    } else if (file2.isDirectory()) {
                        deleteDir(file2.getAbsolutePath(), str2);
                        return;
                    }
                }
            }
            file.delete();
        }
    }

    public static Set<String> getSkipDbInitSceneSet() {
        return parseJSONArrayToSet(DownloadSetting.obtainGlobal().optJSONArray(DownloadSettingKeys.SKIP_DB_INIT_MONITOR_SCENE_LIST));
    }

    public static Set<String> getSkipDbInitExpectMimeTypeSet() {
        return parseJSONArrayToSet(DownloadSetting.obtainGlobal().optJSONArray(DownloadSettingKeys.SKIP_DB_INIT_EXPECT_MIME_TYPE));
    }

    public static Set<String> getDbInitSceneSet() {
        return parseJSONArrayToSet(DownloadSetting.obtainGlobal().optJSONArray(DownloadSettingKeys.DB_INIT_MONITOR_SCENE_LIST));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class SceneLruLimitInfo {
        public int curCount;
        public int limit;

        public SceneLruLimitInfo(int i, int i2) {
            this.curCount = i;
            this.limit = i2;
        }
    }

    public static Map<String, SceneLruLimitInfo> getDbInitSceneLruLimitMap() {
        int parseInt;
        Set<String> parseJSONArrayToSet = parseJSONArrayToSet(DownloadSetting.obtainGlobal().optJSONArray(DownloadSettingKeys.LRU_DB_INIT_MONITOR_SCENE_LIMIT_LIST));
        if (parseJSONArrayToSet == null || parseJSONArrayToSet.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            Iterator<String> it = parseJSONArrayToSet.iterator();
            while (it.hasNext()) {
                String[] split = it.next().split(Constants.COLON_SEPARATOR);
                if (split != null && split.length > 0) {
                    String str = split[0];
                    if (!TextUtils.isEmpty(str) && (parseInt = Integer.parseInt(split[1])) > 0) {
                        hashMap.put(str, new SceneLruLimitInfo(0, parseInt));
                    }
                }
            }
        } catch (Throwable th) {
            Logger.globalError(TAG, "getDbInitSceneLruLimitSet", "Error" + th);
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    private static Set<String> parseJSONArrayToSet(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                hashSet.add(jSONArray.getString(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return hashSet;
    }

    public static boolean hitSkipDbInitScene(Set<String> set, Set<String> set2, Set<String> set3, String str, String str2) {
        if (set == null || TextUtils.isEmpty(str2) || !set.contains(str2)) {
            return (set2 == null || set2.contains(str) || (set3 != null && set3.contains(str2))) ? false : true;
        }
        return true;
    }

    public static void updateCacheSetting() {
        try {
            String[] strArr = {DownloadSettingKeys.KEY_LRU_DOWNLOAD_INFO_CACHE_ENABLE, DownloadSettingKeys.OPTIMIZE_DOWNLOAD_CACHE};
            int i = 0;
            SharedPreferences sharedPreferences = DownloadComponentManager.getAppContext().getSharedPreferences(DownloadConstants.SP_DOWNLOAD_SETTING_CACHE, 0);
            JSONObject globalSettings = DownloadSetting.getGlobalSettings();
            if (globalSettings.optInt(DownloadSettingKeys.ENABLE_SETTING_CACHE) <= 0) {
                while (true) {
                    if (i >= 2) {
                        break;
                    }
                    if (sharedPreferences.contains(strArr[i])) {
                        sharedPreferences.edit().clear().apply();
                        break;
                    }
                    i++;
                }
                if (Logger.debug()) {
                    Logger.globalDebug(TAG, "updateCacheSetting", "Disable cache setting");
                    return;
                }
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            boolean z = false;
            for (int i2 = 0; i2 < 2; i2++) {
                String str = strArr[i2];
                int optInt = globalSettings.optInt(str, 0);
                if (sharedPreferences.getInt(str, 0) != optInt) {
                    edit.putInt(str, optInt);
                    if (Logger.debug()) {
                        Logger.globalDebug(TAG, "updateCacheSetting", "Key:" + str + " Value:" + optInt);
                    }
                    z = true;
                }
            }
            if (z) {
                edit.apply();
            }
        } catch (Throwable th) {
            Logger.globalError(TAG, "updateCacheSetting", "Error:" + th);
        }
    }

    public static int getCacheSettingInt(String str) {
        int i = 0;
        try {
            i = DownloadComponentManager.getAppContext().getSharedPreferences(DownloadConstants.SP_DOWNLOAD_SETTING_CACHE, 0).getInt(str, 0);
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "getCacheSettingInt", "Key:" + str + " Value:" + i);
            }
        } catch (Throwable th) {
            Logger.globalError(TAG, "getCacheSettingInt", "Error:" + th);
        }
        return i;
    }
}
