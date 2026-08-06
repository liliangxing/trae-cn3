package coil3.compose.internal;

import android.content.Context;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p001ui.semantics.Role;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.IntSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import coil3.compose.AsyncImagePainter;
import coil3.request.ImageRequest;
import coil3.request.NullRequestDataException;
import coil3.size.Dimension;
import coil3.size.DimensionKt;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeResolver;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: utils.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a'\u0010\u0005\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n\u001a2\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0001\u001aX\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0013\u0018\u00010\fH\u0001\u001a\u0016\u0010\u001a\u001a\u00020\u001b*\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001cH\u0001\u001a\f\u0010\u001d\u001a\u00020\u001e*\u00020\u0007H\u0001\u001a\u0013\u0010\u001f\u001a\u00020 *\u00020!H\u0001¢\u0006\u0004\b\"\u0010#\u001a\u0015\u0010$\u001a\u0004\u0018\u00010 *\u00020!H\u0001¢\u0006\u0004\b%\u0010#\u001a\u001b\u0010&\u001a\u00020'*\u00020!2\u0006\u0010(\u001a\u00020'H\u0000¢\u0006\u0004\b)\u0010*\u001a\u001b\u0010+\u001a\u00020'*\u00020!2\u0006\u0010,\u001a\u00020'H\u0000¢\u0006\u0004\b-\u0010*\u001a\u0015\u0010.\u001a\u0004\u0018\u00010 *\u00020/H\u0000¢\u0006\u0004\b0\u0010#\u001a\u001b\u00101\u001a\u00020'*\u00020'2\f\u00102\u001a\b\u0012\u0004\u0012\u00020'03H\u0080\b\u001a\u0013\u00104\u001a\u000205*\u00020/H\u0000¢\u0006\u0004\b6\u00107\"\u0018\u00108\u001a\u00020\t*\u00020/8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:\"\u0014\u0010;\u001a\u00020<X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>¨\u0006?"}, d2 = {"requestOf", "Lcoil3/request/ImageRequest;", StrategyConstants.MODEL, "", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Lcoil3/request/ImageRequest;", "requestOfWithSizeResolver", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "useOptimization", "", "(Ljava/lang/Object;Landroidx/compose/ui/layout/ContentScale;ZLandroidx/compose/runtime/Composer;I)Lcoil3/request/ImageRequest;", "transformOf", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State;", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onStateOf", "", "onLoading", "Lcoil3/compose/AsyncImagePainter$State$Loading;", "onSuccess", "Lcoil3/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil3/compose/AsyncImagePainter$State$Error;", "contentDescription", "Landroidx/compose/ui/Modifier;", "", "toScale", "Lcoil3/size/Scale;", "toSize", "Lcoil3/size/Size;", "Landroidx/compose/ui/unit/Constraints;", "toSize-BRTryo0", "(J)Lcoil3/size/Size;", "toSizeOrNull", "toSizeOrNull-BRTryo0", "constrainWidth", "", "width", "constrainWidth-K40F9xA", "(JF)F", "constrainHeight", "height", "constrainHeight-K40F9xA", "toCoilSizeOrNull", "Landroidx/compose/ui/geometry/Size;", "toCoilSizeOrNull-uvyYCjk", "takeOrElse", "block", "Lkotlin/Function0;", "toIntSize", "Landroidx/compose/ui/unit/IntSize;", "toIntSize-uvyYCjk", "(J)J", "isPositive", "isPositive-uvyYCjk", "(J)Z", "safeImmediateMainDispatcher", "Lkotlin/coroutines/CoroutineContext;", "getSafeImmediateMainDispatcher", "()Lkotlin/coroutines/CoroutineContext;", "coil-compose-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class UtilsKt {
    private static final CoroutineContext safeImmediateMainDispatcher;

    public static final ImageRequest requestOf(Object obj, Composer composer, int i) {
        composer.startReplaceableGroup(1319639034);
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            composer.endReplaceableGroup();
            return imageRequest;
        }
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) consume;
        composer.startReplaceableGroup(690393439);
        boolean changed = composer.changed(context) | composer.changed(obj);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new ImageRequest.Builder(context).data(obj).build();
            composer.updateRememberedValue(rememberedValue);
        }
        ImageRequest imageRequest2 = (ImageRequest) rememberedValue;
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return imageRequest2;
    }

    public static final ImageRequest requestOfWithSizeResolver(Object obj, ContentScale contentScale, boolean z, Composer composer, int i) {
        LegacyConstraintsSizeResolver legacyConstraintsSizeResolver;
        composer.startReplaceableGroup(1576905390);
        boolean z2 = obj instanceof ImageRequest;
        if (z2) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (imageRequest.getDefined().getSizeResolver() != null) {
                composer.endReplaceableGroup();
                return imageRequest;
            }
        }
        if (Intrinsics.areEqual(contentScale, ContentScale.Companion.getNone())) {
            composer.startReplaceableGroup(-858705707);
            composer.endReplaceableGroup();
            legacyConstraintsSizeResolver = SizeResolver.ORIGINAL;
        } else if (z) {
            composer.startReplaceableGroup(-858641413);
            composer.startReplaceableGroup(1219228183);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new OptimizedConstraintsSizeResolver();
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            legacyConstraintsSizeResolver = (OptimizedConstraintsSizeResolver) rememberedValue;
        } else {
            composer.startReplaceableGroup(-858573058);
            composer.startReplaceableGroup(1219230388);
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new LegacyConstraintsSizeResolver();
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            legacyConstraintsSizeResolver = (LegacyConstraintsSizeResolver) rememberedValue2;
        }
        if (z2) {
            composer.startReplaceableGroup(-858478074);
            ImageRequest imageRequest2 = (ImageRequest) obj;
            composer.startReplaceableGroup(1219233669);
            boolean changed = composer.changed(imageRequest2) | composer.changed(legacyConstraintsSizeResolver);
            Object rememberedValue3 = composer.rememberedValue();
            if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = ImageRequest.newBuilder$default(imageRequest2, null, 1, null).size(legacyConstraintsSizeResolver).build();
                composer.updateRememberedValue(rememberedValue3);
            }
            ImageRequest imageRequest3 = (ImageRequest) rememberedValue3;
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            return imageRequest3;
        }
        composer.startReplaceableGroup(-858322330);
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) consume;
        composer.startReplaceableGroup(1219240274);
        boolean changed2 = composer.changed(context) | composer.changed(obj) | composer.changed(legacyConstraintsSizeResolver);
        Object rememberedValue4 = composer.rememberedValue();
        if (changed2 || rememberedValue4 == Composer.Companion.getEmpty()) {
            rememberedValue4 = new ImageRequest.Builder(context).data(obj).size(legacyConstraintsSizeResolver).build();
            composer.updateRememberedValue(rememberedValue4);
        }
        ImageRequest imageRequest4 = (ImageRequest) rememberedValue4;
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return imageRequest4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsyncImagePainter.State transformOf$lambda$5(Painter painter, Painter painter2, Painter painter3, AsyncImagePainter.State state) {
        if (state instanceof AsyncImagePainter.State.Loading) {
            return painter != null ? ((AsyncImagePainter.State.Loading) state).copy(painter) : (AsyncImagePainter.State.Loading) state;
        }
        if (!(state instanceof AsyncImagePainter.State.Error)) {
            return state;
        }
        AsyncImagePainter.State.Error error = (AsyncImagePainter.State.Error) state;
        if (error.getResult().getThrowable() instanceof NullRequestDataException) {
            if (painter2 != null) {
                error = AsyncImagePainter.State.Error.copy$default(error, painter2, null, 2, null);
            }
        } else if (painter3 != null) {
            error = AsyncImagePainter.State.Error.copy$default(error, painter3, null, 2, null);
        }
        return error;
    }

    public static final Function1<AsyncImagePainter.State, AsyncImagePainter.State> transformOf(final Painter painter, final Painter painter2, final Painter painter3) {
        if (painter != null || painter2 != null || painter3 != null) {
            return new Function1() { // from class: coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    AsyncImagePainter.State transformOf$lambda$5;
                    transformOf$lambda$5 = UtilsKt.transformOf$lambda$5(painter, painter3, painter2, (AsyncImagePainter.State) obj);
                    return transformOf$lambda$5;
                }
            };
        }
        return AsyncImagePainter.INSTANCE.getDefaultTransform();
    }

    public static final Function1<AsyncImagePainter.State, Unit> onStateOf(final Function1<? super AsyncImagePainter.State.Loading, Unit> function1, final Function1<? super AsyncImagePainter.State.Success, Unit> function12, final Function1<? super AsyncImagePainter.State.Error, Unit> function13) {
        if (function1 == null && function12 == null && function13 == null) {
            return null;
        }
        return new Function1() { // from class: coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit onStateOf$lambda$6;
                onStateOf$lambda$6 = UtilsKt.onStateOf$lambda$6(function1, function12, function13, (AsyncImagePainter.State) obj);
                return onStateOf$lambda$6;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onStateOf$lambda$6(Function1 function1, Function1 function12, Function1 function13, AsyncImagePainter.State state) {
        if (state instanceof AsyncImagePainter.State.Loading) {
            if (function1 != null) {
                function1.invoke(state);
            }
        } else if (state instanceof AsyncImagePainter.State.Success) {
            if (function12 != null) {
                function12.invoke(state);
            }
        } else if (state instanceof AsyncImagePainter.State.Error) {
            if (function13 != null) {
                function13.invoke(state);
            }
        } else if (!(state instanceof AsyncImagePainter.State.Empty)) {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }

    public static final Modifier contentDescription(Modifier modifier, final String str) {
        return str != null ? SemanticsModifierKt.semantics$default(modifier, false, new Function1() { // from class: coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit contentDescription$lambda$7;
                contentDescription$lambda$7 = UtilsKt.contentDescription$lambda$7(str, (SemanticsPropertyReceiver) obj);
                return contentDescription$lambda$7;
            }
        }, 1, null) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit contentDescription$lambda$7(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.m1878setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m1863getImageo7Vup1c());
        return Unit.INSTANCE;
    }

    public static final Scale toScale(ContentScale contentScale) {
        if (Intrinsics.areEqual(contentScale, ContentScale.Companion.getFit()) || Intrinsics.areEqual(contentScale, ContentScale.Companion.getInside())) {
            return Scale.FIT;
        }
        return Scale.FILL;
    }

    /* renamed from: toSize-BRTryo0, reason: not valid java name */
    public static final Size m3234toSizeBRTryo0(long j) {
        return new Size(Constraints.m2617getHasBoundedWidthimpl(j) ? Dimension.Pixels.m3263boximpl(DimensionKt.Dimension(Constraints.m2621getMaxWidthimpl(j))) : Dimension.Undefined.INSTANCE, Constraints.m2616getHasBoundedHeightimpl(j) ? Dimension.Pixels.m3263boximpl(DimensionKt.Dimension(Constraints.m2620getMaxHeightimpl(j))) : Dimension.Undefined.INSTANCE);
    }

    /* renamed from: toSizeOrNull-BRTryo0, reason: not valid java name */
    public static final Size m3235toSizeOrNullBRTryo0(long j) {
        if (Constraints.m2625isZeroimpl(j)) {
            return null;
        }
        return m3234toSizeBRTryo0(j);
    }

    /* renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final float m3230constrainWidthK40F9xA(long j, float f) {
        return RangesKt.coerceIn(f, Constraints.m2623getMinWidthimpl(j), Constraints.m2621getMaxWidthimpl(j));
    }

    /* renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final float m3229constrainHeightK40F9xA(long j, float f) {
        return RangesKt.coerceIn(f, Constraints.m2622getMinHeightimpl(j), Constraints.m2620getMaxHeightimpl(j));
    }

    public static final float takeOrElse(float f, Function0<Float> function0) {
        return !Float.isInfinite(f) && !Float.isNaN(f) ? f : ((Number) function0.invoke()).floatValue();
    }

    /* renamed from: toIntSize-uvyYCjk, reason: not valid java name */
    public static final long m3233toIntSizeuvyYCjk(long j) {
        return IntSizeKt.IntSize(MathKt.roundToInt(androidx.compose.ui.geometry.Size.getWidth-impl(j)), MathKt.roundToInt(androidx.compose.ui.geometry.Size.getHeight-impl(j)));
    }

    /* renamed from: isPositive-uvyYCjk, reason: not valid java name */
    public static final boolean m3231isPositiveuvyYCjk(long j) {
        return ((double) androidx.compose.ui.geometry.Size.getWidth-impl(j)) >= 0.5d && ((double) androidx.compose.ui.geometry.Size.getHeight-impl(j)) >= 0.5d;
    }

    public static final CoroutineContext getSafeImmediateMainDispatcher() {
        return safeImmediateMainDispatcher;
    }

    static {
        CoroutineContext coroutineContext;
        try {
            MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
            immediate.isDispatchNeeded(EmptyCoroutineContext.INSTANCE);
            coroutineContext = (CoroutineContext) immediate;
        } catch (Throwable unused) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        safeImmediateMainDispatcher = coroutineContext;
    }

    /* renamed from: toCoilSizeOrNull-uvyYCjk, reason: not valid java name */
    public static final Size m3232toCoilSizeOrNulluvyYCjk(long j) {
        if (j == androidx.compose.ui.geometry.Size.Companion.getUnspecified-NH-jbRc()) {
            return Size.ORIGINAL;
        }
        if (!m3231isPositiveuvyYCjk(j)) {
            return null;
        }
        float f = androidx.compose.ui.geometry.Size.getWidth-impl(j);
        Dimension.Undefined m3263boximpl = !Float.isInfinite(f) && !Float.isNaN(f) ? Dimension.Pixels.m3263boximpl(DimensionKt.Dimension(MathKt.roundToInt(androidx.compose.ui.geometry.Size.getWidth-impl(j)))) : Dimension.Undefined.INSTANCE;
        float f2 = androidx.compose.ui.geometry.Size.getHeight-impl(j);
        return new Size(m3263boximpl, (Float.isInfinite(f2) || Float.isNaN(f2)) ? false : true ? Dimension.Pixels.m3263boximpl(DimensionKt.Dimension(MathKt.roundToInt(androidx.compose.ui.geometry.Size.getHeight-impl(j)))) : Dimension.Undefined.INSTANCE);
    }
}
