package com.bytedance.crash.dumper;

import com.bytedance.crash.Global;
import com.bytedance.crash.util.DateUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import com.ss.android.update.UpdateDialogNewBase;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* loaded from: classes3.dex */
public class ProtectorInfo {
    private static final String HISTORY_FILE_NAME = "protector_history.txt";
    private static final String LOG_TAG = "NPTH_PROT";
    private File mDumpDir;
    private boolean mHasHistory = false;
    private String mSid = null;
    private int mPerformedCount = 0;
    private int mTotalPerformedCount = 0;
    private boolean mIsPerformed = false;
    private boolean mIsFinalPerformed = false;
    private String mOriginScope = null;
    private String mPreviousScope = null;
    private String mScope = null;
    private String mFormattedContent = null;

    public ProtectorInfo(File file) {
        this.mDumpDir = file;
    }

    public boolean init() {
        long j;
        long parseLong;
        long parseLong2;
        int parseInt;
        int parseInt2;
        String str;
        char c;
        boolean z = false;
        z = false;
        if (this.mDumpDir == null) {
            return false;
        }
        File file = new File(Global.getRootDirectory(), HISTORY_FILE_NAME);
        if (!file.exists() || file.length() == 0) {
            return false;
        }
        try {
            String[] split = this.mDumpDir.getName().split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split.length == 1) {
                j = Long.parseLong(split[0]);
                File parentFile = this.mDumpDir.getParentFile();
                if (parentFile != null) {
                    split = parentFile.getName().split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
            } else {
                j = 0;
            }
            char c2 = 3;
            char c3 = 2;
            if (split.length != 2 && split.length != 3) {
                return false;
            }
            long parseLong3 = Long.parseLong(split[0]);
            int parseInt3 = Integer.parseInt(split[1]);
            if (split.length == 3) {
                this.mPerformedCount = Integer.parseInt(split[2]);
                this.mIsPerformed = true;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String readLine = bufferedReader.readLine();
            if (readLine != null && readLine.equals("V002")) {
                StringBuilder sb = null;
                while (true) {
                    String readLine2 = bufferedReader.readLine();
                    if (readLine2 == null) {
                        try {
                            break;
                        } catch (Throwable unused) {
                            return false;
                        }
                    }
                    String[] split2 = readLine2.split(" ");
                    if (split2.length == 5) {
                        try {
                            parseLong = Long.parseLong(split2[z ? 1 : 0]);
                            parseLong2 = Long.parseLong(split2[1]);
                            parseInt = Integer.parseInt(split2[c3]);
                            parseInt2 = Integer.parseInt(split2[c2]);
                            str = split2[4];
                        } catch (Throwable unused2) {
                        }
                        if (parseInt == parseInt3 && parseLong >= parseLong3 && ((j != 0 || parseLong2 == parseLong3) && (j == 0 || parseLong <= j))) {
                            this.mTotalPerformedCount = parseInt2;
                            if (parseInt2 == 1) {
                                this.mOriginScope = str;
                            }
                            if (!this.mIsPerformed) {
                                this.mPerformedCount = parseInt2;
                                this.mPreviousScope = str;
                            } else {
                                int i = this.mPerformedCount;
                                if (i == parseInt2 + 1) {
                                    this.mPreviousScope = str;
                                } else if (i == parseInt2) {
                                    this.mScope = str;
                                }
                            }
                            if (sb == null) {
                                try {
                                    this.mHasHistory = true;
                                    c = 2;
                                    try {
                                        this.mSid = split2[1] + '-' + split2[2];
                                        sb = new StringBuilder();
                                    } catch (Throwable unused3) {
                                    }
                                } catch (Throwable unused4) {
                                    c = 2;
                                }
                            } else {
                                c = 2;
                            }
                            sb.append("No.").append(parseInt2).append("\n  time: ").append(DateUtils.formatDateMs(parseLong)).append("\n  scope: ").append(str).append(UpdateDialogNewBase.TYPE);
                            c3 = c;
                            z = false;
                            c2 = 3;
                        }
                    }
                    c = c3;
                    c3 = c;
                    z = false;
                    c2 = 3;
                }
                if (this.mIsPerformed && this.mPerformedCount == this.mTotalPerformedCount) {
                    this.mIsFinalPerformed = true;
                }
                if (sb != null) {
                    this.mFormattedContent = ("sid: " + this.mSid + "\nperformed_count: " + this.mPerformedCount + "\ntotal_performed_count: " + this.mTotalPerformedCount + "\n--- --- ---\n") + sb.toString();
                }
                return true;
            }
            return false;
        } catch (Throwable unused5) {
            return z;
        }
    }

    public void dump() {
        if (this.mDumpDir == null || this.mFormattedContent == null) {
            return;
        }
        try {
            FileUtils.writeFile(new File(this.mDumpDir, HISTORY_FILE_NAME), this.mFormattedContent, false);
            NpthLog.i(LOG_TAG, "dump history file: " + this.mDumpDir.getName());
        } catch (Throwable unused) {
        }
    }

    public boolean hasHistory() {
        return this.mHasHistory;
    }

    public String getSid() {
        return this.mSid;
    }

    public int getPerformedCount() {
        return this.mPerformedCount;
    }

    public int getTotalPerformedCount() {
        return this.mTotalPerformedCount;
    }

    public boolean isPerformed() {
        return this.mIsPerformed;
    }

    public boolean isFinalPerformed() {
        return this.mIsFinalPerformed;
    }

    public String getPreviousScope() {
        return this.mPreviousScope;
    }

    public String getOriginScope() {
        return this.mOriginScope;
    }

    public String getScope() {
        return this.mScope;
    }
}
