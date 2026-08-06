package androidx.compose.foundation.contextmenu;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import androidx.autofill.HintConstants;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.ComposedModifierKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.draw.ShadowKt;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.ColorKt;
import androidx.compose.p002ui.graphics.ColorProducer;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContextMenuUi.android.kt */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aF\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\rH\u0001¢\u0006\u0002\u0010\u000e\u001aN\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\rH\u0001¢\u0006\u0002\u0010\u0011\u001a:\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\rH\u0001¢\u0006\u0002\u0010\u0013\u001a=\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\t2\u001c\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\u0017¢\u0006\u0002\b\rH\u0001¢\u0006\u0002\u0010\u0018\u001ai\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\t2*\b\u0002\u0010\u001e\u001a$\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\u0002\b\u00172\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0001¢\u0006\u0002\u0010$\u001a!\u0010,\u001a\u00020\u00102\b\b\u0003\u0010-\u001a\u00020.2\b\b\u0003\u0010/\u001a\u00020.H\u0001¢\u0006\u0002\u00100\u001a/\u00101\u001a\u00020\u001f*\u0002022\b\b\u0001\u00103\u001a\u00020.2\b\b\u0001\u00104\u001a\u00020.2\u0006\u00105\u001a\u00020\u001fH\u0002¢\u0006\u0004\b6\u00107\u001a\"\u00108\u001a\u0004\u0018\u000109*\u0002022\b\b\u0001\u00103\u001a\u00020.2\b\b\u0001\u00104\u001a\u00020.H\u0002\u001a\u001d\u0010:\u001a\u00020\u001f*\u0004\u0018\u0001092\u0006\u00105\u001a\u00020\u001fH\u0002¢\u0006\u0004\b;\u0010<\u001a\u001d\u0010=\u001a\u00020\u001f*\u0004\u0018\u0001092\u0006\u00105\u001a\u00020\u001fH\u0002¢\u0006\u0004\b>\u0010<\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020&X\u0082T¢\u0006\u0002\n\u0000\"\u001c\u0010'\u001a\u00020\u00108\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006?"}, d2 = {"DefaultPopupProperties", "Landroidx/compose/ui/window/PopupProperties;", "ContextMenuPopup", "", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "onDismiss", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "contextMenuBuilderBlock", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "colors", "Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/contextmenu/ContextMenuColors;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ContextMenuColumnBuilder", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/contextmenu/ContextMenuColors;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ContextMenuColumn", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ContextMenuItem", "label", "", "enabled", "", "leadingIcon", "Landroidx/compose/ui/graphics/Color;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "iconColor", "onClick", "(Ljava/lang/String;ZLandroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "DisabledAlpha", "", "DefaultContextMenuColors", "getDefaultContextMenuColors$annotations", "()V", "getDefaultContextMenuColors", "()Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "computeContextMenuColors", "backgroundStyleId", "", "foregroundStyleId", "(IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "resolveColor", "Landroid/content/Context;", "resId", "attrId", "defaultColor", "resolveColor-g2O1Hgs", "(Landroid/content/Context;IIJ)J", "resolveColorStateList", "Landroid/content/res/ColorStateList;", "enabledColor", "enabledColor-4WTKRHQ", "(Landroid/content/res/ColorStateList;J)J", "disabledColor", "disabledColor-4WTKRHQ", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ContextMenuUi_androidKt {
    private static final float DisabledAlpha = 0.38f;
    private static final PopupProperties DefaultPopupProperties = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
    private static final ContextMenuColors DefaultContextMenuColors = new ContextMenuColors(Color.INSTANCE.m4876getWhite0d7_KjU(), Color.INSTANCE.m4865getBlack0d7_KjU(), Color.INSTANCE.m4865getBlack0d7_KjU(), Color.m4838copywmQWz5c$default(Color.INSTANCE.m4865getBlack0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m4838copywmQWz5c$default(Color.INSTANCE.m4865getBlack0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContextMenuColumn$lambda$3(ContextMenuColors contextMenuColors, Modifier modifier, Function3 function3, int i, int i2, Composer composer, int i3) {
        ContextMenuColumn(contextMenuColors, modifier, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContextMenuColumnBuilder$lambda$2(Modifier modifier, ContextMenuColors contextMenuColors, Function1 function1, int i, int i2, Composer composer, int i3) {
        ContextMenuColumnBuilder(modifier, contextMenuColors, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContextMenuItem$lambda$9(String str, boolean z, ContextMenuColors contextMenuColors, Modifier modifier, Function3 function3, Function0 function0, int i, int i2, Composer composer, int i3) {
        ContextMenuItem(str, z, contextMenuColors, modifier, function3, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContextMenuPopup$lambda$0(PopupPositionProvider popupPositionProvider, Function0 function0, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        ContextMenuPopup(popupPositionProvider, function0, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContextMenuPopup$lambda$1(PopupPositionProvider popupPositionProvider, Function0 function0, Modifier modifier, ContextMenuColors contextMenuColors, Function1 function1, int i, int i2, Composer composer, int i3) {
        ContextMenuPopup(popupPositionProvider, function0, modifier, contextMenuColors, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getDefaultContextMenuColors$annotations() {
    }

    public static final void ContextMenuPopup(final PopupPositionProvider popupPositionProvider, final Function0<Unit> function0, Modifier modifier, final Function1<? super ContextMenuScope, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(712057293);
        ComposerKt.sourceInformation(startRestartGroup, "C(ContextMenuPopup)N(popupPositionProvider,onDismiss,modifier,contextMenuBuilderBlock)113@4360L26,109@4210L242:ContextMenuUi.android.kt#3xeu6s");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(popupPositionProvider) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(712057293, i3, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup (ContextMenuUi.android.kt:108)");
            }
            ContextMenuPopup(popupPositionProvider, function0, modifier, computeContextMenuColors(0, 0, startRestartGroup, 0, 3), function1, startRestartGroup, (i3 & 14) | (i3 & 112) | (i3 & 896) | ((i3 << 3) & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit ContextMenuPopup$lambda$0;
                    ContextMenuPopup$lambda$0 = ContextMenuUi_androidKt.ContextMenuPopup$lambda$0(popupPositionProvider, function0, modifier2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return ContextMenuPopup$lambda$0;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ContextMenuPopup(final PopupPositionProvider popupPositionProvider, final Function0<Unit> function0, Modifier modifier, final ContextMenuColors contextMenuColors, final Function1<? super ContextMenuScope, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1447189339);
        ComposerKt.sourceInformation(startRestartGroup, "C(ContextMenuPopup)N(popupPositionProvider,onDismiss,modifier,colors,contextMenuBuilderBlock)131@4878L83,127@4727L234:ContextMenuUi.android.kt#3xeu6s");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(popupPositionProvider) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? Fields.RotationX : Fields.SpotShadowColor;
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changed(contextMenuColors) ? Fields.CameraDistance : Fields.RotationZ;
            }
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                i3 |= startRestartGroup.changedInstance(function1) ? Fields.Clip : Fields.Shape;
            }
            if (startRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                final Modifier modifier4 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1447189339, i3, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup (ContextMenuUi.android.kt:126)");
                }
                AndroidPopup_androidKt.Popup(popupPositionProvider, function0, DefaultPopupProperties, ComposableLambdaKt.rememberComposableLambda(795909757, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuPopup$2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i5) {
                        ComposerKt.sourceInformation(composer2, "C132@4888L67:ContextMenuUi.android.kt#3xeu6s");
                        if (!composer2.shouldExecute((i5 & 3) != 2, i5 & 1)) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(795909757, i5, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup.<anonymous> (ContextMenuUi.android.kt:132)");
                        }
                        ContextMenuUi_androidKt.ContextMenuColumnBuilder(Modifier.this, contextMenuColors, function1, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, (i3 & 14) | 3456 | (i3 & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2) {
                        Unit ContextMenuPopup$lambda$1;
                        ContextMenuPopup$lambda$1 = ContextMenuUi_androidKt.ContextMenuPopup$lambda$1(popupPositionProvider, function0, modifier3, contextMenuColors, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        return ContextMenuPopup$lambda$1;
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final void ContextMenuColumnBuilder(Modifier modifier, final ContextMenuColors contextMenuColors, final Function1<? super ContextMenuScope, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1430784946);
        ComposerKt.sourceInformation(startRestartGroup, "C(ContextMenuColumnBuilder)N(modifier,colors,contextMenuBuilderBlock)142@5211L177,142@5175L213:ContextMenuUi.android.kt#3xeu6s");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(contextMenuColors) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (i5 != 0) {
                contextMenuColors = DefaultContextMenuColors;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1430784946, i3, -1, "androidx.compose.foundation.contextmenu.ContextMenuColumnBuilder (ContextMenuUi.android.kt:141)");
            }
            ContextMenuColumn(contextMenuColors, modifier, ComposableLambdaKt.rememberComposableLambda(860259975, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuColumnBuilder$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((ColumnScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope columnScope, Composer composer2, int i6) {
                    ComposerKt.sourceInformation(composer2, "C143@5233L31,*147@5357L15:ContextMenuUi.android.kt#3xeu6s");
                    if (!composer2.shouldExecute((i6 & 17) != 16, i6 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(860259975, i6, -1, "androidx.compose.foundation.contextmenu.ContextMenuColumnBuilder.<anonymous> (ContextMenuUi.android.kt:143)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer2, 2076115878, "CC(remember):ContextMenuUi.android.kt#9igjgp");
                    Object rememberedValue = composer2.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new ContextMenuScope();
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    ContextMenuScope contextMenuScope = (ContextMenuScope) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Function1<ContextMenuScope, Unit> function12 = function1;
                    ContextMenuColors contextMenuColors2 = contextMenuColors;
                    contextMenuScope.clear$foundation_release();
                    function12.invoke(contextMenuScope);
                    contextMenuScope.Content$foundation_release(contextMenuColors2, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, ((i3 >> 3) & 14) | 384 | ((i3 << 3) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        final ContextMenuColors contextMenuColors2 = contextMenuColors;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit ContextMenuColumnBuilder$lambda$2;
                    ContextMenuColumnBuilder$lambda$2 = ContextMenuUi_androidKt.ContextMenuColumnBuilder$lambda$2(Modifier.this, contextMenuColors2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return ContextMenuColumnBuilder$lambda$2;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ContextMenuColumn(final ContextMenuColors contextMenuColors, Modifier modifier, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Modifier.Companion companion;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(621449936);
        ComposerKt.sourceInformation(startRestartGroup, "C(ContextMenuColumn)N(colors,modifier,content)169@5994L21,159@5578L472:ContextMenuUi.android.kt#3xeu6s");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(contextMenuColors) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= startRestartGroup.changedInstance(function3) ? Fields.RotationX : Fields.SpotShadowColor;
            }
            if (startRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
                startRestartGroup.skipToGroupEnd();
                companion = modifier2;
            } else {
                companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(621449936, i3, -1, "androidx.compose.foundation.contextmenu.ContextMenuColumn (ContextMenuUi.android.kt:158)");
                }
                Modifier verticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m1066paddingVpY3zN4$default(IntrinsicKt.width(BackgroundKt.m397backgroundbw27NRU$default(ShadowKt.m4425shadows4CzXII$default(companion, ContextMenuSpec.INSTANCE.m559getMenuContainerElevationD9Ej5fM(), RoundedCornerShapeKt.m1475RoundedCornerShape0680j_4(ContextMenuSpec.INSTANCE.m549getCornerRadiusD9Ej5fM()), false, 0L, 0L, 28, null), contextMenuColors.getBackgroundColor(), null, 2, null), IntrinsicSize.Max), 0.0f, ContextMenuSpec.INSTANCE.m560getVerticalPaddingD9Ej5fM(), 1, null), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, null, false, 14, null);
                int i5 = (i3 << 3) & 7168;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                int i6 = i5 >> 3;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, (i6 & 112) | (i6 & 14));
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, verticalScroll$default);
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
                Updater.m4116setimpl(m4109constructorimpl, columnMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(hashCode))) {
                    m4109constructorimpl.updateRememberedValue(Integer.valueOf(hashCode));
                    m4109constructorimpl.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                }
                Updater.m4116setimpl(m4109constructorimpl, materializeModifier, (Function2<? super T, ? super Modifier, Unit>) ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                function3.invoke(ColumnScopeInstance.INSTANCE, startRestartGroup, Integer.valueOf(((i5 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier3 = companion;
                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit ContextMenuColumn$lambda$3;
                        ContextMenuColumn$lambda$3 = ContextMenuUi_androidKt.ContextMenuColumn$lambda$3(ContextMenuColors.this, modifier3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        return ContextMenuColumn$lambda$3;
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i2 & 4) == 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ContextMenuItem(final String str, final boolean z, final ContextMenuColors contextMenuColors, Modifier modifier, Function3<? super Color, ? super Composer, ? super Integer, Unit> function3, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        int i4;
        int i5;
        Composer composer2;
        final Function3<? super Color, ? super Composer, ? super Integer, Unit> function32;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1027365588);
        ComposerKt.sourceInformation(startRestartGroup, "C(ContextMenuItem)N(label,enabled,colors,modifier,leadingIcon,onClick)202@7160L237,197@6886L1694:ContextMenuUi.android.kt#3xeu6s");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(contextMenuColors) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        int i6 = i2 & 8;
        if (i6 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? Fields.CameraDistance : Fields.RotationZ;
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                i3 |= startRestartGroup.changedInstance(function3) ? Fields.Clip : Fields.Shape;
                if ((i2 & 32) != 0) {
                    i3 |= 196608;
                } else if ((i & 196608) == 0) {
                    i3 |= startRestartGroup.changedInstance(function0) ? 131072 : 65536;
                }
                i5 = i3;
                if (!startRestartGroup.shouldExecute((74899 & i5) != 74898, i5 & 1)) {
                    composer2 = startRestartGroup;
                    composer2.skipToGroupEnd();
                    function32 = function3;
                } else {
                    Modifier modifier3 = i6 != 0 ? Modifier.INSTANCE : modifier2;
                    Function3<? super Color, ? super Composer, ? super Integer, Unit> function33 = i4 != 0 ? null : function3;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1027365588, i5, -1, "androidx.compose.foundation.contextmenu.ContextMenuItem (ContextMenuUi.android.kt:196)");
                    }
                    Alignment.Vertical labelVerticalTextAlignment = ContextMenuSpec.INSTANCE.getLabelVerticalTextAlignment();
                    Arrangement.HorizontalOrVertical m909spacedBy0680j_4 = Arrangement.INSTANCE.m909spacedBy0680j_4(ContextMenuSpec.INSTANCE.m553getHorizontalPaddingD9Ej5fM());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 544182169, "CC(remember):ContextMenuUi.android.kt#9igjgp");
                    boolean z2 = ((i5 & 112) == 32) | ((458752 & i5) == 131072);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function0() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$$ExternalSyntheticLambda4
                            public final Object invoke() {
                                Unit ContextMenuItem$lambda$5$lambda$4;
                                ContextMenuItem$lambda$5$lambda$4 = ContextMenuUi_androidKt.ContextMenuItem$lambda$5$lambda$4(z, function0);
                                return ContextMenuItem$lambda$5$lambda$4;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Function3<? super Color, ? super Composer, ? super Integer, Unit> function34 = function33;
                    Modifier m1066paddingVpY3zN4$default = PaddingKt.m1066paddingVpY3zN4$default(SizeKt.m1123sizeInqDBjuR0(SizeKt.fillMaxWidth$default(ClickableKt.m442clickableoSLSa3U$default(modifier3, z, str, null, null, (Function0) rememberedValue, 12, null), 0.0f, 1, null), ContextMenuSpec.INSTANCE.m548getContainerWidthMinD9Ej5fM(), ContextMenuSpec.INSTANCE.m558getListItemHeightD9Ej5fM(), ContextMenuSpec.INSTANCE.m547getContainerWidthMaxD9Ej5fM(), ContextMenuSpec.INSTANCE.m558getListItemHeightD9Ej5fM()), ContextMenuSpec.INSTANCE.m553getHorizontalPaddingD9Ej5fM(), 0.0f, 2, null);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m909spacedBy0680j_4, labelVerticalTextAlignment, startRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m1066paddingVpY3zN4$default);
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
                    Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(hashCode))) {
                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(hashCode));
                        m4109constructorimpl.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                    }
                    Updater.m4116setimpl(m4109constructorimpl, materializeModifier, (Function2<? super T, ? super Modifier, Unit>) ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1483502740, "C228@8275L299:ContextMenuUi.android.kt#3xeu6s");
                    if (function34 == null) {
                        startRestartGroup.startReplaceGroup(-1483499797);
                        startRestartGroup.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(-1483499796);
                        ComposerKt.sourceInformation(startRestartGroup, "*217@7862L394");
                        Modifier m1116requiredSizeInqDBjuR0$default = SizeKt.m1116requiredSizeInqDBjuR0$default(Modifier.INSTANCE, ContextMenuSpec.INSTANCE.m554getIconSizeD9Ej5fM(), 0.0f, ContextMenuSpec.INSTANCE.m554getIconSizeD9Ej5fM(), ContextMenuSpec.INSTANCE.m554getIconSizeD9Ej5fM(), 2, null);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m1116requiredSizeInqDBjuR0$default);
                        Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                            startRestartGroup.createNode(constructor2);
                        } else {
                            startRestartGroup.useNode();
                        }
                        Composer m4109constructorimpl2 = Updater.m4109constructorimpl(startRestartGroup);
                        Updater.m4116setimpl(m4109constructorimpl2, maybeCachedBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(hashCode2))) {
                            m4109constructorimpl2.updateRememberedValue(Integer.valueOf(hashCode2));
                            m4109constructorimpl2.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
                        }
                        Updater.m4116setimpl(m4109constructorimpl2, materializeModifier2, (Function2<? super T, ? super Modifier, Unit>) ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1062316871, "C225@8177L65:ContextMenuUi.android.kt#3xeu6s");
                        function34.invoke(Color.m4829boximpl(z ? contextMenuColors.getIconColor() : contextMenuColors.getDisabledIconColor()), startRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        Unit unit = Unit.INSTANCE;
                        startRestartGroup.endReplaceGroup();
                        Unit unit2 = Unit.INSTANCE;
                    }
                    composer2 = startRestartGroup;
                    BasicTextKt.m1516BasicTextRWo7tUw(str, rowScopeInstance.weight(Modifier.INSTANCE, 1.0f, true), ContextMenuSpec.INSTANCE.m561textStyle8_81llA(z ? contextMenuColors.getTextColor() : contextMenuColors.getDisabledTextColor()), (Function1<? super TextLayoutResult, Unit>) null, 0, false, 1, 0, (ColorProducer) null, (TextAutoSize) null, composer2, (i5 & 14) | 1572864, 952);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function32 = function34;
                    modifier2 = modifier3;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ContextMenuItem$lambda$9;
                            ContextMenuItem$lambda$9 = ContextMenuUi_androidKt.ContextMenuItem$lambda$9(str, z, contextMenuColors, modifier2, function32, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            return ContextMenuItem$lambda$9;
                        }
                    });
                    return;
                }
                return;
            }
            if ((i2 & 32) != 0) {
            }
            i5 = i3;
            if (!startRestartGroup.shouldExecute((74899 & i5) != 74898, i5 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        if ((i2 & 32) != 0) {
        }
        i5 = i3;
        if (!startRestartGroup.shouldExecute((74899 & i5) != 74898, i5 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContextMenuItem$lambda$5$lambda$4(boolean z, Function0 function0) {
        if (z) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    public static final ContextMenuColors getDefaultContextMenuColors() {
        return DefaultContextMenuColors;
    }

    public static final ContextMenuColors computeContextMenuColors(int i, int i2, Composer composer, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, 1689505294, "C(computeContextMenuColors)N(backgroundStyleId,foregroundStyleId)384@14138L7,385@14194L7,385@14157L851:ContextMenuUi.android.kt#3xeu6s");
        int i5 = (i4 & 1) != 0 ? R.style.Widget.PopupMenu : i;
        int i6 = (i4 & 2) != 0 ? R.style.TextAppearance.Widget.PopupMenu.Large : i2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1689505294, i3, -1, "androidx.compose.foundation.contextmenu.computeContextMenuColors (ContextMenuUi.android.kt:383)");
        }
        ProvidableCompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) consume;
        ProvidableCompositionLocal localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 116959905, "CC(remember):ContextMenuUi.android.kt#9igjgp");
        boolean changed = composer.changed((Configuration) consume2) | composer.changed(context);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            ContextMenuColors contextMenuColors = DefaultContextMenuColors;
            long m568resolveColorg2O1Hgs = m568resolveColorg2O1Hgs(context, i5, R.attr.colorBackground, contextMenuColors.getBackgroundColor());
            ColorStateList resolveColorStateList = resolveColorStateList(context, i6, R.attr.textColorPrimary);
            long m567enabledColor4WTKRHQ = m567enabledColor4WTKRHQ(resolveColorStateList, contextMenuColors.getTextColor());
            long m566disabledColor4WTKRHQ = m566disabledColor4WTKRHQ(resolveColorStateList, contextMenuColors.getDisabledTextColor());
            rememberedValue = new ContextMenuColors(m568resolveColorg2O1Hgs, m567enabledColor4WTKRHQ, m567enabledColor4WTKRHQ, m566disabledColor4WTKRHQ, m566disabledColor4WTKRHQ, null);
            composer.updateRememberedValue(rememberedValue);
        }
        ContextMenuColors contextMenuColors2 = (ContextMenuColors) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return contextMenuColors2;
    }

    /* renamed from: resolveColor-g2O1Hgs, reason: not valid java name */
    private static final long m568resolveColorg2O1Hgs(Context context, int i, int i2, long j) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, new int[]{i2});
        int m4893toArgb8_81llA = ColorKt.m4893toArgb8_81llA(j);
        int color = obtainStyledAttributes.getColor(0, m4893toArgb8_81llA);
        obtainStyledAttributes.recycle();
        return color == m4893toArgb8_81llA ? j : ColorKt.Color(color);
    }

    private static final ColorStateList resolveColorStateList(Context context, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, new int[]{i2});
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
        obtainStyledAttributes.recycle();
        return colorStateList;
    }

    /* renamed from: enabledColor-4WTKRHQ, reason: not valid java name */
    private static final long m567enabledColor4WTKRHQ(ColorStateList colorStateList, long j) {
        int m4893toArgb8_81llA = ColorKt.m4893toArgb8_81llA(j);
        Integer valueOf = colorStateList != null ? Integer.valueOf(colorStateList.getColorForState(new int[]{R.attr.state_enabled}, m4893toArgb8_81llA)) : null;
        return (valueOf == null || valueOf.intValue() == m4893toArgb8_81llA) ? j : ColorKt.Color(valueOf.intValue());
    }

    /* renamed from: disabledColor-4WTKRHQ, reason: not valid java name */
    private static final long m566disabledColor4WTKRHQ(ColorStateList colorStateList, long j) {
        int m4893toArgb8_81llA = ColorKt.m4893toArgb8_81llA(j);
        Integer valueOf = colorStateList != null ? Integer.valueOf(colorStateList.getColorForState(new int[]{-16842910}, m4893toArgb8_81llA)) : null;
        return (valueOf == null || valueOf.intValue() == m4893toArgb8_81llA) ? j : ColorKt.Color(valueOf.intValue());
    }
}
