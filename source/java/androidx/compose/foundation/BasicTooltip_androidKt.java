package androidx.compose.foundation;

import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: BasicTooltip.android.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001ac\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"BasicTooltipBoxAndroid", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "state", "Landroidx/compose/foundation/BasicTooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "focusable", "", "enableUserInput", "content", "BasicTooltipBox", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/BasicTooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class BasicTooltip_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTooltipBoxAndroid$lambda$0(PopupPositionProvider popupPositionProvider, Function2 function2, BasicTooltipState basicTooltipState, Modifier modifier, boolean z, boolean z2, Function2 function22, int i, int i2, Composer composer, int i3) {
        BasicTooltipBox(popupPositionProvider, function2, basicTooltipState, modifier, z, z2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0051  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void BasicTooltipBox(final PopupPositionProvider popupPositionProvider, final Function2 function2, final BasicTooltipState basicTooltipState, Modifier modifier, boolean z, boolean z2, final Function2 function22, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        boolean z4;
        Modifier.Companion companion;
        boolean z5;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1368136524);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicTooltipBoxAndroid)N(positionProvider,tooltip,state,modifier,focusable,enableUserInput,content)62@2703L247:BasicTooltip.android.kt#71ulvw");
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
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= startRestartGroup.changed(basicTooltipState) ? Fields.RotationX : Fields.SpotShadowColor;
                i4 = i2 & 8;
                if (i4 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    modifier2 = modifier;
                    i3 |= startRestartGroup.changed(modifier2) ? Fields.CameraDistance : Fields.RotationZ;
                    i5 = i2 & 16;
                    if (i5 == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        z3 = z;
                        i3 |= startRestartGroup.changed(z3) ? Fields.Clip : Fields.Shape;
                        i6 = i2 & 32;
                        if (i6 != 0) {
                            i3 |= 196608;
                        } else if ((196608 & i) == 0) {
                            z4 = z2;
                            i3 |= startRestartGroup.changed(z4) ? Fields.RenderEffect : 65536;
                            if ((i2 & 64) == 0) {
                                i3 |= 1572864;
                            } else if ((i & 1572864) == 0) {
                                i3 |= startRestartGroup.changedInstance(function22) ? 1048576 : Fields.BlendMode;
                            }
                            if (startRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
                                startRestartGroup.skipToGroupEnd();
                                companion = modifier2;
                                z5 = z3;
                            } else {
                                companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                                z5 = i5 != 0 ? true : z3;
                                boolean z6 = i6 != 0 ? true : z4;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1368136524, i3, -1, "androidx.compose.foundation.BasicTooltipBoxAndroid (BasicTooltip.android.kt:61)");
                                }
                                BasicTooltipKt.BasicTooltipBox(popupPositionProvider, function2, basicTooltipState, companion, z5, z6, function22, startRestartGroup, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z4 = z6;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                final Modifier modifier3 = companion;
                                final boolean z7 = z5;
                                final boolean z8 = z4;
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.BasicTooltip_androidKt$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit BasicTooltipBoxAndroid$lambda$0;
                                        BasicTooltipBoxAndroid$lambda$0 = BasicTooltip_androidKt.BasicTooltipBoxAndroid$lambda$0(popupPositionProvider, function2, basicTooltipState, modifier3, z7, z8, function22, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                        return BasicTooltipBoxAndroid$lambda$0;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        z4 = z2;
                        if ((i2 & 64) == 0) {
                        }
                        if (startRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    z3 = z;
                    i6 = i2 & 32;
                    if (i6 != 0) {
                    }
                    z4 = z2;
                    if ((i2 & 64) == 0) {
                    }
                    if (startRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                modifier2 = modifier;
                i5 = i2 & 16;
                if (i5 == 0) {
                }
                z3 = z;
                i6 = i2 & 32;
                if (i6 != 0) {
                }
                z4 = z2;
                if ((i2 & 64) == 0) {
                }
                if (startRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i4 = i2 & 8;
            if (i4 != 0) {
            }
            modifier2 = modifier;
            i5 = i2 & 16;
            if (i5 == 0) {
            }
            z3 = z;
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            z4 = z2;
            if ((i2 & 64) == 0) {
            }
            if (startRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i2 & 4) == 0) {
        }
        i4 = i2 & 8;
        if (i4 != 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        z3 = z;
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        z4 = z2;
        if ((i2 & 64) == 0) {
        }
        if (startRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
