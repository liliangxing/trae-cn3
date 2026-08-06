package com.bytedance.sdk.open.tt;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.handler.IDataHandler;
import com.bytedance.sdk.open.douyin.ShareToContact;

/* renamed from: com.bytedance.sdk.open.tt.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0138d implements IDataHandler {
    @Override // com.bytedance.sdk.open.aweme.common.handler.IDataHandler
    public boolean handle(int i, Bundle bundle, IApiEventHandler iApiEventHandler) {
        if (bundle != null && iApiEventHandler != null) {
            if (i == 5) {
                ShareToContact.Request request = new ShareToContact.Request(bundle);
                if (!request.checkArgs()) {
                    return false;
                }
                iApiEventHandler.onReq(request);
                return true;
            }
            if (i == 6) {
                ShareToContact.Response response = new ShareToContact.Response(bundle);
                if (response.checkArgs()) {
                    iApiEventHandler.onResp(response);
                    return true;
                }
            }
        }
        return false;
    }
}
