package com.bytedance.upc.web.bridge.abs;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.example.memorycollector.BuildConfig;
import com.lynx.tasm.DefaultLogicExecutor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AbsMonitorMethodIDL.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\r\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/upc/web/bridge/abs/AbsMonitorMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/bytedance/upc/web/bridge/abs/AbsMonitorMethodIDL$MonitorParamModel;", "Lcom/bytedance/upc/web/bridge/abs/AbsMonitorMethodIDL$MonitorResultModel;", "()V", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", DefaultLogicExecutor.GLOBAL_EVENT_NAME, "", "getName", "()Ljava/lang/String;", "Companion", "MonitorParamModel", "MonitorResultModel", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbsMonitorMethodIDL extends XCoreIDLBridgeMethod<MonitorParamModel, MonitorResultModel> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @XBridgeModelExtension
    private static final Map<String, Object> extensionMetaInfo = MapsKt.mapOf(TuplesKt.to("TicketID", "19286"));

    @XBridgeMethodName(name = "monitor", params = {"serviceName", "category", "metric", "logExtra"})
    private final String name = "monitor";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    private final IDLXBridgeMethod.Access access = IDLXBridgeMethod.Access.PRIVATE;

    /* compiled from: AbsMonitorMethodIDL.kt */
    @XBridgeParamModel
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u00020\u000b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/upc/web/bridge/abs/AbsMonitorMethodIDL$MonitorParamModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "category", "", "getCategory", "()Ljava/lang/Object;", "logExtra", "getLogExtra", "metric", "getMetric", "serviceName", "", "getServiceName", "()Ljava/lang/String;", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface MonitorParamModel extends XBaseParamModel {
        @XBridgeParamField(isGetter = BuildConfig.ONLINE, keyPath = "category", required = BuildConfig.ONLINE)
        Object getCategory();

        @XBridgeParamField(isGetter = BuildConfig.ONLINE, keyPath = "logExtra", required = BuildConfig.ONLINE)
        Object getLogExtra();

        @XBridgeParamField(isGetter = BuildConfig.ONLINE, keyPath = "metric", required = BuildConfig.ONLINE)
        Object getMetric();

        @XBridgeParamField(isGetter = BuildConfig.ONLINE, keyPath = "serviceName", required = BuildConfig.ONLINE)
        String getServiceName();
    }

    /* compiled from: AbsMonitorMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/upc/web/bridge/abs/AbsMonitorMethodIDL$MonitorResultModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
    @XBridgeResultModel
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface MonitorResultModel extends XBaseResultModel {
    }

    /* compiled from: AbsMonitorMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/upc/web/bridge/abs/AbsMonitorMethodIDL$Companion;", "", "()V", "extensionMetaInfo", "", "", "getExtensionMetaInfo", "()Ljava/util/Map;", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Map<String, Object> getExtensionMetaInfo() {
            return AbsMonitorMethodIDL.extensionMetaInfo;
        }
    }

    public String getName() {
        return this.name;
    }

    public IDLXBridgeMethod.Access getAccess() {
        return this.access;
    }
}
