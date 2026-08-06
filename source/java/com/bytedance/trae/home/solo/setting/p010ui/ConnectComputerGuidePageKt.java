package com.bytedance.trae.home.solo.setting.p010ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.design.compose.TraeAnimatedGuideImageKt;
import com.bytedance.trae.home.solo.setting.data.DeviceManagementProduct;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConnectComputerGuidePage.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\r"}, d2 = {"ConnectComputerGuideHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ConnectComputerGuideVerticalPadding", "ConnectComputerGuideContent", "", "displayUrl", "", "onCopyUrl", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "impl_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConnectComputerGuidePageKt {
    private static final float ConnectComputerGuideHorizontalPadding = Dp.constructor-impl(16);
    private static final float ConnectComputerGuideVerticalPadding = Dp.constructor-impl(24);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConnectComputerGuideContent$lambda$3(String str, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ConnectComputerGuideContent(str, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ConnectComputerGuideContent(final String str, final Function0<Unit> function0, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        Object rememberedValue;
        int hashCode;
        Composer composer2;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(str, "displayUrl");
        Intrinsics.checkNotNullParameter(function0, "onCopyUrl");
        Composer startRestartGroup = composer.startRestartGroup(274879062);
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
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? StatusBarUtils.FLAG_NOTCH_SUPPORT : 128;
            if ((i3 & 147) == 146 || !startRestartGroup.getSkipping()) {
                Modifier modifier3 = i4 == 0 ? (Modifier) Modifier.Companion : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(274879062, i3, -1, "com.bytedance.trae.home.solo.setting.ui.ConnectComputerGuideContent (ConnectComputerGuidePage.kt:28)");
                }
                DeviceManagementPalette deviceManagementPalette = DeviceManagementKt.deviceManagementPalette(startRestartGroup, 0);
                Modifier modifier4 = PaddingKt.padding-VpY3zN4(ScrollKt.verticalScroll$default(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), deviceManagementPalette.m2472getBackground0d7_KjU(), (Shape) null, 2, (Object) null), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null), ConnectComputerGuideHorizontalPadding, ConnectComputerGuideVerticalPadding);
                startRestartGroup.startReplaceGroup(969526364);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.ConnectComputerGuidePageKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit ConnectComputerGuideContent$lambda$1$lambda$0;
                            ConnectComputerGuideContent$lambda$1$lambda$0 = ConnectComputerGuidePageKt.ConnectComputerGuideContent$lambda$1$lambda$0((SemanticsPropertyReceiver) obj);
                            return ConnectComputerGuideContent$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier4, false, (Function1) rememberedValue, 1, (Object) null);
                Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, startRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default);
                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor);
                } else {
                    startRestartGroup.useNode();
                }
                composer2 = Updater.constructor-impl(startRestartGroup);
                Updater.set-impl(composer2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
                    composer2.updateRememberedValue(Integer.valueOf(hashCode));
                    composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                }
                Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                TraeAnimatedGuideImageKt.m1581TraeAnimatedGuideImage6a0pyJM(DeviceManagementKt.guideHeroResource(DeviceManagementProduct.Work), SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), DeviceManagementKt.getDeviceGuideHeroHeight()), 0.0f, startRestartGroup, 48, 4);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, DeviceManagementKt.getDeviceGuideStepsGap()), startRestartGroup, 6);
                Modifier modifier5 = modifier3;
                DeviceManagementKt.GuideSteps(DeviceManagementProduct.Work, str, deviceManagementPalette, function0, startRestartGroup, ((i3 << 3) & 112) | 6 | ((i3 << 6) & 7168));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier5;
            } else {
                startRestartGroup.skipToGroupEnd();
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.ConnectComputerGuidePageKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2) {
                        Unit ConnectComputerGuideContent$lambda$3;
                        ConnectComputerGuideContent$lambda$3 = ConnectComputerGuidePageKt.ConnectComputerGuideContent$lambda$3(str, function0, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        return ConnectComputerGuideContent$lambda$3;
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i3 & 147) == 146) {
        }
        if (i4 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        DeviceManagementPalette deviceManagementPalette2 = DeviceManagementKt.deviceManagementPalette(startRestartGroup, 0);
        Modifier modifier42 = PaddingKt.padding-VpY3zN4(ScrollKt.verticalScroll$default(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), deviceManagementPalette2.m2472getBackground0d7_KjU(), (Shape) null, 2, (Object) null), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null), ConnectComputerGuideHorizontalPadding, ConnectComputerGuideVerticalPadding);
        startRestartGroup.startReplaceGroup(969526364);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier semantics$default2 = SemanticsModifierKt.semantics$default(modifier42, false, (Function1) rememberedValue, 1, (Object) null);
        Alignment.Horizontal centerHorizontally2 = Alignment.Companion.getCenterHorizontally();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally2, startRestartGroup, 48);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
        hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default2);
        Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
        }
        composer2 = Updater.constructor-impl(startRestartGroup);
        Updater.set-impl(composer2, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!composer2.getInserting()) {
        }
        composer2.updateRememberedValue(Integer.valueOf(hashCode));
        composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash2);
        Updater.set-impl(composer2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
        TraeAnimatedGuideImageKt.m1581TraeAnimatedGuideImage6a0pyJM(DeviceManagementKt.guideHeroResource(DeviceManagementProduct.Work), SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), DeviceManagementKt.getDeviceGuideHeroHeight()), 0.0f, startRestartGroup, 48, 4);
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, DeviceManagementKt.getDeviceGuideStepsGap()), startRestartGroup, 6);
        Modifier modifier52 = modifier3;
        DeviceManagementKt.GuideSteps(DeviceManagementProduct.Work, str, deviceManagementPalette2, function0, startRestartGroup, ((i3 << 3) & 112) | 6 | ((i3 << 6) & 7168));
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endNode();
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier52;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConnectComputerGuideContent$lambda$1$lambda$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, "cmp_connect_computer_guide_root");
        return Unit.INSTANCE;
    }
}
