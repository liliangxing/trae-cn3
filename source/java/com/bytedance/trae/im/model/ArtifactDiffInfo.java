package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FinishCardResult.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/im/model/ArtifactDiffInfo;", "", "fileAction", "", "insertLineCount", "", "deleteLineCount", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getFileAction", "()Ljava/lang/String;", "getInsertLineCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDeleteLineCount", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/trae/im/model/ArtifactDiffInfo;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ArtifactDiffInfo {

    @SerializedName("delete_line_count")
    private final Integer deleteLineCount;

    @SerializedName("file_action")
    private final String fileAction;

    @SerializedName("insert_line_count")
    private final Integer insertLineCount;

    public ArtifactDiffInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ArtifactDiffInfo copy$default(ArtifactDiffInfo artifactDiffInfo, String str, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = artifactDiffInfo.fileAction;
        }
        if ((i & 2) != 0) {
            num = artifactDiffInfo.insertLineCount;
        }
        if ((i & 4) != 0) {
            num2 = artifactDiffInfo.deleteLineCount;
        }
        return artifactDiffInfo.copy(str, num, num2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFileAction() {
        return this.fileAction;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getInsertLineCount() {
        return this.insertLineCount;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getDeleteLineCount() {
        return this.deleteLineCount;
    }

    public final ArtifactDiffInfo copy(String fileAction, Integer insertLineCount, Integer deleteLineCount) {
        return new ArtifactDiffInfo(fileAction, insertLineCount, deleteLineCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArtifactDiffInfo)) {
            return false;
        }
        ArtifactDiffInfo artifactDiffInfo = (ArtifactDiffInfo) other;
        return Intrinsics.areEqual(this.fileAction, artifactDiffInfo.fileAction) && Intrinsics.areEqual(this.insertLineCount, artifactDiffInfo.insertLineCount) && Intrinsics.areEqual(this.deleteLineCount, artifactDiffInfo.deleteLineCount);
    }

    public int hashCode() {
        String str = this.fileAction;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.insertLineCount;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.deleteLineCount;
        return hashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "ArtifactDiffInfo(fileAction=" + this.fileAction + ", insertLineCount=" + this.insertLineCount + ", deleteLineCount=" + this.deleteLineCount + ')';
    }

    public ArtifactDiffInfo(String str, Integer num, Integer num2) {
        this.fileAction = str;
        this.insertLineCount = num;
        this.deleteLineCount = num2;
    }

    public /* synthetic */ ArtifactDiffInfo(String str, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2);
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
}
