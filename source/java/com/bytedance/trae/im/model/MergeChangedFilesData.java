package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FinishCardResult.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003Jc\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/bytedance/trae/im/model/MergeChangedFilesData;", "", "sourceBranch", "", "targetBranch", "sourceBranchHash", "targetBranchHash", "mergeBaseHash", "totalDiffInfo", "Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;", "fileDiffInfos", "", "Lcom/bytedance/trae/im/model/MergeFileDiffInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;Ljava/util/List;)V", "getSourceBranch", "()Ljava/lang/String;", "getTargetBranch", "getSourceBranchHash", "getTargetBranchHash", "getMergeBaseHash", "getTotalDiffInfo", "()Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;", "getFileDiffInfos", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MergeChangedFilesData {

    @SerializedName("file_diff_infos")
    private final List<MergeFileDiffInfo> fileDiffInfos;

    @SerializedName("merge_base_hash")
    private final String mergeBaseHash;

    @SerializedName("source_branch")
    private final String sourceBranch;

    @SerializedName("source_branch_hash")
    private final String sourceBranchHash;

    @SerializedName("target_branch")
    private final String targetBranch;

    @SerializedName("target_branch_hash")
    private final String targetBranchHash;

    @SerializedName("total_diff_info")
    private final MergeTotalDiffInfo totalDiffInfo;

    public MergeChangedFilesData() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ MergeChangedFilesData copy$default(MergeChangedFilesData mergeChangedFilesData, String str, String str2, String str3, String str4, String str5, MergeTotalDiffInfo mergeTotalDiffInfo, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mergeChangedFilesData.sourceBranch;
        }
        if ((i & 2) != 0) {
            str2 = mergeChangedFilesData.targetBranch;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = mergeChangedFilesData.sourceBranchHash;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = mergeChangedFilesData.targetBranchHash;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = mergeChangedFilesData.mergeBaseHash;
        }
        String str9 = str5;
        if ((i & 32) != 0) {
            mergeTotalDiffInfo = mergeChangedFilesData.totalDiffInfo;
        }
        MergeTotalDiffInfo mergeTotalDiffInfo2 = mergeTotalDiffInfo;
        if ((i & 64) != 0) {
            list = mergeChangedFilesData.fileDiffInfos;
        }
        return mergeChangedFilesData.copy(str, str6, str7, str8, str9, mergeTotalDiffInfo2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSourceBranch() {
        return this.sourceBranch;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTargetBranch() {
        return this.targetBranch;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSourceBranchHash() {
        return this.sourceBranchHash;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTargetBranchHash() {
        return this.targetBranchHash;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMergeBaseHash() {
        return this.mergeBaseHash;
    }

    /* renamed from: component6, reason: from getter */
    public final MergeTotalDiffInfo getTotalDiffInfo() {
        return this.totalDiffInfo;
    }

    public final List<MergeFileDiffInfo> component7() {
        return this.fileDiffInfos;
    }

    public final MergeChangedFilesData copy(String sourceBranch, String targetBranch, String sourceBranchHash, String targetBranchHash, String mergeBaseHash, MergeTotalDiffInfo totalDiffInfo, List<MergeFileDiffInfo> fileDiffInfos) {
        return new MergeChangedFilesData(sourceBranch, targetBranch, sourceBranchHash, targetBranchHash, mergeBaseHash, totalDiffInfo, fileDiffInfos);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MergeChangedFilesData)) {
            return false;
        }
        MergeChangedFilesData mergeChangedFilesData = (MergeChangedFilesData) other;
        return Intrinsics.areEqual(this.sourceBranch, mergeChangedFilesData.sourceBranch) && Intrinsics.areEqual(this.targetBranch, mergeChangedFilesData.targetBranch) && Intrinsics.areEqual(this.sourceBranchHash, mergeChangedFilesData.sourceBranchHash) && Intrinsics.areEqual(this.targetBranchHash, mergeChangedFilesData.targetBranchHash) && Intrinsics.areEqual(this.mergeBaseHash, mergeChangedFilesData.mergeBaseHash) && Intrinsics.areEqual(this.totalDiffInfo, mergeChangedFilesData.totalDiffInfo) && Intrinsics.areEqual(this.fileDiffInfos, mergeChangedFilesData.fileDiffInfos);
    }

    public int hashCode() {
        String str = this.sourceBranch;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.targetBranch;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sourceBranchHash;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.targetBranchHash;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.mergeBaseHash;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        MergeTotalDiffInfo mergeTotalDiffInfo = this.totalDiffInfo;
        int hashCode6 = (hashCode5 + (mergeTotalDiffInfo == null ? 0 : mergeTotalDiffInfo.hashCode())) * 31;
        List<MergeFileDiffInfo> list = this.fileDiffInfos;
        return hashCode6 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "MergeChangedFilesData(sourceBranch=" + this.sourceBranch + ", targetBranch=" + this.targetBranch + ", sourceBranchHash=" + this.sourceBranchHash + ", targetBranchHash=" + this.targetBranchHash + ", mergeBaseHash=" + this.mergeBaseHash + ", totalDiffInfo=" + this.totalDiffInfo + ", fileDiffInfos=" + this.fileDiffInfos + ')';
    }

    public MergeChangedFilesData(String str, String str2, String str3, String str4, String str5, MergeTotalDiffInfo mergeTotalDiffInfo, List<MergeFileDiffInfo> list) {
        this.sourceBranch = str;
        this.targetBranch = str2;
        this.sourceBranchHash = str3;
        this.targetBranchHash = str4;
        this.mergeBaseHash = str5;
        this.totalDiffInfo = mergeTotalDiffInfo;
        this.fileDiffInfos = list;
    }

    public /* synthetic */ MergeChangedFilesData(String str, String str2, String str3, String str4, String str5, MergeTotalDiffInfo mergeTotalDiffInfo, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : mergeTotalDiffInfo, (i & 64) != 0 ? null : list);
    }

    public final String getSourceBranch() {
        return this.sourceBranch;
    }

    public final String getTargetBranch() {
        return this.targetBranch;
    }

    public final String getSourceBranchHash() {
        return this.sourceBranchHash;
    }

    public final String getTargetBranchHash() {
        return this.targetBranchHash;
    }

    public final String getMergeBaseHash() {
        return this.mergeBaseHash;
    }

    public final MergeTotalDiffInfo getTotalDiffInfo() {
        return this.totalDiffInfo;
    }

    public final List<MergeFileDiffInfo> getFileDiffInfos() {
        return this.fileDiffInfos;
    }
}
