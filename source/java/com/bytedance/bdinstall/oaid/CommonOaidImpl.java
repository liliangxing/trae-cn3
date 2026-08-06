package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdinstall.oaid.OaidApi;
import com.bytedance.bdinstall.oaid.ServiceBlockBinder;
import com.bytedance.bdinstall.oaid.impl.MsaIdInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class CommonOaidImpl extends BaseOaidImpl<MsaIdInterface> {
    private static final String PACKAGE_NAME = "com.mdid.msa";

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Common";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CommonOaidImpl() {
        super(PACKAGE_NAME);
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl, com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context context) {
        startMsaklServer(context, context.getPackageName());
        return super.getOaid(context);
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected ServiceBlockBinder.ServiceBindedListener<MsaIdInterface, String> buildServiceImpl() {
        return new ServiceBlockBinder.ServiceBindedListener<MsaIdInterface, String>() { // from class: com.bytedance.bdinstall.oaid.CommonOaidImpl.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.bdinstall.oaid.ServiceBlockBinder.ServiceBindedListener
            public MsaIdInterface asInterface(IBinder iBinder) {
                return MsaIdInterface.Stub.asInterface(iBinder);
            }

            @Override // com.bytedance.bdinstall.oaid.ServiceBlockBinder.ServiceBindedListener
            public String fetchResult(MsaIdInterface msaIdInterface) throws Exception {
                if (msaIdInterface == null) {
                    return null;
                }
                return msaIdInterface.getOAID();
            }
        };
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected Intent buildIntent(Context context) {
        Intent intent = new Intent();
        intent.setClassName(PACKAGE_NAME, "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
        return intent;
    }

    private void startMsaklServer(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName(PACKAGE_NAME, "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
