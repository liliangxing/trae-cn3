package com.bytedance.trae.conversation.network;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/bytedance/trae/conversation/network/ModelFeatures;", "", "access", "Lcom/bytedance/trae/conversation/network/ModelFeatureAccess;", "cost", "Lcom/bytedance/trae/conversation/network/ModelFeatureCost;", "consumptionRate", "Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRate;", "discount", "Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;", "<init>", "(Lcom/bytedance/trae/conversation/network/ModelFeatureAccess;Lcom/bytedance/trae/conversation/network/ModelFeatureCost;Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRate;Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;)V", "getAccess", "()Lcom/bytedance/trae/conversation/network/ModelFeatureAccess;", "getCost", "()Lcom/bytedance/trae/conversation/network/ModelFeatureCost;", "getConsumptionRate", "()Lcom/bytedance/trae/conversation/network/ModelFeatureConsumptionRate;", "getDiscount", "()Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class ModelFeatures {

    @SerializedName("access")
    private final ModelFeatureAccess access;

    @SerializedName("consumption_rate")
    private final ModelFeatureConsumptionRate consumptionRate;

    @SerializedName("cost")
    private final ModelFeatureCost cost;

    @SerializedName("discount")
    private final ModelFeatureDiscount discount;

    public ModelFeatures() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ModelFeatures copy$default(ModelFeatures modelFeatures, ModelFeatureAccess modelFeatureAccess, ModelFeatureCost modelFeatureCost, ModelFeatureConsumptionRate modelFeatureConsumptionRate, ModelFeatureDiscount modelFeatureDiscount, int i, Object obj) {
        if ((i & 1) != 0) {
            modelFeatureAccess = modelFeatures.access;
        }
        if ((i & 2) != 0) {
            modelFeatureCost = modelFeatures.cost;
        }
        if ((i & 4) != 0) {
            modelFeatureConsumptionRate = modelFeatures.consumptionRate;
        }
        if ((i & 8) != 0) {
            modelFeatureDiscount = modelFeatures.discount;
        }
        return modelFeatures.copy(modelFeatureAccess, modelFeatureCost, modelFeatureConsumptionRate, modelFeatureDiscount);
    }

    /* renamed from: component1, reason: from getter */
    public final ModelFeatureAccess getAccess() {
        return this.access;
    }

    /* renamed from: component2, reason: from getter */
    public final ModelFeatureCost getCost() {
        return this.cost;
    }

    /* renamed from: component3, reason: from getter */
    public final ModelFeatureConsumptionRate getConsumptionRate() {
        return this.consumptionRate;
    }

    /* renamed from: component4, reason: from getter */
    public final ModelFeatureDiscount getDiscount() {
        return this.discount;
    }

    public final ModelFeatures copy(ModelFeatureAccess access, ModelFeatureCost cost, ModelFeatureConsumptionRate consumptionRate, ModelFeatureDiscount discount) {
        return new ModelFeatures(access, cost, consumptionRate, discount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelFeatures)) {
            return false;
        }
        ModelFeatures modelFeatures = (ModelFeatures) other;
        return Intrinsics.areEqual(this.access, modelFeatures.access) && Intrinsics.areEqual(this.cost, modelFeatures.cost) && Intrinsics.areEqual(this.consumptionRate, modelFeatures.consumptionRate) && Intrinsics.areEqual(this.discount, modelFeatures.discount);
    }

    public int hashCode() {
        ModelFeatureAccess modelFeatureAccess = this.access;
        int hashCode = (modelFeatureAccess == null ? 0 : modelFeatureAccess.hashCode()) * 31;
        ModelFeatureCost modelFeatureCost = this.cost;
        int hashCode2 = (hashCode + (modelFeatureCost == null ? 0 : modelFeatureCost.hashCode())) * 31;
        ModelFeatureConsumptionRate modelFeatureConsumptionRate = this.consumptionRate;
        int hashCode3 = (hashCode2 + (modelFeatureConsumptionRate == null ? 0 : modelFeatureConsumptionRate.hashCode())) * 31;
        ModelFeatureDiscount modelFeatureDiscount = this.discount;
        return hashCode3 + (modelFeatureDiscount != null ? modelFeatureDiscount.hashCode() : 0);
    }

    public String toString() {
        return "ModelFeatures(access=" + this.access + ", cost=" + this.cost + ", consumptionRate=" + this.consumptionRate + ", discount=" + this.discount + ')';
    }

    public ModelFeatures(ModelFeatureAccess modelFeatureAccess, ModelFeatureCost modelFeatureCost, ModelFeatureConsumptionRate modelFeatureConsumptionRate, ModelFeatureDiscount modelFeatureDiscount) {
        this.access = modelFeatureAccess;
        this.cost = modelFeatureCost;
        this.consumptionRate = modelFeatureConsumptionRate;
        this.discount = modelFeatureDiscount;
    }

    public /* synthetic */ ModelFeatures(ModelFeatureAccess modelFeatureAccess, ModelFeatureCost modelFeatureCost, ModelFeatureConsumptionRate modelFeatureConsumptionRate, ModelFeatureDiscount modelFeatureDiscount, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : modelFeatureAccess, (i & 2) != 0 ? null : modelFeatureCost, (i & 4) != 0 ? null : modelFeatureConsumptionRate, (i & 8) != 0 ? null : modelFeatureDiscount);
    }

    public final ModelFeatureAccess getAccess() {
        return this.access;
    }

    public final ModelFeatureCost getCost() {
        return this.cost;
    }

    public final ModelFeatureConsumptionRate getConsumptionRate() {
        return this.consumptionRate;
    }

    public final ModelFeatureDiscount getDiscount() {
        return this.discount;
    }
}
