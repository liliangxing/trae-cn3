# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/IListClisService;
.super Ljava/lang/Object;
.source "IListClisService.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/IListClisService$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IListClisService$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IListClisService$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/IListClisService;->Companion Lcom/bytedance/trae/im/service/IListClisService$Companion;
    return-void 
.end method

.method public abstract getOnboardingState(kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract listClis(java.lang.String  int  int  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract renameCli(com.bytedance.trae.im.service.RenameCliRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract unregisterCli(com.bytedance.trae.im.service.UnregisterCliRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
