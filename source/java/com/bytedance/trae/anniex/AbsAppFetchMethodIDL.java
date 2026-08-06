package com.bytedance.trae.anniex;

import com.bytedance.sdk.account.platform.api.IWeixinService;
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
import com.bytedance.timonbase.scene.PageDataManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AbsAppFetchMethodIDL.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000e\u000f\u0010B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u000b8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchParamModel;", "Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "Companion", "AppFetchParamModel", "AppFetchResultModel", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbsAppFetchMethodIDL extends XCoreIDLBridgeMethod<AppFetchParamModel, AppFetchResultModel> {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @XBridgeModelExtension
    private static final Map<String, Object> extensionMetaInfo = MapsKt.mapOf(TuplesKt.to("TicketID", "0"));

    @XBridgeMethodName(name = "app.fetch", params = {IWeixinService.ResponseConstants.URL, "method", "params", "data", "header", "needCommonParams", "requestType", "responseType", "fetch_type"}, results = {PageDataManager.EXTRA_STATUS, "response"})
    private final String name = "app.fetch";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PUBLIC)
    private final IDLXBridgeMethod.Access access = IDLXBridgeMethod.Access.PUBLIC;

    /* compiled from: AbsAppFetchMethodIDL.kt */
    @XBridgeParamModel
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000f\bg\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR(\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\f8g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\f8g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R(\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\f8g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R(\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0002\u001a\u0004\u0018\u00010\u00188g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010\u001e\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR(\u0010!\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR(\u0010$\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b¨\u0006'"}, d2 = {"Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchParamModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "value", "", IWeixinService.ResponseConstants.URL, "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "method", "getMethod", "setMethod", "", "params", "getParams", "()Ljava/lang/Object;", "setParams", "(Ljava/lang/Object;)V", "data", "getData", "setData", "header", "getHeader", "setHeader", "", "needCommonParams", "getNeedCommonParams", "()Ljava/lang/Boolean;", "setNeedCommonParams", "(Ljava/lang/Boolean;)V", "requestType", "getRequestType", "setRequestType", "responseType", "getResponseType", "setResponseType", "fetch_type", "getFetch_type", "setFetch_type", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface AppFetchParamModel extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "data", required = false)
        Object getData();

        @XBridgeParamField(isGetter = true, keyPath = "fetch_type", required = false)
        String getFetch_type();

        @XBridgeParamField(isGetter = true, keyPath = "header", required = false)
        Object getHeader();

        @XBridgeParamField(isGetter = true, keyPath = "method", required = false)
        String getMethod();

        @XBridgeParamField(isGetter = true, keyPath = "needCommonParams", required = false)
        Boolean getNeedCommonParams();

        @XBridgeParamField(isGetter = true, keyPath = "params", required = false)
        Object getParams();

        @XBridgeParamField(isGetter = true, keyPath = "requestType", required = false)
        String getRequestType();

        @XBridgeParamField(isGetter = true, keyPath = "responseType", required = false)
        String getResponseType();

        @XBridgeParamField(isGetter = true, keyPath = IWeixinService.ResponseConstants.URL, required = true)
        String getUrl();

        @XBridgeParamField(isGetter = false, keyPath = "data", required = false)
        void setData(Object obj);

        @XBridgeParamField(isGetter = false, keyPath = "fetch_type", required = false)
        void setFetch_type(String str);

        @XBridgeParamField(isGetter = false, keyPath = "header", required = false)
        void setHeader(Object obj);

        @XBridgeParamField(isGetter = false, keyPath = "method", required = false)
        void setMethod(String str);

        @XBridgeParamField(isGetter = false, keyPath = "needCommonParams", required = false)
        void setNeedCommonParams(Boolean bool);

        @XBridgeParamField(isGetter = false, keyPath = "params", required = false)
        void setParams(Object obj);

        @XBridgeParamField(isGetter = false, keyPath = "requestType", required = false)
        void setRequestType(String str);

        @XBridgeParamField(isGetter = false, keyPath = "responseType", required = false)
        void setResponseType(String str);

        @XBridgeParamField(isGetter = false, keyPath = IWeixinService.ResponseConstants.URL, required = true)
        void setUrl(String str);
    }

    /* compiled from: AbsAppFetchMethodIDL.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\t8g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchResultModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "value", "", PageDataManager.EXTRA_STATUS, "getStatus", "()Ljava/lang/Number;", "setStatus", "(Ljava/lang/Number;)V", "", "response", "getResponse", "()Ljava/lang/Object;", "setResponse", "(Ljava/lang/Object;)V", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @XBridgeResultModel
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface AppFetchResultModel extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "response", required = false)
        Object getResponse();

        @XBridgeParamField(isGetter = true, keyPath = PageDataManager.EXTRA_STATUS, required = false)
        Number getStatus();

        @XBridgeParamField(isGetter = false, keyPath = "response", required = false)
        void setResponse(Object obj);

        @XBridgeParamField(isGetter = false, keyPath = PageDataManager.EXTRA_STATUS, required = false)
        void setStatus(Number number);
    }

    /* compiled from: AbsAppFetchMethodIDL.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$Companion;", "", "<init>", "()V", "extensionMetaInfo", "", "", "getExtensionMetaInfo", "()Ljava/util/Map;", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Object> getExtensionMetaInfo() {
            return AbsAppFetchMethodIDL.extensionMetaInfo;
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
