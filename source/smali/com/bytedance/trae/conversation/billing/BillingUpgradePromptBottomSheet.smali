# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;
.super Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet;
.source "BillingUpgradePromptBottomSheet.kt"

.field private static final ARG_OWNER_USER_ID:Ljava/lang/String;
.field private static final ARG_USER_STATE:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet$Companion;
.field public static final TAG:Ljava/lang/String;
.field private hasReportedClick:Z
.field private hasReportedShow:Z
.field private restoredInstance:Z
.field private shownAtElapsedRealtime:Ljava/lang/Long;


.method public static synthetic $r8$lambda$6aFsqjgIlImsj3LufDRW8ZWQkKw(com.bytedance.trae.conversation.billing.BillingUpgradePromptBottomSheet)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->onViewCreated$lambda$4(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$CFR8fPUcAcLrvopZOvMahkmUEV4(com.bytedance.trae.conversation.billing.BillingUpgradePromptBottomSheet)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->onViewCreated$lambda$3(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->Companion Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet;-><init>()V
    return-void 
.end method

.method private final getUserState()com.bytedance.trae.conversation.billing.BillingUpgradeUserState
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    if-eqz v0, +02fh
    const-string v1, "arg_user_state"
    invoke-virtual v0, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +027h
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v2
    check-cast v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;
    invoke-static v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;->valueOf(Ljava/lang/String;)Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    const/4 v0, 0
    check-cast v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    if-eqz v0, +003h
    goto +3h
    sget-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;->NoFastRequests Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    return-object v0
    :try_start_0xe
.end method

.method private static final onViewCreated$lambda$3(com.bytedance.trae.conversation.billing.BillingUpgradePromptBottomSheet)kotlin.Unit
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;->Close Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->reportClickAndDismiss(Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onViewCreated$lambda$4(com.bytedance.trae.conversation.billing.BillingUpgradePromptBottomSheet)kotlin.Unit
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;->Primary Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->reportClickAndDismiss(Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final reportClickAndDismiss(com.bytedance.trae.conversation.tracker.BillingPopupAction)void
    .registers 6
    # ins_size=2
    iget-boolean v0, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->hasReportedClick Z
    if-nez v0, +020h
    const/4 v0, 1
    iput-boolean v0, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->hasReportedClick Z
    iget-object v0, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->shownAtElapsedRealtime Ljava/lang/Long;
    if-eqz v0, +00eh
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v2
    sub-long/2addr v2, v0
    goto +3h
    const-wide/16 v2, 0
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;
    invoke-direct v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->getUserState()Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    move-result-object v1
    invoke-virtual v0, v5, v1, v2, v3, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;->trackBillingPopupClick(Lcom/bytedance/trae/conversation/tracker/BillingPopupAction; Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState; J)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->dismiss()V
    return-void 
.end method

.method public final getOwnerUserId$conversation_mainlandRelease()java.lang.String
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +016h
    const-string v2, "arg_owner_user_id"
    invoke-virtual v0, v2, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +00eh
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    move-object v1, v0
    return-object v1
.end method

.method public onCreate(android.os.Bundle)void
    .registers 2
    # ins_size=2
    invoke-super v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet;->onCreate(Landroid/os/Bundle;)V
    if-eqz v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->restoredInstance Z
    return-void 
.end method

.method public onStart()void
    .registers 4
    # ins_size=1
    invoke-super v3, Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet;->onStart()V
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->hasReportedShow Z
    if-eqz v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->hasReportedShow Z
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    iput-object v0, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->shownAtElapsedRealtime Ljava/lang/Long;
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;
    invoke-direct v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->getUserState()Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->restoredInstance Z
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;->trackBillingPopupShow(Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState; Z)V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 12
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v9, v10, v11, Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->trae_img_billing_upgrade_prompt_hero I
    sget v11, Lcom/bytedance/trae/conversation/R$string;->trae_billing_upgrade_prompt_title I
    invoke-virtual v9, v11, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->getString(I)Ljava/lang/String;
    move-result-object v11
    const-string v0, "getString(...)"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v4, v11
    check-cast v4, Ljava/lang/CharSequence;
    sget v11, Lcom/bytedance/trae/conversation/R$string;->trae_billing_upgrade_prompt_message I
    invoke-virtual v9, v11, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->getString(I)Ljava/lang/String;
    move-result-object v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v5, v11
    check-cast v5, Ljava/lang/CharSequence;
    sget v11, Lcom/bytedance/trae/conversation/R$string;->trae_billing_upgrade_prompt_start I
    invoke-virtual v9, v11, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->getString(I)Ljava/lang/String;
    move-result-object v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v6, v11
    check-cast v6, Ljava/lang/CharSequence;
    new-instance v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet$$ExternalSyntheticLambda0;
    invoke-direct v7, v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;)V
    new-instance v8, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet$$ExternalSyntheticLambda1;
    invoke-direct v8, v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;)V
    move-object v1, v9
    move-object v2, v10
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;->bindHeroPrompt(Landroid/view/View; I Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method
