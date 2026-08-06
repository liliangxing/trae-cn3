package com.ss.ttm.player.UnifiedCodec.pool;

import android.text.TextUtils;
import com.ss.ttm.player.UnifiedCodec.MediaCodecManager;
import com.ss.ttm.player.UnifiedCodec.codec.FormatWrapper;
import com.ss.ttm.player.UnifiedCodec.codec.ReuseCodecAdapter;
import com.ss.ttm.player.UnifiedCodec.reuse.ReuseHelper;
import com.ss.ttm.player.UnifiedCodec.reuse.ReusePolicy;
import com.ss.vcbkit.VLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class CodecAdapterPool implements Pool<ReuseCodecAdapter, FormatWrapper> {
    public static final String TAG = "CodecAdapterPool";
    private final int mCapacity;
    private final String mName;
    private PoolCallback mPoolCallback;
    private final CopyOnWriteArraySet<ReuseCodecAdapter> mStoreSet = new CopyOnWriteArraySet<>();

    public CodecAdapterPool(int capacity, String name) {
        this.mCapacity = capacity;
        this.mName = name;
    }

    private ReuseCodecAdapter getFirstCodecAdapter() {
        Iterator<ReuseCodecAdapter> it = this.mStoreSet.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    private ReuseCodecAdapter getRemoveItem(ReuseCodecAdapter adapter) {
        Iterator<ReuseCodecAdapter> it = this.mStoreSet.iterator();
        ReusePolicy reusePolicy = MediaCodecManager.getInstance().getReusePolicy();
        ReuseCodecAdapter firstCodecAdapter = getFirstCodecAdapter();
        return (reusePolicy.mRemoveType != ReusePolicy.RemoveType.SAME || firstCodecAdapter == null) ? firstCodecAdapter : replaceSameTypeCodec(firstCodecAdapter, it);
    }

    private final ReuseCodecAdapter pickMatchedCodecAdapter(FormatWrapper formatWrapper) {
        Iterator<ReuseCodecAdapter> it = this.mStoreSet.iterator();
        while (it.hasNext()) {
            ReuseCodecAdapter next = it.next();
            if (!next.mIsRecycled && next.canReuse(formatWrapper) != ReuseHelper.ReuseResult.CODEC_RESULT_NO) {
                return next;
            }
            next.trackReuseCnt();
            if (next.needToRemove()) {
                remove(next);
            }
        }
        return null;
    }

    private ReuseCodecAdapter replaceSameTypeCodec(ReuseCodecAdapter reuseCodecAdapter, Iterator it) {
        while (it.hasNext()) {
            ReuseCodecAdapter reuseCodecAdapter2 = (ReuseCodecAdapter) it.next();
            if (TextUtils.equals(reuseCodecAdapter.getCodecName(), reuseCodecAdapter2.getCodecName())) {
                return reuseCodecAdapter2;
            }
        }
        return null;
    }

    @Override // com.ss.ttm.player.UnifiedCodec.pool.Pool
    public void clear() {
        VLog.m248i(TAG, "CodecAdapterPool clear:" + this.mStoreSet);
        if (this.mPoolCallback != null) {
            Iterator<ReuseCodecAdapter> it = this.mStoreSet.iterator();
            while (it.hasNext()) {
                this.mPoolCallback.onRemove(it.next());
            }
        }
        this.mStoreSet.clear();
    }

    @Override // com.ss.ttm.player.UnifiedCodec.pool.Pool
    public boolean isEmpty() {
        return this.mStoreSet.isEmpty();
    }

    @Override // com.ss.ttm.player.UnifiedCodec.pool.Pool
    public boolean isFull() {
        return this.mStoreSet.size() == this.mCapacity;
    }

    public final void setPoolCallback(PoolCallback poolCallback) {
        this.mPoolCallback = poolCallback;
    }

    public String toString() {
        return "size:" + this.mStoreSet.size() + " elements:" + this.mStoreSet;
    }

    @Override // com.ss.ttm.player.UnifiedCodec.pool.Pool
    public ReuseCodecAdapter obtain(FormatWrapper formatWrapper) {
        ReuseCodecAdapter pickMatchedCodecAdapter = pickMatchedCodecAdapter(formatWrapper);
        if (pickMatchedCodecAdapter == null) {
            return null;
        }
        this.mStoreSet.remove(pickMatchedCodecAdapter);
        return pickMatchedCodecAdapter;
    }

    @Override // com.ss.ttm.player.UnifiedCodec.pool.Pool
    public void put(ReuseCodecAdapter reuseCodecAdapter) {
        if (isFull()) {
            remove(getRemoveItem(reuseCodecAdapter));
        }
        this.mStoreSet.add(reuseCodecAdapter);
    }

    @Override // com.ss.ttm.player.UnifiedCodec.pool.Pool
    public void remove(ReuseCodecAdapter reuseCodecAdapter) {
        if (this.mStoreSet.remove(reuseCodecAdapter)) {
            VLog.m251w(TAG, "pool:" + this.mName + " remove " + reuseCodecAdapter);
            PoolCallback poolCallback = this.mPoolCallback;
            if (poolCallback != null) {
                poolCallback.onRemove(reuseCodecAdapter);
                return;
            }
            return;
        }
        VLog.m251w(TAG, "pool:" + this.mName + " remove " + reuseCodecAdapter + " not found");
    }
}
