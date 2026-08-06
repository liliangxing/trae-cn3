package com.bytedance.ies.tools.prefetch;

import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.Collection;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: ConfigManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0007H&J2\u0010\t\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u001a\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\r0\u000fj\u0002`\u0010H&J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/IConfigManager;", "", "getConfigListByOccasion", "Lkotlin/Pair;", "", "Lcom/bytedance/ies/tools/prefetch/RequestConfig;", "Ljava/util/SortedMap;", "", "occasion", "getConfigListByUrl", "uriWrapper", "Lcom/bytedance/ies/tools/prefetch/UriWrapper;", EventConstants.PARAM_SOURCE_INIT, "", "callback", "Lkotlin/Function0;", "Lcom/bytedance/ies/tools/prefetch/InitCallback;", "updateConfig", "newConfigProvider", "Lcom/bytedance/ies/tools/prefetch/IConfigProvider;", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IConfigManager {
    Pair<Collection<RequestConfig>, SortedMap<String, String>> getConfigListByOccasion(String occasion);

    Pair<Collection<RequestConfig>, SortedMap<String, String>> getConfigListByUrl(UriWrapper uriWrapper);

    void init(Function0<Unit> callback);

    void updateConfig(IConfigProvider newConfigProvider);
}
