package com.bytedance.iesgurd.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BytePatchException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\nB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/iesgurd/exception/BytePatchException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "code", "", "message", "", "(ILjava/lang/String;)V", "getCode", "()I", "ErrorCode", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final class BytePatchException extends RuntimeException {
    private final int code;

    /* compiled from: BytePatchException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/iesgurd/exception/BytePatchException$ErrorCode;", "", "()V", "bspatchError", "", "checkMd5Error", "copyError", "dataError", "fileSystemError", "formatError", "modifySameFile", "paramsError", "unknown", "writeContentToFileError", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes4.dex */
    public static final class ErrorCode {
        public static final ErrorCode INSTANCE = new ErrorCode();
        public static final int bspatchError = 1010;
        public static final int checkMd5Error = 1011;
        public static final int copyError = 1013;
        public static final int dataError = 1006;
        public static final int fileSystemError = 1012;
        public static final int formatError = 1005;
        public static final int modifySameFile = 1024;
        public static final int paramsError = 1000;
        public static final int unknown = 1099;
        public static final int writeContentToFileError = 1007;

        private ErrorCode() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BytePatchException(int i, String message) {
        super(message);
        Intrinsics.checkParameterIsNotNull(message, "message");
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }
}
