package com.bytedance.trae.utils;

import android.net.Uri;
import com.bytedance.librarian.LibrarianImpl;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TrustedDomainUtils.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/utils/TrustedDomainUtils;", "", "<init>", "()V", "TRUSTED_DOMAINS", "", "", "isTrustedUrl", "", "url", "isTrustedHost", "host", "utils_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TrustedDomainUtils {
    public static final TrustedDomainUtils INSTANCE = new TrustedDomainUtils();
    private static final List<String> TRUSTED_DOMAINS = CollectionsKt.listOf(new String[]{"trae.ai", "trae.cn"});

    private TrustedDomainUtils() {
    }

    public final boolean isTrustedUrl(String url) {
        String str;
        String host;
        String str2 = url;
        if (str2 == null || str2.length() == 0) {
            return false;
        }
        try {
            Uri parse = Uri.parse(url);
            String scheme = parse.getScheme();
            if (scheme != null) {
                str = scheme.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(str, "https") || (host = parse.getHost()) == null) {
                return false;
            }
            String lowerCase = host.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase == null) {
                return false;
            }
            return isTrustedHost(lowerCase);
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean isTrustedHost(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        String lowerCase = host.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List<String> list = TRUSTED_DOMAINS;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (String str : list) {
            if (Intrinsics.areEqual(lowerCase, str) || StringsKt.endsWith$default(lowerCase, new StringBuilder(LibrarianImpl.Constants.DOT).append(str).toString(), false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }
}
