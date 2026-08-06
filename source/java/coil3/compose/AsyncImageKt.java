package coil3.compose;

import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import coil3.ImageLoader;
import coil3.compose.AsyncImagePainter;
import coil3.compose.internal.AsyncImageState;
import coil3.compose.internal.LegacyContentPainterElement;
import coil3.compose.internal.OptimizedContentPainterElement;
import coil3.compose.internal.UtilsKt;
import coil3.request.ImageRequest;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AsyncImage.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aé\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007¢\u0006\u0004\b#\u0010$\u001a«\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0\u000f2\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007¢\u0006\u0004\b(\u0010)\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0\u000f2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0003¢\u0006\u0004\b,\u0010-\"\u0014\u0010.\u001a\u00020/X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u00062"}, d2 = {"AsyncImage", "", StrategyConstants.MODEL, "", "contentDescription", "", "imageLoader", "Lcoil3/ImageLoader;", "modifier", "Landroidx/compose/ui/Modifier;", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State$Loading;", "onSuccess", "Lcoil3/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil3/compose/AsyncImagePainter$State$Error;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "clipToBounds", "", "modelEqualityDelegate", "Lcoil3/compose/EqualityDelegate;", "AsyncImage-J-FEaFM", "(Ljava/lang/Object;Ljava/lang/String;Lcoil3/ImageLoader;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLcoil3/compose/EqualityDelegate;Landroidx/compose/runtime/Composer;III)V", "transform", "Lcoil3/compose/AsyncImagePainter$State;", "onState", "AsyncImage-QgsmV_s", "(Ljava/lang/Object;Ljava/lang/String;Lcoil3/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLcoil3/compose/EqualityDelegate;Landroidx/compose/runtime/Composer;III)V", StrategyConstants.STATE, "Lcoil3/compose/internal/AsyncImageState;", "AsyncImage-76YX9Dk", "(Lcoil3/compose/internal/AsyncImageState;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLandroidx/compose/runtime/Composer;II)V", "UseMinConstraintsMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getUseMinConstraintsMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "coil-compose-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AsyncImageKt {
    private static final MeasurePolicy UseMinConstraintsMeasurePolicy = AsyncImageKt$UseMinConstraintsMeasurePolicy$1.INSTANCE;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AsyncImage_76YX9Dk$lambda$2(AsyncImageState asyncImageState, String str, Modifier modifier, Function1 function1, Function1 function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, int i2, int i3, Composer composer, int i4) {
        m3180AsyncImage76YX9Dk(asyncImageState, str, modifier, function1, function12, alignment, contentScale, f, colorFilter, i, z, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    /* renamed from: AsyncImage-J-FEaFM, reason: not valid java name */
    public static final void m3181AsyncImageJFEaFM(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Painter painter, Painter painter2, Painter painter3, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, EqualityDelegate equalityDelegate, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(-1557279975);
        Modifier modifier2 = (i4 & 8) != 0 ? (Modifier) Modifier.Companion : modifier;
        Painter painter4 = (i4 & 16) != 0 ? null : painter;
        Painter painter5 = (i4 & 32) != 0 ? null : painter2;
        Painter painter6 = (i4 & 64) != 0 ? painter5 : painter3;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function14 = (i4 & 128) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function15 = (i4 & 256) != 0 ? null : function12;
        Function1<? super AsyncImagePainter.State.Error, Unit> function16 = (i4 & 512) != 0 ? null : function13;
        int i5 = i3 << 15;
        m3180AsyncImage76YX9Dk(new AsyncImageState(obj, (i4 & 65536) != 0 ? EqualityDelegateKt.getDefaultModelEqualityDelegate() : equalityDelegate, imageLoader), str, modifier2, UtilsKt.transformOf(painter4, painter5, painter6), UtilsKt.onStateOf(function14, function15, function16), (i4 & 1024) != 0 ? Alignment.Companion.getCenter() : alignment, (i4 & 2048) != 0 ? ContentScale.Companion.getFit() : contentScale, (i4 & 4096) != 0 ? 1.0f : f, (i4 & 8192) == 0 ? colorFilter : null, (i4 & 16384) != 0 ? DrawScope.Companion.getDefaultFilterQuality-f-v9h1I() : i, (32768 & i4) != 0 ? true : z, composer, (i2 & 112) | ((i2 >> 3) & 896) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (234881024 & i5) | (i5 & 1879048192), (i3 >> 15) & 14);
        composer.endReplaceableGroup();
    }

    /* renamed from: AsyncImage-QgsmV_s, reason: not valid java name */
    public static final void m3182AsyncImageQgsmV_s(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, EqualityDelegate equalityDelegate, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(-9854129);
        int i5 = i2 >> 3;
        m3180AsyncImage76YX9Dk(new AsyncImageState(obj, (i4 & 4096) != 0 ? EqualityDelegateKt.getDefaultModelEqualityDelegate() : equalityDelegate, imageLoader), str, (i4 & 8) != 0 ? (Modifier) Modifier.Companion : modifier, (i4 & 16) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1, (i4 & 32) != 0 ? null : function12, (i4 & 64) != 0 ? Alignment.Companion.getCenter() : alignment, (i4 & 128) != 0 ? ContentScale.Companion.getFit() : contentScale, (i4 & 256) != 0 ? 1.0f : f, (i4 & 512) != 0 ? null : colorFilter, (i4 & 1024) != 0 ? DrawScope.Companion.getDefaultFilterQuality-f-v9h1I() : i, (i4 & 2048) != 0 ? true : z, composer, (i2 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (i5 & 234881024) | ((i3 << 27) & 1879048192), (i3 >> 3) & 14);
        composer.endReplaceableGroup();
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x010d, code lost:
    
        if (coil3.compose.internal.ImageOptionsUtilsKt.getUseOptimization(r1) == true) goto L99;
     */
    /* renamed from: AsyncImage-76YX9Dk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m3180AsyncImage76YX9Dk(final AsyncImageState asyncImageState, final String str, final Modifier modifier, final Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, final Function1<? super AsyncImagePainter.State, Unit> function12, final Alignment alignment, final ContentScale contentScale, final float f, final ColorFilter colorFilter, final int i, final boolean z, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1236588022);
        if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(asyncImageState) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= startRestartGroup.changedInstance(function12) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i4 |= startRestartGroup.changed(alignment) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i4 |= startRestartGroup.changed(contentScale) ? 1048576 : 524288;
        }
        if ((12582912 & i2) == 0) {
            i4 |= startRestartGroup.changed(f) ? 8388608 : 4194304;
        }
        if ((100663296 & i2) == 0) {
            i4 |= startRestartGroup.changed(colorFilter) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((805306368 & i2) == 0) {
            i4 |= startRestartGroup.changed(i) ? 536870912 : 268435456;
        }
        if ((i3 & 6) == 0) {
            i5 = i3 | (startRestartGroup.changed(z) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i4 & 306783379) != 306783378 || (i5 & 3) != 2 || !startRestartGroup.getSkipping()) {
            Object model = asyncImageState.getModel();
            ImageRequest imageRequest = model instanceof ImageRequest ? (ImageRequest) model : null;
            boolean z2 = imageRequest != null;
            int i6 = i4 >> 15;
            ImageRequest requestOfWithSizeResolver = UtilsKt.requestOfWithSizeResolver(asyncImageState.getModel(), contentScale, z2, startRestartGroup, i6 & 112);
            AsyncImagePainterKt.validateRequest(requestOfWithSizeResolver);
            if (z2) {
                startRestartGroup.startReplaceableGroup(780540459);
                Modifier then = modifier.then(new OptimizedContentPainterElement(requestOfWithSizeResolver, asyncImageState.getImageLoader(), asyncImageState.getModelEqualityDelegate(), function1, function12, i, alignment, contentScale, f, colorFilter, z, AsyncImagePainterKt.previewHandler(startRestartGroup, 0), str, null));
                MeasurePolicy measurePolicy = UseMinConstraintsMeasurePolicy;
                composer2 = startRestartGroup;
                composer2.startReplaceableGroup(544976794);
                ComposerKt.sourceInformation(composer2, "CC(Layout)P(1)123@4784L23,126@4935L385:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, then);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                final Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                composer2.startReplaceableGroup(1405779621);
                ComposerKt.sourceInformation(composer2, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(new Function0<ComposeUiNode>() { // from class: coil3.compose.AsyncImageKt$AsyncImage-76YX9Dk$$inlined$Layout$1
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
                    composer2.useNode();
                }
                Composer composer3 = Updater.constructor-impl(composer2);
                Updater.set-impl(composer3, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.set-impl(composer3, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
            } else {
                composer2 = startRestartGroup;
                composer2.startReplaceableGroup(781400585);
                EqualityDelegate modelEqualityDelegate = asyncImageState.getModelEqualityDelegate();
                ImageLoader imageLoader = asyncImageState.getImageLoader();
                composer2.startReplaceableGroup(-1498814297);
                boolean changed = composer2.changed(modelEqualityDelegate) | composer2.changed(requestOfWithSizeResolver) | composer2.changed(imageLoader);
                Object rememberedValue = composer2.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new AsyncImageState(requestOfWithSizeResolver, asyncImageState.getModelEqualityDelegate(), asyncImageState.getImageLoader());
                    composer2.updateRememberedValue(rememberedValue);
                }
                AsyncImageState asyncImageState2 = (AsyncImageState) rememberedValue;
                composer2.endReplaceableGroup();
                int i7 = i4 >> 6;
                AsyncImagePainter m3190rememberAsyncImagePainterGSdzBsE = AsyncImagePainterKt.m3190rememberAsyncImagePainterGSdzBsE(asyncImageState2, function1, function12, contentScale, i, composer2, ((i4 >> 9) & 7168) | (i7 & 896) | (i7 & 112) | (i6 & 57344));
                Modifier.Companion sizeResolver = requestOfWithSizeResolver.getSizeResolver();
                if (!(sizeResolver instanceof Modifier)) {
                    sizeResolver = Modifier.Companion;
                }
                Modifier modifier2 = (Modifier) sizeResolver;
                Modifier contentDescription = UtilsKt.contentDescription(modifier, str);
                if (z) {
                    contentDescription = ClipKt.clipToBounds(contentDescription);
                }
                Modifier then2 = contentDescription.then(modifier2).then(new LegacyContentPainterElement(m3190rememberAsyncImagePainterGSdzBsE, alignment, contentScale, f, colorFilter));
                MeasurePolicy measurePolicy2 = UseMinConstraintsMeasurePolicy;
                composer2.startReplaceableGroup(544976794);
                ComposerKt.sourceInformation(composer2, "CC(Layout)P(1)123@4784L23,126@4935L385:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, then2);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                final Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                composer2.startReplaceableGroup(1405779621);
                ComposerKt.sourceInformation(composer2, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(new Function0<ComposeUiNode>() { // from class: coil3.compose.AsyncImageKt$AsyncImage-76YX9Dk$$inlined$Layout$2
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
                    composer2.useNode();
                }
                Composer composer4 = Updater.constructor-impl(composer2);
                Updater.set-impl(composer4, measurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.set-impl(composer4, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: coil3.compose.AsyncImageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit AsyncImage_76YX9Dk$lambda$2;
                    AsyncImage_76YX9Dk$lambda$2 = AsyncImageKt.AsyncImage_76YX9Dk$lambda$2(AsyncImageState.this, str, modifier, function1, function12, alignment, contentScale, f, colorFilter, i, z, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    return AsyncImage_76YX9Dk$lambda$2;
                }
            });
        }
    }

    public static final MeasurePolicy getUseMinConstraintsMeasurePolicy() {
        return UseMinConstraintsMeasurePolicy;
    }
}
