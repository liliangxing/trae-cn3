# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver;
.super Landroid/content/BroadcastReceiver;
.source "KillMySelfBroadcastReceiver.kt"

.field public static final $stable:I
.field private static final ACTION_SUFFIX:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver$Companion;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver;->Companion Lcom/bytedance/trae/home/privacy/KillMySelfBroadcastReceiver$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroid/content/BroadcastReceiver;-><init>()V
    return-void 
.end method

.method public onReceive(android.content.Context  android.content.Intent)void
    .registers 3
    # ins_size=3
    const-string v1, "PrivacyManager"
    const-string v2, "KillMySelfBroadcastReceiver onReceive, kill main process"
    invoke-static v1, v2, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    invoke-static Landroid/os/Process;->myPid()I
    move-result v1
    invoke-static v1, Landroid/os/Process;->killProcess(I)V
    return-void 
.end method
