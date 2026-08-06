package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.TransformOrigin;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AndroidMenu.android.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001an\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001ad\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u008e\u0001\u0010\u0017\u001a\u00020\u00012\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007¢\u0006\u0002\u0010#\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-4kj-_NE", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "text", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class AndroidMenu_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:105:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00a0  */
    /* renamed from: DropdownMenu-4kj-_NE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2197DropdownMenu4kj_NE(final boolean z, final Function0<Unit> function0, Modifier modifier, long j, ScrollState scrollState, PopupProperties popupProperties, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        long j2;
        int i5;
        PopupProperties popupProperties2;
        ScrollState scrollState2;
        long j3;
        PopupProperties popupProperties3;
        Modifier modifier3;
        ScrollState scrollState3;
        Object rememberedValue;
        final MutableTransitionState mutableTransitionState;
        Object rememberedValue2;
        boolean changed;
        Object rememberedValue3;
        final Modifier modifier4;
        final long j4;
        final ScrollState scrollState4;
        final PopupProperties popupProperties4;
        ScopeUpdateScope endRestartGroup;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1137929566);
        ComposerKt.sourceInformation(startRestartGroup, "C(DropdownMenu)P(1,4,2,3:c#ui.unit.DpOffset,6,5)88@4529L21,92@4697L42,96@4884L51,97@4971L7,98@5015L281,107@5306L441:AndroidMenu.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? Fields.RotationX : Fields.SpotShadowColor;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
                j2 = j;
            } else {
                j2 = j;
                if ((i & 3072) == 0) {
                    i3 |= startRestartGroup.changed(j2) ? Fields.CameraDistance : Fields.RotationZ;
                }
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0 && startRestartGroup.changed(scrollState)) {
                    i6 = Fields.Clip;
                    i3 |= i6;
                }
                i6 = Fields.Shape;
                i3 |= i6;
            }
            i5 = i2 & 32;
            if (i5 == 0) {
                i3 |= 196608;
            } else if ((196608 & i) == 0) {
                popupProperties2 = popupProperties;
                i3 |= startRestartGroup.changed(popupProperties2) ? Fields.RenderEffect : 65536;
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    i3 |= startRestartGroup.changedInstance(function3) ? 1048576 : Fields.BlendMode;
                }
                if ((i3 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                        if (i4 != 0) {
                            float f = 0;
                            j2 = DpKt.DpOffset-YgX7TsA(Dp.constructor-impl(f), Dp.constructor-impl(f));
                        }
                        if ((i2 & 16) != 0) {
                            scrollState2 = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                            i3 &= -57345;
                        } else {
                            scrollState2 = scrollState;
                        }
                        if (i5 != 0) {
                            popupProperties3 = new PopupProperties(true, false, false, (SecureFlagPolicy) null, false, false, 62, (DefaultConstructorMarker) null);
                            scrollState3 = scrollState2;
                            j3 = j2;
                            modifier3 = companion;
                        } else {
                            j3 = j2;
                            popupProperties3 = popupProperties2;
                            modifier3 = companion;
                            scrollState3 = scrollState2;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        j3 = j2;
                        popupProperties3 = popupProperties2;
                        scrollState3 = scrollState;
                        modifier3 = modifier2;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1137929566, i3, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:91)");
                    }
                    startRestartGroup.startReplaceableGroup(463006278);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new MutableTransitionState(false);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    mutableTransitionState = (MutableTransitionState) rememberedValue;
                    startRestartGroup.endReplaceableGroup();
                    mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                    if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue() || ((Boolean) mutableTransitionState.getTargetState()).booleanValue()) {
                        startRestartGroup.startReplaceableGroup(463006465);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m5236boximpl(TransformOrigin.INSTANCE.m5249getCenterSzJe1aQ()), null, 2, null);
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        final MutableState mutableState = (MutableState) rememberedValue2;
                        startRestartGroup.endReplaceableGroup();
                        ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume = startRestartGroup.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        Density density = (Density) consume;
                        startRestartGroup.startReplaceableGroup(463006596);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        changed = ((i3 & 7168) == 2048) | startRestartGroup.changed(density);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = new DropdownMenuPositionProvider(j3, density, 0, new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((IntRect) obj, (IntRect) obj2);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(IntRect intRect, IntRect intRect2) {
                                    mutableState.setValue(TransformOrigin.m5236boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
                                }
                            }, 4, null);
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        startRestartGroup.endReplaceableGroup();
                        final ScrollState scrollState5 = scrollState3;
                        final Modifier modifier5 = modifier3;
                        AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) rememberedValue3, function0, popupProperties3, ComposableLambdaKt.composableLambda(startRestartGroup, -848116919, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1
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

                            public final void invoke(Composer composer2, int i8) {
                                ComposerKt.sourceInformation(composer2, "C112@5481L256:AndroidMenu.android.kt#uh7d8r");
                                if ((i8 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-848116919, i8, -1, "androidx.compose.material3.DropdownMenu.<anonymous> (AndroidMenu.android.kt:112)");
                                    }
                                    MenuKt.DropdownMenuContent(mutableTransitionState, mutableState, scrollState5, modifier5, function3, composer2, MutableTransitionState.$stable | 48, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), startRestartGroup, (i3 & 112) | 3072 | ((i3 >> 9) & 896), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    j4 = j3;
                    scrollState4 = scrollState3;
                    popupProperties4 = popupProperties3;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    scrollState4 = scrollState;
                    modifier4 = modifier2;
                    j4 = j2;
                    popupProperties4 = popupProperties2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$2
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

                        public final void invoke(Composer composer2, int i8) {
                            AndroidMenu_androidKt.m2197DropdownMenu4kj_NE(z, function0, modifier4, j4, scrollState4, popupProperties4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            popupProperties2 = popupProperties;
            if ((i2 & 64) != 0) {
            }
            if ((i3 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i7 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i5 != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(463006278);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            mutableTransitionState = (MutableTransitionState) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
            if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
            }
            startRestartGroup.startReplaceableGroup(463006465);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            }
            final MutableState<TransformOrigin> mutableState2 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceableGroup();
            ProvidableCompositionLocal localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density2 = (Density) consume2;
            startRestartGroup.startReplaceableGroup(463006596);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
            changed = ((i3 & 7168) == 2048) | startRestartGroup.changed(density2);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue3 = new DropdownMenuPositionProvider(j3, density2, 0, new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((IntRect) obj, (IntRect) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(IntRect intRect, IntRect intRect2) {
                    mutableState2.setValue(TransformOrigin.m5236boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
                }
            }, 4, null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
            startRestartGroup.endReplaceableGroup();
            final ScrollState scrollState52 = scrollState3;
            final Modifier modifier52 = modifier3;
            AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) rememberedValue3, function0, popupProperties3, ComposableLambdaKt.composableLambda(startRestartGroup, -848116919, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1
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

                public final void invoke(Composer composer2, int i8) {
                    ComposerKt.sourceInformation(composer2, "C112@5481L256:AndroidMenu.android.kt#uh7d8r");
                    if ((i8 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-848116919, i8, -1, "androidx.compose.material3.DropdownMenu.<anonymous> (AndroidMenu.android.kt:112)");
                        }
                        MenuKt.DropdownMenuContent(mutableTransitionState, mutableState2, scrollState52, modifier52, function3, composer2, MutableTransitionState.$stable | 48, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, (i3 & 112) | 3072 | ((i3 >> 9) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            j4 = j3;
            scrollState4 = scrollState3;
            popupProperties4 = popupProperties3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 == 0) {
        }
        popupProperties2 = popupProperties;
        if ((i2 & 64) != 0) {
        }
        if ((i3 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i5 != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(463006278);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        mutableTransitionState = (MutableTransitionState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
        if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
        }
        startRestartGroup.startReplaceableGroup(463006465);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
        }
        final MutableState<TransformOrigin> mutableState22 = (MutableState) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        ProvidableCompositionLocal localDensity22 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22 = startRestartGroup.consume(localDensity22);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density22 = (Density) consume22;
        startRestartGroup.startReplaceableGroup(463006596);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
        changed = ((i3 & 7168) == 2048) | startRestartGroup.changed(density22);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue3 = new DropdownMenuPositionProvider(j3, density22, 0, new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((IntRect) obj, (IntRect) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(IntRect intRect, IntRect intRect2) {
                mutableState22.setValue(TransformOrigin.m5236boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
            }
        }, 4, null);
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceableGroup();
        final ScrollState scrollState522 = scrollState3;
        final Modifier modifier522 = modifier3;
        AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) rememberedValue3, function0, popupProperties3, ComposableLambdaKt.composableLambda(startRestartGroup, -848116919, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1
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

            public final void invoke(Composer composer2, int i8) {
                ComposerKt.sourceInformation(composer2, "C112@5481L256:AndroidMenu.android.kt#uh7d8r");
                if ((i8 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-848116919, i8, -1, "androidx.compose.material3.DropdownMenu.<anonymous> (AndroidMenu.android.kt:112)");
                    }
                    MenuKt.DropdownMenuContent(mutableTransitionState, mutableState22, scrollState522, modifier522, function3, composer2, MutableTransitionState.$stable | 48, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, (i3 & 112) | 3072 | ((i3 >> 9) & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        j4 = j3;
        scrollState4 = scrollState3;
        popupProperties4 = popupProperties3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0051  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced by a DropdownMenu function with a ScrollState parameter", replaceWith = @ReplaceWith(expression = "DropdownMenu(expanded,onDismissRequest, modifier, offset, rememberScrollState(), properties, content)", imports = {"androidx.compose.foundation.rememberScrollState"}))
    /* renamed from: DropdownMenu-ILWXrKs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m2198DropdownMenuILWXrKs(final boolean z, final Function0 function0, Modifier modifier, long j, PopupProperties popupProperties, final Function3 function3, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier modifier2;
        int i5;
        long j2;
        int i6;
        PopupProperties popupProperties2;
        final Modifier modifier3;
        final PopupProperties popupProperties3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(354826666);
        ComposerKt.sourceInformation(startRestartGroup, "C(DropdownMenu)P(1,4,2,3:c#ui.unit.DpOffset,5)146@6601L21,141@6457L219:AndroidMenu.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= startRestartGroup.changed(modifier2) ? Fields.RotationX : Fields.SpotShadowColor;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    j2 = j;
                    i3 |= startRestartGroup.changed(j2) ? Fields.CameraDistance : Fields.RotationZ;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        popupProperties2 = popupProperties;
                        i3 |= startRestartGroup.changed(popupProperties2) ? Fields.Clip : Fields.Shape;
                        if ((i2 & 32) != 0) {
                            i3 |= 196608;
                        } else if ((i & 196608) == 0) {
                            i3 |= startRestartGroup.changedInstance(function3) ? Fields.RenderEffect : 65536;
                        }
                        if ((74899 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                            if (i4 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                float f = 0;
                                j2 = DpKt.DpOffset-YgX7TsA(Dp.constructor-impl(f), Dp.constructor-impl(f));
                            }
                            long j3 = j2;
                            PopupProperties popupProperties4 = i6 != 0 ? new PopupProperties(true, false, false, (SecureFlagPolicy) null, false, false, 62, (DefaultConstructorMarker) null) : popupProperties2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(354826666, i3, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:141)");
                            }
                            int i7 = (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                            int i8 = i3 << 3;
                            m2197DropdownMenu4kj_NE(z, function0, modifier2, j3, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), popupProperties4, function3, startRestartGroup, i7 | (458752 & i8) | (i8 & 3670016), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            popupProperties3 = popupProperties4;
                            j2 = j3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            popupProperties3 = popupProperties2;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final long j4 = j2;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$3
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
                                    AndroidMenu_androidKt.m2198DropdownMenuILWXrKs(z, function0, modifier3, j4, popupProperties3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    popupProperties2 = popupProperties;
                    if ((i2 & 32) != 0) {
                    }
                    if ((74899 & i3) == 74898) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    long j32 = j2;
                    if (i6 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i72 = (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                    int i82 = i3 << 3;
                    m2197DropdownMenu4kj_NE(z, function0, modifier2, j32, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), popupProperties4, function3, startRestartGroup, i72 | (458752 & i82) | (i82 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier2;
                    popupProperties3 = popupProperties4;
                    j2 = j32;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                j2 = j;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                popupProperties2 = popupProperties;
                if ((i2 & 32) != 0) {
                }
                if ((74899 & i3) == 74898) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                long j322 = j2;
                if (i6 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i722 = (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                int i822 = i3 << 3;
                m2197DropdownMenu4kj_NE(z, function0, modifier2, j322, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), popupProperties4, function3, startRestartGroup, i722 | (458752 & i822) | (i822 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                popupProperties3 = popupProperties4;
                j2 = j322;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            j2 = j;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            popupProperties2 = popupProperties;
            if ((i2 & 32) != 0) {
            }
            if ((74899 & i3) == 74898) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            long j3222 = j2;
            if (i6 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i7222 = (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
            int i8222 = i3 << 3;
            m2197DropdownMenu4kj_NE(z, function0, modifier2, j3222, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), popupProperties4, function3, startRestartGroup, i7222 | (458752 & i8222) | (i8222 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            popupProperties3 = popupProperties4;
            j2 = j3222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        j2 = j;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        popupProperties2 = popupProperties;
        if ((i2 & 32) != 0) {
        }
        if ((74899 & i3) == 74898) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        long j32222 = j2;
        if (i6 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i72222 = (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
        int i82222 = i3 << 3;
        m2197DropdownMenu4kj_NE(z, function0, modifier2, j32222, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), popupProperties4, function3, startRestartGroup, i72222 | (458752 & i82222) | (i82222 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        popupProperties3 = popupProperties4;
        j2 = j32222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DropdownMenuItem(final Function2<? super Composer, ? super Integer, Unit> function2, final Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, boolean z, MenuItemColors menuItemColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i7;
        boolean z2;
        MenuItemColors menuItemColors2;
        int i8;
        int i9;
        Modifier.Companion companion;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        boolean z3;
        MenuItemColors menuItemColors3;
        PaddingValues dropdownMenuItemContentPadding;
        MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier2;
        final boolean z4;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final MenuItemColors menuItemColors4;
        final PaddingValues paddingValues2;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(1826340448);
        ComposerKt.sourceInformation(startRestartGroup, "C(DropdownMenuItem)P(7,6,5,4,8,2)186@8615L12,188@8760L39,190@8809L319:AndroidMenu.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= startRestartGroup.changed(modifier) ? Fields.RotationX : Fields.SpotShadowColor;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    function24 = function22;
                    i3 |= startRestartGroup.changedInstance(function24) ? Fields.CameraDistance : Fields.RotationZ;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        function25 = function23;
                        i3 |= startRestartGroup.changedInstance(function25) ? Fields.Clip : Fields.Shape;
                        i7 = i2 & 32;
                        if (i7 != 0) {
                            i3 |= 196608;
                        } else if ((196608 & i) == 0) {
                            z2 = z;
                            i3 |= startRestartGroup.changed(z2) ? Fields.RenderEffect : 65536;
                            if ((1572864 & i) != 0) {
                                if ((i2 & 64) == 0) {
                                    menuItemColors2 = menuItemColors;
                                    if (startRestartGroup.changed(menuItemColors2)) {
                                        i10 = 1048576;
                                        i3 |= i10;
                                    }
                                } else {
                                    menuItemColors2 = menuItemColors;
                                }
                                i10 = Fields.BlendMode;
                                i3 |= i10;
                            } else {
                                menuItemColors2 = menuItemColors;
                            }
                            i8 = i2 & Fields.SpotShadowColor;
                            if (i8 == 0) {
                                i3 |= 12582912;
                            } else if ((i & 12582912) == 0) {
                                i3 |= startRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                            }
                            i9 = i2 & Fields.RotationX;
                            if (i9 == 0) {
                                i3 |= 100663296;
                            } else if ((i & 100663296) == 0) {
                                i3 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                            }
                            if ((i3 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    companion = i4 == 0 ? Modifier.INSTANCE : modifier;
                                    if (i5 != 0) {
                                        function24 = null;
                                    }
                                    function26 = i6 == 0 ? function25 : null;
                                    z3 = i7 == 0 ? true : z2;
                                    if ((i2 & 64) == 0) {
                                        menuItemColors3 = MenuDefaults.INSTANCE.itemColors(startRestartGroup, 6);
                                        i3 &= -3670017;
                                    } else {
                                        menuItemColors3 = menuItemColors2;
                                    }
                                    dropdownMenuItemContentPadding = i8 == 0 ? MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding() : paddingValues;
                                    if (i9 == 0) {
                                        startRestartGroup.startReplaceableGroup(1989948114);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AndroidMenu.android.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                        startRestartGroup.endReplaceableGroup();
                                    } else {
                                        mutableInteractionSource2 = mutableInteractionSource;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 64) != 0) {
                                        i3 &= -3670017;
                                    }
                                    companion = modifier;
                                    dropdownMenuItemContentPadding = paddingValues;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    function26 = function25;
                                    z3 = z2;
                                    menuItemColors3 = menuItemColors2;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1826340448, i3, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:189)");
                                }
                                MenuKt.DropdownMenuItemContent(function2, function0, companion, function24, function26, z3, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, startRestartGroup, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (29360128 & i3) | (i3 & 234881024));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = companion;
                                z4 = z3;
                                function27 = function24;
                                menuItemColors4 = menuItemColors3;
                                paddingValues2 = dropdownMenuItemContentPadding;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier2 = modifier;
                                mutableInteractionSource3 = mutableInteractionSource;
                                function27 = function24;
                                function26 = function25;
                                z4 = z2;
                                menuItemColors4 = menuItemColors2;
                                paddingValues2 = paddingValues;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenuItem$2
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

                                    public final void invoke(Composer composer2, int i11) {
                                        AndroidMenu_androidKt.DropdownMenuItem(function2, function0, modifier2, function27, function26, z4, menuItemColors4, paddingValues2, mutableInteractionSource3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        z2 = z;
                        if ((1572864 & i) != 0) {
                        }
                        i8 = i2 & Fields.SpotShadowColor;
                        if (i8 == 0) {
                        }
                        i9 = i2 & Fields.RotationX;
                        if (i9 == 0) {
                        }
                        if ((i3 & 38347923) == 38347922) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i4 == 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if ((i2 & 64) == 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (i9 == 0) {
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        MenuKt.DropdownMenuItemContent(function2, function0, companion, function24, function26, z3, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, startRestartGroup, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (29360128 & i3) | (i3 & 234881024));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier2 = companion;
                        z4 = z3;
                        function27 = function24;
                        menuItemColors4 = menuItemColors3;
                        paddingValues2 = dropdownMenuItemContentPadding;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    function25 = function23;
                    i7 = i2 & 32;
                    if (i7 != 0) {
                    }
                    z2 = z;
                    if ((1572864 & i) != 0) {
                    }
                    i8 = i2 & Fields.SpotShadowColor;
                    if (i8 == 0) {
                    }
                    i9 = i2 & Fields.RotationX;
                    if (i9 == 0) {
                    }
                    if ((i3 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i4 == 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i7 == 0) {
                    }
                    if ((i2 & 64) == 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i9 == 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    MenuKt.DropdownMenuItemContent(function2, function0, companion, function24, function26, z3, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, startRestartGroup, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (29360128 & i3) | (i3 & 234881024));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = companion;
                    z4 = z3;
                    function27 = function24;
                    menuItemColors4 = menuItemColors3;
                    paddingValues2 = dropdownMenuItemContentPadding;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                function24 = function22;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                function25 = function23;
                i7 = i2 & 32;
                if (i7 != 0) {
                }
                z2 = z;
                if ((1572864 & i) != 0) {
                }
                i8 = i2 & Fields.SpotShadowColor;
                if (i8 == 0) {
                }
                i9 = i2 & Fields.RotationX;
                if (i9 == 0) {
                }
                if ((i3 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i4 == 0) {
                }
                if (i5 != 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if ((i2 & 64) == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                MenuKt.DropdownMenuItemContent(function2, function0, companion, function24, function26, z3, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, startRestartGroup, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (29360128 & i3) | (i3 & 234881024));
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = companion;
                z4 = z3;
                function27 = function24;
                menuItemColors4 = menuItemColors3;
                paddingValues2 = dropdownMenuItemContentPadding;
                mutableInteractionSource3 = mutableInteractionSource2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function24 = function22;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            function25 = function23;
            i7 = i2 & 32;
            if (i7 != 0) {
            }
            z2 = z;
            if ((1572864 & i) != 0) {
            }
            i8 = i2 & Fields.SpotShadowColor;
            if (i8 == 0) {
            }
            i9 = i2 & Fields.RotationX;
            if (i9 == 0) {
            }
            if ((i3 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i4 == 0) {
            }
            if (i5 != 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if ((i2 & 64) == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            MenuKt.DropdownMenuItemContent(function2, function0, companion, function24, function26, z3, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, startRestartGroup, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (29360128 & i3) | (i3 & 234881024));
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = companion;
            z4 = z3;
            function27 = function24;
            menuItemColors4 = menuItemColors3;
            paddingValues2 = dropdownMenuItemContentPadding;
            mutableInteractionSource3 = mutableInteractionSource2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function24 = function22;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        function25 = function23;
        i7 = i2 & 32;
        if (i7 != 0) {
        }
        z2 = z;
        if ((1572864 & i) != 0) {
        }
        i8 = i2 & Fields.SpotShadowColor;
        if (i8 == 0) {
        }
        i9 = i2 & Fields.RotationX;
        if (i9 == 0) {
        }
        if ((i3 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i4 == 0) {
        }
        if (i5 != 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        MenuKt.DropdownMenuItemContent(function2, function0, companion, function24, function26, z3, menuItemColors3, dropdownMenuItemContentPadding, mutableInteractionSource2, startRestartGroup, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (29360128 & i3) | (i3 & 234881024));
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = companion;
        z4 = z3;
        function27 = function24;
        menuItemColors4 = menuItemColors3;
        paddingValues2 = dropdownMenuItemContentPadding;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
