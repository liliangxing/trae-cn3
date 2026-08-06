package com.bytedance.sdk.account.platform.onekey;

import android.content.Context;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.AuthorizeIniter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class OnekeyLoginServiceIniter implements AuthorizeIniter<IOnekeyLoginService> {
    private final OnekeyLoginConfig mConfig;

    public OnekeyLoginServiceIniter(OnekeyLoginConfig onekeyLoginConfig) {
        this.mConfig = onekeyLoginConfig;
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeIniter
    public void init(Context context) {
        AuthorizeFramework.registerService(IOnekeyLoginService.class, new OnekeyLoginServiceImpl(context, this.mConfig));
    }
}
