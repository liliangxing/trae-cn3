package com.bytedance.networkstackapplib;

import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes4.dex */
public class TTNETScoreAPI {
    private static final String INTERCEPTOR_NAME = "MY_PROXY_INTERCEPTOR";
    public static final int MAX_WAIT_TIME = 3000;
    private static final String TAG = "TTNETScoreAPI:";
    private static Method sAddInterceptor = null;
    private static boolean sAppSupportTTNET = false;
    private static boolean sHasStarted = false;
    private static boolean sInitForReflect = false;
    private static Object sInterceptor = null;
    private static int sLastScore = -1;
    private static Method sRemoveInterceptor = null;
    public static int sSampleCircle = 5;
    public static long sSampleDebugLog = 0;
    public static long sSampleGapTime = 15000;
    public static int sSampleSize = 26;
    public static long sSampleSpeed = 100000;
    public static int sSampleTimeFeed = 2700;
    public static int sSampleTimeImg = 256;
    public static int sSampleTimeNormal = 300;
    private static final Object sWeakNetLock = new Object();
    private static AtomicInteger mSequenceNumber = new AtomicInteger(0);
    private static RingBuffer<MyReqInfo> sSampleReqs = new RingBuffer<>(MyReqInfo.class, 20);
    private static ParamConfig mConfigByApp = null;
    private static ArrayList<IWeakNetworkCallBack> sAllCallbacks = new ArrayList<>();
    private static Class<?> Chain = null;
    private static Class<?> Request = null;
    private static Class<?> SsResponse = null;
    private static Method methodRequset = null;
    private static Method methodGetPath = null;
    private static Method methodProceed = null;
    private static Method methodIsSuccessful = null;
    private static Method methodRaw = null;
    private static Method methodGetBody = null;
    private static Method methodLength = null;
    private static boolean isReflectSuccess = false;

    /* loaded from: classes4.dex */
    public interface IWeakNetworkCallBack {
        void onScoreChange(int i);
    }

    /* loaded from: classes4.dex */
    public static class ParamConfig {
        public int configCircle = 5;
        public int configSize = 26;
        public int configTimeImg = 256;
        public int configTimeFeed = 2700;
        public int configTimeNormal = 288;
        public int configGoodSpeed = AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength;
        public int configGapTime = 15000;
        public int configDebugLog = 0;
    }

    private static int getScoreLevel(int i) {
        if (i < 30) {
            return 0;
        }
        if (i < 60) {
            return 1;
        }
        return i < 80 ? 2 : 3;
    }

    public static synchronized void setParamConfig(ParamConfig paramConfig) {
        synchronized (TTNETScoreAPI.class) {
            mConfigByApp = paramConfig;
        }
    }

    /* loaded from: classes4.dex */
    public static class MyReqInfo {
        public long startTime;
        public String path = null;
        public long costTime = 0;
        public int reqId = 0;
        public long badTime = 0;
        public long speed = 0;
        public boolean hasException = false;

        public boolean isHealthy(long j) {
            String str;
            if (this.hasException) {
                return false;
            }
            if (this.speed > TTNETScoreAPI.sSampleSpeed) {
                return true;
            }
            if (this.costTime == 0 && this.speed == 0 && (str = this.path) != null && (str.startsWith("/obj/") || this.path.startsWith("/tos-cn-") || this.path.startsWith("/large/"))) {
                return true;
            }
            long j2 = this.costTime;
            if (j2 == 0) {
                j2 = j - this.startTime;
            }
            return j2 <= this.badTime;
        }

        public MyReqInfo() {
            this.startTime = 0L;
            this.startTime = System.currentTimeMillis();
        }

        public String toString() {
            return "MyReqInfo{path='" + this.path + "', costTime=" + this.costTime + ", speed=" + this.speed + AbstractJsonLexerKt.END_OBJ;
        }
    }

    private static int isWeakNetwork() {
        MyReqInfo[] array;
        Object obj = sWeakNetLock;
        synchronized (obj) {
            array = sSampleReqs.toArray();
        }
        int length = array.length;
        if (length < 6) {
            return -1;
        }
        long j = sSampleReqs.getLatestItem().startTime - sSampleReqs.getEarliestItem().startTime;
        if (j > sSampleGapTime) {
            synchronized (obj) {
                sSampleReqs.clear();
            }
            return -1;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        for (MyReqInfo myReqInfo : array) {
            if (myReqInfo.isHealthy(currentTimeMillis)) {
                i++;
                hashSet.add(myReqInfo.toString());
            } else {
                hashSet2.add(myReqInfo.toString());
            }
        }
        int size = hashSet.size();
        int size2 = (size * 100) / (size + hashSet2.size());
        if (size2 > 0 && getScoreLevel(size2) != getScoreLevel(sLastScore) && Math.abs(size2 - sLastScore) > 12 && sSampleDebugLog == 1) {
            System.out.println("TTNETScoreAPI: gaptime =" + j);
            System.out.println("TTNETScoreAPI: successCount = " + i + ",badcount = " + (length - i));
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                System.out.println("TTNETScoreAPI: goodReqs = " + ((String) it.next()));
            }
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                System.out.println("TTNETScoreAPI: badReqs = " + ((String) it2.next()));
            }
        }
        return size2;
    }

    public static long getPathBadCostTime(String str) {
        int i;
        if (str == null) {
            return 0L;
        }
        if (str.startsWith("/img/") || str.startsWith("/article/content/")) {
            i = sSampleTimeImg;
        } else if (str.startsWith("/api/news/feed/v88")) {
            i = sSampleTimeFeed;
        } else if (str.startsWith("/obj/") || str.startsWith("/tos-cn-") || str.startsWith("/large/")) {
            i = sSampleTimeImg;
        } else if (str.startsWith("/gecko/server/") || str.startsWith("/monitor/collect/batch/")) {
            i = sSampleTimeFeed / 3;
        } else if (str.startsWith("/client_impr/impr_recycle/")) {
            i = sSampleTimeNormal;
        } else {
            if (!str.startsWith("/search/suggest/")) {
                return 0L;
            }
            i = sSampleTimeNormal * 4;
        }
        return i;
    }

    private static void initForWeakNetParam() {
        try {
            ParamConfig paramConfig = mConfigByApp;
            if (paramConfig != null) {
                sSampleCircle = paramConfig.configCircle;
                sSampleSize = mConfigByApp.configSize;
                sSampleTimeFeed = mConfigByApp.configTimeFeed;
                sSampleTimeImg = mConfigByApp.configTimeImg;
                sSampleTimeNormal = mConfigByApp.configTimeNormal;
                sSampleSpeed = mConfigByApp.configGoodSpeed;
                sSampleGapTime = mConfigByApp.configGapTime;
                sSampleDebugLog = mConfigByApp.configDebugLog;
            } else {
                int intSystemProperties = getIntSystemProperties("debug.weaknet.circle");
                if (intSystemProperties > 0) {
                    sSampleCircle = intSystemProperties;
                }
                int intSystemProperties2 = getIntSystemProperties("debug.weaknet.size");
                if (intSystemProperties2 > 0) {
                    sSampleSize = intSystemProperties2;
                }
                int intSystemProperties3 = getIntSystemProperties("debug.weaknet.feed");
                if (intSystemProperties3 > 0) {
                    sSampleTimeFeed = intSystemProperties3;
                }
                int intSystemProperties4 = getIntSystemProperties("debug.weaknet.img");
                if (intSystemProperties4 > 0) {
                    sSampleTimeImg = intSystemProperties4;
                }
                int intSystemProperties5 = getIntSystemProperties("debug.weaknet.normal");
                if (intSystemProperties5 > 0) {
                    sSampleTimeNormal = intSystemProperties5;
                }
                int intSystemProperties6 = getIntSystemProperties("debug.weaknet.speed");
                if (intSystemProperties6 > 0) {
                    sSampleSpeed = intSystemProperties6;
                }
                int intSystemProperties7 = getIntSystemProperties("debug.weaknet.gaptime");
                if (intSystemProperties7 > 0) {
                    sSampleGapTime = intSystemProperties7;
                }
                int intSystemProperties8 = getIntSystemProperties("debug.weaknet.debuglog");
                if (intSystemProperties8 >= 0) {
                    sSampleDebugLog = intSystemProperties8;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sSampleSize < 10) {
            sSampleSize = 10;
        }
        sSampleReqs = new RingBuffer<>(MyReqInfo.class, sSampleSize);
    }

    private static int getIntSystemProperties(String str) {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getInt", String.class, Integer.TYPE);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(null, str, 0)).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static synchronized boolean registerWeakNetworkCallBack(IWeakNetworkCallBack iWeakNetworkCallBack) {
        synchronized (TTNETScoreAPI.class) {
            if (!sAllCallbacks.contains(iWeakNetworkCallBack)) {
                sAllCallbacks.add(iWeakNetworkCallBack);
            }
        }
        return true;
    }

    public static synchronized boolean unregisterWeakNetworkCallBack(IWeakNetworkCallBack iWeakNetworkCallBack) {
        synchronized (TTNETScoreAPI.class) {
            if (sAllCallbacks.contains(iWeakNetworkCallBack)) {
                sAllCallbacks.remove(iWeakNetworkCallBack);
            }
        }
        return true;
    }

    private static void notifyScoreChange(int i) {
        if (sAllCallbacks.size() > 0) {
            Iterator<IWeakNetworkCallBack> it = sAllCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onScoreChange(i);
                if (sSampleDebugLog == 1) {
                    System.out.println("TTNETScoreAPI:weaknetwork_notifyscore score=" + i);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class MyInterceptorHandler implements InvocationHandler {
        private MyInterceptorHandler() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if (method.getName().equals("intercept")) {
                    return TTNETScoreAPI.handleRequest(objArr[0]);
                }
                if (method.getName().equals("equals")) {
                    if (objArr[0].toString().equals(TTNETScoreAPI.INTERCEPTOR_NAME)) {
                        return true;
                    }
                    return false;
                }
                if (method.getName().equals("toString")) {
                    return TTNETScoreAPI.INTERCEPTOR_NAME;
                }
                if (method.getName().equals("hashCode")) {
                    return -1425398335;
                }
                return method.invoke(this, objArr);
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object handleRequest(Object obj) throws Throwable {
        int isWeakNetwork;
        long currentTimeMillis = System.currentTimeMillis();
        MyReqInfo myReqInfo = new MyReqInfo();
        Object obj2 = null;
        try {
            if (!sInitForReflect) {
                Class<?> cls = Class.forName("com.bytedance.retrofit2.intercept.Interceptor$Chain");
                Class<?> cls2 = Class.forName("com.bytedance.retrofit2.client.Request");
                Class<?> cls3 = Class.forName("com.bytedance.retrofit2.SsResponse");
                Class<?> cls4 = Class.forName("com.bytedance.retrofit2.client.Response");
                Class<?> cls5 = Class.forName("com.bytedance.retrofit2.mime.TypedInput");
                Method declaredMethod = cls.getDeclaredMethod(OauthTokenTriggerScene.REQUEST, new Class[0]);
                methodRequset = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = cls2.getDeclaredMethod("getPath", new Class[0]);
                methodGetPath = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = cls.getDeclaredMethod("proceed", cls2);
                methodProceed = declaredMethod3;
                declaredMethod3.setAccessible(true);
                Method declaredMethod4 = cls3.getDeclaredMethod("isSuccessful", new Class[0]);
                methodIsSuccessful = declaredMethod4;
                declaredMethod4.setAccessible(true);
                Method declaredMethod5 = cls3.getDeclaredMethod(AccountMonitorConstants.CommonParameter.RAW, new Class[0]);
                methodRaw = declaredMethod5;
                declaredMethod5.setAccessible(true);
                Method declaredMethod6 = cls4.getDeclaredMethod("getBody", new Class[0]);
                methodGetBody = declaredMethod6;
                declaredMethod6.setAccessible(true);
                Method declaredMethod7 = cls5.getDeclaredMethod("length", new Class[0]);
                methodLength = declaredMethod7;
                declaredMethod7.setAccessible(true);
                sInitForReflect = true;
                initForWeakNetParam();
            }
            Object invoke = methodRequset.invoke(obj, new Object[0]);
            Object invoke2 = methodGetPath.invoke(invoke, new Object[0]);
            int incrementAndGet = mSequenceNumber.incrementAndGet();
            myReqInfo.path = (String) invoke2;
            myReqInfo.reqId = incrementAndGet;
            myReqInfo.badTime = getPathBadCostTime((String) invoke2);
            if (myReqInfo.badTime > 0) {
                synchronized (sWeakNetLock) {
                    sSampleReqs.append(myReqInfo);
                }
            }
            if (incrementAndGet % sSampleCircle == 0 && (isWeakNetwork = isWeakNetwork()) > 0 && getScoreLevel(isWeakNetwork) != getScoreLevel(sLastScore) && Math.abs(isWeakNetwork - sLastScore) > 12) {
                sLastScore = isWeakNetwork;
                notifyScoreChange(isWeakNetwork);
            }
            obj2 = methodProceed.invoke(obj, invoke);
            isReflectSuccess = true;
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            myReqInfo.costTime = currentTimeMillis2;
            if (((Boolean) methodIsSuccessful.invoke(obj2, new Object[0])).booleanValue()) {
                long longValue = ((Long) methodLength.invoke(methodGetBody.invoke(methodRaw.invoke(obj2, new Object[0]), new Object[0]), new Object[0])).longValue();
                long j = (1000 * longValue) / currentTimeMillis2;
                if (sSampleDebugLog == 1) {
                    System.out.println("TTNETScoreAPI:weaknetwork_interceptor reply=" + invoke2 + ",requestCost=" + currentTimeMillis2 + ",len=" + longValue + ",speed=" + j);
                }
                myReqInfo.speed = j;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            isReflectSuccess = true;
            System.currentTimeMillis();
            myReqInfo.hasException = true;
            throw e4.getTargetException();
        }
        if (!isReflectSuccess) {
            stopCheck();
        }
        return obj2;
    }

    public static synchronized boolean isAppContainsTtnet() {
        synchronized (TTNETScoreAPI.class) {
            boolean z = true;
            if (sAddInterceptor != null && sRemoveInterceptor != null && sInterceptor != null) {
                return true;
            }
            try {
                Class<?> cls = Class.forName("com.bytedance.ttnet.utils.RetrofitUtils");
                Class<?> cls2 = Class.forName("com.bytedance.retrofit2.intercept.Interceptor");
                sInterceptor = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls2}, new MyInterceptorHandler());
                sAddInterceptor = cls.getDeclaredMethod("addInterceptor", cls2);
                sRemoveInterceptor = cls.getDeclaredMethod("removeInterceptor", cls2);
                sAddInterceptor.setAccessible(true);
                sRemoveInterceptor.setAccessible(true);
            } catch (Exception e) {
                e.printStackTrace();
                sAddInterceptor = null;
                sRemoveInterceptor = null;
                sInterceptor = null;
                z = false;
            }
            System.out.println("TTNETScoreAPI:isAppContainsTtnet = " + z);
            sAppSupportTTNET = z;
            return z;
        }
    }

    public static int getLastScore() {
        if (sAppSupportTTNET) {
            return sLastScore;
        }
        return -2;
    }

    public static synchronized void startCheck() {
        synchronized (TTNETScoreAPI.class) {
            if (!sHasStarted) {
                try {
                    sAddInterceptor.invoke(null, sInterceptor);
                    sHasStarted = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static synchronized void stopCheck() {
        synchronized (TTNETScoreAPI.class) {
            if (sHasStarted) {
                try {
                    sRemoveInterceptor.invoke(null, sInterceptor);
                    sHasStarted = false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
