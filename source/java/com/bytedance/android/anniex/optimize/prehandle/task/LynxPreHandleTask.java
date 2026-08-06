package com.bytedance.android.anniex.optimize.prehandle.task;

import com.bytedance.android.anniex.ability.service.IAnnieXPiaMethodProvider;
import com.bytedance.android.anniex.optimize.prehandle.api.BaseHandleBridgeContext;
import com.bytedance.android.anniex.optimize.prehandle.api.IPreHandleTask;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import com.bytedance.sdk.xbridge.cn.platform.lynx.ReadableMapBridgeHandler;
import com.bytedance.sdk.xbridge.cn.protocol.BaseBridgeHandler;
import com.bytedance.sdk.xbridge.cn.protocol.BridgeResultCallback;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxPreHandleTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR)\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/anniex/optimize/prehandle/task/LynxPreHandleTask;", "Lcom/bytedance/android/anniex/optimize/prehandle/api/IPreHandleTask;", "Lcom/lynx/react/bridge/ReadableMap;", "", "bid", "", "(Ljava/lang/String;)V", "getBid", "()Ljava/lang/String;", "handler", "Lcom/bytedance/sdk/xbridge/cn/protocol/BaseBridgeHandler;", "getHandler", "()Lcom/bytedance/sdk/xbridge/cn/protocol/BaseBridgeHandler;", "methods", "", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "getMethods", "()Ljava/util/Map;", "methods$delegate", "Lkotlin/Lazy;", "preHandleMethod", "methodCalls", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LynxPreHandleTask implements IPreHandleTask<ReadableMap, Object> {
    private final String bid;
    private final BaseBridgeHandler<ReadableMap, Object> handler;

    /* renamed from: methods$delegate, reason: from kotlin metadata */
    private final Lazy methods;

    public LynxPreHandleTask(String str) {
        Intrinsics.checkNotNullParameter(str, "bid");
        this.bid = str;
        this.methods = LazyKt.lazy(new Function0<Map<String, ? extends IDLXBridgeMethod>>() { // from class: com.bytedance.android.anniex.optimize.prehandle.task.LynxPreHandleTask$methods$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final Map<String, IDLXBridgeMethod> invoke() {
                IAnnieXPiaMethodProvider iAnnieXPiaMethodProvider = (IAnnieXPiaMethodProvider) ServiceCenter.Companion.instance().get(LynxPreHandleTask.this.getBid(), IAnnieXPiaMethodProvider.class);
                if (iAnnieXPiaMethodProvider != null) {
                    return iAnnieXPiaMethodProvider.providerPreHandleMethod(LynxPreHandleTask.this.getBid());
                }
                return null;
            }
        });
        BaseBridgeHandler<ReadableMap, Object> readableMapBridgeHandler = new ReadableMapBridgeHandler<>();
        readableMapBridgeHandler.setNamespace(getBid());
        this.handler = readableMapBridgeHandler;
    }

    @Override // com.bytedance.android.anniex.optimize.prehandle.api.IPreHandleTask
    public String getBid() {
        return this.bid;
    }

    private final Map<String, IDLXBridgeMethod> getMethods() {
        return (Map) this.methods.getValue();
    }

    @Override // com.bytedance.android.anniex.optimize.prehandle.api.IPreHandleTask
    public BaseBridgeHandler<ReadableMap, Object> getHandler() {
        return this.handler;
    }

    @Override // com.bytedance.android.anniex.optimize.prehandle.api.IPreHandleTask
    public Map<String, Object> preHandleMethod(List<String> methodCalls) {
        IDLXBridgeMethod iDLXBridgeMethod;
        Intrinsics.checkNotNullParameter(methodCalls, "methodCalls");
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (final String str : methodCalls) {
            Map<String, IDLXBridgeMethod> methods = getMethods();
            if (methods != null && (iDLXBridgeMethod = methods.get(str)) != null) {
                final BaseBridgeCall lynxBridgeCall = new LynxBridgeCall(str, new JavaOnlyMap(), "");
                lynxBridgeCall.setNamespace(lynxBridgeCall.getBid());
                BaseBridgeCall baseBridgeCall = lynxBridgeCall;
                getHandler().handle(baseBridgeCall, new JavaOnlyMap(), iDLXBridgeMethod, new BaseHandleBridgeContext(baseBridgeCall), new BridgeResultCallback<Object>(lynxBridgeCall, linkedHashMap, str) { // from class: com.bytedance.android.anniex.optimize.prehandle.task.LynxPreHandleTask$preHandleMethod$1$1$1
                    final /* synthetic */ String $_methodName;
                    final /* synthetic */ Map<String, Object> $preHandleResult;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super((BaseBridgeCall) lynxBridgeCall);
                        this.$preHandleResult = linkedHashMap;
                        this.$_methodName = str;
                        Intrinsics.checkNotNull(lynxBridgeCall, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall<kotlin.Any>");
                    }

                    public void dispatchPlatformInvoke(Object data) {
                        Intrinsics.checkNotNullParameter(data, Constants.KEY_DATA);
                        this.$preHandleResult.put(this.$_methodName, data);
                    }
                });
            }
        }
        return linkedHashMap;
    }
}
