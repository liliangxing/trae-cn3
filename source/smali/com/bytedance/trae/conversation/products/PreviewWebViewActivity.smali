# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "PreviewWebViewActivity.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$Companion;
.field private static final EXTRA_CHAT_SESSION_ID:Ljava/lang/String;
.field private static final EXTRA_CLI_TYPE:Ljava/lang/String;
.field private static final EXTRA_TITLE:Ljava/lang/String;
.field private static final EXTRA_URL:Ljava/lang/String;
.field private btnBack:Landroid/widget/ImageView;
.field private btnRetry:Landroid/widget/TextView;
.field private btnStartAgent:Landroid/widget/TextView;
.field private errorContainer:Landroid/view/View;
.field private progressBar:Landroid/widget/ProgressBar;
.field private statusDesc:Landroid/widget/TextView;
.field private statusError:Landroid/widget/TextView;
.field private tvTitle:Landroid/widget/TextView;
.field private webView:Landroid/webkit/WebView;


.method public static synthetic $r8$lambda$Bslt-m11ImIscfgicpf0sH3aoKA(com.bytedance.trae.conversation.products.PreviewWebViewActivity  java.lang.String  java.lang.String  java.lang.String  android.view.View)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->onCreate$lambda$1(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$H4Rvk0MoeKA_aHBWdozEfr9IFuo(com.bytedance.trae.conversation.products.PreviewWebViewActivity  java.lang.String  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->onCreate$lambda$3(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$K2o_w_y4fbH0sjmYNZkhiS2Xb0k(com.bytedance.trae.conversation.products.PreviewWebViewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->onCreate$lambda$0(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$mBTjqJ-7LucY02EgNkx8tPDh8rk(java.lang.String  com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->isUrlValid$lambda$9(Ljava/lang/String; Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->Companion Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    return-void 
.end method

.method public static final synthetic access$fetchSessionPreviewUrl(com.bytedance.trae.conversation.products.PreviewWebViewActivity  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->fetchSessionPreviewUrl(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$fetchSessionToken(com.bytedance.trae.conversation.products.PreviewWebViewActivity  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->fetchSessionToken(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getProgressBar$p(com.bytedance.trae.conversation.products.PreviewWebViewActivity)android.widget.ProgressBar
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->progressBar Landroid/widget/ProgressBar;
    return-object v0
.end method

.method public static final synthetic access$getWebView$p(com.bytedance.trae.conversation.products.PreviewWebViewActivity)android.webkit.WebView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->webView Landroid/webkit/WebView;
    return-object v0
.end method

.method public static final synthetic access$resolvePreviewUrl(com.bytedance.trae.conversation.products.PreviewWebViewActivity  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->resolvePreviewUrl(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final appendOrReplaceQueryParam(java.lang.String  java.lang.String  java.lang.String)java.lang.String
    .registers 10
    # ins_size=4
    invoke-static v7, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v0
    invoke-virtual v0, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;
    move-result-object v1
    invoke-virtual v1, Landroid/net/Uri$Builder;->clearQuery()Landroid/net/Uri$Builder;
    move-result-object v1
    invoke-virtual v0, Landroid/net/Uri;->getQueryParameterNames()Ljava/util/Set;
    move-result-object v2
    invoke-interface v2, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +02eh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    invoke-static v3, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    goto -12h
    invoke-virtual v0, v3, Landroid/net/Uri;->getQueryParameters(Ljava/lang/String;)Ljava/util/List;
    move-result-object v4
    const-string v5, "getQueryParameters(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Ljava/lang/Iterable;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, -026h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    invoke-virtual v1, v3, v5, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    goto -fh
    invoke-virtual v1, v8, v9, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    invoke-virtual v1, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;
    move-result-object v8
    invoke-virtual v8, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v7, v8
    return-object v7
    :try_start_0x0
.end method

.method public static com_bytedance_trae_conversation_products_PreviewWebViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.conversation.products.PreviewWebViewActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->com_bytedance_trae_conversation_products_PreviewWebViewActivity__onStop$___twin___()V
    invoke-static Lcom/bytedance/sysoptimizer/EnterTransitionCrashOptimizer;->getContext()Landroid/content/Context;
    move-result-object v0
    if-eqz v0, +013h
    check-cast v1, Landroid/app/Activity;
    invoke-virtual v1, Landroid/app/Activity;->getWindow()Landroid/view/Window;
    move-result-object v1
    invoke-virtual v1, Landroid/view/Window;->getDecorView()Landroid/view/View;
    move-result-object v1
    invoke-virtual v1, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;
    move-result-object v1
    invoke-virtual v1, Landroid/view/ViewTreeObserver;->dispatchOnPreDraw()Z
    return-void 
    :try_start_0xb
.end method

.method private final fetchSessionPreviewUrl(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=3
    instance-of v0, v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionPreviewUrl$1;
    if-eqz v0, +012h
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionPreviewUrl$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionPreviewUrl$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v6, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionPreviewUrl$1;->label I
    sub-int/2addr v6, v2
    iput v6, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionPreviewUrl$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionPreviewUrl$1;
    invoke-direct v0, v4, v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionPreviewUrl$1;-><init>(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity; Lkotlin/coroutines/Continuation;)V
    iget-object v6, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionPreviewUrl$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionPreviewUrl$1;->label I
    const/4 v3, 1
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +17h
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v6, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v6, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v6, Lcom/bytedance/trae/im/service/IChatSessionApi;->Companion Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;
    iput v3, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionPreviewUrl$1;->label I
    invoke-virtual v6, v5, v0, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->getChatSessionRawCall(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v1, +003h
    return-object v1
    check-cast v6, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v5, v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v5, +033h
    check-cast v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/service/ChatSessionResponse;
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getPreviewUrl()Ljava/lang/String;
    move-result-object v5
    goto +2h
    const/4 v5, 0
    move-object v6, v5
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +00ah
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    const/4 v3, 0
    if-eqz v3, +007h
    sget-object v5, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult$Empty;->INSTANCE Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult$Empty;
    check-cast v5, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult;
    goto +12h
    new-instance v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult$Success;
    invoke-direct v6, v5, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult$Success;-><init>(Ljava/lang/String;)V
    move-object v5, v6
    check-cast v5, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult;
    goto +9h
    instance-of v5, v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v5, +007h
    sget-object v5, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult$Error;->INSTANCE Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult$Error;
    check-cast v5, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult;
    return-object v5
    new-instance v5, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v5, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v5
.end method

.method private final fetchSessionToken(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=3
    instance-of v0, v7, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$1;
    if-eqz v0, +012h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v7, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$1;->label I
    sub-int/2addr v7, v2
    iput v7, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$1;
    invoke-direct v0, v5, v7, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$1;-><init>(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity; Lkotlin/coroutines/Continuation;)V
    iget-object v7, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$1;->label I
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1eh
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v7, Lcom/bytedance/trae/im/service/IChatSessionAuthApi;->Companion Lcom/bytedance/trae/im/service/IChatSessionAuthApi$Companion;
    new-instance v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$result$1;
    invoke-direct v2, v6, v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$result$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/jvm/functions/Function2;
    iput v3, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$fetchSessionToken$1;->label I
    invoke-virtual v7, v2, v0, Lcom/bytedance/trae/im/service/IChatSessionAuthApi$Companion;->safeCall(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v1, +003h
    return-object v1
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v6, v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v6, +015h
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/service/SessionTokenData;
    if-eqz v6, +00bh
    invoke-virtual v6, Lcom/bytedance/trae/im/service/SessionTokenData;->getToken()Ljava/lang/String;
    move-result-object v4
    goto +5h
    instance-of v6, v7, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v6, +003h
    return-object v4
    new-instance v6, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v6, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v6
.end method

.method private final isUrlValid(java.lang.String)boolean
    .registers 8
    # ins_size=2
    const-string v0, "PreviewWebViewActivity"
    const-string v1, "isUrlValid:"
    const/4 v2, 0
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/List;
    new-instance v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$$ExternalSyntheticLambda3;
    invoke-direct v4, v7, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$$ExternalSyntheticLambda3;-><init>(Ljava/lang/String;)V
    invoke-interface v3, v4, Ljava/util/List;->add(Ljava/lang/Object;)Z
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v0, v5, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "https://placeholder.trae/"
    const/4 v5, 0
    invoke-static v4, v3, v5, Lcom/bytedance/ttnet/utils/RetrofitUtils;->createSsRetrofit(Ljava/lang/String; Ljava/util/List; Lcom/bytedance/retrofit2/Converter$Factory;)Lcom/bytedance/retrofit2/Retrofit;
    move-result-object v3
    const-class v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$WebFetchApi;
    invoke-virtual v3, v4, Lcom/bytedance/retrofit2/Retrofit;->create(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$WebFetchApi;
    if-nez v3, +003h
    return v2
    invoke-interface v3, v7, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$WebFetchApi;->get(Ljava/lang/String;)Lcom/bytedance/retrofit2/Call;
    move-result-object v7
    invoke-interface v7, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v7
    const-string v3, "execute(...)"
    invoke-static v7, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v1
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/retrofit2/SsResponse;->isSuccessful()Z
    move-result v7
    return v7
    move-exception v7
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "isUrlValid"
    invoke-virtual v1, v0, v3, v7, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return v2
    :try_start_0x5
.end method

.method private static final isUrlValid$lambda$9(java.lang.String  com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
    .registers 5
    # ins_size=2
    if-eqz v4, +038h
    invoke-interface v4, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->request()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v0
    if-nez v0, +003h
    goto +30h
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->getUrl()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v1
    invoke-virtual v1, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;
    move-result-object v1
    invoke-virtual v1, Landroid/net/Uri$Builder;->clearQuery()Landroid/net/Uri$Builder;
    move-result-object v1
    invoke-virtual v1, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;
    move-result-object v1
    invoke-virtual v1, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, toString(...)
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->newBuilder()Lcom/bytedance/retrofit2/client/Request$Builder;
    move-result-object v0
    invoke-virtual v0, v3, Lcom/bytedance/retrofit2/client/Request$Builder;->url(Ljava/lang/String;)Lcom/bytedance/retrofit2/client/Request$Builder;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/retrofit2/client/Request$Builder;->build()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v3
    invoke-interface v4, v3, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->proceed(Lcom/bytedance/retrofit2/client/Request;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v3
    return-object v3
    const/4 v3, 0
    return-object v3
.end method

.method private static final onCreate$lambda$0(com.bytedance.trae.conversation.products.PreviewWebViewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->finish()V
    return-void 
.end method

.method private static final onCreate$lambda$1(com.bytedance.trae.conversation.products.PreviewWebViewActivity  java.lang.String  java.lang.String  java.lang.String  android.view.View)void
    .registers 14
    # ins_size=5
    iget-object v13, v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->errorContainer Landroid/view/View;
    const/4 v0, 0
    if-nez v13, +008h
    const-string v13, "errorContainer"
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v13, v0
    const/16 v1, 8
    invoke-virtual v13, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v13, v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v13, +009h
    const-string/jumbo v13, webView
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v13, v0
    const/4 v1, 0
    invoke-virtual v13, v1, Landroid/webkit/WebView;->setVisibility(I)V
    iget-object v13, v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->progressBar Landroid/widget/ProgressBar;
    const-string v2, "progressBar"
    if-nez v13, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v13, v0
    const/4 v3, 1
    invoke-virtual v13, v3, Landroid/widget/ProgressBar;->setIndeterminate(Z)V
    iget-object v13, v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->progressBar Landroid/widget/ProgressBar;
    if-nez v13, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v13
    invoke-virtual v0, v1, Landroid/widget/ProgressBar;->setVisibility(I)V
    move-object v13, v9
    check-cast v13, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v13, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v13
    move-object v0, v13
    check-cast v0, Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 0
    new-instance v13, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;
    const/4 v8, 0
    move-object v3, v13
    move-object v4, v9
    move-object v5, v10
    move-object v6, v11
    move-object v7, v12
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$2$1;-><init>(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v3, v13
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final onCreate$lambda$3(com.bytedance.trae.conversation.products.PreviewWebViewActivity  java.lang.String  android.view.View)void
    .registers 4
    # ins_size=3
    new-instance v3, Landroid/content/Intent;
    invoke-direct v3, Landroid/content/Intent;-><init>()V
    const-string v0, "extra_start_server_url"
    invoke-virtual v3, v0, v2, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const/4 v2, -1
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->setResult(I Landroid/content/Intent;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->finish()V
    return-void 
.end method

.method private final parseUrl(java.lang.String)com.bytedance.trae.conversation.products.PreviewWebViewActivity$ParsedUrl
    .registers 10
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;
    const-string v1, ""
    const/4 v2, 0
    invoke-direct v0, v1, v2, v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;-><init>(Ljava/lang/String; Z Z)V
    move-object v1, v9
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    return-object v0
    new-instance v1, Ljava/net/URI;
    invoke-direct v1, v9, Ljava/net/URI;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Ljava/net/URI;->getHost()Ljava/lang/String;
    move-result-object v9
    const/4 v3, 0
    if-eqz v9, +00fh
    sget-object v4, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v9, v4, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v9
    const-string/jumbo v4, toLowerCase(...)
    invoke-static v9, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +2h
    move-object v9, v3
    invoke-virtual v1, Ljava/net/URI;->getRawPath()Ljava/lang/String;
    move-result-object v4
    const/4 v5, 1
    if-eqz v4, +014h
    move-object v6, v4
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-lez v6, +004h
    move v6, v5
    goto +2h
    move v6, v2
    if-eqz v6, +003h
    goto +2h
    move-object v4, v3
    if-nez v4, +004h
    const-string v4, "/"
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Ljava/net/URI;->getRawQuery()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +01dh
    move-object v7, v4
    check-cast v7, Ljava/lang/CharSequence;
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-lez v7, +004h
    move v7, v5
    goto +2h
    move v7, v2
    if-eqz v7, +003h
    goto +2h
    move-object v4, v3
    if-eqz v4, +00bh
    const/16 v7, 63
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v1, Ljava/net/URI;->getRawFragment()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +01ah
    move-object v4, v1
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +003h
    move v2, v5
    if-eqz v2, +003h
    move-object v3, v1
    if-eqz v3, +00bh
    const/16 v1, 35
    invoke-virtual v6, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, toString(...)
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "localhost"
    const-string v3, "127.0.0.1"
    const-string v4, "0.0.0.0"
    const-string v6, "::1"
    filled-new-array v2, v3, v4, v6, [Ljava/lang/String;
    move-result-object v2
    invoke-static v2, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, v9, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v9
    invoke-virtual v0, v1, v9, v5, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->copy(Ljava/lang/String; Z Z)Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;
    move-result-object v0
    return-object v0
    :try_start_0x12
.end method

.method private final resolvePreviewUrl(java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 12
    # ins_size=5
    instance-of v0, v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$resolvePreviewUrl$1;
    if-eqz v0, +012h
    move-object v0, v11
    check-cast v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$resolvePreviewUrl$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$resolvePreviewUrl$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v11, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$resolvePreviewUrl$1;->label I
    sub-int/2addr v11, v2
    iput v11, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$resolvePreviewUrl$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$resolvePreviewUrl$1;
    invoke-direct v0, v7, v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$resolvePreviewUrl$1;-><init>(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity; Lkotlin/coroutines/Continuation;)V
    iget-object v11, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$resolvePreviewUrl$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$resolvePreviewUrl$1;->label I
    const/4 v3, 0
    const/4 v4, 2
    const/4 v5, 1
    if-eqz v2, +02eh
    if-eq v2, v5, +019h
    if-ne v2, v4, +00fh
    iget-object v8, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$resolvePreviewUrl$1;->L$1 Ljava/lang/Object;
    check-cast v8, Ljava/lang/String;
    iget-object v9, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$resolvePreviewUrl$1;->L$0 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +08bh
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v9, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v9, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    iget-object v8, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$resolvePreviewUrl$1;->L$2 Ljava/lang/Object;
    check-cast v8, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;
    iget-object v9, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$resolvePreviewUrl$1;->L$1 Ljava/lang/Object;
    check-cast v9, Ljava/lang/String;
    iget-object v10, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$resolvePreviewUrl$1;->L$0 Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v6, v10
    move-object v10, v9
    move-object v9, v6
    goto +49h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->parseUrl(Ljava/lang/String;)Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->isValid()Z
    move-result v2
    if-eqz v2, +0aah
    invoke-virtual v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->isLocal()Z
    move-result v2
    if-nez v2, +004h
    goto/16 +0a2h
    move-object v2, v9
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    move v2, v3
    goto +2h
    move v2, v5
    if-nez v2, +08bh
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v10, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v10
    if-nez v10, +004h
    goto/16 +07dh
    iput-object v7, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$resolvePreviewUrl$1;->L$0 Ljava/lang/Object;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$resolvePreviewUrl$1;->L$1 Ljava/lang/Object;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$resolvePreviewUrl$1;->L$2 Ljava/lang/Object;
    iput v5, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$resolvePreviewUrl$1;->label I
    invoke-direct v7, v9, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->fetchSessionPreviewUrl(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    move-object v10, v9
    move-object v9, v7
    move-object v6, v11
    move-object v11, v8
    move-object v8, v6
    check-cast v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult;
    instance-of v2, v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult$Success;
    if-eqz v2, +04fh
    check-cast v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult$Success;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult$Success;->getPreviewUrl()Ljava/lang/String;
    move-result-object v11
    sget-object v2, Lcom/bytedance/trae/conversation/products/SessionPreviewUrlBuilder;->INSTANCE Lcom/bytedance/trae/conversation/products/SessionPreviewUrlBuilder;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;->getPathSearchHash()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v2, v11, v8, Lcom/bytedance/trae/conversation/products/SessionPreviewUrlBuilder;->build(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    iput-object v9, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$resolvePreviewUrl$1;->L$0 Ljava/lang/Object;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$resolvePreviewUrl$1;->L$1 Ljava/lang/Object;
    const/4 v11, 0
    iput-object v11, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$resolvePreviewUrl$1;->L$2 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$resolvePreviewUrl$1;->label I
    invoke-direct v9, v10, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->fetchSessionToken(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v1, +003h
    return-object v1
    check-cast v11, Ljava/lang/String;
    move-object v10, v11
    check-cast v10, Ljava/lang/CharSequence;
    if-eqz v10, +008h
    invoke-static v10, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v10
    if-eqz v10, +003h
    move v3, v5
    if-nez v3, +008h
    const-string v10, "_session_token"
    invoke-direct v9, v8, v10, v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->appendOrReplaceQueryParam(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    invoke-direct v9, v8, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->isUrlValid(Ljava/lang/String;)Z
    move-result v9
    if-eqz v9, +00ah
    new-instance v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$Success;
    invoke-direct v9, v8, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$Success;-><init>(Ljava/lang/String;)V
    check-cast v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult;
    goto +6h
    sget-object v8, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$ServiceNotRunning;->INSTANCE Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$ServiceNotRunning;
    move-object v9, v8
    check-cast v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult;
    return-object v9
    sget-object v8, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$NetworkError;->INSTANCE Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$NetworkError;
    return-object v8
    instance-of v8, v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult$Empty;
    if-eqz v8, +005h
    sget-object v8, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$ServiceNotRunning;->INSTANCE Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$ServiceNotRunning;
    return-object v8
    instance-of v8, v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult$Error;
    if-eqz v8, +005h
    sget-object v8, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$NetworkError;->INSTANCE Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$NetworkError;
    return-object v8
    new-instance v8, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v8, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v8
    new-instance v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$Success;
    invoke-direct v9, v8, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$Success;-><init>(Ljava/lang/String;)V
    return-object v9
    new-instance v9, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$Success;
    invoke-direct v9, v8, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$Success;-><init>(Ljava/lang/String;)V
    return-object v9
    :try_start_0xa6
.end method

.method private final setupBackHandler()void
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    move-result-object v0
    move-object v1, v3
    check-cast v1, Landroidx/lifecycle/LifecycleOwner;
    new-instance v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$setupBackHandler$1;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$setupBackHandler$1;-><init>(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;)V
    check-cast v2, Landroidx/activity/OnBackPressedCallback;
    invoke-virtual v0, v1, v2, Landroidx/activity/OnBackPressedDispatcher;->addCallback(Landroidx/lifecycle/LifecycleOwner; Landroidx/activity/OnBackPressedCallback;)V
    return-void 
.end method

.method private final setupWebView()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->webView Landroid/webkit/WebView;
    const/4 v1, 0
    const-string/jumbo v2, webView
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v3, Landroid/webkit/WebViewClient;
    invoke-direct v3, Landroid/webkit/WebViewClient;-><init>()V
    invoke-virtual v0, v3, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v3, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$setupWebView$1;
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$setupWebView$1;-><init>(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;)V
    check-cast v3, Landroid/webkit/WebChromeClient;
    invoke-virtual v0, v3, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;
    move-result-object v0
    const-string v1, "getSettings(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v1, 1
    invoke-virtual v0, v1, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V
    invoke-virtual v0, v1, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V
    invoke-virtual v0, v1, Landroid/webkit/WebSettings;->setUseWideViewPort(Z)V
    invoke-virtual v0, v1, Landroid/webkit/WebSettings;->setLoadWithOverviewMode(Z)V
    invoke-virtual v0, v1, Landroid/webkit/WebSettings;->setSupportZoom(Z)V
    invoke-virtual v0, v1, Landroid/webkit/WebSettings;->setBuiltInZoomControls(Z)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/webkit/WebSettings;->setDisplayZoomControls(Z)V
    const/4 v1, 2
    invoke-virtual v0, v1, Landroid/webkit/WebSettings;->setMixedContentMode(I)V
    return-void 
.end method

.method private final showError(int  int  boolean  boolean)void
    .registers 9
    # ins_size=5
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->progressBar Landroid/widget/ProgressBar;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +009h
    const-string/jumbo v0, webView
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/webkit/WebView;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->errorContainer Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "errorContainer"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v3, 0
    invoke-virtual v0, v3, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->statusError Landroid/widget/TextView;
    if-nez v0, +009h
    const-string/jumbo v0, statusError
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v5, Landroid/widget/TextView;->setText(I)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->statusDesc Landroid/widget/TextView;
    if-nez v5, +009h
    const-string/jumbo v5, statusDesc
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v1
    invoke-virtual v5, v6, Landroid/widget/TextView;->setText(I)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->btnRetry Landroid/widget/TextView;
    const-string v6, "btnRetry"
    if-nez v5, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v1
    if-eqz v7, +004h
    move v7, v3
    goto +2h
    move v7, v2
    invoke-virtual v5, v7, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->btnRetry Landroid/widget/TextView;
    if-nez v5, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v1
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_doc_preview_retry I
    invoke-virtual v5, v6, Landroid/widget/TextView;->setText(I)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->btnStartAgent Landroid/widget/TextView;
    const-string v6, "btnStartAgent"
    if-nez v5, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v1
    if-eqz v8, +003h
    move v2, v3
    invoke-virtual v5, v2, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->btnStartAgent Landroid/widget/TextView;
    if-nez v5, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v5
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_doc_preview_restart_service I
    invoke-virtual v1, v5, Landroid/widget/TextView;->setText(I)V
    return-void 
.end method

.method static synthetic showError$default(com.bytedance.trae.conversation.products.PreviewWebViewActivity  int  int  boolean  boolean  int  java.lang.Object)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 4
    const/4 v0, 0
    if-eqz v7, +003h
    move v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move v5, v0
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->showError(I I Z Z)V
    return-void 
.end method

.method public com_bytedance_trae_conversation_products_PreviewWebViewActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 13
    # ins_size=2
    invoke-super v11, v12, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    sget v12, Lcom/bytedance/trae/conversation/R$layout;->trae_activity_web_preview I
    invoke-virtual v11, v12, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->setContentView(I)V
    sget v12, Lcom/bytedance/trae/conversation/R$id;->btn_back I
    invoke-virtual v11, v12, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v12
    const-string v0, "findViewById(...)"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v12, Landroid/widget/ImageView;
    iput-object v12, v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->btnBack Landroid/widget/ImageView;
    sget v12, Lcom/bytedance/trae/conversation/R$id;->tv_title I
    invoke-virtual v11, v12, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v12, Landroid/widget/TextView;
    iput-object v12, v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->tvTitle Landroid/widget/TextView;
    sget v12, Lcom/bytedance/trae/conversation/R$id;->progress_bar I
    invoke-virtual v11, v12, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v12, Landroid/widget/ProgressBar;
    iput-object v12, v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->progressBar Landroid/widget/ProgressBar;
    sget v12, Lcom/bytedance/trae/conversation/R$id;->webview I
    invoke-virtual v11, v12, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v12, Landroid/webkit/WebView;
    iput-object v12, v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->webView Landroid/webkit/WebView;
    sget v12, Lcom/bytedance/trae/conversation/R$id;->error_container I
    invoke-virtual v11, v12, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v12, v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->errorContainer Landroid/view/View;
    sget v12, Lcom/bytedance/trae/conversation/R$id;->status_error I
    invoke-virtual v11, v12, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v12, Landroid/widget/TextView;
    iput-object v12, v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->statusError Landroid/widget/TextView;
    sget v12, Lcom/bytedance/trae/conversation/R$id;->status_error_desc I
    invoke-virtual v11, v12, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v12, Landroid/widget/TextView;
    iput-object v12, v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->statusDesc Landroid/widget/TextView;
    sget v12, Lcom/bytedance/trae/conversation/R$id;->btn_retry I
    invoke-virtual v11, v12, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v12, Landroid/widget/TextView;
    iput-object v12, v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->btnRetry Landroid/widget/TextView;
    sget v12, Lcom/bytedance/trae/conversation/R$id;->btn_start_agent I
    invoke-virtual v11, v12, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v12, Landroid/widget/TextView;
    iput-object v12, v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->btnStartAgent Landroid/widget/TextView;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v12
    const-string v0, "extra_url"
    invoke-virtual v12, v0, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v12
    if-nez v12, +004h
    const-string v12, ""
    move-object v2, v12
    move-object v12, v2
    check-cast v12, Ljava/lang/CharSequence;
    invoke-interface v12, Ljava/lang/CharSequence;->length()I
    move-result v12
    const/4 v0, 1
    const/4 v1, 0
    if-nez v12, +004h
    move v12, v0
    goto +2h
    move v12, v1
    if-eqz v12, +006h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->finish()V
    return-void 
    invoke-virtual v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v12
    const-string v3, "extra_chat_session_id"
    invoke-virtual v12, v3, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v12
    const-string v4, "extra_cli_type"
    invoke-virtual v12, v4, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    iget-object v12, v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->tvTitle Landroid/widget/TextView;
    const/4 v5, 0
    if-nez v12, +009h
    const-string/jumbo v12, tvTitle
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v12, v5
    invoke-virtual v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v6
    const-string v7, "extra_title"
    invoke-virtual v6, v7, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +005h
    check-cast v6, Ljava/lang/CharSequence;
    goto +eh
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_chat_artifact_preview_web I
    invoke-virtual v11, v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->getString(I)Ljava/lang/String;
    move-result-object v6
    const-string v7, "getString(...)"
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Ljava/lang/CharSequence;
    invoke-virtual v12, v6, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->btnBack Landroid/widget/ImageView;
    if-nez v12, +008h
    const-string v12, "btnBack"
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v12, v5
    new-instance v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$$ExternalSyntheticLambda0;
    invoke-direct v6, v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;)V
    invoke-virtual v12, v6, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->setupBackHandler()V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->btnRetry Landroid/widget/TextView;
    if-nez v12, +008h
    const-string v12, "btnRetry"
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v12, v5
    new-instance v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$$ExternalSyntheticLambda1;
    invoke-direct v6, v11, v2, v3, v4, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v12, v6, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->btnStartAgent Landroid/widget/TextView;
    if-nez v12, +008h
    const-string v12, "btnStartAgent"
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v12, v5
    new-instance v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$$ExternalSyntheticLambda2;
    invoke-direct v6, v11, v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity; Ljava/lang/String;)V
    invoke-virtual v12, v6, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->setupWebView()V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->progressBar Landroid/widget/ProgressBar;
    const-string v6, "progressBar"
    if-nez v12, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v12, v5
    invoke-virtual v12, v0, Landroid/widget/ProgressBar;->setIndeterminate(Z)V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->progressBar Landroid/widget/ProgressBar;
    if-nez v12, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v5, v12
    invoke-virtual v5, v1, Landroid/widget/ProgressBar;->setVisibility(I)V
    move-object v12, v11
    check-cast v12, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v12, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v12
    check-cast v12, Lkotlinx/coroutines/CoroutineScope;
    const/4 v6, 0
    const/4 v7, 0
    new-instance v8, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4;
    const/4 v5, 0
    move-object v0, v8
    move-object v1, v11
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4;-><init>(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/jvm/functions/Function2;
    const/4 v9, 3
    const/4 v10, 0
    move-object v5, v12
    invoke-static/range v5 ... v10, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method protected onDestroy()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->webView Landroid/webkit/WebView;
    if-eqz v0, +026h
    const-string/jumbo v1, webView
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Landroid/webkit/WebView;->stopLoading()V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v2, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    invoke-virtual v2, Landroid/webkit/WebView;->destroy()V
    invoke-super v3, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onDestroy()V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->com_bytedance_trae_conversation_products_PreviewWebViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;)V
    return-void 
.end method
