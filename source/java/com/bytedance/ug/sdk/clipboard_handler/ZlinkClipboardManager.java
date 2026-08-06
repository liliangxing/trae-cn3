package com.bytedance.ug.sdk.clipboard_handler;

import android.content.ClipData;
import android.text.TextUtils;
import com.bytedance.ug.sdk.deeplink.ClipboardCompat;
import com.bytedance.ug.sdk.deeplink.GlobalContext;
import com.bytedance.ug.sdk.deeplink.IClipboardChecker;
import com.bytedance.ug.sdk.deeplink.ZlinkApi;
import com.bytedance.ug.sdk.deeplink.interfaces.AbstractClipboardObserver;
import com.bytedance.ug.sdk.deeplink.utils.CollectionsUtils;
import com.bytedance.ug.sdk.deeplink.utils.Logger;
import com.bytedance.ug.sdk.deeplink.utils.ThreadUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
class ZlinkClipboardManager {
    private static final String TAG = "ZlinkClipboardManager";
    private static final PriorityBlockingQueue<AbstractClipboardObserver> sClipboardObservers = new PriorityBlockingQueue<>();
    private static final Map<String, Integer> sPriorityMap = new HashMap();

    private ZlinkClipboardManager() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void registerClipboardObserver(AbstractClipboardObserver abstractClipboardObserver) {
        if (abstractClipboardObserver == null) {
            return;
        }
        Map<String, Integer> map = sPriorityMap;
        if (map.get(abstractClipboardObserver.getClassName()) == null) {
            map.put(abstractClipboardObserver.getClassName(), Integer.valueOf(abstractClipboardObserver.getPriority()));
            sClipboardObservers.offer(abstractClipboardObserver);
        }
    }

    public static void checkAndDistributeClipboard() {
        if (ZlinkApi.INSTANCE.isInited()) {
            ThreadUtils.executeAsync(new Runnable() { // from class: com.bytedance.ug.sdk.clipboard_handler.ZlinkClipboardManager.1
                @Override // java.lang.Runnable
                public void run() {
                    ZlinkClipboardManager.doCheckAndDistributeClipboard();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doCheckAndDistributeClipboard() {
        doDistributeClipboard(ClipboardCompat.getClipBoardContent(GlobalContext.INSTANCE.getApplication()), System.currentTimeMillis() - System.currentTimeMillis());
    }

    public static void distributeClipboard(final ClipData clipData, final long j) {
        ThreadUtils.executeAsync(new Runnable() { // from class: com.bytedance.ug.sdk.clipboard_handler.ZlinkClipboardManager.2
            @Override // java.lang.Runnable
            public void run() {
                ZlinkClipboardManager.doDistributeClipboard(clipData, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doDistributeClipboard(ClipData clipData, long j) {
        AbstractClipboardObserver abstractClipboardObserver;
        IClipboardChecker value;
        Map<String, IClipboardChecker> checkerMap = ClipboardHelper.getInstance().getCheckerMap();
        if (!CollectionsUtils.isEmptyMap(checkerMap)) {
            for (Map.Entry<String, IClipboardChecker> entry : checkerMap.entrySet()) {
                if (entry != null && !TextUtils.isEmpty(entry.getKey()) && (value = entry.getValue()) != null && value.process(System.currentTimeMillis() - j, clipData)) {
                    Logger.m448e(TAG, value.getClass().getCanonicalName() + " processed the clipData", null);
                    return;
                }
            }
        }
        PriorityBlockingQueue<AbstractClipboardObserver> priorityBlockingQueue = sClipboardObservers;
        if (priorityBlockingQueue.size() > 0) {
            Iterator<AbstractClipboardObserver> it = priorityBlockingQueue.iterator();
            while (true) {
                if (!it.hasNext()) {
                    abstractClipboardObserver = null;
                    break;
                }
                abstractClipboardObserver = it.next();
                if (abstractClipboardObserver != null && abstractClipboardObserver.process(clipData)) {
                    break;
                }
            }
            if (abstractClipboardObserver == null) {
                Logger.m448e(TAG, "There is no suitable observer process the content of clipboard!", null);
            } else {
                Logger.m448e(TAG, "The observer which processed the content of clipboard is " + abstractClipboardObserver.getTag(), null);
            }
        }
    }
}
