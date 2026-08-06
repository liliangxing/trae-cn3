package com.bytedance.trae.im.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FinishCardResult.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/im/model/FinishCardResultData;", "", "summary", "", "products", "Lcom/bytedance/trae/im/model/ArtifactData;", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/im/model/ArtifactData;)V", "getSummary", "()Ljava/lang/String;", "getProducts", "()Lcom/bytedance/trae/im/model/ArtifactData;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class FinishCardResultData {

    @SerializedName("products")
    private final ArtifactData products;

    @SerializedName("summary")
    private final String summary;

    /* JADX WARN: Multi-variable type inference failed */
    public FinishCardResultData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ FinishCardResultData copy$default(FinishCardResultData finishCardResultData, String str, ArtifactData artifactData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = finishCardResultData.summary;
        }
        if ((i & 2) != 0) {
            artifactData = finishCardResultData.products;
        }
        return finishCardResultData.copy(str, artifactData);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    /* renamed from: component2, reason: from getter */
    public final ArtifactData getProducts() {
        return this.products;
    }

    public final FinishCardResultData copy(String summary, ArtifactData products) {
        return new FinishCardResultData(summary, products);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FinishCardResultData)) {
            return false;
        }
        FinishCardResultData finishCardResultData = (FinishCardResultData) other;
        return Intrinsics.areEqual(this.summary, finishCardResultData.summary) && Intrinsics.areEqual(this.products, finishCardResultData.products);
    }

    public int hashCode() {
        String str = this.summary;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ArtifactData artifactData = this.products;
        return hashCode + (artifactData != null ? artifactData.hashCode() : 0);
    }

    public String toString() {
        return "FinishCardResultData(summary=" + this.summary + ", products=" + this.products + ')';
    }

    public FinishCardResultData(String str, ArtifactData artifactData) {
        this.summary = str;
        this.products = artifactData;
    }

    public /* synthetic */ FinishCardResultData(String str, ArtifactData artifactData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : artifactData);
    }

    public final String getSummary() {
        return this.summary;
    }

    public final ArtifactData getProducts() {
        return this.products;
    }
}
