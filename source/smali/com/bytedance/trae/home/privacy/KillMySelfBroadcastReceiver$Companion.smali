# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver$Companion;
.super Ljava/lang/Object;
.source "KillMySelfBroadcastReceiver.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver$Companion;-><init>()V
    return-void 
.end method

.method public static INVOKEVIRTUAL_com_bytedance_trae_home_privacy_KillMySelfBroadcastReceiver$Companion_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(android.content.Context  android.content.BroadcastReceiver  android.content.IntentFilter  java.lang.String  android.os.Handler)android.content.Intent
    .registers 6
    # ins_size=5
    invoke-static Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer;->fixedOpen()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer;->doHWReceiverFix()V
    invoke-virtual v1, v2, v3, v4, v5, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver; Landroid/content/IntentFilter; Ljava/lang/String; Landroid/os/Handler;)Landroid/content/Intent;
    move-result-object v1
    return-object v1
    move-exception v1
    invoke-static Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer;->fixedOpen()Z
    move-result v0
    if-eqz v0, +007h
    invoke-static v2, v3, v4, v5, Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer;->registerReceiver(Landroid/content/BroadcastReceiver; Landroid/content/IntentFilter; Ljava/lang/String; Landroid/os/Handler;)Landroid/content/Intent;
    move-result-object v1
    return-object v1
    throw v1
    :try_start_0x9
.end method

.method public static INVOKEVIRTUAL_com_bytedance_trae_home_privacy_KillMySelfBroadcastReceiver$Companion_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(android.content.Context  android.content.BroadcastReceiver  android.content.IntentFilter  java.lang.String  android.os.Handler  int)android.content.Intent
    .registers 7
    # ins_size=6
    invoke-static Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer;->fixedOpen()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer;->doHWReceiverFix()V
    invoke-virtual/range v1 ... v6, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver; Landroid/content/IntentFilter; Ljava/lang/String; Landroid/os/Handler; I)Landroid/content/Intent;
    move-result-object v1
    return-object v1
    move-exception v1
    invoke-static Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer;->fixedOpen()Z
    move-result v0
    if-eqz v0, +007h
    invoke-static v2, v3, v4, v5, v6, Lcom/bytedance/sysoptimizer/ReceiverRegisterCrashOptimizer;->registerReceiver(Landroid/content/BroadcastReceiver; Landroid/content/IntentFilter; Ljava/lang/String; Landroid/os/Handler; I)Landroid/content/Intent;
    move-result-object v1
    return-object v1
    throw v1
    :try_start_0x9
.end method

.method private final getAction(android.content.Context)java.lang.String
    .registers 3
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v0, ".action.KILL_MAIN_PROCESS"
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method private final getPermission(android.content.Context)java.lang.String
    .registers 3
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v0, ".permission.PRIVACY_BROADCAST"
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method public final registerReceiver(android.content.Context)void
    .registers 9
    # ins_size=2
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v3, Landroid/content/IntentFilter;
    invoke-direct v7, v8, Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver$Companion;->getAction(Landroid/content/Context;)Ljava/lang/String;
    move-result-object v0
    invoke-direct v3, v0, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver;
    invoke-direct v0, Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver;-><init>()V
    sget v1, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v2, 33
    if-lt v1, v2, +010h
    move-object v2, v0
    check-cast v2, Landroid/content/BroadcastReceiver;
    invoke-direct v7, v8, Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver$Companion;->getPermission(Landroid/content/Context;)Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    const/4 v6, 4
    move-object v1, v8
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver$Companion;->INVOKEVIRTUAL_com_bytedance_trae_home_privacy_KillMySelfBroadcastReceiver$Companion_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Landroid/content/Context; Landroid/content/BroadcastReceiver; Landroid/content/IntentFilter; Ljava/lang/String; Landroid/os/Handler; I)Landroid/content/Intent;
    goto +bh
    check-cast v0, Landroid/content/BroadcastReceiver;
    invoke-direct v7, v8, Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver$Companion;->getPermission(Landroid/content/Context;)Ljava/lang/String;
    move-result-object v1
    const/4 v2, 0
    invoke-static v8, v0, v3, v1, v2, Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver$Companion;->INVOKEVIRTUAL_com_bytedance_trae_home_privacy_KillMySelfBroadcastReceiver$Companion_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Landroid/content/Context; Landroid/content/BroadcastReceiver; Landroid/content/IntentFilter; Ljava/lang/String; Landroid/os/Handler;)Landroid/content/Intent;
    const-string v8, "PrivacyManager"
    const-string v0, "registerReceiver success"
    invoke-static v8, v0, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method

.method public final sendBroadcast(android.content.Context)void
    .registers 4
    # ins_size=2
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Landroid/content/Intent;
    invoke-direct v2, v3, Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver$Companion;->getAction(Landroid/content/Context;)Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v1, Landroid/content/Intent;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;
    invoke-direct v2, v3, Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver$Companion;->getPermission(Landroid/content/Context;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v0, v1, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent; Ljava/lang/String;)V
    const-string v3, "PrivacyManager"
    const-string/jumbo v0, sendBroadcast to kill main process
    invoke-static v3, v0, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method
