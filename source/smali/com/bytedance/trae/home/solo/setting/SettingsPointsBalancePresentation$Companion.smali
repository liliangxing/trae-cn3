# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation$Companion;
.super Ljava/lang/Object;
.source "SettingsPointsBalancePresentation.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation$Companion;-><init>()V
    return-void 
.end method

.method private final formatFiniteBalance(long)java.lang.String
    .registers 7
    # ins_size=3
    sget-object v0, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE Lkotlin/jvm/internal/StringCompanionObject;
    sget-object v0, Ljava/util/Locale;->US Ljava/util/Locale;
    const/4 v1, 1
    new-array v2, v1, [Ljava/lang/Object;
    const/4 v3, 0
    invoke-static v5, v6, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v5
    aput-object v5, v2, v3
    invoke-static v2, v1, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v5
    const-string v6, "%,d"
    invoke-static v0, v6, v5, Ljava/lang/String;->format(Ljava/util/Locale; Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    const-string v6, "format(...)"
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v5
.end method

.method public static synthetic from$default(com.bytedance.trae.home.solo.setting.SettingsPointsBalancePresentation$Companion  java.lang.String  java.lang.String  java.lang.Long  boolean  boolean  int  java.lang.Object)com.bytedance.trae.home.solo.setting.SettingsPointsBalancePresentation
    .registers 14
    # ins_size=8
    and-int/lit8 v12, v12, 8
    if-eqz v12, +003h
    const/4 v10, 0
    move v4, v10
    move-object v0, v6
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    move v5, v11
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation$Companion;->from(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Z Z)Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation;
    move-result-object v6
    return-object v6
.end method

.method public final from(java.lang.String  java.lang.String  java.lang.Long  boolean  boolean)com.bytedance.trae.home.solo.setting.SettingsPointsBalancePresentation
    .registers 9
    # ins_size=6
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v4, +00ch
    sget-object v2, Lcom/bytedance/trae/conversation/CreditsBalancePolicy;->INSTANCE Lcom/bytedance/trae/conversation/CreditsBalancePolicy;
    invoke-virtual v2, v4, v5, v8, Lcom/bytedance/trae/conversation/CreditsBalancePolicy;->belongsToCurrentUser(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v4
    if-ne v4, v0, +004h
    move v4, v0
    goto +2h
    move v4, v1
    if-eqz v4, +005h
    if-eqz v6, +003h
    goto +2h
    move v0, v1
    if-eqz v0, +018h
    new-instance v4, Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation$Visible;
    if-eqz v7, +006h
    const-string/jumbo v5, ∞
    goto +9h
    invoke-virtual v6, Ljava/lang/Long;->longValue()J
    move-result-wide v5
    invoke-direct v3, v5, v6, Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation$Companion;->formatFiniteBalance(J)Ljava/lang/String;
    move-result-object v5
    invoke-direct v4, v5, Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation$Visible;-><init>(Ljava/lang/String;)V
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation;
    goto +5h
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation$Hidden;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation$Hidden;
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation;
    return-object v4
.end method
