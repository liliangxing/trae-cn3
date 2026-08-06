package com.bytedance.android.anniex.base.lifecycle;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.container.AnnieXContainer;
import com.bytedance.android.anniex.container.popup.AnnieXLynxViewNestedScrollUtil;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.schema.model.BDXContainerModel;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.lynx.tasm.LynxConfigInfo;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxPerfMetric;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewClient;
import com.lynx.tasm.behavior.ImageInterceptor;
import com.lynx.tasm.event.LynxEventDetail;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.xml.transform.Transformer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXLynxViewClientProxy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u0000 W2\u00020\u0001:\u0001WB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005JF\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001e\u0010\u0014\u001a\u00020\u00072\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\u001e\u0010\u001a\u001a\u00020\u00072\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\u0012\u0010!\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010$\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001e\u0010'\u001a\u00020\u00072\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0016J\u001a\u0010)\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-H\u0016J\u0012\u0010.\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u00100\u001a\u00020\u0007H\u0016J\u0012\u00101\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020\u0007H\u0016J$\u00105\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u00010\u000b2\b\u00107\u001a\u0004\u0018\u00010\u000b2\u0006\u00108\u001a\u000209H\u0016J\u0012\u0010:\u001a\u00020\u00072\b\u0010;\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010<\u001a\u00020\u0007H\u0016J\u001e\u0010=\u001a\u00020\u00072\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0016J\u0012\u0010>\u001a\u00020\u00072\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0012\u0010>\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010A\u001a\u00020\u00072\b\u0010B\u001a\u0004\u0018\u00010@H\u0016J\u0012\u0010C\u001a\u00020\u00072\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0012\u0010D\u001a\u00020\u00072\b\u0010E\u001a\u0004\u0018\u00010@H\u0016J\u0018\u0010F\u001a\u00020\u00072\u000e\u0010G\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010HH\u0016J\u0012\u0010I\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010JH\u0016J\b\u0010K\u001a\u00020\u0007H\u0016J\u0012\u0010L\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010M\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001e\u0010N\u001a\u00020\u00072\u0014\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0016J>\u0010P\u001a\u00020\u00072\u0014\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0014\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020R\u0018\u00010\u00162\b\u0010S\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010T\u001a\u00020\u0007H\u0016J\u0012\u0010U\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0014\u0010V\u001a\u0004\u0018\u00010\u000b2\b\u0010;\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/bytedance/android/anniex/base/lifecycle/AnnieXLynxViewClientProxy;", "Lcom/lynx/tasm/LynxViewClient;", "container", "Lcom/bytedance/android/anniex/container/AnnieXContainer;", "lynxViewClient", "(Lcom/bytedance/android/anniex/container/AnnieXContainer;Lcom/lynx/tasm/LynxViewClient;)V", "loadImage", "", "context", "Landroid/content/Context;", "cacheKey", "", "src", "width", "", "height", "transformer", "Ljavax/xml/transform/Transformer;", "handler", "Lcom/lynx/tasm/behavior/ImageInterceptor$CompletionHandler;", "onCallJSBFinished", "jsbTiming", "", "", "onDataUpdated", "onDestroy", "onDynamicComponentPerfReady", "perf", "Ljava/util/HashMap;", "onFirstLoadPerfReady", "metric", "Lcom/lynx/tasm/LynxPerfMetric;", "onFirstScreen", "onFling", "info", "Lcom/lynx/tasm/LynxViewClient$ScrollInfo;", "onFlushFinish", "flushInfo", "Lcom/lynx/tasm/LynxViewClient$FlushInfo;", "onJSBInvoked", "jsbInfo", "onKeyEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "handled", "", "onLoadFailed", "message", "onLoadSuccess", "onLynxEvent", "detail", "Lcom/lynx/tasm/event/LynxEventDetail;", "onLynxViewAndJSRuntimeDestroy", "onModuleMethodInvoked", "module", "method", "error_code", "", "onPageStart", StreamTrafficObservable.STREAM_URL, "onPageUpdate", "onPiperInvoked", "onReceivedError", "error", "Lcom/lynx/tasm/LynxError;", "onReceivedJSError", "jsError", "onReceivedJavaError", "onReceivedNativeError", "nativeError", "onReportComponentInfo", "mComponentSet", "", "onReportLynxConfigInfo", "Lcom/lynx/tasm/LynxConfigInfo;", "onRuntimeReady", "onScrollStart", "onScrollStop", "onTimingSetup", "timingInfo", "onTimingUpdate", "updateTiming", "", "flag", "onUpdateDataWithoutChange", "onUpdatePerfReady", "shouldRedirectImageUrl", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLynxViewClientProxy extends LynxViewClient {
    public static final String TAG = "AnnieXLynxViewClient";
    private final AnnieXContainer container;
    private final LynxViewClient lynxViewClient;

    public AnnieXLynxViewClientProxy(AnnieXContainer annieXContainer, LynxViewClient lynxViewClient) {
        Intrinsics.checkNotNullParameter(annieXContainer, "container");
        this.container = annieXContainer;
        this.lynxViewClient = lynxViewClient;
    }

    public String shouldRedirectImageUrl(String url) {
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.shouldRedirectImageUrl(url);
        }
        return super.shouldRedirectImageUrl(url);
    }

    public void loadImage(Context context, String cacheKey, String src, float width, float height, Transformer transformer, ImageInterceptor.CompletionHandler handler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(handler, "handler");
        super.loadImage(context, cacheKey, src, width, height, transformer, handler);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.loadImage(context, cacheKey, src, width, height, transformer, handler);
        }
    }

    public void onModuleMethodInvoked(String module, String method, int error_code) {
        super.onModuleMethodInvoked(module, method, error_code);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onModuleMethodInvoked(module, method, error_code);
        }
    }

    public void onPageStart(String url) {
        super.onPageStart(url);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onPageStart(url);
        }
    }

    public void onLoadSuccess() {
        super.onLoadSuccess();
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onLoadSuccess();
        }
    }

    public void onReportLynxConfigInfo(LynxConfigInfo info) {
        super.onReportLynxConfigInfo(info);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onReportLynxConfigInfo(info);
        }
    }

    public void onFirstScreen() {
        View findViewByRecursive;
        BooleanParam enableEngineViewScroll;
        BooleanParam pullDownClose;
        super.onFirstScreen();
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onFirstScreen();
        }
        LynxView kitView = this.container.getKitView();
        LynxView lynxView = kitView instanceof LynxView ? kitView : null;
        if (lynxView != null) {
            boolean z = false;
            if (Intrinsics.areEqual(this.container.getViewType(), AnnieX.CONTAINER_VIEW_TYPE_POPUP)) {
                BDXContainerModel annieXContainerModel$anniex_release = this.container.getAnnieXContainerModel$anniex_release();
                if (((annieXContainerModel$anniex_release == null || (pullDownClose = annieXContainerModel$anniex_release.getPullDownClose()) == null) ? false : Intrinsics.areEqual(pullDownClose.getValue(), true)) && IConditionCallKt.enableAnnieXDialogNestedScrollFix()) {
                    AnnieXLynxViewNestedScrollUtil.INSTANCE.handleNestedScrollWithVp(lynxView);
                }
            }
            if (Intrinsics.areEqual(this.container.getViewType(), AnnieX.CONTAINER_VIEW_TYPE_POPUP)) {
                BDXContainerModel annieXContainerModel$anniex_release2 = this.container.getAnnieXContainerModel$anniex_release();
                if (annieXContainerModel$anniex_release2 != null && (enableEngineViewScroll = annieXContainerModel$anniex_release2.getEnableEngineViewScroll()) != null) {
                    z = Intrinsics.areEqual(enableEngineViewScroll.getValue(), true);
                }
                if (!z || (findViewByRecursive = AnnieXLynxViewNestedScrollUtil.INSTANCE.findViewByRecursive((View) lynxView, new Function1<View, Boolean>() { // from class: com.bytedance.android.anniex.base.lifecycle.AnnieXLynxViewClientProxy$onFirstScreen$1$1
                    public final Boolean invoke(View view) {
                        Intrinsics.checkNotNullParameter(view, "view");
                        return Boolean.valueOf(view instanceof RecyclerView);
                    }
                })) == null) {
                    return;
                }
                this.container.setLynxWithScrollView$anniex_release(findViewByRecursive);
            }
        }
    }

    public void onPageUpdate() {
        super.onPageUpdate();
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onPageUpdate();
        }
    }

    public void onDataUpdated() {
        super.onDataUpdated();
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onDataUpdated();
        }
    }

    public void onLoadFailed(String message) {
        super.onLoadFailed(message);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onLoadFailed(message);
        }
    }

    public void onRuntimeReady() {
        super.onRuntimeReady();
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onRuntimeReady();
        }
    }

    public void onReceivedError(String info) {
        super.onReceivedError(info);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onReceivedError(info);
        }
    }

    public void onReceivedError(LynxError error) {
        super.onReceivedError(error);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onReceivedError(error);
        }
    }

    public void onReceivedJavaError(LynxError error) {
        super.onReceivedJavaError(error);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onReceivedJavaError(error);
        }
    }

    public void onReceivedJSError(LynxError jsError) {
        super.onReceivedJSError(jsError);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onReceivedJSError(jsError);
        }
    }

    public void onReceivedNativeError(LynxError nativeError) {
        super.onReceivedNativeError(nativeError);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onReceivedNativeError(nativeError);
        }
    }

    public void onFirstLoadPerfReady(LynxPerfMetric metric) {
        super.onFirstLoadPerfReady(metric);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onFirstLoadPerfReady(metric);
        }
    }

    public void onUpdatePerfReady(LynxPerfMetric metric) {
        super.onUpdatePerfReady(metric);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onUpdatePerfReady(metric);
        }
    }

    public void onDynamicComponentPerfReady(HashMap<String, Object> perf) {
        super.onDynamicComponentPerfReady(perf);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onDynamicComponentPerfReady(perf);
        }
    }

    public void onReportComponentInfo(Set<String> mComponentSet) {
        super.onReportComponentInfo(mComponentSet);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onReportComponentInfo(mComponentSet);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onDestroy();
        }
    }

    public void onUpdateDataWithoutChange() {
        super.onUpdateDataWithoutChange();
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onUpdateDataWithoutChange();
        }
    }

    public void onScrollStart(LynxViewClient.ScrollInfo info) {
        super.onScrollStart(info);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onScrollStart(info);
        }
    }

    public void onScrollStop(LynxViewClient.ScrollInfo info) {
        super.onScrollStop(info);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onScrollStop(info);
        }
    }

    public void onFling(LynxViewClient.ScrollInfo info) {
        super.onFling(info);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onFling(info);
        }
    }

    public void onFlushFinish(LynxViewClient.FlushInfo flushInfo) {
        super.onFlushFinish(flushInfo);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onFlushFinish(flushInfo);
        }
    }

    public void onPiperInvoked(Map<String, Object> info) {
        super.onPiperInvoked(info);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onPiperInvoked(info);
        }
    }

    public void onLynxViewAndJSRuntimeDestroy() {
        super.onLynxViewAndJSRuntimeDestroy();
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onLynxViewAndJSRuntimeDestroy();
        }
    }

    public void onKeyEvent(KeyEvent event, boolean handled) {
        super.onKeyEvent(event, handled);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onKeyEvent(event, handled);
        }
    }

    public void onTimingSetup(Map<String, Object> timingInfo) {
        super.onTimingSetup(timingInfo);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onTimingSetup(timingInfo);
        }
    }

    public void onTimingUpdate(Map<String, Object> timingInfo, Map<String, Long> updateTiming, String flag) {
        super.onTimingUpdate(timingInfo, updateTiming, flag);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onTimingUpdate(timingInfo, updateTiming, flag);
        }
    }

    public void onJSBInvoked(Map<String, Object> jsbInfo) {
        super.onJSBInvoked(jsbInfo);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onJSBInvoked(jsbInfo);
        }
    }

    public void onCallJSBFinished(Map<String, Object> jsbTiming) {
        super.onCallJSBFinished(jsbTiming);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onCallJSBFinished(jsbTiming);
        }
    }

    public void onLynxEvent(LynxEventDetail detail) {
        super.onLynxEvent(detail);
        LynxViewClient lynxViewClient = this.lynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onLynxEvent(detail);
        }
    }
}
