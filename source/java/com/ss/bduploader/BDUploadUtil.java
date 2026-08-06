package com.ss.bduploader;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.boringssl.so.BoringsslLoaderWrapper;
import com.ss.bduploader.logupload.VideoEventEngineUploader;
import com.ss.bduploader.net.BDUploadThreadPool;
import com.ss.bduploader.util.BDUrlDispatchInterface;
import com.ss.mediakit.vcnlib.VcnlibloadWrapper;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class BDUploadUtil {
    public static String DiskResumeConfigDir = "DiskResumeConfigDir";
    public static String RetryStatesInfoDir = "RetryStatesInfoDir";
    public static String SpeedTestcontextDir = "SpeedTestcontextDir";
    private static final int UPDATE_PEROID = 300000;
    private static volatile boolean mIsLibraryLoaded;
    private static volatile boolean mIsXQuicLoaded;
    private static volatile BDLibraryLoaderProxy mProxy;
    private static volatile String mServerIP;
    private static volatile long mServerIPTime;
    public static String sdkConfigDir;
    private static final ReentrantLock mLock = new ReentrantLock();
    public static VideoEventEngineUploader eventEngineUploader = null;
    public static BDUrlDispatchInterface urlDispatch = null;
    public static Boolean mEnableDisaptch = false;
    public static Boolean mEnableNativeLog = false;
    public static Boolean mSkipUploadLog = false;

    public static void setLoadProxy(BDLibraryLoaderProxy bDLibraryLoaderProxy) {
        ReentrantLock reentrantLock = mLock;
        reentrantLock.lock();
        if (bDLibraryLoaderProxy != null) {
            try {
                mProxy = bDLibraryLoaderProxy;
            } catch (Throwable th) {
                mLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
    }

    private static boolean loadVcn() {
        if (!VcnlibloadWrapper.tryLoadVcnlib()) {
            Log.e("ttmn", "Can't load vcn");
        }
        if (VcnlibloadWrapper.tryLoadVcnverifylib()) {
            return true;
        }
        Log.e("ttmn", "Can't load vcn verify");
        return true;
    }

    private static boolean loadLibrary() {
        if (mProxy == null) {
            return true;
        }
        if (mProxy != null && !mIsLibraryLoaded) {
            boolean z = BoringsslLoaderWrapper.loadBoringssl() || mProxy.loadLibrary("ttopenssl");
            mProxy.loadLibrary("vcn");
            mProxy.loadLibrary("vcnverify");
            boolean loadLibrary = mProxy.loadLibrary("xquic");
            boolean loadLibrary2 = mProxy.loadLibrary("xquicclient");
            boolean loadLibrary3 = mProxy.loadLibrary("bdvideouploader");
            mIsXQuicLoaded = loadLibrary && loadLibrary2;
            mIsLibraryLoaded = z && loadLibrary3;
        }
        return mIsLibraryLoaded;
    }

    public static synchronized boolean initInternal(StringBuffer stringBuffer) {
        synchronized (BDUploadUtil.class) {
            if (!loadLibrary()) {
                Log.e("ttmn", String.format("proxy library load fail", new Object[0]));
                return false;
            }
            Log.d("ttmn", "use defaullt loadLibrary()");
            if (systemLoadInit(mProxy != null, stringBuffer) != 1) {
                Log.e("ttmn", String.format("library has not been loaded", new Object[0]));
                return false;
            }
            Log.d("ttmn", "init()");
            return true;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:8|(1:10)|11|(1:13)|14|(1:16)|(3:17|18|19)|20|(1:22)|23|24) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b1, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b2, code lost:
    
        android.util.Log.e("ttmn", "Can't load bdvideoUploader library: " + r4.toString());
        r5.append(r4.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0092, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0093, code lost:
    
        android.util.Log.e("ttmn", "other exception when loading bdvideoUploader library: " + r4.toString());
        r5.append(r4.toString());
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d5 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int systemLoadInit(boolean z, StringBuffer stringBuffer) {
        boolean z2;
        if (mIsLibraryLoaded) {
            Log.d("ttmn", "had load success");
            return 1;
        }
        mIsLibraryLoaded = z;
        Log.d("ttmn", "mIsLibraryLoaded:" + mIsLibraryLoaded);
        if (!mIsLibraryLoaded) {
            if (!BoringsslLoaderWrapper.loadBoringssl()) {
                Log.e("ttmn", "load boringssl fail!");
            }
            if (!VcnlibloadWrapper.tryLoadVcnlib()) {
                Log.e("ttmn", "Can't load vcn");
            }
            if (!VcnlibloadWrapper.tryLoadVcnverifylib()) {
                Log.e("ttmn", "Can't load vcn verify");
            }
            try {
                System.loadLibrary("xquic");
                System.loadLibrary("xquicclient");
                z2 = true;
            } catch (UnsatisfiedLinkError e) {
                Log.e("ttmn", "Can't load xquic library: " + e);
                z2 = false;
                mIsXQuicLoaded = z2;
                if (!mIsXQuicLoaded) {
                }
                System.loadLibrary("bdvideouploader");
                mIsLibraryLoaded = true;
                if (!mIsLibraryLoaded) {
                }
            } catch (Throwable th) {
                Log.e("ttmn", "other exception when loading xquic library: " + th);
                z2 = false;
                mIsXQuicLoaded = z2;
                if (!mIsXQuicLoaded) {
                }
                System.loadLibrary("bdvideouploader");
                mIsLibraryLoaded = true;
                if (!mIsLibraryLoaded) {
                }
            }
            mIsXQuicLoaded = z2;
            if (!mIsXQuicLoaded) {
                Log.e("ttmn", "Can't load xquic client");
            }
            System.loadLibrary("bdvideouploader");
            mIsLibraryLoaded = true;
        }
        return !mIsLibraryLoaded ? -1 : 1;
    }

    public static synchronized boolean xquicAvalilable() {
        boolean z;
        synchronized (BDUploadUtil.class) {
            z = mIsXQuicLoaded;
        }
        return z;
    }

    public static String mapToString(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                Object obj = map.get(str);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put(str, obj);
                }
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject mapToJSON(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                Object obj = map.get(str);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put(str, obj);
                }
            }
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static synchronized void updateDNSServerIP() {
        synchronized (BDUploadUtil.class) {
            if (SystemClock.elapsedRealtime() - mServerIPTime < 300000) {
                return;
            }
            new Thread(new Runnable() { // from class: com.ss.bduploader.BDUploadUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        InetAddress byName = InetAddress.getByName("whoami.akamai.net");
                        if (byName != null) {
                            String unused = BDUploadUtil.mServerIP = byName.getHostAddress();
                            long unused2 = BDUploadUtil.mServerIPTime = SystemClock.elapsedRealtime();
                        }
                    } catch (UnknownHostException unused3) {
                    }
                }
            }).start();
        }
    }

    public static synchronized String getDNSServerIP() {
        String str;
        synchronized (BDUploadUtil.class) {
            if (SystemClock.elapsedRealtime() - mServerIPTime >= 300000) {
                BDUploadThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.bduploader.BDUploadUtil$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        BDUploadUtil.lambda$getDNSServerIP$0();
                    }
                });
            }
            str = mServerIP;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$getDNSServerIP$0() {
        try {
            InetAddress byName = InetAddress.getByName("whoami.akamai.net");
            if (byName != null) {
                mServerIP = byName.getHostAddress();
                mServerIPTime = SystemClock.elapsedRealtime();
            }
        } catch (UnknownHostException unused) {
        }
    }

    public static Map<String, String> jsonToHashMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String valueOf = String.valueOf(keys.next());
            hashMap.put(valueOf, jSONObject.optString(valueOf));
        }
        return hashMap;
    }

    public static void setSDKConfigDir(String str) {
        String str2 = sdkConfigDir;
        if (str2 == null || str2.length() <= 0) {
            sdkConfigDir = str;
        }
    }

    public static int createDir(String str) {
        File file = new File(str);
        if (file.exists()) {
            Log.v("ttmn", str + " has already exists");
            return 1;
        }
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        if (file.mkdirs()) {
            Log.d("ttmn", str + "create success");
            return 1;
        }
        Log.e("ttmn", str + " failed");
        return -1;
    }

    public static void setVideoEventUpload(VideoEventEngineUploader videoEventEngineUploader) {
        eventEngineUploader = videoEventEngineUploader;
    }

    public static void setDispatchImp(BDUrlDispatchInterface bDUrlDispatchInterface) {
        urlDispatch = bDUrlDispatchInterface;
    }

    public static void setEnableDispatch(Boolean bool) {
        mEnableDisaptch = bool;
    }

    public static void setEnableNativeLog(Boolean bool) {
        mEnableNativeLog = bool;
    }

    public static void setSkipUploadLog(Boolean bool) {
        mSkipUploadLog = bool;
    }
}
