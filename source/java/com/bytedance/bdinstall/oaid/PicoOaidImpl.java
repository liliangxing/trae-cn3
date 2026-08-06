package com.bytedance.bdinstall.oaid;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.bytedance.bdinstall.oaid.OaidApi;

/* loaded from: classes3.dex */
public class PicoOaidImpl implements OaidApi {
    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Pico";
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context context) {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    @Override // com.bytedance.bdinstall.oaid.OaidApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public OaidApi.Result getOaid(Context context) {
        ContentProviderClient contentProviderClient;
        Bundle bundle;
        PicoOaid picoOaid = new PicoOaid();
        ContentProviderClient contentProviderClient2 = null;
        try {
            contentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://com.pico.idprovider"));
            try {
                try {
                    bundle = contentProviderClient.call("request_oaid", null, null);
                    if (contentProviderClient != null) {
                        contentProviderClient.close();
                    }
                } catch (RemoteException e) {
                    e = e;
                    e.printStackTrace();
                    if (contentProviderClient != null) {
                        contentProviderClient.close();
                    }
                    bundle = null;
                    if (bundle != null) {
                    }
                    return picoOaid;
                }
            } catch (Throwable th) {
                th = th;
                contentProviderClient2 = contentProviderClient;
                if (contentProviderClient2 != null) {
                    contentProviderClient2.close();
                }
                throw th;
            }
        } catch (RemoteException e2) {
            e = e2;
            contentProviderClient = null;
        } catch (Throwable th2) {
            th = th2;
            if (contentProviderClient2 != null) {
            }
            throw th;
        }
        if (bundle != null) {
            picoOaid.oaid = bundle.getString("oaid", null);
            picoOaid.isTrackLimit = bundle.getBoolean("forbidden", false);
        }
        return picoOaid;
    }

    /* loaded from: classes3.dex */
    static class PicoOaid extends OaidApi.Result {
        PicoOaid() {
        }
    }
}
