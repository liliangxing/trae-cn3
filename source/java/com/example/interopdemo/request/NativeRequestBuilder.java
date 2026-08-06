package com.example.interopdemo.request;

import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import com.lynx.tasm.DefaultLogicExecutor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NativeRequestBuilder.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\rJ\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/example/interopdemo/request/NativeRequestBuilder;", "", "<init>", "()V", "url", "", DefaultLogicExecutor.EVENT_METHOD, "body", "Lcom/example/interopdemo/request/NativeRequestBody;", "headers", "", "Lkotlin/Pair;", "requestTimeout", "", "connectTimeout", "readTimeout", "writeTimeout", "requestFlag", "bypassCronetCookie", "", "followRedirectInternal", "isDownloadStreaming", "bodyString", "contentType", "bytes", "", "addHeader", "key", CustomDataTagHandler.VALUE_ATTRIBUTE, "timeout", "build", "Lcom/example/interopdemo/request/NativeRequest;", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class NativeRequestBuilder {
    private NativeRequestBody body;
    private boolean bypassCronetCookie;
    private boolean isDownloadStreaming;
    private int requestFlag;
    private String url = "";
    private String method = "GET";
    private List<Pair<String, String>> headers = new ArrayList();
    private int requestTimeout = -1;
    private int connectTimeout = 15000;
    private int readTimeout = 15000;
    private int writeTimeout = 15000;
    private boolean followRedirectInternal = true;

    public final NativeRequestBuilder url(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        return this;
    }

    public final NativeRequestBuilder method(String method) {
        Intrinsics.checkNotNullParameter(method, DefaultLogicExecutor.EVENT_METHOD);
        this.method = method;
        return this;
    }

    public final NativeRequestBuilder body(NativeRequestBody body) {
        this.body = body;
        return this;
    }

    public static /* synthetic */ NativeRequestBuilder body$default(NativeRequestBuilder nativeRequestBuilder, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "application/json; charset=utf-8";
        }
        return nativeRequestBuilder.body(str, str2);
    }

    public final NativeRequestBuilder body(String bodyString, String contentType) {
        Intrinsics.checkNotNullParameter(bodyString, "bodyString");
        this.body = NativeRequestBody.INSTANCE.create(bodyString, contentType);
        return this;
    }

    public static /* synthetic */ NativeRequestBuilder body$default(NativeRequestBuilder nativeRequestBuilder, byte[] bArr, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "application/octet-stream";
        }
        return nativeRequestBuilder.body(bArr, str);
    }

    public final NativeRequestBuilder body(byte[] bytes, String contentType) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.body = NativeRequestBody.INSTANCE.create(bytes, contentType);
        return this;
    }

    public final NativeRequestBuilder addHeader(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, CustomDataTagHandler.VALUE_ATTRIBUTE);
        this.headers.add(new Pair<>(key, value));
        return this;
    }

    public final NativeRequestBuilder requestTimeout(int timeout) {
        this.requestTimeout = timeout;
        return this;
    }

    public final NativeRequestBuilder connectTimeout(int timeout) {
        this.connectTimeout = timeout;
        return this;
    }

    public final NativeRequestBuilder readTimeout(int timeout) {
        this.readTimeout = timeout;
        return this;
    }

    public final NativeRequestBuilder writeTimeout(int timeout) {
        this.writeTimeout = timeout;
        return this;
    }

    public final NativeRequest build() {
        String contentType;
        boolean z = false;
        if (this.url.length() == 0) {
            throw new IllegalArgumentException("URL must not be empty");
        }
        NativeRequestBody nativeRequestBody = this.body;
        if (nativeRequestBody != null && (contentType = nativeRequestBody.getContentType()) != null) {
            List<Pair<String, String>> list = this.headers;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (StringsKt.equals((String) ((Pair) it.next()).getFirst(), "Content-Type", true)) {
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                this.headers.add(TuplesKt.to("Content-Type", contentType));
            }
        }
        return new NativeRequest(this.url, this.method, this.headers, this.body, this.requestTimeout, this.connectTimeout, this.readTimeout, this.writeTimeout);
    }
}
