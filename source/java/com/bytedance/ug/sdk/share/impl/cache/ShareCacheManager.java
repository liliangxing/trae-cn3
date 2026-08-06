package com.bytedance.ug.sdk.share.impl.cache;

import android.text.TextUtils;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.utils.Logger;
import com.bytedance.ug.sdk.share.impl.utils.SharePrefHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ShareCacheManager {
    private static final String ANDROID12_TOKEN_DETECT_STRATEGY = "android12_token_detect_strategy";
    public static final String CHECKED_IMAGE_PATH_LIST = "checked_image_path_list";
    private static final String CHECK_AND_SIGN_CHANNEL_LIST = "check_and_sign_channel_list";
    private static final String CHECK_USE_TIMON = "use_timon";
    private static final int HIDDEN_IMAGE_CACHE_COUNT = 20;
    public static final String HIDDEN_IMAGE_PATH_LIST = "hidden_image_path_list";
    private static final String PANEL_LIST = "panel_list";
    private static final String TAG = "ShareCacheManager";
    private static final String TOKEN_ACTIVITY_REGEX = "token_activity_regex";
    private static final String TOKEN_PIC_REGEX = "token_pic_regex";
    private static final String TOKEN_REGEX = "token_regex";
    private static final String TOKEN_SHARE_REGEX = "€[0-9A-Za-z]{5}€[0-9A-Za-z]{6}";
    private static final String TOKEN_STRATEGY = "token_strategy";
    private static final String TOKEN_VIDEO_REGEX = "token_video_regex";
    private static final String VIDEO_HIDDEN_MARK_TIME = "video_hidden_mark_time";
    private static final String ZLINK_INFO_LIST = "zlink_info_list";
    private SharePrefHelper mPrefHelper;

    private ShareCacheManager() {
        this.mPrefHelper = SharePrefHelper.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class SingleHolder {
        private static ShareCacheManager sInstance = new ShareCacheManager();

        private SingleHolder() {
        }
    }

    public static ShareCacheManager getInstance() {
        return SingleHolder.sInstance;
    }

    public void setTokenRegex(String str) {
        this.mPrefHelper.setPref(TOKEN_REGEX, str);
    }

    public String getTokenRegex() {
        return this.mPrefHelper.getPref(TOKEN_REGEX, TOKEN_SHARE_REGEX);
    }

    public void setTokenStrategy(String str) {
        this.mPrefHelper.setPref(TOKEN_STRATEGY, str);
    }

    public String getTokenStrategy() {
        return this.mPrefHelper.getPref(TOKEN_STRATEGY, "");
    }

    public void setTokenActivityRegex(String str) {
        this.mPrefHelper.setPref(TOKEN_ACTIVITY_REGEX, str);
    }

    public String getTokenActivityRegex() {
        return this.mPrefHelper.getPref(TOKEN_ACTIVITY_REGEX, ShareConfigManager.getInstance().getDefaultTokenActReg());
    }

    public void setTokenPicRegex(String str) {
        this.mPrefHelper.setPref(TOKEN_PIC_REGEX, str);
    }

    public String getTokenPicRegex() {
        return this.mPrefHelper.getPref(TOKEN_PIC_REGEX, ShareConfigManager.getInstance().getDefaultTokenPicReg());
    }

    public void setTokenVideoRegex(String str) {
        this.mPrefHelper.setPref(TOKEN_VIDEO_REGEX, str);
    }

    public String getTokenVideoRegex() {
        return this.mPrefHelper.getPref(TOKEN_VIDEO_REGEX, ShareConfigManager.getInstance().getDefaultTokenVideoReg());
    }

    public void setPanelList(String str) {
        this.mPrefHelper.setPref(PANEL_LIST, str);
    }

    public String getPanelList() {
        return this.mPrefHelper.getPref(PANEL_LIST, ShareConfigManager.getInstance().getDefaultPanelList());
    }

    public void setVideoHiddenMarkTime(int i, int i2) {
        this.mPrefHelper.setPref(VIDEO_HIDDEN_MARK_TIME, i + "/" + i2);
    }

    public String getVideoHiddenMarkTime() {
        return this.mPrefHelper.getPref(VIDEO_HIDDEN_MARK_TIME, "");
    }

    public void setZlinkInfoList(String str) {
        this.mPrefHelper.setPref(ZLINK_INFO_LIST, str);
    }

    public String getZlinkInfoList() {
        return this.mPrefHelper.getPref(ZLINK_INFO_LIST, "");
    }

    public void setCheckAndSignChannelList(String str) {
        this.mPrefHelper.setPref(CHECK_AND_SIGN_CHANNEL_LIST, str);
    }

    public String getCheckAndSignChannelList() {
        return this.mPrefHelper.getPref(CHECK_AND_SIGN_CHANNEL_LIST, "");
    }

    public void setAndroid12TokenDetectStrategy(String str) {
        this.mPrefHelper.setPref(ANDROID12_TOKEN_DETECT_STRATEGY, str);
    }

    public int getEnableUseTimon() {
        return this.mPrefHelper.getPref(CHECK_USE_TIMON, 0);
    }

    public void setEnableUseTimon(int i) {
        this.mPrefHelper.setPref(CHECK_USE_TIMON, i);
    }

    public String getAndroid12TokenDetectStrategy() {
        return this.mPrefHelper.getPref(ANDROID12_TOKEN_DETECT_STRATEGY, "");
    }

    public LinkedHashMap<String, Boolean> getImageCheckedPaths(String str) {
        String pref = this.mPrefHelper.getPref(str, "");
        LinkedHashMap<String, Boolean> linkedHashMap = new LinkedHashMap<>();
        if (TextUtils.isEmpty(pref)) {
            return linkedHashMap;
        }
        try {
            JSONArray jSONArray = new JSONArray(pref);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                JSONArray names = jSONObject.names();
                if (names != null) {
                    for (int i2 = 0; i2 < names.length(); i2++) {
                        String string = names.getString(i2);
                        linkedHashMap.put(string, Boolean.valueOf(jSONObject.getBoolean(string)));
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return linkedHashMap;
    }

    public void updateSaveAlbumMediaCache(String str, boolean z) {
        Logger.m463d(TAG, "updateSaveAlbumMediaCache : " + str + " valid is " + z);
        try {
            LinkedHashMap<String, Boolean> imageCheckedPaths = getImageCheckedPaths(HIDDEN_IMAGE_PATH_LIST);
            if (imageCheckedPaths == null) {
                imageCheckedPaths = new LinkedHashMap<>();
            }
            if (imageCheckedPaths.containsKey(str) && imageCheckedPaths.get(str).booleanValue() == z) {
                return;
            }
            imageCheckedPaths.put(str, Boolean.valueOf(z));
            JSONArray jSONArray = new JSONArray();
            Iterator<Map.Entry<String, Boolean>> it = imageCheckedPaths.entrySet().iterator();
            if (imageCheckedPaths.size() > 20 && it.hasNext()) {
                imageCheckedPaths.remove(it.next().getKey());
            }
            for (Map.Entry<String, Boolean> entry : imageCheckedPaths.entrySet()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(entry.getKey(), entry.getValue());
                jSONArray.put(jSONObject);
            }
            this.mPrefHelper.setPref(HIDDEN_IMAGE_PATH_LIST, jSONArray.toString());
        } catch (Throwable th) {
            Logger.m466e(TAG, "updateSaveAlbumMediaCache : " + th.toString());
        }
    }

    public void updateCheckAlbumMedia(String str, boolean z) {
        Logger.m463d(TAG, "updateCheckAlbumMedia : " + str + " valid is " + z);
        try {
            LinkedHashMap<String, Boolean> imageCheckedPaths = getImageCheckedPaths(CHECKED_IMAGE_PATH_LIST);
            if (imageCheckedPaths == null) {
                imageCheckedPaths = new LinkedHashMap<>();
            }
            if (imageCheckedPaths.containsKey(str) && imageCheckedPaths.get(str).booleanValue() == z) {
                return;
            }
            imageCheckedPaths.put(str, Boolean.valueOf(z));
            JSONArray jSONArray = new JSONArray();
            Iterator<Map.Entry<String, Boolean>> it = imageCheckedPaths.entrySet().iterator();
            if (imageCheckedPaths.size() > ShareConfigManager.getInstance().getAlbumImageCacheNum() && it.hasNext()) {
                imageCheckedPaths.remove(it.next().getKey());
            }
            for (Map.Entry<String, Boolean> entry : imageCheckedPaths.entrySet()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(entry.getKey(), entry.getValue());
                jSONArray.put(jSONObject);
            }
            this.mPrefHelper.setPref(CHECKED_IMAGE_PATH_LIST, jSONArray.toString());
        } catch (Throwable th) {
            Logger.m463d(TAG, "updateCheckAlbumMedia : " + th.toString());
        }
    }
}
