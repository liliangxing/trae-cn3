package com.bytedance.geckox.policy.lazy;

import android.text.TextUtils;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.meta.PrepareMetaManager;
import java.io.File;
import java.util.Map;
import kotlin.Triple;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LazyUpdateManager {
    public static Triple<Boolean, Long, Long> getLazyUpdateStoreGeckoInfo(String str, String str2) {
        Map metas = PrepareMetaManager.INSTANCE.getMetas(str);
        if (metas == null || metas.isEmpty()) {
            return new Triple<>(false, (Object) null, (Object) null);
        }
        String str3 = GeckoGlobalManager.inst().getAccessKeyDirs().get(str);
        if (TextUtils.isEmpty(str3)) {
            return new Triple<>(false, (Object) null, (Object) null);
        }
        Long innerGetLatestChannelVersion = ResLoadUtils.innerGetLatestChannelVersion(new File(str3), str, str2);
        long longValue = innerGetLatestChannelVersion == null ? 0L : innerGetLatestChannelVersion.longValue();
        PrepareMeta prepareMeta = (PrepareMeta) metas.get(str2);
        if (prepareMeta != null && longValue != prepareMeta.getVersion()) {
            if (prepareMeta.getFullPackage() != null) {
                return new Triple<>(true, Long.valueOf(prepareMeta.getFullPackage().getLength()), Long.valueOf(prepareMeta.getVersion()));
            }
            return new Triple<>(false, (Object) null, (Object) null);
        }
        return new Triple<>(false, (Object) null, (Object) null);
    }
}
