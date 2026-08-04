# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public interface abstract Lcom/bytedance/trae/network/RegisterAppApi;
.super Ljava/lang/Object;
.source "RegisterAppApi.kt"

.field public static final Companion:Lcom/bytedance/trae/network/RegisterAppApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/RegisterAppApi$Companion;->$$INSTANCE Lcom/bytedance/trae/network/RegisterAppApi$Companion;
    sput-object v0, Lcom/bytedance/trae/network/RegisterAppApi;->Companion Lcom/bytedance/trae/network/RegisterAppApi$Companion;
    return-void 
.end method

.method public abstract fetchApp(com.bytedance.trae.network.RegisterAppRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
