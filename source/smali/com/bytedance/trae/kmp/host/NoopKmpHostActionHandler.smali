# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/host/NoopKmpHostActionHandler;
.super Ljava/lang/Object;
.source "KmpHostActions.kt"

.implements Lcom/bytedance/trae/kmp/host/KmpHostActionHandler;

.field public static final INSTANCE:Lcom/bytedance/trae/kmp/host/NoopKmpHostActionHandler;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/host/NoopKmpHostActionHandler;
    invoke-direct v0, Lcom/bytedance/trae/kmp/host/NoopKmpHostActionHandler;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/host/NoopKmpHostActionHandler;->INSTANCE Lcom/bytedance/trae/kmp/host/NoopKmpHostActionHandler;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public copyToClipboard(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, text
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public showToast(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "message"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method
