package com.bytedance.kmp.network.requet;

import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.BufferedSink;
import okio.Source;

/* compiled from: RequestBody.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"toRequestBody", "Lcom/bytedance/kmp/network/requet/RequestBody;", "", "contentType", "", "offset", "", "byteCount", "Lokio/Source;", "contentLength", "", "network_service_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RequestBodyKt {
    public static /* synthetic */ RequestBody toRequestBody$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = null;
        }
        return toRequestBody(str, str2);
    }

    public static final RequestBody toRequestBody(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toRequestBody$default(StringsKt.encodeToByteArray(str), str2, 0, 0, 6, null);
    }

    public static /* synthetic */ RequestBody toRequestBody$default(byte[] bArr, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return toRequestBody(bArr, str, i, i2);
    }

    public static final RequestBody toRequestBody(final byte[] bArr, final String str, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new RequestBody() { // from class: com.bytedance.kmp.network.requet.RequestBodyKt$toRequestBody$1
            @Override // com.bytedance.kmp.network.requet.RequestBody
            /* renamed from: contentType, reason: from getter */
            public String get$contentType() {
                return str;
            }

            @Override // com.bytedance.kmp.network.requet.RequestBody
            /* renamed from: contentLength */
            public long get$contentLength() {
                return i2;
            }

            @Override // com.bytedance.kmp.network.requet.RequestBody
            public void writeTo(BufferedSink sink) {
                if (sink != null) {
                    sink.write(bArr, i, i2);
                }
            }
        };
    }

    public static /* synthetic */ RequestBody toRequestBody$default(Source source, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            j = -1;
        }
        return toRequestBody(source, str, j);
    }

    public static final RequestBody toRequestBody(final Source source, final String str, final long j) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        return new RequestBody() { // from class: com.bytedance.kmp.network.requet.RequestBodyKt$toRequestBody$2
            @Override // com.bytedance.kmp.network.requet.RequestBody
            /* renamed from: contentType, reason: from getter */
            public String get$contentType() {
                return str;
            }

            @Override // com.bytedance.kmp.network.requet.RequestBody
            /* renamed from: contentLength, reason: from getter */
            public long get$contentLength() {
                return j;
            }

            @Override // com.bytedance.kmp.network.requet.RequestBody
            public void writeTo(BufferedSink sink) {
                Source source2 = (Closeable) source;
                try {
                    Source source3 = source2;
                    if (sink != null) {
                        Long.valueOf(sink.writeAll(source3));
                    }
                    if (source2 != null) {
                        try {
                            source2.close();
                        } catch (Throwable th) {
                            th = th;
                        }
                    }
                    th = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (source2 != null) {
                        try {
                            source2.close();
                        } catch (Throwable th3) {
                            ExceptionsKt.addSuppressed(th, th3);
                        }
                    }
                }
                if (th != null) {
                    throw th;
                }
            }
        };
    }
}
