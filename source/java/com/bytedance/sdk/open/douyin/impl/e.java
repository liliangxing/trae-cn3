package com.bytedance.sdk.open.douyin.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.douyin.settings.a;

/* loaded from: classes5.dex */
public class e extends BaseCheckHelperImpl {
    private static final String[] b = {"com.ss.android.ugc.aweme.share.SystemShareActivity", "com.ss.android.ugc.aweme.opensdk.share.SystemShareActivity"};
    private final g a;

    public e(Context context, g gVar) {
        super(context);
        this.a = gVar;
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean allowAuth() {
        return com.bytedance.sdk.open.douyin.settings.a.a(a.c.AUTH, a.b.DOUYIN_LITE);
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean allowShare() {
        return com.bytedance.sdk.open.douyin.settings.a.a(a.c.SHARE, a.b.DOUYIN_LITE);
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    protected int getAuthRequestApi() {
        return 10;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public String getPackageName() {
        return ParamKeyConstants.DOUYIN_LITE_PACKAGE_NAME;
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl, com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public boolean isAppSupportShare() {
        if (!allowShare() || !isAppInstalled() || this.mContext == null) {
            return false;
        }
        for (String str : b) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(this.a.getPackageName(), str));
            ActivityInfo resolveActivityInfo = intent.resolveActivityInfo(this.mContext.getPackageManager(), 65536);
            if (resolveActivityInfo != null && resolveActivityInfo.exported) {
                this.a.a(str);
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean isSupportAuthSwitchAccount() {
        return isAppSupportAuthorization() && super.isSupportAuthSwitchAccount();
    }
}
