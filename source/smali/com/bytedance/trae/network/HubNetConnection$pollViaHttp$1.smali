# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/network/HubNetConnection$pollViaHttp$1;
.super Lkotlin/coroutines/jvm/internal/ContinuationImpl;
.source "HubNetConnection.kt"

.field  L$0:Ljava/lang/Object;
.field  label:I
.field synthetic result:Ljava/lang/Object;
.field final synthetic this$0:Lcom/bytedance/trae/network/HubNetConnection;


.method constructor <init>(com.bytedance.trae.network.HubNetConnection  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/network/HubNetConnection$pollViaHttp$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-direct v0, v2, Lkotlin/coroutines/jvm/internal/ContinuationImpl;-><init>(Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    iput-object v4, v3, Lcom/bytedance/trae/network/HubNetConnection$pollViaHttp$1;->result Ljava/lang/Object;
    iget v4, v3, Lcom/bytedance/trae/network/HubNetConnection$pollViaHttp$1;->label I
    const/high16 v0, -2147483648
    or-int/2addr v4, v0
    iput v4, v3, Lcom/bytedance/trae/network/HubNetConnection$pollViaHttp$1;->label I
    iget-object v4, v3, Lcom/bytedance/trae/network/HubNetConnection$pollViaHttp$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    const-wide/16 v0, 0
    move-object v2, v3
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-static v4, v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection;->access$pollViaHttp(Lcom/bytedance/trae/network/HubNetConnection; J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    return-object v4
.end method
