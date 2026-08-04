# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/IRevertTaskApi$Companion;
.super Ljava/lang/Object;
.source "IRevertTaskApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/im/service/IRevertTaskApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/IRevertTaskApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/im/service/IRevertTaskApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IRevertTaskApi$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IRevertTaskApi$Companion;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final safeCall(kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)java.lang.Object
    .registers 12
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v1, revert_task
    const-class v2, Lcom/bytedance/trae/im/service/IRevertTaskApi;
    const/4 v4, 0
    const/4 v5, 0
    const/16 v7, 24
    const/4 v8, 0
    move-object v3, v10
    move-object v6, v11
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/network/TraeHttpConnection;->safeCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lkotlin/jvm/functions/Function2; Ljava/lang/String; Ljava/util/Set; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    return-object v10
.end method
