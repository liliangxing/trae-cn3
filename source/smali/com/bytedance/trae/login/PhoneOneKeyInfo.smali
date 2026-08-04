# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/PhoneOneKeyInfo;
.super Ljava/lang/Object;
.source "IPhoneOneKeyCallback.kt"

.field private final carrier:Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
.field private final maskPhone:Ljava/lang/String;


.method public constructor <init>(java.lang.String  com.bytedance.trae.login.PhoneOneKeyPlatform)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->maskPhone Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->carrier Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.login.PhoneOneKeyInfo  java.lang.String  com.bytedance.trae.login.PhoneOneKeyPlatform  int  java.lang.Object)com.bytedance.trae.login.PhoneOneKeyInfo
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->maskPhone Ljava/lang/String;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->carrier Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->copy(Ljava/lang/String; Lcom/bytedance/trae/login/PhoneOneKeyPlatform;)Lcom/bytedance/trae/login/PhoneOneKeyInfo;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->maskPhone Ljava/lang/String;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.login.PhoneOneKeyPlatform
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->carrier Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    return-object v0
.end method

.method public final copy(java.lang.String  com.bytedance.trae.login.PhoneOneKeyPlatform)com.bytedance.trae.login.PhoneOneKeyInfo
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/login/PhoneOneKeyInfo;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/login/PhoneOneKeyInfo;-><init>(Ljava/lang/String; Lcom/bytedance/trae/login/PhoneOneKeyPlatform;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/login/PhoneOneKeyInfo;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/login/PhoneOneKeyInfo;
    iget-object v1, v4, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->maskPhone Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->maskPhone Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->carrier Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    iget-object v5, v5, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->carrier Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getCarrier()com.bytedance.trae.login.PhoneOneKeyPlatform
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->carrier Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    return-object v0
.end method

.method public final getMaskPhone()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->maskPhone Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->maskPhone Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->carrier Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "PhoneOneKeyInfo(maskPhone="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->maskPhone Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", carrier="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/PhoneOneKeyInfo;->carrier Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
