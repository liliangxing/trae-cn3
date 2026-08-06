package com.bytedance.ug.sdk.deeplink.api.internal;

import android.content.ClipData;
import android.net.Uri;
import com.bytedance.ug.sdk.deeplink.IClipboardChecker;
import com.bytedance.ug.sdk.deeplink.api.IService;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: IFissionInternalApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ug/sdk/deeplink/api/internal/IFissionInternalApi;", "Lcom/bytedance/ug/sdk/deeplink/api/IService;", "doAttributionOnMainThread", "", "clipData", "Landroid/content/ClipData;", "clipboardText", "", "zlinkData", "Lorg/json/JSONObject;", "getFissionClipBoardChecker", "Lcom/bytedance/ug/sdk/deeplink/IClipboardChecker;", "parseIntentForFission", "uri", "Landroid/net/Uri;", "deeplink_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public interface IFissionInternalApi extends IService {
    void doAttributionOnMainThread(ClipData clipData, String clipboardText, JSONObject zlinkData);

    IClipboardChecker getFissionClipBoardChecker();

    void parseIntentForFission(Uri uri);
}
