package com.bytedance.ttnet.cronet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public class CronetDropReasonAccess extends Observable {
    public static final String DROP_REASON_LIST = "drop_reason_list";
    public static final String USER_BLOCKED_STATE = "user_blocked_state";
    private static volatile CronetDropReasonAccess sInstance;
    private CopyOnWriteArrayList<Integer> mDropReasonList = new CopyOnWriteArrayList<>();
    private volatile boolean mUserBlockedState;

    public static CronetDropReasonAccess inst() {
        if (sInstance == null) {
            synchronized (CronetDropReasonAccess.class) {
                if (sInstance == null) {
                    sInstance = new CronetDropReasonAccess();
                }
            }
        }
        return sInstance;
    }

    public void onDropReasonChanged(boolean z, List<Integer> list) {
        this.mUserBlockedState = z;
        this.mDropReasonList.clear();
        this.mDropReasonList.addAll(list);
        HashMap hashMap = new HashMap();
        hashMap.put(USER_BLOCKED_STATE, Boolean.valueOf(this.mUserBlockedState));
        hashMap.put(DROP_REASON_LIST, this.mDropReasonList);
        notifyDropReasonChangedObservers(hashMap);
    }

    private void notifyDropReasonChangedObservers(Map<String, Object> map) {
        setChanged();
        notifyObservers(map);
    }

    public boolean userBlockedState() {
        return this.mUserBlockedState;
    }

    public List<Integer> dropReasonList() {
        return this.mDropReasonList;
    }
}
