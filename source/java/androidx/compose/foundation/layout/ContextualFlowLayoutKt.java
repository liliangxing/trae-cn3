package androidx.compose.foundation.layout;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.SubcomposeLayoutKt;
import androidx.compose.p002ui.layout.SubcomposeMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* compiled from: ContextualFlowLayout.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u008e\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f21\u0010\u0010\u001a-\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a\u008e\u0001\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u001d21\u0010\u0010\u001a-\u0012\u0004\u0012\u00020\u001e\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u001f\u001a\u00ad\u0001\u0010 \u001a\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010'\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010)¢\u0006\u0002\b\u00160(2;\u0010*\u001a7\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110+¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016H\u0001¢\u0006\u0002\u0010-\u001a\u00ad\u0001\u0010.\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010'\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010)¢\u0006\u0002\b\u00160(2;\u0010*\u001a7\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110+¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016H\u0001¢\u0006\u0002\u0010/¨\u00060"}, d2 = {"ContextualFlowRow", "", "itemCount", "", "modifier", "Landroidx/compose/ui/Modifier;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "itemVerticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "maxItemsInEachRow", "maxLines", "overflow", "Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", "content", "Lkotlin/Function2;", "Landroidx/compose/foundation/layout/ContextualFlowRowScope;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "index", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/ContextualFlowRowOverflow;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "ContextualFlowColumn", "itemHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "maxItemsInEachColumn", "Landroidx/compose/foundation/layout/ContextualFlowColumnOverflow;", "Landroidx/compose/foundation/layout/ContextualFlowColumnScope;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/ContextualFlowColumnOverflow;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "contextualRowMeasurementHelper", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "maxItemsInMainAxis", "overflowState", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "overflowComposables", "", "Lkotlin/Function0;", "getComposable", "Landroidx/compose/foundation/layout/FlowLineInfo;", "info", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;ILjava/util/List;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "contextualColumnMeasureHelper", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;ILjava/util/List;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ContextualFlowLayoutKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContextualFlowColumn$lambda$5(int i, Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i2, int i3, ContextualFlowColumnOverflow contextualFlowColumnOverflow, Function4 function4, int i4, int i5, Composer composer, int i6) {
        ContextualFlowColumn(i, modifier, vertical, horizontal, horizontal2, i2, i3, contextualFlowColumnOverflow, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContextualFlowRow$lambda$2(int i, Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i2, int i3, ContextualFlowRowOverflow contextualFlowRowOverflow, Function4 function4, int i4, int i5, Composer composer, int i6) {
        ContextualFlowRow(i, modifier, horizontal, vertical, vertical2, i2, i3, contextualFlowRowOverflow, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x01c0, code lost:
    
        if (r13 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L145;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00e9  */
    @Deprecated(message = "ContextualFlowLayouts are no longer maintained")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ContextualFlowRow(final int i, Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i2, int i3, ContextualFlowRowOverflow contextualFlowRowOverflow, final Function4<? super ContextualFlowRowScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i4, final int i5) {
        int i6;
        int i7;
        int i8;
        Arrangement.Vertical vertical3;
        int i9;
        Alignment.Vertical vertical4;
        int i10;
        int i11;
        int i12;
        final Modifier.Companion companion;
        final Arrangement.Horizontal horizontal2;
        final int i13;
        final int i14;
        final ContextualFlowRowOverflow contextualFlowRowOverflow2;
        final Arrangement.Vertical vertical5;
        final Alignment.Vertical vertical6;
        ScopeUpdateScope endRestartGroup;
        Object obj;
        Composer startRestartGroup = composer.startRestartGroup(-294153140);
        ComposerKt.sourceInformation(startRestartGroup, "C(ContextualFlowRow)N(itemCount,modifier,horizontalArrangement,verticalArrangement,itemVerticalAlignment,maxItemsInEachRow,maxLines,overflow,content)80@3819L53,82@3926L209,97@4434L336,88@4168L602,107@4775L68:ContextualFlowLayout.kt#2w3rfo");
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i6 = (startRestartGroup.changed(i) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i15 = i5 & 2;
        if (i15 != 0) {
            i6 |= 48;
        } else if ((i4 & 48) == 0) {
            i6 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else if ((i4 & 384) == 0) {
                i6 |= startRestartGroup.changed(horizontal) ? Fields.RotationX : Fields.SpotShadowColor;
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else if ((i4 & 3072) == 0) {
                    vertical3 = vertical;
                    i6 |= startRestartGroup.changed(vertical3) ? Fields.CameraDistance : Fields.RotationZ;
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else if ((i4 & 24576) == 0) {
                        vertical4 = vertical2;
                        i6 |= startRestartGroup.changed(vertical4) ? Fields.Clip : Fields.Shape;
                        i10 = i5 & 32;
                        if (i10 != 0) {
                            i6 |= 196608;
                        } else if ((i4 & 196608) == 0) {
                            i6 |= startRestartGroup.changed(i2) ? Fields.RenderEffect : 65536;
                        }
                        i11 = i5 & 64;
                        if (i11 != 0) {
                            i6 |= 1572864;
                        } else if ((i4 & 1572864) == 0) {
                            i6 |= startRestartGroup.changed(i3) ? 1048576 : Fields.BlendMode;
                        }
                        i12 = i5 & Fields.SpotShadowColor;
                        if (i12 != 0) {
                            i6 |= 12582912;
                        } else if ((i4 & 12582912) == 0) {
                            i6 |= startRestartGroup.changed(contextualFlowRowOverflow) ? 8388608 : 4194304;
                        }
                        if ((i5 & Fields.RotationX) != 0) {
                            i6 |= 100663296;
                        } else if ((i4 & 100663296) == 0) {
                            i6 |= startRestartGroup.changedInstance(function4) ? 67108864 : 33554432;
                        }
                        if (!startRestartGroup.shouldExecute((38347923 & i6) != 38347922, i6 & 1)) {
                            startRestartGroup.skipToGroupEnd();
                            companion = modifier;
                            horizontal2 = horizontal;
                            i13 = i2;
                            i14 = i3;
                            contextualFlowRowOverflow2 = contextualFlowRowOverflow;
                            vertical5 = vertical3;
                            vertical6 = vertical4;
                        } else {
                            companion = i15 != 0 ? Modifier.INSTANCE : modifier;
                            Arrangement.Horizontal start = i7 != 0 ? Arrangement.INSTANCE.getStart() : horizontal;
                            Arrangement.Vertical top = i8 != 0 ? Arrangement.INSTANCE.getTop() : vertical3;
                            Alignment.Vertical top2 = i9 != 0 ? Alignment.INSTANCE.getTop() : vertical4;
                            int i16 = i10 != 0 ? Integer.MAX_VALUE : i2;
                            int i17 = i11 == 0 ? i3 : Integer.MAX_VALUE;
                            ContextualFlowRowOverflow clip = i12 != 0 ? ContextualFlowRowOverflow.INSTANCE.getClip() : contextualFlowRowOverflow;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-294153140, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:79)");
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 786694049, "CC(remember):ContextualFlowLayout.kt#9igjgp");
                            int i18 = 29360128 & i6;
                            boolean z = i18 == 8388608;
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = clip.createOverflowState$foundation_layout();
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 786697629, "CC(remember):ContextualFlowLayout.kt#9igjgp");
                            boolean z2 = i18 == 8388608;
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!z2) {
                                obj = rememberedValue2;
                            }
                            ArrayList arrayList = new ArrayList();
                            clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList);
                            startRestartGroup.updateRememberedValue(arrayList);
                            obj = arrayList;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i19 = i6 >> 6;
                            SubcomposeLayoutKt.SubcomposeLayout(companion, contextualRowMeasurementHelper(start, top, top2, i16, i17, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-1677845586, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                                    invoke(((Number) obj2).intValue(), (FlowLineInfo) obj3, (Composer) obj4, ((Number) obj5).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(int i20, FlowLineInfo flowLineInfo, Composer composer2, int i21) {
                                    ComposerKt.sourceInformation(composer2, "CN(index,info)105@4746L14:ContextualFlowLayout.kt#2w3rfo");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1677845586, i21, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:98)");
                                    }
                                    function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex(), flowLineInfo.getPositionInLine(), flowLineInfo.getMaxMainAxisSize(), flowLineInfo.getMaxCrossAxisSize(), null), Integer.valueOf(i20), composer2, Integer.valueOf((i21 << 3) & 112));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), startRestartGroup, (i19 & 57344) | (i19 & 14) | 100663296 | (i19 & 112) | (i19 & 896) | (i19 & 7168) | ((i6 << 18) & 3670016)), startRestartGroup, (i6 >> 3) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            horizontal2 = start;
                            vertical5 = top;
                            vertical6 = top2;
                            i14 = i17;
                            i13 = i16;
                            contextualFlowRowOverflow2 = clip;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj2, Object obj3) {
                                    Unit ContextualFlowRow$lambda$2;
                                    ContextualFlowRow$lambda$2 = ContextualFlowLayoutKt.ContextualFlowRow$lambda$2(i, companion, horizontal2, vertical5, vertical6, i13, i14, contextualFlowRowOverflow2, function4, i4, i5, (Composer) obj2, ((Integer) obj3).intValue());
                                    return ContextualFlowRow$lambda$2;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    vertical4 = vertical2;
                    i10 = i5 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i5 & 64;
                    if (i11 != 0) {
                    }
                    i12 = i5 & Fields.SpotShadowColor;
                    if (i12 != 0) {
                    }
                    if ((i5 & Fields.RotationX) != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((38347923 & i6) != 38347922, i6 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                vertical3 = vertical;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                vertical4 = vertical2;
                i10 = i5 & 32;
                if (i10 != 0) {
                }
                i11 = i5 & 64;
                if (i11 != 0) {
                }
                i12 = i5 & Fields.SpotShadowColor;
                if (i12 != 0) {
                }
                if ((i5 & Fields.RotationX) != 0) {
                }
                if (!startRestartGroup.shouldExecute((38347923 & i6) != 38347922, i6 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            vertical3 = vertical;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            vertical4 = vertical2;
            i10 = i5 & 32;
            if (i10 != 0) {
            }
            i11 = i5 & 64;
            if (i11 != 0) {
            }
            i12 = i5 & Fields.SpotShadowColor;
            if (i12 != 0) {
            }
            if ((i5 & Fields.RotationX) != 0) {
            }
            if (!startRestartGroup.shouldExecute((38347923 & i6) != 38347922, i6 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        vertical3 = vertical;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        vertical4 = vertical2;
        i10 = i5 & 32;
        if (i10 != 0) {
        }
        i11 = i5 & 64;
        if (i11 != 0) {
        }
        i12 = i5 & Fields.SpotShadowColor;
        if (i12 != 0) {
        }
        if ((i5 & Fields.RotationX) != 0) {
        }
        if (!startRestartGroup.shouldExecute((38347923 & i6) != 38347922, i6 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x01c0, code lost:
    
        if (r13 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L145;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00e9  */
    @Deprecated(message = "ContextualFlowLayouts are no longer maintained")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ContextualFlowColumn(final int i, Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i2, int i3, ContextualFlowColumnOverflow contextualFlowColumnOverflow, final Function4<? super ContextualFlowColumnScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i4, final int i5) {
        int i6;
        int i7;
        int i8;
        Arrangement.Horizontal horizontal3;
        int i9;
        Alignment.Horizontal horizontal4;
        int i10;
        int i11;
        int i12;
        final Modifier.Companion companion;
        final Arrangement.Vertical vertical2;
        final int i13;
        final int i14;
        final ContextualFlowColumnOverflow contextualFlowColumnOverflow2;
        final Arrangement.Horizontal horizontal5;
        final Alignment.Horizontal horizontal6;
        ScopeUpdateScope endRestartGroup;
        Object obj;
        Composer startRestartGroup = composer.startRestartGroup(1986851536);
        ComposerKt.sourceInformation(startRestartGroup, "C(ContextualFlowColumn)N(itemCount,modifier,verticalArrangement,horizontalArrangement,itemHorizontalAlignment,maxItemsInEachColumn,maxLines,overflow,content)155@7415L53,157@7522L209,172@8034L339,163@7764L609,183@8379L68:ContextualFlowLayout.kt#2w3rfo");
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i6 = (startRestartGroup.changed(i) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i15 = i5 & 2;
        if (i15 != 0) {
            i6 |= 48;
        } else if ((i4 & 48) == 0) {
            i6 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else if ((i4 & 384) == 0) {
                i6 |= startRestartGroup.changed(vertical) ? Fields.RotationX : Fields.SpotShadowColor;
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else if ((i4 & 3072) == 0) {
                    horizontal3 = horizontal;
                    i6 |= startRestartGroup.changed(horizontal3) ? Fields.CameraDistance : Fields.RotationZ;
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else if ((i4 & 24576) == 0) {
                        horizontal4 = horizontal2;
                        i6 |= startRestartGroup.changed(horizontal4) ? Fields.Clip : Fields.Shape;
                        i10 = i5 & 32;
                        if (i10 != 0) {
                            i6 |= 196608;
                        } else if ((i4 & 196608) == 0) {
                            i6 |= startRestartGroup.changed(i2) ? Fields.RenderEffect : 65536;
                        }
                        i11 = i5 & 64;
                        if (i11 != 0) {
                            i6 |= 1572864;
                        } else if ((i4 & 1572864) == 0) {
                            i6 |= startRestartGroup.changed(i3) ? 1048576 : Fields.BlendMode;
                        }
                        i12 = i5 & Fields.SpotShadowColor;
                        if (i12 != 0) {
                            i6 |= 12582912;
                        } else if ((i4 & 12582912) == 0) {
                            i6 |= startRestartGroup.changed(contextualFlowColumnOverflow) ? 8388608 : 4194304;
                        }
                        if ((i5 & Fields.RotationX) != 0) {
                            i6 |= 100663296;
                        } else if ((i4 & 100663296) == 0) {
                            i6 |= startRestartGroup.changedInstance(function4) ? 67108864 : 33554432;
                        }
                        if (!startRestartGroup.shouldExecute((38347923 & i6) != 38347922, i6 & 1)) {
                            startRestartGroup.skipToGroupEnd();
                            companion = modifier;
                            vertical2 = vertical;
                            i13 = i2;
                            i14 = i3;
                            contextualFlowColumnOverflow2 = contextualFlowColumnOverflow;
                            horizontal5 = horizontal3;
                            horizontal6 = horizontal4;
                        } else {
                            companion = i15 != 0 ? Modifier.INSTANCE : modifier;
                            Arrangement.Vertical top = i7 != 0 ? Arrangement.INSTANCE.getTop() : vertical;
                            Arrangement.Horizontal start = i8 != 0 ? Arrangement.INSTANCE.getStart() : horizontal3;
                            Alignment.Horizontal start2 = i9 != 0 ? Alignment.INSTANCE.getStart() : horizontal4;
                            int i16 = i10 != 0 ? Integer.MAX_VALUE : i2;
                            int i17 = i11 == 0 ? i3 : Integer.MAX_VALUE;
                            ContextualFlowColumnOverflow clip = i12 != 0 ? ContextualFlowColumnOverflow.INSTANCE.getClip() : contextualFlowColumnOverflow;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1986851536, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:154)");
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1896099899, "CC(remember):ContextualFlowLayout.kt#9igjgp");
                            int i18 = 29360128 & i6;
                            boolean z = i18 == 8388608;
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = clip.createOverflowState$foundation_layout();
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1896096319, "CC(remember):ContextualFlowLayout.kt#9igjgp");
                            boolean z2 = i18 == 8388608;
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!z2) {
                                obj = rememberedValue2;
                            }
                            ArrayList arrayList = new ArrayList();
                            clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList);
                            startRestartGroup.updateRememberedValue(arrayList);
                            obj = arrayList;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i19 = i6 >> 6;
                            SubcomposeLayoutKt.SubcomposeLayout(companion, contextualColumnMeasureHelper(top, start, start2, i16, i17, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(620176540, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                                    invoke(((Number) obj2).intValue(), (FlowLineInfo) obj3, (Composer) obj4, ((Number) obj5).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(int i20, FlowLineInfo flowLineInfo, Composer composer2, int i21) {
                                    ComposerKt.sourceInformation(composer2, "CN(index,info)180@8349L14:ContextualFlowLayout.kt#2w3rfo");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(620176540, i21, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:173)");
                                    }
                                    function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex(), flowLineInfo.getPositionInLine(), flowLineInfo.getMaxCrossAxisSize(), flowLineInfo.getMaxMainAxisSize(), null), Integer.valueOf(i20), composer2, Integer.valueOf((i21 << 3) & 112));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), startRestartGroup, (i19 & 57344) | (i19 & 14) | 100663296 | (i19 & 112) | (i19 & 896) | (i19 & 7168) | ((i6 << 18) & 3670016)), startRestartGroup, (i6 >> 3) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            vertical2 = top;
                            horizontal5 = start;
                            horizontal6 = start2;
                            i14 = i17;
                            i13 = i16;
                            contextualFlowColumnOverflow2 = clip;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj2, Object obj3) {
                                    Unit ContextualFlowColumn$lambda$5;
                                    ContextualFlowColumn$lambda$5 = ContextualFlowLayoutKt.ContextualFlowColumn$lambda$5(i, companion, vertical2, horizontal5, horizontal6, i13, i14, contextualFlowColumnOverflow2, function4, i4, i5, (Composer) obj2, ((Integer) obj3).intValue());
                                    return ContextualFlowColumn$lambda$5;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    horizontal4 = horizontal2;
                    i10 = i5 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i5 & 64;
                    if (i11 != 0) {
                    }
                    i12 = i5 & Fields.SpotShadowColor;
                    if (i12 != 0) {
                    }
                    if ((i5 & Fields.RotationX) != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((38347923 & i6) != 38347922, i6 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                horizontal3 = horizontal;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                horizontal4 = horizontal2;
                i10 = i5 & 32;
                if (i10 != 0) {
                }
                i11 = i5 & 64;
                if (i11 != 0) {
                }
                i12 = i5 & Fields.SpotShadowColor;
                if (i12 != 0) {
                }
                if ((i5 & Fields.RotationX) != 0) {
                }
                if (!startRestartGroup.shouldExecute((38347923 & i6) != 38347922, i6 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            horizontal3 = horizontal;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            horizontal4 = horizontal2;
            i10 = i5 & 32;
            if (i10 != 0) {
            }
            i11 = i5 & 64;
            if (i11 != 0) {
            }
            i12 = i5 & Fields.SpotShadowColor;
            if (i12 != 0) {
            }
            if ((i5 & Fields.RotationX) != 0) {
            }
            if (!startRestartGroup.shouldExecute((38347923 & i6) != 38347922, i6 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        horizontal3 = horizontal;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        horizontal4 = horizontal2;
        i10 = i5 & 32;
        if (i10 != 0) {
        }
        i11 = i5 & 64;
        if (i11 != 0) {
        }
        i12 = i5 & Fields.SpotShadowColor;
        if (i12 != 0) {
        }
        if ((i5 & Fields.RotationX) != 0) {
        }
        if (!startRestartGroup.shouldExecute((38347923 & i6) != 38347922, i6 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0031, code lost:
    
        if (r30.changed(r21) != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Function2<SubcomposeMeasureScope, Constraints, MeasureResult> contextualRowMeasurementHelper(Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState, int i3, List<? extends Function2<? super Composer, ? super Integer, Unit>> list, Function4<? super Integer, ? super FlowLineInfo, ? super Composer, ? super Integer, Unit> function4, Composer composer, int i4) {
        boolean z;
        boolean changed;
        Object rememberedValue;
        ComposerKt.sourceInformationMarkerStart(composer, 962906403, "C(contextualRowMeasurementHelper)N(horizontalArrangement,verticalArrangement,itemVerticalAlignment,maxItemsInMainAxis,maxLines,overflowState,itemCount,overflowComposables,getComposable)385@16647L971:ContextualFlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(962906403, i4, -1, "androidx.compose.foundation.layout.contextualRowMeasurementHelper (ContextualFlowLayout.kt:384)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1935102030, "CC(remember):ContextualFlowLayout.kt#9igjgp");
        if (((i4 & 14) ^ 6) <= 4) {
        }
        if ((i4 & 6) != 4) {
            z = false;
            changed = z | ((((i4 & 112) ^ 48) <= 32 && composer.changed(vertical)) || (i4 & 48) == 32) | ((((i4 & 896) ^ 384) <= 256 && composer.changed(vertical2)) || (i4 & 384) == 256) | ((((i4 & 7168) ^ 3072) <= 2048 && composer.changed(i)) || (i4 & 3072) == 2048) | ((((57344 & i4) ^ 24576) <= 16384 && composer.changed(i2)) || (i4 & 24576) == 16384) | composer.changed(flowLayoutOverflowState) | ((((3670016 & i4) ^ 1572864) <= 1048576 && composer.changed(i3)) || (i4 & 1572864) == 1048576) | ((((234881024 & i4) ^ 100663296) > 67108864 && composer.changed(function4)) || (i4 & 100663296) == 67108864);
            rememberedValue = composer.rememberedValue();
            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new FlowMeasureLazyPolicy(true, horizontal, vertical, horizontal.getSpacing(), CrossAxisAlignment.INSTANCE.vertical$foundation_layout(vertical2), vertical.getSpacing(), i3, i2, i, flowLayoutOverflowState, list, function4, null).getMeasurePolicy();
                composer.updateRememberedValue(rememberedValue);
            }
            Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function2 = (Function2) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return function2;
        }
        z = true;
        if (((234881024 & i4) ^ 100663296) > 67108864) {
            changed = z | ((((i4 & 112) ^ 48) <= 32 && composer.changed(vertical)) || (i4 & 48) == 32) | ((((i4 & 896) ^ 384) <= 256 && composer.changed(vertical2)) || (i4 & 384) == 256) | ((((i4 & 7168) ^ 3072) <= 2048 && composer.changed(i)) || (i4 & 3072) == 2048) | ((((57344 & i4) ^ 24576) <= 16384 && composer.changed(i2)) || (i4 & 24576) == 16384) | composer.changed(flowLayoutOverflowState) | ((((3670016 & i4) ^ 1572864) <= 1048576 && composer.changed(i3)) || (i4 & 1572864) == 1048576) | ((((234881024 & i4) ^ 100663296) > 67108864 && composer.changed(function4)) || (i4 & 100663296) == 67108864);
            rememberedValue = composer.rememberedValue();
            if (!changed) {
            }
            rememberedValue = new FlowMeasureLazyPolicy(true, horizontal, vertical, horizontal.getSpacing(), CrossAxisAlignment.INSTANCE.vertical$foundation_layout(vertical2), vertical.getSpacing(), i3, i2, i, flowLayoutOverflowState, list, function4, null).getMeasurePolicy();
            composer.updateRememberedValue(rememberedValue);
            Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function22 = (Function2) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return function22;
        }
        changed = z | ((((i4 & 112) ^ 48) <= 32 && composer.changed(vertical)) || (i4 & 48) == 32) | ((((i4 & 896) ^ 384) <= 256 && composer.changed(vertical2)) || (i4 & 384) == 256) | ((((i4 & 7168) ^ 3072) <= 2048 && composer.changed(i)) || (i4 & 3072) == 2048) | ((((57344 & i4) ^ 24576) <= 16384 && composer.changed(i2)) || (i4 & 24576) == 16384) | composer.changed(flowLayoutOverflowState) | ((((3670016 & i4) ^ 1572864) <= 1048576 && composer.changed(i3)) || (i4 & 1572864) == 1048576) | ((((234881024 & i4) ^ 100663296) > 67108864 && composer.changed(function4)) || (i4 & 100663296) == 67108864);
        rememberedValue = composer.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new FlowMeasureLazyPolicy(true, horizontal, vertical, horizontal.getSpacing(), CrossAxisAlignment.INSTANCE.vertical$foundation_layout(vertical2), vertical.getSpacing(), i3, i2, i, flowLayoutOverflowState, list, function4, null).getMeasurePolicy();
        composer.updateRememberedValue(rememberedValue);
        Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function222 = (Function2) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return function222;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0031, code lost:
    
        if (r30.changed(r21) != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Function2<SubcomposeMeasureScope, Constraints, MeasureResult> contextualColumnMeasureHelper(Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState, int i3, List<? extends Function2<? super Composer, ? super Integer, Unit>> list, Function4<? super Integer, ? super FlowLineInfo, ? super Composer, ? super Integer, Unit> function4, Composer composer, int i4) {
        boolean z;
        boolean changed;
        Object rememberedValue;
        ComposerKt.sourceInformationMarkerStart(composer, -676633639, "C(contextualColumnMeasureHelper)N(verticalArrangement,horizontalArrangement,itemHorizontalAlignment,maxItemsInMainAxis,maxLines,overflowState,itemCount,overflowComposables,getComposable)425@18138L978:ContextualFlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-676633639, i4, -1, "androidx.compose.foundation.layout.contextualColumnMeasureHelper (ContextualFlowLayout.kt:424)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1704847893, "CC(remember):ContextualFlowLayout.kt#9igjgp");
        if (((i4 & 14) ^ 6) <= 4) {
        }
        if ((i4 & 6) != 4) {
            z = false;
            changed = z | ((((i4 & 112) ^ 48) <= 32 && composer.changed(horizontal)) || (i4 & 48) == 32) | ((((i4 & 896) ^ 384) <= 256 && composer.changed(horizontal2)) || (i4 & 384) == 256) | ((((i4 & 7168) ^ 3072) <= 2048 && composer.changed(i)) || (i4 & 3072) == 2048) | ((((57344 & i4) ^ 24576) <= 16384 && composer.changed(i2)) || (i4 & 24576) == 16384) | composer.changed(flowLayoutOverflowState) | ((((3670016 & i4) ^ 1572864) <= 1048576 && composer.changed(i3)) || (i4 & 1572864) == 1048576) | ((((234881024 & i4) ^ 100663296) > 67108864 && composer.changed(function4)) || (i4 & 100663296) == 67108864);
            rememberedValue = composer.rememberedValue();
            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new FlowMeasureLazyPolicy(false, horizontal, vertical, vertical.getSpacing(), CrossAxisAlignment.INSTANCE.horizontal$foundation_layout(horizontal2), horizontal.getSpacing(), i3, i2, i, flowLayoutOverflowState, list, function4, null).getMeasurePolicy();
                composer.updateRememberedValue(rememberedValue);
            }
            Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function2 = (Function2) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return function2;
        }
        z = true;
        if (((234881024 & i4) ^ 100663296) > 67108864) {
            changed = z | ((((i4 & 112) ^ 48) <= 32 && composer.changed(horizontal)) || (i4 & 48) == 32) | ((((i4 & 896) ^ 384) <= 256 && composer.changed(horizontal2)) || (i4 & 384) == 256) | ((((i4 & 7168) ^ 3072) <= 2048 && composer.changed(i)) || (i4 & 3072) == 2048) | ((((57344 & i4) ^ 24576) <= 16384 && composer.changed(i2)) || (i4 & 24576) == 16384) | composer.changed(flowLayoutOverflowState) | ((((3670016 & i4) ^ 1572864) <= 1048576 && composer.changed(i3)) || (i4 & 1572864) == 1048576) | ((((234881024 & i4) ^ 100663296) > 67108864 && composer.changed(function4)) || (i4 & 100663296) == 67108864);
            rememberedValue = composer.rememberedValue();
            if (!changed) {
            }
            rememberedValue = new FlowMeasureLazyPolicy(false, horizontal, vertical, vertical.getSpacing(), CrossAxisAlignment.INSTANCE.horizontal$foundation_layout(horizontal2), horizontal.getSpacing(), i3, i2, i, flowLayoutOverflowState, list, function4, null).getMeasurePolicy();
            composer.updateRememberedValue(rememberedValue);
            Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function22 = (Function2) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return function22;
        }
        changed = z | ((((i4 & 112) ^ 48) <= 32 && composer.changed(horizontal)) || (i4 & 48) == 32) | ((((i4 & 896) ^ 384) <= 256 && composer.changed(horizontal2)) || (i4 & 384) == 256) | ((((i4 & 7168) ^ 3072) <= 2048 && composer.changed(i)) || (i4 & 3072) == 2048) | ((((57344 & i4) ^ 24576) <= 16384 && composer.changed(i2)) || (i4 & 24576) == 16384) | composer.changed(flowLayoutOverflowState) | ((((3670016 & i4) ^ 1572864) <= 1048576 && composer.changed(i3)) || (i4 & 1572864) == 1048576) | ((((234881024 & i4) ^ 100663296) > 67108864 && composer.changed(function4)) || (i4 & 100663296) == 67108864);
        rememberedValue = composer.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new FlowMeasureLazyPolicy(false, horizontal, vertical, vertical.getSpacing(), CrossAxisAlignment.INSTANCE.horizontal$foundation_layout(horizontal2), horizontal.getSpacing(), i3, i2, i, flowLayoutOverflowState, list, function4, null).getMeasurePolicy();
        composer.updateRememberedValue(rememberedValue);
        Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function222 = (Function2) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return function222;
    }
}
