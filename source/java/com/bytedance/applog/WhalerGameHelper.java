package com.bytedance.applog;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WhalerGameHelper {
    public static final String GT_AD_BUTTON_CLICK = "gt_ad_button_click";
    public static final String GT_AD_SHOW = "gt_ad_show";
    public static final String GT_AD_SHOW_END = "gt_ad_show_end";
    public static final String GT_COST_COINS = "gt_cost_coins";
    public static final String GT_END_PLAY = "gt_end_play";
    public static final String GT_GET_COINS = "gt_get_coins";
    public static final String GT_INIT_INFO = "gt_init_info";
    public static final String GT_LEVELUP = "gt_levelup";
    public static final String GT_START_PLAY = "gt_start_play";
    public static final String PURCHASE = "purchase";

    private static void fillOtherParams(HashMap<String, Object> hashMap, JSONObject jSONObject) throws JSONException {
        if (hashMap == null || hashMap.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public static void adButtonClick(String str, String str2, String str3, HashMap<String, Object> hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            fillOtherParams(hashMap, jSONObject);
            jSONObject.put("ad_type", str);
            jSONObject.put("ad_position_type", str2);
            jSONObject.put("ad_position", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AppLog.onEventV3(GT_AD_BUTTON_CLICK, jSONObject);
    }

    public static void adShow(String str, String str2, String str3, HashMap<String, Object> hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            fillOtherParams(hashMap, jSONObject);
            jSONObject.put("ad_type", str);
            jSONObject.put("ad_position_type", str2);
            jSONObject.put("ad_position", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AppLog.onEventV3(GT_AD_SHOW, jSONObject);
    }

    public static void adShowEnd(String str, String str2, String str3, String str4, HashMap<String, Object> hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            fillOtherParams(hashMap, jSONObject);
            jSONObject.put("ad_type", str);
            jSONObject.put("ad_position_type", str2);
            jSONObject.put("ad_position", str3);
            jSONObject.put("result", str4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AppLog.onEventV3(GT_AD_SHOW_END, jSONObject);
    }

    public static void levelUp(int i, int i2, String str, int i3, HashMap<String, Object> hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            fillOtherParams(hashMap, jSONObject);
            jSONObject.put("get_exp", i2);
            jSONObject.put("method", str);
            jSONObject.put("aflev", i3);
            jSONObject.put("lev", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AppLog.onEventV3(GT_LEVELUP, jSONObject);
    }

    public static void startPlay(String str, HashMap<String, Object> hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            fillOtherParams(hashMap, jSONObject);
            jSONObject.put("ectype_name", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AppLog.onEventV3(GT_START_PLAY, jSONObject);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public enum Result {
        UNCOMPLETED("uncompleted"),
        SUCCESS("success"),
        FAIL("fail");

        final String gameResult;

        Result(String str) {
            this.gameResult = str;
        }
    }

    public static void endPlay(String str, Result result, int i, HashMap<String, Object> hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            fillOtherParams(hashMap, jSONObject);
            jSONObject.put("ectype_name", str);
            jSONObject.put("result", result.gameResult);
            jSONObject.put("duration", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AppLog.onEventV3(GT_END_PLAY, jSONObject);
    }

    public static void purchase(String str, String str2, String str3, int i, String str4, String str5, String str6, int i2, HashMap<String, Object> hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            fillOtherParams(hashMap, jSONObject);
            jSONObject.put("content_type", str);
            jSONObject.put("content_name", str2);
            jSONObject.put("content_num", i);
            jSONObject.put("content_id", str3);
            jSONObject.put("payment_channel", str4);
            jSONObject.put("currency", str5);
            jSONObject.put("is_success", str6);
            jSONObject.put("currency_amount", i2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AppLog.onEventV3("purchase", jSONObject);
    }

    public static void gameInitInfo(int i, String str, int i2, HashMap<String, Object> hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            fillOtherParams(hashMap, jSONObject);
            jSONObject.put("coin_type", str);
            jSONObject.put("coin_left", i2);
            jSONObject.put("lev", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AppLog.onEventV3(GT_INIT_INFO, jSONObject);
    }

    public static void getCoins(String str, String str2, int i, HashMap<String, Object> hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            fillOtherParams(hashMap, jSONObject);
            jSONObject.put("coin_type", str);
            jSONObject.put("method", str2);
            jSONObject.put("coin_num", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AppLog.onEventV3(GT_GET_COINS, jSONObject);
    }

    public static void costCoins(String str, String str2, int i, HashMap<String, Object> hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            fillOtherParams(hashMap, jSONObject);
            jSONObject.put("coin_type", str);
            jSONObject.put("method", str2);
            jSONObject.put("coin_num", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AppLog.onEventV3(GT_COST_COINS, jSONObject);
    }
}
