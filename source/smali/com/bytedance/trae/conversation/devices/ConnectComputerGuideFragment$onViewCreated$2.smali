# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final synthetic Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$onViewCreated$2;
.super Lkotlin/jvm/internal/FunctionReferenceImpl;
.source "ConnectComputerGuideFragment.kt"

.implements Lkotlin/jvm/functions/Function0;

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$onViewCreated$2;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$onViewCreated$2;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$onViewCreated$2;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$onViewCreated$2;->INSTANCE Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$onViewCreated$2;
    return-void 
.end method

.method constructor <init>()void
    .registers 7
    # ins_size=1
    const/4 v1, 0
    const-class v2, Landroid/os/SystemClock;
    const-string v3, "elapsedRealtime"
    const-string v4, "elapsedRealtime()J"
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lkotlin/jvm/internal/FunctionReferenceImpl;-><init>(I Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; I)V
    return-void 
.end method

.method public final invoke()java.lang.Long
    .registers 3
    # ins_size=1
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    return-object v0
.end method

.method public bridge synthetic invoke()java.lang.Object
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$onViewCreated$2;->invoke()Ljava/lang/Long;
    move-result-object v0
    return-object v0
.end method
