# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/tracker/LoginTracker;
.super Ljava/lang/Object;
.source "LoginTracker.kt"

.field private static final ACTION_BIND:Ljava/lang/String;
.field private static final ACTION_SEND_CODE:Ljava/lang/String;
.field private static final CURRENT_PAGE_DOUYIN_BIND_PHONE:Ljava/lang/String;
.field private static final EVENT_ACCOUNT_BINDING_CLICK:Ljava/lang/String;
.field private static final EVENT_ACCOUNT_BINDING_PAGE_VIEW:Ljava/lang/String;
.field private static final EVENT_ACCOUNT_BINDING_RESULT:Ljava/lang/String;
.field private static final EVENT_LOGIN_CLICK:Ljava/lang/String;
.field private static final EVENT_LOGIN_RESULT:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/login/tracker/LoginTracker;
.field private static final RESULT_FAIL:Ljava/lang/String;
.field private static final RESULT_SUCCESS:Ljava/lang/String;
.field private static final SOURCE_DOUYIN_LOGIN:Ljava/lang/String;
.field private static final TYPE_PHONE:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/tracker/LoginTracker;
    invoke-direct v0, Lcom/bytedance/trae/login/tracker/LoginTracker;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/tracker/LoginTracker;->INSTANCE Lcom/bytedance/trae/login/tracker/LoginTracker;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic trackDouyinBindPhoneResult$default(com.bytedance.trae.login.tracker.LoginTracker  boolean  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 4
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-virtual v1, v2, v3, v4, v5, Lcom/bytedance/trae/login/tracker/LoginTracker;->trackDouyinBindPhoneResult(Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic trackLoginResult$default(com.bytedance.trae.login.tracker.LoginTracker  boolean  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/login/tracker/LoginTracker;->trackLoginResult(Z Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final trackDouyinBindPhonePageView()void
    .registers 4
    # ins_size=1
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "current_page"
    const-string v2, "douyin_bind_phone"
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, source
    const-string v2, "douyin_login"
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, type
    const-string/jumbo v2, phone
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "action"
    const-string v2, "bind"
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v2, "icube_account_binding_page_view"
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackDouyinBindPhoneResult(boolean  java.lang.String  java.lang.String  java.lang.String)void
    .registers 9
    # ins_size=5
    const-string/jumbo v0, stage
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    const-string v2, "current_page"
    const-string v3, "douyin_bind_phone"
    invoke-virtual v1, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v2, source
    const-string v3, "douyin_login"
    invoke-virtual v1, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v2, type
    const-string/jumbo v3, phone
    invoke-virtual v1, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v2, "action"
    const-string v3, "bind"
    invoke-virtual v1, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v5, +006h
    const-string/jumbo v5, success
    goto +3h
    const-string v5, "fail"
    const-string/jumbo v2, result
    invoke-virtual v1, v2, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v1, v0, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    move-object v5, v7
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v6, 0
    const/4 v0, 1
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    goto +3h
    move v5, v6
    goto +2h
    move v5, v0
    if-nez v5, +007h
    const-string v5, "error_code"
    invoke-virtual v1, v5, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    move-object v5, v8
    check-cast v5, Ljava/lang/CharSequence;
    if-eqz v5, +008h
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    move v6, v0
    if-nez v6, +007h
    const-string v5, "fail_reason"
    invoke-virtual v1, v5, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v5, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v6, "icube_account_binding_result"
    invoke-virtual v5, v6, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackDouyinBindPhoneSendCodeClick()void
    .registers 4
    # ins_size=1
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "current_page"
    const-string v2, "douyin_bind_phone"
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, source
    const-string v2, "douyin_login"
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, type
    const-string/jumbo v2, phone
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "action"
    const-string/jumbo v2, send_code
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v2, "icube_account_binding_click"
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackLoginClick(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, type
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v1, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v0, "icube_login_click"
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final trackLoginResult(boolean  java.lang.String  java.lang.String)void
    .registers 7
    # ins_size=4
    const-string/jumbo v0, type
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    const-string v2, "is_success"
    invoke-virtual v1, v2, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-virtual v1, v0, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-nez v4, +018h
    move-object v4, v6
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +3h
    const/4 v4, 0
    goto +2h
    const/4 v4, 1
    if-nez v4, +007h
    const-string v4, "fail_reason"
    invoke-virtual v1, v4, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v4, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v5, "icube_login_result"
    invoke-virtual v4, v5, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method
