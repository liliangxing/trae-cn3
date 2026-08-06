package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* compiled from: ArgusConstants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0017\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusUploadFileVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/IArgusVerifyReason;", "code", "", "strValue", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getStrValue", "()Ljava/lang/String;", "SESSION_ID_FOUND_MODE_BLOCK", "SESSION_ID_FOUND_MODE_REPORT", "REGEX_HIT_MODE_BLOCK", "REGEX_HIT_MODE_REPORT", "FILE_PATH_IN_SKIP_LIST", "APPLICATION_IS_NULL", "FILE_CAN_NOT_READ", "FILE_SIZE_EXCEED_LIMIT", "CAN_NOT_GET_FILE_SIZE", "CAN_NOT_GET_SESSION_ID", "FILE_MATCH_NOTHING", "FILE_DETECT_TIMEOUT", "UNEXPECTED_DETECT_RESULT", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public enum ArgusUploadFileVerifyReason implements IArgusVerifyReason {
    SESSION_ID_FOUND_MODE_BLOCK(-1, "session id found, mode block"),
    SESSION_ID_FOUND_MODE_REPORT(-2, "session id found, mode report"),
    REGEX_HIT_MODE_BLOCK(-3, "regex hit, mode block"),
    REGEX_HIT_MODE_REPORT(-4, "regex hit, mode report"),
    FILE_PATH_IN_SKIP_LIST(2, "file path in skip list"),
    APPLICATION_IS_NULL(3, "application is null"),
    FILE_CAN_NOT_READ(4, "file can not read"),
    FILE_SIZE_EXCEED_LIMIT(5, "file size exceed limit"),
    CAN_NOT_GET_FILE_SIZE(6, "can not get file size"),
    CAN_NOT_GET_SESSION_ID(7, "can not get session id"),
    FILE_MATCH_NOTHING(8, "file match nothing"),
    FILE_DETECT_TIMEOUT(9, "file detect timeout"),
    UNEXPECTED_DETECT_RESULT(1000, "unexpected detect result");

    private final int code;
    private final String strValue;

    ArgusUploadFileVerifyReason(int i, String str) {
        this.code = i;
        this.strValue = str;
    }

    @Override // com.bytedance.ies.argus.bean.IArgusVerifyReason
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.IArgusVerifyReason
    public String getStrValue() {
        return this.strValue;
    }
}
