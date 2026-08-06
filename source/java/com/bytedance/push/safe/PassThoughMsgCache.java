package com.bytedance.push.safe;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.push.PushBody;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class PassThoughMsgCache implements IPassThoughMsgCache {
    private final Map<Long, Pair<PushBody, Integer>> caches = new ConcurrentHashMap();

    @Override // com.bytedance.push.safe.IPassThoughMsgCache
    public boolean isFromPassThough(String str) {
        Iterator<Map.Entry<Long, Pair<PushBody, Integer>>> it = this.caches.entrySet().iterator();
        while (it.hasNext()) {
            Pair<PushBody, Integer> value = it.next().getValue();
            if (value != null && value.first != null && TextUtils.equals(((PushBody) value.first).msgData.toString(), str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.push.safe.IPassThoughMsgCache
    public PushBody getRevokedMsg(long j) {
        Pair<PushBody, Integer> pair = this.caches.get(Long.valueOf(j));
        if (pair != null) {
            return (PushBody) pair.first;
        }
        return null;
    }

    @Override // com.bytedance.push.safe.IPassThoughMsgCache
    public int getMsgFrom(PushBody pushBody) {
        Pair<PushBody, Integer> pair;
        if (pushBody == null || (pair = this.caches.get(Long.valueOf(pushBody.id))) == null) {
            return 0;
        }
        return ((Integer) pair.second).intValue();
    }

    @Override // com.bytedance.push.safe.IPassThoughMsgCache
    public void cacheMsg(PushBody pushBody, int i) {
        this.caches.put(Long.valueOf(pushBody.id), new Pair<>(pushBody, Integer.valueOf(i)));
    }
}
