package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.openid.appauth.BuildConfig;

/* compiled from: CommentLexers.kt */
@Metadata(m4d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\b\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\u00112\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0016¨\u0006\u0016"}, m5d2 = {"Lkotlinx/serialization/json/internal/ReaderJsonLexerWithComments;", "Lkotlinx/serialization/json/internal/ReaderJsonLexer;", "reader", "Lkotlinx/serialization/json/internal/InternalJsonReader;", "buffer", BuildConfig.FLAVOR, "<init>", "(Lkotlinx/serialization/json/internal/InternalJsonReader;[C)V", "consumeNextToken", BuildConfig.FLAVOR, "expected", BuildConfig.FLAVOR, "canConsumeValue", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "peekNextToken", "handleComment", "Lkotlin/Pair;", BuildConfig.FLAVOR, "position", "prefetchWithinThreshold", "skipWhitespaces", "kotlinx-serialization-json"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ReaderJsonLexerWithComments extends ReaderJsonLexer {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReaderJsonLexerWithComments(InternalJsonReader reader, char[] buffer) {
        super(reader, buffer);
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
    }

    @Override // kotlinx.serialization.json.internal.ReaderJsonLexer, kotlinx.serialization.json.internal.AbstractJsonLexer
    public void consumeNextToken(char expected) {
        ensureHaveChars();
        ArrayAsSequence source = getSource();
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces >= source.length() || skipWhitespaces == -1) {
            this.currentPosition = -1;
            unexpectedToken(expected);
        }
        char charAt = source.charAt(skipWhitespaces);
        this.currentPosition = skipWhitespaces + 1;
        if (charAt == expected) {
            return;
        }
        unexpectedToken(expected);
    }

    @Override // kotlinx.serialization.json.internal.ReaderJsonLexer, kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean canConsumeValue() {
        ensureHaveChars();
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces >= getSource().length() || skipWhitespaces == -1) {
            return false;
        }
        return isValidValueStart(getSource().charAt(skipWhitespaces));
    }

    @Override // kotlinx.serialization.json.internal.ReaderJsonLexer, kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte consumeNextToken() {
        ensureHaveChars();
        ArrayAsSequence source = getSource();
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces >= source.length() || skipWhitespaces == -1) {
            return (byte) 10;
        }
        this.currentPosition = skipWhitespaces + 1;
        return AbstractJsonLexerKt.charToTokenClass(source.charAt(skipWhitespaces));
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte peekNextToken() {
        ensureHaveChars();
        ArrayAsSequence source = getSource();
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces >= source.length() || skipWhitespaces == -1) {
            return (byte) 10;
        }
        this.currentPosition = skipWhitespaces;
        return AbstractJsonLexerKt.charToTokenClass(source.charAt(skipWhitespaces));
    }

    private final Pair<Integer, Boolean> handleComment(int position) {
        int i = position + 2;
        char charAt = getSource().charAt(position + 1);
        if (charAt == '/') {
            int i2 = i;
            while (position != -1) {
                int indexOf$default = StringsKt.indexOf$default((CharSequence) getSource(), '\n', i2, false, 4, (Object) null);
                if (indexOf$default == -1) {
                    i2 = prefetchOrEof(getSource().length());
                    position = i2;
                } else {
                    return TuplesKt.m12to(Integer.valueOf(indexOf$default + 1), true);
                }
            }
            return TuplesKt.m12to(-1, true);
        }
        boolean z = false;
        if (charAt == '*') {
            int i3 = i;
            while (position != -1) {
                int indexOf$default2 = StringsKt.indexOf$default((CharSequence) getSource(), "*/", i3, false, 4, (Object) null);
                if (indexOf$default2 != -1) {
                    return TuplesKt.m12to(Integer.valueOf(indexOf$default2 + 2), true);
                }
                if (getSource().charAt(getSource().length() - 1) != '*') {
                    i3 = prefetchOrEof(getSource().length());
                } else {
                    i3 = prefetchWithinThreshold(getSource().length() - 1);
                    if (z) {
                        break;
                    }
                    z = true;
                }
                position = i3;
            }
            this.currentPosition = getSource().length();
            AbstractJsonLexer.fail$default(this, "Expected end of the block comment: \"*/\", but had EOF instead", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        return TuplesKt.m12to(Integer.valueOf(position), false);
    }

    private final int prefetchWithinThreshold(int position) {
        if (getSource().length() - position > this.threshold) {
            return position;
        }
        this.currentPosition = position;
        ensureHaveChars();
        if (this.currentPosition == 0) {
            return getSource().length() == 0 ? -1 : 0;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.ReaderJsonLexer, kotlinx.serialization.json.internal.AbstractJsonLexer
    public int skipWhitespaces() {
        int prefetchOrEof;
        int i = this.currentPosition;
        while (true) {
            prefetchOrEof = prefetchOrEof(i);
            if (prefetchOrEof != -1) {
                char charAt = getSource().charAt(prefetchOrEof);
                if (!(charAt == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t')) {
                    if (charAt != '/' || prefetchOrEof + 1 >= getSource().length()) {
                        break;
                    }
                    Pair<Integer, Boolean> handleComment = handleComment(prefetchOrEof);
                    int intValue = handleComment.component1().intValue();
                    if (!handleComment.component2().booleanValue()) {
                        prefetchOrEof = intValue;
                        break;
                    }
                    i = intValue;
                } else {
                    i = prefetchOrEof + 1;
                }
            } else {
                break;
            }
        }
        this.currentPosition = prefetchOrEof;
        return prefetchOrEof;
    }
}
