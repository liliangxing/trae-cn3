package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FinishCardResult.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0099\u0001\u0010\u001f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006&"}, d2 = {"Lcom/bytedance/trae/im/model/SessionProductsData;", "", "previews", "", "", "changedDocs", "changedCodes", "changedImages", "changedSheets", "changedSlides", "changedSkills", "mergeProducts", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getPreviews", "()Ljava/util/List;", "getChangedDocs", "getChangedCodes", "getChangedImages", "getChangedSheets", "getChangedSlides", "getChangedSkills", "getMergeProducts", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SessionProductsData {

    @SerializedName("changed_codes")
    private final List<String> changedCodes;

    @SerializedName("changed_docs")
    private final List<String> changedDocs;

    @SerializedName("changed_images")
    private final List<String> changedImages;

    @SerializedName("changed_sheets")
    private final List<String> changedSheets;

    @SerializedName("changed_skills")
    private final List<String> changedSkills;

    @SerializedName("changed_slides")
    private final List<String> changedSlides;

    @SerializedName("merge_products")
    private final List<String> mergeProducts;

    @SerializedName("previews")
    private final List<String> previews;

    public SessionProductsData() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public final List<String> component1() {
        return this.previews;
    }

    public final List<String> component2() {
        return this.changedDocs;
    }

    public final List<String> component3() {
        return this.changedCodes;
    }

    public final List<String> component4() {
        return this.changedImages;
    }

    public final List<String> component5() {
        return this.changedSheets;
    }

    public final List<String> component6() {
        return this.changedSlides;
    }

    public final List<String> component7() {
        return this.changedSkills;
    }

    public final List<String> component8() {
        return this.mergeProducts;
    }

    public final SessionProductsData copy(List<String> previews, List<String> changedDocs, List<String> changedCodes, List<String> changedImages, List<String> changedSheets, List<String> changedSlides, List<String> changedSkills, List<String> mergeProducts) {
        return new SessionProductsData(previews, changedDocs, changedCodes, changedImages, changedSheets, changedSlides, changedSkills, mergeProducts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionProductsData)) {
            return false;
        }
        SessionProductsData sessionProductsData = (SessionProductsData) other;
        return Intrinsics.areEqual(this.previews, sessionProductsData.previews) && Intrinsics.areEqual(this.changedDocs, sessionProductsData.changedDocs) && Intrinsics.areEqual(this.changedCodes, sessionProductsData.changedCodes) && Intrinsics.areEqual(this.changedImages, sessionProductsData.changedImages) && Intrinsics.areEqual(this.changedSheets, sessionProductsData.changedSheets) && Intrinsics.areEqual(this.changedSlides, sessionProductsData.changedSlides) && Intrinsics.areEqual(this.changedSkills, sessionProductsData.changedSkills) && Intrinsics.areEqual(this.mergeProducts, sessionProductsData.mergeProducts);
    }

    public int hashCode() {
        List<String> list = this.previews;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<String> list2 = this.changedDocs;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<String> list3 = this.changedCodes;
        int hashCode3 = (hashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<String> list4 = this.changedImages;
        int hashCode4 = (hashCode3 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<String> list5 = this.changedSheets;
        int hashCode5 = (hashCode4 + (list5 == null ? 0 : list5.hashCode())) * 31;
        List<String> list6 = this.changedSlides;
        int hashCode6 = (hashCode5 + (list6 == null ? 0 : list6.hashCode())) * 31;
        List<String> list7 = this.changedSkills;
        int hashCode7 = (hashCode6 + (list7 == null ? 0 : list7.hashCode())) * 31;
        List<String> list8 = this.mergeProducts;
        return hashCode7 + (list8 != null ? list8.hashCode() : 0);
    }

    public String toString() {
        return "SessionProductsData(previews=" + this.previews + ", changedDocs=" + this.changedDocs + ", changedCodes=" + this.changedCodes + ", changedImages=" + this.changedImages + ", changedSheets=" + this.changedSheets + ", changedSlides=" + this.changedSlides + ", changedSkills=" + this.changedSkills + ", mergeProducts=" + this.mergeProducts + ')';
    }

    public SessionProductsData(List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, List<String> list7, List<String> list8) {
        this.previews = list;
        this.changedDocs = list2;
        this.changedCodes = list3;
        this.changedImages = list4;
        this.changedSheets = list5;
        this.changedSlides = list6;
        this.changedSkills = list7;
        this.mergeProducts = list8;
    }

    public /* synthetic */ SessionProductsData(List list, List list2, List list3, List list4, List list5, List list6, List list7, List list8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3, (i & 8) != 0 ? null : list4, (i & 16) != 0 ? null : list5, (i & 32) != 0 ? null : list6, (i & 64) != 0 ? null : list7, (i & 128) == 0 ? list8 : null);
    }

    public final List<String> getPreviews() {
        return this.previews;
    }

    public final List<String> getChangedDocs() {
        return this.changedDocs;
    }

    public final List<String> getChangedCodes() {
        return this.changedCodes;
    }

    public final List<String> getChangedImages() {
        return this.changedImages;
    }

    public final List<String> getChangedSheets() {
        return this.changedSheets;
    }

    public final List<String> getChangedSlides() {
        return this.changedSlides;
    }

    public final List<String> getChangedSkills() {
        return this.changedSkills;
    }

    public final List<String> getMergeProducts() {
        return this.mergeProducts;
    }
}
