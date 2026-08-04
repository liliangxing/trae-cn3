# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/zlink/TimonClipboardImpl;
.super Ljava/lang/Object;
.source "TimonClipboardImpl.kt"

.implements Lcom/bytedance/ug/sdk/deeplink/interfaces/IClipboard;

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/zlink/TimonClipboardImpl$Companion;
.field private static final TAG:Ljava/lang/String;
.field private final cert$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$oVoyxq0ZB-wf1F2KkOXyjgCeWC0()com.bytedance.bpea.basics.Cert
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/home/zlink/TimonClipboardImpl;->cert_delegate$lambda$0()Lcom/bytedance/bpea/basics/Cert;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/zlink/TimonClipboardImpl$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/zlink/TimonClipboardImpl$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/zlink/TimonClipboardImpl;->Companion Lcom/bytedance/trae/home/zlink/TimonClipboardImpl$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/zlink/TimonClipboardImpl;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    new-instance v0, Lcom/bytedance/trae/home/zlink/TimonClipboardImpl$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/home/zlink/TimonClipboardImpl$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/home/zlink/TimonClipboardImpl;->cert$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private static final cert_delegate$lambda$0()com.bytedance.bpea.basics.Cert
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/timon/clipboard/suite/cert/EmptyCert;->INSTANCE Lcom/bytedance/timon/clipboard/suite/cert/EmptyCert;
    invoke-virtual v0, Lcom/bytedance/timon/clipboard/suite/cert/EmptyCert;->genEmptyCert()Lcom/bytedance/bpea/basics/Cert;
    move-result-object v0
    return-object v0
.end method

.method private final getCert()com.bytedance.bpea.basics.Cert
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/zlink/TimonClipboardImpl;->cert$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/bpea/basics/Cert;
    return-object v0
.end method

.method public appendTextToClipboard(android.content.Context  java.lang.CharSequence)void
    .registers 5
    # ins_size=3
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v4, +003h
    return-void 
    sget-object v3, Lcom/bytedance/timon/clipboard/suite/TimonClipboardSuite;->INSTANCE Lcom/bytedance/timon/clipboard/suite/TimonClipboardSuite;
    invoke-direct v2, Lcom/bytedance/trae/home/zlink/TimonClipboardImpl;->getCert()Lcom/bytedance/bpea/basics/Cert;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual v3, v0, v4, v1, Lcom/bytedance/timon/clipboard/suite/TimonClipboardSuite;->setText(Lcom/bytedance/bpea/basics/Cert; Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1;)V
    goto +bh
    move-exception v3
    const-string v4, "appendTextToClipboard failed"
    check-cast v3, Ljava/lang/Throwable;
    const-string v0, "TimonClipboardImpl"
    invoke-static v0, v4, v3, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-void 
    :try_start_0x8
.end method

.method public clearClipBoard(android.content.Context)void
    .registers 4
    # ins_size=2
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/timon/clipboard/suite/TimonClipboardSuite;->INSTANCE Lcom/bytedance/timon/clipboard/suite/TimonClipboardSuite;
    invoke-direct v2, Lcom/bytedance/trae/home/zlink/TimonClipboardImpl;->getCert()Lcom/bytedance/bpea/basics/Cert;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual v3, v0, v1, Lcom/bytedance/timon/clipboard/suite/TimonClipboardSuite;->clearPrimaryClip(Lcom/bytedance/bpea/basics/Cert; Lkotlin/jvm/functions/Function1;)V
    goto +bh
    move-exception v3
    const-string v0, "clearClipBoard failed"
    check-cast v3, Ljava/lang/Throwable;
    const-string v1, "TimonClipboardImpl"
    invoke-static v1, v0, v3, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-void 
    :try_start_0x5
.end method

.method public clearClipBoard(android.content.Context  java.lang.String  android.content.ClipData)void
    .registers 4
    # ins_size=4
    const-string v2, "context"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/timon/clipboard/suite/TimonClipboardSuite;->INSTANCE Lcom/bytedance/timon/clipboard/suite/TimonClipboardSuite;
    invoke-direct v0, Lcom/bytedance/trae/home/zlink/TimonClipboardImpl;->getCert()Lcom/bytedance/bpea/basics/Cert;
    move-result-object v2
    const/4 v3, 0
    invoke-virtual v1, v2, v3, Lcom/bytedance/timon/clipboard/suite/TimonClipboardSuite;->clearPrimaryClip(Lcom/bytedance/bpea/basics/Cert; Lkotlin/jvm/functions/Function1;)V
    goto +bh
    move-exception v1
    const-string v2, "clearClipBoard failed"
    check-cast v1, Ljava/lang/Throwable;
    const-string v3, "TimonClipboardImpl"
    invoke-static v3, v2, v1, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-void 
    :try_start_0x5
.end method

.method public getClipBoardContent(android.content.Context)android.content.ClipData
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    return-object v2
.end method

.method public writeClipBoard(android.content.Context  java.lang.CharSequence  java.lang.CharSequence)void
    .registers 5
    # ins_size=4
    const-string v3, "context"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v4, +003h
    return-void 
    sget-object v2, Lcom/bytedance/timon/clipboard/suite/TimonClipboardSuite;->INSTANCE Lcom/bytedance/timon/clipboard/suite/TimonClipboardSuite;
    invoke-direct v1, Lcom/bytedance/trae/home/zlink/TimonClipboardImpl;->getCert()Lcom/bytedance/bpea/basics/Cert;
    move-result-object v3
    const/4 v0, 0
    invoke-virtual v2, v3, v4, v0, Lcom/bytedance/timon/clipboard/suite/TimonClipboardSuite;->setText(Lcom/bytedance/bpea/basics/Cert; Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1;)V
    goto +ch
    move-exception v2
    const-string/jumbo v3, writeClipBoard failed
    check-cast v2, Ljava/lang/Throwable;
    const-string v4, "TimonClipboardImpl"
    invoke-static v4, v3, v2, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-void 
    :try_start_0x8
.end method
