# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/onboarding/OnboardingFragment$onViewCreated$2;
.super Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;
.source "OnboardingFragment.kt"

.field final synthetic this$0:Lcom/bytedance/trae/home/onboarding/OnboardingFragment;


.method constructor <init>(com.bytedance.trae.home.onboarding.OnboardingFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/onboarding/OnboardingFragment$onViewCreated$2;->this$0 Lcom/bytedance/trae/home/onboarding/OnboardingFragment;
    invoke-direct v0, Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;-><init>()V
    return-void 
.end method

.method public onPageSelected(int)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment$onViewCreated$2;->this$0 Lcom/bytedance/trae/home/onboarding/OnboardingFragment;
    invoke-static v0, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->access$getCurrentPage$p(Lcom/bytedance/trae/home/onboarding/OnboardingFragment;)I
    move-result v0
    if-le v5, v0, +005h
    const-string v0, "left"
    goto +4h
    const-string/jumbo v0, right
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string v3, "direction"
    invoke-virtual v2, v3, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string v0, "icube_onboarding_slide"
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    iget-object v0, v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment$onViewCreated$2;->this$0 Lcom/bytedance/trae/home/onboarding/OnboardingFragment;
    invoke-static v0, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->access$getExposedPositions$p(Lcom/bytedance/trae/home/onboarding/OnboardingFragment;)Ljava/util/Set;
    move-result-object v0
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +015h
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    const-string v2, "position"
    invoke-virtual v1, v2, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string v2, "onboarding_page_view"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    iget-object v0, v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment$onViewCreated$2;->this$0 Lcom/bytedance/trae/home/onboarding/OnboardingFragment;
    invoke-static v0, v5, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->access$setCurrentPage$p(Lcom/bytedance/trae/home/onboarding/OnboardingFragment; I)V
    iget-object v0, v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment$onViewCreated$2;->this$0 Lcom/bytedance/trae/home/onboarding/OnboardingFragment;
    invoke-static v0, v5, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->access$updateIndicator(Lcom/bytedance/trae/home/onboarding/OnboardingFragment; I)V
    iget-object v0, v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment$onViewCreated$2;->this$0 Lcom/bytedance/trae/home/onboarding/OnboardingFragment;
    invoke-static v0, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->access$getPages$p(Lcom/bytedance/trae/home/onboarding/OnboardingFragment;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;
    iget-object v0, v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment$onViewCreated$2;->this$0 Lcom/bytedance/trae/home/onboarding/OnboardingFragment;
    invoke-static v0, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->access$getBtnAction$p(Lcom/bytedance/trae/home/onboarding/OnboardingFragment;)Landroid/widget/TextView;
    move-result-object v0
    if-nez v0, +008h
    const-string v0, "btnAction"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    iget-object v1, v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment$onViewCreated$2;->this$0 Lcom/bytedance/trae/home/onboarding/OnboardingFragment;
    invoke-virtual v5, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->getButtonTextResId()I
    move-result v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v4, Lcom/bytedance/trae/home/onboarding/OnboardingFragment$onViewCreated$2;->this$0 Lcom/bytedance/trae/home/onboarding/OnboardingFragment;
    invoke-virtual v5, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->isLastPage()Z
    move-result v5
    invoke-static v0, v5, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->access$updateButtonStyle(Lcom/bytedance/trae/home/onboarding/OnboardingFragment; Z)V
    return-void 
.end method
