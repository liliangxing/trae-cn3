# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl;
.super Ljava/lang/Object;
.source "ShareKeyConfigImpl.kt"

.implements Lcom/bytedance/ug/sdk/share/api/depend/IShareKeyConfig;

.field public static final Companion:Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl$Companion;
.field private static WEIXIN_KEY_AVAILABLE:Z
.field private final weixinKey:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl;->Companion Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 1
    invoke-direct v2, v0, v1, v0, Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl;-><init>(Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, weixinKey
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl;->weixinKey Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    const-string v1, ""
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl;-><init>(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$getWEIXIN_KEY_AVAILABLE$cp()boolean
    .registers 1
    # ins_size=0
    sget-boolean v0, Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl;->WEIXIN_KEY_AVAILABLE Z
    return v0
.end method

.method public static final synthetic access$setWEIXIN_KEY_AVAILABLE$cp(boolean)void
    .registers 1
    # ins_size=1
    sput-boolean v0, Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl;->WEIXIN_KEY_AVAILABLE Z
    return-void 
.end method

.method public static final getWEIXIN_KEY_AVAILABLE()boolean
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl;->Companion Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl$Companion;->getWEIXIN_KEY_AVAILABLE()Z
    move-result v0
    return v0
.end method

.method public static final setWEIXIN_KEY_AVAILABLE(boolean)void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl;->Companion Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl$Companion;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl$Companion;->setWEIXIN_KEY_AVAILABLE(Z)V
    return-void 
.end method

.method public getKeys()org.json.JSONObject
    .registers 3
    # ins_size=1
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl;->weixinKey Ljava/lang/String;
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v1
    if-nez v1, +005h
    const/4 v1, 1
    sput-boolean v1, Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl;->WEIXIN_KEY_AVAILABLE Z
    return-object v0
.end method
