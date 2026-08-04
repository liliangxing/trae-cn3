# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$1;
.super Lkotlin/coroutines/jvm/internal/ContinuationImpl;
.source "TraeHttpConnection.kt"

.field  label:I
.field synthetic result:Ljava/lang/Object;
.field final synthetic this$0:Lcom/bytedance/trae/network/TraeHttpConnection;


.method constructor <init>(com.bytedance.trae.network.TraeHttpConnection  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$1;->this$0 Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-direct v0, v2, Lkotlin/coroutines/jvm/internal/ContinuationImpl;-><init>(Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=2
    iput-object v13, v12, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$1;->result Ljava/lang/Object;
    iget v13, v12, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$1;->label I
    const/high16 v0, -2147483648
    or-int/2addr v13, v0
    iput v13, v12, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$1;->label I
    iget-object v0, v12, Lcom/bytedance/trae/network/TraeHttpConnection$rawBizCall$1;->this$0 Lcom/bytedance/trae/network/TraeHttpConnection;
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    move-object v11, v12
    check-cast v11, Lkotlin/coroutines/Continuation;
    invoke-virtual/range v0 ... v11, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCall(Ljava/lang/String; Ljava/lang/Class; Ljava/lang/reflect/Type; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    return-object v13
.end method
