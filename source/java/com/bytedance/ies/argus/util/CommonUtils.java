package com.bytedance.ies.argus.util;

import android.net.Uri;
import com.bytedance.applog.server.Api;
import com.bytedance.ies.argus.bean.ArgusSwitch;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Deferred;

/* compiled from: CommonUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0001J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J#\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0014J'\u0010\u0015\u001a\u00020\u00102\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u0018J\u000e\u0010\u0019\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u0006J\f\u0010\u001a\u001a\u0004\u0018\u00010\u0006*\u00020\u001bJ\u0012\u0010\u001c\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006J\u0018\u0010\u001e\u001a\u00020\u0010*\u00020\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012J\u0012\u0010 \u001a\u00020\u0010*\u00020\u00062\u0006\u0010!\u001a\u00020\u0006J\u0014\u0010\"\u001a\u0004\u0018\u00010\u0006*\u00020\u001b2\u0006\u0010#\u001a\u00020\u0006J\u000e\u0010$\u001a\u00020\u0010*\u0006\u0012\u0002\b\u00030%J\u0014\u0010&\u001a\u00020\u0010*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030%0\u0012J\f\u0010'\u001a\u0004\u0018\u00010\u0006*\u00020\u0006J\u0011\u0010(\u001a\u00020)*\u0004\u0018\u00010*¢\u0006\u0002\u0010+R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ies/argus/util/CommonUtils;", "", "()V", "ASYNC_EVENT_DEFAULT_AWAIT_TIMEOUT", "", "getHostByUrl", "", "url", "getObjectId", "obj", "getParentHostBaseHost", "domain", "getParentHostBaseUrl", "removeFragment", "removeQuery", "verifyDecodeUrl", "", "safeUrls", "", "remoteUrl", "verifyDecodeUrl$anniex_release", "verifyUrl", "matchUrlList", "toVerifyUrl", "verifyUrl$anniex_release", "clearQueryAndFragment", "getCDN", "Landroid/net/Uri;", "matchPlainHost", "host", "matchPlainHostList", "hostList", "matchReg", "reg", "safeGetQueryParameter", Api.KEY_ENCRYPT_RESP_KEY, "safelyAwait", "Lkotlinx/coroutines/Deferred;", "safelyAwaitAll", "toMD5", "toSwitch", "Lcom/bytedance/ies/argus/bean/ArgusSwitch;", "", "(Ljava/lang/Integer;)Lcom/bytedance/ies/argus/bean/ArgusSwitch;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class CommonUtils {
    private static final long ASYNC_EVENT_DEFAULT_AWAIT_TIMEOUT = 3000;
    public static final CommonUtils INSTANCE = new CommonUtils();

    private CommonUtils() {
    }

    public final String getObjectId(Object obj) {
        Object obj2;
        Intrinsics.checkNotNullParameter(obj, "obj");
        try {
            Result.Companion companion = Result.Companion;
            obj2 = Result.constructor-impl(String.valueOf(System.identityHashCode(obj)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj2)) {
            obj2 = null;
        }
        return (String) obj2;
    }

    public final String removeFragment(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return StringsKt.substringBefore$default(url, '#', (String) null, 2, (Object) null);
    }

    public final String toMD5(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            byte[] digest = messageDigest.digest(bytes);
            Intrinsics.checkNotNullExpressionValue(digest, "digest");
            return ArraysKt.joinToString$default(digest, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<Byte, CharSequence>() { // from class: com.bytedance.ies.argus.util.CommonUtils$toMD5$1
                public final CharSequence invoke(byte b) {
                    String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(this, *args)");
                    return format;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).byteValue());
                }
            }, 30, (Object) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public final boolean matchReg(String str, String str2) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "reg");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Boolean.valueOf(Pattern.compile(str2).matcher(str).find()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = false;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final ArgusSwitch toSwitch(Integer num) {
        return new ArgusSwitch(num);
    }

    public final String getCDN(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        if (Intrinsics.areEqual(uri.getScheme(), "http") || Intrinsics.areEqual(uri.getScheme(), "https")) {
            return uri.toString();
        }
        String safeGetQueryParameter = safeGetQueryParameter(uri, "a_surl");
        if (safeGetQueryParameter != null) {
            return safeGetQueryParameter;
        }
        String safeGetQueryParameter2 = safeGetQueryParameter(uri, "surl");
        return safeGetQueryParameter2 == null ? safeGetQueryParameter(uri, "url") : safeGetQueryParameter2;
    }

    public final String safeGetQueryParameter(Uri uri, String str) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(str, Api.KEY_ENCRYPT_RESP_KEY);
        try {
            return uri.getQueryParameter(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String getParentHostBaseHost(String domain) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        List split$default = StringsKt.split$default(domain, new String[]{"."}, false, 0, 6, (Object) null);
        if (split$default.size() > 2) {
            return CollectionsKt.joinToString$default(CollectionsKt.drop(split$default, 1), ".", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        return null;
    }

    public final String getParentHostBaseUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String hostByUrl = getHostByUrl(url);
        if (hostByUrl != null) {
            return INSTANCE.getParentHostBaseHost(hostByUrl);
        }
        return null;
    }

    public final String removeQuery(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        int indexOf$default = StringsKt.indexOf$default(url, '?', 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return url;
        }
        String substring = url.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean verifyDecodeUrl$anniex_release(List<String> safeUrls, String remoteUrl) {
        String str;
        Intrinsics.checkNotNullParameter(safeUrls, "safeUrls");
        Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
        try {
            Result.Companion companion = Result.Companion;
            CommonUtils commonUtils = this;
            str = Result.constructor-impl(URLDecoder.decode(remoteUrl, Charsets.UTF_8.name()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            str = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(str) == null) {
            remoteUrl = str;
        }
        return verifyUrl$anniex_release(safeUrls, remoteUrl);
    }

    public final boolean verifyUrl$anniex_release(List<String> matchUrlList, String toVerifyUrl) {
        if (matchUrlList == null || toVerifyUrl == null) {
            return false;
        }
        List<String> list = matchUrlList;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (INSTANCE.matchReg(toVerifyUrl, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean safelyAwait(Deferred<?> deferred) {
        Intrinsics.checkNotNullParameter(deferred, "<this>");
        return ((Boolean) BuildersKt.runBlocking$default((CoroutineContext) null, new CommonUtils$safelyAwait$1(deferred, null), 1, (Object) null)).booleanValue();
    }

    public final boolean safelyAwaitAll(List<? extends Deferred<?>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return ((Boolean) BuildersKt.runBlocking$default((CoroutineContext) null, new CommonUtils$safelyAwaitAll$1(list, null), 1, (Object) null)).booleanValue();
    }

    public final String clearQueryAndFragment(String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        int indexOf$default = StringsKt.indexOf$default(str2, "?", 0, false, 6, (Object) null);
        int indexOf$default2 = StringsKt.indexOf$default(str2, "#", 0, false, 6, (Object) null);
        if (indexOf$default == -1 && indexOf$default2 == -1) {
            return str;
        }
        if (indexOf$default == -1) {
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = str.substring(0, indexOf$default2);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        if (indexOf$default2 == -1) {
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String substring2 = str.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring2;
        }
        int min = Integer.min(indexOf$default, indexOf$default2);
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring3 = str.substring(0, min);
        Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring3;
    }

    public final boolean matchPlainHostList(String str, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(list, "hostList");
        List<String> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            if (INSTANCE.matchPlainHost(str, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean matchPlainHost(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "host");
        if (StringsKt.startsWith$default(str2, ".", false, 2, (Object) null)) {
            return StringsKt.endsWith$default(str, str2, false, 2, (Object) null);
        }
        return Intrinsics.areEqual(str2, str);
    }

    public final String getHostByUrl(String url) {
        if (url == null) {
            return null;
        }
        try {
            Uri parse = Uri.parse(url);
            Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
            if (parse != null) {
                return parse.getHost();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
