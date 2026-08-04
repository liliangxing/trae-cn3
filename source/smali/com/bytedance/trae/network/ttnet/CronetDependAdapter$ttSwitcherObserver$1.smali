# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/ttnet/CronetDependAdapter$ttSwitcherObserver$1;
.super Ljava/lang/Object;
.source "TTNetExt.kt"

.implements Lcom/bytedance/ttnet/TTWiFiCellSwitcher$Observer;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onStateChanged(com.bytedance.ttnet.TTWiFiCellSwitcher$State  com.bytedance.ttnet.TTWiFiCellSwitcher$State)void
    .registers 8
    # ins_size=3
    const-string/jumbo v0, previousState
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "currentState"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->INSTANCE Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;
    invoke-virtual v0, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->getMultiNetworkState()Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    invoke-virtual v7, Lcom/bytedance/ttnet/TTWiFiCellSwitcher$State;->code()I
    move-result v1
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/ttnet/TTWiFiCellSwitcher$State;->WIFI_WITH_CELLULAR_TRANS_DATA Lcom/bytedance/ttnet/TTWiFiCellSwitcher$State;
    if-ne v6, v0, +046h
    sget-object v6, Lcom/bytedance/trae/platform/service/ApplogService;->INSTANCE Lcom/bytedance/trae/platform/service/ApplogService;
    const/4 v0, 2
    new-array v0, v0, [Lkotlin/Pair;
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v1
    invoke-static Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->access$getAuto4GStartTime$p()J
    move-result-wide v3
    sub-long/2addr v1, v3
    const/16 v3, 1000
    int-to-long v3, v3
    div-long/2addr v1, v3
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    const-string v2, "duration"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 0
    aput-object v1, v0, v2
    sget-object v1, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->INSTANCE Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;
    invoke-static v1, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->access$nowBytes(Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;)J
    move-result-wide v1
    invoke-static Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->access$getTrafficBytesStart$p()J
    move-result-wide v3
    sub-long/2addr v1, v3
    const/16 v3, 1024
    int-to-long v3, v3
    div-long/2addr v1, v3
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    const-string v2, "data_size"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 1
    aput-object v1, v0, v2
    invoke-static v0, Landroidx/core/os/BundleKt;->bundleOf([Lkotlin/Pair;)Landroid/os/Bundle;
    move-result-object v0
    const-string v1, "flow_network_auto_4g_end"
    invoke-virtual v6, v1, v0, Lcom/bytedance/trae/platform/service/ApplogService;->reportEvent(Ljava/lang/String; Landroid/os/Bundle;)V
    sget-object v6, Lcom/bytedance/ttnet/TTWiFiCellSwitcher$State;->WAIT_USER_ALLOW_TO_CELLULAR Lcom/bytedance/ttnet/TTWiFiCellSwitcher$State;
    if-eq v7, v6, +025h
    sget-object v6, Lcom/bytedance/ttnet/TTWiFiCellSwitcher$State;->WIFI_WITH_CELLULAR_TRANS_DATA Lcom/bytedance/ttnet/TTWiFiCellSwitcher$State;
    if-ne v7, v6, +021h
    sget-object v6, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->INSTANCE Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v6
    invoke-static v6, v7, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->access$setAuto4GStartTime$p(J)V
    sget-object v6, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->INSTANCE Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;
    sget-object v6, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->INSTANCE Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;
    invoke-static v6, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->access$nowBytes(Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;)J
    move-result-wide v6
    invoke-static v6, v7, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->access$setTrafficBytesStart$p(J)V
    sget-object v6, Lcom/bytedance/trae/platform/service/ApplogService;->INSTANCE Lcom/bytedance/trae/platform/service/ApplogService;
    const-string v7, "flow_network_auto_4g_start"
    invoke-static Landroidx/core/os/BundleKt;->bundleOf()Landroid/os/Bundle;
    move-result-object v0
    invoke-virtual v6, v7, v0, Lcom/bytedance/trae/platform/service/ApplogService;->reportEvent(Ljava/lang/String; Landroid/os/Bundle;)V
    return-void 
.end method
