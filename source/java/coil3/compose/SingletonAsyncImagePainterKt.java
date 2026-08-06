package coil3.compose;

import android.content.Context;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import coil3.SingletonImageLoader;
import coil3.compose.AsyncImagePainter;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: SingletonAsyncImagePainter.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a£\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001ae\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\t2\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"rememberAsyncImagePainter", "Lcoil3/compose/AsyncImagePainter;", StrategyConstants.MODEL, "", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State$Loading;", "", "onSuccess", "Lcoil3/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil3/compose/AsyncImagePainter$State$Error;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "modelEqualityDelegate", "Lcoil3/compose/EqualityDelegate;", "rememberAsyncImagePainter-HtA5bXE", "(Ljava/lang/Object;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILcoil3/compose/EqualityDelegate;Landroidx/compose/runtime/Composer;II)Lcoil3/compose/AsyncImagePainter;", "transform", "Lcoil3/compose/AsyncImagePainter$State;", "onState", "rememberAsyncImagePainter-EHKIwbg", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILcoil3/compose/EqualityDelegate;Landroidx/compose/runtime/Composer;II)Lcoil3/compose/AsyncImagePainter;", "coil-compose_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SingletonAsyncImagePainterKt {
    /* renamed from: rememberAsyncImagePainter-HtA5bXE, reason: not valid java name */
    public static final AsyncImagePainter m3199rememberAsyncImagePainterHtA5bXE(Object obj, Painter painter, Painter painter2, Painter painter3, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13, ContentScale contentScale, int i, EqualityDelegate equalityDelegate, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(-161587155);
        Painter painter4 = (i3 & 2) != 0 ? null : painter;
        Painter painter5 = (i3 & 4) != 0 ? null : painter2;
        Painter painter6 = (i3 & 8) != 0 ? painter5 : painter3;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function14 = (i3 & 16) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function15 = (i3 & 32) != 0 ? null : function12;
        Function1<? super AsyncImagePainter.State.Error, Unit> function16 = (i3 & 64) != 0 ? null : function13;
        ContentScale fit = (i3 & 128) != 0 ? ContentScale.Companion.getFit() : contentScale;
        int i4 = (i3 & 256) != 0 ? DrawScope.Companion.getDefaultFilterQuality-f-v9h1I() : i;
        EqualityDelegate defaultModelEqualityDelegate = (i3 & 512) != 0 ? EqualityDelegateKt.getDefaultModelEqualityDelegate() : equalityDelegate;
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i5 = i2 << 3;
        AsyncImagePainter m3189rememberAsyncImagePainter10Xjiaw = AsyncImagePainterKt.m3189rememberAsyncImagePainter10Xjiaw(obj, SingletonImageLoader.get((Context) consume), painter4, painter5, painter6, function14, function15, function16, fit, i4, defaultModelEqualityDelegate, composer, (i2 & 14) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (234881024 & i5) | (i5 & 1879048192), (i2 >> 27) & 14, 0);
        composer.endReplaceableGroup();
        return m3189rememberAsyncImagePainter10Xjiaw;
    }

    /* renamed from: rememberAsyncImagePainter-EHKIwbg, reason: not valid java name */
    public static final AsyncImagePainter m3198rememberAsyncImagePainterEHKIwbg(Object obj, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, ContentScale contentScale, int i, EqualityDelegate equalityDelegate, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(1009598647);
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform = (i3 & 2) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        Function1<? super AsyncImagePainter.State, Unit> function13 = (i3 & 4) != 0 ? null : function12;
        ContentScale fit = (i3 & 8) != 0 ? ContentScale.Companion.getFit() : contentScale;
        int i4 = (i3 & 16) != 0 ? DrawScope.Companion.getDefaultFilterQuality-f-v9h1I() : i;
        EqualityDelegate defaultModelEqualityDelegate = (i3 & 32) != 0 ? EqualityDelegateKt.getDefaultModelEqualityDelegate() : equalityDelegate;
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i5 = i2 << 3;
        AsyncImagePainter m3188rememberAsyncImagePainter0YpotYA = AsyncImagePainterKt.m3188rememberAsyncImagePainter0YpotYA(obj, SingletonImageLoader.get((Context) consume), defaultTransform, function13, fit, i4, defaultModelEqualityDelegate, composer, (i2 & 14) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (i5 & 3670016), 0);
        composer.endReplaceableGroup();
        return m3188rememberAsyncImagePainter0YpotYA;
    }
}
