package com.bytedance.ies.xbridge.event.idl_bridge;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebView;
import com.bytedance.ies.web.jsbridge.IESJsBridge;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.api.IContainerIDProvider;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostHeadSetDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostMemoryWaringDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostNaviDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostOpenDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.XBaseRuntime;
import com.bytedance.ies.xbridge.event.AppEvent;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.EventManager;
import com.bytedance.ies.xbridge.event.Subscriber;
import com.bytedance.ies.xbridge.event.bridge.KeyboardUtils;
import com.bytedance.ies.xbridge.event.idl.AbsXUnsubscribeEventMethodIDL;
import com.bytedance.ies.xbridge.model.idl.CompletionBlock;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import com.bytedance.ies.xbridge.utils.XBridgeKTXKt;
import com.bytedance.ies.xbridge.utils.XBridgeMethodHelper;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: XUnsubscribeEventMethod.kt */
@XBridgeMethod(name = "x.unsubscribeEvent")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/xbridge/event/idl_bridge/XUnsubscribeEventMethod;", "Lcom/bytedance/ies/xbridge/event/idl/AbsXUnsubscribeEventMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/protocol/StatefulMethod;", "()V", "getContainerId", "", "getContext", "Landroid/content/Context;", "getHostContainerID", "Lcom/bytedance/ies/xbridge/api/IContainerIDProvider;", "handle", "", "params", "Lcom/bytedance/ies/xbridge/event/idl/AbsXUnsubscribeEventMethodIDL$XUnsubscribeEventParamModel;", "callback", "Lcom/bytedance/ies/xbridge/model/idl/CompletionBlock;", "Lcom/bytedance/ies/xbridge/event/idl/AbsXUnsubscribeEventMethodIDL$XUnsubscribeEventResultModel;", "type", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class XUnsubscribeEventMethod extends AbsXUnsubscribeEventMethodIDL implements StatefulMethod {
    private final IContainerIDProvider getHostContainerID() {
        return (IContainerIDProvider) provideContext(IContainerIDProvider.class);
    }

    private final String getContainerId() {
        String provideContainerID;
        IContainerIDProvider hostContainerID = getHostContainerID();
        return (hostContainerID == null || (provideContainerID = hostContainerID.provideContainerID()) == null) ? "" : provideContainerID;
    }

    private final Context getContext() {
        return (Context) provideContext(Context.class);
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(AbsXUnsubscribeEventMethodIDL.XUnsubscribeEventParamModel params, CompletionBlock<AbsXUnsubscribeEventMethodIDL.XUnsubscribeEventResultModel> callback, XBridgePlatformType type) {
        XBaseRuntime instance;
        IHostMemoryWaringDepend memoryWaringDepend;
        IHostHeadSetDepend hostHeadSetDepend;
        IHostOpenDepend hostOpenDepend;
        IHostNaviDepend hostNaviDepend;
        IESJsBridge iESJsBridge;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(type, "type");
        try {
            if (params.getEventName().length() == 0) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, -3, null, null, 6, null);
                return;
            }
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
            } else if (Intrinsics.areEqual(eventName, AppEvent.AppStatusChange.getEventName())) {
                Activity activity = XBridgeMethodHelper.INSTANCE.getActivity(getContext());
                XBaseRuntime instance2 = XBaseRuntime.INSTANCE.getINSTANCE();
                if (instance2 != null && (hostNaviDepend = instance2.getHostNaviDepend()) != null) {
                    hostNaviDepend.unSetAppStatusChange(getContextProviderFactory(), activity);
                }
            } else if (Intrinsics.areEqual(eventName, AppEvent.GeckoResourceUpdated.getEventName())) {
                XBaseRuntime instance3 = XBaseRuntime.INSTANCE.getINSTANCE();
                if (instance3 != null && (hostOpenDepend = instance3.getHostOpenDepend()) != null) {
                    hostOpenDepend.unRegisterGeckoUpdateListener(containerId);
                }
            } else if (Intrinsics.areEqual(eventName, AppEvent.OnHeadSetPlug.getEventName())) {
                XBaseRuntime instance4 = XBaseRuntime.INSTANCE.getINSTANCE();
                if (instance4 != null && (hostHeadSetDepend = instance4.getHostHeadSetDepend()) != null) {
                    hostHeadSetDepend.unRegisterHeadSetListener(containerId);
                }
            } else if (Intrinsics.areEqual(eventName, AppEvent.MemoryWarning.getEventName()) && (instance = XBaseRuntime.INSTANCE.getINSTANCE()) != null && (memoryWaringDepend = instance.getMemoryWaringDepend()) != null) {
                memoryWaringDepend.unRegisterMemoryWaringListener(containerId);
            }
            EventCenter.unregisterSubscriber(new Subscriber(containerId, currentTimeMillis, jsEventDelegate, webView), eventName);
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXUnsubscribeEventMethodIDL.XUnsubscribeEventResultModel.class)), null, 2, null);
        } catch (NullPointerException unused) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, null, null, 6, null);
        }
    }
}
