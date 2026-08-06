package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;", "", "enable", "", "subKey", "", "data", "Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;", "<init>", "(ZLjava/lang/String;Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;)V", "getEnable", "()Z", "getSubKey", "()Ljava/lang/String;", "getData", "()Lcom/bytedance/trae/conversation/network/ModelFeatureDiscountData;", "component1", "component2", "component3", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ModelFeatureDiscount {

    @SerializedName("data")
    private final ModelFeatureDiscountData data;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("subKey")
    private final String subKey;

    public ModelFeatureDiscount() {
        this(false, null, null, 7, null);
    }

    public static /* synthetic */ ModelFeatureDiscount copy$default(ModelFeatureDiscount modelFeatureDiscount, boolean z, String str, ModelFeatureDiscountData modelFeatureDiscountData, int i, Object obj) {
        if ((i & 1) != 0) {
            z = modelFeatureDiscount.enable;
        }
        if ((i & 2) != 0) {
            str = modelFeatureDiscount.subKey;
        }
        if ((i & 4) != 0) {
            modelFeatureDiscountData = modelFeatureDiscount.data;
        }
        return modelFeatureDiscount.copy(z, str, modelFeatureDiscountData);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSubKey() {
        return this.subKey;
    }

    /* renamed from: component3, reason: from getter */
    public final ModelFeatureDiscountData getData() {
        return this.data;
    }

    public final ModelFeatureDiscount copy(boolean enable, String subKey, ModelFeatureDiscountData data) {
        return new ModelFeatureDiscount(enable, subKey, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelFeatureDiscount)) {
            return false;
        }
        ModelFeatureDiscount modelFeatureDiscount = (ModelFeatureDiscount) other;
        return this.enable == modelFeatureDiscount.enable && Intrinsics.areEqual(this.subKey, modelFeatureDiscount.subKey) && Intrinsics.areEqual(this.data, modelFeatureDiscount.data);
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.enable) * 31;
        String str = this.subKey;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        ModelFeatureDiscountData modelFeatureDiscountData = this.data;
        return hashCode2 + (modelFeatureDiscountData != null ? modelFeatureDiscountData.hashCode() : 0);
    }

    public String toString() {
        return "ModelFeatureDiscount(enable=" + this.enable + ", subKey=" + this.subKey + ", data=" + this.data + ')';
    }

    public ModelFeatureDiscount(boolean z, String str, ModelFeatureDiscountData modelFeatureDiscountData) {
        this.enable = z;
        this.subKey = str;
        this.data = modelFeatureDiscountData;
    }

    public /* synthetic */ ModelFeatureDiscount(boolean z, String str, ModelFeatureDiscountData modelFeatureDiscountData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : modelFeatureDiscountData);
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final String getSubKey() {
        return this.subKey;
    }

    public final ModelFeatureDiscountData getData() {
        return this.data;
    }
}
