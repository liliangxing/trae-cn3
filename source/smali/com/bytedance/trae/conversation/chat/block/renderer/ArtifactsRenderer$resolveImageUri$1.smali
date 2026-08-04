# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;
.super Lkotlin/coroutines/jvm/internal/ContinuationImpl;
.source "ArtifactsRenderer.kt"

.field  I$0:I
.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  L$2:Ljava/lang/Object;
.field  L$3:Ljava/lang/Object;
.field  L$4:Ljava/lang/Object;
.field  L$5:Ljava/lang/Object;
.field  label:I
.field synthetic result:Ljava/lang/Object;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;


.method constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    invoke-direct v0, v2, Lkotlin/coroutines/jvm/internal/ContinuationImpl;-><init>(Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=2
    iput-object v9, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->result Ljava/lang/Object;
    iget v9, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->label I
    const/high16 v0, -2147483648
    or-int/2addr v9, v0
    iput v9, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->label I
    iget-object v0, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    move-object v7, v8
    check-cast v7, Lkotlin/coroutines/Continuation;
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->access$resolveImageUri(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/content/Context; Lcom/bytedance/trae/im/model/FileDiffInfo; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    return-object v9
.end method
