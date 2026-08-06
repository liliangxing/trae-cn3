package com.bytedance.sdk.open.douyin.p002ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.open.aweme.CommonConstants;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.authorize.p000ui.BaseWebAuthorizeActivity;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;
import com.bytedance.sdk.open.aweme.utils.ViewUtils;
import com.bytedance.sdk.open.douyin.AbstractC0113a;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class DouYinWebAuthorizeActivity extends BaseWebAuthorizeActivity {

    /* renamed from: d */
    public static final String f192d = "open.douyin.com";

    /* renamed from: e */
    public static final String f193e = "open-boe.douyin.com";

    /* renamed from: f */
    public static final String f194f = "api.snssdk.com";

    /* renamed from: g */
    public static final String f195g = "/platform/oauth/connect/";

    /* renamed from: h */
    protected static final String f196h = "douyinapi.DouYinEntryActivity";

    /* renamed from: a */
    private DouYinOpenApi f197a;

    /* renamed from: b */
    private String f198b;

    /* renamed from: c */
    private boolean f199c = false;

    /* renamed from: com.bytedance.sdk.open.douyin.ui.DouYinWebAuthorizeActivity$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private class C0134b extends BaseWebAuthorizeActivity.AuthWebViewClient {
        private C0134b() {
            super();
        }

        @Override // com.bytedance.sdk.open.aweme.authorize.ui.BaseWebAuthorizeActivity.AuthWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (TextUtils.isEmpty(DouYinWebAuthorizeActivity.this.f198b)) {
                return;
            }
            DouYinWebAuthorizeActivity.this.m135a();
        }

        @Override // com.bytedance.sdk.open.aweme.authorize.ui.BaseWebAuthorizeActivity.AuthWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m135a() {
        this.mContentWebView.loadUrl("javascript:(function () {window.secureCommonParams ='" + this.f198b + "';})();");
    }

    /* renamed from: com_bytedance_sdk_open_douyin_ui_DouYinWebAuthorizeActivity__onStop$___twin___ */
    public void m138xe3617865() {
        super.onStop();
    }

    @Override // com.bytedance.sdk.open.aweme.authorize.p000ui.BaseWebAuthorizeActivity
    protected void configWebView() {
        this.mContentWebView.setWebViewClient(new C0134b());
    }

    @Override // com.bytedance.sdk.open.aweme.authorize.p000ui.BaseWebAuthorizeActivity
    protected String errorCode2Message(int i) {
        return "";
    }

    @Override // com.bytedance.sdk.open.aweme.authorize.p000ui.BaseWebAuthorizeActivity
    protected String getAuthPath() {
        return f195g;
    }

    @Override // com.bytedance.sdk.open.aweme.authorize.p000ui.BaseWebAuthorizeActivity
    protected String getDomain() {
        return f194f;
    }

    @Override // com.bytedance.sdk.open.aweme.authorize.p000ui.BaseWebAuthorizeActivity
    protected String getHost() {
        return this.f199c ? f193e : f192d;
    }

    @Override // com.bytedance.sdk.open.aweme.authorize.p000ui.BaseWebAuthorizeActivity
    protected String getScheme() {
        return this.f199c ? "http" : "https";
    }

    @Override // com.bytedance.sdk.open.aweme.authorize.p000ui.BaseWebAuthorizeActivity
    protected boolean handleIntent(Intent intent, IApiEventHandler iApiEventHandler) {
        Bundle m133xf761e846 = m133xf761e846(intent, "_bytedance_params_extra");
        if (m133xf761e846 != null) {
            this.f198b = m133xf761e846.getString("internal_secure_common_params");
        }
        DouYinOpenApi douYinOpenApi = this.f197a;
        if (douYinOpenApi != null) {
            return douYinOpenApi.handleIntent(intent, iApiEventHandler);
        }
        return false;
    }

    @Override // com.bytedance.sdk.open.aweme.authorize.p000ui.BaseWebAuthorizeActivity
    protected boolean isNetworkAvailable() {
        return true;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.open.aweme.authorize.p000ui.BaseWebAuthorizeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f197a = AbstractC0113a.create(this);
        this.f199c = AbstractC0113a.isBoe();
        super.onCreate(bundle);
        ViewUtils.setStatusBarColor(this, Color.parseColor("#FFFFFF"));
        ViewUtils.setStatusBarLightMode(this);
    }

    @Override // android.app.Activity
    protected void onStop() {
        m137x4b7e04b6(this);
    }

    @Override // com.bytedance.sdk.open.aweme.authorize.p000ui.BaseWebAuthorizeActivity
    protected void sendInnerResponse(Authorization.Request request, BaseResp baseResp) {
        if (baseResp != null && this.mContentWebView != null) {
            if (baseResp.extras == null) {
                baseResp.extras = new Bundle();
            }
            baseResp.extras.putString("wap_authorize_url", this.mContentWebView.getUrl());
            baseResp.extras.putString(CommonConstants.ExtraParams.AUTH_HOST_APP, "H5");
        }
        sendInnerResponse(f196h, request, baseResp);
    }

    @Override // com.bytedance.sdk.open.aweme.authorize.p000ui.BaseWebAuthorizeActivity
    protected void setContainerViewBgColor() {
        RelativeLayout relativeLayout = this.mContainer;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(-1);
        }
    }

    @Proxy("getBundleExtra")
    @TargetClass("android.content.Intent")
    /* renamed from: INVOKEVIRTUAL_com_bytedance_sdk_open_douyin_ui_DouYinWebAuthorizeActivity_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra */
    public static Bundle m133xf761e846(Intent intent, String str) {
        Bundle bundleExtra = intent.getBundleExtra(str);
        Context context = BadParcelableCrashOptimizer.getContext();
        if (bundleExtra != null && context != null) {
            bundleExtra.setClassLoader(context.getClassLoader());
        }
        return bundleExtra;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_sdk_open_douyin_ui_DouYinWebAuthorizeActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m137x4b7e04b6(DouYinWebAuthorizeActivity douYinWebAuthorizeActivity) {
        douYinWebAuthorizeActivity.m138xe3617865();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                douYinWebAuthorizeActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
