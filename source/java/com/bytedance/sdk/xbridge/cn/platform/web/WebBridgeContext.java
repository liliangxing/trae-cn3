package com.bytedance.sdk.xbridge.cn.platform.web;

import android.webkit.WebView;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.BaseBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.service.JSEventDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebBridgeContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBridgeContext;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/BaseBDXBridgeContext;", "containerID", "", "view", "Landroid/webkit/WebView;", "jsEventDelegate", "Lcom/bytedance/sdk/xbridge/cn/service/JSEventDelegate;", LynxBridgeCall.NAME_SPACE, "(Ljava/lang/String;Landroid/webkit/WebView;Lcom/bytedance/sdk/xbridge/cn/service/JSEventDelegate;Ljava/lang/String;)V", "getJsEventDelegate", "()Lcom/bytedance/sdk/xbridge/cn/service/JSEventDelegate;", "platformType", "Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "getPlatformType", "()Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class WebBridgeContext extends BaseBDXBridgeContext {
    private final JSEventDelegate jsEventDelegate;
    private final PlatformType platformType;

    public /* synthetic */ WebBridgeContext(String str, WebView webView, JSEventDelegate jSEventDelegate, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, webView, jSEventDelegate, (i & 8) != 0 ? "" : str2);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public JSEventDelegate getJsEventDelegate() {
        return this.jsEventDelegate;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebBridgeContext(String str, WebView webView, JSEventDelegate jSEventDelegate, String str2) {
        super(str, webView, str2);
        Intrinsics.checkNotNullParameter(str, "containerID");
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(jSEventDelegate, "jsEventDelegate");
        Intrinsics.checkNotNullParameter(str2, LynxBridgeCall.NAME_SPACE);
        this.jsEventDelegate = jSEventDelegate;
        this.platformType = PlatformType.WEB;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public PlatformType getPlatformType() {
        return this.platformType;
    }
}
