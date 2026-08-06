package com.bytedance.ies.bullet.preloadv2.cache;

import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PreloadItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/cache/FontPreloadItem;", "Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadItem;", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "resUrl", "", "(Ljava/lang/String;)V", "defaultType", "Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadResourceType;", "getDefaultType", "()Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadResourceType;", "typeFace", "Landroid/graphics/Typeface;", "getTypeFace", "()Landroid/graphics/Typeface;", "setTypeFace", "(Landroid/graphics/Typeface;)V", "clearMemory", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class FontPreloadItem extends PreloadItem {
    private final PreloadResourceType defaultType;
    private Typeface typeFace;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FontPreloadItem(JSONObject jSONObject) {
        super(jSONObject);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        this.defaultType = PreloadResourceType.Font;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FontPreloadItem(String str) {
        super(str, PreloadResourceType.Font, false, 0L, 12, null);
        Intrinsics.checkNotNullParameter(str, "resUrl");
        this.defaultType = PreloadResourceType.Font;
    }

    @Override // com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public PreloadResourceType getDefaultType() {
        return this.defaultType;
    }

    public final Typeface getTypeFace() {
        return this.typeFace;
    }

    public final void setTypeFace(Typeface typeface) {
        this.typeFace = typeface;
    }

    @Override // com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public void clearMemory() {
        this.typeFace = null;
    }
}
