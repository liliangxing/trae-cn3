# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/conversation/network/IMarketplaceApi;
.super Ljava/lang/Object;
.source "IMarketplaceApi.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion;
    sput-object v0, Lcom/bytedance/trae/conversation/network/IMarketplaceApi;->Companion Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion;
    return-void 
.end method

.method public abstract listPlugins(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
