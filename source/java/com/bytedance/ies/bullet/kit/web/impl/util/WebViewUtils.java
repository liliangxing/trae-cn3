package com.bytedance.ies.bullet.kit.web.impl.util;

import android.content.Context;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.webx.WebX;
import com.bytedance.webx.core.webview.WebviewManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebViewUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/impl/util/WebViewUtils;", "", "()V", "createWebView", "Lcom/bytedance/ies/bullet/kit/web/SSWebView;", "context", "Landroid/content/Context;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class WebViewUtils {
    public static final WebViewUtils INSTANCE = new WebViewUtils();

    private WebViewUtils() {
    }

    public final SSWebView createWebView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            SSWebView createContainer = WebX.getContainerManager("webx_webkit", WebviewManager.class).createContainer(context, SSWebView.class);
            Intrinsics.checkNotNullExpressionValue(createContainer, "{\n            WebX.getCo…ew::class.java)\n        }");
            return createContainer;
        } catch (Throwable unused) {
            return new SSWebView(context, null, 0, 6, null);
        }
    }
}
