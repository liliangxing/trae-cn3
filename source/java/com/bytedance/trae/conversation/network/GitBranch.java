package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ<\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0005\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0007\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/network/GitBranch;", "", "name", "", "commitSha", "isDefault", "", "isProtected", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getName", "()Ljava/lang/String;", "getCommitSha", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/bytedance/trae/conversation/network/GitBranch;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GitBranch {

    @SerializedName("commit_sha")
    private final String commitSha;

    @SerializedName("is_default")
    private final Boolean isDefault;

    @SerializedName("is_protected")
    private final Boolean isProtected;

    @SerializedName("name")
    private final String name;

    public static /* synthetic */ GitBranch copy$default(GitBranch gitBranch, String str, String str2, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gitBranch.name;
        }
        if ((i & 2) != 0) {
            str2 = gitBranch.commitSha;
        }
        if ((i & 4) != 0) {
            bool = gitBranch.isDefault;
        }
        if ((i & 8) != 0) {
            bool2 = gitBranch.isProtected;
        }
        return gitBranch.copy(str, str2, bool, bool2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCommitSha() {
        return this.commitSha;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getIsDefault() {
        return this.isDefault;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getIsProtected() {
        return this.isProtected;
    }

    public final GitBranch copy(String name, String commitSha, Boolean isDefault, Boolean isProtected) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new GitBranch(name, commitSha, isDefault, isProtected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GitBranch)) {
            return false;
        }
        GitBranch gitBranch = (GitBranch) other;
        return Intrinsics.areEqual(this.name, gitBranch.name) && Intrinsics.areEqual(this.commitSha, gitBranch.commitSha) && Intrinsics.areEqual(this.isDefault, gitBranch.isDefault) && Intrinsics.areEqual(this.isProtected, gitBranch.isProtected);
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        String str = this.commitSha;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.isDefault;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isProtected;
        return hashCode3 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        return "GitBranch(name=" + this.name + ", commitSha=" + this.commitSha + ", isDefault=" + this.isDefault + ", isProtected=" + this.isProtected + ')';
    }

    public GitBranch(String name, String str, Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.commitSha = str;
        this.isDefault = bool;
        this.isProtected = bool2;
    }

    public /* synthetic */ GitBranch(String str, String str2, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : bool2);
    }

    public final String getName() {
        return this.name;
    }

    public final String getCommitSha() {
        return this.commitSha;
    }

    public final Boolean isDefault() {
        return this.isDefault;
    }

    public final Boolean isProtected() {
        return this.isProtected;
    }
}
