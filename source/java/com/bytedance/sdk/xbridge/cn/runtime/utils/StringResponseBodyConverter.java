package com.bytedance.sdk.xbridge.cn.runtime.utils;

import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XNetworkRequestImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/utils/StringResponseBodyConverter;", "", "()V", "convert", "", "value", "Lcom/bytedance/retrofit2/mime/TypedInput;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class StringResponseBodyConverter {
    public static final StringResponseBodyConverter INSTANCE = new StringResponseBodyConverter();

    private StringResponseBodyConverter() {
    }

    public final String convert(TypedInput value) {
        if (value == null || !(value instanceof TypedByteArray)) {
            return null;
        }
        try {
            String parseCharset = value.mimeType() != null ? MimeUtil.parseCharset(value.mimeType(), "UTF-8") : "UTF-8";
            byte[] bytes = ((TypedByteArray) value).getBytes();
            Intrinsics.checkNotNullExpressionValue(bytes, "value.bytes");
            Charset forName = Charset.forName(parseCharset);
            Intrinsics.checkNotNullExpressionValue(forName, "forName(charset)");
            return new String(bytes, forName);
        } catch (Throwable unused) {
            return null;
        }
    }
}
