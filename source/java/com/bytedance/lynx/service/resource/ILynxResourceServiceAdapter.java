package com.bytedance.lynx.service.resource;

import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.lynx.service.model.LynxServiceConfig;
import com.lynx.tasm.service.ILynxResourceServiceRequestOperation;
import com.lynx.tasm.service.ILynxResourceServiceResponse;
import com.lynx.tasm.service.LynxResourceServiceCallback;
import com.lynx.tasm.service.LynxResourceServiceRequestParams;
import kotlin.Metadata;

/* compiled from: ILynxResourceServiceAdapter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H&J\"\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H&J\"\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H&J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\u001c"}, d2 = {"Lcom/bytedance/lynx/service/resource/ILynxResourceServiceAdapter;", "", "addResourceLoader", "", "loader", "templateUrl", "", "fetchResourceAsync", "Lcom/lynx/tasm/service/ILynxResourceServiceRequestOperation;", "url", "lynxResourceRequestParams", "Lcom/lynx/tasm/service/LynxResourceServiceRequestParams;", "callback", "Lcom/lynx/tasm/service/LynxResourceServiceCallback;", "fetchResourceSync", "Lcom/lynx/tasm/service/ILynxResourceServiceResponse;", "getPrefixAsGeckoCDN", "path", "initForest", "initLynxResourceServiceAdapter", "lynxServiceConfig", "Lcom/bytedance/lynx/service/model/LynxServiceConfig;", "isInitial", "", "parseChannelBundleByPrefix", SchemaConstants.QUERY_KEY_PREFIX, "accessKey", ResourceInfo.RESOURCE_FROM_PRELOAD, "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface ILynxResourceServiceAdapter {
    void addResourceLoader(Object loader, String templateUrl);

    ILynxResourceServiceRequestOperation fetchResourceAsync(String url, LynxResourceServiceRequestParams lynxResourceRequestParams, LynxResourceServiceCallback callback);

    ILynxResourceServiceResponse fetchResourceSync(String url, LynxResourceServiceRequestParams lynxResourceRequestParams);

    String getPrefixAsGeckoCDN(String path);

    void initForest();

    void initLynxResourceServiceAdapter(LynxServiceConfig lynxServiceConfig);

    boolean isInitial();

    String parseChannelBundleByPrefix(String url, String prefix, String accessKey);

    void preload(String url, LynxResourceServiceRequestParams lynxResourceRequestParams);
}
