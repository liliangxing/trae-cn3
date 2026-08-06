package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IDiffViewApi.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0012JJ\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\b\u0010\u0012¨\u0006 "}, d2 = {"Lcom/bytedance/trae/im/service/GitFileDiff;", "", "path", "", "status", "baseContent", "Lcom/bytedance/trae/im/service/GitFileContent;", "headContent", "isConflict", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/GitFileContent;Lcom/bytedance/trae/im/service/GitFileContent;Ljava/lang/Boolean;)V", "getPath", "()Ljava/lang/String;", "getStatus", "getBaseContent", "()Lcom/bytedance/trae/im/service/GitFileContent;", "getHeadContent", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/GitFileContent;Lcom/bytedance/trae/im/service/GitFileContent;Ljava/lang/Boolean;)Lcom/bytedance/trae/im/service/GitFileDiff;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GitFileDiff {

    @SerializedName("base_content")
    private final GitFileContent baseContent;

    @SerializedName("head_content")
    private final GitFileContent headContent;

    @SerializedName("is_conflict")
    private final Boolean isConflict;

    @SerializedName("path")
    private final String path;

    @SerializedName("status")
    private final String status;

    public GitFileDiff() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ GitFileDiff copy$default(GitFileDiff gitFileDiff, String str, String str2, GitFileContent gitFileContent, GitFileContent gitFileContent2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gitFileDiff.path;
        }
        if ((i & 2) != 0) {
            str2 = gitFileDiff.status;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            gitFileContent = gitFileDiff.baseContent;
        }
        GitFileContent gitFileContent3 = gitFileContent;
        if ((i & 8) != 0) {
            gitFileContent2 = gitFileDiff.headContent;
        }
        GitFileContent gitFileContent4 = gitFileContent2;
        if ((i & 16) != 0) {
            bool = gitFileDiff.isConflict;
        }
        return gitFileDiff.copy(str, str3, gitFileContent3, gitFileContent4, bool);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: component2, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component3, reason: from getter */
    public final GitFileContent getBaseContent() {
        return this.baseContent;
    }

    /* renamed from: component4, reason: from getter */
    public final GitFileContent getHeadContent() {
        return this.headContent;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getIsConflict() {
        return this.isConflict;
    }

    public final GitFileDiff copy(String path, String status, GitFileContent baseContent, GitFileContent headContent, Boolean isConflict) {
        return new GitFileDiff(path, status, baseContent, headContent, isConflict);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GitFileDiff)) {
            return false;
        }
        GitFileDiff gitFileDiff = (GitFileDiff) other;
        return Intrinsics.areEqual(this.path, gitFileDiff.path) && Intrinsics.areEqual(this.status, gitFileDiff.status) && Intrinsics.areEqual(this.baseContent, gitFileDiff.baseContent) && Intrinsics.areEqual(this.headContent, gitFileDiff.headContent) && Intrinsics.areEqual(this.isConflict, gitFileDiff.isConflict);
    }

    public int hashCode() {
        String str = this.path;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.status;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        GitFileContent gitFileContent = this.baseContent;
        int hashCode3 = (hashCode2 + (gitFileContent == null ? 0 : gitFileContent.hashCode())) * 31;
        GitFileContent gitFileContent2 = this.headContent;
        int hashCode4 = (hashCode3 + (gitFileContent2 == null ? 0 : gitFileContent2.hashCode())) * 31;
        Boolean bool = this.isConflict;
        return hashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "GitFileDiff(path=" + this.path + ", status=" + this.status + ", baseContent=" + this.baseContent + ", headContent=" + this.headContent + ", isConflict=" + this.isConflict + ')';
    }

    public GitFileDiff(String str, String str2, GitFileContent gitFileContent, GitFileContent gitFileContent2, Boolean bool) {
        this.path = str;
        this.status = str2;
        this.baseContent = gitFileContent;
        this.headContent = gitFileContent2;
        this.isConflict = bool;
    }

    public /* synthetic */ GitFileDiff(String str, String str2, GitFileContent gitFileContent, GitFileContent gitFileContent2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : gitFileContent, (i & 8) != 0 ? null : gitFileContent2, (i & 16) != 0 ? null : bool);
    }

    public final String getPath() {
        return this.path;
    }

    public final String getStatus() {
        return this.status;
    }

    public final GitFileContent getBaseContent() {
        return this.baseContent;
    }

    public final GitFileContent getHeadContent() {
        return this.headContent;
    }

    public final Boolean isConflict() {
        return this.isConflict;
    }
}
