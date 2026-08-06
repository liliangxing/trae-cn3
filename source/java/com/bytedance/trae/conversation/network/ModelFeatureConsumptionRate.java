package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRate;", "", "enable", "", "data", "Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;", "<init>", "(ZLcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;)V", "getEnable", "()Z", "getData", "()Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;", "component1", "component2", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ModelFeatureConsumptionRate {

    @SerializedName("data")
    private final ModelFeatureConsumptionRateData data;

    @SerializedName("enable")
    private final boolean enable;

    /* JADX WARN: Multi-variable type inference failed */
    public ModelFeatureConsumptionRate() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ModelFeatureConsumptionRate copy$default(ModelFeatureConsumptionRate modelFeatureConsumptionRate, boolean z, ModelFeatureConsumptionRateData modelFeatureConsumptionRateData, int i, Object obj) {
        if ((i & 1) != 0) {
            z = modelFeatureConsumptionRate.enable;
        }
        if ((i & 2) != 0) {
            modelFeatureConsumptionRateData = modelFeatureConsumptionRate.data;
        }
        return modelFeatureConsumptionRate.copy(z, modelFeatureConsumptionRateData);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2, reason: from getter */
    public final ModelFeatureConsumptionRateData getData() {
        return this.data;
    }

    public final ModelFeatureConsumptionRate copy(boolean enable, ModelFeatureConsumptionRateData data) {
        return new ModelFeatureConsumptionRate(enable, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelFeatureConsumptionRate)) {
            return false;
        }
        ModelFeatureConsumptionRate modelFeatureConsumptionRate = (ModelFeatureConsumptionRate) other;
        return this.enable == modelFeatureConsumptionRate.enable && Intrinsics.areEqual(this.data, modelFeatureConsumptionRate.data);
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.enable) * 31;
        ModelFeatureConsumptionRateData modelFeatureConsumptionRateData = this.data;
        return hashCode + (modelFeatureConsumptionRateData == null ? 0 : modelFeatureConsumptionRateData.hashCode());
    }

    public String toString() {
        return "ModelFeatureConsumptionRate(enable=" + this.enable + ", data=" + this.data + ')';
    }

    public ModelFeatureConsumptionRate(boolean z, ModelFeatureConsumptionRateData modelFeatureConsumptionRateData) {
        this.enable = z;
        this.data = modelFeatureConsumptionRateData;
    }

    public /* synthetic */ ModelFeatureConsumptionRate(boolean z, ModelFeatureConsumptionRateData modelFeatureConsumptionRateData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : modelFeatureConsumptionRateData);
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final ModelFeatureConsumptionRateData getData() {
        return this.data;
    }
}
