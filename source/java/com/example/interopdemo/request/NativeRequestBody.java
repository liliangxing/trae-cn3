package com.example.interopdemo.request;

import com.example.interopdemo.request.NativeRequestBody;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NativeRequest.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \n2\u00020\u0001:\u0003\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u0082\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lcom/example/interopdemo/request/NativeRequestBody;", "", "<init>", "()V", "content", "", "contentType", "", "StringBody", "ByteArrayBody", "Companion", "Lcom/example/interopdemo/request/NativeRequestBody$ByteArrayBody;", "Lcom/example/interopdemo/request/NativeRequestBody$StringBody;", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class NativeRequestBody {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ NativeRequestBody(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* renamed from: content */
    public abstract byte[] getBytes();

    /* renamed from: contentType */
    public abstract String getContentType();

    private NativeRequestBody() {
    }

    /* compiled from: NativeRequest.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\bH\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/example/interopdemo/request/NativeRequestBody$StringBody;", "Lcom/example/interopdemo/request/NativeRequestBody;", "text", "", "contentType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "bytes", "", "getBytes", "()[B", "bytes$delegate", "Lkotlin/Lazy;", "content", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class StringBody extends NativeRequestBody {

        /* renamed from: bytes$delegate, reason: from kotlin metadata */
        private final Lazy bytes;
        private final String contentType;
        private final String text;

        public /* synthetic */ StringBody(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? "text/plain; charset=utf-8" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StringBody(String str, String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "text");
            this.text = str;
            this.contentType = str2;
            this.bytes = LazyKt.lazy(new Function0() { // from class: com.example.interopdemo.request.NativeRequestBody$StringBody$$ExternalSyntheticLambda0
                public final Object invoke() {
                    byte[] bytes_delegate$lambda$0;
                    bytes_delegate$lambda$0 = NativeRequestBody.StringBody.bytes_delegate$lambda$0(NativeRequestBody.StringBody.this);
                    return bytes_delegate$lambda$0;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final byte[] bytes_delegate$lambda$0(StringBody stringBody) {
            return StringsKt.encodeToByteArray(stringBody.text);
        }

        private final byte[] getBytes() {
            return (byte[]) this.bytes.getValue();
        }

        @Override // com.example.interopdemo.request.NativeRequestBody
        /* renamed from: content */
        public byte[] getBytes() {
            return getBytes();
        }

        @Override // com.example.interopdemo.request.NativeRequestBody
        /* renamed from: contentType, reason: from getter */
        public String getContentType() {
            return this.contentType;
        }
    }

    /* compiled from: NativeRequest.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/example/interopdemo/request/NativeRequestBody$ByteArrayBody;", "Lcom/example/interopdemo/request/NativeRequestBody;", "bytes", "", "contentType", "", "<init>", "([BLjava/lang/String;)V", "content", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class ByteArrayBody extends NativeRequestBody {
        private final byte[] bytes;
        private final String contentType;

        public /* synthetic */ ByteArrayBody(byte[] bArr, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(bArr, (i & 2) != 0 ? null : str);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ByteArrayBody(byte[] bArr, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(bArr, "bytes");
            this.bytes = bArr;
            this.contentType = str;
        }

        @Override // com.example.interopdemo.request.NativeRequestBody
        /* renamed from: content, reason: from getter */
        public byte[] getBytes() {
            return this.bytes;
        }

        @Override // com.example.interopdemo.request.NativeRequestBody
        /* renamed from: contentType, reason: from getter */
        public String getContentType() {
            return this.contentType;
        }
    }

    /* compiled from: NativeRequest.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¨\u0006\u000b"}, d2 = {"Lcom/example/interopdemo/request/NativeRequestBody$Companion;", "", "<init>", "()V", "create", "Lcom/example/interopdemo/request/NativeRequestBody;", "text", "", "contentType", "bytes", "", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ NativeRequestBody create$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = "application/json; charset=utf-8";
            }
            return companion.create(str, str2);
        }

        public final NativeRequestBody create(String text, String contentType) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new StringBody(text, contentType);
        }

        public static /* synthetic */ NativeRequestBody create$default(Companion companion, byte[] bArr, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = "application/octet-stream";
            }
            return companion.create(bArr, str);
        }

        public final NativeRequestBody create(byte[] bytes, String contentType) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            return new ByteArrayBody(bytes, contentType);
        }
    }
}
