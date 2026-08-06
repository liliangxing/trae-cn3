package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.FileCache;
import com.facebook.imagepipeline.cache.StagingArea;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class FrescoCacheMonitorUtil {
    private static boolean mAddMDLCancel = false;
    private static boolean mAvoidSRAbnormal = false;
    private static long mBigImgSizeLimit = 2097152;
    private static boolean mControllerBuilderByLazyInit = false;
    private static List<String> mCurrentSceneTags = null;
    private static long mDelayTime = 0;
    private static boolean mDelayWriteDisk = false;
    private static boolean mEnableAddLogUriInfo = false;
    private static boolean mEnableBigImgCache = false;
    private static boolean mEnableCalculateColor = false;
    private static boolean mEnableFileProviderOpt = false;
    private static boolean mEnableNewLocalVideoThumbnailOpt = false;
    private static boolean mEnableSingleCache = false;
    private static boolean mFixVvicDecode = false;
    private static int mHeicDecodeThreads = 1;
    private static boolean mHeicUseWpp = false;
    private static int mHeifDecodeThreads = 1;
    private static boolean mHeifUseWpp = false;
    private static boolean mIsFallBackMainDisk = false;
    private static boolean mIsSplitMemCache = false;
    private static boolean mIsSplitPrefetchCache = false;
    private static boolean mLocalVideoThumbOpt = false;
    private static boolean mMultiUrlCacheOpt = false;
    private static boolean mOptAnimCacheClear = false;
    private static boolean mOptAutoSr = false;
    private static boolean mOptBitmapCacheKey = false;
    private static boolean mOptHardWareForSRProcessor = false;
    private static boolean mOptHeifParse = false;
    private static boolean mOptLazyInit = false;
    private static boolean mOptListenerAnr = false;
    private static boolean mOptMDLCancel = false;
    private static boolean mOptMultiOriginListener = false;
    private static boolean mOptMultiRequestSensible = false;
    private static boolean mOptPlaceholderNull = false;
    private static boolean mOptPrefetchCacheKey = false;
    private static boolean mOptRest = false;
    private static boolean mOptRgbaForPostProcessor = false;
    private static boolean mOptSensibleMonitor = false;
    private static boolean mOptSimpleDraweeViewAnr = false;
    private static boolean mOptUltimateProducerReached = false;
    private static boolean mRemoveVvicUseSystemApi = false;
    private static boolean mRetainPreviousImage = false;
    private static boolean mSRAutoScaleLowerFirst = false;
    private static boolean mSaveAfterSrPostBitmap = false;
    private static boolean mSavePreSrPostBitmap = false;
    private static float mStretchAboveForSR = 0.0f;
    private static boolean mTTHeifAnimDecOpt = false;
    private static boolean mTTHeifDecOpt = false;
    private static boolean mUseHeicHdr = false;
    private static boolean mUseHeicHdrRgba102 = false;
    private static boolean mUseImageDecoder = false;
    private static boolean mUseJniSr = false;
    private static boolean mUseNewOptHeifBitmap = false;
    private static boolean mUseOptHeifBitmap = false;
    private static boolean mUseUltimateOptHeifBitmap = false;
    private static int mUsedBytes = 0;
    private static boolean mVvicDecOpt = false;
    private static int mVvicDecodeThreads = 1;
    private static int mVvicOptMode;
    private static boolean mVvicUseWpp;
    private static Map<String, String> mWaitParseParamFromUrl;
    private static FileCache mainFileCache;
    private static StagingArea mainStagingArea;
    private static int maxSizeHardCap;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class SingletonHolder {
        private static final int NUM_IO_BOUND_THREADS = 2;
        private static final ScheduledExecutorService mIoBoundExecutor = Executors.newScheduledThreadPool(2, new PriorityThreadFactory(10, "FrescoDelayIoBoundExecutor", true));

        private SingletonHolder() {
        }
    }

    public static ScheduledExecutorService getNewIoBoundExecutor() {
        return SingletonHolder.mIoBoundExecutor;
    }

    public static void setDelayWriteDisk(boolean z, long j) {
        mDelayWriteDisk = z;
        mDelayTime = j;
        if (z || getNewIoBoundExecutor() == null) {
            return;
        }
        getNewIoBoundExecutor().shutdown();
    }

    public static boolean isDelayWriteDisk() {
        return mDelayWriteDisk;
    }

    public static long getDelayTime() {
        return mDelayTime;
    }

    public static void setMaxSizeHardCap(int i) {
        maxSizeHardCap = i;
    }

    public static int getMaxSizeHardCap() {
        return maxSizeHardCap;
    }

    public static void setUsedBytes(int i) {
        mUsedBytes = i;
    }

    public static int getUsedBytes() {
        return mUsedBytes;
    }

    public static void setSplitMemCache(boolean z) {
        mIsSplitMemCache = z;
    }

    public static boolean isSplitMemCache() {
        return mIsSplitMemCache;
    }

    public static void setSplitPrefetchCache(boolean z) {
        mIsSplitPrefetchCache = z;
    }

    public static boolean isSplitPrefetchCache() {
        return mIsSplitPrefetchCache;
    }

    public static void setOptPrefetchCacheKey(boolean z) {
        mOptPrefetchCacheKey = z;
    }

    public static boolean isOptPrefetchCacheKey() {
        return mOptPrefetchCacheKey;
    }

    public static void setOptBitmapCacheKey(boolean z) {
        mOptBitmapCacheKey = z;
    }

    public static boolean isOptBitmapCacheKey() {
        return mOptBitmapCacheKey;
    }

    public static void setEnableSingleCache(boolean z) {
        mEnableSingleCache = z;
    }

    public static boolean isEnableSingleCache() {
        return mEnableSingleCache;
    }

    public static void setEnableBigImgCache(boolean z) {
        mEnableBigImgCache = z;
    }

    public static boolean isEnableBigImgCache() {
        return mEnableBigImgCache;
    }

    public static void setBigImgSizeLimit(long j) {
        mBigImgSizeLimit = j;
    }

    public static long getBigImgSizeLimit() {
        return mBigImgSizeLimit;
    }

    public static void setEnableSavePreSrPostBitmap(boolean z) {
        mSavePreSrPostBitmap = z;
    }

    public static boolean isSavePrePostBitmap() {
        return mSavePreSrPostBitmap;
    }

    public static void setEnableSaveAfterSrPostBitmap(boolean z) {
        mSaveAfterSrPostBitmap = z;
    }

    public static boolean isSaveAfterPostBitmap() {
        return mSaveAfterSrPostBitmap;
    }

    public static void setRetainPreviousImage(boolean z) {
        mRetainPreviousImage = z;
    }

    public static boolean isRetainPreviousImage() {
        return mRetainPreviousImage;
    }

    public static boolean isNewLocalVideoThumbnailOptEnabled() {
        return mEnableNewLocalVideoThumbnailOpt;
    }

    public static void setNewLocalVideoThumbnailOptEnabled(boolean z) {
        mEnableNewLocalVideoThumbnailOpt = z;
    }

    public static void setWaitParseParamFromUrl(Map<String, String> map) {
        mWaitParseParamFromUrl = map;
    }

    public static Map<String, String> getWaitParseParamFromUrl() {
        return mWaitParseParamFromUrl;
    }

    public static void setUseOptHeifBitmap(boolean z) {
        mUseOptHeifBitmap = z;
    }

    public static boolean isUseOptHeifBitmap() {
        return mUseOptHeifBitmap;
    }

    public static void setUseNewOptHeifBitmap(boolean z) {
        mUseNewOptHeifBitmap = z;
    }

    public static boolean isUseNewOptHeifBitmap() {
        return mUseNewOptHeifBitmap;
    }

    public static void setUseUltimateOptHeifBitmap(boolean z) {
        EncodedImage.setUseUltimateOptHeifBitmap(z);
        mUseUltimateOptHeifBitmap = z;
    }

    public static boolean isUseUltimateOptHeifBitmap() {
        return mUseUltimateOptHeifBitmap;
    }

    public static void setOptHeifParse(boolean z) {
        if (z) {
            EncodedImage.setOptHeifParse(true);
        }
        mOptHeifParse = z;
    }

    public static boolean isOptHeifParse() {
        return mOptHeifParse;
    }

    public static void setOptMultiOriginListener(boolean z) {
        mOptMultiOriginListener = z;
    }

    public static boolean isOptMultiOriginListener() {
        return mOptMultiOriginListener;
    }

    public static void setSRAutoScaleLowerFirst(boolean z) {
        mSRAutoScaleLowerFirst = z;
    }

    public static boolean isSRAutoScaleLowerFirst() {
        return mSRAutoScaleLowerFirst;
    }

    public static void setVvicUseWpp(boolean z) {
        mVvicUseWpp = z;
    }

    public static boolean isVvicUseWpp() {
        return mVvicUseWpp;
    }

    public static void setVvicDecodeThreads(int i) {
        mVvicDecodeThreads = i;
    }

    public static int getVvicDecodeThreads() {
        return mVvicDecodeThreads;
    }

    public static void setHeicUseWpp(boolean z) {
        mHeicUseWpp = z;
    }

    public static boolean isHeicUseWpp() {
        return mHeicUseWpp;
    }

    public static void setHeicDecodeThreads(int i) {
        mHeicDecodeThreads = i;
    }

    public static int getHeicDecodeThreads() {
        return mHeicDecodeThreads;
    }

    public static void setHeifUseWpp(boolean z) {
        mHeifUseWpp = z;
    }

    public static boolean isHeifUseWpp() {
        return mHeifUseWpp;
    }

    public static void setHeifDecodeThreads(int i) {
        mHeifDecodeThreads = i;
    }

    public static int getHeifDecodeThreads() {
        return mHeifDecodeThreads;
    }

    public static void setOptAutoSr(boolean z) {
        mOptAutoSr = z;
    }

    public static boolean isOptAutoSr() {
        return mOptAutoSr;
    }

    public static void setStretchAboveForSR(float f) {
        mStretchAboveForSR = f;
    }

    public static float getStretchAboveForSR() {
        return mStretchAboveForSR;
    }

    public static void setMultiUrlCacheOpt(boolean z) {
        mMultiUrlCacheOpt = z;
    }

    public static boolean isMultiUrlCacheOpt() {
        return mMultiUrlCacheOpt;
    }

    public static void setOptSensibleMonitor(boolean z) {
        mOptSensibleMonitor = z;
    }

    public static boolean isOptSensibleMonitor() {
        return mOptSensibleMonitor;
    }

    public static void setOptRgbaForPostProcessor(boolean z) {
        mOptRgbaForPostProcessor = z;
    }

    public static boolean isOptRgbaForPostProcessor() {
        return mOptRgbaForPostProcessor;
    }

    public static void setOptHardWareForSRProcessor(boolean z) {
        mOptHardWareForSRProcessor = z;
    }

    public static boolean isOptHardWareForSRProcessor() {
        return mOptHardWareForSRProcessor;
    }

    public static void setOptSimpleDraweeViewAnr(boolean z) {
        mOptSimpleDraweeViewAnr = z;
    }

    public static boolean isOptSimpleDraweeViewAnr() {
        return mOptSimpleDraweeViewAnr;
    }

    public static void setTTHeifDecOpt(boolean z) {
        mTTHeifDecOpt = z;
    }

    public static boolean getTTHeifDecOpt() {
        return mTTHeifDecOpt;
    }

    public static void setTTHeifAnimDecOpt(boolean z) {
        mTTHeifAnimDecOpt = z;
    }

    public static boolean getTTHeifAnimDecOpt() {
        return mTTHeifAnimDecOpt;
    }

    public static void setFixVvicDecode(boolean z) {
        mFixVvicDecode = z;
    }

    public static void setVvicDecOpt(boolean z) {
        mVvicDecOpt = z;
    }

    public static boolean getVvicDecOpt() {
        return mVvicDecOpt;
    }

    public static void setVvicOptMode(int i) {
        mVvicOptMode = i;
    }

    public static int getVvicOptMode() {
        return mVvicOptMode;
    }

    public static void setOptPlaceholderNull(boolean z) {
        mOptPlaceholderNull = z;
    }

    public static boolean isFixVvicDecode() {
        return mFixVvicDecode;
    }

    public static void setIsFallBackMainDisk(boolean z) {
        mIsFallBackMainDisk = z;
    }

    public static boolean isFallBackMainDisk() {
        return mIsFallBackMainDisk;
    }

    public static void setMainStagingArea(StagingArea stagingArea) {
        mainStagingArea = stagingArea;
    }

    public static StagingArea getMainStagingArea() {
        return mainStagingArea;
    }

    public static void setMainFileCache(FileCache fileCache) {
        mainFileCache = fileCache;
    }

    public static FileCache getMainFileCache() {
        return mainFileCache;
    }

    public static void setLocalVideoThumbOpt(boolean z) {
        mLocalVideoThumbOpt = z;
    }

    public static boolean isLocalVideoThumbOpt() {
        return mLocalVideoThumbOpt;
    }

    public static void setRemoveVvicUseSystemApi(boolean z) {
        mRemoveVvicUseSystemApi = z;
    }

    public static boolean isRemoveVvicUseSystemApi() {
        return mRemoveVvicUseSystemApi;
    }

    public static void setOptAnimCacheClear(boolean z) {
        mOptAnimCacheClear = z;
    }

    public static boolean isOptAnimCacheClear() {
        return mOptAnimCacheClear;
    }

    public static void setAddMDLCancel(boolean z) {
        mAddMDLCancel = z;
    }

    public static boolean isAddMDLCancel() {
        return mAddMDLCancel;
    }

    public static void setOptMDLCancel(boolean z) {
        mOptMDLCancel = z;
    }

    public static boolean isOptMDLCancel() {
        return mOptMDLCancel;
    }

    public static void setEnableCalculateColor(boolean z) {
        mEnableCalculateColor = z;
    }

    public static boolean isEnableCalculateColor() {
        return mEnableCalculateColor;
    }

    public static void setEnableFileProviderOpt(boolean z) {
        mEnableFileProviderOpt = z;
    }

    public static boolean isEnableFileProviderOpt() {
        return mEnableFileProviderOpt;
    }

    public static void setEnableAddLogUriInfo(boolean z) {
        mEnableAddLogUriInfo = z;
    }

    public static boolean isEnableAddLogUriInfo() {
        return mEnableAddLogUriInfo;
    }

    public static void setAvoidSRAbnormal(boolean z) {
        mAvoidSRAbnormal = z;
    }

    public static boolean isAvoidSRAbnormal() {
        return mAvoidSRAbnormal;
    }

    public static void setOptLazyInit(boolean z) {
        mOptLazyInit = z;
    }

    public static boolean isOptLazyInit() {
        return mOptLazyInit;
    }

    public static void setUseJniSr(boolean z) {
        mUseJniSr = z;
    }

    public static boolean isUseJniSr() {
        return mUseJniSr;
    }

    public static void setUseHeicHdr(boolean z) {
        mUseHeicHdr = z;
    }

    public static boolean isUseHeicHdr() {
        return mUseHeicHdr;
    }

    public static void setUseHeicHdrRgba102(boolean z) {
        mUseHeicHdrRgba102 = z;
    }

    public static boolean isUseHeicHdrRgba102() {
        return mUseHeicHdrRgba102;
    }

    public static void setOptRest(boolean z) {
        mOptRest = z;
    }

    public static boolean isOptRest() {
        return mOptRest;
    }

    public static void setCurrentSceneTags(List<String> list) {
        mCurrentSceneTags = list;
    }

    public static List<String> getCurrentSceneTags() {
        return mCurrentSceneTags;
    }

    public static boolean isControllerBuilderByLazyInit() {
        return mControllerBuilderByLazyInit;
    }

    public static void setControllerBuilderByLazyInit(boolean z) {
        mControllerBuilderByLazyInit = z;
    }

    public static boolean isOptUltimateProducerReached() {
        return mOptUltimateProducerReached;
    }

    public static void setOptUltimateProducerReached(boolean z) {
        mOptUltimateProducerReached = z;
    }

    public static boolean isOptMultiRequestSensible() {
        return mOptMultiRequestSensible;
    }

    public static void setOptMultiRequestSensible(boolean z) {
        mOptMultiRequestSensible = z;
    }

    public static boolean isOptListenerAnr() {
        return mOptListenerAnr;
    }

    public static void setOptListenerAnr(boolean z) {
        mOptListenerAnr = z;
    }

    public static boolean isUseImageDecoder() {
        return mUseImageDecoder;
    }

    public static void setUseImageDecoder(boolean z) {
        mUseImageDecoder = z;
    }
}
