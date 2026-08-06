package com.bytedance.ies.xbridge.event.idl_bridge;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.webkit.WebView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ies.web.jsbridge.IESJsBridge;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.api.IContainerIDProvider;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostHeadSetDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostMemoryWaringDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostNaviDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostOpenDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.OnAppStatusChange;
import com.bytedance.ies.xbridge.base.runtime.depend.XBaseRuntime;
import com.bytedance.ies.xbridge.event.AppEvent;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.EventManager;
import com.bytedance.ies.xbridge.event.Subscriber;
import com.bytedance.ies.xbridge.event.bridge.AdVisibleAreaChangeMonitor;
import com.bytedance.ies.xbridge.event.bridge.KeyboardUtils;
import com.bytedance.ies.xbridge.event.idl.AbsXSubscribeEventMethodIDL;
import com.bytedance.ies.xbridge.model.idl.CompletionBlock;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import com.bytedance.ies.xbridge.utils.XBridgeKTXKt;
import com.bytedance.ies.xbridge.utils.XBridgeMethodHelper;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: XSubscribeEventMethod.kt */
@XBridgeMethod(name = "x.subscribeEvent")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/xbridge/event/idl_bridge/XSubscribeEventMethod;", "Lcom/bytedance/ies/xbridge/event/idl/AbsXSubscribeEventMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/protocol/StatefulMethod;", "()V", "adVisibleAreaChangeMonitor", "Lcom/bytedance/ies/xbridge/event/bridge/AdVisibleAreaChangeMonitor;", "getAdVisibleAreaChangeMonitor", "()Lcom/bytedance/ies/xbridge/event/bridge/AdVisibleAreaChangeMonitor;", "setAdVisibleAreaChangeMonitor", "(Lcom/bytedance/ies/xbridge/event/bridge/AdVisibleAreaChangeMonitor;)V", "getContainerId", "", "getContext", "Landroid/content/Context;", "getHostContainerID", "Lcom/bytedance/ies/xbridge/api/IContainerIDProvider;", "handle", "", "params", "Lcom/bytedance/ies/xbridge/event/idl/AbsXSubscribeEventMethodIDL$XSubscribeEventParamModel;", "callback", "Lcom/bytedance/ies/xbridge/model/idl/CompletionBlock;", "Lcom/bytedance/ies/xbridge/event/idl/AbsXSubscribeEventMethodIDL$XSubscribeEventResultModel;", "type", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class XSubscribeEventMethod extends AbsXSubscribeEventMethodIDL implements StatefulMethod {
    private AdVisibleAreaChangeMonitor adVisibleAreaChangeMonitor;

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

    public final AdVisibleAreaChangeMonitor getAdVisibleAreaChangeMonitor() {
        return this.adVisibleAreaChangeMonitor;
    }

    public final void setAdVisibleAreaChangeMonitor(AdVisibleAreaChangeMonitor adVisibleAreaChangeMonitor) {
        this.adVisibleAreaChangeMonitor = adVisibleAreaChangeMonitor;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(AbsXSubscribeEventMethodIDL.XSubscribeEventParamModel params, CompletionBlock<AbsXSubscribeEventMethodIDL.XSubscribeEventResultModel> callback, XBridgePlatformType type) {
        long longValue;
        Window window;
        Dialog dialog;
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(type, "type");
        final String containerId = getContainerId();
        final String eventName = params.getEventName();
        IDLXBridgeMethod.JSEventDelegate jSEventDelegate = (IDLXBridgeMethod.JSEventDelegate) provideContext(IDLXBridgeMethod.JSEventDelegate.class);
        IESJsBridge iESJsBridge = (IESJsBridge) provideContext(IESJsBridge.class);
        WebView webView = iESJsBridge != null ? iESJsBridge.getWebView() : null;
        AppEvent event = EventManager.INSTANCE.getEvent(eventName);
        if (event != null) {
            event.active();
        }
        if (eventName.length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, null, null, 6, null);
            return;
        }
        Number timestamp = params.getTimestamp();
        if (timestamp instanceof Number) {
            longValue = (long) asDouble(params.getTimestamp());
        } else {
            if (!(timestamp instanceof Integer)) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, -3, null, null, 6, null);
                return;
            }
            longValue = params.getTimestamp().longValue();
        }
        if (Intrinsics.areEqual(eventName, AppEvent.KeyboardStatusChange.getEventName())) {
            Context context = getContext();
            final FragmentActivity activity = XBridgeMethodHelper.INSTANCE.getActivity(context);
            FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? activity : null;
            Fragment findFragmentByTag = (fragmentActivity == null || (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) == null) ? null : supportFragmentManager.findFragmentByTag("BulletPopUp");
            DialogFragment dialogFragment = findFragmentByTag instanceof DialogFragment ? (DialogFragment) findFragmentByTag : null;
            AppEvent event2 = EventManager.INSTANCE.getEvent(eventName);
            if (event2 != null && event2.getIsActive()) {
                KeyboardUtils keyboardUtils = KeyboardUtils.INSTANCE;
                if (dialogFragment == null || (dialog = dialogFragment.getDialog()) == null || (window = dialog.getWindow()) == null) {
                    window = activity != null ? activity.getWindow() : null;
                }
                keyboardUtils.registerSoftInputChangedListener(context, window, new KeyboardUtils.OnSoftInputChangedListener() { // from class: com.bytedance.ies.xbridge.event.idl_bridge.XSubscribeEventMethod$handle$1
                    @Override // com.bytedance.ies.xbridge.event.bridge.KeyboardUtils.OnSoftInputChangedListener
                    public void onSoftInputChanged(int height) {
                        Event event3 = new Event(AppEvent.KeyboardStatusChange.getEventName(), System.currentTimeMillis(), null);
                        Pair[] pairArr = new Pair[2];
                        pairArr[0] = TuplesKt.to("height", Integer.valueOf(KeyboardUtils.INSTANCE.px2dp(activity, height)));
                        pairArr[1] = TuplesKt.to("visible", Boolean.valueOf(height != 0));
                        event3.setMapParams(MapsKt.mapOf(pairArr));
                        EventCenter.enqueueEvent(event3);
                    }
                });
            }
        } else if (Intrinsics.areEqual(eventName, AppEvent.AppStatusChange.getEventName())) {
            Activity activity2 = XBridgeMethodHelper.INSTANCE.getActivity(getContext());
            XBaseRuntime instance = XBaseRuntime.INSTANCE.getINSTANCE();
            IHostNaviDepend hostNaviDepend = instance != null ? instance.getHostNaviDepend() : null;
            if (hostNaviDepend != null) {
                hostNaviDepend.setOnAppStatusChange(getContextProviderFactory(), activity2, new OnAppStatusChange() { // from class: com.bytedance.ies.xbridge.event.idl_bridge.XSubscribeEventMethod$handle$2
                    @Override // com.bytedance.ies.xbridge.base.runtime.depend.OnAppStatusChange
                    public void onShow() {
                        AppEvent event3 = EventManager.INSTANCE.getEvent(eventName);
                        boolean z = false;
                        if (event3 != null && event3.getIsActive()) {
                            z = true;
                        }
                        if (z) {
                            Event event4 = new Event(AppEvent.AppStatusChange.getEventName(), System.currentTimeMillis(), null);
                            event4.setMapParams(MapsKt.mapOf(TuplesKt.to("active", true)));
                            EventCenter.enqueueEvent(event4);
                        }
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
                    
                        if (r0.getIsActive() == true) goto L8;
                     */
                    @Override // com.bytedance.ies.xbridge.base.runtime.depend.OnAppStatusChange
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void onHide() {
                        boolean z;
                        AppEvent event3 = EventManager.INSTANCE.getEvent(eventName);
                        if (event3 != null) {
                            z = true;
                        }
                        z = false;
                        if (z) {
                            Event event4 = new Event(AppEvent.AppStatusChange.getEventName(), System.currentTimeMillis(), null);
                            event4.setMapParams(MapsKt.mapOf(TuplesKt.to("active", false)));
                            EventCenter.enqueueEvent(event4);
                        }
                    }
                });
            }
        } else if (Intrinsics.areEqual(eventName, AppEvent.GeckoResourceUpdated.getEventName())) {
            AppEvent event3 = EventManager.INSTANCE.getEvent(eventName);
            if (event3 != null && event3.getIsActive()) {
                XBaseRuntime instance2 = XBaseRuntime.INSTANCE.getINSTANCE();
                IHostOpenDepend hostOpenDepend = instance2 != null ? instance2.getHostOpenDepend() : null;
                if (hostOpenDepend != null) {
                    hostOpenDepend.registerGeckoUpdateListener(containerId, new IHostOpenDepend.IGeckoUpdateListener() { // from class: com.bytedance.ies.xbridge.event.idl_bridge.XSubscribeEventMethod$handle$3
                        @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostOpenDepend.IGeckoUpdateListener
                        public void onGeckoUpdateSuccess(Object params2) {
                            if (params2 instanceof Map) {
                                Map map = (Map) params2;
                                Object obj = map.get("channel");
                                if (obj == null) {
                                    obj = "";
                                }
                                Object obj2 = map.get(IPiaCacheProvider.CacheConfig.FIELD_VERSION);
                                Object obj3 = obj2 != null ? obj2 : "";
                                Event event4 = new Event(AppEvent.GeckoResourceUpdated.getEventName(), System.currentTimeMillis(), null);
                                String str = containerId;
                                event4.setMapParams(MapsKt.mapOf(new Pair[]{TuplesKt.to("channel", obj), TuplesKt.to(IPiaCacheProvider.CacheConfig.FIELD_VERSION, obj3)}));
                                event4.setContainerID(str);
                                EventCenter.enqueueEvent(event4);
                            }
                        }
                    });
                }
            }
        } else if (Intrinsics.areEqual(eventName, AppEvent.OnHeadSetPlug.getEventName())) {
            AppEvent event4 = EventManager.INSTANCE.getEvent(eventName);
            if (event4 != null && event4.getIsActive()) {
                XBaseRuntime instance3 = XBaseRuntime.INSTANCE.getINSTANCE();
                IHostHeadSetDepend hostHeadSetDepend = instance3 != null ? instance3.getHostHeadSetDepend() : null;
                if (hostHeadSetDepend != null) {
                    hostHeadSetDepend.registerHeadSetListener(containerId, new IHostHeadSetDepend.IHeadSetListener() { // from class: com.bytedance.ies.xbridge.event.idl_bridge.XSubscribeEventMethod$handle$4
                        @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostHeadSetDepend.IHeadSetListener
                        public void onPlug(boolean isConnect, String type2) {
                            Intrinsics.checkNotNullParameter(type2, "type");
                            Event event5 = new Event(AppEvent.OnHeadSetPlug.getEventName(), System.currentTimeMillis(), null);
                            String str = containerId;
                            Pair[] pairArr = new Pair[2];
                            pairArr[0] = TuplesKt.to("state", isConnect ? "in" : "out");
                            pairArr[1] = TuplesKt.to("type", type2);
                            event5.setMapParams(MapsKt.mapOf(pairArr));
                            event5.setContainerID(str);
                            EventCenter.enqueueEvent(event5);
                        }
                    });
                }
            }
        } else if (Intrinsics.areEqual(eventName, AppEvent.MemoryWarning.getEventName())) {
            AppEvent event5 = EventManager.INSTANCE.getEvent(eventName);
            if (event5 != null && event5.getIsActive()) {
                XBaseRuntime instance4 = XBaseRuntime.INSTANCE.getINSTANCE();
                IHostMemoryWaringDepend memoryWaringDepend = instance4 != null ? instance4.getMemoryWaringDepend() : null;
                if (memoryWaringDepend != null) {
                    memoryWaringDepend.registerMemoryWaringListener(containerId, new IHostMemoryWaringDepend.IMemoryWaringListener() { // from class: com.bytedance.ies.xbridge.event.idl_bridge.XSubscribeEventMethod$handle$5
                        @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostMemoryWaringDepend.IMemoryWaringListener
                        public void onTrimMemory(int level) {
                            Event event6 = new Event(AppEvent.MemoryWarning.getEventName(), System.currentTimeMillis(), null);
                            String str = containerId;
                            event6.setMapParams(MapsKt.mapOf(TuplesKt.to("level", Integer.valueOf(level))));
                            event6.setContainerID(str);
                            EventCenter.enqueueEvent(event6);
                        }
                    });
                }
            }
        }
        Subscriber subscriber = new Subscriber(containerId, longValue, null, webView);
        subscriber.setIdlJsEventDelegate(jSEventDelegate);
        EventCenter.registerSubscriber(subscriber, eventName);
        CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXSubscribeEventMethodIDL.XSubscribeEventResultModel.class)), null, 2, null);
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public void release() {
        super.release();
        AdVisibleAreaChangeMonitor adVisibleAreaChangeMonitor = this.adVisibleAreaChangeMonitor;
        if (adVisibleAreaChangeMonitor != null) {
            adVisibleAreaChangeMonitor.disable();
        }
        EventCenter.release(getContainerId());
    }
}
