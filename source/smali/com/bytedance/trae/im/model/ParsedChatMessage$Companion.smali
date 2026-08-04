# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/model/ParsedChatMessage$Companion;
.super Ljava/lang/Object;
.source "ParsedChatMessage.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/im/model/ParsedChatMessage$Companion;-><init>()V
    return-void 
.end method

.method public final normalizeToMillis(long)long
    .registers 7
    # ins_size=3
    const-wide/16 v0, 1
    cmp-long v0, v0, v5
    const/4 v1, 0
    if-gtz v0, +00ch
    const-wide v2, 10000000000
    cmp-long v0, v5, v2
    if-gez v0, +003h
    const/4 v1, 1
    if-eqz v1, +006h
    const/16 v0, 1000
    int-to-long v0, v0
    mul-long/2addr v5, v0
    return-wide v5
.end method
