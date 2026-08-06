package com.bytedance.trae.im.model;

import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FinishCardResult.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0010HÆ\u0003J{\u0010*\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00062"}, d2 = {"Lcom/bytedance/trae/im/model/ArtifactData;", "", "previews", "", "Lcom/bytedance/trae/im/model/PreviewData;", "changedDocs", "Lcom/bytedance/trae/im/model/ChangedFileData;", "changedCodes", "changedImages", "changedSheets", "changedSlides", "changedVideos", "Lcom/bytedance/trae/im/model/ChangedVideoData;", "changedSkills", "Lcom/bytedance/trae/im/model/ChangedSkillsData;", "mergeProducts", "Lcom/bytedance/trae/im/model/MergeChangedFilesData;", "<init>", "(Ljava/util/List;Lcom/bytedance/trae/im/model/ChangedFileData;Lcom/bytedance/trae/im/model/ChangedFileData;Lcom/bytedance/trae/im/model/ChangedFileData;Lcom/bytedance/trae/im/model/ChangedFileData;Lcom/bytedance/trae/im/model/ChangedFileData;Lcom/bytedance/trae/im/model/ChangedVideoData;Lcom/bytedance/trae/im/model/ChangedSkillsData;Lcom/bytedance/trae/im/model/MergeChangedFilesData;)V", "getPreviews", "()Ljava/util/List;", "getChangedDocs", "()Lcom/bytedance/trae/im/model/ChangedFileData;", "getChangedCodes", "getChangedImages", "getChangedSheets", "getChangedSlides", "getChangedVideos", "()Lcom/bytedance/trae/im/model/ChangedVideoData;", "getChangedSkills", "()Lcom/bytedance/trae/im/model/ChangedSkillsData;", "getMergeProducts", "()Lcom/bytedance/trae/im/model/MergeChangedFilesData;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class ArtifactData {

    @SerializedName("changed_codes")
    private final ChangedFileData changedCodes;

    @SerializedName("changed_docs")
    private final ChangedFileData changedDocs;

    @SerializedName("changed_images")
    private final ChangedFileData changedImages;

    @SerializedName("changed_sheets")
    private final ChangedFileData changedSheets;

    @SerializedName("changed_skills")
    private final ChangedSkillsData changedSkills;

    @SerializedName("changed_slides")
    private final ChangedFileData changedSlides;

    @SerializedName("changed_videos")
    private final ChangedVideoData changedVideos;

    @SerializedName("merge_products")
    private final MergeChangedFilesData mergeProducts;

    @SerializedName("previews")
    private final List<PreviewData> previews;

    public ArtifactData() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public final List<PreviewData> component1() {
        return this.previews;
    }

    /* renamed from: component2, reason: from getter */
    public final ChangedFileData getChangedDocs() {
        return this.changedDocs;
    }

    /* renamed from: component3, reason: from getter */
    public final ChangedFileData getChangedCodes() {
        return this.changedCodes;
    }

    /* renamed from: component4, reason: from getter */
    public final ChangedFileData getChangedImages() {
        return this.changedImages;
    }

    /* renamed from: component5, reason: from getter */
    public final ChangedFileData getChangedSheets() {
        return this.changedSheets;
    }

    /* renamed from: component6, reason: from getter */
    public final ChangedFileData getChangedSlides() {
        return this.changedSlides;
    }

    /* renamed from: component7, reason: from getter */
    public final ChangedVideoData getChangedVideos() {
        return this.changedVideos;
    }

    /* renamed from: component8, reason: from getter */
    public final ChangedSkillsData getChangedSkills() {
        return this.changedSkills;
    }

    /* renamed from: component9, reason: from getter */
    public final MergeChangedFilesData getMergeProducts() {
        return this.mergeProducts;
    }

    public final ArtifactData copy(List<PreviewData> previews, ChangedFileData changedDocs, ChangedFileData changedCodes, ChangedFileData changedImages, ChangedFileData changedSheets, ChangedFileData changedSlides, ChangedVideoData changedVideos, ChangedSkillsData changedSkills, MergeChangedFilesData mergeProducts) {
        return new ArtifactData(previews, changedDocs, changedCodes, changedImages, changedSheets, changedSlides, changedVideos, changedSkills, mergeProducts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArtifactData)) {
            return false;
        }
        ArtifactData artifactData = (ArtifactData) other;
        return Intrinsics.areEqual(this.previews, artifactData.previews) && Intrinsics.areEqual(this.changedDocs, artifactData.changedDocs) && Intrinsics.areEqual(this.changedCodes, artifactData.changedCodes) && Intrinsics.areEqual(this.changedImages, artifactData.changedImages) && Intrinsics.areEqual(this.changedSheets, artifactData.changedSheets) && Intrinsics.areEqual(this.changedSlides, artifactData.changedSlides) && Intrinsics.areEqual(this.changedVideos, artifactData.changedVideos) && Intrinsics.areEqual(this.changedSkills, artifactData.changedSkills) && Intrinsics.areEqual(this.mergeProducts, artifactData.mergeProducts);
    }

    public int hashCode() {
        List<PreviewData> list = this.previews;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        ChangedFileData changedFileData = this.changedDocs;
        int hashCode2 = (hashCode + (changedFileData == null ? 0 : changedFileData.hashCode())) * 31;
        ChangedFileData changedFileData2 = this.changedCodes;
        int hashCode3 = (hashCode2 + (changedFileData2 == null ? 0 : changedFileData2.hashCode())) * 31;
        ChangedFileData changedFileData3 = this.changedImages;
        int hashCode4 = (hashCode3 + (changedFileData3 == null ? 0 : changedFileData3.hashCode())) * 31;
        ChangedFileData changedFileData4 = this.changedSheets;
        int hashCode5 = (hashCode4 + (changedFileData4 == null ? 0 : changedFileData4.hashCode())) * 31;
        ChangedFileData changedFileData5 = this.changedSlides;
        int hashCode6 = (hashCode5 + (changedFileData5 == null ? 0 : changedFileData5.hashCode())) * 31;
        ChangedVideoData changedVideoData = this.changedVideos;
        int hashCode7 = (hashCode6 + (changedVideoData == null ? 0 : changedVideoData.hashCode())) * 31;
        ChangedSkillsData changedSkillsData = this.changedSkills;
        int hashCode8 = (hashCode7 + (changedSkillsData == null ? 0 : changedSkillsData.hashCode())) * 31;
        MergeChangedFilesData mergeChangedFilesData = this.mergeProducts;
        return hashCode8 + (mergeChangedFilesData != null ? mergeChangedFilesData.hashCode() : 0);
    }

    public String toString() {
        return "ArtifactData(previews=" + this.previews + ", changedDocs=" + this.changedDocs + ", changedCodes=" + this.changedCodes + ", changedImages=" + this.changedImages + ", changedSheets=" + this.changedSheets + ", changedSlides=" + this.changedSlides + ", changedVideos=" + this.changedVideos + ", changedSkills=" + this.changedSkills + ", mergeProducts=" + this.mergeProducts + ')';
    }

    public ArtifactData(List<PreviewData> list, ChangedFileData changedFileData, ChangedFileData changedFileData2, ChangedFileData changedFileData3, ChangedFileData changedFileData4, ChangedFileData changedFileData5, ChangedVideoData changedVideoData, ChangedSkillsData changedSkillsData, MergeChangedFilesData mergeChangedFilesData) {
        this.previews = list;
        this.changedDocs = changedFileData;
        this.changedCodes = changedFileData2;
        this.changedImages = changedFileData3;
        this.changedSheets = changedFileData4;
        this.changedSlides = changedFileData5;
        this.changedVideos = changedVideoData;
        this.changedSkills = changedSkillsData;
        this.mergeProducts = mergeChangedFilesData;
    }

    public /* synthetic */ ArtifactData(List list, ChangedFileData changedFileData, ChangedFileData changedFileData2, ChangedFileData changedFileData3, ChangedFileData changedFileData4, ChangedFileData changedFileData5, ChangedVideoData changedVideoData, ChangedSkillsData changedSkillsData, MergeChangedFilesData mergeChangedFilesData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : changedFileData, (i & 4) != 0 ? null : changedFileData2, (i & 8) != 0 ? null : changedFileData3, (i & 16) != 0 ? null : changedFileData4, (i & 32) != 0 ? null : changedFileData5, (i & 64) != 0 ? null : changedVideoData, (i & 128) != 0 ? null : changedSkillsData, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) == 0 ? mergeChangedFilesData : null);
    }

    public final List<PreviewData> getPreviews() {
        return this.previews;
    }

    public final ChangedFileData getChangedDocs() {
        return this.changedDocs;
    }

    public final ChangedFileData getChangedCodes() {
        return this.changedCodes;
    }

    public final ChangedFileData getChangedImages() {
        return this.changedImages;
    }

    public final ChangedFileData getChangedSheets() {
        return this.changedSheets;
    }

    public final ChangedFileData getChangedSlides() {
        return this.changedSlides;
    }

    public final ChangedVideoData getChangedVideos() {
        return this.changedVideos;
    }

    public final ChangedSkillsData getChangedSkills() {
        return this.changedSkills;
    }

    public final MergeChangedFilesData getMergeProducts() {
        return this.mergeProducts;
    }
}
