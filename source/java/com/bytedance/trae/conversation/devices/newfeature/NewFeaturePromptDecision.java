package com.bytedance.trae.conversation.devices.newfeature;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.conversation.devices.DeviceProductType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NewFeaturePromptPolicy.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptDecision;", "", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "<init>", "(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)V", "getProductType", "()Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class NewFeaturePromptDecision {
    private final DeviceProductType productType;

    public static /* synthetic */ NewFeaturePromptDecision copy$default(NewFeaturePromptDecision newFeaturePromptDecision, DeviceProductType deviceProductType, int i, Object obj) {
        if ((i & 1) != 0) {
            deviceProductType = newFeaturePromptDecision.productType;
        }
        return newFeaturePromptDecision.copy(deviceProductType);
    }

    /* renamed from: component1, reason: from getter */
    public final DeviceProductType getProductType() {
        return this.productType;
    }

    public final NewFeaturePromptDecision copy(DeviceProductType productType) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        return new NewFeaturePromptDecision(productType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof NewFeaturePromptDecision) && this.productType == ((NewFeaturePromptDecision) other).productType;
    }

    public int hashCode() {
        return this.productType.hashCode();
    }

    public String toString() {
        return "NewFeaturePromptDecision(productType=" + this.productType + ')';
    }

    public NewFeaturePromptDecision(DeviceProductType productType) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        this.productType = productType;
    }

    public final DeviceProductType getProductType() {
        return this.productType;
    }
}
