package com.bytedance.ies.bullet.lynx.impl;

import android.content.Context;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.lynx.tasm.LynxViewClient;
import com.lynx.tasm.behavior.ImageInterceptor;
import javax.xml.transform.Transformer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultImageInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JF\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/impl/DefaultImageInterceptor;", "Lcom/lynx/tasm/behavior/ImageInterceptor;", "lynxViewClient", "Lcom/lynx/tasm/LynxViewClient;", "(Lcom/lynx/tasm/LynxViewClient;)V", "loadImage", "", "context", "Landroid/content/Context;", "cacheKey", "", "src", "width", "", "height", "transformer", "Ljavax/xml/transform/Transformer;", "handler", "Lcom/lynx/tasm/behavior/ImageInterceptor$CompletionHandler;", "shouldRedirectImageUrl", "url", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DefaultImageInterceptor implements ImageInterceptor {
    private static final String TAG = "DefaultImageInterceptor";
    private final LynxViewClient lynxViewClient;

    public DefaultImageInterceptor(LynxViewClient lynxViewClient) {
        Intrinsics.checkNotNullParameter(lynxViewClient, "lynxViewClient");
        this.lynxViewClient = lynxViewClient;
    }

    public String shouldRedirectImageUrl(String url) {
        HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "shouldRedirectImageUrl: " + url, null, null, 12, null);
        return this.lynxViewClient.shouldRedirectImageUrl(url);
    }

    public void loadImage(Context context, String cacheKey, String src, float width, float height, Transformer transformer, ImageInterceptor.CompletionHandler handler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(handler, "handler");
        HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "loadImage", null, null, 12, null);
        this.lynxViewClient.loadImage(context, cacheKey, src, width, height, transformer, handler);
    }
}
