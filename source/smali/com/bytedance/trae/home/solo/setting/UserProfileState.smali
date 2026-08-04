# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/UserProfileState;
.super Ljava/lang/Object;
.source "SettingsViewModel.kt"

.field public static final $stable:I
.field private final avatarUrl:Ljava/lang/String;
.field private final email:Ljava/lang/String;
.field private final phoneNumber:Ljava/lang/String;
.field private final productType:I
.field private final saasPrivacyMode:Ljava/lang/Boolean;
.field private final screenName:Ljava/lang/String;
.field private final userId:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 11
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 127
    const/4 v9, 0
    move-object v0, v10
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/home/solo/setting/UserProfileState;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Boolean)void
    .registers 9
    # ins_size=8
    const-string/jumbo v0, screenName
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "avatarUrl"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "email"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "phoneNumber"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, userId
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->screenName Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->avatarUrl Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->email Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->phoneNumber Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->userId Ljava/lang/String;
    iput v7, v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->productType I
    iput-object v8, v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->saasPrivacyMode Ljava/lang/Boolean;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 15
    # ins_size=10
    and-int/lit8 v14, v13, 1
    const-string v0, ""
    if-eqz v14, +004h
    move-object v14, v0
    goto +2h
    move-object v14, v6
    and-int/lit8 v6, v13, 2
    if-eqz v6, +004h
    move-object v1, v0
    goto +2h
    move-object v1, v7
    and-int/lit8 v6, v13, 4
    if-eqz v6, +004h
    move-object v2, v0
    goto +2h
    move-object v2, v8
    and-int/lit8 v6, v13, 8
    if-eqz v6, +004h
    move-object v3, v0
    goto +2h
    move-object v3, v9
    and-int/lit8 v6, v13, 16
    if-eqz v6, +003h
    goto +2h
    move-object v0, v10
    and-int/lit8 v6, v13, 32
    if-eqz v6, +003h
    const/4 v11, 0
    move v4, v11
    and-int/lit8 v6, v13, 64
    if-eqz v6, +003h
    const/4 v12, 0
    move-object v13, v12
    move-object v6, v5
    move-object v7, v14
    move-object v8, v1
    move-object v9, v2
    move-object v10, v3
    move-object v11, v0
    move v12, v4
    invoke-direct/range v6 ... v13, Lcom/bytedance/trae/home/solo/setting/UserProfileState;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Boolean;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.UserProfileState  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Boolean  int  java.lang.Object)com.bytedance.trae.home.solo.setting.UserProfileState
    .registers 15
    # ins_size=10
    and-int/lit8 v14, v13, 1
    if-eqz v14, +004h
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->screenName Ljava/lang/String;
    and-int/lit8 v14, v13, 2
    if-eqz v14, +004h
    iget-object v7, v5, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->avatarUrl Ljava/lang/String;
    move-object v14, v7
    and-int/lit8 v7, v13, 4
    if-eqz v7, +004h
    iget-object v8, v5, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->email Ljava/lang/String;
    move-object v0, v8
    and-int/lit8 v7, v13, 8
    if-eqz v7, +004h
    iget-object v9, v5, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->phoneNumber Ljava/lang/String;
    move-object v1, v9
    and-int/lit8 v7, v13, 16
    if-eqz v7, +004h
    iget-object v10, v5, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->userId Ljava/lang/String;
    move-object v2, v10
    and-int/lit8 v7, v13, 32
    if-eqz v7, +004h
    iget v11, v5, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->productType I
    move v3, v11
    and-int/lit8 v7, v13, 64
    if-eqz v7, +004h
    iget-object v12, v5, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->saasPrivacyMode Ljava/lang/Boolean;
    move-object v4, v12
    move-object v7, v5
    move-object v8, v6
    move-object v9, v14
    move-object v10, v0
    move-object v11, v1
    move-object v12, v2
    move v13, v3
    move-object v14, v4
    invoke-virtual/range v7 ... v14, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Boolean;)Lcom/bytedance/trae/home/solo/setting/UserProfileState;
    move-result-object v5
    return-object v5
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->screenName Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->avatarUrl Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->email Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->phoneNumber Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->userId Ljava/lang/String;
    return-object v0
.end method

.method public final component6()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->productType I
    return v0
.end method

.method public final component7()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->saasPrivacyMode Ljava/lang/Boolean;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Boolean)com.bytedance.trae.home.solo.setting.UserProfileState
    .registers 17
    # ins_size=8
    const-string/jumbo v0, screenName
    move-object v2, v10
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "avatarUrl"
    move-object v3, v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "email"
    move-object v4, v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "phoneNumber"
    move-object v5, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, userId
    move-object v6, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/UserProfileState;
    move-object v1, v0
    move v7, v15
    move-object/from16 v8, v16
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/home/solo/setting/UserProfileState;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Boolean;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/UserProfileState;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/UserProfileState;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->screenName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->screenName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->avatarUrl Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->avatarUrl Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->email Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->email Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->phoneNumber Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->phoneNumber Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->userId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->userId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->productType I
    iget v3, v5, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->productType I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->saasPrivacyMode Ljava/lang/Boolean;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->saasPrivacyMode Ljava/lang/Boolean;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAvatarUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->avatarUrl Ljava/lang/String;
    return-object v0
.end method

.method public final getEmail()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->email Ljava/lang/String;
    return-object v0
.end method

.method public final getPhoneNumber()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->phoneNumber Ljava/lang/String;
    return-object v0
.end method

.method public final getProductType()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->productType I
    return v0
.end method

.method public final getSaasPrivacyMode()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->saasPrivacyMode Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getScreenName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->screenName Ljava/lang/String;
    return-object v0
.end method

.method public final getUserId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->userId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->screenName Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->avatarUrl Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->email Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->phoneNumber Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->userId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->productType I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->saasPrivacyMode Ljava/lang/Boolean;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "UserProfileState(screenName="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->screenName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", avatarUrl="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->avatarUrl Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", email="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->email Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", phoneNumber="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->phoneNumber Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", userId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->userId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", productType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->productType I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", saasPrivacyMode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->saasPrivacyMode Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
