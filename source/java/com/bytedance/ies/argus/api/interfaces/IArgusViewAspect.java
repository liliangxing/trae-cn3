package com.bytedance.ies.argus.api.interfaces;

import com.bytedance.ies.argus.api.params.JSBCallParams;
import com.bytedance.ies.argus.api.params.JSBCallRewritePayload;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import kotlin.Metadata;

/* compiled from: IArgusViewAspect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/api/interfaces/IArgusViewAspect;", "", "monitorViewDestroy", "", "verifyJSBCall", "Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "Lcom/bytedance/ies/argus/api/params/JSBCallRewritePayload;", "params", "Lcom/bytedance/ies/argus/api/params/JSBCallParams;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface IArgusViewAspect {
    void monitorViewDestroy();

    AspectVerifyResult<JSBCallRewritePayload> verifyJSBCall(JSBCallParams params);
}
