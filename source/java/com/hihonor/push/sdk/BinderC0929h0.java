package com.hihonor.push.sdk;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.hihonor.push.framework.aidl.DataBuffer;
import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.IPushCallback;
import com.hihonor.push.framework.aidl.MessageCodec;
import com.hihonor.push.framework.aidl.entity.ResponseHeader;
import com.hihonor.push.sdk.C0966z;
import com.hihonor.push.sdk.common.data.ApiException;

/* renamed from: com.hihonor.push.sdk.h0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class BinderC0929h0 extends IPushCallback.Stub {

    /* renamed from: a */
    public final Object f723a;

    /* renamed from: b */
    public final InterfaceC0932i0 f724b;

    public BinderC0929h0(Object obj, InterfaceC0932i0 interfaceC0932i0) {
        this.f723a = obj;
        this.f724b = interfaceC0932i0;
    }

    @Override // com.hihonor.push.framework.aidl.IPushCallback
    public void onResult(DataBuffer dataBuffer) {
        Log.i("IPCCallback", "onResult parse start.");
        Bundle header = dataBuffer.getHeader();
        Bundle body = dataBuffer.getBody();
        ResponseHeader responseHeader = new ResponseHeader();
        MessageCodec.parseMessageEntity(header, responseHeader);
        Object obj = this.f723a;
        if (obj instanceof IMessageEntity) {
            MessageCodec.parseMessageEntity(body, (IMessageEntity) obj);
        }
        InterfaceC0932i0 interfaceC0932i0 = this.f724b;
        ApiException apiException = new ApiException(responseHeader.getStatusCode(), responseHeader.getStatusMessage());
        Object obj2 = this.f723a;
        C0966z.b bVar = (C0966z.b) interfaceC0932i0;
        bVar.getClass();
        C0966z c0966z = C0966z.f792c;
        AbstractC0924f1<?> abstractC0924f1 = bVar.f801a;
        c0966z.getClass();
        Log.i("HonorApiManager", "sendResolveResult start");
        Handler handler = c0966z.f793a;
        handler.sendMessage(handler.obtainMessage(2, abstractC0924f1));
        bVar.f801a.m767b(apiException, obj2);
        Log.i("IPCCallback", "onResult parse end.");
    }
}
