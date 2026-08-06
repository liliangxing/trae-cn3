package com.bytedance.crash;

import android.text.TextUtils;
import com.bytedance.crash.anr.AnrInfoParser;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.ListMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class UserDataCenter {
    private static boolean isIgnoreExceptionTag;
    private static boolean sEnableCloseBgAnr;
    private static boolean sEnsureOpt;
    private static boolean sOptDumpTrace;
    private static boolean sOptNpthInit;
    private static boolean sProcessTrackDiskOpt;
    private static boolean sTerminateOpt;
    private ICrashFilter mCrashFilter;
    private CrashUploadCallback mCrashUploadCallback;
    private boolean mIsTagOptEnable;
    private volatile boolean isAlreadyPut = true;
    private final ConcurrentHashMap<String, String> mCustomTagHashMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Integer, String> mSdkVersionHashMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, String> mInnerSdkVersionHashMap = new ConcurrentHashMap<>();
    private final ListMap<CrashType, AttachUserData> mAttachUserDataListMap = new ListMap<>();
    private final ListMap<CrashType, ICrashCallback> mCrashCallbackListMap = new ListMap<>();
    private final ListMap<CrashType, CrashInfoCallback> mCrashInfoCallbackListMap = new ListMap<>();
    private final List<IOOMCallback> mOomCallbacksList = new CopyOnWriteArrayList();
    private final List<IOOMCallback> mHprofCallbacksList = new CopyOnWriteArrayList();
    private final List<IANRCallback> mAnrCallbacksList = new CopyOnWriteArrayList();
    private final List<IPreANRCallback> mPreAnrCallbackList = new CopyOnWriteArrayList();
    private final List<IAnrUploadCallback> mAnrUploadCallbackList = new CopyOnWriteArrayList();
    private final Map<String, LinkedList<String>> mPriorityCrashReasonDataMap = new ConcurrentHashMap();
    private final Map<String, Integer> mCrashReasonLimitMap = new ConcurrentHashMap();
    private final ListMap<CrashType, IPreCrashCallback> mPreCrashCallbacks = new ListMap<>();
    private final ListMap<CrashType, IUserCrashInfoCallback> mUserCrashInfoCallbackListMap = new ListMap<>();

    @Deprecated
    public static boolean isOpenNewAnrMonitor() {
        return false;
    }

    public void setCrashReasonArrayLimit(String str, int i) {
        this.mCrashReasonLimitMap.put(str, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeCrashReasonArray(String str) {
        this.mPriorityCrashReasonDataMap.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addCrashReasonArray(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (!this.mPriorityCrashReasonDataMap.containsKey(str)) {
            synchronized (this.mPriorityCrashReasonDataMap) {
                if (!this.mPriorityCrashReasonDataMap.containsKey(str)) {
                    this.mPriorityCrashReasonDataMap.put(str, new LinkedList<>());
                }
            }
        }
        LinkedList<String> linkedList = this.mPriorityCrashReasonDataMap.get(str);
        if (linkedList == null) {
            return;
        }
        synchronized (linkedList) {
            if (linkedList.contains(str2)) {
                return;
            }
            if (this.mCrashReasonLimitMap.containsKey(str)) {
                if (linkedList.size() > this.mCrashReasonLimitMap.get(str).intValue()) {
                    linkedList.removeFirst();
                }
                linkedList.add(str2);
            } else {
                linkedList.add(str2);
            }
        }
    }

    public Map<String, JSONArray> getCustomData() {
        HashMap hashMap = new HashMap();
        for (String str : this.mPriorityCrashReasonDataMap.keySet()) {
            JSONArray jSONArray = new JSONArray();
            LinkedList<String> linkedList = this.mPriorityCrashReasonDataMap.get(str);
            if (linkedList != null) {
                synchronized (linkedList) {
                    Iterator<String> it = linkedList.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next());
                    }
                }
            }
            hashMap.put(str, jSONArray);
        }
        return hashMap;
    }

    public void addAttachUserData(AttachUserData attachUserData, CrashType crashType) {
        if (attachUserData != null) {
            synchronized (this.mAttachUserDataListMap) {
                if (crashType == CrashType.ALL) {
                    this.mAttachUserDataListMap.addMulti(attachUserData, CrashType.ANR, CrashType.LAUNCH, CrashType.JAVA, CrashType.DART, CrashType.GAME, CrashType.NATIVE);
                } else {
                    this.mAttachUserDataListMap.add(crashType, attachUserData);
                }
            }
        }
    }

    public void removeAttachUserData(CrashType crashType, AttachUserData attachUserData) {
        if (attachUserData != null) {
            synchronized (this.mAttachUserDataListMap) {
                if (crashType == CrashType.ALL) {
                    this.mAttachUserDataListMap.removeAll(attachUserData);
                } else {
                    this.mAttachUserDataListMap.removeInList(crashType, attachUserData);
                }
            }
        }
    }

    public List<AttachUserData> getAttachUserData(CrashType crashType) {
        List<AttachUserData> list;
        synchronized (this.mAttachUserDataListMap) {
            list = this.mAttachUserDataListMap.getList(crashType);
        }
        return list;
    }

    public Map<String, String> getAttachUserDataToMap(CrashType crashType) {
        List<AttachUserData> list;
        synchronized (this.mAttachUserDataListMap) {
            list = this.mAttachUserDataListMap.getList(crashType);
        }
        HashMap hashMap = new HashMap();
        Iterator<AttachUserData> it = list.iterator();
        while (it.hasNext()) {
            Map<? extends String, ? extends String> userData = it.next().getUserData(crashType);
            if (userData != null) {
                hashMap.putAll(userData);
            }
        }
        return hashMap;
    }

    public JSONObject getAttachUserDataToJson(CrashType crashType) {
        List<AttachUserData> list = this.mAttachUserDataListMap.getList(crashType);
        HashMap hashMap = new HashMap();
        Iterator<AttachUserData> it = list.iterator();
        while (it.hasNext()) {
            Map<? extends String, ? extends String> userData = it.next().getUserData(crashType);
            if (userData != null) {
                hashMap.putAll(userData);
            }
        }
        return new JSONObject(hashMap);
    }

    public void setTagOpt(boolean z) {
        if (!this.mIsTagOptEnable && z) {
            this.mIsTagOptEnable = true;
            if (!this.mCustomTagHashMap.isEmpty() && NativeBridge.isSoLoaded()) {
                this.isAlreadyPut = false;
                DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.UserDataCenter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (Map.Entry entry : UserDataCenter.this.mCustomTagHashMap.entrySet()) {
                            String str = (String) entry.getKey();
                            String str2 = (String) entry.getValue();
                            if (!TextUtils.isEmpty(str)) {
                                NativeBridge.register(str, str2);
                            }
                        }
                        UserDataCenter.this.isAlreadyPut = true;
                    }
                });
            }
        }
        this.mIsTagOptEnable = z;
    }

    public boolean isTagOptEnable() {
        return this.mIsTagOptEnable;
    }

    public void addCustomTags(Map<? extends String, ? extends String> map) {
        if (map != null) {
            try {
                if (map.isEmpty()) {
                    return;
                }
                for (Map.Entry<? extends String, ? extends String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (NativeBridge.isSoLoaded() && this.mIsTagOptEnable) {
                        if (value == null) {
                            NativeBridge.remove(key);
                        } else if (!TextUtils.isEmpty(key)) {
                            NativeBridge.register(key, value);
                        }
                    } else if (value == null) {
                        this.mCustomTagHashMap.remove(key);
                    } else if (key != null) {
                        this.mCustomTagHashMap.put(key, value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void addCustomTag(String str, String str2) {
        if (NativeBridge.isSoLoaded() && this.mIsTagOptEnable) {
            if (str2 == null) {
                NativeBridge.remove(str);
                return;
            } else {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                NativeBridge.register(str, str2);
                return;
            }
        }
        if (str2 == null) {
            this.mCustomTagHashMap.remove(str);
        } else if (str != null) {
            this.mCustomTagHashMap.put(str, str2);
        }
    }

    public void removeCustomTag(String str) {
        if (NativeBridge.isSoLoaded() && this.mIsTagOptEnable) {
            if (this.isAlreadyPut) {
                NativeBridge.remove(str);
                return;
            } else {
                this.mCustomTagHashMap.remove(str);
                return;
            }
        }
        this.mCustomTagHashMap.remove(str);
    }

    public Map<String, String> getCustomTags() {
        if (TagService.getTagCacheService() != null) {
            return TagService.getTags();
        }
        if (NativeBridge.isSoLoaded() && this.mIsTagOptEnable) {
            return NativeBridge.getTags();
        }
        return this.mCustomTagHashMap;
    }

    public Map<String, String> getCacheCustomTags() {
        if (NativeBridge.isSoLoaded() && this.mIsTagOptEnable) {
            return NativeBridge.getTags();
        }
        return this.mCustomTagHashMap;
    }

    public void clearCustomTags() {
        this.mCustomTagHashMap.clear();
    }

    public JSONObject getCustomTagsToJson() {
        return new JSONObject(getCustomTags());
    }

    public void addCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        synchronized (this.mCrashCallbackListMap) {
            if (crashType == CrashType.ALL) {
                this.mCrashCallbackListMap.addMulti(iCrashCallback, CrashType.NATIVE, CrashType.ANR, CrashType.JAVA, CrashType.LAUNCH);
            } else {
                this.mCrashCallbackListMap.add(crashType, iCrashCallback);
            }
        }
    }

    public void removeCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        synchronized (this.mCrashCallbackListMap) {
            if (crashType == CrashType.ALL) {
                this.mCrashCallbackListMap.removeAll(iCrashCallback);
            } else {
                this.mCrashCallbackListMap.removeInList(crashType, iCrashCallback);
            }
        }
    }

    public List<ICrashCallback> getCrashCallback(CrashType crashType) {
        List<ICrashCallback> list;
        synchronized (this.mCrashCallbackListMap) {
            list = this.mCrashCallbackListMap.getList(crashType);
        }
        return list;
    }

    public void addCrashInfoCallback(CrashInfoCallback crashInfoCallback, CrashType crashType) {
        synchronized (this.mCrashInfoCallbackListMap) {
            if (crashType == CrashType.ALL) {
                this.mCrashInfoCallbackListMap.addMulti(crashInfoCallback, CrashType.NATIVE, CrashType.ANR, CrashType.JAVA, CrashType.LAUNCH);
            } else {
                this.mCrashInfoCallbackListMap.add(crashType, crashInfoCallback);
            }
        }
    }

    public void removeCrashInfoCallback(CrashInfoCallback crashInfoCallback, CrashType crashType) {
        synchronized (this.mCrashInfoCallbackListMap) {
            if (crashType == CrashType.ALL) {
                this.mCrashInfoCallbackListMap.removeAll(crashInfoCallback);
            } else {
                this.mCrashInfoCallbackListMap.removeInList(crashType, crashInfoCallback);
            }
        }
    }

    public List<CrashInfoCallback> getCrashInfoCallback(CrashType crashType) {
        List<CrashInfoCallback> list;
        synchronized (this.mCrashInfoCallbackListMap) {
            list = this.mCrashInfoCallbackListMap.getList(crashType);
        }
        return list;
    }

    public void addOOMCallback(IOOMCallback iOOMCallback) {
        this.mOomCallbacksList.add(iOOMCallback);
    }

    public void addANRCallback(IANRCallback iANRCallback) {
        this.mAnrCallbacksList.add(iANRCallback);
    }

    public List<IANRCallback> getANRCallback() {
        return this.mAnrCallbacksList;
    }

    public void removeOOMCallback(IOOMCallback iOOMCallback) {
        this.mOomCallbacksList.remove(iOOMCallback);
    }

    public List<IOOMCallback> getOOMCallback() {
        return this.mOomCallbacksList;
    }

    public void addHprofCallback(IOOMCallback iOOMCallback) {
        this.mHprofCallbacksList.add(iOOMCallback);
    }

    public void removeHprofCallback(IOOMCallback iOOMCallback) {
        this.mHprofCallbacksList.remove(iOOMCallback);
    }

    public List<IOOMCallback> getHprofCallback() {
        return this.mHprofCallbacksList;
    }

    public void registerSdkInfo(int i, String str) {
        this.mSdkVersionHashMap.put(Integer.valueOf(i), str);
    }

    public ConcurrentHashMap<Integer, String> getSdkInfo() {
        return this.mSdkVersionHashMap;
    }

    public void registerInnerSdkInfo(String str, String str2) {
        this.mInnerSdkVersionHashMap.put(str, str2);
    }

    public ConcurrentHashMap<String, String> getInnerSDKInfo() {
        return this.mInnerSdkVersionHashMap;
    }

    public JSONObject getInnerSdkInfoToJson() {
        return new JSONObject(this.mInnerSdkVersionHashMap);
    }

    public void setCrashFilter(ICrashFilter iCrashFilter) {
        this.mCrashFilter = iCrashFilter;
    }

    public boolean isIgnored(Thread thread, Throwable th) {
        try {
            ICrashFilter iCrashFilter = this.mCrashFilter;
            if (iCrashFilter != null) {
                return !iCrashFilter.onJavaCrashFilter(th, thread);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean isIgnored(CrashType crashType, JSONObject jSONObject) {
        if (this.mCrashFilter == null) {
            return false;
        }
        if (crashType == CrashType.NATIVE) {
            return !this.mCrashFilter.onNativeCrashFilter(jSONObject.optString("data"), jSONObject.optString(CrashBody.CRASH_THREAD_NAME));
        }
        if (crashType == CrashType.ANR && (this.mCrashFilter instanceof ICrashFilterExt)) {
            return !((ICrashFilterExt) this.mCrashFilter).onAnrFilter(jSONObject.optString("data"), jSONObject.optString(AnrInfoParser.ANR_INFO));
        }
        return false;
    }

    public boolean beforeUpload(CrashType crashType, JSONObject jSONObject) {
        try {
            if (isIgnored(crashType, jSONObject)) {
                return true;
            }
            CrashUploadCallback crashUploadCallback = this.mCrashUploadCallback;
            if (crashUploadCallback != null) {
                crashUploadCallback.beforeUpload(crashType, jSONObject);
            }
            if (crashType != CrashType.ANR) {
                return false;
            }
            long optLong = jSONObject.optLong("app_start_time");
            long optLong2 = jSONObject.optLong("crash_time");
            String optString = jSONObject.optString("process_name");
            Iterator<IAnrUploadCallback> it = this.mAnrUploadCallbackList.iterator();
            while (it.hasNext()) {
                it.next().onCrash(optLong, optLong2, optString, jSONObject);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void setUploadCallback(CrashUploadCallback crashUploadCallback) {
        this.mCrashUploadCallback = crashUploadCallback;
    }

    public static boolean isIgnoreExceptionTag() {
        return isIgnoreExceptionTag;
    }

    public static void setIgnoreExceptionTagEnable(boolean z) {
        isIgnoreExceptionTag = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setTerminateOpt(boolean z) {
        sTerminateOpt = z;
    }

    @Deprecated
    public static boolean isTerminateOpt() {
        return sTerminateOpt && isOpenNewAnrMonitor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void optProcessTrackDisk() {
        sProcessTrackDiskOpt = true;
    }

    public static boolean isProcessTrackDiskOpt() {
        return sProcessTrackDiskOpt;
    }

    public static void setOpenDumpTraceOpt(boolean z) {
        sOptDumpTrace = z;
    }

    public static boolean isOptDumpTrace() {
        return sOptDumpTrace;
    }

    static void setEnsureOpt(boolean z) {
        sEnsureOpt = z;
    }

    public static boolean isEnsureOpt() {
        return sEnsureOpt;
    }

    public static void setNpthInitOptEnable(boolean z) {
        sOptNpthInit = z;
    }

    public static boolean isOptNpthInit() {
        return sOptNpthInit;
    }

    public static void setCloseBgAnr(boolean z) {
        sEnableCloseBgAnr = z;
    }

    public static boolean isCloseBgAnr() {
        return sEnableCloseBgAnr;
    }

    public void addPreANRCallback(IPreANRCallback iPreANRCallback) {
        this.mPreAnrCallbackList.add(iPreANRCallback);
    }

    public void removePreANRCallback(IPreANRCallback iPreANRCallback) {
        this.mPreAnrCallbackList.remove(iPreANRCallback);
    }

    public List<IPreANRCallback> getPreANRCallback() {
        return this.mPreAnrCallbackList;
    }

    public void addAnrUploadCallback(IAnrUploadCallback iAnrUploadCallback) {
        this.mAnrUploadCallbackList.add(iAnrUploadCallback);
    }

    public List<IAnrUploadCallback> getAnrUploadCallback() {
        return this.mAnrUploadCallbackList;
    }

    public void addPreCrashCallback(IPreCrashCallback iPreCrashCallback, CrashType crashType) {
        synchronized (this.mPreCrashCallbacks) {
            if (crashType == CrashType.ALL) {
                this.mPreCrashCallbacks.addMulti(iPreCrashCallback, CrashType.NATIVE, CrashType.ANR, CrashType.JAVA, CrashType.LAUNCH);
            } else {
                this.mPreCrashCallbacks.add(crashType, iPreCrashCallback);
            }
        }
    }

    public void removePreCrashCallback(IPreCrashCallback iPreCrashCallback, CrashType crashType) {
        synchronized (this.mPreCrashCallbacks) {
            if (crashType == CrashType.ALL) {
                this.mPreCrashCallbacks.removeAll(iPreCrashCallback);
            } else {
                this.mPreCrashCallbacks.removeInList(crashType, iPreCrashCallback);
            }
        }
    }

    public List<IPreCrashCallback> getPreCrashCallback(CrashType crashType) {
        List<IPreCrashCallback> list;
        synchronized (this.mPreCrashCallbacks) {
            list = this.mPreCrashCallbacks.getList(crashType);
        }
        return list;
    }

    public void addUserCrashInfoCallback(IUserCrashInfoCallback iUserCrashInfoCallback, CrashType crashType) {
        if (iUserCrashInfoCallback != null) {
            synchronized (this.mUserCrashInfoCallbackListMap) {
                if (crashType == CrashType.ALL) {
                    this.mUserCrashInfoCallbackListMap.addMulti(iUserCrashInfoCallback, CrashType.ANR, CrashType.LAUNCH, CrashType.JAVA, CrashType.DART, CrashType.GAME, CrashType.NATIVE);
                } else {
                    this.mUserCrashInfoCallbackListMap.add(crashType, iUserCrashInfoCallback);
                }
            }
        }
    }

    public void removeUserCrashInfoCallback(IUserCrashInfoCallback iUserCrashInfoCallback, CrashType crashType) {
        if (iUserCrashInfoCallback != null) {
            synchronized (this.mUserCrashInfoCallbackListMap) {
                if (crashType == CrashType.ALL) {
                    this.mUserCrashInfoCallbackListMap.removeAll(iUserCrashInfoCallback);
                } else {
                    this.mUserCrashInfoCallbackListMap.removeInList(crashType, iUserCrashInfoCallback);
                }
            }
        }
    }

    public List<IUserCrashInfoCallback> getUserCrashInfoCallback(CrashType crashType) {
        List<IUserCrashInfoCallback> list;
        synchronized (this.mUserCrashInfoCallbackListMap) {
            list = this.mUserCrashInfoCallbackListMap.getList(crashType);
        }
        return list;
    }
}
