package com.bytedance.ies.bullet.web.pia;

import android.app.Activity;
import android.view.View;
import com.bytedance.ies.bullet.service.base.api.BidConstants;
import com.bytedance.ies.bullet.service.base.settings.CommonConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.utils.XConstant;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.web.pia.PiaXBridge3Adapter;
import com.bytedance.pia.core.api.bridge.IPiaBridge;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IReleasable;
import com.bytedance.pia.core.tracing.OnlineTracing;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.mix.AllowListForSpecialLogic;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeCall;
import com.bytedance.sdk.xbridge.cn.platform.web.WebPlatformDataProcessor;
import com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.service.JSEventDelegate;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PiaXBridge3Adapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0013\u0014B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ7\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0010H\u0096\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/bullet/web/pia/PiaXBridge3Adapter;", "Lcom/bytedance/pia/core/api/bridge/PiaMethod$ICall;", "Lorg/json/JSONObject;", "", "bid", "", "methodName", "xBridgeMethod", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;)V", "invoke", "", "bridge", "Lcom/bytedance/pia/core/api/bridge/IPiaBridge;", "params", "resolve", "Lcom/bytedance/pia/core/api/utils/IConsumer;", "reject", "Lcom/bytedance/pia/core/api/bridge/PiaMethod$Error;", "Companion", "PiaBridgeCallContext", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PiaXBridge3Adapter implements PiaMethod.ICall<JSONObject, Object> {
    private static final WebPlatformDataProcessor WEB_DATA_PROCESSOR = new WebPlatformDataProcessor();
    private final String bid;
    private final String methodName;
    private final IDLXBridgeMethod xBridgeMethod;

    public PiaXBridge3Adapter(String str, String str2, IDLXBridgeMethod iDLXBridgeMethod) {
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(str2, "methodName");
        Intrinsics.checkNotNullParameter(iDLXBridgeMethod, "xBridgeMethod");
        this.bid = str;
        this.methodName = str2;
        this.xBridgeMethod = iDLXBridgeMethod;
    }

    @Override // com.bytedance.pia.core.api.bridge.PiaMethod.ICall
    public /* bridge */ /* synthetic */ void invoke(IPiaBridge iPiaBridge, JSONObject jSONObject, IConsumer<Object> iConsumer, IConsumer iConsumer2) {
        invoke2(iPiaBridge, jSONObject, iConsumer, (IConsumer<PiaMethod.Error>) iConsumer2);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(IPiaBridge bridge, JSONObject params, final IConsumer<Object> resolve, final IConsumer<PiaMethod.Error> reject) {
        IDLXBridgeMethod.Callback callback;
        String str;
        CommonConfig commonConfig;
        Boolean enablePrefetchNetworkParams;
        Intrinsics.checkNotNullParameter(bridge, "bridge");
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        Intrinsics.checkNotNullParameter(reject, "reject");
        if (params == null) {
            params = new JSONObject();
        }
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if ((iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enablePrefetchNetworkParams = commonConfig.getEnablePrefetchNetworkParams()) == null) ? true : enablePrefetchNetworkParams.booleanValue()) {
            String name = this.xBridgeMethod.getName();
            if (Intrinsics.areEqual(name, "x.request")) {
                str = OnlineTracing.HeaderKeys.KEY_SSR_FALLBACK_HEADER;
            } else {
                str = Intrinsics.areEqual(name, "fetch") ? "headers" : null;
            }
            if (str != null) {
                JSONObject optJSONObject = params.optJSONObject(str);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                } else {
                    Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(it) ?: JSONObject()");
                }
                optJSONObject.put("Anniex-Prefetch", "1");
                params.put(str, optJSONObject);
            }
        }
        Map transformPlatformDataToMap = WEB_DATA_PROCESSOR.transformPlatformDataToMap(params, this.xBridgeMethod.getClass());
        if (transformPlatformDataToMap == null && (transformPlatformDataToMap = ConvertUtils.INSTANCE.jsonToMap(params)) == null) {
            transformPlatformDataToMap = MapsKt.emptyMap();
        }
        final PiaBridgeCallContext piaBridgeCallContext = new PiaBridgeCallContext(bridge, new WebBridgeCall(this.methodName, params, ""), Intrinsics.areEqual(this.bid, BidConstants.WEBCAST) ? BidConstants.WEBCAST : "");
        if (Intrinsics.areEqual(this.bid, BidConstants.WEBCAST)) {
            callback = new IDLXBridgeMethod.Callback() { // from class: com.bytedance.ies.bullet.web.pia.PiaXBridge3Adapter$invoke$callback$1
                public void invoke(Map<String, ? extends Object> data) {
                    Object obj;
                    String str2;
                    Intrinsics.checkNotNullParameter(data, "data");
                    IConsumer<Object> iConsumer = resolve;
                    PiaXBridge3Adapter piaXBridge3Adapter = this;
                    PiaXBridge3Adapter.PiaBridgeCallContext piaBridgeCallContext2 = piaBridgeCallContext;
                    try {
                        Result.Companion companion = Result.Companion;
                        Object obj2 = data.get("__jsb2__data__");
                        JSONObject jSONObject = obj2 instanceof JSONObject ? (JSONObject) obj2 : null;
                        boolean z = false;
                        if (jSONObject != null && jSONObject.has("__data")) {
                            z = true;
                        }
                        if (z) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("data", jSONObject.get("__data"));
                            iConsumer.accept(jSONObject2);
                        } else if (jSONObject != null) {
                            iConsumer.accept(jSONObject);
                        } else {
                            AllowListForSpecialLogic allowListForSpecialLogic = AllowListForSpecialLogic.INSTANCE;
                            str2 = piaXBridge3Adapter.methodName;
                            iConsumer.accept(allowListForSpecialLogic.dealSpecialDataSwitch(str2, piaBridgeCallContext2, data));
                        }
                        obj = Result.constructor-impl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    IConsumer<PiaMethod.Error> iConsumer2 = reject;
                    Throwable th2 = Result.exceptionOrNull-impl(obj);
                    if (th2 != null) {
                        iConsumer2.accept(new PiaMethod.Error(th2.getMessage()));
                    }
                }
            };
        } else {
            callback = new IDLXBridgeMethod.Callback() { // from class: com.bytedance.ies.bullet.web.pia.PiaXBridge3Adapter$invoke$callback$2
                /* JADX WARN: Removed duplicated region for block: B:18:0x006a  */
                /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void invoke(Map<String, ? extends Object> data) {
                    Object obj;
                    Throwable th;
                    Integer num;
                    Intrinsics.checkNotNullParameter(data, "data");
                    IConsumer<Object> iConsumer = resolve;
                    IConsumer<PiaMethod.Error> iConsumer2 = reject;
                    try {
                        Result.Companion companion = Result.Companion;
                        Object obj2 = data.get("code");
                        num = obj2 instanceof Integer ? (Integer) obj2 : null;
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                    if (num != null && num.intValue() == 1) {
                        Object obj3 = data.get("data");
                        iConsumer.accept(obj3 instanceof Map ? (Map) obj3 : null);
                        obj = Result.constructor-impl(Unit.INSTANCE);
                        IConsumer<PiaMethod.Error> iConsumer3 = reject;
                        th = Result.exceptionOrNull-impl(obj);
                        if (th == null) {
                            iConsumer3.accept(new PiaMethod.Error(th.getMessage()));
                            return;
                        }
                        return;
                    }
                    int intValue = num != null ? num.intValue() : 0;
                    Object obj4 = data.get("msg");
                    iConsumer2.accept(new PiaMethod.Error(intValue, obj4 instanceof String ? (String) obj4 : null));
                    obj = Result.constructor-impl(Unit.INSTANCE);
                    IConsumer<PiaMethod.Error> iConsumer32 = reject;
                    th = Result.exceptionOrNull-impl(obj);
                    if (th == null) {
                    }
                }
            };
        }
        this.xBridgeMethod.realHandle(piaBridgeCallContext, transformPlatformDataToMap, callback);
        if (this.xBridgeMethod instanceof StatefulMethod) {
            bridge.getContext().put(new IReleasable() { // from class: com.bytedance.ies.bullet.web.pia.PiaXBridge3Adapter$invoke$2
                @Override // com.bytedance.pia.core.api.utils.IReleasable
                public final void release() {
                    StatefulMethod statefulMethod;
                    statefulMethod = PiaXBridge3Adapter.this.xBridgeMethod;
                    statefulMethod.release();
                }
            });
        }
    }

    /* compiled from: PiaXBridge3Adapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J#\u0010!\u001a\u0004\u0018\u0001H\"\"\u0004\b\u0000\u0010\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\"0$H\u0016¢\u0006\u0002\u0010%J(\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00072\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*H\u0016R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/bytedance/ies/bullet/web/pia/PiaXBridge3Adapter$PiaBridgeCallContext;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "piaBridge", "Lcom/bytedance/pia/core/api/bridge/IPiaBridge;", "bridgeCall", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "namespace", "", "(Lcom/bytedance/pia/core/api/bridge/IPiaBridge;Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;Ljava/lang/String;)V", "getBridgeCall", "()Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", XConstant.CALL_ID, "getCallId", "()Ljava/lang/String;", "setCallId", "(Ljava/lang/String;)V", "containerID", "getContainerID", "jsEventDelegate", "Lcom/bytedance/sdk/xbridge/cn/service/JSEventDelegate;", "getJsEventDelegate", "()Lcom/bytedance/sdk/xbridge/cn/service/JSEventDelegate;", "getNamespace", "getPiaBridge", "()Lcom/bytedance/pia/core/api/bridge/IPiaBridge;", "platformType", "Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "getPlatformType", "()Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "getEngineView", "Landroid/view/View;", "getOwnerActivity", "Landroid/app/Activity;", "getService", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "sendEvent", "", SchemaConstants.INNER_PARAM_EVENT_NAME, "params", "", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class PiaBridgeCallContext implements IBDXBridgeContext {
        private final BaseBridgeCall<?> bridgeCall;
        private String callId;
        private final String containerID;
        private final JSEventDelegate jsEventDelegate;
        private final String namespace;
        private final IPiaBridge piaBridge;
        private final PlatformType platformType;

        public View getEngineView() {
            return null;
        }

        public Activity getOwnerActivity() {
            return null;
        }

        public <T> T getService(Class<T> clazz) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            return null;
        }

        public PiaBridgeCallContext(IPiaBridge iPiaBridge, BaseBridgeCall<?> baseBridgeCall, String str) {
            Intrinsics.checkNotNullParameter(iPiaBridge, "piaBridge");
            Intrinsics.checkNotNullParameter(baseBridgeCall, "bridgeCall");
            Intrinsics.checkNotNullParameter(str, "namespace");
            this.piaBridge = iPiaBridge;
            this.bridgeCall = baseBridgeCall;
            this.namespace = str;
            this.containerID = "";
            this.platformType = getBridgeCall().getPlatformType();
            this.jsEventDelegate = new JSEventDelegate() { // from class: com.bytedance.ies.bullet.web.pia.PiaXBridge3Adapter$PiaBridgeCallContext$jsEventDelegate$1
                public void sendJSEvent(String eventName, Map<String, ? extends Object> params) {
                    Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
                    PiaXBridge3Adapter.PiaBridgeCallContext.this.getPiaBridge().send(eventName, params);
                }
            };
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            this.callId = uuid;
        }

        public /* synthetic */ PiaBridgeCallContext(IPiaBridge iPiaBridge, BaseBridgeCall baseBridgeCall, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(iPiaBridge, baseBridgeCall, (i & 4) != 0 ? "" : str);
        }

        public final IPiaBridge getPiaBridge() {
            return this.piaBridge;
        }

        public BaseBridgeCall<?> getBridgeCall() {
            return this.bridgeCall;
        }

        public String getNamespace() {
            return this.namespace;
        }

        public String getContainerID() {
            return this.containerID;
        }

        public PlatformType getPlatformType() {
            return this.platformType;
        }

        public JSEventDelegate getJsEventDelegate() {
            return this.jsEventDelegate;
        }

        public String getCallId() {
            return this.callId;
        }

        public void setCallId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.callId = str;
        }

        public void sendEvent(String eventName, Map<String, ? extends Object> params) {
            Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
            this.piaBridge.send(eventName, params);
        }
    }
}
