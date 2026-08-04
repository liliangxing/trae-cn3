# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/DouyinEntryActivity;
.super Lcom/bytedance/sdk/account/platform/douyin/BaseDouyinEntryActivity;
.source "DouyinEntryActivity.kt"


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/sdk/account/platform/douyin/BaseDouyinEntryActivity;-><init>()V
    return-void 
.end method

.method public static com_bytedance_trae_login_DouyinEntryActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.login.DouyinEntryActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/DouyinEntryActivity;->com_bytedance_trae_login_DouyinEntryActivity__onStop$___twin___()V
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

.method public com_bytedance_trae_login_DouyinEntryActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/sdk/account/platform/douyin/BaseDouyinEntryActivity;->onStop()V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/DouyinEntryActivity;->com_bytedance_trae_login_DouyinEntryActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/login/DouyinEntryActivity;)V
    return-void 
.end method
