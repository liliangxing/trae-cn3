package com.bytedance.ies.bullet.service.schema.interceptor;

import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ies.bullet.service.schema.ISchemaMutableData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.SchemaInterceptor;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxUrlInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/interceptor/LynxUrlInterceptor;", "Lcom/bytedance/ies/bullet/service/sdk/SchemaInterceptor;", "channel", "", SchemaConstants.QUERY_KEY_BUNDLE, CDNLoader.DIAGNOSE_SOURCE_URL, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "name", "getName", "()Ljava/lang/String;", "convert", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaMutableData;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxUrlInterceptor extends SchemaInterceptor {
    private final String bundle;
    private final String channel;
    private final String name = "LynxUrl";
    private final String sourceUrl;

    public LynxUrlInterceptor(String str, String str2, String str3) {
        this.channel = str;
        this.bundle = str2;
        this.sourceUrl = str3;
    }

    @Override // com.bytedance.ies.bullet.service.sdk.SchemaInterceptor, com.bytedance.ies.bullet.service.schema.ISchemaInterceptor
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.ies.bullet.service.sdk.SchemaInterceptor, com.bytedance.ies.bullet.service.schema.ISchemaInterceptor
    public boolean convert(ISchemaMutableData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        schemaData.setPath("lynxview");
        String str = this.channel;
        if (str != null) {
            schemaData.addParam("channel", new StringParam(str), true);
        }
        if (this.bundle != null) {
            schemaData.addParam(SchemaConstants.QUERY_KEY_BUNDLE, new StringParam(this.bundle), true);
        }
        if (this.sourceUrl != null) {
            schemaData.addParam(SchemaConstants.QUERY_KEY_SURL, new StringParam(this.sourceUrl), true);
        }
        return true;
    }
}
