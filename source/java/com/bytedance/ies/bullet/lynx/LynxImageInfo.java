package com.bytedance.ies.bullet.lynx;

import android.content.Context;
import com.bytedance.forest.model.PreloadConfig;
import javax.xml.transform.Transformer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxClientDelegateChain.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006$"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/LynxImageInfo;", "", "context", "Landroid/content/Context;", "cacheKey", "", "src", "width", "", "height", "transformer", "Ljavax/xml/transform/Transformer;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;FFLjavax/xml/transform/Transformer;)V", "getCacheKey", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getHeight", "()F", "getSrc", "getTransformer", "()Ljavax/xml/transform/Transformer;", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LynxImageInfo {
    private final String cacheKey;
    private final Context context;
    private final float height;
    private final String src;
    private final Transformer transformer;
    private final float width;

    public static /* synthetic */ LynxImageInfo copy$default(LynxImageInfo lynxImageInfo, Context context, String str, String str2, float f, float f2, Transformer transformer, int i, Object obj) {
        if ((i & 1) != 0) {
            context = lynxImageInfo.context;
        }
        if ((i & 2) != 0) {
            str = lynxImageInfo.cacheKey;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = lynxImageInfo.src;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            f = lynxImageInfo.width;
        }
        float f3 = f;
        if ((i & 16) != 0) {
            f2 = lynxImageInfo.height;
        }
        float f4 = f2;
        if ((i & 32) != 0) {
            transformer = lynxImageInfo.transformer;
        }
        return lynxImageInfo.copy(context, str3, str4, f3, f4, transformer);
    }

    /* renamed from: component1, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCacheKey() {
        return this.cacheKey;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSrc() {
        return this.src;
    }

    /* renamed from: component4, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    /* renamed from: component5, reason: from getter */
    public final float getHeight() {
        return this.height;
    }

    /* renamed from: component6, reason: from getter */
    public final Transformer getTransformer() {
        return this.transformer;
    }

    public final LynxImageInfo copy(Context context, String cacheKey, String src, float width, float height, Transformer transformer) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new LynxImageInfo(context, cacheKey, src, width, height, transformer);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LynxImageInfo)) {
            return false;
        }
        LynxImageInfo lynxImageInfo = (LynxImageInfo) other;
        return Intrinsics.areEqual(this.context, lynxImageInfo.context) && Intrinsics.areEqual(this.cacheKey, lynxImageInfo.cacheKey) && Intrinsics.areEqual(this.src, lynxImageInfo.src) && Float.compare(this.width, lynxImageInfo.width) == 0 && Float.compare(this.height, lynxImageInfo.height) == 0 && Intrinsics.areEqual(this.transformer, lynxImageInfo.transformer);
    }

    public int hashCode() {
        int hashCode = this.context.hashCode() * 31;
        String str = this.cacheKey;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.src;
        int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Float.hashCode(this.width)) * 31) + Float.hashCode(this.height)) * 31;
        Transformer transformer = this.transformer;
        return hashCode3 + (transformer != null ? transformer.hashCode() : 0);
    }

    public String toString() {
        return "LynxImageInfo(context=" + this.context + ", cacheKey=" + this.cacheKey + ", src=" + this.src + ", width=" + this.width + ", height=" + this.height + ", transformer=" + this.transformer + ')';
    }

    public LynxImageInfo(Context context, String str, String str2, float f, float f2, Transformer transformer) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.cacheKey = str;
        this.src = str2;
        this.width = f;
        this.height = f2;
        this.transformer = transformer;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getCacheKey() {
        return this.cacheKey;
    }

    public final String getSrc() {
        return this.src;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getHeight() {
        return this.height;
    }

    public final Transformer getTransformer() {
        return this.transformer;
    }
}
