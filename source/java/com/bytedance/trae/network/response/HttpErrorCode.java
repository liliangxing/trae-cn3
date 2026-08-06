package com.bytedance.trae.network.response;

import kotlin.Metadata;

/* compiled from: HttpErrorCode.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/network/response/HttpErrorCode;", "", "<init>", "()V", "UNKNOWN", "", "CANCELLED", "UNKNOWN_HOST", "EOF_ERROR", "INVALID_FORMAT", "NULL_POINTER", "CONNECT_FAIL", "SOCKET_TIME_OUT", "ILLEGAL_ARGUMENT", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpErrorCode {
    public static final int CANCELLED = -1001;
    public static final int CONNECT_FAIL = -1006;
    public static final int EOF_ERROR = -1003;
    public static final int ILLEGAL_ARGUMENT = -1008;
    public static final HttpErrorCode INSTANCE = new HttpErrorCode();
    public static final int INVALID_FORMAT = -1004;
    public static final int NULL_POINTER = -1005;
    public static final int SOCKET_TIME_OUT = -1007;
    public static final int UNKNOWN = -1000;
    public static final int UNKNOWN_HOST = -1002;

    private HttpErrorCode() {
    }
}
