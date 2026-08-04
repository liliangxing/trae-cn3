# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/cn/wxapi/WXEntryActivity;
.super Lcom/bytedance/ug/sdk/share/channel/wechat/view/BaseWXEntryActivity;
.source "WXEntryActivity.java"


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/ug/sdk/share/channel/wechat/view/BaseWXEntryActivity;-><init>()V
    return-void 
.end method

.method public static com_bytedance_trae_cn_wxapi_WXEntryActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.cn.wxapi.WXEntryActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/cn/wxapi/WXEntryActivity;->com_bytedance_trae_cn_wxapi_WXEntryActivity__onStop$___twin___()V
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

.method public com_bytedance_trae_cn_wxapi_WXEntryActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/ug/sdk/share/channel/wechat/view/BaseWXEntryActivity;->onStop()V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/cn/wxapi/WXEntryActivity;->com_bytedance_trae_cn_wxapi_WXEntryActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/cn/wxapi/WXEntryActivity;)V
    return-void 
.end method
