# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/util/ScreenStateManager;
.super Ljava/lang/Object;
.source "ScreenStateManager.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/network/util/ScreenStateManager;
.field private static final listeners:Ljava/util/concurrent/CopyOnWriteArraySet;
.field private static receiver:Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/util/ScreenStateManager;
    invoke-direct v0, Lcom/bytedance/trae/network/util/ScreenStateManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/util/ScreenStateManager;->INSTANCE Lcom/bytedance/trae/network/util/ScreenStateManager;
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-direct v0, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/util/ScreenStateManager;->listeners Ljava/util/concurrent/CopyOnWriteArraySet;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static INVOKEVIRTUAL_com_bytedance_trae_network_util_ScreenStateManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(android.app.Application  android.content.BroadcastReceiver  android.content.IntentFilter)android.content.Intent
    .registers 10
    # ins_size=3
    invoke-static Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer;->fixedOpen()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer;->doHWReceiverFix()V
    invoke-static Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer;->doRegisterHandler()Z
    move-result v0
    if-eqz v0, +00fh
    invoke-static Lcom/bytedance/sysoptimizer/ReceiverRegisterLancet;->initHandler()V
    check-cast v7, Landroid/content/Context;
    sget-object v0, Lcom/bytedance/sysoptimizer/ReceiverRegisterLancet;->sReceiverHandler Landroid/os/Handler;
    const/4 v1, 0
    invoke-virtual v7, v8, v9, v1, v0, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver; Landroid/content/IntentFilter; Ljava/lang/String; Landroid/os/Handler;)Landroid/content/Intent;
    move-result-object v7
    return-object v7
    invoke-static Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer;->getReceiverRegisterHandler()Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer$BroadcastReceiverRegisterCallback;
    move-result-object v0
    if-eqz v0, +01dh
    invoke-static Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer;->getReceiverRegisterHandler()Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer$BroadcastReceiverRegisterCallback;
    move-result-object v0
    invoke-interface v0, v9, Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer$BroadcastReceiverRegisterCallback;->needHookFilter(Landroid/content/IntentFilter;)Z
    move-result v0
    if-eqz v0, +013h
    invoke-static Lcom/bytedance/sysoptimizer/ReceiverRegisterLancet;->initProxyHandler()V
    move-object v1, v7
    check-cast v1, Landroid/content/Context;
    const/4 v4, 0
    sget-object v5, Lcom/bytedance/sysoptimizer/ReceiverRegisterLancet;->sProxyHandler Landroid/os/Handler;
    const/4 v6, 2
    move-object v2, v8
    move-object v3, v9
    invoke-static/range v1 ... v6, Landroidx/core/content/ContextCompat;->registerReceiver(Landroid/content/Context; Landroid/content/BroadcastReceiver; Landroid/content/IntentFilter; Ljava/lang/String; Landroid/os/Handler; I)Landroid/content/Intent;
    move-result-object v7
    return-object v7
    invoke-virtual v7, v8, v9, Landroid/app/Application;->registerReceiver(Landroid/content/BroadcastReceiver; Landroid/content/IntentFilter;)Landroid/content/Intent;
    move-result-object v7
    return-object v7
    move-exception v7
    invoke-static Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer;->fixedOpen()Z
    move-result v0
    if-eqz v0, +007h
    invoke-static v8, v9, Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer;->registerReceiver(Landroid/content/BroadcastReceiver; Landroid/content/IntentFilter;)Landroid/content/Intent;
    move-result-object v7
    return-object v7
    throw v7
    :try_start_0x9
.end method

.method public static INVOKEVIRTUAL_com_bytedance_trae_network_util_ScreenStateManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(android.app.Application  android.content.BroadcastReceiver  android.content.IntentFilter  int)android.content.Intent
    .registers 11
    # ins_size=4
    invoke-static Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer;->fixedOpen()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer;->doHWReceiverFix()V
    invoke-static Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer;->doRegisterHandler()Z
    move-result v0
    if-eqz v0, +00fh
    invoke-static Lcom/bytedance/sysoptimizer/ReceiverRegisterLancet;->initHandler()V
    check-cast v7, Landroid/content/Context;
    sget-object v0, Lcom/bytedance/sysoptimizer/ReceiverRegisterLancet;->sReceiverHandler Landroid/os/Handler;
    const/4 v1, 0
    invoke-virtual v7, v8, v9, v1, v0, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver; Landroid/content/IntentFilter; Ljava/lang/String; Landroid/os/Handler;)Landroid/content/Intent;
    move-result-object v7
    return-object v7
    invoke-static Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer;->getReceiverRegisterHandler()Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer$BroadcastReceiverRegisterCallback;
    move-result-object v0
    if-eqz v0, +01dh
    invoke-static Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer;->getReceiverRegisterHandler()Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer$BroadcastReceiverRegisterCallback;
    move-result-object v0
    invoke-interface v0, v9, Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer$BroadcastReceiverRegisterCallback;->needHookFilter(Landroid/content/IntentFilter;)Z
    move-result v0
    if-eqz v0, +013h
    invoke-static Lcom/bytedance/sysoptimizer/ReceiverRegisterLancet;->initProxyHandler()V
    move-object v1, v7
    check-cast v1, Landroid/content/Context;
    const/4 v4, 0
    sget-object v5, Lcom/bytedance/sysoptimizer/ReceiverRegisterLancet;->sProxyHandler Landroid/os/Handler;
    move-object v2, v8
    move-object v3, v9
    move v6, v10
    invoke-static/range v1 ... v6, Landroidx/core/content/ContextCompat;->registerReceiver(Landroid/content/Context; Landroid/content/BroadcastReceiver; Landroid/content/IntentFilter; Ljava/lang/String; Landroid/os/Handler; I)Landroid/content/Intent;
    move-result-object v7
    return-object v7
    invoke-virtual v7, v8, v9, v10, Landroid/app/Application;->registerReceiver(Landroid/content/BroadcastReceiver; Landroid/content/IntentFilter; I)Landroid/content/Intent;
    move-result-object v7
    return-object v7
    move-exception v7
    invoke-static Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer;->fixedOpen()Z
    move-result v0
    if-eqz v0, +007h
    invoke-static v8, v9, v10, Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer;->registerReceiver(Landroid/content/BroadcastReceiver; Landroid/content/IntentFilter; I)Landroid/content/Intent;
    move-result-object v7
    return-object v7
    throw v7
    :try_start_0x9
.end method

.method public static INVOKEVIRTUAL_com_bytedance_trae_network_util_ScreenStateManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(android.app.Application  android.content.BroadcastReceiver)void
    .registers 3
    # ins_size=2
    const/4 v0, 0
    invoke-static v2, v0, Lcom/bytedance/sysoptimizer/ReceiverRegisterLancet;->loge(Landroid/content/BroadcastReceiver; Z)V
    invoke-virtual v1, v2, Landroid/app/Application;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    return-void 
.end method

.method public static final synthetic access$getListeners$p()java.util.concurrent.CopyOnWriteArraySet
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/util/ScreenStateManager;->listeners Ljava/util/concurrent/CopyOnWriteArraySet;
    return-object v0
.end method

.method private final ensureReceiverRegistered()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/util/ScreenStateManager;->receiver Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver;
    if-nez v0, +03fh
    new-instance v0, Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver;
    invoke-direct v0, Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/util/ScreenStateManager;->receiver Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver;
    new-instance v0, Landroid/content/IntentFilter;
    invoke-direct v0, Landroid/content/IntentFilter;-><init>()V
    const-string v1, "android.intent.action.SCREEN_OFF"
    invoke-virtual v0, v1, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V
    const-string v1, "android.intent.action.SCREEN_ON"
    invoke-virtual v0, v1, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V
    const-string v1, "android.intent.action.USER_PRESENT"
    invoke-virtual v0, v1, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V
    sget v1, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v2, 33
    if-lt v1, v2, +011h
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/network/util/ScreenStateManager;->receiver Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver;
    check-cast v2, Landroid/content/BroadcastReceiver;
    const/4 v3, 4
    invoke-static v1, v2, v0, v3, Lcom/bytedance/trae/network/util/ScreenStateManager;->INVOKEVIRTUAL_com_bytedance_trae_network_util_ScreenStateManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Landroid/app/Application; Landroid/content/BroadcastReceiver; Landroid/content/IntentFilter; I)Landroid/content/Intent;
    goto +eh
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/network/util/ScreenStateManager;->receiver Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver;
    check-cast v2, Landroid/content/BroadcastReceiver;
    invoke-static v1, v2, v0, Lcom/bytedance/trae/network/util/ScreenStateManager;->INVOKEVIRTUAL_com_bytedance_trae_network_util_ScreenStateManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Landroid/app/Application; Landroid/content/BroadcastReceiver; Landroid/content/IntentFilter;)Landroid/content/Intent;
    return-void 
.end method

.method private final unregisterReceiver()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/util/ScreenStateManager;->receiver Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver;
    if-eqz v0, +010h
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    check-cast v0, Landroid/content/BroadcastReceiver;
    invoke-static v1, v0, Lcom/bytedance/trae/network/util/ScreenStateManager;->INVOKEVIRTUAL_com_bytedance_trae_network_util_ScreenStateManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Landroid/app/Application; Landroid/content/BroadcastReceiver;)V
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/network/util/ScreenStateManager;->receiver Lcom/bytedance/trae/network/util/ScreenStateManager$ScreenBroadcastReceiver;
    return-void 
.end method

.method public final register(com.bytedance.trae.network.util.ScreenStateManager$ScreenStateListener)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, screenStateListener
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/util/ScreenStateManager;->listeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, Ljava/util/concurrent/CopyOnWriteArraySet;->isEmpty()Z
    move-result v1
    if-eqz v1, +005h
    invoke-direct v2, Lcom/bytedance/trae/network/util/ScreenStateManager;->ensureReceiverRegistered()V
    invoke-virtual v0, v3, Ljava/util/concurrent/CopyOnWriteArraySet;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final unregister(com.bytedance.trae.network.util.ScreenStateManager$ScreenStateListener)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, screenStateListener
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/util/ScreenStateManager;->listeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->remove(Ljava/lang/Object;)Z
    invoke-virtual v0, Ljava/util/concurrent/CopyOnWriteArraySet;->isEmpty()Z
    move-result v2
    if-eqz v2, +005h
    invoke-direct v1, Lcom/bytedance/trae/network/util/ScreenStateManager;->unregisterReceiver()V
    return-void 
.end method
