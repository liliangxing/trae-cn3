package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IDiffViewApi.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J/\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/im/service/GitBatchDiffRequest;", "", "baseRef", "", "headRef", "paths", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getBaseRef", "()Ljava/lang/String;", "getHeadRef", "getPaths", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GitBatchDiffRequest {

    @SerializedName("base_ref")
    private final String baseRef;

    @SerializedName("head_ref")
    private final String headRef;

    @SerializedName("paths")
    private final List<String> paths;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GitBatchDiffRequest copy$default(GitBatchDiffRequest gitBatchDiffRequest, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gitBatchDiffRequest.baseRef;
        }
        if ((i & 2) != 0) {
            str2 = gitBatchDiffRequest.headRef;
        }
        if ((i & 4) != 0) {
            list = gitBatchDiffRequest.paths;
        }
        return gitBatchDiffRequest.copy(str, str2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getBaseRef() {
        return this.baseRef;
    }

    /* renamed from: component2, reason: from getter */
    public final String getHeadRef() {
        return this.headRef;
    }

    public final List<String> component3() {
        return this.paths;
    }

    public final GitBatchDiffRequest copy(String baseRef, String headRef, List<String> paths) {
        Intrinsics.checkNotNullParameter(baseRef, "baseRef");
        Intrinsics.checkNotNullParameter(headRef, "headRef");
        return new GitBatchDiffRequest(baseRef, headRef, paths);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GitBatchDiffRequest)) {
            return false;
        }
        GitBatchDiffRequest gitBatchDiffRequest = (GitBatchDiffRequest) other;
        return Intrinsics.areEqual(this.baseRef, gitBatchDiffRequest.baseRef) && Intrinsics.areEqual(this.headRef, gitBatchDiffRequest.headRef) && Intrinsics.areEqual(this.paths, gitBatchDiffRequest.paths);
    }

    public int hashCode() {
        int hashCode = ((this.baseRef.hashCode() * 31) + this.headRef.hashCode()) * 31;
        List<String> list = this.paths;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "GitBatchDiffRequest(baseRef=" + this.baseRef + ", headRef=" + this.headRef + ", paths=" + this.paths + ')';
    }

    public GitBatchDiffRequest(String baseRef, String headRef, List<String> list) {
        Intrinsics.checkNotNullParameter(baseRef, "baseRef");
        Intrinsics.checkNotNullParameter(headRef, "headRef");
        this.baseRef = baseRef;
        this.headRef = headRef;
        this.paths = list;
    }

    public /* synthetic */ GitBatchDiffRequest(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : list);
    }

    public final String getBaseRef() {
        return this.baseRef;
    }

    public final String getHeadRef() {
        return this.headRef;
    }

    public final List<String> getPaths() {
        return this.paths;
    }
}
