# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/IdeVersionGate;
.super Ljava/lang/Object;
.source "IdeVersionComparator.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/network/IdeVersionGate;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/IdeVersionGate;
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/IdeVersionGate;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/network/IdeVersionGate;->INSTANCE Lcom/bytedance/trae/conversation/network/IdeVersionGate;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final shouldBlockByMinimum(java.lang.String  java.lang.String)boolean
    .registers 6
    # ins_size=3
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +003h
    return v1
    sget-object v0, Lcom/bytedance/trae/conversation/network/IdeVersionComparator;->INSTANCE Lcom/bytedance/trae/conversation/network/IdeVersionComparator;
    invoke-virtual v0, v4, v5, Lcom/bytedance/trae/conversation/network/IdeVersionComparator;->isGreaterOrEqual(Ljava/lang/String; Ljava/lang/String;)Z
    move-result v4
    xor-int/2addr v4, v2
    return v4
.end method

.method public final shouldBlockCliModelList(com.bytedance.trae.im.service.CliType  java.lang.String  java.lang.String)boolean
    .registers 5
    # ins_size=4
    const-string v0, "cliType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v2, v0, +004h
    const/4 v2, 0
    return v2
    invoke-virtual v1, v3, v4, Lcom/bytedance/trae/conversation/network/IdeVersionGate;->shouldBlockByMinimum(Ljava/lang/String; Ljava/lang/String;)Z
    move-result v2
    return v2
.end method
