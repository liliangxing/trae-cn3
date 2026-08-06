package com.bytedance.rts.foundation;

import com.bytedance.pia.core.misc.UrlMatcher;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: URI.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u000e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u000e\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u000e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001¨\u0006\t"}, d2 = {"decodeURI", "", "encodedURI", "decodeURIComponent", "encodedURIComponent", "encodeURI", "uri", "encodeURIComponent", "uriComponent", "lib_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class URIKt {
    public static final String encodeURIComponent(String str) {
        Intrinsics.checkNotNullParameter(str, "uriComponent");
        String encode = URLEncoder.encode(str, StandardCharsets.UTF_8.name());
        Intrinsics.checkNotNullExpressionValue(encode, "encode(uriComponent, Sta…ardCharsets.UTF_8.name())");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(encode, "+", "%20", false, 4, (Object) null), UrlMatcher.WILDCARD, "%2A", false, 4, (Object) null), "%7E", "~", false, 4, (Object) null);
    }

    public static final String decodeURIComponent(String str) {
        Intrinsics.checkNotNullParameter(str, "encodedURIComponent");
        String decode = URLDecoder.decode(str, StandardCharsets.UTF_8.name());
        Intrinsics.checkNotNullExpressionValue(decode, "decode(encodedURICompone…ardCharsets.UTF_8.name())");
        return decode;
    }

    public static final String encodeURI(String str) {
        Intrinsics.checkNotNullParameter(str, "uri");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(encodeURIComponent(str), "%3A", ":", false, 4, (Object) null), "%2F", "/", false, 4, (Object) null), "%3F", "?", false, 4, (Object) null), "%23", "#", false, 4, (Object) null), "%5B", "[", false, 4, (Object) null), "%5D", "]", false, 4, (Object) null), "%40", "@", false, 4, (Object) null), "%21", "!", false, 4, (Object) null), "%24", "$", false, 4, (Object) null), "%26", "&", false, 4, (Object) null), "%27", "'", false, 4, (Object) null), "%28", "(", false, 4, (Object) null), "%29", ")", false, 4, (Object) null), "%2A", UrlMatcher.WILDCARD, false, 4, (Object) null), "%2B", "+", false, 4, (Object) null), "%2C", ",", false, 4, (Object) null), "%3B", ";", false, 4, (Object) null), "%3D", "=", false, 4, (Object) null);
    }

    public static final String decodeURI(String str) {
        Intrinsics.checkNotNullParameter(str, "encodedURI");
        return decodeURIComponent(str);
    }
}
