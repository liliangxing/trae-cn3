# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final synthetic Lcom/bytedance/trae/conversation/CliListRepository$1;
.super Lkotlin/jvm/internal/FunctionReferenceImpl;
.source "CliListRepository.kt"

.implements Lkotlin/jvm/functions/Function1;


.method constructor <init>(java.lang.Object)void
    .registers 9
    # ins_size=2
    const/4 v1, 1
    const-class v3, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    const-string/jumbo v4, trackDevicePairCount
    const-string/jumbo v5, trackDevicePairCount$conversation_mainlandRelease(Lcom/bytedance/trae/conversation/DeviceCountSnapshot;)V
    const/4 v6, 0
    move-object v0, v7
    move-object v2, v8
    invoke-direct/range v0 ... v6, Lkotlin/jvm/internal/FunctionReferenceImpl;-><init>(I Ljava/lang/Object; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; I)V
    return-void 
.end method

.method public bridge synthetic invoke(java.lang.Object)java.lang.Object
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/trae/conversation/DeviceCountSnapshot;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/CliListRepository$1;->invoke(Lcom/bytedance/trae/conversation/DeviceCountSnapshot;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final invoke(com.bytedance.trae.conversation.DeviceCountSnapshot)void
    .registers 3
    # ins_size=2
    const-string v0, "p0"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/CliListRepository$1;->receiver Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackDevicePairCount$conversation_mainlandRelease(Lcom/bytedance/trae/conversation/DeviceCountSnapshot;)V
    return-void 
.end method
