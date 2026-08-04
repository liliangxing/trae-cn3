# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/conversation/network/IRemoteModelsApi;
.super Ljava/lang/Object;
.source "IRemoteModelsApi.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    sput-object v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi;->Companion Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    return-void 
.end method

.method public abstract getModels(java.util.List  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method

.method public abstract getPcModels(java.lang.String  java.util.List  boolean  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method
