package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: LoadStaticResourceParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/argus/api/params/LoadStaticResourceParams;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParamsWithRewrite;", "Lcom/bytedance/ies/argus/api/params/LoadStaticResourceRewritePayload;", "url", "", "originHeaders", "", "resourceType", "resourcePoint", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "getOriginHeaders", "()Ljava/util/Map;", "getResourcePoint", "()Ljava/lang/String;", "getResourceType", "getUrl", "initRewritePayload", "toALogObject", "Lorg/json/JSONObject;", "action", "Lcom/bytedance/ies/argus/bean/ArgusVerifyAction;", "toMonitorObject", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LoadStaticResourceParams extends BaseAspectParamsWithRewrite<LoadStaticResourceRewritePayload> {
    private final Map<String, String> originHeaders;
    private final String resourcePoint;
    private final String resourceType;
    private final String url;

    public final String getUrl() {
        return this.url;
    }

    public final Map<String, String> getOriginHeaders() {
        return this.originHeaders;
    }

    public final String getResourceType() {
        return this.resourceType;
    }

    public final String getResourcePoint() {
        return this.resourcePoint;
    }

    public LoadStaticResourceParams(String str, Map<String, String> map, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(map, "originHeaders");
        Intrinsics.checkNotNullParameter(str2, "resourceType");
        Intrinsics.checkNotNullParameter(str3, "resourcePoint");
        this.url = str;
        this.originHeaders = map;
        this.resourceType = str2;
        this.resourcePoint = str3;
    }

    @Override // com.bytedance.ies.argus.api.params.BaseAspectParams
    public LoadStaticResourceRewritePayload initRewritePayload() {
        return new LoadStaticResourceRewritePayload(MapsKt.emptyMap());
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public JSONObject toMonitorObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        JSONObject jSONObject = new JSONObject();
        JSONUtilsKt.safelyPut(jSONObject, "resource_url", this.url);
        JSONUtilsKt.safelyPut(jSONObject, "resource_point", this.resourcePoint);
        JSONUtilsKt.safelyPut(jSONObject, "resource_type", this.resourceType);
        JSONUtilsKt.safelyPut(jSONObject, "origin_headers", this.originHeaders.keySet().toString());
        return jSONObject;
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public JSONObject toALogObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        JSONObject jSONObject = new JSONObject();
        JSONUtilsKt.safelyPut(jSONObject, "resource_url", this.url);
        return jSONObject;
    }
}
