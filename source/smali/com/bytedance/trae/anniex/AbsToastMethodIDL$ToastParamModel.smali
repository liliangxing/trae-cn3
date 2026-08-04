# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/anniex/AbsToastMethodIDL$ToastParamModel;
.super Ljava/lang/Object;
.source "AbsToastMethodIDL.kt"

.implements Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;

.field public static final Companion:Lcom/bytedance/trae/anniex/AbsToastMethodIDL$ToastParamModel$Companion;
.field public static final ICON_ERROR:Ljava/lang/String;
.field public static final ICON_SUCCESS:Ljava/lang/String;
.field public static final TYPE_ERROR:Ljava/lang/String;
.field public static final TYPE_SUCCESS:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/anniex/AbsToastMethodIDL$ToastParamModel$Companion;->$$INSTANCE Lcom/bytedance/trae/anniex/AbsToastMethodIDL$ToastParamModel$Companion;
    sput-object v0, Lcom/bytedance/trae/anniex/AbsToastMethodIDL$ToastParamModel;->Companion Lcom/bytedance/trae/anniex/AbsToastMethodIDL$ToastParamModel$Companion;
    return-void 
.end method

.method public abstract getDuration()java.lang.Number
    # abstract or native
.end method

.method public abstract getIconType()java.lang.String
    # abstract or native
.end method

.method public abstract getText()java.lang.String
    # abstract or native
.end method

.method public abstract getType()java.lang.String
    # abstract or native
.end method
