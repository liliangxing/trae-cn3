package com.vivo.push;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.vivo.push.listener.IPushQueryActionListener;
import com.vivo.push.p010b.C1209f;
import com.vivo.push.p012d.C1234b;
import com.vivo.push.p013e.C1250d;
import com.vivo.push.p013e.InterfaceC1244a;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.C1393t;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PushClient extends C1199a implements InterfaceC1244a {
    public static final String DEFAULT_REQUEST_ID = "1";
    private static volatile PushClient sPushClient;
    private Context mContext;
    private boolean mIsInitSdk;
    private InterfaceC1244a mSyncProfileInfo;

    private PushClient(Context context) {
        this.mContext = ContextDelegate.getContext(context);
        C1313a.m810a().m811a(context);
        C1306m.m762a().m774a(context);
        this.mSyncProfileInfo = new C1250d();
    }

    public static synchronized PushClient getInstance(Context context) {
        PushClient pushClient;
        synchronized (PushClient.class) {
            if (sPushClient == null) {
                sPushClient = new PushClient(context.getApplicationContext());
            }
            pushClient = sPushClient;
        }
        return pushClient;
    }

    public void initialize(PushConfig pushConfig) throws VivoPushException {
        if (pushConfig == null) {
            throw new VivoPushException("initialize error config is null");
        }
        C1313a.m810a().m815e().mo856a(pushConfig);
        initialize();
    }

    private void initialize() throws VivoPushException {
        if (checkAgreePrivacyStatementAndInitSdk()) {
            checkManifest();
            C1306m m762a = C1306m.m762a();
            C1209f c1209f = new C1209f();
            c1209f.m593a(C1313a.m810a().m815e().mo872l());
            m762a.m776a(c1209f);
            C1393t.m1048d("PushClientManager", "startWork");
        }
    }

    private boolean checkAgreePrivacyStatementAndInitSdk() {
        if (!C1313a.m810a().m815e().mo873m().isAgreePrivacyStatement()) {
            return false;
        }
        inidSdk(this.mContext);
        return true;
    }

    private void inidSdk(Context context) {
        synchronized (this) {
            if (!this.mIsInitSdk) {
                C1306m.m762a().m774a(context);
                this.mIsInitSdk = true;
            }
        }
    }

    public void checkManifest() throws VivoPushException {
        if (checkAgreePrivacyStatementAndInitSdk()) {
            C1306m.m762a().m784b();
        }
    }

    private void checkParam(String str) {
        if (str == null) {
            throw new IllegalArgumentException("PushManager String param should not be ".concat(String.valueOf(str)));
        }
    }

    public void bindAlias(String str, IPushActionListener iPushActionListener) {
        if (checkAgreePrivacyStatementAndInitSdk()) {
            checkParam(str);
            C1306m.m762a().m780a(str, getAppId(""), getAppKey(""), iPushActionListener);
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(104);
        }
    }

    private String getAppId(String str) {
        return !TextUtils.isEmpty(str) ? str : C1313a.m810a().m815e().mo854a();
    }

    private String getAppKey(String str) {
        return !TextUtils.isEmpty(str) ? str : C1313a.m810a().m815e().mo860c();
    }

    public void unBindAlias(String str, IPushActionListener iPushActionListener) {
        if (checkAgreePrivacyStatementAndInitSdk()) {
            checkParam(str);
            C1306m.m762a().m786b(str, getAppId(""), getAppKey(""), iPushActionListener);
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(104);
        }
    }

    public void turnOnPush(IPushActionListener iPushActionListener) {
        if (checkAgreePrivacyStatementAndInitSdk()) {
            C1306m.m762a().m775a(iPushActionListener, getAppId(""), getAppKey(""));
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(104);
        }
    }

    public void turnOffPush(IPushActionListener iPushActionListener) {
        if (checkAgreePrivacyStatementAndInitSdk()) {
            C1306m.m762a().m788c(iPushActionListener, getAppId(""), getAppKey(""));
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(104);
        }
    }

    public String getAlias() {
        if (checkAgreePrivacyStatementAndInitSdk()) {
            return C1306m.m762a().m794i();
        }
        return null;
    }

    @Override // com.vivo.push.C1199a
    public void getRegId(IPushQueryActionListener iPushQueryActionListener) {
        if (checkAgreePrivacyStatementAndInitSdk()) {
            super.getRegId(iPushQueryActionListener);
        } else if (iPushQueryActionListener != null) {
            iPushQueryActionListener.onFail(104);
        }
    }

    public String getVersion() {
        if (checkAgreePrivacyStatementAndInitSdk()) {
            return "506";
        }
        return null;
    }

    public void setTopic(String str, IPushActionListener iPushActionListener) {
        if (checkAgreePrivacyStatementAndInitSdk()) {
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add(str);
            C1306m.m762a().m781a(arrayList, getAppId(""), getAppKey(""), iPushActionListener);
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(104);
        }
    }

    public void delTopic(String str, IPushActionListener iPushActionListener) {
        if (checkAgreePrivacyStatementAndInitSdk()) {
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add(str);
            C1306m.m762a().m787b(arrayList, getAppId(""), getAppKey(""), iPushActionListener);
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(104);
        }
    }

    public List<String> getTopics() {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            return new ArrayList();
        }
        C1306m.m762a();
        return C1306m.m770c();
    }

    public void setSystemModel(boolean z) {
        if (checkAgreePrivacyStatementAndInitSdk()) {
            C1306m.m762a().m783a(z);
        }
    }

    public boolean isSupport() {
        if (checkAgreePrivacyStatementAndInitSdk()) {
            return C1306m.m762a().m789d();
        }
        return false;
    }

    public int isSupportNewControlStrategies() {
        if (checkAgreePrivacyStatementAndInitSdk()) {
            return C1313a.m810a().m817g().m641a();
        }
        return -1;
    }

    public int isSupportSyncProfileInfo() {
        if (checkAgreePrivacyStatementAndInitSdk()) {
            return C1313a.m810a().m817g().m643b();
        }
        return -1;
    }

    public boolean isPushSupport(int i) {
        if (checkAgreePrivacyStatementAndInitSdk()) {
            return C1313a.m810a().m817g().m642a(i);
        }
        return false;
    }

    @Override // com.vivo.push.p013e.InterfaceC1244a
    public void addProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(104);
            }
        } else {
            InterfaceC1244a interfaceC1244a = this.mSyncProfileInfo;
            if (interfaceC1244a != null) {
                interfaceC1244a.addProfileId(str, iPushRequestCallback);
            }
        }
    }

    @Override // com.vivo.push.p013e.InterfaceC1244a
    public void deleteProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(104);
            }
        } else {
            InterfaceC1244a interfaceC1244a = this.mSyncProfileInfo;
            if (interfaceC1244a != null) {
                interfaceC1244a.deleteProfileId(str, iPushRequestCallback);
            }
        }
    }

    @Override // com.vivo.push.p013e.InterfaceC1244a
    public void deleteAllProfileId(IPushRequestCallback<Integer> iPushRequestCallback) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(104);
            }
        } else {
            InterfaceC1244a interfaceC1244a = this.mSyncProfileInfo;
            if (interfaceC1244a != null) {
                interfaceC1244a.deleteAllProfileId(iPushRequestCallback);
            }
        }
    }

    @Override // com.vivo.push.p013e.InterfaceC1244a
    public void queryProfileIds(IPushRequestCallback<List<String>> iPushRequestCallback) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(104);
            }
        } else {
            InterfaceC1244a interfaceC1244a = this.mSyncProfileInfo;
            if (interfaceC1244a != null) {
                interfaceC1244a.queryProfileIds(iPushRequestCallback);
            }
        }
    }

    public void deleteRegid(IPushActionListener iPushActionListener) {
        if (checkAgreePrivacyStatementAndInitSdk()) {
            super.deleteRegid(iPushActionListener, getAppId(""), getAppKey(""));
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(104);
        }
    }

    @Override // com.vivo.push.C1199a
    public void querySubscribeState(IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk() && iPushActionListener != null) {
            iPushActionListener.onStateChanged(104);
        }
        super.querySubscribeState(iPushActionListener);
    }

    public void isNotifyGuideDialogAllowed(Activity activity, IPushActionListener iPushActionListener) {
        if (iPushActionListener == null) {
            return;
        }
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            iPushActionListener.onStateChanged(104);
        } else {
            C1234b.m667a().m668a(activity, iPushActionListener);
        }
    }

    public void showNotifyGuideDialog(Activity activity, IPushActionListener iPushActionListener) {
        if (iPushActionListener == null) {
            return;
        }
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            iPushActionListener.onStateChanged(104);
        } else {
            C1234b.m667a().m669a(activity, iPushActionListener, SystemClock.elapsedRealtime());
        }
    }
}
