package kotlinx.serialization.json.internal;

import java.io.OutputStream;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.openid.appauth.BuildConfig;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
import org.bouncycastle.asn1.eac.CertificateHolderAuthorization;
import org.bouncycastle.i18n.TextBundle;

/* compiled from: JvmJsonStreams.kt */
@Metadata(m4d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0015H\u0002J\u0018\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002J\b\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\rH\u0002J\u0011\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000bH\u0082\bJ\u0011\u0010\u0013\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u000bH\u0082\bJ\t\u0010\"\u001a\u00020\u000bH\u0082\bJ\u0018\u0010#\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u000bH\u0002J\u0010\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, m5d2 = {"Lkotlinx/serialization/json/internal/JsonToJavaStreamWriter;", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "stream", "Ljava/io/OutputStream;", "<init>", "(Ljava/io/OutputStream;)V", "buffer", BuildConfig.FLAVOR, "charArray", BuildConfig.FLAVOR, "indexInBuffer", BuildConfig.FLAVOR, "writeLong", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "writeChar", "char", BuildConfig.FLAVOR, "write", TextBundle.TEXT_ENTRY, BuildConfig.FLAVOR, "writeQuoted", "appendStringSlowPath", "currentSize", "string", "ensureTotalCapacity", "oldSize", "additional", "release", "flush", "ensure", "bytesCount", "byte", "rest", "writeUtf8", "count", "writeUtf8CodePoint", "codePoint", "kotlinx-serialization-json"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class JsonToJavaStreamWriter implements InternalJsonWriter {
    private final byte[] buffer;
    private char[] charArray;
    private int indexInBuffer;
    private final OutputStream stream;

    public JsonToJavaStreamWriter(OutputStream stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        this.stream = stream;
        this.buffer = ByteArrayPool.INSTANCE.take();
        this.charArray = CharArrayPool.INSTANCE.take();
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeLong(long value) {
        write(String.valueOf(value));
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeChar(char r1) {
        writeUtf8CodePoint(r1);
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void write(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        int length = text.length();
        ensureTotalCapacity(0, length);
        text.getChars(0, length, this.charArray, 0);
        writeUtf8(this.charArray, length);
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeQuoted(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        ensureTotalCapacity(0, text.length() + 2);
        char[] cArr = this.charArray;
        cArr[0] = '\"';
        int length = text.length();
        text.getChars(0, length, cArr, 1);
        int i = length + 1;
        for (int i2 = 1; i2 < i; i2++) {
            char c = cArr[i2];
            if (c < StringOpsKt.getESCAPE_MARKERS().length && StringOpsKt.getESCAPE_MARKERS()[c] != 0) {
                appendStringSlowPath(i2, text);
                return;
            }
        }
        cArr[i] = '\"';
        writeUtf8(cArr, length + 2);
        flush();
    }

    private final void appendStringSlowPath(int currentSize, String string) {
        int i;
        int length = string.length();
        for (int i2 = currentSize - 1; i2 < length; i2++) {
            int ensureTotalCapacity = ensureTotalCapacity(currentSize, 2);
            char charAt = string.charAt(i2);
            if (charAt < StringOpsKt.getESCAPE_MARKERS().length) {
                byte b = StringOpsKt.getESCAPE_MARKERS()[charAt];
                if (b == 0) {
                    i = ensureTotalCapacity + 1;
                    this.charArray[ensureTotalCapacity] = charAt;
                } else {
                    if (b == 1) {
                        String str = StringOpsKt.getESCAPE_STRINGS()[charAt];
                        Intrinsics.checkNotNull(str);
                        int ensureTotalCapacity2 = ensureTotalCapacity(ensureTotalCapacity, str.length());
                        str.getChars(0, str.length(), this.charArray, ensureTotalCapacity2);
                        currentSize = ensureTotalCapacity2 + str.length();
                    } else {
                        char[] cArr = this.charArray;
                        cArr[ensureTotalCapacity] = AbstractJsonLexerKt.STRING_ESC;
                        cArr[ensureTotalCapacity + 1] = (char) b;
                        currentSize = ensureTotalCapacity + 2;
                    }
                }
            } else {
                i = ensureTotalCapacity + 1;
                this.charArray[ensureTotalCapacity] = charAt;
            }
            currentSize = i;
        }
        ensureTotalCapacity(currentSize, 1);
        char[] cArr2 = this.charArray;
        cArr2[currentSize] = '\"';
        writeUtf8(cArr2, currentSize + 1);
        flush();
    }

    private final int ensureTotalCapacity(int oldSize, int additional) {
        int i = additional + oldSize;
        char[] cArr = this.charArray;
        if (cArr.length <= i) {
            char[] copyOf = Arrays.copyOf(cArr, RangesKt.coerceAtLeast(i, oldSize * 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.charArray = copyOf;
        }
        return oldSize;
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void release() {
        flush();
        CharArrayPool.INSTANCE.release(this.charArray);
        ByteArrayPool.INSTANCE.release(this.buffer);
    }

    private final void flush() {
        this.stream.write(this.buffer, 0, this.indexInBuffer);
        this.indexInBuffer = 0;
    }

    private final void write(int r4) {
        byte[] bArr = this.buffer;
        int i = this.indexInBuffer;
        this.indexInBuffer = i + 1;
        bArr[i] = (byte) r4;
    }

    private final int rest() {
        return this.buffer.length - this.indexInBuffer;
    }

    private final void writeUtf8(char[] string, int count) {
        if (!(count >= 0)) {
            throw new IllegalArgumentException("count < 0".toString());
        }
        if (!(count <= string.length)) {
            throw new IllegalArgumentException(("count > string.length: " + count + " > " + string.length).toString());
        }
        int i = 0;
        while (i < count) {
            char c = string[i];
            if (c < 128) {
                if (this.buffer.length - this.indexInBuffer < 1) {
                    flush();
                }
                byte[] bArr = this.buffer;
                int i2 = this.indexInBuffer;
                int i3 = i2 + 1;
                this.indexInBuffer = i3;
                bArr[i2] = (byte) c;
                i++;
                int min = Math.min(count, (bArr.length - i3) + i);
                while (i < min) {
                    char c2 = string[i];
                    if (c2 < 128) {
                        byte[] bArr2 = this.buffer;
                        int i4 = this.indexInBuffer;
                        this.indexInBuffer = i4 + 1;
                        bArr2[i4] = (byte) c2;
                        i++;
                    }
                }
            } else {
                if (c < 2048) {
                    if (this.buffer.length - this.indexInBuffer < 2) {
                        flush();
                    }
                    int i5 = (c >> 6) | CertificateHolderAuthorization.CVCA;
                    byte[] bArr3 = this.buffer;
                    int i6 = this.indexInBuffer;
                    int i7 = i6 + 1;
                    bArr3[i6] = (byte) i5;
                    this.indexInBuffer = i7 + 1;
                    bArr3[i7] = (byte) ((c & '?') | 128);
                } else if (c >= 55296 && c <= 57343) {
                    int i8 = i + 1;
                    char c3 = i8 < count ? string[i8] : (char) 0;
                    if (c <= 56319) {
                        if (56320 <= c3 && c3 < 57344) {
                            int i9 = (((c & 1023) << 10) | (c3 & 1023)) + PKIFailureInfo.notAuthorized;
                            if (this.buffer.length - this.indexInBuffer < 4) {
                                flush();
                            }
                            byte[] bArr4 = this.buffer;
                            int i10 = this.indexInBuffer;
                            int i11 = i10 + 1;
                            bArr4[i10] = (byte) ((i9 >> 18) | 240);
                            int i12 = i11 + 1;
                            bArr4[i11] = (byte) (((i9 >> 12) & 63) | 128);
                            int i13 = i12 + 1;
                            bArr4[i12] = (byte) (((i9 >> 6) & 63) | 128);
                            this.indexInBuffer = i13 + 1;
                            bArr4[i13] = (byte) ((i9 & 63) | 128);
                            i += 2;
                        }
                    }
                    if (this.buffer.length - this.indexInBuffer < 1) {
                        flush();
                    }
                    byte[] bArr5 = this.buffer;
                    int i14 = this.indexInBuffer;
                    this.indexInBuffer = i14 + 1;
                    bArr5[i14] = (byte) 63;
                    i = i8;
                } else {
                    if (this.buffer.length - this.indexInBuffer < 3) {
                        flush();
                    }
                    byte[] bArr6 = this.buffer;
                    int i15 = this.indexInBuffer;
                    int i16 = i15 + 1;
                    bArr6[i15] = (byte) ((c >> '\f') | 224);
                    int i17 = i16 + 1;
                    bArr6[i16] = (byte) (((c >> 6) & 63) | 128);
                    this.indexInBuffer = i17 + 1;
                    bArr6[i17] = (byte) ((c & '?') | 128);
                }
                i++;
            }
        }
    }

    private final void ensure(int bytesCount) {
        if (this.buffer.length - this.indexInBuffer < bytesCount) {
            flush();
        }
    }

    private final void writeUtf8CodePoint(int codePoint) {
        if (codePoint < 128) {
            if (this.buffer.length - this.indexInBuffer < 1) {
                flush();
            }
            byte[] bArr = this.buffer;
            int i = this.indexInBuffer;
            this.indexInBuffer = i + 1;
            bArr[i] = (byte) codePoint;
            return;
        }
        if (codePoint < 2048) {
            if (this.buffer.length - this.indexInBuffer < 2) {
                flush();
            }
            int i2 = (codePoint >> 6) | CertificateHolderAuthorization.CVCA;
            byte[] bArr2 = this.buffer;
            int i3 = this.indexInBuffer;
            int i4 = i3 + 1;
            bArr2[i3] = (byte) i2;
            this.indexInBuffer = i4 + 1;
            bArr2[i4] = (byte) ((codePoint & 63) | 128);
            return;
        }
        boolean z = false;
        if (55296 <= codePoint && codePoint < 57344) {
            z = true;
        }
        if (z) {
            if (this.buffer.length - this.indexInBuffer < 1) {
                flush();
            }
            byte[] bArr3 = this.buffer;
            int i5 = this.indexInBuffer;
            this.indexInBuffer = i5 + 1;
            bArr3[i5] = (byte) 63;
            return;
        }
        if (codePoint < 65536) {
            if (this.buffer.length - this.indexInBuffer < 3) {
                flush();
            }
            byte[] bArr4 = this.buffer;
            int i6 = this.indexInBuffer;
            int i7 = i6 + 1;
            bArr4[i6] = (byte) ((codePoint >> 12) | 224);
            int i8 = i7 + 1;
            bArr4[i7] = (byte) (((codePoint >> 6) & 63) | 128);
            this.indexInBuffer = i8 + 1;
            bArr4[i8] = (byte) ((codePoint & 63) | 128);
            return;
        }
        if (codePoint > 1114111) {
            throw new JsonEncodingException("Unexpected code point: " + codePoint);
        }
        if (this.buffer.length - this.indexInBuffer < 4) {
            flush();
        }
        byte[] bArr5 = this.buffer;
        int i9 = this.indexInBuffer;
        int i10 = i9 + 1;
        bArr5[i9] = (byte) ((codePoint >> 18) | 240);
        int i11 = i10 + 1;
        bArr5[i10] = (byte) (((codePoint >> 12) & 63) | 128);
        int i12 = i11 + 1;
        bArr5[i11] = (byte) (((codePoint >> 6) & 63) | 128);
        this.indexInBuffer = i12 + 1;
        bArr5[i12] = (byte) ((codePoint & 63) | 128);
    }
}
