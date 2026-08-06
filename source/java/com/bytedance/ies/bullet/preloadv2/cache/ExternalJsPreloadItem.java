package com.bytedance.ies.bullet.preloadv2.cache;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PreloadItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/cache/ExternalJsPreloadItem;", "Lcom/bytedance/ies/bullet/preloadv2/cache/ByteArrayPreloadItem;", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "resUrl", "", "(Ljava/lang/String;)V", "defaultType", "Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadResourceType;", "getDefaultType", "()Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadResourceType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ExternalJsPreloadItem extends ByteArrayPreloadItem {
    private final PreloadResourceType defaultType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExternalJsPreloadItem(JSONObject jSONObject) {
        super(jSONObject);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        this.defaultType = PreloadResourceType.ExternalJs;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExternalJsPreloadItem(String str) {
        super(str, PreloadResourceType.ExternalJs);
        Intrinsics.checkNotNullParameter(str, "resUrl");
        this.defaultType = PreloadResourceType.ExternalJs;
    }

    @Override // com.bytedance.ies.bullet.preloadv2.cache.ByteArrayPreloadItem, com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public PreloadResourceType getDefaultType() {
        return this.defaultType;
    }
}
