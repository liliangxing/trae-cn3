package com.bytedance.android.anniex.lite.container;

import android.webkit.WebView;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.android.anniex.lite.model.AnnieXContext;
import com.bytedance.android.anniex.web.api.IAnnieXWebLifecycle;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXWebEngineProxy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0012\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0013\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u0014\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/anniex/lite/container/AnnieXWebLifeCycleWrapper;", "Lcom/bytedance/android/anniex/web/api/IAnnieXWebLifecycle;", "annieXContext", "Lcom/bytedance/android/anniex/lite/model/AnnieXContext;", "originLifeCycle", "Lcom/bytedance/android/anniex/base/lifecycle/AbsAnnieXLifecycle;", "iContainer", "Lcom/bytedance/android/anniex/base/container/IContainer;", "(Lcom/bytedance/android/anniex/lite/model/AnnieXContext;Lcom/bytedance/android/anniex/base/lifecycle/AbsAnnieXLifecycle;Lcom/bytedance/android/anniex/base/container/IContainer;)V", "onLoadFail", "", StreamTrafficObservable.STREAM_URL, "", "webView", "Landroid/webkit/WebView;", "e", "", "onLoadStart", "onLoadUriSuccess", "onRuntimeReady", "onViewDestroy", "throwable", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXWebLifeCycleWrapper implements IAnnieXWebLifecycle {
    private final AnnieXContext annieXContext;
    private final IContainer iContainer;
    private final AbsAnnieXLifecycle originLifeCycle;

    public AnnieXWebLifeCycleWrapper(AnnieXContext annieXContext, AbsAnnieXLifecycle absAnnieXLifecycle, IContainer iContainer) {
        Intrinsics.checkNotNullParameter(annieXContext, "annieXContext");
        Intrinsics.checkNotNullParameter(absAnnieXLifecycle, "originLifeCycle");
        Intrinsics.checkNotNullParameter(iContainer, "iContainer");
        this.annieXContext = annieXContext;
        this.originLifeCycle = absAnnieXLifecycle;
        this.iContainer = iContainer;
    }

    @Override // com.bytedance.android.anniex.web.api.IAnnieXWebLifecycle
    public void onLoadStart(String url, WebView webView) {
        AbsAnnieXLifecycle absAnnieXLifecycle = this.originLifeCycle;
        if (url == null) {
            url = this.annieXContext.getOriginSchema();
        }
        absAnnieXLifecycle.onLoadStart(url, this.iContainer);
    }

    @Override // com.bytedance.android.anniex.web.api.IAnnieXWebLifecycle
    public void onLoadFail(String url, WebView webView, Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        AbsAnnieXLifecycle absAnnieXLifecycle = this.originLifeCycle;
        if (url == null) {
            url = this.annieXContext.getOriginSchema();
        }
        absAnnieXLifecycle.onLoadFail(url, this.iContainer, e);
    }

    @Override // com.bytedance.android.anniex.web.api.IAnnieXWebLifecycle
    public void onRuntimeReady(String url, WebView webView) {
        AbsAnnieXLifecycle absAnnieXLifecycle = this.originLifeCycle;
        if (url == null) {
            url = this.annieXContext.getOriginSchema();
        }
        absAnnieXLifecycle.onRuntimeReady(url, this.iContainer);
    }

    @Override // com.bytedance.android.anniex.web.api.IAnnieXWebLifecycle
    public void onViewDestroy(String url, WebView webView, Throwable throwable) {
        AbsAnnieXLifecycle absAnnieXLifecycle = this.originLifeCycle;
        if (url == null) {
            url = this.annieXContext.getOriginSchema();
        }
        absAnnieXLifecycle.onRelease(url);
    }

    @Override // com.bytedance.android.anniex.web.api.IAnnieXWebLifecycle
    public void onLoadUriSuccess(String url, WebView webView) {
        AbsAnnieXLifecycle absAnnieXLifecycle = this.originLifeCycle;
        if (url == null) {
            url = this.annieXContext.getOriginSchema();
        }
        absAnnieXLifecycle.onLoadSuccess(url, this.iContainer);
    }
}
