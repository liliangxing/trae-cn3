# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/InitMarkdownTask$runInternal$1$2;
.super Ljava/lang/Object;
.source "InitMarkdownTask.kt"

.implements Lcom/larus/business/markdown/api/depend/LinkResolverWithStyle;

.field final synthetic this$0:Lcom/bytedance/trae/init/task/InitMarkdownTask;


.method constructor <init>(com.bytedance.trae.init.task.InitMarkdownTask)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/init/task/InitMarkdownTask$runInternal$1$2;->this$0 Lcom/bytedance/trae/init/task/InitMarkdownTask;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public enableLinkColor(java.lang.String)boolean
    .registers 3
    # ins_size=2
    const-string/jumbo v0, url
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    return v2
.end method

.method public enableLinkStyle(java.lang.String)boolean
    .registers 3
    # ins_size=2
    const-string v0, "link"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/init/task/InitMarkdownTask$runInternal$1$2;->this$0 Lcom/bytedance/trae/init/task/InitMarkdownTask;
    invoke-static v0, v2, Lcom/bytedance/trae/init/task/InitMarkdownTask;->access$isBlockedLink(Lcom/bytedance/trae/init/task/InitMarkdownTask; Ljava/lang/String;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    return v2
.end method

.method public getLinkColor(java.lang.String)int
    .registers 3
    # ins_size=2
    const-string/jumbo v0, url
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    return v2
.end method

.method public needUnderline(java.lang.String)boolean
    .registers 3
    # ins_size=2
    const-string v0, "link"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    return v2
.end method

.method public resolve(android.view.View  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "link"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/init/task/InitMarkdownTask$runInternal$1$2;->this$0 Lcom/bytedance/trae/init/task/InitMarkdownTask;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/init/task/InitMarkdownTask;->access$openLink(Lcom/bytedance/trae/init/task/InitMarkdownTask; Landroid/view/View; Ljava/lang/String;)V
    return-void 
.end method

.method public resolve(android.view.View  java.lang.String  boolean)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "link"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v4, +003h
    return-void 
    iget-object v4, v1, Lcom/bytedance/trae/init/task/InitMarkdownTask$runInternal$1$2;->this$0 Lcom/bytedance/trae/init/task/InitMarkdownTask;
    invoke-static v4, v2, v3, Lcom/bytedance/trae/init/task/InitMarkdownTask;->access$openLink(Lcom/bytedance/trae/init/task/InitMarkdownTask; Landroid/view/View; Ljava/lang/String;)V
    return-void 
.end method
