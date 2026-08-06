package com.bytedance.sdk.account.twiceverify;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.account.utils.ActivityStack;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class TwiceVerifyManager {
    private static final String TAG = "TwiceVerifyManager";
    private static IExternalDepend sExternalDepend;
    private static volatile TwiceVerifyManager sInstance;
    private JSONObject bizParams;
    private TwiceVerifyResultCallback callback;
    private JSONObject decisionData;
    private volatile boolean isStartVerifyFlow = false;

    private TwiceVerifyManager() {
    }

    public static TwiceVerifyManager getInstance() {
        if (sInstance == null) {
            synchronized (TwiceVerifyManager.class) {
                if (sInstance == null) {
                    sInstance = new TwiceVerifyManager();
                }
            }
        }
        return sInstance;
    }

    public void init() {
        init(null);
    }

    public void init(IExternalDepend iExternalDepend) {
        TwiceVerifyErrorHandler.register();
        sExternalDepend = iExternalDepend;
    }

    public boolean canHandle(int i, String str, String str2) {
        return canHandle(i, false, str, str2, null);
    }

    public boolean canHandle(int i, boolean z, String str, String str2, JSONObject jSONObject) {
        JSONObject parseData;
        boolean z2 = i == 2046 || i == 2139 || i == 2148 || i == 4023;
        if (z2) {
            parseData = parseData(str2, jSONObject);
        } else if (z || (!TextUtils.isEmpty(str) && str.startsWith("/passport/"))) {
            parseData = parseData(str2, jSONObject);
            z2 = parseData != null && "verify".equalsIgnoreCase(parseData.optString("account_flow", ""));
        } else {
            parseData = null;
        }
        if (z2) {
            return checkDecisionConfig(parseData);
        }
        return false;
    }

    private JSONObject parseData(String str, JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("data")) {
            return jSONObject.optJSONObject("data");
        }
        try {
            return new JSONObject(str).optJSONObject("data");
        } catch (Exception e) {
            TwiceVerifyLogHelper.m11e(TAG, "", e);
            return null;
        }
    }

    private boolean checkDecisionConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return (TextUtils.isEmpty(jSONObject.optString("schema")) || TextUtils.isEmpty(jSONObject.optString(IWeixinService.ResponseConstants.URL))) ? false : true;
    }

    public boolean startTwiceVerify(JSONObject jSONObject, TwiceVerifyResultCallback twiceVerifyResultCallback) {
        String optString;
        String optString2;
        JSONObject optJSONObject;
        TwiceVerifyLogHelper.m9d(TAG, "startTwiceVerify, isStartVerifyFlow = " + this.isStartVerifyFlow);
        if (!this.isStartVerifyFlow && jSONObject != null) {
            try {
                optString = jSONObject.optString("schema");
                optString2 = jSONObject.optString(IWeixinService.ResponseConstants.URL);
                optJSONObject = jSONObject.optJSONObject("biz_params");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                this.isStartVerifyFlow = true;
                this.decisionData = jSONObject;
                this.callback = twiceVerifyResultCallback;
                this.bizParams = optJSONObject;
                Activity validTopActivity = ActivityStack.getValidTopActivity();
                if (validTopActivity != null) {
                    boolean isFinishing = validTopActivity.isFinishing();
                    Context context = validTopActivity;
                    if (isFinishing) {
                        TwiceVerifyLogHelper.m9d(TAG, "startTwiceVerify, " + validTopActivity.getLocalClassName() + " is finish, use applicationContext");
                        context = validTopActivity.getApplicationContext();
                    }
                    TwiceVerifyActivity.startIntent(context, optString, optString2, jSONObject.toString());
                    return true;
                }
                TwiceVerifyLogHelper.m9d(TAG, "startTwiceVerify, activity is null");
                resetStatus();
            }
            TwiceVerifyLogHelper.m9d(TAG, "startTwiceVerify, schema or url is empty, return");
            return false;
        }
        return false;
    }

    public JSONObject getDecision() {
        JSONObject jSONObject;
        TwiceVerifyLogHelper.m9d(TAG, "getDecision, isStartVerifyFlow = " + this.isStartVerifyFlow);
        if (!this.isStartVerifyFlow || (jSONObject = this.decisionData) == null) {
            return null;
        }
        return jSONObject;
    }

    public void onTwiceVerifySuccess(String str, String str2, Map<String, Object> map, Map<String, Object> map2) {
        TwiceVerifyLogHelper.m9d(TAG, "onTwiceVerifySuccess, verifyWay=" + str);
        if (this.callback != null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = this.bizParams;
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next) && this.bizParams.opt(next) != null) {
                        hashMap.put(next, this.bizParams.opt(next).toString());
                    }
                }
            }
            if (map2 != null && !map2.isEmpty()) {
                for (Map.Entry<String, Object> entry : map2.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && value != null && !TextUtils.isEmpty(value.toString())) {
                        hashMap.put(entry.getKey(), value.toString());
                    }
                }
            }
            TwiceVerifyResultCallback twiceVerifyResultCallback = this.callback;
            resetStatus();
            twiceVerifyResultCallback.onSuccess(str, str2, hashMap, map);
        }
    }

    public void onTwiceVerifyError() {
        TwiceVerifyLogHelper.m9d(TAG, "onTwiceVerifyError");
        TwiceVerifyResultCallback twiceVerifyResultCallback = this.callback;
        resetStatus();
        if (twiceVerifyResultCallback != null) {
            twiceVerifyResultCallback.onFail();
        }
    }

    protected void resetStatus() {
        TwiceVerifyLogHelper.m9d(TAG, "resetStatus");
        this.isStartVerifyFlow = false;
        this.decisionData = null;
        this.callback = null;
        this.bizParams = null;
    }

    public static IExternalDepend getExternalDepend() {
        return sExternalDepend;
    }

    public static void setExternalDepend(IExternalDepend iExternalDepend) {
        sExternalDepend = iExternalDepend;
    }
}
