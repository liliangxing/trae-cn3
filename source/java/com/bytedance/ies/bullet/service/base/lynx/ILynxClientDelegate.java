package com.bytedance.ies.bullet.service.base.lynx;

import android.content.Context;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.monitor.deviceperf.ScrollInfo;
import java.util.Map;
import javax.xml.transform.Transformer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ILynxClientDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001/Jf\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u001c\u0010\u0010\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u00030\u0011H&J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0014\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0018\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u001b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u001d\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u001e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 H&J\u001c\u0010\u001e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\tH&J\u0012\u0010!\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$H&J\u0012\u0010%\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$H&J\u001e\u0010&\u001a\u00020\u00032\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010(H&J>\u0010)\u001a\u00020\u00032\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010(2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020+\u0018\u00010(2\b\u0010,\u001a\u0004\u0018\u00010\tH&J\u001c\u0010-\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\u0014\u0010.\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\tH&¨\u00060"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "", "loadImage", "", "viewService", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "context", "Landroid/content/Context;", "cacheKey", "", "src", "width", "", "height", "transformer", "Ljavax/xml/transform/Transformer;", "handler", "Lkotlin/Function2;", "", "onDataUpdated", "onFirstLoadPerfReady", "pref", "Lorg/json/JSONObject;", "onFirstScreen", "onLoadFailed", "errorMsg", "onLoadSuccess", "onPageStart", "url", "onPageUpdate", "onReceivedError", "error", "Lcom/bytedance/ies/bullet/service/base/lynx/LynxError;", "onRuntimeReady", "onScrollStart", "info", "Lcom/bytedance/ies/bullet/service/monitor/deviceperf/ScrollInfo;", "onScrollStop", "onTimingSetup", "timingInfo", "", "onTimingUpdate", "updateTiming", "", "flag", "onUpdatePerfReady", "shouldRedirectImageUrl", "Base", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface ILynxClientDelegate {
    void loadImage(IKitViewService viewService, Context context, String cacheKey, String src, float width, float height, Transformer transformer, Function2<Object, ? super Throwable, Unit> handler);

    void onDataUpdated(IKitViewService viewService);

    void onFirstLoadPerfReady(IKitViewService viewService, JSONObject pref);

    void onFirstScreen(IKitViewService viewService);

    void onLoadFailed(IKitViewService viewService, String errorMsg);

    void onLoadSuccess(IKitViewService viewService);

    void onPageStart(IKitViewService viewService, String url);

    void onPageUpdate(IKitViewService viewService);

    void onReceivedError(IKitViewService viewService, LynxError error);

    void onReceivedError(IKitViewService viewService, String errorMsg);

    void onRuntimeReady(IKitViewService viewService);

    void onScrollStart(ScrollInfo info);

    void onScrollStop(ScrollInfo info);

    void onTimingSetup(Map<String, Object> timingInfo);

    void onTimingUpdate(Map<String, Object> timingInfo, Map<String, Long> updateTiming, String flag);

    void onUpdatePerfReady(IKitViewService viewService, JSONObject pref);

    String shouldRedirectImageUrl(String url);

    /* compiled from: ILynxClientDelegate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002Jf\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00040\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0016\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u001a\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u001d\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010 \u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001c\u0010 \u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010#\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010$\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010'\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001e\u0010(\u001a\u00020\u00042\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010*H\u0016J>\u0010+\u001a\u00020\u00042\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010*2\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020-\u0018\u00010*2\b\u0010.\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010/\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0014\u00100\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0016¨\u00061"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate$Base;", "Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "()V", "loadImage", "", "viewService", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "context", "Landroid/content/Context;", "cacheKey", "", "src", "width", "", "height", "transformer", "Ljavax/xml/transform/Transformer;", "handler", "Lkotlin/Function2;", "", "", "onDataUpdated", "onFirstLoadPerfReady", "pref", "Lorg/json/JSONObject;", "onFirstScreen", "onLoadFailed", "errorMsg", "onLoadSuccess", "onPageStart", "url", "onPageUpdate", "onReceivedError", "error", "Lcom/bytedance/ies/bullet/service/base/lynx/LynxError;", "onRuntimeReady", "onScrollStart", "info", "Lcom/bytedance/ies/bullet/service/monitor/deviceperf/ScrollInfo;", "onScrollStop", "onTimingSetup", "timingInfo", "", "onTimingUpdate", "updateTiming", "", "flag", "onUpdatePerfReady", "shouldRedirectImageUrl", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static abstract class Base implements ILynxClientDelegate {
        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onDataUpdated(IKitViewService viewService) {
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onFirstLoadPerfReady(IKitViewService viewService, JSONObject pref) {
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onFirstScreen(IKitViewService viewService) {
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onLoadFailed(IKitViewService viewService, String errorMsg) {
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onLoadSuccess(IKitViewService viewService) {
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onPageStart(IKitViewService viewService, String url) {
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onPageUpdate(IKitViewService viewService) {
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onReceivedError(IKitViewService viewService, LynxError error) {
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onReceivedError(IKitViewService viewService, String errorMsg) {
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onRuntimeReady(IKitViewService viewService) {
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onScrollStart(ScrollInfo info) {
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onScrollStop(ScrollInfo info) {
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onTimingSetup(Map<String, Object> timingInfo) {
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onTimingUpdate(Map<String, Object> timingInfo, Map<String, Long> updateTiming, String flag) {
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onUpdatePerfReady(IKitViewService viewService, JSONObject pref) {
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public String shouldRedirectImageUrl(String url) {
            return null;
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void loadImage(IKitViewService viewService, Context context, String cacheKey, String src, float width, float height, Transformer transformer, Function2<Object, ? super Throwable, Unit> handler) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(handler, "handler");
            handler.invoke((Object) null, (Object) null);
        }
    }
}
