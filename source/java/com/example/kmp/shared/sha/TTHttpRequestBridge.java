package com.example.kmp.shared.sha;

import com.bytedance.bdturing.methods.JsCallParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TTHttpRequestBridge.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u00101J\u001e\u00102\u001a\u0002032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00104\u001a\u000205H¦@¢\u0006\u0002\u00106J\b\u00107\u001a\u000203H&R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR,\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000f0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\u001a\u0010\u0017\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001a\u0010)\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\u001a\u0010,\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%¨\u00068"}, d2 = {"Lcom/example/kmp/shared/sha/TTHttpRequestBridge;", "", "<init>", "()V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "method", "getMethod", "setMethod", "headers", "", "Lkotlin/Pair;", "getHeaders", "()Ljava/util/List;", "setHeaders", "(Ljava/util/List;)V", "bodyType", "getBodyType", "setBodyType", "strBody", "getStrBody", "setStrBody", "bytesBody", "", "getBytesBody", "()[B", "setBytesBody", "([B)V", "requestTimeout", "", "getRequestTimeout", "()I", "setRequestTimeout", "(I)V", "connectTimeout", "getConnectTimeout", "setConnectTimeout", "readTimeout", "getReadTimeout", "setReadTimeout", "writeTimeout", "getWriteTimeout", "setWriteTimeout", "execute", "Lcom/example/kmp/shared/sha/BridgeResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeStream", "", JsCallParser.VALUE_CALLBACK, "Lcom/example/kmp/shared/sha/BridgeResponseCallback;", "(Ljava/lang/String;Lcom/example/kmp/shared/sha/BridgeResponseCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "kmpNativeBridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class TTHttpRequestBridge {
    private String url = "";
    private String method = "GET";
    private List<Pair<String, String>> headers = new ArrayList();
    private String bodyType = "STRING";
    private String strBody = "";
    private byte[] bytesBody = new byte[0];
    private int requestTimeout = -1;
    private int connectTimeout = 15000;
    private int readTimeout = 15000;
    private int writeTimeout = 15000;

    public abstract void cancel();

    public abstract Object execute(String str, Continuation<? super BridgeResponse> continuation);

    public abstract Object executeStream(String str, BridgeResponseCallback bridgeResponseCallback, Continuation<? super Unit> continuation);

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final String getMethod() {
        return this.method;
    }

    public final void setMethod(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.method = str;
    }

    public final List<Pair<String, String>> getHeaders() {
        return this.headers;
    }

    public final void setHeaders(List<Pair<String, String>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.headers = list;
    }

    public final String getBodyType() {
        return this.bodyType;
    }

    public final void setBodyType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bodyType = str;
    }

    public final String getStrBody() {
        return this.strBody;
    }

    public final void setStrBody(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.strBody = str;
    }

    public final byte[] getBytesBody() {
        return this.bytesBody;
    }

    public final void setBytesBody(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.bytesBody = bArr;
    }

    public final int getRequestTimeout() {
        return this.requestTimeout;
    }

    public final void setRequestTimeout(int i) {
        this.requestTimeout = i;
    }

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    public final void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    public final int getReadTimeout() {
        return this.readTimeout;
    }

    public final void setReadTimeout(int i) {
        this.readTimeout = i;
    }

    public final int getWriteTimeout() {
        return this.writeTimeout;
    }

    public final void setWriteTimeout(int i) {
        this.writeTimeout = i;
    }
}
