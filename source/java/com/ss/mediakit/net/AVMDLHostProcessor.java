package com.ss.mediakit.net;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.ss.mediakit.medialoader.AVMDLLog;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AVMDLHostProcessor {
    private static final int BACKUP_DNS = 1;
    private static final int MAIN_DNS = 0;
    public static final int STATE_IS_IDLE = 0;
    public static final int STATE_IS_PARSE_END_ERROR = 2;
    public static final int STATE_IS_PARSE_END_SUC = 3;
    public static final int STATE_IS_WAIT_RESULT = 1;
    private static final String TAG = "AVMDLHostProcessor";
    private int mBackUpDelayedTime;
    private int mBackUpDelayedTimeForExpiredCache;
    private int mBackUpType;
    private int mEnableParallel;
    private Handler mHandler;
    public String mHost;
    public HashMap<AVMDLDNSParserListener, Integer> mListeners;
    private int mMainType;
    private BaseDNS[] mParsers;
    private int[] mStates;

    public AVMDLHostProcessor(String str, Handler handler, int i, int i2, int i3, int i4) {
        this.mMainType = i;
        this.mBackUpType = i2;
        this.mHandler = handler;
        this.mHost = str;
        this.mBackUpDelayedTime = i3;
        this.mEnableParallel = i4;
        this.mStates = new int[2];
        this.mParsers = new BaseDNS[2];
        for (int i5 = 0; i5 < 2; i5++) {
            this.mParsers[i5] = null;
        }
        for (int i6 = 0; i6 < 2; i6++) {
            this.mStates[i6] = 0;
        }
        this.mListeners = new HashMap<>();
    }

    public AVMDLHostProcessor(String str, Handler handler, int i, int i2, int i3, int i4, int i5) {
        this.mMainType = i;
        this.mBackUpType = i2;
        this.mHandler = handler;
        this.mHost = str;
        this.mBackUpDelayedTime = i3;
        this.mBackUpDelayedTimeForExpiredCache = i5;
        this.mEnableParallel = i4;
        this.mStates = new int[2];
        this.mParsers = new BaseDNS[2];
        for (int i6 = 0; i6 < 2; i6++) {
            this.mParsers[i6] = null;
        }
        for (int i7 = 0; i7 < 2; i7++) {
            this.mStates[i7] = 0;
        }
        this.mListeners = new HashMap<>();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
    
        if (r6 != 9) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void processMsg(final int i, final AVMDLDNSInfo aVMDLDNSInfo) {
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLHostProcessor$$ExternalSyntheticLambda8
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "----processor pro msg what:%d host:%s info:%s", Integer.valueOf(i), r1.mHost, aVMDLDNSInfo);
                return format;
            }
        });
        if (i != 5) {
            if (i == 6) {
                int[] iArr = this.mStates;
                int i2 = iArr[0];
                if ((i2 == 1 || i2 == 2 || i2 == 3 || this.mEnableParallel > 0) && iArr[1] == 0) {
                    AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLHostProcessor$$ExternalSyntheticLambda10
                        @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                        public final String get() {
                            String format;
                            format = String.format(Locale.US, "main dns is not end or enable parrallel and backup dns is idle call backup dns", new Object[0]);
                            return format;
                        }
                    });
                    doParseInternal(i, aVMDLDNSInfo);
                }
            }
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLHostProcessor$$ExternalSyntheticLambda12
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "****end processor pro msg what:%d host:%s info:%s", Integer.valueOf(i), r1.mHost, aVMDLDNSInfo);
                    return format;
                }
            });
        }
        if (this.mStates[0] == 0) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLHostProcessor$$ExternalSyntheticLambda9
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "main dns is idle call main dns", new Object[0]);
                    return format;
                }
            });
            doParseInternal(i, aVMDLDNSInfo);
        }
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLHostProcessor$$ExternalSyntheticLambda12
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "****end processor pro msg what:%d host:%s info:%s", Integer.valueOf(i), r1.mHost, aVMDLDNSInfo);
                return format;
            }
        });
    }

    public boolean isValidSourceId(final String str) {
        if (TextUtils.isEmpty(str)) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLHostProcessor$$ExternalSyntheticLambda0
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "id: %s is empty", str);
                    return format;
                }
            });
            return false;
        }
        for (final int i = 0; i < 2; i++) {
            BaseDNS baseDNS = this.mParsers[i];
            if (baseDNS != null && str.equals(baseDNS.mId)) {
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLHostProcessor$$ExternalSyntheticLambda11
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "id: %s is valid index: %d", str, Integer.valueOf(i));
                        return format;
                    }
                });
                return true;
            }
        }
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLHostProcessor$$ExternalSyntheticLambda13
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "id: %s is valid", str);
                return format;
            }
        });
        return false;
    }

    public void processResult(final int i, final AVMDLDNSInfo aVMDLDNSInfo) {
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLHostProcessor$$ExternalSyntheticLambda3
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "----process result what:%d id:%s host:%s", Integer.valueOf(i), r1.mId, aVMDLDNSInfo.mHost);
                return format;
            }
        });
        String str = ((i == 2 || i == 3) && aVMDLDNSInfo != null) ? aVMDLDNSInfo.mId : null;
        if (TextUtils.isEmpty(str)) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLHostProcessor$$ExternalSyntheticLambda4
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "****process result err id is empty", new Object[0]);
                    return format;
                }
            });
            return;
        }
        final int i2 = 0;
        while (true) {
            if (i2 >= 2) {
                break;
            }
            BaseDNS baseDNS = this.mParsers[i2];
            if (baseDNS == null || !str.equals(baseDNS.mId)) {
                i2++;
            } else {
                this.mParsers[i2].close();
                this.mParsers[i2] = null;
                if (i == 3) {
                    this.mStates[i2] = 3;
                } else if (i == 2) {
                    this.mStates[i2] = 2;
                }
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLHostProcessor$$ExternalSyntheticLambda5
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "****process result parser index:%d is end, be close", Integer.valueOf(i2));
                        return format;
                    }
                });
            }
        }
        if (i2 == 0 && i == 2) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLHostProcessor$$ExternalSyntheticLambda6
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "mian dns parse error, try back up dns", new Object[0]);
                    return format;
                }
            });
            processMsg(6, new AVMDLDNSInfo(this.mBackUpType, aVMDLDNSInfo.mHost, (String) null, 0L, (String) null, aVMDLDNSInfo.mTaskType));
        }
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLHostProcessor$$ExternalSyntheticLambda7
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "****end process result what:%d id:%s host:%s", Integer.valueOf(i), r1.mId, aVMDLDNSInfo.mHost);
                return format;
            }
        });
    }

    public boolean isEnd() {
        int i;
        for (int i2 = 0; i2 < 2; i2++) {
            if (this.mParsers[i2] != null && (i = this.mStates[i2]) != 3 && i != 2) {
                return false;
            }
        }
        AVMDLLog.m226d(TAG, "all dns parse is end");
        return true;
    }

    private void doParseInternal(final int i, final AVMDLDNSInfo aVMDLDNSInfo) {
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLHostProcessor$$ExternalSyntheticLambda16
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "----do parse internal what:%d info:%s", Integer.valueOf(i), aVMDLDNSInfo);
                return format;
            }
        });
        if (aVMDLDNSInfo == null) {
            return;
        }
        if ((i == 5 || i == 9) && this.mParsers[0] == null) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLHostProcessor$$ExternalSyntheticLambda17
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    return AVMDLHostProcessor.this.m4185lambda$doParseInternal$13$comssmediakitnetAVMDLHostProcessor(aVMDLDNSInfo);
                }
            });
            this.mStates[0] = 1;
            this.mParsers[0] = createDNSParser(aVMDLDNSInfo.mHost, this.mMainType, 0, aVMDLDNSInfo.mTaskType);
            this.mParsers[0].start();
            if (AVMDLDNSParser.mGloabalDisableParallelForExpiredCache <= 0) {
                Message message = new Message();
                message.what = 6;
                message.obj = aVMDLDNSInfo;
                if (this.mBackUpDelayedTime > 0 || this.mEnableParallel > 0) {
                    AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLHostProcessor$$ExternalSyntheticLambda20
                        @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                        public final String get() {
                            return AVMDLHostProcessor.this.m4188lambda$doParseInternal$16$comssmediakitnetAVMDLHostProcessor();
                        }
                    });
                    this.mHandler.sendMessageDelayed(message, this.mBackUpDelayedTime * 1000);
                }
            } else if (i == 9) {
                Message message2 = new Message();
                message2.what = 6;
                message2.obj = aVMDLDNSInfo;
                if (this.mBackUpDelayedTimeForExpiredCache > 0) {
                    AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLHostProcessor$$ExternalSyntheticLambda18
                        @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                        public final String get() {
                            return AVMDLHostProcessor.this.m4186lambda$doParseInternal$14$comssmediakitnetAVMDLHostProcessor();
                        }
                    });
                    this.mHandler.sendMessageDelayed(message2, this.mBackUpDelayedTimeForExpiredCache * 1000);
                }
            } else {
                Message message3 = new Message();
                message3.what = 6;
                message3.obj = aVMDLDNSInfo;
                if (this.mBackUpDelayedTime > 0 || this.mEnableParallel > 0) {
                    AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLHostProcessor$$ExternalSyntheticLambda19
                        @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                        public final String get() {
                            return AVMDLHostProcessor.this.m4187lambda$doParseInternal$15$comssmediakitnetAVMDLHostProcessor();
                        }
                    });
                    this.mHandler.sendMessageDelayed(message3, this.mBackUpDelayedTime * 1000);
                }
            }
        } else if (i == 6 && this.mParsers[1] == null) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLHostProcessor$$ExternalSyntheticLambda1
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    return AVMDLHostProcessor.this.m4189lambda$doParseInternal$17$comssmediakitnetAVMDLHostProcessor(aVMDLDNSInfo);
                }
            });
            this.mStates[1] = 1;
            this.mParsers[1] = createDNSParser(aVMDLDNSInfo.mHost, this.mBackUpType, 1, aVMDLDNSInfo.mTaskType);
            this.mParsers[1].start();
        }
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLHostProcessor$$ExternalSyntheticLambda2
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "****do parse internal end", new Object[0]);
                return format;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$doParseInternal$13$com-ss-mediakit-net-AVMDLHostProcessor, reason: not valid java name */
    public /* synthetic */ String m4185lambda$doParseInternal$13$comssmediakitnetAVMDLHostProcessor(AVMDLDNSInfo aVMDLDNSInfo) {
        return String.format(Locale.US, "create main dns type:%d host:%s", Integer.valueOf(this.mMainType), aVMDLDNSInfo.mHost);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$doParseInternal$14$com-ss-mediakit-net-AVMDLHostProcessor, reason: not valid java name */
    public /* synthetic */ String m4186lambda$doParseInternal$14$comssmediakitnetAVMDLHostProcessor() {
        return String.format(Locale.US, "mBackUpDelayedTimeForExpiredCache:%d send backup delay first", Integer.valueOf(this.mBackUpDelayedTimeForExpiredCache));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$doParseInternal$15$com-ss-mediakit-net-AVMDLHostProcessor, reason: not valid java name */
    public /* synthetic */ String m4187lambda$doParseInternal$15$comssmediakitnetAVMDLHostProcessor() {
        return String.format(Locale.US, "BackUpDelayedTime:%d enableparallel:%d send backup delay first", Integer.valueOf(this.mBackUpDelayedTime), Integer.valueOf(this.mEnableParallel));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$doParseInternal$16$com-ss-mediakit-net-AVMDLHostProcessor, reason: not valid java name */
    public /* synthetic */ String m4188lambda$doParseInternal$16$comssmediakitnetAVMDLHostProcessor() {
        return String.format(Locale.US, "BackUpDelayedTime:%d enableparallel:%d send backup delay first", Integer.valueOf(this.mBackUpDelayedTime), Integer.valueOf(this.mEnableParallel));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$doParseInternal$17$com-ss-mediakit-net-AVMDLHostProcessor, reason: not valid java name */
    public /* synthetic */ String m4189lambda$doParseInternal$17$comssmediakitnetAVMDLHostProcessor(AVMDLDNSInfo aVMDLDNSInfo) {
        return String.format(Locale.US, "create backup dns type:%d host:%s", Integer.valueOf(this.mBackUpType), aVMDLDNSInfo.mHost);
    }

    private BaseDNS createDNSParser(final String str, final int i, int i2, int i3) {
        CreateConstructor createConstructor;
        try {
            createConstructor = AVMDLDNSManager.getInstance().getCreateConstructor(i);
        } catch (Exception e) {
            e.printStackTrace();
            createConstructor = null;
        }
        CreateConstructor createConstructor2 = createConstructor;
        if (createConstructor2 != null) {
            return createConstructor2.createDns(str, null, i, this.mHandler, i3);
        }
        if (i == 4 && AVMDLDNSParser.mCustomHttpDNSParser != null) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLHostProcessor$$ExternalSyntheticLambda14
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "create custom httpdns parser for host:%s type:%d", str, Integer.valueOf(i));
                    return format;
                }
            });
            return new CustomHTTPDNS(str, this.mHandler, i3);
        }
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLHostProcessor$$ExternalSyntheticLambda15
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "create local dns parser for host:%s type:%d", str, Integer.valueOf(i));
                return format;
            }
        });
        return new LocalDNS(i, str, this.mHandler, i3);
    }
}
