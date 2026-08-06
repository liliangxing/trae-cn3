package com.bytedance.sdk.account.induce;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ss.android.LogHelper;
import com.ss.android.TTAccountConfig;
import com.ss.android.account.TTAccountInit;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class InduceRecorder {
    private static final String INDUCE_LOGIN_STRATEGY = "account_sdk_induce_login_strategy";
    private static final String RECORDER_FILE_NAME = "account_sdk_induce_recorder";
    private static final String SCENE_SHOW_TIMES_PREFIX = "account_sdk_induce_scene_show_times_";
    private static final String SCENE_TRIGGER_COUNT_LONG_PREFIX = "account_sdk_induce_scene_trigger_long_count_";
    private static final String SCENE_TRIGGER_COUNT_PREFIX = "account_sdk_induce_scene_trigger_count_";
    private static final String TAG = "InduceRecorder";
    private SharedPreferences mSharedPreferences;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InduceRecorder() {
        tryInitSp();
    }

    private void tryInitSp() {
        TTAccountConfig configMayNull;
        if (this.mSharedPreferences == null && (configMayNull = TTAccountInit.getConfigMayNull()) != null) {
            this.mSharedPreferences = configMayNull.getApplicationContext().getSharedPreferences(RECORDER_FILE_NAME, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void markSceneCurrentCount(String str, long j) {
        putLong(SCENE_TRIGGER_COUNT_LONG_PREFIX + str, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getSceneCurrentCount(String str) {
        int i = getInt(SCENE_TRIGGER_COUNT_PREFIX + str, -1);
        return i == -1 ? getLong(SCENE_TRIGGER_COUNT_LONG_PREFIX + str, 0L) : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearSceneTriggerCount() {
        Map<String, ?> all;
        Set<String> keySet;
        tryInitSp();
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        if (sharedPreferences == null || (all = sharedPreferences.getAll()) == null || (keySet = all.keySet()) == null) {
            return;
        }
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        for (String str : keySet) {
            if (str.startsWith(SCENE_TRIGGER_COUNT_PREFIX) || str.startsWith(SCENE_TRIGGER_COUNT_LONG_PREFIX)) {
                edit.remove(str);
            }
        }
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject getGuideLoginStrategy() {
        String string = getString(INDUCE_LOGIN_STRATEGY, null);
        if (!TextUtils.isEmpty(string)) {
            try {
                return new JSONObject(string);
            } catch (Exception e) {
                LogHelper.e(TAG, "", e);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setGuideLoginStrategy(JSONObject jSONObject) {
        if (jSONObject != null) {
            putString(INDUCE_LOGIN_STRATEGY, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void saveSceneShowTimes(String str, String str2) {
        putString(SCENE_SHOW_TIMES_PREFIX + str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getSceneShowTimes(String str) {
        return getString(SCENE_SHOW_TIMES_PREFIX + str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearSceneShowTimes() {
        Map<String, ?> all;
        Set<String> keySet;
        tryInitSp();
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        if (sharedPreferences == null || (all = sharedPreferences.getAll()) == null || (keySet = all.keySet()) == null) {
            return;
        }
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        for (String str : keySet) {
            if (str.startsWith(SCENE_SHOW_TIMES_PREFIX)) {
                edit.remove(str);
            }
        }
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<String> getAllSceneShowKeys() {
        Map<String, ?> all;
        Set<String> keySet;
        tryInitSp();
        HashSet hashSet = new HashSet();
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        if (sharedPreferences != null && (all = sharedPreferences.getAll()) != null && (keySet = all.keySet()) != null) {
            for (String str : keySet) {
                if (str.startsWith(SCENE_SHOW_TIMES_PREFIX)) {
                    hashSet.add(str.replaceFirst(SCENE_SHOW_TIMES_PREFIX, ""));
                }
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<String> getAllTriggerCountKeys() {
        Map<String, ?> all;
        Set<String> keySet;
        tryInitSp();
        HashSet hashSet = new HashSet();
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        if (sharedPreferences != null && (all = sharedPreferences.getAll()) != null && (keySet = all.keySet()) != null) {
            for (String str : keySet) {
                if (str.startsWith(SCENE_TRIGGER_COUNT_PREFIX)) {
                    hashSet.add(str.replaceFirst(SCENE_TRIGGER_COUNT_PREFIX, ""));
                } else if (str.startsWith(SCENE_TRIGGER_COUNT_LONG_PREFIX)) {
                    hashSet.add(str.replaceFirst(SCENE_TRIGGER_COUNT_LONG_PREFIX, ""));
                }
            }
        }
        return hashSet;
    }

    private void putLong(String str, long j) {
        tryInitSp();
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(str, j).apply();
        }
    }

    private long getLong(String str, long j) {
        tryInitSp();
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        return sharedPreferences != null ? sharedPreferences.getLong(str, j) : j;
    }

    private void putInt(String str, int i) {
        tryInitSp();
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(str, i).apply();
        }
    }

    private int getInt(String str, int i) {
        tryInitSp();
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        return sharedPreferences != null ? sharedPreferences.getInt(str, i) : i;
    }

    private void putString(String str, String str2) {
        tryInitSp();
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    private String getString(String str, String str2) {
        tryInitSp();
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }
}
