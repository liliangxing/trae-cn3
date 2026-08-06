package com.ss.android.deviceregister.base;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.hihonor.cloudservice.oaid.IOAIDService;
import com.ss.android.deviceregister.LogUtils;
import com.ss.android.deviceregister.base.OaidApi;
import com.ss.android.deviceregister.base.ServiceBlockBinder;
import com.ss.android.deviceregister.base.honor.HonorKeys;
import com.ss.android.deviceregister.base.honor.HonorOAIDCallback;
import com.ss.android.deviceregister.base.honor.HonorOAIDLimitCallback;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class HonorOaidImpl extends BaseOaidImpl<IOAIDService> {
    final HonorOAIDLimitCallback limitCallback;
    final HonorOAIDCallback oaidCallback;

    @Override // com.ss.android.deviceregister.base.OaidApi
    public String getName(Context context) {
        return HonorKeys.NAME;
    }

    @Override // com.ss.android.deviceregister.base.BaseOaidImpl, com.ss.android.deviceregister.base.OaidApi
    public /* bridge */ /* synthetic */ boolean support(Context context) {
        return super.support(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HonorOaidImpl() {
        super("com.hihonor.id");
        this.oaidCallback = new HonorOAIDCallback();
        this.limitCallback = new HonorOAIDLimitCallback();
    }

    @Override // com.ss.android.deviceregister.base.BaseOaidImpl
    protected ServiceBlockBinder.ServiceBindedListener<IOAIDService, String> buildServiceImpl() {
        return new ServiceBlockBinder.ServiceBindedListener<IOAIDService, String>() { // from class: com.ss.android.deviceregister.base.HonorOaidImpl.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ss.android.deviceregister.base.ServiceBlockBinder.ServiceBindedListener
            public IOAIDService asInterface(IBinder iBinder) {
                return IOAIDService.Stub.asInterface(iBinder);
            }

            @Override // com.ss.android.deviceregister.base.ServiceBlockBinder.ServiceBindedListener
            public String fetchResult(IOAIDService iOAIDService) throws Exception {
                if (iOAIDService == null) {
                    LogUtils.m90e(HonorKeys.TAG, "service is null");
                    return null;
                }
                iOAIDService.getOAID(HonorOaidImpl.this.oaidCallback);
                iOAIDService.isOAIDTrackingLimited(HonorOaidImpl.this.limitCallback);
                return "";
            }
        };
    }

    @Override // com.ss.android.deviceregister.base.BaseOaidImpl
    protected Intent buildIntent(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        return intent;
    }

    @Override // com.ss.android.deviceregister.base.BaseOaidImpl, com.ss.android.deviceregister.base.OaidApi
    public OaidApi.Result getOaid(Context context) {
        OaidApi.Result result = new OaidApi.Result();
        try {
            new ServiceBlockBinder(context, buildIntent(context), buildServiceImpl()).blockFetchResult();
            result.oaid = this.oaidCallback.getOaid();
            result.isTrackLimit = this.limitCallback.isLimit();
            LogUtils.m88d(HonorKeys.TAG, "getOaid " + result.oaid);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }
}
