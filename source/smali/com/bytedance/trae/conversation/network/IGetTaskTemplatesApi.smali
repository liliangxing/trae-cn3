# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/conversation/network/IGetTaskTemplatesApi;
.super Ljava/lang/Object;
.source "IGetTaskTemplatesApi.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/network/IGetTaskTemplatesApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/network/IGetTaskTemplatesApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IGetTaskTemplatesApi$Companion;
    sput-object v0, Lcom/bytedance/trae/conversation/network/IGetTaskTemplatesApi;->Companion Lcom/bytedance/trae/conversation/network/IGetTaskTemplatesApi$Companion;
    return-void 
.end method

.method public abstract getTaskTemplates(kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
