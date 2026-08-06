package com.bytedance.ies.bullet.prefetchv2;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PrefetchConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/PrefetchCondition;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "key", "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "operator", "getOperator", "setOperator", "type", "getType", "setType", "value", "", "getValue", "()Ljava/util/List;", "setValue", "(Ljava/util/List;)V", "check", "", "schemaModel", "Lcom/bytedance/ies/bullet/prefetchv2/SchemaModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrefetchCondition {
    private String key;
    private String operator;
    private String type;
    private List<String> value;

    public PrefetchCondition(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        this.type = "";
        this.key = "";
        this.operator = "";
        this.value = new ArrayList();
        String optString = jSONObject.optString("type");
        Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"type\")");
        this.type = optString;
        String optString2 = jSONObject.optString("key");
        Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"key\")");
        this.key = optString2;
        String optString3 = jSONObject.optString("operator");
        Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"operator\")");
        this.operator = optString3;
        JSONArray optJSONArray = jSONObject.optJSONArray("value");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                String optString4 = optJSONArray.optString(i);
                Intrinsics.checkNotNullExpressionValue(optString4, "valueArr.optString(i)");
                arrayList.add(optString4);
            }
            this.value = arrayList;
        }
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public final String getKey() {
        return this.key;
    }

    public final void setKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.key = str;
    }

    public final String getOperator() {
        return this.operator;
    }

    public final void setOperator(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.operator = str;
    }

    public final List<String> getValue() {
        return this.value;
    }

    public final void setValue(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.value = list;
    }

    public final boolean check(SchemaModel schemaModel) {
        String queryFromObject;
        boolean z;
        Intrinsics.checkNotNullParameter(schemaModel, "schemaModel");
        String str = this.type;
        if (Intrinsics.areEqual(str, "query")) {
            queryFromObject = schemaModel.getQuery(this.key);
        } else {
            queryFromObject = Intrinsics.areEqual(str, PrefetchRequestConfig.PARAM_TYPE_QUERY_OBJECT) ? schemaModel.getQueryFromObject(this.key) : null;
        }
        if (queryFromObject == null) {
            queryFromObject = "null";
        }
        String str2 = this.operator;
        if (Intrinsics.areEqual(str2, "=")) {
            z = this.value.contains(queryFromObject);
        } else {
            z = (Intrinsics.areEqual(str2, "!=") && this.value.contains(queryFromObject)) ? false : true;
        }
        PrefetchLogger.INSTANCE.m38i("检查预取条件, key: " + this.key + ", query: " + queryFromObject + ", value: " + this.value + ", result: " + z);
        return z;
    }
}
