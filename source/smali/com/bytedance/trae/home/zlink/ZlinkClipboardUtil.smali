# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/zlink/ZlinkClipboardUtil;
.super Ljava/lang/Object;
.source "ZlinkClipboardUtil.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/zlink/ZlinkClipboardUtil;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/zlink/ZlinkClipboardUtil;
    invoke-direct v0, Lcom/bytedance/trae/home/zlink/ZlinkClipboardUtil;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/zlink/ZlinkClipboardUtil;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkClipboardUtil;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final clearClipboard(android.content.Context)void
    .registers 5
    # ins_size=2
    const-string v0, "ZlinkClipboardUtil"
    const-string v1, "context"
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/timon/clipboard/suite/cert/EmptyCert;->INSTANCE Lcom/bytedance/timon/clipboard/suite/cert/EmptyCert;
    invoke-virtual v4, Lcom/bytedance/timon/clipboard/suite/cert/EmptyCert;->genEmptyCert()Lcom/bytedance/bpea/basics/Cert;
    move-result-object v4
    sget-object v1, Lcom/bytedance/timon/clipboard/suite/TimonClipboardSuite;->INSTANCE Lcom/bytedance/timon/clipboard/suite/TimonClipboardSuite;
    const/4 v2, 0
    invoke-virtual v1, v4, v2, Lcom/bytedance/timon/clipboard/suite/TimonClipboardSuite;->clearPrimaryClip(Lcom/bytedance/bpea/basics/Cert; Lkotlin/jvm/functions/Function1;)V
    goto +9h
    move-exception v4
    const-string v1, "clearClipboard via Timon failed"
    check-cast v4, Ljava/lang/Throwable;
    invoke-static v0, v1, v4, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    const-string v4, "clearClipboard done"
    invoke-static v0, v4, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
    :try_start_0x7
.end method
