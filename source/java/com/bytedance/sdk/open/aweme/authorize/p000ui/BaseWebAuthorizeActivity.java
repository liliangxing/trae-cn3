package com.bytedance.sdk.open.aweme.authorize.p000ui;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.account.bdplatform.model.BDPlatformConstants;
import com.bytedance.sdk.open.aweme.C0087R;
import com.bytedance.sdk.open.aweme.authorize.C0089a;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.model.BaseReq;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;
import com.bytedance.sdk.open.aweme.commonbase.OpenEvent;
import com.bytedance.sdk.open.aweme.init.DouYinSdkContext;
import com.bytedance.sdk.open.aweme.utils.AppUtil;
import com.bytedance.sdk.open.aweme.utils.OpenUtils;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class BaseWebAuthorizeActivity extends Activity implements IApiEventHandler {
    private static final int MSG_LOADING_TIME_OUT = 100;
    private static final String RES_ID = "id";
    private static final String RES_LAYOUT = "layout";
    private static final String RES_STRING = "string";
    protected static final String WAP_AUTHORIZE_URL = "wap_authorize_url";
    protected Authorization.Request mAuthRequest;
    protected AlertDialog mBaseErrorDialog;
    protected ImageView mCancelImg;
    protected RelativeLayout mContainer;
    protected WebView mContentWebView;
    private Context mContext;
    protected boolean mHasExecutingRequest;
    protected RelativeLayout mHeaderView;
    private int mLastErrorCode;
    protected FrameLayout mLoadingLayout;
    int OP_ERROR_NO_CONNECTION = -12;
    int OP_ERROR_CONNECT_TIMEOUT = -13;
    int OP_ERROR_NETWORK_ERROR = -15;
    protected boolean mStatusDestroyed = false;
    protected boolean isShowNetworkError = false;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class AuthWebViewClient extends WebViewClient {
        public AuthWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            BaseWebAuthorizeActivity baseWebAuthorizeActivity = BaseWebAuthorizeActivity.this;
            baseWebAuthorizeActivity.mHasExecutingRequest = false;
            WebView webView2 = baseWebAuthorizeActivity.mContentWebView;
            if (webView2 == null || webView2.getProgress() != 100) {
                return;
            }
            BaseWebAuthorizeActivity.this.stopLoading();
            if (BaseWebAuthorizeActivity.this.mLastErrorCode == 0) {
                BaseWebAuthorizeActivity baseWebAuthorizeActivity2 = BaseWebAuthorizeActivity.this;
                if (baseWebAuthorizeActivity2.isShowNetworkError) {
                    return;
                }
                OpenUtils.setViewVisibility(baseWebAuthorizeActivity2.mContentWebView, 0);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            BaseWebAuthorizeActivity baseWebAuthorizeActivity = BaseWebAuthorizeActivity.this;
            if (baseWebAuthorizeActivity.mHasExecutingRequest) {
                return;
            }
            baseWebAuthorizeActivity.mLastErrorCode = 0;
            BaseWebAuthorizeActivity baseWebAuthorizeActivity2 = BaseWebAuthorizeActivity.this;
            baseWebAuthorizeActivity2.mHasExecutingRequest = true;
            baseWebAuthorizeActivity2.startLoading();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            BaseWebAuthorizeActivity.this.mLastErrorCode = i;
            BaseWebAuthorizeActivity baseWebAuthorizeActivity = BaseWebAuthorizeActivity.this;
            baseWebAuthorizeActivity.showNetworkErrorDialog(baseWebAuthorizeActivity.OP_ERROR_NETWORK_ERROR);
            BaseWebAuthorizeActivity.this.isShowNetworkError = true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            BaseWebAuthorizeActivity.this.showSslErrorDialog(sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!BaseWebAuthorizeActivity.this.isNetworkAvailable()) {
                BaseWebAuthorizeActivity baseWebAuthorizeActivity = BaseWebAuthorizeActivity.this;
                baseWebAuthorizeActivity.showNetworkErrorDialog(baseWebAuthorizeActivity.OP_ERROR_NO_CONNECTION);
            } else {
                if (BaseWebAuthorizeActivity.this.handleRedirect(str)) {
                    return true;
                }
                BaseWebAuthorizeActivity.this.mContentWebView.loadUrl(str);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.open.aweme.authorize.ui.BaseWebAuthorizeActivity$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class ViewOnClickListenerC0090a implements View.OnClickListener {
        ViewOnClickListenerC0090a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseWebAuthorizeActivity.this.mobEvent("aweme_auth_refuse");
            BaseWebAuthorizeActivity.this.onCancel(-2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.open.aweme.authorize.ui.BaseWebAuthorizeActivity$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class DialogInterfaceOnClickListenerC0091b implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ SslErrorHandler f32a;

        DialogInterfaceOnClickListenerC0091b(SslErrorHandler sslErrorHandler) {
            this.f32a = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            BaseWebAuthorizeActivity.this.cancelLoad(this.f32a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.open.aweme.authorize.ui.BaseWebAuthorizeActivity$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class DialogInterfaceOnClickListenerC0092c implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ SslErrorHandler f34a;

        DialogInterfaceOnClickListenerC0092c(SslErrorHandler sslErrorHandler) {
            this.f34a = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            BaseWebAuthorizeActivity.this.cancelLoad(this.f34a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.open.aweme.authorize.ui.BaseWebAuthorizeActivity$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class ViewOnClickListenerC0093d implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ int f36a;

        ViewOnClickListenerC0093d(int i) {
            this.f36a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseWebAuthorizeActivity.this.onCancel(this.f36a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleRedirect(String str) {
        Authorization.Request request;
        String str2;
        int parseInt;
        if (TextUtils.isEmpty(str) || (request = this.mAuthRequest) == null || (str2 = request.redirectUri) == null || !str.startsWith(str2)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("code");
        String queryParameter2 = parse.getQueryParameter("state");
        String queryParameter3 = parse.getQueryParameter("scopes");
        if (!TextUtils.isEmpty(queryParameter)) {
            redirectToClientApp(queryParameter, queryParameter2, queryParameter3, 0);
            return true;
        }
        String queryParameter4 = parse.getQueryParameter("errCode");
        if (!TextUtils.isEmpty(queryParameter4)) {
            try {
                parseInt = Integer.parseInt(queryParameter4);
            } catch (Exception e) {
                e.printStackTrace();
            }
            redirectToClientApp("", queryParameter2, parseInt);
            return false;
        }
        parseInt = -1;
        redirectToClientApp("", queryParameter2, parseInt);
        return false;
    }

    private void initView() {
        this.mContainer = (RelativeLayout) findViewById(C0087R.id.open_rl_container);
        this.mHeaderView = (RelativeLayout) findViewById(C0087R.id.open_header_view);
        ImageView imageView = (ImageView) findViewById(C0087R.id.cancel);
        this.mCancelImg = imageView;
        imageView.setOnClickListener(new ViewOnClickListenerC0090a());
        setContainerViewBgColor();
        FrameLayout frameLayout = (FrameLayout) findViewById(C0087R.id.open_loading_group);
        this.mLoadingLayout = frameLayout;
        View loadingView = getLoadingView(frameLayout);
        if (loadingView != null) {
            this.mLoadingLayout.removeAllViews();
            this.mLoadingLayout.addView(loadingView);
        }
        initWebView(this);
        if (this.mContentWebView.getParent() != null) {
            ((ViewGroup) this.mContentWebView.getParent()).removeView(this.mContentWebView);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mContentWebView.getLayoutParams();
        layoutParams.addRule(3, C0087R.id.auth_top_divider);
        this.mContentWebView.setLayoutParams(layoutParams);
        this.mContentWebView.setVisibility(4);
        this.mContainer.addView(this.mContentWebView);
    }

    private void initWebView(Context context) {
        this.mContentWebView = new WebView(context);
        this.mContentWebView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        WebSettings settings = this.mContentWebView.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(-1);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mobEvent(String str) {
        PackageManager packageManager;
        String string = this.mAuthRequest.extras.getString("enter_from", "auth_login");
        String str2 = TextUtils.isEmpty(string) ? "auth_login" : string;
        String str3 = this.mAuthRequest.isThridAuthDialog ? "half" : "full";
        StringBuilder sb = new StringBuilder();
        String str4 = this.mAuthRequest.scope;
        if (str4 != null) {
            sb.append(str4);
        }
        String str5 = this.mAuthRequest.optionalScope0;
        if (str5 != null) {
            sb.append(str5);
        }
        String str6 = this.mAuthRequest.optionalScope1;
        if (str6 != null) {
            sb.append(str6);
        }
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = getApplicationContext().getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        new OpenEvent.Builder(str).m18kv("params_for_special", "uc_login").m18kv("enter_method", "other_inside").m18kv("is_mobile_auth", 1).m18kv("auth_source", "external_h5").m18kv(BDPlatformConstants.EventKey.EVENT_KEY_SDK_VERSION, "5.21.1-rc.0").m18kv("client_app_type", 1).m18kv("enter_from", str2).m18kv("is_skip_all", 0).m18kv("is_new_process", 0).m18kv("client_key", this.mAuthRequest.clientKey).m18kv("refuse_type", "exit").m18kv("client_name", applicationInfo != null ? (String) packageManager.getApplicationLabel(applicationInfo) : "").m18kv("panel_type", str3).m18kv("auth_info_all", sb.toString()).m18kv("auth_info_show", sb.toString()).m18kv("auth_info_select", "").build().flush();
    }

    private void redirectToClientApp(String str, String str2, int i) {
        Authorization.Response response = new Authorization.Response();
        response.authCode = str;
        response.errorCode = i;
        response.state = str2;
        sendInnerResponse(this.mAuthRequest, response);
        finish();
    }

    private void redirectToClientApp(String str, String str2, String str3, int i) {
        Authorization.Response response = new Authorization.Response();
        response.authCode = str;
        response.errorCode = i;
        response.state = str2;
        response.grantedPermissions = str3;
        sendInnerResponse(this.mAuthRequest, response);
        finish();
    }

    protected String buildLoadUrl(Authorization.Request request) {
        return C0089a.m17a(this, request, getScheme(), getHost(), getAuthPath());
    }

    protected void cancelLoad(SslErrorHandler sslErrorHandler) {
        if (sslErrorHandler != null) {
            sslErrorHandler.cancel();
        }
        showNetworkErrorDialog(this.OP_ERROR_NETWORK_ERROR);
        this.isShowNetworkError = true;
    }

    protected void configWebView() {
        this.mContentWebView.setWebViewClient(new AuthWebViewClient());
    }

    protected abstract String errorCode2Message(int i);

    protected abstract String getAuthPath();

    protected abstract String getDomain();

    protected abstract String getHost();

    protected View getLoadingView(ViewGroup viewGroup) {
        return LayoutInflater.from(this).inflate(C0087R.layout.layout_open_loading_view, viewGroup, false);
    }

    protected abstract String getScheme();

    protected abstract boolean handleIntent(Intent intent, IApiEventHandler iApiEventHandler);

    public final void handleRequestIntent() {
        String ppeProd;
        Authorization.Request request = this.mAuthRequest;
        if (request == null) {
            finish();
            return;
        }
        if (!isNetworkAvailable()) {
            this.isShowNetworkError = true;
            showNetworkErrorDialog(this.OP_ERROR_NO_CONNECTION);
            return;
        }
        startLoading();
        configWebView();
        HashMap hashMap = new HashMap();
        if (!DouYinSdkContext.inst().isBoe() || DouYinSdkContext.inst().getBoeProd() == null) {
            if (DouYinSdkContext.inst().isPpe() && DouYinSdkContext.inst().getPpeProd() != null) {
                hashMap.put("x-use_ppe", "1");
                ppeProd = DouYinSdkContext.inst().getPpeProd();
            }
            this.mContentWebView.loadUrl(buildLoadUrl(request), hashMap);
        }
        hashMap.put("x-use_boe", "1");
        ppeProd = DouYinSdkContext.inst().getBoeProd();
        hashMap.put("x-tt-env", ppeProd);
        this.mContentWebView.loadUrl(buildLoadUrl(request), hashMap);
    }

    protected void initActions() {
    }

    @Override // android.app.Activity
    public boolean isDestroyed() {
        try {
            return super.isDestroyed();
        } catch (Throwable unused) {
            return this.mStatusDestroyed;
        }
    }

    protected abstract boolean isNetworkAvailable();

    @Override // android.app.Activity
    public void onBackPressed() {
        mobEvent("aweme_auth_refuse");
        Authorization.Request request = this.mAuthRequest;
        redirectToClientApp("", request != null ? request.state : null, -2);
    }

    protected void onCancel(int i) {
        Authorization.Request request = this.mAuthRequest;
        redirectToClientApp("", request != null ? request.state : null, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        handleIntent(getIntent(), this);
        setContentView(C0087R.layout.layout_open_web_authorize);
        initView();
        initActions();
        handleRequestIntent();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mStatusDestroyed = true;
        WebView webView = this.mContentWebView;
        if (webView != null) {
            ViewParent parent = webView.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.mContentWebView);
            }
            this.mContentWebView.stopLoading();
            this.mContentWebView.setWebViewClient(null);
            this.mContentWebView.removeAllViews();
            this.mContentWebView.destroy();
        }
    }

    @Override // com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler
    public void onErrorIntent(Intent intent) {
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        AlertDialog alertDialog = this.mBaseErrorDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.mBaseErrorDialog.dismiss();
    }

    @Override // com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler
    public void onReq(BaseReq baseReq) {
        if (baseReq instanceof Authorization.Request) {
            Authorization.Request request = (Authorization.Request) baseReq;
            this.mAuthRequest = request;
            request.redirectUri = "https://" + getDomain() + "/oauth/authorize/callback/";
            setRequestedOrientation(-1);
        }
    }

    @Override // com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler
    public void onResp(BaseResp baseResp) {
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    protected abstract void sendInnerResponse(Authorization.Request request, BaseResp baseResp);

    public boolean sendInnerResponse(String str, Authorization.Request request, BaseResp baseResp) {
        if (baseResp == null || this.mContext == null || request == null || !baseResp.checkArgs()) {
            return false;
        }
        Bundle bundle = new Bundle();
        baseResp.toBundle(bundle);
        String packageName = this.mContext.getPackageName();
        String buildComponentClassName = TextUtils.isEmpty(request.callerLocalEntry) ? AppUtil.buildComponentClassName(packageName, str) : request.callerLocalEntry;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, buildComponentClassName));
        intent.putExtras(bundle);
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        try {
            this.mContext.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    protected void setContainerViewBgColor() {
        RelativeLayout relativeLayout = this.mContainer;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }

    protected void showNetworkErrorDialog(int i) {
        AlertDialog alertDialog = this.mBaseErrorDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            if (this.mBaseErrorDialog == null) {
                View inflate = LayoutInflater.from(this).inflate(C0087R.layout.layout_open_network_error_dialog, (ViewGroup) null, false);
                inflate.findViewById(C0087R.id.tv_confirm).setOnClickListener(new ViewOnClickListenerC0093d(i));
                this.mBaseErrorDialog = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.Theme.Holo)).setView(inflate).setCancelable(false).create();
            }
            if (isFinishing()) {
                return;
            }
            this.mBaseErrorDialog.show();
        }
    }

    protected void showSslErrorDialog(SslErrorHandler sslErrorHandler, SslError sslError) {
        Context context;
        int i;
        try {
            AlertDialog create = new AlertDialog.Builder(this.mContext).create();
            String string = this.mContext.getString(C0087R.string.aweme_open_ssl_error);
            int primaryError = sslError.getPrimaryError();
            if (primaryError == 0) {
                context = this.mContext;
                i = C0087R.string.aweme_open_ssl_notyetvalid;
            } else if (primaryError == 1) {
                context = this.mContext;
                i = C0087R.string.aweme_open_ssl_expired;
            } else if (primaryError == 2) {
                context = this.mContext;
                i = C0087R.string.aweme_open_ssl_mismatched;
            } else {
                if (primaryError != 3) {
                    String str = string + this.mContext.getString(C0087R.string.aweme_open_ssl_continue);
                    create.setTitle(C0087R.string.aweme_open_ssl_warning);
                    create.setTitle(str);
                    create.setButton(-1, this.mContext.getString(C0087R.string.aweme_open_ssl_ok), new DialogInterfaceOnClickListenerC0091b(sslErrorHandler));
                    create.setButton(-2, this.mContext.getString(C0087R.string.aweme_open_ssl_cancel), new DialogInterfaceOnClickListenerC0092c(sslErrorHandler));
                    create.setCanceledOnTouchOutside(false);
                    create.show();
                }
                context = this.mContext;
                i = C0087R.string.aweme_open_ssl_untrusted;
            }
            string = context.getString(i);
            String str2 = string + this.mContext.getString(C0087R.string.aweme_open_ssl_continue);
            create.setTitle(C0087R.string.aweme_open_ssl_warning);
            create.setTitle(str2);
            create.setButton(-1, this.mContext.getString(C0087R.string.aweme_open_ssl_ok), new DialogInterfaceOnClickListenerC0091b(sslErrorHandler));
            create.setButton(-2, this.mContext.getString(C0087R.string.aweme_open_ssl_cancel), new DialogInterfaceOnClickListenerC0092c(sslErrorHandler));
            create.setCanceledOnTouchOutside(false);
            create.show();
        } catch (Exception unused) {
            cancelLoad(sslErrorHandler);
        }
    }

    protected void startLoading() {
        OpenUtils.setViewVisibility(this.mLoadingLayout, 0);
    }

    protected void stopLoading() {
        OpenUtils.setViewVisibility(this.mLoadingLayout, 8);
    }
}
