# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/InitWebViewStartupTask$startUpWebView$1;
.super Ljava/lang/Object;
.source "InitWebViewStartupTask.kt"

.implements Landroidx/webkit/WebViewOutcomeReceiver;

.field final synthetic $startTime:J


.method constructor <init>(long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/init/task/InitWebViewStartupTask$startUpWebView$1;->$startTime J
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onError(androidx.webkit.WebViewStartupException)void
    .registers 8
    # ins_size=2
    const-string v0, "error"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, startUpWebView failed, costMs=
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v2
    iget-wide v4, v6, Lcom/bytedance/trae/init/task/InitWebViewStartupTask$startUpWebView$1;->$startTime J
    sub-long/2addr v2, v4
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    check-cast v7, Ljava/lang/Throwable;
    const-string v2, "WebViewStartup"
    invoke-virtual v0, v2, v1, v7, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
.end method

.method public bridge synthetic onError(java.lang.Throwable)void
    .registers 2
    # ins_size=2
    check-cast v1, Landroidx/webkit/WebViewStartupException;
    invoke-virtual v0, v1, Lcom/bytedance/trae/init/task/InitWebViewStartupTask$startUpWebView$1;->onError(Landroidx/webkit/WebViewStartupException;)V
    return-void 
.end method

.method public onResult(androidx.webkit.WebViewStartUpResult)void
    .registers 7
    # ins_size=2
    const-string/jumbo v0, result
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, startUpWebView success, costMs=
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v1
    iget-wide v3, v5, Lcom/bytedance/trae/init/task/InitWebViewStartupTask$startUpWebView$1;->$startTime J
    sub-long/2addr v1, v3
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "WebViewStartup"
    invoke-virtual v6, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public bridge synthetic onResult(java.lang.Object)void
    .registers 2
    # ins_size=2
    check-cast v1, Landroidx/webkit/WebViewStartUpResult;
    invoke-virtual v0, v1, Lcom/bytedance/trae/init/task/InitWebViewStartupTask$startUpWebView$1;->onResult(Landroidx/webkit/WebViewStartUpResult;)V
    return-void 
.end method
