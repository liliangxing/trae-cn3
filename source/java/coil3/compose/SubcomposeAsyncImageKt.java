package coil3.compose;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import coil3.ImageLoader;
import coil3.compose.AsyncImagePainter;
import coil3.compose.internal.AsyncImageState;
import coil3.compose.internal.ConstraintsSizeResolver;
import coil3.compose.internal.ImageOptionsUtilsKt;
import coil3.compose.internal.LegacyContentPainterElement;
import coil3.compose.internal.OptimizedSubcomposeContentPainterElement;
import coil3.compose.internal.UtilsKt;
import coil3.request.ImageRequest;
import coil3.size.SizeResolver;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: SubcomposeAsyncImage.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÓ\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2&\b\u0002\u0010\r\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122&\b\u0002\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122&\b\u0002\u0010\u0015\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'H\u0007¢\u0006\u0004\b(\u0010)\u001aÉ\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\u001c\u0010+\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0004\b,\u0010-\u001a¥\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010.\u001a\u00020/2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u001c\u0010+\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0003¢\u0006\u0004\b0\u00101\u001ae\u00102\u001a\u00020\u0001*\u00020\u000f2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010$\u001a\u00020%H\u0007¢\u0006\u0002\u00105\u001a\u0095\u0001\u00106\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122$\u0010\r\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122$\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122$\u0010\u0015\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0003¢\u0006\u0002\u00107¨\u00068"}, d2 = {"SubcomposeAsyncImage", "", StrategyConstants.MODEL, "", "contentDescription", "", "imageLoader", "Lcoil3/ImageLoader;", "modifier", "Landroidx/compose/ui/Modifier;", "transform", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State;", "loading", "Lkotlin/Function2;", "Lcoil3/compose/SubcomposeAsyncImageScope;", "Lcoil3/compose/AsyncImagePainter$State$Loading;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/runtime/Composable;", "success", "Lcoil3/compose/AsyncImagePainter$State$Success;", "error", "Lcoil3/compose/AsyncImagePainter$State$Error;", "onLoading", "onSuccess", "onError", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "clipToBounds", "", "modelEqualityDelegate", "Lcoil3/compose/EqualityDelegate;", "SubcomposeAsyncImage-TCQMD7g", "(Ljava/lang/Object;Ljava/lang/String;Lcoil3/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLcoil3/compose/EqualityDelegate;Landroidx/compose/runtime/Composer;III)V", "onState", StrategyConstants.CONTENT, "SubcomposeAsyncImage-FSyRiR8", "(Ljava/lang/Object;Ljava/lang/String;Lcoil3/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLcoil3/compose/EqualityDelegate;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", StrategyConstants.STATE, "Lcoil3/compose/internal/AsyncImageState;", "SubcomposeAsyncImage-gl8XCv8", "(Lcoil3/compose/internal/AsyncImageState;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SubcomposeAsyncImageContent", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Lcoil3/compose/SubcomposeAsyncImageScope;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ZLandroidx/compose/runtime/Composer;II)V", "contentOf", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;)Lkotlin/jvm/functions/Function3;", "coil-compose-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SubcomposeAsyncImageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SubcomposeAsyncImageContent$lambda$3(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Modifier modifier, Painter painter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, int i, int i2, Composer composer, int i3) {
        SubcomposeAsyncImageContent(subcomposeAsyncImageScope, modifier, painter, str, alignment, contentScale, f, colorFilter, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SubcomposeAsyncImage_gl8XCv8$lambda$1(AsyncImageState asyncImageState, String str, Modifier modifier, Function1 function1, Function1 function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Function3 function3, int i2, int i3, int i4, Composer composer, int i5) {
        m3205SubcomposeAsyncImagegl8XCv8(asyncImageState, str, modifier, function1, function12, alignment, contentScale, f, colorFilter, i, z, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* renamed from: SubcomposeAsyncImage-TCQMD7g, reason: not valid java name */
    public static final void m3204SubcomposeAsyncImageTCQMD7g(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function42, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function43, Function1<? super AsyncImagePainter.State.Loading, Unit> function12, Function1<? super AsyncImagePainter.State.Success, Unit> function13, Function1<? super AsyncImagePainter.State.Error, Unit> function14, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, EqualityDelegate equalityDelegate, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(733909996);
        Modifier modifier2 = (i4 & 8) != 0 ? (Modifier) Modifier.Companion : modifier;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform = (i4 & 16) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function44 = (i4 & 32) != 0 ? null : function4;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function45 = (i4 & 64) != 0 ? null : function42;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function46 = (i4 & 128) != 0 ? null : function43;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function15 = (i4 & 256) != 0 ? null : function12;
        Function1<? super AsyncImagePainter.State.Success, Unit> function16 = (i4 & 512) != 0 ? null : function13;
        Function1<? super AsyncImagePainter.State.Error, Unit> function17 = (i4 & 1024) != 0 ? null : function14;
        Alignment center = (i4 & 2048) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i4 & 4096) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i4 & 8192) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 16384) == 0 ? colorFilter : null;
        int i5 = (32768 & i4) != 0 ? DrawScope.Companion.getDefaultFilterQuality-f-v9h1I() : i;
        boolean z2 = (65536 & i4) != 0 ? true : z;
        AsyncImageState asyncImageState = new AsyncImageState(obj, (i4 & 131072) != 0 ? EqualityDelegateKt.getDefaultModelEqualityDelegate() : equalityDelegate, imageLoader);
        Function1<AsyncImagePainter.State, Unit> onStateOf = UtilsKt.onStateOf(function15, function16, function17);
        Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> contentOf = contentOf(function44, function45, function46);
        int i6 = i2 >> 3;
        int i7 = (i2 & 112) | (i6 & 896) | (i6 & 7168);
        int i8 = i3 << 12;
        m3205SubcomposeAsyncImagegl8XCv8(asyncImageState, str, modifier2, defaultTransform, onStateOf, center, fit, f2, colorFilter2, i5, z2, contentOf, composer, i7 | (458752 & i8) | (3670016 & i8) | (29360128 & i8) | (234881024 & i8) | (i8 & 1879048192), (i3 >> 18) & 14, 0);
        composer.endReplaceableGroup();
    }

    /* renamed from: SubcomposeAsyncImage-FSyRiR8, reason: not valid java name */
    public static final void m3203SubcomposeAsyncImageFSyRiR8(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, EqualityDelegate equalityDelegate, Function3<? super SubcomposeAsyncImageScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(-1878660401);
        int i5 = i2 >> 3;
        m3205SubcomposeAsyncImagegl8XCv8(new AsyncImageState(obj, (i4 & 4096) != 0 ? EqualityDelegateKt.getDefaultModelEqualityDelegate() : equalityDelegate, imageLoader), str, (i4 & 8) != 0 ? (Modifier) Modifier.Companion : modifier, (i4 & 16) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1, (i4 & 32) != 0 ? null : function12, (i4 & 64) != 0 ? Alignment.Companion.getCenter() : alignment, (i4 & 128) != 0 ? ContentScale.Companion.getFit() : contentScale, (i4 & 256) != 0 ? 1.0f : f, (i4 & 512) != 0 ? null : colorFilter, (i4 & 1024) != 0 ? DrawScope.Companion.getDefaultFilterQuality-f-v9h1I() : i, (i4 & 2048) != 0 ? true : z, function3, composer, (i2 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (i5 & 234881024) | ((i3 << 27) & 1879048192), ((i3 >> 3) & 14) | ((i3 >> 6) & 112), 0);
        composer.endReplaceableGroup();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x013b  */
    /* renamed from: SubcomposeAsyncImage-gl8XCv8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m3205SubcomposeAsyncImagegl8XCv8(final AsyncImageState asyncImageState, final String str, Modifier modifier, final Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, final Function1<? super AsyncImagePainter.State, Unit> function12, final Alignment alignment, final ContentScale contentScale, final float f, final ColorFilter colorFilter, final int i, final boolean z, final Function3<? super SubcomposeAsyncImageScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        final SizeResolver sizeResolver;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-205779950);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(asyncImageState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        int i7 = i4 & 4;
        if (i7 != 0) {
            i5 |= 384;
        } else if ((i2 & 384) == 0) {
            modifier2 = modifier;
            i5 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            if ((i4 & 8) == 0) {
                i5 |= 3072;
            } else if ((i2 & 3072) == 0) {
                i5 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
                if ((i4 & 16) != 0) {
                    i5 |= 24576;
                } else if ((i2 & 24576) == 0) {
                    i5 |= startRestartGroup.changedInstance(function12) ? 16384 : 8192;
                    if ((i4 & 32) == 0) {
                        i5 |= ProfileVerifier.CompilationStatus.f79xf2722a21;
                    } else if ((i2 & ProfileVerifier.CompilationStatus.f79xf2722a21) == 0) {
                        i5 |= startRestartGroup.changed(alignment) ? 131072 : 65536;
                    }
                    if ((i4 & 64) == 0) {
                        i5 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i5 |= startRestartGroup.changed(contentScale) ? 1048576 : 524288;
                    }
                    if ((i4 & 128) == 0) {
                        i5 |= 12582912;
                    } else if ((i2 & 12582912) == 0) {
                        i5 |= startRestartGroup.changed(f) ? 8388608 : 4194304;
                        if ((i4 & 256) != 0) {
                            i5 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i5 |= startRestartGroup.changed(colorFilter) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
                            if ((i4 & 512) == 0) {
                                i5 |= 805306368;
                            } else if ((805306368 & i2) == 0) {
                                i5 |= startRestartGroup.changed(i) ? 536870912 : 268435456;
                                if ((i4 & 1024) != 0) {
                                    i6 = i3 | 6;
                                } else if ((i3 & 6) == 0) {
                                    i6 = i3 | (startRestartGroup.changed(z) ? 4 : 2);
                                } else {
                                    i6 = i3;
                                }
                                if ((i4 & 2048) != 0) {
                                    i6 |= 48;
                                } else if ((i3 & 48) == 0) {
                                    i6 |= startRestartGroup.changedInstance(function3) ? 32 : 16;
                                }
                                if ((306783379 & i5) == 306783378 || (i6 & 19) != 18 || !startRestartGroup.getSkipping()) {
                                    Modifier modifier4 = i7 != 0 ? (Modifier) Modifier.Companion : modifier2;
                                    Object model = asyncImageState.getModel();
                                    ImageRequest imageRequest = model instanceof ImageRequest ? (ImageRequest) model : null;
                                    ImageRequest requestOfWithSizeResolver = UtilsKt.requestOfWithSizeResolver(asyncImageState.getModel(), contentScale, imageRequest == null && ImageOptionsUtilsKt.getUseOptimization(imageRequest), startRestartGroup, (i5 >> 15) & 112);
                                    int i8 = i5 >> 3;
                                    int i9 = i5 >> 6;
                                    int i10 = i5 >> 12;
                                    final AsyncImagePainter m3188rememberAsyncImagePainter0YpotYA = AsyncImagePainterKt.m3188rememberAsyncImagePainter0YpotYA(requestOfWithSizeResolver, asyncImageState.getImageLoader(), function1, function12, contentScale, i, null, startRestartGroup, (i8 & 7168) | (i8 & 896) | (i9 & 57344) | (i10 & 458752), 64);
                                    sizeResolver = requestOfWithSizeResolver.getSizeResolver();
                                    if (!(sizeResolver instanceof ConstraintsSizeResolver)) {
                                        startRestartGroup.startReplaceableGroup(-636927450);
                                        int i11 = (i9 & 14) | 384 | (i10 & 112);
                                        startRestartGroup.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        int i12 = i11 >> 3;
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(alignment, true, startRestartGroup, (i12 & 112) | (i12 & 14));
                                        startRestartGroup.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3 modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier4);
                                        int i13 = ((((i11 << 3) & 112) << 9) & 7168) | 6;
                                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        startRestartGroup.startReusableNode();
                                        if (startRestartGroup.getInserting()) {
                                            startRestartGroup.createNode(constructor);
                                        } else {
                                            startRestartGroup.useNode();
                                        }
                                        Composer composer2 = Updater.constructor-impl(startRestartGroup);
                                        Updater.set-impl(composer2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl(startRestartGroup)), startRestartGroup, Integer.valueOf((i13 >> 3) & 112));
                                        startRestartGroup.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        function3.invoke(new RealSubcomposeAsyncImageScope(BoxScopeInstance.INSTANCE, m3188rememberAsyncImagePainter0YpotYA, str, alignment, contentScale, f, colorFilter, z), startRestartGroup, Integer.valueOf(i6 & 112));
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        startRestartGroup.endReplaceableGroup();
                                        startRestartGroup.endNode();
                                        startRestartGroup.endReplaceableGroup();
                                        startRestartGroup.endReplaceableGroup();
                                        startRestartGroup.endReplaceableGroup();
                                    } else {
                                        startRestartGroup.startReplaceableGroup(-636238723);
                                        BoxWithConstraintsKt.BoxWithConstraints(modifier4, alignment, true, ComposableLambdaKt.composableLambda(startRestartGroup, -374957172, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: coil3.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImage$2
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                                invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, int i14) {
                                                if ((i14 & 6) == 0) {
                                                    i14 |= composer3.changed(boxWithConstraintsScope) ? 4 : 2;
                                                }
                                                if ((i14 & 19) != 18 || !composer3.getSkipping()) {
                                                    ((ConstraintsSizeResolver) SizeResolver.this).mo3211setConstraintsBRTryo0(boxWithConstraintsScope.getConstraints-msEJaDk());
                                                    function3.invoke(new RealSubcomposeAsyncImageScope((BoxScope) boxWithConstraintsScope, m3188rememberAsyncImagePainter0YpotYA, str, alignment, contentScale, f, colorFilter, z), composer3, 0);
                                                } else {
                                                    composer3.skipToGroupEnd();
                                                }
                                            }
                                        }), startRestartGroup, (i9 & 14) | 3456 | (i10 & 112), 0);
                                        startRestartGroup.endReplaceableGroup();
                                    }
                                    modifier3 = modifier4;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    modifier3 = modifier2;
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2() { // from class: coil3.compose.SubcomposeAsyncImageKt$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj, Object obj2) {
                                            Unit SubcomposeAsyncImage_gl8XCv8$lambda$1;
                                            SubcomposeAsyncImage_gl8XCv8$lambda$1 = SubcomposeAsyncImageKt.SubcomposeAsyncImage_gl8XCv8$lambda$1(AsyncImageState.this, str, modifier3, function1, function12, alignment, contentScale, f, colorFilter, i, z, function3, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                            return SubcomposeAsyncImage_gl8XCv8$lambda$1;
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            if ((i4 & 1024) != 0) {
                            }
                            if ((i4 & 2048) != 0) {
                            }
                            if ((306783379 & i5) == 306783378) {
                            }
                            if (i7 != 0) {
                            }
                            Object model2 = asyncImageState.getModel();
                            if (model2 instanceof ImageRequest) {
                            }
                            ImageRequest requestOfWithSizeResolver2 = UtilsKt.requestOfWithSizeResolver(asyncImageState.getModel(), contentScale, imageRequest == null && ImageOptionsUtilsKt.getUseOptimization(imageRequest), startRestartGroup, (i5 >> 15) & 112);
                            int i82 = i5 >> 3;
                            int i92 = i5 >> 6;
                            int i102 = i5 >> 12;
                            final AsyncImagePainter m3188rememberAsyncImagePainter0YpotYA2 = AsyncImagePainterKt.m3188rememberAsyncImagePainter0YpotYA(requestOfWithSizeResolver2, asyncImageState.getImageLoader(), function1, function12, contentScale, i, null, startRestartGroup, (i82 & 7168) | (i82 & 896) | (i92 & 57344) | (i102 & 458752), 64);
                            sizeResolver = requestOfWithSizeResolver2.getSizeResolver();
                            if (!(sizeResolver instanceof ConstraintsSizeResolver)) {
                            }
                            modifier3 = modifier4;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        if ((i4 & 512) == 0) {
                        }
                        if ((i4 & 1024) != 0) {
                        }
                        if ((i4 & 2048) != 0) {
                        }
                        if ((306783379 & i5) == 306783378) {
                        }
                        if (i7 != 0) {
                        }
                        Object model22 = asyncImageState.getModel();
                        if (model22 instanceof ImageRequest) {
                        }
                        ImageRequest requestOfWithSizeResolver22 = UtilsKt.requestOfWithSizeResolver(asyncImageState.getModel(), contentScale, imageRequest == null && ImageOptionsUtilsKt.getUseOptimization(imageRequest), startRestartGroup, (i5 >> 15) & 112);
                        int i822 = i5 >> 3;
                        int i922 = i5 >> 6;
                        int i1022 = i5 >> 12;
                        final AsyncImagePainter m3188rememberAsyncImagePainter0YpotYA22 = AsyncImagePainterKt.m3188rememberAsyncImagePainter0YpotYA(requestOfWithSizeResolver22, asyncImageState.getImageLoader(), function1, function12, contentScale, i, null, startRestartGroup, (i822 & 7168) | (i822 & 896) | (i922 & 57344) | (i1022 & 458752), 64);
                        sizeResolver = requestOfWithSizeResolver22.getSizeResolver();
                        if (!(sizeResolver instanceof ConstraintsSizeResolver)) {
                        }
                        modifier3 = modifier4;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    if ((i4 & 256) != 0) {
                    }
                    if ((i4 & 512) == 0) {
                    }
                    if ((i4 & 1024) != 0) {
                    }
                    if ((i4 & 2048) != 0) {
                    }
                    if ((306783379 & i5) == 306783378) {
                    }
                    if (i7 != 0) {
                    }
                    Object model222 = asyncImageState.getModel();
                    if (model222 instanceof ImageRequest) {
                    }
                    ImageRequest requestOfWithSizeResolver222 = UtilsKt.requestOfWithSizeResolver(asyncImageState.getModel(), contentScale, imageRequest == null && ImageOptionsUtilsKt.getUseOptimization(imageRequest), startRestartGroup, (i5 >> 15) & 112);
                    int i8222 = i5 >> 3;
                    int i9222 = i5 >> 6;
                    int i10222 = i5 >> 12;
                    final AsyncImagePainter m3188rememberAsyncImagePainter0YpotYA222 = AsyncImagePainterKt.m3188rememberAsyncImagePainter0YpotYA(requestOfWithSizeResolver222, asyncImageState.getImageLoader(), function1, function12, contentScale, i, null, startRestartGroup, (i8222 & 7168) | (i8222 & 896) | (i9222 & 57344) | (i10222 & 458752), 64);
                    sizeResolver = requestOfWithSizeResolver222.getSizeResolver();
                    if (!(sizeResolver instanceof ConstraintsSizeResolver)) {
                    }
                    modifier3 = modifier4;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                if ((i4 & 32) == 0) {
                }
                if ((i4 & 64) == 0) {
                }
                if ((i4 & 128) == 0) {
                }
                if ((i4 & 256) != 0) {
                }
                if ((i4 & 512) == 0) {
                }
                if ((i4 & 1024) != 0) {
                }
                if ((i4 & 2048) != 0) {
                }
                if ((306783379 & i5) == 306783378) {
                }
                if (i7 != 0) {
                }
                Object model2222 = asyncImageState.getModel();
                if (model2222 instanceof ImageRequest) {
                }
                ImageRequest requestOfWithSizeResolver2222 = UtilsKt.requestOfWithSizeResolver(asyncImageState.getModel(), contentScale, imageRequest == null && ImageOptionsUtilsKt.getUseOptimization(imageRequest), startRestartGroup, (i5 >> 15) & 112);
                int i82222 = i5 >> 3;
                int i92222 = i5 >> 6;
                int i102222 = i5 >> 12;
                final AsyncImagePainter m3188rememberAsyncImagePainter0YpotYA2222 = AsyncImagePainterKt.m3188rememberAsyncImagePainter0YpotYA(requestOfWithSizeResolver2222, asyncImageState.getImageLoader(), function1, function12, contentScale, i, null, startRestartGroup, (i82222 & 7168) | (i82222 & 896) | (i92222 & 57344) | (i102222 & 458752), 64);
                sizeResolver = requestOfWithSizeResolver2222.getSizeResolver();
                if (!(sizeResolver instanceof ConstraintsSizeResolver)) {
                }
                modifier3 = modifier4;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            if ((i4 & 16) != 0) {
            }
            if ((i4 & 32) == 0) {
            }
            if ((i4 & 64) == 0) {
            }
            if ((i4 & 128) == 0) {
            }
            if ((i4 & 256) != 0) {
            }
            if ((i4 & 512) == 0) {
            }
            if ((i4 & 1024) != 0) {
            }
            if ((i4 & 2048) != 0) {
            }
            if ((306783379 & i5) == 306783378) {
            }
            if (i7 != 0) {
            }
            Object model22222 = asyncImageState.getModel();
            if (model22222 instanceof ImageRequest) {
            }
            ImageRequest requestOfWithSizeResolver22222 = UtilsKt.requestOfWithSizeResolver(asyncImageState.getModel(), contentScale, imageRequest == null && ImageOptionsUtilsKt.getUseOptimization(imageRequest), startRestartGroup, (i5 >> 15) & 112);
            int i822222 = i5 >> 3;
            int i922222 = i5 >> 6;
            int i1022222 = i5 >> 12;
            final AsyncImagePainter m3188rememberAsyncImagePainter0YpotYA22222 = AsyncImagePainterKt.m3188rememberAsyncImagePainter0YpotYA(requestOfWithSizeResolver22222, asyncImageState.getImageLoader(), function1, function12, contentScale, i, null, startRestartGroup, (i822222 & 7168) | (i822222 & 896) | (i922222 & 57344) | (i1022222 & 458752), 64);
            sizeResolver = requestOfWithSizeResolver22222.getSizeResolver();
            if (!(sizeResolver instanceof ConstraintsSizeResolver)) {
            }
            modifier3 = modifier4;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i4 & 8) == 0) {
        }
        if ((i4 & 16) != 0) {
        }
        if ((i4 & 32) == 0) {
        }
        if ((i4 & 64) == 0) {
        }
        if ((i4 & 128) == 0) {
        }
        if ((i4 & 256) != 0) {
        }
        if ((i4 & 512) == 0) {
        }
        if ((i4 & 1024) != 0) {
        }
        if ((i4 & 2048) != 0) {
        }
        if ((306783379 & i5) == 306783378) {
        }
        if (i7 != 0) {
        }
        Object model222222 = asyncImageState.getModel();
        if (model222222 instanceof ImageRequest) {
        }
        ImageRequest requestOfWithSizeResolver222222 = UtilsKt.requestOfWithSizeResolver(asyncImageState.getModel(), contentScale, imageRequest == null && ImageOptionsUtilsKt.getUseOptimization(imageRequest), startRestartGroup, (i5 >> 15) & 112);
        int i8222222 = i5 >> 3;
        int i9222222 = i5 >> 6;
        int i10222222 = i5 >> 12;
        final AsyncImagePainter m3188rememberAsyncImagePainter0YpotYA222222 = AsyncImagePainterKt.m3188rememberAsyncImagePainter0YpotYA(requestOfWithSizeResolver222222, asyncImageState.getImageLoader(), function1, function12, contentScale, i, null, startRestartGroup, (i8222222 & 7168) | (i8222222 & 896) | (i9222222 & 57344) | (i10222222 & 458752), 64);
        sizeResolver = requestOfWithSizeResolver222222.getSizeResolver();
        if (!(sizeResolver instanceof ConstraintsSizeResolver)) {
        }
        modifier3 = modifier4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:92:0x01a7, code lost:
    
        if (coil3.compose.internal.ImageOptionsUtilsKt.getUseOptimization(r2) != true) goto L151;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SubcomposeAsyncImageContent(final SubcomposeAsyncImageScope subcomposeAsyncImageScope, Modifier modifier, Painter painter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Painter painter2;
        String str2;
        Alignment alignment2;
        ContentScale contentScale2;
        float f2;
        ColorFilter colorFilter2;
        boolean z2;
        boolean z3;
        StateFlow<AsyncImagePainter.Input> input;
        AsyncImagePainter.Input input2;
        ScopeUpdateScope endRestartGroup;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(-1375825518);
        if ((Integer.MIN_VALUE & i2) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(subcomposeAsyncImageScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 1;
        if (i11 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 384) != 0) {
                if ((i2 & 2) == 0) {
                    painter2 = painter;
                    if (startRestartGroup.changedInstance(painter2)) {
                        i10 = 256;
                        i3 |= i10;
                    }
                } else {
                    painter2 = painter;
                }
                i10 = 128;
                i3 |= i10;
            } else {
                painter2 = painter;
            }
            if ((i & 3072) != 0) {
                if ((i2 & 4) == 0) {
                    str2 = str;
                    if (startRestartGroup.changed(str2)) {
                        i9 = 2048;
                        i3 |= i9;
                    }
                } else {
                    str2 = str;
                }
                i9 = 1024;
                i3 |= i9;
            } else {
                str2 = str;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 8) == 0) {
                    alignment2 = alignment;
                    if (startRestartGroup.changed(alignment2)) {
                        i8 = 16384;
                        i3 |= i8;
                    }
                } else {
                    alignment2 = alignment;
                }
                i8 = 8192;
                i3 |= i8;
            } else {
                alignment2 = alignment;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 16) == 0) {
                    contentScale2 = contentScale;
                    if (startRestartGroup.changed(contentScale2)) {
                        i7 = 131072;
                        i3 |= i7;
                    }
                } else {
                    contentScale2 = contentScale;
                }
                i7 = 65536;
                i3 |= i7;
            } else {
                contentScale2 = contentScale;
            }
            if ((1572864 & i) != 0) {
                if ((i2 & 32) == 0) {
                    f2 = f;
                    if (startRestartGroup.changed(f2)) {
                        i6 = 1048576;
                        i3 |= i6;
                    }
                } else {
                    f2 = f;
                }
                i6 = 524288;
                i3 |= i6;
            } else {
                f2 = f;
            }
            if ((12582912 & i) != 0) {
                if ((i2 & 64) == 0) {
                    colorFilter2 = colorFilter;
                    if (startRestartGroup.changed(colorFilter2)) {
                        i5 = 8388608;
                        i3 |= i5;
                    }
                } else {
                    colorFilter2 = colorFilter;
                }
                i5 = 4194304;
                i3 |= i5;
            } else {
                colorFilter2 = colorFilter;
            }
            if ((100663296 & i) != 0) {
                if ((i2 & 128) == 0) {
                    z2 = z;
                    if (startRestartGroup.changed(z2)) {
                        i4 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                        i3 |= i4;
                    }
                } else {
                    z2 = z;
                }
                i4 = 33554432;
                i3 |= i4;
            } else {
                z2 = z;
            }
            if ((i3 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    if (i11 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 2) != 0) {
                        painter2 = subcomposeAsyncImageScope.getPainter();
                    }
                    if ((i2 & 4) != 0) {
                        str2 = subcomposeAsyncImageScope.getContentDescription();
                    }
                    if ((i2 & 8) != 0) {
                        alignment2 = subcomposeAsyncImageScope.getAlignment();
                    }
                    if ((i2 & 16) != 0) {
                        contentScale2 = subcomposeAsyncImageScope.getContentScale();
                    }
                    if ((i2 & 32) != 0) {
                        f2 = subcomposeAsyncImageScope.getAlpha();
                    }
                    if ((i2 & 64) != 0) {
                        colorFilter2 = subcomposeAsyncImageScope.getColorFilter();
                    }
                    if ((i2 & 128) != 0) {
                        z2 = subcomposeAsyncImageScope.getClipToBounds();
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                }
                startRestartGroup.endDefaults();
                AsyncImagePainter asyncImagePainter = !(painter2 instanceof AsyncImagePainter) ? (AsyncImagePainter) painter2 : null;
                z3 = (asyncImagePainter == null || (input = asyncImagePainter.getInput()) == null || (input2 = (AsyncImagePainter.Input) input.getValue()) == null || (r2 = input2.getRequest()) == null) ? false : true;
                if (!z3) {
                    startRestartGroup.startReplaceableGroup(-1343017698);
                    Modifier then = modifier2.then(new OptimizedSubcomposeContentPainterElement(painter2, alignment2, contentScale2, f2, colorFilter2, z2, str2));
                    MeasurePolicy useMinConstraintsMeasurePolicy = AsyncImageKt.getUseMinConstraintsMeasurePolicy();
                    startRestartGroup.startReplaceableGroup(544976794);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(1)123@4784L23,126@4935L385:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, then);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    final Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    startRestartGroup.startReplaceableGroup(1405779621);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(new Function0<ComposeUiNode>() { // from class: coil3.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$$inlined$Layout$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.ComposeUiNode, java.lang.Object] */
                            public final ComposeUiNode invoke() {
                                return constructor.invoke();
                            }
                        });
                    } else {
                        startRestartGroup.useNode();
                    }
                    Composer composer2 = Updater.constructor-impl(startRestartGroup);
                    Updater.set-impl(composer2, useMinConstraintsMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.set-impl(composer2, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                } else {
                    startRestartGroup.startReplaceableGroup(-1342468564);
                    Modifier contentDescription = UtilsKt.contentDescription(modifier2, str2);
                    if (z2) {
                        contentDescription = ClipKt.clipToBounds(contentDescription);
                    }
                    Modifier then2 = contentDescription.then(new LegacyContentPainterElement(painter2, alignment2, contentScale2, f2, colorFilter2));
                    MeasurePolicy useMinConstraintsMeasurePolicy2 = AsyncImageKt.getUseMinConstraintsMeasurePolicy();
                    startRestartGroup.startReplaceableGroup(544976794);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(1)123@4784L23,126@4935L385:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, then2);
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    final Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    startRestartGroup.startReplaceableGroup(1405779621);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(new Function0<ComposeUiNode>() { // from class: coil3.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$$inlined$Layout$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.ComposeUiNode, java.lang.Object] */
                            public final ComposeUiNode invoke() {
                                return constructor2.invoke();
                            }
                        });
                    } else {
                        startRestartGroup.useNode();
                    }
                    Composer composer3 = Updater.constructor-impl(startRestartGroup);
                    Updater.set-impl(composer3, useMinConstraintsMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.set-impl(composer3, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
            }
            final Modifier modifier3 = modifier2;
            final Painter painter3 = painter2;
            final String str3 = str2;
            final Alignment alignment3 = alignment2;
            final ContentScale contentScale3 = contentScale2;
            final float f3 = f2;
            final ColorFilter colorFilter3 = colorFilter2;
            final boolean z4 = z2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: coil3.compose.SubcomposeAsyncImageKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        Unit SubcomposeAsyncImageContent$lambda$3;
                        SubcomposeAsyncImageContent$lambda$3 = SubcomposeAsyncImageKt.SubcomposeAsyncImageContent$lambda$3(SubcomposeAsyncImageScope.this, modifier3, painter3, str3, alignment3, contentScale3, f3, colorFilter3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        return SubcomposeAsyncImageContent$lambda$3;
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((12582912 & i) != 0) {
        }
        if ((100663296 & i) != 0) {
        }
        if ((i3 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i11 != 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        startRestartGroup.endDefaults();
        if (!(painter2 instanceof AsyncImagePainter)) {
        }
        if (asyncImagePainter == null) {
        }
        if (!z3) {
        }
        final Modifier modifier32 = modifier2;
        final Painter painter32 = painter2;
        final String str32 = str2;
        final Alignment alignment32 = alignment2;
        final ContentScale contentScale32 = contentScale2;
        final float f32 = f2;
        final ColorFilter colorFilter32 = colorFilter2;
        final boolean z42 = z2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> contentOf(final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function42, final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function43) {
        return (function4 == null && function42 == null && function43 == null) ? ComposableSingletons$SubcomposeAsyncImageKt.INSTANCE.m3192getLambda1$coil_compose_core_release() : ComposableLambdaKt.composableLambdaInstance(-1106738291, true, new Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit>() { // from class: coil3.compose.SubcomposeAsyncImageKt$contentOf$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((SubcomposeAsyncImageScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:22:0x00aa  */
            /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Composer composer, int i) {
                int i2;
                if ((i & 6) == 0) {
                    i2 = i | (composer.changed(subcomposeAsyncImageScope) ? 4 : 2);
                } else {
                    i2 = i;
                }
                if ((i2 & 19) != 18 || !composer.getSkipping()) {
                    boolean z = false;
                    boolean z2 = true;
                    AsyncImagePainter.State state = (AsyncImagePainter.State) SnapshotStateKt.collectAsState(subcomposeAsyncImageScope.getPainter().getState(), (CoroutineContext) null, composer, 0, 1).getValue();
                    if (state instanceof AsyncImagePainter.State.Loading) {
                        composer.startReplaceableGroup(-715028864);
                        Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Loading, Composer, Integer, Unit> function44 = function4;
                        if (function44 != null) {
                            function44.invoke(subcomposeAsyncImageScope, state, composer, Integer.valueOf(i2 & 14));
                            Unit unit = Unit.INSTANCE;
                        } else {
                            z = true;
                        }
                        composer.endReplaceableGroup();
                    } else if (state instanceof AsyncImagePainter.State.Success) {
                        composer.startReplaceableGroup(-714935616);
                        Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Success, Composer, Integer, Unit> function45 = function42;
                        if (function45 != null) {
                            function45.invoke(subcomposeAsyncImageScope, state, composer, Integer.valueOf(i2 & 14));
                            Unit unit2 = Unit.INSTANCE;
                        } else {
                            z = true;
                        }
                        composer.endReplaceableGroup();
                    } else {
                        if (!(state instanceof AsyncImagePainter.State.Error)) {
                            if (!(state instanceof AsyncImagePainter.State.Empty)) {
                                composer.startReplaceableGroup(1362405237);
                                composer.endReplaceableGroup();
                                throw new NoWhenBranchMatchedException();
                            }
                            composer.startReplaceableGroup(-714758761);
                            composer.endReplaceableGroup();
                            if (z2) {
                                return;
                            }
                            SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(subcomposeAsyncImageScope, null, null, null, null, null, 0.0f, null, false, composer, i2 & 14, 255);
                            return;
                        }
                        composer.startReplaceableGroup(-714844476);
                        Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Error, Composer, Integer, Unit> function46 = function43;
                        if (function46 != null) {
                            function46.invoke(subcomposeAsyncImageScope, state, composer, Integer.valueOf(i2 & 14));
                            Unit unit3 = Unit.INSTANCE;
                        } else {
                            z = true;
                        }
                        composer.endReplaceableGroup();
                    }
                    z2 = z;
                    if (z2) {
                    }
                } else {
                    composer.skipToGroupEnd();
                }
            }
        });
    }
}
