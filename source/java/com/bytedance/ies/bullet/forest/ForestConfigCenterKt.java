package com.bytedance.ies.bullet.forest;

import com.bytedance.forest.model.GeckoConfig;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ForestConfigCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0000¨\u0006\b"}, d2 = {"toForestGeckoConfig", "Lcom/bytedance/forest/model/GeckoConfig;", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/GeckoConfig;", "appId", "", "appVersion", CommonConstants.KEY_DEVICE_ID, "region", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForestConfigCenterKt {
    public static final GeckoConfig toForestGeckoConfig(com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig geckoConfig, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(geckoConfig, "<this>");
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "appVersion");
        Intrinsics.checkNotNullParameter(str3, CommonConstants.KEY_DEVICE_ID);
        Intrinsics.checkNotNullParameter(str4, "region");
        String accessKey = geckoConfig.getAccessKey();
        String offlineDir = geckoConfig.getOfflineDir();
        boolean isRelativePath = geckoConfig.getIsRelativePath();
        Long longOrNull = StringsKt.toLongOrNull(str);
        return new GeckoConfig(accessKey, offlineDir, longOrNull != null ? longOrNull.longValue() : 0L, str2, str3, str4, isRelativePath);
    }
}
