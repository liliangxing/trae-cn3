package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/network/ModelFeatureAccess;", "", "enable", "", "data", "Lcom/bytedance/trae/conversation/network/ModelFeatureAccessData;", "<init>", "(ZLcom/bytedance/trae/conversation/network/ModelFeatureAccessData;)V", "getEnable", "()Z", "getData", "()Lcom/bytedance/trae/conversation/network/ModelFeatureAccessData;", "component1", "component2", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ModelFeatureAccess {

    @SerializedName("data")
    private final ModelFeatureAccessData data;

    @SerializedName("enable")
    private final boolean enable;

    /* JADX WARN: Multi-variable type inference failed */
    public ModelFeatureAccess() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ModelFeatureAccess copy$default(ModelFeatureAccess modelFeatureAccess, boolean z, ModelFeatureAccessData modelFeatureAccessData, int i, Object obj) {
        if ((i & 1) != 0) {
            z = modelFeatureAccess.enable;
        }
        if ((i & 2) != 0) {
            modelFeatureAccessData = modelFeatureAccess.data;
        }
        return modelFeatureAccess.copy(z, modelFeatureAccessData);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2, reason: from getter */
    public final ModelFeatureAccessData getData() {
        return this.data;
    }

    public final ModelFeatureAccess copy(boolean enable, ModelFeatureAccessData data) {
        return new ModelFeatureAccess(enable, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelFeatureAccess)) {
            return false;
        }
        ModelFeatureAccess modelFeatureAccess = (ModelFeatureAccess) other;
        return this.enable == modelFeatureAccess.enable && Intrinsics.areEqual(this.data, modelFeatureAccess.data);
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.enable) * 31;
        ModelFeatureAccessData modelFeatureAccessData = this.data;
        return hashCode + (modelFeatureAccessData == null ? 0 : modelFeatureAccessData.hashCode());
    }

    public String toString() {
        return "ModelFeatureAccess(enable=" + this.enable + ", data=" + this.data + ')';
    }

    public ModelFeatureAccess(boolean z, ModelFeatureAccessData modelFeatureAccessData) {
        this.enable = z;
        this.data = modelFeatureAccessData;
    }

    public /* synthetic */ ModelFeatureAccess(boolean z, ModelFeatureAccessData modelFeatureAccessData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : modelFeatureAccessData);
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final ModelFeatureAccessData getData() {
        return this.data;
    }
}
