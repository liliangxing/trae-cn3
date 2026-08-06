package com.bytedance.trae.im.model;

import com.bytedance.timonbase.scene.PageDataManager;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FinishCardResult.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003JJ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/bytedance/trae/im/model/FinishCardResult;", "", PageDataManager.EXTRA_STATUS, "", "summary", "", "products", "Lcom/bytedance/trae/im/model/ArtifactData;", "sessionProducts", "Lcom/bytedance/trae/im/model/SessionProductsData;", "data", "Lcom/bytedance/trae/im/model/FinishCardResultData;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Lcom/bytedance/trae/im/model/ArtifactData;Lcom/bytedance/trae/im/model/SessionProductsData;Lcom/bytedance/trae/im/model/FinishCardResultData;)V", "getStatus", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSummary", "()Ljava/lang/String;", "getProducts", "()Lcom/bytedance/trae/im/model/ArtifactData;", "getSessionProducts", "()Lcom/bytedance/trae/im/model/SessionProductsData;", "getData", "()Lcom/bytedance/trae/im/model/FinishCardResultData;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Lcom/bytedance/trae/im/model/ArtifactData;Lcom/bytedance/trae/im/model/SessionProductsData;Lcom/bytedance/trae/im/model/FinishCardResultData;)Lcom/bytedance/trae/im/model/FinishCardResult;", "equals", "other", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class FinishCardResult {

    @SerializedName("data")
    private final FinishCardResultData data;

    @SerializedName("products")
    private final ArtifactData products;

    @SerializedName("session_products")
    private final SessionProductsData sessionProducts;

    @SerializedName(PageDataManager.EXTRA_STATUS)
    private final Boolean status;

    @SerializedName("summary")
    private final String summary;

    public FinishCardResult() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ FinishCardResult copy$default(FinishCardResult finishCardResult, Boolean bool, String str, ArtifactData artifactData, SessionProductsData sessionProductsData, FinishCardResultData finishCardResultData, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = finishCardResult.status;
        }
        if ((i & 2) != 0) {
            str = finishCardResult.summary;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            artifactData = finishCardResult.products;
        }
        ArtifactData artifactData2 = artifactData;
        if ((i & 8) != 0) {
            sessionProductsData = finishCardResult.sessionProducts;
        }
        SessionProductsData sessionProductsData2 = sessionProductsData;
        if ((i & 16) != 0) {
            finishCardResultData = finishCardResult.data;
        }
        return finishCardResult.copy(bool, str2, artifactData2, sessionProductsData2, finishCardResultData);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    /* renamed from: component3, reason: from getter */
    public final ArtifactData getProducts() {
        return this.products;
    }

    /* renamed from: component4, reason: from getter */
    public final SessionProductsData getSessionProducts() {
        return this.sessionProducts;
    }

    /* renamed from: component5, reason: from getter */
    public final FinishCardResultData getData() {
        return this.data;
    }

    public final FinishCardResult copy(Boolean status, String summary, ArtifactData products, SessionProductsData sessionProducts, FinishCardResultData data) {
        return new FinishCardResult(status, summary, products, sessionProducts, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FinishCardResult)) {
            return false;
        }
        FinishCardResult finishCardResult = (FinishCardResult) other;
        return Intrinsics.areEqual(this.status, finishCardResult.status) && Intrinsics.areEqual(this.summary, finishCardResult.summary) && Intrinsics.areEqual(this.products, finishCardResult.products) && Intrinsics.areEqual(this.sessionProducts, finishCardResult.sessionProducts) && Intrinsics.areEqual(this.data, finishCardResult.data);
    }

    public int hashCode() {
        Boolean bool = this.status;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.summary;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        ArtifactData artifactData = this.products;
        int hashCode3 = (hashCode2 + (artifactData == null ? 0 : artifactData.hashCode())) * 31;
        SessionProductsData sessionProductsData = this.sessionProducts;
        int hashCode4 = (hashCode3 + (sessionProductsData == null ? 0 : sessionProductsData.hashCode())) * 31;
        FinishCardResultData finishCardResultData = this.data;
        return hashCode4 + (finishCardResultData != null ? finishCardResultData.hashCode() : 0);
    }

    public String toString() {
        return "FinishCardResult(status=" + this.status + ", summary=" + this.summary + ", products=" + this.products + ", sessionProducts=" + this.sessionProducts + ", data=" + this.data + ')';
    }

    public FinishCardResult(Boolean bool, String str, ArtifactData artifactData, SessionProductsData sessionProductsData, FinishCardResultData finishCardResultData) {
        this.status = bool;
        this.summary = str;
        this.products = artifactData;
        this.sessionProducts = sessionProductsData;
        this.data = finishCardResultData;
    }

    public /* synthetic */ FinishCardResult(Boolean bool, String str, ArtifactData artifactData, SessionProductsData sessionProductsData, FinishCardResultData finishCardResultData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : artifactData, (i & 8) != 0 ? null : sessionProductsData, (i & 16) != 0 ? null : finishCardResultData);
    }

    public final Boolean getStatus() {
        return this.status;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final ArtifactData getProducts() {
        return this.products;
    }

    public final SessionProductsData getSessionProducts() {
        return this.sessionProducts;
    }

    public final FinishCardResultData getData() {
        return this.data;
    }
}
