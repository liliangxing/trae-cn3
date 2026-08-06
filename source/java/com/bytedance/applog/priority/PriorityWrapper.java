package com.bytedance.applog.priority;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.webkit.ValueCallback;
import com.bytedance.applog.UriConfig;
import com.bytedance.applog.log.AbsSingleton;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.log.NativeLogWrapper;
import com.bytedance.applog.priority.original.Engine;
import com.bytedance.applog.priority.original.LocalLazy;
import com.bytedance.applog.priority.original.ValueLoader;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class PriorityWrapper {
    private final String appId;
    private final Context context;
    private volatile String dbDir;
    private final boolean logEnabled;
    private final Logger logger;
    private Engine originalEngine;
    private final PriorityCallback priorityCallback;

    /* renamed from: sp */
    private final SharedPreferences f61sp;
    private static final List<String> loggerTags = Collections.singletonList("Priority3");
    private static volatile boolean isNativeChannel = true;
    public static int RETURN_SUCCESS = 0;
    private static int RETURN_ERR_INVALID_PARAMS = 1;
    private static int RETURN_ERR_NO_APP_ID = 2;
    private static int RETURN_TRUE = 3;
    private static int RETURN_FALSE = 4;
    private static int RETURN_ERR_FUNCTION_FAILED = 9;
    private static int nativeDefaultThreadNum = 0;
    private static int nativeThreadType = 0;
    public static final AbsSingleton<Boolean> nativeLoader = new AbsSingleton<Boolean>() { // from class: com.bytedance.applog.priority.PriorityWrapper.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.applog.log.AbsSingleton
        public Boolean create(Object... objArr) {
            System.loadLibrary("applog_rust");
            return true;
        }
    };
    private final AtomicBoolean initialized = new AtomicBoolean(false);
    private String defaultReportHost = "";
    private String defaultReportPath = UriConfig.PATH_SEND;
    private volatile boolean isNativeConfigEmpty = false;

    private static native int flush(String str);

    private static native String getVersionConfig(String str);

    private static native int init(String str, String str2, String str3, String str4, PriorityCallback priorityCallback);

    private static native int initHooks();

    private static native boolean isEmpty(String str);

    private static native boolean isMatchEventType(String str, int i);

    private static native int onEvent(String str, int i, String str2, NativeLazyString nativeLazyString);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onHttpPostResponse(long j, PriorityHttpResponse priorityHttpResponse);

    private static native int setConfig(String str, String str2);

    private static native void setDefaultThreadNum(int i);

    private static native void setThreadType(int i);

    public static void setNativeChannel(boolean z) {
        isNativeChannel = z;
    }

    public PriorityWrapper(Context context, String str, String str2, boolean z, PriorityCallback priorityCallback) {
        this.originalEngine = null;
        LoggerImpl.global().info(loggerTags, "create priority wrapper with native: {}...", Boolean.valueOf(isNativeChannel));
        this.context = context;
        this.appId = str;
        this.f61sp = context.getSharedPreferences("applog_priority_wrapper@" + str, 0);
        this.logEnabled = z;
        Logger priorityCallbackLogger = z ? new PriorityCallbackLogger(priorityCallback) : new EmptyLogger();
        this.logger = priorityCallbackLogger;
        this.dbDir = getDefaultDbDir(context.getFilesDir().getAbsolutePath());
        this.priorityCallback = priorityCallback;
        parseDefaultReportUrl(str2);
        if (!isNativeChannel) {
            this.originalEngine = Engine.INSTANCE.create(context, str, priorityCallback, priorityCallbackLogger, this.defaultReportHost, this.defaultReportPath);
            return;
        }
        nativeLoader.get(new Object[0]);
        if (z) {
            NativeLogWrapper.setLogEnable(true);
        }
    }

    public void setDbDir(String str) {
        this.dbDir = str;
    }

    public void clearCache() {
        this.f61sp.edit().clear().commit();
    }

    public synchronized void initPriority() {
        Engine engine;
        LoggerImpl.global().info(loggerTags, "start to init priority...", new Object[0]);
        if (this.initialized.get()) {
            return;
        }
        try {
            if (!isNativeChannel && (engine = this.originalEngine) != null) {
                engine.init();
                this.initialized.set(true);
            } else {
                nativeInit();
            }
        } catch (Throwable th) {
            LoggerImpl.global().error(loggerTags, "init priority error!", th, new Object[0]);
        }
    }

    public boolean onPriorityEvent(int i, String str, ValueLoader<JSONObject> valueLoader) {
        boolean z;
        Engine engine;
        if (!isNativeChannel && (engine = this.originalEngine) != null) {
            if (engine.isEmpty()) {
                return false;
            }
            z = this.originalEngine.onEvent(str, i, new LocalLazy(valueLoader));
        } else {
            if (this.isNativeConfigEmpty || !isMatchEventType(this.appId, i)) {
                return false;
            }
            z = onEvent(this.appId, i, str, new NativeLazyString(valueLoader)) == RETURN_TRUE;
        }
        this.logger.info("onPriorityEvent -> match: {} , event: {}", Boolean.valueOf(z), str);
        return z;
    }

    public void addDefaultPriorityOptions(JSONObject jSONObject) {
        JSONObject versionConfig;
        if (jSONObject == null) {
            return;
        }
        try {
            if (isNativeChannel) {
                String versionConfig2 = getVersionConfig(this.appId);
                versionConfig = (versionConfig2 == null || versionConfig2.isEmpty()) ? null : new JSONObject(versionConfig2);
            } else {
                versionConfig = this.originalEngine.getVersionConfig();
            }
            if (versionConfig != null && versionConfig.length() > 0) {
                for (String str : PriorityConst.INSTANCE.getOPTIONS_KEYS()) {
                    Object optJSONObject = versionConfig.optJSONObject(str);
                    if (optJSONObject != null) {
                        jSONObject.put(str, optJSONObject);
                    }
                }
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("version", 0);
            Iterator<String> it = PriorityConst.INSTANCE.getOPTIONS_KEYS().iterator();
            while (it.hasNext()) {
                jSONObject.put(it.next(), jSONObject2);
            }
        } catch (Throwable th) {
            LoggerImpl.global().error(loggerTags, "addDefaultPriorityOptions for version config error!", th, new Object[0]);
            if (this.priorityCallback.isMonitorEnabled()) {
                this.priorityCallback.monitorError("priority addDefaultPriorityOptions error", th.toString());
            }
        }
    }

    public void parsePriorityConfigFromServerResponse(JSONObject jSONObject) {
        boolean z;
        Engine engine;
        if (jSONObject == null || !this.initialized.get()) {
            return;
        }
        Iterator<String> it = PriorityConst.INSTANCE.getRESPONSE_KEYS().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (jSONObject.has(it.next())) {
                z = true;
                break;
            }
        }
        if (z) {
            LoggerImpl.global().info(loggerTags, "start update priority config by default response: {}...", jSONObject);
            if (!isNativeChannel && (engine = this.originalEngine) != null) {
                engine.setConfig(jSONObject);
            } else if (setConfig(this.appId, jSONObject.toString()) == RETURN_SUCCESS) {
                this.isNativeConfigEmpty = isEmpty(this.appId);
            }
        }
    }

    public void flush() {
        Engine engine;
        LoggerImpl.global().info(loggerTags, "start flush priority {}...", this.appId);
        if (!isNativeChannel && (engine = this.originalEngine) != null) {
            engine.flush();
        } else {
            flush(this.appId);
        }
    }

    public static void setNativeDefaultThreadNum(int i) {
        nativeDefaultThreadNum = Math.max(i, 0);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public enum NativeThreadType {
        Native(0),
        Android(1);

        private final int value;

        NativeThreadType(int i) {
            this.value = i;
        }
    }

    public static void setNativeThreadType(NativeThreadType nativeThreadType2) {
        nativeThreadType = nativeThreadType2.value;
    }

    private void nativeInit() {
        IAppLogLogger global = LoggerImpl.global();
        List<String> list = loggerTags;
        global.info(list, "start init native priority {}...", this.appId);
        if (this.logEnabled) {
            NativeLogWrapper.setLogEnable(true);
        }
        setDefaultThreadNum(nativeDefaultThreadNum);
        setThreadType(nativeThreadType);
        int init = init(this.appId, this.dbDir, this.defaultReportHost, this.defaultReportPath, new NativePriorityCallbackImpl(this.priorityCallback, this.logger, new ValueCallback() { // from class: com.bytedance.applog.priority.PriorityWrapper$$ExternalSyntheticLambda0
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                PriorityWrapper.onHttpPostResponse(((Long) r1.getFirst()).longValue(), (PriorityHttpResponse) ((Pair) obj).getSecond());
            }
        }));
        if (init == RETURN_SUCCESS) {
            this.initialized.set(true);
            this.isNativeConfigEmpty = isEmpty(this.appId);
        }
        LoggerImpl.global().info(list, "init native priority completed: {}.", Integer.valueOf(init));
    }

    private String getDefaultDbDir(String str) {
        File file = new File(str + "/applog_priority_db");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private void parseDefaultReportUrl(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            Uri parse = Uri.parse(str);
            this.defaultReportHost = parse.getScheme() + "://" + parse.getHost();
            this.defaultReportPath = parse.getPath();
        } catch (Throwable th) {
            LoggerImpl.global().error(loggerTags, "parseDefaultReportUrl error: ", th, new Object[0]);
        }
    }

    private static void tryLoadLibrary(String... strArr) {
        for (String str : strArr) {
            try {
                System.loadLibrary(str);
                return;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
