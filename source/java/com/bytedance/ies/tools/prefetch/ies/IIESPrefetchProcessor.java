package com.bytedance.ies.tools.prefetch.ies;

import com.bytedance.ies.tools.prefetch.IPrefetchProcessor;
import com.bytedance.ies.web.jsbridge2.JsBridge2;
import kotlin.Metadata;

/* compiled from: IESPrefetchProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/ies/IIESPrefetchProcessor;", "Lcom/bytedance/ies/tools/prefetch/IPrefetchProcessor;", "bindJsBridge", "", "bridge", "Lcom/bytedance/ies/web/jsbridge2/JsBridge2;", "prefetch-ies_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IIESPrefetchProcessor extends IPrefetchProcessor {
    void bindJsBridge(JsBridge2 bridge);
}
