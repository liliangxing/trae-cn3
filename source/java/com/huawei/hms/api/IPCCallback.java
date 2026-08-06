package com.huawei.hms.api;

import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.CodecLookup;
import com.huawei.hms.core.aidl.DataBuffer;
import com.huawei.hms.core.aidl.IAIDLCallback;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.MessageCodec;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class IPCCallback extends IAIDLCallback.Stub {
    private static final String TAG = "IPCCallback";
    private final DatagramTransport.InterfaceC1256a mCallback;
    private final Class<? extends IMessageEntity> mResponseClass;

    public IPCCallback(Class<? extends IMessageEntity> cls, DatagramTransport.InterfaceC1256a interfaceC1256a) {
        this.mResponseClass = cls;
        this.mCallback = interfaceC1256a;
    }

    @Override // com.huawei.hms.core.aidl.IAIDLCallback
    public void call(DataBuffer dataBuffer) throws RemoteException {
        IMessageEntity iMessageEntity;
        if (dataBuffer != null && !TextUtils.isEmpty(dataBuffer.URI)) {
            MessageCodec find = CodecLookup.find(dataBuffer.getProtocol());
            if (dataBuffer.getBodySize() > 0) {
                iMessageEntity = newResponseInstance();
                if (iMessageEntity != null) {
                    find.decode(dataBuffer.getBody(), iMessageEntity);
                }
            } else {
                iMessageEntity = null;
            }
            DatagramTransport.InterfaceC1256a interfaceC1256a = this.mCallback;
            if (interfaceC1256a != null) {
                if (dataBuffer.header != null) {
                    ResponseHeader responseHeader = new ResponseHeader();
                    find.decode(dataBuffer.header, responseHeader);
                    this.mCallback.mo2071a(responseHeader.getStatusCode(), iMessageEntity);
                    return;
                }
                interfaceC1256a.mo2071a(0, iMessageEntity);
                return;
            }
            return;
        }
        HMSLog.m2118e(TAG, "In call, URI cannot be empty.");
        throw new RemoteException();
    }

    protected IMessageEntity newResponseInstance() {
        Class<? extends IMessageEntity> cls = this.mResponseClass;
        if (cls == null) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            HMSLog.m2118e(TAG, "In newResponseInstance, instancing exception." + e.getMessage());
            return null;
        }
    }
}
