package com.bytedance.bdinstall.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class GaidGetter {
    private static volatile Pair<String, Boolean> sGaidPair;
    private static GaidMonitor sMonitor;

    public static Pair<String, Boolean> getGaid(Context context, InstallOptions installOptions) {
        if (!isValidPair(sGaidPair)) {
            synchronized (GaidGetter.class) {
                if (isValidPair(sGaidPair)) {
                    return sGaidPair;
                }
                GaidMonitor gaidMonitor = new GaidMonitor();
                sMonitor = gaidMonitor;
                gaidMonitor.onSysCallBegin();
                Pair<String, Boolean> googleAdid = getGoogleAdid(installOptions);
                sMonitor.onSysCallEnd();
                sMonitor.setGaid((String) googleAdid.first);
                sMonitor.setGaidLimited(((Boolean) googleAdid.second).booleanValue());
                String str = (String) googleAdid.first;
                boolean booleanValue = ((Boolean) googleAdid.second).booleanValue();
                if (TextUtils.isEmpty(str)) {
                    DrLog.m140e("Gaid#getGaid failed . rst = " + googleAdid);
                    sMonitor.onFileLoadBegin();
                    SharedPreferences commonSp = LocalConstants.getCommonSp(context, installOptions);
                    str = commonSp.getString("google_aid", null);
                    booleanValue = commonSp.getBoolean("gaid_limited", false);
                    sMonitor.onFileLoadEnd();
                } else {
                    sMonitor.onFileSaveBegin();
                    SharedPreferences commonSp2 = LocalConstants.getCommonSp(context, installOptions);
                    String string = commonSp2.getString("google_aid", null);
                    boolean z = commonSp2.getBoolean("gaid_limited", false);
                    if (!TextUtils.equals(string, str) || z != booleanValue) {
                        trySaveGoogleAid(context, installOptions, str, booleanValue);
                    }
                    sMonitor.onFileSaveEnd();
                }
                sGaidPair = new Pair<>(str, Boolean.valueOf(booleanValue));
            }
        }
        return sGaidPair;
    }

    private static boolean isValidPair(Pair<String, Boolean> pair) {
        return (pair == null || TextUtils.isEmpty((CharSequence) pair.first)) ? false : true;
    }

    private static Pair<String, Boolean> getGoogleAdid(InstallOptions installOptions) {
        try {
            return SensitiveUtils.getGoogleAdid(installOptions);
        } catch (Throwable unused) {
            return new Pair<>(null, false);
        }
    }

    private static void trySaveGoogleAid(Context context, InstallOptions installOptions, String str, boolean z) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        LocalConstants.getCommonSp(context, installOptions).edit().putString("google_aid", str).putBoolean("gaid_limited", z).apply();
    }

    public static void clearSp(Context context, InstallOptions installOptions) {
        LocalConstants.getCommonSp(context, installOptions).edit().remove("google_aid").remove("gaid_limited").apply();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class GaidMonitor {
        private long mFileLoadBeginTime;
        private long mFileLoadEndTime;
        private long mFileSaveBeginTime;
        private long mFileSaveEndTime;
        private String mGaid = null;
        private boolean mGaidLimited;
        private long mSysCallBeginTime;
        private long mSysCallEndTime;
        private boolean mUsed;

        /* JADX INFO: Access modifiers changed from: private */
        public void setGaid(String str) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onSysCallBegin() {
            this.mSysCallBeginTime = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onSysCallEnd() {
            this.mSysCallEndTime = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onFileLoadBegin() {
            this.mFileLoadBeginTime = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onFileLoadEnd() {
            this.mFileLoadEndTime = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onFileSaveBegin() {
            this.mFileSaveBeginTime = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onFileSaveEnd() {
            this.mFileSaveEndTime = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGaidLimited(boolean z) {
            this.mGaidLimited = z;
        }

        public long getSysCallTs() {
            return this.mSysCallEndTime - this.mSysCallBeginTime;
        }

        public long getFileLoadTs() {
            return this.mFileLoadEndTime - this.mFileLoadBeginTime;
        }

        public long getFileSaveTs() {
            return this.mFileSaveEndTime - this.mFileSaveBeginTime;
        }

        public String getGaid() {
            return this.mGaid;
        }

        public boolean isGaidLimited() {
            return this.mGaidLimited;
        }

        public void markUsed() {
            this.mUsed = true;
        }

        public boolean isCache() {
            return this.mUsed;
        }
    }

    public static GaidMonitor getMonitor() {
        return sMonitor;
    }
}
