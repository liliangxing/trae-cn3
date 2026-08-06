package com.bytedance.ies.bullet.prefetchv2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PrefetchConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\rR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/PrefetchConfig;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "apis", "", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchRequestConfig;", "getApis", "()Ljava/util/List;", "setApis", "(Ljava/util/List;)V", "bid", "", "getBid", "()Ljava/lang/String;", "setBid", "(Ljava/lang/String;)V", "configFrom", "getConfigFrom", "setConfigFrom", "getJson", "()Lorg/json/JSONObject;", "checkValid", "", "toJson", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class PrefetchConfig {
    public static final String FROM_MEMORY = "memory";
    private List<PrefetchRequestConfig> apis;
    private String bid;
    private String configFrom;
    private final JSONObject json;

    public PrefetchConfig(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.json = json;
        this.configFrom = "unknown";
        this.apis = new ArrayList();
        JSONArray optJSONArray = json.optJSONArray("apis");
        if (optJSONArray != null) {
            this.apis = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = optJSONArray.getJSONObject(i);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "this.getJSONObject(i)");
                this.apis.add(new PrefetchRequestConfig(jSONObject));
            }
        }
        this.bid = "default_bid";
    }

    public final JSONObject getJson() {
        return this.json;
    }

    public final String getConfigFrom() {
        return this.configFrom;
    }

    public final void setConfigFrom(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.configFrom = str;
    }

    public final List<PrefetchRequestConfig> getApis() {
        return this.apis;
    }

    public final void setApis(List<PrefetchRequestConfig> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.apis = list;
    }

    public final String getBid() {
        return this.bid;
    }

    public final void setBid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bid = str;
    }

    public final boolean checkValid() {
        List<PrefetchRequestConfig> list = this.apis;
        if (list == null || list.isEmpty()) {
            PrefetchLogger.INSTANCE.e("apis为空");
            return false;
        }
        Iterator<PrefetchRequestConfig> it = this.apis.iterator();
        while (it.hasNext()) {
            if (!it.next().checkValid()) {
                return false;
            }
        }
        return true;
    }

    public final String toJson() {
        String jSONObject = this.json.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "json.toString()");
        return jSONObject;
    }
}
