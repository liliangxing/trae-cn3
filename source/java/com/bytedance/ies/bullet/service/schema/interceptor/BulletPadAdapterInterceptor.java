package com.bytedance.ies.bullet.service.schema.interceptor;

import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.schema.ISchemaMutableData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.SchemaInterceptor;
import com.bytedance.ies.bullet.service.sdk.param.DoubleParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletPadAdapterInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/interceptor/BulletPadAdapterInterceptor;", "Lcom/bytedance/ies/bullet/service/sdk/SchemaInterceptor;", "padRatio", "", "(Ljava/lang/Double;)V", "name", "", "getName", "()Ljava/lang/String;", "Ljava/lang/Double;", "convert", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaMutableData;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletPadAdapterInterceptor extends SchemaInterceptor {
    private final Double padRatio;

    @Override // com.bytedance.ies.bullet.service.sdk.SchemaInterceptor, com.bytedance.ies.bullet.service.schema.ISchemaInterceptor
    public String getName() {
        return "padAdapter";
    }

    public BulletPadAdapterInterceptor(Double d) {
        this.padRatio = d;
    }

    @Override // com.bytedance.ies.bullet.service.sdk.SchemaInterceptor, com.bytedance.ies.bullet.service.schema.ISchemaInterceptor
    public boolean convert(ISchemaMutableData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        Double d = this.padRatio;
        if (d != null) {
            schemaData.addParam(SchemaConstants.QUERY_KEY_PAD_RATIO, new DoubleParam(Double.valueOf(d.doubleValue())), false);
        }
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "PadAdapterInterceptor convert scheme.add param padRatio:" + this.padRatio, null, null, 6, null);
        return true;
    }
}
