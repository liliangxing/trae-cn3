package com.bytedance.ies.bullet.preloadv2.cache;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PreloadItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/cache/ImagePreloadItem;", "Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadItem;", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "resUrl", "", "(Ljava/lang/String;)V", "defaultType", "Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadResourceType;", "getDefaultType", "()Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadResourceType;", "image", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "getImage", "()Lcom/facebook/common/references/CloseableReference;", "setImage", "(Lcom/facebook/common/references/CloseableReference;)V", "size", "", "getSize", "()I", "size$delegate", "Lkotlin/Lazy;", "clearMemory", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ImagePreloadItem extends PreloadItem {
    private final PreloadResourceType defaultType;
    private CloseableReference<Bitmap> image;

    /* renamed from: size$delegate, reason: from kotlin metadata */
    private final Lazy size;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePreloadItem(JSONObject jSONObject) {
        super(jSONObject);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        this.defaultType = PreloadResourceType.Image;
        this.size = LazyKt.lazy(new Function0<Integer>() { // from class: com.bytedance.ies.bullet.preloadv2.cache.ImagePreloadItem$size$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m541invoke() {
                Bitmap bitmap;
                CloseableReference<Bitmap> image = ImagePreloadItem.this.getImage();
                return Integer.valueOf((image == null || (bitmap = (Bitmap) image.get()) == null) ? 0 : bitmap.getByteCount());
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePreloadItem(String str) {
        super(str, PreloadResourceType.Image, false, 0L, 8, null);
        Intrinsics.checkNotNullParameter(str, "resUrl");
        this.defaultType = PreloadResourceType.Image;
        this.size = LazyKt.lazy(new Function0<Integer>() { // from class: com.bytedance.ies.bullet.preloadv2.cache.ImagePreloadItem$size$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m541invoke() {
                Bitmap bitmap;
                CloseableReference<Bitmap> image = ImagePreloadItem.this.getImage();
                return Integer.valueOf((image == null || (bitmap = (Bitmap) image.get()) == null) ? 0 : bitmap.getByteCount());
            }
        });
    }

    @Override // com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public PreloadResourceType getDefaultType() {
        return this.defaultType;
    }

    public final CloseableReference<Bitmap> getImage() {
        return this.image;
    }

    public final void setImage(CloseableReference<Bitmap> closeableReference) {
        this.image = closeableReference;
    }

    @Override // com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public int getSize() {
        return ((Number) this.size.getValue()).intValue();
    }

    @Override // com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public void clearMemory() {
        CloseableReference<Bitmap> closeableReference = this.image;
        if (closeableReference != null) {
            closeableReference.close();
        }
        this.image = null;
    }
}
