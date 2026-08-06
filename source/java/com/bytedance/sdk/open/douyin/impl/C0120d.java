package com.bytedance.sdk.open.douyin.impl;

import android.content.Context;
import com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.douyin.settings.C0125a;

/* renamed from: com.bytedance.sdk.open.douyin.impl.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0120d extends BaseCheckHelperImpl {
    public C0120d(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean allowAuth() {
        return C0125a.m44a(C0125a.c.AUTH, C0125a.b.DOUYIN_HOTSOON);
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean allowShare() {
        return C0125a.m44a(C0125a.c.SHARE, C0125a.b.DOUYIN_HOTSOON);
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
