package com.bytedance.lynx.scc.cloudservice;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.lynx.scc.cloudservice.network.UrlResponse;
import com.bytedance.lynx.scc.cloudservice.utils.Logger;
import com.bytedance.lynx.scc.cloudservice.utils.SccUtils;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class SccResult {
    public static final int CODE_ERROR = -1;
    public static final int CODE_SUCCESS = 0;
    public static final String LABEL_ALLOW = "allow";
    public static final String LABEL_BLACK = "black";
    public static final String LABEL_DENY = "deny";
    public static final String LABEL_GRAY = "gray";
    public static final String LABEL_NOTICE = "notice";
    public static final String LABEL_WHITE = "white";
    public static final String MESSAGE_FAIL = "fail";
    public static final String MESSAGE_OK = "ok";
    private String mBlockStyle;
    private String mClientLogId;
    private String mClientReason;
    private int mCode;
    private String mLabel;
    private String mMessage;
    private JSONObject mOriginJsonResponse;
    private int mPassedTime;
    private int mScore;
    private boolean mShowingBlankPage;

    public SccResult(JSONObject json) {
        this.mOriginJsonResponse = json;
        if (json != null) {
            this.mCode = json.optInt("code", -1);
            this.mMessage = json.optString("message", "fail");
            this.mClientReason = json.optString(SccUtils.CLIENT_REASON, "");
            this.mPassedTime = json.optInt(SccUtils.REPORT_PASSED_TIME, -1);
            this.mClientLogId = json.optString("scc_logid", "");
            JSONObject optJSONObject = json.optJSONObject("data");
            boolean z = false;
            if (optJSONObject != null) {
                this.mLabel = optJSONObject.optString("label", LABEL_NOTICE);
                this.mScore = optJSONObject.optInt(StrategyConstants.SCORE, 0);
                this.mBlockStyle = optJSONObject.optString("block_style", "");
            } else {
                this.mLabel = LABEL_ALLOW;
                this.mScore = 0;
                this.mBlockStyle = "";
            }
            if (isDeny() && (TextUtils.isEmpty(this.mBlockStyle) || this.mBlockStyle.equals("forbid"))) {
                z = true;
            }
            this.mShowingBlankPage = z;
        }
    }

    public SccResult(int mCode, String mMessage, String mLabel, String mClientReason, String mClientLogId, JSONObject mOriginJsonResponse) {
        this.mCode = mCode;
        this.mMessage = mMessage;
        this.mLabel = mLabel;
        this.mClientReason = mClientReason;
        this.mClientLogId = mClientLogId;
        this.mOriginJsonResponse = mOriginJsonResponse;
    }

    public boolean isDeny() {
        return LABEL_DENY.equals(this.mLabel) || "black".equals(this.mLabel);
    }

    public boolean isNotice() {
        return LABEL_GRAY.equals(this.mLabel) || LABEL_NOTICE.equals(this.mLabel);
    }

    public boolean isAllow() {
        return LABEL_ALLOW.equals(this.mLabel) || "white".equals(this.mLabel);
    }

    public int getCode() {
        return this.mCode;
    }

    public void setCode(int mCode) {
        this.mCode = mCode;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public void setMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public void setLabel(String mLabel) {
        this.mLabel = mLabel;
    }

    public String getClientReason() {
        return this.mClientReason;
    }

    public void setClientReason(String mClientReason) {
        this.mClientReason = mClientReason;
    }

    public String getClientLogId() {
        return this.mClientLogId;
    }

    public void setClientLogId(String mClientLogId) {
        this.mClientLogId = mClientLogId;
    }

    public int getScore() {
        return this.mScore;
    }

    public void setScore(int mScore) {
        this.mScore = mScore;
    }

    public String getBlockStyle() {
        return this.mBlockStyle;
    }

    public void setBlockStyle(String mBlockStyle) {
        this.mBlockStyle = mBlockStyle;
    }

    public boolean isShowingBlankPage() {
        return this.mShowingBlankPage;
    }

    public void setShowingBlankPage(boolean mShowingBlankPage) {
        this.mShowingBlankPage = mShowingBlankPage;
    }

    public int getPassedTime() {
        return this.mPassedTime;
    }

    public void setPassedTime(int mPassedTime) {
        this.mPassedTime = mPassedTime;
    }

    public JSONObject getOriginJsonResponse() {
        return this.mOriginJsonResponse;
    }

    public void setOriginJsonResponse(JSONObject mOriginJsonResponse) {
        this.mOriginJsonResponse = mOriginJsonResponse;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.mCode);
            jSONObject.put("message", this.mMessage);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("label", this.mLabel);
            jSONObject.put("data", jSONObject2);
            jSONObject.put(SccUtils.CLIENT_REASON, this.mClientReason);
            jSONObject.put("scc_logid", this.mClientLogId);
        } catch (JSONException e) {
            Log.e("SccResult", "toJson error:" + e.toString());
        }
        return jSONObject;
    }

    public String toString() {
        return "SccResult{mCode=" + this.mCode + ", mMessage='" + this.mMessage + "', mLabel='" + this.mLabel + "', mClientReason='" + this.mClientReason + "', mClientLogId='" + this.mClientLogId + "', mScore=" + this.mScore + ", mBlockStyle='" + this.mBlockStyle + "', mShowingBlankPage=" + this.mShowingBlankPage + ", mPassedTime=" + this.mPassedTime + ", mOriginJsonResponse=" + this.mOriginJsonResponse + AbstractJsonLexerKt.END_OBJ;
    }

    public static SccResult fromUrlResponse(UrlResponse response) {
        SccResult sccResult;
        SccResult sccResult2 = null;
        if (response == null || response.getOriginalData() == null) {
            return null;
        }
        try {
            sccResult = new SccResult(new JSONObject(new String(response.getOriginalData())));
        } catch (Exception e) {
            e = e;
        }
        try {
            sccResult.setClientReason(SccUtils.CLOUD_SERVICE_RES);
            String headerValue = SccUtils.getHeaderValue(response, "X-Tt-Logid", "x-tt-logid");
            if (headerValue == null) {
                headerValue = "";
            }
            sccResult.setClientLogId(headerValue);
            return sccResult;
        } catch (Exception e2) {
            e = e2;
            sccResult2 = sccResult;
            Logger.e(e.toString());
            return sccResult2;
        }
    }
}
