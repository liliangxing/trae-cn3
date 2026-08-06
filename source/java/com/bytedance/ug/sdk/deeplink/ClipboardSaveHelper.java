package com.bytedance.ug.sdk.deeplink;

import android.content.Context;
import com.bytedance.ug.sdk.deeplink.utils.SharedPreferencesHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClipboardSaveHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007J\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ug/sdk/deeplink/ClipboardSaveHelper;", "", "()V", ClipboardSaveHelper.KEY_LAST_CB_D_EEROR_TTCB_CONTENT, "", ClipboardSaveHelper.KEY_LAST_CLIPBOARD_TIME_STAMP, "getSaveClipboardTimeStamp", "", "context", "Landroid/content/Context;", "getSaveTTCBContent", "removeTTCBSave", "", "saveClipboardTimeStamp", "timeStamp", "saveTTCB", "ttcb", "deeplink_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public final class ClipboardSaveHelper {
    public static final ClipboardSaveHelper INSTANCE = new ClipboardSaveHelper();
    private static final String KEY_LAST_CB_D_EEROR_TTCB_CONTENT = "KEY_LAST_CB_D_EEROR_TTCB_CONTENT";
    private static final String KEY_LAST_CLIPBOARD_TIME_STAMP = "KEY_LAST_CLIPBOARD_TIME_STAMP";

    private ClipboardSaveHelper() {
    }

    public final void saveTTCB(Context context, String ttcb) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(ttcb, "ttcb");
        SharedPreferencesHelper.getInstance(context).putString(KEY_LAST_CB_D_EEROR_TTCB_CONTENT, ttcb);
    }

    public final String getSaveTTCBContent(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        String string = SharedPreferencesHelper.getInstance(context).getString(KEY_LAST_CB_D_EEROR_TTCB_CONTENT, "");
        Intrinsics.checkExpressionValueIsNotNull(string, "sp.getString(KEY_LAST_CB_D_EEROR_TTCB_CONTENT, \"\")");
        return string;
    }

    public final void removeTTCBSave(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        SharedPreferencesHelper.getInstance(context).remove(KEY_LAST_CB_D_EEROR_TTCB_CONTENT);
    }

    public final void saveClipboardTimeStamp(Context context, long timeStamp) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        SharedPreferencesHelper.getInstance(context).putLong(KEY_LAST_CLIPBOARD_TIME_STAMP, timeStamp);
    }

    public final long getSaveClipboardTimeStamp(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return SharedPreferencesHelper.getInstance(context).getLong(KEY_LAST_CLIPBOARD_TIME_STAMP, 0L);
    }
}
