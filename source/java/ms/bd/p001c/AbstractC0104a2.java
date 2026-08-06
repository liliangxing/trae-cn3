package ms.bd.p001c;

import android.text.TextUtils;
import com.bytedance.mobsec.metasec.ml.MSConfig;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ms.bd.c.a2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0104a2 extends AbstractC0116c2 implements InterfaceC0110b2 {
    public AbstractC0104a2(String str, String str2, int i) {
        this.mAppID = str;
        this.mLicensetStr = str2;
        this.mCollectMode = i;
        if (TextUtils.isEmpty(str) || "0".equals(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("appID or license must be set.");
        }
    }

    public InterfaceC0110b2 addAdvanceInfo0(String str, String str2) {
        this.mAdvanceInfo.put(str, str2);
        return this;
    }

    protected AbstractC0116c2 build0() {
        if (this.mClientType != -1) {
            return this;
        }
        throw new IllegalArgumentException("MSConfig init error");
    }

    public InterfaceC0110b2 setBDDeviceID0(String str) {
        this.mBDDeviceID = str;
        return this;
    }

    public InterfaceC0110b2 setChannel0(String str) {
        this.mChannel = str;
        return this;
    }

    public InterfaceC0110b2 setClientType0(int i) {
        this.mClientType = i;
        return this;
    }

    public InterfaceC0110b2 setCustomInfo0(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        this.mCustomInfo = map;
        return this;
    }

    public InterfaceC0110b2 setDefaultReportHost0(String str) {
        this.mDefaultReportHost = str;
        return this;
    }

    public InterfaceC0110b2 setDeviceID0(String str) {
        this.mDeviceID = str;
        return this;
    }

    public InterfaceC0110b2 setFetchedDidInterface0(MSConfig.Builder.IFetchedDid iFetchedDid) {
        this.mFetchedDidIntf = iFetchedDid;
        return this;
    }

    public InterfaceC0110b2 setInstallID0(String str) {
        this.mInstallID = str;
        return this;
    }

    public InterfaceC0110b2 setMsComplianceScene0(MSConfig.Builder.IMsComplianceScene iMsComplianceScene) {
        C0215u2.f409b.f410a = iMsComplianceScene;
        return this;
    }

    public InterfaceC0110b2 setMsSettingConfig0(MSConfig.Builder.IMsSettingConfig iMsSettingConfig) {
        C0220v2.f435b.f437a = iMsSettingConfig;
        return this;
    }

    public InterfaceC0110b2 setOVRegionType0(int i) {
        this.mOVRegionType = i;
        return this;
    }

    public InterfaceC0110b2 setSecssionID0(String str) {
        this.mSessionID = str;
        return this;
    }

    public AbstractC0104a2(String str, String str2, String str3, int i) {
        this.mSDKID = str;
        this.mSubAppID = str2;
        this.mLicensetStr = str3;
        this.mCollectMode = i;
        if (TextUtils.isEmpty(str) || "0".equals(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("sdkID or license must be set.");
        }
    }
}
