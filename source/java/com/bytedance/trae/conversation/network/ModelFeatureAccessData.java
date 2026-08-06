package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/network/ModelFeatureAccessData;", "", "identityList", "", "", "<init>", "(Ljava/util/List;)V", "getIdentityList", "()Ljava/util/List;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ModelFeatureAccessData {

    @SerializedName("identity_list")
    private final List<Integer> identityList;

    /* JADX WARN: Multi-variable type inference failed */
    public ModelFeatureAccessData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelFeatureAccessData copy$default(ModelFeatureAccessData modelFeatureAccessData, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = modelFeatureAccessData.identityList;
        }
        return modelFeatureAccessData.copy(list);
    }

    public final List<Integer> component1() {
        return this.identityList;
    }

    public final ModelFeatureAccessData copy(List<Integer> identityList) {
        return new ModelFeatureAccessData(identityList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ModelFeatureAccessData) && Intrinsics.areEqual(this.identityList, ((ModelFeatureAccessData) other).identityList);
    }

    public int hashCode() {
        List<Integer> list = this.identityList;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "ModelFeatureAccessData(identityList=" + this.identityList + ')';
    }

    public ModelFeatureAccessData(List<Integer> list) {
        this.identityList = list;
    }

    public /* synthetic */ ModelFeatureAccessData(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public final List<Integer> getIdentityList() {
        return this.identityList;
    }
}
