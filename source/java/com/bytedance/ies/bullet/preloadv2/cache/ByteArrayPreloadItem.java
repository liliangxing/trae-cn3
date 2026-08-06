package com.bytedance.ies.bullet.preloadv2.cache;

import com.lynx.tasm.TemplateBundle;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PreloadItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u001f\u001a\u00020 H\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/cache/ByteArrayPreloadItem;", "Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadItem;", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "resUrl", "", "type", "Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadResourceType;", "(Ljava/lang/String;Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadResourceType;)V", "byteArray", "", "getByteArray", "()[B", "setByteArray", "([B)V", "defaultType", "getDefaultType", "()Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadResourceType;", "size", "", "getSize", "()I", "size$delegate", "Lkotlin/Lazy;", "templateBundle", "Lcom/lynx/tasm/TemplateBundle;", "getTemplateBundle", "()Lcom/lynx/tasm/TemplateBundle;", "setTemplateBundle", "(Lcom/lynx/tasm/TemplateBundle;)V", "clearMemory", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ByteArrayPreloadItem extends PreloadItem {
    private byte[] byteArray;
    private final PreloadResourceType defaultType;

    /* renamed from: size$delegate, reason: from kotlin metadata */
    private final Lazy size;
    private TemplateBundle templateBundle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteArrayPreloadItem(JSONObject jSONObject) {
        super(jSONObject);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        this.defaultType = PreloadResourceType.Template;
        this.size = LazyKt.lazy(new Function0<Integer>() { // from class: com.bytedance.ies.bullet.preloadv2.cache.ByteArrayPreloadItem$size$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m540invoke() {
                byte[] byteArray = ByteArrayPreloadItem.this.getByteArray();
                return Integer.valueOf(byteArray != null ? byteArray.length : 0);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteArrayPreloadItem(String str, PreloadResourceType preloadResourceType) {
        super(str, preloadResourceType, false, 0L, 12, null);
        Intrinsics.checkNotNullParameter(str, "resUrl");
        Intrinsics.checkNotNullParameter(preloadResourceType, "type");
        this.defaultType = PreloadResourceType.Template;
        this.size = LazyKt.lazy(new Function0<Integer>() { // from class: com.bytedance.ies.bullet.preloadv2.cache.ByteArrayPreloadItem$size$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m540invoke() {
                byte[] byteArray = ByteArrayPreloadItem.this.getByteArray();
                return Integer.valueOf(byteArray != null ? byteArray.length : 0);
            }
        });
    }

    @Override // com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public PreloadResourceType getDefaultType() {
        return this.defaultType;
    }

    public final byte[] getByteArray() {
        return this.byteArray;
    }

    public final void setByteArray(byte[] bArr) {
        this.byteArray = bArr;
    }

    public final TemplateBundle getTemplateBundle() {
        return this.templateBundle;
    }

    public final void setTemplateBundle(TemplateBundle templateBundle) {
        this.templateBundle = templateBundle;
    }

    @Override // com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public int getSize() {
        return ((Number) this.size.getValue()).intValue();
    }

    @Override // com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public void clearMemory() {
        this.byteArray = null;
        this.templateBundle = null;
    }
}
