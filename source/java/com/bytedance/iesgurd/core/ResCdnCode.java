package com.bytedance.iesgurd.core;

import kotlin.Metadata;

/* compiled from: Enum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/iesgurd/core/ResCdnCode;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "ONLY_OFFLINE", "NO_PREPARE_META", "ULTRA_RESOURCE_IS_NULL", "ULTRA_RESOURCE_ERROR", "CDN_UNKNOWN_ERROR", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public enum ResCdnCode {
    ONLY_OFFLINE(1),
    NO_PREPARE_META(2),
    ULTRA_RESOURCE_IS_NULL(3),
    ULTRA_RESOURCE_ERROR(4),
    CDN_UNKNOWN_ERROR(99);

    private final int type;

    ResCdnCode(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }
}
