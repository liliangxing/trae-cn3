package com.bytedance.ies.bullet.service.base.api;

import android.content.Context;
import android.net.Uri;
import com.bytedance.push.interfaze.IMessageCallbackService;
import kotlin.Metadata;

/* compiled from: IBulletService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/api/IBulletUIService;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", IMessageCallbackService.EVENT_TYPE_SHOW, "", "context", "Landroid/content/Context;", "schema", "Landroid/net/Uri;", "config", "Lcom/bytedance/ies/bullet/service/base/api/UIShowConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IBulletUIService extends IBulletService {
    boolean show(Context context, Uri schema, UIShowConfig config);

    /* compiled from: IBulletService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ boolean show$default(IBulletUIService iBulletUIService, Context context, Uri uri, UIShowConfig uIShowConfig, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
            }
            if ((i & 4) != 0) {
                uIShowConfig = new UIShowConfig();
            }
            return iBulletUIService.show(context, uri, uIShowConfig);
        }
    }
}
