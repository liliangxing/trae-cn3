package com.bytedance.sdk.open.douyin.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.sdk.open.aweme.CommonConstants;
import com.bytedance.sdk.open.aweme.authorize.AuthImpl;
import com.bytedance.sdk.open.aweme.authorize.handler.SendAuthDataHandler;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.handler.IDataHandler;
import com.bytedance.sdk.open.aweme.commonability.CommonAbility;
import com.bytedance.sdk.open.aweme.share.Share;
import com.bytedance.sdk.open.aweme.share.ShareDataHandler;
import com.bytedance.sdk.open.aweme.share.ShareImpl;
import com.bytedance.sdk.open.aweme.utils.AppUtil;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.douyin.C0114b;
import com.bytedance.sdk.open.douyin.C0116d;
import com.bytedance.sdk.open.douyin.ShareToContact;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import com.bytedance.sdk.open.douyin.model.OpenRecord;
import com.bytedance.sdk.open.douyin.p002ui.DouYinWebAuthorizeActivity;
import com.bytedance.sdk.open.tt.C0137c;
import com.bytedance.sdk.open.tt.C0138d;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bytedance.sdk.open.douyin.impl.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0122f implements DouYinOpenApi {

    /* renamed from: h */
    private static final String f82h = "RapidOpenApiImpl";

    /* renamed from: i */
    private static final String f83i = "douyinapi.DouYinEntryActivity";

    /* renamed from: j */
    public static final String f84j = "wap_authorize_url";

    /* renamed from: k */
    private static final int f85k = 1;

    /* renamed from: l */
    private static final int f86l = 2;

    /* renamed from: a */
    private Map<Integer, IDataHandler> f87a = new HashMap(2);

    /* renamed from: b */
    private final C0123g f88b;

    /* renamed from: c */
    private ShareImpl f89c;

    /* renamed from: d */
    private AuthImpl f90d;

    /* renamed from: e */
    private C0116d f91e;

    /* renamed from: f */
    private C0121e f92f;

    /* renamed from: g */
    private WeakReference<Activity> f93g;

    public C0122f(Activity activity, String str) {
        this.f93g = new WeakReference<>(activity);
        Context applicationContext = activity.getApplicationContext();
        C0123g c0123g = new C0123g(str);
        this.f88b = c0123g;
        this.f89c = new ShareImpl(applicationContext, c0123g);
        this.f90d = new AuthImpl(str);
        this.f91e = new C0116d(str);
        this.f92f = new C0121e(activity, c0123g);
        this.f87a.put(1, new SendAuthDataHandler());
        this.f87a.put(2, new ShareDataHandler());
    }

    /* renamed from: a */
    private boolean m41a(Authorization.Request request) {
        return this.f90d.authorizeWeb(this.f93g.get(), DouYinWebAuthorizeActivity.class, request);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean authorize(Authorization.Request request) {
        return isAppSupportAuthorization() ? this.f90d.authorizeNative(this.f93g.get(), request, this.f92f.getPackageName(), this.f92f.getRemoteAuthEntryActivity(), f83i, C0114b.f52e, "5.21.1-rc.0") : authorizeWeb(request);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean authorize(Authorization.Request request, CommonConstants.InvokeStrategy invokeStrategy) {
        return authorize(request);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean authorizeInThirdApp(Authorization.Request request) {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean authorizeWeb(Authorization.Request request) {
        return m41a(request);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public String getSdkVersion() {
        return "5.21.1-rc.0";
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public String getWapUrlIfAuthByWap(Authorization.Response response) {
        Bundle bundle;
        if (response == null || (bundle = response.extras) == null || !bundle.containsKey("wap_authorize_url")) {
            return null;
        }
        return response.extras.getString("wap_authorize_url", "");
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean handleIntent(Intent intent, IApiEventHandler iApiEventHandler) {
        if (iApiEventHandler == null) {
            return false;
        }
        if (intent == null) {
            iApiEventHandler.onErrorIntent(intent);
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            iApiEventHandler.onErrorIntent(intent);
            return false;
        }
        int i = extras.getInt("_bytedance_params_type");
        if (i == 0) {
            i = extras.getInt(ParamKeyConstants.ShareParams.TYPE);
        }
        switch (i) {
            case 1:
            case 2:
                return this.f87a.get(1).handle(i, extras, iApiEventHandler);
            case 3:
            case 4:
                return this.f87a.get(2).handle(i, extras, iApiEventHandler);
            case 5:
            case 6:
                return new C0138d().handle(i, extras, iApiEventHandler);
            case 7:
            case 8:
                return new C0137c().handle(i, extras, iApiEventHandler);
            default:
                LogUtils.m30w(f82h, "handleIntent: unknown type " + i);
                return this.f87a.get(1).handle(i, extras, iApiEventHandler);
        }
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppInstalled() {
        return AppUtil.isAppInstalled(this.f93g.get(), this.f92f.getPackageName());
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportAuthorization() {
        return this.f92f.isAppSupportAuthorization();
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportAuthorization(boolean z) {
        return z && isAppSupportAuthorization();
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportMixShare() {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportShare() {
        return this.f92f.isAppSupportShare();
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportShareCardToContact() {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportShareToContacts() {
        return this.f92f.isSupportShareToContact();
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportShareToImageAlbum() {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportShareToPublish() {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportVerification() {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isShareSupportFileProvider() {
        return true;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isSupportApi(int i, int i2) {
        return isSupportApi(i, i2, CommonConstants.InvokeStrategy.AUTO);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isSupportApi(int i, int i2, CommonConstants.InvokeStrategy invokeStrategy) {
        return this.f92f.isSupportApi(i, i2);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isSupportCommonAbility(int i) {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isSupportOpenRecordPage() {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isSupportShareLunaMusic() {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isSupportSwitchAccount() {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean openCommon(CommonAbility.Request request) {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean openCommon(CommonAbility.Request request, CommonConstants.InvokeStrategy invokeStrategy) {
        return openCommon(request);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean openRecordPage(OpenRecord.Request request) {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean openRecordPage(OpenRecord.Request request, CommonConstants.InvokeStrategy invokeStrategy) {
        return openRecordPage(request);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean share(Share.Request request) {
        if (request == null) {
            return false;
        }
        int i = request.requireApi;
        if (i == 10003 ? this.f92f.isAppSupportShare() : this.f92f.isSupportApi(2, i)) {
            return this.f89c.share(this.f93g.get(), f83i, this.f88b.getPackageName(), this.f88b.getComponentClassName(), request, "", C0114b.f52e, "5.21.1-rc.0");
        }
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean share(Share.Request request, CommonConstants.InvokeStrategy invokeStrategy) {
        return share(request);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean shareToContacts(ShareToContact.Request request) {
        if (!this.f92f.isSupportShareToContact()) {
            return false;
        }
        this.f91e.m34a(this.f93g.get(), f83i, this.f92f.getPackageName(), "openshare.ShareToContactsActivity", request);
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean shareToContacts(ShareToContact.Request request, CommonConstants.InvokeStrategy invokeStrategy) {
        return shareToContacts(request);
    }
}
