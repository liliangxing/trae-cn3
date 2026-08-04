# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;
.super Lkotlin/coroutines/jvm/internal/ContinuationImpl;
.source "TraeHttpConnection.kt"

.field  J$0:J
.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  L$2:Ljava/lang/Object;
.field  label:I
.field synthetic result:Ljava/lang/Object;
.field final synthetic this$0:Lcom/bytedance/trae/network/TraeHttpConnection;


.method constructor <init>(com.bytedance.trae.network.TraeHttpConnection  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;->this$0 Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-direct v0, v2, Lkotlin/coroutines/jvm/internal/ContinuationImpl;-><init>(Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    iput-object v8, v7, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;->result Ljava/lang/Object;
    iget v8, v7, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;->label I
    const/high16 v0, -2147483648
    or-int/2addr v8, v0
    iput v8, v7, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;->label I
    iget-object v0, v7, Lcom/bytedance/trae/network/TraeHttpConnection$safeCall$2;->this$0 Lcom/bytedance/trae/network/TraeHttpConnection;
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    move-object v6, v7
    check-cast v6, Lkotlin/coroutines/Continuation;
    invoke-virtual/range v0 ... v6, Lcom/bytedance/trae/network/TraeHttpConnection;->safeCall(Ljava/lang/String; Ljava/lang/Class; Lkotlin/jvm/functions/Function2; Ljava/lang/String; Ljava/util/Set; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    return-object v8
.end method
