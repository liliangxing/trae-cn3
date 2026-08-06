package com.bytedance.kmp.network;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetError.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR\u0014\u0010#\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\rR\u001a\u0010%\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR\u001a\u0010(\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\t¨\u0006+"}, d2 = {"Lcom/bytedance/kmp/network/NetError;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "()V", "cronetInternalError", "", "getCronetInternalError", "()I", "setCronetInternalError", "(I)V", "cronetRequestLog", "", "getCronetRequestLog", "()Ljava/lang/String;", "setCronetRequestLog", "(Ljava/lang/String;)V", "errorMessage", "getErrorMessage", "setErrorMessage", "errorRespBody", "", "getErrorRespBody", "()[B", "setErrorRespBody", "([B)V", "errorRespHeader", "", "Lcom/bytedance/kmp/network/Header;", "getErrorRespHeader", "()Ljava/util/List;", "setErrorRespHeader", "(Ljava/util/List;)V", "exceptionStackTrackStr", "getExceptionStackTrackStr", "setExceptionStackTrackStr", "message", "getMessage", "ttnetErrorOriginalCause", "getTtnetErrorOriginalCause", "setTtnetErrorOriginalCause", "ttnetStatusCode", "getTtnetStatusCode", "setTtnetStatusCode", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class NetError extends RuntimeException {
    private int cronetInternalError;
    private byte[] errorRespBody;
    private int ttnetStatusCode;
    private String cronetRequestLog = "";
    private String errorMessage = "";
    private List<Header> errorRespHeader = CollectionsKt.emptyList();
    private String ttnetErrorOriginalCause = "";
    private String exceptionStackTrackStr = "";

    public final int getCronetInternalError() {
        return this.cronetInternalError;
    }

    public final void setCronetInternalError(int i) {
        this.cronetInternalError = i;
    }

    public final int getTtnetStatusCode() {
        return this.ttnetStatusCode;
    }

    public final void setTtnetStatusCode(int i) {
        this.ttnetStatusCode = i;
    }

    public final String getCronetRequestLog() {
        return this.cronetRequestLog;
    }

    public final void setCronetRequestLog(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cronetRequestLog = str;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errorMessage = str;
    }

    public final List<Header> getErrorRespHeader() {
        return this.errorRespHeader;
    }

    public final void setErrorRespHeader(List<Header> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.errorRespHeader = list;
    }

    public final byte[] getErrorRespBody() {
        return this.errorRespBody;
    }

    public final void setErrorRespBody(byte[] bArr) {
        this.errorRespBody = bArr;
    }

    public final String getTtnetErrorOriginalCause() {
        return this.ttnetErrorOriginalCause;
    }

    public final void setTtnetErrorOriginalCause(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ttnetErrorOriginalCause = str;
    }

    public final String getExceptionStackTrackStr() {
        return this.exceptionStackTrackStr;
    }

    public final void setExceptionStackTrackStr(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.exceptionStackTrackStr = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.errorMessage;
    }
}
