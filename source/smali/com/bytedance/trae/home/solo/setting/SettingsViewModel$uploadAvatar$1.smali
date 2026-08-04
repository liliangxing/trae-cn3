# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "SettingsViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $context:Landroid/app/Application;
.field final synthetic $loginService:Lcom/bytedance/trae/login/api/ILoginService;
.field final synthetic $uri:Landroid/net/Uri;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;


.method public static synthetic $r8$lambda$HSAPUyLKO2h0tQLBgwGRj_eCb-M(com.bytedance.trae.home.solo.setting.SettingsViewModel  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->invokeSuspend$lambda$2$lambda$0(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$O7a6eLQfCDciU7piY2KORCXh6GI(java.io.File  com.bytedance.trae.home.solo.setting.SettingsViewModel  java.lang.Long)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->invokeSuspend$lambda$3(Ljava/io/File; Lcom/bytedance/trae/home/solo/setting/SettingsViewModel; Ljava/lang/Long;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$WD4sObR7SSJTbw_iSEJK5XaO3D8(com.bytedance.trae.home.solo.setting.SettingsViewModel  int)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->invokeSuspend$lambda$2$lambda$1(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$weGU6rm1tgAbnb7wkkBN3_oVRtM(java.io.File  com.bytedance.trae.login.api.ILoginService  com.bytedance.trae.home.solo.setting.SettingsViewModel  java.lang.String)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->invokeSuspend$lambda$2(Ljava/io/File; Lcom/bytedance/trae/login/api/ILoginService; Lcom/bytedance/trae/home/solo/setting/SettingsViewModel; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.home.solo.setting.SettingsViewModel  com.bytedance.trae.login.api.ILoginService  android.app.Application  android.net.Uri  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->$loginService Lcom/bytedance/trae/login/api/ILoginService;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->$context Landroid/app/Application;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->$uri Landroid/net/Uri;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$2(java.io.File  com.bytedance.trae.login.api.ILoginService  com.bytedance.trae.home.solo.setting.SettingsViewModel  java.lang.String)kotlin.Unit
    .registers 5
    # ins_size=4
    invoke-virtual v1, Ljava/io/File;->delete()Z
    const-string v1, "avatar"
    invoke-static v1, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v1
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$$ExternalSyntheticLambda0;
    invoke-direct v0, v3, v4, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel; Ljava/lang/String;)V
    new-instance v4, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$$ExternalSyntheticLambda1;
    invoke-direct v4, v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;)V
    invoke-interface v2, v1, v0, v4, Lcom/bytedance/trae/login/api/ILoginService;->updateUserProfile(Ljava/util/Map; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final invokeSuspend$lambda$2$lambda$0(com.bytedance.trae.home.solo.setting.SettingsViewModel  java.lang.String)kotlin.Unit
    .registers 13
    # ins_size=2
    invoke-static v11, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->access$get_isLoading$p(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    invoke-static v11, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->access$get_userProfile$p(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/UserProfileState;
    if-eqz v1, +017h
    invoke-static v11, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->access$get_userProfile$p(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    const/4 v2, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 125
    const/4 v10, 0
    move-object v3, v12
    invoke-static/range v1 ... v10, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->copy$default(Lcom/bytedance/trae/home/solo/setting/UserProfileState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Boolean; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/UserProfileState;
    move-result-object v12
    invoke-virtual v0, v12, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    invoke-static v11, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->access$get_uploadAvatarResult$p(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v11
    new-instance v12, Lcom/bytedance/trae/home/solo/setting/Event;
    const/4 v0, 1
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-direct v12, v0, Lcom/bytedance/trae/home/solo/setting/Event;-><init>(Ljava/lang/Object;)V
    invoke-virtual v11, v12, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
.end method

.method private static final invokeSuspend$lambda$2$lambda$1(com.bytedance.trae.home.solo.setting.SettingsViewModel  int)kotlin.Unit
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, updateUserProfile avatar failed, errorCode=
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v1, "SettingsViewModel"
    invoke-virtual v0, v1, v4, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->access$get_isLoading$p(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v4
    const/4 v0, 0
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-virtual v4, v0, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    invoke-static v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->access$get_uploadAvatarResult$p(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/home/solo/setting/Event;
    invoke-direct v4, v0, Lcom/bytedance/trae/home/solo/setting/Event;-><init>(Ljava/lang/Object;)V
    invoke-virtual v3, v4, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private static final invokeSuspend$lambda$3(java.io.File  com.bytedance.trae.home.solo.setting.SettingsViewModel  java.lang.Long)kotlin.Unit
    .registers 5
    # ins_size=3
    invoke-virtual v2, Ljava/io/File;->delete()Z
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, uploadAvatar failed, errorCode=
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v0, "SettingsViewModel"
    invoke-virtual v2, v0, v4, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->access$get_isLoading$p(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v2
    const/4 v4, 0
    invoke-static v4, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v4
    invoke-virtual v2, v4, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    invoke-static v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->access$get_uploadAvatarResult$p(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/Event;
    invoke-direct v3, v4, Lcom/bytedance/trae/home/solo/setting/Event;-><init>(Ljava/lang/Object;)V
    invoke-virtual v2, v3, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    iget-object v2, v6, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->$loginService Lcom/bytedance/trae/login/api/ILoginService;
    iget-object v3, v6, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->$context Landroid/app/Application;
    iget-object v4, v6, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->$uri Landroid/net/Uri;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel; Lcom/bytedance/trae/login/api/ILoginService; Landroid/app/Application; Landroid/net/Uri; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v7, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2ch
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v8
    check-cast v8, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$uploadFile$1;
    iget-object v3, v7, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    iget-object v4, v7, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->$context Landroid/app/Application;
    iget-object v5, v7, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->$uri Landroid/net/Uri;
    const/4 v6, 0
    invoke-direct v1, v3, v4, v5, v6, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$uploadFile$1;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel; Landroid/app/Application; Landroid/net/Uri; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v3, v7
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v7, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->label I
    invoke-static v8, v1, v3, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +003h
    return-object v0
    check-cast v8, Ljava/io/File;
    if-nez v8, +025h
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    invoke-static v8, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->access$get_isLoading$p(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v8
    const/4 v0, 0
    invoke-static v0, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v8, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    invoke-static v8, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->access$get_uploadAvatarResult$p(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v8
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/Event;
    invoke-static v0, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-direct v1, v0, Lcom/bytedance/trae/home/solo/setting/Event;-><init>(Ljava/lang/Object;)V
    invoke-virtual v8, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
    iget-object v0, v7, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->$loginService Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v8, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v1
    const-string v2, "getAbsolutePath(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v7, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->$loginService Lcom/bytedance/trae/login/api/ILoginService;
    iget-object v3, v7, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    new-instance v4, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$$ExternalSyntheticLambda2;
    invoke-direct v4, v8, v2, v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$$ExternalSyntheticLambda2;-><init>(Ljava/io/File; Lcom/bytedance/trae/login/api/ILoginService; Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;)V
    iget-object v2, v7, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$$ExternalSyntheticLambda3;
    invoke-direct v3, v8, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$$ExternalSyntheticLambda3;-><init>(Ljava/io/File; Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;)V
    invoke-interface v0, v1, v4, v3, Lcom/bytedance/trae/login/api/ILoginService;->uploadAvatar(Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1;)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
.end method
