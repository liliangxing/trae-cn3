# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment;
.super Lcom/bytedance/trae/kmp/cmp/TraeCmpSheetContentFragment;
.source "CmpSettingsAboutFragment.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment$Companion;
.field private final titleResId:I


.method public static synthetic $r8$lambda$fVMAPW_ConuNrmjDmA_buf05f8Y(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsAboutFragment  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment;->RenderCmpContent$lambda$1(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment;->Companion Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpSheetContentFragment;-><init>()V
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_setting_about I
    iput v0, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment;->titleResId I
    return-void 
.end method

.method private static final RenderCmpContent$lambda$1(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsAboutFragment  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 4
    # ins_size=4
    or-int/lit8 v1, v1, 1
    invoke-static v1, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v1
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment;->RenderCmpContent(Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public static final synthetic access$handleItemClick(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsAboutFragment  com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItem  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment;->handleItemClick(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem; Ljava/lang/String;)V
    return-void 
.end method

.method private final handleItemClick(com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItem  java.lang.String)void
    .registers 12
    # ins_size=3
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;->getDestination()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination;
    move-result-object v10
    instance-of v0, v10, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination$WebUrl;
    if-eqz v0, +02fh
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment;->getContext()Landroid/content/Context;
    move-result-object v11
    if-nez v11, +003h
    return-void 
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v9
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment;
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/AboutWebUrlOpener;->INSTANCE Lcom/bytedance/trae/home/solo/setting/AboutWebUrlOpener;
    check-cast v10, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination$WebUrl;
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination$WebUrl;->getUrl()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v0, v11, v10, Lcom/bytedance/trae/home/solo/setting/AboutWebUrlOpener;->open(Landroid/content/Context; Ljava/lang/String;)V
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v10, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    goto +ch
    move-exception v10
    sget-object v11, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v10, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v10
    invoke-static v10, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    invoke-static v10, Lkotlin/Result;->box-impl(Ljava/lang/Object;)Lkotlin/Result;
    goto +1dh
    instance-of v0, v10, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination$ExternalBrowser;
    if-eqz v0, +01bh
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment;->getContext()Landroid/content/Context;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->Companion Lcom/bytedance/trae/conversation/ShareWebViewActivity$Companion;
    check-cast v10, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination$ExternalBrowser;
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination$ExternalBrowser;->getUrl()Ljava/lang/String;
    move-result-object v3
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 24
    const/4 v8, 0
    move-object v4, v11
    invoke-static/range v1 ... v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity$Companion;->startWithBrowser$default(Lcom/bytedance/trae/conversation/ShareWebViewActivity$Companion; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
    new-instance v10, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v10, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v10
    :try_start_0xf
.end method

.method protected RenderCmpContent(androidx.compose.runtime.Composer  int)void
    .registers 10
    # ins_size=3
    const v0, -1458829653
    invoke-interface v8, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v8
    and-int/lit8 v1, v9, 6
    const/4 v2, 4
    const/4 v3, 2
    if-nez v1, +00dh
    invoke-interface v8, v7, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    or-int/2addr v1, v9
    goto +2h
    move v1, v9
    and-int/lit8 v4, v1, 3
    if-ne v4, v3, +00dh
    invoke-interface v8, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v3
    if-nez v3, +003h
    goto +5h
    invoke-interface v8, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    goto +53h
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v3
    if-eqz v3, +008h
    const/4 v3, -1
    const-string v4, "com.bytedance.trae.home.solo.setting.fragment.CmpSettingsAboutFragment.RenderCmpContent (CmpSettingsAboutFragment.kt:16)"
    invoke-static v0, v1, v3, v4, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;->INSTANCE Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;
    const/4 v3, 0
    const/4 v4, 1
    invoke-static v0, v3, v4, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;->build$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory; Lcom/bytedance/trae/kmp/host/KmpHostInfo; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;
    move-result-object v0
    const v5, -1416797264
    invoke-interface v8, v5, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    and-int/lit8 v1, v1, 14
    if-ne v1, v2, +003h
    goto +2h
    const/4 v4, 0
    invoke-interface v8, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v1
    if-nez v4, +00ah
    sget-object v2, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v2, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v2
    if-ne v1, v2, +00ch
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment$RenderCmpContent$1$1;
    invoke-direct v1, v7, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment$RenderCmpContent$1$1;-><init>(Ljava/lang/Object;)V
    check-cast v1, Lkotlin/reflect/KFunction;
    invoke-interface v8, v1, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v1, Lkotlin/reflect/KFunction;
    invoke-interface v8, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    move-object v4, v1
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 0
    const/4 v6, 2
    move-object v1, v0
    move-object v2, v3
    move-object v3, v4
    move-object v4, v8
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt;->SettingsAboutContent(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState; Landroidx/compose/ui/Modifier; Lkotlin/jvm/functions/Function2; Landroidx/compose/runtime/Composer; I I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v8, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v8
    if-eqz v8, +00ah
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment$$ExternalSyntheticLambda0;
    invoke-direct v0, v7, v9, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment; I)V
    invoke-interface v8, v0, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method protected getTitleResId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment;->titleResId I
    return v0
.end method
