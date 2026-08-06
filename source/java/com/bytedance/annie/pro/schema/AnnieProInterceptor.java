package com.bytedance.annie.pro.schema;

import android.net.Uri;
import com.bytedance.annie.pro.AnnieProConstants;
import com.bytedance.annie.pro.utils.SchemaUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaMutableData;
import com.bytedance.ies.bullet.service.sdk.SchemaInterceptor;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ies.bullet.service.sdk.param.UrlParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieProInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/annie/pro/schema/AnnieProInterceptor;", "Lcom/bytedance/ies/bullet/service/sdk/SchemaInterceptor;", "()V", "name", "", "getName", "()Ljava/lang/String;", "convert", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaMutableData;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class AnnieProInterceptor extends SchemaInterceptor {
    private final String name = "AnniePro";

    public String getName() {
        return this.name;
    }

    public boolean convert(ISchemaMutableData schemaData) {
        String str;
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        if (!Intrinsics.areEqual(new BooleanParam((ISchemaData) schemaData, "enable_annie_pro", false).getValue(), true)) {
            return true;
        }
        schemaData.addParam("__x_param_annie_pro", new BooleanParam(true), false);
        String str2 = (String) schemaData.getQueryItems().get(Api.KEY_TICKET_APP_ID);
        if (str2 != null) {
            String str3 = (String) schemaData.getQueryItems().get("local_host");
            String str4 = (String) schemaData.getQueryItems().get("start_page");
            String str5 = str3;
            if (str5 == null || str5.length() == 0) {
                str = SchemaUtils.INSTANCE.appendEndSlash(AnnieProConstants.INSTANCE.getONLINE_URL_PREFIX()) + str2 + SchemaUtils.INSTANCE.appendStartSlash(str4);
            } else {
                str = SchemaUtils.INSTANCE.removeEndSlash(str3) + SchemaUtils.INSTANCE.appendStartSlash(str4);
            }
            schemaData.removeParam("surl");
            schemaData.addParam("url", new UrlParam(Uri.parse(str)), true);
            schemaData.addParam("bdhm_bid", new StringParam(str2), true);
            schemaData.addParam("group", new StringParam(str2), true);
        }
        return true;
    }
}
