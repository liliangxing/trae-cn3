package com.bytedance.android.anniex.base.builder;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebViewClient;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.android.anniex.container.ui.AnnieXPageService;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.utils.XConstant;
import com.lynx.tasm.LynxViewClient;
import com.lynx.tasm.TemplateData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UIComponentBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u0002092\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\t\u001a\u0002092\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u0011\u001a\u0002092\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010:J\u000e\u0010\u0015\u001a\u0002092\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010;\u001a\u0002092\u0006\u0010'\u001a\u00020(J\u000e\u0010\u001b\u001a\u0002092\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010<\u001a\u0002092\u0006\u0010<\u001a\u00020\u0004J\u000e\u0010=\u001a\u0002092\u0006\u0010=\u001a\u00020\u0004J\u0010\u0010-\u001a\u0002092\u0006\u0010-\u001a\u00020.H\u0007J'\u0010>\u001a\u000209\"\u0004\b\u0000\u0010?2\f\u0010@\u001a\b\u0012\u0004\u0012\u0002H?0A2\u0006\u0010B\u001a\u0002H?¢\u0006\u0002\u0010CJ\u000e\u00103\u001a\u0002092\u0006\u00103\u001a\u000204R\u001a\u0010\u0003\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006D"}, d2 = {"Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;", "", "()V", "bid", "", "getBid$anniex_release", "()Ljava/lang/String;", "setBid$anniex_release", "(Ljava/lang/String;)V", "bundle", "Landroid/os/Bundle;", "getBundle$anniex_release", "()Landroid/os/Bundle;", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "getContextProviderFactory$anniex_release", "()Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "globalProps", "", "getGlobalProps$anniex_release", "()Ljava/util/Map;", "lifecycle", "Lcom/bytedance/android/anniex/base/lifecycle/AbsAnnieXLifecycle;", "getLifecycle$anniex_release", "()Lcom/bytedance/android/anniex/base/lifecycle/AbsAnnieXLifecycle;", "setLifecycle$anniex_release", "(Lcom/bytedance/android/anniex/base/lifecycle/AbsAnnieXLifecycle;)V", "lynxViewClient", "Lcom/lynx/tasm/LynxViewClient;", "getLynxViewClient$anniex_release", "()Lcom/lynx/tasm/LynxViewClient;", "setLynxViewClient$anniex_release", "(Lcom/lynx/tasm/LynxViewClient;)V", "systemContext", "Landroid/content/Context;", "getSystemContext$anniex_release", "()Landroid/content/Context;", "setSystemContext$anniex_release", "(Landroid/content/Context;)V", "templateData", "Lcom/lynx/tasm/TemplateData;", "getTemplateData$anniex_release", "()Lcom/lynx/tasm/TemplateData;", "setTemplateData$anniex_release", "(Lcom/lynx/tasm/TemplateData;)V", "useFlow", "", "getUseFlow$anniex_release", "()Z", "setUseFlow$anniex_release", "(Z)V", "webViewClient", "Landroid/webkit/WebViewClient;", "getWebViewClient$anniex_release", "()Landroid/webkit/WebViewClient;", "setWebViewClient$anniex_release", "(Landroid/webkit/WebViewClient;)V", "", "", "lynxInitData", "schema", "sessionId", "weakHolder", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "item", "(Ljava/lang/Class;Ljava/lang/Object;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public class UIComponentBuilder {
    private String bid = "default_bid";
    private final Bundle bundle = new Bundle();
    private final ContextProviderFactory contextProviderFactory = new ContextProviderFactory();
    private final Map<String, Object> globalProps = new LinkedHashMap();
    private AbsAnnieXLifecycle lifecycle;
    private LynxViewClient lynxViewClient;
    public Context systemContext;
    private TemplateData templateData;
    private boolean useFlow;
    private WebViewClient webViewClient;

    public final Context getSystemContext$anniex_release() {
        Context context = this.systemContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("systemContext");
        return null;
    }

    public final void setSystemContext$anniex_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.systemContext = context;
    }

    /* renamed from: getBid$anniex_release, reason: from getter */
    public final String getBid() {
        return this.bid;
    }

    public final void setBid$anniex_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bid = str;
    }

    /* renamed from: getBundle$anniex_release, reason: from getter */
    public final Bundle getBundle() {
        return this.bundle;
    }

    /* renamed from: getContextProviderFactory$anniex_release, reason: from getter */
    public final ContextProviderFactory getContextProviderFactory() {
        return this.contextProviderFactory;
    }

    public final Map<String, Object> getGlobalProps$anniex_release() {
        return this.globalProps;
    }

    /* renamed from: getLifecycle$anniex_release, reason: from getter */
    public final AbsAnnieXLifecycle getLifecycle() {
        return this.lifecycle;
    }

    public final void setLifecycle$anniex_release(AbsAnnieXLifecycle absAnnieXLifecycle) {
        this.lifecycle = absAnnieXLifecycle;
    }

    /* renamed from: getWebViewClient$anniex_release, reason: from getter */
    public final WebViewClient getWebViewClient() {
        return this.webViewClient;
    }

    public final void setWebViewClient$anniex_release(WebViewClient webViewClient) {
        this.webViewClient = webViewClient;
    }

    /* renamed from: getLynxViewClient$anniex_release, reason: from getter */
    public final LynxViewClient getLynxViewClient() {
        return this.lynxViewClient;
    }

    public final void setLynxViewClient$anniex_release(LynxViewClient lynxViewClient) {
        this.lynxViewClient = lynxViewClient;
    }

    /* renamed from: getTemplateData$anniex_release, reason: from getter */
    public final TemplateData getTemplateData() {
        return this.templateData;
    }

    public final void setTemplateData$anniex_release(TemplateData templateData) {
        this.templateData = templateData;
    }

    /* renamed from: getUseFlow$anniex_release, reason: from getter */
    public final boolean getUseFlow() {
        return this.useFlow;
    }

    public final void setUseFlow$anniex_release(boolean z) {
        this.useFlow = z;
    }

    public final <T> void weakHolder(Class<T> clazz, T item) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        this.contextProviderFactory.registerWeakHolder(clazz, item);
    }

    public final void bundle(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.bundle.putAll(bundle);
    }

    public final void lifecycle(AbsAnnieXLifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        this.lifecycle = lifecycle;
    }

    public final void webViewClient(WebViewClient webViewClient) {
        Intrinsics.checkNotNullParameter(webViewClient, "webViewClient");
        this.webViewClient = webViewClient;
    }

    public final void lynxViewClient(LynxViewClient lynxViewClient) {
        Intrinsics.checkNotNullParameter(lynxViewClient, "lynxViewClient");
        this.lynxViewClient = lynxViewClient;
    }

    public final void globalProps(Map<String, ? extends Object> globalProps) {
        Intrinsics.checkNotNullParameter(globalProps, "globalProps");
        this.globalProps.putAll(globalProps);
    }

    public final void lynxInitData(TemplateData templateData) {
        Intrinsics.checkNotNullParameter(templateData, "templateData");
        this.templateData = templateData;
    }

    public final void bid(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        this.bid = bid;
    }

    public final void schema(String schema) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        this.bundle.putString(XConstant.BUNDLE_KEY_INNER_SCHEMA, schema);
    }

    public final void sessionId(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.bundle.putString("__x_session_id", sessionId);
    }

    @Deprecated(message = "use flow by default in the future")
    public final void useFlow(boolean useFlow) {
        this.useFlow = useFlow;
        this.bundle.putBoolean(AnnieXPageService.BUNDLE_ANNIE_X_FLOW, useFlow);
    }
}
