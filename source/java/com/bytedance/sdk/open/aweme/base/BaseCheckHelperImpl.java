package com.bytedance.sdk.open.aweme.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.commonability.CommonAbility;
import com.bytedance.sdk.open.aweme.utils.AppUtil;
import com.bytedance.sdk.open.aweme.utils.SignatureUtils;

/* loaded from: classes5.dex */
public abstract class BaseCheckHelperImpl implements IAPPCheckHelper {
    public static String REMOTE_AUTH_ACTIVITY = "openauthorize.AwemeAuthorizedActivity";
    public static String REMOTE_COMMON_ABILITY_ACTIVITY = "openability.CommonAbilityActivity";
    public static String REMOTE_SHARE_ACTIVITY = "share.SystemShareActivity";
    public static String REMOTE_SHARE_CONTACTS_ACTIVITY = "openshare.ShareToContactsActivity";
    public static String REMOTE_SHARE_RECORD_ACTIVITY = "opensdk.OpenCameraActivity";
    protected Context mContext;

    public BaseCheckHelperImpl(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private int getPlatformSDKVersion(String str, String str2) {
        Bundle bundle;
        if (this.mContext == null || TextUtils.isEmpty(str) || !AppUtil.isAppInstalled(this.mContext, getPackageName())) {
            return -1;
        }
        try {
            ActivityInfo activityInfo = this.mContext.getPackageManager().getActivityInfo(new ComponentName(str, buildComponentClassName(str, str2)), 128);
            if (activityInfo != null && (bundle = activityInfo.metaData) != null) {
                return bundle.getInt("BD_PLATFORM_SDK_VERSION", -1);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private boolean isAppSupportAuthApi() {
        return isAppSupportAPI(getPackageName(), getRemoteAuthEntryActivity(), getAuthRequestApi());
    }

    private boolean isAppSupportShareApi(String str, String str2, int i) {
        return isAppSupportAPI(str, str2, i);
    }

    public abstract boolean allowAuth();

    public abstract boolean allowShare();

    @Override // com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public String buildComponentClassName(String str, String str2) {
        return AppUtil.buildComponentClassName(ParamKeyConstants.DOUYIN_PACKAGE_NAME, str2);
    }

    protected abstract int getAuthRequestApi();

    @Override // com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public String getRemoteAuthEntryActivity() {
        return "openauthorize.AwemeAuthorizedActivity";
    }

    public String getSignature() {
        return "aea615ab910015038f73c47e45d21466";
    }

    @Override // com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public boolean isAppInstalled() {
        return AppUtil.isAppInstalled(this.mContext, getPackageName());
    }

    public boolean isAppSupportAPI(String str, String str2, int i) {
        if (this.mContext == null || TextUtils.isEmpty(str) || !isAppInstalled()) {
            return false;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, buildComponentClassName(str, str2)));
        ActivityInfo resolveActivityInfo = intent.resolveActivityInfo(this.mContext.getPackageManager(), 65536);
        return resolveActivityInfo != null && resolveActivityInfo.exported && getPlatformSDKVersion(str, str2) >= i;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public boolean isAppSupportAuthorization() {
        return allowAuth() && isAppInstalled() && isAppSupportAuthApi() && SignatureUtils.validateSign(this.mContext, getPackageName(), getSignature());
    }

    public boolean isAppSupportMixShare() {
        return allowShare() && isAppInstalled() && isAppSupportAPI(getPackageName(), REMOTE_SHARE_ACTIVITY, 2);
    }

    @Override // com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public boolean isAppSupportShare() {
        return allowShare() && isAppInstalled() && isAppSupportShareApi(getPackageName(), getRemoteAuthEntryActivity(), 3);
    }

    public boolean isAppSupportShareToImageAlbum() {
        return allowShare() && isAppInstalled() && isAppSupportAPI(getPackageName(), REMOTE_SHARE_ACTIVITY, 2);
    }

    public boolean isShareSupportFileProvider() {
        return isSupportApi(2, 10007);
    }

    public boolean isSupportApi(int i, int i2) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i == 5 && isAppInstalled() && isAppSupportAPI(getPackageName(), REMOTE_COMMON_ABILITY_ACTIVITY, i2) : isAppInstalled() && isAppSupportAPI(getPackageName(), REMOTE_SHARE_RECORD_ACTIVITY, i2) : isAppInstalled() && isAppSupportAPI(getPackageName(), REMOTE_SHARE_CONTACTS_ACTIVITY, i2) : (i2 == 10003 || i2 == 10007 || i2 == 10008) ? allowShare() && isAppInstalled() && isAppSupportAPI(getPackageName(), getRemoteAuthEntryActivity(), i2 + (-10000)) : allowShare() && isAppInstalled() && isAppSupportAPI(getPackageName(), REMOTE_SHARE_ACTIVITY, i2) : allowAuth() && isAppInstalled() && isAppSupportAPI(getPackageName(), getRemoteAuthEntryActivity(), i2) && validateSign();
    }

    public boolean isSupportAuthSwitchAccount() {
        return isAppInstalled() && isAppSupportAPI(getPackageName(), getRemoteAuthEntryActivity(), 9);
    }

    public boolean isSupportCommonAbility(int i) {
        return isAppInstalled() && isAppSupportAPI(getPackageName(), REMOTE_COMMON_ABILITY_ACTIVITY, CommonAbility.supportApi(i));
    }

    public boolean isSupportOpenRecordPage() {
        return isAppInstalled() && isAppSupportAPI(getPackageName(), REMOTE_SHARE_RECORD_ACTIVITY, 1);
    }

    public boolean isSupportShareCardToContact() {
        return isAppInstalled() && isAppSupportAPI(getPackageName(), REMOTE_SHARE_CONTACTS_ACTIVITY, 2);
    }

    public boolean isSupportShareLunaMusic() {
        return isSupportApi(2, 3);
    }

    public boolean isSupportShareToContact() {
        return isAppInstalled() && isAppSupportAPI(getPackageName(), REMOTE_SHARE_CONTACTS_ACTIVITY, 1);
    }

    public boolean isSupportShareToPublish() {
        return allowShare() && isAppInstalled() && isAppSupportAPI(getPackageName(), getRemoteAuthEntryActivity(), 8);
    }

    public boolean isSupportUnifiedJoinGroup() {
        return isAppInstalled() && isAppSupportAPI(getPackageName(), REMOTE_SHARE_CONTACTS_ACTIVITY, 3);
    }

    public boolean isSupportVerify() {
        return isSupportApi(1, 6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean validateSign() {
        return SignatureUtils.validateSign(this.mContext, getPackageName(), getSignature());
    }
}
