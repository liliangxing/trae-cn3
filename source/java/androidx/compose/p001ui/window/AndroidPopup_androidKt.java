package androidx.compose.p001ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntRect;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidPopup.android.kt */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aR\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001aD\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0010\u001a \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0002\u001a(\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u001b2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000bH\u0001¢\u0006\u0002\u0010 \u001a+\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0013\b\b\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000bH\u0083\b¢\u0006\u0002\u0010$\u001a\f\u0010%\u001a\u00020\u0015*\u00020&H\u0000\u001a\u0014\u0010'\u001a\u00020\u0012*\u00020\t2\u0006\u0010(\u001a\u00020\u0015H\u0002\u001a\f\u0010)\u001a\u00020**\u00020+H\u0002\u001a\u001c\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020&2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u001bH\u0007\"\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006/²\u0006\u0015\u00100\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000bX\u008a\u0084\u0002"}, d2 = {"Popup", "", "alignment", "Landroidx/compose/ui/Alignment;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "onDismissRequest", "Lkotlin/Function0;", "properties", "Landroidx/compose/ui/window/PopupProperties;", StrategyConstants.CONTENT, "Landroidx/compose/runtime/Composable;", "Popup-K5zGePQ", "(Landroidx/compose/ui/Alignment;JLkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PopupPropertiesBaseFlags", "", "createFlags", "focusable", "", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "clippingEnabled", "LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "PopupTestTag", "tag", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "isFlagSecureEnabled", "Landroid/view/View;", "flagsWithSecureFlagInherited", "isParentFlagSecureEnabled", "toIntBounds", "Landroidx/compose/ui/unit/IntRect;", "Landroid/graphics/Rect;", "isPopupLayout", "view", "testTag", "ui_release", "currentContent"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AndroidPopup_androidKt {
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, new Function0<String>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$LocalPopupTestTag$1
        public final String invoke() {
            return "DEFAULT_TEST_TAG";
        }
    }, 1, (Object) null);
    private static final int PopupPropertiesBaseFlags = 262144;

    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0051  */
    /* renamed from: Popup-K5zGePQ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2947PopupK5zGePQ(Alignment alignment, long j, Function0<Unit> function0, PopupProperties popupProperties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Alignment alignment2;
        int i3;
        long j2;
        int i4;
        Function0<Unit> function02;
        int i5;
        PopupProperties popupProperties2;
        final long j3;
        final PopupProperties popupProperties3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(71005054);
        ComposerKt.sourceInformation(startRestartGroup, "C(Popup)P(!1,2:c#ui.unit.IntOffset,3,4)270@12403L82,272@12491L166:AndroidPopup.android.kt#2oxthz");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            alignment2 = alignment;
        } else if ((i & 6) == 0) {
            alignment2 = alignment;
            i3 = (startRestartGroup.changed(alignment2) ? 4 : 2) | i;
        } else {
            alignment2 = alignment;
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            j2 = j;
            i3 |= startRestartGroup.changed(j2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                function02 = function0;
                i3 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    popupProperties2 = popupProperties;
                    i3 |= startRestartGroup.changed(popupProperties2) ? 2048 : 1024;
                    if ((i2 & 16) == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        i3 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
                        if (startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                            Alignment topStart = i6 != 0 ? Alignment.Companion.getTopStart() : alignment2;
                            if (i7 != 0) {
                                long j4 = 0;
                                j3 = IntOffset.m2802constructorimpl((j4 & 4294967295L) | (j4 << 32));
                            } else {
                                j3 = j2;
                            }
                            Function0<Unit> function03 = i4 != 0 ? null : function02;
                            PopupProperties popupProperties4 = i5 != 0 ? new PopupProperties(false, false, false, false, 15, (DefaultConstructorMarker) null) : popupProperties2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(71005054, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:268)");
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483612592, "CC(remember):AndroidPopup.android.kt#9igjgp");
                            boolean z = ((i3 & 112) == 32) | ((i3 & 14) == 4);
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new AlignmentOffsetPositionProvider(topStart, j3, null);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i8 = i3 >> 3;
                            Popup((AlignmentOffsetPositionProvider) rememberedValue, function03, popupProperties4, function2, startRestartGroup, (i8 & 112) | (i8 & 896) | (i8 & 7168), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            alignment2 = topStart;
                            function02 = function03;
                            popupProperties3 = popupProperties4;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            j3 = j2;
                            popupProperties3 = popupProperties2;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Alignment alignment3 = alignment2;
                            final Function0<Unit> function04 = function02;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i9) {
                                    AndroidPopup_androidKt.m2947PopupK5zGePQ(alignment3, j3, function04, popupProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                popupProperties2 = popupProperties;
                if ((i2 & 16) == 0) {
                }
                if (startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function02 = function0;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            popupProperties2 = popupProperties;
            if ((i2 & 16) == 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        j2 = j;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function02 = function0;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        popupProperties2 = popupProperties;
        if ((i2 & 16) == 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Popup(final PopupPositionProvider popupPositionProvider, Function0<Unit> function0, PopupProperties popupProperties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function02;
        int i4;
        PopupProperties popupProperties2;
        int i5;
        final Function0<Unit> function03;
        final PopupProperties popupProperties3;
        ScopeUpdateScope endRestartGroup;
        LayoutDirection layoutDirection;
        String str;
        int i6;
        int i7;
        boolean z;
        Composer startRestartGroup = composer.startRestartGroup(-1772091631);
        ComposerKt.sourceInformation(startRestartGroup, "C(Popup)P(2,1,3)298@13359L7,299@13398L7,300@13442L7,301@13497L7,302@13533L28,303@13588L29,304@13653L21,304@13636L38,305@13697L1001,332@14734L388,332@14704L418,347@15139L219,347@15128L230,356@15404L126,356@15364L166,368@16121L147,368@16093L175,381@16537L573,389@17118L99,378@16446L771:AndroidPopup.android.kt#2oxthz");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(popupPositionProvider) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            function02 = function0;
            i3 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                popupProperties2 = popupProperties;
                i3 |= startRestartGroup.changed(popupProperties2) ? 256 : 128;
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    i3 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
                }
                i5 = i3;
                if (startRestartGroup.shouldExecute((i5 & 1171) != 1170, i5 & 1)) {
                    Function0<Unit> function04 = i8 != 0 ? null : function02;
                    PopupProperties popupProperties4 = i4 != 0 ? new PopupProperties(false, false, false, false, 15, (DefaultConstructorMarker) null) : popupProperties2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1772091631, i5, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:297)");
                    }
                    CompositionLocal localView = AndroidCompositionLocals_androidKt.getLocalView();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume = startRestartGroup.consume(localView);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    View view = (View) consume;
                    CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume2 = startRestartGroup.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Density density = (Density) consume2;
                    CompositionLocal compositionLocal = LocalPopupTestTag;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume3 = startRestartGroup.consume(compositionLocal);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    String str2 = (String) consume3;
                    CompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume4 = startRestartGroup.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    LayoutDirection layoutDirection2 = (LayoutDirection) consume4;
                    CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext(startRestartGroup, 0);
                    final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, startRestartGroup, (i5 >> 9) & 14);
                    Object[] objArr = new Object[0];
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2121975462, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    AndroidPopup_androidKt$Popup$popupId$1$1 rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Function0<UUID>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupId$1$1
                            public final UUID invoke() {
                                return UUID.randomUUID();
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    UUID uuid = (UUID) RememberSaveableKt.rememberSaveable(objArr, (Function0) rememberedValue, startRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2121977850, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        layoutDirection = layoutDirection2;
                        str = str2;
                        i6 = i5;
                        i7 = 32;
                        final PopupLayout popupLayout = new PopupLayout(function04, popupProperties4, str2, view, density, popupPositionProvider, uuid, null, 128, null);
                        z = true;
                        popupLayout.setContent(rememberCompositionContext, (Function2) ComposableLambdaKt.composableLambdaInstance(-297523940, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i9) {
                                Function2 Popup$lambda$1;
                                ComposerKt.sourceInformation(composer2, "C318@14188L16,320@14307L134,317@14132L528:AndroidPopup.android.kt#2oxthz");
                                if (!composer2.shouldExecute((i9 & 3) != 2, i9 & 1)) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-297523940, i9, -1, "androidx.compose.ui.window.Popup.<anonymous>.<anonymous>.<anonymous> (AndroidPopup.android.kt:317)");
                                }
                                Modifier modifier = Modifier.Companion;
                                ComposerKt.sourceInformationMarkerStart(composer2, 1842305004, "CC(remember):AndroidPopup.android.kt#9igjgp");
                                AndroidPopup_androidKt$Popup$popupLayout$1$1$1$1$1 rememberedValue3 = composer2.rememberedValue();
                                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                    rememberedValue3 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1$1$1
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((SemanticsPropertyReceiver) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            SemanticsPropertiesKt.popup(semanticsPropertyReceiver);
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier, false, (Function1) rememberedValue3, 1, null);
                                ComposerKt.sourceInformationMarkerStart(composer2, 1842308930, "CC(remember):AndroidPopup.android.kt#9igjgp");
                                boolean changedInstance = composer2.changedInstance(PopupLayout.this);
                                final PopupLayout popupLayout2 = PopupLayout.this;
                                Object rememberedValue4 = composer2.rememberedValue();
                                if (changedInstance || rememberedValue4 == Composer.Companion.getEmpty()) {
                                    rememberedValue4 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1$2$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            m2952invokeozmzZPI(((IntSize) obj).m2855unboximpl());
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                        public final void m2952invokeozmzZPI(long j) {
                                            PopupLayout.this.m2956setPopupContentSizefhxjrPA(IntSize.m2843boximpl(j));
                                            PopupLayout.this.updatePosition();
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue4);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                Modifier alpha = AlphaKt.alpha(OnRemeasuredModifierKt.onSizeChanged(semantics$default, (Function1) rememberedValue4), PopupLayout.this.getCanCalculatePosition() ? 1.0f : 0.0f);
                                Popup$lambda$1 = AndroidPopup_androidKt.Popup$lambda$1(rememberUpdatedState);
                                ComposerKt.sourceInformationMarkerStart(composer2, 26279861, "CC(SimpleStack)P(1)431@18599L899,431@18552L946:AndroidPopup.android.kt#2oxthz");
                                ComposerKt.sourceInformationMarkerStart(composer2, -514850408, "CC(remember):AndroidPopup.android.kt#9igjgp");
                                AndroidPopup_androidKt$SimpleStack$1$1 rememberedValue5 = composer2.rememberedValue();
                                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                                    rememberedValue5 = AndroidPopup_androidKt$SimpleStack$1$1.INSTANCE;
                                    composer2.updateRememberedValue(rememberedValue5);
                                }
                                MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue5;
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, alpha);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor);
                                } else {
                                    composer2.useNode();
                                }
                                Composer composer3 = Updater.constructor-impl(composer2);
                                Updater.set-impl(composer3, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode))) {
                                    composer3.updateRememberedValue(Integer.valueOf(hashCode));
                                    composer3.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                                }
                                Updater.set-impl(composer3, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                Popup$lambda$1.invoke(composer2, 0);
                                composer2.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        startRestartGroup.updateRememberedValue(popupLayout);
                        rememberedValue2 = popupLayout;
                    } else {
                        layoutDirection = layoutDirection2;
                        str = str2;
                        i6 = i5;
                        i7 = 32;
                        z = true;
                    }
                    final PopupLayout popupLayout2 = (PopupLayout) rememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2122010421, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    int i9 = i6;
                    int i10 = i9 & 112;
                    int i11 = i9 & 896;
                    final String str3 = str;
                    final LayoutDirection layoutDirection3 = layoutDirection;
                    LayoutDirection layoutDirection4 = layoutDirection3;
                    boolean changedInstance = startRestartGroup.changedInstance(popupLayout2) | (i10 == i7 ? z : false) | (i11 == 256 ? z : false) | startRestartGroup.changed(str3) | startRestartGroup.changed(layoutDirection4.ordinal());
                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                    if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
                        final Function0<Unit> function05 = function04;
                        final PopupProperties popupProperties5 = popupProperties4;
                        rememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                PopupLayout.this.show();
                                PopupLayout.this.updateParameters(function05, popupProperties5, str3, layoutDirection3);
                                final PopupLayout popupLayout3 = PopupLayout.this;
                                return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1
                                    public void dispose() {
                                        PopupLayout.this.disposeComposition();
                                        PopupLayout.this.dismiss();
                                    }
                                };
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    EffectsKt.DisposableEffect(popupLayout2, (Function1) rememberedValue3, startRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2122023212, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    boolean changedInstance2 = (i10 == i7 ? z : false) | startRestartGroup.changedInstance(popupLayout2) | (i11 == 256 ? z : false) | startRestartGroup.changed(str3) | startRestartGroup.changed(layoutDirection4.ordinal());
                    Object rememberedValue4 = startRestartGroup.rememberedValue();
                    if (changedInstance2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                        final Function0<Unit> function06 = function04;
                        final PopupProperties popupProperties6 = popupProperties4;
                        rememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2949invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: collision with other method in class */
                            public final void m2949invoke() {
                                PopupLayout.this.updateParameters(function06, popupProperties6, str3, layoutDirection3);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    EffectsKt.SideEffect((Function0) rememberedValue4, startRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2122031599, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    int i12 = i9 & 14;
                    boolean changedInstance3 = startRestartGroup.changedInstance(popupLayout2) | (i12 == 4 ? z : false);
                    Object rememberedValue5 = startRestartGroup.rememberedValue();
                    if (changedInstance3 || rememberedValue5 == Composer.Companion.getEmpty()) {
                        rememberedValue5 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                PopupLayout.this.setPositionProvider(popupPositionProvider);
                                PopupLayout.this.updatePosition();
                                return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1$invoke$$inlined$onDispose$1
                                    public void dispose() {
                                    }
                                };
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    EffectsKt.DisposableEffect(popupPositionProvider, (Function1) rememberedValue5, startRestartGroup, i12);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2122054564, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    boolean changedInstance4 = startRestartGroup.changedInstance(popupLayout2);
                    AndroidPopup_androidKt$Popup$5$1 rememberedValue6 = startRestartGroup.rememberedValue();
                    if (changedInstance4 || rememberedValue6 == Composer.Companion.getEmpty()) {
                        rememberedValue6 = new AndroidPopup_androidKt$Popup$5$1(popupLayout2, null);
                        startRestartGroup.updateRememberedValue(rememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    EffectsKt.LaunchedEffect(popupLayout2, (Function2) rememberedValue6, startRestartGroup, 0);
                    Modifier modifier = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2122068302, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    boolean changedInstance5 = startRestartGroup.changedInstance(popupLayout2);
                    Object rememberedValue7 = startRestartGroup.rememberedValue();
                    if (changedInstance5 || rememberedValue7 == Composer.Companion.getEmpty()) {
                        rememberedValue7 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((LayoutCoordinates) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(LayoutCoordinates layoutCoordinates) {
                                LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
                                Intrinsics.checkNotNull(parentLayoutCoordinates);
                                PopupLayout.this.updateParentLayoutCoordinates(parentLayoutCoordinates);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier, (Function1) rememberedValue7);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2122086420, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    boolean changedInstance6 = startRestartGroup.changedInstance(popupLayout2) | startRestartGroup.changed(layoutDirection4.ordinal());
                    MeasurePolicy rememberedValue8 = startRestartGroup.rememberedValue();
                    if (changedInstance6 || rememberedValue8 == Composer.Companion.getEmpty()) {
                        rememberedValue8 = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1
                            /* renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m2950measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                PopupLayout.this.setParentLayoutDirection(layoutDirection3);
                                return MeasureScope.layout$default(measureScope, 0, 0, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1.1
                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue8);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue8;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    Composer composer2 = Updater.constructor-impl(startRestartGroup);
                    Updater.set-impl(composer2, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
                        composer2.updateRememberedValue(Integer.valueOf(hashCode));
                        composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer2, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -958253783, "C:AndroidPopup.android.kt#2oxthz");
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function03 = function04;
                    popupProperties3 = popupProperties4;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    function03 = function02;
                    popupProperties3 = popupProperties2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$9
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            AndroidPopup_androidKt.Popup(PopupPositionProvider.this, function03, popupProperties3, function2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            popupProperties2 = popupProperties;
            if ((i2 & 8) != 0) {
            }
            i5 = i3;
            if (startRestartGroup.shouldExecute((i5 & 1171) != 1170, i5 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function02 = function0;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        popupProperties2 = popupProperties;
        if ((i2 & 8) != 0) {
        }
        i5 = i3;
        if (startRestartGroup.shouldExecute((i5 & 1171) != 1170, i5 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final int createFlags(boolean z, SecureFlagPolicy secureFlagPolicy, boolean z2) {
        int i = !z ? 262152 : 262144;
        if (secureFlagPolicy == SecureFlagPolicy.SecureOn) {
            i |= 8192;
        }
        return !z2 ? i | 512 : i;
    }

    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return LocalPopupTestTag;
    }

    public static final void PopupTestTag(final String str, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1357513789);
        ComposerKt.sourceInformation(startRestartGroup, "C(PopupTestTag)P(1)423@18214L75:AndroidPopup.android.kt#2oxthz");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1357513789, i2, -1, "androidx.compose.ui.window.PopupTestTag (AndroidPopup.android.kt:422)");
            }
            CompositionLocalKt.CompositionLocalProvider(LocalPopupTestTag.provides(str), function2, startRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$PopupTestTag$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    AndroidPopup_androidKt.PopupTestTag(str, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final void SimpleStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 26279861, "CC(SimpleStack)P(1)431@18599L899,431@18552L946:AndroidPopup.android.kt#2oxthz");
        ComposerKt.sourceInformationMarkerStart(composer, -514850408, "CC(remember):AndroidPopup.android.kt#9igjgp");
        AndroidPopup_androidKt$SimpleStack$1$1 rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = AndroidPopup_androidKt$SimpleStack$1$1.INSTANCE;
            composer.updateRememberedValue(rememberedValue);
        }
        MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i2 = ((i << 3) & 112) | ((i >> 3) & 14) | 384;
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
        int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        int i3 = ((i2 << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composer2 = Updater.constructor-impl(composer);
        Updater.set-impl(composer2, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
            composer2.updateRememberedValue(Integer.valueOf(hashCode));
            composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
        }
        Updater.set-impl(composer2, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        function2.invoke(composer, Integer.valueOf((i3 >> 6) & 14));
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public static final boolean isFlagSecureEnabled(View view) {
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        return (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) ? false : true;
    }

    public static final int flagsWithSecureFlagInherited(PopupProperties popupProperties, boolean z) {
        if (popupProperties.getInheritSecurePolicy() && z) {
            return popupProperties.getFlags() | 8192;
        }
        if (popupProperties.getInheritSecurePolicy() && !z) {
            return popupProperties.getFlags() & (-8193);
        }
        return popupProperties.getFlags();
    }

    public static final IntRect toIntBounds(Rect rect) {
        return new IntRect(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static /* synthetic */ boolean isPopupLayout$default(View view, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return isPopupLayout(view, str);
    }

    public static final boolean isPopupLayout(View view, String str) {
        return (view instanceof PopupLayout) && (str == null || Intrinsics.areEqual(str, ((PopupLayout) view).getTestTag()));
    }

    public static final Function2<Composer, Integer, Unit> Popup$lambda$1(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}
