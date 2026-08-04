# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/AccountUtils$preLoadAccountPhoneOneKeyInfo$1;
.super Ljava/lang/Object;
.source "AccountUtils.kt"

.implements Lcom/bytedance/trae/login/IPhoneOneKeyCallback;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onGetPhoneOneKeyInfoFailure(int  java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=4
    return-void 
.end method

.method public onGetPhoneOneKeyInfoSuccess(com.bytedance.trae.login.PhoneOneKeyInfo)void
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/login/AccountUtils;->INSTANCE Lcom/bytedance/trae/login/AccountUtils;
    invoke-static v2, Lcom/bytedance/trae/login/AccountUtils;->access$setAccountPhoneOneKeyInfo$p(Lcom/bytedance/trae/login/PhoneOneKeyInfo;)V
    return-void 
.end method
