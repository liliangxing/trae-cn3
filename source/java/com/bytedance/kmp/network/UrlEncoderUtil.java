package com.bytedance.kmp.network;

import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: UrlEncoderUtil.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bJ\u001a\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007J$\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u000fH\u0007J\u0018\u0010\u0013\u001a\u00020\u0014*\u00060\u0015j\u0002`\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u0014*\u00060\u0015j\u0002`\u00162\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J\u001c\u0010\u001b\u001a\u00020\u0018*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\f\u0010\u001f\u001a\u00020\u000f*\u00020\u001eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/kmp/network/UrlEncoderUtil;", "", "()V", "hexDigits", "", "unreservedChars", "", "appendUnEncodedQueryToUrl", "", "originalUrl", "queryMap", "", "decode", EventConstants.PARAM_SOURCE, "plusToSpace", "", "encode", SccResult.LABEL_ALLOW, "spaceToPlus", "appendEncodedByte", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "ch", "", "appendEncodedDigit", "digit", "codePointAtOrChar", "index", "firstChar", "", "isUnreserved", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UrlEncoderUtil {
    public static final UrlEncoderUtil INSTANCE = new UrlEncoderUtil();
    private static final char[] hexDigits;
    private static final boolean[] unreservedChars;

    @JvmStatic
    public static final String decode(String str) {
        Intrinsics.checkNotNullParameter(str, EventConstants.PARAM_SOURCE);
        return decode$default(str, false, 2, null);
    }

    @JvmStatic
    public static final String encode(String str) {
        Intrinsics.checkNotNullParameter(str, EventConstants.PARAM_SOURCE);
        return encode$default(str, null, false, 6, null);
    }

    @JvmStatic
    public static final String encode(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, EventConstants.PARAM_SOURCE);
        Intrinsics.checkNotNullParameter(str2, SccResult.LABEL_ALLOW);
        return encode$default(str, str2, false, 4, null);
    }

    private UrlEncoderUtil() {
    }

    static {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        hexDigits = charArray;
        boolean[] zArr = new boolean[123];
        zArr[45] = true;
        zArr[46] = true;
        zArr[95] = true;
        for (char c = '0'; c < ':'; c = (char) (c + 1)) {
            zArr[c] = true;
        }
        for (char c2 = 'A'; c2 < '['; c2 = (char) (c2 + 1)) {
            zArr[c2] = true;
        }
        for (char c3 = 'a'; c3 < '{'; c3 = (char) (c3 + 1)) {
            zArr[c3] = true;
        }
        unreservedChars = zArr;
    }

    private final boolean isUnreserved(char c) {
        return Intrinsics.compare(c, 122) <= 0 && unreservedChars[c];
    }

    private final void appendEncodedDigit(StringBuilder sb, int i) {
        sb.append(hexDigits[i & 15]);
    }

    private final void appendEncodedByte(StringBuilder sb, int i) {
        sb.append("%");
        appendEncodedDigit(sb, i >> 4);
        appendEncodedDigit(sb, i);
    }

    public static /* synthetic */ String decode$default(String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return decode(str, z);
    }

    @JvmStatic
    public static final String decode(String source, boolean plusToSpace) {
        Intrinsics.checkNotNullParameter(source, EventConstants.PARAM_SOURCE);
        String str = source;
        if (str.length() == 0) {
            return source;
        }
        int length = source.length();
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        int i2 = 0;
        boolean z = false;
        byte[] bArr = null;
        while (i < length) {
            char charAt = source.charAt(i);
            if (charAt == '%') {
                if (!z) {
                    sb.append((CharSequence) str, 0, i);
                    z = true;
                }
                if (bArr == null) {
                    bArr = new byte[(length - i) / 3];
                }
                int i3 = i + 1;
                int i4 = i3 + 2;
                if (!(length >= i4)) {
                    throw new IllegalArgumentException(("Incomplete trailing escape (" + charAt + ") pattern").toString());
                }
                try {
                    String substring = source.substring(i3, i4);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    int parseInt = Integer.parseInt(substring, CharsKt.checkRadix(16));
                    if (!(parseInt >= 0 && parseInt < 256)) {
                        throw new IllegalArgumentException("Illegal escape value".toString());
                    }
                    bArr[i2] = (byte) parseInt;
                    i = i4;
                    i2++;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Illegal characters in escape sequence: " + e + ".message", e);
                }
            } else {
                if (bArr != null) {
                    sb.append(StringsKt.decodeToString$default(bArr, 0, i2, false, 4, (Object) null));
                    z = true;
                    i2 = 0;
                    bArr = null;
                }
                if (plusToSpace && charAt == '+') {
                    if (!z) {
                        sb.append((CharSequence) str, 0, i);
                        z = true;
                    }
                    sb.append(" ");
                } else if (z) {
                    sb.append(charAt);
                }
                i++;
            }
        }
        if (bArr != null) {
            sb.append(StringsKt.decodeToString$default(bArr, 0, i2, false, 4, (Object) null));
        }
        if (!z) {
            return source;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "out.toString()");
        return sb2;
    }

    public static /* synthetic */ String encode$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return encode(str, str2, z);
    }

    @JvmStatic
    public static final String encode(String source, String allow, boolean spaceToPlus) {
        Intrinsics.checkNotNullParameter(source, EventConstants.PARAM_SOURCE);
        Intrinsics.checkNotNullParameter(allow, SccResult.LABEL_ALLOW);
        String str = source;
        if (str.length() == 0) {
            return source;
        }
        StringBuilder sb = null;
        int i = 0;
        while (i < source.length()) {
            char charAt = source.charAt(i);
            UrlEncoderUtil urlEncoderUtil = INSTANCE;
            if (!urlEncoderUtil.isUnreserved(charAt) && !StringsKt.contains$default(allow, charAt, false, 2, (Object) null)) {
                if (sb == null) {
                    sb = new StringBuilder(source.length());
                    sb.append((CharSequence) str, 0, i);
                }
                int codePointAtOrChar = urlEncoderUtil.codePointAtOrChar(source, i, charAt);
                if (codePointAtOrChar < 128) {
                    if (spaceToPlus && charAt == ' ') {
                        sb.append('+');
                    } else {
                        urlEncoderUtil.appendEncodedByte(sb, codePointAtOrChar);
                    }
                } else if (Character.INSTANCE.isSupplementaryCodePoint$network_service_release(codePointAtOrChar)) {
                    int i2 = i + 2;
                    String substring = source.substring(i, i2);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    for (byte b : StringsKt.encodeToByteArray(substring)) {
                        INSTANCE.appendEncodedByte(sb, b);
                    }
                    i = i2;
                } else {
                    for (byte b2 : StringsKt.encodeToByteArray(String.valueOf(charAt))) {
                        INSTANCE.appendEncodedByte(sb, b2);
                    }
                }
            } else if (sb != null) {
                sb.append(charAt);
            }
            i++;
        }
        String sb2 = sb != null ? sb.toString() : null;
        return sb2 == null ? source : sb2;
    }

    private final int codePointAtOrChar(String str, int i, char c) {
        int i2;
        if (java.lang.Character.isHighSurrogate(c) && (i2 = i + 1) < str.length()) {
            char charAt = str.charAt(i2);
            if (java.lang.Character.isLowSurrogate(charAt)) {
                return Character.INSTANCE.toCodePoint$network_service_release(c, charAt);
            }
        }
        return c;
    }

    public final String appendUnEncodedQueryToUrl(String originalUrl, Map<String, String> queryMap) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(originalUrl, "originalUrl");
        if (queryMap == null || queryMap.isEmpty()) {
            return originalUrl;
        }
        List list = CollectionsKt.toList(queryMap.entrySet());
        if (list.isEmpty()) {
            return originalUrl;
        }
        int indexOf$default = StringsKt.indexOf$default(originalUrl, '#', 0, false, 6, (Object) null);
        if (indexOf$default >= 0) {
            str2 = originalUrl.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
            str = originalUrl.substring(indexOf$default);
            Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
        } else {
            str = "";
            str2 = originalUrl;
        }
        StringBuilder sb = new StringBuilder(originalUrl.length() + (list.size() * 16));
        sb.append(str2);
        if (!StringsKt.endsWith$default(str2, "?", false, 2, (Object) null) && !StringsKt.endsWith$default(str2, "&", false, 2, (Object) null)) {
            if (StringsKt.contains$default(str2, '?', false, 2, (Object) null)) {
                sb.append('&');
            } else {
                sb.append('?');
            }
        }
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Map.Entry entry = (Map.Entry) obj;
            if (i > 0) {
                sb.append('&');
            }
            sb.append(encode$default((String) entry.getKey(), null, false, 6, null));
            sb.append('=');
            sb.append(encode$default((String) entry.getValue(), null, false, 6, null));
            i = i2;
        }
        if (str.length() > 0) {
            sb.append(str);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "out.toString()");
        return sb2;
    }
}
