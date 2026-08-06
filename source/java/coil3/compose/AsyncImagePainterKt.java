package coil3.compose;

import android.os.Trace;
import androidx.compose.p001ui.platform.InspectionModeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import coil3.ImageLoader;
import coil3.compose.AsyncImagePainter;
import coil3.compose.internal.AsyncImageState;
import coil3.compose.internal.UtilsKt;
import coil3.request.ImageRequest;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AsyncImagePainter.kt */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a«\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001am\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u000b2\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u000b2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0001¢\u0006\u0004\b!\u0010\"\u001a\u000f\u0010#\u001a\u0004\u0018\u00010$H\u0001¢\u0006\u0002\u0010%\u001a\u0010\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020(H\u0000\u001a\u001a\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020,H\u0002¨\u0006."}, d2 = {"rememberAsyncImagePainter", "Lcoil3/compose/AsyncImagePainter;", StrategyConstants.MODEL, "", "imageLoader", "Lcoil3/ImageLoader;", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State$Loading;", "", "onSuccess", "Lcoil3/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil3/compose/AsyncImagePainter$State$Error;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "modelEqualityDelegate", "Lcoil3/compose/EqualityDelegate;", "rememberAsyncImagePainter-10Xjiaw", "(Ljava/lang/Object;Lcoil3/ImageLoader;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILcoil3/compose/EqualityDelegate;Landroidx/compose/runtime/Composer;III)Lcoil3/compose/AsyncImagePainter;", "transform", "Lcoil3/compose/AsyncImagePainter$State;", "onState", "rememberAsyncImagePainter-0YpotYA", "(Ljava/lang/Object;Lcoil3/ImageLoader;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILcoil3/compose/EqualityDelegate;Landroidx/compose/runtime/Composer;II)Lcoil3/compose/AsyncImagePainter;", StrategyConstants.STATE, "Lcoil3/compose/internal/AsyncImageState;", "rememberAsyncImagePainter-GSdzBsE", "(Lcoil3/compose/internal/AsyncImageState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;I)Lcoil3/compose/AsyncImagePainter;", "previewHandler", "Lcoil3/compose/AsyncImagePreviewHandler;", "(Landroidx/compose/runtime/Composer;I)Lcoil3/compose/AsyncImagePreviewHandler;", "validateRequest", "request", "Lcoil3/request/ImageRequest;", "unsupportedData", "", StrategyConstants.NAME, "", "description", "coil-compose-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AsyncImagePainterKt {
    /* renamed from: rememberAsyncImagePainter-10Xjiaw, reason: not valid java name */
    public static final AsyncImagePainter m3189rememberAsyncImagePainter10Xjiaw(Object obj, ImageLoader imageLoader, Painter painter, Painter painter2, Painter painter3, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13, ContentScale contentScale, int i, EqualityDelegate equalityDelegate, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(1096244534);
        Painter painter4 = (i4 & 4) != 0 ? null : painter;
        Painter painter5 = (i4 & 8) != 0 ? null : painter2;
        Painter painter6 = (i4 & 16) != 0 ? painter5 : painter3;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function14 = (i4 & 32) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function15 = (i4 & 64) != 0 ? null : function12;
        Function1<? super AsyncImagePainter.State.Error, Unit> function16 = (i4 & 128) == 0 ? function13 : null;
        ContentScale fit = (i4 & 256) != 0 ? ContentScale.Companion.getFit() : contentScale;
        int i5 = (i4 & 512) != 0 ? DrawScope.Companion.getDefaultFilterQuality-f-v9h1I() : i;
        AsyncImageState asyncImageState = new AsyncImageState(obj, (i4 & 1024) != 0 ? EqualityDelegateKt.getDefaultModelEqualityDelegate() : equalityDelegate, imageLoader);
        Function1<AsyncImagePainter.State, AsyncImagePainter.State> transformOf = UtilsKt.transformOf(painter4, painter5, painter6);
        Function1<AsyncImagePainter.State, Unit> onStateOf = UtilsKt.onStateOf(function14, function15, function16);
        int i6 = i2 >> 15;
        AsyncImagePainter m3190rememberAsyncImagePainterGSdzBsE = m3190rememberAsyncImagePainterGSdzBsE(asyncImageState, transformOf, onStateOf, fit, i5, composer, (i6 & 57344) | (i6 & 7168));
        composer.endReplaceableGroup();
        return m3190rememberAsyncImagePainterGSdzBsE;
    }

    /* renamed from: rememberAsyncImagePainter-0YpotYA, reason: not valid java name */
    public static final AsyncImagePainter m3188rememberAsyncImagePainter0YpotYA(Object obj, ImageLoader imageLoader, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, ContentScale contentScale, int i, EqualityDelegate equalityDelegate, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(-1243940372);
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform = (i3 & 4) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        Function1<? super AsyncImagePainter.State, Unit> function13 = (i3 & 8) != 0 ? null : function12;
        ContentScale fit = (i3 & 16) != 0 ? ContentScale.Companion.getFit() : contentScale;
        int i4 = (i3 & 32) != 0 ? DrawScope.Companion.getDefaultFilterQuality-f-v9h1I() : i;
        int i5 = i2 >> 3;
        AsyncImagePainter m3190rememberAsyncImagePainterGSdzBsE = m3190rememberAsyncImagePainterGSdzBsE(new AsyncImageState(obj, (i3 & 64) != 0 ? EqualityDelegateKt.getDefaultModelEqualityDelegate() : equalityDelegate, imageLoader), defaultTransform, function13, fit, i4, composer, (i5 & 57344) | (i5 & 112) | (i5 & 896) | (i5 & 7168));
        composer.endReplaceableGroup();
        return m3190rememberAsyncImagePainterGSdzBsE;
    }

    public static final AsyncImagePreviewHandler previewHandler(Composer composer, int i) {
        CompositionLocal localInspectionMode = InspectionModeKt.getLocalInspectionMode();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localInspectionMode);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (!((Boolean) consume).booleanValue()) {
            return null;
        }
        CompositionLocal localAsyncImagePreviewHandler = LocalAsyncImagePreviewHandlerKt.getLocalAsyncImagePreviewHandler();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(localAsyncImagePreviewHandler);
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (AsyncImagePreviewHandler) consume2;
    }

    public static final void validateRequest(ImageRequest imageRequest) {
        Object data = imageRequest.getData();
        if (data instanceof ImageRequest.Builder) {
            unsupportedData("ImageRequest.Builder", "Did you forget to call ImageRequest.Builder.build()?");
            throw new KotlinNothingValueException();
        }
        if (data instanceof ImageBitmap) {
            unsupportedData$default("ImageBitmap", null, 2, null);
            throw new KotlinNothingValueException();
        }
        if (data instanceof ImageVector) {
            unsupportedData$default("ImageVector", null, 2, null);
            throw new KotlinNothingValueException();
        }
        if (data instanceof Painter) {
            unsupportedData$default("Painter", null, 2, null);
            throw new KotlinNothingValueException();
        }
        AsyncImagePainter_androidKt.validateRequestProperties(imageRequest);
    }

    static /* synthetic */ Void unsupportedData$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "If you wish to display this " + str + ", use androidx.compose.foundation.Image.";
        }
        return unsupportedData(str, str2);
    }

    private static final Void unsupportedData(String str, String str2) {
        throw new IllegalArgumentException("Unsupported type: " + str + ". " + str2);
    }

    /* renamed from: rememberAsyncImagePainter-GSdzBsE, reason: not valid java name */
    public static final AsyncImagePainter m3190rememberAsyncImagePainterGSdzBsE(AsyncImageState asyncImageState, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, ContentScale contentScale, int i, Composer composer, int i2) {
        composer.startReplaceableGroup(-1242991349);
        Trace.beginSection("rememberAsyncImagePainter");
        try {
            ImageRequest requestOf = UtilsKt.requestOf(asyncImageState.getModel(), composer, 0);
            validateRequest(requestOf);
            AsyncImagePainter.Input input = new AsyncImagePainter.Input(asyncImageState.getImageLoader(), requestOf, asyncImageState.getModelEqualityDelegate());
            composer.startReplaceableGroup(1596938077);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new AsyncImagePainter(input);
                composer.updateRememberedValue(rememberedValue);
            }
            AsyncImagePainter asyncImagePainter = (AsyncImagePainter) rememberedValue;
            composer.endReplaceableGroup();
            composer.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue2 = compositionScopedCoroutineScopeCanceller;
            }
            composer.endReplaceableGroup();
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
            composer.endReplaceableGroup();
            asyncImagePainter.setScope$coil_compose_core_release(coroutineScope);
            asyncImagePainter.setTransform$coil_compose_core_release(function1);
            asyncImagePainter.setOnState$coil_compose_core_release(function12);
            asyncImagePainter.setContentScale$coil_compose_core_release(contentScale);
            asyncImagePainter.m3187setFilterQualityvDHp3xo$coil_compose_core_release(i);
            asyncImagePainter.setPreviewHandler$coil_compose_core_release(previewHandler(composer, 0));
            asyncImagePainter.set_input$coil_compose_core_release(input);
            Trace.endSection();
            composer.endReplaceableGroup();
            return asyncImagePainter;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }
}
