package com.ss.android.socialbase.downloader.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.ss.android.http.legacy.protocol.HTTP;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.md5.TTMd5;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadUtils {
    public static final int CHUNKED_CONTENT_LENGTH = -1;
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_RANGE = "Content-Range";
    public static final int DEFAULT_MIN_TIME_INTERVAL = 1000;
    public static volatile boolean ENABLE_APP_DOWNLOADER = true;
    public static final String HEADER_TAG_DOWNLOAD_CACHE = "download-tc21-1-15";
    public static final int MULTI_PROCESS_DB_MODE = 2;
    public static final int MULTI_PROCESS_NO_DB_MODE = 1;
    private static final String TAG = "DownloadUtils";
    private static ConnectivityManager connectivityManager;
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static String sCurProcessName = null;
    private static volatile AtomicInteger sMultiProcessMode = new AtomicInteger(-1);
    private static volatile int sPid = -1;

    public static boolean isChunkedTask(long j) {
        return j == -1;
    }

    public static boolean isMd5Valid(int i) {
        return i == 0 || i == 2;
    }

    public static void safeClose(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void safeClose(Cursor... cursorArr) {
        if (cursorArr == null) {
            return;
        }
        for (Cursor cursor : cursorArr) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static int getInt(Object obj, int i) {
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            return i;
        }
    }

    public static boolean getBoolean(Object obj, boolean z) {
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            return z;
        }
    }

    public static String getString(Object obj, String str) {
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            return str;
        }
    }

    public static String hexToString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            try {
                bArr[i] = (byte) (Integer.parseInt(str.substring(i2, i2 + 2), 16) & 255);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            return new String(bArr, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String getErrorMsgWithTagPrefix(Throwable th, String str) {
        if (str == null) {
            return getThrowableMsg(th);
        }
        return str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + getThrowableMsg(th);
    }

    public static String getThrowableMsg(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            return th.toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "throwable getMsg error";
        }
    }

    public static String generateDistinctDirectory(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String md5Hex = md5Hex(str2);
        return (TextUtils.isEmpty(md5Hex) || str.contains(md5Hex)) ? str : new File(str, md5Hex).getAbsolutePath();
    }

    public static String md5Hex(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes(HTTP.UTF_8));
                    return toHexString(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String toHexString(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        return toHexString(bArr, 0, bArr.length);
    }

    public static String toHexString(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2 * 2;
        char[] cArr = new char[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i5 + i] & 255;
            int i7 = i4 + 1;
            char[] cArr2 = HEX_CHARS;
            cArr[i4] = cArr2[i6 >> 4];
            i4 = i7 + 1;
            cArr[i7] = cArr2[i6 & 15];
        }
        return new String(cArr, 0, i3);
    }

    public static String getTargetFilePath(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (!DownloadFileUtils.isMediaUri(str) || DownloadFileUtils.checkUriInsert(str)) {
            return new DownloadFile(str, str2).getPath();
        }
        return null;
    }

    public static String getTempFilePath(String str, String str2, String str3) {
        String targetFilePath;
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            targetFilePath = getTargetFilePath(str2, str3);
        } else {
            targetFilePath = getTargetFilePath(str, str3);
        }
        if (TextUtils.isEmpty(targetFilePath)) {
            return null;
        }
        return String.format("%s.tp", targetFilePath);
    }

    public static String getTempFileSavePath(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public static String getTempFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("%s.tp", str);
    }

    public static ConnectivityManager getConnectivityManager(Context context) {
        ConnectivityManager connectivityManager2 = connectivityManager;
        if (connectivityManager2 != null) {
            return connectivityManager2;
        }
        ConnectivityManager connectivityManager3 = (ConnectivityManager) context.getSystemService("connectivity");
        connectivityManager = connectivityManager3;
        return connectivityManager3;
    }

    public static boolean isWifi(Context context) {
        try {
            NetworkInfo activeNetworkInfo = getConnectivityManager(context).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                return 1 == activeNetworkInfo.getType();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isNetworkConnected(Context context) {
        try {
            NetworkInfo activeNetworkInfo = getConnectivityManager(context).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static int getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return 0;
        }
        try {
            ConnectivityManager connectivityManager2 = getConnectivityManager(context);
            if (connectivityManager2 != null && (activeNetworkInfo = connectivityManager2.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                return 1 == activeNetworkInfo.getType() ? 1 : 2;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public static boolean isFileDownloaded(DownloadInfo downloadInfo) {
        return isFileDownloaded(downloadInfo, downloadInfo.isForce(), downloadInfo.getMd5());
    }

    public static boolean isFileDownloaded(DownloadInfo downloadInfo, boolean z, String str) {
        if (!z && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            try {
                DownloadFile downloadFile = new DownloadFile(downloadInfo.getSavePath(), downloadInfo.getName());
                if (DownloadFileUtils.existsAndNotEmpty(downloadFile) && checkFileLength(downloadInfo, downloadFile)) {
                    if (checkMd5Valid(downloadFile, str)) {
                        return true;
                    }
                }
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean isFileDownloaded(String str, String str2, boolean z) {
        return isFileDownloaded(str, str2, null, z);
    }

    public static boolean isFileDownloaded(String str, String str2, String str3, boolean z) {
        if (!z && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                DownloadFile downloadFile = new DownloadFile(str, str2);
                if (DownloadFileUtils.existsAndNotEmpty(downloadFile)) {
                    if (checkMd5Valid(downloadFile, str3)) {
                        return true;
                    }
                }
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean isDownloadSuccessAndFileNotExist(int i, String str, String str2) {
        return i == -3 && !isFileExist(str, str2);
    }

    public static boolean isFileExist(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!DownloadFileUtils.isMediaUri(str) || DownloadFileUtils.checkUriInsert(str)) {
            return new DownloadFile(str, str2).exists();
        }
        return false;
    }

    public static boolean checkFileLength(DownloadInfo downloadInfo, DownloadFile downloadFile) {
        return downloadInfo.getTotalBytes() <= 0 || downloadFile.length() >= downloadInfo.getTotalBytes();
    }

    public static int checkMd5Status(String str, String str2, String str3) {
        return checkMd5Status(new DownloadFile(str, str2), str3);
    }

    public static int checkMd5Status(DownloadFile downloadFile, String str) {
        if (downloadFile.isTypeFile()) {
            return TTMd5.checkMd5(str, downloadFile.getFile());
        }
        try {
            return TTMd5.checkMd5(str, downloadFile.getFile(), new DownloadFileRandomAccess(downloadFile.obtainInputStream()));
        } catch (Throwable th) {
            th.printStackTrace();
            return 5;
        }
    }

    public static boolean checkMd5Valid(String str, String str2, String str3) {
        return isMd5Valid(checkMd5Status(new DownloadFile(str, str2), str3));
    }

    public static int checkMd5Status(File file, String str) {
        return TTMd5.checkMd5(str, file);
    }

    public static boolean checkMd5Valid(File file, String str) {
        return isMd5Valid(TTMd5.checkMd5(str, file));
    }

    public static boolean checkMd5Valid(DownloadFile downloadFile, String str) {
        return isMd5Valid(checkMd5Status(downloadFile, str));
    }

    public static String getMd5StatusMsg(int i) {
        String str = "ttmd5 check code = " + i + ", ";
        if (i != 99) {
            switch (i) {
                case 0:
                    return str + "md5 match";
                case 1:
                    return str + "md5 not match";
                case 2:
                    return str + "md5 empty";
                case 3:
                    return str + "ttmd5 version not support";
                case 4:
                    return str + "ttmd5 tag parser error";
                case 5:
                    return str + "file not exist";
                case 6:
                    return str + "get file md5 error";
                default:
                    return str;
            }
        }
        return str + "unknown error";
    }

    public static boolean cacheExpired(DownloadInfo downloadInfo) {
        return cacheExpiredWithHttp(downloadInfo, false);
    }

    public static boolean cacheExpiredWithHttp(DownloadInfo downloadInfo, boolean z) {
        boolean z2 = false;
        if (!downloadInfo.isDeleteCacheIfCheckFailed() && TextUtils.isEmpty(downloadInfo.getLastModified())) {
            if (Logger.debugScene(downloadInfo)) {
                Logger.taskDebug(TAG, downloadInfo, "cacheExpiredWithHttp", "Modify is empty, so just return cache");
            }
        } else {
            if (Logger.debugScene(downloadInfo)) {
                Logger.taskDebug(TAG, downloadInfo, "cacheExpiredWithHttp", "Curt=" + System.currentTimeMillis() + " expired=" + downloadInfo.getCacheExpiredTime());
            }
            if (System.currentTimeMillis() > downloadInfo.getCacheExpiredTime() || z) {
                z2 = true;
            }
        }
        if (Logger.debugScene(downloadInfo)) {
            Logger.taskDebug(TAG, downloadInfo, "cacheExpiredWithHttp", "Name=" + downloadInfo.getName() + " expired=" + z2);
        }
        return z2;
    }

    public static boolean isNetworkError(Throwable th) {
        if (th == null || !(th instanceof BaseException)) {
            return false;
        }
        int errorCode = ((BaseException) th).getErrorCode();
        return (errorCode >= 2000 && errorCode < 3000) || errorCode == 1075 || errorCode == 1078 || errorCode == 1079 || errorCode == 1055 || errorCode == 1023 || errorCode == 1041 || errorCode == 1022 || errorCode == 1048 || errorCode == 1056 || errorCode == 1057 || errorCode == 1058 || errorCode == 1059 || errorCode == 1060 || errorCode == 1061 || errorCode == 1067 || errorCode == 1049 || errorCode == 1047 || errorCode == 1051 || errorCode == 1004 || errorCode == 1011 || errorCode == 1002 || errorCode == 1013;
    }

    public static boolean isInsufficientSpaceError(Throwable th) {
        if (th == null) {
            return false;
        }
        if (th instanceof BaseException) {
            BaseException baseException = (BaseException) th;
            int errorCode = baseException.getErrorCode();
            if (errorCode == 1006) {
                return true;
            }
            if (!(errorCode == 1023 || errorCode == 1039 || errorCode == 1040 || errorCode == 1054 || errorCode == 1064)) {
                return false;
            }
            String message = baseException.getMessage();
            return !TextUtils.isEmpty(message) && message.contains("ENOSPC");
        }
        if (!(th instanceof IOException)) {
            return false;
        }
        String throwableMsg = getThrowableMsg(th);
        return !TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("ENOSPC");
    }

    public static boolean isWaitWifiAndInNet(BaseException baseException, DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.isOnlyWifi() && isNetworkConnected(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext());
    }

    public static String getCurProcessName(Context context) {
        String str = sCurProcessName;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String curProcessNameByApplication = getCurProcessNameByApplication();
        sCurProcessName = curProcessNameByApplication;
        if (!TextUtils.isEmpty(curProcessNameByApplication)) {
            return sCurProcessName;
        }
        String curProcessNameByActivityThread = getCurProcessNameByActivityThread();
        sCurProcessName = curProcessNameByActivityThread;
        if (!TextUtils.isEmpty(curProcessNameByActivityThread)) {
            return sCurProcessName;
        }
        String curProcessNameFromProc = getCurProcessNameFromProc();
        sCurProcessName = curProcessNameFromProc;
        if (!TextUtils.isEmpty(curProcessNameFromProc)) {
            return sCurProcessName;
        }
        String curProcessNameByActivityManager = getCurProcessNameByActivityManager(context);
        sCurProcessName = curProcessNameByActivityManager;
        return curProcessNameByActivityManager;
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = bufferedReader.read();
                if (read <= 0) {
                    break;
                }
                sb.append((char) read);
            }
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "getCurProcessNameFromProc", "ProcessName: " + sb.toString());
            }
            String sb2 = sb.toString();
            safeClose(bufferedReader);
            return sb2;
        } catch (Throwable unused2) {
            safeClose(bufferedReader);
            return null;
        }
    }

    private static String getCurProcessNameByApplication() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            String processName = Application.getProcessName();
            if (Logger.debug() && !TextUtils.isEmpty(processName)) {
                Logger.globalDebug(TAG, "getCurProcessNameByApplication", "ProcessName: " + processName);
            }
            return processName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getCurProcessNameByActivityThread() {
        String str = null;
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (!(invoke instanceof String)) {
                return null;
            }
            String str2 = (String) invoke;
            try {
                if (Logger.debug() && !TextUtils.isEmpty(str2)) {
                    Logger.globalDebug(TAG, "getCurProcessNameByActivityThread", "ProcessName: " + str2);
                }
                return str2;
            } catch (Throwable th) {
                th = th;
                str = str2;
                th.printStackTrace();
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String getCurProcessNameByActivityManager(Context context) {
        if (context == null) {
            return null;
        }
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(RXScreenCaptureService.KEY_LAUNCH_ACTIVITY);
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        if (Logger.debug()) {
                            Logger.globalDebug(TAG, "getCurProcessNameByActivityManager", "ProcessName: " + runningAppProcessInfo.processName);
                        }
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void ensureDirExists(String str) {
        if (str == null) {
            return;
        }
        ensureDirExists(new File(str));
    }

    private static void ensureDirExists(File file) {
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static long getContentLength(IDownloadHeadHttpConnection iDownloadHeadHttpConnection) {
        if (iDownloadHeadHttpConnection == null) {
            return -1L;
        }
        String respHeadFieldIgnoreCase = getRespHeadFieldIgnoreCase(iDownloadHeadHttpConnection, "Content-Length");
        if (TextUtils.isEmpty(respHeadFieldIgnoreCase)) {
            return parseContentLengthFromContentRange(iDownloadHeadHttpConnection);
        }
        try {
            return Long.parseLong(respHeadFieldIgnoreCase);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static String getRespHeadFieldIgnoreCase(IDownloadHeadHttpConnection iDownloadHeadHttpConnection, String str) {
        if (iDownloadHeadHttpConnection == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String responseHeaderField = iDownloadHeadHttpConnection.getResponseHeaderField(str);
        if (TextUtils.isEmpty(responseHeaderField)) {
            responseHeaderField = iDownloadHeadHttpConnection.getResponseHeaderField(str.toLowerCase());
        }
        return TextUtils.isEmpty(responseHeaderField) ? iDownloadHeadHttpConnection.getResponseHeaderField(str.toUpperCase()) : responseHeaderField;
    }

    public static long parseContentLengthFromContentRange(IDownloadHeadHttpConnection iDownloadHeadHttpConnection) {
        if (iDownloadHeadHttpConnection == null) {
            return -1L;
        }
        String respHeadFieldIgnoreCase = getRespHeadFieldIgnoreCase(iDownloadHeadHttpConnection, CONTENT_RANGE);
        if (TextUtils.isEmpty(respHeadFieldIgnoreCase)) {
            return -1L;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(respHeadFieldIgnoreCase);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
        } catch (Exception e) {
            Logger.globalError(TAG, "parseContentLengthFromContentRange", "Exception:" + e);
        }
        return -1L;
    }

    public static long getAvailableSpaceBytes(String str) throws BaseException {
        try {
            if (DownloadFileUtils.isMediaUri(str)) {
                str = new File(DownloadFileUtils.getFilePathFromUri(Uri.parse(str))).getParent();
            }
            return new StatFs(str).getAvailableBytes();
        } catch (IllegalArgumentException e) {
            throw new BaseException(1050, e);
        } catch (Throwable th) {
            throw new BaseException(1052, th);
        }
    }

    public static long getReportableSpaceMB(long j) {
        long j2 = 50;
        return ((j / 1048576) / j2) * j2;
    }

    public static String getEncodedStr(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static String parseDevicePostfix(String str) {
        try {
            return (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) ? "" : String.valueOf(Long.valueOf(str).longValue() % 100);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void deleteAllDownloadFiles(DownloadInfo downloadInfo) {
        deleteAllDownloadFiles(downloadInfo, true);
    }

    public static void deleteAllDownloadFiles(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (downloadInfo.isForce() && !DownloadDirUtils.isSavePathSecurity(downloadInfo.getSavePath())) {
            z = false;
        }
        if (z) {
            try {
                deleteFile(downloadInfo.getSavePath(), downloadInfo.getName());
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        deleteFile(downloadInfo.getTempPath(), downloadInfo.getTempName());
        if (downloadInfo.isSavePathRedirected()) {
            clearAntiHijackDir(downloadInfo);
        }
        if (z) {
            String md5Hex = md5Hex(downloadInfo.getUrl());
            if (TextUtils.isEmpty(md5Hex) || TextUtils.isEmpty(downloadInfo.getSavePath()) || !downloadInfo.getSavePath().contains(md5Hex)) {
                return;
            }
            deleteDirIfEmpty(downloadInfo.getSavePath());
        }
    }

    public static void clearDownloadFile(String str, String str2, String str3) {
        String format = String.format("%s.tp", str3);
        securityDeleteFile(str, str3);
        if (str2 != null) {
            str = str2;
        }
        securityDeleteFile(str, format);
    }

    private static void securityDeleteFile(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        DownloadFile downloadFile = new DownloadFile(str, str2, true, true);
        if (downloadFile.exists()) {
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "deleteFile", "Path: " + downloadFile.getAbsolutePath());
            }
            downloadFile.delete();
        }
    }

    private static boolean deleteDirIfEmpty(String str) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "deleteDirIfEmpty", "Thread:" + Thread.currentThread());
        }
        if (DownloadFileUtils.getTypeByUri(str) == 1 && DownloadDirUtils.isSavePathSecurity(str) && !TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.isDirectory()) {
                if (file.delete()) {
                    return true;
                }
                if (Logger.debug()) {
                    Logger.globalDebug(TAG, "deleteDirIfEmpty", "Delete Failed");
                }
                return false;
            }
        }
        return false;
    }

    public static void deleteFile(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        DownloadFile downloadFile = new DownloadFile(str, str2, false, true);
        if (downloadFile.exists()) {
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "deleteFile", "Path: " + downloadFile.getAbsolutePath());
            }
            downloadFile.delete();
        }
    }

    public static void clearAntiHijackDir(DownloadInfo downloadInfo) {
        DownloadSetting obtain;
        JSONObject optJSONObject;
        if (downloadInfo == null || (optJSONObject = (obtain = DownloadSetting.obtain(downloadInfo.getId())).optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR)) == null) {
            return;
        }
        String optString = optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_INSTALL_DESC);
        if (!TextUtils.isEmpty(optString)) {
            deleteFile(downloadInfo.getSavePath(), optString);
        }
        String title = downloadInfo.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = downloadInfo.getName();
        }
        String redirectSavePath = getRedirectSavePath(title, obtain);
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(redirectSavePath) || TextUtils.isEmpty(savePath)) {
            return;
        }
        File file = new File(redirectSavePath);
        for (File file2 = new File(savePath); file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
            deleteDirIfEmpty(file2.getPath());
            file = file.getParentFile();
        }
    }

    public static String getRedirectSavePath(String str, DownloadSetting downloadSetting) {
        JSONObject optJSONObject;
        String format;
        if (downloadSetting == null || (optJSONObject = downloadSetting.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR)) == null) {
            return "";
        }
        String optString = optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME);
        if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
            optString = optString.substring(1);
        }
        if (TextUtils.isEmpty(optString)) {
            return optString;
        }
        if (!optString.contains("%s")) {
            format = optString + str;
        } else {
            try {
                format = String.format(optString, str);
            } catch (Throwable unused) {
            }
        }
        optString = format;
        return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
    }

    public static boolean isResponseCode304Error(Throwable th) {
        return ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getTTNetHandler().getResponseCode(th) == 304;
    }

    public static boolean hasDownloadCacheHeader(List<HttpHeader> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (HttpHeader httpHeader : list) {
            if (httpHeader != null && !TextUtils.isEmpty(httpHeader.getName()) && !TextUtils.isEmpty(httpHeader.getValue()) && HEADER_TAG_DOWNLOAD_CACHE.equals(httpHeader.getName()) && HEADER_TAG_DOWNLOAD_CACHE.equals(httpHeader.getValue())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isProcessNameSame(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String curProcessName = getCurProcessName(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext());
        return curProcessName != null && curProcessName.equals(str);
    }

    public static boolean isNoWifiAndInNet() {
        Context appContext = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        return (appContext == null || isWifi(appContext) || !isNetworkConnected(appContext)) ? false : true;
    }

    public static String getDownloadPath() {
        return DownloadDirUtils.getDownloadPath();
    }

    public static String getLoggerTag(String str) {
        return Logger.downloaderTag(str);
    }

    public static String readStreamToString(InputStream inputStream, int i) {
        BufferedReader bufferedReader;
        String readLine;
        StringBuilder sb = new StringBuilder();
        if (inputStream == null || i <= 0) {
            safeClose(inputStream);
            return sb.toString();
        }
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        } catch (Throwable th) {
            th = th;
        }
        do {
            try {
                readLine = bufferedReader.readLine();
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                try {
                    th.printStackTrace();
                    safeClose(bufferedReader2);
                    safeClose(inputStream);
                    return sb.toString();
                } catch (Throwable th3) {
                    safeClose(bufferedReader2);
                    safeClose(inputStream);
                    throw th3;
                }
            }
            if (readLine == null) {
                safeClose(bufferedReader);
                safeClose(inputStream);
                return sb.toString();
            }
            sb.append(readLine);
        } while (sb.length() <= i);
        String substring = sb.substring(0, i);
        safeClose(bufferedReader);
        safeClose(inputStream);
        return substring;
    }

    public static String listToJsonString(List<String> list) {
        if (list != null && !list.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (String str : list) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(str);
                    }
                }
                return jSONArray.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static List<String> jsonStringTolist(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                String optString = jSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(optString);
                }
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String parseTTNetIp(String str) {
        int lastIndexOf;
        return (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(Constants.COLON_SEPARATOR)) > 0) ? str.substring(0, lastIndexOf) : "";
    }

    public static boolean optimizeMultiProcess() {
        sMultiProcessMode.compareAndSet(-1, 0);
        return sMultiProcessMode.get() > 0;
    }

    public static void setMultiProcessMode(int i, String str, boolean z) {
        if (z && !TextUtils.isEmpty(str) && str.endsWith(":downloader")) {
            return;
        }
        sMultiProcessMode.compareAndSet(-1, i);
    }

    public static boolean isMultiProcessDBMode() {
        return sMultiProcessMode.get() == 2;
    }

    public static boolean isMultiProcessNoDBMode() {
        return sMultiProcessMode.get() == 1;
    }

    public static int getPid() {
        if (sPid == -1) {
            sPid = Process.myPid();
        }
        return sPid;
    }
}
