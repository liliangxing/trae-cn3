# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/conversation/network/IGetProjectApi;
.super Ljava/lang/Object;
.source "IGetProjectApi.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;
    sput-object v0, Lcom/bytedance/trae/conversation/network/IGetProjectApi;->Companion Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;
    return-void 
.end method

.method public abstract authorizationResult(com.bytedance.trae.conversation.network.AuthorizationResultRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract authorizationResultRaw(com.bytedance.trae.conversation.network.AuthorizationResultRequest  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method

.method public abstract checkNeedAuthorization(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract checkNeedAuthorizationRaw(java.util.Map  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method

.method public abstract createFolder(com.bytedance.trae.conversation.network.CreateFolderRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract createFolderRaw(com.bytedance.trae.conversation.network.CreateFolderRequest  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method

.method public abstract getUserProjectFolders(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract getUserProjectFoldersRaw(java.util.Map  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method

.method public abstract listFolder(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract listFolderRaw(java.util.Map  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method

.method public abstract listProjects(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
