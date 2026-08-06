package com.bytedance.forest.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.forest.model.ConstantsKt;
import com.bytedance.forest.model.GeckoModel;
import com.bytedance.forest.model.URIQueryParamKeys;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: UriParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u001c\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¨\u0006\u000f"}, d2 = {"Lcom/bytedance/forest/utils/UriParser;", "", "()V", "buildRawUri", "", "channel", "bundle", "makeRelativeUri", "Landroid/net/Uri;", "path", "sourceUri", "parseChannelBundleByPrefix", "Lcom/bytedance/forest/model/GeckoModel;", "url", URIQueryParamKeys.KRY_PREFIX, "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class UriParser {
    public static final UriParser INSTANCE = new UriParser();

    private UriParser() {
    }

    public final GeckoModel parseChannelBundleByPrefix(String url, String prefix) {
        String str = url;
        String str2 = prefix;
        Intrinsics.checkParameterIsNotNull(str, "url");
        Intrinsics.checkParameterIsNotNull(str2, URIQueryParamKeys.KRY_PREFIX);
        String str3 = str;
        if (str3.length() > 0) {
            if (str2.length() > 0) {
                Integer valueOf = Integer.valueOf(StringsKt.indexOf$default(str3, '?', 0, false, 6, (Object) null));
                if (!(valueOf.intValue() != -1)) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    str = str.substring(0, valueOf.intValue());
                    Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                Integer valueOf2 = Integer.valueOf(StringsKt.indexOf$default(str, '#', 0, false, 6, (Object) null));
                if (!(valueOf2.intValue() != -1)) {
                    valueOf2 = null;
                }
                if (valueOf2 != null) {
                    int intValue = valueOf2.intValue();
                    if (str == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    str = str.substring(0, intValue);
                    Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                if (!(!TextUtils.isEmpty(StringsKt.trim(r2).toString()))) {
                    str2 = null;
                }
                if (str2 != null) {
                    if (!StringsKt.endsWith$default(str2, '/', false, 2, (Object) null)) {
                        str2 = str2 + '/';
                    }
                    Integer valueOf3 = Integer.valueOf(StringsKt.indexOf$default(str, str2, 0, false, 6, (Object) null));
                    if (!(valueOf3.intValue() != -1)) {
                        valueOf3 = null;
                    }
                    if (valueOf3 != null) {
                        int intValue2 = valueOf3.intValue() + str2.length();
                        if (str == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        String substring = str.substring(intValue2);
                        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                        Integer valueOf4 = Integer.valueOf(StringsKt.indexOf$default(substring, '/', 0, false, 6, (Object) null));
                        if (!(valueOf4.intValue() != -1)) {
                            valueOf4 = null;
                        }
                        if (valueOf4 != null) {
                            int intValue3 = valueOf4.intValue();
                            if (substring != null) {
                                String substring2 = substring.substring(0, intValue3);
                                Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                int i = intValue3 + 1;
                                if (substring != null) {
                                    String substring3 = substring.substring(i);
                                    Intrinsics.checkExpressionValueIsNotNull(substring3, "(this as java.lang.String).substring(startIndex)");
                                    if ((!StringsKt.isBlank(substring2)) && (!StringsKt.isBlank(substring3))) {
                                        return new GeckoModel("", substring2, substring3);
                                    }
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public final String buildRawUri(String channel, String bundle) {
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        if (bundle != null) {
            return bundle.length() == 0 ? channel : channel + '/' + StringsKt.removePrefix(bundle, "/");
        }
        return channel;
    }

    public static /* synthetic */ Uri makeRelativeUri$default(UriParser uriParser, String str, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            uri = null;
        }
        return uriParser.makeRelativeUri(str, uri);
    }

    public final Uri makeRelativeUri(String path, Uri sourceUri) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        Uri.Builder path2 = new Uri.Builder().scheme(ConstantsKt.SCHEME_FILE).authority(ConstantsKt.AUTHORITY_RELATIVE).path(path);
        Intrinsics.checkExpressionValueIsNotNull(path2, "Uri.Builder()\n        .s…RITY_RELATIVE).path(path)");
        Uri build = UriParserKt.appendExtraPart(path2, sourceUri).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "Uri.Builder()\n        .s…urceUri)\n        .build()");
        return build;
    }
}
