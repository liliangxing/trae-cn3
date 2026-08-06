package com.bytedance.iesgurd.core;

import kotlin.Metadata;

/* compiled from: Enum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/iesgurd/core/ResOfflineCode;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "INVALID_PARAMS", "BLOCK_BY_ON_DEMAND", "BLOCK_BY_CLEAN_BLOCK_LIST", "BLOCK_BY_LOW_STORAGE", "BLOCK_BY_OCCASION_UPDATE", "NO_PREPARE_META", "WAIT_UPDATE", "UPDATING", "VERSION_IS_FORBIDDEN", "NO_VERSION_FILE", "NO_BUNDLE_FILE", "CHECK_FILE_BROKEN", "ACCESS_KEY_DIR_NOT_REGISTER", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public enum ResOfflineCode {
    INVALID_PARAMS(-1),
    BLOCK_BY_ON_DEMAND(1),
    BLOCK_BY_CLEAN_BLOCK_LIST(2),
    BLOCK_BY_LOW_STORAGE(3),
    BLOCK_BY_OCCASION_UPDATE(4),
    NO_PREPARE_META(10),
    WAIT_UPDATE(11),
    UPDATING(12),
    VERSION_IS_FORBIDDEN(13),
    NO_VERSION_FILE(14),
    NO_BUNDLE_FILE(15),
    CHECK_FILE_BROKEN(16),
    ACCESS_KEY_DIR_NOT_REGISTER(99);

    private final int type;

    ResOfflineCode(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }
}
