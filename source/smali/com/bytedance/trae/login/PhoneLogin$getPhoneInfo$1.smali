# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/PhoneLogin$getPhoneInfo$1;
.super Ljava/lang/Object;
.source "PhoneLogin.kt"

.implements Lcom/bytedance/sdk/account/platform/base/AuthorizeCallback;

.field final synthetic $callback:Lcom/bytedance/trae/login/IPhoneOneKeyCallback;
.field final synthetic $service:Lcom/bytedance/sdk/account/platform/api/IOnekeyLoginService;


.method constructor <init>(com.bytedance.sdk.account.platform.api.IOnekeyLoginService  com.bytedance.trae.login.IPhoneOneKeyCallback)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/login/PhoneLogin$getPhoneInfo$1;->$service Lcom/bytedance/sdk/account/platform/api/IOnekeyLoginService;
    iput-object v2, v0, Lcom/bytedance/trae/login/PhoneLogin$getPhoneInfo$1;->$callback Lcom/bytedance/trae/login/IPhoneOneKeyCallback;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onError(com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/login/PhoneLogin$getPhoneInfo$1;->$callback Lcom/bytedance/trae/login/IPhoneOneKeyCallback;
    if-eqz v4, +006h
    iget-object v1, v4, Lcom/bytedance/sdk/account/platform/base/AuthorizeErrorResponse;->platformErrorCode Ljava/lang/String;
    if-nez v1, +004h
    const-string v1, "-1"
    if-eqz v4, +006h
    iget-object v4, v4, Lcom/bytedance/sdk/account/platform/base/AuthorizeErrorResponse;->platformErrorMsg Ljava/lang/String;
    if-nez v4, +004h
    const-string v4, ""
    const/4 v2, -1
    invoke-interface v0, v2, v1, v4, Lcom/bytedance/trae/login/IPhoneOneKeyCallback;->onGetPhoneOneKeyInfoFailure(I Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onSuccess(android.os.Bundle)void
    .registers 5
    # ins_size=2
    if-eqz v4, +00ah
    const-string/jumbo v0, security_phone
    invoke-virtual v4, v0, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    goto +2h
    const/4 v4, 0
    iget-object v0, v3, Lcom/bytedance/trae/login/PhoneLogin$getPhoneInfo$1;->$service Lcom/bytedance/sdk/account/platform/api/IOnekeyLoginService;
    invoke-interface v0, Lcom/bytedance/sdk/account/platform/api/IOnekeyLoginService;->getCarrier()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +03ch
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v1
    const v2, -1429363305
    if-eq v1, v2, +026h
    const v2, -1068855134
    if-eq v1, v2, +015h
    const v2, -840542575
    if-eq v1, v2, +003h
    goto +27h
    const-string/jumbo v1, unicom
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +1dh
    sget-object v0, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;->UNICOM Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    goto +1ch
    const-string v1, "mobile"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +11h
    sget-object v0, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;->MOBILE Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    goto +10h
    const-string/jumbo v1, telecom
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +4h
    sget-object v0, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;->TELECOM Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    goto +3h
    sget-object v0, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;->UNKNOWN Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    iget-object v1, v3, Lcom/bytedance/trae/login/PhoneLogin$getPhoneInfo$1;->$callback Lcom/bytedance/trae/login/IPhoneOneKeyCallback;
    new-instance v2, Lcom/bytedance/trae/login/PhoneOneKeyInfo;
    invoke-direct v2, v4, v0, Lcom/bytedance/trae/login/PhoneOneKeyInfo;-><init>(Ljava/lang/String; Lcom/bytedance/trae/login/PhoneOneKeyPlatform;)V
    invoke-interface v1, v2, Lcom/bytedance/trae/login/IPhoneOneKeyCallback;->onGetPhoneOneKeyInfoSuccess(Lcom/bytedance/trae/login/PhoneOneKeyInfo;)V
    return-void 
.end method
