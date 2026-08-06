package com.bytedance.platform.settingsx.map;

import android.content.SharedPreferences;
import android.os.Handler;
import com.bytedance.platform.settingsx.api.GlobalConfig;
import com.bytedance.platform.settingsx.internal.HandlerUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class FixedKeyIndex {
    private static volatile boolean isLoad;
    private static final Map<Integer, Integer> fixedKeyIndex = new ConcurrentHashMap();
    private static final Map<Integer, Integer> pendingFixedKeyIndex = new ConcurrentHashMap();
    private static final Handler handler = HandlerUtils.getHandler();
    private static final Runnable flushTask = new Runnable() { // from class: com.bytedance.platform.settingsx.map.FixedKeyIndex$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            FixedKeyIndex.flush();
        }
    };

    public static void record(int i, int i2) {
        if (isLoad) {
            Map<Integer, Integer> map = fixedKeyIndex;
            Integer num = map.get(Integer.valueOf(i));
            if (num == null || i2 == num.intValue()) {
                return;
            }
            map.put(Integer.valueOf(i), Integer.valueOf(i2));
            Handler handler2 = handler;
            Runnable runnable = flushTask;
            handler2.removeCallbacks(runnable);
            handler2.postDelayed(runnable, 5000L);
            return;
        }
        pendingFixedKeyIndex.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void flush() {
        GlobalConfig.getIOWritePool().execute(new Runnable() { // from class: com.bytedance.platform.settingsx.map.FixedKeyIndex$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FixedKeyIndex.lambda$flush$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$flush$0() {
        SharedPreferences.Editor edit = GlobalConfig.getSp().getSharedPreferences(GlobalConfig.getContext(), "settingsx_fixed_key_index", 0).edit();
        for (Map.Entry<Integer, Integer> entry : fixedKeyIndex.entrySet()) {
            edit.putInt(String.valueOf(entry.getKey()), entry.getValue().intValue());
        }
        edit.apply();
    }

    public static int getBlockIndex(int i) {
        ifInit();
        Integer num = fixedKeyIndex.get(Integer.valueOf(i));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    private static void ifInit() {
        for (Map.Entry<String, ?> entry : GlobalConfig.getSp().getSharedPreferences(GlobalConfig.getContext(), "settingsx_fixed_key_index", 0).getAll().entrySet()) {
            try {
                if (entry.getValue() instanceof Integer) {
                    fixedKeyIndex.put(Integer.valueOf(Integer.parseInt(entry.getKey())), (Integer) entry.getValue());
                }
            } catch (Exception unused) {
            }
        }
        fixedKeyIndex.putAll(pendingFixedKeyIndex);
        isLoad = true;
    }
}
