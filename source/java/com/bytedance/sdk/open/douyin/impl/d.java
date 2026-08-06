package com.bytedance.sdk.open.douyin.impl;

import android.content.Context;
import com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.douyin.settings.a;

/* loaded from: classes5.dex */
public class d extends BaseCheckHelperImpl {
    public d(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean allowAuth() {
        return com.bytedance.sdk.open.douyin.settings.a.a(a.c.AUTH, a.b.DOUYIN_HOTSOON);
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean allowShare() {
        return com.bytedance.sdk.open.douyin.settings.a.a(a.c.SHARE, a.b.DOUYIN_HOTSOON);
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    protected int getAuthRequestApi() {
        return Integer.MAX_VALUE;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public String getPackageName() {
        return ParamKeyConstants.DOUYIN_HOTSOON_PACKAGE_NAME;
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean isSupportAuthSwitchAccount() {
        return isAppSupportAuthorization() && super.isSupportAuthSwitchAccount();
    }
}
