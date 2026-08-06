package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;

/* compiled from: JsonSchemaCache.kt */
@Metadata(m4d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5d2 = {"schemaCache", "Lkotlinx/serialization/json/internal/DescriptorSchemaCache;", "Lkotlinx/serialization/json/Json;", "getSchemaCache$annotations", "(Lkotlinx/serialization/json/Json;)V", "getSchemaCache", "(Lkotlinx/serialization/json/Json;)Lkotlinx/serialization/json/internal/DescriptorSchemaCache;", "kotlinx-serialization-json"}, m6k = 2, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class JsonSchemaCacheKt {
    public static /* synthetic */ void getSchemaCache$annotations(Json json) {
    }

    public static final DescriptorSchemaCache getSchemaCache(Json json) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        return json.get_schemaCache();
    }
}
