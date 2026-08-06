package com.bytedance.pitaya.api.bean;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PTYTaskData.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYTaskData;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "params", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "dataFetcher", "Lcom/bytedance/pitaya/api/bean/DataFetcher;", "getDataFetcher", "()Lcom/bytedance/pitaya/api/bean/DataFetcher;", "setDataFetcher", "(Lcom/bytedance/pitaya/api/bean/DataFetcher;)V", "getParams", "()Lorg/json/JSONObject;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PTYTaskData implements ReflectionCall {
    private DataFetcher dataFetcher;
    private final JSONObject params;

    public static /* synthetic */ PTYTaskData copy$default(PTYTaskData pTYTaskData, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            jSONObject = pTYTaskData.params;
        }
        return pTYTaskData.copy(jSONObject);
    }

    /* renamed from: component1, reason: from getter */
    public final JSONObject getParams() {
        return this.params;
    }

    public final PTYTaskData copy(JSONObject params) {
        return new PTYTaskData(params);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PTYTaskData) && Intrinsics.areEqual(this.params, ((PTYTaskData) other).params);
    }

    public int hashCode() {
        JSONObject jSONObject = this.params;
        if (jSONObject == null) {
            return 0;
        }
        return jSONObject.hashCode();
    }

    public String toString() {
        return "PTYTaskData(params=" + this.params + ')';
    }

    public PTYTaskData(JSONObject jSONObject) {
        this.params = jSONObject;
    }

    public final JSONObject getParams() {
        return this.params;
    }

    public final DataFetcher getDataFetcher() {
        return this.dataFetcher;
    }

    public final void setDataFetcher(DataFetcher dataFetcher) {
        this.dataFetcher = dataFetcher;
    }
}
