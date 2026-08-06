package com.larus.business.markdown.impl.markwon.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.larus.business.markdown.api.extplugin.image.ImageStatusDrawableProvider;
import com.larus.business.markdown.api.model.ImageSpanStatus;
import com.larus.business.markdown.impl.C1327R;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CustomImageStatusDrawableProvider.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/image/CustomImageStatusDrawableProvider;", "Lcom/larus/business/markdown/api/extplugin/image/ImageStatusDrawableProvider;", "()V", "getDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "url", "", "status", "Lcom/larus/business/markdown/api/model/ImageSpanStatus;", LynxError.LYNX_THROWABLE, "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CustomImageStatusDrawableProvider implements ImageStatusDrawableProvider {

    /* compiled from: CustomImageStatusDrawableProvider.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageSpanStatus.values().length];
            try {
                iArr[ImageSpanStatus.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageSpanStatus.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImageSpanStatus.FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ImageSpanStatus.FAIL_NO_RETRY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.larus.business.markdown.api.extplugin.image.ImageStatusDrawableProvider
    public Drawable getDrawable(Context context, String url, ImageSpanStatus status, Throwable throwable) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(status, "status");
        int i = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
        if (i == 1 || i == 2) {
            if (StringsKt.isBlank(url)) {
                drawable = ContextCompat.getDrawable(context, C1327R.drawable.md_img_error_alert);
                Intrinsics.checkNotNull(drawable);
            } else {
                drawable = ContextCompat.getDrawable(context, C1327R.drawable.md_img_placeholder);
                Intrinsics.checkNotNull(drawable);
            }
            Intrinsics.checkNotNullExpressionValue(drawable, "if (url.isBlank()) {\n   …ceholder)!!\n            }");
            return drawable;
        }
        if (i == 3) {
            Drawable drawable2 = ContextCompat.getDrawable(context, C1327R.drawable.md_img_error);
            Intrinsics.checkNotNull(drawable2);
            return drawable2;
        }
        if (i == 4) {
            Drawable drawable3 = ContextCompat.getDrawable(context, C1327R.drawable.md_img_error_alert);
            Intrinsics.checkNotNull(drawable3);
            return drawable3;
        }
        throw new IllegalArgumentException(status.toString());
    }
}
