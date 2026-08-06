package androidx.fragment.app;

import android.app.Activity;
import android.app.Application;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import android.util.Pair;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.Npth;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class TransactionTooLargeMonitor {
    private static final String TAG = "TransactionTooLarge";
    private static volatile int largeStringSizeThreshold = Integer.MAX_VALUE;
    private static final AtomicBoolean hasHooked = new AtomicBoolean(false);
    private static final ArrayDeque<Pair<WeakReference<Bundle>, String>> container = new ArrayDeque<>(3);

    private TransactionTooLargeMonitor() {
    }

    public static void reportLargeStringValues(int i) {
        largeStringSizeThreshold = i;
    }

    public static void hook(Application application) {
        hook(application, true);
    }

    public static void hook(Application application, boolean z) {
        if (hasHooked.getAndSet(true)) {
            Log.w(TAG, "has invoked hook(), ignore");
            return;
        }
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: androidx.fragment.app.TransactionTooLargeMonitor.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                try {
                    if (TransactionTooLargeMonitor.container.size() >= 3) {
                        TransactionTooLargeMonitor.container.removeFirst();
                    }
                    TransactionTooLargeMonitor.container.addLast(Pair.create(new WeakReference(bundle), activity.getClass().getName()));
                } catch (Throwable unused) {
                }
            }
        });
        if (z) {
            try {
                reportToNpth();
            } catch (Throwable unused) {
            }
        }
    }

    private static void reportToNpth() {
        ICrashCallback iCrashCallback = new ICrashCallback() { // from class: androidx.fragment.app.TransactionTooLargeMonitor.2
            public void onCrash(CrashType crashType, String str, Thread thread) {
                if (str != null) {
                    try {
                        if (str.contains("android.os.TransactionTooLargeException")) {
                            final Map<String, String> dumpBundleInfo = TransactionTooLargeMonitor.dumpBundleInfo();
                            AttachUserData attachUserData = new AttachUserData() { // from class: androidx.fragment.app.TransactionTooLargeMonitor.2.1
                                public Map<? extends String, ? extends String> getUserData(CrashType crashType2) {
                                    return dumpBundleInfo;
                                }
                            };
                            Npth.addAttachLongUserData(attachUserData, CrashType.JAVA);
                            Npth.addAttachLongUserData(attachUserData, CrashType.LAUNCH);
                        }
                    } catch (Throwable th) {
                        Log.e(TransactionTooLargeMonitor.TAG, "", th);
                    }
                }
            }
        };
        Npth.registerCrashCallback(iCrashCallback, CrashType.LAUNCH);
        Npth.registerCrashCallback(iCrashCallback, CrashType.JAVA);
    }

    public static Map<String, String> dumpBundleInfo() {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        Iterator<Pair<WeakReference<Bundle>, String>> it = container.iterator();
        while (it.hasNext()) {
            Pair<WeakReference<Bundle>, String> next = it.next();
            Bundle bundle = (Bundle) ((WeakReference) next.first).get();
            if (bundle != null) {
                sb.append("Activity: ").append((String) next.second).append(", Bundle size: ").append(formatSize(measureSize(bundle))).append('\n');
                dump(bundle, sb, 4, hashMap);
                sb.append('\n');
            }
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("BundleTooLarge", sb.toString());
        for (Map.Entry entry : hashMap.entrySet()) {
            hashMap2.put("Bundle_" + ((String) entry.getKey()), entry.getValue());
        }
        return hashMap2;
    }

    private static int measureSize(Object obj) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeValue(obj);
            return obtain.dataSize();
        } finally {
            obtain.recycle();
        }
    }

    private static String formatSize(int i) {
        return (i / 1024.0f) + "K";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void dump(Bundle bundle, StringBuilder sb, int i, Map<String, String> map) {
        ArrayList<SizeObj<FragmentState>> fragmentStates;
        Map<String, Object> map2 = getMap(bundle);
        if (map2 != null) {
            ArrayList arrayList = new ArrayList(map2.size());
            for (Map.Entry<String, Object> entry : map2.entrySet()) {
                arrayList.add(new SizeObj(measureSize(entry.getValue()), Pair.create(entry.getKey(), entry.getValue())));
            }
            Collections.sort(arrayList, new Comparator<SizeObj<Pair<String, Object>>>() { // from class: androidx.fragment.app.TransactionTooLargeMonitor.3
                @Override // java.util.Comparator
                public int compare(SizeObj<Pair<String, Object>> sizeObj, SizeObj<Pair<String, Object>> sizeObj2) {
                    return sizeObj2.size - sizeObj.size;
                }
            });
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                SizeObj sizeObj = (SizeObj) it.next();
                String str = (String) ((Pair) sizeObj.obj).first;
                Object obj = ((Pair) sizeObj.obj).second;
                formintent(i, sb);
                sb.append("key: ").append(str).append(", size: ").append(formatSize(sizeObj.size)).append('\n');
                if (map != null && (obj instanceof String) && sizeObj.size >= largeStringSizeThreshold) {
                    String str2 = (String) obj;
                    String str3 = map.get(str);
                    if (str3 == null || str2.length() > str3.length()) {
                        map.put(str, str2);
                    }
                }
                if (obj instanceof Bundle) {
                    dump((Bundle) obj, sb, i + 4, map);
                } else if ((obj instanceof FragmentManagerState) && (fragmentStates = getFragmentStates((FragmentManagerState) obj)) != null && !fragmentStates.isEmpty()) {
                    Collections.sort(fragmentStates, new Comparator<SizeObj<FragmentState>>() { // from class: androidx.fragment.app.TransactionTooLargeMonitor.4
                        @Override // java.util.Comparator
                        public int compare(SizeObj<FragmentState> sizeObj2, SizeObj<FragmentState> sizeObj3) {
                            return sizeObj3.size - sizeObj2.size;
                        }
                    });
                    Iterator<SizeObj<FragmentState>> it2 = fragmentStates.iterator();
                    while (it2.hasNext()) {
                        SizeObj<FragmentState> next = it2.next();
                        formintent(i + 4, sb);
                        sb.append("FragmentState: ").append(next.obj.mClassName).append(", size: ").append(formatSize(next.size)).append('\n');
                        Bundle bundle2 = new Bundle();
                        if (next.obj.mArguments != null) {
                            bundle2.putAll(next.obj.mArguments);
                        }
                        if (next.obj.mSavedFragmentState != null) {
                            bundle2.putAll(next.obj.mSavedFragmentState);
                        }
                        dump(bundle2, sb, i + 8, map);
                    }
                }
            }
        }
    }

    private static ArrayList<SizeObj<FragmentState>> getFragmentStates(FragmentManagerState fragmentManagerState) {
        Object activeState = getActiveState(fragmentManagerState);
        if (activeState == null) {
            Log.w(TAG, "mActive is null");
            return null;
        }
        ArrayList<SizeObj<FragmentState>> arrayList = new ArrayList<>();
        if (activeState instanceof FragmentState[]) {
            for (FragmentState fragmentState : (FragmentState[]) activeState) {
                if (fragmentState != null) {
                    arrayList.add(new SizeObj<>(measureSize(fragmentState), fragmentState));
                }
            }
        } else if (activeState instanceof List) {
            for (Object obj : (List) activeState) {
                if (obj instanceof FragmentState) {
                    FragmentState fragmentState2 = (FragmentState) obj;
                    arrayList.add(new SizeObj<>(measureSize(fragmentState2), fragmentState2));
                }
            }
        } else {
            Log.w(TAG, "unsupported androidx.fragment version");
        }
        return arrayList;
    }

    private static Object getActiveState(FragmentManagerState fragmentManagerState) {
        try {
            Field declaredField = FragmentManagerState.class.getDeclaredField("mActive");
            declaredField.setAccessible(true);
            return declaredField.get(fragmentManagerState);
        } catch (Throwable th) {
            Log.w(TAG, "unsupported androidx.fragment version", th);
            return null;
        }
    }

    private static Map<String, Object> getMap(Bundle bundle) {
        try {
            Field declaredField = BaseBundle.class.getDeclaredField("mMap");
            declaredField.setAccessible(true);
            return (Map) declaredField.get(bundle);
        } catch (Throwable th) {
            Log.e(TAG, "", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class SizeObj<T> {
        final T obj;
        final int size;

        SizeObj(int i, T t) {
            this.size = i;
            this.obj = t;
        }
    }

    private static void formintent(int i, StringBuilder sb) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(' ');
        }
    }
}
