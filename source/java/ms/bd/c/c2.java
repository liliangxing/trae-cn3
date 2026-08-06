package ms.bd.c;

import android.text.TextUtils;
import com.bytedance.mobsec.metasec.ml.MSConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes8.dex */
public abstract class c2 {
    public static final int CLIENT_TYPE_BUSINESS = 1;
    public static final int CLIENT_TYPE_INHOUSE = 0;
    public static final int CLIENT_TYPE_UNKNOWN = -1;
    private static final int COLLECT_MODE_603 = 603;
    private static final int COLLECT_MODE_APPLIST = 810;
    public static final int COLLECT_MODE_DEFAULT = 99999;
    public static final int COLLECT_MODE_FINANCE = 300;
    public static final int COLLECT_MODE_FLOW = 603;
    public static final int COLLECT_MODE_MINIMIZE = 5;
    private static final int COLLECT_MODE_MINIMIZE503 = 5;
    public static final int COLLECT_MODE_ML_AL = 810;
    private static final int COLLECT_MODE_ML_BASE = 280;
    public static final int COLLECT_MODE_ML_MINIMIZE = 290;
    public static final int COLLECT_MODE_ML_TEEN = 280;
    public static final int OVREGION_TYPE_SG = 0;
    public static final int OVREGION_TYPE_UNKNOWN = -1;
    public static final int OVREGION_TYPE_VA = 1;
    protected String mFetchedDid;
    protected MSConfig.Builder.IFetchedDid mFetchedDidIntf;
    protected int mOrigin;
    protected String mAppID = "";
    protected String mChannel = "";
    protected String mDeviceID = "";
    protected String mBDDeviceID = "";
    protected String mInstallID = "";
    protected String mSessionID = "";
    protected String mSDKID = "";
    protected String mSubAppID = "";
    protected String mLicensetStr = "";
    protected String mDefaultReportHost = "";
    protected String mSDKVersion = "";
    protected int mClientType = -1;
    protected int mOVRegionType = -1;
    protected int mCollectMode = COLLECT_MODE_DEFAULT;
    protected Map<String, String> mCustomInfo = new HashMap();
    protected Map<String, String> mAdvanceInfo = new HashMap();

    public synchronized void setFetchedDid(String str) {
        this.mFetchedDid = str;
        this.mOrigin = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String toNativeValue() {
        JSONArray jSONArray;
        jSONArray = new JSONArray();
        jSONArray.put(wrap(this.mAppID));
        jSONArray.put(wrap(this.mSubAppID));
        jSONArray.put(wrap(this.mSDKID));
        jSONArray.put(wrap(this.mLicensetStr));
        jSONArray.put(wrap(w3.a));
        jSONArray.put(wrap(this.mChannel));
        jSONArray.put(wrap(this.mDeviceID));
        jSONArray.put(wrap(this.mBDDeviceID));
        jSONArray.put(wrap(this.mInstallID));
        jSONArray.put(wrap(this.mSessionID));
        jSONArray.put(String.valueOf(this.mClientType));
        jSONArray.put(String.valueOf(this.mOVRegionType));
        jSONArray.put(String.valueOf(this.mCollectMode));
        jSONArray.put(wrap(this.mFetchedDid));
        jSONArray.put(String.valueOf(this.mOrigin));
        JSONArray jSONArray2 = new JSONArray();
        for (Map.Entry<String, String> entry : this.mCustomInfo.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                jSONArray2.put(wrap(entry.getKey()));
                jSONArray2.put(wrap(entry.getValue()));
            }
        }
        jSONArray.put(jSONArray2);
        JSONArray jSONArray3 = new JSONArray();
        for (Map.Entry<String, String> entry2 : this.mAdvanceInfo.entrySet()) {
            if (!TextUtils.isEmpty(entry2.getKey())) {
                jSONArray3.put(wrap(entry2.getKey()));
                jSONArray3.put(wrap(entry2.getValue()));
            }
        }
        jSONArray.put(jSONArray3);
        return jSONArray.toString();
    }

    String wrap(Object obj) {
        return (obj == null || !(obj instanceof String)) ? "" : ((String) obj).trim();
    }
}
