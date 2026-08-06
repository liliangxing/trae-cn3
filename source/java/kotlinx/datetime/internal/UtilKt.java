package kotlinx.datetime.internal;

import kotlin.Metadata;

/* compiled from: util.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0000¨\u0006\u0005"}, d2 = {"isAsciiDigit", "", "", "asciiDigitToInt", "", "kotlinx-datetime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class UtilKt {
    public static final int asciiDigitToInt(char c) {
        return c - '0';
    }

    public static final boolean isAsciiDigit(char c) {
        return '0' <= c && c < ':';
    }
}
