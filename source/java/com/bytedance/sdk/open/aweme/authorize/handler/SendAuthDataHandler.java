package com.bytedance.sdk.open.aweme.authorize.handler;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.handler.IDataHandler;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SendAuthDataHandler implements IDataHandler {
    @Override // com.bytedance.sdk.open.aweme.common.handler.IDataHandler
    public boolean handle(int i, Bundle bundle, IApiEventHandler iApiEventHandler) {
        if (bundle != null && iApiEventHandler != null) {
            if (i == 1) {
                Authorization.Request request = new Authorization.Request(bundle);
                if (!request.checkArgs()) {
                    return false;
                }
                String str = request.scope;
                if (str != null) {
                    request.scope = str.replace(" ", "");
                }
                String str2 = request.optionalScope1;
                if (str2 != null) {
                    request.optionalScope1 = str2.replace(" ", "");
                }
                String str3 = request.optionalScope0;
                if (str3 != null) {
                    request.optionalScope0 = str3.replace(" ", "");
                }
                iApiEventHandler.onReq(request);
                return true;
            }
            if (i == 2) {
                BaseResp response = new Authorization.Response(bundle);
                if (response.checkArgs()) {
                    iApiEventHandler.onResp(response);
                    return true;
                }
            }
        }
        return false;
    }
}
