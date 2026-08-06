package androidx.compose.foundation.text;

import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.input.pointer.PointerInputEventHandler;
import androidx.compose.p002ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextOverflow;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: ClickableText.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001as\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"ClickableText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "onClick", "ClickableText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ClickableTextKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClickableText_4YKlhWE$lambda$6(AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, boolean z, int i, int i2, Function1 function1, Function1 function12, int i3, int i4, Composer composer, int i5) {
        m1522ClickableText4YKlhWE(annotatedString, modifier, textStyle, z, i, i2, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClickableText_4YKlhWE$lambda$1$lambda$0(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00cc  */
    @Deprecated(message = "Use Text or BasicText and pass an AnnotatedString that contains a LinkAnnotation. Check LinkAnnotation's documentation for more details and samples.")
    /* renamed from: ClickableText-4YKlhWE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1522ClickableText4YKlhWE(final AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, boolean z, int i, int i2, Function1<? super TextLayoutResult, Unit> function1, final Function1<? super Integer, Unit> function12, Composer composer, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        TextStyle textStyle2;
        int i7;
        boolean z2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        final Function1<? super TextLayoutResult, Unit> function13;
        final Modifier modifier3;
        final boolean z3;
        final int i13;
        final int i14;
        final TextStyle textStyle3;
        ScopeUpdateScope endRestartGroup;
        final Function1<? super TextLayoutResult, Unit> function14;
        Composer startRestartGroup = composer.startRestartGroup(-246609449);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClickableText)N(text,modifier,style,softWrap,overflow:c#ui.text.style.TextOverflow,maxLines,onTextLayout,onClick)77@3766L2,80@3825L52,82@3942L208,97@4371L76,90@4156L298:ClickableText.kt#423gt5");
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (startRestartGroup.changed(annotatedString) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i15 = i4 & 2;
        if (i15 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            modifier2 = modifier;
            i5 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i3 & 384) == 0) {
                textStyle2 = textStyle;
                i5 |= startRestartGroup.changed(textStyle2) ? Fields.RotationX : Fields.SpotShadowColor;
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i3 & 3072) == 0) {
                    z2 = z;
                    i5 |= startRestartGroup.changed(z2) ? Fields.CameraDistance : Fields.RotationZ;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i3 & 24576) == 0) {
                        i9 = i;
                        i5 |= startRestartGroup.changed(i9) ? Fields.Clip : Fields.Shape;
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= 196608;
                            i11 = i2;
                        } else {
                            i11 = i2;
                            if ((i3 & 196608) == 0) {
                                i5 |= startRestartGroup.changed(i11) ? Fields.RenderEffect : 65536;
                            }
                        }
                        i12 = i4 & 64;
                        if (i12 != 0) {
                            i5 |= 1572864;
                        } else if ((i3 & 1572864) == 0) {
                            i5 |= startRestartGroup.changedInstance(function1) ? 1048576 : Fields.BlendMode;
                        }
                        if ((i4 & Fields.SpotShadowColor) != 0) {
                            i5 |= 12582912;
                        } else if ((i3 & 12582912) == 0) {
                            i5 |= startRestartGroup.changedInstance(function12) ? 8388608 : 4194304;
                        }
                        if (!startRestartGroup.shouldExecute((4793491 & i5) != 4793490, i5 & 1)) {
                            startRestartGroup.skipToGroupEnd();
                            function13 = function1;
                            modifier3 = modifier2;
                            z3 = z2;
                            i13 = i9;
                            i14 = i11;
                            textStyle3 = textStyle2;
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            TextStyle textStyle4 = i6 != 0 ? TextStyle.Companion.getDefault() : textStyle2;
                            boolean z4 = i7 != 0 ? true : z2;
                            i13 = i8 != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : i9;
                            if (i10 != 0) {
                                i11 = Integer.MAX_VALUE;
                            }
                            if (i12 != 0) {
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -768463911, "CC(remember):ClickableText.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj) {
                                            Unit ClickableText_4YKlhWE$lambda$1$lambda$0;
                                            ClickableText_4YKlhWE$lambda$1$lambda$0 = ClickableTextKt.ClickableText_4YKlhWE$lambda$1$lambda$0((TextLayoutResult) obj);
                                            return ClickableText_4YKlhWE$lambda$1$lambda$0;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                function14 = (Function1) rememberedValue;
                            } else {
                                function14 = function1;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:79)");
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -768461973, "CC(remember):ClickableText.kt#9igjgp");
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            final MutableState mutableState = (MutableState) rememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Modifier.Companion companion = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -768458073, "CC(remember):ClickableText.kt#9igjgp");
                            boolean z5 = (29360128 & i5) == 8388608;
                            ClickableTextKt$ClickableText$pressIndicator$1$1 rememberedValue3 = startRestartGroup.rememberedValue();
                            if (z5 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function12);
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Modifier then = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion, function12, (PointerInputEventHandler) rememberedValue3));
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -768444477, "CC(remember):ClickableText.kt#9igjgp");
                            boolean z6 = (i5 & 3670016) == 1048576;
                            Object rememberedValue4 = startRestartGroup.rememberedValue();
                            if (z6 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                                    public final Object invoke(Object obj) {
                                        Unit ClickableText_4YKlhWE$lambda$5$lambda$4;
                                        ClickableText_4YKlhWE$lambda$5$lambda$4 = ClickableTextKt.ClickableText_4YKlhWE$lambda$5$lambda$4(MutableState.this, function14, (TextLayoutResult) obj);
                                        return ClickableText_4YKlhWE$lambda$5$lambda$4;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i16 = (i5 & 14) | (i5 & 896) | (57344 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016);
                            Function1<? super TextLayoutResult, Unit> function15 = function14;
                            BasicTextKt.m1514BasicTextCL7eQgs(annotatedString, then, textStyle4, (Function1) rememberedValue4, i13, z4, i11, 0, null, null, null, startRestartGroup, i16, 0, 1920);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function13 = function15;
                            z3 = z4;
                            modifier3 = modifier2;
                            i14 = i11;
                            textStyle3 = textStyle4;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit ClickableText_4YKlhWE$lambda$6;
                                    ClickableText_4YKlhWE$lambda$6 = ClickableTextKt.ClickableText_4YKlhWE$lambda$6(annotatedString, modifier3, textStyle3, z3, i13, i14, function13, function12, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                    return ClickableText_4YKlhWE$lambda$6;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    i12 = i4 & 64;
                    if (i12 != 0) {
                    }
                    if ((i4 & Fields.SpotShadowColor) != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((4793491 & i5) != 4793490, i5 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z2 = z;
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 != 0) {
                }
                i12 = i4 & 64;
                if (i12 != 0) {
                }
                if ((i4 & Fields.SpotShadowColor) != 0) {
                }
                if (!startRestartGroup.shouldExecute((4793491 & i5) != 4793490, i5 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            textStyle2 = textStyle;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            z2 = z;
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i;
            i10 = i4 & 32;
            if (i10 != 0) {
            }
            i12 = i4 & 64;
            if (i12 != 0) {
            }
            if ((i4 & Fields.SpotShadowColor) != 0) {
            }
            if (!startRestartGroup.shouldExecute((4793491 & i5) != 4793490, i5 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        textStyle2 = textStyle;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        z2 = z;
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i;
        i10 = i4 & 32;
        if (i10 != 0) {
        }
        i12 = i4 & 64;
        if (i12 != 0) {
        }
        if ((i4 & Fields.SpotShadowColor) != 0) {
        }
        if (!startRestartGroup.shouldExecute((4793491 & i5) != 4793490, i5 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClickableText_4YKlhWE$lambda$5$lambda$4(MutableState mutableState, Function1 function1, TextLayoutResult textLayoutResult) {
        mutableState.setValue(textLayoutResult);
        function1.invoke(textLayoutResult);
        return Unit.INSTANCE;
    }
}
