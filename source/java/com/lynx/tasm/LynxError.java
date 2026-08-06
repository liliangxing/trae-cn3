package com.lynx.tasm;

import android.text.TextUtils;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxSubErrorCode;
import com.lynx.tasm.base.LLog;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class LynxError extends LynxErrorCodeLegacy {
    public static final int JAVA_ERROR = -3;
    public static final int JS_ERROR = -2;
    public static final String LEVEL_ERROR = "error";
    public static final String LEVEL_WARN = "warn";
    static final String LYNX_ERROR_KEY_CONTEXT = "context";
    public static final String LYNX_ERROR_KEY_IMAGE_CATEGORIZED_CODE = "image_categorized_code";
    static final String LYNX_ERROR_KEY_PREFIX_CONTEXT = "lynx_context_";
    public static final String LYNX_ERROR_KEY_RESOURCE_TYPE = "type";
    public static final String LYNX_ERROR_KEY_RESOURCE_URL = "src";
    public static final String LYNX_ERROR_SUGGESTION_REF_OFFICIAL_SITE = "Please refer to the solution in Doc 'LynxError FAQ' on the official website.";
    public static final String LYNX_THROWABLE = "throwable";
    public static final int NATIVE_ERROR = -1;
    private static final String TAG = "LynxError";

    @Deprecated
    private JSONObject errorObj;
    private String mCallStack;
    private String mCardVersion;
    private List<LynxSubErrorCode.Consumer> mConsumers;
    private Map<String, Object> mCustomInfo;
    private int mErrorType;
    private String mFixSuggestion;
    private boolean mIsLogBoxOnly;
    private boolean mIsNewErrorCode;
    private String mJsonStringCache;
    private String mLevel;
    private String mRootCause;
    private int mSubCode;
    private String mSummaryMessage;
    private String mTemplateUrl;
    private JSONObject mUserDefineInfo;

    @Deprecated
    private String msg;

    @Deprecated
    public LynxError(String str, int i) {
        this.mIsLogBoxOnly = false;
        this.mIsNewErrorCode = false;
        this.mSubCode = i;
        this.msg = str;
    }

    public LynxError(int i, String str) {
        this(i, str, "", LynxSubErrorCode.Level.ERROR.value);
    }

    public LynxError(int i, String str, String str2, String str3) {
        this(i, str, str2, str3, -3);
    }

    public LynxError(int i, String str, String str2, String str3, int i2) {
        this(i, str, str2, str3, i2, null);
    }

    LynxError(int i, String str, String str2, String str3, int i2, Map<String, Object> map) {
        this(i, str, str2, str3, i2, map, false);
    }

    LynxError(int i, String str, String str2, String str3, int i2, Map<String, Object> map, boolean z) {
        this.mIsNewErrorCode = false;
        this.msg = "";
        this.mSubCode = i;
        this.mSummaryMessage = str;
        this.mErrorType = i2;
        this.mCustomInfo = map;
        this.mIsLogBoxOnly = z;
        LynxSubErrorCode.MetaData metaData = LynxSubErrorCode.getMetaData(i);
        if (metaData != null) {
            this.mLevel = metaData.mLevel != LynxSubErrorCode.Level.UNDECIDED ? metaData.mLevel.value : str3;
            this.mFixSuggestion = metaData.mFixSuggestion.isEmpty() ? str2 : metaData.mFixSuggestion;
            this.mConsumers = metaData.mConsumer;
            this.mIsNewErrorCode = true;
            return;
        }
        this.mLevel = str3;
        this.mFixSuggestion = str2;
        this.mConsumers = Collections.emptyList();
    }

    public void addCustomInfo(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mJsonStringCache = null;
        if (this.mCustomInfo == null) {
            this.mCustomInfo = new HashMap();
        }
        this.mCustomInfo.put(str, str2);
    }

    public void setCustomInfo(Map<String, Object> map) {
        this.mJsonStringCache = null;
        this.mCustomInfo = map;
    }

    public boolean containsCustomField(String str) {
        if (this.mCustomInfo == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return this.mCustomInfo.containsKey(str);
    }

    public void setTemplateUrl(String str) {
        this.mJsonStringCache = null;
        this.mTemplateUrl = str;
    }

    public void setCardVersion(String str) {
        this.mJsonStringCache = null;
        this.mCardVersion = str;
    }

    public void setCallStack(String str) {
        this.mJsonStringCache = null;
        this.mCallStack = str;
    }

    public void setRootCause(String str) {
        this.mJsonStringCache = null;
        this.mRootCause = str;
    }

    public String getRootCause() {
        String str = this.mRootCause;
        return str == null ? "" : str;
    }

    public void setUserDefineInfo(JSONObject jSONObject) {
        this.mJsonStringCache = null;
        this.mUserDefineInfo = jSONObject;
    }

    public String getSummaryMessage() {
        String str = this.mSummaryMessage;
        return str == null ? "" : str;
    }

    public String getLevel() {
        return this.mLevel;
    }

    public int getErrorCode() {
        if (this.mIsNewErrorCode) {
            return this.mSubCode / 100;
        }
        return this.mSubCode;
    }

    public int getSubCode() {
        return this.mSubCode;
    }

    public String getFixSuggestion() {
        String str = this.mFixSuggestion;
        return str == null ? "" : str;
    }

    public int getType() {
        return this.mErrorType;
    }

    public Map<String, String> getContextInfo() {
        HashMap hashMap = new HashMap();
        Map<String, Object> map = this.mCustomInfo;
        if (map == null) {
            return hashMap;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith(LYNX_ERROR_KEY_PREFIX_CONTEXT)) {
                hashMap.put(key.substring(13), entry.getValue().toString());
            } else if (key.equals("src")) {
                hashMap.put(key, entry.getValue().toString());
            }
        }
        return hashMap;
    }

    public String getMsg() {
        if (!TextUtils.isEmpty(this.mJsonStringCache)) {
            return this.mJsonStringCache;
        }
        if (!TextUtils.isEmpty(this.mSummaryMessage)) {
            this.mJsonStringCache = generateJsonString();
        } else {
            JSONObject jSONObject = this.errorObj;
            if (jSONObject != null) {
                this.mJsonStringCache = jSONObject.toString();
            } else {
                String str = this.msg;
                if (str != null) {
                    this.mJsonStringCache = str;
                }
            }
        }
        String str2 = this.mJsonStringCache;
        return str2 == null ? "" : str2;
    }

    @Deprecated
    public JSONObject getErrorObj() {
        return this.errorObj;
    }

    static void putStringToJsonObject(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (jSONObject == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    static void putMapValueToJsonObject(JSONObject jSONObject, Map<String, Object> map) throws JSONException {
        if (map == null || map.isEmpty() || jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getKey().startsWith(LYNX_ERROR_KEY_PREFIX_CONTEXT)) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            } else {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        }
        if (jSONObject2.length() > 0) {
            jSONObject.put("context", jSONObject2);
        }
    }

    private String generateJsonString() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error_code", getErrorCode());
            jSONObject.put("sub_code", this.mSubCode);
            putStringToJsonObject(jSONObject, "url", this.mTemplateUrl);
            putStringToJsonObject(jSONObject, "error", this.mSummaryMessage);
            putStringToJsonObject(jSONObject, "card_version", this.mCardVersion);
            putStringToJsonObject(jSONObject, MonitorConstants.MONITOR_FROM_SDK, LynxEnv.inst().getLynxVersion());
            putStringToJsonObject(jSONObject, "level", this.mLevel);
            jSONObject.put("consumers", new JSONArray((Collection) this.mConsumers));
            putStringToJsonObject(jSONObject, "fix_suggestion", this.mFixSuggestion);
            putStringToJsonObject(jSONObject, com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_ERROR_STACK, this.mCallStack);
            putStringToJsonObject(jSONObject, "root_cause", this.mRootCause);
            putMapValueToJsonObject(jSONObject, this.mCustomInfo);
            JSONObject jSONObject2 = this.mUserDefineInfo;
            if (jSONObject2 != null && jSONObject2.length() > 0) {
                jSONObject.put("user_define_info", this.mUserDefineInfo);
            }
            str = jSONObject.toString();
        } catch (JSONException e) {
            LLog.e(TAG, e.getMessage());
            str = null;
        }
        return str == null ? "" : str;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.msg) && this.errorObj == null && TextUtils.isEmpty(this.mSummaryMessage)) ? false : true;
    }

    public boolean isFatal() {
        return this.mLevel == LynxSubErrorCode.Level.FATAL.value;
    }

    public boolean isJSError() {
        int errorCode = getErrorCode();
        return errorCode >= 200 && errorCode < 300;
    }

    public boolean isLepusError() {
        int errorCode = getErrorCode();
        return errorCode >= 1100 && errorCode < 1200;
    }

    public void setLogBoxOnly(boolean z) {
        this.mIsLogBoxOnly = z;
    }

    public boolean isLogBoxOnly() {
        return this.mIsLogBoxOnly;
    }

    public String toString() {
        return "{\"code\": " + getErrorCode() + ",\"msg\":" + getMsg() + "}";
    }

    private static LynxError createLynxError(int i, String str, String str2, String str3, JavaOnlyMap javaOnlyMap, boolean z) {
        return new LynxError(i, str, str2, str3, -1, javaOnlyMap, z);
    }
}
