package com.bytedance.ttnet.okhttp;

import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.ok3.IOkHttpAppInfoProvider;
import com.bytedance.ttnet.AbsOptionalTTNetDepend;
import com.bytedance.ttnet.ITTNetDepend;
import com.bytedance.ttnet.TTNetInit;
import java.util.List;

/* loaded from: classes4.dex */
public class OkHttpAppInfoProvider implements IOkHttpAppInfoProvider {
    private static volatile OkHttpAppInfoProvider sInstance;
    private ICronetAppProvider mCronetProvider;
    private ITTNetDepend mTTNetDepend;

    public static OkHttpAppInfoProvider inst() {
        if (sInstance == null) {
            synchronized (OkHttpAppInfoProvider.class) {
                if (sInstance == null) {
                    sInstance = new OkHttpAppInfoProvider();
                }
            }
        }
        return sInstance;
    }

    private OkHttpAppInfoProvider() {
    }

    public void setCronetProvider(ICronetAppProvider iCronetAppProvider) {
        this.mCronetProvider = iCronetAppProvider;
    }

    public void setTTNetDepend(ITTNetDepend iTTNetDepend) {
        this.mTTNetDepend = iTTNetDepend;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.IOkHttpAppInfoProvider
    public int getAid() {
        ITTNetDepend iTTNetDepend = this.mTTNetDepend;
        if (iTTNetDepend != null) {
            return iTTNetDepend.getAppId();
        }
        return 0;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.IOkHttpAppInfoProvider
    public String getHttpDnsDomain() {
        ITTNetDepend iTTNetDepend = this.mTTNetDepend;
        if (iTTNetDepend != null) {
            return iTTNetDepend.getTTNetServiceDomainMap().get(TTNetInit.DOMAIN_HTTPDNS_KEY);
        }
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.IOkHttpAppInfoProvider
    public String[] getHttpDnsPreloadDomains() {
        Object obj = this.mTTNetDepend;
        if (obj instanceof AbsOptionalTTNetDepend) {
            return ((AbsOptionalTTNetDepend) obj).getPreloadDomains();
        }
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.IOkHttpAppInfoProvider
    public String[] getHttpDnsDomainHardCodeIps() {
        Object obj = this.mTTNetDepend;
        if (obj instanceof AbsOptionalTTNetDepend) {
            return ((AbsOptionalTTNetDepend) obj).getHttpDnsHardCodeIps();
        }
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.IOkHttpAppInfoProvider
    public List<String> getAbSdkVersion() {
        ICronetAppProvider iCronetAppProvider = this.mCronetProvider;
        if (iCronetAppProvider != null) {
            return iCronetAppProvider.getAbSdkVersion();
        }
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.IOkHttpAppInfoProvider
    public void sendAppMonitorEvent(String str, String str2) {
        ICronetAppProvider iCronetAppProvider = this.mCronetProvider;
        if (iCronetAppProvider != null) {
            iCronetAppProvider.sendAppMonitorEvent(str, str2);
        }
    }
}
