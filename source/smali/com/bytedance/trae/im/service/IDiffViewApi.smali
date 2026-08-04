# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/IDiffViewApi;
.super Ljava/lang/Object;
.source "IDiffViewApi.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/IDiffViewApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IDiffViewApi$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IDiffViewApi$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/IDiffViewApi;->Companion Lcom/bytedance/trae/im/service/IDiffViewApi$Companion;
    return-void 
.end method

.method public abstract getDiffView(java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
