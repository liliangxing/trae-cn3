package com.bytedance.trae.home.solo.setting.p010ui;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bytedance.trae.design.compose.TraeContextMenuItem;
import com.bytedance.trae.design.compose.TraeContextMenuPopupKt;
import com.bytedance.trae.design.compose.TraeContextMenuPosition;
import com.bytedance.trae.home.generated.resources.Res;
import com.bytedance.trae.home.generated.resources.String0_commonMainKt;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryState;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsGroup;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsItemKey;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode;
import com.bytedance.trae.kmp.ui.KmpClickHandler;
import com.bytedance.trae.kmp.ui.KmpStringResource_androidKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.compose.resources.StringResource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsEntry.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsEntryKt$SettingsEntryContent$3 implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ SettingsEntryPalette $colors;
    final /* synthetic */ ScrollState $contentScrollState;
    final /* synthetic */ Density $density;
    final /* synthetic */ KmpClickHandler $dismissPopupClickHandler;
    final /* synthetic */ MutableState<Dp> $languageAnchorTop$delegate;
    final /* synthetic */ MutableState<Boolean> $logoutDialogVisible$delegate;
    final /* synthetic */ Function0<Unit> $onEditProfile;
    final /* synthetic */ Function1<SettingsItemKey, Unit> $onItemClick;
    final /* synthetic */ Function1<String, Unit> $onLanguageSelected;
    final /* synthetic */ Function0<Unit> $onOpenAbout;
    final /* synthetic */ Function0<Unit> $onOpenDeviceManagement;
    final /* synthetic */ Function1<SettingsThemeMode, Unit> $onThemeSelected;
    final /* synthetic */ MutableState<SettingsPopupType> $popupType$delegate;
    final /* synthetic */ SettingsEntryState $state;
    final /* synthetic */ MutableState<Dp> $themeAnchorTop$delegate;

    /* compiled from: SettingsEntry.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SettingsItemKey.values().length];
            try {
                iArr[SettingsItemKey.Theme.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SettingsItemKey.Language.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SettingsItemKey.About.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SettingsItemKey.DeviceManagement.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SettingsItemKey.Logout.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SettingsPopupType.values().length];
            try {
                iArr2[SettingsPopupType.Theme.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[SettingsPopupType.Language.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public SettingsEntryKt$SettingsEntryContent$3(ScrollState scrollState, SettingsEntryState settingsEntryState, SettingsEntryPalette settingsEntryPalette, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function1<? super SettingsItemKey, Unit> function1, Density density, MutableState<SettingsPopupType> mutableState, MutableState<Boolean> mutableState2, MutableState<Dp> mutableState3, MutableState<Dp> mutableState4, KmpClickHandler kmpClickHandler, Function1<? super SettingsThemeMode, Unit> function12, Function1<? super String, Unit> function13) {
        this.$contentScrollState = scrollState;
        this.$state = settingsEntryState;
        this.$colors = settingsEntryPalette;
        this.$onEditProfile = function0;
        this.$onOpenAbout = function02;
        this.$onOpenDeviceManagement = function03;
        this.$onItemClick = function1;
        this.$density = density;
        this.$popupType$delegate = mutableState;
        this.$logoutDialogVisible$delegate = mutableState2;
        this.$themeAnchorTop$delegate = mutableState3;
        this.$languageAnchorTop$delegate = mutableState4;
        this.$dismissPopupClickHandler = kmpClickHandler;
        this.$onThemeSelected = function12;
        this.$onLanguageSelected = function13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x0496, code lost:
    
        if (r11 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L102;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v21, types: [com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda3, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r15v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v13, types: [com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda2, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v14 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i) {
        SettingsPopupType SettingsEntryContent$lambda$1;
        float SettingsEntryContent$lambda$4;
        float f;
        float f2;
        float f3;
        List popupOptions;
        ArrayList arrayList;
        StringResource titleResource;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        Object obj;
        final MutableState<SettingsPopupType> mutableState;
        final MutableState<Dp> mutableState2;
        final MutableState<Dp> mutableState3;
        Intrinsics.checkNotNullParameter(boxWithConstraintsScope, "$this$BoxWithConstraints");
        int i2 = (i & 6) == 0 ? i | (composer.changed(boxWithConstraintsScope) ? 4 : 2) : i;
        if ((i2 & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-108097301, i2, -1, "com.bytedance.trae.home.solo.setting.ui.SettingsEntryContent.<anonymous> (SettingsEntry.kt:190)");
            }
            Modifier modifier = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), this.$contentScrollState, false, (FlingBehavior) null, false, 14, (Object) null), Dp.constructor-impl(16), 0.0f, 2, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(24), 7, (Object) null);
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            SettingsEntryState settingsEntryState = this.$state;
            SettingsEntryPalette settingsEntryPalette = this.$colors;
            Function0<Unit> function0 = this.$onEditProfile;
            Function0<Unit> function02 = this.$onOpenAbout;
            Function0<Unit> function03 = this.$onOpenDeviceManagement;
            Function1<SettingsItemKey, Unit> function1 = this.$onItemClick;
            final Density density = this.$density;
            MutableState<SettingsPopupType> mutableState4 = this.$popupType$delegate;
            final MutableState<Boolean> mutableState5 = this.$logoutDialogVisible$delegate;
            MutableState<Dp> mutableState6 = this.$themeAnchorTop$delegate;
            MutableState<Dp> mutableState7 = this.$languageAnchorTop$delegate;
            MutableState<SettingsPopupType> mutableState8 = mutableState4;
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            MutableState<Dp> mutableState9 = mutableState6;
            MutableState<Dp> mutableState10 = mutableState7;
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
            Updater.set-impl(composer2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
                composer2.updateRememberedValue(Integer.valueOf(hashCode));
                composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            SettingsEntryKt.ProfileHeader(settingsEntryState, settingsEntryPalette, function0, composer, 0);
            composer.startReplaceGroup(540051626);
            for (SettingsGroup settingsGroup : settingsEntryState.getGroups()) {
                String messageUnreadBadge = settingsEntryState.getMessageUnreadBadge();
                composer.startReplaceGroup(2084059247);
                boolean changed = composer.changed(function02) | composer.changed(function03) | composer.changed(function1);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    mutableState = mutableState8;
                    final Function0<Unit> function04 = function02;
                    final Function0<Unit> function05 = function03;
                    final Function1<SettingsItemKey, Unit> function12 = function1;
                    rememberedValue = new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj2) {
                            Unit invoke$lambda$6$lambda$5$lambda$1$lambda$0;
                            invoke$lambda$6$lambda$5$lambda$1$lambda$0 = SettingsEntryKt$SettingsEntryContent$3.invoke$lambda$6$lambda$5$lambda$1$lambda$0(function04, function05, function12, mutableState, mutableState5, (SettingsItemKey) obj2);
                            return invoke$lambda$6$lambda$5$lambda$1$lambda$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                } else {
                    mutableState = mutableState8;
                }
                Function1 function13 = (Function1) rememberedValue;
                composer.endReplaceGroup();
                composer.startReplaceGroup(2084081973);
                boolean changed2 = composer.changed(density);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    mutableState2 = mutableState9;
                    mutableState3 = mutableState10;
                    rememberedValue2 = new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit invoke$lambda$6$lambda$5$lambda$4$lambda$3;
                            invoke$lambda$6$lambda$5$lambda$4$lambda$3 = SettingsEntryKt$SettingsEntryContent$3.invoke$lambda$6$lambda$5$lambda$4$lambda$3(density, mutableState2, mutableState3, (SettingsItemKey) obj2, ((Float) obj3).floatValue());
                            return invoke$lambda$6$lambda$5$lambda$4$lambda$3;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                } else {
                    mutableState2 = mutableState9;
                    mutableState3 = mutableState10;
                }
                composer.endReplaceGroup();
                SettingsEntryKt.SettingsGroupView(settingsGroup, settingsEntryPalette, messageUnreadBadge, function13, (Function2) rememberedValue2, composer, 0);
                mutableState10 = mutableState3;
                function1 = function1;
                mutableState8 = mutableState;
                function03 = function03;
                mutableState9 = mutableState2;
                density = density;
                function02 = function02;
            }
            composer.endReplaceGroup();
            SettingsEntryKt.SettingsFooter(settingsEntryState.getFooter(), settingsEntryPalette, composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            SettingsEntryContent$lambda$1 = SettingsEntryKt.SettingsEntryContent$lambda$1(this.$popupType$delegate);
            if (SettingsEntryContent$lambda$1 != null) {
                SettingsEntryState settingsEntryState2 = this.$state;
                SettingsEntryPalette settingsEntryPalette2 = this.$colors;
                final KmpClickHandler kmpClickHandler = this.$dismissPopupClickHandler;
                MutableState<Dp> mutableState11 = this.$themeAnchorTop$delegate;
                MutableState<Dp> mutableState12 = this.$languageAnchorTop$delegate;
                final Function1<SettingsThemeMode, Unit> function14 = this.$onThemeSelected;
                final MutableState<SettingsPopupType> mutableState13 = this.$popupType$delegate;
                final Function1<String, Unit> function15 = this.$onLanguageSelected;
                int i3 = WhenMappings.$EnumSwitchMapping$1[SettingsEntryContent$lambda$1.ordinal()];
                if (i3 == 1) {
                    SettingsEntryContent$lambda$4 = SettingsEntryKt.SettingsEntryContent$lambda$4(mutableState11);
                } else if (i3 == 2) {
                    SettingsEntryContent$lambda$4 = SettingsEntryKt.SettingsEntryContent$lambda$7(mutableState12);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                f = SettingsEntryKt.SettingsPopupAnchorYOffset;
                float f9 = Dp.constructor-impl(SettingsEntryContent$lambda$4 + f);
                float f10 = boxWithConstraintsScope.getMaxWidth-D9Ej5fM();
                f2 = SettingsEntryKt.SettingsPopupEndMargin;
                float f11 = Dp.constructor-impl(f10 - f2);
                f3 = SettingsEntryKt.SettingsPopupWidth;
                float f12 = RangesKt.coerceAtLeast(Dp.box-impl(Dp.constructor-impl(f11 - f3)), Dp.box-impl(Dp.constructor-impl(0))).unbox-impl();
                int i4 = WhenMappings.$EnumSwitchMapping$1[SettingsEntryContent$lambda$1.ordinal()];
                if (i4 == 1) {
                    composer.startReplaceGroup(-436328641);
                    popupOptions = SettingsEntryKt.popupOptions(settingsEntryState2.getThemeMode());
                    List<SettingsThemeMode> list = popupOptions;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (final SettingsThemeMode settingsThemeMode : list) {
                        composer.startReplaceGroup(2084116683);
                        boolean changed3 = composer.changed(settingsThemeMode);
                        Object rememberedValue3 = composer.rememberedValue();
                        if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = new KmpClickHandler((Function0) null, 1, (DefaultConstructorMarker) null);
                            composer.updateRememberedValue(rememberedValue3);
                        }
                        final KmpClickHandler kmpClickHandler2 = (KmpClickHandler) rememberedValue3;
                        composer.endReplaceGroup();
                        String str = "theme_" + settingsThemeMode.name();
                        titleResource = SettingsEntryKt.titleResource(settingsThemeMode);
                        String kmpStringResource = KmpStringResource_androidKt.kmpStringResource(titleResource, new Object[0], composer, 0);
                        composer.startReplaceGroup(2084124950);
                        boolean changedInstance = composer.changedInstance(kmpClickHandler2) | composer.changed(function14) | composer.changed(settingsThemeMode);
                        Function0 rememberedValue4 = composer.rememberedValue();
                        if (changedInstance || rememberedValue4 == Composer.Companion.getEmpty()) {
                            rememberedValue4 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda2
                                public final Object invoke() {
                                    Unit invoke$lambda$20$lambda$11$lambda$10$lambda$9;
                                    invoke$lambda$20$lambda$11$lambda$10$lambda$9 = SettingsEntryKt$SettingsEntryContent$3.invoke$lambda$20$lambda$11$lambda$10$lambda$9(kmpClickHandler2, function14, settingsThemeMode, mutableState13);
                                    return invoke$lambda$20$lambda$11$lambda$10$lambda$9;
                                }
                            };
                            composer.updateRememberedValue((Object) rememberedValue4);
                        }
                        composer.endReplaceGroup();
                        arrayList2.add(new TraeContextMenuItem(str, kmpStringResource, rememberedValue4, null, null, null, null, null, 248, null));
                    }
                    arrayList = arrayList2;
                    composer.endReplaceGroup();
                } else {
                    if (i4 != 2) {
                        composer.startReplaceGroup(540112318);
                        composer.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composer.startReplaceGroup(-435419194);
                    List<Pair> listOf = CollectionsKt.listOf(new Pair[]{TuplesKt.to("zh", String0_commonMainKt.getTrae_setting_lang_chinese(Res.string.INSTANCE)), TuplesKt.to("en", String0_commonMainKt.getTrae_setting_lang_english(Res.string.INSTANCE)), TuplesKt.to("ja", String0_commonMainKt.getTrae_setting_lang_japanese(Res.string.INSTANCE))});
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf, 10));
                    for (Pair pair : listOf) {
                        final String str2 = (String) pair.component1();
                        StringResource stringResource = (StringResource) pair.component2();
                        composer.startReplaceGroup(2084146671);
                        boolean changed4 = composer.changed(str2);
                        Object rememberedValue5 = composer.rememberedValue();
                        if (changed4 || rememberedValue5 == Composer.Companion.getEmpty()) {
                            rememberedValue5 = new KmpClickHandler((Function0) null, 1, (DefaultConstructorMarker) null);
                            composer.updateRememberedValue(rememberedValue5);
                        }
                        final KmpClickHandler kmpClickHandler3 = (KmpClickHandler) rememberedValue5;
                        composer.endReplaceGroup();
                        String str3 = "language_" + str2;
                        String kmpStringResource2 = KmpStringResource_androidKt.kmpStringResource(stringResource, new Object[0], composer, 0);
                        composer.startReplaceGroup(2084154845);
                        boolean changedInstance2 = composer.changedInstance(kmpClickHandler3) | composer.changed(function15) | composer.changed(str2);
                        Function0 rememberedValue6 = composer.rememberedValue();
                        if (changedInstance2 || rememberedValue6 == Composer.Companion.getEmpty()) {
                            rememberedValue6 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda3
                                public final Object invoke() {
                                    Unit invoke$lambda$20$lambda$16$lambda$15$lambda$14;
                                    invoke$lambda$20$lambda$16$lambda$15$lambda$14 = SettingsEntryKt$SettingsEntryContent$3.invoke$lambda$20$lambda$16$lambda$15$lambda$14(kmpClickHandler3, function15, str2, mutableState13);
                                    return invoke$lambda$20$lambda$16$lambda$15$lambda$14;
                                }
                            };
                            composer.updateRememberedValue((Object) rememberedValue6);
                        }
                        composer.endReplaceGroup();
                        arrayList3.add(new TraeContextMenuItem(str3, kmpStringResource2, rememberedValue6, null, null, null, null, null, 248, null));
                    }
                    arrayList = arrayList3;
                    composer.endReplaceGroup();
                }
                ArrayList arrayList4 = arrayList;
                TraeContextMenuPosition.Fixed fixed = new TraeContextMenuPosition.Fixed(f12, f9, null);
                f4 = SettingsEntryKt.SettingsPopupWidth;
                f5 = SettingsEntryKt.SettingsPopupItemHeight;
                f6 = SettingsEntryKt.SettingsPopupCornerRadius;
                f7 = SettingsEntryKt.SettingsPopupElevation;
                f8 = SettingsEntryKt.SettingsPopupDividerHeight;
                long m2530getDivider0d7_KjU = settingsEntryPalette2.m2530getDivider0d7_KjU();
                long m2539getPrimaryText0d7_KjU = settingsEntryPalette2.m2539getPrimaryText0d7_KjU();
                Modifier zIndex = ZIndexModifierKt.zIndex(Modifier.Companion, 1.0f);
                TraeContextMenuPosition.Fixed fixed2 = fixed;
                composer.startReplaceGroup(540167267);
                boolean changedInstance3 = composer.changedInstance(kmpClickHandler);
                Object rememberedValue7 = composer.rememberedValue();
                if (!changedInstance3) {
                    obj = rememberedValue7;
                }
                Function0 function06 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit invoke$lambda$20$lambda$19$lambda$18;
                        invoke$lambda$20$lambda$19$lambda$18 = SettingsEntryKt$SettingsEntryContent$3.invoke$lambda$20$lambda$19$lambda$18(kmpClickHandler, mutableState13);
                        return invoke$lambda$20$lambda$19$lambda$18;
                    }
                };
                composer.updateRememberedValue(function06);
                obj = function06;
                composer.endReplaceGroup();
                TraeContextMenuPopupKt.m1846TraeContextMenuPopup_G194Zc(arrayList4, fixed2, (Function0) obj, zIndex, f4, f5, f6, f7, f8, false, false, false, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, m2530getDivider0d7_KjU, m2539getPrimaryText0d7_KjU, 0L, null, composer, 115043328, 0, 0, 6815232);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$6$lambda$5$lambda$1$lambda$0(Function0 function0, Function0 function02, Function1 function1, MutableState mutableState, MutableState mutableState2, SettingsItemKey settingsItemKey) {
        Intrinsics.checkNotNullParameter(settingsItemKey, "key");
        int i = WhenMappings.$EnumSwitchMapping$0[settingsItemKey.ordinal()];
        if (i == 1) {
            mutableState.setValue(SettingsPopupType.Theme);
        } else if (i == 2) {
            mutableState.setValue(SettingsPopupType.Language);
        } else if (i == 3) {
            function0.invoke();
        } else if (i == 4) {
            function02.invoke();
        } else if (i == 5) {
            function1.invoke(settingsItemKey);
            SettingsEntryKt.SettingsEntryContent$lambda$11(mutableState2, true);
        } else {
            function1.invoke(settingsItemKey);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$6$lambda$5$lambda$4$lambda$3(Density density, MutableState mutableState, MutableState mutableState2, SettingsItemKey settingsItemKey, float f) {
        Intrinsics.checkNotNullParameter(settingsItemKey, "key");
        float f2 = density.toDp-u2uoSUM(f);
        int i = WhenMappings.$EnumSwitchMapping$0[settingsItemKey.ordinal()];
        if (i == 1) {
            SettingsEntryKt.SettingsEntryContent$lambda$5(mutableState, f2);
        } else if (i == 2) {
            SettingsEntryKt.SettingsEntryContent$lambda$8(mutableState2, f2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$20$lambda$11$lambda$10$lambda$9(KmpClickHandler kmpClickHandler, final Function1 function1, final SettingsThemeMode settingsThemeMode, final MutableState mutableState) {
        kmpClickHandler.tryHandle(new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda7
            public final Object invoke() {
                Unit invoke$lambda$20$lambda$11$lambda$10$lambda$9$lambda$8;
                invoke$lambda$20$lambda$11$lambda$10$lambda$9$lambda$8 = SettingsEntryKt$SettingsEntryContent$3.invoke$lambda$20$lambda$11$lambda$10$lambda$9$lambda$8(function1, settingsThemeMode, mutableState);
                return invoke$lambda$20$lambda$11$lambda$10$lambda$9$lambda$8;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$20$lambda$11$lambda$10$lambda$9$lambda$8(Function1 function1, SettingsThemeMode settingsThemeMode, MutableState mutableState) {
        mutableState.setValue(null);
        function1.invoke(settingsThemeMode);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$20$lambda$16$lambda$15$lambda$14(KmpClickHandler kmpClickHandler, final Function1 function1, final String str, final MutableState mutableState) {
        kmpClickHandler.tryHandle(new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda5
            public final Object invoke() {
                Unit invoke$lambda$20$lambda$16$lambda$15$lambda$14$lambda$13;
                invoke$lambda$20$lambda$16$lambda$15$lambda$14$lambda$13 = SettingsEntryKt$SettingsEntryContent$3.invoke$lambda$20$lambda$16$lambda$15$lambda$14$lambda$13(function1, str, mutableState);
                return invoke$lambda$20$lambda$16$lambda$15$lambda$14$lambda$13;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$20$lambda$16$lambda$15$lambda$14$lambda$13(Function1 function1, String str, MutableState mutableState) {
        mutableState.setValue(null);
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$20$lambda$19$lambda$18(KmpClickHandler kmpClickHandler, final MutableState mutableState) {
        kmpClickHandler.tryHandle(new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda6
            public final Object invoke() {
                Unit invoke$lambda$20$lambda$19$lambda$18$lambda$17;
                invoke$lambda$20$lambda$19$lambda$18$lambda$17 = SettingsEntryKt$SettingsEntryContent$3.invoke$lambda$20$lambda$19$lambda$18$lambda$17(mutableState);
                return invoke$lambda$20$lambda$19$lambda$18$lambda$17;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$20$lambda$19$lambda$18$lambda$17(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }
}
