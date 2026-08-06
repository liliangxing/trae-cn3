package com.ss.mediakit.net;

import android.os.Handler;

/* loaded from: classes7.dex */
public class DefaultConstructor implements CreateConstructor {
    @Override // com.ss.mediakit.net.CreateConstructor
    public BaseDNS createDns(String str, AVMDLNetClient aVMDLNetClient, int i, Handler handler, int i2) {
        try {
            return new HTTPDNS(str, aVMDLNetClient, i, handler, i2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
