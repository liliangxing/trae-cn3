package com.bytedance.trae.conversation.fileupload;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;

/* compiled from: ResourceUploadModels.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/fileupload/UploadTimings;", "", "prepareMs", "", "uploadMs", "commitMs", "totalMs", "<init>", "(JJJJ)V", "getPrepareMs", "()J", "getUploadMs", "getCommitMs", "getTotalMs", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UploadTimings {
    private final long commitMs;
    private final long prepareMs;
    private final long totalMs;
    private final long uploadMs;

    /* renamed from: component1, reason: from getter */
    public final long getPrepareMs() {
        return this.prepareMs;
    }

    /* renamed from: component2, reason: from getter */
    public final long getUploadMs() {
        return this.uploadMs;
    }

    /* renamed from: component3, reason: from getter */
    public final long getCommitMs() {
        return this.commitMs;
    }

    /* renamed from: component4, reason: from getter */
    public final long getTotalMs() {
        return this.totalMs;
    }

    public final UploadTimings copy(long prepareMs, long uploadMs, long commitMs, long totalMs) {
        return new UploadTimings(prepareMs, uploadMs, commitMs, totalMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadTimings)) {
            return false;
        }
        UploadTimings uploadTimings = (UploadTimings) other;
        return this.prepareMs == uploadTimings.prepareMs && this.uploadMs == uploadTimings.uploadMs && this.commitMs == uploadTimings.commitMs && this.totalMs == uploadTimings.totalMs;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.prepareMs) * 31) + Long.hashCode(this.uploadMs)) * 31) + Long.hashCode(this.commitMs)) * 31) + Long.hashCode(this.totalMs);
    }

    public String toString() {
        return "UploadTimings(prepareMs=" + this.prepareMs + ", uploadMs=" + this.uploadMs + ", commitMs=" + this.commitMs + ", totalMs=" + this.totalMs + ')';
    }

    public UploadTimings(long j, long j2, long j3, long j4) {
        this.prepareMs = j;
        this.uploadMs = j2;
        this.commitMs = j3;
        this.totalMs = j4;
    }

    public final long getPrepareMs() {
        return this.prepareMs;
    }

    public final long getUploadMs() {
        return this.uploadMs;
    }

    public final long getCommitMs() {
        return this.commitMs;
    }

    public final long getTotalMs() {
        return this.totalMs;
    }
}
