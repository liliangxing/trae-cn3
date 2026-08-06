package com.bytedance.ies.bullet.service.sdk;

import com.bytedance.ies.bullet.service.schema.ISchemaInterceptor;
import com.bytedance.ies.bullet.service.schema.ISchemaMutableData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SchemaInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/SchemaInterceptor;", "Lcom/bytedance/ies/bullet/service/schema/ISchemaInterceptor;", "()V", "name", "", "getName", "()Ljava/lang/String;", "convert", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaMutableData;", "errorMessage", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public abstract class SchemaInterceptor implements ISchemaInterceptor {
    private final String name = "Anonymity";

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaInterceptor
    public boolean convert(ISchemaMutableData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        return false;
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaInterceptor
    public String errorMessage() {
        return "No Error";
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaInterceptor
    public String getName() {
        return this.name;
    }
}
