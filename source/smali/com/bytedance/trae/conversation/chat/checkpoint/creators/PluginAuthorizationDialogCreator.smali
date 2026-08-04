# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;
.super Ljava/lang/Object;
.source "PluginAuthorizationDialogCreator.kt"

.implements Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;

.field private static final Companion:Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$Companion;
.field public static final SERVICE_SEPARATOR:Ljava/lang/String;
.field public static final TITLE_LETTER_SPACING_EM:F
.field private descriptor:Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;
.field private originalParams:Lcom/google/gson/JsonObject;
.field private resolvedName:Ljava/lang/String;
.field private resolvedNameForPlugin:Ljava/lang/String;


.method public static synthetic $r8$lambda$0rAgmBm61SH8DPCdSBt307yFPBA(java.lang.String  android.view.View  android.view.View  android.view.View  android.view.View)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindQrCodeActions$lambda$5$lambda$4$lambda$3(Ljava/lang/String; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$2LhAL5-xjLQvE8yBTbToHP1La6w(java.lang.String  android.view.View  android.view.View  android.view.View  android.view.View)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindCustomAuthPollingActions$lambda$16$lambda$15$lambda$14(Ljava/lang/String; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$7QNFaqXSbcnEn_97FAlhDCz7qUs(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  kotlin.jvm.functions.Function1  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindBrowserActions$lambda$6(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Lkotlin/jvm/functions/Function1; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$BnW1i2miPiojtG0vpgY11K7juZc(android.view.View  android.widget.TextView  android.view.View  java.lang.String  android.content.Context  com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  android.view.View  kotlin.jvm.functions.Function1  android.content.res.ColorStateList  android.view.View  android.view.View  android.view.View)void
    .registers 12
    # ins_size=12
    invoke-static/range v0 ... v11, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindWebViewActions$lambda$21(Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Ljava/lang/String; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Landroid/view/View; Lkotlin/jvm/functions/Function1; Landroid/content/res/ColorStateList; Landroid/view/View; Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$E2U6AnyNCG9j3XDrpb4ntfjxD_Y(android.view.View  java.lang.String  android.view.View  com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  kotlin.jvm.functions.Function1  android.view.View  android.view.View  android.view.View)void
    .registers 8
    # ins_size=8
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindDesktopRedirectActions$lambda$25(Landroid/view/View; Ljava/lang/String; Landroid/view/View; Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Lkotlin/jvm/functions/Function1; Landroid/view/View; Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$MLp6umyghJ8Sms4Z7HQVG0lBdKY(android.view.View  java.lang.String  android.content.Context  com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  android.view.View  kotlin.jvm.functions.Function1  android.view.View  android.view.View  android.view.View)void
    .registers 9
    # ins_size=9
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindCustomAuthPollingActions$lambda$16(Landroid/view/View; Ljava/lang/String; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Landroid/view/View; Lkotlin/jvm/functions/Function1; Landroid/view/View; Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$PljLC0LzAwlHwMNvtg8_EKA67X4(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  java.lang.String  android.view.View  kotlin.jvm.functions.Function1  android.view.View  android.view.View  android.view.View  java.lang.String)kotlin.Unit
    .registers 8
    # ins_size=8
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindDesktopRedirectActions$lambda$25$lambda$24(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Ljava/lang/String; Landroid/view/View; Lkotlin/jvm/functions/Function1; Landroid/view/View; Landroid/view/View; Landroid/view/View; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$SFihFJsRTVYUL5Vh5zN1hwCXYvM(android.view.View  android.widget.TextView  android.view.View  java.lang.String  android.content.Context  android.content.res.ColorStateList  com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  kotlin.jvm.functions.Function1  android.view.View  android.view.View  android.view.View  android.view.View)void
    .registers 12
    # ins_size=12
    invoke-static/range v0 ... v11, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindBrowserActions$lambda$12(Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Ljava/lang/String; Landroid/content/Context; Landroid/content/res/ColorStateList; Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Lkotlin/jvm/functions/Function1; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$VH2W1Po4vGUG-WwqrygAjTTO_hM(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  java.lang.String  android.view.View  kotlin.jvm.functions.Function1  android.content.res.ColorStateList  android.view.View  android.view.View  android.view.View  android.view.View  android.widget.TextView  java.lang.String)kotlin.Unit
    .registers 11
    # ins_size=11
    invoke-static/range v0 ... v10, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindWebViewActions$lambda$21$lambda$20(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Ljava/lang/String; Landroid/view/View; Lkotlin/jvm/functions/Function1; Landroid/content/res/ColorStateList; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$VQiGHKln2cNd2vQ3eNqNOQav9us(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  java.lang.String  android.view.View  kotlin.jvm.functions.Function1  android.view.View  android.view.View  android.view.View  java.lang.String)kotlin.Unit
    .registers 8
    # ins_size=8
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindCustomAuthPollingActions$lambda$16$lambda$15(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Ljava/lang/String; Landroid/view/View; Lkotlin/jvm/functions/Function1; Landroid/view/View; Landroid/view/View; Landroid/view/View; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Xz3ZGUOODGbNTDtAReK20c7CYTQ(android.content.res.ColorStateList  android.view.View  java.lang.String  android.view.View  android.view.View  android.view.View  android.view.View  android.widget.TextView)void
    .registers 8
    # ins_size=8
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindWebViewActions$lambda$21$lambda$20$lambda$19(Landroid/content/res/ColorStateList; Landroid/view/View; Ljava/lang/String; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$YGAaQAuwMY89p52M_M4FKqkjh8I(java.lang.String  android.view.View  android.view.View  android.view.View  android.view.View)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindDesktopRedirectActions$lambda$25$lambda$24$lambda$23(Ljava/lang/String; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$e23BRBWN8S_GMtrGFWdkSgWdfxw(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  java.lang.String  android.view.View  kotlin.jvm.functions.Function1  android.content.res.ColorStateList  android.view.View  android.view.View  android.view.View  android.view.View  android.widget.TextView  java.lang.String)kotlin.Unit
    .registers 11
    # ins_size=11
    invoke-static/range v0 ... v10, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindBrowserActions$lambda$12$lambda$11(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Ljava/lang/String; Landroid/view/View; Lkotlin/jvm/functions/Function1; Landroid/content/res/ColorStateList; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$gbueAMl1-Q6LS8wCSR3IslBnkek(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  java.lang.String  android.view.View  kotlin.jvm.functions.Function1  android.view.View  android.view.View  android.view.View  java.lang.String)kotlin.Unit
    .registers 8
    # ins_size=8
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindQrCodeActions$lambda$5$lambda$4(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Ljava/lang/String; Landroid/view/View; Lkotlin/jvm/functions/Function1; Landroid/view/View; Landroid/view/View; Landroid/view/View; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$gjiCwjSmFLvL67DG6vwPOR2jgg0(android.view.View  java.lang.String  android.view.View  com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  kotlin.jvm.functions.Function1  android.view.View  android.view.View  android.view.View)void
    .registers 8
    # ins_size=8
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindQrCodeActions$lambda$5(Landroid/view/View; Ljava/lang/String; Landroid/view/View; Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Lkotlin/jvm/functions/Function1; Landroid/view/View; Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$hIygKx0puVj8El4JYqJqAKhcL_Y(android.content.res.ColorStateList  android.view.View  android.view.View  android.widget.TextView)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindBrowserActions$lambda$12$lambda$8(Landroid/content/res/ColorStateList; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$m6Jj29SxTFdbM2ZzG6lOdOvClCE(android.content.res.ColorStateList  android.view.View  java.lang.String  android.view.View  android.view.View  android.view.View  android.view.View  android.widget.TextView)void
    .registers 8
    # ins_size=8
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindBrowserActions$lambda$12$lambda$11$lambda$10(Landroid/content/res/ColorStateList; Landroid/view/View; Ljava/lang/String; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$o3Q8GBhnzAVQmlUVGUR1MG1jYEA(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  kotlin.jvm.functions.Function1  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindCustomAuthPollingActions$lambda$13(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Lkotlin/jvm/functions/Function1; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$rNfGzYyq1C0H2bl0qasD2vZgn6s(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  kotlin.jvm.functions.Function1  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindQrCodeActions$lambda$2(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Lkotlin/jvm/functions/Function1; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$uRvETkcLRyB0pAwHf9K6yLAyagw(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  kotlin.jvm.functions.Function1  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindWebViewActions$lambda$17(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Lkotlin/jvm/functions/Function1; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$y34JpBMNglqmKfged6dwlocXNKM(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  kotlin.jvm.functions.Function1  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindDesktopRedirectActions$lambda$22(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Lkotlin/jvm/functions/Function1; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->Companion Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final bindBrowserActions(android.content.Context  java.lang.String  android.view.View  android.view.View  android.view.View  android.view.View  android.view.View  kotlin.jvm.functions.Function1)void
    .registers 24
    # ins_size=9
    move-object/from16 v0, v18
    move-object/from16 v12, v19
    sget v1, Lcom/bytedance/trae/conversation/R$id;->pb_plugin_authorization_loading I
    move-object/from16 v10, v21
    invoke-virtual v10, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    instance-of v1, v12, Landroid/widget/TextView;
    const/4 v2, 0
    if-eqz v1, +007h
    move-object v1, v12
    check-cast v1, Landroid/widget/TextView;
    move-object v4, v1
    goto +2h
    move-object v4, v2
    if-eqz v4, +008h
    invoke-virtual v4, Landroid/widget/TextView;->getTextColors()Landroid/content/res/ColorStateList;
    move-result-object v1
    move-object v6, v1
    goto +2h
    move-object v6, v2
    if-eqz v0, +00eh
    new-instance v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda2;
    move-object v13, v15
    move-object/from16 v8, v23
    invoke-direct v1, v15, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    goto +4h
    move-object v13, v15
    move-object/from16 v8, v23
    if-eqz v12, +01bh
    new-instance v14, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda3;
    move-object v0, v14
    move-object/from16 v1, v19
    move-object v2, v4
    move-object/from16 v4, v17
    move-object/from16 v5, v16
    move-object v7, v15
    move-object/from16 v8, v23
    move-object/from16 v9, v20
    move-object/from16 v10, v21
    move-object/from16 v11, v22
    invoke-direct/range v0 ... v11, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda3;-><init>(Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Ljava/lang/String; Landroid/content/Context; Landroid/content/res/ColorStateList; Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Lkotlin/jvm/functions/Function1; Landroid/view/View; Landroid/view/View; Landroid/view/View;)V
    invoke-virtual v12, v14, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final bindBrowserActions$lambda$12(android.view.View  android.widget.TextView  android.view.View  java.lang.String  android.content.Context  android.content.res.ColorStateList  com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  kotlin.jvm.functions.Function1  android.view.View  android.view.View  android.view.View  android.view.View)void
    .registers 27
    # ins_size=12
    move-object v3, v15
    move-object/from16 v10, v16
    move-object/from16 v6, v17
    move-object/from16 v11, v18
    const/4 v0, 0
    invoke-virtual v15, v0, Landroid/view/View;->setEnabled(Z)V
    if-eqz v10, +005h
    invoke-virtual v10, v0, Landroid/widget/TextView;->setTextColor(I)V
    if-eqz v6, +005h
    invoke-virtual v6, v0, Landroid/view/View;->setVisibility(I)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string v1, "chat_hint"
    invoke-virtual v0, v11, v1, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthStart(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v12, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    new-instance v13, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda14;
    move-object/from16 v5, v20
    invoke-direct v13, v5, v6, v15, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda14;-><init>(Landroid/content/res/ColorStateList; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView;)V
    new-instance v14, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda15;
    move-object v0, v14
    move-object/from16 v1, v21
    move-object/from16 v2, v18
    move-object v3, v15
    move-object/from16 v4, v22
    move-object/from16 v6, v17
    move-object/from16 v7, v23
    move-object/from16 v8, v24
    move-object/from16 v9, v25
    move-object/from16 v10, v16
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda15;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Ljava/lang/String; Landroid/view/View; Lkotlin/jvm/functions/Function1; Landroid/content/res/ColorStateList; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView;)V
    move-object/from16 v0, v19
    invoke-virtual v12, v0, v11, v13, v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->startOAuth(Landroid/content/Context; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private static final bindBrowserActions$lambda$12$lambda$11(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  java.lang.String  android.view.View  kotlin.jvm.functions.Function1  android.content.res.ColorStateList  android.view.View  android.view.View  android.view.View  android.view.View  android.widget.TextView  java.lang.String)kotlin.Unit
    .registers 23
    # ins_size=11
    move-object v0, v12
    move-object/from16 v10, v22
    const-string/jumbo v1, status
    invoke-static v10, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "oauth"
    move-object v2, v13
    invoke-direct v12, v13, v10, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->reportAuthOutcome(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    new-instance v11, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda16;
    move-object v1, v11
    move-object/from16 v2, v16
    move-object/from16 v3, v17
    move-object/from16 v4, v22
    move-object/from16 v5, v18
    move-object/from16 v6, v19
    move-object/from16 v7, v20
    move-object v8, v14
    move-object/from16 v9, v21
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda16;-><init>(Landroid/content/res/ColorStateList; Landroid/view/View; Ljava/lang/String; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView;)V
    move-object v1, v14
    invoke-virtual v14, v11, Landroid/view/View;->post(Ljava/lang/Runnable;)Z
    invoke-direct v12, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->buildAuthorizationParams(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    move-object v1, v15
    invoke-interface v15, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final bindBrowserActions$lambda$12$lambda$11$lambda$10(android.content.res.ColorStateList  android.view.View  java.lang.String  android.view.View  android.view.View  android.view.View  android.view.View  android.widget.TextView)void
    .registers 8
    # ins_size=8
    if-eqz v0, +007h
    if-eqz v7, +005h
    invoke-virtual v7, v0, Landroid/widget/TextView;->setTextColor(Landroid/content/res/ColorStateList;)V
    const/16 v0, 8
    if-eqz v1, +005h
    invoke-virtual v1, v0, Landroid/view/View;->setVisibility(I)V
    const-string/jumbo v1, success
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +018h
    if-eqz v3, +005h
    invoke-virtual v3, v0, Landroid/view/View;->setVisibility(I)V
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_plugin_authorization_body I
    invoke-virtual v4, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    if-eqz v1, +005h
    invoke-virtual v1, v0, Landroid/view/View;->setVisibility(I)V
    if-eqz v5, +006h
    const/4 v0, 0
    invoke-virtual v5, v0, Landroid/view/View;->setVisibility(I)V
    const/4 v0, 1
    invoke-virtual v6, v0, Landroid/view/View;->setEnabled(Z)V
    return-void 
.end method

.method private static final bindBrowserActions$lambda$12$lambda$8(android.content.res.ColorStateList  android.view.View  android.view.View  android.widget.TextView)kotlin.Unit
    .registers 4
    # ins_size=4
    if-eqz v0, +005h
    invoke-virtual v3, v0, Landroid/widget/TextView;->setTextColor(Landroid/content/res/ColorStateList;)V
    if-eqz v1, +007h
    const/16 v0, 8
    invoke-virtual v1, v0, Landroid/view/View;->setVisibility(I)V
    const/4 v0, 1
    invoke-virtual v2, v0, Landroid/view/View;->setEnabled(Z)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final bindBrowserActions$lambda$6(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  kotlin.jvm.functions.Function1  android.view.View)void
    .registers 3
    # ins_size=3
    const-string/jumbo v2, user_cancel
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->buildAuthorizationParams(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private final bindCustomAuthPollingActions(android.content.Context  java.lang.String  android.view.View  android.view.View  android.view.View  android.view.View  android.view.View  kotlin.jvm.functions.Function1)void
    .registers 21
    # ins_size=9
    move-object v0, v15
    move-object/from16 v9, v16
    if-eqz v0, +00eh
    new-instance v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda9;
    move-object v10, v12
    move-object/from16 v6, v20
    invoke-direct v1, v12, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v15, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    goto +4h
    move-object v10, v12
    move-object/from16 v6, v20
    if-eqz v9, +018h
    new-instance v11, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda10;
    move-object v0, v11
    move-object/from16 v1, v16
    move-object v2, v14
    move-object v3, v13
    move-object v4, v12
    move-object/from16 v5, v18
    move-object/from16 v6, v20
    move-object/from16 v7, v17
    move-object/from16 v8, v19
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda10;-><init>(Landroid/view/View; Ljava/lang/String; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Landroid/view/View; Lkotlin/jvm/functions/Function1; Landroid/view/View; Landroid/view/View;)V
    invoke-virtual v9, v11, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final bindCustomAuthPollingActions$lambda$13(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  kotlin.jvm.functions.Function1  android.view.View)void
    .registers 3
    # ins_size=3
    sget-object v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->cancelCustomAuthPolling()V
    const-string/jumbo v2, user_cancel
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->buildAuthorizationParams(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private static final bindCustomAuthPollingActions$lambda$16(android.view.View  java.lang.String  android.content.Context  com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  android.view.View  kotlin.jvm.functions.Function1  android.view.View  android.view.View  android.view.View)void
    .registers 20
    # ins_size=9
    move-object v8, v12
    const/4 v0, 0
    move-object v7, v11
    invoke-virtual v11, v0, Landroid/view/View;->setEnabled(Z)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string v1, "chat_hint"
    invoke-virtual v0, v12, v1, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthStart(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v9, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    new-instance v10, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda1;
    move-object v0, v10
    move-object v1, v14
    move-object v2, v12
    move-object v3, v15
    move-object/from16 v4, v16
    move-object/from16 v5, v17
    move-object/from16 v6, v18
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Ljava/lang/String; Landroid/view/View; Lkotlin/jvm/functions/Function1; Landroid/view/View; Landroid/view/View; Landroid/view/View;)V
    move-object v0, v13
    invoke-virtual v9, v13, v12, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->startCustomAuthPollingAuth(Landroid/content/Context; Ljava/lang/String; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private static final bindCustomAuthPollingActions$lambda$16$lambda$15(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  java.lang.String  android.view.View  kotlin.jvm.functions.Function1  android.view.View  android.view.View  android.view.View  java.lang.String)kotlin.Unit
    .registers 15
    # ins_size=8
    const-string/jumbo v0, status
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "oauth"
    invoke-direct v7, v8, v14, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->reportAuthOutcome(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    new-instance v8, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda18;
    move-object v1, v8
    move-object v2, v14
    move-object v3, v11
    move-object v4, v9
    move-object v5, v12
    move-object v6, v13
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda18;-><init>(Ljava/lang/String; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View;)V
    invoke-virtual v9, v8, Landroid/view/View;->post(Ljava/lang/Runnable;)Z
    invoke-direct v7, v14, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->buildAuthorizationParams(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    invoke-interface v10, v7, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method

.method private static final bindCustomAuthPollingActions$lambda$16$lambda$15$lambda$14(java.lang.String  android.view.View  android.view.View  android.view.View  android.view.View)void
    .registers 6
    # ins_size=5
    const-string/jumbo v0, success
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +01ah
    const/16 v1, 8
    if-eqz v2, +005h
    invoke-virtual v2, v1, Landroid/view/View;->setVisibility(I)V
    sget v2, Lcom/bytedance/trae/conversation/R$id;->tv_plugin_authorization_body I
    invoke-virtual v3, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    if-eqz v2, +005h
    invoke-virtual v2, v1, Landroid/view/View;->setVisibility(I)V
    if-eqz v4, +006h
    const/4 v1, 0
    invoke-virtual v4, v1, Landroid/view/View;->setVisibility(I)V
    const/4 v1, 1
    invoke-virtual v5, v1, Landroid/view/View;->setEnabled(Z)V
    return-void 
.end method

.method private final bindDesktopRedirectActions(android.content.Context  android.view.View  java.lang.String  android.view.View  android.view.View  android.view.View  android.view.View  kotlin.jvm.functions.Function1)void
    .registers 20
    # ins_size=9
    move-object v0, v15
    move-object/from16 v8, v16
    if-eqz v0, +00eh
    new-instance v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda4;
    move-object v9, v11
    move-object/from16 v5, v19
    invoke-direct v1, v11, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v15, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    goto +4h
    move-object v9, v11
    move-object/from16 v5, v19
    if-eqz v8, +016h
    new-instance v10, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda5;
    move-object v0, v10
    move-object/from16 v1, v16
    move-object v2, v14
    move-object v3, v13
    move-object v4, v11
    move-object/from16 v5, v19
    move-object/from16 v6, v17
    move-object/from16 v7, v18
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda5;-><init>(Landroid/view/View; Ljava/lang/String; Landroid/view/View; Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Lkotlin/jvm/functions/Function1; Landroid/view/View; Landroid/view/View;)V
    invoke-virtual v8, v10, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final bindDesktopRedirectActions$lambda$22(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  kotlin.jvm.functions.Function1  android.view.View)void
    .registers 3
    # ins_size=3
    const-string/jumbo v2, user_cancel
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->buildAuthorizationParams(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private static final bindDesktopRedirectActions$lambda$25(android.view.View  java.lang.String  android.view.View  com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  kotlin.jvm.functions.Function1  android.view.View  android.view.View  android.view.View)void
    .registers 19
    # ins_size=8
    move-object v7, v11
    move-object v2, v12
    move-object v1, v14
    const/4 v0, 0
    invoke-virtual v11, v0, Landroid/view/View;->setEnabled(Z)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string v3, "chat_hint"
    invoke-virtual v0, v12, v3, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthStart(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v13, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    instance-of v3, v0, Landroidx/fragment/app/FragmentActivity;
    const/4 v4, 0
    if-eqz v3, +006h
    check-cast v0, Landroidx/fragment/app/FragmentActivity;
    move-object v8, v0
    goto +2h
    move-object v8, v4
    const/4 v0, 1
    if-nez v8, +00dh
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string v3, "host_activity_not_found"
    invoke-virtual v1, v12, v3, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v11, v0, Landroid/view/View;->setEnabled(Z)V
    return-void 
    invoke-virtual v13, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v3
    const-string v5, "getContext(...)"
    invoke-static v3, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v14, v3, v12, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->getLocalizedProviderName(Landroid/content/Context; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    sget-object v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->Companion Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$Companion;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->descriptor Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;
    if-eqz v6, +006h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->getProviderDisplayName()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +004h
    const-string v4, ""
    invoke-virtual v5, v12, v4, v3, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$Companion;->newInstance(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I)Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;
    move-result-object v9
    new-instance v10, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda20;
    move-object v0, v10
    move-object v1, v14
    move-object v2, v12
    move-object v3, v13
    move-object v4, v15
    move-object/from16 v5, v16
    move-object/from16 v6, v17
    move-object v7, v11
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda20;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Ljava/lang/String; Landroid/view/View; Lkotlin/jvm/functions/Function1; Landroid/view/View; Landroid/view/View; Landroid/view/View;)V
    invoke-virtual v9, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->setOnAuthResult(Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v8, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string v1, "PluginAuthorizationBottomSheet"
    invoke-virtual v9, v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    return-void 
.end method

.method private static final bindDesktopRedirectActions$lambda$25$lambda$24(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  java.lang.String  android.view.View  kotlin.jvm.functions.Function1  android.view.View  android.view.View  android.view.View  java.lang.String)kotlin.Unit
    .registers 15
    # ins_size=8
    const-string/jumbo v0, status
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "desktop_redirect"
    invoke-direct v7, v8, v14, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->reportAuthOutcome(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    new-instance v8, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda19;
    move-object v1, v8
    move-object v2, v14
    move-object v3, v11
    move-object v4, v9
    move-object v5, v12
    move-object v6, v13
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda19;-><init>(Ljava/lang/String; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View;)V
    invoke-virtual v9, v8, Landroid/view/View;->post(Ljava/lang/Runnable;)Z
    invoke-direct v7, v14, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->buildAuthorizationParams(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    invoke-interface v10, v7, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method

.method private static final bindDesktopRedirectActions$lambda$25$lambda$24$lambda$23(java.lang.String  android.view.View  android.view.View  android.view.View  android.view.View)void
    .registers 6
    # ins_size=5
    const-string/jumbo v0, success
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +01ah
    const/16 v1, 8
    if-eqz v2, +005h
    invoke-virtual v2, v1, Landroid/view/View;->setVisibility(I)V
    sget v2, Lcom/bytedance/trae/conversation/R$id;->tv_plugin_authorization_body I
    invoke-virtual v3, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    if-eqz v2, +005h
    invoke-virtual v2, v1, Landroid/view/View;->setVisibility(I)V
    if-eqz v4, +006h
    const/4 v1, 0
    invoke-virtual v4, v1, Landroid/view/View;->setVisibility(I)V
    const/4 v1, 1
    invoke-virtual v5, v1, Landroid/view/View;->setEnabled(Z)V
    return-void 
.end method

.method private final bindQrCodeActions(android.view.View  java.lang.String  android.view.View  android.view.View  android.view.View  android.view.View  kotlin.jvm.functions.Function1)void
    .registers 19
    # ins_size=8
    move-object v0, v14
    move-object v8, v15
    if-eqz v0, +00eh
    new-instance v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda6;
    move-object v9, v11
    move-object/from16 v5, v18
    invoke-direct v1, v11, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v14, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    goto +4h
    move-object v9, v11
    move-object/from16 v5, v18
    if-eqz v8, +015h
    new-instance v10, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda7;
    move-object v0, v10
    move-object v1, v15
    move-object v2, v13
    move-object v3, v12
    move-object v4, v11
    move-object/from16 v5, v18
    move-object/from16 v6, v16
    move-object/from16 v7, v17
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda7;-><init>(Landroid/view/View; Ljava/lang/String; Landroid/view/View; Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Lkotlin/jvm/functions/Function1; Landroid/view/View; Landroid/view/View;)V
    invoke-virtual v15, v10, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final bindQrCodeActions$lambda$2(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  kotlin.jvm.functions.Function1  android.view.View)void
    .registers 3
    # ins_size=3
    sget-object v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->cancelQrCodeAuth()V
    const-string/jumbo v2, user_cancel
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->buildAuthorizationParams(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private static final bindQrCodeActions$lambda$5(android.view.View  java.lang.String  android.view.View  com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  kotlin.jvm.functions.Function1  android.view.View  android.view.View  android.view.View)void
    .registers 21
    # ins_size=8
    move-object v7, v13
    move-object v8, v14
    move-object/from16 v9, v16
    const/4 v0, 0
    invoke-virtual v13, v0, Landroid/view/View;->setEnabled(Z)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string v1, "chat_hint"
    invoke-virtual v0, v14, v1, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthStart(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v15, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    instance-of v1, v0, Landroidx/fragment/app/FragmentActivity;
    const/4 v2, 0
    if-eqz v1, +006h
    check-cast v0, Landroidx/fragment/app/FragmentActivity;
    move-object v10, v0
    goto +2h
    move-object v10, v2
    if-nez v10, +00eh
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string v1, "host_activity_not_found"
    invoke-virtual v0, v14, v1, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v0, 1
    invoke-virtual v13, v0, Landroid/view/View;->setEnabled(Z)V
    return-void 
    invoke-virtual v15, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    const-string v1, "getContext(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v9, v0, v14, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->getLocalizedProviderName(Landroid/content/Context; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    sget-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->Companion Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$Companion;
    iget-object v1, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->descriptor Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;
    if-eqz v1, +006h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->getProviderDisplayName()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +005h
    const-string v1, ""
    move-object v2, v1
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object v1, v14
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$Companion;->newInstance$default(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$Companion; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;
    move-result-object v11
    new-instance v12, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda0;
    move-object v0, v12
    move-object/from16 v1, v16
    move-object v2, v14
    move-object v3, v15
    move-object/from16 v4, v17
    move-object/from16 v5, v18
    move-object/from16 v6, v19
    move-object v7, v13
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Ljava/lang/String; Landroid/view/View; Lkotlin/jvm/functions/Function1; Landroid/view/View; Landroid/view/View; Landroid/view/View;)V
    invoke-virtual v11, v12, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->setOnAuthResult(Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v10, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string v1, "PluginAuthorizationBottomSheet"
    invoke-virtual v11, v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    return-void 
.end method

.method private static final bindQrCodeActions$lambda$5$lambda$4(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  java.lang.String  android.view.View  kotlin.jvm.functions.Function1  android.view.View  android.view.View  android.view.View  java.lang.String)kotlin.Unit
    .registers 15
    # ins_size=8
    const-string/jumbo v0, status
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "bot_scan"
    invoke-direct v7, v8, v14, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->reportAuthOutcome(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    new-instance v8, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda12;
    move-object v1, v8
    move-object v2, v14
    move-object v3, v11
    move-object v4, v9
    move-object v5, v12
    move-object v6, v13
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda12;-><init>(Ljava/lang/String; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View;)V
    invoke-virtual v9, v8, Landroid/view/View;->post(Ljava/lang/Runnable;)Z
    invoke-direct v7, v14, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->buildAuthorizationParams(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    invoke-interface v10, v7, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method

.method private static final bindQrCodeActions$lambda$5$lambda$4$lambda$3(java.lang.String  android.view.View  android.view.View  android.view.View  android.view.View)void
    .registers 6
    # ins_size=5
    const-string/jumbo v0, success
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +01ah
    const/16 v1, 8
    if-eqz v2, +005h
    invoke-virtual v2, v1, Landroid/view/View;->setVisibility(I)V
    sget v2, Lcom/bytedance/trae/conversation/R$id;->tv_plugin_authorization_body I
    invoke-virtual v3, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    if-eqz v2, +005h
    invoke-virtual v2, v1, Landroid/view/View;->setVisibility(I)V
    if-eqz v4, +006h
    const/4 v1, 0
    invoke-virtual v4, v1, Landroid/view/View;->setVisibility(I)V
    const/4 v1, 1
    invoke-virtual v5, v1, Landroid/view/View;->setEnabled(Z)V
    return-void 
.end method

.method private final bindWebViewActions(android.content.Context  java.lang.String  android.view.View  android.view.View  android.view.View  android.view.View  android.view.View  kotlin.jvm.functions.Function1)void
    .registers 24
    # ins_size=9
    move-object/from16 v0, v18
    move-object/from16 v12, v19
    sget v1, Lcom/bytedance/trae/conversation/R$id;->pb_plugin_authorization_loading I
    move-object/from16 v7, v21
    invoke-virtual v7, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    instance-of v1, v12, Landroid/widget/TextView;
    const/4 v2, 0
    if-eqz v1, +007h
    move-object v1, v12
    check-cast v1, Landroid/widget/TextView;
    move-object v4, v1
    goto +2h
    move-object v4, v2
    if-eqz v4, +008h
    invoke-virtual v4, Landroid/widget/TextView;->getTextColors()Landroid/content/res/ColorStateList;
    move-result-object v1
    move-object v9, v1
    goto +2h
    move-object v9, v2
    if-eqz v0, +00eh
    new-instance v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda11;
    move-object v13, v15
    move-object/from16 v8, v23
    invoke-direct v1, v15, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda11;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    goto +4h
    move-object v13, v15
    move-object/from16 v8, v23
    if-eqz v12, +01bh
    new-instance v14, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;
    move-object v0, v14
    move-object/from16 v1, v19
    move-object v2, v4
    move-object/from16 v4, v17
    move-object/from16 v5, v16
    move-object v6, v15
    move-object/from16 v7, v21
    move-object/from16 v8, v23
    move-object/from16 v10, v20
    move-object/from16 v11, v22
    invoke-direct/range v0 ... v11, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;-><init>(Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Ljava/lang/String; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Landroid/view/View; Lkotlin/jvm/functions/Function1; Landroid/content/res/ColorStateList; Landroid/view/View; Landroid/view/View;)V
    invoke-virtual v12, v14, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final bindWebViewActions$lambda$17(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  kotlin.jvm.functions.Function1  android.view.View)void
    .registers 3
    # ins_size=3
    sget-object v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->cancelWebViewAuth()V
    const-string/jumbo v2, user_cancel
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->buildAuthorizationParams(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private static final bindWebViewActions$lambda$21(android.view.View  android.widget.TextView  android.view.View  java.lang.String  android.content.Context  com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  android.view.View  kotlin.jvm.functions.Function1  android.content.res.ColorStateList  android.view.View  android.view.View  android.view.View)void
    .registers 26
    # ins_size=12
    move-object v10, v15
    move-object/from16 v6, v16
    move-object/from16 v11, v17
    const/4 v0, 0
    move-object v9, v14
    invoke-virtual v14, v0, Landroid/view/View;->setEnabled(Z)V
    if-eqz v10, +005h
    invoke-virtual v15, v0, Landroid/widget/TextView;->setTextColor(I)V
    if-eqz v6, +005h
    invoke-virtual v6, v0, Landroid/view/View;->setVisibility(I)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string v1, "chat_hint"
    invoke-virtual v0, v11, v1, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthStart(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v12, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    new-instance v13, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda8;
    move-object v0, v13
    move-object/from16 v1, v19
    move-object/from16 v2, v17
    move-object/from16 v3, v20
    move-object/from16 v4, v21
    move-object/from16 v5, v22
    move-object/from16 v6, v16
    move-object/from16 v7, v23
    move-object/from16 v8, v24
    move-object v9, v14
    move-object v10, v15
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Ljava/lang/String; Landroid/view/View; Lkotlin/jvm/functions/Function1; Landroid/content/res/ColorStateList; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView;)V
    move-object/from16 v0, v18
    invoke-virtual v12, v0, v11, v13, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->startWebViewAuth(Landroid/content/Context; Ljava/lang/String; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private static final bindWebViewActions$lambda$21$lambda$20(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  java.lang.String  android.view.View  kotlin.jvm.functions.Function1  android.content.res.ColorStateList  android.view.View  android.view.View  android.view.View  android.view.View  android.widget.TextView  java.lang.String)kotlin.Unit
    .registers 23
    # ins_size=11
    move-object v0, v12
    move-object/from16 v10, v22
    const-string/jumbo v1, status
    invoke-static v10, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, webview
    move-object v2, v13
    invoke-direct v12, v13, v10, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->reportAuthOutcome(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    new-instance v11, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda17;
    move-object v1, v11
    move-object/from16 v2, v16
    move-object/from16 v3, v17
    move-object/from16 v4, v22
    move-object/from16 v5, v18
    move-object v6, v14
    move-object/from16 v7, v19
    move-object/from16 v8, v20
    move-object/from16 v9, v21
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda17;-><init>(Landroid/content/res/ColorStateList; Landroid/view/View; Ljava/lang/String; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView;)V
    move-object v1, v14
    invoke-virtual v14, v11, Landroid/view/View;->post(Ljava/lang/Runnable;)Z
    invoke-direct v12, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->buildAuthorizationParams(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    move-object v1, v15
    invoke-interface v15, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final bindWebViewActions$lambda$21$lambda$20$lambda$19(android.content.res.ColorStateList  android.view.View  java.lang.String  android.view.View  android.view.View  android.view.View  android.view.View  android.widget.TextView)void
    .registers 8
    # ins_size=8
    if-eqz v0, +007h
    if-eqz v7, +005h
    invoke-virtual v7, v0, Landroid/widget/TextView;->setTextColor(Landroid/content/res/ColorStateList;)V
    const/16 v0, 8
    if-eqz v1, +005h
    invoke-virtual v1, v0, Landroid/view/View;->setVisibility(I)V
    const-string/jumbo v1, success
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +018h
    if-eqz v3, +005h
    invoke-virtual v3, v0, Landroid/view/View;->setVisibility(I)V
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_plugin_authorization_body I
    invoke-virtual v4, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    if-eqz v1, +005h
    invoke-virtual v1, v0, Landroid/view/View;->setVisibility(I)V
    if-eqz v5, +006h
    const/4 v0, 0
    invoke-virtual v5, v0, Landroid/view/View;->setVisibility(I)V
    const/4 v0, 1
    invoke-virtual v6, v0, Landroid/view/View;->setEnabled(Z)V
    return-void 
.end method

.method private final buildAuthorizationParams(java.lang.String)java.lang.String
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->originalParams Lcom/google/gson/JsonObject;
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/google/gson/JsonObject;->deepCopy()Lcom/google/gson/JsonObject;
    move-result-object v0
    if-nez v0, +007h
    new-instance v0, Lcom/google/gson/JsonObject;
    invoke-direct v0, Lcom/google/gson/JsonObject;-><init>()V
    new-instance v1, Lcom/google/gson/JsonObject;
    invoke-direct v1, Lcom/google/gson/JsonObject;-><init>()V
    const-string/jumbo v2, status
    invoke-virtual v1, v2, v4, Lcom/google/gson/JsonObject;->addProperty(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "auth_scope_mode"
    const-string v2, "all"
    invoke-virtual v1, v4, v2, Lcom/google/gson/JsonObject;->addProperty(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v4, Lcom/google/gson/JsonArray;
    invoke-direct v4, Lcom/google/gson/JsonArray;-><init>()V
    check-cast v4, Lcom/google/gson/JsonElement;
    const-string/jumbo v2, scope_results
    invoke-virtual v1, v2, v4, Lcom/google/gson/JsonObject;->add(Ljava/lang/String; Lcom/google/gson/JsonElement;)V
    const-string v4, "authorization_result"
    check-cast v1, Lcom/google/gson/JsonElement;
    invoke-virtual v0, v4, v1, Lcom/google/gson/JsonObject;->add(Ljava/lang/String; Lcom/google/gson/JsonElement;)V
    new-instance v4, Lcom/google/gson/Gson;
    invoke-direct v4, Lcom/google/gson/Gson;-><init>()V
    check-cast v0, Lcom/google/gson/JsonElement;
    invoke-virtual v4, v0, Lcom/google/gson/Gson;->toJson(Lcom/google/gson/JsonElement;)Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v0, toJson(...)
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v4
.end method

.method private final getLocalizedProviderName(android.content.Context  java.lang.String)java.lang.String
    .registers 6
    # ins_size=3
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->descriptor Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;
    const/4 v1, 0
    if-eqz v0, +00fh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->getPluginName()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +009h
    sget-object v2, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->INSTANCE Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->getCachedLocalizedDisplayName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    if-nez v2, +003h
    return-object v0
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    const-string v2, "ROOT"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Ljava/lang/String;->hashCode()I
    move-result v0
    const v2, 113006579
    if-eq v0, v2, +026h
    const v2, 133862058
    if-eq v0, v2, +015h
    const v2, 136221635
    if-eq v0, v2, +003h
    goto +2fh
    const-string/jumbo v0, tencent-docs
    invoke-virtual v5, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    goto +25h
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_plugin_provider_name_tencent_docs I
    goto +18h
    const-string v0, "dingtalk"
    invoke-virtual v5, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    goto +19h
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_plugin_provider_name_dingtalk I
    goto +ch
    const-string/jumbo v0, wecom
    invoke-virtual v5, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +00eh
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_plugin_provider_name_wecom I
    invoke-virtual v4, v5, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v4
    const-string v5, "getString(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v4
    iget-object v4, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->descriptor Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;
    if-eqz v4, +006h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->getProviderDisplayName()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    const-string v1, ""
    return-object v1
.end method

.method private final getProviderIconRes(java.lang.String)int
    .registers 4
    # ins_size=2
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    const-string v1, "ROOT"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Ljava/lang/String;->hashCode()I
    move-result v0
    const v1, 113006579
    if-eq v0, v1, +026h
    const v1, 133862058
    if-eq v0, v1, +015h
    const v1, 136221635
    if-eq v0, v1, +003h
    goto +26h
    const-string/jumbo v0, tencent-docs
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +1ch
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_plugin_auth_tencent_docs_logo I
    goto +1bh
    const-string v0, "dingtalk"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +10h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_plugin_auth_dingtalk_logo I
    goto +fh
    const-string/jumbo v0, wecom
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +005h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_plugin_auth_wecom_logo I
    goto +3h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_plugin_auth_link_connector I
    return v3
.end method

.method private final reportAuthOutcome(java.lang.String  java.lang.String  java.lang.String)void
    .registers 14
    # ins_size=4
    iget-object v0, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->descriptor Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->getPluginName()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    move-object v2, v0
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->authDurationMs()J
    move-result-wide v8
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string/jumbo v0, success
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +004h
    move-object v4, v0
    goto +4h
    const-string v3, "cancel"
    move-object v4, v3
    const/4 v5, 0
    const/16 v6, 8
    const/4 v7, 0
    move-object v3, v11
    invoke-static/range v1 ... v7, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthResult$default(Lcom/bytedance/trae/conversation/tracker/PluginTracker; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +008h
    sget-object v12, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    invoke-virtual v12, v11, v8, v9, v13, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthSuccess(Ljava/lang/String; J Ljava/lang/String;)V
    goto +6h
    sget-object v13, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    invoke-virtual v13, v11, v12, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public bindActions(android.view.View  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->bindActions(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Landroid/view/View; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public bindActions(android.view.View  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1)void
    .registers 15
    # ins_size=5
    const-string v0, "contentView"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onConfirm"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v12, "onSkip"
    invoke-static v13, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v12, "onConfirmWithParams"
    invoke-static v14, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v1
    iget-object v12, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->descriptor Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;
    const/4 v13, 0
    if-eqz v12, +007h
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->getProviderRaw()Ljava/lang/String;
    move-result-object v12
    goto +2h
    move-object v12, v13
    const-string v0, ""
    if-nez v12, +004h
    move-object v4, v0
    goto +2h
    move-object v4, v12
    sget v12, Lcom/bytedance/trae/conversation/R$id;->btn_plugin_authorization_cancel I
    invoke-virtual v11, v12, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    sget v12, Lcom/bytedance/trae/conversation/R$id;->btn_plugin_authorization_authorize I
    invoke-virtual v11, v12, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    sget v12, Lcom/bytedance/trae/conversation/R$id;->layout_plugin_authorization_actions I
    invoke-virtual v11, v12, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v7
    sget v12, Lcom/bytedance/trae/conversation/R$id;->layout_plugin_authorization_success I
    invoke-virtual v11, v12, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v8
    sget v12, Lcom/bytedance/trae/conversation/R$id;->tv_plugin_authorization_success_name I
    invoke-virtual v11, v12, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v12
    check-cast v12, Landroid/widget/TextView;
    if-eqz v12, +01bh
    iget-object v2, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->resolvedName Ljava/lang/String;
    if-eqz v2, +005h
    check-cast v2, Ljava/lang/CharSequence;
    goto +10h
    iget-object v2, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->descriptor Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;
    if-eqz v2, +006h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->getPluginDisplayName()Ljava/lang/String;
    move-result-object v13
    if-nez v13, +003h
    goto +2h
    move-object v0, v13
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v12, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget-object v12, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-virtual v12, v4, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->isDesktopRedirectProvider(Ljava/lang/String;)Z
    move-result v12
    if-eqz v12, +012h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v0, v10
    move-object v2, v11
    move-object v3, v4
    move-object v4, v5
    move-object v5, v6
    move-object v6, v7
    move-object v7, v8
    move-object v8, v14
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindDesktopRedirectActions(Landroid/content/Context; Landroid/view/View; Ljava/lang/String; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View; Lkotlin/jvm/functions/Function1;)V
    goto/16 +04dh
    sget-object v12, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-virtual v12, v4, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->isQrCodeProvider(Ljava/lang/String;)Z
    move-result v12
    if-eqz v12, +009h
    move-object v2, v10
    move-object v3, v11
    move-object v9, v14
    invoke-direct/range v2 ... v9, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindQrCodeActions(Landroid/view/View; Ljava/lang/String; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View; Lkotlin/jvm/functions/Function1;)V
    goto +3dh
    sget-object v12, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-virtual v12, v4, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->isCustomAuthPollingProvider(Ljava/lang/String;)Z
    move-result v12
    if-eqz v12, +011h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v0, v10
    move-object v2, v4
    move-object v3, v5
    move-object v4, v6
    move-object v5, v7
    move-object v6, v11
    move-object v7, v8
    move-object v8, v14
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindCustomAuthPollingActions(Landroid/content/Context; Ljava/lang/String; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View; Lkotlin/jvm/functions/Function1;)V
    goto +26h
    sget-object v12, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-virtual v12, v4, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->isWebViewProvider(Ljava/lang/String;)Z
    move-result v12
    if-eqz v12, +011h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v0, v10
    move-object v2, v4
    move-object v3, v5
    move-object v4, v6
    move-object v5, v7
    move-object v6, v11
    move-object v7, v8
    move-object v8, v14
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindWebViewActions(Landroid/content/Context; Ljava/lang/String; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View; Lkotlin/jvm/functions/Function1;)V
    goto +fh
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v0, v10
    move-object v2, v4
    move-object v3, v5
    move-object v4, v6
    move-object v5, v7
    move-object v6, v11
    move-object v7, v8
    move-object v8, v14
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->bindBrowserActions(Landroid/content/Context; Ljava/lang/String; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public createContentView(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.im.model.ConfirmInfo)android.view.View
    .registers 8
    # ins_size=4
    const-string v7, "context"
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v7, toolCallInfo
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v7, 0
    iput-object v7, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->resolvedName Ljava/lang/String;
    iput-object v7, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->resolvedNameForPlugin Ljava/lang/String;
    sget-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->Companion Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor$Companion;
    invoke-virtual v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor$Companion;->from(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;
    move-result-object v0
    iput-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->descriptor Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v6
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/google/gson/JsonObject;->deepCopy()Lcom/google/gson/JsonObject;
    move-result-object v6
    goto +2h
    move-object v6, v7
    iput-object v6, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->originalParams Lcom/google/gson/JsonObject;
    iget-object v6, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->descriptor Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->getProviderRaw()Ljava/lang/String;
    invoke-static v5, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v6
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_plugin_authorization_checkpoint_content I
    const/4 v1, 0
    invoke-virtual v6, v0, v7, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v6
    sget v7, Lcom/bytedance/trae/conversation/R$id;->tv_plugin_authorization_body I
    invoke-virtual v6, v7, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v7
    check-cast v7, Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_plugin_authorization_body I
    const/4 v2, 1
    new-array v2, v2, [Ljava/lang/Object;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->descriptor Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->getProviderRaw()Ljava/lang/String;
    move-result-object v3
    invoke-direct v4, v5, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->getLocalizedProviderName(Landroid/content/Context; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    aput-object v3, v2, v1
    invoke-virtual v5, v0, v2, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v7, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const-string v5, "also(...)"
    invoke-static v6, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v6
.end method

.method public getCHECK_POINT_TAG()java.lang.String
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getCHECK_POINT_TAG(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getContentTopMarginDp()int
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getContentTopMarginDp(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)I
    move-result v0
    return v0
.end method

.method public getContentTopMarginRes()int
    .registers 2
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$dimen;->trae_plugin_authorization_title_body_gap I
    return v0
.end method

.method public getHeaderLabel(android.content.Context)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    return-object v2
.end method

.method public getPrimaryButtonBackgroundRes()int
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getPrimaryButtonBackgroundRes(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)I
    move-result v0
    return v0
.end method

.method public getPrimaryButtonText(android.content.Context)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_plugin_authorization_authorize I
    invoke-virtual v2, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    const-string v0, "getString(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public getSecondaryButtonText(android.content.Context)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_plugin_authorization_cancel I
    invoke-virtual v2, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    const-string v0, "getString(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public getTitle(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo)java.lang.String
    .registers 7
    # ins_size=3
    const-string v0, "context"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolCallInfo
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->Companion Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor$Companion;
    invoke-virtual v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor$Companion;->from(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;
    move-result-object v0
    iput-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->descriptor Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->originalParams Lcom/google/gson/JsonObject;
    const/4 v2, 0
    if-nez v1, +010h
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v6
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/google/gson/JsonObject;->deepCopy()Lcom/google/gson/JsonObject;
    move-result-object v6
    goto +2h
    move-object v6, v2
    iput-object v6, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->originalParams Lcom/google/gson/JsonObject;
    iget-object v6, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->resolvedName Ljava/lang/String;
    if-eqz v6, +012h
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->resolvedNameForPlugin Ljava/lang/String;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->getPluginName()Ljava/lang/String;
    move-result-object v3
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    move-object v2, v6
    if-eqz v2, +003h
    goto +9h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->getProviderRaw()Ljava/lang/String;
    move-result-object v6
    invoke-direct v4, v5, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->getLocalizedProviderName(Landroid/content/Context; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_plugin_authorization_title I
    const/4 v0, 1
    new-array v0, v0, [Ljava/lang/Object;
    const/4 v1, 0
    aput-object v2, v0, v1
    invoke-virtual v5, v6, v0, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    const-string v6, "getString(...)"
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v5
.end method

.method public getTitleLetterSpacing()float
    .registers 2
    # ins_size=1
    const v0, -1127267854
    return v0
.end method

.method public getTitleTextColorRes()int
    .registers 2
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$color;->trae_plugin_authorization_title_text I
    return v0
.end method

.method public hideDefaultButtons()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method

.method public setFileClickListener(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->setFileClickListener(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public setResolvedDisplayName(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->resolvedName Ljava/lang/String;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->descriptor Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->getPluginName()Ljava/lang/String;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->resolvedNameForPlugin Ljava/lang/String;
    return-void 
.end method

.method public showCloseButton()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method
