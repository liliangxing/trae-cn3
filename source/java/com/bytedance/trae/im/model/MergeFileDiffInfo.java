package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FinishCardResult.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\b\u0010\u0013¨\u0006 "}, d2 = {"Lcom/bytedance/trae/im/model/MergeFileDiffInfo;", "", "filePath", "", "fileAction", "insertLineCount", "", "deleteLineCount", "isConflict", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getFilePath", "()Ljava/lang/String;", "getFileAction", "getInsertLineCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDeleteLineCount", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/bytedance/trae/im/model/MergeFileDiffInfo;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MergeFileDiffInfo {

    @SerializedName("delete_line_count")
    private final Integer deleteLineCount;

    @SerializedName("file_action")
    private final String fileAction;

    @SerializedName("file_path")
    private final String filePath;

    @SerializedName("insert_line_count")
    private final Integer insertLineCount;

    @SerializedName("is_conflict")
    private final Boolean isConflict;

    public MergeFileDiffInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ MergeFileDiffInfo copy$default(MergeFileDiffInfo mergeFileDiffInfo, String str, String str2, Integer num, Integer num2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mergeFileDiffInfo.filePath;
        }
        if ((i & 2) != 0) {
            str2 = mergeFileDiffInfo.fileAction;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            num = mergeFileDiffInfo.insertLineCount;
        }
        Integer num3 = num;
        if ((i & 8) != 0) {
            num2 = mergeFileDiffInfo.deleteLineCount;
        }
        Integer num4 = num2;
        if ((i & 16) != 0) {
            bool = mergeFileDiffInfo.isConflict;
        }
        return mergeFileDiffInfo.copy(str, str3, num3, num4, bool);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFileAction() {
        return this.fileAction;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getInsertLineCount() {
        return this.insertLineCount;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getDeleteLineCount() {
        return this.deleteLineCount;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getIsConflict() {
        return this.isConflict;
    }

    public final MergeFileDiffInfo copy(String filePath, String fileAction, Integer insertLineCount, Integer deleteLineCount, Boolean isConflict) {
        return new MergeFileDiffInfo(filePath, fileAction, insertLineCount, deleteLineCount, isConflict);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MergeFileDiffInfo)) {
            return false;
        }
        MergeFileDiffInfo mergeFileDiffInfo = (MergeFileDiffInfo) other;
        return Intrinsics.areEqual(this.filePath, mergeFileDiffInfo.filePath) && Intrinsics.areEqual(this.fileAction, mergeFileDiffInfo.fileAction) && Intrinsics.areEqual(this.insertLineCount, mergeFileDiffInfo.insertLineCount) && Intrinsics.areEqual(this.deleteLineCount, mergeFileDiffInfo.deleteLineCount) && Intrinsics.areEqual(this.isConflict, mergeFileDiffInfo.isConflict);
    }

    public int hashCode() {
        String str = this.filePath;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.fileAction;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.insertLineCount;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.deleteLineCount;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.isConflict;
        return hashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "MergeFileDiffInfo(filePath=" + this.filePath + ", fileAction=" + this.fileAction + ", insertLineCount=" + this.insertLineCount + ", deleteLineCount=" + this.deleteLineCount + ", isConflict=" + this.isConflict + ')';
    }

    public MergeFileDiffInfo(String str, String str2, Integer num, Integer num2, Boolean bool) {
        this.filePath = str;
        this.fileAction = str2;
        this.insertLineCount = num;
        this.deleteLineCount = num2;
        this.isConflict = bool;
    }

    public /* synthetic */ MergeFileDiffInfo(String str, String str2, Integer num, Integer num2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : bool);
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final String getFileAction() {
        return this.fileAction;
    }

    public final Integer getInsertLineCount() {
        return this.insertLineCount;
    }

    public final Integer getDeleteLineCount() {
        return this.deleteLineCount;
    }

    public final Boolean isConflict() {
        return this.isConflict;
    }
}
