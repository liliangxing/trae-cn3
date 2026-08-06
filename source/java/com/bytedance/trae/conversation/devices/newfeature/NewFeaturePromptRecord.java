package com.bytedance.trae.conversation.devices.newfeature;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.conversation.devices.DeviceProductType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NewFeaturePromptPolicy.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;", "", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "version", "", "<init>", "(Lcom/bytedance/trae/conversation/devices/DeviceProductType;I)V", "getProductType", "()Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "getVersion", "()I", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class NewFeaturePromptRecord {
    private final DeviceProductType productType;
    private final int version;

    public static /* synthetic */ NewFeaturePromptRecord copy$default(NewFeaturePromptRecord newFeaturePromptRecord, DeviceProductType deviceProductType, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            deviceProductType = newFeaturePromptRecord.productType;
        }
        if ((i2 & 2) != 0) {
            i = newFeaturePromptRecord.version;
        }
        return newFeaturePromptRecord.copy(deviceProductType, i);
    }

    /* renamed from: component1, reason: from getter */
    public final DeviceProductType getProductType() {
        return this.productType;
    }

    /* renamed from: component2, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public final NewFeaturePromptRecord copy(DeviceProductType productType, int version) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        return new NewFeaturePromptRecord(productType, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewFeaturePromptRecord)) {
            return false;
        }
        NewFeaturePromptRecord newFeaturePromptRecord = (NewFeaturePromptRecord) other;
        return this.productType == newFeaturePromptRecord.productType && this.version == newFeaturePromptRecord.version;
    }

    public int hashCode() {
        return (this.productType.hashCode() * 31) + Integer.hashCode(this.version);
    }

    public String toString() {
        return "NewFeaturePromptRecord(productType=" + this.productType + ", version=" + this.version + ')';
    }

    public NewFeaturePromptRecord(DeviceProductType productType, int i) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        this.productType = productType;
        this.version = i;
    }

    public final DeviceProductType getProductType() {
        return this.productType;
    }

    public final int getVersion() {
        return this.version;
    }
}
