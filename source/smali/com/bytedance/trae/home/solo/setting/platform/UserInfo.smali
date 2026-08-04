# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;
.super Ljava/lang/Object;
.source "UserInfoProvider.kt"

.field public static final $stable:I
.field private final accountText:Ljava/lang/String;
.field private final avatarUrl:Ljava/lang/String;
.field private final displayName:Ljava/lang/String;
.field private final productType:I


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  int)void
    .registers 6
    # ins_size=5
    const-string v0, "displayName"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "accountText"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "avatarUrl"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->displayName Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->accountText Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->avatarUrl Ljava/lang/String;
    iput v5, v1, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->productType I
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 8
    if-eqz v5, +003h
    const/4 v4, 0
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.platform.UserInfo  java.lang.String  java.lang.String  java.lang.String  int  int  java.lang.Object)com.bytedance.trae.home.solo.setting.platform.UserInfo
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->displayName Ljava/lang/String;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->accountText Ljava/lang/String;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->avatarUrl Ljava/lang/String;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget v4, v0, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->productType I
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I)Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->displayName Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->accountText Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->avatarUrl Ljava/lang/String;
    return-object v0
.end method

.method public final component4()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->productType I
    return v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  int)com.bytedance.trae.home.solo.setting.platform.UserInfo
    .registers 6
    # ins_size=5
    const-string v0, "displayName"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "accountText"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "avatarUrl"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->displayName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->displayName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->accountText Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->accountText Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->avatarUrl Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->avatarUrl Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->productType I
    iget v5, v5, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->productType I
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getAccountText()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->accountText Ljava/lang/String;
    return-object v0
.end method

.method public final getAvatarUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->avatarUrl Ljava/lang/String;
    return-object v0
.end method

.method public final getDisplayName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->displayName Ljava/lang/String;
    return-object v0
.end method

.method public final getProductType()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->productType I
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->displayName Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->accountText Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->avatarUrl Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->productType I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "UserInfo(displayName="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->displayName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", accountText="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->accountText Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", avatarUrl="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->avatarUrl Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", productType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->productType I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
