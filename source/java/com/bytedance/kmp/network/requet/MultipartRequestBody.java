package com.bytedance.kmp.network.requet;

import com.bytedance.ies.xbridge.base.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.CharsKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* compiled from: MultipartRequestBody.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0004\u001e\u001f !B%\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0012J\u001a\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\f¨\u0006\""}, d2 = {"Lcom/bytedance/kmp/network/requet/MultipartRequestBody;", "Lcom/bytedance/kmp/network/requet/RequestBody;", "boundaryByteString", "Lokio/ByteString;", "type", "", "parts", "", "Lcom/bytedance/kmp/network/requet/MultipartRequestBody$Part;", "(Lokio/ByteString;Ljava/lang/String;Ljava/util/List;)V", "boundary", "getBoundary", "()Ljava/lang/String;", "contentLength", "", "contentType", "()Ljava/util/List;", "size", "", "getSize", "()I", "part", "index", "writeOrCountBytes", "sink", "Lokio/BufferedSink;", "countBytes", "", "writeTo", "", "Builder", "Companion", "MultiSourcePart", "Part", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class MultipartRequestBody extends RequestBody {
    private final ByteString boundaryByteString;
    private long contentLength;
    private final String contentType;
    private final List<Part> parts;
    private final String type;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String MIXED = "multipart/mixed";
    public static final String ALTERNATIVE = "multipart/alternative";
    public static final String DIGEST = "multipart/digest";
    public static final String PARALLEL = "multipart/parallel";
    public static final String FORM = "multipart/form-data";
    private static final byte[] COLONSPACE = {58, 32};
    private static final byte[] CRLF = {13, 10};
    private static final byte[] DASHDASH = {45, 45};

    public /* synthetic */ MultipartRequestBody(ByteString byteString, String str, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteString, str, list);
    }

    /* renamed from: type, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final List<Part> parts() {
        return this.parts;
    }

    private MultipartRequestBody(ByteString byteString, String str, List<Part> list) {
        this.boundaryByteString = byteString;
        this.type = str;
        this.parts = list;
        this.contentType = str + "; boundary=" + getBoundary();
        this.contentLength = -1L;
    }

    @Override // com.bytedance.kmp.network.requet.RequestBody
    /* renamed from: contentType, reason: from getter */
    public String getContentType() {
        return this.contentType;
    }

    @Override // com.bytedance.kmp.network.requet.RequestBody
    public void writeTo(BufferedSink sink) {
        writeOrCountBytes(sink, false);
    }

    public final String getBoundary() {
        return this.boundaryByteString.utf8();
    }

    public final int getSize() {
        return this.parts.size();
    }

    public final Part part(int index) {
        return this.parts.get(index);
    }

    @Override // com.bytedance.kmp.network.requet.RequestBody
    /* renamed from: contentLength */
    public long get$contentLength() {
        long j = this.contentLength;
        if (j != -1) {
            return j;
        }
        long writeOrCountBytes = writeOrCountBytes(null, true);
        this.contentLength = writeOrCountBytes;
        return writeOrCountBytes;
    }

    private final long writeOrCountBytes(BufferedSink sink, boolean countBytes) {
        BufferedSink bufferedSink;
        if (countBytes) {
            sink = new Buffer();
            bufferedSink = sink;
        } else {
            bufferedSink = null;
        }
        int size = this.parts.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            Part part = this.parts.get(i);
            Map<String, String> headers = part.headers();
            RequestBody body = part.getBody();
            Intrinsics.checkNotNull(sink);
            BufferedSink bufferedSink2 = sink;
            bufferedSink2.write(DASHDASH);
            bufferedSink2.write(this.boundaryByteString);
            bufferedSink2.write(CRLF);
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    String key = entry.getKey();
                    bufferedSink2.writeUtf8(key).write(COLONSPACE).writeUtf8(entry.getValue()).write(CRLF);
                }
            }
            String contentType = body.getContentType();
            if (contentType != null) {
                bufferedSink2.writeUtf8("Content-Type: ").writeUtf8(contentType.toString()).write(CRLF);
            }
            long j2 = body.get$contentLength();
            if (j2 != -1) {
                bufferedSink2.writeUtf8("Content-Length: ").writeDecimalLong(j2).write(CRLF);
            } else if (countBytes) {
                Intrinsics.checkNotNull(bufferedSink);
                bufferedSink.clear();
                return -1L;
            }
            byte[] bArr = CRLF;
            bufferedSink2.write(bArr);
            if (countBytes) {
                j += j2;
            } else {
                body.writeTo(bufferedSink2);
            }
            bufferedSink2.write(bArr);
        }
        Intrinsics.checkNotNull(sink);
        BufferedSink bufferedSink3 = sink;
        byte[] bArr2 = DASHDASH;
        bufferedSink3.write(bArr2);
        bufferedSink3.write(this.boundaryByteString);
        bufferedSink3.write(bArr2);
        bufferedSink3.write(CRLF);
        if (!countBytes) {
            return j;
        }
        Intrinsics.checkNotNull(bufferedSink);
        long size2 = j + bufferedSink.size();
        bufferedSink.clear();
        return size2;
    }

    /* compiled from: MultipartRequestBody.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB%\b\u0002\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR!\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/kmp/network/requet/MultipartRequestBody$Part;", "", "headers", "", "", "body", "Lcom/bytedance/kmp/network/requet/RequestBody;", "(Ljava/util/Map;Lcom/bytedance/kmp/network/requet/RequestBody;)V", "()Lcom/bytedance/kmp/network/requet/RequestBody;", "()Ljava/util/Map;", "Companion", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Part {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final RequestBody body;
        private final Map<String, String> headers;

        public /* synthetic */ Part(Map map, RequestBody requestBody, DefaultConstructorMarker defaultConstructorMarker) {
            this(map, requestBody);
        }

        @JvmStatic
        public static final Part create(RequestBody requestBody) {
            return INSTANCE.create(requestBody);
        }

        @JvmStatic
        public static final Part create(Map<String, String> map, RequestBody requestBody) {
            return INSTANCE.create(map, requestBody);
        }

        @JvmStatic
        public static final Part createFormData(String str, String str2) {
            return INSTANCE.createFormData(str, str2);
        }

        @JvmStatic
        public static final Part createFormData(String str, String str2, RequestBody requestBody) {
            return INSTANCE.createFormData(str, str2, requestBody);
        }

        private Part(Map<String, String> map, RequestBody requestBody) {
            this.headers = map;
            this.body = requestBody;
        }

        public final Map<String, String> headers() {
            return this.headers;
        }

        /* renamed from: body, reason: from getter */
        public final RequestBody getBody() {
            return this.body;
        }

        /* compiled from: MultipartRequestBody.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J&\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0007J\"\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/kmp/network/requet/MultipartRequestBody$Part$Companion;", "", "()V", "create", "Lcom/bytedance/kmp/network/requet/MultipartRequestBody$Part;", "body", "Lcom/bytedance/kmp/network/requet/RequestBody;", "headers", "", "", "createFormData", "name", "value", "filename", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Part create(RequestBody body) {
                Intrinsics.checkNotNullParameter(body, "body");
                return create(null, body);
            }

            @JvmStatic
            public final Part create(Map<String, String> headers, RequestBody body) {
                Intrinsics.checkNotNullParameter(body, "body");
                DefaultConstructorMarker defaultConstructorMarker = null;
                if (!((headers != null ? headers.get(XBridgeAPIRequestUtils.CONTENT_TYPE) : null) == null)) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
                }
                if (!((headers != null ? headers.get("Content-Length") : null) == null)) {
                    throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
                }
                return new Part(headers, body, defaultConstructorMarker);
            }

            @JvmStatic
            public final Part createFormData(String name, String value) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(value, "value");
                return createFormData(name, null, RequestBodyKt.toRequestBody$default(value, null, 1, null));
            }

            @JvmStatic
            public final Part createFormData(String name, String filename, RequestBody body) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(body, "body");
                StringBuilder sb = new StringBuilder();
                sb.append("form-data; name=");
                MultipartRequestBody.INSTANCE.appendQuotedString$network_service_release(sb, name);
                if (filename != null) {
                    sb.append("; filename=");
                    MultipartRequestBody.INSTANCE.appendQuotedString$network_service_release(sb, filename);
                }
                return create(MapsKt.mapOf(TuplesKt.to("Content-Disposition", sb.toString())), body);
            }
        }
    }

    /* compiled from: MultipartRequestBody.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/kmp/network/requet/MultipartRequestBody$MultiSourcePart;", "", "name", "", "fileName", EventConstants.PARAM_SOURCE, "Lokio/BufferedSource;", "(Ljava/lang/String;Ljava/lang/String;Lokio/BufferedSource;)V", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "getName", "setName", "getSource", "()Lokio/BufferedSource;", "setSource", "(Lokio/BufferedSource;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class MultiSourcePart {
        private String fileName;
        private String name;
        private BufferedSource source;

        public static /* synthetic */ MultiSourcePart copy$default(MultiSourcePart multiSourcePart, String str, String str2, BufferedSource bufferedSource, int i, Object obj) {
            if ((i & 1) != 0) {
                str = multiSourcePart.name;
            }
            if ((i & 2) != 0) {
                str2 = multiSourcePart.fileName;
            }
            if ((i & 4) != 0) {
                bufferedSource = multiSourcePart.source;
            }
            return multiSourcePart.copy(str, str2, bufferedSource);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final String getFileName() {
            return this.fileName;
        }

        /* renamed from: component3, reason: from getter */
        public final BufferedSource getSource() {
            return this.source;
        }

        public final MultiSourcePart copy(String name, String fileName, BufferedSource source) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(source, EventConstants.PARAM_SOURCE);
            return new MultiSourcePart(name, fileName, source);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MultiSourcePart)) {
                return false;
            }
            MultiSourcePart multiSourcePart = (MultiSourcePart) other;
            return Intrinsics.areEqual(this.name, multiSourcePart.name) && Intrinsics.areEqual(this.fileName, multiSourcePart.fileName) && Intrinsics.areEqual(this.source, multiSourcePart.source);
        }

        public int hashCode() {
            int hashCode = this.name.hashCode() * 31;
            String str = this.fileName;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.source.hashCode();
        }

        public String toString() {
            return "MultiSourcePart(name=" + this.name + ", fileName=" + this.fileName + ", source=" + this.source + ')';
        }

        public MultiSourcePart(String str, String str2, BufferedSource bufferedSource) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(bufferedSource, EventConstants.PARAM_SOURCE);
            this.name = str;
            this.fileName = str2;
            this.source = bufferedSource;
        }

        public /* synthetic */ MultiSourcePart(String str, String str2, BufferedSource bufferedSource, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, bufferedSource);
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        public final String getFileName() {
            return this.fileName;
        }

        public final void setFileName(String str) {
            this.fileName = str;
        }

        public final BufferedSource getSource() {
            return this.source;
        }

        public final void setSource(BufferedSource bufferedSource) {
            Intrinsics.checkNotNullParameter(bufferedSource, "<set-?>");
            this.source = bufferedSource;
        }
    }

    /* compiled from: MultipartRequestBody.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tJ \u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ$\u0010\u0010\u001a\u00020\u00002\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\tH\u0002J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/kmp/network/requet/MultipartRequestBody$Builder;", "", "()V", "boundary", "Lokio/ByteString;", "parts", "", "Lcom/bytedance/kmp/network/requet/MultipartRequestBody$Part;", "type", "", "addFormDataPart", "name", "value", "filename", "body", "Lcom/bytedance/kmp/network/requet/RequestBody;", "addPart", "part", "headers", "", "build", "Lcom/bytedance/kmp/network/requet/MultipartRequestBody;", "generateUUID", "setType", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Builder {
        private final ByteString boundary = ByteString.Companion.encodeUtf8(generateUUID());
        private String type = MultipartRequestBody.MIXED;
        private final List<Part> parts = new ArrayList();

        public final Builder setType(String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            return this;
        }

        public final Builder addPart(RequestBody body) {
            Intrinsics.checkNotNullParameter(body, "body");
            addPart(Part.INSTANCE.create(body));
            return this;
        }

        public final Builder addPart(Map<String, String> headers, RequestBody body) {
            Intrinsics.checkNotNullParameter(body, "body");
            addPart(Part.INSTANCE.create(headers, body));
            return this;
        }

        public final Builder addFormDataPart(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            addPart(Part.INSTANCE.createFormData(name, value));
            return this;
        }

        public final Builder addFormDataPart(String name, String filename, RequestBody body) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(body, "body");
            addPart(Part.INSTANCE.createFormData(name, filename, body));
            return this;
        }

        public final Builder addPart(Part part) {
            Intrinsics.checkNotNullParameter(part, "part");
            this.parts.add(part);
            return this;
        }

        public final MultipartRequestBody build() {
            if (!(!this.parts.isEmpty())) {
                throw new IllegalStateException("Multipart body must have at least one part.".toString());
            }
            return new MultipartRequestBody(this.boundary, this.type, this.parts, null);
        }

        private final String generateUUID() {
            Random.Default r0 = Random.Default;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                String num = Integer.toString(r0.nextInt(0, 16), CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
                sb.append(num);
            }
            sb.append('-');
            for (int i2 = 0; i2 < 4; i2++) {
                String num2 = Integer.toString(r0.nextInt(0, 16), CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(num2, "toString(...)");
                sb.append(num2);
            }
            sb.append("-4");
            for (int i3 = 0; i3 < 3; i3++) {
                String num3 = Integer.toString(r0.nextInt(0, 16), CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(num3, "toString(...)");
                sb.append(num3);
            }
            sb.append('-');
            String num4 = Integer.toString(r0.nextInt(8, 16), CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(num4, "toString(...)");
            sb.append(num4);
            for (int i4 = 0; i4 < 3; i4++) {
                String num5 = Integer.toString(r0.nextInt(0, 16), CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(num5, "toString(...)");
                sb.append(num5);
            }
            sb.append('-');
            for (int i5 = 0; i5 < 12; i5++) {
                String num6 = Integer.toString(r0.nextInt(0, 16), CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(num6, "toString(...)");
                sb.append(num6);
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "uuid.toString()");
            return sb2;
        }
    }

    /* compiled from: MultipartRequestBody.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\r\u001a\u00020\u000e*\u00060\u000fj\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0012R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/kmp/network/requet/MultipartRequestBody$Companion;", "", "()V", "ALTERNATIVE", "", "COLONSPACE", "", "CRLF", "DASHDASH", "DIGEST", "FORM", "MIXED", "PARALLEL", "appendQuotedString", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "key", "appendQuotedString$network_service_release", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void appendQuotedString$network_service_release(StringBuilder sb, String str) {
            Intrinsics.checkNotNullParameter(sb, "<this>");
            Intrinsics.checkNotNullParameter(str, "key");
            sb.append('\"');
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt == '\n') {
                    sb.append("%0A");
                } else if (charAt == '\r') {
                    sb.append("%0D");
                } else if (charAt == '\"') {
                    sb.append("%22");
                } else {
                    sb.append(charAt);
                }
            }
            sb.append('\"');
        }
    }
}
