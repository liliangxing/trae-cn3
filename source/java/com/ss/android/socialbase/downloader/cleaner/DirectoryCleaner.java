package com.ss.android.socialbase.downloader.cleaner;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.socialbase.downloader.cleaner.CleanerImpl;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IDirectoryCleanerListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DirectoryCleaner implements CleanerImpl.CleanerHandler {
    private static final String TAG = "DirectoryCleaner";
    private static volatile boolean sEnabled;
    private static volatile long sExpiredTime;
    private long mCleanDuration;
    private CleanerConfig mCleanerConfig;
    private CleanerImpl mCleanerImpl;
    private int mDeleteFileCount;
    private IDirectoryCleanerListener mDirectoryCleanerListener;
    private String mPackageName;
    private int mSearchDBCount;

    public DirectoryCleaner() {
    }

    public DirectoryCleaner(CleanerImpl cleanerImpl, CleanerConfig cleanerConfig) {
        this.mCleanerImpl = cleanerImpl;
        this.mCleanerConfig = cleanerConfig;
    }

    public static void init(CleanerConfig cleanerConfig) {
        JSONArray optJSONArray;
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "init", "Run");
        }
        DownloadSetting obtainGlobal = DownloadSetting.obtainGlobal();
        if (obtainGlobal.optInt(DownloadSettingKeys.AUTO_CLEAN_DIRECTORY) > 0 && (optJSONArray = obtainGlobal.optJSONArray(DownloadSettingKeys.CLEAN_DIRECTORY_LIST)) != null && optJSONArray.length() > 0) {
            int optInt = obtainGlobal.optInt(DownloadSettingKeys.CLEAN_DIRECTORY_CHECK_INTERVAL_D);
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "init", "Clean_directory_check_interval_d:" + optInt + " clean_directory_list:" + optJSONArray);
            }
            if (optInt > 0) {
                long lastCleanDirectoryTime = cleanerConfig.getLastCleanDirectoryTime();
                if (lastCleanDirectoryTime > 0 && System.currentTimeMillis() - lastCleanDirectoryTime < optInt * DownloadConstants.DAY) {
                    if (Logger.debug()) {
                        Logger.globalDebug(TAG, "start", "It has already been clean, lastCleanTime:" + lastCleanDirectoryTime);
                        return;
                    }
                    return;
                }
            }
            sEnabled = true;
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "init", "Run End");
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    @Override // com.ss.android.socialbase.downloader.cleaner.CleanerImpl.CleanerHandler
    public void start() {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "start", "Run");
        }
        long nanoTime = System.nanoTime();
        try {
            startImpl();
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "start", "Run End");
            }
            long nanoTime2 = ((System.nanoTime() - nanoTime) / 1000) / 1000;
            this.mCleanDuration = nanoTime2;
            IDirectoryCleanerListener iDirectoryCleanerListener = this.mDirectoryCleanerListener;
            if (iDirectoryCleanerListener != null) {
                iDirectoryCleanerListener.onFinish(null, this.mSearchDBCount, this.mDeleteFileCount, nanoTime2);
            }
        } catch (Throwable th) {
            try {
                Logger.globalError(TAG, "start", "Error:" + th);
                if (Logger.debug()) {
                    Logger.globalDebug(TAG, "start", "Run End");
                }
                long nanoTime3 = ((System.nanoTime() - nanoTime) / 1000) / 1000;
                this.mCleanDuration = nanoTime3;
                IDirectoryCleanerListener iDirectoryCleanerListener2 = this.mDirectoryCleanerListener;
                if (iDirectoryCleanerListener2 != null) {
                    iDirectoryCleanerListener2.onFinish(th, this.mSearchDBCount, this.mDeleteFileCount, nanoTime3);
                }
            } catch (Throwable th2) {
                if (Logger.debug()) {
                    Logger.globalDebug(TAG, "start", "Run End");
                }
                long nanoTime4 = ((System.nanoTime() - nanoTime) / 1000) / 1000;
                this.mCleanDuration = nanoTime4;
                IDirectoryCleanerListener iDirectoryCleanerListener3 = this.mDirectoryCleanerListener;
                if (iDirectoryCleanerListener3 != null) {
                    iDirectoryCleanerListener3.onFinish(null, this.mSearchDBCount, this.mDeleteFileCount, nanoTime4);
                }
                throw th2;
            }
        }
    }

    public static boolean isEnabled() {
        return sEnabled;
    }

    public void setDirectoryCleanerListener(IDirectoryCleanerListener iDirectoryCleanerListener) {
        this.mDirectoryCleanerListener = iDirectoryCleanerListener;
    }

    private void startImpl() {
        Context appContext = DownloadComponentManager.getAppContext();
        if (appContext == null) {
            Logger.globalError(TAG, "init", "Error context is null");
            return;
        }
        this.mPackageName = appContext.getPackageName();
        if (sExpiredTime < 0) {
            sExpiredTime = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.CLEAN_DIRECTORY_EXPIRED_TIME_D, -1);
        }
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "init", "ExpiredTime" + sExpiredTime);
        }
        if (sExpiredTime < 0) {
            return;
        }
        sExpiredTime *= DownloadConstants.DAY;
        CleanerConfig cleanerConfig = this.mCleanerConfig;
        if (cleanerConfig != null) {
            cleanerConfig.updateCleanDirectoryTime();
        }
        JSONArray optJSONArray = DownloadSetting.obtainGlobal().optJSONArray(DownloadSettingKeys.CLEAN_DIRECTORY_LIST);
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString(DownloadSettingKeys.CleanDirectory.DIRECTORY_PATH);
                if (Logger.debug()) {
                    Logger.globalDebug(TAG, "startImpl", "Run directoryPath:" + optString);
                }
                if (TextUtils.isEmpty(optString)) {
                    continue;
                } else {
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray(DownloadSettingKeys.CleanDirectory.PATH_CONTAINS_LIST);
                    ArrayList arrayList = new ArrayList();
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            String optString2 = optJSONArray2.optString(i2);
                            if (!TextUtils.isEmpty(optString2)) {
                                arrayList.add(optString2);
                            }
                        }
                    }
                    File realExternalFile = CleanerConfig.getRealExternalFile(optString, this.mPackageName);
                    if (realExternalFile != null && realExternalFile.isDirectory()) {
                        deleteCacheData(realExternalFile, arrayList);
                    } else {
                        CleanerImpl cleanerImpl = this.mCleanerImpl;
                        if (cleanerImpl != null && cleanerImpl.isStop()) {
                            return;
                        }
                        File realInternalFile = CleanerConfig.getRealInternalFile(optString, this.mPackageName);
                        if (realInternalFile != null && realInternalFile.isDirectory()) {
                            deleteCacheData(realInternalFile, arrayList);
                        }
                        CleanerImpl cleanerImpl2 = this.mCleanerImpl;
                        if (cleanerImpl2 != null && cleanerImpl2.isStop()) {
                            return;
                        }
                    }
                }
            }
        }
    }

    private void deleteCacheData(File file, List<String> list) {
        Pair pair;
        List<File> expiredFiles = getExpiredFiles(file, list);
        if (expiredFiles == null || expiredFiles.isEmpty()) {
            return;
        }
        Map installedTimeStampBySavePath = Downloader.getInstance(DownloadComponentManager.getAppContext()).getInstalledTimeStampBySavePath(file.getAbsolutePath() + "%");
        if (installedTimeStampBySavePath != null) {
            this.mSearchDBCount += installedTimeStampBySavePath.size();
        }
        for (File file2 : expiredFiles) {
            CleanerImpl cleanerImpl = this.mCleanerImpl;
            if (cleanerImpl != null && cleanerImpl.isStop()) {
                return;
            }
            String absolutePath = file2.getAbsolutePath();
            if (installedTimeStampBySavePath != null && (pair = (Pair) installedTimeStampBySavePath.get(absolutePath.toLowerCase(Locale.getDefault()))) != null && ((Long) pair.second).longValue() <= 0) {
                DownloadComponentManager.getDownloadCache().removeDownloadTaskData(((Integer) pair.first).intValue());
            }
            file2.delete();
            this.mDeleteFileCount++;
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "deleteCacheDataImpl", "Delete DownloadData:" + absolutePath);
            }
        }
    }

    private List<File> getExpiredFiles(File file, final List<String> list) {
        final long currentTimeMillis = System.currentTimeMillis();
        final ArrayList arrayList = new ArrayList();
        final LinkedList linkedList = new LinkedList();
        linkedList.add(file);
        FileFilter fileFilter = new FileFilter() { // from class: com.ss.android.socialbase.downloader.cleaner.DirectoryCleaner.1
            private boolean mTempRv;

            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2.isFile()) {
                    String absolutePath = file2.getAbsolutePath();
                    if (TextUtils.isEmpty(absolutePath)) {
                        return false;
                    }
                    this.mTempRv = false;
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (absolutePath.contains((String) it.next())) {
                            this.mTempRv = true;
                            break;
                        }
                    }
                    if (this.mTempRv && currentTimeMillis - file2.lastModified() > DirectoryCleaner.sExpiredTime) {
                        arrayList.add(file2);
                    }
                } else if (file2.isDirectory()) {
                    linkedList.add(file2);
                }
                return false;
            }
        };
        while (!linkedList.isEmpty()) {
            ((File) linkedList.poll()).listFiles(fileFilter);
        }
        return arrayList;
    }
}
