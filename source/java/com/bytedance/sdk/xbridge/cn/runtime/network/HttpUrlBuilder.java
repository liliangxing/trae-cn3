package com.bytedance.sdk.xbridge.cn.runtime.network;

import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: HttpUrlBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0012J\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0013J\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0014\u001a\u00020\u0003J\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/network/HttpUrlBuilder;", "", IWeixinService.ResponseConstants.URL, "", "(Ljava/lang/String;)V", "encoding", "getEncoding", "()Ljava/lang/String;", "setEncoding", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getUrl", "setUrl", "addParam", "name", "value", "", "", "", "build", "toString", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class HttpUrlBuilder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String ENCODING_UTF_8 = "UTF-8";
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";
    private String encoding;
    private final HashMap<String, String> params;
    private String url;

    /* compiled from: HttpUrlBuilder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002J(\u0010\n\u001a\u00020\u00042\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/network/HttpUrlBuilder$Companion;", "", "()V", "ENCODING_UTF_8", "", "NAME_VALUE_SEPARATOR", "PARAMETER_SEPARATOR", "encode", ReportConstant.COMMON_CONTENT, "encoding", "formatUrl", "parameters", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String formatUrl(Map<String, String> parameters, String encoding) {
            String str;
            StringBuilder sb = new StringBuilder();
            Set<String> keySet = parameters.keySet();
            if (keySet == null || keySet.isEmpty()) {
                return "";
            }
            for (String str2 : keySet) {
                String encode = encode(str2, encoding);
                String str3 = parameters.get(str2);
                if (str3 == null || (str = HttpUrlBuilder.INSTANCE.encode(str3, encoding)) == null) {
                    str = "";
                }
                if (sb.length() > 0) {
                    sb.append(HttpUrlBuilder.PARAMETER_SEPARATOR);
                }
                sb.append(encode);
                sb.append(HttpUrlBuilder.NAME_VALUE_SEPARATOR);
                sb.append(str);
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "result.toString()");
            return sb2;
        }

        private final String encode(String content, String encoding) {
            try {
                if (encoding == null) {
                    content = URLEncoder.encode(content, "ISO_8859_1");
                } else if (!Intrinsics.areEqual(encoding, "null_encoding")) {
                    content = URLEncoder.encode(content, encoding);
                }
                Intrinsics.checkNotNullExpressionValue(content, "{\n                if (en…          }\n            }");
                return content;
            } catch (UnsupportedEncodingException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final String getEncoding() {
        return this.encoding;
    }

    public final void setEncoding(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.encoding = str;
    }

    public HttpUrlBuilder(String str) {
        Intrinsics.checkNotNullParameter(str, IWeixinService.ResponseConstants.URL);
        this.params = new HashMap<>();
        this.encoding = "UTF-8";
        this.url = str;
    }

    public final HttpUrlBuilder addParam(String name, int value) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.params.put(name, String.valueOf(value));
        return this;
    }

    public final HttpUrlBuilder addParam(String name, long value) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.params.put(name, String.valueOf(value));
        return this;
    }

    public final HttpUrlBuilder addParam(String name, double value) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.params.put(name, String.valueOf(value));
        return this;
    }

    public final HttpUrlBuilder addParam(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.params.put(name, value);
        return this;
    }

    public final String build() {
        if (!this.params.isEmpty()) {
            String formatUrl = INSTANCE.formatUrl(this.params, this.encoding);
            String str = this.url;
            if (str == null) {
                return formatUrl;
            }
            if (str.length() == 0) {
                return formatUrl;
            }
            if (StringsKt.indexOf$default(this.url, '?', 0, false, 6, (Object) null) >= 0) {
                return this.url + '&' + formatUrl;
            }
            return this.url + '?' + formatUrl;
        }
        return this.url;
    }

    public String toString() {
        return build();
    }
}
