package androidx.compose.p001ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.p001ui.text.font.AndroidFont;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: AndroidFontLoader.android.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\fR\u0016\u0010\u0002\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/font/AndroidFontLoader;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "kotlin.jvm.PlatformType", "loadBlocking", "Landroid/graphics/Typeface;", "font", "Landroidx/compose/ui/text/font/Font;", "awaitLoad", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cacheKey", "", "getCacheKey", "()Ljava/lang/Object;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AndroidFontLoader implements PlatformFontLoader {
    public static final int $stable = 8;
    private final Object cacheKey;
    private final Context context;

    public AndroidFontLoader(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override // androidx.compose.p001ui.text.font.PlatformFontLoader
    public Typeface loadBlocking(Font font) {
        Object obj;
        Typeface typeface;
        Typeface load;
        if (font instanceof AndroidFont) {
            AndroidFont androidFont = (AndroidFont) font;
            return androidFont.getTypefaceLoader().loadBlocking(this.context, androidFont);
        }
        if (!(font instanceof ResourceFont)) {
            return null;
        }
        ResourceFont resourceFont = (ResourceFont) font;
        int loadingStrategy = resourceFont.getLoadingStrategy();
        if (FontLoadingStrategy.m2224equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m2229getBlockingPKNRLFQ())) {
            typeface = AndroidFontLoader_androidKt.load(resourceFont, this.context);
        } else if (FontLoadingStrategy.m2224equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m2230getOptionalLocalPKNRLFQ())) {
            try {
                Result.Companion companion = Result.Companion;
                AndroidFontLoader androidFontLoader = this;
                load = AndroidFontLoader_androidKt.load((ResourceFont) font, this.context);
                obj = Result.constructor-impl(load);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            typeface = (Typeface) (Result.isFailure-impl(obj) ? null : obj);
        } else {
            if (FontLoadingStrategy.m2224equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m2228getAsyncPKNRLFQ())) {
                throw new UnsupportedOperationException("Unsupported Async font load path");
            }
            throw new IllegalArgumentException("Unknown loading type " + ((Object) FontLoadingStrategy.m2226toStringimpl(resourceFont.getLoadingStrategy())));
        }
        return PlatformTypefaces_androidKt.setFontVariationSettings(typeface, resourceFont.getVariationSettings(), this.context);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.compose.p001ui.text.font.PlatformFontLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object awaitLoad(Font font, Continuation<? super Typeface> continuation) {
        AndroidFontLoader$awaitLoad$1 androidFontLoader$awaitLoad$1;
        int i;
        if (continuation instanceof AndroidFontLoader$awaitLoad$1) {
            androidFontLoader$awaitLoad$1 = (AndroidFontLoader$awaitLoad$1) continuation;
            if ((androidFontLoader$awaitLoad$1.label & Integer.MIN_VALUE) != 0) {
                androidFontLoader$awaitLoad$1.label -= Integer.MIN_VALUE;
                Object obj = androidFontLoader$awaitLoad$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidFontLoader$awaitLoad$1.label;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    }
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    font = (Font) androidFontLoader$awaitLoad$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    return PlatformTypefaces_androidKt.setFontVariationSettings((Typeface) obj, ((ResourceFont) font).getVariationSettings(), this.context);
                }
                ResultKt.throwOnFailure(obj);
                if (font instanceof AndroidFont) {
                    AndroidFont androidFont = (AndroidFont) font;
                    AndroidFont.TypefaceLoader typefaceLoader = androidFont.getTypefaceLoader();
                    Context context = this.context;
                    androidFontLoader$awaitLoad$1.label = 1;
                    obj = typefaceLoader.awaitLoad(context, androidFont, androidFontLoader$awaitLoad$1);
                    return obj == coroutine_suspended ? coroutine_suspended : obj;
                }
                if (font instanceof ResourceFont) {
                    Context context2 = this.context;
                    androidFontLoader$awaitLoad$1.L$0 = font;
                    androidFontLoader$awaitLoad$1.label = 2;
                    obj = AndroidFontLoader_androidKt.loadAsync((ResourceFont) font, context2, androidFontLoader$awaitLoad$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return PlatformTypefaces_androidKt.setFontVariationSettings((Typeface) obj, ((ResourceFont) font).getVariationSettings(), this.context);
                }
                throw new IllegalArgumentException("Unknown font type: " + font);
            }
        }
        androidFontLoader$awaitLoad$1 = new AndroidFontLoader$awaitLoad$1(this, continuation);
        Object obj2 = androidFontLoader$awaitLoad$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidFontLoader$awaitLoad$1.label;
        if (i == 0) {
        }
    }

    @Override // androidx.compose.p001ui.text.font.PlatformFontLoader
    public Object getCacheKey() {
        return this.cacheKey;
    }
}
