package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.BuildConfig;

/* compiled from: ReaderJsonLexer.kt */
@Metadata(m4d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\u0010\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0002J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\rH\u0016J\u0018\u0010$\u001a\u00020 2\u0006\u0010#\u001a\u00020\r2\u0006\u0010%\u001a\u00020\rH\u0016J\u0018\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\rH\u0014J\u001a\u0010)\u001a\u0004\u0018\u00010 2\u0006\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020\u0013H\u0016J\u0006\u0010,\u001a\u00020\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\r8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006-"}, m5d2 = {"Lkotlinx/serialization/json/internal/ReaderJsonLexer;", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "reader", "Lkotlinx/serialization/json/internal/InternalJsonReader;", "buffer", BuildConfig.FLAVOR, "<init>", "(Lkotlinx/serialization/json/internal/InternalJsonReader;[C)V", "getReader", "()Lkotlinx/serialization/json/internal/InternalJsonReader;", "getBuffer", "()[C", "threshold", BuildConfig.FLAVOR, "source", "Lkotlinx/serialization/json/internal/ArrayAsSequence;", "getSource", "()Lkotlinx/serialization/json/internal/ArrayAsSequence;", "canConsumeValue", BuildConfig.FLAVOR, "preload", BuildConfig.FLAVOR, "unprocessedCount", "prefetchOrEof", "position", "consumeNextToken", BuildConfig.FLAVOR, "expected", BuildConfig.FLAVOR, "skipWhitespaces", "ensureHaveChars", "consumeKeyString", BuildConfig.FLAVOR, "indexOf", "char", "startPos", "substring", "endPos", "appendRange", "fromIndex", "toIndex", "peekLeadingMatchingValue", "keyToMatch", "isLenient", "release", "kotlinx-serialization-json"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class ReaderJsonLexer extends AbstractJsonLexer {
    private final char[] buffer;
    private final InternalJsonReader reader;
    private final ArrayAsSequence source;
    protected int threshold;

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String peekLeadingMatchingValue(String keyToMatch, boolean isLenient) {
        Intrinsics.checkNotNullParameter(keyToMatch, "keyToMatch");
        return null;
    }

    public final InternalJsonReader getReader() {
        return this.reader;
    }

    public /* synthetic */ ReaderJsonLexer(InternalJsonReader internalJsonReader, char[] cArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(internalJsonReader, (i & 2) != 0 ? CharArrayPoolBatchSize.INSTANCE.take() : cArr);
    }

    public final char[] getBuffer() {
        return this.buffer;
    }

    public ReaderJsonLexer(InternalJsonReader reader, char[] buffer) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.reader = reader;
        this.buffer = buffer;
        this.threshold = 128;
        this.source = new ArrayAsSequence(buffer);
        preload(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public ArrayAsSequence getSource() {
        return this.source;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean canConsumeValue() {
        ensureHaveChars();
        int i = this.currentPosition;
        while (true) {
            int prefetchOrEof = prefetchOrEof(i);
            if (prefetchOrEof != -1) {
                char charAt = getSource().charAt(prefetchOrEof);
                if (!(charAt == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t')) {
                    this.currentPosition = prefetchOrEof;
                    return isValidValueStart(charAt);
                }
                i = prefetchOrEof + 1;
            } else {
                this.currentPosition = prefetchOrEof;
                return false;
            }
        }
    }

    private final void preload(int unprocessedCount) {
        char[] buffer = getSource().getBuffer();
        if (unprocessedCount != 0) {
            ArraysKt.copyInto(buffer, buffer, 0, this.currentPosition, this.currentPosition + unprocessedCount);
        }
        int length = getSource().length();
        while (true) {
            if (unprocessedCount == length) {
                break;
            }
            int read = this.reader.read(buffer, unprocessedCount, length - unprocessedCount);
            if (read == -1) {
                getSource().trim(unprocessedCount);
                this.threshold = -1;
                break;
            }
            unprocessedCount += read;
        }
        this.currentPosition = 0;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int prefetchOrEof(int position) {
        if (position < getSource().length()) {
            return position;
        }
        this.currentPosition = position;
        ensureHaveChars();
        if (this.currentPosition == 0) {
            return getSource().length() == 0 ? -1 : 0;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte consumeNextToken() {
        ensureHaveChars();
        ArrayAsSequence source = getSource();
        int i = this.currentPosition;
        while (true) {
            int prefetchOrEof = prefetchOrEof(i);
            if (prefetchOrEof != -1) {
                int i2 = prefetchOrEof + 1;
                byte charToTokenClass = AbstractJsonLexerKt.charToTokenClass(source.charAt(prefetchOrEof));
                if (charToTokenClass != 3) {
                    this.currentPosition = i2;
                    return charToTokenClass;
                }
                i = i2;
            } else {
                this.currentPosition = prefetchOrEof;
                return (byte) 10;
            }
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public void consumeNextToken(char expected) {
        ensureHaveChars();
        ArrayAsSequence source = getSource();
        int i = this.currentPosition;
        while (true) {
            int prefetchOrEof = prefetchOrEof(i);
            if (prefetchOrEof != -1) {
                int i2 = prefetchOrEof + 1;
                char charAt = source.charAt(prefetchOrEof);
                if (!(charAt == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t')) {
                    this.currentPosition = i2;
                    if (charAt == expected) {
                        return;
                    } else {
                        unexpectedToken(expected);
                    }
                }
                i = i2;
            } else {
                this.currentPosition = prefetchOrEof;
                unexpectedToken(expected);
                return;
            }
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int skipWhitespaces() {
        int prefetchOrEof;
        int i = this.currentPosition;
        while (true) {
            prefetchOrEof = prefetchOrEof(i);
            if (prefetchOrEof != -1) {
                char charAt = getSource().charAt(prefetchOrEof);
                if (!(charAt == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t')) {
                    break;
                }
                i = prefetchOrEof + 1;
            } else {
                break;
            }
        }
        this.currentPosition = prefetchOrEof;
        return prefetchOrEof;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public void ensureHaveChars() {
        int length = getSource().length() - this.currentPosition;
        if (length > this.threshold) {
            return;
        }
        preload(length);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String consumeKeyString() {
        consumeNextToken('\"');
        int i = this.currentPosition;
        int indexOf = indexOf('\"', i);
        if (indexOf == -1) {
            int prefetchOrEof = prefetchOrEof(i);
            if (prefetchOrEof == -1) {
                AbstractJsonLexer.fail$kotlinx_serialization_json$default(this, (byte) 1, false, 2, null);
                throw new KotlinNothingValueException();
            }
            return consumeString(getSource(), this.currentPosition, prefetchOrEof);
        }
        for (int i2 = i; i2 < indexOf; i2++) {
            if (getSource().charAt(i2) == '\\') {
                return consumeString(getSource(), this.currentPosition, i2);
            }
        }
        this.currentPosition = indexOf + 1;
        return substring(i, indexOf);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int indexOf(char r4, int startPos) {
        ArrayAsSequence source = getSource();
        int length = source.length();
        while (startPos < length) {
            if (source.charAt(startPos) == r4) {
                return startPos;
            }
            startPos++;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String substring(int startPos, int endPos) {
        return getSource().substring(startPos, endPos);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    protected void appendRange(int fromIndex, int toIndex) {
        Intrinsics.checkNotNullExpressionValue(getEscapedString().append(getSource().getBuffer(), fromIndex, toIndex - fromIndex), "append(...)");
    }

    public final void release() {
        CharArrayPoolBatchSize.INSTANCE.release(this.buffer);
    }
}
