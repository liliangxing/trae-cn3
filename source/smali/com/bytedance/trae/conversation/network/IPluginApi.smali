# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/conversation/network/IPluginApi;
.super Ljava/lang/Object;
.source "IPluginApi.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/network/IPluginApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/network/IPluginApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IPluginApi$Companion;
    sput-object v0, Lcom/bytedance/trae/conversation/network/IPluginApi;->Companion Lcom/bytedance/trae/conversation/network/IPluginApi$Companion;
    return-void 
.end method

.method public abstract listLocalPluginsRaw(java.util.Map  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method

.method public abstract listRemotePluginsRaw(java.util.Map  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method
