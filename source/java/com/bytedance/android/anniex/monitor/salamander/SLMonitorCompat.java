package com.bytedance.android.anniex.monitor.salamander;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import androidx.webkit.ProxyConfig;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.utils.AnnieXUrlExtKt;
import com.bytedance.android.monitorV2.executor.HybridMonitorExecutor;
import com.bytedance.android.monitorV2.webview.ttweb.TTUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.salamander.anniex.AccessLayerStringField;
import com.bytedance.salamander.anniex.SLAnnieXMonitor;
import com.bytedance.salamander.anniex.SLPVEventInfo;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SLMonitorCompat.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002./B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u000e¢\u0006\u0002\b\u0010J\u0016\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013J\u001e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fJ\u0016\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0004J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0010\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010'\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010(\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010)\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010*\u001a\u00020\fJ(\u0010)\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010+\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\fJ\u0016\u0010)\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\fJ \u0010)\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\fJ&\u0010,\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u00060"}, d2 = {"Lcom/bytedance/android/anniex/monitor/salamander/SLMonitorCompat;", "", "()V", "slMonitorSwitch", "", "getSlMonitorSwitch", "()Z", "setSlMonitorSwitch", "(Z)V", "collectContainerBaseStringField", "", "sessionId", "", "block", "Lkotlin/Function1;", "Lcom/bytedance/salamander/anniex/SLAnnieXMonitor;", "Lkotlin/ExtensionFunctionType;", "collectLynxBaseField", "lynxView", "Lcom/lynx/tasm/LynxView;", "collectResourceField", "geckoId", "", "resFrom", "collectWebBaseField", "webView", "Landroid/webkit/WebView;", "enableSLMonitor", "getActivity", "Landroid/app/Activity;", "ctx", "Landroid/content/Context;", "getContainerType", StrategyConstants.SCHEMA, "Landroid/net/Uri;", "getNativePage", "view", "Landroid/view/View;", "getUrl", "getWebViewVersion", "releaseMonitor", "reportPV", "viewType", "containerType", "reportReusePV", StreamTrafficObservable.STREAM_URL, "ContainerType", "ViewType", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SLMonitorCompat {
    public static final SLMonitorCompat INSTANCE = new SLMonitorCompat();
    private static boolean slMonitorSwitch;

    private SLMonitorCompat() {
    }

    /* compiled from: SLMonitorCompat.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/monitor/salamander/SLMonitorCompat$ContainerType;", "", StrategyConstants.VALUE, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Lynx", "Web", "Unknown", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public enum ContainerType {
        Lynx("lynx"),
        Web("webview"),
        Unknown("unknown");

        private final String value;

        ContainerType(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* compiled from: SLMonitorCompat.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/monitor/salamander/SLMonitorCompat$ViewType;", "", StrategyConstants.VALUE, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Card", "Popup", "Page", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public enum ViewType {
        Card(AnnieX.CONTAINER_VIEW_TYPE_CARD),
        Popup(AnnieX.CONTAINER_VIEW_TYPE_POPUP),
        Page("page");

        private final String value;

        ViewType(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    public final boolean getSlMonitorSwitch() {
        return slMonitorSwitch;
    }

    public final void setSlMonitorSwitch(boolean z) {
        slMonitorSwitch = z;
    }

    public final boolean enableSLMonitor() {
        return slMonitorSwitch;
    }

    public final void reportPV(String sessionId, String schema) {
        String value;
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        if (enableSLMonitor()) {
            Uri parse = Uri.parse(schema);
            Intrinsics.checkNotNullExpressionValue(parse, "schemaUri");
            if (Intrinsics.areEqual(AnnieXUrlExtKt.getType(parse), "_popup")) {
                value = ViewType.Popup.getValue();
            } else {
                value = ViewType.Page.getValue();
            }
            reportPV(sessionId, parse, getContainerType(parse), value);
        }
    }

    public final void reportPV(String sessionId, String schema, String viewType) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        if (enableSLMonitor()) {
            Uri parse = Uri.parse(schema);
            Intrinsics.checkNotNullExpressionValue(parse, "schemaUri");
            reportPV(sessionId, parse, getContainerType(parse), viewType);
        }
    }

    public final void reportPV(String sessionId, Uri schema, String viewType) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        if (enableSLMonitor()) {
            reportPV(sessionId, schema, getContainerType(schema), viewType);
        }
    }

    public final void reportPV(String sessionId, Uri schema, String containerType, String viewType) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        Intrinsics.checkNotNullParameter(containerType, "containerType");
        if (enableSLMonitor()) {
            SLAnnieXMonitor monitorWithSessionId = SLMonitorCompatKt.getSLMonitorManager().getMonitorWithSessionId(sessionId);
            AccessLayerStringField accessLayerStringField = AccessLayerStringField.Schema;
            String uri = schema.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "schema.toString()");
            monitorWithSessionId.collectContainerBaseStringField(accessLayerStringField, uri);
            monitorWithSessionId.collectContainerBaseStringField(AccessLayerStringField.SdkVersion, "9.0.0");
            monitorWithSessionId.collectContainerBaseStringField(AccessLayerStringField.ContainerType, containerType);
            if (viewType != null) {
                monitorWithSessionId.collectContainerBaseStringField(AccessLayerStringField.ViewType, viewType);
            }
            monitorWithSessionId.collectContainerBaseStringField(AccessLayerStringField.Url, INSTANCE.getUrl(schema));
            if (Intrinsics.areEqual(containerType, ContainerType.Lynx.getValue())) {
                monitorWithSessionId.collectContainerBaseStringField(AccessLayerStringField.LynxVersion, ContainerBaseFieldsCache.INSTANCE.getLynxVersion());
            } else {
                monitorWithSessionId.collectContainerBaseStringField(AccessLayerStringField.WebViewType, ContainerBaseFieldsCache.INSTANCE.getWebViewType());
                monitorWithSessionId.collectContainerBaseStringField(AccessLayerStringField.WebEngineVersion, ContainerBaseFieldsCache.INSTANCE.getWebEngineVersion());
            }
            monitorWithSessionId.reportPV(new SLPVEventInfo());
        }
    }

    public static /* synthetic */ void reportReusePV$default(SLMonitorCompat sLMonitorCompat, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        sLMonitorCompat.reportReusePV(str, str2, str3);
    }

    public final void reportReusePV(String sessionId, String schema, String url) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        if (enableSLMonitor()) {
            SLMonitorCompatKt.getSLMonitorManager().getMonitorWithSessionId(sessionId).reportReusePV(new SLPVEventInfo(), url, schema);
        }
    }

    public final void collectWebBaseField(String sessionId, final WebView webView) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(webView, "webView");
        if (enableSLMonitor()) {
            final SLAnnieXMonitor monitorWithSessionId = SLMonitorCompatKt.getSLMonitorManager().getMonitorWithSessionId(sessionId);
            monitorWithSessionId.collectContainerBaseStringField(AccessLayerStringField.ContainerType, ContainerType.Web.getValue());
            if (Intrinsics.areEqual(ContainerBaseFieldsCache.INSTANCE.getWebEngineVersion(), "unknown") || StringsKt.isBlank(ContainerBaseFieldsCache.INSTANCE.getWebEngineVersion())) {
                HybridMonitorExecutor.INSTANCE.runOnMain(new Runnable() { // from class: com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat$collectWebBaseField$1$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        String webViewVersion;
                        webViewVersion = SLMonitorCompat.INSTANCE.getWebViewVersion(webView);
                        ContainerBaseFieldsCache.INSTANCE.setWebEngineVersion(webViewVersion);
                        monitorWithSessionId.collectContainerBaseStringField(AccessLayerStringField.WebEngineVersion, webViewVersion);
                    }
                });
            } else {
                monitorWithSessionId.collectContainerBaseStringField(AccessLayerStringField.WebEngineVersion, ContainerBaseFieldsCache.INSTANCE.getWebEngineVersion());
            }
            if (Intrinsics.areEqual(ContainerBaseFieldsCache.INSTANCE.getWebViewType(), "unknown")) {
                HybridMonitorExecutor.INSTANCE.runOnMain(new Runnable() { // from class: com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat$collectWebBaseField$1$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        String str = TTUtils.INSTANCE.isTTWebView(webView) ? "ttwebview" : "system";
                        ContainerBaseFieldsCache.INSTANCE.setWebViewType(str);
                        monitorWithSessionId.collectContainerBaseStringField(AccessLayerStringField.WebViewType, str);
                    }
                });
            } else {
                monitorWithSessionId.collectContainerBaseStringField(AccessLayerStringField.WebViewType, ContainerBaseFieldsCache.INSTANCE.getWebViewType());
            }
            monitorWithSessionId.collectContainerBaseStringField(AccessLayerStringField.NativePage, INSTANCE.getNativePage(webView));
        }
    }

    public final void collectLynxBaseField(String sessionId, LynxView lynxView) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(lynxView, "lynxView");
        if (enableSLMonitor()) {
            SLAnnieXMonitor monitorWithSessionId = SLMonitorCompatKt.getSLMonitorManager().getMonitorWithSessionId(sessionId);
            monitorWithSessionId.collectContainerBaseStringField(AccessLayerStringField.ContainerType, ContainerType.Lynx.getValue());
            if (Intrinsics.areEqual(ContainerBaseFieldsCache.INSTANCE.getLynxVersion(), "unknown")) {
                ContainerBaseFieldsCache containerBaseFieldsCache = ContainerBaseFieldsCache.INSTANCE;
                String lynxVersion = LynxEnv.inst().getLynxVersion();
                Intrinsics.checkNotNullExpressionValue(lynxVersion, "inst().lynxVersion");
                containerBaseFieldsCache.setLynxVersion(lynxVersion);
            }
            monitorWithSessionId.collectContainerBaseStringField(AccessLayerStringField.LynxVersion, ContainerBaseFieldsCache.INSTANCE.getLynxVersion());
            monitorWithSessionId.collectContainerBaseStringField(AccessLayerStringField.NativePage, INSTANCE.getNativePage((View) lynxView));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0044, code lost:
    
        if (r5.equals("gecko") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x007a, code lost:
    
        r4 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
    
        if (r5.equals("cdn") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
    
        if (r5.equals("preload") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x009d, code lost:
    
        r4 = "template_bundle";
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0065, code lost:
    
        if (r5.equals("externalTemplateBundle") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
    
        if (r5.equals("custom") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0077, code lost:
    
        if (r5.equals("offline") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x009a, code lost:
    
        if (r5.equals("internalTemplateBundle") == false) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void collectResourceField(String sessionId, long geckoId, String resFrom) {
        String str;
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(resFrom, "resFrom");
        if (enableSLMonitor()) {
            SLAnnieXMonitor monitorWithSessionId = SLMonitorCompatKt.getSLMonitorManager().getMonitorWithSessionId(sessionId);
            monitorWithSessionId.collectContainerBaseStringField(AccessLayerStringField.GeckoId, String.valueOf(geckoId));
            String str2 = "unknown";
            switch (resFrom.hashCode()) {
                case -1994413639:
                    break;
                case -1848962670:
                    if (resFrom.equals("geckoUpdate")) {
                        str2 = "gecko_update";
                        break;
                    }
                    break;
                case -1785310379:
                    if (resFrom.equals("cdnCache")) {
                        str2 = "cdn_cache";
                        break;
                    }
                    break;
                case -1548612125:
                    str = "offline";
                    break;
                case -1349088399:
                    break;
                case -318613945:
                    break;
                case -318476791:
                    break;
                case -284840886:
                    resFrom.equals("unknown");
                    break;
                case 98349:
                    str = "cdn";
                    break;
                case 98230121:
                    str = "gecko";
                    break;
                case 230943795:
                    if (resFrom.equals("buildIn")) {
                        str2 = "builtin";
                        break;
                    }
                    break;
            }
            monitorWithSessionId.collectContainerBaseStringField(AccessLayerStringField.TemplateResType, str2);
        }
    }

    public final void collectContainerBaseStringField(String sessionId, Function1<? super SLAnnieXMonitor, Unit> block) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(block, "block");
        if (enableSLMonitor()) {
            block.invoke(SLMonitorCompatKt.getSLMonitorManager().getMonitorWithSessionId(sessionId));
        }
    }

    public final void releaseMonitor(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        SLMonitorCompatKt.getSLMonitorManager().releaseMonitorWithSessionId(sessionId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getWebViewVersion(WebView webView) {
        try {
            String userAgentString = webView.getSettings().getUserAgentString();
            if (userAgentString == null) {
                userAgentString = "";
            }
            int indexOf$default = StringsKt.indexOf$default(userAgentString, "Chrome/", 0, false, 6, (Object) null);
            if (indexOf$default != -1) {
                indexOf$default += 7;
            }
            String substring = userAgentString.substring(indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            List split$default = StringsKt.split$default(substring, new String[]{" "}, false, 0, 6, (Object) null);
            return split$default.isEmpty() ^ true ? (String) split$default.get(0) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private final String getNativePage(View view) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            SLMonitorCompat sLMonitorCompat = this;
            Activity activity = getActivity(view.getContext());
            obj = Result.constructor-impl(activity != null ? activity.getClass().getName() : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        String str = (String) (Result.isFailure-impl(obj) ? null : obj);
        return str == null ? "" : str;
    }

    private final Activity getActivity(Context ctx) {
        while (ctx != null) {
            if (ctx instanceof Activity) {
                return (Activity) ctx;
            }
            if (!(ctx instanceof ContextWrapper)) {
                break;
            }
            ctx = ((ContextWrapper) ctx).getBaseContext();
        }
        return null;
    }

    private final String getUrl(Uri schema) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            SLMonitorCompat sLMonitorCompat = this;
            String queryParameter = schema.getQueryParameter("annie_x_url");
            if (queryParameter == null) {
                queryParameter = ExtKt.getCDN$default(schema, (String) null, 1, (Object) null);
            }
            obj = Result.constructor-impl(String.valueOf(queryParameter));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        String str = (String) (Result.isFailure-impl(obj) ? null : obj);
        return str == null ? "" : str;
    }

    private final String getContainerType(Uri schema) {
        String scheme = schema.getScheme();
        if (scheme != null) {
            int hashCode = scheme.hashCode();
            if (hashCode != -1772600516) {
                if (hashCode != 3213448) {
                    if (hashCode == 99617003 && scheme.equals(ProxyConfig.MATCH_HTTPS)) {
                        return ContainerType.Web.getValue();
                    }
                } else if (scheme.equals("http")) {
                    return ContainerType.Web.getValue();
                }
            } else if (scheme.equals("lynxview")) {
                return ContainerType.Lynx.getValue();
            }
        }
        String host = schema.getHost();
        if (host != null && StringsKt.contains$default(host, "lynx", false, 2, (Object) null)) {
            return ContainerType.Lynx.getValue();
        }
        String host2 = schema.getHost();
        if (host2 != null && StringsKt.contains$default(host2, "web", false, 2, (Object) null)) {
            return ContainerType.Web.getValue();
        }
        return ContainerType.Lynx.getValue();
    }
}
