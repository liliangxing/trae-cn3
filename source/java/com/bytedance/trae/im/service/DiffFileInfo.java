package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IRevertCheckTaskApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/im/service/DiffFileInfo;", "", "filePath", "", "targetNewContent", "fileAction", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFilePath", "()Ljava/lang/String;", "getTargetNewContent", "getFileAction", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DiffFileInfo {

    @SerializedName("file_action")
    private final String fileAction;

    @SerializedName("file_path")
    private final String filePath;

    @SerializedName("target_new_content")
    private final String targetNewContent;

    public DiffFileInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ DiffFileInfo copy$default(DiffFileInfo diffFileInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = diffFileInfo.filePath;
        }
        if ((i & 2) != 0) {
            str2 = diffFileInfo.targetNewContent;
        }
        if ((i & 4) != 0) {
            str3 = diffFileInfo.fileAction;
        }
        return diffFileInfo.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTargetNewContent() {
        return this.targetNewContent;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFileAction() {
        return this.fileAction;
    }

    public final DiffFileInfo copy(String filePath, String targetNewContent, String fileAction) {
        return new DiffFileInfo(filePath, targetNewContent, fileAction);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiffFileInfo)) {
            return false;
        }
        DiffFileInfo diffFileInfo = (DiffFileInfo) other;
        return Intrinsics.areEqual(this.filePath, diffFileInfo.filePath) && Intrinsics.areEqual(this.targetNewContent, diffFileInfo.targetNewContent) && Intrinsics.areEqual(this.fileAction, diffFileInfo.fileAction);
    }

    public int hashCode() {
        String str = this.filePath;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.targetNewContent;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.fileAction;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "DiffFileInfo(filePath=" + this.filePath + ", targetNewContent=" + this.targetNewContent + ", fileAction=" + this.fileAction + ')';
    }

    public DiffFileInfo(String str, String str2, String str3) {
        this.filePath = str;
        this.targetNewContent = str2;
        this.fileAction = str3;
    }

    public /* synthetic */ DiffFileInfo(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final String getTargetNewContent() {
        return this.targetNewContent;
    }

    public final String getFileAction() {
        return this.fileAction;
    }
}
