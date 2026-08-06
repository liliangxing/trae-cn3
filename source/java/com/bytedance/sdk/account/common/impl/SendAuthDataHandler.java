package com.bytedance.sdk.account.common.impl;

import android.os.Bundle;
import com.bytedance.sdk.account.common.api.BDApiEventHandler;
import com.bytedance.sdk.account.common.api.BDDataHandler;
import com.bytedance.sdk.account.common.model.BaseResp;
import com.bytedance.sdk.account.common.model.SendAuth;

/* loaded from: classes5.dex */
public class SendAuthDataHandler implements BDDataHandler {
    @Override // com.bytedance.sdk.account.common.api.BDDataHandler
    public boolean handle(int i, Bundle bundle, BDApiEventHandler bDApiEventHandler) {
        if (bundle != null && bDApiEventHandler != null) {
            if (i == 1) {
                SendAuth.Request request = new SendAuth.Request(bundle);
                if (!request.checkArgs()) {
                    return false;
                }
                if (request.scope != null) {
                    request.scope = request.scope.replace(" ", "");
                }
                if (request.optionalScope1 != null) {
                    request.optionalScope1 = request.optionalScope1.replace(" ", "");
                }
                if (request.optionalScope0 != null) {
                    request.optionalScope0 = request.optionalScope0.replace(" ", "");
                }
                bDApiEventHandler.onReq(request);
                return true;
            }
            if (i == 2) {
                BaseResp response = new SendAuth.Response(bundle);
                if (response.checkArgs()) {
                    bDApiEventHandler.onResp(response);
                    return true;
                }
            }
        }
        return false;
    }
}
