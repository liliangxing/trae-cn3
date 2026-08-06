package com.bytedance.pia.core.utils;

import com.bytedance.ies.bullet.lynx.DefaultLynxParams;
import com.bytedance.pia.core.api.PiaAppInfo;
import com.bytedance.pia.core.setting.SettingService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SampleUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/pia/core/utils/SampleUtils;", "", "()V", "sampleCache", "", "", "Lkotlin/Pair;", "", "", "sample", "key", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SampleUtils {
    public static final SampleUtils INSTANCE = new SampleUtils();
    private static final Map<String, Pair<Integer, Boolean>> sampleCache = new LinkedHashMap();

    private SampleUtils() {
    }

    public static /* synthetic */ boolean sample$default(int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = DefaultLynxParams.DEFAULT_LYNX_GROUP_NAME;
        }
        return sample(i, str);
    }

    @JvmStatic
    public static final boolean sample(int sample, String key) {
        String str;
        if (sample <= 10000 && sample >= 0) {
            Map<String, Pair<Integer, Boolean>> map = sampleCache;
            Pair<Integer, Boolean> pair = map.get(key);
            if (pair != null && ((Number) pair.getFirst()).intValue() == sample) {
                return ((Boolean) pair.getSecond()).booleanValue();
            }
            PiaAppInfo appInfo = SettingService.INSTANCE.getAppInfo();
            if (appInfo != null && (str = appInfo.deviceID) != null) {
                r0 = ((new StringBuilder().append(str).append(key).toString().hashCode() % 10000) + 10000) % 10000 < sample;
                Intrinsics.checkNotNull(key);
                map.put(key, new Pair<>(Integer.valueOf(sample), Boolean.valueOf(r0)));
            }
        }
        return r0;
    }
}
