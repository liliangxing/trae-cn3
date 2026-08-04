# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetHtml;
.super Ljava/lang/Object;
.source "PureShowWidgetInlineView.kt"

.field public static final ENCODING:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetHtml;
.field public static final MIME_TYPE:Ljava/lang/String;
.field public static final WIDGET_BASE_URL:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetHtml;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetHtml;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetHtml;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetHtml;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final build(java.lang.String  boolean)java.lang.String
    .registers 7
    # ins_size=3
    const-string/jumbo v0, widgetCode
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "hidden"
    if-eqz v6, +005h
    const-string v1, "auto"
    goto +2h
    move-object v1, v0
    if-eqz v6, +005h
    const-string/jumbo v0, visible
    if-eqz v6, +005h
    const-string v6, "100%"
    goto +3h
    const-string v6, "0"
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "
            <!doctype html>
            <html>
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
                <style>
                    html, body {
                        margin: 0;
                        padding: 0;
                        width: 100%;
                        min-height: "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ";
                        overflow: "
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ";
                        background: transparent;
                        -webkit-overflow-scrolling: touch;
                        -webkit-text-size-adjust: 100%;
                        text-size-adjust: 100%;
                    }
                    #trae-widget-root,
                    #trae-widget-root * {
                        box-sizing: border-box;
                        max-width: 100%;
                    }
                    #trae-widget-root {
                        display: flow-root;
                        width: 100%;
                        min-height: "
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v0, ";
                    }
                </style>
            </head>
            <body>
                <div id="trae-widget-root">"
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, "</div>
            </body>
            </html>
        "
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, Lkotlin/text/StringsKt;->trimIndent(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    return-object v5
.end method
