# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;
.super Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet;
.source "NewFeaturePromptBottomSheet.kt"

.field private static final ARG_HAS_REGISTERED_IDE:Ljava/lang/String;
.field private static final ARG_HAS_REGISTERED_WORK:Ljava/lang/String;
.field private static final ARG_PRODUCT_TYPE:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet$Companion;
.field private static final STATE_GUIDE_CLICK_REPORTED:Ljava/lang/String;
.field private static final STATE_GUIDE_SHOW_REPORTED:Ljava/lang/String;
.field public static final TAG:Ljava/lang/String;
.field private guideClickEventGate:Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
.field private guideShowEventGate:Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
.field private onConfirm:Lkotlin/jvm/functions/Function0;
.field private onDismissListener:Lkotlin/jvm/functions/Function0;


.method public static synthetic $r8$lambda$SXDBX1ggNeaepQ0qOSNuaf8KZj8(com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptBottomSheet)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->onViewCreated$lambda$2(Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$kcC7ZOwUil2NZQ0H0N9jlIZMDZs(com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptBottomSheet)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->onViewCreated$lambda$1(Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->Companion Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet;-><init>()V
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    const/4 v1, 0
    const/4 v2, 1
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;-><init>(Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v0, v4, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->guideShowEventGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;-><init>(Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v0, v4, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->guideClickEventGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    return-void 
.end method

.method private final connectButtonRes(com.bytedance.trae.conversation.devices.DeviceProductType)int
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->ordinal()I
    move-result v2
    aget v2, v0, v2
    const/4 v0, 1
    if-eq v2, v0, +00eh
    const/4 v0, 2
    if-ne v2, v0, +005h
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_new_feature_prompt_ide_connect I
    goto +9h
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_new_feature_prompt_work_connect I
    return v2
.end method

.method private final getHasRegisteredIDE()boolean
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +00ch
    const-string v2, "arg_has_registered_ide"
    invoke-virtual v0, v2, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    return v1
.end method

.method private final getHasRegisteredWork()boolean
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +00ch
    const-string v2, "arg_has_registered_work"
    invoke-virtual v0, v2, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    return v1
.end method

.method private final getProductType()com.bytedance.trae.conversation.devices.DeviceProductType
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    if-eqz v0, +030h
    const-string v1, "arg_product_type"
    invoke-virtual v0, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +26h
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v3
    check-cast v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->valueOf(Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/DeviceProductType;
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
    sget-object v1, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    return-object v0
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    return-object v0
    :try_start_0xf
.end method

.method private final imageRes(com.bytedance.trae.conversation.devices.DeviceProductType)int
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->ordinal()I
    move-result v2
    aget v2, v0, v2
    const/4 v0, 1
    if-eq v2, v0, +00eh
    const/4 v0, 2
    if-ne v2, v0, +005h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->trae_img_new_feature_prompt_ide_hero_2026q3 I
    goto +9h
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->trae_img_new_feature_prompt_work_hero_2026q3 I
    return v2
.end method

.method private final messageRes(com.bytedance.trae.conversation.devices.DeviceProductType)int
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->ordinal()I
    move-result v2
    aget v2, v0, v2
    const/4 v0, 1
    if-eq v2, v0, +00eh
    const/4 v0, 2
    if-ne v2, v0, +005h
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_new_feature_prompt_ide_message I
    goto +9h
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_new_feature_prompt_work_message I
    return v2
.end method

.method private static final onViewCreated$lambda$1(com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptBottomSheet)kotlin.Unit
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->guideClickEventGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->tryConsume()Z
    move-result v0
    if-eqz v0, +01dh
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    invoke-direct v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;->CLOSE Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackGuideClick$conversation_mainlandRelease(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;)V
    move-object v0, v3
    check-cast v0, Landroidx/fragment/app/Fragment;
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigatorKt;->deviceFlowNavigator(Landroidx/fragment/app/Fragment;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;
    move-result-object v0
    if-eqz v0, +006h
    invoke-interface v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;->closeCurrentFlow()V
    goto +4h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->dismiss()V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private static final onViewCreated$lambda$2(com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptBottomSheet)kotlin.Unit
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->guideClickEventGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->tryConsume()Z
    move-result v0
    if-eqz v0, +020h
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    invoke-direct v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;->GET_STARTED Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackGuideClick$conversation_mainlandRelease(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;)V
    move-object v0, v3
    check-cast v0, Landroidx/fragment/app/Fragment;
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigatorKt;->deviceFlowNavigator(Landroidx/fragment/app/Fragment;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->onConfirm Lkotlin/jvm/functions/Function0;
    if-eqz v1, +005h
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    if-nez v0, +005h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->dismiss()V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private final titleRes(com.bytedance.trae.conversation.devices.DeviceProductType)int
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->ordinal()I
    move-result v2
    aget v2, v0, v2
    const/4 v0, 1
    if-eq v2, v0, +00eh
    const/4 v0, 2
    if-ne v2, v0, +005h
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_new_feature_prompt_ide_title I
    goto +9h
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_new_feature_prompt_work_title I
    return v2
.end method

.method public final getOnConfirm()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->onConfirm Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getOnDismissListener()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->onDismissListener Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public onCreate(android.os.Bundle)void
    .registers 6
    # ins_size=2
    invoke-super v4, v5, Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet;->onCreate(Landroid/os/Bundle;)V
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v5, +00dh
    const-string/jumbo v3, state_guide_show_reported
    invoke-virtual v5, v3, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z
    move-result v3
    if-ne v3, v1, +004h
    move v3, v1
    goto +2h
    move v3, v2
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;-><init>(Z)V
    iput-object v0, v4, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->guideShowEventGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    if-eqz v5, +00ch
    const-string/jumbo v3, state_guide_click_reported
    invoke-virtual v5, v3, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z
    move-result v5
    if-ne v5, v1, +003h
    goto +2h
    move v1, v2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;-><init>(Z)V
    iput-object v0, v4, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->guideClickEventGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    return-void 
.end method

.method public onDestroyView()void
    .registers 4
    # ins_size=1
    invoke-super v3, Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet;->onDestroyView()V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-virtual v0, Landroidx/fragment/app/FragmentActivity;->isChangingConfigurations()Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    if-nez v1, +00ch
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->guideShowEventGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->reset()V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->guideClickEventGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->reset()V
    return-void 
.end method

.method public onDismiss(android.content.DialogInterface)void
    .registers 3
    # ins_size=2
    const-string v0, "dialog"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet;->onDismiss(Landroid/content/DialogInterface;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->onDismissListener Lkotlin/jvm/functions/Function0;
    if-eqz v2, +005h
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method public onSaveInstanceState(android.os.Bundle)void
    .registers 4
    # ins_size=2
    const-string v0, "outState"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->guideShowEventGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->isConsumed()Z
    move-result v0
    const-string/jumbo v1, state_guide_show_reported
    invoke-virtual v3, v1, v0, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->guideClickEventGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->isConsumed()Z
    move-result v0
    const-string/jumbo v1, state_guide_click_reported
    invoke-virtual v3, v1, v0, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    invoke-super v2, v3, Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet;->onSaveInstanceState(Landroid/os/Bundle;)V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 11
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v8, v9, v10, Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v10
    invoke-direct v8, v10, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->imageRes(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)I
    move-result v2
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v10
    invoke-direct v8, v10, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->titleRes(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)I
    move-result v10
    invoke-virtual v8, v10, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->getString(I)Ljava/lang/String;
    move-result-object v10
    const-string v0, "getString(...)"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v3, v10
    check-cast v3, Ljava/lang/CharSequence;
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v10
    invoke-direct v8, v10, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->messageRes(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)I
    move-result v10
    invoke-virtual v8, v10, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->getString(I)Ljava/lang/String;
    move-result-object v10
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v4, v10
    check-cast v4, Ljava/lang/CharSequence;
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v10
    invoke-direct v8, v10, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->connectButtonRes(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)I
    move-result v10
    invoke-virtual v8, v10, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->getString(I)Ljava/lang/String;
    move-result-object v10
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v5, v10
    check-cast v5, Ljava/lang/CharSequence;
    new-instance v6, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet$$ExternalSyntheticLambda0;
    invoke-direct v6, v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;)V
    new-instance v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet$$ExternalSyntheticLambda1;
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;)V
    move-object v0, v8
    move-object v1, v9
    invoke-virtual/range v0 ... v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->bindHeroPrompt(Landroid/view/View; I Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    iget-object v9, v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->guideShowEventGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->tryConsume()Z
    move-result v9
    if-eqz v9, +013h
    sget-object v9, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v10
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->getHasRegisteredWork()Z
    move-result v0
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->getHasRegisteredIDE()Z
    move-result v1
    invoke-virtual v9, v10, v0, v1, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackGuideShow(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z Z)V
    return-void 
.end method

.method public final setOnConfirm(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->onConfirm Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setOnDismissListener(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->onDismissListener Lkotlin/jvm/functions/Function0;
    return-void 
.end method
