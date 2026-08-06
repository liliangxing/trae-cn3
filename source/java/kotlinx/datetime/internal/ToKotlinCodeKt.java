package kotlinx.datetime.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: toKotlinCode.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\f\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toKotlinCode", "", "", "kotlinx-datetime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ToKotlinCodeKt {
    public static final String toKotlinCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\"') {
                sb.append("\\\"");
            } else if (charAt == '\\') {
                sb.append("\\\\");
            } else if (charAt == '\b') {
                sb.append("\\b");
            } else if (charAt == '\t') {
                sb.append("\\t");
            } else if (charAt == '\n') {
                sb.append("\\n");
            } else if (charAt == '\r') {
                sb.append("\\r");
            } else {
                sb.append(charAt);
            }
        }
        sb.append('\"');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public static final String toKotlinCode(char c) {
        return c == '\'' ? "'\\''" : "'" + c + '\'';
    }
}
