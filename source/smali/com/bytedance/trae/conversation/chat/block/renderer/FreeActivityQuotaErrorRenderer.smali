# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer;
.super Ljava/lang/Object;
.source "FreeActivityQuotaErrorRenderer.kt"

.implements Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;

.field public static final BLOCK_TAG:Ljava/lang/String;
.field private static final Companion:Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer$Companion;
.field private isToAppLog:Z


.method public static synthetic $r8$lambda$9qUidxpFKVjgYwU88IxmkF9jdl4(long[]  com.bytedance.trae.conversation.chat.block.AgentContentBlock$FreeActivityQuotaError  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer;->render$lambda$11([J Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final buildFreeActivityQuotaMessage(android.content.Context  com.google.gson.JsonObject  boolean)java.lang.String
    .registers 10
    # ins_size=4
    invoke-virtual v7, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    const-string v1, "dimension"
    invoke-virtual v8, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v8
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v8, +011h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->isJsonNull()Z
    move-result v3
    xor-int/2addr v3, v2
    if-eqz v3, +003h
    goto +2h
    move-object v8, v1
    if-eqz v8, +006h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v1
    const-string v8, "Let's call it a day. Get some rest and we'll pick this back up tomorrow!"
    const-string v3, "monthly"
    const-string/jumbo v4, weekly
    const/4 v5, 0
    if-eqz v9, +058h
    invoke-direct v6, v7, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer;->formatResetDate(Landroid/content/Context; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    check-cast v1, Ljava/lang/CharSequence;
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v1, v4, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence; Ljava/lang/CharSequence;)Z
    move-result v9
    if-eqz v9, +005h
    sget v9, Lcom/bytedance/trae/multilanguage/R$string;->imkit_weekly_limit_canuse I
    goto +eh
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v1, v3, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence; Ljava/lang/CharSequence;)Z
    move-result v9
    if-eqz v9, +005h
    sget v9, Lcom/bytedance/trae/multilanguage/R$string;->imkit_monthly_limit_canuse I
    goto +3h
    sget v9, Lcom/bytedance/trae/multilanguage/R$string;->imkit_daily_limit_canuse I
    sget-object v1, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    new-array v3, v2, [Ljava/lang/Object;
    aput-object v7, v3, v5
    invoke-virtual v1, v0, v9, v3, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    check-cast v7, Ljava/lang/CharSequence;
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v9
    if-nez v9, +004h
    move v9, v2
    goto +2h
    move v9, v5
    if-eqz v9, +01dh
    sget-object v7, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget v9, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_free_activity_quota I
    new-array v1, v5, [Ljava/lang/Object;
    invoke-virtual v7, v0, v9, v1, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    check-cast v7, Ljava/lang/CharSequence;
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v9
    if-nez v9, +003h
    goto +2h
    move v2, v5
    if-eqz v2, +003h
    goto +2h
    move-object v8, v7
    move-object v7, v8
    check-cast v7, Ljava/lang/String;
    check-cast v7, Ljava/lang/String;
    return-object v7
    invoke-direct v6, v7, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer;->formatResetDate(Landroid/content/Context; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    check-cast v1, Ljava/lang/CharSequence;
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v1, v4, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence; Ljava/lang/CharSequence;)Z
    move-result v9
    if-eqz v9, +005h
    sget v9, Lcom/bytedance/trae/multilanguage/R$string;->imkit_weekly_limit_cannotuse I
    goto +eh
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v1, v3, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence; Ljava/lang/CharSequence;)Z
    move-result v9
    if-eqz v9, +005h
    sget v9, Lcom/bytedance/trae/multilanguage/R$string;->imkit_monthly_limit_cannotuse I
    goto +3h
    sget v9, Lcom/bytedance/trae/multilanguage/R$string;->imkit_daily_limit_cannotuse I
    sget-object v1, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    new-array v3, v2, [Ljava/lang/Object;
    aput-object v7, v3, v5
    invoke-virtual v1, v0, v9, v3, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    check-cast v7, Ljava/lang/CharSequence;
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v9
    if-nez v9, +004h
    move v9, v2
    goto +2h
    move v9, v5
    if-eqz v9, +01dh
    sget-object v7, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget v9, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_free_activity_quota I
    new-array v1, v5, [Ljava/lang/Object;
    invoke-virtual v7, v0, v9, v1, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    check-cast v7, Ljava/lang/CharSequence;
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v9
    if-nez v9, +003h
    goto +2h
    move v2, v5
    if-eqz v2, +003h
    goto +2h
    move-object v8, v7
    move-object v7, v8
    check-cast v7, Ljava/lang/String;
    check-cast v7, Ljava/lang/String;
    return-object v7
.end method

.method private final createActionButton(android.content.Context  float)android.view.View
    .registers 11
    # ins_size=3
    invoke-virtual v9, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v10
    invoke-virtual v10, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v10
    iget v10, v10, Landroid/util/DisplayMetrics;->density F
    sget-object v0, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual v9, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    const-string v2, "getResources(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_queue_canuse_button I
    const/4 v3, 0
    new-array v4, v3, [Ljava/lang/Object;
    invoke-virtual v0, v1, v2, v4, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v9, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    sget v2, Lcom/bytedance/trae/conversation/R$id;->btn_use_now I
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setId(I)V
    invoke-virtual v1, v3, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v2, 17
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    const/16 v3, 12
    int-to-float v3, v3
    mul-float/2addr v3, v10
    float-to-int v3, v3
    invoke-virtual v1, v3, v3, v3, v3, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v4, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v4, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_base_secondary I
    invoke-static v9, v5, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v5
    invoke-virtual v4, v5, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    const/16 v5, 8
    int-to-float v5, v5
    mul-float/2addr v5, v10
    invoke-virtual v4, v5, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    const/4 v5, 1
    int-to-float v6, v5
    mul-float/2addr v6, v10
    float-to-int v6, v6
    sget v7, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l2 I
    invoke-static v9, v7, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v7
    invoke-virtual v4, v6, v7, Landroid/graphics/drawable/GradientDrawable;->setStroke(I I)V
    check-cast v4, Landroid/graphics/drawable/Drawable;
    invoke-virtual v1, v4, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v1, v5, Landroid/widget/LinearLayout;->setClickable(Z)V
    invoke-virtual v1, v5, Landroid/widget/LinearLayout;->setFocusable(Z)V
    new-instance v4, Landroid/widget/ImageView;
    invoke-direct v4, v9, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget v6, Lcom/bytedance/trae/conversation/R$drawable;->ic_input_bar_use_express_pass I
    invoke-virtual v4, v6, Landroid/widget/ImageView;->setImageResource(I)V
    sget-object v6, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v4, v6, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    check-cast v4, Landroid/view/View;
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v6, v3, v3, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v4, v6, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v3, Landroid/widget/TextView;
    invoke-direct v3, v9, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v3, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v3, v2, Landroid/widget/TextView;->setGravity(I)V
    const/4 v0, 2
    const/high16 v2, 1095761920
    invoke-virtual v3, v0, v2, Landroid/widget/TextView;->setTextSize(I F)V
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v9, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v9
    invoke-virtual v3, v9, Landroid/widget/TextView;->setTextColor(I)V
    sget-object v9, Landroid/graphics/Typeface;->DEFAULT Landroid/graphics/Typeface;
    invoke-static v9, v5, Landroid/graphics/Typeface;->create(Landroid/graphics/Typeface; I)Landroid/graphics/Typeface;
    move-result-object v9
    invoke-virtual v3, v9, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    invoke-virtual v3, v5, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v9, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v3, v9, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v0, -2
    invoke-direct v9, v0, v0, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v0, 4
    int-to-float v0, v0
    mul-float/2addr v0, v10
    float-to-int v10, v0
    invoke-virtual v9, v10, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v9, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v3, Landroid/view/View;
    invoke-virtual v1, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method private final formatResetDate(android.content.Context  java.lang.String)java.lang.String
    .registers 12
    # ins_size=3
    const-string v0, "Asia/Shanghai"
    invoke-static v0, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;
    move-result-object v0
    invoke-static v0, Ljava/util/Calendar;->getInstance(Ljava/util/TimeZone;)Ljava/util/Calendar;
    move-result-object v0
    check-cast v11, Ljava/lang/CharSequence;
    const-string/jumbo v1, weekly
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v11, v1, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence; Ljava/lang/CharSequence;)Z
    move-result v1
    const-string v2, "monthly"
    const/4 v3, 5
    const/4 v4, 6
    const/4 v5, 3
    const/4 v6, 2
    const/4 v7, 1
    if-eqz v1, +01ah
    const/4 v1, 7
    invoke-virtual v0, v1, Ljava/util/Calendar;->get(I)I
    move-result v8
    packed-switch v8, +0000141h
    goto +ch
    move v1, v6
    goto +ah
    move v1, v5
    goto +8h
    const/4 v1, 4
    goto +6h
    move v1, v3
    goto +4h
    move v1, v4
    goto +2h
    move v1, v7
    invoke-virtual v0, v4, v1, Ljava/util/Calendar;->add(I I)V
    goto +14h
    move-object v1, v2
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v11, v1, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence; Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +009h
    invoke-virtual v0, v6, v7, Ljava/util/Calendar;->add(I I)V
    invoke-virtual v0, v3, v7, Ljava/util/Calendar;->set(I I)V
    goto +4h
    invoke-virtual v0, v4, v7, Ljava/util/Calendar;->add(I I)V
    invoke-virtual v0, v7, Ljava/util/Calendar;->get(I)I
    move-result v1
    invoke-virtual v0, v6, Ljava/util/Calendar;->get(I)I
    move-result v4
    add-int/2addr v4, v7
    invoke-virtual v0, v3, Ljava/util/Calendar;->get(I)I
    move-result v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v11, v2, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence; Ljava/lang/CharSequence;)Z
    move-result v11
    invoke-virtual v10, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v10
    invoke-virtual v10, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;
    move-result-object v10
    invoke-virtual v10, Landroid/content/res/Configuration;->getLocales()Landroid/os/LocaleList;
    move-result-object v10
    const/4 v2, 0
    invoke-virtual v10, v2, Landroid/os/LocaleList;->get(I)Ljava/util/Locale;
    move-result-object v10
    if-nez v10, +006h
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v10
    sget-object v3, Lcom/bytedance/trae/multilanguage/I18nLanguage;->Companion Lcom/bytedance/trae/multilanguage/I18nLanguage$Companion;
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v3, v10, Lcom/bytedance/trae/multilanguage/I18nLanguage$Companion;->fromLocale(Ljava/util/Locale;)Lcom/bytedance/trae/multilanguage/I18nLanguage;
    move-result-object v10
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v10, Lcom/bytedance/trae/multilanguage/I18nLanguage;->ordinal()I
    move-result v10
    aget v10, v3, v10
    const-string v3, "format(...)"
    if-eq v10, v7, +096h
    if-eq v10, v6, +04ch
    if-eqz v11, +023h
    sget-object v10, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE Lkotlin/jvm/internal/StringCompanionObject;
    sget-object v10, Ljava/util/Locale;->ENGLISH Ljava/util/Locale;
    new-array v11, v6, [Ljava/lang/Object;
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    aput-object v0, v11, v2
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    aput-object v0, v11, v7
    invoke-static v11, v6, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v11
    const-string v0, "%04d-%02d-01"
    invoke-static v10, v0, v11, Ljava/lang/String;->format(Ljava/util/Locale; Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    invoke-static v10, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +0b8h
    sget-object v10, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE Lkotlin/jvm/internal/StringCompanionObject;
    sget-object v10, Ljava/util/Locale;->ENGLISH Ljava/util/Locale;
    new-array v11, v5, [Ljava/lang/Object;
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    aput-object v1, v11, v2
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    aput-object v1, v11, v7
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    aput-object v0, v11, v6
    invoke-static v11, v5, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v11
    const-string v0, "%04d-%02d-%02d"
    invoke-static v10, v0, v11, Ljava/lang/String;->format(Ljava/util/Locale; Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    invoke-static v10, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +091h
    if-eqz v11, +022h
    sget-object v10, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE Lkotlin/jvm/internal/StringCompanionObject;
    sget-object v10, Ljava/util/Locale;->CHINESE Ljava/util/Locale;
    new-array v11, v6, [Ljava/lang/Object;
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    aput-object v0, v11, v2
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    aput-object v0, v11, v7
    invoke-static v11, v6, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v11
    const-string v0, "%d 年 %d月 1日"
    invoke-static v10, v0, v11, Ljava/lang/String;->format(Ljava/util/Locale; Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    invoke-static v10, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +6eh
    sget-object v10, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE Lkotlin/jvm/internal/StringCompanionObject;
    sget-object v10, Ljava/util/Locale;->CHINESE Ljava/util/Locale;
    new-array v11, v5, [Ljava/lang/Object;
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    aput-object v1, v11, v2
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    aput-object v1, v11, v7
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    aput-object v0, v11, v6
    invoke-static v11, v5, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v11
    const-string v0, "%d 年 %d月 %d 日"
    invoke-static v10, v0, v11, Ljava/lang/String;->format(Ljava/util/Locale; Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    invoke-static v10, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +48h
    if-eqz v11, +022h
    sget-object v10, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE Lkotlin/jvm/internal/StringCompanionObject;
    sget-object v10, Ljava/util/Locale;->JAPANESE Ljava/util/Locale;
    new-array v11, v6, [Ljava/lang/Object;
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    aput-object v0, v11, v2
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    aput-object v0, v11, v7
    invoke-static v11, v6, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v11
    const-string v0, "%d年%d月 1日"
    invoke-static v10, v0, v11, Ljava/lang/String;->format(Ljava/util/Locale; Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    invoke-static v10, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +26h
    sget-object v10, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE Lkotlin/jvm/internal/StringCompanionObject;
    sget-object v10, Ljava/util/Locale;->JAPANESE Ljava/util/Locale;
    new-array v11, v5, [Ljava/lang/Object;
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    aput-object v1, v11, v2
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    aput-object v1, v11, v7
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    aput-object v0, v11, v6
    invoke-static v11, v5, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v11
    const-string v0, "%d年%d月%d日"
    invoke-static v10, v0, v11, Ljava/lang/String;->format(Ljava/util/Locale; Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    invoke-static v10, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v10
    packed-switch-payload 1 2 3 4 5 6 7
.end method

.method private static final render$lambda$11(long[]  com.bytedance.trae.conversation.chat.block.AgentContentBlock$FreeActivityQuotaError  android.view.View)void
    .registers 9
    # ins_size=3
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    const/4 v8, 0
    aget-wide v2, v6, v8
    sub-long v2, v0, v2
    const-wide/16 v4, 500
    cmp-long v2, v2, v4
    if-gez v2, +003h
    return-void 
    aput-wide v0, v6, v8
    sget-object v6, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v8, "im_quota_banner_click"
    invoke-virtual v6, v8, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->notifyBenefitEnable()V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->getOnActionClick()Lkotlin/jvm/functions/Function1;
    move-result-object v6
    if-eqz v6, +007h
    sget-object v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;->USER_ERPRESS_PASS_WHEN_ERROR Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;
    invoke-interface v6, v7, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$FreeActivityQuotaError)android.view.View
    .registers 19
    # ins_size=3
    move-object/from16 v1, v16
    move-object/from16 v2, v17
    move-object/from16 v3, v18
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v4, "AgentBlock"
    const-string v5, "[FreeActivityQuotaErrorRenderer] render"
    invoke-virtual v0, v4, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual/range v17, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v4, v0, Landroid/util/DisplayMetrics;->density F
    new-instance v5, Landroid/widget/LinearLayout;
    invoke-direct v5, v2, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v6, 1
    invoke-virtual v5, v6, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v0, 16
    int-to-float v7, v0
    mul-float/2addr v7, v4
    float-to-int v7, v7
    const/16 v8, 12
    int-to-float v8, v8
    mul-float/2addr v8, v4
    float-to-int v9, v8
    invoke-virtual v5, v7, v9, v7, v9, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v7, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v7, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    invoke-virtual v7, v8, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    sget v8, Lcom/bytedance/trae/common_ui/R$color;->trae_status_info_surface_l1 I
    invoke-static v2, v8, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v8
    invoke-virtual v7, v8, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    int-to-float v8, v6
    mul-float/2addr v8, v4
    float-to-int v8, v8
    sget v9, Lcom/bytedance/trae/common_ui/R$color;->trae_status_primary_surface_l2 I
    invoke-static v2, v9, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v9
    invoke-virtual v7, v8, v9, Landroid/graphics/drawable/GradientDrawable;->setStroke(I I)V
    check-cast v7, Landroid/graphics/drawable/Drawable;
    invoke-virtual v5, v7, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v8, -1
    const/4 v9, -2
    invoke-direct v7, v8, v9, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v10, 8
    int-to-float v11, v10
    mul-float/2addr v11, v4
    float-to-int v11, v11
    iput v11, v7, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    const/4 v12, 4
    int-to-float v12, v12
    mul-float/2addr v12, v4
    float-to-int v12, v12
    iput v12, v7, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v7, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v7, Landroid/widget/LinearLayout;
    invoke-direct v7, v2, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v13, 0
    invoke-virtual v7, v13, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v7, v0, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v0, Landroid/widget/ImageView;
    invoke-direct v0, v2, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget-object v14, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v0, v14, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    sget v14, Lcom/bytedance/trae/conversation/R$drawable;->info_filled_blue I
    invoke-virtual v0, v14, Landroid/widget/ImageView;->setImageResource(I)V
    sget v14, Lcom/bytedance/trae/common_ui/R$color;->trae_status_info_default I
    invoke-static v2, v14, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v14
    invoke-virtual v0, v14, Landroid/widget/ImageView;->setColorFilter(I)V
    const/16 v14, 20
    int-to-float v14, v14
    mul-float/2addr v14, v4
    float-to-int v14, v14
    check-cast v0, Landroid/view/View;
    new-instance v15, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v15, v14, v14, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v15, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v7, v0, v15, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Landroid/widget/TextView;
    invoke-direct v0, v2, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    const/high16 v14, 1096810496
    const/4 v15, 2
    invoke-virtual v0, v15, v14, Landroid/widget/TextView;->setTextSize(I F)V
    sget-object v14, Landroid/graphics/Typeface;->DEFAULT Landroid/graphics/Typeface;
    invoke-static v14, v6, Landroid/graphics/Typeface;->create(Landroid/graphics/Typeface; I)Landroid/graphics/Typeface;
    move-result-object v14
    invoke-virtual v0, v14, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    sget v14, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v2, v14, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v14
    invoke-virtual v0, v14, Landroid/widget/TextView;->setTextColor(I)V
    new-instance v14, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v6, 1065353216
    invoke-direct v14, v13, v9, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    invoke-virtual v14, v12, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v14, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v14, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_chat_stream_tips_title I
    invoke-virtual v2, v6, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    invoke-virtual v0, v6, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    check-cast v0, Landroid/view/View;
    invoke-virtual v7, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v7, Landroid/view/View;
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v0, v8, v9, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v7, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->isLatestAgent()Z
    move-result v0
    if-eqz v0, +05bh
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedError;->getData()Lcom/google/gson/JsonObject;
    move-result-object v0
    if-eqz v0, +04ch
    const-string v6, "fast_request_event"
    invoke-virtual v0, v6, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +044h
    sget-object v6, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v6, v1
    check-cast v6, Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer;
    new-instance v6, Lcom/google/gson/Gson;
    invoke-direct v6, Lcom/google/gson/Gson;-><init>()V
    const-class v7, Lcom/bytedance/trae/im/service/FastRequestEvent;
    invoke-virtual v6, v0, v7, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/FastRequestEvent;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v6, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +003h
    const/4 v0, 0
    check-cast v0, Lcom/bytedance/trae/im/service/FastRequestEvent;
    if-eqz v0, +017h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/FastRequestEvent;->getType()Ljava/lang/Integer;
    move-result-object v0
    sget-object v6, Lcom/bytedance/trae/im/service/FastRequestEventType;->HasQuotaCanUse Lcom/bytedance/trae/im/service/FastRequestEventType;
    invoke-virtual v6, Lcom/bytedance/trae/im/service/FastRequestEventType;->getValue()I
    move-result v6
    if-nez v0, +003h
    goto +9h
    invoke-virtual v0, Ljava/lang/Integer;->intValue()I
    move-result v0
    if-ne v0, v6, +004h
    const/4 v0, 1
    goto +2h
    move v0, v13
    if-eqz v0, +004h
    const/4 v0, 1
    goto +2h
    move v0, v13
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedError;->getData()Lcom/google/gson/JsonObject;
    move-result-object v6
    if-eqz v6, +012h
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedError;->getData()Lcom/google/gson/JsonObject;
    move-result-object v6
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v1, v2, v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer;->buildFreeActivityQuotaMessage(Landroid/content/Context; Lcom/google/gson/JsonObject; Z)Ljava/lang/String;
    move-result-object v6
    goto +3h
    const-string v6, ""
    new-instance v7, Landroid/widget/TextView;
    invoke-direct v7, v2, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    const/high16 v14, 1095761920
    invoke-virtual v7, v15, v14, Landroid/widget/TextView;->setTextSize(I F)V
    sget v14, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v2, v14, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v14
    invoke-virtual v7, v14, Landroid/widget/TextView;->setTextColor(I)V
    new-instance v14, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v14, v8, v9, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v12, v14, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    check-cast v14, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v7, v14, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-nez v8, +004h
    const/4 v8, 1
    goto +2h
    move v8, v13
    if-eqz v8, +006h
    invoke-virtual v7, v10, Landroid/widget/TextView;->setVisibility(I)V
    goto +7h
    invoke-virtual v7, v13, Landroid/widget/TextView;->setVisibility(I)V
    invoke-virtual v7, v6, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    check-cast v7, Landroid/view/View;
    invoke-virtual v5, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-direct v1, v2, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer;->createActionButton(Landroid/content/Context; F)Landroid/view/View;
    move-result-object v2
    const/4 v4, 1
    new-array v6, v4, [J
    const-wide/16 v7, 0
    aput-wide v7, v6, v13
    new-instance v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer$$ExternalSyntheticLambda0;
    invoke-direct v4, v6, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer$$ExternalSyntheticLambda0;-><init>([J Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;)V
    invoke-virtual v2, v4, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    if-eqz v0, +003h
    move v10, v13
    invoke-virtual v2, v10, Landroid/view/View;->setVisibility(I)V
    if-eqz v0, +044h
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer;->isToAppLog Z
    if-nez v0, +040h
    const/4 v4, 1
    iput-boolean v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer;->isToAppLog Z
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v4, "im_quota_banner_occur"
    new-instance v6, Lorg/json/JSONObject;
    invoke-direct v6, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v7, unique_id
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->getOriginMessage()Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v10
    invoke-virtual v10, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getSessionId()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v8, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const/16 v10, 95
    invoke-virtual v8, v10, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->getOriginMessage()Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v8, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v6, v7, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v0, v4, v6, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v0, v9, v9, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v11, v0, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    const v3, 8388613
    iput v3, v0, Landroid/widget/LinearLayout$LayoutParams;->gravity I
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v2, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v5, Landroid/view/View;
    return-object v5
    :try_start_0x109
    :try_start_0x1ca
.end method

.method public bridge synthetic render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock)android.view.View
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method public update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock$FreeActivityQuotaError)void
    .registers 7
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    instance-of v0, v5, Landroid/widget/LinearLayout;
    if-eqz v0, +071h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_use_now I
    invoke-virtual v5, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->isLatestAgent()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +05bh
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedError;->getData()Lcom/google/gson/JsonObject;
    move-result-object v6
    const/4 v0, 1
    if-eqz v6, +04ch
    const-string v2, "fast_request_event"
    invoke-virtual v6, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v6
    if-eqz v6, +044h
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v2, v4
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer;
    new-instance v2, Lcom/google/gson/Gson;
    invoke-direct v2, Lcom/google/gson/Gson;-><init>()V
    const-class v3, Lcom/bytedance/trae/im/service/FastRequestEvent;
    invoke-virtual v2, v6, v3, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/service/FastRequestEvent;
    invoke-static v6, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    goto +ch
    move-exception v6
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v6, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v6
    invoke-static v6, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    invoke-static v6, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    const/4 v6, 0
    check-cast v6, Lcom/bytedance/trae/im/service/FastRequestEvent;
    if-eqz v6, +017h
    invoke-virtual v6, Lcom/bytedance/trae/im/service/FastRequestEvent;->getType()Ljava/lang/Integer;
    move-result-object v6
    sget-object v2, Lcom/bytedance/trae/im/service/FastRequestEventType;->HasQuotaCanUse Lcom/bytedance/trae/im/service/FastRequestEventType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/FastRequestEventType;->getValue()I
    move-result v2
    if-nez v6, +003h
    goto +9h
    invoke-virtual v6, Ljava/lang/Integer;->intValue()I
    move-result v6
    if-ne v6, v2, +004h
    move v6, v0
    goto +2h
    move v6, v1
    if-eqz v6, +003h
    goto +2h
    move v0, v1
    if-eqz v0, +003h
    goto +3h
    const/16 v1, 8
    invoke-virtual v5, v1, Landroid/view/View;->setVisibility(I)V
    return-void 
    :try_start_0xf
    :try_start_0x2f
    :try_start_0x47
.end method

.method public bridge synthetic update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;)V
    return-void 
.end method
