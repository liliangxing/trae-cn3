package com.ss.android.socialbase.downloader.logger;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.update.UpdateDialogNewBase;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes7.dex */
public class Logger {
    public static final boolean DEBUG = false;
    private static final String DOWNLOAD_TAG_PREFIX = "MNetDownloader-";
    private static final String KEY_GLOBAL_REPORT = "GlobalReport";
    private static final String KEY_TASK_REPORT = "TaskReport";
    private static final String TAG = "DownloaderLogger";
    private static final String TAG_GLOBAL_FORMAT = "[MNetDownloader|Global|%s]";
    private static final String TAG_TASK_FORMAT = "[MNetDownloader|%d|%s]";
    private static boolean mEnableALogWritter = false;
    private static boolean mEnableGlobalReport = false;
    private static int mLevel = 6;
    private static ILogReport mLogReport;
    private static ILogWritter sLogWritter;
    private static Object mAlogLock = new Object();
    private static Set mTaskReportSceneList = new CopyOnWriteArraySet();
    private static Set mAlogTaskSceneList = new CopyOnWriteArraySet();

    /* loaded from: classes7.dex */
    public static abstract class ILogReport {
        public void monitorEvent(String str, String str2) {
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class ILogWritter {
        public void logD(String str, String str2) {
        }

        public void logE(String str, String str2) {
        }

        public void logE(String str, String str2, Throwable th) {
        }

        public void logI(String str, String str2) {
        }

        public void logI(String str, String str2, Throwable th) {
        }

        public void logK(String str, String str2) {
        }

        public void logV(String str, String str2) {
        }

        public void logW(String str, String str2) {
        }

        public void logW(String str, String str2, Throwable th) {
        }
    }

    private static boolean isLoggerParamsValid(String str, String str2, String str3) {
        return (str == null || str2 == null || str3 == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class ALogHolder {
        private static Method mAlogMethod = getAlogMethod();

        private ALogHolder() {
        }

        private static Method getAlogMethod() {
            try {
                return Class.forName("com.ss.android.agilelogger.ALog").getMethod("e", String.class, String.class);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
    }

    public static void alogE(String str, String str2) {
        try {
            if (ALogHolder.mAlogMethod != null) {
                ALogHolder.mAlogMethod.invoke(null, str, str2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setLogLevel(int i) {
        synchronized (mAlogLock) {
            if (mEnableALogWritter) {
                return;
            }
            mLevel = i;
        }
    }

    public static int getLogLevel() {
        return mLevel;
    }

    public static boolean debug() {
        return mLevel <= 3;
    }

    public static boolean alog() {
        return mLevel <= 4;
    }

    public static boolean debugScene(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        return debugScene(downloadInfo.getMonitorScene());
    }

    public static boolean debugScene(String str) {
        return (mAlogTaskSceneList.isEmpty() || !mAlogTaskSceneList.contains(str)) ? mLevel <= 3 : mLevel <= 4;
    }

    public static void globalDebug(String str, String str2, String str3) {
        if (isLoggerParamsValid(str, str2, str3)) {
            if (alog()) {
                globalAlog(str, str2, str3);
                return;
            }
            if (mLevel > 3) {
                return;
            }
            String format = String.format(TAG_GLOBAL_FORMAT, str);
            String str4 = str2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str3;
            ILogWritter iLogWritter = sLogWritter;
            if (iLogWritter != null) {
                iLogWritter.logD(format, str4);
            } else {
                Log.d(format, str4);
            }
        }
    }

    public static void globalError(String str, String str2, String str3) {
        if (isLoggerParamsValid(str, str2, str3)) {
            globalReport(str, str2, str3);
            if (alog()) {
                globalAlog(str, str2, str3);
                return;
            }
            if (mLevel > 6) {
                return;
            }
            String format = String.format(TAG_GLOBAL_FORMAT, str);
            String str4 = str2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str3;
            ILogWritter iLogWritter = sLogWritter;
            if (iLogWritter != null) {
                iLogWritter.logE(format, str4);
            } else {
                Log.e(format, str4);
            }
        }
    }

    private static void globalAlog(String str, String str2, String str3) {
        if (!isLoggerParamsValid(str, str2, str3) || mLevel > 4) {
            return;
        }
        String format = String.format(TAG_GLOBAL_FORMAT, str);
        String str4 = str2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str3;
        ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logE(format, str4);
        } else {
            Log.e(format, str4);
        }
    }

    private static void globalReport(String str, String str2, String str3) {
        ILogReport iLogReport;
        if (mEnableGlobalReport && isLoggerParamsValid(str, str2, str3) && (iLogReport = mLogReport) != null) {
            iLogReport.monitorEvent(KEY_GLOBAL_REPORT, str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str3);
        }
    }

    public static void taskDebug(String str, DownloadInfo downloadInfo, String str2, String str3) {
        taskDebug(str, downloadInfo.getId(), downloadInfo.getMonitorScene(), str2, str3, false);
    }

    public static void taskDebug(String str, DownloadInfo downloadInfo, String str2, String str3, boolean z) {
        taskDebug(str, downloadInfo.getId(), downloadInfo.getMonitorScene(), str2, str3, z);
    }

    public static void taskDebug(String str, int i, String str2, String str3) {
        taskDebug(str, i, null, str2, str3, false);
    }

    public static void taskDebug(String str, int i, String str2, String str3, String str4, boolean z) {
        if (isLoggerParamsValid(str, str3, str4)) {
            if (z) {
                taskReport(str, i, str2, str3, str4);
            }
            if (alog() && !TextUtils.isEmpty(str2)) {
                taskAlog(str, i, str3, str4);
                return;
            }
            if (mLevel > 3) {
                return;
            }
            String format = String.format(TAG_TASK_FORMAT, Integer.valueOf(i), str);
            String str5 = str3 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str4;
            ILogWritter iLogWritter = sLogWritter;
            if (iLogWritter != null) {
                iLogWritter.logD(format, str5);
            } else {
                Log.d(format, str5);
            }
        }
    }

    public static void taskError(String str, int i, String str2, String str3) {
        if (isLoggerParamsValid(str, str2, str3)) {
            globalReport(str, str2, i + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str3);
            if (alog()) {
                taskAlog(str, i, str2, str3);
                return;
            }
            if (mLevel > 6) {
                return;
            }
            String format = String.format(TAG_TASK_FORMAT, Integer.valueOf(i), str);
            String str4 = str2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str3;
            ILogWritter iLogWritter = sLogWritter;
            if (iLogWritter != null) {
                iLogWritter.logE(format, str4);
            } else {
                Log.e(format, str4);
            }
        }
    }

    private static void taskAlog(String str, int i, String str2, String str3) {
        if (isLoggerParamsValid(str, str2, str3)) {
            String format = String.format(TAG_TASK_FORMAT, Integer.valueOf(i), str);
            String str4 = str2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str3;
            ILogWritter iLogWritter = sLogWritter;
            if (iLogWritter != null) {
                iLogWritter.logE(format, str4);
            } else {
                Log.e(format, str4);
            }
        }
    }

    private static void taskReport(String str, int i, String str2, String str3, String str4) {
        ILogReport iLogReport;
        if (TextUtils.isEmpty(str2) || mTaskReportSceneList.isEmpty() || !mTaskReportSceneList.contains(str2) || !isLoggerParamsValid(str, str3, str4) || (iLogReport = mLogReport) == null) {
            return;
        }
        iLogReport.monitorEvent(KEY_TASK_REPORT, str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + i + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str3 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str4);
    }

    public static void v(String str) {
        v(TAG, str);
    }

    public static void v(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (mLevel <= 2) {
            Log.v(str, str2);
        }
        ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logV(downloaderTag(str), str2);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (mLevel <= 2) {
            Log.v(str, str2, th);
        }
        ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logV(downloaderTag(str), str2 + th);
        }
    }

    public static void d(String str) {
        d(TAG, str);
    }

    public static String downloaderTag(String str) {
        return !TextUtils.isEmpty(str) ? DOWNLOAD_TAG_PREFIX + str : TAG;
    }

    public static void d(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (mLevel <= 3) {
            Log.d(downloaderTag(str), str2);
        }
        ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logD(downloaderTag(str), str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (mLevel <= 3) {
            Log.d(downloaderTag(str), str2, th);
        }
        ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logD(downloaderTag(str), str2 + th);
        }
    }

    public static void i(String str) {
        i(TAG, str);
    }

    public static void i(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (mLevel <= 4) {
            Log.i(downloaderTag(str), str2);
        }
        ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logI(downloaderTag(str), str2);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (mLevel <= 4) {
            Log.i(downloaderTag(str), str2, th);
        }
        ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logI(downloaderTag(str), str2, th);
        }
    }

    public static void w(String str) {
        w(TAG, str);
    }

    public static void w(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (mLevel <= 5) {
            Log.w(downloaderTag(str), str2);
        }
        ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logW(downloaderTag(str), str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (mLevel <= 5) {
            Log.w(downloaderTag(str), str2, th);
        }
        ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logW(downloaderTag(str), str2, th);
        }
    }

    public static void e(String str) {
        e(TAG, str);
    }

    public static void e(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (mLevel <= 6) {
            Log.e(downloaderTag(str), str2);
        }
        ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logE(downloaderTag(str), str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (mLevel <= 6) {
            Log.e(downloaderTag(str), str2, th);
        }
        ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logE(downloaderTag(str), str2, th);
        }
    }

    public static void k(String str) {
        k(TAG, str);
    }

    public static void k(String str, String str2) {
        if (mLevel <= 3) {
            Log.d(downloaderTag(str), str2);
        }
        ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logK(downloaderTag(str), str2);
        }
    }

    public static void st(String str, int i) {
        try {
            throw new Exception();
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 1; i2 < Math.min(i, stackTrace.length); i2++) {
                if (i2 > 1) {
                    sb.append(UpdateDialogNewBase.TYPE);
                }
                sb.append(getSimpleClassName(stackTrace[i2].getClassName()));
                sb.append(LibrarianImpl.Constants.DOT);
                sb.append(stackTrace[i2].getMethodName());
            }
            v(downloaderTag(str), sb.toString());
        }
    }

    private static String getSimpleClassName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf < 0 ? str : str.substring(lastIndexOf + 1);
    }

    public static void throwException(Throwable th) {
        if (th == null) {
            return;
        }
        th.printStackTrace();
        if (debug()) {
            throw new RuntimeException("Error! Now in debug, we alert to you to correct it !", th);
        }
    }

    public static void alertErrorInfo(String str) {
        if (debug()) {
            throw new IllegalStateException(str);
        }
    }

    public static void registerLogHandler(ILogWritter iLogWritter) {
        synchronized (mAlogLock) {
            if (mEnableALogWritter) {
                return;
            }
            sLogWritter = iLogWritter;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class AlogHandler extends ILogWritter {
        private AlogHandler() {
        }

        @Override // com.ss.android.socialbase.downloader.logger.Logger.ILogWritter
        public void logD(String str, String str2) {
            Logger.alogE(str, str2);
        }

        @Override // com.ss.android.socialbase.downloader.logger.Logger.ILogWritter
        public void logE(String str, String str2) {
            Logger.alogE(str, str2);
        }
    }

    public static void registerLogReport(ILogReport iLogReport) {
        if (iLogReport == null) {
            return;
        }
        mLogReport = iLogReport;
    }

    public static void setLogReportParams(int i, boolean z, List<String> list, List<String> list2) {
        synchronized (mAlogLock) {
            if (mEnableALogWritter) {
                return;
            }
            mEnableALogWritter = true;
            mLevel = i;
            sLogWritter = new AlogHandler();
            mEnableGlobalReport = z;
            if (list != null && !list.isEmpty()) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    mTaskReportSceneList.add(it.next());
                }
            }
            if (list2 != null && !list2.isEmpty()) {
                Iterator<String> it2 = list2.iterator();
                while (it2.hasNext()) {
                    mAlogTaskSceneList.add(it2.next());
                }
            }
        }
    }
}
