# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;
.super Ljava/lang/Object;
.source "SettingsEntry.kt"

.field private static final LANGUAGE_EN:Ljava/lang/String;
.field private static final LANGUAGE_JA:Ljava/lang/String;
.field private static final LANGUAGE_ZH:Ljava/lang/String;
.field private static final SettingsItemHeight:F
.field private static final SettingsItemIconSize:F
.field private static final SettingsItemIconSlotSize:F
.field private static final SettingsPopupAnchorYOffset:F
.field private static final SettingsPopupCornerRadius:F
.field private static final SettingsPopupDividerHeight:F
.field private static final SettingsPopupElevation:F
.field private static final SettingsPopupEndMargin:F
.field private static final SettingsPopupItemHeight:F
.field private static final SettingsPopupWidth:F


.method public static synthetic $r8$lambda$2mSk4o545BlQdnUyJFcUHcmLJqw(com.bytedance.trae.home.solo.setting.viewmodel.SettingsFooterState  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsFooter$lambda$40(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$CFLJwjdoknnUfdKxsH4Ochji2nI(androidx.compose.ui.semantics.SemanticsPropertyReceiver)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->ProfileHeader$lambda$24$lambda$22$lambda$20$lambda$19(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$CUlJAIkAhvP4B7qy_86IkmXSAAI(com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryState  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  kotlin.jvm.functions.Function0  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->ProfileHeader$lambda$25(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lkotlin/jvm/functions/Function0; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$D780eMbxt2XIiLttwXLuX8N_1Bo(java.lang.String  androidx.compose.ui.semantics.SemanticsPropertyReceiver)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->UnreadBadge$lambda$56$lambda$55(Ljava/lang/String; Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$E-2QdOavy41f8A-NDkxk_eorkto(androidx.compose.runtime.DisposableEffectScope)androidx.compose.runtime.DisposableEffectResult
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsEntryContent$lambda$16$lambda$15(Landroidx/compose/runtime/DisposableEffectScope;)Landroidx/compose/runtime/DisposableEffectResult;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$G2B1BOhD8H11mlBpvGmHYHRqZKI(com.bytedance.trae.home.solo.setting.viewmodel.SettingsEnterpriseBadge  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->EnterpriseBadge$lambda$26(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$J12eKJ3E0vPPWynpIdgTR8rVN2Y(com.bytedance.trae.home.solo.setting.viewmodel.SettingsGroup  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function2  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 8
    # ins_size=8
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsGroupView$lambda$29(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Kl6ELPJ2KK0IB-klT1-rDTszT_Q(java.lang.String  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  com.bytedance.trae.home.solo.setting.ui.SettingsTextBadgeStyle  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->TextBadge$lambda$28(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$VrCeCEhUDmBqHhZPbAXc8BVb8hE(org.jetbrains.compose.resources.DrawableResource  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsItemIcon$lambda$48(Lorg/jetbrains/compose/resources/DrawableResource; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Wj-_mAtDpfA99MHQF2p9K6MeSzw(kotlin.jvm.functions.Function2  com.bytedance.trae.home.solo.setting.viewmodel.SettingsItem  float)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsGroupView$lambda$37$lambda$36$lambda$35$lambda$34(Lkotlin/jvm/functions/Function2; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem; F)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ahsVO6q7EGXGjCHK2qeCoi51Qq0(java.lang.String  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  androidx.compose.ui.Modifier  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->FooterText$lambda$41(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Landroidx/compose/ui/Modifier; I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$eBLdJ134aOFtf1UG0FNjW3n1UZI(com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryState  androidx.compose.ui.Modifier  androidx.compose.foundation.ScrollState  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 14
    # ins_size=14
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsEntryContent$lambda$17(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState; Landroidx/compose/ui/Modifier; Landroidx/compose/foundation/ScrollState; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$lDZ3WhMDKeO5RZfy9bFb3hamVek(kotlin.jvm.functions.Function1  androidx.compose.ui.layout.LayoutCoordinates)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsRow$lambda$43$lambda$42(Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/layout/LayoutCoordinates;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$lIvInqlv-umNMj-IXiPwqi77mAU(com.bytedance.trae.home.solo.setting.viewmodel.SettingsFooterState  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsFooter$lambda$39(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$nZ-5-HfBm-_Oo5W1HaDsAE37xVY(kotlin.jvm.functions.Function1  com.bytedance.trae.home.solo.setting.viewmodel.SettingsItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsGroupView$lambda$37$lambda$36$lambda$33$lambda$32(Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$pG3B4AFOA0-vOJnDjh3poK_KfX0(java.lang.String  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->UnreadBadge$lambda$58(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$qSrpruRLqPYIEHk6Rlb4Y9H3fP0(com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->UpgradeButton$lambda$52(Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$sIgQELVkKB0MC9o5jQ12dXPlHGE(com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->UsageTrailing$lambda$50(Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$wzSOPH9hdgfeiSKhctqoadP7Itc(com.bytedance.trae.home.solo.setting.viewmodel.SettingsGroup  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function2  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 8
    # ins_size=8
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsGroupView$lambda$38(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$xgCP3CP7Z6vE5lc3AaHcLJlXwR8(com.bytedance.trae.home.solo.setting.viewmodel.SettingsItem  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  java.lang.String  kotlin.jvm.functions.Function0  com.bytedance.trae.kmp.ui.KmpClickHandler  kotlin.jvm.functions.Function1  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 9
    # ins_size=9
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsRow$lambda$46(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function1; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    const/16 v0, 180
    int-to-float v0, v0
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v0
    sput v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsPopupWidth F
    const/16 v0, 44
    int-to-float v0, v0
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v0
    sput v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsPopupItemHeight F
    const/16 v0, 20
    int-to-float v0, v0
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v1
    sput v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsPopupCornerRadius F
    const/16 v1, 40
    int-to-float v1, v1
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v1
    sput v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsPopupElevation F
    const-wide/high16 v1, 4602678819172646912
    double-to-float v1, v1
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v1
    sput v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsPopupDividerHeight F
    const/16 v1, 24
    int-to-float v1, v1
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v2
    sput v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsPopupEndMargin F
    const/16 v2, 56
    int-to-float v2, v2
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v2
    sput v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsItemHeight F
    sput v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsPopupAnchorYOffset F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v1
    sput v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsItemIconSlotSize F
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v0
    sput v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsItemIconSize F
    return-void 
.end method

.method private static final EnterpriseBadge(com.bytedance.trae.home.solo.setting.viewmodel.SettingsEnterpriseBadge  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  androidx.compose.runtime.Composer  int)void
    .registers 8
    # ins_size=4
    const v0, -1965253816
    invoke-interface v6, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v6
    and-int/lit8 v1, v7, 6
    if-nez v1, +00dh
    invoke-interface v6, v4, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +004h
    const/4 v1, 4
    goto +2h
    const/4 v1, 2
    or-int/2addr v1, v7
    goto +2h
    move v1, v7
    and-int/lit8 v2, v7, 48
    if-nez v2, +00eh
    invoke-interface v6, v5, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +005h
    const/16 v2, 32
    goto +3h
    const/16 v2, 16
    or-int/2addr v1, v2
    and-int/lit8 v2, v1, 19
    const/16 v3, 18
    if-ne v2, v3, +00dh
    invoke-interface v6, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v2
    if-nez v2, +003h
    goto +5h
    invoke-interface v6, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    goto +2ah
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v2
    if-eqz v2, +008h
    const/4 v2, -1
    const-string v3, "com.bytedance.trae.home.solo.setting.ui.EnterpriseBadge (SettingsEntry.kt:387)"
    invoke-static v0, v1, v2, v3, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    invoke-static v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->titleResource(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v0
    const/4 v2, 0
    new-array v3, v2, [Ljava/lang/Object;
    invoke-static v0, v3, v6, v2, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v0
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;->Enterprise Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;
    and-int/lit8 v1, v1, 112
    or-int/lit16 v1, v1, 384
    invoke-static v0, v5, v2, v6, v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->TextBadge(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle; Landroidx/compose/runtime/Composer; I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v6, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v6
    if-eqz v6, +00ah
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda16;
    invoke-direct v0, v4, v5, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda16;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; I)V
    invoke-interface v6, v0, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final EnterpriseBadge$lambda$26(com.bytedance.trae.home.solo.setting.viewmodel.SettingsEnterpriseBadge  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 5
    # ins_size=5
    or-int/lit8 v2, v2, 1
    invoke-static v2, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v2
    invoke-static v0, v1, v3, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->EnterpriseBadge(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final FooterText(java.lang.String  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  androidx.compose.ui.Modifier  androidx.compose.runtime.Composer  int  int)void
    .registers 37
    # ins_size=6
    move/from16 v4, v35
    const v0, 2099976551
    move-object/from16 v1, v34
    invoke-interface v1, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v1
    and-int/lit8 v2, v36, 1
    if-eqz v2, +008h
    or-int/lit8 v2, v4, 6
    move v3, v2
    move-object/from16 v2, v31
    goto +15h
    and-int/lit8 v2, v4, 6
    if-nez v2, +00fh
    move-object/from16 v2, v31
    invoke-interface v1, v2, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +004h
    const/4 v3, 4
    goto +2h
    const/4 v3, 2
    or-int/2addr v3, v4
    goto +4h
    move-object/from16 v2, v31
    move v3, v4
    and-int/lit8 v5, v36, 2
    if-eqz v5, +005h
    or-int/lit8 v3, v3, 48
    goto +14h
    and-int/lit8 v5, v4, 48
    if-nez v5, +011h
    move-object/from16 v5, v32
    invoke-interface v1, v5, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +005h
    const/16 v6, 32
    goto +3h
    const/16 v6, 16
    or-int/2addr v3, v6
    goto +3h
    move-object/from16 v5, v32
    and-int/lit8 v6, v36, 4
    if-eqz v6, +005h
    or-int/lit16 v3, v3, 384
    goto +14h
    and-int/lit16 v7, v4, 384
    if-nez v7, +011h
    move-object/from16 v7, v33
    invoke-interface v1, v7, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +005h
    const/16 v8, 256
    goto +3h
    const/16 v8, 128
    or-int/2addr v3, v8
    goto +3h
    move-object/from16 v7, v33
    and-int/lit16 v8, v3, 147
    const/16 v9, 146
    if-ne v8, v9, +00eh
    invoke-interface v1, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v8
    if-nez v8, +003h
    goto +6h
    invoke-interface v1, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    move-object v3, v7
    goto +6ch
    if-eqz v6, +008h
    sget-object v6, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v6, Landroidx/compose/ui/Modifier;
    move-object v14, v6
    goto +2h
    move-object v14, v7
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v6
    if-eqz v6, +008h
    const/4 v6, -1
    const-string v7, "com.bytedance.trae.home.solo.setting.ui.FooterText (SettingsEntry.kt:493)"
    invoke-static v0, v3, v6, v7, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    invoke-virtual/range v32, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getTertiaryText-0d7_KjU()J
    move-result-wide v7
    sget-object v0, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v6, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v0, v1, v6, Lcom/bytedance/trae/design/compose/TraeTheme;->getTypography(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeTypography;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/design/compose/TraeTypography;->getCaptionBase()Landroidx/compose/ui/text/TextStyle;
    move-result-object v25
    sget-object v0, Landroidx/compose/ui/text/style/TextAlign;->Companion Landroidx/compose/ui/text/style/TextAlign$Companion;
    invoke-virtual v0, Landroidx/compose/ui/text/style/TextAlign$Companion;->getCenter-e0LSkKk()I
    move-result v0
    sget-object v6, Landroidx/compose/ui/text/style/TextOverflow;->Companion Landroidx/compose/ui/text/style/TextOverflow$Companion;
    invoke-virtual v6, Landroidx/compose/ui/text/style/TextOverflow$Companion;->getEllipsis-gIe3tQ8()I
    move-result v20
    const/4 v6, 0
    const/4 v9, 0
    const/4 v10, 1
    invoke-static v14, v6, v10, v9, Landroidx/compose/foundation/layout/SizeKt;->fillMaxWidth$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v6
    const-wide/16 v9, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const-wide/16 v15, 0
    move-object/from16 v30, v14
    move-wide v14, v15
    const/16 v16, 0
    invoke-static v0, Landroidx/compose/ui/text/style/TextAlign;->box-impl(I)Landroidx/compose/ui/text/style/TextAlign;
    move-result-object v17
    const-wide/16 v18, 0
    const/16 v21, 0
    const/16 v22, 1
    const/16 v23, 0
    const/16 v24, 0
    and-int/lit8 v27, v3, 14
    const/16 v28, 3120
    const v29, 54776
    move-object/from16 v5, v31
    move-object/from16 v26, v1
    invoke-static/range v5 ... v29, Landroidx/compose/material3/TextKt;->Text--4IGK_g(Ljava/lang/String; Landroidx/compose/ui/Modifier; J J Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontFamily; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/text/style/TextAlign; J I Z I I Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/runtime/Composer; I I I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    move-object/from16 v3, v30
    invoke-interface v1, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v6
    if-eqz v6, +013h
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda0;
    move-object v0, v7
    move-object/from16 v1, v31
    move-object/from16 v2, v32
    move/from16 v4, v35
    move/from16 v5, v36
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda0;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Landroidx/compose/ui/Modifier; I I)V
    invoke-interface v6, v7, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final FooterText$lambda$41(java.lang.String  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  androidx.compose.ui.Modifier  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 13
    # ins_size=7
    or-int/lit8 v9, v9, 1
    invoke-static v9, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v4
    move-object v0, v6
    move-object v1, v7
    move-object v2, v8
    move-object v3, v11
    move v5, v10
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->FooterText(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I I)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method

.method private static final ProfileHeader(com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryState  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  kotlin.jvm.functions.Function0  androidx.compose.runtime.Composer  int)void
    .registers 41
    # ins_size=5
    move-object/from16 v0, v36
    move-object/from16 v1, v37
    move-object/from16 v2, v38
    move/from16 v3, v40
    const v4, 1666269811
    move-object/from16 v5, v39
    invoke-interface v5, v4, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v15
    and-int/lit8 v5, v3, 6
    if-nez v5, +00dh
    invoke-interface v15, v0, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +004h
    const/4 v5, 4
    goto +2h
    const/4 v5, 2
    or-int/2addr v5, v3
    goto +2h
    move v5, v3
    and-int/lit8 v6, v3, 48
    if-nez v6, +00eh
    invoke-interface v15, v1, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +005h
    const/16 v6, 32
    goto +3h
    const/16 v6, 16
    or-int/2addr v5, v6
    and-int/lit16 v6, v3, 384
    if-nez v6, +00eh
    invoke-interface v15, v2, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +005h
    const/16 v6, 256
    goto +3h
    const/16 v6, 128
    or-int/2addr v5, v6
    move v13, v5
    and-int/lit16 v5, v13, 147
    const/16 v6, 146
    if-ne v5, v6, +00fh
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v5
    if-nez v5, +003h
    goto +7h
    invoke-interface v15, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    move-object v0, v15
    goto/16 +5a9h
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v5
    if-eqz v5, +008h
    const/4 v5, -1
    const-string v6, "com.bytedance.trae.home.solo.setting.ui.ProfileHeader (SettingsEntry.kt:297)"
    invoke-static v4, v13, v5, v6, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v5, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v4, v15, v5, Lcom/bytedance/trae/design/compose/TraeTheme;->getTypography(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeTypography;
    move-result-object v4
    const v5, 81851444
    invoke-interface v15, v5, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v5
    sget-object v6, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v6, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v6
    const/4 v7, 0
    const/4 v12, 1
    if-ne v5, v6, +00ah
    new-instance v5, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    invoke-direct v5, v7, v12, v7, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;-><init>(Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v15, v5, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object v11, v5
    check-cast v11, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->getDisplayName()Ljava/lang/String;
    move-result-object v26
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->getAccountText()Ljava/lang/String;
    move-result-object v30
    sget-object v5, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v5, Landroidx/compose/ui/Modifier;
    const/4 v6, 0
    invoke-static v5, v6, v12, v7, Landroidx/compose/foundation/layout/SizeKt;->fillMaxWidth$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v5
    const/16 v8, 12
    int-to-float v10, v8
    invoke-static v10, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v8
    invoke-static v10, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v9
    const/4 v14, 6
    int-to-float v6, v14
    invoke-static v6, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v14
    invoke-static v6, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v6
    invoke-static v5, v14, v8, v6, v9, Landroidx/compose/foundation/layout/PaddingKt;->padding-qDBjuR0(Landroidx/compose/ui/Modifier; F F F F)Landroidx/compose/ui/Modifier;
    move-result-object v5
    sget-object v6, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v6, Landroidx/compose/ui/Alignment$Companion;->getCenterHorizontally()Landroidx/compose/ui/Alignment$Horizontal;
    move-result-object v6
    const v8, 1341605231
    const-string v9, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo"
    invoke-static v15, v8, v9, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v8, Landroidx/compose/foundation/layout/Arrangement;->INSTANCE Landroidx/compose/foundation/layout/Arrangement;
    invoke-virtual v8, Landroidx/compose/foundation/layout/Arrangement;->getTop()Landroidx/compose/foundation/layout/Arrangement$Vertical;
    move-result-object v8
    const/16 v14, 48
    invoke-static v8, v6, v15, v14, Landroidx/compose/foundation/layout/ColumnKt;->columnMeasurePolicy(Landroidx/compose/foundation/layout/Arrangement$Vertical; Landroidx/compose/ui/Alignment$Horizontal; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v6
    const v9, -1159599143
    const-string v8, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh"
    invoke-static v15, v9, v8, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    move/from16 v18, v13
    const/4 v13, 0
    invoke-static v15, v13, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v19
    invoke-static/range v19 ... v20, Ljava/lang/Long;->hashCode(J)I
    move-result v19
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v14
    invoke-static v15, v5, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v5
    sget-object v21, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual/range v21, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v7
    move-object/from16 v21, v11
    const v11, -553112988
    move/from16 v23, v10
    const-string v10, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp"
    invoke-static v15, v11, v10, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v12
    instance-of v12, v12, Landroidx/compose/runtime/Applier;
    if-nez v12, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v12
    if-eqz v12, +006h
    invoke-interface v15, v7, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v15, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v15, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v7
    sget-object v12, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v12, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v12
    invoke-static v7, v6, v12, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v6, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v6, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v6
    invoke-static v7, v14, v6, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v6, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v6, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v6
    invoke-interface v7, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v12
    if-nez v12, +010h
    invoke-interface v7, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v12
    invoke-static/range v19, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v14
    invoke-static v12, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v12
    if-nez v12, +010h
    invoke-static/range v19, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v12
    invoke-interface v7, v12, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static/range v19, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v12
    invoke-interface v7, v12, v6, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v6, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v6, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v6
    invoke-static v7, v5, v6, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v5, 2093002350
    const-string v6, "C89@4557L9:Column.kt#2w3rfo"
    invoke-static v15, v5, v6, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v5, Landroidx/compose/foundation/layout/ColumnScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/ColumnScopeInstance;
    check-cast v5, Landroidx/compose/foundation/layout/ColumnScope;
    sget-object v5, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v5, Landroidx/compose/ui/Alignment$Companion;->getBottomEnd()Landroidx/compose/ui/Alignment;
    move-result-object v5
    const v6, 1042775818
    const-string v7, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo"
    invoke-static v15, v6, v7, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v12, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v12, Landroidx/compose/ui/Modifier;
    invoke-static v5, v13, Landroidx/compose/foundation/layout/BoxKt;->maybeCachedBoxMeasurePolicy(Landroidx/compose/ui/Alignment; Z)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v5
    invoke-static v15, v9, v8, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v15, v13, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v27
    invoke-static/range v27 ... v28, Ljava/lang/Long;->hashCode(J)I
    move-result v14
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v9
    invoke-static v15, v12, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v12
    sget-object v25, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual/range v25, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v6
    invoke-static v15, v11, v10, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v11
    instance-of v11, v11, Landroidx/compose/runtime/Applier;
    if-nez v11, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v11
    if-eqz v11, +006h
    invoke-interface v15, v6, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v15, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v15, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v6
    sget-object v11, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v11, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v11
    invoke-static v6, v5, v11, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-static v6, v9, v5, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-interface v6, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v9
    if-nez v9, +010h
    invoke-interface v6, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v9
    invoke-static v14, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v11
    invoke-static v9, v11, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +010h
    invoke-static v14, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    invoke-interface v6, v9, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v14, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    invoke-interface v6, v9, v5, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-static v6, v12, v5, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v5, 1833054614
    const-string v6, "C72@3469L9:Box.kt#2w3rfo"
    invoke-static v15, v5, v6, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v9, Landroidx/compose/foundation/layout/BoxScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/BoxScopeInstance;
    check-cast v9, Landroidx/compose/foundation/layout/BoxScope;
    sget-object v9, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v9, Landroidx/compose/ui/Modifier;
    const/16 v11, 80
    int-to-float v11, v11
    invoke-static v11, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v11
    invoke-static v9, v11, Landroidx/compose/foundation/layout/SizeKt;->size-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v9
    invoke-static Landroidx/compose/foundation/shape/RoundedCornerShapeKt;->getCircleShape()Landroidx/compose/foundation/shape/RoundedCornerShape;
    move-result-object v11
    check-cast v11, Landroidx/compose/ui/graphics/Shape;
    invoke-static v9, v11, Landroidx/compose/ui/draw/ClipKt;->clip(Landroidx/compose/ui/Modifier; Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;
    move-result-object v9
    const v11, -1030163838
    invoke-interface v15, v11, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v11
    sget-object v12, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v12, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v12
    if-ne v11, v12, +00ah
    new-instance v11, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda11;
    invoke-direct v11, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda11;-><init>()V
    invoke-interface v15, v11, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v11, Lkotlin/jvm/functions/Function1;
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/4 v12, 0
    const/4 v14, 1
    invoke-static v9, v13, v11, v14, v12, Landroidx/compose/ui/semantics/SemanticsModifierKt;->semantics$default(Landroidx/compose/ui/Modifier; Z Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v9
    const v11, 1042775818
    invoke-static v15, v11, v7, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v7, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v7, Landroidx/compose/ui/Alignment$Companion;->getTopStart()Landroidx/compose/ui/Alignment;
    move-result-object v7
    invoke-static v7, v13, Landroidx/compose/foundation/layout/BoxKt;->maybeCachedBoxMeasurePolicy(Landroidx/compose/ui/Alignment; Z)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v7
    const v11, -1159599143
    invoke-static v15, v11, v8, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v15, v13, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v27
    invoke-static/range v27 ... v28, Ljava/lang/Long;->hashCode(J)I
    move-result v12
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v14
    invoke-static v15, v9, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v9
    sget-object v19, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual/range v19, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v11
    move-object/from16 v19, v8
    const v8, -553112988
    invoke-static v15, v8, v10, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v8
    instance-of v8, v8, Landroidx/compose/runtime/Applier;
    if-nez v8, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v8
    if-eqz v8, +006h
    invoke-interface v15, v11, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v15, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v15, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v8
    sget-object v11, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v11, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v11
    invoke-static v8, v7, v11, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v7
    invoke-static v8, v14, v7, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v7
    invoke-interface v8, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v11
    if-nez v11, +010h
    invoke-interface v8, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v11
    invoke-static v12, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v14
    invoke-static v11, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +010h
    invoke-static v12, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v11
    invoke-interface v8, v11, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v12, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v11
    invoke-interface v8, v11, v7, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v7
    invoke-static v8, v9, v7, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    invoke-static v15, v5, v6, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v5, Landroidx/compose/foundation/layout/BoxScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/BoxScopeInstance;
    check-cast v5, Landroidx/compose/foundation/layout/BoxScope;
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->getAvatarUrl()Ljava/lang/String;
    move-result-object v5
    sget-object v6, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v6, Landroidx/compose/ui/Modifier;
    const/4 v7, 0
    const/4 v8, 0
    const/4 v12, 1
    invoke-static v6, v7, v12, v8, Landroidx/compose/foundation/layout/SizeKt;->fillMaxSize$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v6
    const/16 v14, 48
    invoke-static v5, v6, v15, v14, v13, Lcom/bytedance/trae/home/solo/setting/ui/components/SettingsAvatarKt;->SettingsAvatar(Ljava/lang/String; Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I I)V
    invoke-static v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    const v5, -1030155705
    invoke-interface v15, v5, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->getShowByteCloudBadge()Z
    move-result v5
    if-eqz v5, +04ah
    sget-object v5, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v5, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_bytecloud_badge(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v5
    new-array v6, v13, [Ljava/lang/Object;
    invoke-static v5, v6, v15, v13, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v6
    sget-object v5, Lcom/bytedance/trae/home/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$drawable;
    invoke-static v5, Lcom/bytedance/trae/home/generated/resources/Drawable0_commonMainKt;->getCmp_trae_ic_bytecloud_badge(Lcom/bytedance/trae/home/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v5
    invoke-static v5, v15, v13, Lorg/jetbrains/compose/resources/ImageResources_androidKt;->painterResource(Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/graphics/painter/Painter;
    move-result-object v5
    sget-object v7, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v7, Landroidx/compose/ui/Modifier;
    const/16 v8, 28
    int-to-float v8, v8
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v8
    invoke-static v7, v8, Landroidx/compose/foundation/layout/SizeKt;->size-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v7
    const/4 v8, 0
    const/4 v9, 0
    const/4 v11, 0
    const/16 v16, 0
    const/16 v20, 384
    const/16 v22, 120
    move-object/from16 v31, v19
    const v19, -553112988
    move-object/from16 v33, v10
    move/from16 v32, v23
    move v10, v11
    move-object/from16 v34, v21
    move-object/from16 v11, v16
    move-object v12, v15
    move/from16 v35, v18
    move/from16 v13, v20
    const/4 v0, 6
    move/from16 v14, v22
    invoke-static/range v5 ... v14, Landroidx/compose/foundation/ImageKt;->Image(Landroidx/compose/ui/graphics/painter/Painter; Ljava/lang/String; Landroidx/compose/ui/Modifier; Landroidx/compose/ui/Alignment; Landroidx/compose/ui/layout/ContentScale; F Landroidx/compose/ui/graphics/ColorFilter; Landroidx/compose/runtime/Composer; I I)V
    goto +ch
    move-object/from16 v33, v10
    move/from16 v35, v18
    move-object/from16 v31, v19
    move-object/from16 v34, v21
    move/from16 v32, v23
    const/4 v0, 6
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    sget-object v5, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v5, Landroidx/compose/ui/Modifier;
    invoke-static/range v32, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v6
    invoke-static v5, v6, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v5
    invoke-static v5, v15, v0, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    sget-object v5, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v5, Landroidx/compose/ui/Alignment$Companion;->getCenterVertically()Landroidx/compose/ui/Alignment$Vertical;
    move-result-object v5
    const v6, 844473419
    const-string v7, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo"
    invoke-static v15, v6, v7, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v6, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v6, Landroidx/compose/ui/Modifier;
    sget-object v7, Landroidx/compose/foundation/layout/Arrangement;->INSTANCE Landroidx/compose/foundation/layout/Arrangement;
    invoke-virtual v7, Landroidx/compose/foundation/layout/Arrangement;->getStart()Landroidx/compose/foundation/layout/Arrangement$Horizontal;
    move-result-object v7
    const/16 v8, 48
    invoke-static v7, v5, v15, v8, Landroidx/compose/foundation/layout/RowKt;->rowMeasurePolicy(Landroidx/compose/foundation/layout/Arrangement$Horizontal; Landroidx/compose/ui/Alignment$Vertical; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v5
    move-object/from16 v7, v31
    const v8, -1159599143
    invoke-static v15, v8, v7, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    const/4 v14, 0
    invoke-static v15, v14, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v7
    invoke-static v7, v8, Ljava/lang/Long;->hashCode(J)I
    move-result v7
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v8
    invoke-static v15, v6, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v6
    sget-object v9, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v9, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v9
    move-object/from16 v10, v33
    const v11, -553112988
    invoke-static v15, v11, v10, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v10
    instance-of v10, v10, Landroidx/compose/runtime/Applier;
    if-nez v10, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v10
    if-eqz v10, +006h
    invoke-interface v15, v9, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v15, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v15, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v9
    sget-object v10, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v10, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v10
    invoke-static v9, v5, v10, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-static v9, v8, v5, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-interface v9, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v8
    if-nez v8, +010h
    invoke-interface v9, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v8
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v10
    invoke-static v8, v10, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +010h
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-interface v9, v8, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    invoke-interface v9, v7, v5, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-static v9, v6, v5, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v5, 1456264949
    const-string v6, "C101@5233L9:Row.kt#2w3rfo"
    invoke-static v15, v5, v6, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v5, Landroidx/compose/foundation/layout/RowScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/RowScopeInstance;
    check-cast v5, Landroidx/compose/foundation/layout/RowScope;
    invoke-virtual/range v37, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getPrimaryText-0d7_KjU()J
    move-result-wide v7
    invoke-virtual v4, Lcom/bytedance/trae/design/compose/TraeTypography;->getHeadingXlStrong()Landroidx/compose/ui/text/TextStyle;
    move-result-object v25
    sget-object v5, Landroidx/compose/ui/text/style/TextOverflow;->Companion Landroidx/compose/ui/text/style/TextOverflow$Companion;
    invoke-virtual v5, Landroidx/compose/ui/text/style/TextOverflow$Companion;->getEllipsis-gIe3tQ8()I
    move-result v20
    const/4 v6, 0
    const-wide/16 v9, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const-wide/16 v16, 0
    move-object v5, v15
    move-wide/from16 v14, v16
    const/16 v16, 0
    const/16 v17, 0
    const-wide/16 v18, 0
    const/16 v21, 0
    const/16 v22, 1
    const/16 v23, 0
    const/16 v24, 0
    const/16 v27, 0
    const/16 v28, 3120
    const v29, 55290
    move-object/from16 v39, v5
    move-object/from16 v5, v26
    move-object/from16 v26, v39
    invoke-static/range v5 ... v29, Landroidx/compose/material3/TextKt;->Text--4IGK_g(Ljava/lang/String; Landroidx/compose/ui/Modifier; J J Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontFamily; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/text/style/TextAlign; J I Z I I Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/runtime/Composer; I I I)V
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->getEnterpriseBadge()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;
    move-result-object v5
    if-eqz v5, +029h
    const v5, -1869262677
    move-object/from16 v14, v39
    invoke-interface v14, v5, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    sget-object v5, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v5, Landroidx/compose/ui/Modifier;
    const/4 v6, 4
    int-to-float v7, v6
    invoke-static v7, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v7
    invoke-static v5, v7, Landroidx/compose/foundation/layout/SizeKt;->width-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v5
    invoke-static v5, v14, v0, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->getEnterpriseBadge()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;
    move-result-object v5
    and-int/lit8 v7, v35, 112
    invoke-static v5, v1, v14, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->EnterpriseBadge(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Landroidx/compose/runtime/Composer; I)V
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/4 v9, 1
    goto +49h
    move-object/from16 v14, v39
    const/4 v6, 4
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->getIdentityBadgeText()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +037h
    const v5, -1869038795
    invoke-interface v14, v5, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    sget-object v5, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v5, Landroidx/compose/ui/Modifier;
    int-to-float v7, v6
    invoke-static v7, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v7
    invoke-static v5, v7, Landroidx/compose/foundation/layout/SizeKt;->width-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v5
    invoke-static v5, v14, v0, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->getIdentityBadgeText()Ljava/lang/String;
    move-result-object v5
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->getIdentityBadgeText()Ljava/lang/String;
    move-result-object v7
    const-string v8, "free"
    const/4 v9, 1
    invoke-static v7, v8, v9, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v7
    if-eqz v7, +005h
    sget-object v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;->Free Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;
    goto +3h
    sget-object v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;->PublicCloud Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;
    and-int/lit8 v8, v35, 112
    invoke-static v5, v1, v7, v14, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->TextBadge(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle; Landroidx/compose/runtime/Composer; I)V
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    goto +bh
    const/4 v9, 1
    const v5, -1868539602
    invoke-interface v14, v5, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    const v5, -426493313
    invoke-interface v14, v5, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    move-object/from16 v5, v30
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/2addr v5, v9
    if-eqz v5, +049h
    sget-object v5, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v5, Landroidx/compose/ui/Modifier;
    int-to-float v6, v6
    invoke-static v6, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v6
    invoke-static v5, v6, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v5
    invoke-static v5, v14, v0, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    invoke-virtual/range v37, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getTertiaryText-0d7_KjU()J
    move-result-wide v7
    invoke-virtual v4, Lcom/bytedance/trae/design/compose/TraeTypography;->getBodyXs()Landroidx/compose/ui/text/TextStyle;
    move-result-object v25
    sget-object v5, Landroidx/compose/ui/text/style/TextOverflow;->Companion Landroidx/compose/ui/text/style/TextOverflow$Companion;
    invoke-virtual v5, Landroidx/compose/ui/text/style/TextOverflow$Companion;->getEllipsis-gIe3tQ8()I
    move-result v20
    const/4 v6, 0
    const-wide/16 v9, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const-wide/16 v15, 0
    move-object v5, v14
    move-wide v14, v15
    const/16 v16, 0
    const/16 v17, 0
    const-wide/16 v18, 0
    const/16 v21, 0
    const/16 v22, 1
    const/16 v23, 0
    const/16 v24, 0
    const/16 v27, 0
    const/16 v28, 3120
    const v29, 55290
    move-object/from16 v39, v5
    move-object/from16 v5, v30
    move-object/from16 v26, v39
    invoke-static/range v5 ... v29, Landroidx/compose/material3/TextKt;->Text--4IGK_g(Ljava/lang/String; Landroidx/compose/ui/Modifier; J J Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontFamily; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/text/style/TextAlign; J I Z I I Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/runtime/Composer; I I I)V
    goto +3h
    move-object/from16 v39, v14
    invoke-interface/range v39, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v5, -426482208
    move-object/from16 v14, v39
    invoke-interface v14, v5, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->getShowEditProfile()Z
    move-result v5
    if-eqz v5, +081h
    sget-object v5, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v5, Landroidx/compose/ui/Modifier;
    invoke-static/range v32, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v6
    invoke-static v5, v6, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v5
    invoke-static v5, v14, v0, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v0, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_edit_profile(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v0
    const/4 v5, 0
    new-array v6, v5, [Ljava/lang/Object;
    invoke-static v0, v6, v14, v5, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v5
    invoke-virtual/range v37, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getPrimaryText-0d7_KjU()J
    move-result-wide v7
    invoke-virtual v4, Lcom/bytedance/trae/design/compose/TraeTypography;->getBodyXs()Landroidx/compose/ui/text/TextStyle;
    move-result-object v25
    sget-object v0, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v0, Landroidx/compose/ui/Modifier;
    invoke-static/range v32, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v4
    invoke-static v4, Landroidx/compose/foundation/shape/RoundedCornerShapeKt;->RoundedCornerShape-0680j_4(F)Landroidx/compose/foundation/shape/RoundedCornerShape;
    move-result-object v4
    check-cast v4, Landroidx/compose/ui/graphics/Shape;
    invoke-static v0, v4, Landroidx/compose/ui/draw/ClipKt;->clip(Landroidx/compose/ui/Modifier; Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;
    move-result-object v15
    invoke-virtual/range v37, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getEditButtonBackground-0d7_KjU()J
    move-result-wide v16
    const/16 v18, 0
    const/16 v19, 2
    const/16 v20, 0
    invoke-static/range v15 ... v20, Landroidx/compose/foundation/BackgroundKt;->background-bw27NRU$default(Landroidx/compose/ui/Modifier; J Landroidx/compose/ui/graphics/Shape; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v0
    move-object/from16 v4, v34
    invoke-static v0, v4, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsScaffoldKt;->noRippleClickable(Landroidx/compose/ui/Modifier; Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function0;)Landroidx/compose/ui/Modifier;
    move-result-object v0
    invoke-static/range v32, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v4
    const/16 v6, 8
    int-to-float v6, v6
    invoke-static v6, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v6
    invoke-static v0, v4, v6, Landroidx/compose/foundation/layout/PaddingKt;->padding-VpY3zN4(Landroidx/compose/ui/Modifier; F F)Landroidx/compose/ui/Modifier;
    move-result-object v6
    const-wide/16 v9, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const-wide/16 v15, 0
    move-object v0, v14
    move-wide v14, v15
    const/16 v16, 0
    const/16 v17, 0
    const-wide/16 v18, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v27, 0
    const/16 v28, 0
    const v29, 65528
    move-object/from16 v26, v0
    invoke-static/range v5 ... v29, Landroidx/compose/material3/TextKt;->Text--4IGK_g(Ljava/lang/String; Landroidx/compose/ui/Modifier; J J Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontFamily; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/text/style/TextAlign; J I Z I I Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/runtime/Composer; I I I)V
    goto +2h
    move-object v0, v14
    invoke-interface v0, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v0, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v0, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v0, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v0, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v0, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v4
    if-eqz v4, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v0, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v0
    if-eqz v0, +00ch
    new-instance v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda12;
    move-object/from16 v5, v36
    invoke-direct v4, v5, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda12;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lkotlin/jvm/functions/Function0; I)V
    invoke-interface v0, v4, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final ProfileHeader$lambda$24$lambda$22$lambda$20$lambda$19(androidx.compose.ui.semantics.SemanticsPropertyReceiver)kotlin.Unit
    .registers 2
    # ins_size=1
    const-string v0, "$this$semantics"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cmp_settings_avatar"
    invoke-static v1, v0, Landroidx/compose/ui/semantics/SemanticsPropertiesKt;->setContentDescription(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final ProfileHeader$lambda$25(com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryState  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  kotlin.jvm.functions.Function0  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 6
    # ins_size=6
    or-int/lit8 v3, v3, 1
    invoke-static v3, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v3
    invoke-static v0, v1, v2, v4, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->ProfileHeader(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lkotlin/jvm/functions/Function0; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public static final SettingsEntryContent(com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryState  androidx.compose.ui.Modifier  androidx.compose.foundation.ScrollState  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  androidx.compose.runtime.Composer  int  int)void
    .registers 43
    # ins_size=13
    move-object/from16 v15, v30
    move-object/from16 v14, v33
    move-object/from16 v13, v34
    move-object/from16 v12, v35
    move-object/from16 v11, v36
    move-object/from16 v10, v37
    move-object/from16 v9, v38
    move-object/from16 v8, v39
    move/from16 v7, v41
    move/from16 v6, v42
    const-string/jumbo v0, state
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onEditProfile"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onThemeSelected"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onLanguageSelected"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onOpenAbout"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onOpenDeviceManagement"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onLogoutConfirmed"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onItemClick"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const v0, -203173739
    move-object/from16 v1, v40
    invoke-interface v1, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v5
    and-int/lit8 v1, v6, 1
    if-eqz v1, +005h
    or-int/lit8 v1, v7, 6
    goto +11h
    and-int/lit8 v1, v7, 6
    if-nez v1, +00dh
    invoke-interface v5, v15, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +004h
    const/4 v1, 4
    goto +2h
    const/4 v1, 2
    or-int/2addr v1, v7
    goto +2h
    move v1, v7
    and-int/lit8 v3, v6, 2
    if-eqz v3, +005h
    or-int/lit8 v1, v1, 48
    goto +15h
    and-int/lit8 v4, v7, 48
    if-nez v4, +012h
    move-object/from16 v4, v31
    invoke-interface v5, v4, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v16
    if-eqz v16, +005h
    const/16 v16, 32
    goto +3h
    const/16 v16, 16
    or-int v1, v1, v16
    goto +3h
    move-object/from16 v4, v31
    and-int/lit16 v2, v7, 384
    if-nez v2, +018h
    and-int/lit8 v2, v6, 4
    if-nez v2, +00dh
    move-object/from16 v2, v32
    invoke-interface v5, v2, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v16
    if-eqz v16, +007h
    const/16 v16, 256
    goto +5h
    move-object/from16 v2, v32
    const/16 v16, 128
    or-int v1, v1, v16
    goto +3h
    move-object/from16 v2, v32
    and-int/lit8 v16, v6, 8
    if-eqz v16, +005h
    or-int/lit16 v1, v1, 3072
    goto +11h
    and-int/lit16 v0, v7, 3072
    if-nez v0, +00eh
    invoke-interface v5, v14, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    const/16 v0, 2048
    goto +3h
    const/16 v0, 1024
    or-int/2addr v1, v0
    and-int/lit8 v0, v6, 16
    if-eqz v0, +005h
    or-int/lit16 v1, v1, 24576
    goto +11h
    and-int/lit16 v0, v7, 24576
    if-nez v0, +00eh
    invoke-interface v5, v13, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    const/16 v0, 16384
    goto +3h
    const/16 v0, 8192
    or-int/2addr v1, v0
    and-int/lit8 v0, v6, 32
    const/high16 v17, 196608
    if-eqz v0, +005h
    or-int v1, v1, v17
    goto +11h
    and-int v0, v7, v17
    if-nez v0, +00eh
    invoke-interface v5, v12, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    const/high16 v0, 131072
    goto +3h
    const/high16 v0, 65536
    or-int/2addr v1, v0
    and-int/lit8 v0, v6, 64
    const/high16 v17, 1572864
    if-eqz v0, +005h
    or-int v1, v1, v17
    goto +11h
    and-int v0, v7, v17
    if-nez v0, +00eh
    invoke-interface v5, v11, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    const/high16 v0, 1048576
    goto +3h
    const/high16 v0, 524288
    or-int/2addr v1, v0
    and-int/lit16 v0, v6, 128
    const/high16 v17, 12582912
    if-eqz v0, +005h
    or-int v1, v1, v17
    goto +11h
    and-int v0, v7, v17
    if-nez v0, +00eh
    invoke-interface v5, v10, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    const/high16 v0, 8388608
    goto +3h
    const/high16 v0, 4194304
    or-int/2addr v1, v0
    and-int/lit16 v0, v6, 256
    const/high16 v17, 100663296
    if-eqz v0, +005h
    or-int v1, v1, v17
    goto +11h
    and-int v0, v7, v17
    if-nez v0, +00eh
    invoke-interface v5, v9, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    const/high16 v0, 67108864
    goto +3h
    const/high16 v0, 33554432
    or-int/2addr v1, v0
    and-int/lit16 v0, v6, 512
    const/high16 v17, 805306368
    if-eqz v0, +005h
    or-int v1, v1, v17
    goto +11h
    and-int v0, v7, v17
    if-nez v0, +00eh
    invoke-interface v5, v8, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    const/high16 v0, 536870912
    goto +3h
    const/high16 v0, 268435456
    or-int/2addr v1, v0
    const v0, 306783379
    and-int/2addr v0, v1
    const v2, 306783378
    if-ne v0, v2, +012h
    invoke-interface v5, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v0
    if-nez v0, +003h
    goto +ah
    invoke-interface v5, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    move-object/from16 v3, v32
    move-object v2, v4
    move-object v8, v5
    goto/16 +25ah
    invoke-interface v5, Landroidx/compose/runtime/Composer;->startDefaults()V
    and-int/lit8 v0, v7, 1
    const/4 v2, 0
    const/4 v7, 1
    if-eqz v0, +013h
    invoke-interface v5, Landroidx/compose/runtime/Composer;->getDefaultsInvalid()Z
    move-result v0
    if-eqz v0, +003h
    goto +bh
    invoke-interface v5, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    and-int/lit8 v0, v6, 4
    if-eqz v0, +019h
    and-int/lit16 v1, v1, -897
    goto +15h
    if-eqz v3, +007h
    sget-object v0, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v0, Landroidx/compose/ui/Modifier;
    move-object v4, v0
    and-int/lit8 v0, v6, 4
    if-eqz v0, +00bh
    invoke-static v2, v5, v2, v7, Landroidx/compose/foundation/ScrollKt;->rememberScrollState(I Landroidx/compose/runtime/Composer; I I)Landroidx/compose/foundation/ScrollState;
    move-result-object v0
    and-int/lit16 v1, v1, -897
    move-object/from16 v18, v0
    goto +3h
    move-object/from16 v18, v32
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endDefaults()V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +00bh
    const/4 v0, -1
    const-string v3, "com.bytedance.trae.home.solo.setting.ui.SettingsEntryContent (SettingsEntry.kt:150)"
    const v7, -203173739
    invoke-static v7, v1, v0, v3, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    invoke-static v5, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsScaffoldKt;->settingsEntryPalette(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
    move-result-object v16
    const v0, -1878175265
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v0
    sget-object v3, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v3, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v3
    const/4 v7, 0
    if-ne v0, v3, +00ah
    const/4 v3, 2
    invoke-static v7, v7, v3, v7, Landroidx/compose/runtime/SnapshotStateKt;->mutableStateOf$default(Ljava/lang/Object; Landroidx/compose/runtime/SnapshotMutationPolicy; I Ljava/lang/Object;)Landroidx/compose/runtime/MutableState;
    move-result-object v0
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object/from16 v20, v0
    check-cast v20, Landroidx/compose/runtime/MutableState;
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v0, -1878172725
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v0
    sget-object v3, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v3, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v3
    if-ne v0, v3, +013h
    int-to-float v0, v2
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v0
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->box-impl(F)Landroidx/compose/ui/unit/Dp;
    move-result-object v0
    const/4 v3, 2
    invoke-static v0, v7, v3, v7, Landroidx/compose/runtime/SnapshotStateKt;->mutableStateOf$default(Ljava/lang/Object; Landroidx/compose/runtime/SnapshotMutationPolicy; I Ljava/lang/Object;)Landroidx/compose/runtime/MutableState;
    move-result-object v0
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object/from16 v21, v0
    check-cast v21, Landroidx/compose/runtime/MutableState;
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v0, -1878170709
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v0
    sget-object v3, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v3, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v3
    if-ne v0, v3, +013h
    int-to-float v0, v2
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v0
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->box-impl(F)Landroidx/compose/ui/unit/Dp;
    move-result-object v0
    const/4 v3, 2
    invoke-static v0, v7, v3, v7, Landroidx/compose/runtime/SnapshotStateKt;->mutableStateOf$default(Ljava/lang/Object; Landroidx/compose/runtime/SnapshotMutationPolicy; I Ljava/lang/Object;)Landroidx/compose/runtime/MutableState;
    move-result-object v0
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object/from16 v22, v0
    check-cast v22, Landroidx/compose/runtime/MutableState;
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v0, -1878168628
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v0
    sget-object v3, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v3, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v3
    if-ne v0, v3, +00eh
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    const/4 v3, 2
    invoke-static v0, v7, v3, v7, Landroidx/compose/runtime/SnapshotStateKt;->mutableStateOf$default(Ljava/lang/Object; Landroidx/compose/runtime/SnapshotMutationPolicy; I Ljava/lang/Object;)Landroidx/compose/runtime/MutableState;
    move-result-object v0
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object/from16 v23, v0
    check-cast v23, Landroidx/compose/runtime/MutableState;
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v0, -1878166392
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v0
    sget-object v3, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v3, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v3
    if-ne v0, v3, +00ch
    new-instance v0, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    const/4 v3, 1
    invoke-direct v0, v7, v3, v7, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;-><init>(Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    goto +2h
    const/4 v3, 1
    move-object/from16 v19, v0
    check-cast v19, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    sget-object v0, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v0, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_logout(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v0
    new-array v3, v2, [Ljava/lang/Object;
    invoke-static v0, v3, v5, v2, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v3
    sget-object v0, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v0, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_logout_confirm_message(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v0
    new-array v7, v2, [Ljava/lang/Object;
    invoke-static v0, v7, v5, v2, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v7
    sget-object v0, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v0, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_cancel(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v0
    move-object/from16 v40, v4
    new-array v4, v2, [Ljava/lang/Object;
    invoke-static v0, v4, v5, v2, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v4
    sget-object v0, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v0, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_ok(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v0
    new-array v6, v2, [Ljava/lang/Object;
    invoke-static v0, v6, v5, v2, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v6
    invoke-static Landroidx/compose/ui/platform/CompositionLocalsKt;->getLocalDensity()Landroidx/compose/runtime/ProvidableCompositionLocal;
    move-result-object v0
    check-cast v0, Landroidx/compose/runtime/CompositionLocal;
    const v2, 2023513938
    const-string v8, "CC(<get-current>):CompositionLocal.kt#9igjgp"
    invoke-static v5, v2, v8, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->consume(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    move-object v8, v0
    check-cast v8, Landroidx/compose/ui/unit/Density;
    invoke-static/range v23, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsEntryContent$lambda$10(Landroidx/compose/runtime/MutableState;)Z
    move-result v0
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    const v0, -1878152726
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v5, v3, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v0
    invoke-interface v5, v7, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v25
    or-int v0, v0, v25
    invoke-interface v5, v4, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v25
    or-int v0, v0, v25
    invoke-interface v5, v6, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v25
    or-int v0, v0, v25
    const/high16 v25, 234881024
    and-int v1, v1, v25
    move-object/from16 v25, v2
    const/high16 v2, 67108864
    if-ne v1, v2, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    or-int/2addr v0, v1
    invoke-interface v5, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v1
    if-nez v0, +013h
    sget-object v0, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v0, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v0
    if-ne v1, v0, +003h
    goto +9h
    move-object/from16 v27, v40
    move-object v9, v5
    move-object/from16 v10, v25
    const/4 v11, 0
    const/4 v15, 1
    goto +29h
    new-instance v17, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;
    const/16 v26, 0
    move-object/from16 v0, v17
    move-object v1, v3
    move-object/from16 v3, v25
    const/4 v9, 0
    move-object v2, v7
    move-object v7, v3
    const/16 v24, 1
    move-object v3, v4
    move-object/from16 v27, v40
    move-object v4, v6
    move-object v6, v5
    move-object/from16 v5, v23
    move-object v9, v6
    move-object/from16 v6, v38
    move-object v10, v7
    move/from16 v15, v24
    const/4 v11, 0
    move-object/from16 v7, v26
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Landroidx/compose/runtime/MutableState; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    move-object/from16 v1, v17
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-interface v9, v1, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-interface v9, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/4 v0, 0
    invoke-static v10, v1, v9, v0, Landroidx/compose/runtime/EffectsKt;->LaunchedEffect(Ljava/lang/Object; Lkotlin/jvm/functions/Function2; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const v1, -1878134892
    invoke-interface v9, v1, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v9, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v1
    sget-object v2, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v2, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v2
    if-ne v1, v2, +00ah
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda9;
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda9;-><init>()V
    invoke-interface v9, v1, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v1, Lkotlin/jvm/functions/Function1;
    invoke-interface v9, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/16 v10, 54
    invoke-static v0, v1, v9, v10, Landroidx/compose/runtime/EffectsKt;->DisposableEffect(Ljava/lang/Object; Lkotlin/jvm/functions/Function1; Landroidx/compose/runtime/Composer; I)V
    const/4 v0, 0
    move-object/from16 v7, v27
    invoke-static v7, v0, v15, v11, Landroidx/compose/foundation/layout/SizeKt;->fillMaxSize$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    invoke-virtual/range v16, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getBackground-0d7_KjU()J
    move-result-wide v2
    const/4 v4, 0
    const/4 v5, 2
    const/4 v6, 0
    invoke-static/range v1 ... v6, Landroidx/compose/foundation/BackgroundKt;->background-bw27NRU$default(Landroidx/compose/ui/Modifier; J Landroidx/compose/ui/graphics/Shape; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v17
    const/16 v24, 0
    const/16 v25, 0
    new-instance v11, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;
    move-object v0, v11
    move-object/from16 v1, v18
    move-object/from16 v2, v30
    move-object/from16 v3, v16
    move-object/from16 v4, v33
    move-object/from16 v5, v36
    move-object/from16 v6, v37
    move-object/from16 v16, v7
    move-object/from16 v7, v39
    move-object/from16 v28, v9
    move-object/from16 v9, v20
    move-object/from16 v10, v23
    move-object/from16 v29, v11
    move-object/from16 v11, v21
    move-object/from16 v12, v22
    move-object/from16 v13, v19
    move-object/from16 v14, v34
    move-object/from16 v15, v35
    invoke-direct/range v0 ... v15, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;-><init>(Landroidx/compose/foundation/ScrollState; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/unit/Density; Landroidx/compose/runtime/MutableState; Landroidx/compose/runtime/MutableState; Landroidx/compose/runtime/MutableState; Landroidx/compose/runtime/MutableState; Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1;)V
    const v0, -108097301
    move-object/from16 v8, v28
    move-object/from16 v1, v29
    const/16 v2, 54
    const/4 v3, 1
    invoke-static v0, v3, v1, v8, v2, Landroidx/compose/runtime/internal/ComposableLambdaKt;->rememberComposableLambda(I Z Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Landroidx/compose/runtime/internal/ComposableLambda;
    move-result-object v0
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function3;
    const/16 v6, 3072
    const/4 v7, 6
    move-object/from16 v1, v17
    move-object/from16 v2, v24
    move/from16 v3, v25
    move-object v5, v8
    invoke-static/range v1 ... v7, Landroidx/compose/foundation/layout/BoxWithConstraintsKt;->BoxWithConstraints(Landroidx/compose/ui/Modifier; Landroidx/compose/ui/Alignment; Z Lkotlin/jvm/functions/Function3; Landroidx/compose/runtime/Composer; I I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    move-object/from16 v2, v16
    move-object/from16 v3, v18
    invoke-interface v8, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v13
    if-eqz v13, +01fh
    new-instance v14, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;
    move-object v0, v14
    move-object/from16 v1, v30
    move-object/from16 v4, v33
    move-object/from16 v5, v34
    move-object/from16 v6, v35
    move-object/from16 v7, v36
    move-object/from16 v8, v37
    move-object/from16 v9, v38
    move-object/from16 v10, v39
    move/from16 v11, v41
    move/from16 v12, v42
    invoke-direct/range v0 ... v12, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState; Landroidx/compose/ui/Modifier; Landroidx/compose/foundation/ScrollState; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; I I)V
    invoke-interface v13, v14, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final SettingsEntryContent$lambda$1(androidx.compose.runtime.MutableState)com.bytedance.trae.home.solo.setting.ui.SettingsPopupType
    .registers 1
    # ins_size=1
    check-cast v0, Landroidx/compose/runtime/State;
    invoke-interface v0, Landroidx/compose/runtime/State;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;
    return-object v0
.end method

.method private static final SettingsEntryContent$lambda$10(androidx.compose.runtime.MutableState)boolean
    .registers 1
    # ins_size=1
    check-cast v0, Landroidx/compose/runtime/State;
    invoke-interface v0, Landroidx/compose/runtime/State;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    return v0
.end method

.method private static final SettingsEntryContent$lambda$11(androidx.compose.runtime.MutableState  boolean)void
    .registers 2
    # ins_size=2
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v0, v1, Landroidx/compose/runtime/MutableState;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method private static final SettingsEntryContent$lambda$16$lambda$15(androidx.compose.runtime.DisposableEffectScope)androidx.compose.runtime.DisposableEffectResult
    .registers 2
    # ins_size=1
    const-string v0, "$this$DisposableEffect"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$lambda$16$lambda$15$$inlined$onDispose$1;
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$lambda$16$lambda$15$$inlined$onDispose$1;-><init>()V
    check-cast v1, Landroidx/compose/runtime/DisposableEffectResult;
    return-object v1
.end method

.method private static final SettingsEntryContent$lambda$17(com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryState  androidx.compose.ui.Modifier  androidx.compose.foundation.ScrollState  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 28
    # ins_size=14
    or-int/lit8 v0, v24, 1
    invoke-static v0, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v12
    move-object v1, v14
    move-object v2, v15
    move-object/from16 v3, v16
    move-object/from16 v4, v17
    move-object/from16 v5, v18
    move-object/from16 v6, v19
    move-object/from16 v7, v20
    move-object/from16 v8, v21
    move-object/from16 v9, v22
    move-object/from16 v10, v23
    move-object/from16 v11, v26
    move/from16 v13, v25
    invoke-static/range v1 ... v13, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsEntryContent(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState; Landroidx/compose/ui/Modifier; Landroidx/compose/foundation/ScrollState; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Landroidx/compose/runtime/Composer; I I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final SettingsEntryContent$lambda$2(androidx.compose.runtime.MutableState  com.bytedance.trae.home.solo.setting.ui.SettingsPopupType)void
    .registers 2
    # ins_size=2
    invoke-interface v0, v1, Landroidx/compose/runtime/MutableState;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method private static final SettingsEntryContent$lambda$4(androidx.compose.runtime.MutableState)float
    .registers 1
    # ins_size=1
    check-cast v0, Landroidx/compose/runtime/State;
    invoke-interface v0, Landroidx/compose/runtime/State;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroidx/compose/ui/unit/Dp;
    invoke-virtual v0, Landroidx/compose/ui/unit/Dp;->unbox-impl()F
    move-result v0
    return v0
.end method

.method private static final SettingsEntryContent$lambda$5(androidx.compose.runtime.MutableState  float)void
    .registers 2
    # ins_size=2
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->box-impl(F)Landroidx/compose/ui/unit/Dp;
    move-result-object v1
    invoke-interface v0, v1, Landroidx/compose/runtime/MutableState;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method private static final SettingsEntryContent$lambda$7(androidx.compose.runtime.MutableState)float
    .registers 1
    # ins_size=1
    check-cast v0, Landroidx/compose/runtime/State;
    invoke-interface v0, Landroidx/compose/runtime/State;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroidx/compose/ui/unit/Dp;
    invoke-virtual v0, Landroidx/compose/ui/unit/Dp;->unbox-impl()F
    move-result v0
    return v0
.end method

.method private static final SettingsEntryContent$lambda$8(androidx.compose.runtime.MutableState  float)void
    .registers 2
    # ins_size=2
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->box-impl(F)Landroidx/compose/ui/unit/Dp;
    move-result-object v1
    invoke-interface v0, v1, Landroidx/compose/runtime/MutableState;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method private static final SettingsFooter(com.bytedance.trae.home.solo.setting.viewmodel.SettingsFooterState  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  androidx.compose.runtime.Composer  int)void
    .registers 15
    # ins_size=4
    const v0, -132772300
    invoke-interface v13, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v13
    and-int/lit8 v1, v14, 6
    if-nez v1, +00dh
    invoke-interface v13, v11, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +004h
    const/4 v1, 4
    goto +2h
    const/4 v1, 2
    or-int/2addr v1, v14
    goto +2h
    move v1, v14
    and-int/lit8 v2, v14, 48
    if-nez v2, +00eh
    invoke-interface v13, v12, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +005h
    const/16 v2, 32
    goto +3h
    const/16 v2, 16
    or-int/2addr v1, v2
    and-int/lit8 v2, v1, 19
    const/16 v3, 18
    if-ne v2, v3, +00eh
    invoke-interface v13, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v2
    if-nez v2, +003h
    goto +6h
    invoke-interface v13, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    goto/16 +09bh
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v2
    if-eqz v2, +008h
    const/4 v2, -1
    const-string v3, "com.bytedance.trae.home.solo.setting.ui.SettingsFooter (SettingsEntry.kt:469)"
    invoke-static v0, v1, v2, v3, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    if-nez v11, +01ah
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v13, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v13
    if-eqz v13, +00ah
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda13;
    invoke-direct v0, v11, v12, v14, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda13;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; I)V
    invoke-interface v13, v0, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
    sget-object v0, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v0, Landroidx/compose/ui/Modifier;
    const/16 v2, 40
    int-to-float v2, v2
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v2
    invoke-static v0, v2, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v0
    const/4 v7, 6
    invoke-static v0, v13, v7, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v0, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_model_name(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v0
    const/4 v8, 0
    new-array v2, v8, [Ljava/lang/Object;
    invoke-static v0, v2, v13, v8, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v0
    const/4 v3, 0
    and-int/lit8 v9, v1, 112
    const/4 v6, 4
    move-object v1, v0
    move-object v2, v12
    move-object v4, v13
    move v5, v9
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->FooterText(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I I)V
    sget-object v0, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v0, Landroidx/compose/ui/Modifier;
    const/16 v1, 8
    int-to-float v10, v1
    invoke-static v10, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v1
    invoke-static v0, v1, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v0
    invoke-static v0, v13, v7, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v0, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_model_filing(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v0
    new-array v1, v8, [Ljava/lang/Object;
    invoke-static v0, v1, v13, v8, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v1
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->FooterText(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I I)V
    sget-object v0, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v0, Landroidx/compose/ui/Modifier;
    invoke-static v10, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v1
    invoke-static v0, v1, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v0
    invoke-static v0, v13, v7, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v0, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_icp_filing(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v0
    new-array v1, v8, [Ljava/lang/Object;
    invoke-static v0, v1, v13, v8, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v1
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->FooterText(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v13, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v13
    if-eqz v13, +00ah
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda14;
    invoke-direct v0, v11, v12, v14, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda14;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; I)V
    invoke-interface v13, v0, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final SettingsFooter$lambda$39(com.bytedance.trae.home.solo.setting.viewmodel.SettingsFooterState  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 5
    # ins_size=5
    or-int/lit8 v2, v2, 1
    invoke-static v2, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v2
    invoke-static v0, v1, v3, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsFooter(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final SettingsFooter$lambda$40(com.bytedance.trae.home.solo.setting.viewmodel.SettingsFooterState  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 5
    # ins_size=5
    or-int/lit8 v2, v2, 1
    invoke-static v2, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v2
    invoke-static v0, v1, v3, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsFooter(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final SettingsGroupView(com.bytedance.trae.home.solo.setting.viewmodel.SettingsGroup  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function2  androidx.compose.runtime.Composer  int)void
    .registers 31
    # ins_size=7
    move-object/from16 v4, v27
    move-object/from16 v5, v28
    move/from16 v6, v30
    const v0, 810577646
    move-object/from16 v1, v29
    invoke-interface v1, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v1
    and-int/lit8 v2, v6, 6
    const/4 v3, 4
    if-nez v2, +00fh
    move-object/from16 v2, v24
    invoke-interface v1, v2, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +004h
    move v7, v3
    goto +2h
    const/4 v7, 2
    or-int/2addr v7, v6
    goto +4h
    move-object/from16 v2, v24
    move v7, v6
    and-int/lit8 v8, v6, 48
    const/16 v9, 16
    move-object/from16 v15, v25
    if-nez v8, +00dh
    invoke-interface v1, v15, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +005h
    const/16 v8, 32
    goto +2h
    move v8, v9
    or-int/2addr v7, v8
    and-int/lit16 v8, v6, 384
    move-object/from16 v14, v26
    if-nez v8, +00eh
    invoke-interface v1, v14, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +005h
    const/16 v8, 256
    goto +3h
    const/16 v8, 128
    or-int/2addr v7, v8
    and-int/lit16 v8, v6, 3072
    if-nez v8, +00eh
    invoke-interface v1, v4, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +005h
    const/16 v8, 2048
    goto +3h
    const/16 v8, 1024
    or-int/2addr v7, v8
    and-int/lit16 v8, v6, 24576
    if-nez v8, +00eh
    invoke-interface v1, v5, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +005h
    const/16 v8, 16384
    goto +3h
    const/16 v8, 8192
    or-int/2addr v7, v8
    move v11, v7
    and-int/lit16 v7, v11, 9363
    const/16 v8, 9362
    if-ne v7, v8, +00eh
    invoke-interface v1, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v7
    if-nez v7, +003h
    goto +6h
    invoke-interface v1, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    goto/16 +232h
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v7
    if-eqz v7, +008h
    const/4 v7, -1
    const-string v8, "com.bytedance.trae.home.solo.setting.ui.SettingsGroupView (SettingsEntry.kt:441)"
    invoke-static v0, v11, v7, v8, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    invoke-virtual/range v24, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;->getItems()Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +027h
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v1, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v7
    if-eqz v7, +017h
    new-instance v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda4;
    move-object v0, v8
    move-object/from16 v1, v24
    move-object/from16 v2, v25
    move-object/from16 v3, v26
    move-object/from16 v4, v27
    move-object/from16 v5, v28
    move/from16 v6, v30
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2; I)V
    invoke-interface v7, v8, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
    sget-object v0, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v0, Landroidx/compose/ui/Modifier;
    const/4 v7, 0
    const/4 v10, 1
    const/4 v8, 0
    invoke-static v0, v7, v10, v8, Landroidx/compose/foundation/layout/SizeKt;->fillMaxWidth$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v16
    const/16 v17, 0
    const/16 v0, 12
    int-to-float v12, v0
    invoke-static v12, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v18
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 13
    const/16 v22, 0
    invoke-static/range v16 ... v22, Landroidx/compose/foundation/layout/PaddingKt;->padding-qDBjuR0$default(Landroidx/compose/ui/Modifier; F F F F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v12
    int-to-float v9, v9
    invoke-static v9, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v9
    invoke-static v9, Landroidx/compose/foundation/shape/RoundedCornerShapeKt;->RoundedCornerShape-0680j_4(F)Landroidx/compose/foundation/shape/RoundedCornerShape;
    move-result-object v9
    check-cast v9, Landroidx/compose/ui/graphics/Shape;
    invoke-static v12, v9, Landroidx/compose/ui/draw/ClipKt;->clip(Landroidx/compose/ui/Modifier; Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;
    move-result-object v16
    invoke-virtual/range v25, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getSurface-0d7_KjU()J
    move-result-wide v17
    const/16 v19, 0
    const/16 v20, 2
    const/16 v21, 0
    invoke-static/range v16 ... v21, Landroidx/compose/foundation/BackgroundKt;->background-bw27NRU$default(Landroidx/compose/ui/Modifier; J Landroidx/compose/ui/graphics/Shape; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v9
    int-to-float v3, v3
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v3
    invoke-static v9, v7, v3, v10, v8, Landroidx/compose/foundation/layout/PaddingKt;->padding-VpY3zN4$default(Landroidx/compose/ui/Modifier; F F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v3
    const v7, 1341605231
    const-string v9, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo"
    invoke-static v1, v7, v9, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v7, Landroidx/compose/foundation/layout/Arrangement;->INSTANCE Landroidx/compose/foundation/layout/Arrangement;
    invoke-virtual v7, Landroidx/compose/foundation/layout/Arrangement;->getTop()Landroidx/compose/foundation/layout/Arrangement$Vertical;
    move-result-object v7
    sget-object v9, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v9, Landroidx/compose/ui/Alignment$Companion;->getStart()Landroidx/compose/ui/Alignment$Horizontal;
    move-result-object v9
    const/4 v12, 0
    invoke-static v7, v9, v1, v12, Landroidx/compose/foundation/layout/ColumnKt;->columnMeasurePolicy(Landroidx/compose/foundation/layout/Arrangement$Vertical; Landroidx/compose/ui/Alignment$Horizontal; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v7
    const v9, -1159599143
    const-string v0, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh"
    invoke-static v1, v9, v0, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v1, v12, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v17
    invoke-static/range v17 ... v18, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    invoke-interface v1, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v9
    invoke-static v1, v3, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v3
    sget-object v17, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual/range v17, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v12
    const v13, -553112988
    const-string v8, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp"
    invoke-static v1, v13, v8, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v1, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v8
    instance-of v8, v8, Landroidx/compose/runtime/Applier;
    if-nez v8, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v1, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v1, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v8
    if-eqz v8, +006h
    invoke-interface v1, v12, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v1, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v1, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v8
    sget-object v12, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v12, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v12
    invoke-static v8, v7, v12, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v7
    invoke-static v8, v9, v7, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v7
    invoke-interface v8, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v9
    if-nez v9, +010h
    invoke-interface v8, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v9
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v12
    invoke-static v9, v12, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +010h
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    invoke-interface v8, v9, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-interface v8, v0, v7, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v0, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v0, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v0
    invoke-static v8, v3, v0, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v0, 2093002350
    const-string v3, "C89@4557L9:Column.kt#2w3rfo"
    invoke-static v1, v0, v3, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v0, Landroidx/compose/foundation/layout/ColumnScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/ColumnScopeInstance;
    check-cast v0, Landroidx/compose/foundation/layout/ColumnScope;
    const v0, 591589057
    invoke-interface v1, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-virtual/range v24, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;->getItems()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +0d3h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v7, v3
    check-cast v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->getKey()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    move-result-object v3
    const v8, 1898173863
    invoke-interface v1, v8, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v1, v3, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v3
    invoke-interface v1, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v8
    if-nez v3, +00dh
    sget-object v3, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v3, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v3
    if-ne v8, v3, +003h
    goto +3h
    const/4 v3, 0
    goto +ah
    new-instance v8, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    const/4 v3, 0
    invoke-direct v8, v3, v10, v3, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;-><init>(Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v1, v8, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object v12, v8
    check-cast v12, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    invoke-interface v1, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->getKey()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    move-result-object v8
    sget-object v9, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Message Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    if-ne v8, v9, +004h
    move v8, v10
    goto +2h
    const/4 v8, 0
    if-eqz v8, +004h
    move-object v9, v14
    goto +2h
    move-object v9, v3
    const v8, 1898181880
    invoke-interface v1, v8, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    and-int/lit16 v8, v11, 7168
    const/16 v13, 2048
    if-ne v8, v13, +004h
    move v8, v10
    goto +2h
    const/4 v8, 0
    invoke-interface v1, v7, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v17
    or-int v8, v8, v17
    invoke-interface v1, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v3
    if-nez v8, +00ah
    sget-object v8, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v8, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v8
    if-ne v3, v8, +00ah
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda5;
    invoke-direct v3, v4, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda5;-><init>(Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;)V
    invoke-interface v1, v3, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v3, Lkotlin/jvm/functions/Function0;
    invoke-interface v1, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v8, 1898185324
    invoke-interface v1, v8, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    const v8, 57344
    and-int/2addr v8, v11
    const/16 v13, 16384
    if-ne v8, v13, +004h
    move v8, v10
    goto +2h
    const/4 v8, 0
    invoke-interface v1, v7, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v20
    or-int v8, v8, v20
    invoke-interface v1, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v10
    if-nez v8, +00ah
    sget-object v8, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v8, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v8
    if-ne v10, v8, +00ah
    new-instance v10, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda6;
    invoke-direct v10, v5, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda6;-><init>(Lkotlin/jvm/functions/Function2; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;)V
    invoke-interface v1, v10, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object/from16 v20, v10
    check-cast v20, Lkotlin/jvm/functions/Function1;
    invoke-interface v1, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    and-int/lit8 v8, v11, 112
    sget v10, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;->$stable I
    const/16 v16, 12
    shl-int/lit8 v10, v10, 12
    or-int v21, v8, v10
    const/16 v19, 0
    move-object/from16 v8, v25
    const/16 v22, 1
    move-object v10, v3
    move v3, v11
    move-object v11, v12
    move/from16 v18, v13
    const/16 v23, 0
    move-object/from16 v12, v20
    const/16 v17, 2048
    move-object v13, v1
    move/from16 v14, v21
    invoke-static/range v7 ... v14, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsRow(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function1; Landroidx/compose/runtime/Composer; I)V
    move-object/from16 v14, v26
    move v11, v3
    move/from16 v10, v22
    goto/16 -0d5h
    invoke-interface v1, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v1, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v1, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v1, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v1, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v1, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v1, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v7
    if-eqz v7, +017h
    new-instance v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda7;
    move-object v0, v8
    move-object/from16 v1, v24
    move-object/from16 v2, v25
    move-object/from16 v3, v26
    move-object/from16 v4, v27
    move-object/from16 v5, v28
    move/from16 v6, v30
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2; I)V
    invoke-interface v7, v8, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final SettingsGroupView$lambda$29(com.bytedance.trae.home.solo.setting.viewmodel.SettingsGroup  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function2  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 15
    # ins_size=8
    or-int/lit8 v12, v12, 1
    invoke-static v12, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v6
    move-object v0, v7
    move-object v1, v8
    move-object v2, v9
    move-object v3, v10
    move-object v4, v11
    move-object v5, v13
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsGroupView(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2; Landroidx/compose/runtime/Composer; I)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method

.method private static final SettingsGroupView$lambda$37$lambda$36$lambda$33$lambda$32(kotlin.jvm.functions.Function1  com.bytedance.trae.home.solo.setting.viewmodel.SettingsItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->getKey()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    move-result-object v1
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final SettingsGroupView$lambda$37$lambda$36$lambda$35$lambda$34(kotlin.jvm.functions.Function2  com.bytedance.trae.home.solo.setting.viewmodel.SettingsItem  float)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->getKey()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    move-result-object v1
    invoke-static v2, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v2
    invoke-interface v0, v1, v2, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final SettingsGroupView$lambda$38(com.bytedance.trae.home.solo.setting.viewmodel.SettingsGroup  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function2  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 15
    # ins_size=8
    or-int/lit8 v12, v12, 1
    invoke-static v12, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v6
    move-object v0, v7
    move-object v1, v8
    move-object v2, v9
    move-object v3, v10
    move-object v4, v11
    move-object v5, v13
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsGroupView(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2; Landroidx/compose/runtime/Composer; I)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method

.method private static final SettingsItemIcon(org.jetbrains.compose.resources.DrawableResource  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  androidx.compose.runtime.Composer  int)void
    .registers 25
    # ins_size=4
    move-object/from16 v0, v21
    move-object/from16 v1, v22
    move/from16 v2, v24
    const v3, -1153017164
    move-object/from16 v4, v23
    invoke-interface v4, v3, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v14
    and-int/lit8 v4, v2, 6
    if-nez v4, +00dh
    invoke-interface v14, v0, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +004h
    const/4 v4, 4
    goto +2h
    const/4 v4, 2
    or-int/2addr v4, v2
    goto +2h
    move v4, v2
    and-int/lit8 v5, v2, 48
    if-nez v5, +00eh
    invoke-interface v14, v1, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +005h
    const/16 v5, 32
    goto +3h
    const/16 v5, 16
    or-int/2addr v4, v5
    and-int/lit8 v5, v4, 19
    const/16 v6, 18
    if-ne v5, v6, +00eh
    invoke-interface v14, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v5
    if-nez v5, +003h
    goto +6h
    invoke-interface v14, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    goto/16 +108h
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v5
    if-eqz v5, +008h
    const/4 v5, -1
    const-string v6, "com.bytedance.trae.home.solo.setting.ui.SettingsItemIcon (SettingsEntry.kt:580)"
    invoke-static v3, v4, v5, v6, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    sget-object v3, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v3, Landroidx/compose/ui/Modifier;
    sget v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsItemIconSlotSize F
    invoke-static v3, v5, Landroidx/compose/foundation/layout/SizeKt;->size-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v3
    sget-object v5, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v5, Landroidx/compose/ui/Alignment$Companion;->getCenter()Landroidx/compose/ui/Alignment;
    move-result-object v5
    const v6, 1042775818
    const-string v7, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo"
    invoke-static v14, v6, v7, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    const/4 v6, 0
    invoke-static v5, v6, Landroidx/compose/foundation/layout/BoxKt;->maybeCachedBoxMeasurePolicy(Landroidx/compose/ui/Alignment; Z)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v5
    const v7, -1159599143
    const-string v8, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh"
    invoke-static v14, v7, v8, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v14, v6, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v6
    invoke-static v6, v7, Ljava/lang/Long;->hashCode(J)I
    move-result v6
    invoke-interface v14, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v7
    invoke-static v14, v3, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v3
    sget-object v8, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v8, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v8
    const v9, -553112988
    const-string v10, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp"
    invoke-static v14, v9, v10, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v14, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v9
    instance-of v9, v9, Landroidx/compose/runtime/Applier;
    if-nez v9, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v14, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v14, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v9
    if-eqz v9, +006h
    invoke-interface v14, v8, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v14, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v14, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v8
    sget-object v9, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v9, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v9
    invoke-static v8, v5, v9, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-static v8, v7, v5, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-interface v8, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v7
    if-nez v7, +010h
    invoke-interface v8, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v7
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    invoke-static v7, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-nez v7, +010h
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    invoke-interface v8, v7, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-interface v8, v6, v5, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-static v8, v3, v5, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v3, 1833054614
    const-string v5, "C72@3469L9:Box.kt#2w3rfo"
    invoke-static v14, v3, v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v3, Landroidx/compose/foundation/layout/BoxScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/BoxScopeInstance;
    check-cast v3, Landroidx/compose/foundation/layout/BoxScope;
    and-int/lit8 v3, v4, 14
    invoke-static v0, v14, v3, Lorg/jetbrains/compose/resources/ImageResources_androidKt;->painterResource(Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/graphics/painter/Painter;
    move-result-object v4
    const/4 v5, 0
    sget-object v3, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v3, Landroidx/compose/ui/Modifier;
    sget v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsItemIconSize F
    invoke-static v3, v6, Landroidx/compose/foundation/layout/SizeKt;->size-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v6
    const/4 v7, 0
    sget-object v3, Landroidx/compose/ui/layout/ContentScale;->Companion Landroidx/compose/ui/layout/ContentScale$Companion;
    invoke-virtual v3, Landroidx/compose/ui/layout/ContentScale$Companion;->getFillBounds()Landroidx/compose/ui/layout/ContentScale;
    move-result-object v8
    const/4 v9, 0
    sget-object v15, Landroidx/compose/ui/graphics/ColorFilter;->Companion Landroidx/compose/ui/graphics/ColorFilter$Companion;
    invoke-virtual/range v22, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getIconDefault-0d7_KjU()J
    move-result-wide v16
    const/16 v18, 0
    const/16 v19, 2
    const/16 v20, 0
    invoke-static/range v15 ... v20, Landroidx/compose/ui/graphics/ColorFilter$Companion;->tint-xETnrds$default(Landroidx/compose/ui/graphics/ColorFilter$Companion; J I I Ljava/lang/Object;)Landroidx/compose/ui/graphics/ColorFilter;
    move-result-object v10
    const/16 v12, 25008
    const/16 v13, 40
    move-object v11, v14
    invoke-static/range v4 ... v13, Landroidx/compose/foundation/ImageKt;->Image(Landroidx/compose/ui/graphics/painter/Painter; Ljava/lang/String; Landroidx/compose/ui/Modifier; Landroidx/compose/ui/Alignment; Landroidx/compose/ui/layout/ContentScale; F Landroidx/compose/ui/graphics/ColorFilter; Landroidx/compose/runtime/Composer; I I)V
    invoke-static v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v3
    if-eqz v3, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v3
    if-eqz v3, +00ah
    new-instance v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda19;
    invoke-direct v4, v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda19;-><init>(Lorg/jetbrains/compose/resources/DrawableResource; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; I)V
    invoke-interface v3, v4, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final SettingsItemIcon$lambda$48(org.jetbrains.compose.resources.DrawableResource  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 5
    # ins_size=5
    or-int/lit8 v2, v2, 1
    invoke-static v2, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v2
    invoke-static v0, v1, v3, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsItemIcon(Lorg/jetbrains/compose/resources/DrawableResource; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final SettingsRow(com.bytedance.trae.home.solo.setting.viewmodel.SettingsItem  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  java.lang.String  kotlin.jvm.functions.Function0  com.bytedance.trae.kmp.ui.KmpClickHandler  kotlin.jvm.functions.Function1  androidx.compose.runtime.Composer  int)void
    .registers 44
    # ins_size=8
    move-object/from16 v1, v36
    move-object/from16 v2, v37
    move-object/from16 v3, v38
    move-object/from16 v4, v39
    move-object/from16 v5, v40
    move-object/from16 v6, v41
    move/from16 v7, v43
    const v0, 369941886
    move-object/from16 v8, v42
    invoke-interface v8, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v15
    and-int/lit8 v8, v7, 6
    if-nez v8, +00dh
    invoke-interface v15, v1, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +004h
    const/4 v8, 4
    goto +2h
    const/4 v8, 2
    or-int/2addr v8, v7
    goto +2h
    move v8, v7
    and-int/lit8 v9, v7, 48
    const/16 v10, 16
    if-nez v9, +00dh
    invoke-interface v15, v2, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +005h
    const/16 v9, 32
    goto +2h
    move v9, v10
    or-int/2addr v8, v9
    and-int/lit16 v9, v7, 384
    if-nez v9, +00eh
    invoke-interface v15, v3, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +005h
    const/16 v9, 256
    goto +3h
    const/16 v9, 128
    or-int/2addr v8, v9
    and-int/lit16 v9, v7, 3072
    if-nez v9, +00eh
    invoke-interface v15, v4, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +005h
    const/16 v9, 2048
    goto +3h
    const/16 v9, 1024
    or-int/2addr v8, v9
    and-int/lit16 v9, v7, 24576
    if-nez v9, +019h
    const v9, 32768
    and-int/2addr v9, v7
    if-nez v9, +007h
    invoke-interface v15, v5, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v9
    goto +5h
    invoke-interface v15, v5, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +005h
    const/16 v9, 16384
    goto +3h
    const/16 v9, 8192
    or-int/2addr v8, v9
    const/high16 v9, 196608
    and-int/2addr v9, v7
    const/high16 v11, 131072
    if-nez v9, +00dh
    invoke-interface v15, v6, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +004h
    move v9, v11
    goto +3h
    const/high16 v9, 65536
    or-int/2addr v8, v9
    move v12, v8
    const v8, 74899
    and-int/2addr v8, v12
    const v9, 74898
    if-ne v8, v9, +00fh
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v8
    if-nez v8, +003h
    goto +7h
    invoke-interface v15, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    move-object v5, v15
    goto/16 +300h
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v8
    if-eqz v8, +008h
    const/4 v8, -1
    const-string v9, "com.bytedance.trae.home.solo.setting.ui.SettingsRow (SettingsEntry.kt:513)"
    invoke-static v0, v12, v8, v9, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v8, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v0, v15, v8, Lcom/bytedance/trae/design/compose/TraeTheme;->getTypography(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeTypography;
    move-result-object v0
    sget-object v8, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v8, Landroidx/compose/ui/Modifier;
    const/4 v9, 0
    const/4 v13, 0
    const/4 v14, 1
    invoke-static v8, v9, v14, v13, Landroidx/compose/foundation/layout/SizeKt;->fillMaxWidth$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v8
    sget v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsItemHeight F
    invoke-static v8, v9, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v8
    const v9, 1428042622
    invoke-interface v15, v9, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    const/high16 v9, 458752
    and-int/2addr v9, v12
    const/4 v13, 0
    if-ne v9, v11, +004h
    move v9, v14
    goto +2h
    move v9, v13
    invoke-interface v15, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v11
    if-nez v9, +00ah
    sget-object v9, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v9, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v9
    if-ne v11, v9, +00ah
    new-instance v11, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda1;
    invoke-direct v11, v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/functions/Function1;)V
    invoke-interface v15, v11, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v11, Lkotlin/jvm/functions/Function1;
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v8, v11, Landroidx/compose/ui/layout/OnGloballyPositionedModifierKt;->onGloballyPositioned(Landroidx/compose/ui/Modifier; Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;
    move-result-object v8
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->getClickable()Z
    move-result v9
    if-eqz v9, +00bh
    sget-object v9, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v9, Landroidx/compose/ui/Modifier;
    invoke-static v9, v5, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsScaffoldKt;->noRippleClickable(Landroidx/compose/ui/Modifier; Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function0;)Landroidx/compose/ui/Modifier;
    move-result-object v9
    goto +5h
    sget-object v9, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v9, Landroidx/compose/ui/Modifier;
    invoke-interface v8, v9, Landroidx/compose/ui/Modifier;->then(Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v16
    int-to-float v9, v10
    invoke-static v9, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v17
    const/16 v18, 0
    const/16 v8, 12
    int-to-float v8, v8
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v19
    const/16 v20, 0
    const/16 v21, 10
    const/16 v22, 0
    invoke-static/range v16 ... v22, Landroidx/compose/foundation/layout/PaddingKt;->padding-qDBjuR0$default(Landroidx/compose/ui/Modifier; F F F F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v8
    sget-object v10, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v10, Landroidx/compose/ui/Alignment$Companion;->getCenterVertically()Landroidx/compose/ui/Alignment$Vertical;
    move-result-object v10
    const v11, 844473419
    const-string v14, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo"
    invoke-static v15, v11, v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v11, Landroidx/compose/foundation/layout/Arrangement;->INSTANCE Landroidx/compose/foundation/layout/Arrangement;
    invoke-virtual v11, Landroidx/compose/foundation/layout/Arrangement;->getStart()Landroidx/compose/foundation/layout/Arrangement$Horizontal;
    move-result-object v11
    const/16 v14, 48
    invoke-static v11, v10, v15, v14, Landroidx/compose/foundation/layout/RowKt;->rowMeasurePolicy(Landroidx/compose/foundation/layout/Arrangement$Horizontal; Landroidx/compose/ui/Alignment$Vertical; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v10
    const v11, -1159599143
    const-string v14, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh"
    invoke-static v15, v11, v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v15, v13, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v17
    invoke-static/range v17 ... v18, Ljava/lang/Long;->hashCode(J)I
    move-result v11
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v14
    invoke-static v15, v8, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v8
    sget-object v17, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual/range v17, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v13
    const v4, -553112988
    const-string v5, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp"
    invoke-static v15, v4, v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v4
    instance-of v4, v4, Landroidx/compose/runtime/Applier;
    if-nez v4, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v4
    if-eqz v4, +006h
    invoke-interface v15, v13, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v15, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v15, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v4
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-static v4, v10, v5, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-static v4, v14, v5, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-interface v4, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v10
    if-nez v10, +010h
    invoke-interface v4, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v10
    invoke-static v11, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v13
    invoke-static v10, v13, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v10
    if-nez v10, +010h
    invoke-static v11, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v10
    invoke-interface v4, v10, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v11, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v10
    invoke-interface v4, v10, v5, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-static v4, v8, v5, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v4, 1456264949
    const-string v5, "C101@5233L9:Row.kt#2w3rfo"
    invoke-static v15, v4, v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v4, Landroidx/compose/foundation/layout/RowScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/RowScopeInstance;
    move-object/from16 v19, v4
    check-cast v19, Landroidx/compose/foundation/layout/RowScope;
    const v4, -458697668
    invoke-interface v15, v4, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->getKey()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    move-result-object v4
    invoke-static v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->iconResource(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v4
    and-int/lit8 v5, v12, 112
    invoke-static v4, v2, v15, v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsItemIcon(Lorg/jetbrains/compose/resources/DrawableResource; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Landroidx/compose/runtime/Composer; I)V
    sget-object v4, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v4, Landroidx/compose/ui/Modifier;
    const/16 v8, 8
    int-to-float v14, v8
    invoke-static v14, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v8
    invoke-static v4, v8, Landroidx/compose/foundation/layout/SizeKt;->width-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v4
    const/4 v13, 6
    invoke-static v4, v15, v13, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->getKey()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    move-result-object v4
    invoke-static v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->titleResource(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v4
    const/4 v10, 0
    new-array v8, v10, [Ljava/lang/Object;
    invoke-static v4, v8, v15, v10, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v8
    invoke-virtual/range v37, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getPrimaryText-0d7_KjU()J
    move-result-wide v17
    move v4, v10
    move-wide/from16 v10, v17
    invoke-virtual v0, Lcom/bytedance/trae/design/compose/TraeTypography;->getBodyBase()Landroidx/compose/ui/text/TextStyle;
    move-result-object v28
    sget-object v17, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    move-object/from16 v20, v17
    check-cast v20, Landroidx/compose/ui/Modifier;
    const/high16 v21, 1065353216
    const/16 v22, 0
    const/16 v23, 2
    const/16 v24, 0
    invoke-static/range v19 ... v24, Landroidx/compose/foundation/layout/RowScope;->weight$default(Landroidx/compose/foundation/layout/RowScope; Landroidx/compose/ui/Modifier; F Z I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v17
    move/from16 v33, v9
    move-object/from16 v9, v17
    const-wide/16 v17, 0
    move v4, v12
    move-wide/from16 v12, v17
    const/16 v17, 0
    move/from16 v35, v14
    const/16 v34, 1
    move-object/from16 v14, v17
    const/16 v16, 0
    move-object/from16 v42, v15
    move-object/from16 v15, v16
    const-wide/16 v17, 0
    const/16 v19, 0
    const/16 v20, 0
    const-wide/16 v21, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v30, 0
    const/16 v31, 0
    const v32, 65528
    move-object/from16 v29, v42
    invoke-static/range v8 ... v32, Landroidx/compose/material3/TextKt;->Text--4IGK_g(Ljava/lang/String; Landroidx/compose/ui/Modifier; J J Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontFamily; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/text/style/TextAlign; J I Z I I Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/runtime/Composer; I I I)V
    const v8, -2092996242
    move-object/from16 v15, v42
    invoke-interface v15, v8, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->getKey()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    move-result-object v8
    sget-object v9, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Subscribe Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    if-ne v8, v9, +012h
    shr-int/lit8 v0, v4, 3
    and-int/lit8 v0, v0, 14
    invoke-static v2, v15, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->UpgradeButton(Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Landroidx/compose/runtime/Composer; I)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    move-object v5, v15
    goto/16 +10fh
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v8, -2092992089
    invoke-interface v15, v8, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->getKey()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    move-result-object v8
    sget-object v9, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Usage Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    if-ne v8, v9, +01ch
    shr-int/lit8 v8, v4, 3
    and-int/lit8 v8, v8, 14
    invoke-static v2, v15, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->UsageTrailing(Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Landroidx/compose/runtime/Composer; I)V
    sget-object v8, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v8, Landroidx/compose/ui/Modifier;
    const/4 v14, 4
    int-to-float v9, v14
    invoke-static v9, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v9
    invoke-static v8, v9, Landroidx/compose/foundation/layout/SizeKt;->width-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v8
    const/4 v12, 6
    invoke-static v8, v15, v12, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    goto +3h
    const/4 v12, 6
    const/4 v14, 4
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v8, -2092987148
    invoke-interface v15, v8, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    move-object v8, v3
    check-cast v8, Ljava/lang/CharSequence;
    if-eqz v8, +00bh
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    if-eqz v8, +003h
    goto +3h
    const/16 v34, 0
    if-nez v34, +019h
    shr-int/lit8 v8, v4, 6
    and-int/lit8 v8, v8, 14
    or-int/2addr v5, v8
    invoke-static v3, v2, v15, v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->UnreadBadge(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Landroidx/compose/runtime/Composer; I)V
    sget-object v5, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v5, Landroidx/compose/ui/Modifier;
    invoke-static/range v35, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v8
    invoke-static v5, v8, Landroidx/compose/foundation/layout/SizeKt;->width-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v5
    invoke-static v5, v15, v12, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->getKey()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    move-result-object v5
    and-int/lit8 v4, v4, 14
    invoke-static v1, v5, v15, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->trailingText(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v8
    const v4, -2092979460
    invoke-interface v15, v4, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    if-nez v8, +004h
    move-object v5, v15
    goto +4ah
    invoke-virtual/range v37, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getTertiaryText-0d7_KjU()J
    move-result-wide v10
    invoke-virtual v0, Lcom/bytedance/trae/design/compose/TraeTypography;->getBodyXs()Landroidx/compose/ui/text/TextStyle;
    move-result-object v28
    sget-object v0, Landroidx/compose/ui/text/style/TextOverflow;->Companion Landroidx/compose/ui/text/style/TextOverflow$Companion;
    invoke-virtual v0, Landroidx/compose/ui/text/style/TextOverflow$Companion;->getEllipsis-gIe3tQ8()I
    move-result v23
    const/4 v9, 0
    const-wide/16 v4, 0
    move v0, v12
    move-wide v12, v4
    const/4 v4, 0
    move v5, v14
    move-object v14, v4
    move-object/from16 v42, v15
    move-object v15, v4
    const/16 v16, 0
    const-wide/16 v17, 0
    const/16 v19, 0
    const/16 v20, 0
    const-wide/16 v21, 0
    const/16 v24, 0
    const/16 v25, 1
    const/16 v26, 0
    const/16 v27, 0
    const/16 v30, 0
    const/16 v31, 3120
    const v32, 55290
    move-object/from16 v29, v42
    invoke-static/range v8 ... v32, Landroidx/compose/material3/TextKt;->Text--4IGK_g(Ljava/lang/String; Landroidx/compose/ui/Modifier; J J Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontFamily; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/text/style/TextAlign; J I Z I I Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/runtime/Composer; I I I)V
    sget-object v4, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v4, Landroidx/compose/ui/Modifier;
    int-to-float v5, v5
    invoke-static v5, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v5
    invoke-static v4, v5, Landroidx/compose/foundation/layout/SizeKt;->width-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v4
    move-object/from16 v5, v42
    invoke-static v4, v5, v0, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v0, -2092969729
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->getDestructive()Z
    move-result v0
    if-nez v0, +03dh
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->getShowTrailingIcon()Z
    move-result v0
    if-eqz v0, +037h
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->getKey()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    move-result-object v0
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->trailingIconResource(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v0
    const/4 v4, 0
    invoke-static v0, v5, v4, Lorg/jetbrains/compose/resources/ImageResources_androidKt;->painterResource(Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/graphics/painter/Painter;
    move-result-object v8
    const/4 v9, 0
    sget-object v0, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v0, Landroidx/compose/ui/Modifier;
    invoke-static/range v33, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v4
    invoke-static v0, v4, Landroidx/compose/foundation/layout/SizeKt;->size-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v10
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    sget-object v14, Landroidx/compose/ui/graphics/ColorFilter;->Companion Landroidx/compose/ui/graphics/ColorFilter$Companion;
    invoke-virtual/range v37, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getIconTertiary-0d7_KjU()J
    move-result-wide v15
    const/16 v17, 0
    const/16 v18, 2
    const/16 v19, 0
    invoke-static/range v14 ... v19, Landroidx/compose/ui/graphics/ColorFilter$Companion;->tint-xETnrds$default(Landroidx/compose/ui/graphics/ColorFilter$Companion; J I I Ljava/lang/Object;)Landroidx/compose/ui/graphics/ColorFilter;
    move-result-object v14
    const/16 v16, 432
    const/16 v17, 56
    move-object v15, v5
    invoke-static/range v8 ... v17, Landroidx/compose/foundation/ImageKt;->Image(Landroidx/compose/ui/graphics/painter/Painter; Ljava/lang/String; Landroidx/compose/ui/Modifier; Landroidx/compose/ui/Alignment; Landroidx/compose/ui/layout/ContentScale; F Landroidx/compose/ui/graphics/ColorFilter; Landroidx/compose/runtime/Composer; I I)V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v8
    if-eqz v8, +019h
    new-instance v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda2;
    move-object v0, v9
    move-object/from16 v1, v36
    move-object/from16 v2, v37
    move-object/from16 v3, v38
    move-object/from16 v4, v39
    move-object/from16 v5, v40
    move-object/from16 v6, v41
    move/from16 v7, v43
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function1; I)V
    invoke-interface v8, v9, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final SettingsRow$lambda$43$lambda$42(kotlin.jvm.functions.Function1  androidx.compose.ui.layout.LayoutCoordinates)kotlin.Unit
    .registers 6
    # ins_size=2
    const-string v0, "it"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v5, Landroidx/compose/ui/layout/LayoutCoordinatesKt;->positionInRoot(Landroidx/compose/ui/layout/LayoutCoordinates;)J
    move-result-wide v0
    const-wide v2, 4294967295
    and-long/2addr v0, v2
    long-to-int v5, v0
    invoke-static v5, Ljava/lang/Float;->intBitsToFloat(I)F
    move-result v5
    invoke-static v5, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v5
    invoke-interface v4, v5, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method

.method private static final SettingsRow$lambda$46(com.bytedance.trae.home.solo.setting.viewmodel.SettingsItem  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  java.lang.String  kotlin.jvm.functions.Function0  com.bytedance.trae.kmp.ui.KmpClickHandler  kotlin.jvm.functions.Function1  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 18
    # ins_size=9
    or-int/lit8 v0, v15, 1
    invoke-static v0, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v8
    move-object v1, v9
    move-object v2, v10
    move-object v3, v11
    move-object v4, v12
    move-object v5, v13
    move-object v6, v14
    move-object/from16 v7, v16
    invoke-static/range v1 ... v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsRow(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function1; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final TextBadge(java.lang.String  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  com.bytedance.trae.home.solo.setting.ui.SettingsTextBadgeStyle  androidx.compose.runtime.Composer  int)void
    .registers 34
    # ins_size=5
    move-object/from16 v2, v29
    move-object/from16 v3, v30
    move-object/from16 v0, v31
    move/from16 v15, v33
    const v1, -1031772878
    move-object/from16 v4, v32
    invoke-interface v4, v1, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v13
    and-int/lit8 v4, v15, 6
    const/4 v5, 4
    const/4 v6, 2
    if-nez v4, +00dh
    invoke-interface v13, v2, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +004h
    move v4, v5
    goto +2h
    move v4, v6
    or-int/2addr v4, v15
    goto +2h
    move v4, v15
    and-int/lit8 v7, v15, 48
    if-nez v7, +00eh
    invoke-interface v13, v3, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +005h
    const/16 v7, 32
    goto +3h
    const/16 v7, 16
    or-int/2addr v4, v7
    and-int/lit16 v7, v15, 384
    if-nez v7, +00eh
    invoke-interface v13, v0, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +005h
    const/16 v7, 256
    goto +3h
    const/16 v7, 128
    or-int/2addr v4, v7
    move v14, v4
    and-int/lit16 v4, v14, 147
    const/16 v7, 146
    if-ne v4, v7, +010h
    invoke-interface v13, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v4
    if-nez v4, +003h
    goto +8h
    invoke-interface v13, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    move-object/from16 v25, v13
    goto/16 +188h
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v4
    if-eqz v4, +008h
    const/4 v4, -1
    const-string v7, "com.bytedance.trae.home.solo.setting.ui.TextBadge (SettingsEntry.kt:406)"
    invoke-static v1, v14, v4, v7, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v4, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v1, v13, v4, Lcom/bytedance/trae/design/compose/TraeTheme;->getTypography(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeTypography;
    move-result-object v20
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;->Free Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;
    const/4 v4, 1
    const/4 v7, 0
    if-ne v0, v1, +004h
    move v1, v4
    goto +2h
    move v1, v7
    sget-object v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual/range v31, Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;->ordinal()I
    move-result v9
    aget v8, v8, v9
    const/4 v9, 3
    if-eq v8, v4, +016h
    if-eq v8, v6, +00fh
    if-ne v8, v9, +007h
    invoke-virtual/range v30, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getEnterpriseBadgeBackground-0d7_KjU()J
    move-result-wide v10
    goto +10h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    invoke-virtual/range v30, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getBadgeBackground-0d7_KjU()J
    move-result-wide v10
    goto +5h
    invoke-virtual/range v30, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getFreeBadgeBackground-0d7_KjU()J
    move-result-wide v10
    move-wide/from16 v22, v10
    sget-object v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual/range v31, Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;->ordinal()I
    move-result v10
    aget v8, v8, v10
    if-eq v8, v4, +016h
    if-eq v8, v6, +00fh
    if-ne v8, v9, +007h
    invoke-virtual/range v30, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getEnterpriseBadgeText-0d7_KjU()J
    move-result-wide v8
    goto +10h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    invoke-virtual/range v30, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getBadgeText-0d7_KjU()J
    move-result-wide v8
    goto +5h
    invoke-virtual/range v30, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getFreeBadgeText-0d7_KjU()J
    move-result-wide v8
    move-wide/from16 v27, v8
    sget-object v4, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v4, Landroidx/compose/ui/Modifier;
    if-eqz v1, +004h
    int-to-float v1, v5
    goto +4h
    const/16 v1, 999
    int-to-float v1, v1
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v1
    invoke-static v1, Landroidx/compose/foundation/shape/RoundedCornerShapeKt;->RoundedCornerShape-0680j_4(F)Landroidx/compose/foundation/shape/RoundedCornerShape;
    move-result-object v1
    check-cast v1, Landroidx/compose/ui/graphics/Shape;
    invoke-static v4, v1, Landroidx/compose/ui/draw/ClipKt;->clip(Landroidx/compose/ui/Modifier; Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;
    move-result-object v21
    const/16 v24, 0
    const/16 v25, 2
    const/16 v26, 0
    invoke-static/range v21 ... v26, Landroidx/compose/foundation/BackgroundKt;->background-bw27NRU$default(Landroidx/compose/ui/Modifier; J Landroidx/compose/ui/graphics/Shape; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    const/4 v4, 6
    int-to-float v4, v4
    invoke-static v4, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v4
    int-to-float v5, v6
    invoke-static v5, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v5
    invoke-static v1, v4, v5, Landroidx/compose/foundation/layout/PaddingKt;->padding-VpY3zN4(Landroidx/compose/ui/Modifier; F F)Landroidx/compose/ui/Modifier;
    move-result-object v1
    sget-object v4, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v4, Landroidx/compose/ui/Alignment$Companion;->getCenter()Landroidx/compose/ui/Alignment;
    move-result-object v4
    const v5, 1042775818
    const-string v6, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo"
    invoke-static v13, v5, v6, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v4, v7, Landroidx/compose/foundation/layout/BoxKt;->maybeCachedBoxMeasurePolicy(Landroidx/compose/ui/Alignment; Z)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v4
    const v5, -1159599143
    const-string v6, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh"
    invoke-static v13, v5, v6, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v13, v7, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v5
    invoke-static v5, v6, Ljava/lang/Long;->hashCode(J)I
    move-result v5
    invoke-interface v13, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v6
    invoke-static v13, v1, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v7
    const v8, -553112988
    const-string v9, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp"
    invoke-static v13, v8, v9, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v13, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v8
    instance-of v8, v8, Landroidx/compose/runtime/Applier;
    if-nez v8, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v13, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v13, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v8
    if-eqz v8, +006h
    invoke-interface v13, v7, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v13, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v13, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v7
    sget-object v8, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v8, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v8
    invoke-static v7, v4, v8, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v4, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v4, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v4
    invoke-static v7, v6, v4, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v4, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v4, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v4
    invoke-interface v7, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v6
    if-nez v6, +010h
    invoke-interface v7, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v6
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-static v6, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +010h
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-interface v7, v6, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    invoke-interface v7, v5, v4, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v4, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v4, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v4
    invoke-static v7, v1, v4, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v1, 1833054614
    const-string v4, "C72@3469L9:Box.kt#2w3rfo"
    invoke-static v13, v1, v4, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v1, Landroidx/compose/foundation/layout/BoxScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/BoxScopeInstance;
    check-cast v1, Landroidx/compose/foundation/layout/BoxScope;
    const/4 v1, 0
    const-wide/16 v4, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const-wide/16 v9, 0
    const/4 v11, 0
    const/4 v12, 0
    const-wide/16 v16, 0
    move-object/from16 v25, v13
    move/from16 v21, v14
    move-wide/from16 v13, v16
    const/16 v16, 0
    move/from16 v15, v16
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    invoke-virtual/range v20, Lcom/bytedance/trae/design/compose/TraeTypography;->getCaptionXsStrong()Landroidx/compose/ui/text/TextStyle;
    move-result-object v20
    and-int/lit8 v22, v21, 14
    const/16 v23, 0
    const v24, 65530
    move-object/from16 v0, v29
    move-wide/from16 v2, v27
    move-object/from16 v21, v25
    invoke-static/range v0 ... v24, Landroidx/compose/material3/TextKt;->Text--4IGK_g(Ljava/lang/String; Landroidx/compose/ui/Modifier; J J Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontFamily; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/text/style/TextAlign; J I Z I I Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/runtime/Composer; I I I)V
    invoke-static/range v25, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface/range v25, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static/range v25, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static/range v25, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static/range v25, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface/range v25, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v0
    if-eqz v0, +012h
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda15;
    move-object/from16 v2, v29
    move-object/from16 v3, v30
    move-object/from16 v4, v31
    move/from16 v5, v33
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda15;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle; I)V
    invoke-interface v0, v1, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final TextBadge$lambda$28(java.lang.String  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  com.bytedance.trae.home.solo.setting.ui.SettingsTextBadgeStyle  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 6
    # ins_size=6
    or-int/lit8 v3, v3, 1
    invoke-static v3, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v3
    invoke-static v0, v1, v2, v4, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->TextBadge(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final UnreadBadge(java.lang.String  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  androidx.compose.runtime.Composer  int)void
    .registers 31
    # ins_size=4
    move-object/from16 v0, v27
    move-object/from16 v15, v28
    move/from16 v13, v30
    const v1, -452901904
    move-object/from16 v2, v29
    invoke-interface v2, v1, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v14
    and-int/lit8 v2, v13, 6
    const/4 v3, 4
    const/4 v4, 2
    if-nez v2, +00dh
    invoke-interface v14, v0, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +004h
    move v2, v3
    goto +2h
    move v2, v4
    or-int/2addr v2, v13
    goto +2h
    move v2, v13
    and-int/lit8 v5, v13, 48
    const/16 v6, 16
    if-nez v5, +00dh
    invoke-interface v14, v15, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +005h
    const/16 v5, 32
    goto +2h
    move v5, v6
    or-int/2addr v2, v5
    and-int/lit8 v5, v2, 19
    const/16 v7, 18
    if-ne v5, v7, +010h
    invoke-interface v14, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v5
    if-nez v5, +003h
    goto +8h
    invoke-interface v14, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    move-object/from16 v25, v14
    goto/16 +16dh
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v5
    if-eqz v5, +008h
    const/4 v5, -1
    const-string v7, "com.bytedance.trae.home.solo.setting.ui.UnreadBadge (SettingsEntry.kt:665)"
    invoke-static v1, v2, v5, v7, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v5, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v1, v14, v5, Lcom/bytedance/trae/design/compose/TraeTheme;->getTypography(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeTypography;
    move-result-object v20
    sget-object v1, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v1, Landroidx/compose/ui/Modifier;
    int-to-float v5, v6
    invoke-static v5, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v5
    const/4 v6, 0
    const/4 v7, 0
    invoke-static v1, v5, v6, v4, v7, Landroidx/compose/foundation/layout/SizeKt;->heightIn-VpY3zN4$default(Landroidx/compose/ui/Modifier; F F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    const/16 v5, 8
    int-to-float v5, v5
    invoke-static v5, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v5
    invoke-static v5, Landroidx/compose/foundation/shape/RoundedCornerShapeKt;->RoundedCornerShape-0680j_4(F)Landroidx/compose/foundation/shape/RoundedCornerShape;
    move-result-object v5
    check-cast v5, Landroidx/compose/ui/graphics/Shape;
    invoke-static v1, v5, Landroidx/compose/ui/draw/ClipKt;->clip(Landroidx/compose/ui/Modifier; Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;
    move-result-object v21
    invoke-virtual/range v28, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getUnreadBadgeBackground-0d7_KjU()J
    move-result-wide v22
    const/16 v24, 0
    const/16 v25, 2
    const/16 v26, 0
    invoke-static/range v21 ... v26, Landroidx/compose/foundation/BackgroundKt;->background-bw27NRU$default(Landroidx/compose/ui/Modifier; J Landroidx/compose/ui/graphics/Shape; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    const/4 v5, 5
    int-to-float v5, v5
    invoke-static v5, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v5
    invoke-static v1, v5, v6, v4, v7, Landroidx/compose/foundation/layout/PaddingKt;->padding-VpY3zN4$default(Landroidx/compose/ui/Modifier; F F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    const v4, -1990510117
    invoke-interface v14, v4, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    and-int/lit8 v12, v2, 14
    const/4 v2, 1
    const/4 v4, 0
    if-ne v12, v3, +004h
    move v3, v2
    goto +2h
    move v3, v4
    invoke-interface v14, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v5
    if-nez v3, +00ah
    sget-object v3, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v3, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v3
    if-ne v5, v3, +00ah
    new-instance v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda17;
    invoke-direct v5, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda17;-><init>(Ljava/lang/String;)V
    invoke-interface v14, v5, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v5, Lkotlin/jvm/functions/Function1;
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v1, v4, v5, v2, v7, Landroidx/compose/ui/semantics/SemanticsModifierKt;->semantics$default(Landroidx/compose/ui/Modifier; Z Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    sget-object v2, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v2, Landroidx/compose/ui/Alignment$Companion;->getCenter()Landroidx/compose/ui/Alignment;
    move-result-object v2
    const v3, 1042775818
    const-string v5, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo"
    invoke-static v14, v3, v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v2, v4, Landroidx/compose/foundation/layout/BoxKt;->maybeCachedBoxMeasurePolicy(Landroidx/compose/ui/Alignment; Z)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v2
    const v3, -1159599143
    const-string v5, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh"
    invoke-static v14, v3, v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v14, v4, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v3
    invoke-static v3, v4, Ljava/lang/Long;->hashCode(J)I
    move-result v3
    invoke-interface v14, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v4
    invoke-static v14, v1, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v5
    const v6, -553112988
    const-string v7, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp"
    invoke-static v14, v6, v7, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v14, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v6
    instance-of v6, v6, Landroidx/compose/runtime/Applier;
    if-nez v6, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v14, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v14, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v6
    if-eqz v6, +006h
    invoke-interface v14, v5, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v14, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v14, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v5
    sget-object v6, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v6, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v6
    invoke-static v5, v2, v6, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v2, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v2, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v2
    invoke-static v5, v4, v2, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v2, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v2, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v2
    invoke-interface v5, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v4
    if-nez v4, +010h
    invoke-interface v5, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v4
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +010h
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-interface v5, v4, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v5, v3, v2, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v2, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v2, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v2
    invoke-static v5, v1, v2, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v1, 1833054614
    const-string v2, "C72@3469L9:Box.kt#2w3rfo"
    invoke-static v14, v1, v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v1, Landroidx/compose/foundation/layout/BoxScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/BoxScopeInstance;
    check-cast v1, Landroidx/compose/foundation/layout/BoxScope;
    const/4 v1, 0
    invoke-virtual/range v28, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getUnreadBadgeText-0d7_KjU()J
    move-result-wide v2
    const-wide/16 v4, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const-wide/16 v9, 0
    const/4 v11, 0
    const/16 v16, 0
    move/from16 v22, v12
    move-object/from16 v12, v16
    const-wide/16 v16, 0
    move-object/from16 v25, v14
    move-wide/from16 v13, v16
    const/16 v16, 0
    move/from16 v15, v16
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    invoke-virtual/range v20, Lcom/bytedance/trae/design/compose/TraeTypography;->getCaptionXsStrong()Landroidx/compose/ui/text/TextStyle;
    move-result-object v20
    const/16 v23, 0
    const v24, 65530
    move-object/from16 v0, v27
    move-object/from16 v21, v25
    invoke-static/range v0 ... v24, Landroidx/compose/material3/TextKt;->Text--4IGK_g(Ljava/lang/String; Landroidx/compose/ui/Modifier; J J Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontFamily; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/text/style/TextAlign; J I Z I I Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/runtime/Composer; I I I)V
    invoke-static/range v25, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface/range v25, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static/range v25, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static/range v25, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static/range v25, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface/range v25, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v0
    if-eqz v0, +010h
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda18;
    move-object/from16 v2, v27
    move-object/from16 v3, v28
    move/from16 v4, v30
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda18;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; I)V
    invoke-interface v0, v1, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final UnreadBadge$lambda$56$lambda$55(java.lang.String  androidx.compose.ui.semantics.SemanticsPropertyReceiver)kotlin.Unit
    .registers 4
    # ins_size=2
    const-string v0, "$this$semantics"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, unread_
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v3, v2, Landroidx/compose/ui/semantics/SemanticsPropertiesKt;->setContentDescription(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver; Ljava/lang/String;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final UnreadBadge$lambda$58(java.lang.String  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 5
    # ins_size=5
    or-int/lit8 v2, v2, 1
    invoke-static v2, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v2
    invoke-static v0, v1, v3, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->UnreadBadge(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final UpgradeButton(com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  androidx.compose.runtime.Composer  int)void
    .registers 32
    # ins_size=3
    move-object/from16 v0, v29
    move/from16 v1, v31
    const v2, 1816518561
    move-object/from16 v3, v30
    invoke-interface v3, v2, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v15
    and-int/lit8 v3, v1, 6
    const/4 v4, 2
    if-nez v3, +00dh
    invoke-interface v15, v0, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +004h
    const/4 v3, 4
    goto +2h
    move v3, v4
    or-int/2addr v3, v1
    goto +2h
    move v3, v1
    and-int/lit8 v5, v3, 3
    if-ne v5, v4, +010h
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v5
    if-nez v5, +003h
    goto +8h
    invoke-interface v15, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    move-object/from16 v28, v15
    goto/16 +143h
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v5
    if-eqz v5, +008h
    const/4 v5, -1
    const-string v6, "com.bytedance.trae.home.solo.setting.ui.UpgradeButton (SettingsEntry.kt:616)"
    invoke-static v2, v3, v5, v6, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v3, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v2, v15, v3, Lcom/bytedance/trae/design/compose/TraeTheme;->getTypography(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeTypography;
    move-result-object v2
    sget-object v3, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v3, Landroidx/compose/ui/Modifier;
    const/16 v5, 24
    int-to-float v5, v5
    invoke-static v5, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v5
    invoke-static v3, v5, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v3
    const/16 v5, 12
    int-to-float v5, v5
    invoke-static v5, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v6
    invoke-static v6, Landroidx/compose/foundation/shape/RoundedCornerShapeKt;->RoundedCornerShape-0680j_4(F)Landroidx/compose/foundation/shape/RoundedCornerShape;
    move-result-object v6
    check-cast v6, Landroidx/compose/ui/graphics/Shape;
    invoke-static v3, v6, Landroidx/compose/ui/draw/ClipKt;->clip(Landroidx/compose/ui/Modifier; Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;
    move-result-object v7
    invoke-virtual/range v29, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getUpgradeButtonBackground-0d7_KjU()J
    move-result-wide v8
    const/4 v10, 0
    const/4 v11, 2
    const/4 v12, 0
    invoke-static/range v7 ... v12, Landroidx/compose/foundation/BackgroundKt;->background-bw27NRU$default(Landroidx/compose/ui/Modifier; J Landroidx/compose/ui/graphics/Shape; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v3
    invoke-static v5, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v5
    const/4 v6, 0
    const/4 v7, 0
    invoke-static v3, v5, v6, v4, v7, Landroidx/compose/foundation/layout/PaddingKt;->padding-VpY3zN4$default(Landroidx/compose/ui/Modifier; F F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v3
    sget-object v4, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v4, Landroidx/compose/ui/Alignment$Companion;->getCenter()Landroidx/compose/ui/Alignment;
    move-result-object v4
    const v5, 1042775818
    const-string v6, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo"
    invoke-static v15, v5, v6, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    const/4 v5, 0
    invoke-static v4, v5, Landroidx/compose/foundation/layout/BoxKt;->maybeCachedBoxMeasurePolicy(Landroidx/compose/ui/Alignment; Z)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v4
    const v6, -1159599143
    const-string v7, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh"
    invoke-static v15, v6, v7, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v15, v5, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v6
    invoke-static v6, v7, Ljava/lang/Long;->hashCode(J)I
    move-result v6
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v7
    invoke-static v15, v3, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v3
    sget-object v8, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v8, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v8
    const v9, -553112988
    const-string v10, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp"
    invoke-static v15, v9, v10, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v9
    instance-of v9, v9, Landroidx/compose/runtime/Applier;
    if-nez v9, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v9
    if-eqz v9, +006h
    invoke-interface v15, v8, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v15, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v15, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v8
    sget-object v9, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v9, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v9
    invoke-static v8, v4, v9, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v4, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v4, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v4
    invoke-static v8, v7, v4, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v4, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v4, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v4
    invoke-interface v8, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v7
    if-nez v7, +010h
    invoke-interface v8, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v7
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    invoke-static v7, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-nez v7, +010h
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    invoke-interface v8, v7, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-interface v8, v6, v4, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v4, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v4, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v4
    invoke-static v8, v3, v4, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v3, 1833054614
    const-string v4, "C72@3469L9:Box.kt#2w3rfo"
    invoke-static v15, v3, v4, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v3, Landroidx/compose/foundation/layout/BoxScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/BoxScopeInstance;
    check-cast v3, Landroidx/compose/foundation/layout/BoxScope;
    sget-object v3, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v3, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getCmp_trae_setting_upgrade(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v3
    new-array v4, v5, [Ljava/lang/Object;
    invoke-static v3, v4, v15, v5, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v3
    invoke-virtual/range v29, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getUpgradeButtonText-0d7_KjU()J
    move-result-wide v5
    invoke-virtual v2, Lcom/bytedance/trae/design/compose/TraeTypography;->getCaptionBase()Landroidx/compose/ui/text/TextStyle;
    move-result-object v23
    const/4 v4, 0
    const-wide/16 v7, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const-wide/16 v12, 0
    const/4 v14, 0
    const/4 v2, 0
    move-object/from16 v28, v15
    move-object v15, v2
    const-wide/16 v16, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 1
    const/16 v21, 0
    const/16 v22, 0
    const/16 v25, 0
    const/16 v26, 3072
    const v27, 57338
    move-object/from16 v24, v28
    invoke-static/range v3 ... v27, Landroidx/compose/material3/TextKt;->Text--4IGK_g(Ljava/lang/String; Landroidx/compose/ui/Modifier; J J Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontFamily; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/text/style/TextAlign; J I Z I I Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/runtime/Composer; I I I)V
    invoke-static/range v28, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface/range v28, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static/range v28, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static/range v28, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static/range v28, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v2
    if-eqz v2, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface/range v28, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v2
    if-eqz v2, +00ah
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda3;
    invoke-direct v3, v0, v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; I)V
    invoke-interface v2, v3, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final UpgradeButton$lambda$52(com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 4
    # ins_size=4
    or-int/lit8 v1, v1, 1
    invoke-static v1, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v1
    invoke-static v0, v2, v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->UpgradeButton(Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final UsageTrailing(com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  androidx.compose.runtime.Composer  int)void
    .registers 32
    # ins_size=3
    move-object/from16 v0, v29
    move/from16 v1, v31
    const v2, 780215184
    move-object/from16 v3, v30
    invoke-interface v3, v2, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v15
    and-int/lit8 v3, v1, 6
    const/4 v14, 4
    const/4 v4, 2
    if-nez v3, +00dh
    invoke-interface v15, v0, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +004h
    move v3, v14
    goto +2h
    move v3, v4
    or-int/2addr v3, v1
    goto +2h
    move v3, v1
    and-int/lit8 v5, v3, 3
    if-ne v5, v4, +010h
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v4
    if-nez v4, +003h
    goto +8h
    invoke-interface v15, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    move-object/from16 v28, v15
    goto/16 +155h
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v4
    if-eqz v4, +008h
    const/4 v4, -1
    const-string v5, "com.bytedance.trae.home.solo.setting.ui.UsageTrailing (SettingsEntry.kt:596)"
    invoke-static v2, v3, v4, v5, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v3, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v2, v15, v3, Lcom/bytedance/trae/design/compose/TraeTheme;->getTypography(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeTypography;
    move-result-object v2
    sget-object v3, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v3, Landroidx/compose/ui/Alignment$Companion;->getCenterVertically()Landroidx/compose/ui/Alignment$Vertical;
    move-result-object v3
    const v4, 844473419
    const-string v5, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo"
    invoke-static v15, v4, v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v4, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v4, Landroidx/compose/ui/Modifier;
    sget-object v5, Landroidx/compose/foundation/layout/Arrangement;->INSTANCE Landroidx/compose/foundation/layout/Arrangement;
    invoke-virtual v5, Landroidx/compose/foundation/layout/Arrangement;->getStart()Landroidx/compose/foundation/layout/Arrangement$Horizontal;
    move-result-object v5
    const/16 v6, 48
    invoke-static v5, v3, v15, v6, Landroidx/compose/foundation/layout/RowKt;->rowMeasurePolicy(Landroidx/compose/foundation/layout/Arrangement$Horizontal; Landroidx/compose/ui/Alignment$Vertical; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v3
    const v5, -1159599143
    const-string v6, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh"
    invoke-static v15, v5, v6, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    const/4 v12, 0
    invoke-static v15, v12, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v5
    invoke-static v5, v6, Ljava/lang/Long;->hashCode(J)I
    move-result v5
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v6
    invoke-static v15, v4, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v4
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v7
    const v8, -553112988
    const-string v9, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp"
    invoke-static v15, v8, v9, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v8
    instance-of v8, v8, Landroidx/compose/runtime/Applier;
    if-nez v8, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v8
    if-eqz v8, +006h
    invoke-interface v15, v7, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v15, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v15, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v7
    sget-object v8, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v8, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v8
    invoke-static v7, v3, v8, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v3, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v3, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v3
    invoke-static v7, v6, v3, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v3, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v3, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v3
    invoke-interface v7, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v6
    if-nez v6, +010h
    invoke-interface v7, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v6
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-static v6, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +010h
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-interface v7, v6, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    invoke-interface v7, v5, v3, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v3, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v3, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v3
    invoke-static v7, v4, v3, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v3, 1456264949
    const-string v4, "C101@5233L9:Row.kt#2w3rfo"
    invoke-static v15, v3, v4, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v3, Landroidx/compose/foundation/layout/RowScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/RowScopeInstance;
    check-cast v3, Landroidx/compose/foundation/layout/RowScope;
    sget-object v3, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v3, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getCmp_trae_setting_usage_price(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v3
    new-array v4, v12, [Ljava/lang/Object;
    invoke-static v3, v4, v15, v12, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v3
    invoke-virtual/range v29, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getTertiaryText-0d7_KjU()J
    move-result-wide v5
    invoke-virtual v2, Lcom/bytedance/trae/design/compose/TraeTypography;->getBodyXs()Landroidx/compose/ui/text/TextStyle;
    move-result-object v23
    const/4 v4, 0
    const-wide/16 v7, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const-wide/16 v16, 0
    move-wide/from16 v12, v16
    const/16 v16, 0
    move-object/from16 v14, v16
    move-object/from16 v30, v15
    move-object/from16 v15, v16
    const-wide/16 v16, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 1
    const/16 v21, 0
    const/16 v22, 0
    const/16 v25, 0
    const/16 v26, 3072
    const v27, 57338
    move-object/from16 v24, v30
    invoke-static/range v3 ... v27, Landroidx/compose/material3/TextKt;->Text--4IGK_g(Ljava/lang/String; Landroidx/compose/ui/Modifier; J J Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontFamily; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/text/style/TextAlign; J I Z I I Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/runtime/Composer; I I I)V
    sget-object v3, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v3, Landroidx/compose/ui/Modifier;
    const/4 v4, 4
    int-to-float v4, v4
    invoke-static v4, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v4
    invoke-static v3, v4, Landroidx/compose/foundation/layout/SizeKt;->width-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v3
    const/4 v4, 6
    move-object/from16 v15, v30
    invoke-static v3, v15, v4, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    sget-object v3, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v3, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getCmp_trae_setting_bonus(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v3
    const/4 v4, 0
    new-array v5, v4, [Ljava/lang/Object;
    invoke-static v3, v5, v15, v4, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v3
    invoke-virtual/range v29, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getTertiaryText-0d7_KjU()J
    move-result-wide v5
    invoke-virtual v2, Lcom/bytedance/trae/design/compose/TraeTypography;->getBodyXs()Landroidx/compose/ui/text/TextStyle;
    move-result-object v23
    const/4 v4, 0
    const-wide/16 v12, 0
    const/4 v14, 0
    const/4 v2, 0
    move-object/from16 v28, v15
    move-object v15, v2
    move-object/from16 v24, v28
    invoke-static/range v3 ... v27, Landroidx/compose/material3/TextKt;->Text--4IGK_g(Ljava/lang/String; Landroidx/compose/ui/Modifier; J J Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontFamily; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/text/style/TextAlign; J I Z I I Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/runtime/Composer; I I I)V
    invoke-static/range v28, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface/range v28, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static/range v28, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static/range v28, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static/range v28, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v2
    if-eqz v2, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface/range v28, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v2
    if-eqz v2, +00ah
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda8;
    invoke-direct v3, v0, v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; I)V
    invoke-interface v2, v3, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final UsageTrailing$lambda$50(com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 4
    # ins_size=4
    or-int/lit8 v1, v1, 1
    invoke-static v1, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v1
    invoke-static v0, v2, v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->UsageTrailing(Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public static final synthetic access$ProfileHeader(com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryState  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  kotlin.jvm.functions.Function0  androidx.compose.runtime.Composer  int)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->ProfileHeader(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lkotlin/jvm/functions/Function0; Landroidx/compose/runtime/Composer; I)V
    return-void 
.end method

.method public static final synthetic access$SettingsEntryContent$lambda$1(androidx.compose.runtime.MutableState)com.bytedance.trae.home.solo.setting.ui.SettingsPopupType
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsEntryContent$lambda$1(Landroidx/compose/runtime/MutableState;)Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$SettingsEntryContent$lambda$10(androidx.compose.runtime.MutableState)boolean
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsEntryContent$lambda$10(Landroidx/compose/runtime/MutableState;)Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$SettingsEntryContent$lambda$11(androidx.compose.runtime.MutableState  boolean)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsEntryContent$lambda$11(Landroidx/compose/runtime/MutableState; Z)V
    return-void 
.end method

.method public static final synthetic access$SettingsEntryContent$lambda$2(androidx.compose.runtime.MutableState  com.bytedance.trae.home.solo.setting.ui.SettingsPopupType)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsEntryContent$lambda$2(Landroidx/compose/runtime/MutableState; Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;)V
    return-void 
.end method

.method public static final synthetic access$SettingsEntryContent$lambda$4(androidx.compose.runtime.MutableState)float
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsEntryContent$lambda$4(Landroidx/compose/runtime/MutableState;)F
    move-result v0
    return v0
.end method

.method public static final synthetic access$SettingsEntryContent$lambda$5(androidx.compose.runtime.MutableState  float)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsEntryContent$lambda$5(Landroidx/compose/runtime/MutableState; F)V
    return-void 
.end method

.method public static final synthetic access$SettingsEntryContent$lambda$7(androidx.compose.runtime.MutableState)float
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsEntryContent$lambda$7(Landroidx/compose/runtime/MutableState;)F
    move-result v0
    return v0
.end method

.method public static final synthetic access$SettingsEntryContent$lambda$8(androidx.compose.runtime.MutableState  float)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsEntryContent$lambda$8(Landroidx/compose/runtime/MutableState; F)V
    return-void 
.end method

.method public static final synthetic access$SettingsFooter(com.bytedance.trae.home.solo.setting.viewmodel.SettingsFooterState  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  androidx.compose.runtime.Composer  int)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsFooter(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Landroidx/compose/runtime/Composer; I)V
    return-void 
.end method

.method public static final synthetic access$SettingsGroupView(com.bytedance.trae.home.solo.setting.viewmodel.SettingsGroup  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function2  androidx.compose.runtime.Composer  int)void
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsGroupView(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2; Landroidx/compose/runtime/Composer; I)V
    return-void 
.end method

.method public static final synthetic access$getSettingsPopupAnchorYOffset$p()float
    .registers 1
    # ins_size=0
    sget v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsPopupAnchorYOffset F
    return v0
.end method

.method public static final synthetic access$getSettingsPopupCornerRadius$p()float
    .registers 1
    # ins_size=0
    sget v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsPopupCornerRadius F
    return v0
.end method

.method public static final synthetic access$getSettingsPopupDividerHeight$p()float
    .registers 1
    # ins_size=0
    sget v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsPopupDividerHeight F
    return v0
.end method

.method public static final synthetic access$getSettingsPopupElevation$p()float
    .registers 1
    # ins_size=0
    sget v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsPopupElevation F
    return v0
.end method

.method public static final synthetic access$getSettingsPopupEndMargin$p()float
    .registers 1
    # ins_size=0
    sget v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsPopupEndMargin F
    return v0
.end method

.method public static final synthetic access$getSettingsPopupItemHeight$p()float
    .registers 1
    # ins_size=0
    sget v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsPopupItemHeight F
    return v0
.end method

.method public static final synthetic access$getSettingsPopupWidth$p()float
    .registers 1
    # ins_size=0
    sget v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsPopupWidth F
    return v0
.end method

.method public static final synthetic access$popupOptions(com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode)java.util.List
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->popupOptions(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$titleResource(com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode)org.jetbrains.compose.resources.StringResource
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->titleResource(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v0
    return-object v0
.end method

.method private static final iconResource(com.bytedance.trae.home.solo.setting.viewmodel.SettingsItemKey)org.jetbrains.compose.resources.DrawableResource
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v1
    aget v1, v0, v1
    packed-switch v1, +0000072h
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$drawable;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/Drawable0_commonMainKt;->getCmp_ic_setting_logout(Lcom/bytedance/trae/home/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v1
    goto +62h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$drawable;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/Drawable0_commonMainKt;->getCmp_ic_setting_trae(Lcom/bytedance/trae/home/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v1
    goto +5bh
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$drawable;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/Drawable0_commonMainKt;->getCmp_ic_setting_info_circle(Lcom/bytedance/trae/home/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v1
    goto +54h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$drawable;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/Drawable0_commonMainKt;->getCmp_ic_setting_privacy(Lcom/bytedance/trae/home/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v1
    goto +4dh
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$drawable;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/Drawable0_commonMainKt;->getCmp_ic_setting_connector_added(Lcom/bytedance/trae/home/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v1
    goto +46h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$drawable;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/Drawable0_commonMainKt;->getCmp_ic_setting_computer_screen(Lcom/bytedance/trae/home/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v1
    goto +3fh
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$drawable;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/Drawable0_commonMainKt;->getCmp_ic_setting_notification(Lcom/bytedance/trae/home/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v1
    goto +38h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$drawable;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/Drawable0_commonMainKt;->getCmp_ic_setting_points(Lcom/bytedance/trae/home/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v1
    goto +31h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$drawable;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/Drawable0_commonMainKt;->getCmp_ic_setting_message(Lcom/bytedance/trae/home/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v1
    goto +2ah
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$drawable;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/Drawable0_commonMainKt;->getCmp_ic_setting_user(Lcom/bytedance/trae/home/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v1
    goto +23h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$drawable;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/Drawable0_commonMainKt;->getCmp_ic_setting_tokens(Lcom/bytedance/trae/home/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v1
    goto +1ch
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$drawable;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/Drawable0_commonMainKt;->getCmp_ic_setting_subscription(Lcom/bytedance/trae/home/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v1
    goto +15h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$drawable;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/Drawable0_commonMainKt;->getCmp_ic_setting_debug(Lcom/bytedance/trae/home/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v1
    goto +eh
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$drawable;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/Drawable0_commonMainKt;->getCmp_ic_setting_language(Lcom/bytedance/trae/home/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v1
    goto +7h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$drawable;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/Drawable0_commonMainKt;->getCmp_ic_setting_sun_day(Lcom/bytedance/trae/home/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v1
    return-object v1
    packed-switch-payload 1 2 3 4 5 6 7 8 9 a b c d e f
.end method

.method private static final languageDisplayName(java.lang.String  androidx.compose.runtime.Composer  int)java.lang.String
    .registers 6
    # ins_size=3
    const v0, 1803860352
    invoke-interface v4, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v1
    if-eqz v1, +008h
    const/4 v1, -1
    const-string v2, "com.bytedance.trae.home.solo.setting.ui.languageDisplayName (SettingsEntry.kt:652)"
    invoke-static v0, v5, v1, v2, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    invoke-static v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->languageDisplayResource(Ljava/lang/String;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v3
    const/4 v5, 0
    new-array v0, v5, [Ljava/lang/Object;
    invoke-static v3, v0, v4, v5, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v3
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v5
    if-eqz v5, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v4, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    return-object v3
.end method

.method private static final languageDisplayResource(java.lang.String)org.jetbrains.compose.resources.StringResource
    .registers 2
    # ins_size=1
    const-string/jumbo v0, zh
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +009h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_lang_chinese(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +16h
    const-string v0, "ja"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +009h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_lang_japanese(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +7h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_lang_english(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    return-object v1
.end method

.method private static final popupOptions(com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode)java.util.List
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$WhenMappings;->$EnumSwitchMapping$2 [I
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->ordinal()I
    move-result v4
    aget v4, v0, v4
    const/4 v0, 0
    const/4 v1, 2
    const/4 v2, 1
    if-eq v4, v2, +02bh
    if-eq v4, v1, +01ah
    const/4 v3, 3
    if-ne v4, v3, +011h
    new-array v4, v1, [Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->Light Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    aput-object v1, v4, v0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->Dark Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    aput-object v0, v4, v2
    invoke-static v4, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v4
    goto +24h
    new-instance v4, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v4, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v4
    new-array v4, v1, [Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->Light Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    aput-object v1, v4, v0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->System Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    aput-object v0, v4, v2
    invoke-static v4, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v4
    goto +fh
    new-array v4, v1, [Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->Dark Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    aput-object v1, v4, v0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->System Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    aput-object v0, v4, v2
    invoke-static v4, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v4
    return-object v4
.end method

.method private static final themeDisplayName(java.lang.String  androidx.compose.runtime.Composer  int)java.lang.String
    .registers 6
    # ins_size=3
    const v0, 398732333
    invoke-interface v4, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v1
    if-eqz v1, +008h
    const/4 v1, -1
    const-string v2, "com.bytedance.trae.home.solo.setting.ui.themeDisplayName (SettingsEntry.kt:647)"
    invoke-static v0, v5, v1, v2, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    sget-object v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->Companion Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode$Companion;
    invoke-virtual v5, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode$Companion;->fromValue(Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    move-result-object v3
    invoke-static v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->titleResource(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v3
    const/4 v5, 0
    new-array v0, v5, [Ljava/lang/Object;
    invoke-static v3, v0, v4, v5, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v3
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v5
    if-eqz v5, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v4, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    return-object v3
.end method

.method private static final titleResource(com.bytedance.trae.home.solo.setting.viewmodel.SettingsEnterpriseBadge)org.jetbrains.compose.resources.StringResource
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$WhenMappings;->$EnumSwitchMapping$3 [I
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;->ordinal()I
    move-result v1
    aget v1, v0, v1
    const/4 v0, 1
    if-eq v1, v0, +012h
    const/4 v0, 2
    if-ne v1, v0, +009h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_saas_team_flagship_badge(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +dh
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_saas_team_group_badge(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    return-object v1
.end method

.method private static final titleResource(com.bytedance.trae.home.solo.setting.viewmodel.SettingsItemKey)org.jetbrains.compose.resources.StringResource
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v1
    aget v1, v0, v1
    packed-switch v1, +0000072h
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_logout(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +62h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_about(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +5bh
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_update(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +54h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_privacy_permission(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +4dh
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_connectors(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +46h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_device_management(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +3fh
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_notification(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +38h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getCmp_trae_setting_points(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +31h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_messages(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +2ah
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_account(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +23h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getCmp_trae_setting_usage(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +1ch
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getCmp_trae_setting_subscribe(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +15h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_debug(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +eh
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_language(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +7h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getCmp_trae_setting_theme(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    return-object v1
    packed-switch-payload 1 2 3 4 5 6 7 8 9 a b c d e f
.end method

.method private static final titleResource(com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode)org.jetbrains.compose.resources.StringResource
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$WhenMappings;->$EnumSwitchMapping$2 [I
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->ordinal()I
    move-result v1
    aget v1, v0, v1
    const/4 v0, 1
    if-eq v1, v0, +01ch
    const/4 v0, 2
    if-eq v1, v0, +012h
    const/4 v0, 3
    if-ne v1, v0, +009h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getCmp_trae_setting_theme_system(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +14h
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getCmp_trae_setting_theme_dark(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +7h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getCmp_trae_setting_theme_light(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    return-object v1
.end method

.method private static final trailingIconResource(com.bytedance.trae.home.solo.setting.viewmodel.SettingsItemKey)org.jetbrains.compose.resources.DrawableResource
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Theme Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    if-eq v1, v0, +00eh
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Language Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    if-ne v1, v0, +003h
    goto +8h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$drawable;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/Drawable0_commonMainKt;->getCmp_ic_setting_chevron_right(Lcom/bytedance/trae/home/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v1
    goto +7h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$drawable;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/Drawable0_commonMainKt;->getCmp_ic_setting_selector_arrows(Lcom/bytedance/trae/home/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v1
    return-object v1
.end method

.method private static final trailingText(com.bytedance.trae.home.solo.setting.viewmodel.SettingsItem  com.bytedance.trae.home.solo.setting.viewmodel.SettingsItemKey  androidx.compose.runtime.Composer  int)java.lang.String
    .registers 7
    # ins_size=4
    const v0, 731139054
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v1
    if-eqz v1, +008h
    const/4 v1, -1
    const-string v2, "com.bytedance.trae.home.solo.setting.ui.trailingText (SettingsEntry.kt:636)"
    invoke-static v0, v6, v1, v2, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    aget v4, v6, v4
    const/4 v6, 1
    const/4 v0, 0
    const/4 v1, 0
    if-eq v4, v6, +062h
    const/4 v2, 2
    if-eq v4, v2, +04ah
    const/4 v2, 3
    if-eq v4, v2, +01dh
    const v4, -430896545
    invoke-interface v5, v4, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->getTrailingText()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +061h
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/2addr v4, v6
    if-eqz v4, +057h
    move-object v1, v3
    goto +54h
    const v4, -431043423
    invoke-interface v5, v4, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->getTrailingText()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +00dh
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/2addr v4, v6
    if-eqz v4, +003h
    move-object v1, v3
    if-nez v1, +00fh
    sget-object v3, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v3, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_debug_ppe_env_not_set(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v3
    new-array v4, v0, [Ljava/lang/Object;
    invoke-static v3, v4, v5, v0, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v3
    move-object v1, v3
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    goto +2ah
    const v4, -431101052
    invoke-interface v5, v4, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->getTrailingText()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    goto +5h
    invoke-static v3, v5, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->languageDisplayName(Ljava/lang/String; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v1
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    goto +15h
    const v4, -431169593
    invoke-interface v5, v4, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->getTrailingText()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    goto +5h
    invoke-static v3, v5, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->themeDisplayName(Ljava/lang/String; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v1
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v3
    if-eqz v3, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    return-object v1
.end method
