package com.bytedance.applog.util;

import android.content.Context;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.AppLogHelper;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.log.AbsSingleton;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.server.Api;
import com.bytedance.applog.store.BaseData;
import com.bytedance.applog.store.Event;
import com.bytedance.applog.store.EventMisc;
import com.bytedance.applog.store.EventV3;
import com.bytedance.applog.store.Launch;
import com.bytedance.applog.store.Terminate;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class EventsSenderUtils {
    private static final List<String> logTags = Collections.singletonList("EventsSenderUtils");
    private static final Map<String, IEventsSender> appEventSenderMap = new ConcurrentHashMap();
    private static final AbsSingleton<Boolean> hasEventVerifyClass = new AbsSingleton<Boolean>() { // from class: com.bytedance.applog.util.EventsSenderUtils.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.applog.log.AbsSingleton
        public Boolean create(Object... objArr) {
            return Boolean.valueOf(ReflectUtils.hasClass("com.bytedance.applog.et_verify.EventVerify"));
        }
    };

    private static IEventsSender getSender(String str) {
        if (!hasEventVerifyClass.get(new Object[0]).booleanValue()) {
            return null;
        }
        Map<String, IEventsSender> map = appEventSenderMap;
        if (!map.containsKey(str)) {
            IEventsSender findIEventsSender = findIEventsSender(str);
            map.put(str, findIEventsSender);
            return findIEventsSender;
        }
        return map.get(str);
    }

    public static void setEventsSenderEnable(String str, boolean z, Context context) {
        IEventsSender sender = getSender(str);
        if (sender != null) {
            sender.setEnable(z, context);
        } else {
            LoggerImpl.global().error(logTags, "can't find ET, should compile with ET", new Object[0]);
        }
    }

    public static void putEvent(String str, String str2, JSONArray jSONArray) {
        IEventsSender sender = getSender(str);
        if (sender != null) {
            sender.putEvent(str2, jSONArray);
        }
    }

    public static boolean isEnable(String str) {
        IEventsSender sender;
        if (hasEventVerifyClass.get(new Object[0]).booleanValue() && (sender = getSender(str)) != null) {
            return sender.isEnable();
        }
        return false;
    }

    public static void setEventVerifyHost(String str, String str2) {
        IEventsSender sender = getSender(str);
        if (sender != null) {
            sender.setEventVerifyUrl(str2);
        } else {
            LoggerImpl.global().error(logTags, "can't find ET, should compile with ET", new Object[0]);
        }
    }

    public static String getType(BaseData baseData) {
        if (baseData instanceof Event) {
            return "event";
        }
        if (baseData instanceof EventV3) {
            return Api.KEY_V3;
        }
        if (baseData instanceof EventMisc) {
            return "log_data";
        }
        if (baseData instanceof Launch) {
            return "launch";
        }
        if (baseData instanceof Terminate) {
            return "terminate";
        }
        return null;
    }

    private static IEventsSender findIEventsSender(String str) {
        if (!hasEventVerifyClass.get(new Object[0]).booleanValue()) {
            return null;
        }
        AppLogInstance instanceByAppId = AppLogHelper.getInstanceByAppId(str);
        if (instanceByAppId == null) {
            instanceByAppId = (AppLogInstance) AppLog.getInstance();
        }
        try {
            Constructor<?> constructor = Class.forName("com.bytedance.applog.et_verify.EventVerify").getConstructor(AppLogInstance.class);
            constructor.setAccessible(true);
            IEventsSender iEventsSender = (IEventsSender) constructor.newInstance(instanceByAppId);
            if (iEventsSender == null) {
                LoggerImpl.global().warn(logTags, "can't find event verify, should compile with ET", new Object[0]);
            } else {
                LoggerImpl.global().debug(logTags, "found event sender: {}", iEventsSender);
            }
            return iEventsSender;
        } catch (Exception unused) {
            LoggerImpl.global().warn(logTags, "can't find event verify, should compile with ET", new Object[0]);
            return null;
        } catch (Throwable th) {
            LoggerImpl.global().warn(logTags, "can't find event verify, should compile with ET", new Object[0]);
            throw th;
        }
    }

    public static void loginEtWithScheme(String str, String str2, Context context) {
        IEventsSender sender = getSender(str);
        if (sender != null) {
            sender.loginEtWithScheme(str2, context);
        } else {
            LoggerImpl.global().error(logTags, "can't find ET, should compile with ET", new Object[0]);
        }
    }

    public static void setEventVerifyInterval(String str, long j) {
        IEventsSender sender = getSender(str);
        if (sender != null) {
            sender.setEventVerifyInterval(j);
        } else {
            LoggerImpl.global().error(logTags, "can't find ET, should compile with ET", new Object[0]);
        }
    }

    public static void setSpecialKeys(String str, List<String> list) {
        IEventsSender sender = getSender(str);
        if (sender != null) {
            sender.setSpecialKeys(list);
        } else {
            LoggerImpl.global().error(logTags, "can't find ET, should compile with ET", new Object[0]);
        }
    }
}
