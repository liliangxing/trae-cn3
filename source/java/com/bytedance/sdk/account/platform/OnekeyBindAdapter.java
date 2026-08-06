package com.bytedance.sdk.account.platform;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.account.api.IBDAccountAPIV3;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.impl.BDAccountAPIV3Impl;
import com.bytedance.sdk.account.mobile.query.OneBindMobileQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.OneBindMobileCallback;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class OnekeyBindAdapter extends OnekeyBaseAdapter implements IOnekeyBindAdapter {
    private OneBindMobileCallback mCallback;
    private Context mContext;
    private String mFrom;
    private String mProviderAppId;
    private String mToken;
    protected IBDAccountAPIV3 accountAPI = BDAccountAPIV3Impl.instance();
    private volatile boolean isCancel = false;
    private String mPassWord = "";
    private int mUnbindExits = 0;

    @Override // com.bytedance.sdk.account.platform.base.OneLoginCallback
    public JSONObject onSendEvent() {
        return null;
    }

    public OnekeyBindAdapter(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void setExtraParams(String str, int i, Map<String, String> map) {
        this.mPassWord = str;
        this.mUnbindExits = i;
        this.mExtendInfo = map;
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onSuccess(Bundle bundle) {
        if (this.isCancel) {
            return;
        }
        parseData(bundle);
        this.mCallback = new OneBindMobileCallback() { // from class: com.bytedance.sdk.account.platform.OnekeyBindAdapter.1
            @Override // com.bytedance.sdk.account.NeedCaptchaCallBack, com.bytedance.sdk.account.CommonCallBack
            public void onSuccess(MobileApiResponse<OneBindMobileQueryObj> mobileApiResponse) {
                OnekeyBindAdapter.this.onBindSuccess(mobileApiResponse);
            }

            @Override // com.bytedance.sdk.account.NeedCaptchaCallBack, com.bytedance.sdk.account.CommonCallBack
            public void onError(MobileApiResponse<OneBindMobileQueryObj> mobileApiResponse, int i) {
                OnekeyBindAdapter onekeyBindAdapter = OnekeyBindAdapter.this;
                onekeyBindAdapter.onBindError(onekeyBindAdapter.getBindErrorResponse(mobileApiResponse, onekeyBindAdapter.mFrom));
            }
        };
        if (this.mExtendInfo == null) {
            this.mExtendInfo = new HashMap();
        }
        this.mExtendInfo.put("provider_app_id", this.mProviderAppId);
        this.accountAPI.oneBindMobile(this.mToken, this.mFrom, this.mPassWord, this.mUnbindExits, this.mExtendInfo, this.mCallback);
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onError(AuthorizeErrorResponse authorizeErrorResponse) {
        if (this.isCancel) {
            return;
        }
        handleAuthorizeErrorResponse(authorizeErrorResponse);
        onBindError(authorizeErrorResponse);
    }

    public void cancel() {
        this.isCancel = true;
        OneBindMobileCallback oneBindMobileCallback = this.mCallback;
        if (oneBindMobileCallback != null) {
            oneBindMobileCallback.cancel();
        }
    }

    private void parseData(Bundle bundle) {
        this.mToken = bundle.getString("access_token");
        this.mFrom = bundle.getString(IOnekeyLoginService.ResponseConstants.CARRIER_FROM);
        this.mProviderAppId = bundle.getString("carrier_app_id");
    }

    protected String getProviderAppId() {
        return this.mProviderAppId;
    }

    protected String getToken() {
        return this.mToken;
    }

    protected String getFrom() {
        return this.mFrom;
    }
}
