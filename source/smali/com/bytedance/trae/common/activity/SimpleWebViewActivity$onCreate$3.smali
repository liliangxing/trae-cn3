# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$onCreate$3;
.super Landroid/webkit/WebViewClient;
.source "SimpleWebViewActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;


.method constructor <init>(com.bytedance.trae.common.activity.SimpleWebViewActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$onCreate$3;->this$0 Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;
    invoke-direct v0, Landroid/webkit/WebViewClient;-><init>()V
    return-void 
.end method

.method public shouldOverrideUrlLoading(android.webkit.WebView  android.webkit.WebResourceRequest)boolean
    .registers 5
    # ins_size=3
    const/4 v3, 0
    if-eqz v4, +02ch
    invoke-interface v4, Landroid/webkit/WebResourceRequest;->getUrl()Landroid/net/Uri;
    move-result-object v4
    if-nez v4, +003h
    goto +24h
    invoke-virtual v4, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +01fh
    const-string v1, "http"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +017h
    const-string v1, "https"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00fh
    iget-object v3, v2, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$onCreate$3;->this$0 Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;
    new-instance v0, Landroid/content/Intent;
    const-string v1, "android.intent.action.VIEW"
    invoke-direct v0, v1, v4, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    invoke-virtual v3, v0, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->startActivity(Landroid/content/Intent;)V
    const/4 v3, 1
    return v3
    :try_start_0x20
.end method
