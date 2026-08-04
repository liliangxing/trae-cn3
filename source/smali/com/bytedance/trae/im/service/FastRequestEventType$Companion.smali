# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/FastRequestEventType$Companion;
.super Ljava/lang/Object;
.source "IMEvent.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/im/service/FastRequestEventType$Companion;-><init>()V
    return-void 
.end method

.method public final fromValue(int)com.bytedance.trae.im.service.FastRequestEventType
    .registers 5
    # ins_size=2
    invoke-static Lcom/bytedance/trae/im/service/FastRequestEventType;->getEntries()Lkotlin/enums/EnumEntries;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +015h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/im/service/FastRequestEventType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/FastRequestEventType;->getValue()I
    move-result v2
    if-ne v2, v4, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, -016h
    goto +2h
    const/4 v1, 0
    check-cast v1, Lcom/bytedance/trae/im/service/FastRequestEventType;
    return-object v1
.end method
