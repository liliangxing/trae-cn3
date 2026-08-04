# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$uploadFile$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "SettingsViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $context:Landroid/app/Application;
.field final synthetic $uri:Landroid/net/Uri;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;


.method constructor <init>(com.bytedance.trae.home.solo.setting.SettingsViewModel  android.app.Application  android.net.Uri  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$uploadFile$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$uploadFile$1;->$context Landroid/app/Application;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$uploadFile$1;->$uri Landroid/net/Uri;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$uploadFile$1;
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$uploadFile$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$uploadFile$1;->$context Landroid/app/Application;
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$uploadFile$1;->$uri Landroid/net/Uri;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$uploadFile$1;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel; Landroid/app/Application; Landroid/net/Uri; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$uploadFile$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$uploadFile$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$uploadFile$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$uploadFile$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$uploadFile$1;->label I
    if-nez v0, +010h
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v3, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$uploadFile$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$uploadFile$1;->$context Landroid/app/Application;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$uploadFile$1;->$uri Landroid/net/Uri;
    invoke-static v3, v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->access$copyAndCompressAvatar(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel; Landroid/app/Application; Landroid/net/Uri;)Ljava/io/File;
    move-result-object v3
    return-object v3
    new-instance v3, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v3, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v3
.end method
