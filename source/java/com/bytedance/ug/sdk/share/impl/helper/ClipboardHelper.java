package com.bytedance.ug.sdk.share.impl.helper;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Looper;
import com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetHtml;
import com.bytedance.ug.sdk.share.impl.utils.Logger;

/* loaded from: classes4.dex */
public class ClipboardHelper {
    private static final String TAG = "ClipboardHelper";

    public void setText(Context context, CharSequence charSequence, CharSequence charSequence2) {
        ClipboardManager clipboardManager = getClipboardManager(context);
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(charSequence, charSequence2));
        }
    }

    public String getClipBoardText(Context context) {
        ClipData.Item itemAt;
        CharSequence text;
        CharSequence text2;
        ClipboardManager clipboardManager = getClipboardManager(context);
        if (clipboardManager == null) {
            return "";
        }
        try {
            if (clipboardManager.hasPrimaryClip() && (clipboardManager.getPrimaryClipDescription().hasMimeType("text/plain") || clipboardManager.getPrimaryClipDescription().hasMimeType(PureShowWidgetHtml.MIME_TYPE))) {
                ClipData.Item itemAt2 = clipboardManager.getPrimaryClip().getItemAt(0);
                return (itemAt2.getText() == null || (text2 = itemAt2.getText()) == null) ? "" : text2.toString();
            }
        } catch (NullPointerException unused) {
            ClipData primaryClip = clipboardManager.getPrimaryClip();
            return (primaryClip == null || (itemAt = primaryClip.getItemAt(0)) == null || (text = itemAt.getText()) == null) ? "" : text.toString();
        } catch (Throwable th) {
            Logger.e(th.toString());
        }
        return "";
    }

    public ClipboardManager getClipboardManager(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return (ClipboardManager) context.getSystemService("clipboard");
        } catch (Throwable unused) {
            Logger.d(TAG, "Can't create handler inside thread that has not called Looper.prepare() ");
            if (Looper.myLooper() != null) {
                return null;
            }
            Looper.prepare();
            return (ClipboardManager) context.getSystemService("clipboard");
        }
    }

    public void clearPrimaryClip(Context context) {
        ClipboardManager clipboardManager = getClipboardManager(context);
        if (clipboardManager != null) {
            clipboardManager.clearPrimaryClip();
        }
    }
}
