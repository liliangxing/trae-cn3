# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource;
.super Ljava/lang/Object;
.source "HtmlArtifactRemoteArchiveUrlResolver.kt"

.implements Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSandboxStatusSource;

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource;
.field private static final WS_PROTO_SANDBOX_STATUS_CHANGE:I


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource;->INSTANCE Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public updates()kotlinx.coroutines.flow.Flow
    .registers 3
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v0, Lkotlin/jvm/functions/Function2;
    invoke-static v0, Lkotlinx/coroutines/flow/FlowKt;->callbackFlow(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;
    move-result-object v0
    return-object v0
.end method
