package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IDiffViewApi.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/im/service/GitBatchDiffResponse;", "", "diffs", "", "Lcom/bytedance/trae/im/service/GitFileDiff;", "<init>", "(Ljava/util/List;)V", "getDiffs", "()Ljava/util/List;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GitBatchDiffResponse {

    @SerializedName("diffs")
    private final List<GitFileDiff> diffs;

    /* JADX WARN: Multi-variable type inference failed */
    public GitBatchDiffResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GitBatchDiffResponse copy$default(GitBatchDiffResponse gitBatchDiffResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = gitBatchDiffResponse.diffs;
        }
        return gitBatchDiffResponse.copy(list);
    }

    public final List<GitFileDiff> component1() {
        return this.diffs;
    }

    public final GitBatchDiffResponse copy(List<GitFileDiff> diffs) {
        return new GitBatchDiffResponse(diffs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GitBatchDiffResponse) && Intrinsics.areEqual(this.diffs, ((GitBatchDiffResponse) other).diffs);
    }

    public int hashCode() {
        List<GitFileDiff> list = this.diffs;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "GitBatchDiffResponse(diffs=" + this.diffs + ')';
    }

    public GitBatchDiffResponse(List<GitFileDiff> list) {
        this.diffs = list;
    }

    public /* synthetic */ GitBatchDiffResponse(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public final List<GitFileDiff> getDiffs() {
        return this.diffs;
    }
}
