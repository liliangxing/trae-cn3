package com.bytedance.ies.bullet.interaction.predefine.model;

import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: MetaModelConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R-\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0014j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/bullet/interaction/predefine/model/MetaExternal;", "", "name", "", "jsonObject", "Lorg/json/JSONObject;", "filePath", "Lcom/bytedance/ies/bullet/interaction/predefine/model/MetaFilePath;", "signature", "Lcom/bytedance/ies/bullet/interaction/predefine/model/Signature;", "matchRule", "(Ljava/lang/String;Lorg/json/JSONObject;Lcom/bytedance/ies/bullet/interaction/predefine/model/MetaFilePath;Lcom/bytedance/ies/bullet/interaction/predefine/model/Signature;Ljava/lang/String;)V", "getFilePath", "()Lcom/bytedance/ies/bullet/interaction/predefine/model/MetaFilePath;", "setFilePath", "(Lcom/bytedance/ies/bullet/interaction/predefine/model/MetaFilePath;)V", "getMatchRule", "()Ljava/lang/String;", "getName", "requiredDependencies", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getRequiredDependencies", "()Ljava/util/HashMap;", "getSignature", "()Lcom/bytedance/ies/bullet/interaction/predefine/model/Signature;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class MetaExternal {
    private MetaFilePath filePath;
    private final String matchRule;
    private final String name;
    private final HashMap<String, String> requiredDependencies;
    private final Signature signature;

    public MetaExternal(String str, JSONObject jSONObject, MetaFilePath metaFilePath, Signature signature, String str2) {
        Intrinsics.checkNotNullParameter(signature, "signature");
        this.name = str;
        this.filePath = metaFilePath;
        this.signature = signature;
        this.matchRule = str2;
        this.requiredDependencies = new HashMap<>();
        Iterator<String> keys = jSONObject != null ? jSONObject.keys() : null;
        while (true) {
            boolean z = false;
            if (keys != null && keys.hasNext()) {
                z = true;
            }
            if (!z) {
                return;
            }
            String key = keys.next();
            String value = jSONObject.optString(key);
            HashMap<String, String> hashMap = this.requiredDependencies;
            Intrinsics.checkNotNullExpressionValue(key, "key");
            Intrinsics.checkNotNullExpressionValue(value, "value");
            hashMap.put(key, value);
        }
    }

    public final String getName() {
        return this.name;
    }

    public final MetaFilePath getFilePath() {
        return this.filePath;
    }

    public final void setFilePath(MetaFilePath metaFilePath) {
        this.filePath = metaFilePath;
    }

    public final Signature getSignature() {
        return this.signature;
    }

    public final String getMatchRule() {
        return this.matchRule;
    }

    public final HashMap<String, String> getRequiredDependencies() {
        return this.requiredDependencies;
    }
}
