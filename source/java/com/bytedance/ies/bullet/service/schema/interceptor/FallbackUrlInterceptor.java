package com.bytedance.ies.bullet.service.schema.interceptor;

import android.net.Uri;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.schema.ISchemaMutableData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.SchemaInterceptor;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FallbackUrlInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/interceptor/FallbackUrlInterceptor;", "Lcom/bytedance/ies/bullet/service/sdk/SchemaInterceptor;", "()V", "name", "", "getName", "()Ljava/lang/String;", "convert", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaMutableData;", "hookConvert", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class FallbackUrlInterceptor extends SchemaInterceptor {
    private final String name = "FallbackUrl";

    private final void hookConvert(ISchemaMutableData schemaData) {
    }

    @Override // com.bytedance.ies.bullet.service.sdk.SchemaInterceptor, com.bytedance.ies.bullet.service.schema.ISchemaInterceptor
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.ies.bullet.service.sdk.SchemaInterceptor, com.bytedance.ies.bullet.service.schema.ISchemaInterceptor
    public boolean convert(ISchemaMutableData schemaData) {
        String substring;
        String substring2;
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        String str = schemaData.getQueryItems().get(SchemaConstants.QUERY_KEY_FALLBACK_URL);
        if (str != null) {
            int indexOf$default = StringsKt.indexOf$default(str, '#', 0, false, 6, (Object) null);
            if (indexOf$default == -1) {
                substring = str;
            } else {
                substring = str.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            if (indexOf$default == -1) {
                substring2 = "";
            } else {
                substring2 = str.substring(indexOf$default, str.length());
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            StringBuilder sb = new StringBuilder(substring);
            if (!StringsKt.contains$default(substring, '?', false, 2, (Object) null)) {
                sb.append('?');
            }
            sb.append("&prev_kit_type=").append(KitType.LYNX.name());
            String str2 = schemaData.getQueryItems().get("url");
            if (str2 != null) {
                int indexOf$default2 = StringsKt.indexOf$default(str2, '?', 0, false, 6, (Object) null);
                StringBuilder append = sb.append("&prev_url=");
                if (indexOf$default2 != -1) {
                    if (str2 != null) {
                        str2 = str2.substring(0, indexOf$default2);
                        Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
                append.append(Uri.encode(str2));
            }
            sb.append(substring2);
            schemaData.addParam(SchemaConstants.QUERY_KEY_FALLBACK_URL, new StringParam(sb.toString()), true);
        }
        hookConvert(schemaData);
        return true;
    }
}
