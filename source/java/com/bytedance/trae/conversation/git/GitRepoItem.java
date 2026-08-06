package com.bytedance.trae.conversation.git;

import com.bytedance.forest.model.PreloadConfig;
import com.ss.ttm.player.MediaFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GitRepoItem.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitRepoItem;", "", "id", "", "title", MediaFormat.KEY_SUBTITLE, "repoUrl", "isSelected", "", "isEnabled", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getId", "()Ljava/lang/String;", "getTitle", "getSubtitle", "getRepoUrl", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GitRepoItem {
    private final String id;
    private final boolean isEnabled;
    private final boolean isSelected;
    private final String repoUrl;
    private final String subtitle;
    private final String title;

    public static /* synthetic */ GitRepoItem copy$default(GitRepoItem gitRepoItem, String str, String str2, String str3, String str4, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gitRepoItem.id;
        }
        if ((i & 2) != 0) {
            str2 = gitRepoItem.title;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = gitRepoItem.subtitle;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = gitRepoItem.repoUrl;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            z = gitRepoItem.isSelected;
        }
        boolean z3 = z;
        if ((i & 32) != 0) {
            z2 = gitRepoItem.isEnabled;
        }
        return gitRepoItem.copy(str, str5, str6, str7, z3, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRepoUrl() {
        return this.repoUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    public final GitRepoItem copy(String id, String title, String subtitle, String repoUrl, boolean isSelected, boolean isEnabled) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(repoUrl, "repoUrl");
        return new GitRepoItem(id, title, subtitle, repoUrl, isSelected, isEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GitRepoItem)) {
            return false;
        }
        GitRepoItem gitRepoItem = (GitRepoItem) other;
        return Intrinsics.areEqual(this.id, gitRepoItem.id) && Intrinsics.areEqual(this.title, gitRepoItem.title) && Intrinsics.areEqual(this.subtitle, gitRepoItem.subtitle) && Intrinsics.areEqual(this.repoUrl, gitRepoItem.repoUrl) && this.isSelected == gitRepoItem.isSelected && this.isEnabled == gitRepoItem.isEnabled;
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + this.repoUrl.hashCode()) * 31) + Boolean.hashCode(this.isSelected)) * 31) + Boolean.hashCode(this.isEnabled);
    }

    public String toString() {
        return "GitRepoItem(id=" + this.id + ", title=" + this.title + ", subtitle=" + this.subtitle + ", repoUrl=" + this.repoUrl + ", isSelected=" + this.isSelected + ", isEnabled=" + this.isEnabled + ')';
    }

    public GitRepoItem(String id, String title, String subtitle, String repoUrl, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(repoUrl, "repoUrl");
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.repoUrl = repoUrl;
        this.isSelected = z;
        this.isEnabled = z2;
    }

    public /* synthetic */ GitRepoItem(String str, String str2, String str3, String str4, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? false : z, (i & 32) != 0 ? true : z2);
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getRepoUrl() {
        return this.repoUrl;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }
}
