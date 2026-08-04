# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver;
.super Landroid/content/BroadcastReceiver;
.source "ScreenStateManager.kt"


.method public static synthetic $r8$lambda$8XI_MUuFIfmLkvCrNTNa4ErgP4o(com.bytedance.trae.network.util.ScreenStateManager$ScreenStateListener)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver;->onReceive$lambda$2(Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenStateListener;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Y1E1e0TNG4ildpqPB08YANZ5MPE(com.bytedance.trae.network.util.ScreenStateManager$ScreenStateListener)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver;->onReceive$lambda$1(Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenStateListener;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$lnEJ0A1ZS5JzclZGl_8tN24f4BM(com.bytedance.trae.network.util.ScreenStateManager$ScreenStateListener)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver;->onReceive$lambda$0(Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenStateListener;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroid/content/BroadcastReceiver;-><init>()V
    return-void 
.end method

.method private final notifyListeners(kotlin.jvm.functions.Function1)void
    .registers 6
    # ins_size=2
    invoke-static Lcom/bytedance/trae/network/util/ScreenStateManager;->access$getListeners$p()Ljava/util/concurrent/CopyOnWriteArraySet;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenStateListener;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v5, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto -12h
    move-exception v1
    const-string v2, "Error notifying listener"
    check-cast v1, Ljava/lang/Throwable;
    const-string v3, "ScreenListener"
    invoke-static v3, v2, v1, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    goto -1dh
    return-void 
    :try_start_0x16
.end method

.method private static final onReceive$lambda$0(com.bytedance.trae.network.util.ScreenStateManager$ScreenStateListener)kotlin.Unit
    .registers 2
    # ins_size=1
    const-string v0, "it"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v1, Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenStateListener;->onScreenOn()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onReceive$lambda$1(com.bytedance.trae.network.util.ScreenStateManager$ScreenStateListener)kotlin.Unit
    .registers 2
    # ins_size=1
    const-string v0, "it"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v1, Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenStateListener;->onScreenOff()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onReceive$lambda$2(com.bytedance.trae.network.util.ScreenStateManager$ScreenStateListener)kotlin.Unit
    .registers 2
    # ins_size=1
    const-string v0, "it"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v1, Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenStateListener;->onUserPresent()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public onReceive(android.content.Context  android.content.Intent)void
    .registers 4
    # ins_size=3
    if-eqz v3, +007h
    invoke-virtual v3, Landroid/content/Intent;->getAction()Ljava/lang/String;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    if-eqz v2, +04ah
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v3
    const v0, -2128145023
    if-eq v3, v0, +030h
    const v0, -1454123155
    if-eq v3, v0, +01ah
    const v0, 823795052
    if-eq v3, v0, +003h
    goto +35h
    const-string v3, "android.intent.action.USER_PRESENT"
    invoke-virtual v2, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +2ch
    new-instance v2, Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver$$ExternalSyntheticLambda2;
    invoke-direct v2, Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver$$ExternalSyntheticLambda2;-><init>()V
    invoke-direct v1, v2, Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver;->notifyListeners(Lkotlin/jvm/functions/Function1;)V
    goto +23h
    const-string v3, "android.intent.action.SCREEN_ON"
    invoke-virtual v2, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +01ch
    new-instance v2, Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver$$ExternalSyntheticLambda0;
    invoke-direct v2, Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver$$ExternalSyntheticLambda0;-><init>()V
    invoke-direct v1, v2, Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver;->notifyListeners(Lkotlin/jvm/functions/Function1;)V
    goto +12h
    const-string v3, "android.intent.action.SCREEN_OFF"
    invoke-virtual v2, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +9h
    new-instance v2, Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver$$ExternalSyntheticLambda1;
    invoke-direct v2, Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver$$ExternalSyntheticLambda1;-><init>()V
    invoke-direct v1, v2, Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver;->notifyListeners(Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method
