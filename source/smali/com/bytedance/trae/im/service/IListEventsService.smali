# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/IListEventsService;
.super Ljava/lang/Object;
.source "IListEventsService.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/IListEventsService$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IListEventsService$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IListEventsService$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/IListEventsService;->Companion Lcom/bytedance/trae/im/service/IListEventsService$Companion;
    return-void 
.end method

.method public abstract listEvents(java.lang.String  java.lang.Integer  java.lang.Integer  int  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
