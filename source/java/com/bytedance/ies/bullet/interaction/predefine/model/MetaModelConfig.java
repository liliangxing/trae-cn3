package com.bytedance.ies.bullet.interaction.predefine.model;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.HybridLoggerConst;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MetaModelConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J2\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J0\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e2\u0006\u0010\u0018\u001a\u00020\u0016H\u0002R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR1\u0010\n\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/bullet/interaction/predefine/model/MetaModelConfig;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "enablePredefine", "", "getEnablePredefine", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "externalsMap", "Ljava/util/HashMap;", "", "Lcom/bytedance/ies/bullet/interaction/predefine/model/MetaExternal;", "Lkotlin/collections/HashMap;", "getExternalsMap", "()Ljava/util/HashMap;", "publishPath", "getPublishPath", "()Ljava/lang/String;", "convert", "jArr", "Lorg/json/JSONArray;", "parseExternals", "jsonArray", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class MetaModelConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Boolean enablePredefine;
    private final HashMap<String, MetaExternal> externalsMap;
    private final JSONObject json;
    private final String publishPath;

    public MetaModelConfig(JSONObject jSONObject) {
        this.json = jSONObject;
        this.enablePredefine = jSONObject != null ? Boolean.valueOf(jSONObject.optBoolean("predefineEnable")) : null;
        JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject(IPiaCacheProvider.CacheConfig.FIELD_META) : null;
        this.publishPath = optJSONObject != null ? optJSONObject.optString("publicPath") : null;
        JSONArray optJSONArray = optJSONObject != null ? optJSONObject.optJSONArray("externals") : null;
        this.externalsMap = optJSONArray != null ? parseExternals(optJSONArray) : null;
        HybridLogger.i$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "metaModel init", null, null, 12, null);
    }

    /* compiled from: MetaModelConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/interaction/predefine/model/MetaModelConfig$Companion;", "", "()V", "getJson", "Lorg/json/JSONObject;", "jsonStr", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JSONObject getJson(String jsonStr) {
            Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
            try {
                return new JSONObject(jsonStr);
            } catch (JSONException e) {
                HybridLogger.e$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "meta json init failed:" + e.getMessage(), null, null, 12, null);
                return null;
            }
        }
    }

    public final String getPublishPath() {
        return this.publishPath;
    }

    public final HashMap<String, MetaExternal> getExternalsMap() {
        return this.externalsMap;
    }

    public final Boolean getEnablePredefine() {
        return this.enablePredefine;
    }

    private final HashMap<String, MetaExternal> parseExternals(JSONArray jsonArray) {
        return convert(jsonArray);
    }

    private final HashMap<String, MetaExternal> convert(JSONArray jArr) {
        if (jArr == null) {
            return null;
        }
        HashMap<String, MetaExternal> hashMap = new HashMap<>();
        try {
            int length = jArr.length();
            for (int i = 0; i < length; i++) {
                Object obj = jArr.get(i);
                JSONObject jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
                String optString = jSONObject != null ? jSONObject.optString("name") : null;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("requiredDependencies") : null;
                MetaFilePath metaFilePath = new MetaFilePath(jSONObject != null ? jSONObject.optJSONObject("filePath") : null);
                String optString2 = jSONObject != null ? jSONObject.optString("matchRule") : null;
                MetaExternal metaExternal = new MetaExternal(optString, optJSONObject, metaFilePath, new Signature(jSONObject != null ? jSONObject.optJSONObject("signature") : null), optString2);
                HybridLogger.d$default(HybridLogger.INSTANCE, "predefine", "convert success:" + metaExternal, null, null, 12, null);
                if (optString2 != null) {
                    hashMap.put(optString2, metaExternal);
                }
            }
        } catch (Exception e) {
            HybridLogger.e$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "convert error:" + e.getMessage(), null, null, 12, null);
        }
        return hashMap;
    }
}
