# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$onCreate$4;
.super Landroidx/activity/OnBackPressedCallback;
.source "SimpleWebViewActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;


.method constructor <init>(com.bytedance.trae.common.activity.SimpleWebViewActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$onCreate$4;->this$0 Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;
    const/4 v1, 1
    invoke-direct v0, v1, Landroidx/activity/OnBackPressedCallback;-><init>(Z)V
    return-void 
.end method

.method public handleOnBackPressed()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$onCreate$4;->this$0 Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;
    invoke-static v0, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->access$getWebView$p(Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;)Landroid/webkit/WebView;
    move-result-object v0
    const/4 v1, 0
    const-string/jumbo v2, webView
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Landroid/webkit/WebView;->canGoBack()Z
    move-result v0
    if-eqz v0, +013h
    iget-object v0, v3, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$onCreate$4;->this$0 Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;
    invoke-static v0, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->access$getWebView$p(Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;)Landroid/webkit/WebView;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, Landroid/webkit/WebView;->goBack()V
    goto +eh
    const/4 v0, 0
    invoke-virtual v3, v0, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$onCreate$4;->setEnabled(Z)V
    iget-object v0, v3, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$onCreate$4;->this$0 Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;
    invoke-virtual v0, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    move-result-object v0
    invoke-virtual v0, Landroidx/activity/OnBackPressedDispatcher;->onBackPressed()V
    return-void 
.end method
