package com.bytedance.sdk.account.platform;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.IPlatformBindAdapter;
import com.bytedance.sdk.account.platform.PlatformDelegate;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.ss.android.account.UserBindCallback;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class PlatformBindAdapter extends BaseAccountAdapter implements IPlatformBindAdapter {
    private Map<String, String> changeBindExtraParam;
    boolean isBindPlatformAndThirdMobileMode;
    private PlatformDelegate mBindDelegate;
    private Map<String, String> switchBindExtraParam;
    private boolean verifyTicket;
    private boolean verifyType;

    public PlatformBindAdapter setVerifyType(boolean z) {
        this.verifyType = z;
        return this;
    }

    public PlatformBindAdapter setVerifyTicket(boolean z) {
        this.verifyTicket = z;
        return this;
    }

    public PlatformBindAdapter setChangeBindExtraParam(Map<String, String> map) {
        this.changeBindExtraParam = map;
        return this;
    }

    public PlatformBindAdapter setSwitchBindExtraParam(Map<String, String> map) {
        this.switchBindExtraParam = map;
        return this;
    }

    public PlatformBindAdapter(Context context, String str, String str2) {
        super(context, str, str2);
        this.verifyType = false;
        this.verifyTicket = false;
        this.isBindPlatformAndThirdMobileMode = false;
    }

    public PlatformBindAdapter(Context context, String str, String str2, Map<String, String> map) {
        this(context, str, str2);
        this.mExtendParam = map;
    }

    public PlatformBindAdapter(Context context, String str, String str2, boolean z) {
        super(context, str, str2);
        this.verifyType = false;
        this.verifyTicket = false;
        this.isBindPlatformAndThirdMobileMode = z;
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onSuccess(Bundle bundle) {
        AccountMonitorUtil.platformAuthEvent(this.platform, "bind", 1, null, null, false, null);
        PlatformDelegate.IFactory iFactory = delegateMap.get(this.platform);
        if (iFactory != null) {
            PlatformDelegate createBind = iFactory.createBind(this);
            this.mBindDelegate = createBind;
            createBind.requestBind(bundle);
        }
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onError(AuthorizeErrorResponse authorizeErrorResponse) {
        AccountMonitorUtil.platformAuthEvent(this.platform, "bind", 0, authorizeErrorResponse.platformErrorCode, authorizeErrorResponse.platformErrorMsg, authorizeErrorResponse.isCancel, null);
        onBindError(getErrorResponse(authorizeErrorResponse));
    }

    public void cancelBind() {
        PlatformDelegate platformDelegate = this.mBindDelegate;
        if (platformDelegate != null) {
            platformDelegate.cancelBind();
            this.mBindDelegate = null;
        }
    }

    public PlatformBindAdapter setBindPlatformAndThirdMobileMode(boolean z) {
        this.isBindPlatformAndThirdMobileMode = z;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class BindCallback extends UserBindCallback {
        /* JADX INFO: Access modifiers changed from: package-private */
        public BindCallback() {
        }

        public void onBindExist(final UserApiResponse userApiResponse, String str, String str2, final String str3) {
            PlatformBindAdapter.this.onBindExist(userApiResponse, str, str2, str3, new IPlatformBindAdapter.BindController() { // from class: com.bytedance.sdk.account.platform.PlatformBindAdapter.BindCallback.1
                @Override // com.bytedance.sdk.account.platform.IPlatformBindAdapter.BindController
                public void doNext() {
                    CommonCallBack<UserApiResponse> commonCallBack = new CommonCallBack<UserApiResponse>() { // from class: com.bytedance.sdk.account.platform.PlatformBindAdapter.BindCallback.1.1
                        @Override // com.bytedance.sdk.account.CommonCallBack
                        public void onSuccess(UserApiResponse userApiResponse2) {
                            PlatformBindAdapter.this.onBindSuccess(userApiResponse2);
                        }

                        @Override // com.bytedance.sdk.account.CommonCallBack
                        public void onError(UserApiResponse userApiResponse2, int i) {
                            PlatformBindAdapter.this.onBindError(userApiResponse2);
                        }
                    };
                    if (userApiResponse.error == 1030) {
                        PlatformBindAdapter.this.api.ssoSwitchBindWithAuthToken(PlatformBindAdapter.this.platformId, PlatformBindAdapter.this.platform, str3, 0L, null, PlatformBindAdapter.this.switchBindExtraParam, commonCallBack);
                    } else if (userApiResponse.error == 1041) {
                        PlatformBindAdapter.this.api.authChangeBind(PlatformBindAdapter.this.platform, PlatformBindAdapter.this.platformId, str3, null, PlatformBindAdapter.this.verifyType, PlatformBindAdapter.this.verifyTicket, PlatformBindAdapter.this.changeBindExtraParam, commonCallBack);
                    }
                }
            });
        }

        public void onBindError(UserApiResponse userApiResponse) {
            PlatformBindAdapter.this.onBindError(userApiResponse);
        }

        public void onBindSuccess(UserApiResponse userApiResponse) {
            PlatformBindAdapter.this.onBindSuccess(userApiResponse);
        }
    }
}
