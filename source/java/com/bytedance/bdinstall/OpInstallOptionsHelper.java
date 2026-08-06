package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.SubpSyncManager;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class OpInstallOptionsHelper implements IInstallListener {
    private static final String SP_KEY_APPLOG_STATS = "applog_stats";
    private static final String SP_KEY_SNSSDK = "snssdk_openudid";
    private static final String kEY_INSTALL_INFO = "install_info";
    private final Context mContext;
    private InstallOptions sOptions;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    interface OnDataChangedListener {
        void onInstallInfoChanged(InstallInfo installInfo, String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpInstallOptionsHelper(Context context) {
        this.mContext = context;
    }

    public void setInstallOptions(InstallOptions installOptions) {
        this.sOptions = installOptions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void trySync() {
        InstallOptions installOptions = this.sOptions;
        if (installOptions == null) {
            return;
        }
        BDInstall.getInstance(String.valueOf(installOptions.getAid())).addInstallListener(true, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startObserver(Context context, final OnDataChangedListener onDataChangedListener) {
        if (this.sOptions == null) {
            return;
        }
        SubpSyncManager.inst(context).observer(this.sOptions.getAidString(), kEY_INSTALL_INFO, new SubpSyncManager.OnUpdateListener() { // from class: com.bytedance.bdinstall.OpInstallOptionsHelper.1
            @Override // com.bytedance.bdinstall.SubpSyncManager.OnUpdateListener
            public void onUpdate(String str, String str2) {
                DrLog.m139d("install_info onUpdate " + str);
                InstallInfo parse = InstallInfo.parse(str);
                if (parse == null || TextUtils.isEmpty(parse.getDid()) || TextUtils.isEmpty(parse.getIid())) {
                    DrLog.m139d("install_info onUpdate invalid value " + parse);
                    return;
                }
                OnDataChangedListener onDataChangedListener2 = onDataChangedListener;
                if (onDataChangedListener2 != null) {
                    onDataChangedListener2.onInstallInfoChanged(parse, str2);
                }
            }
        });
    }

    @Override // com.bytedance.bdinstall.IInstallListener
    public void installFinished(InstallInfo installInfo) {
        if (this.sOptions == null) {
            return;
        }
        String jSONObject = installInfo.toJson().toString();
        if (this.sOptions.isMainInstance) {
            this.mContext.getSharedPreferences("ug_install_op_pref", 0).edit().putString(kEY_INSTALL_INFO, jSONObject).apply();
        }
        SubpSyncManager.inst(this.mContext).sendSubpEvent(this.sOptions.getAidString(), kEY_INSTALL_INFO, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstallInfo getSavedInstallInfo() {
        try {
            String string = this.mContext.getSharedPreferences("ug_install_op_pref", 0).getString(kEY_INSTALL_INFO, null);
            if (TextUtils.isEmpty(string) && Utils.isOffsetInstallInfo()) {
                string = offsetInstallInfo();
            }
            return InstallInfo.parse(string);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String offsetInstallInfo() {
        HashMap hashMap = new HashMap();
        try {
            SharedPreferences sharedPreferences = this.mContext.getSharedPreferences("applog_stats", 0);
            SharedPreferences sharedPreferences2 = this.mContext.getSharedPreferences("snssdk_openudid", 0);
            hashMap.put("did", sharedPreferences.getString("device_id", null));
            hashMap.put("iid", sharedPreferences.getString("install_id", null));
            hashMap.put("client_udid", sharedPreferences2.getString("clientudid", null));
            hashMap.put("openudid", sharedPreferences2.getString("openudid", null));
            DrLog.m139d("offset_did offset installinfo is " + hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap.toString();
    }
}
