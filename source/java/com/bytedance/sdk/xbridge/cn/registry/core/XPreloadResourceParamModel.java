package com.bytedance.sdk.xbridge.cn.registry.core;

import com.bytedance.ies.xbridge.XCollectionsKt;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.model.params.XBaseParamModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbsXPreloadResourceMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040%H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/XPreloadResourceParamModel;", "Lcom/bytedance/ies/xbridge/model/params/XBaseParamModel;", "()V", "containerType", "", "getContainerType", "()Ljava/lang/String;", "setContainerType", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "maxAge", "", "getMaxAge", "()Ljava/lang/Integer;", "setMaxAge", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "processType", "getProcessType", "setProcessType", "subRes", "", "", "getSubRes", "()Ljava/util/Map;", "setSubRes", "(Ljava/util/Map;)V", "usePreloadJson", "", "getUsePreloadJson", "()Ljava/lang/Boolean;", "setUsePreloadJson", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "provideParamList", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XPreloadResourceParamModel extends XBaseParamModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String containerType;
    private String mainUrl;
    private Integer maxAge;
    private String processType;
    private Map<String, ? extends Object> subRes;
    private Boolean usePreloadJson;

    @JvmStatic
    public static final XPreloadResourceParamModel convert(XReadableMap xReadableMap) {
        return INSTANCE.convert(xReadableMap);
    }

    public final String getMainUrl() {
        return this.mainUrl;
    }

    public final void setMainUrl(String str) {
        this.mainUrl = str;
    }

    public final Integer getMaxAge() {
        return this.maxAge;
    }

    public final void setMaxAge(Integer num) {
        this.maxAge = num;
    }

    public final Map<String, Object> getSubRes() {
        return this.subRes;
    }

    public final void setSubRes(Map<String, ? extends Object> map) {
        this.subRes = map;
    }

    public final String getContainerType() {
        return this.containerType;
    }

    public final void setContainerType(String str) {
        this.containerType = str;
    }

    public final Boolean getUsePreloadJson() {
        return this.usePreloadJson;
    }

    public final void setUsePreloadJson(Boolean bool) {
        this.usePreloadJson = bool;
    }

    public final String getProcessType() {
        return this.processType;
    }

    public final void setProcessType(String str) {
        this.processType = str;
    }

    public List<String> provideParamList() {
        return CollectionsKt.listOf(new String[]{"mainUrl", "subRes", "containerType", "usePreloadJson", "processType"});
    }

    /* compiled from: AbsXPreloadResourceMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/XPreloadResourceParamModel$Companion;", "", "()V", "convert", "Lcom/bytedance/sdk/xbridge/cn/registry/core/XPreloadResourceParamModel;", "params", "Lcom/bytedance/ies/xbridge/XReadableMap;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final XPreloadResourceParamModel convert(XReadableMap params) {
            XReadableMap optMap$default;
            Intrinsics.checkNotNullParameter(params, "params");
            String optString$default = XCollectionsKt.optString$default(params, "mainUrl", (String) null, 2, (Object) null);
            int optInt$default = XCollectionsKt.optInt$default(params, "maxAge", 0, 2, (Object) null);
            Map<String, ? extends Object> objectMap = (params.isNull("subRes") || (optMap$default = XCollectionsKt.optMap$default(params, "subRes", (XReadableMap) null, 2, (Object) null)) == null) ? null : XCollectionsKt.toObjectMap(optMap$default);
            String optString$default2 = XCollectionsKt.optString$default(params, "containerType", (String) null, 2, (Object) null);
            boolean optBoolean$default = XCollectionsKt.optBoolean$default(params, "usePreloadJson", false, 2, (Object) null);
            String optString$default3 = XCollectionsKt.optString$default(params, "processType", (String) null, 2, (Object) null);
            XPreloadResourceParamModel xPreloadResourceParamModel = new XPreloadResourceParamModel();
            xPreloadResourceParamModel.setMainUrl(optString$default);
            xPreloadResourceParamModel.setMaxAge(Integer.valueOf(optInt$default));
            xPreloadResourceParamModel.setSubRes(objectMap);
            xPreloadResourceParamModel.setContainerType(optString$default2);
            xPreloadResourceParamModel.setUsePreloadJson(Boolean.valueOf(optBoolean$default));
            xPreloadResourceParamModel.setProcessType(optString$default3);
            return xPreloadResourceParamModel;
        }
    }
}
