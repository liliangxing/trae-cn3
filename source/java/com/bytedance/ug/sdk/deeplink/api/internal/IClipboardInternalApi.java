package com.bytedance.ug.sdk.deeplink.api.internal;

import android.content.ClipData;
import com.bytedance.ug.sdk.deeplink.IClipboardChecker;
import com.bytedance.ug.sdk.deeplink.api.IService;
import java.util.List;
import kotlin.Metadata;

/* compiled from: IClipboardInternalApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u001a\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H&¨\u0006\r"}, d2 = {"Lcom/bytedance/ug/sdk/deeplink/api/internal/IClipboardInternalApi;", "Lcom/bytedance/ug/sdk/deeplink/api/IService;", "checkAndDistributeClipboard", "", "clearMatchSchemeClipBoard", "getClipBoardText", "", "", "clipData", "Landroid/content/ClipData;", "getClipboardCheckerWithType", "Lcom/bytedance/ug/sdk/deeplink/IClipboardChecker;", "type", "deeplink_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public interface IClipboardInternalApi extends IService {
    void checkAndDistributeClipboard();

    void clearMatchSchemeClipBoard();

    List<String> getClipBoardText(ClipData clipData);

    IClipboardChecker getClipboardCheckerWithType(String type);
}
