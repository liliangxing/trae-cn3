package com.bytedance.pia.core.api.services;

import android.net.Uri;
import com.bytedance.pia.core.api.PiaCoreApi;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IReleasable;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public interface IPiaRenderingService {
    IReleasable execute(String str, String str2, Object obj, Map<String, ?> map, IConsumer<Map<String, ?>> iConsumer, IConsumer<PiaMethod.Error> iConsumer2);

    IReleasable execute(String str, String str2, Map<String, ?> map, IConsumer<Map<String, ?>> iConsumer, IConsumer<PiaMethod.Error> iConsumer2);

    boolean isCacheExist(Uri uri, List<String> list);

    static IPiaRenderingService inst() {
        return (IPiaRenderingService) PiaCoreApi.get(IPiaRenderingService.class);
    }
}
