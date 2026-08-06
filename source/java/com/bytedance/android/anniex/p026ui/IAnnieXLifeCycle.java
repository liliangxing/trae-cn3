package com.bytedance.android.anniex.p026ui;

import android.content.Context;
import android.net.Uri;
import com.bytedance.forest.model.Response;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxViewClient;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.behavior.ImageInterceptor;
import java.util.Map;
import javax.xml.transform.Transformer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IAnnieXLifeCycle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001@JF\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001c\u0010\u001c\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u001f\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u00072\u0006\u0010#\u001a\u00020$H\u0016J\u001c\u0010%\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010&\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010'\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010(\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001c\u0010(\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010+\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010,\u001a\u00020\u00032\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0012\u0010/\u001a\u00020\u00032\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u000202H\u0016J\u0018\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u000206H\u0016J\u001e\u00107\u001a\u00020\u00032\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u000109H\u0016J>\u0010:\u001a\u00020\u00032\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u0001092\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020<\u0018\u0001092\b\u0010=\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010>\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0014\u0010?\u001a\u0004\u0018\u00010\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006A"}, d2 = {"Lcom/bytedance/android/anniex/ui/IAnnieXLifeCycle;", "", "loadImage", "", "context", "Landroid/content/Context;", "cacheKey", "", "src", "width", "", "height", "transformer", "Ljavax/xml/transform/Transformer;", "handler", "Lcom/lynx/tasm/behavior/ImageInterceptor$CompletionHandler;", "onDataUpdated", "annieXLynxView", "Lcom/bytedance/android/anniex/ui/AnnieXLynxView;", "onFirstLoadPerfReady", "pref", "Lorg/json/JSONObject;", "onFirstScreen", "onLoadFail", "uri", "Landroid/net/Uri;", "e", "", "onLoadFailed", "errorMsg", "onLoadStart", "onLoadUriSuccess", "onModuleMethodInvoked", "module", "method", "error_code", "", "onPageStart", StreamTrafficObservable.STREAM_URL, "onPageUpdate", "onReceivedError", "error", "Lcom/lynx/tasm/LynxError;", "onRuntimeReady", "onScrollStart", "info", "Lcom/lynx/tasm/LynxViewClient$ScrollInfo;", "onScrollStop", "onTemplateBundleReady", "templateBundle", "Lcom/lynx/tasm/TemplateBundle;", "onTemplateReady", "resFrom", "isFromMemory", "", "onTimingSetup", "timingInfo", "", "onTimingUpdate", "updateTiming", "", "flag", "onUpdatePerfReady", "shouldRedirectImageUrl", "AnnieXLynxLifeCycle", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface IAnnieXLifeCycle {

    /* compiled from: IAnnieXLifeCycle.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JF\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u001c\u0010\u0015\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J$\u0010\u001e\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u001e\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010!\u001a\u0004\u0018\u00010\bH\u0017J\u001a\u0010\"\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010#\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010$\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\b2\b\u0010&\u001a\u0004\u0018\u00010\b2\u0006\u0010'\u001a\u00020 H\u0016J\u001c\u0010(\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010)\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010*\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010+\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001c\u0010+\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010!\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010.\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010/\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00102\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u000208H\u0016J\u0018\u00106\u001a\u00020\u00042\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020;H\u0016J\u001e\u0010<\u001a\u00020\u00042\u0014\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020?\u0018\u00010>H\u0016J>\u0010@\u001a\u00020\u00042\u0014\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020?\u0018\u00010>2\u0014\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020B\u0018\u00010>2\b\u0010C\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010D\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010E\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0014\u0010F\u001a\u0004\u0018\u00010\b2\b\u0010)\u001a\u0004\u0018\u00010\bH\u0016¨\u0006G"}, d2 = {"Lcom/bytedance/android/anniex/ui/IAnnieXLifeCycle$AnnieXLynxLifeCycle;", "Lcom/bytedance/android/anniex/ui/IAnnieXLifeCycle;", "()V", "loadImage", "", "context", "Landroid/content/Context;", "cacheKey", "", "src", "width", "", "height", "transformer", "Ljavax/xml/transform/Transformer;", "handler", "Lcom/lynx/tasm/behavior/ImageInterceptor$CompletionHandler;", "onDataUpdated", "annieXLynxView", "Lcom/bytedance/android/anniex/ui/AnnieXLynxView;", "onDestroy", "onFirstLoadPerfReady", "pref", "Lorg/json/JSONObject;", "onFirstScreen", "onLoadFail", "uri", "Landroid/net/Uri;", "e", "", "onLoadFailed", "errorCode", "", "errorMsg", "onLoadStart", "onLoadUriSuccess", "onModuleMethodInvoked", "module", "method", "error_code", "onPageStart", StreamTrafficObservable.STREAM_URL, "onPageUpdate", "onReceivedError", "error", "Lcom/lynx/tasm/LynxError;", "onRuntimeReady", "onScrollStart", "info", "Lcom/lynx/tasm/LynxViewClient$ScrollInfo;", "onScrollStop", "onTemplateBundleReady", "templateBundle", "Lcom/lynx/tasm/TemplateBundle;", "onTemplateReady", "response", "Lcom/bytedance/forest/model/Response;", "resFrom", "isFromMemory", "", "onTimingSetup", "timingInfo", "", "", "onTimingUpdate", "updateTiming", "", "flag", "onUpdatePerfReady", "onViewDetached", "shouldRedirectImageUrl", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class AnnieXLynxLifeCycle implements IAnnieXLifeCycle {
        @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
        public void loadImage(Context context, String cacheKey, String src, float width, float height, Transformer transformer, ImageInterceptor.CompletionHandler handler) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(handler, "handler");
        }

        @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
        public void onDataUpdated(AnnieXLynxView annieXLynxView) {
        }

        public void onDestroy() {
        }

        @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
        public void onFirstLoadPerfReady(AnnieXLynxView annieXLynxView, JSONObject pref) {
        }

        @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
        public void onFirstScreen(AnnieXLynxView annieXLynxView) {
        }

        @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
        public void onLoadFail(Uri uri, Throwable e) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(e, "e");
        }

        public void onLoadFailed(AnnieXLynxView annieXLynxView, int errorCode, String errorMsg) {
        }

        @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
        @Deprecated(message = "Use onLoadFailed with errorCode instead")
        public void onLoadFailed(AnnieXLynxView annieXLynxView, String errorMsg) {
        }

        @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
        public void onLoadStart(Uri uri, AnnieXLynxView annieXLynxView) {
            Intrinsics.checkNotNullParameter(uri, "uri");
        }

        @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
        public void onLoadUriSuccess(Uri uri, AnnieXLynxView annieXLynxView) {
        }

        @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
        public void onModuleMethodInvoked(String module, String method, int error_code) {
        }

        @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
        public void onPageStart(AnnieXLynxView annieXLynxView, String url) {
        }

        @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
        public void onPageUpdate(AnnieXLynxView annieXLynxView) {
        }

        @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
        public void onReceivedError(AnnieXLynxView annieXLynxView, LynxError error) {
        }

        @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
        public void onReceivedError(AnnieXLynxView annieXLynxView, String errorMsg) {
        }

        @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
        public void onRuntimeReady(AnnieXLynxView annieXLynxView) {
        }

        @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
        public void onScrollStart(LynxViewClient.ScrollInfo info) {
        }

        @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
        public void onScrollStop(LynxViewClient.ScrollInfo info) {
        }

        @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
        public void onTemplateBundleReady(TemplateBundle templateBundle) {
            Intrinsics.checkNotNullParameter(templateBundle, "templateBundle");
        }

        public void onTemplateReady(Response response) {
            Intrinsics.checkNotNullParameter(response, "response");
        }

        @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
        public void onTemplateReady(String resFrom, boolean isFromMemory) {
            Intrinsics.checkNotNullParameter(resFrom, "resFrom");
        }

        @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
        public void onTimingSetup(Map<String, Object> timingInfo) {
        }

        @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
        public void onTimingUpdate(Map<String, Object> timingInfo, Map<String, Long> updateTiming, String flag) {
        }

        @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
        public void onUpdatePerfReady(AnnieXLynxView annieXLynxView, JSONObject pref) {
        }

        public void onViewDetached(AnnieXLynxView annieXLynxView) {
        }

        @Override // com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle
        public String shouldRedirectImageUrl(String url) {
            return null;
        }
    }

    /* compiled from: IAnnieXLifeCycle.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class DefaultImpls {
        public static void loadImage(IAnnieXLifeCycle iAnnieXLifeCycle, Context context, String str, String str2, float f, float f2, Transformer transformer, ImageInterceptor.CompletionHandler completionHandler) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(completionHandler, "handler");
        }

        public static void onDataUpdated(IAnnieXLifeCycle iAnnieXLifeCycle, AnnieXLynxView annieXLynxView) {
        }

        public static void onFirstLoadPerfReady(IAnnieXLifeCycle iAnnieXLifeCycle, AnnieXLynxView annieXLynxView, JSONObject jSONObject) {
        }

        public static void onFirstScreen(IAnnieXLifeCycle iAnnieXLifeCycle, AnnieXLynxView annieXLynxView) {
        }

        public static void onLoadFail(IAnnieXLifeCycle iAnnieXLifeCycle, Uri uri, Throwable th) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(th, "e");
        }

        public static void onLoadFailed(IAnnieXLifeCycle iAnnieXLifeCycle, AnnieXLynxView annieXLynxView, String str) {
        }

        public static void onLoadStart(IAnnieXLifeCycle iAnnieXLifeCycle, Uri uri, AnnieXLynxView annieXLynxView) {
            Intrinsics.checkNotNullParameter(uri, "uri");
        }

        public static void onLoadUriSuccess(IAnnieXLifeCycle iAnnieXLifeCycle, Uri uri, AnnieXLynxView annieXLynxView) {
        }

        public static void onModuleMethodInvoked(IAnnieXLifeCycle iAnnieXLifeCycle, String str, String str2, int i) {
        }

        public static void onPageStart(IAnnieXLifeCycle iAnnieXLifeCycle, AnnieXLynxView annieXLynxView, String str) {
        }

        public static void onPageUpdate(IAnnieXLifeCycle iAnnieXLifeCycle, AnnieXLynxView annieXLynxView) {
        }

        public static void onReceivedError(IAnnieXLifeCycle iAnnieXLifeCycle, AnnieXLynxView annieXLynxView, LynxError lynxError) {
        }

        public static void onReceivedError(IAnnieXLifeCycle iAnnieXLifeCycle, AnnieXLynxView annieXLynxView, String str) {
        }

        public static void onRuntimeReady(IAnnieXLifeCycle iAnnieXLifeCycle, AnnieXLynxView annieXLynxView) {
        }

        public static void onScrollStart(IAnnieXLifeCycle iAnnieXLifeCycle, LynxViewClient.ScrollInfo scrollInfo) {
        }

        public static void onScrollStop(IAnnieXLifeCycle iAnnieXLifeCycle, LynxViewClient.ScrollInfo scrollInfo) {
        }

        public static void onTemplateBundleReady(IAnnieXLifeCycle iAnnieXLifeCycle, TemplateBundle templateBundle) {
            Intrinsics.checkNotNullParameter(templateBundle, "templateBundle");
        }

        public static void onTemplateReady(IAnnieXLifeCycle iAnnieXLifeCycle, String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "resFrom");
        }

        public static void onTimingSetup(IAnnieXLifeCycle iAnnieXLifeCycle, Map<String, Object> map) {
        }

        public static void onTimingUpdate(IAnnieXLifeCycle iAnnieXLifeCycle, Map<String, Object> map, Map<String, Long> map2, String str) {
        }

        public static void onUpdatePerfReady(IAnnieXLifeCycle iAnnieXLifeCycle, AnnieXLynxView annieXLynxView, JSONObject jSONObject) {
        }

        public static String shouldRedirectImageUrl(IAnnieXLifeCycle iAnnieXLifeCycle, String str) {
            return null;
        }
    }

    void loadImage(Context context, String cacheKey, String src, float width, float height, Transformer transformer, ImageInterceptor.CompletionHandler handler);

    void onDataUpdated(AnnieXLynxView annieXLynxView);

    void onFirstLoadPerfReady(AnnieXLynxView annieXLynxView, JSONObject pref);

    void onFirstScreen(AnnieXLynxView annieXLynxView);

    void onLoadFail(Uri uri, Throwable e);

    void onLoadFailed(AnnieXLynxView annieXLynxView, String errorMsg);

    void onLoadStart(Uri uri, AnnieXLynxView annieXLynxView);

    void onLoadUriSuccess(Uri uri, AnnieXLynxView annieXLynxView);

    void onModuleMethodInvoked(String module, String method, int error_code);

    void onPageStart(AnnieXLynxView annieXLynxView, String url);

    void onPageUpdate(AnnieXLynxView annieXLynxView);

    void onReceivedError(AnnieXLynxView annieXLynxView, LynxError error);

    void onReceivedError(AnnieXLynxView annieXLynxView, String errorMsg);

    void onRuntimeReady(AnnieXLynxView annieXLynxView);

    void onScrollStart(LynxViewClient.ScrollInfo info);

    void onScrollStop(LynxViewClient.ScrollInfo info);

    void onTemplateBundleReady(TemplateBundle templateBundle);

    void onTemplateReady(String resFrom, boolean isFromMemory);

    void onTimingSetup(Map<String, Object> timingInfo);

    void onTimingUpdate(Map<String, Object> timingInfo, Map<String, Long> updateTiming, String flag);

    void onUpdatePerfReady(AnnieXLynxView annieXLynxView, JSONObject pref);

    String shouldRedirectImageUrl(String url);
}
