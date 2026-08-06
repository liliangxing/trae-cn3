package com.bytedance.sdk.account.response;

import com.bytedance.sdk.account.mobile.query.SendCodeQueryObj;

/* loaded from: classes5.dex */
public class SendCodeResponseData extends MobileResponseData {
    public String confirmSwitchBindTips;
    public String confirmSwitchBindUrl;
    public int resendTime;

    public SendCodeResponseData(SendCodeQueryObj sendCodeQueryObj) {
        super(sendCodeQueryObj);
        this.resendTime = sendCodeQueryObj.mResendTime;
        this.confirmSwitchBindTips = sendCodeQueryObj.mConfirmSwitchBindTips;
        this.confirmSwitchBindUrl = sendCodeQueryObj.mConfirmSwitchBindUrl;
    }

    @Override // com.bytedance.sdk.account.response.MobileResponseData
    public String toString() {
        return super.toString() + "\nSendCodeSdkResponse{resendTime=" + this.resendTime + ", confirmSwitchBindTips='" + this.confirmSwitchBindTips + "', confirmSwitchBindUrl='" + this.confirmSwitchBindUrl + "'}";
    }
}
