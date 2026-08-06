package com.bytedance.ies.bullet.service.base;

import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import kotlin.Metadata;

/* compiled from: IPreloadV2Service.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0004"}, d2 = {"PRELOAD_LOG_TAG", "", "getPreloadV2Service", "Lcom/bytedance/ies/bullet/service/base/IPreloadV2Service;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IPreloadV2ServiceKt {
    public static final String PRELOAD_LOG_TAG = "PreloadV2";

    public static final IPreloadV2Service getPreloadV2Service() {
        IPreloadV2Service iPreloadV2Service = (IPreloadV2Service) StandardServiceManager.INSTANCE.get(IPreloadV2Service.class);
        if (iPreloadV2Service == null) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "getPreLoadV2Service fail", LogLevel.E, null, 4, null);
        }
        return iPreloadV2Service;
    }
}
