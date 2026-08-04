# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/host/KmpHostActions;
.super Ljava/lang/Object;
.source "KmpHostActions.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/kmp/host/KmpHostActions;
.field private static handler:Lcom/bytedance/trae/kmp/host/KmpHostActionHandler;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/host/KmpHostActions;
    invoke-direct v0, Lcom/bytedance/trae/kmp/host/KmpHostActions;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/host/KmpHostActions;->INSTANCE Lcom/bytedance/trae/kmp/host/KmpHostActions;
    sget-object v0, Lcom/bytedance/trae/kmp/host/NoopKmpHostActionHandler;->INSTANCE Lcom/bytedance/trae/kmp/host/NoopKmpHostActionHandler;
    check-cast v0, Lcom/bytedance/trae/kmp/host/KmpHostActionHandler;
    sput-object v0, Lcom/bytedance/trae/kmp/host/KmpHostActions;->handler Lcom/bytedance/trae/kmp/host/KmpHostActionHandler;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/kmp/host/KmpHostActions;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final configure(com.bytedance.trae.kmp.host.KmpHostActionHandler)void
    .registers 3
    # ins_size=2
    const-string v0, "handler"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v2, Lcom/bytedance/trae/kmp/host/KmpHostActions;->handler Lcom/bytedance/trae/kmp/host/KmpHostActionHandler;
    return-void 
.end method

.method public final copyToClipboard(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, text
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/kmp/host/KmpHostActions;->handler Lcom/bytedance/trae/kmp/host/KmpHostActionHandler;
    invoke-interface v0, v2, Lcom/bytedance/trae/kmp/host/KmpHostActionHandler;->copyToClipboard(Ljava/lang/String;)V
    return-void 
.end method

.method public final showToast(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "message"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/kmp/host/KmpHostActions;->handler Lcom/bytedance/trae/kmp/host/KmpHostActionHandler;
    invoke-interface v0, v2, Lcom/bytedance/trae/kmp/host/KmpHostActionHandler;->showToast(Ljava/lang/String;)V
    return-void 
.end method
