package com.bytedance.android.anniex.lite.base;

import android.net.Uri;
import com.bytedance.android.anniex.base.service.IAnnieXService;
import kotlin.Metadata;

/* compiled from: IAnnieXLynxProcess.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/lite/base/IAnnieXLynxProcess;", "Lcom/bytedance/android/anniex/base/service/IAnnieXService;", "dispatchFlow", "", "bid", "", "sessionId", "uri", "Landroid/net/Uri;", "preCreateLynxModel", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface IAnnieXLynxProcess extends IAnnieXService {
    void dispatchFlow(String bid, String sessionId, Uri uri);

    void preCreateLynxModel(String bid, String sessionId, Uri uri);
}
