package com.bytedance.ies.xbridge.event.bridge;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebView;
import com.bytedance.ies.web.jsbridge.IESJsBridge;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.api.IContainerIDProvider;
import com.bytedance.ies.xbridge.event.AppEvent;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.EventManager;
import com.bytedance.ies.xbridge.event.Subscriber;
import com.bytedance.ies.xbridge.event.base.AbsXSubscribeEventMethod;
import com.bytedance.ies.xbridge.event.bridge.KeyboardUtils;
import com.bytedance.ies.xbridge.event.model.XSubscribeEventMethodParamModel;
import com.bytedance.ies.xbridge.model.collections.defaultimpl.DefaultXReadableMapImpl;
import com.bytedance.ies.xbridge.model.results.XDefaultResultModel;
import com.bytedance.ies.xbridge.utils.XBridgeMethodHelper;
import com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: XSubscribeEventMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/xbridge/event/bridge/XSubscribeEventMethod;", "Lcom/bytedance/ies/xbridge/event/base/AbsXSubscribeEventMethod;", "Lcom/bytedance/sdk/xbridge/cn/protocol/StatefulMethod;", "()V", "getContainerId", "", "getContext", "Landroid/content/Context;", "getHostContainerID", "Lcom/bytedance/ies/xbridge/api/IContainerIDProvider;", "handle", "", "params", "Lcom/bytedance/ies/xbridge/event/model/XSubscribeEventMethodParamModel;", "callback", "Lcom/bytedance/ies/xbridge/event/base/AbsXSubscribeEventMethod$XSubscribeEventCallback;", "type", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class XSubscribeEventMethod extends AbsXSubscribeEventMethod implements StatefulMethod {
    private final Context getContext() {
        return (Context) provideContext(Context.class);
    }

    private final IContainerIDProvider getHostContainerID() {
        return (IContainerIDProvider) provideContext(IContainerIDProvider.class);
    }

    private final String getContainerId() {
        String provideContainerID;
        IContainerIDProvider hostContainerID = getHostContainerID();
        return (hostContainerID == null || (provideContainerID = hostContainerID.provideContainerID()) == null) ? "" : provideContainerID;
    }

    @Override // com.bytedance.ies.xbridge.event.base.AbsXSubscribeEventMethod
    public void handle(XSubscribeEventMethodParamModel params, AbsXSubscribeEventMethod.XSubscribeEventCallback callback, XBridgePlatformType type) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(type, "type");
        String containerId = getContainerId();
        String eventName = params.getEventName();
        long timestamp = params.getTimestamp();
        XBridgeMethod.JsEventDelegate jsEventDelegate = (XBridgeMethod.JsEventDelegate) provideContext(XBridgeMethod.JsEventDelegate.class);
        IESJsBridge iESJsBridge = (IESJsBridge) provideContext(IESJsBridge.class);
        WebView webView = iESJsBridge != null ? iESJsBridge.getWebView() : null;
        AppEvent event = EventManager.INSTANCE.getEvent(eventName);
        if (event != null) {
            event.active();
        }
        if (Intrinsics.areEqual(eventName, AppEvent.KeyboardStatusChange.getEventName())) {
            Context context = getContext();
            Activity activity = XBridgeMethodHelper.INSTANCE.getActivity(context);
            AppEvent event2 = EventManager.INSTANCE.getEvent(eventName);
            boolean z = false;
            if (event2 != null && event2.getIsActive()) {
                z = true;
            }
            if (z) {
                KeyboardUtils.INSTANCE.registerSoftInputChangedListener(context, activity != null ? activity.getWindow() : null, new KeyboardUtils.OnSoftInputChangedListener() { // from class: com.bytedance.ies.xbridge.event.bridge.XSubscribeEventMethod$handle$1
                    @Override // com.bytedance.ies.xbridge.event.bridge.KeyboardUtils.OnSoftInputChangedListener
                    public void onSoftInputChanged(int height) {
                        String eventName2 = AppEvent.KeyboardStatusChange.getEventName();
                        long currentTimeMillis = System.currentTimeMillis();
                        Pair[] pairArr = new Pair[2];
                        pairArr[0] = TuplesKt.to("height1", Integer.valueOf(height));
                        pairArr[1] = TuplesKt.to("visible", Boolean.valueOf(height != 0));
                        EventCenter.enqueueEvent(new Event(eventName2, currentTimeMillis, new DefaultXReadableMapImpl(new JSONObject(MapsKt.mapOf(pairArr)))));
                    }
                });
            }
        }
        EventCenter.registerSubscriber(new Subscriber(containerId, timestamp, jsEventDelegate, webView), eventName);
        AbsXSubscribeEventMethod.XSubscribeEventCallback.DefaultImpls.onSuccess$default(callback, new XDefaultResultModel(), null, 2, null);
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public void release() {
        super.release();
        EventCenter.release(getContainerId());
    }
}
