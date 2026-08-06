package com.bytedance.android.anniex.lite.config;

import android.net.Uri;
import com.bytedance.android.anniex.lite.AnnieXProcessCenter;
import com.bytedance.ies.bullet.service.base.api.UIShowConfig;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LitePageConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/anniex/lite/config/LitePageConfig;", "", "bid", "", "uri", "Landroid/net/Uri;", "uiShowConfig", "Lcom/bytedance/ies/bullet/service/base/api/UIShowConfig;", "(Ljava/lang/String;Landroid/net/Uri;Lcom/bytedance/ies/bullet/service/base/api/UIShowConfig;)V", "schemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "getSchemaModelUnion", "()Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "schemaModelUnion$delegate", "Lkotlin/Lazy;", "isDelayOpen", "", "isFromScan", "isOpenWithReplace", "isScanOpen", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LitePageConfig {

    /* renamed from: schemaModelUnion$delegate, reason: from kotlin metadata */
    private final Lazy schemaModelUnion;

    public LitePageConfig(final String str, final Uri uri, final UIShowConfig uIShowConfig) {
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(uIShowConfig, "uiShowConfig");
        this.schemaModelUnion = LazyKt.lazy(new Function0<SchemaModelUnion>() { // from class: com.bytedance.android.anniex.lite.config.LitePageConfig$schemaModelUnion$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final SchemaModelUnion m3340invoke() {
                return AnnieXProcessCenter.INSTANCE.getOrCreateSchemaData(str, uri, uIShowConfig.getSessionId());
            }
        });
    }

    private final SchemaModelUnion getSchemaModelUnion() {
        return (SchemaModelUnion) this.schemaModelUnion.getValue();
    }

    public final boolean isOpenWithReplace() {
        return Intrinsics.areEqual(new BooleanParam(getSchemaModelUnion().getSchemaData(), "open_schema_with_replace", (Boolean) null).getValue(), true);
    }

    public final boolean isScanOpen() {
        return Intrinsics.areEqual(new BooleanParam(getSchemaModelUnion().getSchemaData(), "scan_open", (Boolean) null).getValue(), true);
    }

    public final boolean isFromScan() {
        return Intrinsics.areEqual(new BooleanParam(getSchemaModelUnion().getSchemaData(), "is_from_scan", (Boolean) null).getValue(), true);
    }

    public final boolean isDelayOpen() {
        return Intrinsics.areEqual(new BooleanParam(getSchemaModelUnion().getSchemaData(), "delay_open", (Boolean) null).getValue(), true);
    }
}
