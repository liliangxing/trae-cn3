package com.bytedance.android.anniex.optimize.prehandle.task;

import com.bytedance.android.anniex.ability.service.IAnnieXPiaMethodProvider;
import com.bytedance.android.anniex.optimize.prehandle.api.BaseHandleBridgeContext;
import com.bytedance.android.anniex.optimize.prehandle.api.IPreHandleTask;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.sdk.xbridge.cn.platform.web.JsonBridgeHandler;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeCall;
import com.bytedance.sdk.xbridge.cn.protocol.BaseBridgeHandler;
import com.bytedance.sdk.xbridge.cn.protocol.BridgeResultCallback;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: WebPreHandleTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J$\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR)\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/anniex/optimize/prehandle/task/WebPreHandleTask;", "Lcom/bytedance/android/anniex/optimize/prehandle/api/IPreHandleTask;", "Lorg/json/JSONObject;", "bid", "", "(Ljava/lang/String;)V", "getBid", "()Ljava/lang/String;", "handler", "Lcom/bytedance/sdk/xbridge/cn/protocol/BaseBridgeHandler;", "getHandler", "()Lcom/bytedance/sdk/xbridge/cn/protocol/BaseBridgeHandler;", "methods", "", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "getMethods", "()Ljava/util/Map;", "methods$delegate", "Lkotlin/Lazy;", "preHandleMethod", "methodCalls", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class WebPreHandleTask implements IPreHandleTask<JSONObject, JSONObject> {
    private final String bid;
    private final BaseBridgeHandler<JSONObject, JSONObject> handler;

    /* renamed from: methods$delegate, reason: from kotlin metadata */
    private final Lazy methods;

    public WebPreHandleTask(String str) {
        Intrinsics.checkNotNullParameter(str, "bid");
        this.bid = str;
        this.methods = LazyKt.lazy(new Function0<Map<String, ? extends IDLXBridgeMethod>>() { // from class: com.bytedance.android.anniex.optimize.prehandle.task.WebPreHandleTask$methods$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final Map<String, IDLXBridgeMethod> invoke() {
                IAnnieXPiaMethodProvider iAnnieXPiaMethodProvider = (IAnnieXPiaMethodProvider) ServiceCenter.Companion.instance().get(WebPreHandleTask.this.getBid(), IAnnieXPiaMethodProvider.class);
                if (iAnnieXPiaMethodProvider != null) {
                    return iAnnieXPiaMethodProvider.providerPreHandleMethod(WebPreHandleTask.this.getBid());
                }
                return null;
            }
        });
        this.handler = new JsonBridgeHandler<>();
    }

    @Override // com.bytedance.android.anniex.optimize.prehandle.api.IPreHandleTask
    public String getBid() {
        return this.bid;
    }

    private final Map<String, IDLXBridgeMethod> getMethods() {
        return (Map) this.methods.getValue();
    }

    @Override // com.bytedance.android.anniex.optimize.prehandle.api.IPreHandleTask
    public BaseBridgeHandler<JSONObject, JSONObject> getHandler() {
        return this.handler;
    }

    @Override // com.bytedance.android.anniex.optimize.prehandle.api.IPreHandleTask
    public Map<String, JSONObject> preHandleMethod(List<String> methodCalls) {
        IDLXBridgeMethod iDLXBridgeMethod;
        Intrinsics.checkNotNullParameter(methodCalls, "methodCalls");
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (final String str : methodCalls) {
            Map<String, IDLXBridgeMethod> methods = getMethods();
            if (methods != null && (iDLXBridgeMethod = methods.get(str)) != null) {
                final BaseBridgeCall webBridgeCall = new WebBridgeCall(str, new JSONObject(), "");
                webBridgeCall.setNamespace(webBridgeCall.getBid());
                BaseBridgeCall baseBridgeCall = webBridgeCall;
                getHandler().handle(baseBridgeCall, new JSONObject(), iDLXBridgeMethod, new BaseHandleBridgeContext(baseBridgeCall), new BridgeResultCallback<JSONObject>(webBridgeCall, linkedHashMap, str) { // from class: com.bytedance.android.anniex.optimize.prehandle.task.WebPreHandleTask$preHandleMethod$1$1$1
                    final /* synthetic */ String $_methodName;
                    final /* synthetic */ Map<String, JSONObject> $preHandleResult;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super((BaseBridgeCall) webBridgeCall);
                        this.$preHandleResult = linkedHashMap;
                        this.$_methodName = str;
                    }

                    public void dispatchPlatformInvoke(JSONObject data) {
                        Intrinsics.checkNotNullParameter(data, Constants.KEY_DATA);
                        this.$preHandleResult.put(this.$_methodName, data);
                    }
                });
            }
        }
        return linkedHashMap;
    }
}
