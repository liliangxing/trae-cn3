# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/InputFragment$benefitSwitchListener$1;
.super Ljava/lang/Object;
.source "InputFragment.kt"

.implements Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$OnBenefitSwitchListener;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/widget/InputFragment;


.method public static synthetic $r8$lambda$F1bRKyFxEtzf2i4-88nZbj4wVTw(com.bytedance.trae.conversation.widget.InputFragment  boolean)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$benefitSwitchListener$1;->onBenefitSwitched$lambda$0(Lcom/bytedance/trae/conversation/widget/InputFragment; Z)V
    return-void 
.end method

.method constructor <init>(com.bytedance.trae.conversation.widget.InputFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$benefitSwitchListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final onBenefitSwitched$lambda$0(com.bytedance.trae.conversation.widget.InputFragment  boolean)void
    .registers 7
    # ins_size=2
    const-string v0, "express_pass_enable_from_agent"
    const-string/jumbo v1, showExpressPassPopWindow:
    invoke-static v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$get_binding$p(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    sget-object v2, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v2
    const/4 v3, 0
    if-eqz v2, +011h
    invoke-static v5, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$setExpressPassVisible$p(Lcom/bytedance/trae/conversation/widget/InputFragment; Z)V
    invoke-static v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getBinding(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v5
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    const/16 v6, 8
    invoke-virtual v5, v6, Landroid/widget/ImageView;->setVisibility(I)V
    return-void 
    sget-object v2, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v2
    invoke-virtual v2, v0, v3, Lcom/bytedance/keva/Keva;->getBoolean(Ljava/lang/String; Z)Z
    move-result v2
    const/4 v4, 1
    if-nez v2, +00eh
    sget-object v2, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v2
    invoke-virtual v2, v0, v4, Lcom/bytedance/keva/Keva;->storeBoolean(Ljava/lang/String; Z)V
    invoke-static v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$showExpressPassPopWindow(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    sget-object v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->saveAutoUseExpressPass(Z)V
    const-string v0, "ExpressPassBenefitManager"
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lcom/facebook/common/logging/FLog;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getBinding(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setVisibility(I)V
    if-eqz v6, +020h
    invoke-static v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getInfinite$p(Lcom/bytedance/trae/conversation/widget/InputFragment;)Z
    move-result v6
    if-eqz v6, +00eh
    invoke-static v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getBinding(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v5
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    sget v6, Lcom/bytedance/trae/conversation/R$drawable;->ic_input_bar_express_999 I
    invoke-virtual v5, v6, Landroid/widget/ImageView;->setImageResource(I)V
    goto +18h
    invoke-static v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getBinding(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v5
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    sget v6, Lcom/bytedance/trae/conversation/R$drawable;->ic_input_bar_use_express_pass I
    invoke-virtual v5, v6, Landroid/widget/ImageView;->setImageResource(I)V
    goto +ch
    invoke-static v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getBinding(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v5
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    sget v6, Lcom/bytedance/trae/conversation/R$drawable;->ic_input_bar_no_use_express_pass I
    invoke-virtual v5, v6, Landroid/widget/ImageView;->setImageResource(I)V
    return-void 
    :try_start_0x5
.end method

.method public onBenefitSwitched(boolean)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment$benefitSwitchListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    if-eqz v0, +00ch
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/InputFragment$benefitSwitchListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputFragment$benefitSwitchListener$1$$ExternalSyntheticLambda0;
    invoke-direct v2, v1, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$benefitSwitchListener$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment; Z)V
    invoke-virtual v0, v2, Landroidx/fragment/app/FragmentActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    return-void 
.end method
