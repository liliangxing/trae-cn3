package com.ss.android.socialbase.downloader.setting;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class DownloadSetting {
    private static final int POOL_SIZE = 16;
    private static final String TAG = "DownloadSetting";
    private static JSONObject sDisabledTaskKeys;
    private static Boolean sGlobalBugFixDefault;
    private static JSONObject sGlobalBugFixSetting;
    private static JSONObject sGlobalTaskSetting;
    private static DownloadSetting sLastSetting;
    private static boolean sTaskSettingDisabled;
    private final Boolean mBugFixDefault;
    private final JSONObject mBugFixSetting;
    private int mDownloadId;
    private final JSONObject mTaskSetting;
    private static final LruCache<Integer, DownloadSetting> sCache = new LruCache<>(16, 16);
    private static final DownloadSetting sGlobal = new DownloadSetting(null);

    static {
        init();
    }

    public static void init() {
        Boolean bool;
        JSONObject downloadSetting = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getDownloadSetting();
        sTaskSettingDisabled = downloadSetting.optInt(DownloadSettingKeys.DISABLE_TASK_SETTING, 0) == 1;
        sDisabledTaskKeys = downloadSetting.optJSONObject(DownloadSettingKeys.DISABLED_TASK_KEYS);
        sGlobalTaskSetting = downloadSetting.optJSONObject(DownloadSettingKeys.GLOBAL_TASK_SETTING);
        JSONObject optJSONObject = downloadSetting.optJSONObject(DownloadSettingKeys.BUG_FIX);
        if (optJSONObject == null || !optJSONObject.has("default")) {
            bool = null;
        } else {
            bool = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
        }
        sGlobalBugFixSetting = optJSONObject;
        sGlobalBugFixDefault = bool;
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "init", "SettingUpdate:" + (downloadSetting != null ? downloadSetting.toString() : "Empty"));
        }
    }

    private DownloadSetting(JSONObject jSONObject) {
        Boolean bool;
        this.mTaskSetting = jSONObject;
        JSONObject jSONObject2 = null;
        r0 = null;
        r0 = null;
        Boolean bool2 = null;
        if (jSONObject == null || isTaskKeyDisabled(DownloadSettingKeys.BUG_FIX)) {
            bool = null;
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject(DownloadSettingKeys.BUG_FIX);
            if (optJSONObject != null && optJSONObject.has("default") && !isTaskKeyDisabled("default")) {
                bool2 = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
            }
            Boolean bool3 = bool2;
            jSONObject2 = optJSONObject;
            bool = bool3;
        }
        this.mBugFixSetting = jSONObject2;
        this.mBugFixDefault = bool;
    }

    public static JSONObject getGlobalSettings() {
        return ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getDownloadSetting();
    }

    public static JSONObject getGlobalTaskSettings() {
        return sGlobalTaskSetting;
    }

    public static void setGlobalBugFix(String str, boolean z) {
        try {
            if (sGlobalBugFixSetting == null) {
                sGlobalBugFixSetting = new JSONObject();
            }
            sGlobalBugFixSetting.put(str, z ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    public static DownloadSetting obtainGlobal() {
        return sGlobal;
    }

    public static DownloadSetting obtain(int i) {
        return obtain(i, null);
    }

    public static DownloadSetting obtain(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return sGlobal;
        }
        return obtain(downloadInfo.getId(), downloadInfo);
    }

    private static DownloadSetting obtain(int i, DownloadInfo downloadInfo) {
        DownloadSetting downloadSetting;
        DownloadSetting downloadSetting2 = sLastSetting;
        if (downloadSetting2 != null && downloadSetting2.mDownloadId == i) {
            return downloadSetting2;
        }
        LruCache<Integer, DownloadSetting> lruCache = sCache;
        synchronized (lruCache) {
            downloadSetting = lruCache.get(Integer.valueOf(i));
        }
        if (downloadSetting == null) {
            downloadSetting = downloadInfo == null ? create(i) : create(downloadInfo);
            synchronized (lruCache) {
                lruCache.put(Integer.valueOf(i), downloadSetting);
            }
        }
        downloadSetting.mDownloadId = i;
        sLastSetting = downloadSetting;
        return downloadSetting;
    }

    public boolean optBugFix(String str) {
        return optBugFix(str, false);
    }

    public boolean optBugFix(String str, boolean z) {
        if (this.mBugFixSetting != null && !isTaskKeyDisabled(str)) {
            if (this.mBugFixSetting.has(str)) {
                return this.mBugFixSetting.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool = this.mBugFixDefault;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = sGlobalBugFixSetting;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return sGlobalBugFixSetting.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = sGlobalBugFixDefault;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z;
    }

    public int optInt(String str) {
        return optInt(str, 0);
    }

    public int optInt(String str, int i) {
        JSONObject jSONObject = this.mTaskSetting;
        if (jSONObject != null && jSONObject.has(str) && !isTaskKeyDisabled(str)) {
            return this.mTaskSetting.optInt(str, i);
        }
        return getGlobalSettings().optInt(str, i);
    }

    public long optLong(String str) {
        return optLong(str, 0L);
    }

    public long optLong(String str, long j) {
        JSONObject jSONObject = this.mTaskSetting;
        if (jSONObject != null && jSONObject.has(str) && !isTaskKeyDisabled(str)) {
            return this.mTaskSetting.optLong(str, j);
        }
        return getGlobalSettings().optLong(str, j);
    }

    public double optDouble(String str) {
        return optDouble(str, Double.NaN);
    }

    public double optDouble(String str, double d) {
        JSONObject jSONObject = this.mTaskSetting;
        if (jSONObject != null && jSONObject.has(str) && !isTaskKeyDisabled(str)) {
            return this.mTaskSetting.optDouble(str, d);
        }
        return getGlobalSettings().optDouble(str, d);
    }

    public boolean optBoolean(String str) {
        return optBoolean(str, false);
    }

    public boolean optBoolean(String str, boolean z) {
        JSONObject jSONObject = this.mTaskSetting;
        if (jSONObject != null && jSONObject.has(str) && !isTaskKeyDisabled(str)) {
            return this.mTaskSetting.optBoolean(str, z);
        }
        return getGlobalSettings().optBoolean(str, z);
    }

    public String optString(String str) {
        return optString(str, "");
    }

    public String optString(String str, String str2) {
        JSONObject jSONObject = this.mTaskSetting;
        if (jSONObject != null && jSONObject.has(str) && !isTaskKeyDisabled(str)) {
            return this.mTaskSetting.optString(str, str2);
        }
        return getGlobalSettings().optString(str, str2);
    }

    public JSONObject optJSONObject(String str) {
        JSONObject jSONObject = this.mTaskSetting;
        if (jSONObject != null && jSONObject.has(str) && !isTaskKeyDisabled(str)) {
            return this.mTaskSetting.optJSONObject(str);
        }
        return getGlobalSettings().optJSONObject(str);
    }

    public JSONArray optJSONArray(String str) {
        JSONObject jSONObject = this.mTaskSetting;
        if (jSONObject != null && jSONObject.has(str) && !isTaskKeyDisabled(str)) {
            return this.mTaskSetting.optJSONArray(str);
        }
        return getGlobalSettings().optJSONArray(str);
    }

    public Object opt(String str) {
        JSONObject jSONObject = this.mTaskSetting;
        if (jSONObject != null && jSONObject.has(str) && !isTaskKeyDisabled(str)) {
            return this.mTaskSetting.opt(str);
        }
        return getGlobalSettings().opt(str);
    }

    public boolean has(String str) {
        if (this.mTaskSetting != null && !isTaskKeyDisabled(str)) {
            return this.mTaskSetting.has(str);
        }
        return getGlobalSettings().has(str);
    }

    public static boolean isTaskKeyDisabled(String str) {
        JSONObject jSONObject = sDisabledTaskKeys;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public static DownloadSetting obtain(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == getGlobalSettings() || sTaskSettingDisabled) {
            return sGlobal;
        }
        DownloadSetting downloadSetting = sLastSetting;
        if (downloadSetting != null && downloadSetting.mTaskSetting == jSONObject) {
            return downloadSetting;
        }
        LruCache<Integer, DownloadSetting> lruCache = sCache;
        synchronized (lruCache) {
            for (DownloadSetting downloadSetting2 : lruCache.values()) {
                if (downloadSetting2.mTaskSetting == jSONObject) {
                    sLastSetting = downloadSetting2;
                    return downloadSetting2;
                }
            }
            DownloadSetting downloadSetting3 = new DownloadSetting(jSONObject);
            sLastSetting = downloadSetting3;
            return downloadSetting3;
        }
    }

    public static void addTaskDownloadSetting(int i, JSONObject jSONObject) {
        addTaskDownloadSetting(i, null, jSONObject);
    }

    public static void addTaskDownloadSetting(int i, String str, JSONObject jSONObject) {
        DownloadSetting downloadSetting;
        JSONObject mergeGlobalTaskSetting = mergeGlobalTaskSetting(jSONObject, str);
        if (mergeGlobalTaskSetting == null || mergeGlobalTaskSetting == getGlobalSettings() || sTaskSettingDisabled) {
            return;
        }
        LruCache<Integer, DownloadSetting> lruCache = sCache;
        synchronized (lruCache) {
            DownloadSetting downloadSetting2 = sLastSetting;
            if (downloadSetting2 != null && downloadSetting2.mTaskSetting == mergeGlobalTaskSetting) {
                downloadSetting2.mDownloadId = i;
            } else {
                Iterator<DownloadSetting> it = lruCache.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        downloadSetting = null;
                        break;
                    }
                    downloadSetting = it.next();
                    if (downloadSetting.mTaskSetting == mergeGlobalTaskSetting) {
                        downloadSetting.mDownloadId = i;
                        break;
                    }
                }
                if (downloadSetting == null) {
                    downloadSetting2 = new DownloadSetting(mergeGlobalTaskSetting);
                    downloadSetting2.mDownloadId = i;
                } else {
                    downloadSetting2 = downloadSetting;
                }
                sLastSetting = downloadSetting2;
            }
            sCache.put(Integer.valueOf(i), downloadSetting2);
        }
    }

    public static void removeTaskDownloadSetting(int i) {
        DownloadSetting downloadSetting = sLastSetting;
        if (downloadSetting != null && downloadSetting.mDownloadId == i) {
            sLastSetting = null;
        }
        LruCache<Integer, DownloadSetting> lruCache = sCache;
        synchronized (lruCache) {
            lruCache.remove(Integer.valueOf(i));
        }
    }

    private static DownloadSetting create(int i) {
        DownloadInfo downloadInfo;
        if (sTaskSettingDisabled) {
            return sGlobal;
        }
        if (((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext() != null && (downloadInfo = ((IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class)).getDownloadInfo(i)) != null) {
            return create(downloadInfo);
        }
        return sGlobal;
    }

    private static DownloadSetting create(DownloadInfo downloadInfo) {
        if (sTaskSettingDisabled) {
            return sGlobal;
        }
        try {
            String downloadSettingString = downloadInfo.getDownloadSettingString();
            JSONObject mergeGlobalTaskSetting = mergeGlobalTaskSetting(!TextUtils.isEmpty(downloadSettingString) ? new JSONObject(downloadSettingString) : null, downloadInfo.getMonitorScene());
            if (mergeGlobalTaskSetting != null) {
                return new DownloadSetting(mergeGlobalTaskSetting);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sGlobal;
    }

    private static JSONObject mergeGlobalTaskSetting(JSONObject jSONObject, String str) {
        JSONObject optJSONObject;
        try {
            optJSONObject = matchSceneTaskSetting(str) ? sGlobalTaskSetting.optJSONObject(str) : null;
            if (jSONObject != null && optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, optJSONObject.get(next));
                }
            }
        } catch (Throwable th) {
            Logger.globalError(TAG, "mergeGlobalTaskSetting", "Error:" + th + " " + str);
        }
        if (jSONObject != null) {
            return jSONObject;
        }
        if (optJSONObject != null) {
            return optJSONObject;
        }
        return null;
    }

    private static boolean matchSceneTaskSetting(String str) {
        return (sGlobalTaskSetting == null || TextUtils.isEmpty(str) || !sGlobalTaskSetting.has(str)) ? false : true;
    }

    public String toString() {
        try {
            return "DownloadSetting{mTaskSetting=" + this.mTaskSetting + ", mBugFixSetting=" + this.mBugFixSetting + ", mBugFixDefault=" + this.mBugFixDefault + ", mDownloadId=" + this.mDownloadId + ", globalSetting=" + getGlobalSettings() + AbstractJsonLexerKt.END_OBJ;
        } catch (Throwable th) {
            Logger.globalError(TAG, "toString", "Error:" + th);
            return "DownloadSetting Error";
        }
    }
}
