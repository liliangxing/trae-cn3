package com.bytedance.geckox.policy.meta;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MetaDataItemNew.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/geckox/policy/meta/MetaDataItemNew;", "Ljava/io/Serializable;", "lastReadTimeStamp", "", "allowUpdate", "", "lastCleanTimeStamp", "(JZJ)V", "getAllowUpdate", "()Z", "setAllowUpdate", "(Z)V", "getLastCleanTimeStamp", "()J", "setLastCleanTimeStamp", "(J)V", "getLastReadTimeStamp", "setLastReadTimeStamp", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class MetaDataItemNew implements Serializable {
    private static final long serialVersionUID = 2;
    private boolean allowUpdate;
    private long lastCleanTimeStamp;
    private long lastReadTimeStamp;

    public MetaDataItemNew(long j, boolean z, long j2) {
        this.lastReadTimeStamp = j;
        this.allowUpdate = z;
        this.lastCleanTimeStamp = j2;
    }

    public final long getLastReadTimeStamp() {
        return this.lastReadTimeStamp;
    }

    public final void setLastReadTimeStamp(long j) {
        this.lastReadTimeStamp = j;
    }

    public final boolean getAllowUpdate() {
        return this.allowUpdate;
    }

    public final void setAllowUpdate(boolean z) {
        this.allowUpdate = z;
    }

    public /* synthetic */ MetaDataItemNew(long j, boolean z, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? true : z, (i & 4) != 0 ? 0L : j2);
    }

    public final long getLastCleanTimeStamp() {
        return this.lastCleanTimeStamp;
    }

    public final void setLastCleanTimeStamp(long j) {
        this.lastCleanTimeStamp = j;
    }
}
