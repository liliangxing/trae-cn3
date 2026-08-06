package com.bytedance.ies.argus.api.interfaces.service;

import android.webkit.WebView;
import com.bytedance.ies.argus.api.params.WebLoadUrlRewritePayload;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IArgusWebSecureService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\t0\bj\u0002`\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\t0\bj\u0002`\nH\u0016J&\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00110\bH\u0016J&\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00110\bH\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/argus/api/interfaces/service/IArgusWebSecureService;", "Lcom/bytedance/ies/argus/api/interfaces/service/ArgusBaseSecureService;", "()V", "handleGoBack", "", "webView", "Landroid/webkit/WebView;", "verifyResult", "Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "", "Lcom/bytedance/ies/argus/bean/AspectVerifyResultWithoutRewrite;", "provideListener", "Lcom/bytedance/ies/argus/api/interfaces/service/ArgusWebSecureServiceListener;", "verifyCanGoBack", "verifyLoadUrl", "url", "", "Lcom/bytedance/ies/argus/api/params/WebLoadUrlRewritePayload;", "verifyShouldOverrideUrlLoading", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class IArgusWebSecureService extends ArgusBaseSecureService {
    public void handleGoBack(WebView webView, AspectVerifyResult verifyResult) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(verifyResult, "verifyResult");
    }

    public ArgusWebSecureServiceListener provideListener() {
        return null;
    }

    public void verifyCanGoBack(WebView webView, AspectVerifyResult verifyResult) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(verifyResult, "verifyResult");
    }

    public void verifyLoadUrl(WebView webView, String url, AspectVerifyResult<WebLoadUrlRewritePayload> verifyResult) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(verifyResult, "verifyResult");
    }

    public void verifyShouldOverrideUrlLoading(WebView webView, String url, AspectVerifyResult<WebLoadUrlRewritePayload> verifyResult) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(verifyResult, "verifyResult");
    }
}
