package com.bytedance.ies.argus.api.interfaces;

import com.bytedance.ies.argus.api.params.AboutToUploadFileParams;
import com.bytedance.ies.argus.api.params.LoadStaticResourceParams;
import com.bytedance.ies.argus.api.params.LoadStaticResourceRewritePayload;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.strategy.provider.client.PrefetchCallerParams;
import kotlin.Metadata;

/* compiled from: IArgusGlobalAspect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052\u0006\u0010\u0006\u001a\u00020\tH&J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\u0006\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/argus/api/interfaces/IArgusGlobalAspect;", "", "verifyAboutToPrefetch", "Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "", "Lcom/bytedance/ies/argus/bean/AspectVerifyResultWithoutRewrite;", "params", "Lcom/bytedance/ies/argus/strategy/provider/client/PrefetchCallerParams;", "verifyAboutToUploadFile", "Lcom/bytedance/ies/argus/api/params/AboutToUploadFileParams;", "verifyLoadStaticResource", "Lcom/bytedance/ies/argus/api/params/LoadStaticResourceRewritePayload;", "Lcom/bytedance/ies/argus/api/params/LoadStaticResourceParams;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface IArgusGlobalAspect {
    AspectVerifyResult verifyAboutToPrefetch(PrefetchCallerParams params);

    AspectVerifyResult verifyAboutToUploadFile(AboutToUploadFileParams params);

    AspectVerifyResult<LoadStaticResourceRewritePayload> verifyLoadStaticResource(LoadStaticResourceParams params);
}
