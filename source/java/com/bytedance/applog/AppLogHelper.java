package com.bytedance.applog;

import android.text.TextUtils;
import com.bytedance.applog.store.BaseData;
import com.bytedance.applog.util.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AppLogHelper {
    public static AppLogInstanceMatcher isHandleLifecycleMatcher = new AppLogInstanceMatcher() { // from class: com.bytedance.applog.AppLogHelper.1
        @Override // com.bytedance.applog.AppLogHelper.AppLogInstanceMatcher
        public boolean match(AppLogInstance appLogInstance) {
            return appLogInstance.getInitConfig() != null && appLogInstance.getInitConfig().isHandleLifeCycle();
        }
    };

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface AppLogInstanceHandler {
        void handle(AppLogInstance appLogInstance);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface AppLogInstanceMatcher {
        boolean match(AppLogInstance appLogInstance);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface BaseDataLoader {
        BaseData load();
    }

    public static boolean hasInstanceByAppId(final String str) {
        return !TextUtils.isEmpty(str) && matchInstance(new AppLogInstanceMatcher() { // from class: com.bytedance.applog.AppLogHelper.2
            @Override // com.bytedance.applog.AppLogHelper.AppLogInstanceMatcher
            public boolean match(AppLogInstance appLogInstance) {
                return str.equals(appLogInstance.getAppId());
            }
        });
    }

    public static AppLogInstance getInstanceByAppId(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (AppLogInstance appLogInstance : AppLogInstance.getAllInstances()) {
            if (str.equals(appLogInstance.getAppId())) {
                return appLogInstance;
            }
        }
        return null;
    }

    public static IAppLogInstance getInstanceByAppIdOrGlobalDefault(String str) {
        AppLogInstance instanceByAppId = getInstanceByAppId(str);
        return instanceByAppId != null ? instanceByAppId : AppLog.getInstance();
    }

    public static void receive(BaseData baseData) {
        for (AppLogInstance appLogInstance : AppLogInstance.getAllInstances()) {
            if (!Utils.isNotEmpty(baseData.getAppId()) || !Utils.isNotEmpty(appLogInstance.getAppId()) || Utils.equal(appLogInstance.getAppId(), baseData.getAppId())) {
                appLogInstance.receive(baseData.m432clone());
            }
        }
    }

    public static void receive(String[] strArr) {
        Iterator<AppLogInstance> it = AppLogInstance.getAllInstances().iterator();
        while (it.hasNext()) {
            it.next().receive((String[]) strArr.clone());
        }
    }

    public static void receiveIf(BaseData baseData, AppLogInstanceMatcher appLogInstanceMatcher) {
        for (AppLogInstance appLogInstance : AppLogInstance.getAllInstances()) {
            if (appLogInstanceMatcher.match(appLogInstance)) {
                appLogInstance.receive(baseData.m432clone());
            }
        }
    }

    public static void receiveIf(BaseDataLoader baseDataLoader, AppLogInstanceMatcher appLogInstanceMatcher) {
        BaseData baseData = null;
        for (AppLogInstance appLogInstance : AppLogInstance.getAllInstances()) {
            if (appLogInstanceMatcher.match(appLogInstance)) {
                if (baseData == null) {
                    baseData = baseDataLoader.load();
                }
                appLogInstance.receive(baseData.m432clone());
            }
        }
    }

    public static List<AppLogInstance> filterInstances(AppLogInstanceMatcher appLogInstanceMatcher) {
        ArrayList arrayList = new ArrayList();
        for (AppLogInstance appLogInstance : AppLogInstance.getAllInstances()) {
            if (appLogInstanceMatcher.match(appLogInstance)) {
                arrayList.add(appLogInstance);
            }
        }
        return arrayList;
    }

    public static boolean matchInstance(AppLogInstanceMatcher appLogInstanceMatcher) {
        Iterator<AppLogInstance> it = AppLogInstance.getAllInstances().iterator();
        while (it.hasNext()) {
            if (appLogInstanceMatcher.match(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static void handleAll(AppLogInstanceHandler appLogInstanceHandler) {
        Iterator<AppLogInstance> it = AppLogInstance.getAllInstances().iterator();
        while (it.hasNext()) {
            appLogInstanceHandler.handle(it.next());
        }
    }

    public static boolean isGlobalInstance(IAppLogInstance iAppLogInstance) {
        return AppLog.getInstance() == iAppLogInstance;
    }

    public static boolean isGlobalInstanceInitialized() {
        return !TextUtils.isEmpty(AppLog.getInstance().getAppId());
    }

    public static String getInstanceSpName(IAppLogInstance iAppLogInstance, String str) {
        return isGlobalInstance(iAppLogInstance) ? str : str + "_" + iAppLogInstance.getAppId();
    }
}
