package com.ss.ttm.player.UnifiedCodec.pool;

import com.ss.ttm.player.UnifiedCodec.codec.FormatWrapper;
import com.ss.ttm.player.UnifiedCodec.codec.ReuseCodecAdapter;
import com.ss.vcbkit.VLog;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class CodecAdapterManager implements CodecAdapterTransformer {
    private static final String PERSIST_POOL_NAME = "pPool";
    private static final String RUUNNING_POOL_NAME = "rPool";
    public static final String TAG = "CodecAdapterManager";
    private static final int sDefaultPoolSize = 2;
    private final CodecAdapterPool mPersistentCodecPool;
    private final CodecAdapterPool mRunningCodecPool = new CodecAdapterPool(Integer.MAX_VALUE, RUUNNING_POOL_NAME);

    public CodecAdapterManager() {
        CodecAdapterPool codecAdapterPool = new CodecAdapterPool(2, PERSIST_POOL_NAME);
        this.mPersistentCodecPool = codecAdapterPool;
        codecAdapterPool.setPoolCallback(new PoolCallback() { // from class: com.ss.ttm.player.UnifiedCodec.pool.CodecAdapterManager.1
            @Override // com.ss.ttm.player.UnifiedCodec.pool.PoolCallback
            public void onRemove(ReuseCodecAdapter reuseCodecAdapter) {
                reuseCodecAdapter.recycle();
            }
        });
    }

    @Override // com.ss.ttm.player.UnifiedCodec.pool.CodecAdapterTransformer
    public void clearAll() {
        VLog.m248i(TAG, "clearAll");
        this.mRunningCodecPool.clear();
        this.mPersistentCodecPool.clear();
    }

    public void clearPersistPool() {
        this.mPersistentCodecPool.clear();
    }

    public final String getDumpInfo() {
        return "runningPool:" + this.mRunningCodecPool + " persistPool:" + this.mPersistentCodecPool;
    }

    public boolean isPersistPoolFull() {
        return this.mPersistentCodecPool.isFull();
    }

    @Override // com.ss.ttm.player.UnifiedCodec.pool.CodecAdapterTransformer
    public ReuseCodecAdapter obtainCodecAdapter(FormatWrapper formatWrapper) {
        return this.mPersistentCodecPool.obtain(formatWrapper);
    }

    @Override // com.ss.ttm.player.UnifiedCodec.pool.CodecAdapterTransformer
    public void removeFromRunning(ReuseCodecAdapter codecAdapter) {
        this.mRunningCodecPool.remove(codecAdapter);
    }

    @Override // com.ss.ttm.player.UnifiedCodec.pool.CodecAdapterTransformer
    public void transToPersist(ReuseCodecAdapter codecAdapter) {
        this.mRunningCodecPool.remove(codecAdapter);
        this.mPersistentCodecPool.put(codecAdapter);
    }

    @Override // com.ss.ttm.player.UnifiedCodec.pool.CodecAdapterTransformer
    public void transToRunning(final ReuseCodecAdapter codecAdapter) {
        this.mPersistentCodecPool.remove(codecAdapter);
        this.mRunningCodecPool.put(codecAdapter);
    }
}
