package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;", "", "rate", "Ljava/math/BigDecimal;", "memberDiscount", "consumptionRate", "<init>", "(Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;)V", "getRate", "()Ljava/math/BigDecimal;", "getMemberDiscount", "getConsumptionRate", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ModelFeatureDiscountData {

    @SerializedName("consumption_rate")
    private final BigDecimal consumptionRate;

    @SerializedName("member_discount")
    private final BigDecimal memberDiscount;

    @SerializedName("rate")
    private final BigDecimal rate;

    public ModelFeatureDiscountData() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ModelFeatureDiscountData copy$default(ModelFeatureDiscountData modelFeatureDiscountData, BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3, int i, Object obj) {
        if ((i & 1) != 0) {
            bigDecimal = modelFeatureDiscountData.rate;
        }
        if ((i & 2) != 0) {
            bigDecimal2 = modelFeatureDiscountData.memberDiscount;
        }
        if ((i & 4) != 0) {
            bigDecimal3 = modelFeatureDiscountData.consumptionRate;
        }
        return modelFeatureDiscountData.copy(bigDecimal, bigDecimal2, bigDecimal3);
    }

    /* renamed from: component1, reason: from getter */
    public final BigDecimal getRate() {
        return this.rate;
    }

    /* renamed from: component2, reason: from getter */
    public final BigDecimal getMemberDiscount() {
        return this.memberDiscount;
    }

    /* renamed from: component3, reason: from getter */
    public final BigDecimal getConsumptionRate() {
        return this.consumptionRate;
    }

    public final ModelFeatureDiscountData copy(BigDecimal rate, BigDecimal memberDiscount, BigDecimal consumptionRate) {
        return new ModelFeatureDiscountData(rate, memberDiscount, consumptionRate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelFeatureDiscountData)) {
            return false;
        }
        ModelFeatureDiscountData modelFeatureDiscountData = (ModelFeatureDiscountData) other;
        return Intrinsics.areEqual(this.rate, modelFeatureDiscountData.rate) && Intrinsics.areEqual(this.memberDiscount, modelFeatureDiscountData.memberDiscount) && Intrinsics.areEqual(this.consumptionRate, modelFeatureDiscountData.consumptionRate);
    }

    public int hashCode() {
        BigDecimal bigDecimal = this.rate;
        int hashCode = (bigDecimal == null ? 0 : bigDecimal.hashCode()) * 31;
        BigDecimal bigDecimal2 = this.memberDiscount;
        int hashCode2 = (hashCode + (bigDecimal2 == null ? 0 : bigDecimal2.hashCode())) * 31;
        BigDecimal bigDecimal3 = this.consumptionRate;
        return hashCode2 + (bigDecimal3 != null ? bigDecimal3.hashCode() : 0);
    }

    public String toString() {
        return "ModelFeatureDiscountData(rate=" + this.rate + ", memberDiscount=" + this.memberDiscount + ", consumptionRate=" + this.consumptionRate + ')';
    }

    public ModelFeatureDiscountData(BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3) {
        this.rate = bigDecimal;
        this.memberDiscount = bigDecimal2;
        this.consumptionRate = bigDecimal3;
    }

    public /* synthetic */ ModelFeatureDiscountData(BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bigDecimal, (i & 2) != 0 ? null : bigDecimal2, (i & 4) != 0 ? null : bigDecimal3);
    }

    public final BigDecimal getRate() {
        return this.rate;
    }

    public final BigDecimal getMemberDiscount() {
        return this.memberDiscount;
    }

    public final BigDecimal getConsumptionRate() {
        return this.consumptionRate;
    }
}
