package com.bytedance.sdk.xbridge.cn.system;

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
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AbsXGetDeviceStatsMethodIDL.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\r\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/AbsXGetDeviceStatsMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/bytedance/sdk/xbridge/cn/system/AbsXGetDeviceStatsMethodIDL$XGetDeviceStatsParamModel;", "Lcom/bytedance/sdk/xbridge/cn/system/AbsXGetDeviceStatsMethodIDL$XGetDeviceStatsResultModel;", "()V", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "name", "", "getName", "()Ljava/lang/String;", "Companion", "XGetDeviceStatsParamModel", "XGetDeviceStatsResultModel", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbsXGetDeviceStatsMethodIDL extends XCoreIDLBridgeMethod<XGetDeviceStatsParamModel, XGetDeviceStatsResultModel> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @XBridgeModelExtension
    private static final Map<String, Object> extensionMetaInfo = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", "1005"), TuplesKt.to("UID", "6184d92cb4a5670046bedeb2"), TuplesKt.to("TicketID", "15201")});

    @XBridgeMethodName(name = "x.getDeviceStats", params = {"memory_all", "memory_use", "memory_rest", "memory_limit", "cpu_usage", "temperature"}, results = {"memory_all", "memory_use", "memory_rest", "memory_limit", "cpu_usage", "temperature"})
    private final String name = "x.getDeviceStats";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    private final IDLXBridgeMethod.Access access = IDLXBridgeMethod.Access.PROTECT;

    /* compiled from: AbsXGetDeviceStatsMethodIDL.kt */
    @XBridgeParamModel
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\bg\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/AbsXGetDeviceStatsMethodIDL$XGetDeviceStatsParamModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "cpu_usage", "", "getCpu_usage", "()Ljava/lang/Boolean;", "memory_all", "getMemory_all", "memory_limit", "getMemory_limit", "memory_rest", "getMemory_rest", "memory_use", "getMemory_use", "temperature", "getTemperature", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XGetDeviceStatsParamModel extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "cpu_usage", required = false)
        Boolean getCpu_usage();

        @XBridgeParamField(isGetter = true, keyPath = "memory_all", required = false)
        Boolean getMemory_all();

        @XBridgeParamField(isGetter = true, keyPath = "memory_limit", required = false)
        Boolean getMemory_limit();

        @XBridgeParamField(isGetter = true, keyPath = "memory_rest", required = false)
        Boolean getMemory_rest();

        @XBridgeParamField(isGetter = true, keyPath = "memory_use", required = false)
        Boolean getMemory_use();

        @XBridgeParamField(isGetter = true, keyPath = "temperature", required = false)
        Boolean getTemperature();
    }

    /* compiled from: AbsXGetDeviceStatsMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0015\bg\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR(\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR(\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR(\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR(\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/AbsXGetDeviceStatsMethodIDL$XGetDeviceStatsResultModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "<set-?>", "", "cpu_usage", "getCpu_usage", "()Ljava/lang/Number;", "setCpu_usage", "(Ljava/lang/Number;)V", "memory_all", "getMemory_all", "setMemory_all", "memory_limit", "getMemory_limit", "setMemory_limit", "memory_rest", "getMemory_rest", "setMemory_rest", "memory_use", "getMemory_use", "setMemory_use", "temperature", "getTemperature", "setTemperature", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @XBridgeResultModel
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XGetDeviceStatsResultModel extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "cpu_usage", required = true)
        Number getCpu_usage();

        @XBridgeParamField(isGetter = true, keyPath = "memory_all", required = true)
        Number getMemory_all();

        @XBridgeParamField(isGetter = true, keyPath = "memory_limit", required = true)
        Number getMemory_limit();

        @XBridgeParamField(isGetter = true, keyPath = "memory_rest", required = true)
        Number getMemory_rest();

        @XBridgeParamField(isGetter = true, keyPath = "memory_use", required = true)
        Number getMemory_use();

        @XBridgeParamField(isGetter = true, keyPath = "temperature", required = true)
        Number getTemperature();

        @XBridgeParamField(isGetter = false, keyPath = "cpu_usage", required = true)
        void setCpu_usage(Number number);

        @XBridgeParamField(isGetter = false, keyPath = "memory_all", required = true)
        void setMemory_all(Number number);

        @XBridgeParamField(isGetter = false, keyPath = "memory_limit", required = true)
        void setMemory_limit(Number number);

        @XBridgeParamField(isGetter = false, keyPath = "memory_rest", required = true)
        void setMemory_rest(Number number);

        @XBridgeParamField(isGetter = false, keyPath = "memory_use", required = true)
        void setMemory_use(Number number);

        @XBridgeParamField(isGetter = false, keyPath = "temperature", required = true)
        void setTemperature(Number number);
    }

    /* compiled from: AbsXGetDeviceStatsMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/AbsXGetDeviceStatsMethodIDL$Companion;", "", "()V", "extensionMetaInfo", "", "", "getExtensionMetaInfo", "()Ljava/util/Map;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Object> getExtensionMetaInfo() {
            return AbsXGetDeviceStatsMethodIDL.extensionMetaInfo;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public IDLXBridgeMethod.Access getAccess() {
        return this.access;
    }
}
