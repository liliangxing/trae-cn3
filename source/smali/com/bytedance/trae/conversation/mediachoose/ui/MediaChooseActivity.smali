# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "MediaChooseActivity.kt"


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    return-void 
.end method

.method public static com_bytedance_trae_conversation_mediachoose_ui_MediaChooseActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseActivity;->com_bytedance_trae_conversation_mediachoose_ui_MediaChooseActivity__onStop$___twin___()V
    invoke-static Lcom/bytedance/sysoptimizer/EnterTransitionCrashOptimizer;->getContext()Landroid/content/Context;
    move-result-object v0
    if-eqz v0, +013h
    check-cast v1, Landroid/app/Activity;
    invoke-virtual v1, Landroid/app/Activity;->getWindow()Landroid/view/Window;
    move-result-object v1
    invoke-virtual v1, Landroid/view/Window;->getDecorView()Landroid/view/View;
    move-result-object v1
    invoke-virtual v1, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;
    move-result-object v1
    invoke-virtual v1, Landroid/view/ViewTreeObserver;->dispatchOnPreDraw()Z
    return-void 
    :try_start_0xb
.end method

.method public com_bytedance_trae_conversation_mediachoose_ui_MediaChooseActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method public getDecorViewBackgroundColor()int
    .registers 2
    # ins_size=1
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_base_default I
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseActivity;->getColor(I)I
    move-result v0
    return v0
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 4
    # ins_size=2
    invoke-super v2, v3, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_media_choose_activity I
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseActivity;->setContentView(I)V
    if-nez v3, +01ah
    invoke-virtual v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v3
    invoke-virtual v3, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v3
    sget v0, Lcom/bytedance/trae/conversation/R$id;->trae_media_choose_container I
    new-instance v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-direct v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;-><init>()V
    check-cast v1, Landroidx/fragment/app/Fragment;
    invoke-virtual v3, v0, v1, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v3
    invoke-virtual v3, Landroidx/fragment/app/FragmentTransaction;->commit()I
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseActivity;->com_bytedance_trae_conversation_mediachoose_ui_MediaChooseActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseActivity;)V
    return-void 
.end method
