package com.bytedance.sdk.account.platform.google;

import android.content.Context;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.bytedance.sdk.account.platform.base.AuthorizeCreator;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.AuthorizeIniter;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class GoogleServiceIniter implements AuthorizeIniter<IGoogleService>, AuthorizeCreator<IGoogleService> {
    String appId;

    public GoogleServiceIniter(String str) {
        this.appId = str;
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCreator
    public IGoogleService createService(Context context) {
        return new GoogleServiceImpl(context, this.appId);
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeIniter
    public void init(Context context) {
        AuthorizeMonitorUtil.checkMonitorService();
        AuthorizeFramework.registerService(IGoogleService.class, new GoogleServiceImpl(context, this.appId));
    }
}
