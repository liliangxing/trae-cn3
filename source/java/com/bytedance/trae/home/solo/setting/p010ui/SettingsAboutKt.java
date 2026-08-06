package com.bytedance.trae.home.solo.setting.p010ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.design.compose.TraeTheme;
import com.bytedance.trae.design.compose.TraeTypography;
import com.bytedance.trae.home.generated.resources.Drawable0_commonMainKt;
import com.bytedance.trae.home.generated.resources.Res;
import com.bytedance.trae.home.generated.resources.String0_commonMainKt;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItem;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItemKey;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutState;
import com.bytedance.trae.kmp.ui.KmpClickHandler;
import com.bytedance.trae.kmp.ui.KmpStringResource_androidKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.ImageResources_androidKt;
import org.jetbrains.compose.resources.StringResource;

/* compiled from: SettingsAbout.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\nH\u0007¢\u0006\u0002\u0010\r\u001a\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010\u0011\u001a=\u0010\u0012\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\nH\u0003¢\u0006\u0002\u0010\u0015\u001a7\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\nH\u0003¢\u0006\u0002\u0010\u0019\u001a\f\u0010\u001a\u001a\u00020\u001b*\u00020\u001cH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u001d"}, d2 = {"AboutItemHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SettingsAboutContent", "", "state", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;", "modifier", "Landroidx/compose/ui/Modifier;", "onItemClick", "Lkotlin/Function2;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;", "", "(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "AboutLogo", "colors", "Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;", "(Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;Landroidx/compose/runtime/Composer;I)V", "AboutItemsGroup", "items", "", "(Ljava/util/List;Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "AboutRow", "item", "onClick", "(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "titleResource", "Lorg/jetbrains/compose/resources/StringResource;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;", "impl_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsAboutKt {
    private static final float AboutItemHeight = Dp.constructor-impl(56);

    /* compiled from: SettingsAbout.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SettingsAboutItemKey.values().length];
            try {
                iArr[SettingsAboutItemKey.Terms.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SettingsAboutItemKey.Privacy.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SettingsAboutItemKey.OpenSource.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SettingsAboutItemKey.Help.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SettingsAboutItemKey.Community.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SettingsAboutItemKey.Contact.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SettingsAboutItemKey.PersonalInfoList.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SettingsAboutItemKey.ShareList.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[SettingsAboutItemKey.BusinessLicense.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[SettingsAboutItemKey.IcpFiling.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[SettingsAboutItemKey.PermissionUsage.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AboutItemsGroup$lambda$6(List list, SettingsEntryPalette settingsEntryPalette, Function2 function2, int i, Composer composer, int i2) {
        AboutItemsGroup(list, settingsEntryPalette, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AboutItemsGroup$lambda$9(List list, SettingsEntryPalette settingsEntryPalette, Function2 function2, int i, Composer composer, int i2) {
        AboutItemsGroup(list, settingsEntryPalette, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AboutLogo$lambda$5(SettingsEntryPalette settingsEntryPalette, int i, Composer composer, int i2) {
        AboutLogo(settingsEntryPalette, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AboutRow$lambda$14(SettingsAboutItem settingsAboutItem, SettingsEntryPalette settingsEntryPalette, Function2 function2, int i, Composer composer, int i2) {
        AboutRow(settingsAboutItem, settingsEntryPalette, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsAboutContent$lambda$3(SettingsAboutState settingsAboutState, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        SettingsAboutContent(settingsAboutState, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SettingsAboutContent(final SettingsAboutState settingsAboutState, Modifier modifier, final Function2<? super SettingsAboutItem, ? super String, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Object rememberedValue;
        int hashCode;
        Composer composer2;
        Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(settingsAboutState, "state");
        Intrinsics.checkNotNullParameter(function2, "onItemClick");
        Composer startRestartGroup = composer.startRestartGroup(170214363);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(settingsAboutState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= startRestartGroup.changedInstance(function2) ? StatusBarUtils.FLAG_NOTCH_SUPPORT : 128;
            }
            i4 = i3;
            if ((i4 & 147) == 146 || !startRestartGroup.getSkipping()) {
                Modifier modifier4 = i5 == 0 ? (Modifier) Modifier.Companion : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(170214363, i4, -1, "com.bytedance.trae.home.solo.setting.ui.SettingsAboutContent (SettingsAbout.kt:61)");
                }
                SettingsEntryPalette settingsEntryPalette = SettingsScaffoldKt.settingsEntryPalette(startRestartGroup, 0);
                float f = 16;
                Modifier modifier5 = PaddingKt.padding-VpY3zN4$default(ScrollKt.verticalScroll$default(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), settingsEntryPalette.m2527getBackground0d7_KjU(), (Shape) null, 2, (Object) null), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null), Dp.constructor-impl(f), 0.0f, 2, (Object) null);
                startRestartGroup.startReplaceGroup(-1388963199);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsAboutKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj) {
                            Unit SettingsAboutContent$lambda$1$lambda$0;
                            SettingsAboutContent$lambda$1$lambda$0 = SettingsAboutKt.SettingsAboutContent$lambda$1$lambda$0((SemanticsPropertyReceiver) obj);
                            return SettingsAboutContent$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier5, false, (Function1) rememberedValue, 1, (Object) null);
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
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), startRestartGroup, 6);
                AboutLogo(settingsEntryPalette, startRestartGroup, 0);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), startRestartGroup, 6);
                TraeTypography typography = TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable);
                modifier3 = modifier4;
                TextKt.Text--4IGK_g(settingsAboutState.getAppName(), (Modifier) null, settingsEntryPalette.m2539getPrimaryText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, typography.getHeadingXlStrong(), startRestartGroup, 0, 3120, 55290);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), startRestartGroup, 6);
                TextKt.Text--4IGK_g(KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_about_version(Res.string.INSTANCE), new Object[]{settingsAboutState.getVersionName()}, startRestartGroup, 0), (Modifier) null, settingsEntryPalette.m2541getTertiaryText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, typography.getBodySm(), startRestartGroup, 0, 0, 65530);
                float f2 = 40;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2)), startRestartGroup, 6);
                AboutItemsGroup(settingsAboutState.getItems(), settingsEntryPalette, function2, startRestartGroup, i4 & 896);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2)), startRestartGroup, 6);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier6 = modifier3;
                endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsAboutKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj, Object obj2) {
                        Unit SettingsAboutContent$lambda$3;
                        SettingsAboutContent$lambda$3 = SettingsAboutKt.SettingsAboutContent$lambda$3(SettingsAboutState.this, modifier6, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        return SettingsAboutContent$lambda$3;
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i2 & 4) == 0) {
        }
        i4 = i3;
        if ((i4 & 147) == 146) {
        }
        if (i5 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        SettingsEntryPalette settingsEntryPalette2 = SettingsScaffoldKt.settingsEntryPalette(startRestartGroup, 0);
        float f3 = 16;
        Modifier modifier52 = PaddingKt.padding-VpY3zN4$default(ScrollKt.verticalScroll$default(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), settingsEntryPalette2.m2527getBackground0d7_KjU(), (Shape) null, 2, (Object) null), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null), Dp.constructor-impl(f3), 0.0f, 2, (Object) null);
        startRestartGroup.startReplaceGroup(-1388963199);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier semantics$default2 = SemanticsModifierKt.semantics$default(modifier52, false, (Function1) rememberedValue, 1, (Object) null);
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
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), startRestartGroup, 6);
        AboutLogo(settingsEntryPalette2, startRestartGroup, 0);
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f3)), startRestartGroup, 6);
        TraeTypography typography2 = TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable);
        modifier3 = modifier4;
        TextKt.Text--4IGK_g(settingsAboutState.getAppName(), (Modifier) null, settingsEntryPalette2.m2539getPrimaryText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, typography2.getHeadingXlStrong(), startRestartGroup, 0, 3120, 55290);
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), startRestartGroup, 6);
        TextKt.Text--4IGK_g(KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_about_version(Res.string.INSTANCE), new Object[]{settingsAboutState.getVersionName()}, startRestartGroup, 0), (Modifier) null, settingsEntryPalette2.m2541getTertiaryText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, typography2.getBodySm(), startRestartGroup, 0, 0, 65530);
        float f22 = 40;
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f22)), startRestartGroup, 6);
        AboutItemsGroup(settingsAboutState.getItems(), settingsEntryPalette2, function2, startRestartGroup, i4 & 896);
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f22)), startRestartGroup, 6);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endNode();
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsAboutContent$lambda$1$lambda$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, "cmp_settings_about_root");
        return Unit.INSTANCE;
    }

    private static final void AboutLogo(final SettingsEntryPalette settingsEntryPalette, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(994506512);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(settingsEntryPalette) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(994506512, i2, -1, "com.bytedance.trae.home.solo.setting.ui.AboutLogo (SettingsAbout.kt:104)");
            }
            Modifier modifier = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(96)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(24))), settingsEntryPalette.m2538getLogoBackground0d7_KjU(), (Shape) null, 2, (Object) null);
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
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
            Composer composer2 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
                composer2.updateRememberedValue(Integer.valueOf(hashCode));
                composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ImageKt.Image(ImageResources_androidKt.painterResource(Drawable0_commonMainKt.getCmp_ic_setting_trae_color(Res.drawable.INSTANCE), startRestartGroup, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(64)), (Alignment) null, ContentScale.Companion.getFit(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, 104);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsAboutKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit AboutLogo$lambda$5;
                    AboutLogo$lambda$5 = SettingsAboutKt.AboutLogo$lambda$5(SettingsEntryPalette.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AboutLogo$lambda$5;
                }
            });
        }
    }

    private static final void AboutItemsGroup(final List<SettingsAboutItem> list, final SettingsEntryPalette settingsEntryPalette, final Function2<? super SettingsAboutItem, ? super String, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1623992668);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(settingsEntryPalette) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? StatusBarUtils.FLAG_NOTCH_SUPPORT : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1623992668, i2, -1, "com.bytedance.trae.home.solo.setting.ui.AboutItemsGroup (SettingsAbout.kt:126)");
            }
            if (list.isEmpty()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsAboutKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj, Object obj2) {
                            Unit AboutItemsGroup$lambda$6;
                            AboutItemsGroup$lambda$6 = SettingsAboutKt.AboutItemsGroup$lambda$6(list, settingsEntryPalette, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                            return AboutItemsGroup$lambda$6;
                        }
                    });
                    return;
                }
                return;
            }
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16))), settingsEntryPalette.m2540getSurface0d7_KjU(), (Shape) null, 2, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
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
            Composer composer2 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
                composer2.updateRememberedValue(Integer.valueOf(hashCode));
                composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-1910951697);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                AboutRow((SettingsAboutItem) it.next(), settingsEntryPalette, function2, startRestartGroup, (i2 & 112) | (i2 & 896));
            }
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsAboutKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit AboutItemsGroup$lambda$9;
                    AboutItemsGroup$lambda$9 = SettingsAboutKt.AboutItemsGroup$lambda$9(list, settingsEntryPalette, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AboutItemsGroup$lambda$9;
                }
            });
        }
    }

    private static final void AboutRow(final SettingsAboutItem settingsAboutItem, final SettingsEntryPalette settingsEntryPalette, final Function2<? super SettingsAboutItem, ? super String, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1426957212);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(settingsAboutItem) : startRestartGroup.changedInstance(settingsAboutItem) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(settingsEntryPalette) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1426957212, i2, -1, "com.bytedance.trae.home.solo.setting.ui.AboutRow (SettingsAbout.kt:150)");
            }
            TraeTypography typography = TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable);
            final String kmpStringResource = KmpStringResource_androidKt.kmpStringResource(titleResource(settingsAboutItem.getKey()), new Object[0], startRestartGroup, 0);
            SettingsAboutItemKey key = settingsAboutItem.getKey();
            startRestartGroup.startReplaceGroup(456372021);
            boolean changed = startRestartGroup.changed(key);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new KmpClickHandler((Function0) null, 1, (DefaultConstructorMarker) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            KmpClickHandler kmpClickHandler = (KmpClickHandler) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), AboutItemHeight);
            startRestartGroup.startReplaceGroup(456378021);
            boolean changed2 = ((i2 & 896) == 256) | ((i2 & 14) == 4 || ((i2 & 8) != 0 && startRestartGroup.changedInstance(settingsAboutItem))) | startRestartGroup.changed(kmpStringResource);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsAboutKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit AboutRow$lambda$12$lambda$11;
                        AboutRow$lambda$12$lambda$11 = SettingsAboutKt.AboutRow$lambda$12$lambda$11(function2, settingsAboutItem, kmpStringResource);
                        return AboutRow$lambda$12$lambda$11;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            float f = 16;
            Modifier modifier2 = PaddingKt.padding-VpY3zN4$default(SettingsScaffoldKt.noRippleClickable(modifier, kmpClickHandler, (Function0) rememberedValue2), Dp.constructor-impl(f), 0.0f, 2, (Object) null);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier2);
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
            Composer composer3 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer3, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode))) {
                composer3.updateRememberedValue(Integer.valueOf(hashCode));
                composer3.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.set-impl(composer3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            TextKt.Text--4IGK_g(kmpStringResource, RowScope.weight$default(RowScopeInstance.INSTANCE, Modifier.Companion, 1.0f, false, 2, (Object) null), settingsEntryPalette.m2539getPrimaryText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, typography.getBodyBase(), startRestartGroup, 0, 3120, 55288);
            composer2 = startRestartGroup;
            ImageKt.Image(ImageResources_androidKt.painterResource(Drawable0_commonMainKt.getCmp_ic_setting_chevron_right(Res.drawable.INSTANCE), composer2, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, settingsEntryPalette.m2537getIconTertiary0d7_KjU(), 0, 2, (Object) null), composer2, 432, 56);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsAboutKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AboutRow$lambda$14;
                    AboutRow$lambda$14 = SettingsAboutKt.AboutRow$lambda$14(SettingsAboutItem.this, settingsEntryPalette, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AboutRow$lambda$14;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AboutRow$lambda$12$lambda$11(Function2 function2, SettingsAboutItem settingsAboutItem, String str) {
        function2.invoke(settingsAboutItem, str);
        return Unit.INSTANCE;
    }

    private static final StringResource titleResource(SettingsAboutItemKey settingsAboutItemKey) {
        switch (WhenMappings.$EnumSwitchMapping$0[settingsAboutItemKey.ordinal()]) {
            case 1:
                return String0_commonMainKt.getTrae_setting_about_terms(Res.string.INSTANCE);
            case 2:
                return String0_commonMainKt.getTrae_setting_about_privacy(Res.string.INSTANCE);
            case 3:
                return String0_commonMainKt.getTrae_setting_about_opensource(Res.string.INSTANCE);
            case 4:
                return String0_commonMainKt.getTrae_setting_about_help(Res.string.INSTANCE);
            case 5:
                return String0_commonMainKt.getTrae_setting_about_community(Res.string.INSTANCE);
            case 6:
                return String0_commonMainKt.getTrae_setting_about_contact(Res.string.INSTANCE);
            case 7:
                return String0_commonMainKt.getTrae_setting_personal_info_list(Res.string.INSTANCE);
            case 8:
                return String0_commonMainKt.getTrae_setting_share_list(Res.string.INSTANCE);
            case 9:
                return String0_commonMainKt.getTrae_setting_business_license(Res.string.INSTANCE);
            case 10:
                return String0_commonMainKt.getTrae_setting_about_icp_filing(Res.string.INSTANCE);
            case 11:
                return String0_commonMainKt.getTrae_setting_about_permission_usage(Res.string.INSTANCE);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
