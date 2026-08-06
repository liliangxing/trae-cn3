package com.bytedance.sdk.account.response;

import com.bytedance.sdk.account.AccountSdkResponseData;
import com.bytedance.sdk.account.mobile.query.MobileQueryObj;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class MobileResponseData extends AccountSdkResponseData {
    public long cancelApplyTime;
    public String cancelAvatarUrl;
    public String cancelNickName;
    public long cancelTime;
    public String cancelToken;
    public String errorAlert;
    public String errorCaptcha;
    public JSONObject jsonResult;

    public MobileResponseData(MobileQueryObj mobileQueryObj) {
        this.errorCaptcha = mobileQueryObj.mErrorCaptcha;
        this.errorAlert = mobileQueryObj.mErrorAlert;
        this.jsonResult = mobileQueryObj.jsonResult;
        this.cancelToken = mobileQueryObj.mCancelToken;
        this.cancelApplyTime = mobileQueryObj.mCancelApplyTime;
        this.cancelTime = mobileQueryObj.mCancelTime;
        this.cancelNickName = mobileQueryObj.mCancelNickName;
        this.cancelAvatarUrl = mobileQueryObj.mCancelAvatarUrl;
    }

    public String toString() {
        return "MobileSdkResponse{errorCaptcha='" + this.errorCaptcha + "', errorAlert='" + this.errorAlert + "', jsonResult=" + this.jsonResult + ", cancelToken='" + this.cancelToken + "', cancelApplyTime=" + this.cancelApplyTime + ", cancelTime=" + this.cancelTime + ", cancelNickName='" + this.cancelNickName + "', cancelAvatarUrl='" + this.cancelAvatarUrl + "'}";
    }
}
