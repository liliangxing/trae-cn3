package com.bytedance.iesgurd.model;

import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.iesgurd.core.RegisterManager;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestBodySettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001:\u0001\tB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/iesgurd/model/RequestBodySettings;", "Lcom/bytedance/iesgurd/model/RequestBodyBase;", "reqType", "Lcom/bytedance/iesgurd/core/ReqType;", IPiaCacheProvider.CacheConfig.FIELD_VERSION, "", "(Lcom/bytedance/iesgurd/core/ReqType;Ljava/lang/String;)V", "local", "Lcom/bytedance/iesgurd/model/RequestBodySettings$Local;", "Local", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RequestBodySettings extends RequestBodyBase {

    @SerializedName("local")
    private Local local;

    /* compiled from: RequestBodySettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0002\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/iesgurd/model/RequestBodySettings$Local;", "", IPiaCacheProvider.CacheConfig.FIELD_VERSION, "", "(Ljava/lang/String;)V", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static final class Local {

        @SerializedName(IPiaCacheProvider.CacheConfig.FIELD_VERSION)
        private String version;

        public Local(String str) {
            this.version = ViewVisibleBridge.INVISIBLE;
            if (str != null) {
                this.version = str;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestBodySettings(ReqType reqType, String str) {
        super(reqType);
        Intrinsics.checkParameterIsNotNull(reqType, "reqType");
        this.local = new Local(str);
        for (Map.Entry<String, ConcurrentHashMap<String, String>> entry : RegisterManager.INSTANCE.getCustomParams().entrySet()) {
            String str2 = entry.getValue().get("business_version");
            if (str2 != null) {
                Intrinsics.checkExpressionValueIsNotNull(str2, "it.value[CUSTOM_KEY_BUSI…ERSION] ?: return@forEach");
                getCustom().put(entry.getKey(), MapsKt.mapOf(TuplesKt.to("business_version", str2)));
            }
        }
    }
}
