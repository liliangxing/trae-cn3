package com.bytedance.android.anniex.lite.container;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.android.anniex.lite.model.AnnieXContext;
import com.bytedance.android.anniex.p026ui.AnnieXLynxView;
import com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxViewClient;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.behavior.ImageInterceptor;
import java.util.Map;
import javax.xml.transform.Transformer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AnnieXLynxEngineProxy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0016\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0017\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/anniex/lite/container/AnnieXLynxLifeCycleWrapper;", "Lcom/bytedance/android/anniex/ui/IAnnieXLifeCycle;", "annieXContext", "Lcom/bytedance/android/anniex/lite/model/AnnieXContext;", "originLifeCycle", "Lcom/bytedance/android/anniex/base/lifecycle/AbsAnnieXLifecycle;", "iContainer", "Lcom/bytedance/android/anniex/base/container/IContainer;", "(Lcom/bytedance/android/anniex/lite/model/AnnieXContext;Lcom/bytedance/android/anniex/base/lifecycle/AbsAnnieXLifecycle;Lcom/bytedance/android/anniex/base/container/IContainer;)V", "onFirstScreen", "", "annieXLynxView", "Lcom/bytedance/android/anniex/ui/AnnieXLynxView;", "onLoadFail", "uri", "Landroid/net/Uri;", "e", "", "onLoadFailed", "errorMsg", "", "onLoadStart", "onLoadUriSuccess", "onRuntimeReady", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLynxLifeCycleWrapper implements IAnnieXLifeCycle {
    private final AnnieXContext annieXContext;
    private final IContainer iContainer;
    private final AbsAnnieXLifecycle originLifeCycle;

    public AnnieXLynxLifeCycleWrapper(AnnieXContext annieXContext, AbsAnnieXLifecycle absAnnieXLifecycle, IContainer iContainer) {
        Intrinsics.checkNotNullParameter(annieXContext, "annieXContext");
        Intrinsics.checkNotNullParameter(absAnnieXLifecycle, "originLifeCycle");
        Intrinsics.checkNotNullParameter(iContainer, "iContainer");
        this.annieXContext = annieXContext;
        this.originLifeCycle = absAnnieXLifecycle;
        this.iContainer = iContainer;
    }

    @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
    public void loadImage(Context context, String str, String str2, float f, float f2, Transformer transformer, ImageInterceptor.CompletionHandler completionHandler) {
        IAnnieXLifeCycle.DefaultImpls.loadImage(this, context, str, str2, f, f2, transformer, completionHandler);
    }

    @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
    public void onDataUpdated(AnnieXLynxView annieXLynxView) {
        IAnnieXLifeCycle.DefaultImpls.onDataUpdated(this, annieXLynxView);
    }

    @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
    public void onFirstLoadPerfReady(AnnieXLynxView annieXLynxView, JSONObject jSONObject) {
        IAnnieXLifeCycle.DefaultImpls.onFirstLoadPerfReady(this, annieXLynxView, jSONObject);
    }

    @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
    public void onModuleMethodInvoked(String str, String str2, int i) {
        IAnnieXLifeCycle.DefaultImpls.onModuleMethodInvoked(this, str, str2, i);
    }

    @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
    public void onPageStart(AnnieXLynxView annieXLynxView, String str) {
        IAnnieXLifeCycle.DefaultImpls.onPageStart(this, annieXLynxView, str);
    }

    @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
    public void onPageUpdate(AnnieXLynxView annieXLynxView) {
        IAnnieXLifeCycle.DefaultImpls.onPageUpdate(this, annieXLynxView);
    }

    @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
    public void onReceivedError(AnnieXLynxView annieXLynxView, LynxError lynxError) {
        IAnnieXLifeCycle.DefaultImpls.onReceivedError(this, annieXLynxView, lynxError);
    }

    @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
    public void onReceivedError(AnnieXLynxView annieXLynxView, String str) {
        IAnnieXLifeCycle.DefaultImpls.onReceivedError(this, annieXLynxView, str);
    }

    @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
    public void onScrollStart(LynxViewClient.ScrollInfo scrollInfo) {
        IAnnieXLifeCycle.DefaultImpls.onScrollStart(this, scrollInfo);
    }

    @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
    public void onScrollStop(LynxViewClient.ScrollInfo scrollInfo) {
        IAnnieXLifeCycle.DefaultImpls.onScrollStop(this, scrollInfo);
    }

    @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
    public void onTemplateBundleReady(TemplateBundle templateBundle) {
        IAnnieXLifeCycle.DefaultImpls.onTemplateBundleReady(this, templateBundle);
    }

    @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
    public void onTemplateReady(String str, boolean z) {
        IAnnieXLifeCycle.DefaultImpls.onTemplateReady(this, str, z);
    }

    @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
    public void onTimingSetup(Map<String, Object> map) {
        IAnnieXLifeCycle.DefaultImpls.onTimingSetup(this, map);
    }

    @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
    public void onTimingUpdate(Map<String, Object> map, Map<String, Long> map2, String str) {
        IAnnieXLifeCycle.DefaultImpls.onTimingUpdate(this, map, map2, str);
    }

    @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
    public void onUpdatePerfReady(AnnieXLynxView annieXLynxView, JSONObject jSONObject) {
        IAnnieXLifeCycle.DefaultImpls.onUpdatePerfReady(this, annieXLynxView, jSONObject);
    }

    @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
    public String shouldRedirectImageUrl(String str) {
        return IAnnieXLifeCycle.DefaultImpls.shouldRedirectImageUrl(this, str);
    }

    @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
    public void onLoadStart(Uri uri, AnnieXLynxView annieXLynxView) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        AbsAnnieXLifecycle absAnnieXLifecycle = this.originLifeCycle;
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        absAnnieXLifecycle.onLoadStart(uri2, this.iContainer);
    }

    @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
    public void onLoadFail(Uri uri, Throwable e) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(e, "e");
        AbsAnnieXLifecycle absAnnieXLifecycle = this.originLifeCycle;
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        absAnnieXLifecycle.onLoadFail(uri2, this.iContainer, e);
    }

    @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
    public void onLoadFailed(AnnieXLynxView annieXLynxView, String errorMsg) {
        this.originLifeCycle.onLoadFail(this.annieXContext.getOriginSchema(), this.iContainer, new Throwable(errorMsg));
    }

    @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
    public void onRuntimeReady(AnnieXLynxView annieXLynxView) {
        this.originLifeCycle.onRuntimeReady(this.annieXContext.getOriginSchema(), this.iContainer);
    }

    @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
    public void onFirstScreen(AnnieXLynxView annieXLynxView) {
        this.originLifeCycle.onFirstScreen(this.annieXContext.getOriginSchema(), this.iContainer);
    }

    @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
    public void onLoadUriSuccess(Uri uri, AnnieXLynxView annieXLynxView) {
        this.originLifeCycle.onLoadSuccess(this.annieXContext.getOriginSchema(), this.iContainer);
    }
}
