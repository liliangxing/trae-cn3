package com.bytedance.ies.argus.api.interfaces.service;

import android.webkit.WebView;
import com.bytedance.ies.argus.api.params.WebLoadUrlRewritePayload;
import com.bytedance.ies.argus.bean.ArgusWebViewAspect;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IArgusWebSecureService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/argus/api/interfaces/service/ArgusWebSecureServiceListener;", "", "()V", "afterVerifyLoadUrl", "", "webView", "Landroid/webkit/WebView;", "aspect", "Lcom/bytedance/ies/argus/bean/ArgusWebViewAspect;", "verifyResult", "Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "Lcom/bytedance/ies/argus/api/params/WebLoadUrlRewritePayload;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class ArgusWebSecureServiceListener {
    public void afterVerifyLoadUrl(WebView webView, ArgusWebViewAspect aspect, AspectVerifyResult<WebLoadUrlRewritePayload> verifyResult) {
        Intrinsics.checkNotNullParameter(aspect, "aspect");
        Intrinsics.checkNotNullParameter(verifyResult, "verifyResult");
    }
}
