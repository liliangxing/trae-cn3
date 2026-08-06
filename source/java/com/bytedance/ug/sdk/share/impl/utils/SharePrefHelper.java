package com.bytedance.ug.sdk.share.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SharePrefHelper {
    private static final String DEFAULT_PREFS_FILE = "share_sdk_config.prefs";
    public static final String SP_SHOW_SHARE_VIDEO_CONTINEU_SHARE_DIALOG = "show_share_video_continue_share_dialog";
    public static final String SP_SHOW_SHARE_VIDEO_SHARE_DIALOG = "show_share_video_share_dialog";
    public static final String SP_USER_COPY_CONTENT = "user_copy_content";
    private static Map<String, SharePrefHelper> sCachedHelpers = new HashMap();
    private SharedPreferences prefs;

    private SharePrefHelper(String str) {
        Context appContext;
        this.prefs = null;
        SharedPreferences sharedPreferences = ShareConfigManager.getInstance().getSharedPreferences(str);
        this.prefs = sharedPreferences;
        if (sharedPreferences != null || (appContext = ShareSdkManager.getInstance().getAppContext()) == null) {
            return;
        }
        this.prefs = appContext.getSharedPreferences(str, 0);
    }

    public static SharePrefHelper getInstance() {
        return getInstance(DEFAULT_PREFS_FILE);
    }

    public static SharePrefHelper getInstance(String str) {
        SharePrefHelper sharePrefHelper = sCachedHelpers.get(str);
        if (sharePrefHelper == null) {
            synchronized (SharePrefHelper.class) {
                sharePrefHelper = sCachedHelpers.get(str);
                if (sharePrefHelper == null) {
                    sharePrefHelper = new SharePrefHelper(str);
                    sCachedHelpers.put(str, sharePrefHelper);
                }
            }
        }
        return sharePrefHelper;
    }

    public void setPref(String str, String str2) {
        SharedPreferences sharedPreferences = this.prefs;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    public void setPref(String str, int i) {
        SharedPreferences sharedPreferences = this.prefs;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(str, i);
            edit.apply();
        }
    }

    public String getPref(String str, String str2) {
        SharedPreferences sharedPreferences = this.prefs;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }

    public int getPref(String str, int i) {
        SharedPreferences sharedPreferences = this.prefs;
        return sharedPreferences != null ? sharedPreferences.getInt(str, i) : i;
    }

    public boolean removePref(String str) {
        SharedPreferences sharedPreferences = this.prefs;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove(str);
        return edit.commit();
    }
}
