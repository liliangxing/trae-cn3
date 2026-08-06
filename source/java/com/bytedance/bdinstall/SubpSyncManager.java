package com.bytedance.bdinstall;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.bdinstall.util.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class SubpSyncManager {
    private static final String EVENT_INSTALL_INFO_CHANGE = "install_info_change";
    static final String F_NAME_MULTI_PROCESS = "ug_install_op_pref";
    public static final String KEY_EVENT_AID = "aid";
    private static final String KEY_EVENT_KEY = "key";
    private static final String KEY_EVENT_VALUE = "value";
    private final Context mContext;
    private AtomicBoolean mHasObserve;
    private static final Map<String, String> sCacheValues = new ConcurrentHashMap();
    private static final Map<String, List<OnUpdateListener>> sListeners = new ConcurrentHashMap();
    private static final Singleton<SubpSyncManager> INSTANCE = new Singleton<SubpSyncManager>() { // from class: com.bytedance.bdinstall.SubpSyncManager.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.bdinstall.util.Singleton
        public SubpSyncManager create(Object... objArr) {
            return new SubpSyncManager((Context) objArr[0]);
        }
    };

    /* loaded from: classes3.dex */
    public interface OnUpdateListener {
        void onUpdate(String str, String str2);
    }

    private SubpSyncManager(Context context) {
        this.mHasObserve = new AtomicBoolean(false);
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SubpSyncManager inst(Context context) {
        return INSTANCE.get(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendSubpEvent(final String str, String str2, String str3) {
        try {
            this.mContext.getSharedPreferences(F_NAME_MULTI_PROCESS, 0).edit().putString(str2 + "_" + str, str3).apply();
            Uri contentUri = BDInstallProvider.getContentUri(this.mContext, EVENT_INSTALL_INFO_CHANGE);
            if (contentUri == null) {
                return;
            }
            final Uri build = contentUri.buildUpon().appendQueryParameter("key", str2).appendQueryParameter("aid", str).appendQueryParameter("value", str3).build();
            final int[] iArr = new int[1];
            new Runnable() { // from class: com.bytedance.bdinstall.SubpSyncManager.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        SubpSyncManager.this.mContext.getContentResolver().notifyChange(build, null);
                    } catch (Exception unused) {
                        int[] iArr2 = iArr;
                        int i = iArr2[0] + 1;
                        iArr2[0] = i;
                        if (i <= 4) {
                            DrLog.d(this + "retry " + iArr[0] + " times after 1 second");
                            ExecutorUtil.getHandler(str).postDelayed(this, 1000L);
                        }
                    }
                }
            }.run();
        } catch (Exception e) {
            e.printStackTrace();
            DrLog.e("sendSubpEvent error", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void observer(String str, String str2, OnUpdateListener onUpdateListener) {
        observer();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        synchronized (this) {
            putToListenerCache(str2, onUpdateListener);
            Map<String, String> map = sCacheValues;
            if (map.containsKey(str2)) {
                tryNotify(map.get(str2), str, onUpdateListener);
                return;
            }
            String string = this.mContext.getSharedPreferences(F_NAME_MULTI_PROCESS, 0).getString(str2 + "_" + str, null);
            if (!TextUtils.isEmpty(string)) {
                tryNotify(string, str, onUpdateListener);
            }
        }
    }

    private void putToListenerCache(String str, OnUpdateListener onUpdateListener) {
        Map<String, List<OnUpdateListener>> map = sListeners;
        List<OnUpdateListener> list = map.get(str);
        if (list == null) {
            list = new ArrayList<>();
            map.put(str, list);
        }
        list.add(onUpdateListener);
    }

    private void tryNotify(String str, String str2, OnUpdateListener onUpdateListener) {
        if (onUpdateListener != null) {
            onUpdateListener.onUpdate(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyWithUri(Uri uri) {
        synchronized (this) {
            String queryParameter = uri.getQueryParameter("key");
            String queryParameter2 = uri.getQueryParameter("value");
            String queryParameter3 = uri.getQueryParameter("aid");
            if (!TextUtils.isEmpty(queryParameter) && !TextUtils.isEmpty(queryParameter2)) {
                sCacheValues.put(queryParameter, queryParameter2);
                DrLog.d("install_info 发送到子进程 onUpdate " + queryParameter2 + " aid ：" + queryParameter3);
                List<OnUpdateListener> list = sListeners.get(queryParameter);
                if (list != null) {
                    for (OnUpdateListener onUpdateListener : list) {
                        if (onUpdateListener != null) {
                            onUpdateListener.onUpdate(queryParameter2, queryParameter3);
                        }
                    }
                }
                return;
            }
            DrLog.e("multi process: key or value is nullvalue: " + queryParameter2 + " aid ：" + queryParameter3);
        }
    }

    private void observer() {
        Uri contentUri;
        if (this.mHasObserve.compareAndSet(false, true) && (contentUri = BDInstallProvider.getContentUri(this.mContext, EVENT_INSTALL_INFO_CHANGE)) != null) {
            this.mContext.getContentResolver().registerContentObserver(contentUri, true, new ContentObserver(ExecutorUtil.getFirstHandler()) { // from class: com.bytedance.bdinstall.SubpSyncManager.3
                @Override // android.database.ContentObserver
                public void onChange(boolean z, Uri uri) {
                    super.onChange(z);
                    SubpSyncManager.this.notifyWithUri(uri);
                }
            });
        }
    }
}
