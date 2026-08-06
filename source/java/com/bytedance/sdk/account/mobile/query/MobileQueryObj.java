package com.bytedance.sdk.account.mobile.query;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public abstract class MobileQueryObj {
    public JSONObject jsonResult;
    public long mCancelApplyTime;
    public String mCancelAvatarUrl;
    public String mCancelNickName;
    public long mCancelTime;
    public String mCancelToken;
    public int mDetailErrorCode;
    public int mError;
    public String mErrorAlert;
    public String mErrorCaptcha;
    public String mErrorMsg;
    public int mScenario;

    public MobileQueryObj() {
    }

    public MobileQueryObj(int i) {
        this.mScenario = i;
    }

    public boolean isNeedShowCaptcha() {
        int i = this.mError;
        return i > 1100 && i < 1199;
    }

    public boolean isNeedShowPicCaptcha() {
        int i = this.mError;
        return (i == 1101 || i == 1102 || i == 1103) && !TextUtils.isEmpty(this.mErrorCaptcha);
    }

    public boolean isNeedShowSecureCaptcha() {
        int i = this.mError;
        return i == 1104 || i == 1105;
    }
}
