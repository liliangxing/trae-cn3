package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.compose.foundation.gestures.ScrollableContainerNode;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p002ui.ComposedModifierKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.input.key.Key;
import androidx.compose.p002ui.input.key.KeyEventType;
import androidx.compose.p002ui.input.key.KeyEvent_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: Clickable.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aA\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\b\u000b\u001aK\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000e\u001aS\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u0011\u001a{\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\b\u0017\u001a\u0085\u0001\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u0018\u001aq\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\b\u0019\u001a\u008d\u0001\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u001a\u001a\u0085\u0001\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\b\u001b\u001aA\u0010\u001c\u001a\u00020\u0001*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u001e\b\u0004\u0010\u001d\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020\u00010\u001eH\u0080\b\u001a\f\u0010(\u001a\u00020\u0003*\u00020)H\u0000\u001a\u0010\u0010*\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\"\u0018\u0010 \u001a\u00020\u0003*\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u0018\u0010$\u001a\u00020\u0003*\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#\"\u0018\u0010&\u001a\u00020\u0003*\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010#¨\u0006+"}, d2 = {"clickable", "Landroidx/compose/ui/Modifier;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "clickable-XHw0xAI", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "clickable-oSLSa3U", "indication", "Landroidx/compose/foundation/Indication;", "clickable-O2vRcR0", "combinedClickable", "onLongClickLabel", "onLongClick", "onDoubleClick", "hapticFeedbackEnabled", "combinedClickable-f5TDLPQ", "combinedClickable-hoGz1lA", "combinedClickable-cJG_KMw", "combinedClickable-auXiCPI", "combinedClickable-XVZzFYc", "clickableWithIndicationIfNeeded", "createClickable", "Lkotlin/Function2;", "Landroidx/compose/foundation/IndicationNodeFactory;", "isPress", "Landroidx/compose/ui/input/key/KeyEvent;", "isPress-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isClick", "isClick-ZmokQxo", "isEnter", "isEnter-ZmokQxo", "hasScrollableContainer", "Landroidx/compose/ui/node/TraversableNode;", "unsupportedIndicationExceptionMessage", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ClickableKt {
    /* renamed from: clickable-XHw0xAI$default */
    public static /* synthetic */ Modifier m440clickableXHw0xAI$default(Modifier modifier, boolean z, String str, Role role, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m439clickableXHw0xAI(modifier, z, str, role, function0);
    }

    /* renamed from: clickable-oSLSa3U$default */
    public static /* synthetic */ Modifier m442clickableoSLSa3U$default(Modifier modifier, boolean z, String str, Role role, MutableInteractionSource mutableInteractionSource, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return m441clickableoSLSa3U(modifier, z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : role, (i & 8) != 0 ? null : mutableInteractionSource, function0);
    }

    /* renamed from: clickable-oSLSa3U */
    public static final Modifier m441clickableoSLSa3U(Modifier modifier, final boolean z, final String str, final Role role, final MutableInteractionSource mutableInteractionSource, final Function0<Unit> function0) {
        if (ComposeFoundationFlags.isNonComposedClickableEnabled) {
            return modifier.then((Modifier) new ClickableElement(mutableInteractionSource, null, true, z, str, role, function0, null));
        }
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$clickable-oSLSa3U$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("clickable");
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("onClickLabel", str);
                inspectorInfo.getProperties().set("role", role);
                inspectorInfo.getProperties().set("interactionSource", mutableInteractionSource);
                inspectorInfo.getProperties().set("onClick", function0);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$clickable$4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceGroup(-691633986);
                ComposerKt.sourceInformation(composer, "C229@10871L7:Clickable.kt#71ulvw");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-691633986, i, -1, "androidx.compose.foundation.clickable.<anonymous> (Clickable.kt:229)");
                }
                ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = composer.consume(localIndication);
                ComposerKt.sourceInformationMarkerEnd(composer);
                Indication indication = (Indication) consume;
                MutableInteractionSource mutableInteractionSource2 = MutableInteractionSource.this;
                if (mutableInteractionSource2 == null) {
                    if (indication instanceof IndicationNodeFactory) {
                        composer.startReplaceGroup(-1509763983);
                        composer.endReplaceGroup();
                        mutableInteractionSource2 = null;
                    } else {
                        composer.startReplaceGroup(-1509607061);
                        ComposerKt.sourceInformation(composer, "239@11415L39");
                        ComposerKt.sourceInformationMarkerStart(composer, 1059689445, "CC(remember):Clickable.kt#9igjgp");
                        Object rememberedValue = composer.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer.updateRememberedValue(rememberedValue);
                        }
                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        composer.endReplaceGroup();
                    }
                }
                Modifier m437clickableO2vRcR0 = ClickableKt.m437clickableO2vRcR0(Modifier.INSTANCE, mutableInteractionSource2, indication, z, str, role, function0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return m437clickableO2vRcR0;
            }
        });
    }

    /* renamed from: clickable-O2vRcR0$default */
    public static /* synthetic */ Modifier m438clickableO2vRcR0$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return m437clickableO2vRcR0(modifier, mutableInteractionSource, indication, z, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : role, function0);
    }

    /* renamed from: combinedClickable-hoGz1lA */
    public static final Modifier m451combinedClickablehoGz1lA(Modifier modifier, final boolean z, final String str, final Role role, final String str2, final Function0<Unit> function0, final Function0<Unit> function02, final boolean z2, final MutableInteractionSource mutableInteractionSource, final Function0<Unit> function03) {
        if (ComposeFoundationFlags.isNonComposedClickableEnabled) {
            return modifier.then((Modifier) new CombinedClickableElement(mutableInteractionSource, null, true, z, str, role, function03, str2, function0, function02, z2, null));
        }
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-hoGz1lA$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("combinedClickable");
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("onClickLabel", str);
                inspectorInfo.getProperties().set("role", role);
                inspectorInfo.getProperties().set("onClick", function03);
                inspectorInfo.getProperties().set("onDoubleClick", function02);
                inspectorInfo.getProperties().set("onLongClick", function0);
                inspectorInfo.getProperties().set("onLongClickLabel", str2);
                inspectorInfo.getProperties().set("hapticFeedbackEnabled", Boolean.valueOf(z2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceGroup(-769426448);
                ComposerKt.sourceInformation(composer, "C495@23929L7:Clickable.kt#71ulvw");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-769426448, i, -1, "androidx.compose.foundation.combinedClickable.<anonymous> (Clickable.kt:495)");
                }
                ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = composer.consume(localIndication);
                ComposerKt.sourceInformationMarkerEnd(composer);
                Indication indication = (Indication) consume;
                MutableInteractionSource mutableInteractionSource2 = MutableInteractionSource.this;
                if (mutableInteractionSource2 == null) {
                    if (indication instanceof IndicationNodeFactory) {
                        composer.startReplaceGroup(257340415);
                        composer.endReplaceGroup();
                        mutableInteractionSource2 = null;
                    } else {
                        composer.startReplaceGroup(257497337);
                        ComposerKt.sourceInformation(composer, "505@24473L39");
                        ComposerKt.sourceInformationMarkerStart(composer, -684422505, "CC(remember):Clickable.kt#9igjgp");
                        Object rememberedValue = composer.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer.updateRememberedValue(rememberedValue);
                        }
                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        composer.endReplaceGroup();
                    }
                }
                Modifier m445combinedClickableauXiCPI = ClickableKt.m445combinedClickableauXiCPI(Modifier.INSTANCE, mutableInteractionSource2, indication, z, str, role, str2, function0, function02, z2, function03);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return m445combinedClickableauXiCPI;
            }
        });
    }

    public static final Modifier clickableWithIndicationIfNeeded(Modifier modifier, MutableInteractionSource mutableInteractionSource, final Indication indication, final Function2<? super MutableInteractionSource, ? super IndicationNodeFactory, ? extends Modifier> function2) {
        Modifier composed$default;
        if (indication instanceof IndicationNodeFactory) {
            composed$default = (Modifier) function2.invoke(mutableInteractionSource, indication);
        } else if (indication == null) {
            composed$default = (Modifier) function2.invoke(mutableInteractionSource, (Object) null);
        } else if (mutableInteractionSource != null) {
            composed$default = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource, indication).then((Modifier) function2.invoke(mutableInteractionSource, (Object) null));
        } else {
            composed$default = ComposedModifierKt.composed$default(Modifier.INSTANCE, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$clickableWithIndicationIfNeeded$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
                }

                public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                    composer.startReplaceGroup(-1525724089);
                    ComposerKt.sourceInformation(composer, "C708@33677L39:Clickable.kt#71ulvw");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1525724089, i, -1, "androidx.compose.foundation.clickableWithIndicationIfNeeded.<anonymous> (Clickable.kt:708)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -1636999986, "CC(remember):Clickable.kt#9igjgp");
                    Object rememberedValue = composer.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer.updateRememberedValue(rememberedValue);
                    }
                    MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    Modifier then = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource2, Indication.this).then((Modifier) function2.invoke(mutableInteractionSource2, (Object) null));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceGroup();
                    return then;
                }
            }, 1, null);
        }
        return modifier.then(composed$default);
    }

    /* renamed from: isPress-ZmokQxo */
    public static final boolean m455isPressZmokQxo(KeyEvent keyEvent) {
        return KeyEventType.m5983equalsimpl0(KeyEvent_androidKt.m5991getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m5987getKeyDownCS__XNY()) && m454isEnterZmokQxo(keyEvent);
    }

    /* renamed from: isClick-ZmokQxo */
    public static final boolean m453isClickZmokQxo(KeyEvent keyEvent) {
        return KeyEventType.m5983equalsimpl0(KeyEvent_androidKt.m5991getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m5988getKeyUpCS__XNY()) && m454isEnterZmokQxo(keyEvent);
    }

    /* renamed from: isEnter-ZmokQxo */
    private static final boolean m454isEnterZmokQxo(KeyEvent keyEvent) {
        long m5990getKeyZmokQxo = KeyEvent_androidKt.m5990getKeyZmokQxo(keyEvent);
        return Key.m5682equalsimpl0(m5990getKeyZmokQxo, Key.INSTANCE.m5754getDirectionCenterEK5gGoQ()) || Key.m5682equalsimpl0(m5990getKeyZmokQxo, Key.INSTANCE.m5768getEnterEK5gGoQ()) || Key.m5682equalsimpl0(m5990getKeyZmokQxo, Key.INSTANCE.m5860getNumPadEnterEK5gGoQ()) || Key.m5682equalsimpl0(m5990getKeyZmokQxo, Key.INSTANCE.m5906getSpacebarEK5gGoQ());
    }

    public static final boolean hasScrollableContainer(TraversableNode traversableNode) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        TraversableNodeKt.traverseAncestors((DelegatableNode) traversableNode, ScrollableContainerNode.INSTANCE, new Function1() { // from class: androidx.compose.foundation.ClickableKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean hasScrollableContainer$lambda$8;
                hasScrollableContainer$lambda$8 = ClickableKt.hasScrollableContainer$lambda$8(booleanRef, (TraversableNode) obj);
                return Boolean.valueOf(hasScrollableContainer$lambda$8);
            }
        });
        return booleanRef.element;
    }

    public static final boolean hasScrollableContainer$lambda$8(Ref.BooleanRef booleanRef, TraversableNode traversableNode) {
        boolean z;
        if (!booleanRef.element) {
            Intrinsics.checkNotNull(traversableNode, "null cannot be cast to non-null type androidx.compose.foundation.gestures.ScrollableContainerNode");
            if (!((ScrollableContainerNode) traversableNode).getEnabled()) {
                z = false;
                booleanRef.element = z;
                return !booleanRef.element;
            }
        }
        z = true;
        booleanRef.element = z;
        return !booleanRef.element;
    }

    public static final String unsupportedIndicationExceptionMessage(Indication indication) {
        return "clickable only supports IndicationNodeFactory instances provided to LocalIndication, but Indication was provided instead. Either migrate the Indication implementation to implement IndicationNodeFactory, or use the other clickable overload that takes an Indication parameter, and explicitly pass LocalIndication.current there. You can also use ComposeFoundationFlags.isNonComposedClickableEnabled to temporarily opt-out; note that this flag will be removed in a future release and is only intended to be a temporary migration aid. The Indication instance provided here was: " + indication;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with new overload that only supports IndicationNodeFactory instances inside LocalIndication, and does not use composed")
    /* renamed from: clickable-XHw0xAI */
    public static final /* synthetic */ Modifier m439clickableXHw0xAI(Modifier modifier, final boolean z, final String str, final Role role, final Function0 function0) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$clickable-XHw0xAI$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("clickable");
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("onClickLabel", str);
                inspectorInfo.getProperties().set("role", role);
                inspectorInfo.getProperties().set("onClick", function0);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$clickable$2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                MutableInteractionSource mutableInteractionSource;
                composer.startReplaceGroup(-756081143);
                ComposerKt.sourceInformation(composer, "C137@6464L7:Clickable.kt#71ulvw");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-756081143, i, -1, "androidx.compose.foundation.clickable.<anonymous> (Clickable.kt:137)");
                }
                ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = composer.consume(localIndication);
                ComposerKt.sourceInformationMarkerEnd(composer);
                Indication indication = (Indication) consume;
                if (indication instanceof IndicationNodeFactory) {
                    composer.startReplaceGroup(-1604682242);
                    composer.endReplaceGroup();
                    mutableInteractionSource = null;
                } else {
                    composer.startReplaceGroup(-1604549624);
                    ComposerKt.sourceInformation(composer, "146@6911L39");
                    ComposerKt.sourceInformationMarkerStart(composer, -744489520, "CC(remember):Clickable.kt#9igjgp");
                    Object rememberedValue = composer.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer.updateRememberedValue(rememberedValue);
                    }
                    mutableInteractionSource = (MutableInteractionSource) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endReplaceGroup();
                }
                Modifier m437clickableO2vRcR0 = ClickableKt.m437clickableO2vRcR0(Modifier.INSTANCE, mutableInteractionSource, indication, z, str, role, function0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return m437clickableO2vRcR0;
            }
        });
    }

    /* renamed from: clickable-O2vRcR0 */
    public static final Modifier m437clickableO2vRcR0(Modifier modifier, MutableInteractionSource mutableInteractionSource, final Indication indication, final boolean z, final String str, final Role role, final Function0<Unit> function0) {
        Modifier composed$default;
        ModifierNodeElement clickableElement;
        if (indication instanceof IndicationNodeFactory) {
            clickableElement = new ClickableElement(mutableInteractionSource, (IndicationNodeFactory) indication, false, z, str, role, function0, null);
        } else {
            if (indication != null) {
                if (mutableInteractionSource != null) {
                    composed$default = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource, indication).then((Modifier) new ClickableElement(mutableInteractionSource, null, false, z, str, role, function0, null));
                } else {
                    composed$default = ComposedModifierKt.composed$default(Modifier.INSTANCE, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$clickable-O2vRcR0$$inlined$clickableWithIndicationIfNeeded$1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
                        }

                        public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                            composer.startReplaceGroup(-1525724089);
                            ComposerKt.sourceInformation(composer, "C708@33677L39:Clickable.kt#71ulvw");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1525724089, i, -1, "androidx.compose.foundation.clickableWithIndicationIfNeeded.<anonymous> (Clickable.kt:708)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composer, -1636999986, "CC(remember):Clickable.kt#9igjgp");
                            Object rememberedValue = composer.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer.updateRememberedValue(rememberedValue);
                            }
                            MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            Modifier then = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource2, Indication.this).then((Modifier) new ClickableElement(mutableInteractionSource2, null, false, z, str, role, function0, null));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer.endReplaceGroup();
                            return then;
                        }
                    }, 1, null);
                }
                return modifier.then(composed$default);
            }
            clickableElement = new ClickableElement(mutableInteractionSource, null, false, z, str, role, function0, null);
        }
        composed$default = (Modifier) clickableElement;
        return modifier.then(composed$default);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with new overload that only supports IndicationNodeFactory instances inside LocalIndication, and does not use composed")
    /* renamed from: combinedClickable-f5TDLPQ */
    public static final /* synthetic */ Modifier m449combinedClickablef5TDLPQ(Modifier modifier, final boolean z, final String str, final Role role, final String str2, final Function0 function0, final Function0 function02, final boolean z2, final Function0 function03) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-f5TDLPQ$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("combinedClickable");
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("onClickLabel", str);
                inspectorInfo.getProperties().set("role", role);
                inspectorInfo.getProperties().set("onClick", function03);
                inspectorInfo.getProperties().set("onDoubleClick", function02);
                inspectorInfo.getProperties().set("onLongClick", function0);
                inspectorInfo.getProperties().set("onLongClickLabel", str2);
                inspectorInfo.getProperties().set("hapticFeedbackEnabled", Boolean.valueOf(z2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                MutableInteractionSource mutableInteractionSource;
                composer.startReplaceGroup(-1534186401);
                ComposerKt.sourceInformation(composer, "C382@18326L7:Clickable.kt#71ulvw");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1534186401, i, -1, "androidx.compose.foundation.combinedClickable.<anonymous> (Clickable.kt:382)");
                }
                ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = composer.consume(localIndication);
                ComposerKt.sourceInformationMarkerEnd(composer);
                Indication indication = (Indication) consume;
                if (indication instanceof IndicationNodeFactory) {
                    composer.startReplaceGroup(2095040488);
                    composer.endReplaceGroup();
                    mutableInteractionSource = null;
                } else {
                    composer.startReplaceGroup(2095173106);
                    ComposerKt.sourceInformation(composer, "391@18773L39");
                    ComposerKt.sourceInformationMarkerStart(composer, -1179332954, "CC(remember):Clickable.kt#9igjgp");
                    Object rememberedValue = composer.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer.updateRememberedValue(rememberedValue);
                    }
                    mutableInteractionSource = (MutableInteractionSource) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endReplaceGroup();
                }
                Modifier m445combinedClickableauXiCPI = ClickableKt.m445combinedClickableauXiCPI(Modifier.INSTANCE, mutableInteractionSource, indication, z, str, role, str2, function0, function02, z2, function03);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return m445combinedClickableauXiCPI;
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: combinedClickable-cJG_KMw */
    public static final /* synthetic */ Modifier m447combinedClickablecJG_KMw(Modifier modifier, final boolean z, final String str, final Role role, final String str2, final Function0 function0, final Function0 function02, final Function0 function03) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-cJG_KMw$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("combinedClickable");
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("onClickLabel", str);
                inspectorInfo.getProperties().set("role", role);
                inspectorInfo.getProperties().set("onClick", function03);
                inspectorInfo.getProperties().set("onDoubleClick", function02);
                inspectorInfo.getProperties().set("onLongClick", function0);
                inspectorInfo.getProperties().set("onLongClickLabel", str2);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$6
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                MutableInteractionSource mutableInteractionSource;
                composer.startReplaceGroup(1969174843);
                ComposerKt.sourceInformation(composer, "C545@25965L7:Clickable.kt#71ulvw");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1969174843, i, -1, "androidx.compose.foundation.combinedClickable.<anonymous> (Clickable.kt:545)");
                }
                ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = composer.consume(localIndication);
                ComposerKt.sourceInformationMarkerEnd(composer);
                Indication indication = (Indication) consume;
                if (indication instanceof IndicationNodeFactory) {
                    composer.startReplaceGroup(-1270399604);
                    composer.endReplaceGroup();
                    mutableInteractionSource = null;
                } else {
                    composer.startReplaceGroup(-1270266986);
                    ComposerKt.sourceInformation(composer, "554@26412L39");
                    ComposerKt.sourceInformationMarkerStart(composer, -1703537534, "CC(remember):Clickable.kt#9igjgp");
                    Object rememberedValue = composer.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer.updateRememberedValue(rememberedValue);
                    }
                    mutableInteractionSource = (MutableInteractionSource) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endReplaceGroup();
                }
                Modifier m445combinedClickableauXiCPI = ClickableKt.m445combinedClickableauXiCPI(Modifier.INSTANCE, mutableInteractionSource, indication, z, str, role, str2, function0, function02, true, function03);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return m445combinedClickableauXiCPI;
            }
        });
    }

    /* renamed from: combinedClickable-auXiCPI */
    public static final Modifier m445combinedClickableauXiCPI(Modifier modifier, MutableInteractionSource mutableInteractionSource, final Indication indication, final boolean z, final String str, final Role role, final String str2, final Function0<Unit> function0, final Function0<Unit> function02, final boolean z2, final Function0<Unit> function03) {
        Modifier composed$default;
        ModifierNodeElement combinedClickableElement;
        if (indication instanceof IndicationNodeFactory) {
            combinedClickableElement = new CombinedClickableElement(mutableInteractionSource, (IndicationNodeFactory) indication, false, z, str, role, function03, str2, function0, function02, z2, null);
        } else {
            if (indication != null) {
                if (mutableInteractionSource != null) {
                    composed$default = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource, indication).then((Modifier) new CombinedClickableElement(mutableInteractionSource, null, false, z, str, role, function03, str2, function0, function02, z2, null));
                } else {
                    composed$default = ComposedModifierKt.composed$default(Modifier.INSTANCE, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-auXiCPI$$inlined$clickableWithIndicationIfNeeded$1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
                        }

                        public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                            composer.startReplaceGroup(-1525724089);
                            ComposerKt.sourceInformation(composer, "C708@33677L39:Clickable.kt#71ulvw");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1525724089, i, -1, "androidx.compose.foundation.clickableWithIndicationIfNeeded.<anonymous> (Clickable.kt:708)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composer, -1636999986, "CC(remember):Clickable.kt#9igjgp");
                            Object rememberedValue = composer.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer.updateRememberedValue(rememberedValue);
                            }
                            MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            Modifier then = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource2, Indication.this).then((Modifier) new CombinedClickableElement(mutableInteractionSource2, null, false, z, str, role, function03, str2, function0, function02, z2, null));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer.endReplaceGroup();
                            return then;
                        }
                    }, 1, null);
                }
                return modifier.then(composed$default);
            }
            combinedClickableElement = new CombinedClickableElement(mutableInteractionSource, null, false, z, str, role, function03, str2, function0, function02, z2, null);
        }
        composed$default = (Modifier) combinedClickableElement;
        return modifier.then(composed$default);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: combinedClickable-XVZzFYc */
    public static final /* synthetic */ Modifier m443combinedClickableXVZzFYc(Modifier modifier, MutableInteractionSource mutableInteractionSource, final Indication indication, final boolean z, final String str, final Role role, final String str2, final Function0 function0, final Function0 function02, final Function0 function03) {
        Modifier composed$default;
        ModifierNodeElement combinedClickableElement;
        if (indication instanceof IndicationNodeFactory) {
            combinedClickableElement = new CombinedClickableElement(mutableInteractionSource, (IndicationNodeFactory) indication, false, z, str, role, function03, str2, function0, function02, true, null);
        } else {
            if (indication != null) {
                if (mutableInteractionSource != null) {
                    composed$default = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource, indication).then((Modifier) new CombinedClickableElement(mutableInteractionSource, null, false, z, str, role, function03, str2, function0, function02, true, null));
                } else {
                    composed$default = ComposedModifierKt.composed$default(Modifier.INSTANCE, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-XVZzFYc$$inlined$clickableWithIndicationIfNeeded$1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
                        }

                        public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                            composer.startReplaceGroup(-1525724089);
                            ComposerKt.sourceInformation(composer, "C708@33677L39:Clickable.kt#71ulvw");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1525724089, i, -1, "androidx.compose.foundation.clickableWithIndicationIfNeeded.<anonymous> (Clickable.kt:708)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composer, -1636999986, "CC(remember):Clickable.kt#9igjgp");
                            Object rememberedValue = composer.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer.updateRememberedValue(rememberedValue);
                            }
                            MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            Modifier then = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource2, Indication.this).then((Modifier) new CombinedClickableElement(mutableInteractionSource2, null, false, z, str, role, function03, str2, function0, function02, true, null));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer.endReplaceGroup();
                            return then;
                        }
                    }, 1, null);
                }
                return modifier.then(composed$default);
            }
            combinedClickableElement = new CombinedClickableElement(mutableInteractionSource, null, false, z, str, role, function03, str2, function0, function02, true, null);
        }
        composed$default = (Modifier) combinedClickableElement;
        return modifier.then(composed$default);
    }
}
