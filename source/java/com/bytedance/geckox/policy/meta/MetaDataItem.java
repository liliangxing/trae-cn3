package com.bytedance.geckox.policy.meta;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MetaDataItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/geckox/policy/meta/MetaDataItem;", "Ljava/io/Serializable;", "lastReadTimeStamp", "", "allowUpdate", "", "(JZ)V", "getAllowUpdate", "()Z", "setAllowUpdate", "(Z)V", "getLastReadTimeStamp", "()J", "setLastReadTimeStamp", "(J)V", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class MetaDataItem implements Serializable {
    private boolean allowUpdate;
    private long lastReadTimeStamp;

    public MetaDataItem(long j, boolean z) {
        this.lastReadTimeStamp = j;
        this.allowUpdate = z;
    }

    public /* synthetic */ MetaDataItem(long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? true : z);
    }

    public final boolean getAllowUpdate() {
        return this.allowUpdate;
    }

    public final long getLastReadTimeStamp() {
        return this.lastReadTimeStamp;
    }

    public final void setAllowUpdate(boolean z) {
        this.allowUpdate = z;
    }

    public final void setLastReadTimeStamp(long j) {
        this.lastReadTimeStamp = j;
    }
}
