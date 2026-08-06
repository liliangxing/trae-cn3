package androidx.compose.foundation;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.Matrix;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidExternalSurface.android.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001aZ\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0015H\u0003¢\u0006\u0002\u0010\u0016\u001aR\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"rememberAndroidExternalSurfaceState", "Landroidx/compose/foundation/AndroidExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidExternalSurfaceState;", "AndroidExternalSurface", "", "modifier", "Landroidx/compose/ui/Modifier;", "isOpaque", "", "surfaceSize", "Landroidx/compose/ui/unit/IntSize;", "zOrder", "Landroidx/compose/foundation/AndroidExternalSurfaceZOrder;", "isSecure", "onInit", "Lkotlin/Function1;", "Landroidx/compose/foundation/AndroidExternalSurfaceScope;", "Lkotlin/ExtensionFunctionType;", "AndroidExternalSurface-58FFMhA", "(Landroidx/compose/ui/Modifier;ZJIZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberAndroidEmbeddedExternalSurfaceState", "Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "AndroidEmbeddedExternalSurface", "transform", "Landroidx/compose/ui/graphics/Matrix;", "AndroidEmbeddedExternalSurface-sv6N_fY", "(Landroidx/compose/ui/Modifier;ZJ[FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class AndroidExternalSurface_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidEmbeddedExternalSurface_sv6N_fY$lambda$18(Modifier modifier, boolean z, long j, float[] fArr, Function1 function1, int i, int i2, Composer composer, int i3) {
        m390AndroidEmbeddedExternalSurfacesv6N_fY(modifier, z, j, fArr, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidExternalSurface_58FFMhA$lambda$8(Modifier modifier, boolean z, long j, int i, boolean z2, Function1 function1, int i2, int i3, Composer composer, int i4) {
        m391AndroidExternalSurface58FFMhA(modifier, z, j, i, z2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    private static final AndroidExternalSurfaceState rememberAndroidExternalSurfaceState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -873615933, "C(rememberAndroidExternalSurfaceState)188@7180L24,189@7216L47:AndroidExternalSurface.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-873615933, i, -1, "androidx.compose.foundation.rememberAndroidExternalSurfaceState (AndroidExternalSurface.android.kt:187)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart(composer, 683737348, "CC(remember):Effects.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
            composer.updateRememberedValue(rememberedValue);
        }
        CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -2026284206, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new AndroidExternalSurfaceState(coroutineScope);
            composer.updateRememberedValue(rememberedValue2);
        }
        AndroidExternalSurfaceState androidExternalSurfaceState = (AndroidExternalSurfaceState) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return androidExternalSurfaceState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0153, code lost:
    
        if (r13 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01cc, code lost:
    
        if (r12 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L133;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0141  */
    /* renamed from: AndroidExternalSurface-58FFMhA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m391AndroidExternalSurface58FFMhA(Modifier modifier, boolean z, long j, int i, boolean z2, final Function1<? super AndroidExternalSurfaceScope, Unit> function1, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        boolean z3;
        long j2;
        int i5;
        int i6;
        int i7;
        boolean z4;
        Modifier.Companion companion;
        final long j3;
        final boolean z5;
        final int i8;
        ScopeUpdateScope endRestartGroup;
        boolean z6;
        boolean z7;
        boolean changedInstance;
        Object obj;
        Object rememberedValue;
        boolean z8;
        Object obj2;
        Composer startRestartGroup = composer.startRestartGroup(640888974);
        ComposerKt.sourceInformation(startRestartGroup, "C(AndroidExternalSurface)N(modifier,isOpaque,surfaceSize:c#ui.unit.IntSize,zOrder:c#foundation.AndroidExternalSurfaceZOrder,isSecure,onInit)275@12030L37,278@12104L150,285@12303L2,286@12324L774,277@12073L1032:AndroidExternalSurface.android.kt#71ulvw");
        int i9 = i3 & 1;
        if (i9 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i4 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        int i10 = i3 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            z3 = z;
            i4 |= startRestartGroup.changed(z3) ? 32 : 16;
            if ((i2 & 384) != 0) {
                j2 = j;
                i4 |= ((i3 & 4) == 0 && startRestartGroup.changed(j2)) ? Fields.RotationX : Fields.SpotShadowColor;
            } else {
                j2 = j;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i2 & 3072) == 0) {
                i6 = i;
                i4 |= startRestartGroup.changed(i6) ? Fields.CameraDistance : Fields.RotationZ;
                i7 = i3 & 16;
                if (i7 != 0) {
                    i4 |= 24576;
                } else if ((i2 & 24576) == 0) {
                    z4 = z2;
                    i4 |= startRestartGroup.changed(z4) ? Fields.Clip : Fields.Shape;
                    if ((i3 & 32) == 0) {
                        i4 |= 196608;
                    } else if ((i2 & 196608) == 0) {
                        i4 |= startRestartGroup.changedInstance(function1) ? Fields.RenderEffect : 65536;
                    }
                    if (!startRestartGroup.shouldExecute((i4 & 74899) == 74898, i4 & 1)) {
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            companion = modifier2;
                        } else {
                            companion = i9 != 0 ? Modifier.INSTANCE : modifier2;
                            if (i10 != 0) {
                                z3 = true;
                            }
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                                j2 = IntSize.Companion.getZero-YbymL2g();
                            }
                            if (i5 != 0) {
                                i6 = AndroidExternalSurfaceZOrder.INSTANCE.m384getBehindB_4ceCc();
                            }
                            if (i7 != 0) {
                                z6 = false;
                                z7 = z3;
                                final int i11 = i6;
                                int i12 = i4;
                                final long j4 = j2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(640888974, i12, -1, "androidx.compose.foundation.AndroidExternalSurface (AndroidExternalSurface.android.kt:274)");
                                }
                                final AndroidExternalSurfaceState rememberAndroidExternalSurfaceState = rememberAndroidExternalSurfaceState(startRestartGroup, 0);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1713993732, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                                changedInstance = ((458752 & i12) != 131072) | startRestartGroup.changedInstance(rememberAndroidExternalSurfaceState);
                                Object rememberedValue2 = startRestartGroup.rememberedValue();
                                if (!changedInstance) {
                                    obj = rememberedValue2;
                                }
                                Function1 function12 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj3) {
                                        SurfaceView AndroidExternalSurface_58FFMhA$lambda$3$lambda$2;
                                        AndroidExternalSurface_58FFMhA$lambda$3$lambda$2 = AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$3$lambda$2(function1, rememberAndroidExternalSurfaceState, (Context) obj3);
                                        return AndroidExternalSurface_58FFMhA$lambda$3$lambda$2;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(function12);
                                obj = function12;
                                Function1 function13 = (Function1) obj;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1713999952, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj3) {
                                            Unit AndroidExternalSurface_58FFMhA$lambda$5$lambda$4;
                                            AndroidExternalSurface_58FFMhA$lambda$5$lambda$4 = AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$5$lambda$4((SurfaceView) obj3);
                                            return AndroidExternalSurface_58FFMhA$lambda$5$lambda$4;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                Function1 function14 = (Function1) rememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1714001396, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                                z8 = ((57344 & i12) == 16384) | ((((i12 & 896) ^ 384) <= 256 && startRestartGroup.changed(j4)) || (i12 & 384) == 256) | ((i12 & 112) != 32) | ((i12 & 7168) != 2048);
                                Object rememberedValue3 = startRestartGroup.rememberedValue();
                                if (!z8) {
                                    obj2 = rememberedValue3;
                                }
                                final boolean z9 = z7;
                                final boolean z10 = z6;
                                Function1 function15 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj3) {
                                        Unit AndroidExternalSurface_58FFMhA$lambda$7$lambda$6;
                                        AndroidExternalSurface_58FFMhA$lambda$7$lambda$6 = AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$7$lambda$6(j4, z9, i11, z10, (SurfaceView) obj3);
                                        return AndroidExternalSurface_58FFMhA$lambda$7$lambda$6;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(function15);
                                obj2 = function15;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                AndroidView_androidKt.AndroidView(function13, companion, function14, (Function1) null, (Function1) obj2, startRestartGroup, ((i12 << 3) & 112) | 384, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z3 = z7;
                                j3 = j4;
                                i8 = i11;
                                z5 = z6;
                            }
                        }
                        z7 = z3;
                        z6 = z4;
                        final int i112 = i6;
                        int i122 = i4;
                        final long j42 = j2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final AndroidExternalSurfaceState rememberAndroidExternalSurfaceState2 = rememberAndroidExternalSurfaceState(startRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1713993732, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                        changedInstance = ((458752 & i122) != 131072) | startRestartGroup.changedInstance(rememberAndroidExternalSurfaceState2);
                        Object rememberedValue22 = startRestartGroup.rememberedValue();
                        if (!changedInstance) {
                        }
                        Function1 function122 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj3) {
                                SurfaceView AndroidExternalSurface_58FFMhA$lambda$3$lambda$2;
                                AndroidExternalSurface_58FFMhA$lambda$3$lambda$2 = AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$3$lambda$2(function1, rememberAndroidExternalSurfaceState2, (Context) obj3);
                                return AndroidExternalSurface_58FFMhA$lambda$3$lambda$2;
                            }
                        };
                        startRestartGroup.updateRememberedValue(function122);
                        obj = function122;
                        Function1 function132 = (Function1) obj;
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1713999952, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        Function1 function142 = (Function1) rememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1714001396, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                        z8 = ((57344 & i122) == 16384) | ((((i122 & 896) ^ 384) <= 256 && startRestartGroup.changed(j42)) || (i122 & 384) == 256) | ((i122 & 112) != 32) | ((i122 & 7168) != 2048);
                        Object rememberedValue32 = startRestartGroup.rememberedValue();
                        if (!z8) {
                        }
                        final boolean z92 = z7;
                        final boolean z102 = z6;
                        Function1 function152 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj3) {
                                Unit AndroidExternalSurface_58FFMhA$lambda$7$lambda$6;
                                AndroidExternalSurface_58FFMhA$lambda$7$lambda$6 = AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$7$lambda$6(j42, z92, i112, z102, (SurfaceView) obj3);
                                return AndroidExternalSurface_58FFMhA$lambda$7$lambda$6;
                            }
                        };
                        startRestartGroup.updateRememberedValue(function152);
                        obj2 = function152;
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        AndroidView_androidKt.AndroidView(function132, companion, function142, (Function1) null, (Function1) obj2, startRestartGroup, ((i122 << 3) & 112) | 384, 8);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        z3 = z7;
                        j3 = j42;
                        i8 = i112;
                        z5 = z6;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        companion = modifier2;
                        j3 = j2;
                        z5 = z4;
                        i8 = i6;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Modifier modifier3 = companion;
                        final boolean z11 = z3;
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj3, Object obj4) {
                                Unit AndroidExternalSurface_58FFMhA$lambda$8;
                                AndroidExternalSurface_58FFMhA$lambda$8 = AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$8(Modifier.this, z11, j3, i8, z5, function1, i2, i3, (Composer) obj3, ((Integer) obj4).intValue());
                                return AndroidExternalSurface_58FFMhA$lambda$8;
                            }
                        });
                        return;
                    }
                    return;
                }
                z4 = z2;
                if ((i3 & 32) == 0) {
                }
                if (!startRestartGroup.shouldExecute((i4 & 74899) == 74898, i4 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i6 = i;
            i7 = i3 & 16;
            if (i7 != 0) {
            }
            z4 = z2;
            if ((i3 & 32) == 0) {
            }
            if (!startRestartGroup.shouldExecute((i4 & 74899) == 74898, i4 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        z3 = z;
        if ((i2 & 384) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        i6 = i;
        i7 = i3 & 16;
        if (i7 != 0) {
        }
        z4 = z2;
        if ((i3 & 32) == 0) {
        }
        if (!startRestartGroup.shouldExecute((i4 & 74899) == 74898, i4 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SurfaceView AndroidExternalSurface_58FFMhA$lambda$3$lambda$2(Function1 function1, AndroidExternalSurfaceState androidExternalSurfaceState, Context context) {
        SurfaceView surfaceView = new SurfaceView(context);
        function1.invoke(androidExternalSurfaceState);
        surfaceView.getHolder().addCallback(androidExternalSurfaceState);
        return surfaceView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidExternalSurface_58FFMhA$lambda$5$lambda$4(SurfaceView surfaceView) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidExternalSurface_58FFMhA$lambda$7$lambda$6(long j, boolean z, int i, boolean z2, SurfaceView surfaceView) {
        if (!IntSize.equals-impl0(j, IntSize.Companion.getZero-YbymL2g())) {
            surfaceView.getHolder().setFixedSize((int) (j >> 32), (int) (j & 4294967295L));
        } else {
            surfaceView.getHolder().setSizeFromLayout();
        }
        surfaceView.getHolder().setFormat(z ? -1 : -3);
        if (AndroidExternalSurfaceZOrder.m380equalsimpl0(i, AndroidExternalSurfaceZOrder.INSTANCE.m384getBehindB_4ceCc())) {
            surfaceView.setZOrderOnTop(false);
        } else if (AndroidExternalSurfaceZOrder.m380equalsimpl0(i, AndroidExternalSurfaceZOrder.INSTANCE.m385getMediaOverlayB_4ceCc())) {
            surfaceView.setZOrderMediaOverlay(true);
        } else if (AndroidExternalSurfaceZOrder.m380equalsimpl0(i, AndroidExternalSurfaceZOrder.INSTANCE.m386getOnTopB_4ceCc())) {
            surfaceView.setZOrderOnTop(true);
        }
        surfaceView.setSecure(z2);
        return Unit.INSTANCE;
    }

    private static final AndroidEmbeddedExternalSurfaceState rememberAndroidEmbeddedExternalSurfaceState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1057437053, "C(rememberAndroidEmbeddedExternalSurfaceState)371@14901L24,372@14937L55:AndroidExternalSurface.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1057437053, i, -1, "androidx.compose.foundation.rememberAndroidEmbeddedExternalSurfaceState (AndroidExternalSurface.android.kt:370)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart(composer, 683737348, "CC(remember):Effects.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
            composer.updateRememberedValue(rememberedValue);
        }
        CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1710246426, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new AndroidEmbeddedExternalSurfaceState(coroutineScope);
            composer.updateRememberedValue(rememberedValue2);
        }
        AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState = (AndroidEmbeddedExternalSurfaceState) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return androidEmbeddedExternalSurfaceState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0198, code lost:
    
        if (r11 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L119;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x008a  */
    /* renamed from: AndroidEmbeddedExternalSurface-sv6N_fY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m390AndroidEmbeddedExternalSurfacesv6N_fY(Modifier modifier, boolean z, long j, float[] fArr, final Function1<? super AndroidExternalSurfaceScope, Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        boolean z2;
        long j2;
        int i4;
        final float[] fArr2;
        Modifier.Companion companion;
        final long j3;
        ScopeUpdateScope endRestartGroup;
        float[] fArr3;
        boolean z3;
        Object rememberedValue;
        Object rememberedValue2;
        boolean changedInstance;
        Object obj;
        Composer startRestartGroup = composer.startRestartGroup(217541314);
        ComposerKt.sourceInformation(startRestartGroup, "C(AndroidEmbeddedExternalSurface)N(modifier,isOpaque,surfaceSize:c#ui.unit.IntSize,transform:c#ui.graphics.Matrix,onInit)433@18602L45,436@18684L19,438@18752L2,439@18773L639,435@18653L766:AndroidExternalSurface.android.kt#71ulvw");
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            z2 = z;
            i3 |= startRestartGroup.changed(z2) ? 32 : 16;
            if ((i & 384) != 0) {
                j2 = j;
                i3 |= ((i2 & 4) == 0 && startRestartGroup.changed(j2)) ? 256 : Fields.SpotShadowColor;
            } else {
                j2 = j;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changedInstance(fArr != null ? Matrix.m5080boximpl(fArr) : null) ? Fields.CameraDistance : Fields.RotationZ;
            }
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                i3 |= startRestartGroup.changedInstance(function1) ? Fields.Clip : Fields.Shape;
                if (startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        fArr3 = fArr;
                        companion = modifier2;
                    } else {
                        companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            j2 = IntSize.Companion.getZero-YbymL2g();
                        }
                        if (i4 != 0) {
                            z3 = z2;
                            fArr3 = null;
                            int i7 = i3;
                            final long j4 = j2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(217541314, i7, -1, "androidx.compose.foundation.AndroidEmbeddedExternalSurface (AndroidExternalSurface.android.kt:432)");
                            }
                            final AndroidEmbeddedExternalSurfaceState rememberAndroidEmbeddedExternalSurfaceState = rememberAndroidEmbeddedExternalSurfaceState(startRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1396183883, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda4
                                    public final Object invoke(Object obj2) {
                                        TextureView AndroidEmbeddedExternalSurface_sv6N_fY$lambda$11$lambda$10;
                                        AndroidEmbeddedExternalSurface_sv6N_fY$lambda$11$lambda$10 = AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$11$lambda$10((Context) obj2);
                                        return AndroidEmbeddedExternalSurface_sv6N_fY$lambda$11$lambda$10;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            Function1 function12 = (Function1) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1396181724, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda5
                                    public final Object invoke(Object obj2) {
                                        Unit AndroidEmbeddedExternalSurface_sv6N_fY$lambda$13$lambda$12;
                                        AndroidEmbeddedExternalSurface_sv6N_fY$lambda$13$lambda$12 = AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$13$lambda$12((TextureView) obj2);
                                        return AndroidEmbeddedExternalSurface_sv6N_fY$lambda$13$lambda$12;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            Function1 function13 = (Function1) rememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1396180415, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                            changedInstance = ((((i7 & 896) ^ 384) <= 256 && startRestartGroup.changed(j4)) || (i7 & 384) == 256) | startRestartGroup.changedInstance(rememberAndroidEmbeddedExternalSurfaceState) | ((57344 & i7) != 16384) | ((i7 & 112) != 32) | startRestartGroup.changedInstance(fArr3 == null ? Matrix.m5080boximpl(fArr3) : null);
                            Object rememberedValue3 = startRestartGroup.rememberedValue();
                            if (!changedInstance) {
                                obj = rememberedValue3;
                            }
                            final boolean z4 = z3;
                            final float[] fArr4 = fArr3;
                            Function1 function14 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda6
                                public final Object invoke(Object obj2) {
                                    Unit AndroidEmbeddedExternalSurface_sv6N_fY$lambda$17$lambda$16;
                                    AndroidEmbeddedExternalSurface_sv6N_fY$lambda$17$lambda$16 = AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$17$lambda$16(j4, rememberAndroidEmbeddedExternalSurfaceState, function1, z4, fArr4, (TextureView) obj2);
                                    return AndroidEmbeddedExternalSurface_sv6N_fY$lambda$17$lambda$16;
                                }
                            };
                            startRestartGroup.updateRememberedValue(function14);
                            obj = function14;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            AndroidView_androidKt.AndroidView(function12, companion, function13, (Function1) null, (Function1) obj, startRestartGroup, ((i7 << 3) & 112) | 390, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z2 = z3;
                            j3 = j4;
                            fArr2 = fArr3;
                        } else {
                            fArr3 = fArr;
                        }
                    }
                    z3 = z2;
                    int i72 = i3;
                    final long j42 = j2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final AndroidEmbeddedExternalSurfaceState rememberAndroidEmbeddedExternalSurfaceState2 = rememberAndroidEmbeddedExternalSurfaceState(startRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1396183883, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    Function1 function122 = (Function1) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1396181724, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    }
                    Function1 function132 = (Function1) rememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1396180415, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                    changedInstance = ((((i72 & 896) ^ 384) <= 256 && startRestartGroup.changed(j42)) || (i72 & 384) == 256) | startRestartGroup.changedInstance(rememberAndroidEmbeddedExternalSurfaceState2) | ((57344 & i72) != 16384) | ((i72 & 112) != 32) | startRestartGroup.changedInstance(fArr3 == null ? Matrix.m5080boximpl(fArr3) : null);
                    Object rememberedValue32 = startRestartGroup.rememberedValue();
                    if (!changedInstance) {
                    }
                    final boolean z42 = z3;
                    final float[] fArr42 = fArr3;
                    Function1 function142 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj2) {
                            Unit AndroidEmbeddedExternalSurface_sv6N_fY$lambda$17$lambda$16;
                            AndroidEmbeddedExternalSurface_sv6N_fY$lambda$17$lambda$16 = AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$17$lambda$16(j42, rememberAndroidEmbeddedExternalSurfaceState2, function1, z42, fArr42, (TextureView) obj2);
                            return AndroidEmbeddedExternalSurface_sv6N_fY$lambda$17$lambda$16;
                        }
                    };
                    startRestartGroup.updateRememberedValue(function142);
                    obj = function142;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    AndroidView_androidKt.AndroidView(function122, companion, function132, (Function1) null, (Function1) obj, startRestartGroup, ((i72 << 3) & 112) | 390, 8);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z2 = z3;
                    j3 = j42;
                    fArr2 = fArr3;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    fArr2 = fArr;
                    companion = modifier2;
                    j3 = j2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier3 = companion;
                    final boolean z5 = z2;
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda7
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit AndroidEmbeddedExternalSurface_sv6N_fY$lambda$18;
                            AndroidEmbeddedExternalSurface_sv6N_fY$lambda$18 = AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$18(Modifier.this, z5, j3, fArr2, function1, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                            return AndroidEmbeddedExternalSurface_sv6N_fY$lambda$18;
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
        z2 = z;
        if ((i & 384) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextureView AndroidEmbeddedExternalSurface_sv6N_fY$lambda$11$lambda$10(Context context) {
        return new TextureView(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidEmbeddedExternalSurface_sv6N_fY$lambda$13$lambda$12(TextureView textureView) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidEmbeddedExternalSurface_sv6N_fY$lambda$17$lambda$16(long j, AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState, Function1 function1, boolean z, float[] fArr, TextureView textureView) {
        android.graphics.Matrix matrix;
        SurfaceTexture surfaceTexture;
        if (!IntSize.equals-impl0(j, IntSize.Companion.getZero-YbymL2g()) && (surfaceTexture = textureView.getSurfaceTexture()) != null) {
            surfaceTexture.setDefaultBufferSize((int) (j >> 32), (int) (4294967295L & j));
        }
        androidEmbeddedExternalSurfaceState.m376setSurfaceSizeozmzZPI(j);
        if (textureView.getSurfaceTextureListener() != androidEmbeddedExternalSurfaceState) {
            function1.invoke(androidEmbeddedExternalSurfaceState);
            textureView.setSurfaceTextureListener(androidEmbeddedExternalSurfaceState);
        }
        textureView.setOpaque(z);
        if (fArr != null) {
            matrix = androidEmbeddedExternalSurfaceState.getMatrix();
            AndroidMatrixConversions_androidKt.m4705setFromEL8BTi8(matrix, fArr);
        } else {
            matrix = null;
        }
        textureView.setTransform(matrix);
        return Unit.INSTANCE;
    }
}
