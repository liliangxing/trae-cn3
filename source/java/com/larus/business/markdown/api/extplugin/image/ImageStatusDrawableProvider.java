package com.larus.business.markdown.api.extplugin.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.larus.business.markdown.api.model.ImageSpanStatus;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;

/* compiled from: ImageStatusDrawableProvider.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/larus/business/markdown/api/extplugin/image/ImageStatusDrawableProvider;", "", "getDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "url", "", "status", "Lcom/larus/business/markdown/api/model/ImageSpanStatus;", LynxError.LYNX_THROWABLE, "", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface ImageStatusDrawableProvider {
    Drawable getDrawable(Context context, String url, ImageSpanStatus status, Throwable throwable);
}
