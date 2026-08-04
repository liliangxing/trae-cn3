# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity$setupViews$2;
.super Landroidx/activity/OnBackPressedCallback;
.source "DouyinBindPhoneActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;


.method constructor <init>(com.bytedance.trae.login.activity.DouyinBindPhoneActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity$setupViews$2;->this$0 Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;
    const/4 v1, 1
    invoke-direct v0, v1, Landroidx/activity/OnBackPressedCallback;-><init>(Z)V
    return-void 
.end method

.method public handleOnBackPressed()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity$setupViews$2;->this$0 Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;
    invoke-static v0, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->access$handleBackPressed(Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;)V
    return-void 
.end method
