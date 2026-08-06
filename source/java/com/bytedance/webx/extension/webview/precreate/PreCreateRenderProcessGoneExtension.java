package com.bytedance.webx.extension.webview.precreate;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.bytedance.webx.AbsExtension;
import com.bytedance.webx.IExtension;
import com.bytedance.webx.base.logger.WLog;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.bytedance.webx.core.webview.client.WebViewContainerClient;
import com.bytedance.webx.event.EventManager;
import com.bytedance.webx.extension.webview.precreate.PreCreateRenderProcessGoneExtension;
import com.lynx.tasm.DefaultLogicExecutor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: PreCreateRenderProcessGoneExtension.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0018\u0019B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014RP\u0010\u0005\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00060\u0013R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/webx/extension/webview/precreate/PreCreateRenderProcessGoneExtension;", "Lcom/bytedance/webx/AbsExtension;", "Lcom/bytedance/webx/core/webview/WebViewContainer;", "Lcom/bytedance/webx/IExtension$IContainerExtension;", "()V", "removePreCreatedHandler", "Lkotlin/Function2;", "Landroid/webkit/WebView;", "Lkotlin/ParameterName;", DefaultLogicExecutor.GLOBAL_EVENT_NAME, "view", "Landroid/webkit/RenderProcessGoneDetail;", "detail", "", "getRemovePreCreatedHandler", "()Lkotlin/jvm/functions/Function2;", "setRemovePreCreatedHandler", "(Lkotlin/jvm/functions/Function2;)V", "webViewClientExtension", "Lcom/bytedance/webx/extension/webview/precreate/PreCreateRenderProcessGoneExtension$WebViewClientExtension;", "onCreateExtendable", "", "createHelper", "Lcom/bytedance/webx/AbsExtension$CreateHelper;", "Companion", "WebViewClientExtension", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class PreCreateRenderProcessGoneExtension extends AbsExtension<WebViewContainer> implements IExtension.IContainerExtension {
    public static final String TAG = "PreCreateExtension";
    private Function2<? super WebView, ? super RenderProcessGoneDetail, Boolean> removePreCreatedHandler;
    private final WebViewClientExtension webViewClientExtension = new WebViewClientExtension();

    public final Function2<WebView, RenderProcessGoneDetail, Boolean> getRemovePreCreatedHandler() {
        return this.removePreCreatedHandler;
    }

    public final void setRemovePreCreatedHandler(Function2<? super WebView, ? super RenderProcessGoneDetail, Boolean> function2) {
        this.removePreCreatedHandler = function2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.webx.AbsExtension
    public void onCreateExtendable(AbsExtension.CreateHelper createHelper) {
        if (createHelper != null) {
            createHelper.bindExtension(getExtendable().getExtendableWebViewClient(), this.webViewClientExtension);
        }
    }

    /* compiled from: PreCreateRenderProcessGoneExtension.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0005\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/webx/extension/webview/precreate/PreCreateRenderProcessGoneExtension$WebViewClientExtension;", "Lcom/bytedance/webx/AbsExtension;", "Lcom/bytedance/webx/core/webview/client/WebViewContainerClient;", "(Lcom/bytedance/webx/extension/webview/precreate/PreCreateRenderProcessGoneExtension;)V", "mListener", "com/bytedance/webx/extension/webview/precreate/PreCreateRenderProcessGoneExtension$WebViewClientExtension$mListener$1", "Lcom/bytedance/webx/extension/webview/precreate/PreCreateRenderProcessGoneExtension$WebViewClientExtension$mListener$1;", "onCreateExtendable", "", "createHelper", "Lcom/bytedance/webx/AbsExtension$CreateHelper;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public final class WebViewClientExtension extends AbsExtension<WebViewContainerClient> {
        private final C0056xed41eea3 mListener;

        /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.webx.extension.webview.precreate.PreCreateRenderProcessGoneExtension$WebViewClientExtension$mListener$1] */
        public WebViewClientExtension() {
            this.mListener = new WebViewContainerClient.ListenerStub() { // from class: com.bytedance.webx.extension.webview.precreate.PreCreateRenderProcessGoneExtension$WebViewClientExtension$mListener$1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.bytedance.webx.event.AbsListenerStub
                public AbsExtension<?> getExtension() {
                    return PreCreateRenderProcessGoneExtension.WebViewClientExtension.this;
                }

                @Override // com.bytedance.webx.core.webview.client.WebViewContainerClient.ListenerStub, com.bytedance.webx.core.webview.client.IWebViewContainerClient
                public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
                    boolean onRenderProcessGone = super.onRenderProcessGone(view, detail);
                    Function2<WebView, RenderProcessGoneDetail, Boolean> removePreCreatedHandler = r2.getRemovePreCreatedHandler();
                    if (removePreCreatedHandler != null ? ((Boolean) removePreCreatedHandler.invoke(view, detail)).booleanValue() : false) {
                        WLog.m47w(PreCreateRenderProcessGoneExtension.TAG, "RenderProcessGoneExtension 1");
                        r2.getExtendable().destroy();
                        return true;
                    }
                    WLog.m47w(PreCreateRenderProcessGoneExtension.TAG, "RenderProcessGoneExtension 2");
                    return onRenderProcessGone;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.webx.AbsExtension
        public void onCreateExtendable(AbsExtension.CreateHelper createHelper) {
            register(WebViewContainerClient.EVENT_onRenderProcessGone, this.mListener, EventManager.REGION_IN_OUT_ADJUST);
        }
    }
}
