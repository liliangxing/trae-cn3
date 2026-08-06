package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModelPricingPolicy.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;", "", "consumptionRate", "Ljava/math/BigDecimal;", "discountTag", "Lcom/bytedance/trae/conversation/network/ModelDiscountTag;", "<init>", "(Ljava/math/BigDecimal;Lcom/bytedance/trae/conversation/network/ModelDiscountTag;)V", "getConsumptionRate", "()Ljava/math/BigDecimal;", "getDiscountTag", "()Lcom/bytedance/trae/conversation/network/ModelDiscountTag;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ModelPricingPresentation {
    private final BigDecimal consumptionRate;
    private final ModelDiscountTag discountTag;

    /* JADX WARN: Multi-variable type inference failed */
    public ModelPricingPresentation() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ModelPricingPresentation copy$default(ModelPricingPresentation modelPricingPresentation, BigDecimal bigDecimal, ModelDiscountTag modelDiscountTag, int i, Object obj) {
        if ((i & 1) != 0) {
            bigDecimal = modelPricingPresentation.consumptionRate;
        }
        if ((i & 2) != 0) {
            modelDiscountTag = modelPricingPresentation.discountTag;
        }
        return modelPricingPresentation.copy(bigDecimal, modelDiscountTag);
    }

    /* renamed from: component1, reason: from getter */
    public final BigDecimal getConsumptionRate() {
        return this.consumptionRate;
    }

    /* renamed from: component2, reason: from getter */
    public final ModelDiscountTag getDiscountTag() {
        return this.discountTag;
    }

    public final ModelPricingPresentation copy(BigDecimal consumptionRate, ModelDiscountTag discountTag) {
        return new ModelPricingPresentation(consumptionRate, discountTag);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelPricingPresentation)) {
            return false;
        }
        ModelPricingPresentation modelPricingPresentation = (ModelPricingPresentation) other;
        return Intrinsics.areEqual(this.consumptionRate, modelPricingPresentation.consumptionRate) && Intrinsics.areEqual(this.discountTag, modelPricingPresentation.discountTag);
    }

    public int hashCode() {
        BigDecimal bigDecimal = this.consumptionRate;
        int hashCode = (bigDecimal == null ? 0 : bigDecimal.hashCode()) * 31;
        ModelDiscountTag modelDiscountTag = this.discountTag;
        return hashCode + (modelDiscountTag != null ? modelDiscountTag.hashCode() : 0);
    }

    public String toString() {
        return "ModelPricingPresentation(consumptionRate=" + this.consumptionRate + ", discountTag=" + this.discountTag + ')';
    }

    public ModelPricingPresentation(BigDecimal bigDecimal, ModelDiscountTag modelDiscountTag) {
        this.consumptionRate = bigDecimal;
        this.discountTag = modelDiscountTag;
    }

    public /* synthetic */ ModelPricingPresentation(BigDecimal bigDecimal, ModelDiscountTag modelDiscountTag, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bigDecimal, (i & 2) != 0 ? null : modelDiscountTag);
    }

    public final BigDecimal getConsumptionRate() {
        return this.consumptionRate;
    }

    public final ModelDiscountTag getDiscountTag() {
        return this.discountTag;
    }
}
