package com.bytedance.ies.argus.aspect.eventCenter;

import kotlin.Metadata;

/* compiled from: BaseViewContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/argus/aspect/eventCenter/FeAuthConfigSource;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "CONTENT_V2_FROM_LYNX_UN_FOUND", "LOGIC_ERROR", "NOT_FOUND", "UN_KNOWN", "CONTENT_V2_FROM_CACHE", "CONTENT_V2_FROM_CALL", "CONTENT_V2_FROM_AUTO_MATCH", "CONTENT_V1_FROM_MATCH", "PRIVATE_DOMAINS", "CONTENT_V1_FROM_CACHE", "CONTENT_V2_FROM_LYNX", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public enum FeAuthConfigSource {
    CONTENT_V2_FROM_LYNX_UN_FOUND(-3),
    LOGIC_ERROR(-2),
    NOT_FOUND(-1),
    UN_KNOWN(0),
    CONTENT_V2_FROM_CACHE(1),
    CONTENT_V2_FROM_CALL(2),
    CONTENT_V2_FROM_AUTO_MATCH(3),
    CONTENT_V1_FROM_MATCH(4),
    PRIVATE_DOMAINS(5),
    CONTENT_V1_FROM_CACHE(6),
    CONTENT_V2_FROM_LYNX(7);

    private final int code;

    FeAuthConfigSource(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }
}
