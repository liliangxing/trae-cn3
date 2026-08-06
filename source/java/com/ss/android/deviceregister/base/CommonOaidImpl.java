package com.ss.android.deviceregister.base;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bun.lib.MsaIdInterface;
import com.ss.android.deviceregister.base.OaidApi;
import com.ss.android.deviceregister.base.ServiceBlockBinder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class CommonOaidImpl extends BaseOaidImpl<MsaIdInterface> {
    private static final String PACKAGE_NAME = "com.mdid.msa";

    @Override // com.ss.android.deviceregister.base.OaidApi
    public String getName(Context context) {
        return "Common";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CommonOaidImpl() {
        super(PACKAGE_NAME);
    }

    @Override // com.ss.android.deviceregister.base.BaseOaidImpl, com.ss.android.deviceregister.base.OaidApi
    public OaidApi.Result getOaid(Context context) {
        startMsaklServer(context, context.getPackageName());
        return super.getOaid(context);
    }

    @Override // com.ss.android.deviceregister.base.BaseOaidImpl
    protected ServiceBlockBinder.ServiceBindedListener<MsaIdInterface, String> buildServiceImpl() {
        return new ServiceBlockBinder.ServiceBindedListener<MsaIdInterface, String>() { // from class: com.ss.android.deviceregister.base.CommonOaidImpl.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ss.android.deviceregister.base.ServiceBlockBinder.ServiceBindedListener
            public MsaIdInterface asInterface(IBinder iBinder) {
                return MsaIdInterface.Stub.asInterface(iBinder);
            }

            @Override // com.ss.android.deviceregister.base.ServiceBlockBinder.ServiceBindedListener
            public String fetchResult(MsaIdInterface msaIdInterface) throws Exception {
                if (msaIdInterface == null) {
                    return null;
                }
                return msaIdInterface.getOAID();
            }
        };
    }

    @Override // com.ss.android.deviceregister.base.BaseOaidImpl
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
