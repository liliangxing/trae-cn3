package com.bytedance.trae.conversation.settings;

import kotlin.Metadata;

/* compiled from: IQuerySettings.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;", "", "totalCount", "", "totalSize", "workSingleImageSize", "workSingleAttachmentSize", "codeSingleImageSize", "codeTotalImageCount", "<init>", "(JJJJJJ)V", "getTotalCount", "()J", "getTotalSize", "setTotalSize", "(J)V", "getWorkSingleImageSize", "setWorkSingleImageSize", "getWorkSingleAttachmentSize", "setWorkSingleAttachmentSize", "getCodeSingleImageSize", "setCodeSingleImageSize", "getCodeTotalImageCount", "setCodeTotalImageCount", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WorkAttachmentSettings {
    private long codeSingleImageSize;
    private long codeTotalImageCount;
    private final long totalCount;
    private long totalSize;
    private long workSingleAttachmentSize;
    private long workSingleImageSize;

    public WorkAttachmentSettings(long j, long j2, long j3, long j4, long j5, long j6) {
        this.totalCount = j;
        this.totalSize = j2;
        this.workSingleImageSize = j3;
        this.workSingleAttachmentSize = j4;
        this.codeSingleImageSize = j5;
        this.codeTotalImageCount = j6;
    }

    public final long getTotalCount() {
        return this.totalCount;
    }

    public final long getTotalSize() {
        return this.totalSize;
    }

    public final void setTotalSize(long j) {
        this.totalSize = j;
    }

    public final long getWorkSingleImageSize() {
        return this.workSingleImageSize;
    }

    public final void setWorkSingleImageSize(long j) {
        this.workSingleImageSize = j;
    }

    public final long getWorkSingleAttachmentSize() {
        return this.workSingleAttachmentSize;
    }

    public final void setWorkSingleAttachmentSize(long j) {
        this.workSingleAttachmentSize = j;
    }

    public final long getCodeSingleImageSize() {
        return this.codeSingleImageSize;
    }

    public final void setCodeSingleImageSize(long j) {
        this.codeSingleImageSize = j;
    }

    public final long getCodeTotalImageCount() {
        return this.codeTotalImageCount;
    }

    public final void setCodeTotalImageCount(long j) {
        this.codeTotalImageCount = j;
    }
}
