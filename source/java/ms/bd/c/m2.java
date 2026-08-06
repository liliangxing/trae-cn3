package ms.bd.c;

import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import java.util.Map;

/* loaded from: classes8.dex */
public interface m2 {
    Map frameSign(String str, int i);

    Map getFeatureHash(String str, byte[] bArr);

    Map getReportRaw(String str, int i, Map map);

    String getToken();

    void postEventMessage(MSManagerUtils.MSBusinessHelper mSBusinessHelper);

    void qurryMsRiskInfo(String str, MSManagerUtils.IMsBundleCallback iMsBundleCallback);

    void report(String str, String str2);

    void setBDDeviceID(String str);

    void setCollectMode(int i);

    void setCustomInfo(Map map, boolean z);

    void setDeviceID(String str);

    void setInstallID(String str);

    void setMsSettingConfig(String str);

    void setSessionID(String str);
}
