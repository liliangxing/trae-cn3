package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JU\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lcom/bytedance/trae/conversation/network/GitRepository;", "", "repoId", "", "name", "fullName", "url", "description", "defaultBranch", "visibility", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRepoId", "()Ljava/lang/String;", "getName", "getFullName", "getUrl", "getDescription", "getDefaultBranch", "getVisibility", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GitRepository {

    @SerializedName("default_branch")
    private final String defaultBranch;

    @SerializedName("description")
    private final String description;

    @SerializedName("full_name")
    private final String fullName;

    @SerializedName("name")
    private final String name;

    @SerializedName("repo_id")
    private final String repoId;

    @SerializedName("url")
    private final String url;

    @SerializedName("visibility")
    private final String visibility;

    public static /* synthetic */ GitRepository copy$default(GitRepository gitRepository, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gitRepository.repoId;
        }
        if ((i & 2) != 0) {
            str2 = gitRepository.name;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = gitRepository.fullName;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = gitRepository.url;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = gitRepository.description;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = gitRepository.defaultBranch;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = gitRepository.visibility;
        }
        return gitRepository.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRepoId() {
        return this.repoId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFullName() {
        return this.fullName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDefaultBranch() {
        return this.defaultBranch;
    }

    /* renamed from: component7, reason: from getter */
    public final String getVisibility() {
        return this.visibility;
    }

    public final GitRepository copy(String repoId, String name, String fullName, String url, String description, String defaultBranch, String visibility) {
        Intrinsics.checkNotNullParameter(repoId, "repoId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fullName, "fullName");
        Intrinsics.checkNotNullParameter(url, "url");
        return new GitRepository(repoId, name, fullName, url, description, defaultBranch, visibility);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GitRepository)) {
            return false;
        }
        GitRepository gitRepository = (GitRepository) other;
        return Intrinsics.areEqual(this.repoId, gitRepository.repoId) && Intrinsics.areEqual(this.name, gitRepository.name) && Intrinsics.areEqual(this.fullName, gitRepository.fullName) && Intrinsics.areEqual(this.url, gitRepository.url) && Intrinsics.areEqual(this.description, gitRepository.description) && Intrinsics.areEqual(this.defaultBranch, gitRepository.defaultBranch) && Intrinsics.areEqual(this.visibility, gitRepository.visibility);
    }

    public int hashCode() {
        int hashCode = ((((((this.repoId.hashCode() * 31) + this.name.hashCode()) * 31) + this.fullName.hashCode()) * 31) + this.url.hashCode()) * 31;
        String str = this.description;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.defaultBranch;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.visibility;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "GitRepository(repoId=" + this.repoId + ", name=" + this.name + ", fullName=" + this.fullName + ", url=" + this.url + ", description=" + this.description + ", defaultBranch=" + this.defaultBranch + ", visibility=" + this.visibility + ')';
    }

    public GitRepository(String repoId, String name, String fullName, String url, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(repoId, "repoId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fullName, "fullName");
        Intrinsics.checkNotNullParameter(url, "url");
        this.repoId = repoId;
        this.name = name;
        this.fullName = fullName;
        this.url = url;
        this.description = str;
        this.defaultBranch = str2;
        this.visibility = str3;
    }

    public /* synthetic */ GitRepository(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7);
    }

    public final String getRepoId() {
        return this.repoId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDefaultBranch() {
        return this.defaultBranch;
    }

    public final String getVisibility() {
        return this.visibility;
    }
}
