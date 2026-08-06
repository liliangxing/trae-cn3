package com.ss.android.socialbase.appdownloader.util;

import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.depend.IAppInstallStatsReporter;
import com.ss.android.socialbase.appdownloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AppInstallStatsReporter {
    private static final int DEFAULT_DELAY_TIME = 120;
    private static final int DEFAULT_ITEM_MAX_LENGTH = 1000;
    private static final int DEFAULT_MAX_STATS_SIZE = 20;
    private static final String SEPARATOR = ",";
    private static final String TAG = "AppInstallStatsReporter";
    private static int mDelayTime = 120;
    private static volatile boolean mEnabled;
    private static Future mFuture;
    private static IAppInstallStatsReporter mReporter;
    private static Set<String> mSceneSet = Collections.synchronizedSet(new HashSet());
    private static List<String> mAppInstallStats = new CopyOnWriteArrayList();
    private static int mMaxStatsSize = 20;
    private static int mItemMaxLength = 1000;
    private static AtomicBoolean mTimerFlag = new AtomicBoolean(false);
    private static AtomicBoolean mInitSetting = new AtomicBoolean(false);

    public static boolean isEnabled() {
        initSetting();
        return mEnabled;
    }

    public static boolean isEnabled(String str) {
        initSetting();
        if (!mEnabled || TextUtils.isEmpty(str)) {
            return false;
        }
        return mSceneSet.contains(str);
    }

    public static void initSetting() {
        if (mInitSetting.compareAndSet(false, true)) {
            mEnabled = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.ENABLE_APP_INSTALL_AND_RESUME_REPORT_STATS) > 0;
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "initSetting", "Enable:" + mEnabled);
            }
            if (mEnabled) {
                int optInt = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.APP_INSTALL_AND_RESUME_DELAY_TIME_S);
                if (optInt > 0) {
                    mDelayTime = optInt;
                }
                int optInt2 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.APP_INSTALL_AND_RESUME_MAX_SIZE);
                if (optInt2 > 0) {
                    mMaxStatsSize = optInt2;
                }
                int optInt3 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.APP_INSTALL_AND_RESUME_ITEM_MAX_LENGTH);
                if (optInt3 > 0) {
                    mItemMaxLength = optInt3;
                }
                try {
                    JSONArray optJSONArray = DownloadSetting.obtainGlobal().optJSONArray(DownloadSettingKeys.APP_INSTALL_AND_RESUME_SCENE_LIST);
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String optString = optJSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString)) {
                            mSceneSet.add(optString);
                        }
                    }
                } catch (Throwable th) {
                    Logger.globalError(TAG, "getSceneSet", "Error:" + th);
                }
            }
        }
    }

    public static void addStats(int i, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (mAppInstallStats.size() > mMaxStatsSize) {
            if (DownloadUtils.isMainThread()) {
                return;
            }
            report();
            return;
        }
        String str3 = str + "," + i + "," + str2;
        int length = str3.length();
        int i2 = mItemMaxLength;
        if (length > i2) {
            str3 = str3.substring(0, i2);
        }
        mAppInstallStats.add(str3);
        if (mTimerFlag.compareAndSet(false, true)) {
            mFuture = DownloadComponentManager.getScheduledExecutorService().schedule(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.util.AppInstallStatsReporter.1
                @Override // java.lang.Runnable
                public void run() {
                    if (Logger.debug()) {
                        Logger.globalDebug(AppInstallStatsReporter.TAG, "addStats", "Clear");
                    }
                    AppInstallStatsReporter.report();
                    AppInstallStatsReporter.mAppInstallStats.clear();
                    Future unused = AppInstallStatsReporter.mFuture = null;
                    AppInstallStatsReporter.mTimerFlag.set(false);
                }
            }, mDelayTime, TimeUnit.SECONDS);
        }
    }

    public static void report() {
        if (mReporter == null || mAppInstallStats.isEmpty()) {
            return;
        }
        try {
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "report", "Run:" + mAppInstallStats.size());
            }
            JSONObject jSONObject = new JSONObject();
            Iterator<String> it = mAppInstallStats.iterator();
            while (it.hasNext()) {
                String[] split = it.next().split(",");
                if (split != null && split.length == 3) {
                    jSONObject.put(split[0], split[1] + " Res:" + split[2]);
                }
            }
            if (jSONObject.length() > 0) {
                mReporter.report(jSONObject);
            }
            mAppInstallStats.clear();
            mTimerFlag.set(false);
            Future future = mFuture;
            if (future != null && !future.isDone()) {
                future.cancel(false);
            }
            mFuture = null;
        } catch (Throwable th) {
            Logger.globalError(TAG, "report", "Error:" + th);
        }
    }

    public static void setReporter(IAppInstallStatsReporter iAppInstallStatsReporter) {
        mReporter = iAppInstallStatsReporter;
    }
}
