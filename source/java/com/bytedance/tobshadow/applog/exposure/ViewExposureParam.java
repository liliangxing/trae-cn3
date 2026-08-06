package com.bytedance.tobshadow.applog.exposure;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.tobshadow.bdtracker.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/tobshadow/applog/exposure/ViewExposureParam;", "", "exposureParam", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getExposureParam", "()Lorg/json/JSONObject;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final /* data */ class ViewExposureParam {
    public final JSONObject exposureParam;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewExposureParam() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ViewExposureParam(JSONObject exposureParam) {
        Intrinsics.checkParameterIsNotNull(exposureParam, "exposureParam");
        this.exposureParam = exposureParam;
    }

    public /* synthetic */ ViewExposureParam(JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new JSONObject() : jSONObject);
    }

    public static /* synthetic */ ViewExposureParam copy$default(ViewExposureParam viewExposureParam, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            jSONObject = viewExposureParam.exposureParam;
        }
        return viewExposureParam.copy(jSONObject);
    }

    /* renamed from: component1, reason: from getter */
    public final JSONObject getExposureParam() {
        return this.exposureParam;
    }

    public final ViewExposureParam copy(JSONObject exposureParam) {
        Intrinsics.checkParameterIsNotNull(exposureParam, "exposureParam");
        return new ViewExposureParam(exposureParam);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ViewExposureParam) && Intrinsics.areEqual(this.exposureParam, ((ViewExposureParam) other).exposureParam);
        }
        return true;
    }

    public final JSONObject getExposureParam() {
        return this.exposureParam;
    }

    public int hashCode() {
        JSONObject jSONObject = this.exposureParam;
        if (jSONObject != null) {
            return jSONObject.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.a("ViewExposureParam(exposureParam=").append(this.exposureParam).append(")").toString();
    }
}
