package com.bytedance.ug.sdk.deeplink.api;

import android.content.ClipData;
import android.content.Context;
import com.bytedance.ug.sdk.deeplink.api.internal.IClipboardInternalApi;
import com.bytedance.ug.sdk.deeplink.interfaces.AbstractClipboardObserver;
import kotlin.Metadata;

/* compiled from: IClipboardHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\u001c\u0010\f\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J&\u0010\u0016\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ug/sdk/deeplink/api/IClipboardHandler;", "Lcom/bytedance/ug/sdk/deeplink/api/IService;", "appendTextToClipboard", "", "context", "Landroid/content/Context;", "text", "", "checkScheme", "clipData", "Landroid/content/ClipData;", "checkSchemeAsync", "clearClipBoard", "", "getClipBoardContent", "allowDistribute", "", "getClipboardInternalApi", "Lcom/bytedance/ug/sdk/deeplink/api/internal/IClipboardInternalApi;", "registerClipboardObserver", "abstractClipboardObserver", "Lcom/bytedance/ug/sdk/deeplink/interfaces/AbstractClipboardObserver;", "writeTextToClipboard", "title", "deeplink_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public interface IClipboardHandler extends IService {
    void appendTextToClipboard(Context context, CharSequence text);

    void checkScheme();

    void checkScheme(ClipData clipData);

    void checkSchemeAsync();

    void clearClipBoard();

    void clearClipBoard(String text, ClipData clipData);

    ClipData getClipBoardContent(boolean allowDistribute);

    IClipboardInternalApi getClipboardInternalApi();

    void registerClipboardObserver(AbstractClipboardObserver abstractClipboardObserver);

    void writeTextToClipboard(Context context, CharSequence title, CharSequence text);
}
