# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/CliListRepositoryKt;
.super Ljava/lang/Object;
.source "CliListRepository.kt"


.method public static final mapDiscoverableDevices(java.util.List)java.util.List
    .registers 7
    # ins_size=1
    const-string v0, "clis"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/util/HashSet;
    invoke-direct v0, Ljava/util/HashSet;-><init>()V
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/List;
    check-cast v6, Ljava/lang/Iterable;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +041h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/Cli;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/Cli;->getId()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, -010h
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    const/4 v5, 1
    xor-int/2addr v4, v5
    if-eqz v4, +003h
    goto +2h
    const/4 v3, 0
    if-nez v3, +003h
    goto -21h
    invoke-virtual v0, v3, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -026h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/Cli;->getRegisteredAt()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +00bh
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +003h
    goto +3h
    const/4 v3, 0
    goto +2h
    move v3, v5
    xor-int/2addr v3, v5
    invoke-static v2, v3, Lcom/bytedance/trae/conversation/devices/MobileDeviceKt;->toMobileDeviceOrNull(Lcom/bytedance/trae/im/service/Cli; Z)Lcom/bytedance/trae/conversation/devices/MobileDevice;
    move-result-object v2
    if-eqz v2, -03fh
    invoke-interface v1, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -44h
    return-object v1
.end method
