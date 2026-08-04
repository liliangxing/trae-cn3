# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSessionClient;
.super Ljava/lang/Object;
.source "HtmlArtifactRemoteArchiveUrlResolver.kt"

.implements Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSessionClient;

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSessionClient;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSessionClient;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSessionClient;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSessionClient;->INSTANCE Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSessionClient;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getChatSession(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/im/service/IChatSessionApi;->Companion Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->getChatSessionRawCall(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public wakeupSandbox(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/im/service/IChatSessionApi;->Companion Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->wakeupSandboxRawCall(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method
