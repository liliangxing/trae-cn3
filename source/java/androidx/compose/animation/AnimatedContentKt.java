package androidx.compose.animation;

import androidx.autofill.HintConstants;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.ComposedModifierKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.layout.LayoutModifierKt;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimatedContent.kt */
@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a´\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0017\u001aP\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2>\b\u0002\u0010\u001c\u001a8\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0 0\u0014\u001a\u0015\u0010!\u001a\u00020\t*\u00020\"2\u0006\u0010#\u001a\u00020$H\u0086\u0004\u001a\u0015\u0010%\u001a\u00020\t*\u00020\"2\u0006\u0010#\u001a\u00020$H\u0087\u0004\u001a¬\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020(2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010)\"\u0010\u0010&\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010'¨\u0006*"}, d2 = {"AnimatedContent", "", "S", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/compose/animation/ContentTransform;", "Lkotlin/ExtensionFunctionType;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "label", "", "contentKey", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "", "content", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "SizeTransform", "Landroidx/compose/animation/SizeTransform;", "clip", "", "sizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "initialSize", "targetSize", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "togetherWith", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "with", "UnspecifiedSize", "J", "Landroidx/compose/animation/core/Transition;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "animation"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class AnimatedContentKt {
    private static final long UnspecifiedSize;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <S> void AnimatedContent(final S s, Modifier modifier, Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function1, Alignment alignment, String str, Function1<? super S, ? extends Object> function12, final Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        Alignment alignment2;
        int i6;
        String str2;
        int i7;
        Function1<? super S, ? extends Object> function13;
        Modifier modifier2;
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function14;
        final Alignment alignment3;
        final Function1<? super S, ? extends Object> function15;
        ScopeUpdateScope endRestartGroup;
        Function1<? super S, ? extends Object> function16;
        Composer startRestartGroup = composer.startRestartGroup(1501828832);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedContent)P(5,4,6,1,3,2)131@7139L226,138@7503L6,141@7610L58,142@7684L137:AnimatedContent.kt#xbi5r1");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? startRestartGroup.changed(s) : startRestartGroup.changedInstance(s) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= startRestartGroup.changedInstance(function1) ? Fields.RotationX : Fields.SpotShadowColor;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    alignment2 = alignment;
                    i3 |= startRestartGroup.changed(alignment2) ? Fields.CameraDistance : Fields.RotationZ;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        str2 = str;
                        i3 |= startRestartGroup.changed(str2) ? Fields.Clip : Fields.Shape;
                        i7 = i2 & 32;
                        if (i7 != 0) {
                            i3 |= 196608;
                        } else if ((196608 & i) == 0) {
                            function13 = function12;
                            i3 |= startRestartGroup.changedInstance(function13) ? Fields.RenderEffect : 65536;
                            if ((i2 & 64) == 0) {
                                i3 |= 1572864;
                            } else if ((i & 1572864) == 0) {
                                i3 |= startRestartGroup.changedInstance(function4) ? 1048576 : Fields.BlendMode;
                                if (!startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                                    startRestartGroup.skipToGroupEnd();
                                    modifier2 = modifier;
                                    function14 = function1;
                                    alignment3 = alignment2;
                                    function15 = function13;
                                } else {
                                    Modifier.Companion companion = i8 != 0 ? Modifier.INSTANCE : modifier;
                                    if (i4 != 0) {
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 148502018, "CC(remember):AnimatedContent.kt#9igjgp");
                                        AnimatedContentKt$AnimatedContent$1$1 rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = new Function1<AnimatedContentTransitionScope<S>, ContentTransform>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$1$1
                                                public final ContentTransform invoke(AnimatedContentTransitionScope<S> animatedContentTransitionScope) {
                                                    return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m198scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.92f, 0L, 4, null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null));
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        function14 = (Function1) rememberedValue;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    } else {
                                        function14 = function1;
                                    }
                                    Alignment topStart = i5 != 0 ? Alignment.INSTANCE.getTopStart() : alignment2;
                                    if (i6 != 0) {
                                        str2 = "AnimatedContent";
                                    }
                                    if (i7 != 0) {
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 148513446, "CC(remember):AnimatedContent.kt#9igjgp");
                                        AnimatedContentKt$AnimatedContent$2$1 rememberedValue2 = startRestartGroup.rememberedValue();
                                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = new Function1<S, S>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$2$1
                                                public final S invoke(S s2) {
                                                    return s2;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue2);
                                        }
                                        function16 = (Function1) rememberedValue2;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    } else {
                                        function16 = function13;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1501828832, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:140)");
                                    }
                                    Transition updateTransition = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, startRestartGroup, (i3 & 8) | (i3 & 14) | ((i3 >> 9) & 112), 0);
                                    int i9 = (i3 & 112) | (i3 & 896) | (i3 & 7168);
                                    int i10 = i3 >> 3;
                                    int i11 = i9 | (57344 & i10) | (i10 & 458752);
                                    String str3 = str2;
                                    AnimatedContent(updateTransition, companion, function14, topStart, function16, function4, startRestartGroup, i11, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    str2 = str3;
                                    modifier2 = companion;
                                    Alignment alignment4 = topStart;
                                    function15 = function16;
                                    alignment3 = alignment4;
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    final Modifier modifier3 = modifier2;
                                    final Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function17 = function14;
                                    final String str4 = str2;
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$3
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

                                        public final void invoke(Composer composer2, int i12) {
                                            AnimatedContentKt.AnimatedContent(s, modifier3, function17, alignment3, str4, function15, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            if (!startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        function13 = function12;
                        if ((i2 & 64) == 0) {
                        }
                        if (!startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    str2 = str;
                    i7 = i2 & 32;
                    if (i7 != 0) {
                    }
                    function13 = function12;
                    if ((i2 & 64) == 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                alignment2 = alignment;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                str2 = str;
                i7 = i2 & 32;
                if (i7 != 0) {
                }
                function13 = function12;
                if ((i2 & 64) == 0) {
                }
                if (!startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            alignment2 = alignment;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            str2 = str;
            i7 = i2 & 32;
            if (i7 != 0) {
            }
            function13 = function12;
            if ((i2 & 64) == 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        alignment2 = alignment;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        str2 = str;
        i7 = i2 & 32;
        if (i7 != 0) {
        }
        function13 = function12;
        if ((i2 & 64) == 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static /* synthetic */ SizeTransform SizeTransform$default(boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            function2 = new Function2<IntSize, IntSize, SpringSpec<IntSize>>() { // from class: androidx.compose.animation.AnimatedContentKt$SizeTransform$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return m146invokeTemP2vQ(((IntSize) obj2).unbox-impl(), ((IntSize) obj3).unbox-impl());
                }

                /* renamed from: invoke-TemP2vQ, reason: not valid java name */
                public final SpringSpec<IntSize> m146invokeTemP2vQ(long j, long j2) {
                    return AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
                }
            };
        }
        return SizeTransform(z, function2);
    }

    public static final SizeTransform SizeTransform(boolean z, Function2<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> function2) {
        return new SizeTransformImpl(z, function2);
    }

    public static final ContentTransform togetherWith(EnterTransition enterTransition, ExitTransition exitTransition) {
        return new ContentTransform(enterTransition, exitTransition, 0.0f, null, 12, null);
    }

    @Deprecated(message = "Infix fun EnterTransition.with(ExitTransition) has been renamed to togetherWith", replaceWith = @ReplaceWith(expression = "togetherWith(exit)", imports = {}))
    public static final ContentTransform with(EnterTransition enterTransition, ExitTransition exitTransition) {
        return new ContentTransform(enterTransition, exitTransition, 0.0f, null, 12, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <S> void AnimatedContent(final Transition<S> transition, Modifier modifier, Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function1, Alignment alignment, Function1<? super S, ? extends Object> function12, final Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function13;
        int i5;
        Alignment alignment2;
        int i6;
        Function1<? super S, ? extends Object> function14;
        final Modifier modifier3;
        final Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function15;
        final Alignment alignment3;
        final Function1<? super S, ? extends Object> function16;
        ScopeUpdateScope endRestartGroup;
        String str;
        MutableScatterMap mutableScatterMap;
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function17;
        Alignment alignment4;
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function18;
        ContentTransform contentTransform;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(511725103);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedContent)P(3,4,1,2)765@38134L226,771@38459L6,774@38592L7,776@38628L114,780@38830L51,781@38903L69,867@43438L58,868@43530L45,874@43785L52,869@43580L264:AnimatedContent.kt#xbi5r1");
        if ((i2 & Integer.MIN_VALUE) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(transition) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 2;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                function13 = function1;
                i3 |= startRestartGroup.changedInstance(function13) ? Fields.RotationX : Fields.SpotShadowColor;
                i5 = i2 & 4;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    alignment2 = alignment;
                    i3 |= startRestartGroup.changed(alignment2) ? Fields.CameraDistance : Fields.RotationZ;
                    i6 = i2 & 8;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        function14 = function12;
                        i3 |= startRestartGroup.changedInstance(function14) ? Fields.Clip : Fields.Shape;
                        if ((i2 & 16) != 0) {
                            i3 |= 196608;
                        } else if ((i & 196608) == 0) {
                            i3 |= startRestartGroup.changedInstance(function4) ? Fields.RenderEffect : 65536;
                            boolean z = true;
                            if (startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                                startRestartGroup.skipToGroupEnd();
                                modifier3 = modifier2;
                                function15 = function13;
                                alignment3 = alignment2;
                                function16 = function14;
                            } else {
                                Modifier modifier4 = i8 != 0 ? Modifier.INSTANCE : modifier2;
                                String str2 = "CC(remember):AnimatedContent.kt#9igjgp";
                                if (i4 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2141559249, "CC(remember):AnimatedContent.kt#9igjgp");
                                    AnimatedContentKt$AnimatedContent$4$1 rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = new Function1<AnimatedContentTransitionScope<S>, ContentTransform>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$4$1
                                            public final ContentTransform invoke(AnimatedContentTransitionScope<S> animatedContentTransitionScope) {
                                                return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m198scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.92f, 0L, 4, null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null));
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    function13 = (Function1) rememberedValue;
                                }
                                if (i5 != 0) {
                                    alignment2 = Alignment.INSTANCE.getTopStart();
                                }
                                if (i6 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2141569429, "CC(remember):AnimatedContent.kt#9igjgp");
                                    AnimatedContentKt$AnimatedContent$5$1 rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = new Function1<S, S>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1
                                            public final S invoke(S s) {
                                                return s;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    function14 = (Function1) rememberedValue2;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(511725103, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:773)");
                                }
                                ProvidableCompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object consume = startRestartGroup.consume(localLayoutDirection);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                LayoutDirection layoutDirection = (LayoutDirection) consume;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2141574945, "CC(remember):AnimatedContent.kt#9igjgp");
                                int i9 = i3 & 14;
                                boolean z2 = i9 == 4;
                                Object rememberedValue3 = startRestartGroup.rememberedValue();
                                if (z2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = new AnimatedContentTransitionScopeImpl(transition, alignment2, layoutDirection);
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                final AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) rememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2141581346, "CC(remember):AnimatedContent.kt#9igjgp");
                                boolean z3 = i9 == 4;
                                Object rememberedValue4 = startRestartGroup.rememberedValue();
                                if (z3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue4 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                }
                                final SnapshotStateList snapshotStateList = (SnapshotStateList) rememberedValue4;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2141583700, "CC(remember):AnimatedContent.kt#9igjgp");
                                boolean z4 = i9 == 4;
                                Object rememberedValue5 = startRestartGroup.rememberedValue();
                                if (z4 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue5 = ScatterMapKt.mutableScatterMapOf();
                                    startRestartGroup.updateRememberedValue(rememberedValue5);
                                }
                                MutableScatterMap mutableScatterMap2 = (MutableScatterMap) rememberedValue5;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                if (!snapshotStateList.contains(transition.getCurrentState())) {
                                    snapshotStateList.clear();
                                    snapshotStateList.add(transition.getCurrentState());
                                }
                                if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                                    if (snapshotStateList.size() != 1 || !Intrinsics.areEqual(snapshotStateList.get(0), transition.getCurrentState())) {
                                        snapshotStateList.clear();
                                        snapshotStateList.add(transition.getCurrentState());
                                    }
                                    if (mutableScatterMap2.get_size() != 1 || mutableScatterMap2.containsKey(transition.getCurrentState())) {
                                        mutableScatterMap2.clear();
                                    }
                                    animatedContentTransitionScopeImpl.setContentAlignment(alignment2);
                                    animatedContentTransitionScopeImpl.setLayoutDirection$animation(layoutDirection);
                                }
                                if (!Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState()) && !snapshotStateList.contains(transition.getTargetState())) {
                                    Iterator<T> it = snapshotStateList.iterator();
                                    int i10 = 0;
                                    while (true) {
                                        if (!it.hasNext()) {
                                            i7 = -1;
                                            break;
                                        } else {
                                            if (Intrinsics.areEqual(function14.invoke(it.next()), function14.invoke(transition.getTargetState()))) {
                                                i7 = i10;
                                                break;
                                            }
                                            i10++;
                                        }
                                    }
                                    if (i7 == -1) {
                                        Boolean.valueOf(snapshotStateList.add(transition.getTargetState()));
                                    } else {
                                        snapshotStateList.set(i7, transition.getTargetState());
                                        Unit unit = Unit.INSTANCE;
                                    }
                                }
                                if (!mutableScatterMap2.containsKey(transition.getTargetState()) || !mutableScatterMap2.containsKey(transition.getCurrentState())) {
                                    startRestartGroup.startReplaceGroup(1966468977);
                                    ComposerKt.sourceInformation(startRestartGroup, "*817@40849L2545");
                                    mutableScatterMap2.clear();
                                    SnapshotStateList snapshotStateList2 = snapshotStateList;
                                    int size = snapshotStateList2.size();
                                    int i11 = 0;
                                    while (i11 < size) {
                                        final T t = snapshotStateList2.get(i11);
                                        Alignment alignment5 = alignment2;
                                        boolean z5 = z;
                                        SnapshotStateList snapshotStateList3 = snapshotStateList2;
                                        final Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function19 = function13;
                                        MutableScatterMap mutableScatterMap3 = mutableScatterMap2;
                                        mutableScatterMap3.set(t, ComposableLambdaKt.rememberComposableLambda(-23915175, z5, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1
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

                                            /* JADX WARN: Code restructure failed: missing block: B:26:0x013a, code lost:
                                            
                                                if (r10 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L35;
                                             */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public final void invoke(Composer composer2, int i12) {
                                                Object initialContentExit;
                                                Object obj;
                                                ComposerKt.sourceInformation(composer2, "C818@40885L38,822@41099L323,829@41455L125,840@42023L348,836@41832L25,847@42511L233,852@42764L616,834@41763L1617:AnimatedContent.kt#xbi5r1");
                                                if (!composer2.shouldExecute((i12 & 3) != 2, i12 & 1)) {
                                                    composer2.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-23915175, i12, -1, "androidx.compose.animation.AnimatedContent.<anonymous>.<anonymous> (AnimatedContent.kt:818)");
                                                }
                                                ComposerKt.sourceInformationMarkerStart(composer2, -1507645505, "CC(remember):AnimatedContent.kt#9igjgp");
                                                Function1<AnimatedContentTransitionScope<S>, ContentTransform> function110 = function19;
                                                Object obj2 = animatedContentTransitionScopeImpl;
                                                Object rememberedValue6 = composer2.rememberedValue();
                                                if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue6 = (ContentTransform) function110.invoke(obj2);
                                                    composer2.updateRememberedValue(rememberedValue6);
                                                }
                                                final ContentTransform contentTransform2 = (ContentTransform) rememberedValue6;
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                boolean areEqual = Intrinsics.areEqual(transition.getSegment().getTargetState(), t);
                                                ComposerKt.sourceInformationMarkerStart(composer2, -1507638372, "CC(remember):AnimatedContent.kt#9igjgp");
                                                boolean changed = composer2.changed(areEqual);
                                                Transition<S> transition2 = transition;
                                                S s = t;
                                                Function1<AnimatedContentTransitionScope<S>, ContentTransform> function111 = function19;
                                                Object obj3 = animatedContentTransitionScopeImpl;
                                                Object rememberedValue7 = composer2.rememberedValue();
                                                if (changed || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                    if (Intrinsics.areEqual(transition2.getSegment().getTargetState(), s)) {
                                                        initialContentExit = ExitTransition.INSTANCE.getNone();
                                                    } else {
                                                        initialContentExit = ((ContentTransform) function111.invoke(obj3)).getInitialContentExit();
                                                    }
                                                    rememberedValue7 = initialContentExit;
                                                    composer2.updateRememberedValue(rememberedValue7);
                                                }
                                                final ExitTransition exitTransition = (ExitTransition) rememberedValue7;
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                ComposerKt.sourceInformationMarkerStart(composer2, -1507627178, "CC(remember):AnimatedContent.kt#9igjgp");
                                                S s2 = t;
                                                Transition<S> transition3 = transition;
                                                Object rememberedValue8 = composer2.rememberedValue();
                                                if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue8 = new AnimatedContentTransitionScopeImpl.ChildData(Intrinsics.areEqual(s2, transition3.getTargetState()));
                                                    composer2.updateRememberedValue(rememberedValue8);
                                                }
                                                AnimatedContentTransitionScopeImpl.ChildData childData = (AnimatedContentTransitionScopeImpl.ChildData) rememberedValue8;
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                EnterTransition targetContentEnter = contentTransform2.getTargetContentEnter();
                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer2, -1507608779, "CC(remember):AnimatedContent.kt#9igjgp");
                                                boolean changedInstance = composer2.changedInstance(contentTransform2);
                                                Object rememberedValue9 = composer2.rememberedValue();
                                                if (changedInstance || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue9 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$1$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        {
                                                            super(3);
                                                        }

                                                        public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5, Object obj6) {
                                                            return m144invoke3p2s80s((MeasureScope) obj4, (Measurable) obj5, ((Constraints) obj6).unbox-impl());
                                                        }

                                                        /* renamed from: invoke-3p2s80s, reason: not valid java name */
                                                        public final MeasureResult m144invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                                                            final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(j);
                                                            int width = mo6318measureBRTryo0.getWidth();
                                                            int height = mo6318measureBRTryo0.getHeight();
                                                            final ContentTransform contentTransform3 = ContentTransform.this;
                                                            return MeasureScope.layout$default(measureScope, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$1$1.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                                                                    invoke((Placeable.PlacementScope) obj4);
                                                                    return Unit.INSTANCE;
                                                                }

                                                                public final void invoke(Placeable.PlacementScope placementScope) {
                                                                    placementScope.place(Placeable.this, 0, 0, contentTransform3.getTargetContentZIndex());
                                                                }
                                                            }, 4, null);
                                                        }
                                                    };
                                                    composer2.updateRememberedValue(rememberedValue9);
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                Modifier layout = LayoutModifierKt.layout(companion, (Function3) rememberedValue9);
                                                childData.setTarget(Intrinsics.areEqual(t, transition.getTargetState()));
                                                Modifier then = layout.then(childData);
                                                Transition<S> transition4 = transition;
                                                ComposerKt.sourceInformationMarkerStart(composer2, -1507615214, "CC(remember):AnimatedContent.kt#9igjgp");
                                                boolean changedInstance2 = composer2.changedInstance(t);
                                                final S s3 = t;
                                                Object rememberedValue10 = composer2.rememberedValue();
                                                if (!changedInstance2) {
                                                    obj = rememberedValue10;
                                                }
                                                Object obj4 = (Function1) new Function1<S, Boolean>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$3$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    public final Boolean invoke(S s4) {
                                                        return Boolean.valueOf(Intrinsics.areEqual(s4, s3));
                                                    }

                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    /* renamed from: invoke, reason: collision with other method in class */
                                                    public /* bridge */ /* synthetic */ Object m145invoke(Object obj5) {
                                                        return invoke((AnimatedContentKt$AnimatedContent$6$1$3$1<S>) obj5);
                                                    }
                                                };
                                                composer2.updateRememberedValue(obj4);
                                                obj = obj4;
                                                Function1 function112 = (Function1) obj;
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                ComposerKt.sourceInformationMarkerStart(composer2, -1507593278, "CC(remember):AnimatedContent.kt#9igjgp");
                                                boolean changed2 = composer2.changed(exitTransition);
                                                Object rememberedValue11 = composer2.rememberedValue();
                                                if (changed2 || rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue11 = (Function2) new Function2<EnterExitState, EnterExitState, Boolean>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$4$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        {
                                                            super(2);
                                                        }

                                                        public final Boolean invoke(EnterExitState enterExitState, EnterExitState enterExitState2) {
                                                            return Boolean.valueOf(enterExitState == EnterExitState.PostExit && enterExitState2 == EnterExitState.PostExit && !ExitTransition.this.getData().getHold());
                                                        }
                                                    };
                                                    composer2.updateRememberedValue(rememberedValue11);
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                final SnapshotStateList<S> snapshotStateList4 = snapshotStateList;
                                                final S s4 = t;
                                                final AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl2 = animatedContentTransitionScopeImpl;
                                                final Function4<AnimatedContentScope, S, Composer, Integer, Unit> function42 = function4;
                                                AnimatedVisibilityKt.AnimatedEnterExitImpl(transition4, function112, then, targetContentEnter, exitTransition, (Function2) rememberedValue11, null, ComposableLambdaKt.rememberComposableLambda(-143346359, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1.5
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(3);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj5, Object obj6, Object obj7) {
                                                        invoke((AnimatedVisibilityScope) obj5, (Composer) obj6, ((Number) obj7).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, int i13) {
                                                        ComposerKt.sourceInformation(composer3, "C854@42897L230,854@42874L253,862@43289L43,*862@43336L24:AnimatedContent.kt#xbi5r1");
                                                        if ((i13 & 6) == 0) {
                                                            i13 |= (i13 & 8) == 0 ? composer3.changed(animatedVisibilityScope) : composer3.changedInstance(animatedVisibilityScope) ? 4 : 2;
                                                        }
                                                        if (!composer3.shouldExecute((i13 & 19) != 18, i13 & 1)) {
                                                            composer3.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-143346359, i13, -1, "androidx.compose.animation.AnimatedContent.<anonymous>.<anonymous>.<anonymous> (AnimatedContent.kt:854)");
                                                        }
                                                        ComposerKt.sourceInformationMarkerStart(composer3, -316893041, "CC(remember):AnimatedContent.kt#9igjgp");
                                                        boolean changed3 = composer3.changed(snapshotStateList4) | composer3.changedInstance(s4) | composer3.changedInstance(animatedContentTransitionScopeImpl2);
                                                        final SnapshotStateList<S> snapshotStateList5 = snapshotStateList4;
                                                        final S s5 = s4;
                                                        final AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl3 = animatedContentTransitionScopeImpl2;
                                                        Object rememberedValue12 = composer3.rememberedValue();
                                                        if (changed3 || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                                            rememberedValue12 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$5$1$1
                                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                                                    final SnapshotStateList<S> snapshotStateList6 = snapshotStateList5;
                                                                    final S s6 = s5;
                                                                    final AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl4 = animatedContentTransitionScopeImpl3;
                                                                    return new DisposableEffectResult() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$5$1$1$invoke$$inlined$onDispose$1
                                                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                                                        public void dispose() {
                                                                            SnapshotStateList.this.remove(s6);
                                                                            animatedContentTransitionScopeImpl4.getTargetSizeMap$animation().remove(s6);
                                                                        }
                                                                    };
                                                                }
                                                            };
                                                            composer3.updateRememberedValue(rememberedValue12);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        EffectsKt.DisposableEffect(animatedVisibilityScope, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue12, composer3, i13 & 14);
                                                        MutableScatterMap targetSizeMap$animation = animatedContentTransitionScopeImpl2.getTargetSizeMap$animation();
                                                        S s6 = s4;
                                                        Intrinsics.checkNotNull(animatedVisibilityScope, "null cannot be cast to non-null type androidx.compose.animation.AnimatedVisibilityScopeImpl");
                                                        targetSizeMap$animation.set(s6, ((AnimatedVisibilityScopeImpl) animatedVisibilityScope).getTargetSize$animation());
                                                        ComposerKt.sourceInformationMarkerStart(composer3, -316880684, "CC(remember):AnimatedContent.kt#9igjgp");
                                                        Object rememberedValue13 = composer3.rememberedValue();
                                                        if (rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                                                            rememberedValue13 = new AnimatedContentScopeImpl(animatedVisibilityScope);
                                                            composer3.updateRememberedValue(rememberedValue13);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        function42.invoke((AnimatedContentScopeImpl) rememberedValue13, s4, composer3, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, composer2, 54), composer2, 12582912, 64);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, startRestartGroup, 54));
                                        mutableScatterMap2 = mutableScatterMap3;
                                        size = size;
                                        snapshotStateList2 = snapshotStateList3;
                                        str2 = str2;
                                        function13 = function13;
                                        i11++;
                                        z = z5;
                                        alignment2 = alignment5;
                                    }
                                    str = str2;
                                    mutableScatterMap = mutableScatterMap2;
                                    function17 = function13;
                                    alignment4 = alignment2;
                                    startRestartGroup.endReplaceGroup();
                                } else {
                                    startRestartGroup.startReplaceGroup(1969054067);
                                    startRestartGroup.endReplaceGroup();
                                    str = "CC(remember):AnimatedContent.kt#9igjgp";
                                    mutableScatterMap = mutableScatterMap2;
                                    function17 = function13;
                                    alignment4 = alignment2;
                                }
                                Transition.Segment<S> segment = transition.getSegment();
                                String str3 = str;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2141728809, str3);
                                boolean changed = startRestartGroup.changed(segment) | startRestartGroup.changed(animatedContentTransitionScopeImpl);
                                Object rememberedValue6 = startRestartGroup.rememberedValue();
                                if (changed || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    function18 = function17;
                                    contentTransform = (ContentTransform) function18.invoke(animatedContentTransitionScopeImpl);
                                    startRestartGroup.updateRememberedValue(contentTransform);
                                } else {
                                    contentTransform = rememberedValue6;
                                    function18 = function17;
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                Modifier then = modifier4.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation(contentTransform, startRestartGroup, 0));
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2141739907, str3);
                                Object rememberedValue7 = startRestartGroup.rememberedValue();
                                if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue7 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                                    startRestartGroup.updateRememberedValue(rememberedValue7);
                                }
                                AnimatedContentMeasurePolicy animatedContentMeasurePolicy = (AnimatedContentMeasurePolicy) rememberedValue7;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, then);
                                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                    startRestartGroup.createNode(constructor);
                                } else {
                                    startRestartGroup.useNode();
                                }
                                Composer m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
                                Updater.m4116setimpl(m4109constructorimpl, animatedContentMeasurePolicy, (Function2<? super T, ? super AnimatedContentMeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(hashCode))) {
                                    m4109constructorimpl.updateRememberedValue(Integer.valueOf(hashCode));
                                    m4109constructorimpl.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                                }
                                Updater.m4116setimpl(m4109constructorimpl, materializeModifier, (Function2<? super T, ? super Modifier, Unit>) ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -895590996, "C:AnimatedContent.kt#xbi5r1");
                                startRestartGroup.startReplaceGroup(-860173498);
                                ComposerKt.sourceInformation(startRestartGroup, "");
                                SnapshotStateList snapshotStateList4 = snapshotStateList;
                                int size2 = snapshotStateList4.size();
                                for (int i12 = 0; i12 < size2; i12++) {
                                    T t2 = snapshotStateList4.get(i12);
                                    startRestartGroup.startMovableGroup(-2026002954, function14.invoke(t2));
                                    ComposerKt.sourceInformation(startRestartGroup, "");
                                    Function2 function2 = (Function2) mutableScatterMap.get(t2);
                                    if (function2 == null) {
                                        startRestartGroup.startReplaceGroup(1618454323);
                                        startRestartGroup.endReplaceGroup();
                                    } else {
                                        startRestartGroup.startReplaceGroup(-2026001778);
                                        ComposerKt.sourceInformation(startRestartGroup, "872@43737L8");
                                        function2.invoke(startRestartGroup, 0);
                                        startRestartGroup.endReplaceGroup();
                                        Unit unit2 = Unit.INSTANCE;
                                    }
                                    startRestartGroup.endMovableGroup();
                                }
                                startRestartGroup.endReplaceGroup();
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                startRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function15 = function18;
                                function16 = function14;
                                modifier3 = modifier4;
                                alignment3 = alignment4;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$9
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

                                    public final void invoke(Composer composer2, int i13) {
                                        AnimatedContentKt.AnimatedContent(transition, modifier3, function15, alignment3, function16, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        boolean z6 = true;
                        if (startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    function14 = function12;
                    if ((i2 & 16) != 0) {
                    }
                    boolean z62 = true;
                    if (startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                alignment2 = alignment;
                i6 = i2 & 8;
                if (i6 == 0) {
                }
                function14 = function12;
                if ((i2 & 16) != 0) {
                }
                boolean z622 = true;
                if (startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            function13 = function1;
            i5 = i2 & 4;
            if (i5 != 0) {
            }
            alignment2 = alignment;
            i6 = i2 & 8;
            if (i6 == 0) {
            }
            function14 = function12;
            if ((i2 & 16) != 0) {
            }
            boolean z6222 = true;
            if (startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 2;
        if (i4 == 0) {
        }
        function13 = function1;
        i5 = i2 & 4;
        if (i5 != 0) {
        }
        alignment2 = alignment;
        i6 = i2 & 8;
        if (i6 == 0) {
        }
        function14 = function12;
        if ((i2 & 16) != 0) {
        }
        boolean z62222 = true;
        if (startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    static {
        long j = Integer.MIN_VALUE;
        UnspecifiedSize = IntSize.constructor-impl((j & 4294967295L) | (j << 32));
    }
}
