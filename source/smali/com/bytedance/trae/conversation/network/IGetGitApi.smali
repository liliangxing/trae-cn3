# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/conversation/network/IGetGitApi;
.super Ljava/lang/Object;
.source "IGetGitApi.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;
    sput-object v0, Lcom/bytedance/trae/conversation/network/IGetGitApi;->Companion Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;
    return-void 
.end method

.method public abstract getGitToken(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract listBranches(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract listRepositories(kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract listRepositoriesRaw(java.util.Map  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method
