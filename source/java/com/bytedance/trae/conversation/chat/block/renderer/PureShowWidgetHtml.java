package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.trae.im.service.ModelSelectionConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PureShowWidgetInlineView.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetHtml;", "", "<init>", "()V", "WIDGET_BASE_URL", "", "MIME_TYPE", "ENCODING", "build", "widgetCode", "scrollable", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PureShowWidgetHtml {
    public static final String ENCODING = "UTF-8";
    public static final PureShowWidgetHtml INSTANCE = new PureShowWidgetHtml();
    public static final String MIME_TYPE = "text/html";
    public static final String WIDGET_BASE_URL = "https://widget.traecontent.com/";

    private PureShowWidgetHtml() {
    }

    public final String build(String widgetCode, boolean scrollable) {
        Intrinsics.checkNotNullParameter(widgetCode, "widgetCode");
        String str = scrollable ? ModelSelectionConstants.AUTO : "hidden";
        String str2 = scrollable ? "visible" : "hidden";
        String str3 = scrollable ? "100%" : "0";
        return StringsKt.trimIndent("\n            <!doctype html>\n            <html>\n            <head>\n                <meta charset=\"UTF-8\">\n                <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0\">\n                <style>\n                    html, body {\n                        margin: 0;\n                        padding: 0;\n                        width: 100%;\n                        min-height: " + str3 + ";\n                        overflow: " + str + ";\n                        background: transparent;\n                        -webkit-overflow-scrolling: touch;\n                        -webkit-text-size-adjust: 100%;\n                        text-size-adjust: 100%;\n                    }\n                    #trae-widget-root,\n                    #trae-widget-root * {\n                        box-sizing: border-box;\n                        max-width: 100%;\n                    }\n                    #trae-widget-root {\n                        display: flow-root;\n                        width: 100%;\n                        min-height: " + str3 + ";\n                        overflow: " + str2 + ";\n                    }\n                </style>\n            </head>\n            <body>\n                <div id=\"trae-widget-root\">" + widgetCode + "</div>\n            </body>\n            </html>\n        ");
    }
}
