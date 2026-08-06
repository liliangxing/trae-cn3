package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationConstants;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.draw.ShadowKt;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.geometry.OffsetKt;
import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.p002ui.geometry.RectKt;
import androidx.compose.p002ui.geometry.Size;
import androidx.compose.p002ui.graphics.AndroidPath_androidKt;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p002ui.graphics.GraphicsLayerScope;
import androidx.compose.p002ui.graphics.Path;
import androidx.compose.p002ui.graphics.PathFillType;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.p002ui.graphics.StrokeCap;
import androidx.compose.p002ui.graphics.drawscope.DrawContext;
import androidx.compose.p002ui.graphics.drawscope.DrawScope;
import androidx.compose.p002ui.graphics.drawscope.Stroke;
import androidx.compose.p002ui.layout.LayoutKt;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: PullToRefresh.kt */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0002\u001a(\u0010\u0018\u001a\u00020\u00192\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a]\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\u0019\b\u0002\u0010$\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00190%¢\u0006\u0002\b&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u001c2\b\b\u0002\u0010*\u001a\u00020\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a*\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u0002002\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u0002000\u001aH\u0007\u001a,\u00102\u001a\u00020!2\b\b\u0002\u00103\u001a\u00020\u00042\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u0002000\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aF\u00106\u001a\u00020\u0019*\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00162\u0006\u0010>\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a>\u0010A\u001a\u00020\u0019*\u0002072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00162\u0006\u0010B\u001a\u00020;2\u0006\u0010>\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010D\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\f\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u000f\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0013\u0010\u0011\"\u0010\u0010\u0014\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006E²\u0006\n\u0010F\u001a\u00020\u0002X\u008a\u0084\u0002"}, d2 = {"AlphaTween", "Landroidx/compose/animation/core/TweenSpec;", "", "ArcRadius", "Landroidx/compose/ui/unit/Dp;", "F", "ArrowHeight", "ArrowWidth", "CrossfadeDurationMs", "", "DragMultiplier", "Elevation", "MaxAlpha", "MaxProgressArc", "MinAlpha", "SpinnerContainerSize", "getSpinnerContainerSize", "()F", "SpinnerSize", "getSpinnerSize", "StrokeWidth", "ArrowValues", "Landroidx/compose/material3/pulltorefresh/ArrowValues;", "progress", "CircularArrowProgressIndicator", "", "Lkotlin/Function0;", "color", "Landroidx/compose/ui/graphics/Color;", "CircularArrowProgressIndicator-RPmYEkk", "(Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "PullToRefreshContainer", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "modifier", "Landroidx/compose/ui/Modifier;", "indicator", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "contentColor", "PullToRefreshContainer-wBJOh4Y", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/runtime/Composer;II)V", "PullToRefreshState", "positionalThresholdPx", "initialRefreshing", "", "enabled", "rememberPullToRefreshState", "positionalThreshold", "rememberPullToRefreshState--orJrPs", "(FLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "drawArrow", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "alpha", "values", "strokeWidth", "drawArrow-uDrxG_w", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;F)V", "drawCircularIndicator", "arcBounds", "drawCircularIndicator-KzyDr3Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;Landroidx/compose/ui/geometry/Rect;F)V", "material3_release", "targetAlpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class PullToRefreshKt {
    private static final int CrossfadeDurationMs = 100;
    private static final float DragMultiplier = 0.5f;
    private static final float MaxAlpha = 1.0f;
    private static final float MaxProgressArc = 0.8f;
    private static final float MinAlpha = 0.3f;
    private static final float StrokeWidth = Dp.constructor-impl((float) 2.5d);
    private static final float ArcRadius = Dp.constructor-impl((float) 5.5d);
    private static final float SpinnerSize = Dp.constructor-impl(16);
    private static final float SpinnerContainerSize = Dp.constructor-impl(40);
    private static final float Elevation = ElevationTokens.INSTANCE.m3575getLevel2D9Ej5fM();
    private static final float ArrowWidth = Dp.constructor-impl(10);
    private static final float ArrowHeight = Dp.constructor-impl(5);
    private static final TweenSpec<Float> AlphaTween = AnimationSpecKt.tween$default(AnimationConstants.DefaultDurationMillis, 0, EasingKt.getLinearEasing(), 2, null);

    /* renamed from: access$CircularArrowProgressIndicator-RPmYEkk */
    public static final /* synthetic */ void m3390access$CircularArrowProgressIndicatorRPmYEkk(Function0 function0, long j, Composer composer, int i) {
        m3388CircularArrowProgressIndicatorRPmYEkk(function0, j, composer, i);
    }

    public static final /* synthetic */ float access$getStrokeWidth$p() {
        return StrokeWidth;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00eb, code lost:
    
        if ((r27 & 32) != 0) goto L197;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x004c  */
    /* renamed from: PullToRefreshContainer-wBJOh4Y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3389PullToRefreshContainerwBJOh4Y(final PullToRefreshState pullToRefreshState, Modifier modifier, Function3<? super PullToRefreshState, ? super Composer, ? super Integer, Unit> function3, Shape shape, long j, long j2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function3<? super PullToRefreshState, ? super Composer, ? super Integer, Unit> function32;
        int i5;
        Shape shape2;
        long j3;
        long j4;
        Object rememberedValue;
        ScopeUpdateScope endRestartGroup;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-801976958);
        ComposerKt.sourceInformation(startRestartGroup, "C(PullToRefreshContainer)P(5,3,2,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color)113@4939L14,114@5003L12,118@5222L91,121@5318L650:PullToRefresh.kt#djiw08");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(pullToRefreshState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                function32 = function3;
                i3 |= startRestartGroup.changedInstance(function32) ? Fields.RotationX : Fields.SpotShadowColor;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    shape2 = shape;
                    i3 |= startRestartGroup.changed(shape2) ? Fields.CameraDistance : Fields.RotationZ;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            j3 = j;
                            if (startRestartGroup.changed(j3)) {
                                i7 = Fields.Clip;
                                i3 |= i7;
                            }
                        } else {
                            j3 = j;
                        }
                        i7 = Fields.Shape;
                        i3 |= i7;
                    } else {
                        j3 = j;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            j4 = j2;
                            if (startRestartGroup.changed(j4)) {
                                i6 = Fields.RenderEffect;
                                i3 |= i6;
                            }
                        } else {
                            j4 = j2;
                        }
                        i6 = 65536;
                        i3 |= i6;
                    } else {
                        j4 = j2;
                    }
                    if ((74899 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                        } else {
                            if (i8 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function32 = ComposableSingletons$PullToRefreshKt.INSTANCE.m3384getLambda1$material3_release();
                            }
                            if (i5 != 0) {
                                shape2 = PullToRefreshDefaults.INSTANCE.getShape();
                            }
                            if ((i2 & 16) != 0) {
                                j3 = PullToRefreshDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                j4 = PullToRefreshDefaults.INSTANCE.getContentColor(startRestartGroup, 6);
                                i3 &= -458753;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-801976958, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshContainer (PullToRefresh.kt:115)");
                            }
                            startRestartGroup.startReplaceableGroup(751291370);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):PullToRefresh.kt#9igjgp");
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$showElevation$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(0);
                                    }

                                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Boolean m3397invoke() {
                                        return Boolean.valueOf(PullToRefreshState.this.getVerticalOffset() > 1.0f || PullToRefreshState.this.isRefreshing());
                                    }
                                });
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            final State state = (State) rememberedValue;
                            startRestartGroup.endReplaceableGroup();
                            final Modifier modifier3 = modifier2;
                            final Shape shape3 = shape2;
                            final long j5 = j3;
                            final Function3<? super PullToRefreshState, ? super Composer, ? super Integer, Unit> function33 = function32;
                            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(j4)), ComposableLambdaKt.composableLambda(startRestartGroup, 935555266, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i9) {
                                    float f;
                                    ComposerKt.sourceInformation(composer2, "C125@5506L89,122@5394L568:PullToRefresh.kt#djiw08");
                                    if ((i9 & 3) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(935555266, i9, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshContainer.<anonymous> (PullToRefresh.kt:122)");
                                        }
                                        Modifier m1120size3ABfNKs = SizeKt.m1120size3ABfNKs(Modifier.this, PullToRefreshKt.getSpinnerContainerSize());
                                        composer2.startReplaceableGroup(-1737250521);
                                        ComposerKt.sourceInformation(composer2, "CC(remember):PullToRefresh.kt#9igjgp");
                                        boolean changed = composer2.changed(pullToRefreshState);
                                        final PullToRefreshState pullToRefreshState2 = pullToRefreshState;
                                        Object rememberedValue2 = composer2.rememberedValue();
                                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$1$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    super(1);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                    invoke((GraphicsLayerScope) obj);
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                                    graphicsLayerScope.setTranslationY(PullToRefreshState.this.getVerticalOffset() - Size.m4659getHeightimpl(graphicsLayerScope.getSize()));
                                                }
                                            };
                                            composer2.updateRememberedValue(rememberedValue2);
                                        }
                                        composer2.endReplaceableGroup();
                                        Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(m1120size3ABfNKs, (Function1) rememberedValue2);
                                        if (state.getValue().booleanValue()) {
                                            f = PullToRefreshKt.Elevation;
                                        } else {
                                            f = Dp.constructor-impl(0);
                                        }
                                        Modifier m396backgroundbw27NRU = BackgroundKt.m396backgroundbw27NRU(ShadowKt.m4425shadows4CzXII$default(graphicsLayer, f, shape3, true, 0L, 0L, 24, null), j5, shape3);
                                        Function3<PullToRefreshState, Composer, Integer, Unit> function34 = function33;
                                        PullToRefreshState pullToRefreshState3 = pullToRefreshState;
                                        composer2.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                                        composer2.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m396backgroundbw27NRU);
                                        if (!(composer2.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer2.startReusableNode();
                                        if (composer2.getInserting()) {
                                            composer2.createNode(constructor);
                                        } else {
                                            composer2.useNode();
                                        }
                                        Composer m4109constructorimpl = Updater.m4109constructorimpl(composer2);
                                        Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                                        composer2.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer2, 874077558, "C136@5936L16:PullToRefresh.kt#djiw08");
                                        function34.invoke(pullToRefreshState3, composer2, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        composer2.endReplaceableGroup();
                                        composer2.endNode();
                                        composer2.endReplaceableGroup();
                                        composer2.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), startRestartGroup, ProvidedValue.$stable | 0 | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                    }
                    final Function3<? super PullToRefreshState, ? super Composer, ? super Integer, Unit> function34 = function32;
                    final Shape shape4 = shape2;
                    final long j6 = j4;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Modifier modifier4 = modifier2;
                        final long j7 = j3;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i9) {
                                PullToRefreshKt.m3389PullToRefreshContainerwBJOh4Y(PullToRefreshState.this, modifier4, function34, shape4, j7, j6, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                shape2 = shape;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                if ((74899 & i3) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                }
                if (i8 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(751291370);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):PullToRefresh.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                final State<Boolean> state2 = (State) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                final Modifier modifier32 = modifier2;
                final Shape shape32 = shape2;
                final long j52 = j3;
                final Function3<? super PullToRefreshState, ? super Composer, ? super Integer, Unit> function332 = function32;
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(j4)), ComposableLambdaKt.composableLambda(startRestartGroup, 935555266, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        float f;
                        ComposerKt.sourceInformation(composer2, "C125@5506L89,122@5394L568:PullToRefresh.kt#djiw08");
                        if ((i9 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(935555266, i9, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshContainer.<anonymous> (PullToRefresh.kt:122)");
                            }
                            Modifier m1120size3ABfNKs = SizeKt.m1120size3ABfNKs(Modifier.this, PullToRefreshKt.getSpinnerContainerSize());
                            composer2.startReplaceableGroup(-1737250521);
                            ComposerKt.sourceInformation(composer2, "CC(remember):PullToRefresh.kt#9igjgp");
                            boolean changed = composer2.changed(pullToRefreshState);
                            final PullToRefreshState pullToRefreshState2 = pullToRefreshState;
                            Object rememberedValue2 = composer2.rememberedValue();
                            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((GraphicsLayerScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                        graphicsLayerScope.setTranslationY(PullToRefreshState.this.getVerticalOffset() - Size.m4659getHeightimpl(graphicsLayerScope.getSize()));
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue2);
                            }
                            composer2.endReplaceableGroup();
                            Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(m1120size3ABfNKs, (Function1) rememberedValue2);
                            if (state2.getValue().booleanValue()) {
                                f = PullToRefreshKt.Elevation;
                            } else {
                                f = Dp.constructor-impl(0);
                            }
                            Modifier m396backgroundbw27NRU = BackgroundKt.m396backgroundbw27NRU(ShadowKt.m4425shadows4CzXII$default(graphicsLayer, f, shape32, true, 0L, 0L, 24, null), j52, shape32);
                            Function3<PullToRefreshState, Composer, Integer, Unit> function342 = function332;
                            PullToRefreshState pullToRefreshState3 = pullToRefreshState;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m396backgroundbw27NRU);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor);
                            } else {
                                composer2.useNode();
                            }
                            Composer m4109constructorimpl = Updater.m4109constructorimpl(composer2);
                            Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 874077558, "C136@5936L16:PullToRefresh.kt#djiw08");
                            function342.invoke(pullToRefreshState3, composer2, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), startRestartGroup, ProvidedValue.$stable | 0 | 48);
                if (ComposerKt.isTraceInProgress()) {
                }
                final Function3<? super PullToRefreshState, ? super Composer, ? super Integer, Unit> function342 = function32;
                final Shape shape42 = shape2;
                final long j62 = j4;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            function32 = function3;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            shape2 = shape;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            if ((74899 & i3) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) == 0) {
            }
            if (i8 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(751291370);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):PullToRefresh.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            final State<Boolean> state22 = (State) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            final Modifier modifier322 = modifier2;
            final Shape shape322 = shape2;
            final long j522 = j3;
            final Function3<? super PullToRefreshState, ? super Composer, ? super Integer, Unit> function3322 = function32;
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(j4)), ComposableLambdaKt.composableLambda(startRestartGroup, 935555266, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i9) {
                    float f;
                    ComposerKt.sourceInformation(composer2, "C125@5506L89,122@5394L568:PullToRefresh.kt#djiw08");
                    if ((i9 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(935555266, i9, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshContainer.<anonymous> (PullToRefresh.kt:122)");
                        }
                        Modifier m1120size3ABfNKs = SizeKt.m1120size3ABfNKs(Modifier.this, PullToRefreshKt.getSpinnerContainerSize());
                        composer2.startReplaceableGroup(-1737250521);
                        ComposerKt.sourceInformation(composer2, "CC(remember):PullToRefresh.kt#9igjgp");
                        boolean changed = composer2.changed(pullToRefreshState);
                        final PullToRefreshState pullToRefreshState2 = pullToRefreshState;
                        Object rememberedValue2 = composer2.rememberedValue();
                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((GraphicsLayerScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                    graphicsLayerScope.setTranslationY(PullToRefreshState.this.getVerticalOffset() - Size.m4659getHeightimpl(graphicsLayerScope.getSize()));
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue2);
                        }
                        composer2.endReplaceableGroup();
                        Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(m1120size3ABfNKs, (Function1) rememberedValue2);
                        if (state22.getValue().booleanValue()) {
                            f = PullToRefreshKt.Elevation;
                        } else {
                            f = Dp.constructor-impl(0);
                        }
                        Modifier m396backgroundbw27NRU = BackgroundKt.m396backgroundbw27NRU(ShadowKt.m4425shadows4CzXII$default(graphicsLayer, f, shape322, true, 0L, 0L, 24, null), j522, shape322);
                        Function3<PullToRefreshState, Composer, Integer, Unit> function3422 = function3322;
                        PullToRefreshState pullToRefreshState3 = pullToRefreshState;
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m396backgroundbw27NRU);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer m4109constructorimpl = Updater.m4109constructorimpl(composer2);
                        Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 874077558, "C136@5936L16:PullToRefresh.kt#djiw08");
                        function3422.invoke(pullToRefreshState3, composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, ProvidedValue.$stable | 0 | 48);
            if (ComposerKt.isTraceInProgress()) {
            }
            final Function3<? super PullToRefreshState, ? super Composer, ? super Integer, Unit> function3422 = function32;
            final Shape shape422 = shape2;
            final long j622 = j4;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function32 = function3;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        shape2 = shape;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        if ((74899 & i3) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) == 0) {
        }
        if (i8 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(751291370);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):PullToRefresh.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        final State<Boolean> state222 = (State) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        final Modifier modifier3222 = modifier2;
        final Shape shape3222 = shape2;
        final long j5222 = j3;
        final Function3<? super PullToRefreshState, ? super Composer, ? super Integer, Unit> function33222 = function32;
        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(j4)), ComposableLambdaKt.composableLambda(startRestartGroup, 935555266, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i9) {
                float f;
                ComposerKt.sourceInformation(composer2, "C125@5506L89,122@5394L568:PullToRefresh.kt#djiw08");
                if ((i9 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(935555266, i9, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshContainer.<anonymous> (PullToRefresh.kt:122)");
                    }
                    Modifier m1120size3ABfNKs = SizeKt.m1120size3ABfNKs(Modifier.this, PullToRefreshKt.getSpinnerContainerSize());
                    composer2.startReplaceableGroup(-1737250521);
                    ComposerKt.sourceInformation(composer2, "CC(remember):PullToRefresh.kt#9igjgp");
                    boolean changed = composer2.changed(pullToRefreshState);
                    final PullToRefreshState pullToRefreshState2 = pullToRefreshState;
                    Object rememberedValue2 = composer2.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((GraphicsLayerScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                graphicsLayerScope.setTranslationY(PullToRefreshState.this.getVerticalOffset() - Size.m4659getHeightimpl(graphicsLayerScope.getSize()));
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    composer2.endReplaceableGroup();
                    Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(m1120size3ABfNKs, (Function1) rememberedValue2);
                    if (state222.getValue().booleanValue()) {
                        f = PullToRefreshKt.Elevation;
                    } else {
                        f = Dp.constructor-impl(0);
                    }
                    Modifier m396backgroundbw27NRU = BackgroundKt.m396backgroundbw27NRU(ShadowKt.m4425shadows4CzXII$default(graphicsLayer, f, shape3222, true, 0L, 0L, 24, null), j5222, shape3222);
                    Function3<PullToRefreshState, Composer, Integer, Unit> function34222 = function33222;
                    PullToRefreshState pullToRefreshState3 = pullToRefreshState;
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m396backgroundbw27NRU);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer m4109constructorimpl = Updater.m4109constructorimpl(composer2);
                    Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 874077558, "C136@5936L16:PullToRefresh.kt#djiw08");
                    function34222.invoke(pullToRefreshState3, composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, ProvidedValue.$stable | 0 | 48);
        if (ComposerKt.isTraceInProgress()) {
        }
        final Function3<? super PullToRefreshState, ? super Composer, ? super Integer, Unit> function34222 = function32;
        final Shape shape4222 = shape2;
        final long j6222 = j4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* renamed from: rememberPullToRefreshState--orJrPs */
    public static final PullToRefreshState m3395rememberPullToRefreshStateorJrPs(float f, final Function0<Boolean> function0, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1935213334);
        ComposerKt.sourceInformation(composer, "C(rememberPullToRefreshState)P(1:c#ui.unit.Dp)253@9584L7,261@9888L176,255@9680L384:PullToRefresh.kt#djiw08");
        if ((i2 & 1) != 0) {
            f = PullToRefreshDefaults.INSTANCE.m3386getPositionalThresholdD9Ej5fM();
        }
        if ((i2 & 2) != 0) {
            function0 = new Function0<Boolean>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$rememberPullToRefreshState$1
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Boolean m3399invoke() {
                    return true;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1935213334, i, -1, "androidx.compose.material3.pulltorefresh.rememberPullToRefreshState (PullToRefresh.kt:252)");
        }
        ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final float f2 = ((Density) consume).toPx-0680j_4(f);
        Object[] objArr = {Float.valueOf(f2), function0};
        Saver<PullToRefreshState, Boolean> Saver = PullToRefreshStateImpl.INSTANCE.Saver(f2, function0);
        composer.startReplaceableGroup(804873447);
        ComposerKt.sourceInformation(composer, "CC(remember):PullToRefresh.kt#9igjgp");
        boolean changed = composer.changed(f2) | ((((i & 112) ^ 48) > 32 && composer.changed(function0)) || (i & 48) == 32);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = (Function0) new Function0<PullToRefreshState>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$rememberPullToRefreshState$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final PullToRefreshState m3400invoke() {
                    return new PullToRefreshStateImpl(false, f2, function0);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        PullToRefreshState pullToRefreshState = (PullToRefreshState) RememberSaveableKt.m4241rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) rememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return pullToRefreshState;
    }

    public static /* synthetic */ PullToRefreshState PullToRefreshState$default(float f, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function0 = new Function0<Boolean>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshState$1
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Boolean m3398invoke() {
                    return true;
                }
            };
        }
        return PullToRefreshState(f, z, function0);
    }

    public static final PullToRefreshState PullToRefreshState(float f, boolean z, Function0<Boolean> function0) {
        return new PullToRefreshStateImpl(z, f, function0);
    }

    /* renamed from: CircularArrowProgressIndicator-RPmYEkk */
    public static final void m3388CircularArrowProgressIndicatorRPmYEkk(final Function0<Float> function0, final long j, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-569718810);
        ComposerKt.sourceInformation(startRestartGroup, "C(CircularArrowProgressIndicator)P(1,0:c#ui.graphics.Color)428@15876L61,430@16038L88,433@16148L74,436@16300L118,441@16456L443,434@16227L672:PullToRefresh.kt#djiw08");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-569718810, i2, -1, "androidx.compose.material3.pulltorefresh.CircularArrowProgressIndicator (PullToRefresh.kt:427)");
            }
            startRestartGroup.startReplaceableGroup(-656076138);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):PullToRefresh.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            Object obj = rememberedValue;
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                Path Path = AndroidPath_androidKt.Path();
                Path.mo4728setFillTypeoQ8Xj4U(PathFillType.INSTANCE.m5134getEvenOddRgk1Os());
                startRestartGroup.updateRememberedValue(Path);
                obj = Path;
            }
            final Path path = (Path) obj;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-656075976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):PullToRefresh.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$targetAlpha$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final Float m3396invoke() {
                        return Float.valueOf(((Number) function0.invoke()).floatValue() < 1.0f ? 0.3f : 1.0f);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            final State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(CircularArrowProgressIndicator_RPmYEkk$lambda$6((State) rememberedValue2), AlphaTween, 0.0f, null, null, startRestartGroup, 48, 28);
            Modifier.Companion companion = Modifier.INSTANCE;
            startRestartGroup.startReplaceableGroup(-656075714);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):PullToRefresh.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = i3 == 4;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((SemanticsPropertyReceiver) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(((Number) function0.invoke()).floatValue(), RangesKt.rangeTo(0.0f, 1.0f), 0));
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier m1120size3ABfNKs = SizeKt.m1120size3ABfNKs(SemanticsModifierKt.semantics(companion, true, (Function1) rememberedValue3), SpinnerSize);
            startRestartGroup.startReplaceableGroup(-656075558);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):PullToRefresh.kt#9igjgp");
            boolean changed = (i3 == 4) | startRestartGroup.changed(animateFloatAsState) | ((i2 & 112) == 32) | startRestartGroup.changedInstance(path);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                composer2 = startRestartGroup;
                rememberedValue4 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((DrawScope) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(DrawScope drawScope) {
                        ArrowValues ArrowValues;
                        float f;
                        float f2;
                        float f3;
                        float f4;
                        ArrowValues = PullToRefreshKt.ArrowValues(((Number) function0.invoke()).floatValue());
                        float floatValue = animateFloatAsState.getValue().floatValue();
                        float rotation = ArrowValues.getRotation();
                        long j2 = j;
                        Path path2 = path;
                        long m5416getCenterF1C5BW0 = drawScope.m5416getCenterF1C5BW0();
                        DrawContext drawContext = drawScope.getDrawContext();
                        long mo5338getSizeNHjbRc = drawContext.mo5338getSizeNHjbRc();
                        drawContext.getCanvas().save();
                        drawContext.getTransform().mo5344rotateUv8p0NA(rotation, m5416getCenterF1C5BW0);
                        f = PullToRefreshKt.ArcRadius;
                        float f5 = drawScope.toPx-0680j_4(f);
                        f2 = PullToRefreshKt.StrokeWidth;
                        Rect m4632Rect3MmeM6k = RectKt.m4632Rect3MmeM6k(androidx.compose.p002ui.geometry.SizeKt.m4672getCenteruvyYCjk(drawScope.m5417getSizeNHjbRc()), f5 + (drawScope.toPx-0680j_4(f2) / 2.0f));
                        f3 = PullToRefreshKt.StrokeWidth;
                        PullToRefreshKt.m3394drawCircularIndicatorKzyDr3Q(drawScope, j2, floatValue, ArrowValues, m4632Rect3MmeM6k, f3);
                        f4 = PullToRefreshKt.StrokeWidth;
                        PullToRefreshKt.m3393drawArrowuDrxG_w(drawScope, path2, m4632Rect3MmeM6k, j2, floatValue, ArrowValues, f4);
                        drawContext.getCanvas().restore();
                        drawContext.mo5339setSizeuvyYCjk(mo5338getSizeNHjbRc);
                    }
                };
                composer2.updateRememberedValue(rememberedValue4);
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceableGroup();
            CanvasKt.Canvas(m1120size3ABfNKs, (Function1) rememberedValue4, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    PullToRefreshKt.m3388CircularArrowProgressIndicatorRPmYEkk(function0, j, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* renamed from: drawCircularIndicator-KzyDr3Q */
    public static final void m3394drawCircularIndicatorKzyDr3Q(DrawScope drawScope, long j, float f, ArrowValues arrowValues, Rect rect, float f2) {
        DrawScope.m5396drawArcyD3GUKo$default(drawScope, j, arrowValues.getStartAngle(), arrowValues.getEndAngle() - arrowValues.getStartAngle(), false, rect.m4628getTopLeftF1C5BW0(), rect.m4626getSizeNHjbRc(), f, new Stroke(drawScope.toPx-0680j_4(f2), 0.0f, StrokeCap.INSTANCE.m5211getButtKaPHkGw(), 0, null, 26, null), null, 0, 768, null);
    }

    public static final ArrowValues ArrowValues(float f) {
        float max = (Math.max(Math.min(1.0f, f) - 0.4f, 0.0f) * 5) / 3;
        float coerceIn = RangesKt.coerceIn(Math.abs(f) - 1.0f, 0.0f, 2.0f);
        float pow = (((0.4f * max) - 0.25f) + (coerceIn - (((float) Math.pow(coerceIn, 2)) / 4))) * 0.5f;
        float f2 = 360;
        return new ArrowValues(pow, pow * f2, ((MaxProgressArc * max) + pow) * f2, Math.min(1.0f, max));
    }

    /* renamed from: drawArrow-uDrxG_w */
    public static final void m3393drawArrowuDrxG_w(DrawScope drawScope, Path path, Rect rect, long j, float f, ArrowValues arrowValues, float f2) {
        path.reset();
        path.moveTo(0.0f, 0.0f);
        float f3 = ArrowWidth;
        path.lineTo((drawScope.toPx-0680j_4(f3) * arrowValues.getScale()) / 2, drawScope.toPx-0680j_4(ArrowHeight) * arrowValues.getScale());
        path.lineTo(drawScope.toPx-0680j_4(f3) * arrowValues.getScale(), 0.0f);
        path.mo4730translatek4lQ0M(OffsetKt.Offset(((Math.min(rect.getWidth(), rect.getHeight()) / 2.0f) + Offset.m4593getXimpl(rect.m4623getCenterF1C5BW0())) - ((drawScope.toPx-0680j_4(f3) * arrowValues.getScale()) / 2.0f), Offset.m4594getYimpl(rect.m4623getCenterF1C5BW0()) - drawScope.toPx-0680j_4(f2)));
        float endAngle = arrowValues.getEndAngle() - drawScope.toPx-0680j_4(f2);
        long m5416getCenterF1C5BW0 = drawScope.m5416getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long mo5338getSizeNHjbRc = drawContext.mo5338getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo5344rotateUv8p0NA(endAngle, m5416getCenterF1C5BW0);
        DrawScope.m5407drawPathLG529CI$default(drawScope, path, j, f, new Stroke(drawScope.toPx-0680j_4(f2), 0.0f, 0, 0, null, 30, null), null, 0, 48, null);
        drawContext.getCanvas().restore();
        drawContext.mo5339setSizeuvyYCjk(mo5338getSizeNHjbRc);
    }

    public static final float getSpinnerSize() {
        return SpinnerSize;
    }

    public static final float getSpinnerContainerSize() {
        return SpinnerContainerSize;
    }

    private static final float CircularArrowProgressIndicator_RPmYEkk$lambda$6(State<Float> state) {
        return state.getValue().floatValue();
    }
}
