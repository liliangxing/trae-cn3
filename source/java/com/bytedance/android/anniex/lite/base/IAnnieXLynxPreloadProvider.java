package com.bytedance.android.anniex.lite.base;

import android.net.Uri;
import com.bytedance.android.anniex.engine.AnnieXLynxEngine;
import com.bytedance.android.anniex.lite.flow.base.IAnnieXPreloadProvider;
import com.bytedance.android.anniex.model.AnnieXLynxModel;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import kotlin.Metadata;

/* compiled from: IAnnieXLynxPreloadProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH&J\u001c\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/anniex/lite/base/IAnnieXLynxPreloadProvider;", "Lcom/bytedance/android/anniex/lite/flow/base/IAnnieXPreloadProvider;", "cancelPreload", "", "getKitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getOrCreateAnnieXLynxModel", "Lcom/bytedance/android/anniex/model/AnnieXLynxModel;", "bid", "", StrategyConstants.SCHEMA, "Landroid/net/Uri;", "sessionId", "getPreloadEngine", "Lcom/bytedance/android/anniex/engine/AnnieXLynxEngine;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface IAnnieXLynxPreloadProvider extends IAnnieXPreloadProvider {
    void cancelPreload();

    @Override // com.bytedance.android.anniex.lite.flow.base.IAnnieXPreloadProvider
    KitType getKitType();

    AnnieXLynxModel getOrCreateAnnieXLynxModel(String bid, Uri schema, String sessionId);

    AnnieXLynxEngine getPreloadEngine(String bid, String sessionId);

    /* compiled from: IAnnieXLynxPreloadProvider.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class DefaultImpls {
        public static void cancelPreload(IAnnieXLynxPreloadProvider iAnnieXLynxPreloadProvider) {
        }

        public static KitType getKitType(IAnnieXLynxPreloadProvider iAnnieXLynxPreloadProvider) {
            return KitType.LYNX;
        }

        public static /* synthetic */ AnnieXLynxModel getOrCreateAnnieXLynxModel$default(IAnnieXLynxPreloadProvider iAnnieXLynxPreloadProvider, String str, Uri uri, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOrCreateAnnieXLynxModel");
            }
            if ((i & 1) != 0) {
                str = "default_bid";
            }
            return iAnnieXLynxPreloadProvider.getOrCreateAnnieXLynxModel(str, uri, str2);
        }

        public static /* synthetic */ AnnieXLynxEngine getPreloadEngine$default(IAnnieXLynxPreloadProvider iAnnieXLynxPreloadProvider, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPreloadEngine");
            }
            if ((i & 1) != 0) {
                str = "default_bid";
            }
            return iAnnieXLynxPreloadProvider.getPreloadEngine(str, str2);
        }
    }
}
