package com.bytedance.ies.bullet.base.bridge;

import android.content.Context;
import com.bytedance.android.anniex.worker.AnnieXWorkerTag;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.deprecate.fake.ContainerBidParam;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.api.BidConstants;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.CallContextDelegate;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.XBridge;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.api.IContainerIDProvider;
import com.bytedance.ies.xbridge.api.INameSpaceProvider;
import com.bytedance.ies.xbridge.model.context.XContextProviderFactory;
import com.bytedance.ies.xbridge.utils.XReadableJSONUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: BDXCompatMethodFinder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¨\u0006\f"}, d2 = {"getCallContext", "Lcom/bytedance/ies/web/jsbridge2/CallContext;", "bulletContainer", "Lcom/bytedance/ies/bullet/core/container/IBulletContainer;", "getXBridgeProviderFactory", "Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "resetEventDelegate", "", "contextProviderFactory", "xContextProviderFactory", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BDXCompatMethodFinderKt {
    private static final CallContext getCallContext(IBulletContainer iBulletContainer) {
        Context context;
        CallContext callContext = new CallContext();
        final IKitViewService kitView = iBulletContainer.getKitView();
        if (kitView != null) {
            callContext.setHybridView(kitView.realView());
            callContext.setContextDelegate(new CallContextDelegate() { // from class: com.bytedance.ies.bullet.base.bridge.BDXCompatMethodFinderKt$getCallContext$1$1$1
                @Override // com.bytedance.ies.web.jsbridge2.CallContextDelegate
                public <T> void onSendJsEvent(String eventName, T params) {
                    Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
                    IKitViewService.this.sendEvent(eventName, params);
                }
            });
        }
        BulletContext bulletContext = iBulletContainer.getBulletContext();
        if (bulletContext != null && (context = bulletContext.getContext()) != null) {
            callContext.setContext(context);
        }
        callContext.setBizKey(BidConstants.WEBCAST);
        callContext.setUrl(String.valueOf(iBulletContainer.getCurrentUri()));
        callContext.setAnnieXCall(true);
        return callContext;
    }

    public static final XContextProviderFactory getXBridgeProviderFactory(ContextProviderFactory contextProviderFactory) {
        String bid;
        Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
        ContainerBidParam containerBidParam = (ContainerBidParam) contextProviderFactory.provideInstance(ContainerBidParam.class);
        boolean equals = (containerBidParam == null || (bid = containerBidParam.getBid()) == null) ? false : bid.equals(BidConstants.WEBCAST);
        if (IConditionCallKt.disableBridgeContainerLeak()) {
            final IBulletContainer iBulletContainer = (IBulletContainer) contextProviderFactory.provideInstance(IBulletContainer.class);
            XContextProviderFactory xContextProviderFactory = new XContextProviderFactory();
            xContextProviderFactory.registerWeakHolder(Context.class, contextProviderFactory.provideInstance(Context.class));
            xContextProviderFactory.registerWeakHolder(ContextProviderFactory.class, contextProviderFactory);
            xContextProviderFactory.registerHolder(INameSpaceProvider.class, new INameSpaceProvider() { // from class: com.bytedance.ies.bullet.base.bridge.BDXCompatMethodFinderKt$getXBridgeProviderFactory$contextProvider$1$1
                @Override // com.bytedance.ies.xbridge.api.INameSpaceProvider
                public String getNameSpace() {
                    return XBridge.DEFAULT_NAMESPACE;
                }
            });
            if (equals) {
                CallContext callContext = (CallContext) contextProviderFactory.provideInstance(CallContext.class);
                if (callContext == null && iBulletContainer != null) {
                    callContext = getCallContext(iBulletContainer);
                }
                if (IConditionCallKt.enableBridgeProviderRelease()) {
                    xContextProviderFactory.registerHolder(CallContext.class, callContext);
                } else {
                    xContextProviderFactory.registerWeakHolder(CallContext.class, callContext);
                }
            }
            xContextProviderFactory.registerHolder(XBridgeMethod.JsEventDelegate.class, new XBridgeMethod.JsEventDelegate() { // from class: com.bytedance.ies.bullet.base.bridge.BDXCompatMethodFinderKt$getXBridgeProviderFactory$contextProvider$1$2
                @Override // com.bytedance.ies.xbridge.XBridgeMethod.JsEventDelegate
                public void sendJsEvent(final String eventName, final XReadableMap params) {
                    Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
                    IBulletContainer iBulletContainer2 = IBulletContainer.this;
                    if (iBulletContainer2 != null) {
                        iBulletContainer2.onEvent(new IEvent(eventName, params) { // from class: com.bytedance.ies.bullet.base.bridge.BDXCompatMethodFinderKt$getXBridgeProviderFactory$contextProvider$1$2$sendJsEvent$1
                            private final String name;
                            private final JSONObject params;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                JSONObject xReadableMapToJSONObject;
                                this.name = eventName;
                                this.params = (params == null || (xReadableMapToJSONObject = XReadableJSONUtils.INSTANCE.xReadableMapToJSONObject(params)) == null) ? new JSONObject() : xReadableMapToJSONObject;
                            }

                            @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
                            public String getName() {
                                return this.name;
                            }

                            @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
                            public JSONObject getParams() {
                                return this.params;
                            }
                        });
                    }
                }
            });
            xContextProviderFactory.registerHolder(IContainerIDProvider.class, new IContainerIDProvider() { // from class: com.bytedance.ies.bullet.base.bridge.BDXCompatMethodFinderKt$getXBridgeProviderFactory$contextProvider$1$3
                @Override // com.bytedance.ies.xbridge.api.IContainerIDProvider
                public String provideContainerID() {
                    String sessionId;
                    IBulletContainer iBulletContainer2 = IBulletContainer.this;
                    return (iBulletContainer2 == null || (sessionId = iBulletContainer2.getSessionId()) == null) ? "" : sessionId;
                }
            });
            xContextProviderFactory.registerHolder(IDLXBridgeMethod.JSEventDelegate.class, new IDLXBridgeMethod.JSEventDelegate() { // from class: com.bytedance.ies.bullet.base.bridge.BDXCompatMethodFinderKt$getXBridgeProviderFactory$contextProvider$1$4
                @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod.JSEventDelegate
                public void sendJSEvent(final String eventName, final Map<String, ? extends Object> params) {
                    Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
                    IBulletContainer iBulletContainer2 = IBulletContainer.this;
                    if (iBulletContainer2 != null) {
                        iBulletContainer2.onEvent(new IEvent(eventName, params) { // from class: com.bytedance.ies.bullet.base.bridge.BDXCompatMethodFinderKt$getXBridgeProviderFactory$contextProvider$1$4$sendJSEvent$1
                            private final String name;
                            private final JSONObject params;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.name = eventName;
                                this.params = params != null ? new JSONObject(params) : new JSONObject();
                            }

                            @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
                            public String getName() {
                                return this.name;
                            }

                            @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
                            public JSONObject getParams() {
                                return this.params;
                            }
                        });
                    }
                }
            });
            resetEventDelegate(contextProviderFactory, xContextProviderFactory);
            return xContextProviderFactory;
        }
        IBulletContainer iBulletContainer2 = (IBulletContainer) contextProviderFactory.provideInstance(IBulletContainer.class);
        final XContextProviderFactory xContextProviderFactory2 = new XContextProviderFactory();
        xContextProviderFactory2.registerWeakHolder(Context.class, contextProviderFactory.provideInstance(Context.class));
        xContextProviderFactory2.registerWeakHolder(ContextProviderFactory.class, contextProviderFactory);
        xContextProviderFactory2.registerHolder(INameSpaceProvider.class, new INameSpaceProvider() { // from class: com.bytedance.ies.bullet.base.bridge.BDXCompatMethodFinderKt$getXBridgeProviderFactory$contextProvider$2$1
            @Override // com.bytedance.ies.xbridge.api.INameSpaceProvider
            public String getNameSpace() {
                return XBridge.DEFAULT_NAMESPACE;
            }
        });
        if (equals) {
            CallContext callContext2 = (CallContext) contextProviderFactory.provideInstance(CallContext.class);
            if (callContext2 == null && iBulletContainer2 != null) {
                callContext2 = getCallContext(iBulletContainer2);
            }
            if (IConditionCallKt.enableBridgeProviderRelease()) {
                xContextProviderFactory2.registerHolder(CallContext.class, callContext2);
            } else {
                xContextProviderFactory2.registerWeakHolder(CallContext.class, callContext2);
            }
        }
        xContextProviderFactory2.registerHolder(XBridgeMethod.JsEventDelegate.class, new XBridgeMethod.JsEventDelegate() { // from class: com.bytedance.ies.bullet.base.bridge.BDXCompatMethodFinderKt$getXBridgeProviderFactory$contextProvider$2$2
            @Override // com.bytedance.ies.xbridge.XBridgeMethod.JsEventDelegate
            public void sendJsEvent(final String eventName, final XReadableMap params) {
                IBulletContainer iBulletContainer3;
                Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
                ContextProviderFactory contextProviderFactory2 = (ContextProviderFactory) XContextProviderFactory.this.provideInstance(ContextProviderFactory.class);
                if (contextProviderFactory2 == null || (iBulletContainer3 = (IBulletContainer) contextProviderFactory2.provideInstance(IBulletContainer.class)) == null) {
                    return;
                }
                iBulletContainer3.onEvent(new IEvent(eventName, params) { // from class: com.bytedance.ies.bullet.base.bridge.BDXCompatMethodFinderKt$getXBridgeProviderFactory$contextProvider$2$2$sendJsEvent$1
                    private final String name;
                    private final JSONObject params;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        JSONObject xReadableMapToJSONObject;
                        this.name = eventName;
                        this.params = (params == null || (xReadableMapToJSONObject = XReadableJSONUtils.INSTANCE.xReadableMapToJSONObject(params)) == null) ? new JSONObject() : xReadableMapToJSONObject;
                    }

                    @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
                    public String getName() {
                        return this.name;
                    }

                    @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
                    public JSONObject getParams() {
                        return this.params;
                    }
                });
            }
        });
        xContextProviderFactory2.registerHolder(IContainerIDProvider.class, new IContainerIDProvider() { // from class: com.bytedance.ies.bullet.base.bridge.BDXCompatMethodFinderKt$getXBridgeProviderFactory$contextProvider$2$3
            @Override // com.bytedance.ies.xbridge.api.IContainerIDProvider
            public String provideContainerID() {
                IBulletContainer iBulletContainer3;
                String sessionId;
                ContextProviderFactory contextProviderFactory2 = (ContextProviderFactory) XContextProviderFactory.this.provideInstance(ContextProviderFactory.class);
                return (contextProviderFactory2 == null || (iBulletContainer3 = (IBulletContainer) contextProviderFactory2.provideInstance(IBulletContainer.class)) == null || (sessionId = iBulletContainer3.getSessionId()) == null) ? "" : sessionId;
            }
        });
        xContextProviderFactory2.registerHolder(IDLXBridgeMethod.JSEventDelegate.class, new IDLXBridgeMethod.JSEventDelegate() { // from class: com.bytedance.ies.bullet.base.bridge.BDXCompatMethodFinderKt$getXBridgeProviderFactory$contextProvider$2$4
            @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod.JSEventDelegate
            public void sendJSEvent(final String eventName, final Map<String, ? extends Object> params) {
                IBulletContainer iBulletContainer3;
                Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
                ContextProviderFactory contextProviderFactory2 = (ContextProviderFactory) XContextProviderFactory.this.provideInstance(ContextProviderFactory.class);
                if (contextProviderFactory2 == null || (iBulletContainer3 = (IBulletContainer) contextProviderFactory2.provideInstance(IBulletContainer.class)) == null) {
                    return;
                }
                iBulletContainer3.onEvent(new IEvent(eventName, params) { // from class: com.bytedance.ies.bullet.base.bridge.BDXCompatMethodFinderKt$getXBridgeProviderFactory$contextProvider$2$4$sendJSEvent$1
                    private final String name;
                    private final JSONObject params;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.name = eventName;
                        this.params = params != null ? new JSONObject(params) : new JSONObject();
                    }

                    @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
                    public String getName() {
                        return this.name;
                    }

                    @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
                    public JSONObject getParams() {
                        return this.params;
                    }
                });
            }
        });
        resetEventDelegate(contextProviderFactory, xContextProviderFactory2);
        return xContextProviderFactory2;
    }

    private static final void resetEventDelegate(ContextProviderFactory contextProviderFactory, XContextProviderFactory xContextProviderFactory) {
        if (contextProviderFactory.provideInstance(AnnieXWorkerTag.class) == null || !IConditionCallKt.enableWorkerEventReset()) {
            return;
        }
        IDLXBridgeMethod.JSEventDelegate jSEventDelegate = (IDLXBridgeMethod.JSEventDelegate) contextProviderFactory.provideInstance(IDLXBridgeMethod.JSEventDelegate.class);
        if (jSEventDelegate != null) {
            xContextProviderFactory.registerHolder(IDLXBridgeMethod.JSEventDelegate.class, jSEventDelegate);
        }
        XBridgeMethod.JsEventDelegate jsEventDelegate = (XBridgeMethod.JsEventDelegate) contextProviderFactory.provideInstance(XBridgeMethod.JsEventDelegate.class);
        if (jsEventDelegate != null) {
            xContextProviderFactory.registerHolder(XBridgeMethod.JsEventDelegate.class, jsEventDelegate);
        }
    }
}
