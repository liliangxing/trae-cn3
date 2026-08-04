# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1$1;
.super Ljava/lang/Object;
.source "BytecloudLoginActivity.kt"

.implements Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin$Callback;

.field final synthetic $passportStartTime:J


.method constructor <init>(long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1$1;->$passportStartTime J
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onError(int  java.lang.String)void
    .registers 21
    # ins_size=3
    move-object/from16 v0, v20
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "Passport 三方登录失败(降级): code="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move/from16 v3, v19
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", msg="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "BytecloudLoginActivity"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v5, "bytecloud_passport_fail"
    const-string v6, "bytecloud"
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    move-object/from16 v3, v18
    iget-wide v7, v3, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1$1;->$passportStartTime J
    sub-long/2addr v1, v7
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v7
    const-string/jumbo v8, passport_async_login
    const/4 v9, 0
    if-nez v0, +005h
    const-string/jumbo v0, unknown
    move-object v10, v0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 2000
    const/16 v17, 0
    invoke-static/range v4 ... v17, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method public onSuccess(long)void
    .registers 20
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "Passport 三方登录成功, userId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-wide/from16 v2, v18
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "BytecloudLoginActivity"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v4, "bytecloud_passport_done"
    const-string v5, "bytecloud"
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    move-object/from16 v2, v17
    iget-wide v6, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1$1;->$passportStartTime J
    sub-long/2addr v0, v6
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v6
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 2040
    const/16 v16, 0
    invoke-static/range v3 ... v16, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method
