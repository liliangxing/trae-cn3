# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public interface abstract Lcom/bytedance/trae/network/HubNetFallbackApi;
.super Ljava/lang/Object;
.source "HubNetFallbackApi.kt"

.field public static final Companion:Lcom/bytedance/trae/network/HubNetFallbackApi$Companion;
.field public static final SSE_POLL_PATH:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion;->$$INSTANCE Lcom/bytedance/trae/network/HubNetFallbackApi$Companion;
    sput-object v0, Lcom/bytedance/trae/network/HubNetFallbackApi;->Companion Lcom/bytedance/trae/network/HubNetFallbackApi$Companion;
    return-void 
.end method

.method public abstract poll(long  java.lang.String  java.lang.Long  java.lang.Integer  int  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract push(com.bytedance.trae.network.FallbackPushRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
