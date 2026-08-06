package com.bytedance.ies.bullet.container.router.interceptor;

import com.bytedance.ies.bullet.service.schema.ISchemaMutableData;
import com.bytedance.ies.bullet.service.sdk.SchemaInterceptor;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXFlowInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/container/router/interceptor/AnnieXFlowInterceptor;", "Lcom/bytedance/ies/bullet/service/sdk/SchemaInterceptor;", "()V", "name", "", "getName", "()Ljava/lang/String;", "convert", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaMutableData;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AnnieXFlowInterceptor extends SchemaInterceptor {
    private static final String ENABLE_ENGINE_PRELOAD = "enable_engine_preload";
    private static final String ENABLE_MODEL_PRE_CREATE = "enable_model_pre_create";
    private final String name = "TestFlowInterceptor";

    @Override // com.bytedance.ies.bullet.service.sdk.SchemaInterceptor, com.bytedance.ies.bullet.service.schema.ISchemaInterceptor
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.ies.bullet.service.sdk.SchemaInterceptor, com.bytedance.ies.bullet.service.schema.ISchemaInterceptor
    public boolean convert(ISchemaMutableData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        ISchemaMutableData iSchemaMutableData = schemaData;
        schemaData.addParam(ENABLE_MODEL_PRE_CREATE, new BooleanParam(iSchemaMutableData, ENABLE_MODEL_PRE_CREATE, true), true);
        schemaData.addParam(ENABLE_ENGINE_PRELOAD, new BooleanParam(iSchemaMutableData, ENABLE_ENGINE_PRELOAD, true), true);
        return true;
    }
}
