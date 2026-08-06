package com.bytedance.ies.xbridge.event.bridge;

import android.content.Context;
import android.webkit.WebView;
import com.bytedance.ies.web.jsbridge.IESJsBridge;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.api.IContainerIDProvider;
import com.bytedance.ies.xbridge.event.AppEvent;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.EventManager;
import com.bytedance.ies.xbridge.event.Subscriber;
import com.bytedance.ies.xbridge.event.base.AbsXUnsubscribeEventMethod;
import com.bytedance.ies.xbridge.event.model.XUnsubscribeEventMethodParamModel;
import com.bytedance.ies.xbridge.model.results.XDefaultResultModel;
import com.bytedance.ies.xbridge.utils.XBridgeMethodHelper;
import com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XUnsubscribeEventMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/xbridge/event/bridge/XUnsubscribeEventMethod;", "Lcom/bytedance/ies/xbridge/event/base/AbsXUnsubscribeEventMethod;", "Lcom/bytedance/sdk/xbridge/cn/protocol/StatefulMethod;", "()V", "getContainerId", "", "getContext", "Landroid/content/Context;", "getHostContainerID", "Lcom/bytedance/ies/xbridge/api/IContainerIDProvider;", "handle", "", "params", "Lcom/bytedance/ies/xbridge/event/model/XUnsubscribeEventMethodParamModel;", "callback", "Lcom/bytedance/ies/xbridge/event/base/AbsXUnsubscribeEventMethod$XUnsubscribeEventCallback;", "type", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class XUnsubscribeEventMethod extends AbsXUnsubscribeEventMethod implements StatefulMethod {
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

    @Override // com.bytedance.ies.xbridge.event.base.AbsXUnsubscribeEventMethod
    public void handle(XUnsubscribeEventMethodParamModel params, AbsXUnsubscribeEventMethod.XUnsubscribeEventCallback callback, XBridgePlatformType type) {
        IESJsBridge iESJsBridge;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(type, "type");
        String eventName = params.getEventName();
        String containerId = getContainerId();
        long currentTimeMillis = System.currentTimeMillis();
        XBridgeMethod.JsEventDelegate jsEventDelegate = (XBridgeMethod.JsEventDelegate) provideContext(XBridgeMethod.JsEventDelegate.class);
        WebView webView = (!(containerId.length() == 0) || (iESJsBridge = (IESJsBridge) provideContext(IESJsBridge.class)) == null) ? null : iESJsBridge.getWebView();
        AppEvent event = EventManager.INSTANCE.getEvent(eventName);
        if (event != null) {
            event.unActive();
        }
        if (Intrinsics.areEqual(eventName, AppEvent.KeyboardStatusChange.getEventName())) {
            KeyboardUtils.INSTANCE.unregisterSoftInputChangedListener(XBridgeMethodHelper.INSTANCE.getActivity(getContext()));
        }
        EventCenter.unregisterSubscriber(new Subscriber(containerId, currentTimeMillis, jsEventDelegate, webView), eventName);
        AbsXUnsubscribeEventMethod.XUnsubscribeEventCallback.DefaultImpls.onSuccess$default(callback, new XDefaultResultModel(), null, 2, null);
    }
}
