package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FinishCardResult.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;", "", "insertLineCount", "", "deleteLineCount", "conflictCount", "changedFilesCount", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getInsertLineCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDeleteLineCount", "getConflictCount", "getChangedFilesCount", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MergeTotalDiffInfo {

    @SerializedName("changed_files_count")
    private final Integer changedFilesCount;

    @SerializedName("conflict_count")
    private final Integer conflictCount;

    @SerializedName("delete_line_count")
    private final Integer deleteLineCount;

    @SerializedName("insert_line_count")
    private final Integer insertLineCount;

    public MergeTotalDiffInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ MergeTotalDiffInfo copy$default(MergeTotalDiffInfo mergeTotalDiffInfo, Integer num, Integer num2, Integer num3, Integer num4, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mergeTotalDiffInfo.insertLineCount;
        }
        if ((i & 2) != 0) {
            num2 = mergeTotalDiffInfo.deleteLineCount;
        }
        if ((i & 4) != 0) {
            num3 = mergeTotalDiffInfo.conflictCount;
        }
        if ((i & 8) != 0) {
            num4 = mergeTotalDiffInfo.changedFilesCount;
        }
        return mergeTotalDiffInfo.copy(num, num2, num3, num4);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getInsertLineCount() {
        return this.insertLineCount;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getDeleteLineCount() {
        return this.deleteLineCount;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getConflictCount() {
        return this.conflictCount;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getChangedFilesCount() {
        return this.changedFilesCount;
    }

    public final MergeTotalDiffInfo copy(Integer insertLineCount, Integer deleteLineCount, Integer conflictCount, Integer changedFilesCount) {
        return new MergeTotalDiffInfo(insertLineCount, deleteLineCount, conflictCount, changedFilesCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MergeTotalDiffInfo)) {
            return false;
        }
        MergeTotalDiffInfo mergeTotalDiffInfo = (MergeTotalDiffInfo) other;
        return Intrinsics.areEqual(this.insertLineCount, mergeTotalDiffInfo.insertLineCount) && Intrinsics.areEqual(this.deleteLineCount, mergeTotalDiffInfo.deleteLineCount) && Intrinsics.areEqual(this.conflictCount, mergeTotalDiffInfo.conflictCount) && Intrinsics.areEqual(this.changedFilesCount, mergeTotalDiffInfo.changedFilesCount);
    }

    public int hashCode() {
        Integer num = this.insertLineCount;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.deleteLineCount;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.conflictCount;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.changedFilesCount;
        return hashCode3 + (num4 != null ? num4.hashCode() : 0);
    }

    public String toString() {
        return "MergeTotalDiffInfo(insertLineCount=" + this.insertLineCount + ", deleteLineCount=" + this.deleteLineCount + ", conflictCount=" + this.conflictCount + ", changedFilesCount=" + this.changedFilesCount + ')';
    }

    public MergeTotalDiffInfo(Integer num, Integer num2, Integer num3, Integer num4) {
        this.insertLineCount = num;
        this.deleteLineCount = num2;
        this.conflictCount = num3;
        this.changedFilesCount = num4;
    }

    public /* synthetic */ MergeTotalDiffInfo(Integer num, Integer num2, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4);
    }

    public final Integer getInsertLineCount() {
        return this.insertLineCount;
    }

    public final Integer getDeleteLineCount() {
        return this.deleteLineCount;
    }

    public final Integer getConflictCount() {
        return this.conflictCount;
    }

    public final Integer getChangedFilesCount() {
        return this.changedFilesCount;
    }
}
