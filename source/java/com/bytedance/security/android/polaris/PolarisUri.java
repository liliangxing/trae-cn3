package com.bytedance.security.android.polaris;

import android.net.Uri;
import com.bytedance.librarian.LibrarianImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: PolarisUri.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0007J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0007J\u001e\u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0007J\u001e\u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/security/android/polaris/PolarisUri;", "", "()V", "NOT_FOUND", "", "findPortSeparator", "authority", "", "getActualHost", "uri", "Landroid/net/Uri;", "isHostInAllowedList", "", "host", "allowList", "", "isUriInAllowList", "parseHost", "polaris_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class PolarisUri {
    public static final PolarisUri INSTANCE = new PolarisUri();
    private static final int NOT_FOUND = -1;

    private PolarisUri() {
    }

    @JvmStatic
    public static final boolean isUriInAllowList(String uri, List<String> allowList) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(allowList, "allowList");
        Uri parse = Uri.parse(uri);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(uri)");
        return isUriInAllowList(parse, allowList);
    }

    @JvmStatic
    public static final boolean isUriInAllowList(Uri uri, List<String> allowList) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(allowList, "allowList");
        boolean z = true;
        if ((!Intrinsics.areEqual(uri.getScheme(), "http")) && (!Intrinsics.areEqual(uri.getScheme(), "https"))) {
            return false;
        }
        String actualHost = getActualHost(uri);
        String str = actualHost;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            return false;
        }
        return isHostInAllowedList(actualHost, allowList);
    }

    @JvmStatic
    public static final String getActualHost(Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Uri finalUri = uri.isHierarchical() ? Uri.parse(uri.toString()) : uri;
        Intrinsics.checkExpressionValueIsNotNull(finalUri, "finalUri");
        String host = finalUri.getHost();
        if (host != null) {
            Intrinsics.checkExpressionValueIsNotNull(host, "finalUri.host ?: return null");
            String encodedAuthority = finalUri.getEncodedAuthority();
            if (encodedAuthority != null) {
                Intrinsics.checkExpressionValueIsNotNull(encodedAuthority, "finalUri.encodedAuthority ?: return null");
                String str = encodedAuthority;
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i >= str.length()) {
                        break;
                    }
                    if (str.charAt(i) == '@') {
                        i2++;
                    }
                    i++;
                }
                if (i2 <= 1 || (host = INSTANCE.parseHost(uri)) != null) {
                    return StringsKt.contains$default((CharSequence) host, AbstractJsonLexerKt.STRING_ESC, false, 2, (Object) null) ? StringsKt.substringBefore$default(host, AbstractJsonLexerKt.STRING_ESC, (String) null, 2, (Object) null) : host;
                }
                return null;
            }
        }
        return null;
    }

    @JvmStatic
    public static final String getActualHost(String uri) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Uri parse = Uri.parse(uri);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(uri)");
        return getActualHost(parse);
    }

    @JvmStatic
    public static final boolean isHostInAllowedList(String host, List<String> allowList) {
        Intrinsics.checkParameterIsNotNull(host, "host");
        Intrinsics.checkParameterIsNotNull(allowList, "allowList");
        for (String str : allowList) {
            if (!(str.length() == 0)) {
                if (Intrinsics.areEqual(str, host)) {
                    return true;
                }
                if (StringsKt.startsWith$default(str, LibrarianImpl.Constants.DOT, false, 2, (Object) null)) {
                    if (StringsKt.endsWith$default(host, str, false, 2, (Object) null)) {
                        return true;
                    }
                } else if (StringsKt.endsWith$default(host, LibrarianImpl.Constants.DOT + str, false, 2, (Object) null)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final String parseHost(Uri uri) {
        String substring;
        String encodedAuthority = uri.getEncodedAuthority();
        if (encodedAuthority == null) {
            return null;
        }
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) encodedAuthority, '@', 0, false, 6, (Object) null);
        int findPortSeparator = findPortSeparator(encodedAuthority);
        if (findPortSeparator == -1) {
            int i = lastIndexOf$default + 1;
            if (encodedAuthority == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            substring = encodedAuthority.substring(i);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
        } else {
            int i2 = lastIndexOf$default + 1;
            if (encodedAuthority != null) {
                substring = encodedAuthority.substring(i2, findPortSeparator);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        }
        return Uri.decode(substring);
    }

    private final int findPortSeparator(String authority) {
        if (authority == null) {
            return -1;
        }
        for (int length = authority.length() - 1; length >= 0; length--) {
            char charAt = authority.charAt(length);
            if (':' == charAt) {
                return length;
            }
            if (charAt < '0' || charAt > '9') {
                break;
            }
        }
        return -1;
    }
}
