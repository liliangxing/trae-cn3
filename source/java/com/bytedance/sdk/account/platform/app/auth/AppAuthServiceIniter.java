package com.bytedance.sdk.account.platform.app.auth;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.IAppAuthService;
import com.bytedance.sdk.account.platform.base.AuthorizeCreator;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.AuthorizeIniter;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class AppAuthServiceIniter implements AuthorizeIniter<IAppAuthService>, AuthorizeCreator<IAppAuthService> {
    private String authEndPoint;
    private String clientId;
    private String issuerUrl;
    private String tokenEndPoint;

    public AppAuthServiceIniter(String str, String str2, String str3) {
        this.authEndPoint = str;
        this.tokenEndPoint = str2;
        this.clientId = str3;
    }

    public AppAuthServiceIniter(String str, String str2) {
        this.issuerUrl = str;
        this.clientId = str2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCreator
    public IAppAuthService createService(Context context) {
        return getService(context);
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeIniter
    public void init(Context context) {
        AuthorizeMonitorUtil.checkMonitorService();
        AuthorizeFramework.registerService(IAppAuthService.class, getService(context));
    }

    private IAppAuthService getService(Context context) {
        if (context == null) {
            return null;
        }
        if (!TextUtils.isEmpty(this.authEndPoint) && !TextUtils.isEmpty(this.tokenEndPoint)) {
            return new AppAuthServiceImpl(this.authEndPoint, this.tokenEndPoint, this.clientId);
        }
        return new AppAuthServiceImpl(this.issuerUrl, this.clientId);
    }
}
