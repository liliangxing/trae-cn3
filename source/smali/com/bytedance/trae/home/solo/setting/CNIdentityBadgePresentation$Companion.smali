# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation$Companion;
.super Ljava/lang/Object;
.source "CNIdentityBadgePresentation.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation$Companion;-><init>()V
    return-void 
.end method

.method public final canRenderForUser(java.lang.String  java.lang.String  boolean)boolean
    .registers 6
    # ins_size=4
    const-string/jumbo v0, requestUserId
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "currentUserId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    if-eqz v5, +018h
    move-object v5, v3
    check-cast v5, Ljava/lang/CharSequence;
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    const/4 v1, 1
    if-lez v5, +004h
    move v5, v1
    goto +2h
    move v5, v0
    if-eqz v5, +009h
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    move v0, v1
    return v0
.end method

.method public final from(com.bytedance.trae.home.solo.setting.CNUserPayStatusData)com.bytedance.trae.home.solo.setting.CNIdentityBadgePresentation
    .registers 4
    # ins_size=2
    if-eqz v3, +049h
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;->getUserPayIdentityStr()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +043h
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +037h
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +025h
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;->getUserPayIdentity()Ljava/lang/Integer;
    move-result-object v3
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/CNUserPayIdentity;->FREE Lcom/bytedance/trae/home/solo/setting/CNUserPayIdentity;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/CNUserPayIdentity;->getValue()I
    move-result v1
    if-nez v3, +003h
    goto +fh
    invoke-virtual v3, Ljava/lang/Integer;->intValue()I
    move-result v3
    if-ne v3, v1, +00ah
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation$Free;
    invoke-direct v3, v0, Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation$Free;-><init>(Ljava/lang/String;)V
    check-cast v3, Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation;
    goto +8h
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation$Tier;
    invoke-direct v3, v0, Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation$Tier;-><init>(Ljava/lang/String;)V
    check-cast v3, Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation;
    return-object v3
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation$Hidden;->INSTANCE Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation$Hidden;
    check-cast v3, Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation;
    return-object v3
.end method
