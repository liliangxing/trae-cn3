package com.bytedance.ug.sdk.clipboard_handler;

import android.content.ClipData;
import com.bytedance.ug.sdk.deeplink.IClipboardChecker;
import com.bytedance.ug.sdk.deeplink.api.internal.IClipboardInternalApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClipboardInternalApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ug/sdk/clipboard_handler/ClipboardInternalApi;", "Lcom/bytedance/ug/sdk/deeplink/api/internal/IClipboardInternalApi;", "()V", "checkAndDistributeClipboard", "", "clearMatchSchemeClipBoard", "getClipBoardText", "", "", "clipData", "Landroid/content/ClipData;", "getClipboardCheckerWithType", "Lcom/bytedance/ug/sdk/deeplink/IClipboardChecker;", "type", "clipboard_handler_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ClipboardInternalApi implements IClipboardInternalApi {
    @Override // com.bytedance.ug.sdk.deeplink.api.internal.IClipboardInternalApi
    public void clearMatchSchemeClipBoard() {
        ClipboardHelper.getInstance().clearMatchSchemeClipBoard();
    }

    @Override // com.bytedance.ug.sdk.deeplink.api.internal.IClipboardInternalApi
    public IClipboardChecker getClipboardCheckerWithType(String type) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        return ClipboardHelper.getInstance().getClipboardCheckerWithType(type);
    }

    @Override // com.bytedance.ug.sdk.deeplink.api.internal.IClipboardInternalApi
    public List<String> getClipBoardText(ClipData clipData) {
        return ClipboardHelper.getInstance().getClipBoardText(clipData);
    }

    @Override // com.bytedance.ug.sdk.deeplink.api.internal.IClipboardInternalApi
    public void checkAndDistributeClipboard() {
        ZlinkClipboardManager.checkAndDistributeClipboard();
    }
}
