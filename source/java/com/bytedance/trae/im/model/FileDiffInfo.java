package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FinishCardResult.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0018Jn\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\n\u0010\u0018R\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018¨\u0006)"}, d2 = {"Lcom/bytedance/trae/im/model/FileDiffInfo;", "", "insertLineCount", "", "deleteLineCount", "filePath", "", "fileAction", "beforeContent", "afterContent", "isConflict", "", "htmlRender", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getInsertLineCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDeleteLineCount", "getFilePath", "()Ljava/lang/String;", "getFileAction", "getBeforeContent", "getAfterContent", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHtmlRender", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/bytedance/trae/im/model/FileDiffInfo;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FileDiffInfo {

    @SerializedName("after_content")
    private final String afterContent;

    @SerializedName("before_content")
    private final String beforeContent;

    @SerializedName("delete_line_count")
    private final Integer deleteLineCount;

    @SerializedName("file_action")
    private final String fileAction;

    @SerializedName("file_path")
    private final String filePath;

    @SerializedName("html_render")
    private final Boolean htmlRender;

    @SerializedName("insert_line_count")
    private final Integer insertLineCount;

    @SerializedName("is_conflict")
    private final Boolean isConflict;

    public FileDiffInfo() {
        this(null, null, null, null, null, null, null, null, 255, null);
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
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFileAction() {
        return this.fileAction;
    }

    /* renamed from: component5, reason: from getter */
    public final String getBeforeContent() {
        return this.beforeContent;
    }

    /* renamed from: component6, reason: from getter */
    public final String getAfterContent() {
        return this.afterContent;
    }

    /* renamed from: component7, reason: from getter */
    public final Boolean getIsConflict() {
        return this.isConflict;
    }

    /* renamed from: component8, reason: from getter */
    public final Boolean getHtmlRender() {
        return this.htmlRender;
    }

    public final FileDiffInfo copy(Integer insertLineCount, Integer deleteLineCount, String filePath, String fileAction, String beforeContent, String afterContent, Boolean isConflict, Boolean htmlRender) {
        return new FileDiffInfo(insertLineCount, deleteLineCount, filePath, fileAction, beforeContent, afterContent, isConflict, htmlRender);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileDiffInfo)) {
            return false;
        }
        FileDiffInfo fileDiffInfo = (FileDiffInfo) other;
        return Intrinsics.areEqual(this.insertLineCount, fileDiffInfo.insertLineCount) && Intrinsics.areEqual(this.deleteLineCount, fileDiffInfo.deleteLineCount) && Intrinsics.areEqual(this.filePath, fileDiffInfo.filePath) && Intrinsics.areEqual(this.fileAction, fileDiffInfo.fileAction) && Intrinsics.areEqual(this.beforeContent, fileDiffInfo.beforeContent) && Intrinsics.areEqual(this.afterContent, fileDiffInfo.afterContent) && Intrinsics.areEqual(this.isConflict, fileDiffInfo.isConflict) && Intrinsics.areEqual(this.htmlRender, fileDiffInfo.htmlRender);
    }

    public int hashCode() {
        Integer num = this.insertLineCount;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.deleteLineCount;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.filePath;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.fileAction;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.beforeContent;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.afterContent;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.isConflict;
        int hashCode7 = (hashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.htmlRender;
        return hashCode7 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        return "FileDiffInfo(insertLineCount=" + this.insertLineCount + ", deleteLineCount=" + this.deleteLineCount + ", filePath=" + this.filePath + ", fileAction=" + this.fileAction + ", beforeContent=" + this.beforeContent + ", afterContent=" + this.afterContent + ", isConflict=" + this.isConflict + ", htmlRender=" + this.htmlRender + ')';
    }

    public FileDiffInfo(Integer num, Integer num2, String str, String str2, String str3, String str4, Boolean bool, Boolean bool2) {
        this.insertLineCount = num;
        this.deleteLineCount = num2;
        this.filePath = str;
        this.fileAction = str2;
        this.beforeContent = str3;
        this.afterContent = str4;
        this.isConflict = bool;
        this.htmlRender = bool2;
    }

    public /* synthetic */ FileDiffInfo(Integer num, Integer num2, String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : bool, (i & 128) == 0 ? bool2 : null);
    }

    public final Integer getInsertLineCount() {
        return this.insertLineCount;
    }

    public final Integer getDeleteLineCount() {
        return this.deleteLineCount;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final String getFileAction() {
        return this.fileAction;
    }

    public final String getBeforeContent() {
        return this.beforeContent;
    }

    public final String getAfterContent() {
        return this.afterContent;
    }

    public final Boolean isConflict() {
        return this.isConflict;
    }

    public final Boolean getHtmlRender() {
        return this.htmlRender;
    }
}
