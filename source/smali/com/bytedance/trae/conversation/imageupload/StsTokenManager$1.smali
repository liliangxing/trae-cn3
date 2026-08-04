# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$1;
.super Ljava/lang/Object;
.source "StsTokenManager.kt"

.implements Lkotlin/jvm/functions/Function0;

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$1;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$1;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$1;
    return-void 
.end method

.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public bridge synthetic invoke()java.lang.Object
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$1;->invoke()Ljava/lang/Void;
    move-result-object v0
    return-object v0
.end method

.method public final invoke()java.lang.Void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return-object v0
.end method
