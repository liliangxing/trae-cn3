package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.LongPressResult;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.ComposedModifierKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p002ui.input.pointer.PointerEvent;
import androidx.compose.p002ui.input.pointer.PointerEventPass;
import androidx.compose.p002ui.input.pointer.PointerEventType;
import androidx.compose.p002ui.input.pointer.PointerInputChange;
import androidx.compose.p002ui.input.pointer.PointerInputEventHandler;
import androidx.compose.p002ui.input.pointer.PointerInputScope;
import androidx.compose.p002ui.input.pointer.PointerType;
import androidx.compose.p002ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: BasicTooltip.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u000f\u001a:\u0010\u0010\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0011\u001a@\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\n*\u00020\n2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a,\u0010\u0018\u001a\u00020\n*\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a+\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010 \u001a&\u0010!\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¨\u0006\""}, d2 = {"BasicTooltipBox", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "state", "Landroidx/compose/foundation/BasicTooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "focusable", "", "enableUserInput", "content", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/BasicTooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "WrappedAnchor", "(ZLandroidx/compose/foundation/BasicTooltipState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipPopup", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/ui/window/PopupPositionProvider;Landroidx/compose/foundation/BasicTooltipState;Lkotlinx/coroutines/CoroutineScope;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "handleGestures", "enabled", "anchorSemantics", "label", "", "rememberBasicTooltipState", "initialIsVisible", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "(ZZLandroidx/compose/foundation/MutatorMutex;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BasicTooltipState;", "BasicTooltipState", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class BasicTooltipKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTooltipBox$lambda$4(PopupPositionProvider popupPositionProvider, Function2 function2, BasicTooltipState basicTooltipState, Modifier modifier, boolean z, boolean z2, Function2 function22, int i, int i2, Composer composer, int i3) {
        BasicTooltipBox(popupPositionProvider, function2, basicTooltipState, modifier, z, z2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TooltipPopup$lambda$9(PopupPositionProvider popupPositionProvider, BasicTooltipState basicTooltipState, CoroutineScope coroutineScope, boolean z, Function2 function2, int i, Composer composer, int i2) {
        TooltipPopup(popupPositionProvider, basicTooltipState, coroutineScope, z, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WrappedAnchor$lambda$6(boolean z, BasicTooltipState basicTooltipState, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        WrappedAnchor(z, basicTooltipState, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicTooltipBox(final PopupPositionProvider popupPositionProvider, final Function2<? super Composer, ? super Integer, Unit> function2, final BasicTooltipState basicTooltipState, Modifier modifier, boolean z, boolean z2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final boolean z3;
        int i5;
        boolean z4;
        int i6;
        final Modifier modifier3;
        final boolean z5;
        ScopeUpdateScope endRestartGroup;
        boolean z6;
        Composer startRestartGroup = composer.startRestartGroup(196062260);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicTooltipBox)N(positionProvider,tooltip,state,modifier,focusable,enableUserInput,content)82@3723L24,83@3752L453,102@4235L35,102@4211L59:BasicTooltip.kt#71ulvw");
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
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(basicTooltipState) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        int i7 = i2 & 8;
        if (i7 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? Fields.CameraDistance : Fields.RotationZ;
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                z3 = z;
                i3 |= startRestartGroup.changed(z3) ? Fields.Clip : Fields.Shape;
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= 196608;
                } else if ((196608 & i) == 0) {
                    z4 = z2;
                    i3 |= startRestartGroup.changed(z4) ? Fields.RenderEffect : 65536;
                    if ((i2 & 64) == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changedInstance(function22) ? 1048576 : Fields.BlendMode;
                        i6 = i3;
                        if (!startRestartGroup.shouldExecute((599187 & i6) != 599186, i6 & 1)) {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            z5 = z4;
                        } else {
                            Modifier modifier4 = i7 != 0 ? Modifier.INSTANCE : modifier2;
                            boolean z7 = i4 != 0 ? true : z3;
                            if (i5 != 0) {
                                z4 = true;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(196062260, i6, -1, "androidx.compose.foundation.BasicTooltipBox (BasicTooltip.kt:81)");
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
                            Updater.m4116setimpl(m4109constructorimpl, maybeCachedBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(hashCode))) {
                                m4109constructorimpl.updateRememberedValue(Integer.valueOf(hashCode));
                                m4109constructorimpl.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                            }
                            Updater.m4116setimpl(m4109constructorimpl, materializeModifier, (Function2<? super T, ? super Modifier, Unit>) ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833338756, "C94@4037L162:BasicTooltip.kt#71ulvw");
                            if (basicTooltipState.isVisible()) {
                                startRestartGroup.startReplaceGroup(1833353604);
                                ComposerKt.sourceInformation(startRestartGroup, "85@3801L216");
                                int i8 = i6 >> 3;
                                z6 = false;
                                TooltipPopup(popupPositionProvider, basicTooltipState, coroutineScope, z7, function2, startRestartGroup, (i6 & 14) | (i8 & 112) | (i8 & 7168) | ((i6 << 9) & 57344));
                                startRestartGroup.endReplaceGroup();
                            } else {
                                z6 = false;
                                startRestartGroup.startReplaceGroup(1833584244);
                                startRestartGroup.endReplaceGroup();
                            }
                            int i9 = i6 >> 3;
                            WrappedAnchor(z4, basicTooltipState, modifier4, function22, startRestartGroup, ((i6 >> 15) & 14) | (i9 & 112) | (i9 & 896) | ((i6 >> 9) & 7168), 0);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            startRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -562702121, "CC(remember):BasicTooltip.kt#9igjgp");
                            boolean z8 = (i6 & 896) == 256 ? true : z6;
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (z8 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = new Function1() { // from class: androidx.compose.foundation.BasicTooltipKt$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj) {
                                        DisposableEffectResult BasicTooltipBox$lambda$3$lambda$2;
                                        BasicTooltipBox$lambda$3$lambda$2 = BasicTooltipKt.BasicTooltipBox$lambda$3$lambda$2(BasicTooltipState.this, (DisposableEffectScope) obj);
                                        return BasicTooltipBox$lambda$3$lambda$2;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            EffectsKt.DisposableEffect(basicTooltipState, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue2, startRestartGroup, (i6 >> 6) & 14);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            z5 = z4;
                            z3 = z7;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.BasicTooltipKt$$ExternalSyntheticLambda3
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit BasicTooltipBox$lambda$4;
                                    BasicTooltipBox$lambda$4 = BasicTooltipKt.BasicTooltipBox$lambda$4(popupPositionProvider, function2, basicTooltipState, modifier3, z3, z5, function22, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    return BasicTooltipBox$lambda$4;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i6 = i3;
                    if (!startRestartGroup.shouldExecute((599187 & i6) != 599186, i6 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z4 = z2;
                if ((i2 & 64) == 0) {
                }
                i6 = i3;
                if (!startRestartGroup.shouldExecute((599187 & i6) != 599186, i6 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z3 = z;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            z4 = z2;
            if ((i2 & 64) == 0) {
            }
            i6 = i3;
            if (!startRestartGroup.shouldExecute((599187 & i6) != 599186, i6 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        z3 = z;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        z4 = z2;
        if ((i2 & 64) == 0) {
        }
        i6 = i3;
        if (!startRestartGroup.shouldExecute((599187 & i6) != 599186, i6 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final void WrappedAnchor(final boolean z, final BasicTooltipState basicTooltipState, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1381511093);
        ComposerKt.sourceInformation(startRestartGroup, "C(WrappedAnchor)N(enableUserInput,state,modifier,content)113@4506L24,114@4576L7,115@4588L212:BasicTooltip.kt#71ulvw");
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
            i3 |= startRestartGroup.changed(basicTooltipState) ? 32 : 16;
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
            i3 |= startRestartGroup.changedInstance(function2) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1381511093, i3, -1, "androidx.compose.foundation.WrappedAnchor (BasicTooltip.kt:112)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier anchorSemantics = anchorSemantics(handleGestures(modifier, z, basicTooltipState), BasicTooltipStrings.INSTANCE.label(startRestartGroup, 6), z, basicTooltipState, (CoroutineScope) rememberedValue);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, anchorSemantics);
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
            Updater.m4116setimpl(m4109constructorimpl, maybeCachedBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(hashCode))) {
                m4109constructorimpl.updateRememberedValue(Integer.valueOf(hashCode));
                m4109constructorimpl.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.m4116setimpl(m4109constructorimpl, materializeModifier, (Function2<? super T, ? super Modifier, Unit>) ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -529306613, "C121@4785L9:BasicTooltip.kt#71ulvw");
            function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 9) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.BasicTooltipKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit WrappedAnchor$lambda$6;
                    WrappedAnchor$lambda$6 = BasicTooltipKt.WrappedAnchor$lambda$6(z, basicTooltipState, modifier2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return WrappedAnchor$lambda$6;
                }
            });
        }
    }

    private static final void TooltipPopup(final PopupPositionProvider popupPositionProvider, final BasicTooltipState basicTooltipState, final CoroutineScope coroutineScope, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1882542163);
        ComposerKt.sourceInformation(startRestartGroup, "C(TooltipPopup)N(positionProvider,state,scope,focusable,content)134@5099L13,137@5201L109,143@5379L251,135@5117L513:BasicTooltip.kt#71ulvw");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(popupPositionProvider) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(basicTooltipState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(coroutineScope) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(z) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? Fields.Clip : Fields.Shape;
        }
        if (!startRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1882542163, i2, -1, "androidx.compose.foundation.TooltipPopup (BasicTooltip.kt:133)");
            }
            String description = BasicTooltipStrings.INSTANCE.description(startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -941774214, "CC(remember):BasicTooltip.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(coroutineScope) | ((i2 & 112) == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: androidx.compose.foundation.BasicTooltipKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit TooltipPopup$lambda$8$lambda$7;
                        TooltipPopup$lambda$8$lambda$7 = BasicTooltipKt.TooltipPopup$lambda$8$lambda$7(BasicTooltipState.this, coroutineScope);
                        return TooltipPopup$lambda$8$lambda$7;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            AndroidPopup_androidKt.Popup(popupPositionProvider, (Function0) rememberedValue, new PopupProperties(z, false, false, false, 14, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(916917707, true, new BasicTooltipKt$TooltipPopup$2(description, function2), startRestartGroup, 54), startRestartGroup, (i2 & 14) | 3072, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.BasicTooltipKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit TooltipPopup$lambda$9;
                    TooltipPopup$lambda$9 = BasicTooltipKt.TooltipPopup$lambda$9(popupPositionProvider, basicTooltipState, coroutineScope, z, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TooltipPopup$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TooltipPopup$lambda$8$lambda$7(BasicTooltipState basicTooltipState, CoroutineScope coroutineScope) {
        if (basicTooltipState.isVisible()) {
            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new BasicTooltipKt$TooltipPopup$1$1$1(basicTooltipState, null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    private static final Modifier handleGestures(Modifier modifier, boolean z, final BasicTooltipState basicTooltipState) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(SuspendingPointerInputFilterKt.pointerInput(modifier, basicTooltipState, new PointerInputEventHandler() { // from class: androidx.compose.foundation.BasicTooltipKt$handleGestures$1

            /* compiled from: BasicTooltip.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.BasicTooltipKt$handleGestures$1$1", f = "BasicTooltip.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.foundation.BasicTooltipKt$handleGestures$1$1 */
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
            static final class C02211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ BasicTooltipState $state;
                final /* synthetic */ PointerInputScope $this_pointerInput;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C02211(PointerInputScope pointerInputScope, BasicTooltipState basicTooltipState, Continuation<? super C02211> continuation) {
                    super(2, continuation);
                    this.$this_pointerInput = pointerInputScope;
                    this.$state = basicTooltipState;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    Continuation<Unit> c02211 = new C02211(this.$this_pointerInput, this.$state, continuation);
                    c02211.L$0 = obj;
                    return c02211;
                }

                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: BasicTooltip.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.foundation.BasicTooltipKt$handleGestures$1$1$1", f = "BasicTooltip.kt", i = {0, 0, 1, 1}, l = {166, 169, 175}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "pass", "$this$awaitEachGesture", "pass"}, s = {"L$0", "L$1", "L$0", "L$1"})
                /* renamed from: androidx.compose.foundation.BasicTooltipKt$handleGestures$1$1$1, reason: invalid class name */
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CoroutineScope $$this$coroutineScope;
                    final /* synthetic */ BasicTooltipState $state;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(CoroutineScope coroutineScope, BasicTooltipState basicTooltipState, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$$this$coroutineScope = coroutineScope;
                        this.$state = basicTooltipState;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$$this$coroutineScope, this.$state, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                        return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:19:0x008c  */
                    /* JADX WARN: Removed duplicated region for block: B:9:0x00bd A[LOOP:0: B:8:0x00bb->B:9:0x00bd, LOOP_END] */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invokeSuspend(Object obj) {
                        PointerEventPass pointerEventPass;
                        AwaitPointerEventScope awaitPointerEventScope;
                        AwaitPointerEventScope awaitPointerEventScope2;
                        int size;
                        int i;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i2 = this.label;
                        if (i2 == 0) {
                            ResultKt.throwOnFailure(obj);
                            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                            pointerEventPass = PointerEventPass.Initial;
                            this.L$0 = awaitPointerEventScope3;
                            this.L$1 = pointerEventPass;
                            this.label = 1;
                            Object awaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope3, false, pointerEventPass, (Continuation) this, 1, null);
                            if (awaitFirstDown$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            awaitPointerEventScope = awaitPointerEventScope3;
                            obj = awaitFirstDown$default;
                        } else {
                            if (i2 != 1) {
                                if (i2 != 2) {
                                    if (i2 != 3) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                    List<PointerInputChange> changes = ((PointerEvent) obj).getChanges();
                                    size = changes.size();
                                    for (i = 0; i < size; i++) {
                                        changes.get(i).consume();
                                    }
                                    return Unit.INSTANCE;
                                }
                                pointerEventPass = (PointerEventPass) this.L$1;
                                awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                if (((LongPressResult) obj) instanceof LongPressResult.Success) {
                                    BuildersKt.launch$default(this.$$this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C07901(this.$state, null), 3, (Object) null);
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.label = 3;
                                    obj = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass, (Continuation) this);
                                    if (obj == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    List<PointerInputChange> changes2 = ((PointerEvent) obj).getChanges();
                                    size = changes2.size();
                                    while (i < size) {
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                            pointerEventPass = (PointerEventPass) this.L$1;
                            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                        }
                        int type = ((PointerInputChange) obj).getType();
                        if (PointerType.m6215equalsimpl0(type, PointerType.INSTANCE.m6222getTouchT8wyACA()) || PointerType.m6215equalsimpl0(type, PointerType.INSTANCE.m6221getStylusT8wyACA())) {
                            this.L$0 = awaitPointerEventScope;
                            this.L$1 = pointerEventPass;
                            this.label = 2;
                            obj = TapGestureDetectorKt.waitForLongPress(awaitPointerEventScope, pointerEventPass, (Continuation) this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            awaitPointerEventScope2 = awaitPointerEventScope;
                            if (((LongPressResult) obj) instanceof LongPressResult.Success) {
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: BasicTooltip.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.foundation.BasicTooltipKt$handleGestures$1$1$1$1", f = "BasicTooltip.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: androidx.compose.foundation.BasicTooltipKt$handleGestures$1$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                    public static final class C07901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ BasicTooltipState $state;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C07901(BasicTooltipState basicTooltipState, Continuation<? super C07901> continuation) {
                            super(2, continuation);
                            this.$state = basicTooltipState;
                        }

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C07901(this.$state, continuation);
                        }

                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$state.show(MutatePriority.UserInput, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }

                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                        this.label = 1;
                        if (ForEachGestureKt.awaitEachGesture(this.$this_pointerInput, new AnonymousClass1(coroutineScope, this.$state, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.compose.p002ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object coroutineScope = CoroutineScopeKt.coroutineScope(new C02211(pointerInputScope, BasicTooltipState.this, null), continuation);
                return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
            }
        }), basicTooltipState, new PointerInputEventHandler() { // from class: androidx.compose.foundation.BasicTooltipKt$handleGestures$2

            /* compiled from: BasicTooltip.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.BasicTooltipKt$handleGestures$2$1", f = "BasicTooltip.kt", i = {}, l = {186}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.foundation.BasicTooltipKt$handleGestures$2$1 */
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
            static final class C02221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ BasicTooltipState $state;
                final /* synthetic */ PointerInputScope $this_pointerInput;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C02221(PointerInputScope pointerInputScope, BasicTooltipState basicTooltipState, Continuation<? super C02221> continuation) {
                    super(2, continuation);
                    this.$this_pointerInput = pointerInputScope;
                    this.$state = basicTooltipState;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    Continuation<Unit> c02221 = new C02221(this.$this_pointerInput, this.$state, continuation);
                    c02221.L$0 = obj;
                    return c02221;
                }

                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: BasicTooltip.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.foundation.BasicTooltipKt$handleGestures$2$1$1", f = "BasicTooltip.kt", i = {0, 0}, l = {190}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "pass"}, s = {"L$0", "L$1"})
                /* renamed from: androidx.compose.foundation.BasicTooltipKt$handleGestures$2$1$1, reason: invalid class name */
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CoroutineScope $$this$coroutineScope;
                    final /* synthetic */ BasicTooltipState $state;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(CoroutineScope coroutineScope, BasicTooltipState basicTooltipState, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$$this$coroutineScope = coroutineScope;
                        this.$state = basicTooltipState;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$$this$coroutineScope, this.$state, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                        return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:16:0x003d A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0061  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x003e -> B:5:0x0044). Please report as a decompilation issue!!! */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invokeSuspend(Object obj) {
                        PointerEventPass pointerEventPass;
                        AwaitPointerEventScope awaitPointerEventScope;
                        AnonymousClass1 anonymousClass1;
                        Object awaitPointerEvent;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                            pointerEventPass = PointerEventPass.Main;
                            awaitPointerEventScope = awaitPointerEventScope2;
                            anonymousClass1 = this;
                            anonymousClass1.L$0 = awaitPointerEventScope;
                            anonymousClass1.L$1 = pointerEventPass;
                            anonymousClass1.label = 1;
                            awaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(pointerEventPass, (Continuation) anonymousClass1);
                            if (awaitPointerEvent == coroutine_suspended) {
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            PointerEventPass pointerEventPass2 = (PointerEventPass) this.L$1;
                            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            AwaitPointerEventScope awaitPointerEventScope4 = awaitPointerEventScope3;
                            PointerEventPass pointerEventPass3 = pointerEventPass2;
                            Object obj2 = coroutine_suspended;
                            AnonymousClass1 anonymousClass12 = this;
                            PointerEvent pointerEvent = (PointerEvent) obj;
                            if (PointerType.m6215equalsimpl0(pointerEvent.getChanges().get(0).getType(), PointerType.INSTANCE.m6220getMouseT8wyACA())) {
                                int type = pointerEvent.getType();
                                if (PointerEventType.m6091equalsimpl0(type, PointerEventType.INSTANCE.m6095getEnter7fucELk())) {
                                    BuildersKt.launch$default(anonymousClass12.$$this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C07911(anonymousClass12.$state, null), 3, (Object) null);
                                } else if (PointerEventType.m6091equalsimpl0(type, PointerEventType.INSTANCE.m6096getExit7fucELk())) {
                                    anonymousClass12.$state.dismiss();
                                }
                            }
                            anonymousClass1 = anonymousClass12;
                            coroutine_suspended = obj2;
                            pointerEventPass = pointerEventPass3;
                            awaitPointerEventScope = awaitPointerEventScope4;
                            anonymousClass1.L$0 = awaitPointerEventScope;
                            anonymousClass1.L$1 = pointerEventPass;
                            anonymousClass1.label = 1;
                            awaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(pointerEventPass, (Continuation) anonymousClass1);
                            if (awaitPointerEvent == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Object obj3 = coroutine_suspended;
                            anonymousClass12 = anonymousClass1;
                            obj = awaitPointerEvent;
                            awaitPointerEventScope4 = awaitPointerEventScope;
                            pointerEventPass3 = pointerEventPass;
                            obj2 = obj3;
                            PointerEvent pointerEvent2 = (PointerEvent) obj;
                            if (PointerType.m6215equalsimpl0(pointerEvent2.getChanges().get(0).getType(), PointerType.INSTANCE.m6220getMouseT8wyACA())) {
                            }
                            anonymousClass1 = anonymousClass12;
                            coroutine_suspended = obj2;
                            pointerEventPass = pointerEventPass3;
                            awaitPointerEventScope = awaitPointerEventScope4;
                            anonymousClass1.L$0 = awaitPointerEventScope;
                            anonymousClass1.L$1 = pointerEventPass;
                            anonymousClass1.label = 1;
                            awaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(pointerEventPass, (Continuation) anonymousClass1);
                            if (awaitPointerEvent == coroutine_suspended) {
                            }
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: BasicTooltip.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.foundation.BasicTooltipKt$handleGestures$2$1$1$1", f = "BasicTooltip.kt", i = {}, l = {195}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: androidx.compose.foundation.BasicTooltipKt$handleGestures$2$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                    public static final class C07911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ BasicTooltipState $state;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C07911(BasicTooltipState basicTooltipState, Continuation<? super C07911> continuation) {
                            super(2, continuation);
                            this.$state = basicTooltipState;
                        }

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C07911(this.$state, continuation);
                        }

                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$state.show(MutatePriority.UserInput, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }

                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                        this.label = 1;
                        if (this.$this_pointerInput.awaitPointerEventScope(new AnonymousClass1(coroutineScope, this.$state, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.compose.p002ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object coroutineScope = CoroutineScopeKt.coroutineScope(new C02221(pointerInputScope, BasicTooltipState.this, null), continuation);
                return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
            }
        }) : modifier;
    }

    private static final Modifier anchorSemantics(Modifier modifier, final String str, boolean z, final BasicTooltipState basicTooltipState, final CoroutineScope coroutineScope) {
        return z ? SemanticsModifierKt.semantics(modifier, true, new Function1() { // from class: androidx.compose.foundation.BasicTooltipKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit anchorSemantics$lambda$11;
                anchorSemantics$lambda$11 = BasicTooltipKt.anchorSemantics$lambda$11(str, coroutineScope, basicTooltipState, (SemanticsPropertyReceiver) obj);
                return anchorSemantics$lambda$11;
            }
        }) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit anchorSemantics$lambda$11(String str, final CoroutineScope coroutineScope, final BasicTooltipState basicTooltipState, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.onLongClick(semanticsPropertyReceiver, str, new Function0() { // from class: androidx.compose.foundation.BasicTooltipKt$$ExternalSyntheticLambda1
            public final Object invoke() {
                boolean anchorSemantics$lambda$11$lambda$10;
                anchorSemantics$lambda$11$lambda$10 = BasicTooltipKt.anchorSemantics$lambda$11$lambda$10(coroutineScope, basicTooltipState);
                return Boolean.valueOf(anchorSemantics$lambda$11$lambda$10);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean anchorSemantics$lambda$11$lambda$10(CoroutineScope coroutineScope, BasicTooltipState basicTooltipState) {
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new BasicTooltipKt$anchorSemantics$1$1$1(basicTooltipState, null), 3, (Object) null);
        return true;
    }

    public static final BasicTooltipState rememberBasicTooltipState(boolean z, boolean z2, MutatorMutex mutatorMutex, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1123859613, "C(rememberBasicTooltipState)N(initialIsVisible,isPersistent,mutatorMutex)245@9396L216:BasicTooltip.kt#71ulvw");
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        if ((i2 & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1123859613, i, -1, "androidx.compose.foundation.rememberBasicTooltipState (BasicTooltip.kt:245)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1992304821, "CC(remember):BasicTooltip.kt#9igjgp");
        boolean z3 = ((((i & 112) ^ 48) > 32 && composer.changed(z2)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(mutatorMutex)) || (i & 384) == 256);
        Object rememberedValue = composer.rememberedValue();
        if (z3 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new BasicTooltipStateImpl(z, z2, mutatorMutex);
            composer.updateRememberedValue(rememberedValue);
        }
        BasicTooltipStateImpl basicTooltipStateImpl = (BasicTooltipStateImpl) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return basicTooltipStateImpl;
    }

    public static /* synthetic */ BasicTooltipState BasicTooltipState$default(boolean z, boolean z2, MutatorMutex mutatorMutex, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        return BasicTooltipState(z, z2, mutatorMutex);
    }

    public static final BasicTooltipState BasicTooltipState(boolean z, boolean z2, MutatorMutex mutatorMutex) {
        return new BasicTooltipStateImpl(z, z2, mutatorMutex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult BasicTooltipBox$lambda$3$lambda$2(final BasicTooltipState basicTooltipState, DisposableEffectScope disposableEffectScope) {
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.BasicTooltipKt$BasicTooltipBox$lambda$3$lambda$2$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                BasicTooltipState.this.onDispose();
            }
        };
    }
}
