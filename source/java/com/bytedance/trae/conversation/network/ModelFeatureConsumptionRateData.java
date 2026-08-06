package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRateData;", "", "rate", "Ljava/math/BigDecimal;", "<init>", "(Ljava/math/BigDecimal;)V", "getRate", "()Ljava/math/BigDecimal;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ModelFeatureConsumptionRateData {

    @SerializedName("rate")
    private final BigDecimal rate;

    /* JADX WARN: Multi-variable type inference failed */
    public ModelFeatureConsumptionRateData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ModelFeatureConsumptionRateData copy$default(ModelFeatureConsumptionRateData modelFeatureConsumptionRateData, BigDecimal bigDecimal, int i, Object obj) {
        if ((i & 1) != 0) {
            bigDecimal = modelFeatureConsumptionRateData.rate;
        }
        return modelFeatureConsumptionRateData.copy(bigDecimal);
    }

    /* renamed from: component1, reason: from getter */
    public final BigDecimal getRate() {
        return this.rate;
    }

    public final ModelFeatureConsumptionRateData copy(BigDecimal rate) {
        return new ModelFeatureConsumptionRateData(rate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ModelFeatureConsumptionRateData) && Intrinsics.areEqual(this.rate, ((ModelFeatureConsumptionRateData) other).rate);
    }

    public int hashCode() {
        BigDecimal bigDecimal = this.rate;
        if (bigDecimal == null) {
            return 0;
        }
        return bigDecimal.hashCode();
    }

    public String toString() {
        return "ModelFeatureConsumptionRateData(rate=" + this.rate + ')';
    }

    public ModelFeatureConsumptionRateData(BigDecimal bigDecimal) {
        this.rate = bigDecimal;
    }

    public /* synthetic */ ModelFeatureConsumptionRateData(BigDecimal bigDecimal, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bigDecimal);
    }

    public final BigDecimal getRate() {
        return this.rate;
    }
}
