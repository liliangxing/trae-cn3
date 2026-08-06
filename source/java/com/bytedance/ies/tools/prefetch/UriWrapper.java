package com.bytedance.ies.tools.prefetch;

import android.net.Uri;
import java.net.URLDecoder;
import java.util.List;
import java.util.SortedMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* compiled from: UriWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001b\u0010\u0005\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R'\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/UriWrapper;", "", "url", "", "(Ljava/lang/String;)V", "hash", "getHash", "()Ljava/lang/String;", "hash$delegate", "Lkotlin/Lazy;", "host", "getHost", "host$delegate", "queryMap", "Ljava/util/SortedMap;", "getQueryMap", "()Ljava/util/SortedMap;", "queryMap$delegate", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "uri$delegate", "getUrl", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UriWrapper {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(UriWrapper.class), "uri", "getUri()Landroid/net/Uri;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(UriWrapper.class), "host", "getHost()Ljava/lang/String;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(UriWrapper.class), "queryMap", "getQueryMap()Ljava/util/SortedMap;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(UriWrapper.class), "hash", "getHash()Ljava/lang/String;"))};

    /* renamed from: hash$delegate, reason: from kotlin metadata */
    private final Lazy hash;

    /* renamed from: host$delegate, reason: from kotlin metadata */
    private final Lazy host;

    /* renamed from: queryMap$delegate, reason: from kotlin metadata */
    private final Lazy queryMap;

    /* renamed from: uri$delegate, reason: from kotlin metadata */
    private final Lazy uri;
    private final String url;

    public final String getHash() {
        Lazy lazy = this.hash;
        KProperty kProperty = $$delegatedProperties[3];
        return (String) lazy.getValue();
    }

    public final String getHost() {
        Lazy lazy = this.host;
        KProperty kProperty = $$delegatedProperties[1];
        return (String) lazy.getValue();
    }

    public final SortedMap<String, String> getQueryMap() {
        Lazy lazy = this.queryMap;
        KProperty kProperty = $$delegatedProperties[2];
        return (SortedMap) lazy.getValue();
    }

    public final Uri getUri() {
        Lazy lazy = this.uri;
        KProperty kProperty = $$delegatedProperties[0];
        return (Uri) lazy.getValue();
    }

    public UriWrapper(String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        this.url = str;
        this.uri = LazyKt.lazy(new Function0<Uri>() { // from class: com.bytedance.ies.tools.prefetch.UriWrapper$uri$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Uri m628invoke() {
                return Uri.parse(UriWrapper.this.getUrl());
            }
        });
        this.host = LazyKt.lazy(new Function0<String>() { // from class: com.bytedance.ies.tools.prefetch.UriWrapper$host$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final String invoke() {
                String host = UriWrapper.this.getUri().getHost();
                return host != null ? host : "";
            }
        });
        this.queryMap = LazyKt.lazy(new Function0<SortedMap<String, String>>() { // from class: com.bytedance.ies.tools.prefetch.UriWrapper$queryMap$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final SortedMap<String, String> invoke() {
                return UtilKt.getQueryMap(UriWrapper.this.getUri());
            }
        });
        this.hash = LazyKt.lazy(new Function0<String>() { // from class: com.bytedance.ies.tools.prefetch.UriWrapper$hash$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final String invoke() {
                String fragment = UriWrapper.this.getUri().getFragment();
                if (fragment == null) {
                    fragment = "";
                }
                String str2 = fragment;
                if (StringsKt.contains$default(str2, "?", false, 2, (Object) null)) {
                    List split$default = StringsKt.split$default(str2, new String[]{"?"}, false, 0, 6, (Object) null);
                    String str3 = (String) split$default.get(1);
                    if (str3.length() > 0) {
                        for (String str4 : StringsKt.split$default(str3, new String[]{"&"}, false, 0, 6, (Object) null)) {
                            int indexOf$default = StringsKt.indexOf$default(str4, "=", 0, false, 6, (Object) null);
                            if (indexOf$default > 0) {
                                SortedMap<String, String> queryMap = UriWrapper.this.getQueryMap();
                                if (str4 == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                }
                                String substring = str4.substring(0, indexOf$default);
                                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                String decode = URLDecoder.decode(substring, "UTF-8");
                                int i = indexOf$default + 1;
                                if (str4 != null) {
                                    String substring2 = str4.substring(i);
                                    Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
                                    queryMap.put(decode, URLDecoder.decode(substring2, "UTF-8"));
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                }
                            }
                        }
                    }
                    return "#" + ((String) split$default.get(0));
                }
                return "#" + fragment;
            }
        });
    }

    public final String getUrl() {
        return this.url;
    }
}
