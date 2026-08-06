package com.bytedance.iesgurd.core;

import kotlin.Metadata;

/* compiled from: Enum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0081\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/iesgurd/core/ReqType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "NONE", "REGISTER_LATE", "NORMAL", "POLLING", "BYTESYNC", "LAZY", "QUEUE", "CUSTOM_REQUEST", "UPDATE_BY_ACCESS", "UPDATE_BY_PRE_ACCESS", "PROBE", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public enum ReqType {
    NONE(-1),
    REGISTER_LATE(0),
    NORMAL(1),
    POLLING(3),
    BYTESYNC(4),
    LAZY(5),
    QUEUE(6),
    CUSTOM_REQUEST(7),
    UPDATE_BY_ACCESS(8),
    UPDATE_BY_PRE_ACCESS(9),
    PROBE(10);

    private final int type;

    ReqType(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }
}
