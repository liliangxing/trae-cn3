# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/UserPayIdentity$Companion;
.super Ljava/lang/Object;
.source "UserPayStatusApi.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity$Companion;-><init>()V
    return-void 
.end method

.method public final fromValue(int)com.bytedance.trae.home.solo.setting.UserPayIdentity
    .registers 5
    # ins_size=2
    invoke-static Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->getEntries()Lkotlin/enums/EnumEntries;
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
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->getValue()I
    move-result v2
    if-ne v2, v4, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, -016h
    goto +2h
    const/4 v1, 0
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    if-nez v1, +004h
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;->FREE Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;
    return-object v1
.end method
