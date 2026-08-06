package com.bytedance.ies.bullet.prefetchv2;

import android.net.Uri;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrefetchSchema.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0006\u001a\u00020\u0003*\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a\f\u0010\t\u001a\u00020\u0003*\u00020\nH\u0000\u001a\u000e\u0010\u000b\u001a\u0004\u0018\u00010\u0003*\u00020\u0002H\u0000\"\u001d\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"globalSchemaModelCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/net/Uri;", "Lcom/bytedance/ies/bullet/prefetchv2/SchemaModel;", "getGlobalSchemaModelCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "toSchemaModel", "bid", "", "toSchemaModelBySchemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "toSchemaModelOnlyFromCache", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrefetchSchemaKt {
    private static final ConcurrentHashMap<Uri, SchemaModel> globalSchemaModelCache = new ConcurrentHashMap<>();

    public static final ConcurrentHashMap<Uri, SchemaModel> getGlobalSchemaModelCache() {
        return globalSchemaModelCache;
    }

    public static /* synthetic */ SchemaModel toSchemaModel$default(Uri uri, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "default_bid";
        }
        return toSchemaModel(uri, str);
    }

    public static final SchemaModel toSchemaModel(Uri uri, String str) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(str, "bid");
        ConcurrentHashMap<Uri, SchemaModel> concurrentHashMap = globalSchemaModelCache;
        SchemaModel schemaModel = concurrentHashMap.get(uri);
        if (schemaModel != null) {
            return schemaModel;
        }
        SchemaModel schemaModelBySchemaData = toSchemaModelBySchemaData(SchemaService.INSTANCE.getInstance().generateSchemaData(str, uri));
        concurrentHashMap.put(uri, schemaModelBySchemaData);
        return schemaModelBySchemaData;
    }

    public static final SchemaModel toSchemaModelOnlyFromCache(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return globalSchemaModelCache.get(uri);
    }

    public static final SchemaModel toSchemaModelBySchemaData(ISchemaData iSchemaData) {
        Intrinsics.checkNotNullParameter(iSchemaData, "<this>");
        Boolean value = new BooleanParam(iSchemaData, SchemaConstants.ENABLE_PREFETCH_V2, false).getValue();
        SchemaModel schemaModel = new SchemaModel(value != null ? value.booleanValue() : false, iSchemaData.getQueryItems().get(PrefetchSchemaParam.PREFETCH_BUSINESS), iSchemaData);
        schemaModel.setDevMode(Intrinsics.areEqual(iSchemaData.getQueryItems().get("__dev"), "1"));
        return schemaModel;
    }
}
