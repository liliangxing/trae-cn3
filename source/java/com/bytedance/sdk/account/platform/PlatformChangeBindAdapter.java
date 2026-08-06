package com.bytedance.sdk.account.platform;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.ThirdPartyNetConstants;
import com.bytedance.sdk.account.api.AccountErrorCode;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.IPlatformBindAdapter;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class PlatformChangeBindAdapter extends BaseAccountAdapter implements IPlatformChangeBindAdapter {
    private ChangeBindCallback mChangeBindCallback;
    private Map<String, String> switchBindExtraParam;
    private boolean verifyTicket;
    private boolean verifyType;

    public PlatformChangeBindAdapter(Context context, String str, String str2) {
        super(context, str, str2);
    }

    public PlatformChangeBindAdapter setVerifyType(boolean z) {
        this.verifyType = z;
        return this;
    }

    public PlatformChangeBindAdapter setVerifyTicket(boolean z) {
        this.verifyTicket = z;
        return this;
    }

    public PlatformChangeBindAdapter setSwitchBindExtraParam(Map<String, String> map) {
        this.switchBindExtraParam = map;
        return this;
    }

    public void cancelChangeBind() {
        ChangeBindCallback changeBindCallback = this.mChangeBindCallback;
        if (changeBindCallback != null) {
            changeBindCallback.cancel();
            this.mChangeBindCallback = null;
        }
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onSuccess(Bundle bundle) {
        AccountMonitorUtil.platformAuthEvent(this.platform, "bind", 1, null, null, false, null);
        if (bundle == null) {
            onChangeBindError(getFailedParseDataResponse());
            return;
        }
        String string = bundle.getString("auth_code");
        String string2 = bundle.getString("access_token");
        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
            onChangeBindError(getFailedParseDataResponse());
        } else {
            this.mChangeBindCallback = new ChangeBindCallback();
            this.api.authChangeBindWithAuthCodeOrAccessToken(this.platform, this.platformId, string, string2, this.verifyType, this.verifyTicket, this.mExtendParam, this.mChangeBindCallback);
        }
    }

    private UserApiResponse getFailedParseDataResponse() {
        UserApiResponse userApiResponse = new UserApiResponse(false, ThirdPartyNetConstants.API_AUTH_CHANGE_BIND);
        userApiResponse.error = AccountErrorCode.CommonError.COMMON_ERROR_PARSE_DATA_ERROR;
        userApiResponse.mDetailErrorMsg = "fail to parse data auth_code or access_token";
        return userApiResponse;
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onError(AuthorizeErrorResponse authorizeErrorResponse) {
        AccountMonitorUtil.platformAuthEvent(this.platform, AccountMonitorConstants.Scene.SCENE_AUTH_CHANGE_BIND, 0, authorizeErrorResponse.platformErrorCode, authorizeErrorResponse.platformErrorMsg, authorizeErrorResponse.isCancel, null);
        onChangeBindError(getErrorResponse(authorizeErrorResponse));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class ChangeBindCallback extends CommonCallBack<UserApiResponse> {
        private ChangeBindCallback() {
        }

        @Override // com.bytedance.sdk.account.CommonCallBack
        public void onSuccess(UserApiResponse userApiResponse) {
            PlatformChangeBindAdapter.this.onChangeBindSuccess(userApiResponse);
        }

        @Override // com.bytedance.sdk.account.CommonCallBack
        public void onError(final UserApiResponse userApiResponse, int i) {
            if (userApiResponse.error == 1030 && !TextUtils.isEmpty(userApiResponse.authToken)) {
                PlatformChangeBindAdapter.this.onBindExist(userApiResponse, userApiResponse.errorTip, userApiResponse.confirmTip, userApiResponse.authToken, new IPlatformBindAdapter.BindController() { // from class: com.bytedance.sdk.account.platform.PlatformChangeBindAdapter.ChangeBindCallback.1
                    @Override // com.bytedance.sdk.account.platform.IPlatformBindAdapter.BindController
                    public void doNext() {
                        PlatformChangeBindAdapter.this.api.ssoSwitchBindWithAuthToken(PlatformChangeBindAdapter.this.platformId, PlatformChangeBindAdapter.this.platform, userApiResponse.authToken, 0L, null, PlatformChangeBindAdapter.this.switchBindExtraParam, new CommonCallBack<UserApiResponse>() { // from class: com.bytedance.sdk.account.platform.PlatformChangeBindAdapter.ChangeBindCallback.1.1
                            @Override // com.bytedance.sdk.account.CommonCallBack
                            public void onSuccess(UserApiResponse userApiResponse2) {
                                PlatformChangeBindAdapter.this.onChangeBindSuccess(userApiResponse2);
                            }

                            @Override // com.bytedance.sdk.account.CommonCallBack
                            public void onError(UserApiResponse userApiResponse2, int i2) {
                                PlatformChangeBindAdapter.this.onChangeBindError(userApiResponse2);
                            }
                        });
                    }
                });
            } else {
                PlatformChangeBindAdapter.this.onChangeBindError(userApiResponse);
            }
        }
    }
}
