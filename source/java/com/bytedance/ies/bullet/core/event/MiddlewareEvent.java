package com.bytedance.ies.bullet.core.event;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.kit.bridge.Callback;
import com.bytedance.ies.bullet.core.kit.bridge.IBridge3Registry;
import com.bytedance.ies.bullet.core.kit.bridge.IBridgeRegistry;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.xbridge.BridgeDataConverterHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: MiddlewareEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/core/event/MiddlewareEvent;", "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "actionType", "", "name", "params", "Lorg/json/JSONObject;", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lcom/bytedance/ies/bullet/core/BulletContext;)V", "TAG", "kotlin.jvm.PlatformType", "getActionType", "()Ljava/lang/String;", "getBulletContext", "()Lcom/bytedance/ies/bullet/core/BulletContext;", "getName", "getParams", "()Lorg/json/JSONObject;", "checkActionLegal", "", "onEvent", "", "bridgeRegistry", "Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeRegistry;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class MiddlewareEvent implements IEvent {
    private final String TAG;
    private final String actionType;
    private final BulletContext bulletContext;
    private final String name;
    private final JSONObject params;

    /* compiled from: MiddlewareEvent.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KitType.values().length];
            try {
                iArr[KitType.WEB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KitType.LYNX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MiddlewareEvent(String str, String str2, JSONObject jSONObject, BulletContext bulletContext) {
        Intrinsics.checkNotNullParameter(str, "actionType");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.actionType = str;
        this.name = str2;
        this.params = jSONObject;
        this.bulletContext = bulletContext;
        this.TAG = "MiddlewareEvent";
    }

    public final String getActionType() {
        return this.actionType;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
    public JSONObject getParams() {
        return this.params;
    }

    public final BulletContext getBulletContext() {
        return this.bulletContext;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d8, code lost:
    
        if (com.bytedance.ies.bullet.core.BulletContextKt.useXBridge3(r6, r3 != null ? r3.getKitType() : null) == true) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onEvent(IBridgeRegistry bridgeRegistry) {
        String str;
        BulletLoadUriIdentifier uriIdentifier;
        if (checkActionLegal(this.actionType)) {
            final IGenericBridgeMethod bridgeInstance = bridgeRegistry != null ? bridgeRegistry.getBridgeInstance(getName()) : null;
            if (bridgeInstance != null && (bridgeInstance instanceof IBridgeMethod)) {
                if (bridgeRegistry != null) {
                    String name = getName();
                    JSONObject params = getParams();
                    if (params == null) {
                        params = new JSONObject();
                    }
                    bridgeRegistry.handle(name, params, new IBridgeMethod.ICallback() { // from class: com.bytedance.ies.bullet.core.event.MiddlewareEvent$onEvent$1
                        @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod.ICallback
                        public void onComplete(JSONObject data) {
                            String str2;
                            Intrinsics.checkNotNullParameter(data, "data");
                            BulletLogger bulletLogger = BulletLogger.INSTANCE;
                            StringBuilder sb = new StringBuilder();
                            str2 = MiddlewareEvent.this.TAG;
                            bulletLogger.printLog(sb.append(str2).append(" onComplete actionType:").append(MiddlewareEvent.this.getActionType()).append(", name:").append(MiddlewareEvent.this.getName()).toString(), LogLevel.D, "XView");
                        }

                        @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod.ICallback
                        public void onError(int code, String message) {
                            String str2;
                            Intrinsics.checkNotNullParameter(message, "message");
                            BulletLogger bulletLogger = BulletLogger.INSTANCE;
                            StringBuilder sb = new StringBuilder();
                            str2 = MiddlewareEvent.this.TAG;
                            bulletLogger.printLog(sb.append(str2).append(" onError actionType:").append(MiddlewareEvent.this.getActionType()).append(", code:").append(code).append(", message:").append(message).toString(), LogLevel.D, "XView");
                        }

                        @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod.ICallback
                        public void onError(int code, String message, JSONObject data) {
                            String str2;
                            Intrinsics.checkNotNullParameter(message, "message");
                            Intrinsics.checkNotNullParameter(data, "data");
                            BulletLogger bulletLogger = BulletLogger.INSTANCE;
                            StringBuilder sb = new StringBuilder();
                            str2 = MiddlewareEvent.this.TAG;
                            bulletLogger.printLog(sb.append(str2).append(" onError actionType:").append(MiddlewareEvent.this.getActionType()).append(", code:").append(code).append(", message:").append(message).toString(), LogLevel.D, "XView");
                        }
                    }, new Function1<Throwable, Unit>() { // from class: com.bytedance.ies.bullet.core.event.MiddlewareEvent$onEvent$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Throwable) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Throwable th) {
                            String str2;
                            Intrinsics.checkNotNullParameter(th, "it");
                            BulletLogger bulletLogger = BulletLogger.INSTANCE;
                            StringBuilder sb = new StringBuilder();
                            str2 = MiddlewareEvent.this.TAG;
                            bulletLogger.printLog(sb.append(str2).append(" onReject actionType:").append(MiddlewareEvent.this.getActionType()).append(", throwable:").append(th.getMessage()).toString(), LogLevel.D, "XView");
                        }
                    });
                    return;
                }
                return;
            }
            boolean z = true;
            if (bridgeInstance != null && (bridgeInstance instanceof IIDLGenericBridgeMethod)) {
                BulletContext bulletContext = this.bulletContext;
                if (bulletContext != null && (uriIdentifier = bulletContext.getUriIdentifier()) != null) {
                    r0 = uriIdentifier.getKitType();
                }
                int i = r0 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
                if (i == 1) {
                    str = BridgeDataConverterHolder.PLATFORM_WEB;
                } else {
                    if (i != 2) {
                        BulletLogger.INSTANCE.printLog("unknown platform " + r0, LogLevel.D, "XView");
                        return;
                    }
                    str = BridgeDataConverterHolder.PLATFORM_LYNX;
                }
                final Function2<Object, Class<?>, Object> platformInputType = BridgeDataConverterHolder.getPlatformInputType(str);
                final Function2<Object, Class<?>, Object> platformOutputType = BridgeDataConverterHolder.getPlatformOutputType(str);
                IIDLGenericBridgeMethod iIDLGenericBridgeMethod = (IIDLGenericBridgeMethod) bridgeInstance;
                iIDLGenericBridgeMethod.setLocalInputConverter(new Function1<Object, Object>() { // from class: com.bytedance.ies.bullet.core.event.MiddlewareEvent$onEvent$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public final Object invoke(Object obj) {
                        Intrinsics.checkNotNullParameter(obj, "it");
                        Function2<Object, Class<?>, Object> function2 = platformInputType;
                        if (function2 != null) {
                            Class<?> innerClassType = ((IIDLGenericBridgeMethod) bridgeInstance).getInnerClassType();
                            if (innerClassType == null) {
                                innerClassType = Object.class;
                            }
                            Object invoke = function2.invoke(obj, innerClassType);
                            if (invoke != null) {
                                return invoke;
                            }
                        }
                        return MapsKt.emptyMap();
                    }
                });
                iIDLGenericBridgeMethod.setLocalOutputConverter(new Function1<Object, Object>() { // from class: com.bytedance.ies.bullet.core.event.MiddlewareEvent$onEvent$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public final Object invoke(Object obj) {
                        Intrinsics.checkNotNullParameter(obj, "it");
                        Function2<Object, Class<?>, Object> function2 = platformOutputType;
                        if (function2 != null) {
                            Class<?> innerClassType = ((IIDLGenericBridgeMethod) bridgeInstance).getInnerClassType();
                            if (innerClassType == null) {
                                innerClassType = Object.class;
                            }
                            Object invoke = function2.invoke(obj, innerClassType);
                            if (invoke != null) {
                                return invoke;
                            }
                        }
                        return MapsKt.emptyMap();
                    }
                });
                String name2 = getName();
                JSONObject params2 = getParams();
                if (params2 == null) {
                    params2 = new JSONObject();
                }
                bridgeRegistry.handle(name2, params2, new IIDLGenericBridgeMethod.ICallback<Object>() { // from class: com.bytedance.ies.bullet.core.event.MiddlewareEvent$onEvent$5
                    @Override // com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod.ICallback
                    public void onComplete(Object data) {
                        String str2;
                        Intrinsics.checkNotNullParameter(data, "data");
                        BulletLogger bulletLogger = BulletLogger.INSTANCE;
                        StringBuilder sb = new StringBuilder();
                        str2 = MiddlewareEvent.this.TAG;
                        bulletLogger.printLog(sb.append(str2).append(" onComplete actionType:").append(MiddlewareEvent.this.getActionType()).append(", name:").append(MiddlewareEvent.this.getName()).toString(), LogLevel.D, "XView");
                    }

                    @Override // com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod.ICallback
                    public void onError(int code, String message) {
                        String str2;
                        Intrinsics.checkNotNullParameter(message, "message");
                        BulletLogger bulletLogger = BulletLogger.INSTANCE;
                        StringBuilder sb = new StringBuilder();
                        str2 = MiddlewareEvent.this.TAG;
                        bulletLogger.printLog(sb.append(str2).append(" onError actionType:").append(MiddlewareEvent.this.getActionType()).append(", code:").append(code).append(", message:").append(message).toString(), LogLevel.D, "XView");
                    }

                    @Override // com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod.ICallback
                    public void onError(int code, String message, Object data) {
                        String str2;
                        Intrinsics.checkNotNullParameter(message, "message");
                        Intrinsics.checkNotNullParameter(data, "data");
                        BulletLogger bulletLogger = BulletLogger.INSTANCE;
                        StringBuilder sb = new StringBuilder();
                        str2 = MiddlewareEvent.this.TAG;
                        bulletLogger.printLog(sb.append(str2).append(" onError actionType:").append(MiddlewareEvent.this.getActionType()).append(", code:").append(code).append(", message:").append(message).toString(), LogLevel.D, "XView");
                    }
                }, new Function1<Throwable, Unit>() { // from class: com.bytedance.ies.bullet.core.event.MiddlewareEvent$onEvent$6
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Throwable) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Throwable th) {
                        String str2;
                        Intrinsics.checkNotNullParameter(th, "it");
                        BulletLogger bulletLogger = BulletLogger.INSTANCE;
                        StringBuilder sb = new StringBuilder();
                        str2 = MiddlewareEvent.this.TAG;
                        bulletLogger.printLog(sb.append(str2).append(" onReject actionType:").append(MiddlewareEvent.this.getActionType()).append(", throwable:").append(th.getMessage()).toString(), LogLevel.D, "XView");
                    }
                });
                return;
            }
            BulletContext bulletContext2 = this.bulletContext;
            if (bulletContext2 != null) {
                BulletLoadUriIdentifier uriIdentifier2 = bulletContext2.getUriIdentifier();
            }
            z = false;
            if (z) {
                IBridge3Registry bridge3Registry = this.bulletContext.getBridge3Registry();
                if (bridge3Registry != null) {
                    String name3 = getName();
                    JSONObject params3 = getParams();
                    if (params3 == null) {
                        params3 = new JSONObject();
                    }
                    bridge3Registry.handle(name3, params3, new Callback() { // from class: com.bytedance.ies.bullet.core.event.MiddlewareEvent$onEvent$7
                        @Override // com.bytedance.ies.bullet.core.kit.bridge.Callback
                        public void invoke(Object... args) {
                            Intrinsics.checkNotNullParameter(args, "args");
                        }
                    });
                    return;
                }
                return;
            }
            BulletLogger bulletLogger = BulletLogger.INSTANCE;
            String str2 = "bridge " + getName() + " is not support";
            LogLevel logLevel = LogLevel.D;
            String str3 = this.TAG;
            Intrinsics.checkNotNullExpressionValue(str3, "TAG");
            bulletLogger.printLog(str2, logLevel, str3);
        }
    }

    private final boolean checkActionLegal(String actionType) {
        for (KitActionType kitActionType : KitActionType.values()) {
            if (Intrinsics.areEqual(kitActionType.getActionType(), actionType)) {
                return true;
            }
        }
        return false;
    }
}
