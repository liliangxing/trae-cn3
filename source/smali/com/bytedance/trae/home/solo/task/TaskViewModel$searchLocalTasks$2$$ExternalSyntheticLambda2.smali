# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;


.method public synthetic constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-static v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;->$r8$lambda$xwcj72WsicYCpXVMAqVW7SO9mC8(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Ljava/lang/String;
    move-result-object v1
    return-object v1
.end method
