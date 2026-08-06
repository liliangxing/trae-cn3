package com.example.interopdemo.request;

import com.facebook.imageutils.JfifUtil;
import com.lynx.tasm.DefaultLogicExecutor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeRequest.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u00002\u00020\u0001Bm\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00070\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R,\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/example/interopdemo/request/NativeRequest;", "", "url", "", DefaultLogicExecutor.EVENT_METHOD, "headers", "", "Lkotlin/Pair;", "body", "Lcom/example/interopdemo/request/NativeRequestBody;", "requestTimeout", "", "connectTimeout", "readTimeout", "writeTimeout", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/example/interopdemo/request/NativeRequestBody;IIII)V", "getUrl", "()Ljava/lang/String;", "getMethod", "getHeaders", "()Ljava/util/List;", "setHeaders", "(Ljava/util/List;)V", "getBody", "()Lcom/example/interopdemo/request/NativeRequestBody;", "getRequestTimeout", "()I", "getConnectTimeout", "getReadTimeout", "getWriteTimeout", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class NativeRequest {
    private final NativeRequestBody body;
    private final int connectTimeout;
    private List<Pair<String, String>> headers;
    private final String method;
    private final int readTimeout;
    private final int requestTimeout;
    private final String url;
    private final int writeTimeout;

    public NativeRequest() {
        this(null, null, null, null, 0, 0, 0, 0, JfifUtil.MARKER_FIRST_BYTE, null);
    }

    public NativeRequest(String str, String str2, List<Pair<String, String>> list, NativeRequestBody nativeRequestBody, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, DefaultLogicExecutor.EVENT_METHOD);
        Intrinsics.checkNotNullParameter(list, "headers");
        this.url = str;
        this.method = str2;
        this.headers = list;
        this.body = nativeRequestBody;
        this.requestTimeout = i;
        this.connectTimeout = i2;
        this.readTimeout = i3;
        this.writeTimeout = i4;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getMethod() {
        return this.method;
    }

    public /* synthetic */ NativeRequest(String str, String str2, List list, NativeRequestBody nativeRequestBody, int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? "" : str, (i5 & 2) == 0 ? str2 : "", (i5 & 4) != 0 ? new ArrayList() : list, (i5 & 8) != 0 ? null : nativeRequestBody, (i5 & 16) != 0 ? -1 : i, (i5 & 32) != 0 ? 15000 : i2, (i5 & 64) != 0 ? 15000 : i3, (i5 & 128) == 0 ? i4 : 15000);
    }

    public final List<Pair<String, String>> getHeaders() {
        return this.headers;
    }

    public final void setHeaders(List<Pair<String, String>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.headers = list;
    }

    public final NativeRequestBody getBody() {
        return this.body;
    }

    public final int getRequestTimeout() {
        return this.requestTimeout;
    }

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    public final int getReadTimeout() {
        return this.readTimeout;
    }

    public final int getWriteTimeout() {
        return this.writeTimeout;
    }
}
