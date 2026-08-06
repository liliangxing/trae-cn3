package coil3.network.internal;

import coil3.disk.DiskCache;
import coil3.network.NetworkHeaders;
import coil3.network.NetworkResponseBody;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.BufferedSink;

/* compiled from: utils.common.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0000\u001a\u0012\u0010\u0007\u001a\u00020\b*\u00020\tH\u0080@¢\u0006\u0002\u0010\n\u001a\u0015\u0010\u000f\u001a\u00020\u0005*\u00060\u0011j\u0002`\u0010H\u0000¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u000b\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"append", "Lcoil3/network/NetworkHeaders$Builder;", "line", "", "abortQuietly", "", "Lcoil3/disk/DiskCache$Editor;", "readBuffer", "Lokio/Buffer;", "Lcoil3/network/NetworkResponseBody;", "(Lcoil3/network/NetworkResponseBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CACHE_CONTROL", "CONTENT_TYPE", "HTTP_METHOD_GET", "MIME_TYPE_TEXT_PLAIN", "closeQuietly", "Lkotlin/AutoCloseable;", "Ljava/lang/AutoCloseable;", "(Ljava/lang/AutoCloseable;)V", "coil-network-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class Utils_commonKt {
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String HTTP_METHOD_GET = "GET";
    public static final String MIME_TYPE_TEXT_PLAIN = "text/plain";

    public static final NetworkHeaders.Builder append(NetworkHeaders.Builder builder, String str) {
        int indexOf$default = StringsKt.indexOf$default(str, ':', 0, false, 6, (Object) null);
        if (!(indexOf$default != -1)) {
            throw new IllegalArgumentException(("Unexpected header: " + str).toString());
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        String obj = StringsKt.trim(substring).toString();
        String substring2 = str.substring(indexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        builder.add(obj, substring2);
        return builder;
    }

    public static final void abortQuietly(DiskCache.Editor editor) {
        try {
            editor.abort();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readBuffer(NetworkResponseBody networkResponseBody, Continuation<? super Buffer> continuation) {
        Utils_commonKt$readBuffer$1 utils_commonKt$readBuffer$1;
        int i;
        AutoCloseable autoCloseable;
        Throwable th;
        Buffer buffer;
        if (continuation instanceof Utils_commonKt$readBuffer$1) {
            utils_commonKt$readBuffer$1 = (Utils_commonKt$readBuffer$1) continuation;
            if ((utils_commonKt$readBuffer$1.label & Integer.MIN_VALUE) != 0) {
                utils_commonKt$readBuffer$1.label -= Integer.MIN_VALUE;
                Object obj = utils_commonKt$readBuffer$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = utils_commonKt$readBuffer$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    NetworkResponseBody networkResponseBody2 = networkResponseBody;
                    try {
                        Buffer buffer2 = new Buffer();
                        utils_commonKt$readBuffer$1.L$0 = networkResponseBody2;
                        utils_commonKt$readBuffer$1.L$1 = buffer2;
                        utils_commonKt$readBuffer$1.label = 1;
                        if (networkResponseBody2.writeTo((BufferedSink) buffer2, utils_commonKt$readBuffer$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        autoCloseable = networkResponseBody2;
                        buffer = buffer2;
                    } catch (Throwable th2) {
                        autoCloseable = networkResponseBody2;
                        th = th2;
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    buffer = (Buffer) utils_commonKt$readBuffer$1.L$1;
                    autoCloseable = (AutoCloseable) utils_commonKt$readBuffer$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            AutoCloseableKt.closeFinally(autoCloseable, th);
                            throw th4;
                        }
                    }
                }
                AutoCloseableKt.closeFinally(autoCloseable, (Throwable) null);
                return buffer;
            }
        }
        utils_commonKt$readBuffer$1 = new Utils_commonKt$readBuffer$1(continuation);
        Object obj2 = utils_commonKt$readBuffer$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = utils_commonKt$readBuffer$1.label;
        if (i != 0) {
        }
        AutoCloseableKt.closeFinally(autoCloseable, (Throwable) null);
        return buffer;
    }

    public static final void closeQuietly(AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }
}
