package com.bytedance.ies.argus.api.interfaces;

import com.bytedance.ies.argus.api.params.AboutToRequestLynxSSRUrlParams;
import com.bytedance.ies.argus.api.params.LoadTemplateParams;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import kotlin.Metadata;

/* compiled from: IArgusLynxAspect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\u0006\u0010\u0004\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/argus/api/interfaces/IArgusLynxAspect;", "Lcom/bytedance/ies/argus/api/interfaces/IArgusViewAspect;", "monitorLoadTemplate", "", "params", "Lcom/bytedance/ies/argus/api/params/LoadTemplateParams;", "verifyAboutToRequestLynxSSRUrl", "Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "", "Lcom/bytedance/ies/argus/bean/AspectVerifyResultWithoutRewrite;", "Lcom/bytedance/ies/argus/api/params/AboutToRequestLynxSSRUrlParams;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface IArgusLynxAspect extends IArgusViewAspect {
    void monitorLoadTemplate(LoadTemplateParams params);

    AspectVerifyResult verifyAboutToRequestLynxSSRUrl(AboutToRequestLynxSSRUrlParams params);
}
