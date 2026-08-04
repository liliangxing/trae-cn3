# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/conversation/network/IGithubAccessApi;
.super Ljava/lang/Object;
.source "IGithubAccessApi.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/network/IGithubAccessApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/network/IGithubAccessApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IGithubAccessApi$Companion;
    sput-object v0, Lcom/bytedance/trae/conversation/network/IGithubAccessApi;->Companion Lcom/bytedance/trae/conversation/network/IGithubAccessApi$Companion;
    return-void 
.end method

.method public abstract disconnectThirdPartyToken(com.bytedance.trae.conversation.network.DisconnectThirdPartyTokenRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract getThirdPartyToken(com.bytedance.trae.conversation.network.GetThirdPartyTokenRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract setThirdPartyToken(com.bytedance.trae.conversation.network.SetThirdPartyTokenRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
