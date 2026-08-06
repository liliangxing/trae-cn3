package com.bytedance.tobshadow.applog.alink.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/tobshadow/applog/alink/util/LinkUtils;", "", "()V", "getParamFromClipboard", "Lorg/json/JSONObject;", "context", "Landroid/content/Context;", "getParamFromLink", "uri", "Landroid/net/Uri;", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class LinkUtils {
    public static final LinkUtils INSTANCE = new LinkUtils();

    public final JSONObject getParamFromClipboard(Context context) {
        Object systemService;
        if (context != null) {
            try {
                systemService = context.getSystemService("clipboard");
            } catch (Throwable unused) {
            }
        } else {
            systemService = null;
        }
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
        }
        ClipboardManager clipboardManager = (ClipboardManager) systemService;
        ClipData primaryClip = clipboardManager.getPrimaryClip();
        if (primaryClip != null) {
            ClipData.Item itemAt = primaryClip.getItemAt(0);
            Intrinsics.checkExpressionValueIsNotNull(itemAt, "clipData.getItemAt(0)");
            String obj = itemAt.getText().toString();
            if (StringsKt.startsWith$default(obj, "datatracer:", false, 2, (Object) null)) {
                clipboardManager.setPrimaryClip(ClipData.newPlainText("", ""));
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String substring = obj.substring(11);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                Charset charset = Charsets.UTF_8;
                if (substring == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                byte[] bytes = substring.getBytes(charset);
                Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                byte[] decode = Base64.decode(bytes, 2);
                Intrinsics.checkExpressionValueIsNotNull(decode, "data");
                return getParamFromLink(Uri.parse("?".concat(new String(decode, Charsets.UTF_8))));
            }
        }
        return null;
    }

    public final JSONObject getParamFromLink(Uri uri) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (uri == null) {
                return jSONObject;
            }
            String scheme = uri.getScheme();
            if (Intrinsics.areEqual(scheme, "http") || Intrinsics.areEqual(scheme, "https")) {
                jSONObject.put("tr_token", uri.getLastPathSegment());
            }
            for (String str : uri.getQueryParameterNames()) {
                jSONObject.put(str, uri.getQueryParameter(str));
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
