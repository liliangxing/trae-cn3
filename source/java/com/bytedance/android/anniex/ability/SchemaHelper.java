package com.bytedance.android.anniex.ability;

import android.net.Uri;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.lynx.tasm.base.TraceEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SchemaHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/anniex/ability/SchemaHelper;", "", "()V", "parseCardSchema", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "uri", "Landroid/net/Uri;", "bid", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SchemaHelper {
    public static final SchemaHelper INSTANCE = new SchemaHelper();

    private SchemaHelper() {
    }

    public static /* synthetic */ SchemaModelUnion parseCardSchema$default(SchemaHelper schemaHelper, Uri uri, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "default_bid";
        }
        return schemaHelper.parseCardSchema(uri, str);
    }

    public final SchemaModelUnion parseCardSchema(Uri uri, String bid) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        TraceEvent.beginSection("SchemaHelper:parseCardSchema");
        try {
            return new SchemaModelUnion(SchemaService.Companion.getInstance().generateSchemaData(bid, uri));
        } finally {
            TraceEvent.endSection("SchemaHelper:parseCardSchema");
        }
    }
}
