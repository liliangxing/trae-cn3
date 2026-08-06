package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ICreateAgentTask.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;", "", "blockReason", "", "limit", "running", "<init>", "(III)V", "getBlockReason", "()I", "getLimit", "getRunning", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CreateTaskErrorDetail {
    private final int blockReason;
    private final int limit;
    private final int running;

    public CreateTaskErrorDetail() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ CreateTaskErrorDetail copy$default(CreateTaskErrorDetail createTaskErrorDetail, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = createTaskErrorDetail.blockReason;
        }
        if ((i4 & 2) != 0) {
            i2 = createTaskErrorDetail.limit;
        }
        if ((i4 & 4) != 0) {
            i3 = createTaskErrorDetail.running;
        }
        return createTaskErrorDetail.copy(i, i2, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getBlockReason() {
        return this.blockReason;
    }

    /* renamed from: component2, reason: from getter */
    public final int getLimit() {
        return this.limit;
    }

    /* renamed from: component3, reason: from getter */
    public final int getRunning() {
        return this.running;
    }

    public final CreateTaskErrorDetail copy(int blockReason, int limit, int running) {
        return new CreateTaskErrorDetail(blockReason, limit, running);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateTaskErrorDetail)) {
            return false;
        }
        CreateTaskErrorDetail createTaskErrorDetail = (CreateTaskErrorDetail) other;
        return this.blockReason == createTaskErrorDetail.blockReason && this.limit == createTaskErrorDetail.limit && this.running == createTaskErrorDetail.running;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.blockReason) * 31) + Integer.hashCode(this.limit)) * 31) + Integer.hashCode(this.running);
    }

    public String toString() {
        return "CreateTaskErrorDetail(blockReason=" + this.blockReason + ", limit=" + this.limit + ", running=" + this.running + ')';
    }

    public CreateTaskErrorDetail(int i, int i2, int i3) {
        this.blockReason = i;
        this.limit = i2;
        this.running = i3;
    }

    public /* synthetic */ CreateTaskErrorDetail(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    public final int getBlockReason() {
        return this.blockReason;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final int getRunning() {
        return this.running;
    }
}
