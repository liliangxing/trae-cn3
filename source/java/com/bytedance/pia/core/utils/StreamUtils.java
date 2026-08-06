package com.bytedance.pia.core.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: StreamUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\b*\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u000e\u0010\f\u001a\u00020\r*\u0004\u0018\u00010\bH\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/pia/core/utils/StreamUtils;", "", "()V", "asSequence", "Lkotlin/sequences/Sequence;", "", "Ljava/io/InputStream;", "encoding", "", "chunkSize", "", "readAndClose", "safeToCharset", "Ljava/nio/charset/Charset;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class StreamUtils {
    public static final StreamUtils INSTANCE = new StreamUtils();

    @JvmStatic
    public static final Sequence<char[]> asSequence(InputStream inputStream) throws Throwable {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        return asSequence$default(inputStream, null, 0, 3, null);
    }

    @JvmStatic
    public static final Sequence<char[]> asSequence(InputStream inputStream, String str) throws Throwable {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        return asSequence$default(inputStream, str, 0, 2, null);
    }

    @JvmStatic
    public static final String readAndClose(InputStream inputStream) throws Throwable {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        return readAndClose$default(inputStream, null, 1, null);
    }

    private StreamUtils() {
    }

    public static /* synthetic */ String readAndClose$default(InputStream inputStream, String str, int i, Object obj) throws Throwable {
        if ((i & 1) != 0) {
            str = "";
        }
        return readAndClose(inputStream, str);
    }

    @JvmStatic
    public static final String readAndClose(InputStream inputStream, String str) throws Throwable {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        InputStream inputStream2 = inputStream;
        try {
            InputStream inputStream3 = inputStream2;
            String readText = TextStreamsKt.readText(new InputStreamReader(inputStream, INSTANCE.safeToCharset(str)));
            CloseableKt.closeFinally(inputStream2, (Throwable) null);
            return readText;
        } finally {
        }
    }

    @JvmStatic
    public static final Sequence<char[]> asSequence(InputStream inputStream, String str, int i) throws Throwable {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        InputStream inputStream2 = inputStream;
        try {
            InputStream inputStream3 = inputStream2;
            Sequence<char[]> sequence = SequencesKt.sequence(new StreamUtils$asSequence$1$1(i, new InputStreamReader(inputStream, INSTANCE.safeToCharset(str)), null));
            CloseableKt.closeFinally(inputStream2, (Throwable) null);
            return sequence;
        } finally {
        }
    }

    public static /* synthetic */ Sequence asSequence$default(InputStream inputStream, String str, int i, int i2, Object obj) throws Throwable {
        if ((i2 & 1) != 0) {
            str = "";
        }
        if ((i2 & 2) != 0) {
            i = 1024;
        }
        return asSequence(inputStream, str, i);
    }

    private final Charset safeToCharset(String str) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Charset.forName(str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Charset defaultCharset = Charset.defaultCharset();
        if (Result.isFailure-impl(obj)) {
            obj = defaultCharset;
        }
        Intrinsics.checkNotNullExpressionValue(obj, "runCatching { Charset.fo…Charset.defaultCharset())");
        return (Charset) obj;
    }
}
