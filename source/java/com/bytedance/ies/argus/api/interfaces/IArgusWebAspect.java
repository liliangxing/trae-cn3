package com.bytedance.ies.argus.api.interfaces;

import android.webkit.WebView;
import com.bytedance.ies.argus.api.params.ArgusMotionEventParams;
import com.bytedance.ies.argus.api.params.ArgusOnWebViewCreatedParams;
import com.bytedance.ies.argus.api.params.ArgusOnWebViewCreatedRewritePayload;
import com.bytedance.ies.argus.api.params.ArgusWebResourceRequestParams;
import com.bytedance.ies.argus.api.params.ArgusWebResourceRequestRewritePayload;
import com.bytedance.ies.argus.api.params.WebLoadUrlParams;
import com.bytedance.ies.argus.api.params.WebLoadUrlRewritePayload;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import kotlin.Metadata;

/* compiled from: IArgusWebAspect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000eH&J\u001a\u0010\u000f\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000eH&J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\u0006\u0010\n\u001a\u00020\u0013H&J \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0016H&J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000eH&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/argus/api/interfaces/IArgusWebAspect;", "Lcom/bytedance/ies/argus/api/interfaces/IArgusViewAspect;", "handleGoBack", "Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "", "Lcom/bytedance/ies/argus/bean/AspectVerifyResultWithoutRewrite;", "webView", "Landroid/webkit/WebView;", "monitorOnMotionEvent", "", "params", "Lcom/bytedance/ies/argus/api/params/ArgusMotionEventParams;", "verifyAboutToLoadUrl", "Lcom/bytedance/ies/argus/api/params/WebLoadUrlRewritePayload;", "Lcom/bytedance/ies/argus/api/params/WebLoadUrlParams;", "verifyCanGoBack", "verifyLoadUrl", "verifyOnWebViewCreated", "Lcom/bytedance/ies/argus/api/params/ArgusOnWebViewCreatedRewritePayload;", "Lcom/bytedance/ies/argus/api/params/ArgusOnWebViewCreatedParams;", "verifyShouldInterceptRequest", "Lcom/bytedance/ies/argus/api/params/ArgusWebResourceRequestRewritePayload;", "Lcom/bytedance/ies/argus/api/params/ArgusWebResourceRequestParams;", "verifyShouldOverrideUrlLoading", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface IArgusWebAspect extends IArgusViewAspect {
    AspectVerifyResult handleGoBack(WebView webView);

    void monitorOnMotionEvent(ArgusMotionEventParams params);

    AspectVerifyResult<WebLoadUrlRewritePayload> verifyAboutToLoadUrl(WebView webView, WebLoadUrlParams params);

    AspectVerifyResult verifyCanGoBack(WebView webView);

    AspectVerifyResult<WebLoadUrlRewritePayload> verifyLoadUrl(WebView webView, WebLoadUrlParams params);

    AspectVerifyResult<ArgusOnWebViewCreatedRewritePayload> verifyOnWebViewCreated(ArgusOnWebViewCreatedParams params);

    AspectVerifyResult<ArgusWebResourceRequestRewritePayload> verifyShouldInterceptRequest(WebView webView, ArgusWebResourceRequestParams params);

    AspectVerifyResult<WebLoadUrlRewritePayload> verifyShouldOverrideUrlLoading(WebView webView, WebLoadUrlParams params);
}
