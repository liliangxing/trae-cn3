package com.bytedance.sdk.account.platform.douyin;

import android.content.Context;
import com.bytedance.sdk.account.platform.api.IDouYin2Service;
import com.bytedance.sdk.account.platform.base.AuthorizeCreator;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.AuthorizeIniter;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class DouYinServiceIniter implements AuthorizeIniter<IDouYin2Service>, AuthorizeCreator<IDouYin2Service> {
    private String clientKey;

    public DouYinServiceIniter(String str) {
        this.clientKey = str;
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCreator
    public IDouYin2Service createService(Context context) {
        return new DouYin2ServiceImpl(this.clientKey);
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeIniter
    public void init(Context context) {
        AuthorizeMonitorUtil.checkMonitorService();
        AuthorizeFramework.registerService(IDouYin2Service.class, new DouYin2ServiceImpl(this.clientKey));
    }
}
