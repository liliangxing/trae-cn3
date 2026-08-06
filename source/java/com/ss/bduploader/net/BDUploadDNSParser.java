package com.ss.bduploader.net;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.ss.bduploader.BDUploadLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BDUploadDNSParser {
    public static final int BDUPLOAD_DNS_BACKUP_TYPE = 1;
    public static final int BDUPLOAD_DNS_DEFAULT_EXPIRED_TIME = 2;
    public static final int BDUPLOAD_DNS_MAIN_DELAYED_USE_BACKUP_TIME = 3;
    public static final int BDUPLOAD_DNS_MAIN_TYPE = 0;
    public static final int DNS_TYPE_HTTP_ALI = 1;
    public static final int DNS_TYPE_HTTP_GOOGLE = 3;
    public static final int DNS_TYPE_HTTP_OWN = 2;
    public static final int DNS_TYPE_LOCAL = 0;
    public static final int MSG_IS_PARSER_ERROR = 2;
    public static final int MSG_IS_PARSER_RETRY = 1;
    public static final int MSG_IS_PARSER_SUCCESS = 3;
    public static final int PARSER_IS_BACKUP = 1;
    public static final int PARSER_IS_MAIN = 0;
    private static final String TAG = "BDUploadDNSParser";
    public static int mGlobalBackType = 2;
    public static int mGlobalBackUpDelayedTime = 0;
    public static int mGlobalDefaultExpiredTime = 60;
    public static int mGlobalMainType;
    private static BDUploadDNSParser mInstance;
    private Handler mHandler;
    private int mRefCount;
    private int mState;
    private HandlerThread mThread;
    private int mType;
    private int mTimeOut = 5;
    private Lock mLock = new ReentrantLock();
    private Map<String, BDUploadHostProcessor> mProcessors = new HashMap();

    public void release() {
    }

    public static BDUploadDNSParser getInstance() {
        if (mInstance == null) {
            synchronized (BDUploadDNSParser.class) {
                if (mInstance == null) {
                    mInstance = new BDUploadDNSParser();
                }
            }
        }
        return mInstance;
    }

    public static void setIntValue(int i, int i2) {
        BDUploadLog.m161d(TAG, String.format("****set value:%d for key:%d", Integer.valueOf(i2), Integer.valueOf(i)));
        if (i == 0) {
            mGlobalMainType = i2;
            return;
        }
        if (i == 1) {
            mGlobalBackType = i2;
        } else if (i == 2) {
            mGlobalDefaultExpiredTime = i2;
        } else {
            if (i != 3) {
                return;
            }
            mGlobalBackUpDelayedTime = i2;
        }
    }

    public BDUploadDNSParser() {
        HandlerThread handlerThread = new HandlerThread(TAG);
        this.mThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mThread.getLooper()) { // from class: com.ss.bduploader.net.BDUploadDNSParser.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                BDUploadDNSInfo bDUploadDNSInfo = message.obj != null ? (BDUploadDNSInfo) message.obj : null;
                BDUploadLog.m161d(BDUploadDNSParser.TAG, String.format("----receive msg what:%d info:%s", Integer.valueOf(message.what), bDUploadDNSInfo));
                int i = message.what;
                if (i == 1) {
                    BDUploadDNSParser.this.processParseMsg(message.what, bDUploadDNSInfo);
                } else if (i == 2) {
                    BDUploadDNSParser.this.proccessFailMsg(message.what, bDUploadDNSInfo);
                } else if (i == 3) {
                    BDUploadDNSParser.this.proccessSucMsg(message.what, bDUploadDNSInfo);
                }
                BDUploadLog.m161d(BDUploadDNSParser.TAG, String.format("****end proc msg what:%d info:%s", Integer.valueOf(message.what), bDUploadDNSInfo));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processParseMsg(int i, BDUploadDNSInfo bDUploadDNSInfo) {
        if (bDUploadDNSInfo == null || bDUploadDNSInfo.mHost == null) {
            BDUploadLog.m161d(TAG, String.format("proc parser msg  fail, info or host is null", new Object[0]));
            return;
        }
        BDUploadLog.m161d(TAG, String.format("----proc parser msg what:%d host:%s", Integer.valueOf(i), bDUploadDNSInfo.mHost));
        this.mLock.lock();
        try {
            BDUploadHostProcessor bDUploadHostProcessor = this.mProcessors.get(bDUploadDNSInfo.mHost);
            if (bDUploadHostProcessor != null) {
                BDUploadLog.m161d(TAG, String.format("----get processor:%s host:%s", bDUploadHostProcessor, bDUploadDNSInfo.mHost));
                bDUploadHostProcessor.processMsg(i, bDUploadDNSInfo);
            } else {
                BDUploadLog.m161d(TAG, String.format("****get processor null for host:%s", bDUploadDNSInfo.mHost));
            }
            this.mLock.unlock();
            BDUploadLog.m161d(TAG, String.format("****end proc parser msg", new Object[0]));
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void proccessSucMsg(int i, BDUploadDNSInfo bDUploadDNSInfo) {
        if (bDUploadDNSInfo == null || bDUploadDNSInfo.mHost == null) {
            BDUploadLog.m161d(TAG, String.format("proc suc msg  fail, info or host is null", new Object[0]));
            return;
        }
        BDUploadLog.m161d(TAG, String.format("----proc suc msg what:%d host:%s", Integer.valueOf(i), bDUploadDNSInfo.mHost));
        this.mLock.lock();
        try {
            BDUploadHostProcessor bDUploadHostProcessor = this.mProcessors.get(bDUploadDNSInfo.mHost);
            BDUploadLog.m161d(TAG, String.format("get processor:%s host:%s", bDUploadHostProcessor, bDUploadDNSInfo.mHost));
            if (bDUploadHostProcessor != null && bDUploadHostProcessor.mListeners != null) {
                for (BDUploadDNSParserListener bDUploadDNSParserListener : bDUploadHostProcessor.mListeners.keySet()) {
                    if (bDUploadDNSParserListener != null) {
                        BDUploadLog.m161d(TAG, String.format("listener:%s oncompletion suc", bDUploadDNSParserListener));
                        bDUploadDNSParserListener.onCompletion(0, bDUploadDNSInfo.mHost, bDUploadDNSInfo.mIpList, bDUploadDNSInfo.mExpiredTime, null);
                    }
                }
                bDUploadHostProcessor.mListeners.clear();
                this.mProcessors.remove(bDUploadDNSInfo.mHost);
                BDUploadLog.m161d(TAG, String.format("remove all listeners and remove host", new Object[0]));
            }
            this.mLock.unlock();
            BDUploadLog.m161d(TAG, String.format("****end proc suc msg", new Object[0]));
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void proccessFailMsg(int i, BDUploadDNSInfo bDUploadDNSInfo) {
        if (bDUploadDNSInfo == null || bDUploadDNSInfo.mHost == null) {
            BDUploadLog.m161d(TAG, String.format("proc fail msg  fail, info or host is null", new Object[0]));
            return;
        }
        BDUploadLog.m161d(TAG, String.format("----proc fail msg what:%d host:%s", Integer.valueOf(i), bDUploadDNSInfo.mHost));
        this.mLock.lock();
        try {
            BDUploadHostProcessor bDUploadHostProcessor = this.mProcessors.get(bDUploadDNSInfo.mHost);
            BDUploadLog.m161d(TAG, String.format("get processor:%s host:%s", bDUploadHostProcessor, bDUploadDNSInfo.mHost));
            if (bDUploadHostProcessor != null && bDUploadHostProcessor.isValidSourceId(bDUploadDNSInfo.mId)) {
                bDUploadHostProcessor.processResult(i, bDUploadDNSInfo);
                if (bDUploadHostProcessor.isEnd()) {
                    BDUploadLog.m161d(TAG, String.format("processor end, notify result", new Object[0]));
                    for (BDUploadDNSParserListener bDUploadDNSParserListener : bDUploadHostProcessor.mListeners.keySet()) {
                        if (bDUploadDNSParserListener != null) {
                            BDUploadLog.m161d(TAG, String.format("listener:%s oncompletion fail", bDUploadDNSParserListener));
                            bDUploadDNSParserListener.onCompletion(0, bDUploadDNSInfo.mHost, null, 0L, null);
                        }
                    }
                    bDUploadHostProcessor.mListeners.clear();
                    this.mProcessors.remove(bDUploadDNSInfo.mHost);
                } else {
                    BDUploadLog.m161d(TAG, String.format("processor is not end", new Object[0]));
                }
            }
            this.mLock.unlock();
            BDUploadLog.m161d(TAG, String.format("****end proc fail msg what", new Object[0]));
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public void addHost(String str, BDUploadDNSParserListener bDUploadDNSParserListener) {
        addListenerInternal(str, bDUploadDNSParserListener);
    }

    public void removeHost(String str, BDUploadDNSParserListener bDUploadDNSParserListener) {
        removeListenerInternal(str, bDUploadDNSParserListener);
    }

    public void postParseHostMsg(String str, int i) {
        BDUploadDNSInfo bDUploadDNSInfo = new BDUploadDNSInfo(i, str, null, 0L, null);
        Message message = new Message();
        message.what = 0;
        message.obj = bDUploadDNSInfo;
        this.mHandler.sendMessage(message);
    }

    private void addListenerInternal(String str, BDUploadDNSParserListener bDUploadDNSParserListener) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        BDUploadLog.m161d(TAG, String.format("---add listener:%s for host:%s", bDUploadDNSParserListener, str));
        this.mLock.lock();
        try {
            BDUploadHostProcessor bDUploadHostProcessor = this.mProcessors.get(str);
            BDUploadLog.m161d(TAG, String.format("get processor:%s", bDUploadHostProcessor));
            if (bDUploadHostProcessor == null) {
                bDUploadHostProcessor = new BDUploadHostProcessor(str, this.mHandler, mGlobalMainType, mGlobalBackType, mGlobalBackUpDelayedTime);
                BDUploadLog.m161d(TAG, String.format("create processor:%s", bDUploadHostProcessor));
                z = true;
            } else {
                z = false;
            }
            if (bDUploadDNSParserListener != null && !bDUploadHostProcessor.mListeners.containsKey(bDUploadDNSParserListener)) {
                BDUploadLog.m161d(TAG, String.format("add listener", new Object[0]));
                bDUploadHostProcessor.mListeners.put(bDUploadDNSParserListener, 1);
            }
            this.mProcessors.put(str, bDUploadHostProcessor);
            if (z) {
                BDUploadLog.m161d(TAG, String.format("new processor implement parse", new Object[0]));
                bDUploadHostProcessor.processMsg(0, new BDUploadDNSInfo(mGlobalMainType, str, null, 0L, null));
            }
            this.mLock.unlock();
            BDUploadLog.m161d(TAG, String.format("****end add listener", new Object[0]));
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    private void removeListenerInternal(String str, BDUploadDNSParserListener bDUploadDNSParserListener) {
        if (TextUtils.isEmpty(str) || bDUploadDNSParserListener == null) {
            return;
        }
        BDUploadLog.m161d(TAG, String.format("---remove listener:%s for host:%s", bDUploadDNSParserListener, str));
        this.mLock.lock();
        try {
            BDUploadHostProcessor bDUploadHostProcessor = this.mProcessors.get(str);
            BDUploadLog.m161d(TAG, String.format("get processor:%s", bDUploadHostProcessor));
            if (bDUploadHostProcessor != null) {
                BDUploadLog.m161d(TAG, String.format("remove listener", new Object[0]));
                bDUploadHostProcessor.mListeners.remove(bDUploadDNSParserListener);
            }
            if (bDUploadHostProcessor != null && bDUploadHostProcessor.mListeners.size() == 0) {
                BDUploadLog.m161d(TAG, String.format("listeners empty remove host from processors", new Object[0]));
                this.mProcessors.remove(str);
            }
            this.mLock.unlock();
            BDUploadLog.m161d(TAG, String.format("****end remove listener", new Object[0]));
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }
}
