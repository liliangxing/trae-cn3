package com.bytedance.trae.design.compose;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteractionKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.semantics.Role;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ImageResources_androidKt;

/* compiled from: TraePressableIcon.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\u001ak\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014²\u0006\n\u0010\u0015\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\f\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u008a\u008e\u0002"}, d2 = {"TraePressableIcon", "", "icon", "Lorg/jetbrains/compose/resources/DrawableResource;", "contentDescription", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "normalTint", "Landroidx/compose/ui/graphics/Color;", "pressedTint", "disabledTint", "clickFeedbackDurationMillis", "", "TraePressableIcon-v-nKSRU", "(Lorg/jetbrains/compose/resources/DrawableResource;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZJJJJLandroidx/compose/runtime/Composer;II)V", "design-system-compose_mainlandRelease", "pressed", "clickFeedbackActive", "clickFeedbackJob", "Lkotlinx/coroutines/Job;"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraePressableIconKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TraePressableIcon_v_nKSRU$lambda$10(DrawableResource drawableResource, String str, Function0 function0, Modifier modifier, boolean z, long j, long j2, long j3, long j4, int i, int i2, Composer composer, int i3) {
        m2261TraePressableIconvnKSRU(drawableResource, str, function0, modifier, z, j, j2, j3, j4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x02ac, code lost:
    
        if (r12 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L177;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x028f  */
    /* renamed from: TraePressableIcon-v-nKSRU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2261TraePressableIconvnKSRU(final DrawableResource drawableResource, final String str, final Function0<Unit> function0, Modifier modifier, boolean z, long j, long j2, long j3, long j4, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        boolean z2;
        long j5;
        final long j6;
        int i6;
        Modifier modifier2;
        long j7;
        long j8;
        Object rememberedValue;
        Object rememberedValue2;
        Object rememberedValue3;
        Object rememberedValue4;
        boolean changedInstance;
        Object obj;
        final Modifier modifier3;
        final boolean z3;
        final long j9;
        final long j10;
        final long j11;
        ScopeUpdateScope endRestartGroup;
        int i7;
        Intrinsics.checkNotNullParameter(drawableResource, "icon");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(1829015393);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(drawableResource) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(str) ? 32 : 16;
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= startRestartGroup.changedInstance(function0) ? StatusBarUtils.FLAG_NOTCH_SUPPORT : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changed(modifier) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    z2 = z;
                    i3 |= startRestartGroup.changed(z2) ? 16384 : FConstants.DOWNLOAD_BUFFER_SIZE;
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            j5 = j;
                            if (startRestartGroup.changed(j5)) {
                                i7 = 131072;
                                i3 |= i7;
                            }
                        } else {
                            j5 = j;
                        }
                        i7 = 65536;
                        i3 |= i7;
                    } else {
                        j5 = j;
                    }
                    if ((i & 1572864) != 0) {
                        j6 = j2;
                        i3 |= ((i2 & 64) == 0 && startRestartGroup.changed(j6)) ? 1048576 : FConstants.SLICE_SIZE;
                    } else {
                        j6 = j2;
                    }
                    if ((i & 12582912) == 0) {
                        i3 |= ((i2 & 128) == 0 && startRestartGroup.changed(j3)) ? 8388608 : 4194304;
                    }
                    i6 = i2 & StatusBarUtils.FLAG_NOTCH_SUPPORT;
                    if (i6 == 0) {
                        i3 |= 100663296;
                    } else if ((100663296 & i) == 0) {
                        i3 |= startRestartGroup.changed(j4) ? 67108864 : 33554432;
                        if ((i3 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                modifier2 = i4 != 0 ? (Modifier) Modifier.Companion : modifier;
                                if (i5 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    j5 = TraeTheme.INSTANCE.getColors(startRestartGroup, 6).mo1751getIconIconDefault0d7_KjU();
                                    i3 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    j6 = j5;
                                }
                                if ((i2 & 128) != 0) {
                                    j7 = TraeTheme.INSTANCE.getColors(startRestartGroup, 6).mo1753getIconIconDisabled0d7_KjU();
                                    i3 &= -29360129;
                                } else {
                                    j7 = j3;
                                }
                                if (i6 != 0) {
                                    j8 = 120;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1829015393, i3, -1, "com.bytedance.trae.design.compose.TraePressableIcon (TraePressableIcon.kt:32)");
                                    }
                                    startRestartGroup.startReplaceGroup(-1434444789);
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.Companion.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    InteractionSource interactionSource = (MutableInteractionSource) rememberedValue;
                                    startRestartGroup.endReplaceGroup();
                                    State collectIsPressedAsState = PressInteractionKt.collectIsPressedAsState(interactionSource, startRestartGroup, 6);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                                    rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                        rememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue2;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    startRestartGroup.startReplaceGroup(-1434438906);
                                    rememberedValue3 = startRestartGroup.rememberedValue();
                                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                        MutableState mutableStateOf$default = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                                        startRestartGroup.updateRememberedValue(mutableStateOf$default);
                                        rememberedValue3 = mutableStateOf$default;
                                    }
                                    final MutableState mutableState = (MutableState) rememberedValue3;
                                    startRestartGroup.endReplaceGroup();
                                    startRestartGroup.startReplaceGroup(-1434436885);
                                    rememberedValue4 = startRestartGroup.rememberedValue();
                                    long j12 = j6;
                                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                        rememberedValue4 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                                        startRestartGroup.updateRememberedValue(rememberedValue4);
                                    }
                                    final MutableState mutableState2 = (MutableState) rememberedValue4;
                                    startRestartGroup.endReplaceGroup();
                                    long j13 = z2 ? j7 : !z2 && (TraePressableIcon_v_nKSRU$lambda$1(collectIsPressedAsState) || TraePressableIcon_v_nKSRU$lambda$3(mutableState)) ? j12 : j5;
                                    Painter painterResource = ImageResources_androidKt.painterResource(drawableResource, startRestartGroup, i3 & 14);
                                    startRestartGroup.startReplaceGroup(-1434419977);
                                    long j14 = j5;
                                    changedInstance = startRestartGroup.changedInstance(coroutineScope) | ((i3 & 234881024) != 67108864) | ((i3 & 896) == 256);
                                    Object rememberedValue5 = startRestartGroup.rememberedValue();
                                    if (!changedInstance) {
                                        obj = rememberedValue5;
                                    }
                                    final long j15 = j8;
                                    Function0 function02 = new Function0() { // from class: com.bytedance.trae.design.compose.TraePressableIconKt$$ExternalSyntheticLambda0
                                        public final Object invoke() {
                                            Unit TraePressableIcon_v_nKSRU$lambda$9$lambda$8;
                                            TraePressableIcon_v_nKSRU$lambda$9$lambda$8 = TraePressableIconKt.TraePressableIcon_v_nKSRU$lambda$9$lambda$8(coroutineScope, function0, mutableState2, mutableState, j15);
                                            return TraePressableIcon_v_nKSRU$lambda$9$lambda$8;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(function02);
                                    obj = function02;
                                    startRestartGroup.endReplaceGroup();
                                    ImageKt.Image(painterResource, str, ClickableKt.clickable-O2vRcR0$default(modifier2, interactionSource, (Indication) null, z2, (String) null, (Role) null, (Function0) obj, 24, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, j13, 0, 2, (Object) null), startRestartGroup, i3 & 112, 56);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier2;
                                    z3 = z2;
                                    j9 = j7;
                                    j10 = j8;
                                    j6 = j12;
                                    j11 = j14;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    i3 &= -29360129;
                                }
                                modifier2 = modifier;
                                j7 = j3;
                            }
                            j8 = j4;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.startReplaceGroup(-1434444789);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                            }
                            InteractionSource interactionSource2 = (MutableInteractionSource) rememberedValue;
                            startRestartGroup.endReplaceGroup();
                            State collectIsPressedAsState2 = PressInteractionKt.collectIsPressedAsState(interactionSource2, startRestartGroup, 6);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            }
                            final CoroutineScope coroutineScope2 = (CoroutineScope) rememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            startRestartGroup.startReplaceGroup(-1434438906);
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            }
                            final MutableState mutableState3 = (MutableState) rememberedValue3;
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(-1434436885);
                            rememberedValue4 = startRestartGroup.rememberedValue();
                            long j122 = j6;
                            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                            }
                            final MutableState mutableState22 = (MutableState) rememberedValue4;
                            startRestartGroup.endReplaceGroup();
                            if (z2) {
                            }
                            Painter painterResource2 = ImageResources_androidKt.painterResource(drawableResource, startRestartGroup, i3 & 14);
                            startRestartGroup.startReplaceGroup(-1434419977);
                            long j142 = j5;
                            changedInstance = startRestartGroup.changedInstance(coroutineScope2) | ((i3 & 234881024) != 67108864) | ((i3 & 896) == 256);
                            Object rememberedValue52 = startRestartGroup.rememberedValue();
                            if (!changedInstance) {
                            }
                            final long j152 = j8;
                            Function0 function022 = new Function0() { // from class: com.bytedance.trae.design.compose.TraePressableIconKt$$ExternalSyntheticLambda0
                                public final Object invoke() {
                                    Unit TraePressableIcon_v_nKSRU$lambda$9$lambda$8;
                                    TraePressableIcon_v_nKSRU$lambda$9$lambda$8 = TraePressableIconKt.TraePressableIcon_v_nKSRU$lambda$9$lambda$8(coroutineScope2, function0, mutableState22, mutableState3, j152);
                                    return TraePressableIcon_v_nKSRU$lambda$9$lambda$8;
                                }
                            };
                            startRestartGroup.updateRememberedValue(function022);
                            obj = function022;
                            startRestartGroup.endReplaceGroup();
                            ImageKt.Image(painterResource2, str, ClickableKt.clickable-O2vRcR0$default(modifier2, interactionSource2, (Indication) null, z2, (String) null, (Role) null, (Function0) obj, 24, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, j13, 0, 2, (Object) null), startRestartGroup, i3 & 112, 56);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = modifier2;
                            z3 = z2;
                            j9 = j7;
                            j10 = j8;
                            j6 = j122;
                            j11 = j142;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = modifier;
                            z3 = z2;
                            j11 = j5;
                            j9 = j3;
                            j10 = j4;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.design.compose.TraePressableIconKt$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj2, Object obj3) {
                                    Unit TraePressableIcon_v_nKSRU$lambda$10;
                                    TraePressableIcon_v_nKSRU$lambda$10 = TraePressableIconKt.TraePressableIcon_v_nKSRU$lambda$10(drawableResource, str, function0, modifier3, z3, j11, j6, j9, j10, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                                    return TraePressableIcon_v_nKSRU$lambda$10;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i3 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if ((i2 & 128) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    j8 = j4;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceGroup(-1434444789);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                    }
                    InteractionSource interactionSource22 = (MutableInteractionSource) rememberedValue;
                    startRestartGroup.endReplaceGroup();
                    State collectIsPressedAsState22 = PressInteractionKt.collectIsPressedAsState(interactionSource22, startRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    }
                    final CoroutineScope coroutineScope22 = (CoroutineScope) rememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.startReplaceGroup(-1434438906);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    }
                    final MutableState mutableState32 = (MutableState) rememberedValue3;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(-1434436885);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    long j1222 = j6;
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    }
                    final MutableState mutableState222 = (MutableState) rememberedValue4;
                    startRestartGroup.endReplaceGroup();
                    if (z2) {
                    }
                    Painter painterResource22 = ImageResources_androidKt.painterResource(drawableResource, startRestartGroup, i3 & 14);
                    startRestartGroup.startReplaceGroup(-1434419977);
                    long j1422 = j5;
                    changedInstance = startRestartGroup.changedInstance(coroutineScope22) | ((i3 & 234881024) != 67108864) | ((i3 & 896) == 256);
                    Object rememberedValue522 = startRestartGroup.rememberedValue();
                    if (!changedInstance) {
                    }
                    final long j1522 = j8;
                    Function0 function0222 = new Function0() { // from class: com.bytedance.trae.design.compose.TraePressableIconKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit TraePressableIcon_v_nKSRU$lambda$9$lambda$8;
                            TraePressableIcon_v_nKSRU$lambda$9$lambda$8 = TraePressableIconKt.TraePressableIcon_v_nKSRU$lambda$9$lambda$8(coroutineScope22, function0, mutableState222, mutableState32, j1522);
                            return TraePressableIcon_v_nKSRU$lambda$9$lambda$8;
                        }
                    };
                    startRestartGroup.updateRememberedValue(function0222);
                    obj = function0222;
                    startRestartGroup.endReplaceGroup();
                    ImageKt.Image(painterResource22, str, ClickableKt.clickable-O2vRcR0$default(modifier2, interactionSource22, (Indication) null, z2, (String) null, (Role) null, (Function0) obj, 24, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, j13, 0, 2, (Object) null), startRestartGroup, i3 & 112, 56);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier2;
                    z3 = z2;
                    j9 = j7;
                    j10 = j8;
                    j6 = j1222;
                    j11 = j1422;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z2 = z;
                if ((196608 & i) != 0) {
                }
                if ((i & 1572864) != 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i6 = i2 & StatusBarUtils.FLAG_NOTCH_SUPPORT;
                if (i6 == 0) {
                }
                if ((i3 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if ((i2 & 128) != 0) {
                }
                if (i6 != 0) {
                }
                j8 = j4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceGroup(-1434444789);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                }
                InteractionSource interactionSource222 = (MutableInteractionSource) rememberedValue;
                startRestartGroup.endReplaceGroup();
                State collectIsPressedAsState222 = PressInteractionKt.collectIsPressedAsState(interactionSource222, startRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                }
                final CoroutineScope coroutineScope222 = (CoroutineScope) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.startReplaceGroup(-1434438906);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                }
                final MutableState mutableState322 = (MutableState) rememberedValue3;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1434436885);
                rememberedValue4 = startRestartGroup.rememberedValue();
                long j12222 = j6;
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                }
                final MutableState mutableState2222 = (MutableState) rememberedValue4;
                startRestartGroup.endReplaceGroup();
                if (z2) {
                }
                Painter painterResource222 = ImageResources_androidKt.painterResource(drawableResource, startRestartGroup, i3 & 14);
                startRestartGroup.startReplaceGroup(-1434419977);
                long j14222 = j5;
                changedInstance = startRestartGroup.changedInstance(coroutineScope222) | ((i3 & 234881024) != 67108864) | ((i3 & 896) == 256);
                Object rememberedValue5222 = startRestartGroup.rememberedValue();
                if (!changedInstance) {
                }
                final long j15222 = j8;
                Function0 function02222 = new Function0() { // from class: com.bytedance.trae.design.compose.TraePressableIconKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit TraePressableIcon_v_nKSRU$lambda$9$lambda$8;
                        TraePressableIcon_v_nKSRU$lambda$9$lambda$8 = TraePressableIconKt.TraePressableIcon_v_nKSRU$lambda$9$lambda$8(coroutineScope222, function0, mutableState2222, mutableState322, j15222);
                        return TraePressableIcon_v_nKSRU$lambda$9$lambda$8;
                    }
                };
                startRestartGroup.updateRememberedValue(function02222);
                obj = function02222;
                startRestartGroup.endReplaceGroup();
                ImageKt.Image(painterResource222, str, ClickableKt.clickable-O2vRcR0$default(modifier2, interactionSource222, (Indication) null, z2, (String) null, (Role) null, (Function0) obj, 24, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, j13, 0, 2, (Object) null), startRestartGroup, i3 & 112, 56);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                z3 = z2;
                j9 = j7;
                j10 = j8;
                j6 = j12222;
                j11 = j14222;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            z2 = z;
            if ((196608 & i) != 0) {
            }
            if ((i & 1572864) != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i6 = i2 & StatusBarUtils.FLAG_NOTCH_SUPPORT;
            if (i6 == 0) {
            }
            if ((i3 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if (i6 != 0) {
            }
            j8 = j4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(-1434444789);
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
            }
            InteractionSource interactionSource2222 = (MutableInteractionSource) rememberedValue;
            startRestartGroup.endReplaceGroup();
            State collectIsPressedAsState2222 = PressInteractionKt.collectIsPressedAsState(interactionSource2222, startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
            }
            final CoroutineScope coroutineScope2222 = (CoroutineScope) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.startReplaceGroup(-1434438906);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
            }
            final MutableState mutableState3222 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1434436885);
            rememberedValue4 = startRestartGroup.rememberedValue();
            long j122222 = j6;
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
            }
            final MutableState mutableState22222 = (MutableState) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            if (z2) {
            }
            Painter painterResource2222 = ImageResources_androidKt.painterResource(drawableResource, startRestartGroup, i3 & 14);
            startRestartGroup.startReplaceGroup(-1434419977);
            long j142222 = j5;
            changedInstance = startRestartGroup.changedInstance(coroutineScope2222) | ((i3 & 234881024) != 67108864) | ((i3 & 896) == 256);
            Object rememberedValue52222 = startRestartGroup.rememberedValue();
            if (!changedInstance) {
            }
            final long j152222 = j8;
            Function0 function022222 = new Function0() { // from class: com.bytedance.trae.design.compose.TraePressableIconKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit TraePressableIcon_v_nKSRU$lambda$9$lambda$8;
                    TraePressableIcon_v_nKSRU$lambda$9$lambda$8 = TraePressableIconKt.TraePressableIcon_v_nKSRU$lambda$9$lambda$8(coroutineScope2222, function0, mutableState22222, mutableState3222, j152222);
                    return TraePressableIcon_v_nKSRU$lambda$9$lambda$8;
                }
            };
            startRestartGroup.updateRememberedValue(function022222);
            obj = function022222;
            startRestartGroup.endReplaceGroup();
            ImageKt.Image(painterResource2222, str, ClickableKt.clickable-O2vRcR0$default(modifier2, interactionSource2222, (Indication) null, z2, (String) null, (Role) null, (Function0) obj, 24, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, j13, 0, 2, (Object) null), startRestartGroup, i3 & 112, 56);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            z3 = z2;
            j9 = j7;
            j10 = j8;
            j6 = j122222;
            j11 = j142222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i2 & 4) == 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        z2 = z;
        if ((196608 & i) != 0) {
        }
        if ((i & 1572864) != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i6 = i2 & StatusBarUtils.FLAG_NOTCH_SUPPORT;
        if (i6 == 0) {
        }
        if ((i3 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if (i6 != 0) {
        }
        j8 = j4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(-1434444789);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
        }
        InteractionSource interactionSource22222 = (MutableInteractionSource) rememberedValue;
        startRestartGroup.endReplaceGroup();
        State collectIsPressedAsState22222 = PressInteractionKt.collectIsPressedAsState(interactionSource22222, startRestartGroup, 6);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
        }
        final CoroutineScope coroutineScope22222 = (CoroutineScope) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.startReplaceGroup(-1434438906);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
        }
        final MutableState mutableState32222 = (MutableState) rememberedValue3;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(-1434436885);
        rememberedValue4 = startRestartGroup.rememberedValue();
        long j1222222 = j6;
        if (rememberedValue4 == Composer.Companion.getEmpty()) {
        }
        final MutableState mutableState222222 = (MutableState) rememberedValue4;
        startRestartGroup.endReplaceGroup();
        if (z2) {
        }
        Painter painterResource22222 = ImageResources_androidKt.painterResource(drawableResource, startRestartGroup, i3 & 14);
        startRestartGroup.startReplaceGroup(-1434419977);
        long j1422222 = j5;
        changedInstance = startRestartGroup.changedInstance(coroutineScope22222) | ((i3 & 234881024) != 67108864) | ((i3 & 896) == 256);
        Object rememberedValue522222 = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        final long j1522222 = j8;
        Function0 function0222222 = new Function0() { // from class: com.bytedance.trae.design.compose.TraePressableIconKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit TraePressableIcon_v_nKSRU$lambda$9$lambda$8;
                TraePressableIcon_v_nKSRU$lambda$9$lambda$8 = TraePressableIconKt.TraePressableIcon_v_nKSRU$lambda$9$lambda$8(coroutineScope22222, function0, mutableState222222, mutableState32222, j1522222);
                return TraePressableIcon_v_nKSRU$lambda$9$lambda$8;
            }
        };
        startRestartGroup.updateRememberedValue(function0222222);
        obj = function0222222;
        startRestartGroup.endReplaceGroup();
        ImageKt.Image(painterResource22222, str, ClickableKt.clickable-O2vRcR0$default(modifier2, interactionSource22222, (Indication) null, z2, (String) null, (Role) null, (Function0) obj, 24, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, j13, 0, 2, (Object) null), startRestartGroup, i3 & 112, 56);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        z3 = z2;
        j9 = j7;
        j10 = j8;
        j6 = j1222222;
        j11 = j1422222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final boolean TraePressableIcon_v_nKSRU$lambda$3(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TraePressableIcon_v_nKSRU$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Job TraePressableIcon_v_nKSRU$lambda$6(MutableState<Job> mutableState) {
        return (Job) ((State) mutableState).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TraePressableIcon_v_nKSRU$lambda$9$lambda$8(CoroutineScope coroutineScope, Function0 function0, MutableState mutableState, MutableState mutableState2, long j) {
        Job TraePressableIcon_v_nKSRU$lambda$6 = TraePressableIcon_v_nKSRU$lambda$6(mutableState);
        if (TraePressableIcon_v_nKSRU$lambda$6 != null) {
            Job.DefaultImpls.cancel$default(TraePressableIcon_v_nKSRU$lambda$6, (CancellationException) null, 1, (Object) null);
        }
        TraePressableIcon_v_nKSRU$lambda$4(mutableState2, true);
        mutableState.setValue(BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new TraePressableIconKt$TraePressableIcon$1$1$1(j, mutableState2, null), 3, (Object) null));
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final boolean TraePressableIcon_v_nKSRU$lambda$1(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }
}
