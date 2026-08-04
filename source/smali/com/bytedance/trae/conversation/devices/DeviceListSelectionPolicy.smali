# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DeviceListSelectionPolicy;
.super Ljava/lang/Object;
.source "DeviceListSelectionPolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/devices/DeviceListSelectionPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceListSelectionPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/DeviceListSelectionPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DeviceListSelectionPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/DeviceListSelectionPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final applySelection(java.util.List  java.lang.String  java.lang.String)com.bytedance.trae.conversation.devices.DeviceListSelectionResult
    .registers 21
    # ins_size=4
    move-object/from16 v0, v18
    move-object/from16 v1, v19
    move-object/from16 v2, v20
    const-string v3, "devices"
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 1
    if-eqz v1, +041h
    move-object v6, v1
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    xor-int/2addr v6, v5
    if-eqz v6, +033h
    move-object v6, v0
    check-cast v6, Ljava/lang/Iterable;
    instance-of v7, v6, Ljava/util/Collection;
    if-eqz v7, +00dh
    move-object v7, v6
    check-cast v7, Ljava/util/Collection;
    invoke-interface v7, Ljava/util/Collection;->isEmpty()Z
    move-result v7
    if-eqz v7, +004h
    move v6, v4
    goto +1ch
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, -00ah
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, -014h
    move v6, v5
    if-eqz v6, +004h
    move v6, v5
    goto +2h
    move v6, v4
    if-eqz v6, +003h
    goto +2h
    move-object v1, v3
    if-nez v1, +05eh
    if-eqz v2, +04ah
    move-object v6, v2
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    xor-int/2addr v6, v5
    if-eqz v6, +03dh
    move-object v6, v0
    check-cast v6, Ljava/lang/Iterable;
    instance-of v7, v6, Ljava/util/Collection;
    if-eqz v7, +00dh
    move-object v7, v6
    check-cast v7, Ljava/util/Collection;
    invoke-interface v7, Ljava/util/Collection;->isEmpty()Z
    move-result v7
    if-eqz v7, +004h
    move v6, v4
    goto +27h
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, -00ah
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +00ah
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isOnline()Z
    move-result v7
    if-eqz v7, +004h
    move v7, v5
    goto +2h
    move v7, v4
    if-eqz v7, -01fh
    move v6, v5
    if-eqz v6, +003h
    move v4, v5
    if-eqz v4, +003h
    goto +2h
    move-object v2, v3
    if-nez v2, +00fh
    invoke-static/range v18, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    if-eqz v2, +00ah
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v3
    goto +4h
    move-object v3, v2
    goto +2h
    move-object v3, v1
    check-cast v0, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    const/16 v4, 10
    invoke-static v0, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v4
    invoke-direct v2, v4, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +025h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v11
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 479
    const/16 v16, 0
    invoke-static/range v5 ... v16, Lcom/bytedance/trae/conversation/devices/DeviceItem;->copy$default(Lcom/bytedance/trae/conversation/devices/DeviceItem; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Z Z Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DeviceItem;
    move-result-object v4
    invoke-interface v2, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -28h
    check-cast v2, Ljava/util/List;
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceListSelectionResult;
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/conversation/devices/DeviceListSelectionResult;-><init>(Ljava/util/List; Ljava/lang/String;)V
    return-object v0
.end method
