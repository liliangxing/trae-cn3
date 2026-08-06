package com.bytedance.crash.upload;

import android.text.TextUtils;
import com.bytedance.apm.constant.ReportConsts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Response {
    private int mErrorCode;
    private Map<String, List<String>> mHeaders;
    private String mMessage;
    private int mServerErrorCode;
    private JSONObject mServerJson;
    private byte[] sourceData;

    public Response(int i) {
        this.mErrorCode = i;
    }

    public Response(int i, byte[] bArr) {
        this.mErrorCode = i;
        this.sourceData = bArr;
    }

    public Response(int i, Throwable th) {
        this.mErrorCode = i;
        if (th != null) {
            this.mMessage = th.getMessage();
        }
    }

    public Response(int i, String str) {
        this.mErrorCode = i;
        this.mMessage = str;
    }

    public Response(int i, JSONObject jSONObject) {
        this.mErrorCode = i;
        this.mServerJson = jSONObject;
    }

    public boolean isSuccess() {
        int i = this.mErrorCode;
        return (i == 207 || i == 214) ? false : true;
    }

    public boolean isDrop() {
        return this.mErrorCode == 213;
    }

    public boolean isStateOk() {
        JSONObject jSONObject = this.mServerJson;
        return jSONObject != null && jSONObject.optInt("state") == 0;
    }

    public byte[] getData() {
        return this.sourceData;
    }

    public void setData(byte[] bArr) {
        this.sourceData = bArr;
    }

    public void setErrCode(int i) {
        this.mErrorCode = i;
    }

    public JSONObject getServerJson() {
        return this.mServerJson;
    }

    public void setServerJson(JSONObject jSONObject) {
        this.mServerJson = jSONObject;
        try {
            String str = "";
            if (this.mHeaders != null) {
                new ArrayList();
                Iterator<Map.Entry<String, List<String>>> it = this.mHeaders.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, List<String>> next = it.next();
                    if ("Alog_quota".equalsIgnoreCase(next.getKey())) {
                        List<String> value = next.getValue();
                        if (value.size() > 0) {
                            str = value.get(0);
                            break;
                        }
                    }
                }
            }
            this.mServerJson.putOpt("Alog_quota", str);
            String optString = this.mServerJson.optString("message");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            if (optString.equals(ReportConsts.RESPONSE_MESSAGE_DROP_ALL_DATA) || optString.equals(ReportConsts.RESPONSE_MESSAGE_DROP_DATA)) {
                setErrCode(213);
            }
        } catch (Throwable unused) {
        }
    }

    public void setServerErrorCode(int i) {
        this.mServerErrorCode = i;
    }

    public int errorCode() {
        return this.mErrorCode;
    }

    public int serverErrorCode() {
        return this.mServerErrorCode;
    }

    public String errorInfo() {
        return this.mMessage;
    }

    public void setErrorInfo(String str) {
        this.mMessage = str;
    }

    public void setHeaders(Map<String, List<String>> map) {
        this.mHeaders = map;
    }

    public String toString() {
        String str = "Response:mErrorCode=" + this.mErrorCode + ", mServerErrorCode=" + this.mServerErrorCode;
        return this.mServerJson != null ? str + ", mServerJson=" + this.mServerJson.toString() : str;
    }
}
