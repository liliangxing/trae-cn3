package com.bytedance.ies.bullet.prefetchv2;

import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrefetchV2.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"usePrefetchV2", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class PrefetchV2Kt {
    public static final boolean usePrefetchV2(ISchemaData iSchemaData) {
        Map<String, String> queryItems;
        return Intrinsics.areEqual((iSchemaData == null || (queryItems = iSchemaData.getQueryItems()) == null) ? null : queryItems.get(SchemaConstants.ENABLE_PREFETCH_V2), "1");
    }
}
