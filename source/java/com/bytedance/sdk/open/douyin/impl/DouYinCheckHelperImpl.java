package com.bytedance.sdk.open.douyin.impl;

import android.content.Context;
import com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.douyin.settings.a;

/* loaded from: classes5.dex */
public class DouYinCheckHelperImpl extends BaseCheckHelperImpl {
    public DouYinCheckHelperImpl(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean allowAuth() {
        return com.bytedance.sdk.open.douyin.settings.a.a(a.c.AUTH, a.b.DOUYIN);
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean allowShare() {
        return com.bytedance.sdk.open.douyin.settings.a.a(a.c.SHARE, a.b.DOUYIN);
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    protected int getAuthRequestApi() {
        return 1;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public String getPackageName() {
        return ParamKeyConstants.DOUYIN_PACKAGE_NAME;
    }

    public int getVerifyRequestApi() {
        return 6;
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean isShareSupportFileProvider() {
        return allowShare() && isAppInstalled() && isAppSupportAPI(getPackageName(), getRemoteAuthEntryActivity(), 7);
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean isSupportShareLunaMusic() {
        return allowShare() && isAppInstalled() && isAppSupportAPI(getPackageName(), BaseCheckHelperImpl.REMOTE_SHARE_ACTIVITY, 3);
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean isSupportVerify() {
        return allowAuth() && isAppInstalled() && isAppSupportAPI(getPackageName(), getRemoteAuthEntryActivity(), getVerifyRequestApi()) && validateSign();
    }
}
