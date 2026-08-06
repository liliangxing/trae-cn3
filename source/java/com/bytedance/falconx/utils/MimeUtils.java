package com.bytedance.falconx.utils;

import coil3.util.Utils_commonKt;
import com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetHtml;
import com.bytedance.trae.conversation.voice.VoiceChatApiPaths;

/* loaded from: classes3.dex */
public class MimeUtils {
    public static String getMimeType(String str) {
        return str.endsWith(".js") ? "application/x-javascript" : str.endsWith(".json") ? VoiceChatApiPaths.HeaderValue.CONTENT_TYPE_JSON : str.endsWith(".css") ? "text/css" : str.endsWith(".html") ? PureShowWidgetHtml.MIME_TYPE : str.endsWith(".ico") ? "image/x-icon" : (str.endsWith(".jpeg") || str.endsWith(".jpg")) ? Utils_commonKt.MIME_TYPE_JPEG : str.endsWith(".png") ? "image/png" : str.endsWith(".gif") ? "image/gif" : str.endsWith(".woff") ? "font/woff" : str.endsWith(".svg") ? "image/svg+xml" : str.endsWith(".ttf") ? "font/ttf" : "";
    }
}
