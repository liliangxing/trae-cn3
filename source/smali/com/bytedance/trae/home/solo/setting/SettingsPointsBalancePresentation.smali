# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public abstract Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation;
.super Ljava/lang/Object;
.source "SettingsPointsBalancePresentation.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation$Companion;
.field private static final INFINITE_BALANCE_TEXT:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation;->Companion Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation$Companion;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/SettingsPointsBalancePresentation;-><init>()V
    return-void 
.end method
