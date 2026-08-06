package com.bytedance.iesgurd.core;

import kotlin.Metadata;

/* compiled from: Enum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/iesgurd/core/BlockType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "LAZY_UPDATE", "CLEAN_BLOCKLIST", "LOW_STORAGE", "OCCASION_UPDATE", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public enum BlockType {
    LAZY_UPDATE(1),
    CLEAN_BLOCKLIST(2),
    LOW_STORAGE(3),
    OCCASION_UPDATE(4);

    private final int type;

    BlockType(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }
}
