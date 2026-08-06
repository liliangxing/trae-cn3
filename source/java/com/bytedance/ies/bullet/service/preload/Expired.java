package com.bytedance.ies.bullet.service.preload;

import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.ies.bullet.service.base.utils.ReleaseComputable;
import kotlin.Metadata;

/* compiled from: PreloadMemoryCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/service/preload/Expired;", "Lcom/bytedance/ies/bullet/service/base/utils/ReleaseComputable;", "isExpired", "", PerfConsts.KEY_CURRENT_GALVANIC, "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface Expired extends ReleaseComputable {
    boolean isExpired(long current);
}
