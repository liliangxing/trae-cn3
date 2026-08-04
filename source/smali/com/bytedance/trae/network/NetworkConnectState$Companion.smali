# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/NetworkConnectState$Companion;
.super Ljava/lang/Object;
.source "NetworkConnectState.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/network/NetworkConnectState$Companion;-><init>()V
    return-void 
.end method

.method public final fromValue(int)com.bytedance.trae.network.NetworkConnectState
    .registers 5
    # ins_size=2
    invoke-static Lcom/bytedance/trae/network/NetworkConnectState;->getEntries()Lkotlin/enums/EnumEntries;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +015h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/network/NetworkConnectState;
    invoke-virtual v2, Lcom/bytedance/trae/network/NetworkConnectState;->getValue()I
    move-result v2
    if-ne v2, v4, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, -016h
    goto +2h
    const/4 v1, 0
    check-cast v1, Lcom/bytedance/trae/network/NetworkConnectState;
    return-object v1
.end method
