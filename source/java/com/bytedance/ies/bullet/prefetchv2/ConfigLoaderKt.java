package com.bytedance.ies.bullet.prefetchv2;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ConfigLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a0\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u001a\u0012\u0010\b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005\u001a\u0012\u0010\n\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"loadConfig", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchConfig;", "uri", "Landroid/net/Uri;", "business", "", "bid", "identifierUrl", "bundleReplace", "suffix", "suffixReplace", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ConfigLoaderKt {
    public static /* synthetic */ PrefetchConfig loadConfig$default(Uri uri, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "default_bid";
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        return loadConfig(uri, str, str2, str3);
    }

    public static final PrefetchConfig loadConfig(Uri uri, String str, String str2, String str3) {
        PrefetchConfig loadConfig;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(str2, "bid");
        PrefetchProcessor processor = ProcessorManager.INSTANCE.getProcessor(str);
        ConfigLoader provideConfigLoader = processor != null ? processor.provideConfigLoader() : null;
        return (provideConfigLoader == null || (loadConfig = provideConfigLoader.loadConfig(uri, str2, str3)) == null) ? InternalConfigLoader.INSTANCE.loadConfig(uri, str2, str3) : loadConfig;
    }

    public static final String bundleReplace(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "suffix");
        return !StringsKt.contains$default(str, "/", false, 2, (Object) null) ? str2 : suffixReplace(str, str2);
    }

    public static final String suffixReplace(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "suffix");
        String str3 = str;
        if (str3.length() == 0) {
            return str2;
        }
        int lastIndexOf$default = StringsKt.lastIndexOf$default(str3, "://", 0, false, 6, (Object) null);
        int lastIndexOf$default2 = StringsKt.lastIndexOf$default(str3, '/', 0, false, 6, (Object) null);
        if (lastIndexOf$default2 < 0) {
            return str + '/' + str2;
        }
        if (lastIndexOf$default + 2 == lastIndexOf$default2 && lastIndexOf$default >= 0) {
            return str + '/' + str2;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, lastIndexOf$default2);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return sb.append(substring).append('/').append(str2).toString();
    }
}
