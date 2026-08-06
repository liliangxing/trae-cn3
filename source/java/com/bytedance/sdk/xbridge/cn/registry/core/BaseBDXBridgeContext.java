package com.bytedance.sdk.xbridge.cn.registry.core;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeMethodHelper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IBDXBridgeContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J#\u0010\u0014\u001a\u0004\u0018\u0001H\u0015\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u000fH\u0016¢\u0006\u0002\u0010\u0017J'\u0010\u0018\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u000f2\u0006\u0010\u001a\u001a\u0002H\u0015¢\u0006\u0002\u0010\u001bJ/\u0010\u0018\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u000f2\u0006\u0010\u001a\u001a\u0002H\u00152\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0019J(\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00032\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010#H\u0016J\u001a\u0010%\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\"\u0010\r\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/BaseBDXBridgeContext;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXContainerContext;", "containerID", "", "engineView", "Landroid/view/View;", LynxBridgeCall.NAME_SPACE, "(Ljava/lang/String;Landroid/view/View;Ljava/lang/String;)V", "getContainerID", "()Ljava/lang/String;", "engineViewRef", "Ljava/lang/ref/WeakReference;", "getNamespace", "providers", "", "Ljava/lang/Class;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IXContextProvider;", "getEngineView", "getOwnerActivity", "Landroid/app/Activity;", "getService", "T", "clazz", "(Ljava/lang/Class;)Ljava/lang/Object;", "registerService", "", "t", "(Ljava/lang/Class;Ljava/lang/Object;)V", "refType", "Lcom/bytedance/sdk/xbridge/cn/registry/core/RefType;", "(Ljava/lang/Class;Ljava/lang/Object;Lcom/bytedance/sdk/xbridge/cn/registry/core/RefType;)V", "release", "sendEvent", "eventName", "params", "", "", "unRegisterService", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class BaseBDXBridgeContext implements IBDXContainerContext {
    private final String containerID;
    private final View engineView;
    private WeakReference<View> engineViewRef;
    private final String namespace;
    private final Map<Class<?>, IXContextProvider<?>> providers;

    /* compiled from: IBDXBridgeContext.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RefType.values().length];
            try {
                iArr[RefType.WEAK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RefType.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BaseBDXBridgeContext(String str, View view, String str2) {
        Intrinsics.checkNotNullParameter(str, "containerID");
        Intrinsics.checkNotNullParameter(view, "engineView");
        Intrinsics.checkNotNullParameter(str2, LynxBridgeCall.NAME_SPACE);
        this.containerID = str;
        this.engineView = view;
        this.namespace = str2;
        this.providers = new ConcurrentHashMap();
        this.engineViewRef = new WeakReference<>(view);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public String getContainerID() {
        return this.containerID;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public String getNamespace() {
        return this.namespace;
    }

    public final <T> void registerService(Class<T> clazz, T t, RefType refType) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(refType, "refType");
        int i = WhenMappings.$EnumSwitchMapping$0[refType.ordinal()];
        if (i == 1) {
            this.providers.put(clazz, new XWeakContextHolder(t));
        } else {
            if (i != 2) {
                return;
            }
            this.providers.put(clazz, new ContextHolder(t));
        }
    }

    public final <T> void unRegisterService(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        this.providers.remove(clazz);
    }

    public final <T> void registerService(Class<T> clazz, T t) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        this.providers.put(clazz, new XWeakContextHolder(t));
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public <T> T getService(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        IXContextProvider<?> iXContextProvider = this.providers.get(clazz);
        if (iXContextProvider != null) {
            return (T) iXContextProvider.provideInstance();
        }
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public View getEngineView() {
        return this.engineViewRef.get();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public Activity getOwnerActivity() {
        View engineView = getEngineView();
        return XBridgeMethodHelper.INSTANCE.getActivity(engineView != null ? engineView.getContext() : null);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public void sendEvent(String eventName, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        getJsEventDelegate().sendJSEvent(eventName, params);
    }

    public final void release() {
        Iterator<IXContextProvider<?>> it = this.providers.values().iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        this.providers.clear();
    }
}
