# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public interface abstract Lcom/bytedance/trae/login/api/ILoginService;
.super Ljava/lang/Object;
.source "ILoginService.kt"


.method public abstract cleanupGoogleAuth()void
    # abstract or native
.end method

.method public abstract getAccountInfo()com.bytedance.trae.login.api.AccountInfo
    # abstract or native
.end method

.method public abstract getCloudideSession()java.lang.String
    # abstract or native
.end method

.method public abstract getGoogleSignInIntent(android.app.Activity)android.content.Intent
    # abstract or native
.end method

.method public abstract getXTToken()java.lang.String
    # abstract or native
.end method

.method public abstract handleGoogleAuthResult(int  int  android.content.Intent)void
    # abstract or native
.end method

.method public abstract isNewUser()boolean
    # abstract or native
.end method

.method public abstract isTraeLoggedIn()boolean
    # abstract or native
.end method

.method public abstract listLoginDevices(kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1)void
    # abstract or native
.end method

.method public abstract logout(boolean  com.bytedance.trae.login.api.IAccountCallback  java.lang.String)void
    # abstract or native
.end method

.method public abstract parseGoogleSignInResult(android.content.Intent)java.util.Map
    # abstract or native
.end method

.method public abstract refreshUserInfo(kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0)void
    # abstract or native
.end method

.method public abstract registerAccountStatusChangeListener(com.bytedance.trae.login.api.IAccountStatusListener  java.lang.Boolean)void
    # abstract or native
.end method

.method public abstract unregisterAccountStatusChangeListener(com.bytedance.trae.login.api.IAccountStatusListener)void
    # abstract or native
.end method

.method public abstract updateUserProfile(java.util.Map  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1)void
    # abstract or native
.end method

.method public abstract uploadAvatar(java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1)void
    # abstract or native
.end method
