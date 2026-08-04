# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/share/ShareUtils;
.super Ljava/lang/Object;
.source "ShareUtils.kt"

.field private static final CHOOSER_RECEIVER_TIMEOUT_MS:J
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/share/ShareUtils;


.method public static synthetic $r8$lambda$PwDoDutx2MX7fqOn6-EmzYSvDbA(kotlin.jvm.functions.Function0)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/share/ShareUtils;->createChooserWithChosenComponentCallback$lambda$5(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$vLSTuzTarZyOcRX62X3gcqHr4wM(kotlin.jvm.internal.Ref$BooleanRef  android.content.Context  kotlin.jvm.internal.Ref$ObjectRef)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/share/ShareUtils;->createChooserWithChosenComponentCallback$lambda$4(Lkotlin/jvm/internal/Ref$BooleanRef; Landroid/content/Context; Lkotlin/jvm/internal/Ref$ObjectRef;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/share/ShareUtils;
    invoke-direct v0, Lcom/bytedance/trae/conversation/share/ShareUtils;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/share/ShareUtils;->INSTANCE Lcom/bytedance/trae/conversation/share/ShareUtils;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static INVOKEVIRTUAL_com_bytedance_trae_conversation_share_ShareUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(android.content.Context  android.content.BroadcastReceiver)void
    .registers 3
    # ins_size=2
    const/4 v0, 0
    invoke-static v2, v0, Lcom/bytedance/sysoptimizer/ReceiverRegisterLancet;->loge(Landroid/content/BroadcastReceiver; Z)V
    invoke-virtual v1, v2, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    return-void 
.end method

.method public static final synthetic access$chosenComponent(com.bytedance.trae.conversation.share.ShareUtils  android.content.Intent)android.content.ComponentName
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/share/ShareUtils;->chosenComponent(Landroid/content/Intent;)Landroid/content/ComponentName;
    move-result-object v0
    return-object v0
.end method

.method private final chosenComponent(android.content.Intent)android.content.ComponentName
    .registers 5
    # ins_size=2
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 33
    const-string v2, "android.intent.extra.CHOSEN_COMPONENT"
    if-lt v0, v1, +00bh
    const-class v0, Landroid/content/ComponentName;
    invoke-virtual v4, v2, v0, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Landroid/content/ComponentName;
    goto +7h
    invoke-virtual v4, v2, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;
    move-result-object v4
    check-cast v4, Landroid/content/ComponentName;
    return-object v4
.end method

.method private final createChooserWithChosenComponentCallback(android.content.Context  android.content.Intent  java.lang.CharSequence  kotlin.jvm.functions.Function1)android.content.Intent
    .registers 10
    # ins_size=5
    invoke-virtual v6, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v6
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v6, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ".SHARE_CHOSEN."
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    new-instance v1, Landroid/content/Intent;
    invoke-direct v1, v0, Landroid/content/Intent;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;
    move-result-object v1
    const-string/jumbo v2, setPackage(...)
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v2, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v2, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    new-instance v3, Lkotlin/jvm/internal/Ref$BooleanRef;
    invoke-direct v3, Lkotlin/jvm/internal/Ref$BooleanRef;-><init>()V
    const/4 v4, 1
    iput-boolean v4, v3, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    new-instance v4, Lcom/bytedance/trae/conversation/share/ShareUtils$$ExternalSyntheticLambda0;
    invoke-direct v4, v3, v6, v2, Lcom/bytedance/trae/conversation/share/ShareUtils$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/internal/Ref$BooleanRef; Landroid/content/Context; Lkotlin/jvm/internal/Ref$ObjectRef;)V
    new-instance v3, Lcom/bytedance/trae/conversation/share/ShareUtils$createChooserWithChosenComponentCallback$1;
    invoke-direct v3, v4, v9, Lcom/bytedance/trae/conversation/share/ShareUtils$createChooserWithChosenComponentCallback$1;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1;)V
    iput-object v3, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    iget-object v9, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    if-nez v9, +009h
    const-string v9, "receiver"
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v9, 0
    goto +5h
    iget-object v9, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v9, Landroid/content/BroadcastReceiver;
    new-instance v2, Landroid/content/IntentFilter;
    invoke-direct v2, v0, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V
    const/4 v3, 4
    invoke-static v6, v9, v2, v3, Landroidx/core/content/ContextCompat;->registerReceiver(Landroid/content/Context; Landroid/content/BroadcastReceiver; Landroid/content/IntentFilter; I)Landroid/content/Intent;
    new-instance v9, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v2
    invoke-direct v9, v2, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    new-instance v2, Lcom/bytedance/trae/conversation/share/ShareUtils$$ExternalSyntheticLambda1;
    invoke-direct v2, v4, Lcom/bytedance/trae/conversation/share/ShareUtils$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/functions/Function0;)V
    const-wide/32 v3, 60000
    invoke-virtual v9, v2, v3, v4, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    sget v9, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v2, 31
    if-lt v9, v2, +005h
    const/high16 v9, 33554432
    goto +2h
    const/4 v9, 0
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    const/high16 v2, 134217728
    or-int/2addr v9, v2
    invoke-static v6, v0, v1, v9, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context; I Landroid/content/Intent; I)Landroid/app/PendingIntent;
    move-result-object v6
    invoke-virtual v6, Landroid/app/PendingIntent;->getIntentSender()Landroid/content/IntentSender;
    move-result-object v6
    invoke-static v7, v8, v6, Landroid/content/Intent;->createChooser(Landroid/content/Intent; Ljava/lang/CharSequence; Landroid/content/IntentSender;)Landroid/content/Intent;
    move-result-object v6
    const-string v7, "createChooser(...)"
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v6
.end method

.method private static final createChooserWithChosenComponentCallback$lambda$4(kotlin.jvm.internal.Ref$BooleanRef  android.content.Context  kotlin.jvm.internal.Ref$ObjectRef)kotlin.Unit
    .registers 4
    # ins_size=3
    iget-boolean v0, v1, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    if-eqz v0, +029h
    const/4 v0, 0
    iput-boolean v0, v1, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    iget-object v1, v3, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    if-nez v1, +009h
    const-string v1, "receiver"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    goto +5h
    iget-object v1, v3, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v1, Landroid/content/BroadcastReceiver;
    invoke-static v2, v1, Lcom/bytedance/trae/conversation/share/ShareUtils;->INVOKEVIRTUAL_com_bytedance_trae_conversation_share_ShareUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Landroid/content/Context; Landroid/content/BroadcastReceiver;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    :try_start_0x7
.end method

.method private static final createChooserWithChosenComponentCallback$lambda$5(kotlin.jvm.functions.Function0)void
    .registers 1
    # ins_size=1
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method public static synthetic shareImage$default(com.bytedance.trae.conversation.share.ShareUtils  android.content.Context  android.net.Uri  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 4
    if-eqz v6, +003h
    const/4 v3, 0
    and-int/lit8 v5, v5, 8
    if-eqz v5, +005h
    const-string/jumbo v4, 分享图片
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/share/ShareUtils;->shareImage(Landroid/content/Context; Landroid/net/Uri; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic shareImageWithText$default(com.bytedance.trae.conversation.share.ShareUtils  android.content.Context  android.net.Uri  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 8
    if-eqz v5, +005h
    const-string/jumbo v4, 分享
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/share/ShareUtils;->shareImageWithText(Landroid/content/Context; Landroid/net/Uri; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic shareLink$default(com.bytedance.trae.conversation.share.ShareUtils  android.content.Context  java.lang.String  java.lang.String  java.lang.CharSequence  kotlin.jvm.functions.Function1  int  java.lang.Object)boolean
    .registers 15
    # ins_size=8
    and-int/lit8 v14, v13, 4
    const/4 v0, 0
    if-eqz v14, +004h
    move-object v4, v0
    goto +2h
    move-object v4, v10
    and-int/lit8 v10, v13, 8
    if-eqz v10, +004h
    move-object v5, v0
    goto +2h
    move-object v5, v11
    and-int/lit8 v10, v13, 16
    if-eqz v10, +004h
    move-object v6, v0
    goto +2h
    move-object v6, v12
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/conversation/share/ShareUtils;->shareLink(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1;)Z
    move-result v7
    return v7
.end method

.method public static synthetic shareMultipleImages$default(com.bytedance.trae.conversation.share.ShareUtils  android.content.Context  java.util.ArrayList  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 4
    if-eqz v6, +003h
    const/4 v3, 0
    and-int/lit8 v5, v5, 8
    if-eqz v5, +005h
    const-string/jumbo v4, 分享图片
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/share/ShareUtils;->shareMultipleImages(Landroid/content/Context; Ljava/util/ArrayList; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final shareImage(android.content.Context  android.net.Uri  java.lang.String  java.lang.String)void
    .registers 7
    # ins_size=5
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "imageUri"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chooserTitle"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Landroid/content/Intent;
    const-string v1, "android.intent.action.SEND"
    invoke-direct v0, v1, Landroid/content/Intent;-><init>(Ljava/lang/String;)V
    const-string v1, "image/*"
    invoke-virtual v0, v1, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;
    const-string v1, "android.intent.extra.STREAM"
    check-cast v4, Landroid/os/Parcelable;
    invoke-virtual v0, v1, v4, Landroid/content/Intent;->putExtra(Ljava/lang/String; Landroid/os/Parcelable;)Landroid/content/Intent;
    const/4 v4, 1
    invoke-virtual v0, v4, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    move-object v1, v5
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00ah
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +2h
    const/4 v4, 0
    if-nez v4, +00ch
    const-string v4, "android.intent.extra.SUBJECT"
    invoke-virtual v0, v4, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "android.intent.extra.TITLE"
    invoke-virtual v0, v4, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v0, v6, Landroid/content/Intent;->createChooser(Landroid/content/Intent; Ljava/lang/CharSequence;)Landroid/content/Intent;
    move-result-object v4
    const/high16 v5, 268435456
    invoke-virtual v4, v5, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    invoke-virtual v3, v4, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method

.method public final shareImageWithText(android.content.Context  android.net.Uri  java.lang.String  java.lang.String)void
    .registers 7
    # ins_size=5
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "imageUri"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, text
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chooserTitle"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Landroid/content/Intent;
    const-string v1, "android.intent.action.SEND"
    invoke-direct v0, v1, Landroid/content/Intent;-><init>(Ljava/lang/String;)V
    const-string v1, "image/*"
    invoke-virtual v0, v1, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;
    const-string v1, "android.intent.extra.STREAM"
    check-cast v4, Landroid/os/Parcelable;
    invoke-virtual v0, v1, v4, Landroid/content/Intent;->putExtra(Ljava/lang/String; Landroid/os/Parcelable;)Landroid/content/Intent;
    const-string v4, "android.intent.extra.TEXT"
    invoke-virtual v0, v4, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const/4 v4, 1
    invoke-virtual v0, v4, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v0, v6, Landroid/content/Intent;->createChooser(Landroid/content/Intent; Ljava/lang/CharSequence;)Landroid/content/Intent;
    move-result-object v4
    const/high16 v5, 268435456
    invoke-virtual v4, v5, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    invoke-virtual v3, v4, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method

.method public final shareLink(android.content.Context  java.lang.String  java.lang.String  java.lang.CharSequence  kotlin.jvm.functions.Function1)boolean
    .registers 9
    # ins_size=6
    const-string v0, "context"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, url
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Landroid/content/Intent;
    const-string v1, "android.intent.action.SEND"
    invoke-direct v0, v1, Landroid/content/Intent;-><init>(Ljava/lang/String;)V
    const-string/jumbo v1, text/plain
    invoke-virtual v0, v1, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;
    const-string v1, "android.intent.extra.TEXT"
    invoke-virtual v0, v1, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    move-object v5, v6
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    goto +3h
    move v5, v1
    goto +2h
    move v5, v2
    if-nez v5, +00ch
    const-string v5, "android.intent.extra.SUBJECT"
    invoke-virtual v0, v5, v6, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v5, "android.intent.extra.TITLE"
    invoke-virtual v0, v5, v6, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    sget-object v5, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v5, v3
    check-cast v5, Lcom/bytedance/trae/conversation/share/ShareUtils;
    if-nez v8, +007h
    invoke-static v0, v7, Landroid/content/Intent;->createChooser(Landroid/content/Intent; Ljava/lang/CharSequence;)Landroid/content/Intent;
    move-result-object v5
    goto +5h
    invoke-direct v3, v4, v0, v7, v8, Lcom/bytedance/trae/conversation/share/ShareUtils;->createChooserWithChosenComponentCallback(Landroid/content/Context; Landroid/content/Intent; Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1;)Landroid/content/Intent;
    move-result-object v5
    invoke-static v5, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    goto +ch
    move-exception v5
    sget-object v6, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v5, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v5
    invoke-static v5, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    invoke-static v5, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v6
    if-nez v6, +003h
    goto +5h
    invoke-static v0, v7, Landroid/content/Intent;->createChooser(Landroid/content/Intent; Ljava/lang/CharSequence;)Landroid/content/Intent;
    move-result-object v5
    check-cast v5, Landroid/content/Intent;
    const/high16 v6, 268435456
    invoke-virtual v5, v6, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    invoke-virtual v4, v5, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    move v1, v2
    return v1
    :try_start_0x3a
    :try_start_0x6c
.end method

.method public final shareMultipleImages(android.content.Context  java.util.ArrayList  java.lang.String  java.lang.String)void
    .registers 7
    # ins_size=5
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "imageUris"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chooserTitle"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Landroid/content/Intent;
    const-string v1, "android.intent.action.SEND_MULTIPLE"
    invoke-direct v0, v1, Landroid/content/Intent;-><init>(Ljava/lang/String;)V
    const-string v1, "image/*"
    invoke-virtual v0, v1, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;
    const-string v1, "android.intent.extra.STREAM"
    invoke-virtual v0, v1, v4, Landroid/content/Intent;->putParcelableArrayListExtra(Ljava/lang/String; Ljava/util/ArrayList;)Landroid/content/Intent;
    const/4 v4, 1
    invoke-virtual v0, v4, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    move-object v1, v5
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00ah
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +2h
    const/4 v4, 0
    if-nez v4, +00ch
    const-string v4, "android.intent.extra.SUBJECT"
    invoke-virtual v0, v4, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "android.intent.extra.TITLE"
    invoke-virtual v0, v4, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v0, v6, Landroid/content/Intent;->createChooser(Landroid/content/Intent; Ljava/lang/CharSequence;)Landroid/content/Intent;
    move-result-object v4
    const/high16 v5, 268435456
    invoke-virtual v4, v5, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    invoke-virtual v3, v4, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method
