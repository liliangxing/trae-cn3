# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$Companion;
.super Ljava/lang/Object;
.source "BrainstormViewModel.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$Companion;-><init>()V
    return-void 
.end method

.method public static final synthetic access$formatDuration(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$Companion  long)java.lang.String
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$Companion;->formatDuration(J)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final formatDuration(long)java.lang.String
    .registers 13
    # ins_size=3
    const/16 v0, 1000
    int-to-long v0, v0
    div-long/2addr v11, v0
    const/16 v0, 3600
    int-to-long v0, v0
    div-long v2, v11, v0
    rem-long v0, v11, v0
    const/16 v4, 60
    int-to-long v4, v4
    div-long/2addr v0, v4
    rem-long/2addr v11, v4
    const-wide/16 v4, 0
    cmp-long v4, v2, v4
    const-string v5, "format(...)"
    const/4 v6, 1
    const/4 v7, 0
    const/4 v8, 2
    if-lez v4, +027h
    sget-object v4, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE Lkotlin/jvm/internal/StringCompanionObject;
    const/4 v4, 3
    new-array v9, v4, [Ljava/lang/Object;
    invoke-static v2, v3, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v2
    aput-object v2, v9, v7
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    aput-object v0, v9, v6
    invoke-static v11, v12, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v11
    aput-object v11, v9, v8
    invoke-static v9, v4, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v11
    const-string v12, "%02d:%02d:%02d"
    invoke-static v12, v11, Ljava/lang/String;->format(Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    invoke-static v11, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +1eh
    sget-object v2, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE Lkotlin/jvm/internal/StringCompanionObject;
    new-array v2, v8, [Ljava/lang/Object;
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    aput-object v0, v2, v7
    invoke-static v11, v12, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v11
    aput-object v11, v2, v6
    invoke-static v2, v8, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v11
    const-string v12, "%02d:%02d"
    invoke-static v12, v11, Ljava/lang/String;->format(Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    invoke-static v11, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v11
.end method
