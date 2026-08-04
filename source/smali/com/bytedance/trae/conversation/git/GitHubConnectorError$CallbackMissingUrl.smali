# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/git/GitHubConnectorError$CallbackMissingUrl;
.super Lcom/bytedance/trae/conversation/git/GitHubConnectorError;
.source "GitHubConnectorError.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/git/GitHubConnectorError$CallbackMissingUrl;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$CallbackMissingUrl;
    invoke-direct v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$CallbackMissingUrl;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$CallbackMissingUrl;->INSTANCE Lcom/bytedance/trae/conversation/git/GitHubConnectorError$CallbackMissingUrl;
    return-void 
.end method

.method private constructor <init>()void
    .registers 3
    # ins_size=1
    const-string v0, "Authorization callback URL not received."
    const/4 v1, 0
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorError;-><init>(Ljava/lang/String; Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public equals(java.lang.Object)boolean
    .registers 4
    # ins_size=2
    const/4 v0, 1
    if-ne v2, v3, +003h
    return v0
    instance-of v1, v3, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$CallbackMissingUrl;
    if-nez v1, +004h
    const/4 v3, 0
    return v3
    check-cast v3, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$CallbackMissingUrl;
    return v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    const v0, -1647039565
    return v0
.end method

.method public toString()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "CallbackMissingUrl"
    return-object v0
.end method
