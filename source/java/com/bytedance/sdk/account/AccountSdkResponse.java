package com.bytedance.sdk.account;

import com.bytedance.sdk.account.AccountSdkResponseData;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class AccountSdkResponse<D extends AccountSdkResponseData> {
    public int api;
    public D data;
    public int detailErrorCode;
    public String detailErrorMessage;
    public int errorCode;
    public String errorMessage;
    public boolean isSuccess;
    public String logId;
    public String requestUrl;
    public JSONObject result;

    public AccountSdkResponse(BaseApiResponse baseApiResponse, D d) {
        this.api = baseApiResponse.api;
        this.logId = baseApiResponse.logId;
        this.requestUrl = baseApiResponse.mRequestUrl;
        this.isSuccess = baseApiResponse.success;
        this.errorCode = baseApiResponse.error;
        this.detailErrorCode = baseApiResponse.mDetailErrorCode;
        this.errorMessage = baseApiResponse.errorMsg;
        this.detailErrorMessage = baseApiResponse.mDetailErrorMsg;
        this.result = baseApiResponse.result;
        this.data = d;
    }

    public String toString() {
        return "AccountSdkResponse{api=" + this.api + ", logId='" + this.logId + "', requestUrl='" + this.requestUrl + "', isSuccess=" + this.isSuccess + ", errorCode=" + this.errorCode + ", detailErrorCode=" + this.detailErrorCode + ", errorMessage='" + this.errorMessage + "', detailErrorMessage='" + this.detailErrorMessage + "', result=" + this.result + ", data=" + this.data + AbstractJsonLexerKt.END_OBJ;
    }
}
