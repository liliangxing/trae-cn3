package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.honor.HonorKeys;
import com.bytedance.bdinstall.honor.HonorOAIDCallback;
import com.bytedance.bdinstall.honor.HonorOAIDLimitCallback;
import com.bytedance.bdinstall.oaid.OaidApi;
import com.bytedance.bdinstall.oaid.ServiceBlockBinder;
import com.bytedance.bdinstall.oaid.impl.IOAIDService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class HonorOaidImpl extends BaseOaidImpl<IOAIDService> {
    final HonorOAIDLimitCallback limitCallback;
    final HonorOAIDCallback oaidCallback;

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return HonorKeys.NAME;
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl, com.bytedance.bdinstall.oaid.OaidApi
    public /* bridge */ /* synthetic */ boolean support(Context context) {
        return super.support(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HonorOaidImpl() {
        super("com.hihonor.id");
        this.oaidCallback = new HonorOAIDCallback();
        this.limitCallback = new HonorOAIDLimitCallback();
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected ServiceBlockBinder.ServiceBindedListener<IOAIDService, String> buildServiceImpl() {
        return new ServiceBlockBinder.ServiceBindedListener<IOAIDService, String>() { // from class: com.bytedance.bdinstall.oaid.HonorOaidImpl.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.bdinstall.oaid.ServiceBlockBinder.ServiceBindedListener
            public IOAIDService asInterface(IBinder iBinder) {
                return IOAIDService.Stub.asInterface(iBinder);
            }

            @Override // com.bytedance.bdinstall.oaid.ServiceBlockBinder.ServiceBindedListener
            public String fetchResult(IOAIDService iOAIDService) throws Exception {
                if (iOAIDService == null) {
                    DrLog.m140e("honor# service is null");
                    return null;
                }
                iOAIDService.getOAID(HonorOaidImpl.this.oaidCallback);
                iOAIDService.isOAIDTrackingLimited(HonorOaidImpl.this.limitCallback);
                return "";
            }
        };
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected Intent buildIntent(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        return intent;
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl, com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context context) {
        OaidApi.Result result = new OaidApi.Result();
        try {
            new ServiceBlockBinder(context, buildIntent(context), buildServiceImpl()).blockFetchResult();
            result.oaid = this.oaidCallback.getOaid();
            result.isTrackLimit = this.limitCallback.isLimit();
            DrLog.m139d("honor# getOaid " + result.oaid);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }
}
