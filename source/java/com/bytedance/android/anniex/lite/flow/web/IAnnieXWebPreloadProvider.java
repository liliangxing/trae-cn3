package com.bytedance.android.anniex.lite.flow.web;

import android.net.Uri;
import com.bytedance.android.anniex.lite.flow.base.IAnnieXPreloadProvider;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import kotlin.Metadata;

/* compiled from: IAnnieXWebPreloadProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH&J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/web/IAnnieXWebPreloadProvider;", "Lcom/bytedance/android/anniex/lite/flow/base/IAnnieXPreloadProvider;", "cancelPreload", "", "getKitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getOrCreateAnnieXWebModel", "Lcom/bytedance/android/anniex/web/model/AnnieXWebModel;", "bid", "", StrategyConstants.SCHEMA, "Landroid/net/Uri;", "sessionId", "getPreloadEngine", "Lcom/bytedance/android/anniex/web/AnnieXWebKit;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface IAnnieXWebPreloadProvider extends IAnnieXPreloadProvider {
    void cancelPreload();

    @Override // com.bytedance.android.anniex.lite.flow.base.IAnnieXPreloadProvider
    KitType getKitType();

    AnnieXWebModel getOrCreateAnnieXWebModel(String bid, Uri schema, String sessionId);

    AnnieXWebKit getPreloadEngine();

    /* compiled from: IAnnieXWebPreloadProvider.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class DefaultImpls {
        public static void cancelPreload(IAnnieXWebPreloadProvider iAnnieXWebPreloadProvider) {
        }

        public static KitType getKitType(IAnnieXWebPreloadProvider iAnnieXWebPreloadProvider) {
            return KitType.WEB;
        }

        public static /* synthetic */ AnnieXWebModel getOrCreateAnnieXWebModel$default(IAnnieXWebPreloadProvider iAnnieXWebPreloadProvider, String str, Uri uri, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOrCreateAnnieXWebModel");
            }
            if ((i & 1) != 0) {
                str = "default_bid";
            }
            return iAnnieXWebPreloadProvider.getOrCreateAnnieXWebModel(str, uri, str2);
        }
    }
}
