package com.bytedance.android.anniex.lite.base;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.anniex.base.service.IAnnieXService;
import com.bytedance.ies.bullet.service.base.api.UIShowConfig;
import com.bytedance.push.interfaze.IMessageCallbackService;
import kotlin.Metadata;

/* compiled from: ILitePageService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/anniex/lite/base/ILitePageService;", "Lcom/bytedance/android/anniex/base/service/IAnnieXService;", IMessageCallbackService.EVENT_TYPE_SHOW, "", "context", "Landroid/content/Context;", "bid", "", "schema", "Landroid/net/Uri;", "config", "Lcom/bytedance/ies/bullet/service/base/api/UIShowConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface ILitePageService extends IAnnieXService {
    boolean show(Context context, String bid, Uri schema, UIShowConfig config);

    /* compiled from: ILitePageService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ boolean show$default(ILitePageService iLitePageService, Context context, String str, Uri uri, UIShowConfig uIShowConfig, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
            }
            if ((i & 2) != 0) {
                str = "default_bid";
            }
            if ((i & 8) != 0) {
                uIShowConfig = new UIShowConfig();
            }
            return iLitePageService.show(context, str, uri, uIShowConfig);
        }
    }
}
