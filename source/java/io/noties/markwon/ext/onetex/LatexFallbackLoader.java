package io.noties.markwon.ext.onetex;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.larus.business.markdown.api.SpanUtilsKt;
import com.larus.business.markdown.api.depend.OnLatexUrlCallBack;
import com.larus.business.markdown.api.model.ImageSpanStatus;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.p001ui.image.ImageDelegate;
import com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorEventService;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.AsyncDrawableLoader;
import io.noties.markwon.image.DrawableUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: LatexFallbackLoader.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J8\u0010\u0014\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0012\u001a\u00020\u0013H\u0016JB\u0010\u001a\u001a\u00020\u00102:\b\u0002\u0010\u001b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\"\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\u00192\u0006\u0010\"\u001a\u00020#H\u0002R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010\b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexFallbackLoader;", "Lio/noties/markwon/image/AsyncDrawableLoader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contextRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getLatexBitmap", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "url", "Lcom/larus/business/markdown/api/depend/OnLatexUrlCallBack;", "callback", "", "cancel", "drawable", "Lio/noties/markwon/image/AsyncDrawable;", "getBitmapAccessAbility", "isValidImageUrl", "", "load", PropsConstants.PLACEHOLDER, "Landroid/graphics/drawable/Drawable;", "setBitmapAccessAbility", "bitmapAbility", "setErrorResult", "e", "", "setResult", "asyncDrawable", IAssociationStartMonitorEventService.KEY_RESULT, "state", "Lcom/larus/business/markdown/api/model/ImageSpanStatus;", "markdown-latex_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class LatexFallbackLoader extends AsyncDrawableLoader {
    private WeakReference<Context> contextRef;
    private Function2<? super String, ? super OnLatexUrlCallBack, Unit> getLatexBitmap;

    private final void setErrorResult(AsyncDrawable drawable, Throwable e) {
    }

    public void cancel(AsyncDrawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    public Drawable placeholder(AsyncDrawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        return null;
    }

    public LatexFallbackLoader(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.contextRef = new WeakReference<>(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setBitmapAccessAbility$default(LatexFallbackLoader latexFallbackLoader, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = null;
        }
        latexFallbackLoader.setBitmapAccessAbility(function2);
    }

    public final void setBitmapAccessAbility(Function2<? super String, ? super OnLatexUrlCallBack, Unit> bitmapAbility) {
        this.getLatexBitmap = bitmapAbility;
    }

    public final Function2<String, OnLatexUrlCallBack, Unit> getBitmapAccessAbility() {
        return this.getLatexBitmap;
    }

    public void load(final AsyncDrawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Function2<? super String, ? super OnLatexUrlCallBack, Unit> function2 = this.getLatexBitmap;
        if (function2 != null) {
            String destination = drawable.getDestination();
            Intrinsics.checkNotNullExpressionValue(destination, "drawable.destination");
            function2.invoke(destination, new OnLatexUrlCallBack() { // from class: io.noties.markwon.ext.onetex.LatexFallbackLoader$load$1
                public void onFailure() {
                }

                public void onSuccess(Bitmap latexImg, float width, float height) {
                    WeakReference weakReference;
                    if (latexImg != null) {
                        weakReference = LatexFallbackLoader.this.contextRef;
                        Context context = (Context) weakReference.get();
                        LatexFallbackLoader.this.setResult(drawable, new BitmapDrawable(context != null ? context.getResources() : null, latexImg.copy(SpanUtilsKt.orDefault$default(latexImg.getConfig(), (Bitmap.Config) null, 1, (Object) null), false)), ImageSpanStatus.SUCC);
                    }
                }
            });
        }
    }

    private final boolean isValidImageUrl(String url) {
        Uri parse = Uri.parse(url);
        if (!Intrinsics.areEqual(parse.getScheme(), ImageDelegate.HTTP_PREFIX) && !Intrinsics.areEqual(parse.getScheme(), "https")) {
            return false;
        }
        String authority = parse.getAuthority();
        if (authority == null || StringsKt.isBlank(authority)) {
            return false;
        }
        String path = parse.getPath();
        return !(path == null || StringsKt.isBlank(path));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setResult(AsyncDrawable asyncDrawable, Drawable result, ImageSpanStatus state) {
        if (result != null) {
            Rect bounds = result.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "result.bounds");
            if (bounds.isEmpty()) {
                DrawableUtils.applyIntrinsicBounds(result);
            }
            if (asyncDrawable.isAttached()) {
                if (state == ImageSpanStatus.SUCC) {
                    asyncDrawable.setResult(result);
                } else {
                    asyncDrawable.setErrorResult(result);
                }
                asyncDrawable.invalidateSelf();
            }
        }
    }
}
