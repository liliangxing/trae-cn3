package com.bytedance.applog;

import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.util.Utils;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GameReportHelper {
    public static final String ACCESS_ACCOUNT = "access_account";
    public static final String ACCESS_PAYMENT_CHANNEL = "access_payment_channel";
    public static final String ADD_CART = "add_cart";
    public static final String ADD_TO_FAVORITE = "add_to_favourite";
    public static final String CHECK_OUT = "check_out";
    public static final String CREATE_GAMEROLE = "create_gamerole";
    public static final String LOG_IN = "log_in";
    public static final String PURCHASE = "purchase";
    public static final String QUEST = "quest";
    public static final String REGISTER = "register";
    public static final String UPDATE_LEVEL = "update_level";
    public static final String VIEW_CONTENT = "view_content";
    private static final List<String> logTags = Collections.singletonList("GameReportHelper");

    public static void onEventRegister(String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", str);
            jSONObject.put("is_success", Utils.getYesNoString(z));
            AppLog.onEventV3(REGISTER, jSONObject);
        } catch (JSONException e) {
            LoggerImpl.global().error(logTags, "onEventRegister failed", e, new Object[0]);
        }
    }

    public static void onEventLogin(String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", str);
            jSONObject.put("is_success", Utils.getYesNoString(z));
            AppLog.onEventV3(LOG_IN, jSONObject);
        } catch (JSONException e) {
            LoggerImpl.global().error(logTags, "onEventLogin failed", e, new Object[0]);
        }
    }

    public static void onEventPurchase(String str, String str2, String str3, int i, String str4, String str5, boolean z, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("content_type", str);
            jSONObject.put("content_name", str2);
            jSONObject.put("content_id", str3);
            jSONObject.put("content_num", i);
            jSONObject.put("payment_channel", str4);
            jSONObject.put("currency", str5);
            jSONObject.put("is_success", Utils.getYesNoString(z));
            jSONObject.put("currency_amount", i2);
            AppLog.onEventV3("purchase", jSONObject);
        } catch (JSONException e) {
            LoggerImpl.global().error(logTags, "onEventPurchase failed", e, new Object[0]);
        }
    }

    public static void onEventAccessAccount(String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("account_type", str);
            jSONObject.put("is_success", Utils.getYesNoString(z));
            AppLog.onEventV3(ACCESS_ACCOUNT, jSONObject);
        } catch (JSONException e) {
            LoggerImpl.global().error(logTags, "onEventAccessAccount failed", e, new Object[0]);
        }
    }

    public static void onEventQuest(String str, String str2, String str3, int i, boolean z, String str4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("quest_id", str);
            jSONObject.put("quest_type", str2);
            jSONObject.put("quest_name", str3);
            jSONObject.put("quest_no", i);
            jSONObject.put("is_success", Utils.getYesNoString(z));
            jSONObject.put("description", str4);
            AppLog.onEventV3(QUEST, jSONObject);
        } catch (JSONException e) {
            LoggerImpl.global().error(logTags, "onEventQuest failed", e, new Object[0]);
        }
    }

    public static void onEventUpdateLevel(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("level", i);
            AppLog.onEventV3(UPDATE_LEVEL, jSONObject);
        } catch (JSONException e) {
            LoggerImpl.global().error(logTags, "onEventUpdateLevel failed", e, new Object[0]);
        }
    }

    public static void onEventCreateGameRole(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("gamerole_id", str);
            AppLog.onEventV3(CREATE_GAMEROLE, jSONObject);
        } catch (JSONException e) {
            LoggerImpl.global().error(logTags, "onEventCreateGameRole failed", e, new Object[0]);
        }
    }

    public static void onEventCheckOut(String str, String str2, String str3, int i, boolean z, String str4, String str5, boolean z2, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("content_type", str);
            jSONObject.put("content_name", str2);
            jSONObject.put("content_id", str3);
            jSONObject.put("content_num", i);
            jSONObject.put("is_virtual_currency", Utils.getYesNoString(z));
            jSONObject.put("virtual_currency", str4);
            jSONObject.put("currency", str5);
            jSONObject.put("is_success", Utils.getYesNoString(z2));
            jSONObject.put("currency_amount", i2);
            AppLog.onEventV3(CHECK_OUT, jSONObject);
        } catch (JSONException e) {
            LoggerImpl.global().error(logTags, "onEventCheckOut failed", e, new Object[0]);
        }
    }

    public static void onEventAddToFavorite(String str, String str2, String str3, int i, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("content_type", str);
            jSONObject.put("content_name", str2);
            jSONObject.put("content_id", str3);
            jSONObject.put("content_num", i);
            jSONObject.put("is_success", Utils.getYesNoString(z));
            AppLog.onEventV3(ADD_TO_FAVORITE, jSONObject);
        } catch (JSONException e) {
            LoggerImpl.global().error(logTags, "onEventAddToFavorite failed", e, new Object[0]);
        }
    }

    public static void onEventAccessPaymentChannel(String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("payment_channel", str);
            jSONObject.put("is_success", Utils.getYesNoString(z));
            AppLog.onEventV3(ACCESS_PAYMENT_CHANNEL, jSONObject);
        } catch (JSONException e) {
            LoggerImpl.global().error(logTags, "onEventAccessPaymentChannel failed", e, new Object[0]);
        }
    }

    public static void onEventAddCart(String str, String str2, String str3, int i, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("content_type", str);
            jSONObject.put("content_name", str2);
            jSONObject.put("content_id", str3);
            jSONObject.put("content_num", i);
            jSONObject.put("is_success", Utils.getYesNoString(z));
            AppLog.onEventV3(ADD_CART, jSONObject);
        } catch (JSONException e) {
            LoggerImpl.global().error(logTags, "onEventAddCart failed", e, new Object[0]);
        }
    }

    public static void onEventViewContent(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("content_type", str);
            jSONObject.put("content_name", str2);
            jSONObject.put("content_id", str3);
            AppLog.onEventV3(VIEW_CONTENT, jSONObject);
        } catch (JSONException e) {
            LoggerImpl.global().error(logTags, "onEventViewContent failed", e, new Object[0]);
        }
    }
}
