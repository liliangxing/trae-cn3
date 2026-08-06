package com.bytedance.sdk.open.douyin.api;

import android.content.Intent;
import com.bytedance.sdk.open.aweme.CommonConstants;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.commonability.CommonAbility;
import com.bytedance.sdk.open.aweme.share.Share;
import com.bytedance.sdk.open.douyin.ShareToContact;
import com.bytedance.sdk.open.douyin.model.OpenRecord;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface DouYinOpenApi {
    boolean authorize(Authorization.Request request);

    boolean authorize(Authorization.Request request, CommonConstants.InvokeStrategy invokeStrategy);

    boolean authorizeInThirdApp(Authorization.Request request);

    boolean authorizeWeb(Authorization.Request request);

    String getSdkVersion();

    String getWapUrlIfAuthByWap(Authorization.Response response);

    boolean handleIntent(Intent intent, IApiEventHandler iApiEventHandler);

    @Deprecated
    boolean isAppInstalled();

    boolean isAppSupportAuthorization();

    boolean isAppSupportAuthorization(boolean z);

    boolean isAppSupportMixShare();

    boolean isAppSupportShare();

    boolean isAppSupportShareCardToContact();

    boolean isAppSupportShareToContacts();

    boolean isAppSupportShareToImageAlbum();

    boolean isAppSupportShareToPublish();

    boolean isAppSupportVerification();

    boolean isShareSupportFileProvider();

    boolean isSupportApi(int i, int i2);

    boolean isSupportApi(int i, int i2, CommonConstants.InvokeStrategy invokeStrategy);

    boolean isSupportCommonAbility(int i);

    boolean isSupportOpenRecordPage();

    boolean isSupportShareLunaMusic();

    boolean isSupportSwitchAccount();

    boolean openCommon(CommonAbility.Request request);

    boolean openCommon(CommonAbility.Request request, CommonConstants.InvokeStrategy invokeStrategy);

    boolean openRecordPage(OpenRecord.Request request);

    boolean openRecordPage(OpenRecord.Request request, CommonConstants.InvokeStrategy invokeStrategy);

    boolean share(Share.Request request);

    boolean share(Share.Request request, CommonConstants.InvokeStrategy invokeStrategy);

    boolean shareToContacts(ShareToContact.Request request);

    boolean shareToContacts(ShareToContact.Request request, CommonConstants.InvokeStrategy invokeStrategy);
}
