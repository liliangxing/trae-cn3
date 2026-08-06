package com.bytedance.android.monitorV2.util;

import android.net.Uri;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: UrlUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/monitorV2/util/UrlUtil;", "", "()V", "formatUrlRegex", "", "formattedUrlRegex", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getFormatUrl", "fullUrl", "getHost", "url", "getPath", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class UrlUtil {
    public static final UrlUtil INSTANCE = new UrlUtil();
    private static final String formatUrlRegex = "/(data|user|local_file)/.+?/([^\\/]+?)/\\d{5}\\d+/res/([^?]+)";
    private static final Pattern formattedUrlRegex = Pattern.compile(formatUrlRegex);

    private UrlUtil() {
    }

    public final String getPath(String url) {
        try {
            Uri parse = Uri.parse(url);
            if (parse != null) {
                String path = parse.getPath();
                if (path != null) {
                    return path;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public final String getHost(String url) {
        try {
            Uri parse = Uri.parse(url);
            if (parse != null) {
                String host = parse.getHost();
                if (host != null) {
                    return host;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getFormatUrl(String fullUrl) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(fullUrl, "fullUrl");
        try {
            Result.Companion companion = Result.Companion;
            if (StringsKt.startsWith$default(fullUrl, "http", false, 2, (Object) null)) {
                fullUrl = CollectionsKt.first(StringsKt.split$default(fullUrl, new String[]{"?"}, false, 0, 6, (Object) null));
            } else {
                boolean startsWith$default = StringsKt.startsWith$default(fullUrl, "/data", false, 2, (Object) null);
                fullUrl = fullUrl;
                if (startsWith$default) {
                    Matcher matcher = formattedUrlRegex.matcher(fullUrl);
                    if (matcher.find()) {
                        str2 = matcher.group(2);
                        Intrinsics.checkNotNullExpressionValue(str2, "matcher.group(2)");
                        str3 = matcher.group(3);
                        Intrinsics.checkNotNullExpressionValue(str3, "matcher.group(3)");
                    } else {
                        str2 = "";
                        str3 = "";
                    }
                    fullUrl = fullUrl;
                    if (!StringsKt.isBlank(str2)) {
                        fullUrl = fullUrl;
                        if (!StringsKt.isBlank(str3)) {
                            fullUrl = "lynxview://" + str2 + '/' + str3;
                        }
                    }
                }
            }
            Result.constructor-impl(Unit.INSTANCE);
            str = fullUrl;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            str = fullUrl;
        }
        return str;
    }
}
