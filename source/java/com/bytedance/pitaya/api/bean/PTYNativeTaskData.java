package com.bytedance.pitaya.api.bean;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PTYNativeTaskData.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYNativeTaskData;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "data", "", "extra", "Lorg/json/JSONObject;", "(Ljava/lang/Object;Lorg/json/JSONObject;)V", "getData", "()Ljava/lang/Object;", "getExtra", "()Lorg/json/JSONObject;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PTYNativeTaskData implements ReflectionCall {
    private final Object data;
    private final JSONObject extra;

    /* JADX WARN: Multi-variable type inference failed */
    public PTYNativeTaskData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PTYNativeTaskData copy$default(PTYNativeTaskData pTYNativeTaskData, Object obj, JSONObject jSONObject, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = pTYNativeTaskData.data;
        }
        if ((i & 2) != 0) {
            jSONObject = pTYNativeTaskData.extra;
        }
        return pTYNativeTaskData.copy(obj, jSONObject);
    }

    /* renamed from: component1, reason: from getter */
    public final Object getData() {
        return this.data;
    }

    /* renamed from: component2, reason: from getter */
    public final JSONObject getExtra() {
        return this.extra;
    }

    public final PTYNativeTaskData copy(Object data, JSONObject extra) {
        return new PTYNativeTaskData(data, extra);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PTYNativeTaskData)) {
            return false;
        }
        PTYNativeTaskData pTYNativeTaskData = (PTYNativeTaskData) other;
        return Intrinsics.areEqual(this.data, pTYNativeTaskData.data) && Intrinsics.areEqual(this.extra, pTYNativeTaskData.extra);
    }

    public int hashCode() {
        Object obj = this.data;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        JSONObject jSONObject = this.extra;
        return hashCode + (jSONObject != null ? jSONObject.hashCode() : 0);
    }

    public String toString() {
        return "PTYNativeTaskData(data=" + this.data + ", extra=" + this.extra + ')';
    }

    public PTYNativeTaskData(Object obj, JSONObject jSONObject) {
        this.data = obj;
        this.extra = jSONObject;
    }

    public /* synthetic */ PTYNativeTaskData(Object obj, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj, (i & 2) != 0 ? null : jSONObject);
    }

    public final Object getData() {
        return this.data;
    }

    public final JSONObject getExtra() {
        return this.extra;
    }
}
