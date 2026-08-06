package com.bytedance.sdk.account.platform.douyin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.sdk.account.platform.api.IDouYin2Service;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.model.BaseReq;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BaseDouyinEntryActivity extends Activity implements IApiEventHandler {
    @Override // com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler
    public void onReq(BaseReq baseReq) {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (((IDouYin2Service) AuthorizeFramework.getService(IDouYin2Service.class)) == null) {
            AuthorizeMonitorUtil.onPlatformAuthEvent("aweme", 0, "not init", "not init", false, null);
            finish();
        } else {
            DouYinOpenApiFactory.create(this).handleIntent(getIntent(), this);
        }
    }

    @Override // com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler
    public void onResp(BaseResp baseResp) {
        if (baseResp instanceof Authorization.Response) {
            Douyin.authorizeCallback((Authorization.Response) baseResp);
        }
        finish();
    }

    @Override // com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler
    public void onErrorIntent(Intent intent) {
        Douyin.authorizeCallback(null);
        finish();
    }
}
