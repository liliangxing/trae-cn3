package com.fackbook.imagepipeline;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.core.FileCacheFactory;
import com.facebook.imagepipeline.core.ImagePipelineExperiments;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: DefaultImagepipelineConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b6\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010Å\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u000e\u0010Æ\u0001\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u000e\u0010Ç\u0001\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u000f\u0010È\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u000e\u0010É\u0001\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0018J\n\u0010Ê\u0001\u001a\u0005\u0018\u00010¹\u0001J\t\u0010Ë\u0001\u001a\u0004\u0018\u00010\u001bJ\t\u0010Ì\u0001\u001a\u0004\u0018\u00010 J\t\u0010Í\u0001\u001a\u0004\u0018\u00010%J\u0015\u0010Î\u0001\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,\u0018\u00010*J\t\u0010Ï\u0001\u001a\u0004\u0018\u00010,J\u000e\u0010Ð\u0001\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u000e\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u000e\u0010Ò\u0001\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u000e\u0010Ó\u0001\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u000e\u0010Ô\u0001\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u000e\u0010Õ\u0001\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u000f\u0010Ö\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\t\u0010×\u0001\u001a\u0004\u0018\u00010JJ\t\u0010Ø\u0001\u001a\u0004\u0018\u00010OJ\u000e\u0010Ù\u0001\u001a\u0004\u0018\u00010T¢\u0006\u0002\u0010VJ\t\u0010Ú\u0001\u001a\u0004\u0018\u00010YJ\t\u0010Û\u0001\u001a\u0004\u0018\u00010^J\t\u0010Ü\u0001\u001a\u0004\u0018\u00010cJ\t\u0010Ý\u0001\u001a\u0004\u0018\u00010hJ\n\u0010Þ\u0001\u001a\u0005\u0018\u00010¾\u0001J\t\u0010ß\u0001\u001a\u0004\u0018\u00010mJ\u000e\u0010à\u0001\u001a\u0004\u0018\u00010T¢\u0006\u0002\u0010VJ\u000f\u0010á\u0001\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004J\u000e\u0010â\u0001\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u000f\u0010ã\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u000e\u0010ä\u0001\u001a\u0004\u0018\u00010T¢\u0006\u0002\u0010VJ\n\u0010å\u0001\u001a\u0005\u0018\u00010\u0081\u0001J\u0013\u0010æ\u0001\u001a\u000e\u0012\u0007\b\u0001\u0012\u00030\u0087\u0001\u0018\u00010\u0086\u0001J\n\u0010ç\u0001\u001a\u0005\u0018\u00010\u008c\u0001J\n\u0010è\u0001\u001a\u0005\u0018\u00010\u0091\u0001J\u000f\u0010é\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\n\u0010ê\u0001\u001a\u0005\u0018\u00010\u0099\u0001J\u0011\u0010ë\u0001\u001a\f\u0012\u0005\u0012\u00030\u009f\u0001\u0018\u00010\u009e\u0001J\u000e\u0010ì\u0001\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u000e\u0010í\u0001\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u000e\u0010î\u0001\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u000f\u0010ï\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\t\u0010ð\u0001\u001a\u0004\u0018\u00010,J\u000e\u0010ñ\u0001\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u000e\u0010ò\u0001\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u000e\u0010ó\u0001\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rR#\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0010\u0010\rR#\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0013\u0010\u0007R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\t\u001a\u0004\b!\u0010\"R\u001d\u0010$\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\t\u001a\u0004\b&\u0010'R)\u0010)\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,\u0018\u00010*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\t\u001a\u0004\b-\u0010.R\u001d\u00100\u001a\u0004\u0018\u00010,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\t\u001a\u0004\b1\u00102R\u001d\u00104\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\t\u001a\u0004\b5\u0010\rR\u001d\u00107\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\t\u001a\u0004\b8\u0010\rR\u001d\u0010:\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\t\u001a\u0004\b;\u0010\rR\u001d\u0010=\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\t\u001a\u0004\b>\u0010\rR\u001d\u0010@\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\t\u001a\u0004\bA\u0010\rR\u001d\u0010C\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\t\u001a\u0004\bD\u0010\rR#\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\t\u001a\u0004\bG\u0010\u0007R\u001d\u0010I\u001a\u0004\u0018\u00010J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\t\u001a\u0004\bK\u0010LR\u001d\u0010N\u001a\u0004\u0018\u00010O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\t\u001a\u0004\bP\u0010QR\u001d\u0010S\u001a\u0004\u0018\u00010T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\t\u001a\u0004\bU\u0010VR\u001d\u0010X\u001a\u0004\u0018\u00010Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\t\u001a\u0004\bZ\u0010[R\u001d\u0010]\u001a\u0004\u0018\u00010^8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\ba\u0010\t\u001a\u0004\b_\u0010`R\u001d\u0010b\u001a\u0004\u0018\u00010c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010\t\u001a\u0004\bd\u0010eR\u001d\u0010g\u001a\u0004\u0018\u00010h8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010\t\u001a\u0004\bi\u0010jR\u001d\u0010l\u001a\u0004\u0018\u00010m8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010\t\u001a\u0004\bn\u0010oR\u001d\u0010q\u001a\u0004\u0018\u00010T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bs\u0010\t\u001a\u0004\br\u0010VR#\u0010t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bv\u0010\t\u001a\u0004\bu\u0010\u0007R\u001d\u0010w\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\by\u0010\t\u001a\u0004\bx\u0010\rR#\u0010z\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b|\u0010\t\u001a\u0004\b{\u0010\u0007R\u001d\u0010}\u001a\u0004\u0018\u00010T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u007f\u0010\t\u001a\u0004\b~\u0010VR\"\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0084\u0001\u0010\t\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R+\u0010\u0085\u0001\u001a\u000e\u0012\u0007\b\u0001\u0012\u00030\u0087\u0001\u0018\u00010\u0086\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008a\u0001\u0010\t\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\"\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008f\u0001\u0010\t\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\"\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0094\u0001\u0010\t\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R&\u0010\u0095\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0097\u0001\u0010\t\u001a\u0005\b\u0096\u0001\u0010\u0007R\"\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009c\u0001\u0010\t\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R)\u0010\u009d\u0001\u001a\f\u0012\u0005\u0012\u00030\u009f\u0001\u0018\u00010\u009e\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¢\u0001\u0010\t\u001a\u0006\b \u0001\u0010¡\u0001R \u0010£\u0001\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b¥\u0001\u0010\t\u001a\u0005\b¤\u0001\u0010\rR \u0010¦\u0001\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b¨\u0001\u0010\t\u001a\u0005\b§\u0001\u0010\rR \u0010©\u0001\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b«\u0001\u0010\t\u001a\u0005\bª\u0001\u0010\rR&\u0010¬\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b®\u0001\u0010\t\u001a\u0005\b\u00ad\u0001\u0010\u0007R \u0010¯\u0001\u001a\u0004\u0018\u00010,8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b±\u0001\u0010\t\u001a\u0005\b°\u0001\u00102R \u0010²\u0001\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b´\u0001\u0010\t\u001a\u0005\b³\u0001\u0010\rR \u0010µ\u0001\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b·\u0001\u0010\t\u001a\u0005\b¶\u0001\u0010\rR\"\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¼\u0001\u0010\t\u001a\u0006\bº\u0001\u0010»\u0001R\"\u0010½\u0001\u001a\u0005\u0018\u00010¾\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÁ\u0001\u0010\t\u001a\u0006\b¿\u0001\u0010À\u0001R \u0010Â\u0001\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\bÄ\u0001\u0010\t\u001a\u0005\bÃ\u0001\u0010\r¨\u0006ô\u0001"}, d2 = {"Lcom/fackbook/imagepipeline/DefaultImagepipelineConfig;", "", "()V", "lazy_AnimMemoryCacheParams", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/imagepipeline/cache/MemoryCacheParams;", "getLazy_AnimMemoryCacheParams", "()Lcom/facebook/common/internal/Supplier;", "lazy_AnimMemoryCacheParams$delegate", "Lkotlin/Lazy;", "lazy_AnimatedHeifIndividualCacheEnabled", "", "getLazy_AnimatedHeifIndividualCacheEnabled", "()Ljava/lang/Boolean;", "lazy_AnimatedHeifIndividualCacheEnabled$delegate", "lazy_AnimatedHeifIndividualCacheForImageRequestEnabled", "getLazy_AnimatedHeifIndividualCacheForImageRequestEnabled", "lazy_AnimatedHeifIndividualCacheForImageRequestEnabled$delegate", "lazy_BigImgBitmapMemoryCacheParamsSupplier", "getLazy_BigImgBitmapMemoryCacheParamsSupplier", "lazy_BigImgBitmapMemoryCacheParamsSupplier$delegate", "lazy_BigImgSizeLimit", "", "getLazy_BigImgSizeLimit", "()Ljava/lang/Long;", "lazy_BigImgSizeLimit$delegate", "lazy_CacheKeyFactory", "Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "getLazy_CacheKeyFactory", "()Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "lazy_CacheKeyFactory$delegate", "lazy_CacheTrimStrategy", "Lcom/facebook/imagepipeline/cache/CountingMemoryCache$CacheTrimStrategy;", "getLazy_CacheTrimStrategy", "()Lcom/facebook/imagepipeline/cache/CountingMemoryCache$CacheTrimStrategy;", "lazy_CacheTrimStrategy$delegate", "lazy_Context", "Landroid/content/Context;", "getLazy_Context", "()Landroid/content/Context;", "lazy_Context$delegate", "lazy_CustomImageDiskCacheConfigMap", "Ljava/util/HashMap;", "", "Lcom/facebook/cache/disk/DiskCacheConfig;", "getLazy_CustomImageDiskCacheConfigMap", "()Ljava/util/HashMap;", "lazy_CustomImageDiskCacheConfigMap$delegate", "lazy_DiskCacheConfig", "getLazy_DiskCacheConfig", "()Lcom/facebook/cache/disk/DiskCacheConfig;", "lazy_DiskCacheConfig$delegate", "lazy_DiskCacheEnabled", "getLazy_DiskCacheEnabled", "lazy_DiskCacheEnabled$delegate", "lazy_DownsampleEnabled", "getLazy_DownsampleEnabled", "lazy_DownsampleEnabled$delegate", "lazy_EnableBigImgCache", "getLazy_EnableBigImgCache", "lazy_EnableBigImgCache$delegate", "lazy_EnableNewLocalVideoThumbnailOpt", "getLazy_EnableNewLocalVideoThumbnailOpt", "lazy_EnableNewLocalVideoThumbnailOpt$delegate", "lazy_EnablePrefetchImgCache", "getLazy_EnablePrefetchImgCache", "lazy_EnablePrefetchImgCache$delegate", "lazy_EnableSingleMemCache", "getLazy_EnableSingleMemCache", "lazy_EnableSingleMemCache$delegate", "lazy_EncodedMemoryCacheParams", "getLazy_EncodedMemoryCacheParams", "lazy_EncodedMemoryCacheParams$delegate", "lazy_ExecutorSupplier", "Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "getLazy_ExecutorSupplier", "()Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "lazy_ExecutorSupplier$delegate", "lazy_FileCacheFactory", "Lcom/facebook/imagepipeline/core/FileCacheFactory;", "getLazy_FileCacheFactory", "()Lcom/facebook/imagepipeline/core/FileCacheFactory;", "lazy_FileCacheFactory$delegate", "lazy_HttpNetworkTimeout", "", "getLazy_HttpNetworkTimeout", "()Ljava/lang/Integer;", "lazy_HttpNetworkTimeout$delegate", "lazy_ImageCacheStatsTracker", "Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;", "getLazy_ImageCacheStatsTracker", "()Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;", "lazy_ImageCacheStatsTracker$delegate", "lazy_ImageDecoder", "Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "getLazy_ImageDecoder", "()Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "lazy_ImageDecoder$delegate", "lazy_ImageDecoderConfig", "Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig;", "getLazy_ImageDecoderConfig", "()Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig;", "lazy_ImageDecoderConfig$delegate", "lazy_ImagePipelineExperiments", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments;", "getLazy_ImagePipelineExperiments", "()Lcom/facebook/imagepipeline/core/ImagePipelineExperiments;", "lazy_ImagePipelineExperiments$delegate", "lazy_ImageTranscoderFactory", "Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "getLazy_ImageTranscoderFactory", "()Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "lazy_ImageTranscoderFactory$delegate", "lazy_ImageTranscoderType", "getLazy_ImageTranscoderType", "lazy_ImageTranscoderType$delegate", "lazy_IsPrefetchEnabledSupplier", "getLazy_IsPrefetchEnabledSupplier", "lazy_IsPrefetchEnabledSupplier$delegate", "lazy_IsSplitMemCache", "getLazy_IsSplitMemCache", "lazy_IsSplitMemCache$delegate", "lazy_MemoryCacheParams", "getLazy_MemoryCacheParams", "lazy_MemoryCacheParams$delegate", "lazy_MemoryChunkType", "getLazy_MemoryChunkType", "lazy_MemoryChunkType$delegate", "lazy_MemoryTrimmableRegistry", "Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "getLazy_MemoryTrimmableRegistry", "()Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "lazy_MemoryTrimmableRegistry$delegate", "lazy_NetworkFetcher", "Lcom/facebook/imagepipeline/producers/NetworkFetcher;", "Lcom/facebook/imagepipeline/producers/FetchState;", "getLazy_NetworkFetcher", "()Lcom/facebook/imagepipeline/producers/NetworkFetcher;", "lazy_NetworkFetcher$delegate", "lazy_PlatformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "getLazy_PlatformBitmapFactory", "()Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "lazy_PlatformBitmapFactory$delegate", "lazy_PoolFactory", "Lcom/facebook/imagepipeline/memory/PoolFactory;", "getLazy_PoolFactory", "()Lcom/facebook/imagepipeline/memory/PoolFactory;", "lazy_PoolFactory$delegate", "lazy_PrefetchImgBitmapMemoryCacheParamsSupplier", "getLazy_PrefetchImgBitmapMemoryCacheParamsSupplier", "lazy_PrefetchImgBitmapMemoryCacheParamsSupplier$delegate", "lazy_ProgressiveJpegConfig", "Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "getLazy_ProgressiveJpegConfig", "()Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "lazy_ProgressiveJpegConfig$delegate", "lazy_RequestListeners", "", "Lcom/facebook/imagepipeline/listener/RequestListener;", "getLazy_RequestListeners", "()Ljava/util/Set;", "lazy_RequestListeners$delegate", "lazy_ResizeAndRotateEnabledForNetwork", "getLazy_ResizeAndRotateEnabledForNetwork", "lazy_ResizeAndRotateEnabledForNetwork$delegate", "lazy_RetainPreviousImage", "getLazy_RetainPreviousImage", "lazy_RetainPreviousImage$delegate", "lazy_ShowHeifDebugLog", "getLazy_ShowHeifDebugLog", "lazy_ShowHeifDebugLog$delegate", "lazy_SingleBitmapMemoryCacheParamsSupplier", "getLazy_SingleBitmapMemoryCacheParamsSupplier", "lazy_SingleBitmapMemoryCacheParamsSupplier$delegate", "lazy_SmallImageDiskCacheConfig", "getLazy_SmallImageDiskCacheConfig", "lazy_SmallImageDiskCacheConfig$delegate", "lazy_UseOptHeifBitmap", "getLazy_UseOptHeifBitmap", "lazy_UseOptHeifBitmap$delegate", "lazy_WasImmediate", "getLazy_WasImmediate", "lazy_WasImmediate$delegate", "lazy_bitmapConfig", "Landroid/graphics/Bitmap$Config;", "getLazy_bitmapConfig", "()Landroid/graphics/Bitmap$Config;", "lazy_bitmapConfig$delegate", "lazy_initializer", "Lcom/facebook/imagepipeline/core/ImagePipelineFactory;", "getLazy_initializer", "()Lcom/facebook/imagepipeline/core/ImagePipelineFactory;", "lazy_initializer$delegate", "lazy_useSingleImageRequest", "getLazy_useSingleImageRequest", "lazy_useSingleImageRequest$delegate", "getAnimMemoryCacheParams", "getAnimatedHeifIndividualCacheEnabled", "getAnimatedHeifIndividualCacheForImageRequestEnabled", "getBigBitmapMemoryCacheParams", "getBigImgSizeLimit", "getBitmapConfig", "getCacheKeyFactory", "getCacheTrimStrategy", "getContext", "getCustomImageDiskCacheConfigMap", "getDiskCacheConfig", "getDiskCacheEnabled", "getDownsampleEnabled", "getEnableBigImgCache", "getEnableNewLocalVideoThumbnailOpt", "getEnablePrefetchImgCache", "getEnableSingleMemCache", "getEncodedMemoryCacheParams", "getExecutorSupplier", "getFileCacheFactory", "getHttpNetworkTimeout", "getImageCacheStatsTracker", "getImageDecoder", "getImageDecoderConfig", "getImagePipelineExperiments", "getImagePipelineFactory", "getImageTranscoderFactory", "getImageTranscoderType", "getIsPrefetchEnabledSupplier", "getIsSplitMemCache", "getMemoryCacheParams", "getMemoryChunkType", "getMemoryTrimmableRegistry", "getNetworkFetcher", "getPlatformBitmapFactory", "getPoolFactory", "getPrefetchImgBitmapMemoryCacheParams", "getProgressiveJpegConfig", "getRequestListeners", "getResizeAndRotateEnabledForNetwork", "getRetainPreviousImage", "getShowHeifDebugLog", "getSingleBitmapMemoryCacheParams", "getSmallImageDiskCacheConfig", "getUseOptHeifBitmap", "getUseSingleImageRequest", "getWasImmediate", "imagepipeline_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class DefaultImagepipelineConfig {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_initializer", "getLazy_initializer()Lcom/facebook/imagepipeline/core/ImagePipelineFactory;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_bitmapConfig", "getLazy_bitmapConfig()Landroid/graphics/Bitmap$Config;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_MemoryCacheParams", "getLazy_MemoryCacheParams()Lcom/facebook/common/internal/Supplier;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_AnimMemoryCacheParams", "getLazy_AnimMemoryCacheParams()Lcom/facebook/common/internal/Supplier;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_CacheTrimStrategy", "getLazy_CacheTrimStrategy()Lcom/facebook/imagepipeline/cache/CountingMemoryCache$CacheTrimStrategy;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_CacheKeyFactory", "getLazy_CacheKeyFactory()Lcom/facebook/imagepipeline/cache/CacheKeyFactory;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_Context", "getLazy_Context()Landroid/content/Context;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_DownsampleEnabled", "getLazy_DownsampleEnabled()Ljava/lang/Boolean;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_FileCacheFactory", "getLazy_FileCacheFactory()Lcom/facebook/imagepipeline/core/FileCacheFactory;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_EncodedMemoryCacheParams", "getLazy_EncodedMemoryCacheParams()Lcom/facebook/common/internal/Supplier;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_ExecutorSupplier", "getLazy_ExecutorSupplier()Lcom/facebook/imagepipeline/core/ExecutorSupplier;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_ImageCacheStatsTracker", "getLazy_ImageCacheStatsTracker()Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_ImageDecoder", "getLazy_ImageDecoder()Lcom/facebook/imagepipeline/decoder/ImageDecoder;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_ImageTranscoderFactory", "getLazy_ImageTranscoderFactory()Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_ImageTranscoderType", "getLazy_ImageTranscoderType()Ljava/lang/Integer;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_IsPrefetchEnabledSupplier", "getLazy_IsPrefetchEnabledSupplier()Lcom/facebook/common/internal/Supplier;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_DiskCacheConfig", "getLazy_DiskCacheConfig()Lcom/facebook/cache/disk/DiskCacheConfig;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_MemoryTrimmableRegistry", "getLazy_MemoryTrimmableRegistry()Lcom/facebook/common/memory/MemoryTrimmableRegistry;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_MemoryChunkType", "getLazy_MemoryChunkType()Ljava/lang/Integer;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_NetworkFetcher", "getLazy_NetworkFetcher()Lcom/facebook/imagepipeline/producers/NetworkFetcher;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_HttpNetworkTimeout", "getLazy_HttpNetworkTimeout()Ljava/lang/Integer;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_PlatformBitmapFactory", "getLazy_PlatformBitmapFactory()Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_PoolFactory", "getLazy_PoolFactory()Lcom/facebook/imagepipeline/memory/PoolFactory;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_ProgressiveJpegConfig", "getLazy_ProgressiveJpegConfig()Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_RequestListeners", "getLazy_RequestListeners()Ljava/util/Set;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_ResizeAndRotateEnabledForNetwork", "getLazy_ResizeAndRotateEnabledForNetwork()Ljava/lang/Boolean;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_SmallImageDiskCacheConfig", "getLazy_SmallImageDiskCacheConfig()Lcom/facebook/cache/disk/DiskCacheConfig;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_ImageDecoderConfig", "getLazy_ImageDecoderConfig()Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_ImagePipelineExperiments", "getLazy_ImagePipelineExperiments()Lcom/facebook/imagepipeline/core/ImagePipelineExperiments;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_IsSplitMemCache", "getLazy_IsSplitMemCache()Ljava/lang/Boolean;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_EnableSingleMemCache", "getLazy_EnableSingleMemCache()Ljava/lang/Boolean;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_SingleBitmapMemoryCacheParamsSupplier", "getLazy_SingleBitmapMemoryCacheParamsSupplier()Lcom/facebook/common/internal/Supplier;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_AnimatedHeifIndividualCacheEnabled", "getLazy_AnimatedHeifIndividualCacheEnabled()Ljava/lang/Boolean;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_ShowHeifDebugLog", "getLazy_ShowHeifDebugLog()Ljava/lang/Boolean;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_AnimatedHeifIndividualCacheForImageRequestEnabled", "getLazy_AnimatedHeifIndividualCacheForImageRequestEnabled()Ljava/lang/Boolean;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_DiskCacheEnabled", "getLazy_DiskCacheEnabled()Ljava/lang/Boolean;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_WasImmediate", "getLazy_WasImmediate()Ljava/lang/Boolean;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_useSingleImageRequest", "getLazy_useSingleImageRequest()Ljava/lang/Boolean;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_EnableBigImgCache", "getLazy_EnableBigImgCache()Ljava/lang/Boolean;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_BigImgBitmapMemoryCacheParamsSupplier", "getLazy_BigImgBitmapMemoryCacheParamsSupplier()Lcom/facebook/common/internal/Supplier;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_EnablePrefetchImgCache", "getLazy_EnablePrefetchImgCache()Ljava/lang/Boolean;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_PrefetchImgBitmapMemoryCacheParamsSupplier", "getLazy_PrefetchImgBitmapMemoryCacheParamsSupplier()Lcom/facebook/common/internal/Supplier;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_BigImgSizeLimit", "getLazy_BigImgSizeLimit()Ljava/lang/Long;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_RetainPreviousImage", "getLazy_RetainPreviousImage()Ljava/lang/Boolean;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_EnableNewLocalVideoThumbnailOpt", "getLazy_EnableNewLocalVideoThumbnailOpt()Ljava/lang/Boolean;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_CustomImageDiskCacheConfigMap", "getLazy_CustomImageDiskCacheConfigMap()Ljava/util/HashMap;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultImagepipelineConfig.class), "lazy_UseOptHeifBitmap", "getLazy_UseOptHeifBitmap()Ljava/lang/Boolean;"))};
    public static final DefaultImagepipelineConfig INSTANCE = new DefaultImagepipelineConfig();

    /* renamed from: lazy_initializer$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_initializer = LazyKt.lazy(new Function0<ImagePipelineFactory>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_initializer$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ImagePipelineFactory m2738invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getImagePipelineFactory();
            }
            return null;
        }
    });

    /* renamed from: lazy_bitmapConfig$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_bitmapConfig = LazyKt.lazy(new Function0<Bitmap.Config>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_bitmapConfig$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Bitmap.Config m2737invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getBitmapConfig();
            }
            return null;
        }
    });

    /* renamed from: lazy_MemoryCacheParams$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_MemoryCacheParams = LazyKt.lazy(new Function0<Supplier<MemoryCacheParams>>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_MemoryCacheParams$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Supplier<MemoryCacheParams> m2721invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getMemoryCacheParams();
            }
            return null;
        }
    });

    /* renamed from: lazy_AnimMemoryCacheParams$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_AnimMemoryCacheParams = LazyKt.lazy(new Function0<Supplier<MemoryCacheParams>>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_AnimMemoryCacheParams$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Supplier<MemoryCacheParams> m2693invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getAnimMemoryCacheParams();
            }
            return null;
        }
    });

    /* renamed from: lazy_CacheTrimStrategy$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_CacheTrimStrategy = LazyKt.lazy(new Function0<CountingMemoryCache.CacheTrimStrategy>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_CacheTrimStrategy$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final CountingMemoryCache.CacheTrimStrategy m2699invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getCacheTrimStrategy();
            }
            return null;
        }
    });

    /* renamed from: lazy_CacheKeyFactory$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_CacheKeyFactory = LazyKt.lazy(new Function0<CacheKeyFactory>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_CacheKeyFactory$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final CacheKeyFactory m2698invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getCacheKeyFactory();
            }
            return null;
        }
    });

    /* renamed from: lazy_Context$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_Context = LazyKt.lazy(new Function0<Context>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_Context$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Context m2700invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getContext();
            }
            return null;
        }
    });

    /* renamed from: lazy_DownsampleEnabled$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_DownsampleEnabled = LazyKt.lazy(new Function0<Boolean>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_DownsampleEnabled$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2704invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getDownsampleEnabled();
            }
            return null;
        }
    });

    /* renamed from: lazy_FileCacheFactory$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_FileCacheFactory = LazyKt.lazy(new Function0<FileCacheFactory>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_FileCacheFactory$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final FileCacheFactory m2711invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getFileCacheFactory();
            }
            return null;
        }
    });

    /* renamed from: lazy_EncodedMemoryCacheParams$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_EncodedMemoryCacheParams = LazyKt.lazy(new Function0<Supplier<MemoryCacheParams>>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_EncodedMemoryCacheParams$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Supplier<MemoryCacheParams> m2709invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getEncodedMemoryCacheParams();
            }
            return null;
        }
    });

    /* renamed from: lazy_ExecutorSupplier$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_ExecutorSupplier = LazyKt.lazy(new Function0<ExecutorSupplier>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_ExecutorSupplier$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ExecutorSupplier m2710invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getExecutorSupplier();
            }
            return null;
        }
    });

    /* renamed from: lazy_ImageCacheStatsTracker$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_ImageCacheStatsTracker = LazyKt.lazy(new Function0<ImageCacheStatsTracker>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_ImageCacheStatsTracker$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ImageCacheStatsTracker m2713invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getImageCacheStatsTracker();
            }
            return null;
        }
    });

    /* renamed from: lazy_ImageDecoder$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_ImageDecoder = LazyKt.lazy(new Function0<ImageDecoder>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_ImageDecoder$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ImageDecoder m2714invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getImageDecoder();
            }
            return null;
        }
    });

    /* renamed from: lazy_ImageTranscoderFactory$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_ImageTranscoderFactory = LazyKt.lazy(new Function0<ImageTranscoderFactory>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_ImageTranscoderFactory$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ImageTranscoderFactory m2717invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getImageTranscoderFactory();
            }
            return null;
        }
    });

    /* renamed from: lazy_ImageTranscoderType$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_ImageTranscoderType = LazyKt.lazy(new Function0<Integer>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_ImageTranscoderType$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2718invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getImageTranscoderType();
            }
            return null;
        }
    });

    /* renamed from: lazy_IsPrefetchEnabledSupplier$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_IsPrefetchEnabledSupplier = LazyKt.lazy(new Function0<Supplier<Boolean>>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_IsPrefetchEnabledSupplier$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Supplier<Boolean> m2719invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getIsPrefetchEnabledSupplier();
            }
            return null;
        }
    });

    /* renamed from: lazy_DiskCacheConfig$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_DiskCacheConfig = LazyKt.lazy(new Function0<DiskCacheConfig>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_DiskCacheConfig$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final DiskCacheConfig m2702invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getDiskCacheConfig();
            }
            return null;
        }
    });

    /* renamed from: lazy_MemoryTrimmableRegistry$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_MemoryTrimmableRegistry = LazyKt.lazy(new Function0<MemoryTrimmableRegistry>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_MemoryTrimmableRegistry$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MemoryTrimmableRegistry m2723invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getMemoryTrimmableRegistry();
            }
            return null;
        }
    });

    /* renamed from: lazy_MemoryChunkType$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_MemoryChunkType = LazyKt.lazy(new Function0<Integer>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_MemoryChunkType$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2722invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getMemoryChunkType();
            }
            return null;
        }
    });

    /* renamed from: lazy_NetworkFetcher$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_NetworkFetcher = LazyKt.lazy(new Function0<NetworkFetcher<? extends FetchState>>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_NetworkFetcher$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final NetworkFetcher<? extends FetchState> m2724invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getNetworkFetcher();
            }
            return null;
        }
    });

    /* renamed from: lazy_HttpNetworkTimeout$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_HttpNetworkTimeout = LazyKt.lazy(new Function0<Integer>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_HttpNetworkTimeout$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2712invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getHttpNetworkTimeout();
            }
            return null;
        }
    });

    /* renamed from: lazy_PlatformBitmapFactory$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_PlatformBitmapFactory = LazyKt.lazy(new Function0<PlatformBitmapFactory>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_PlatformBitmapFactory$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final PlatformBitmapFactory m2725invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getPlatformBitmapFactory();
            }
            return null;
        }
    });

    /* renamed from: lazy_PoolFactory$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_PoolFactory = LazyKt.lazy(new Function0<PoolFactory>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_PoolFactory$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final PoolFactory m2726invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getPoolFactory();
            }
            return null;
        }
    });

    /* renamed from: lazy_ProgressiveJpegConfig$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_ProgressiveJpegConfig = LazyKt.lazy(new Function0<ProgressiveJpegConfig>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_ProgressiveJpegConfig$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ProgressiveJpegConfig m2728invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getProgressiveJpegConfig();
            }
            return null;
        }
    });

    /* renamed from: lazy_RequestListeners$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_RequestListeners = LazyKt.lazy(new Function0<Set<? extends RequestListener>>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_RequestListeners$2
        public final Set<RequestListener> invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getRequestListeners();
            }
            return null;
        }
    });

    /* renamed from: lazy_ResizeAndRotateEnabledForNetwork$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_ResizeAndRotateEnabledForNetwork = LazyKt.lazy(new Function0<Boolean>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_ResizeAndRotateEnabledForNetwork$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2730invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getResizeAndRotateEnabledForNetwork();
            }
            return null;
        }
    });

    /* renamed from: lazy_SmallImageDiskCacheConfig$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_SmallImageDiskCacheConfig = LazyKt.lazy(new Function0<DiskCacheConfig>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_SmallImageDiskCacheConfig$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final DiskCacheConfig m2734invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getSmallImageDiskCacheConfig();
            }
            return null;
        }
    });

    /* renamed from: lazy_ImageDecoderConfig$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_ImageDecoderConfig = LazyKt.lazy(new Function0<ImageDecoderConfig>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_ImageDecoderConfig$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ImageDecoderConfig m2715invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getImageDecoderConfig();
            }
            return null;
        }
    });

    /* renamed from: lazy_ImagePipelineExperiments$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_ImagePipelineExperiments = LazyKt.lazy(new Function0<ImagePipelineExperiments>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_ImagePipelineExperiments$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ImagePipelineExperiments m2716invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getImagePipelineExperiments();
            }
            return null;
        }
    });

    /* renamed from: lazy_IsSplitMemCache$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_IsSplitMemCache = LazyKt.lazy(new Function0<Boolean>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_IsSplitMemCache$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2720invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getIsSplitMemCache();
            }
            return null;
        }
    });

    /* renamed from: lazy_EnableSingleMemCache$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_EnableSingleMemCache = LazyKt.lazy(new Function0<Boolean>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_EnableSingleMemCache$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2708invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getEnableSingleMemCache();
            }
            return null;
        }
    });

    /* renamed from: lazy_SingleBitmapMemoryCacheParamsSupplier$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_SingleBitmapMemoryCacheParamsSupplier = LazyKt.lazy(new Function0<Supplier<MemoryCacheParams>>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_SingleBitmapMemoryCacheParamsSupplier$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Supplier<MemoryCacheParams> m2733invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getSingleBitmapMemoryCacheParamsSupplier();
            }
            return null;
        }
    });

    /* renamed from: lazy_AnimatedHeifIndividualCacheEnabled$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_AnimatedHeifIndividualCacheEnabled = LazyKt.lazy(new Function0<Boolean>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_AnimatedHeifIndividualCacheEnabled$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2694invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getAnimatedHeifIndividualCacheEnabled();
            }
            return null;
        }
    });

    /* renamed from: lazy_ShowHeifDebugLog$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_ShowHeifDebugLog = LazyKt.lazy(new Function0<Boolean>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_ShowHeifDebugLog$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2732invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getShowHeifDebugLog();
            }
            return null;
        }
    });

    /* renamed from: lazy_AnimatedHeifIndividualCacheForImageRequestEnabled$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_AnimatedHeifIndividualCacheForImageRequestEnabled = LazyKt.lazy(new Function0<Boolean>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_AnimatedHeifIndividualCacheForImageRequestEnabled$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2695invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getAnimatedHeifIndividualCacheForImageRequestEnabled();
            }
            return null;
        }
    });

    /* renamed from: lazy_DiskCacheEnabled$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_DiskCacheEnabled = LazyKt.lazy(new Function0<Boolean>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_DiskCacheEnabled$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2703invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getDiskCacheEnabled();
            }
            return null;
        }
    });

    /* renamed from: lazy_WasImmediate$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_WasImmediate = LazyKt.lazy(new Function0<Boolean>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_WasImmediate$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2736invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getWasImmediate();
            }
            return null;
        }
    });

    /* renamed from: lazy_useSingleImageRequest$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_useSingleImageRequest = LazyKt.lazy(new Function0<Boolean>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_useSingleImageRequest$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2739invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getUseSingleImageRequest();
            }
            return null;
        }
    });

    /* renamed from: lazy_EnableBigImgCache$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_EnableBigImgCache = LazyKt.lazy(new Function0<Boolean>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_EnableBigImgCache$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2705invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getEnableBigImgCache();
            }
            return null;
        }
    });

    /* renamed from: lazy_BigImgBitmapMemoryCacheParamsSupplier$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_BigImgBitmapMemoryCacheParamsSupplier = LazyKt.lazy(new Function0<Supplier<MemoryCacheParams>>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_BigImgBitmapMemoryCacheParamsSupplier$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Supplier<MemoryCacheParams> m2696invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getBigImgBitmapMemoryCacheParamsSupplier();
            }
            return null;
        }
    });

    /* renamed from: lazy_EnablePrefetchImgCache$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_EnablePrefetchImgCache = LazyKt.lazy(new Function0<Boolean>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_EnablePrefetchImgCache$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2707invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getEnablePrefetchImgCache();
            }
            return null;
        }
    });

    /* renamed from: lazy_PrefetchImgBitmapMemoryCacheParamsSupplier$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_PrefetchImgBitmapMemoryCacheParamsSupplier = LazyKt.lazy(new Function0<Supplier<MemoryCacheParams>>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_PrefetchImgBitmapMemoryCacheParamsSupplier$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Supplier<MemoryCacheParams> m2727invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getPrefetchImgBitmapMemoryCacheParamsSupplier();
            }
            return null;
        }
    });

    /* renamed from: lazy_BigImgSizeLimit$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_BigImgSizeLimit = LazyKt.lazy(new Function0<Long>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_BigImgSizeLimit$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Long m2697invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getBigImgSizeLimit();
            }
            return null;
        }
    });

    /* renamed from: lazy_RetainPreviousImage$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_RetainPreviousImage = LazyKt.lazy(new Function0<Boolean>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_RetainPreviousImage$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2731invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getRetainPreviousImage();
            }
            return null;
        }
    });

    /* renamed from: lazy_EnableNewLocalVideoThumbnailOpt$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_EnableNewLocalVideoThumbnailOpt = LazyKt.lazy(new Function0<Boolean>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_EnableNewLocalVideoThumbnailOpt$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2706invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getEnableNewLocalVideoThumbnailOpt();
            }
            return null;
        }
    });

    /* renamed from: lazy_CustomImageDiskCacheConfigMap$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_CustomImageDiskCacheConfigMap = LazyKt.lazy(new Function0<HashMap<String, DiskCacheConfig>>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_CustomImageDiskCacheConfigMap$2
        public final HashMap<String, DiskCacheConfig> invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getCustomImageDiskCacheConfigMap();
            }
            return null;
        }
    });

    /* renamed from: lazy_UseOptHeifBitmap$delegate, reason: from kotlin metadata */
    private static final Lazy lazy_UseOptHeifBitmap = LazyKt.lazy(new Function0<Boolean>() { // from class: com.fackbook.imagepipeline.DefaultImagepipelineConfig$lazy_UseOptHeifBitmap$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2735invoke() {
            IImagePipelineOutService iImagePipelineOutService = (IImagePipelineOutService) ServiceManager.get().getService(IImagePipelineOutService.class);
            if (iImagePipelineOutService != null) {
                return iImagePipelineOutService.getUseOptHeifBitmap();
            }
            return null;
        }
    });

    private final Supplier<MemoryCacheParams> getLazy_AnimMemoryCacheParams() {
        Lazy lazy = lazy_AnimMemoryCacheParams;
        KProperty kProperty = $$delegatedProperties[3];
        return (Supplier) lazy.getValue();
    }

    private final Boolean getLazy_AnimatedHeifIndividualCacheEnabled() {
        Lazy lazy = lazy_AnimatedHeifIndividualCacheEnabled;
        KProperty kProperty = $$delegatedProperties[32];
        return (Boolean) lazy.getValue();
    }

    private final Boolean getLazy_AnimatedHeifIndividualCacheForImageRequestEnabled() {
        Lazy lazy = lazy_AnimatedHeifIndividualCacheForImageRequestEnabled;
        KProperty kProperty = $$delegatedProperties[34];
        return (Boolean) lazy.getValue();
    }

    private final Supplier<MemoryCacheParams> getLazy_BigImgBitmapMemoryCacheParamsSupplier() {
        Lazy lazy = lazy_BigImgBitmapMemoryCacheParamsSupplier;
        KProperty kProperty = $$delegatedProperties[39];
        return (Supplier) lazy.getValue();
    }

    private final Long getLazy_BigImgSizeLimit() {
        Lazy lazy = lazy_BigImgSizeLimit;
        KProperty kProperty = $$delegatedProperties[42];
        return (Long) lazy.getValue();
    }

    private final CacheKeyFactory getLazy_CacheKeyFactory() {
        Lazy lazy = lazy_CacheKeyFactory;
        KProperty kProperty = $$delegatedProperties[5];
        return (CacheKeyFactory) lazy.getValue();
    }

    private final CountingMemoryCache.CacheTrimStrategy getLazy_CacheTrimStrategy() {
        Lazy lazy = lazy_CacheTrimStrategy;
        KProperty kProperty = $$delegatedProperties[4];
        return (CountingMemoryCache.CacheTrimStrategy) lazy.getValue();
    }

    private final Context getLazy_Context() {
        Lazy lazy = lazy_Context;
        KProperty kProperty = $$delegatedProperties[6];
        return (Context) lazy.getValue();
    }

    private final HashMap<String, DiskCacheConfig> getLazy_CustomImageDiskCacheConfigMap() {
        Lazy lazy = lazy_CustomImageDiskCacheConfigMap;
        KProperty kProperty = $$delegatedProperties[45];
        return (HashMap) lazy.getValue();
    }

    private final DiskCacheConfig getLazy_DiskCacheConfig() {
        Lazy lazy = lazy_DiskCacheConfig;
        KProperty kProperty = $$delegatedProperties[16];
        return (DiskCacheConfig) lazy.getValue();
    }

    private final Boolean getLazy_DiskCacheEnabled() {
        Lazy lazy = lazy_DiskCacheEnabled;
        KProperty kProperty = $$delegatedProperties[35];
        return (Boolean) lazy.getValue();
    }

    private final Boolean getLazy_DownsampleEnabled() {
        Lazy lazy = lazy_DownsampleEnabled;
        KProperty kProperty = $$delegatedProperties[7];
        return (Boolean) lazy.getValue();
    }

    private final Boolean getLazy_EnableBigImgCache() {
        Lazy lazy = lazy_EnableBigImgCache;
        KProperty kProperty = $$delegatedProperties[38];
        return (Boolean) lazy.getValue();
    }

    private final Boolean getLazy_EnableNewLocalVideoThumbnailOpt() {
        Lazy lazy = lazy_EnableNewLocalVideoThumbnailOpt;
        KProperty kProperty = $$delegatedProperties[44];
        return (Boolean) lazy.getValue();
    }

    private final Boolean getLazy_EnablePrefetchImgCache() {
        Lazy lazy = lazy_EnablePrefetchImgCache;
        KProperty kProperty = $$delegatedProperties[40];
        return (Boolean) lazy.getValue();
    }

    private final Boolean getLazy_EnableSingleMemCache() {
        Lazy lazy = lazy_EnableSingleMemCache;
        KProperty kProperty = $$delegatedProperties[30];
        return (Boolean) lazy.getValue();
    }

    private final Supplier<MemoryCacheParams> getLazy_EncodedMemoryCacheParams() {
        Lazy lazy = lazy_EncodedMemoryCacheParams;
        KProperty kProperty = $$delegatedProperties[9];
        return (Supplier) lazy.getValue();
    }

    private final ExecutorSupplier getLazy_ExecutorSupplier() {
        Lazy lazy = lazy_ExecutorSupplier;
        KProperty kProperty = $$delegatedProperties[10];
        return (ExecutorSupplier) lazy.getValue();
    }

    private final FileCacheFactory getLazy_FileCacheFactory() {
        Lazy lazy = lazy_FileCacheFactory;
        KProperty kProperty = $$delegatedProperties[8];
        return (FileCacheFactory) lazy.getValue();
    }

    private final Integer getLazy_HttpNetworkTimeout() {
        Lazy lazy = lazy_HttpNetworkTimeout;
        KProperty kProperty = $$delegatedProperties[20];
        return (Integer) lazy.getValue();
    }

    private final ImageCacheStatsTracker getLazy_ImageCacheStatsTracker() {
        Lazy lazy = lazy_ImageCacheStatsTracker;
        KProperty kProperty = $$delegatedProperties[11];
        return (ImageCacheStatsTracker) lazy.getValue();
    }

    private final ImageDecoder getLazy_ImageDecoder() {
        Lazy lazy = lazy_ImageDecoder;
        KProperty kProperty = $$delegatedProperties[12];
        return (ImageDecoder) lazy.getValue();
    }

    private final ImageDecoderConfig getLazy_ImageDecoderConfig() {
        Lazy lazy = lazy_ImageDecoderConfig;
        KProperty kProperty = $$delegatedProperties[27];
        return (ImageDecoderConfig) lazy.getValue();
    }

    private final ImagePipelineExperiments getLazy_ImagePipelineExperiments() {
        Lazy lazy = lazy_ImagePipelineExperiments;
        KProperty kProperty = $$delegatedProperties[28];
        return (ImagePipelineExperiments) lazy.getValue();
    }

    private final ImageTranscoderFactory getLazy_ImageTranscoderFactory() {
        Lazy lazy = lazy_ImageTranscoderFactory;
        KProperty kProperty = $$delegatedProperties[13];
        return (ImageTranscoderFactory) lazy.getValue();
    }

    private final Integer getLazy_ImageTranscoderType() {
        Lazy lazy = lazy_ImageTranscoderType;
        KProperty kProperty = $$delegatedProperties[14];
        return (Integer) lazy.getValue();
    }

    private final Supplier<Boolean> getLazy_IsPrefetchEnabledSupplier() {
        Lazy lazy = lazy_IsPrefetchEnabledSupplier;
        KProperty kProperty = $$delegatedProperties[15];
        return (Supplier) lazy.getValue();
    }

    private final Boolean getLazy_IsSplitMemCache() {
        Lazy lazy = lazy_IsSplitMemCache;
        KProperty kProperty = $$delegatedProperties[29];
        return (Boolean) lazy.getValue();
    }

    private final Supplier<MemoryCacheParams> getLazy_MemoryCacheParams() {
        Lazy lazy = lazy_MemoryCacheParams;
        KProperty kProperty = $$delegatedProperties[2];
        return (Supplier) lazy.getValue();
    }

    private final Integer getLazy_MemoryChunkType() {
        Lazy lazy = lazy_MemoryChunkType;
        KProperty kProperty = $$delegatedProperties[18];
        return (Integer) lazy.getValue();
    }

    private final MemoryTrimmableRegistry getLazy_MemoryTrimmableRegistry() {
        Lazy lazy = lazy_MemoryTrimmableRegistry;
        KProperty kProperty = $$delegatedProperties[17];
        return (MemoryTrimmableRegistry) lazy.getValue();
    }

    private final NetworkFetcher<? extends FetchState> getLazy_NetworkFetcher() {
        Lazy lazy = lazy_NetworkFetcher;
        KProperty kProperty = $$delegatedProperties[19];
        return (NetworkFetcher) lazy.getValue();
    }

    private final PlatformBitmapFactory getLazy_PlatformBitmapFactory() {
        Lazy lazy = lazy_PlatformBitmapFactory;
        KProperty kProperty = $$delegatedProperties[21];
        return (PlatformBitmapFactory) lazy.getValue();
    }

    private final PoolFactory getLazy_PoolFactory() {
        Lazy lazy = lazy_PoolFactory;
        KProperty kProperty = $$delegatedProperties[22];
        return (PoolFactory) lazy.getValue();
    }

    private final Supplier<MemoryCacheParams> getLazy_PrefetchImgBitmapMemoryCacheParamsSupplier() {
        Lazy lazy = lazy_PrefetchImgBitmapMemoryCacheParamsSupplier;
        KProperty kProperty = $$delegatedProperties[41];
        return (Supplier) lazy.getValue();
    }

    private final ProgressiveJpegConfig getLazy_ProgressiveJpegConfig() {
        Lazy lazy = lazy_ProgressiveJpegConfig;
        KProperty kProperty = $$delegatedProperties[23];
        return (ProgressiveJpegConfig) lazy.getValue();
    }

    private final Set<RequestListener> getLazy_RequestListeners() {
        Lazy lazy = lazy_RequestListeners;
        KProperty kProperty = $$delegatedProperties[24];
        return (Set) lazy.getValue();
    }

    private final Boolean getLazy_ResizeAndRotateEnabledForNetwork() {
        Lazy lazy = lazy_ResizeAndRotateEnabledForNetwork;
        KProperty kProperty = $$delegatedProperties[25];
        return (Boolean) lazy.getValue();
    }

    private final Boolean getLazy_RetainPreviousImage() {
        Lazy lazy = lazy_RetainPreviousImage;
        KProperty kProperty = $$delegatedProperties[43];
        return (Boolean) lazy.getValue();
    }

    private final Boolean getLazy_ShowHeifDebugLog() {
        Lazy lazy = lazy_ShowHeifDebugLog;
        KProperty kProperty = $$delegatedProperties[33];
        return (Boolean) lazy.getValue();
    }

    private final Supplier<MemoryCacheParams> getLazy_SingleBitmapMemoryCacheParamsSupplier() {
        Lazy lazy = lazy_SingleBitmapMemoryCacheParamsSupplier;
        KProperty kProperty = $$delegatedProperties[31];
        return (Supplier) lazy.getValue();
    }

    private final DiskCacheConfig getLazy_SmallImageDiskCacheConfig() {
        Lazy lazy = lazy_SmallImageDiskCacheConfig;
        KProperty kProperty = $$delegatedProperties[26];
        return (DiskCacheConfig) lazy.getValue();
    }

    private final Boolean getLazy_UseOptHeifBitmap() {
        Lazy lazy = lazy_UseOptHeifBitmap;
        KProperty kProperty = $$delegatedProperties[46];
        return (Boolean) lazy.getValue();
    }

    private final Boolean getLazy_WasImmediate() {
        Lazy lazy = lazy_WasImmediate;
        KProperty kProperty = $$delegatedProperties[36];
        return (Boolean) lazy.getValue();
    }

    private final Bitmap.Config getLazy_bitmapConfig() {
        Lazy lazy = lazy_bitmapConfig;
        KProperty kProperty = $$delegatedProperties[1];
        return (Bitmap.Config) lazy.getValue();
    }

    private final ImagePipelineFactory getLazy_initializer() {
        Lazy lazy = lazy_initializer;
        KProperty kProperty = $$delegatedProperties[0];
        return (ImagePipelineFactory) lazy.getValue();
    }

    private final Boolean getLazy_useSingleImageRequest() {
        Lazy lazy = lazy_useSingleImageRequest;
        KProperty kProperty = $$delegatedProperties[37];
        return (Boolean) lazy.getValue();
    }

    private DefaultImagepipelineConfig() {
    }

    public final ImagePipelineFactory getImagePipelineFactory() {
        return getLazy_initializer();
    }

    public final Bitmap.Config getBitmapConfig() {
        return getLazy_bitmapConfig();
    }

    public final Supplier<MemoryCacheParams> getMemoryCacheParams() {
        return getLazy_MemoryCacheParams();
    }

    public final Supplier<MemoryCacheParams> getAnimMemoryCacheParams() {
        return getLazy_AnimMemoryCacheParams();
    }

    public final CountingMemoryCache.CacheTrimStrategy getCacheTrimStrategy() {
        return getLazy_CacheTrimStrategy();
    }

    public final CacheKeyFactory getCacheKeyFactory() {
        return getLazy_CacheKeyFactory();
    }

    public final Context getContext() {
        return getLazy_Context();
    }

    public final Boolean getDownsampleEnabled() {
        return getLazy_DownsampleEnabled();
    }

    public final FileCacheFactory getFileCacheFactory() {
        return getLazy_FileCacheFactory();
    }

    public final Supplier<MemoryCacheParams> getEncodedMemoryCacheParams() {
        return getLazy_EncodedMemoryCacheParams();
    }

    public final ExecutorSupplier getExecutorSupplier() {
        return getLazy_ExecutorSupplier();
    }

    public final ImageCacheStatsTracker getImageCacheStatsTracker() {
        return getLazy_ImageCacheStatsTracker();
    }

    public final ImageDecoder getImageDecoder() {
        return getLazy_ImageDecoder();
    }

    public final ImageTranscoderFactory getImageTranscoderFactory() {
        return getLazy_ImageTranscoderFactory();
    }

    public final Integer getImageTranscoderType() {
        return getLazy_ImageTranscoderType();
    }

    public final Supplier<Boolean> getIsPrefetchEnabledSupplier() {
        return getLazy_IsPrefetchEnabledSupplier();
    }

    public final DiskCacheConfig getDiskCacheConfig() {
        return getLazy_DiskCacheConfig();
    }

    public final MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
        return getLazy_MemoryTrimmableRegistry();
    }

    public final Integer getMemoryChunkType() {
        return getLazy_MemoryChunkType();
    }

    public final NetworkFetcher<? extends FetchState> getNetworkFetcher() {
        return getLazy_NetworkFetcher();
    }

    public final Integer getHttpNetworkTimeout() {
        return getLazy_HttpNetworkTimeout();
    }

    public final PlatformBitmapFactory getPlatformBitmapFactory() {
        return getLazy_PlatformBitmapFactory();
    }

    public final PoolFactory getPoolFactory() {
        return getLazy_PoolFactory();
    }

    public final ProgressiveJpegConfig getProgressiveJpegConfig() {
        return getLazy_ProgressiveJpegConfig();
    }

    public final Set<RequestListener> getRequestListeners() {
        return getLazy_RequestListeners();
    }

    public final Boolean getResizeAndRotateEnabledForNetwork() {
        return getLazy_ResizeAndRotateEnabledForNetwork();
    }

    public final DiskCacheConfig getSmallImageDiskCacheConfig() {
        return getLazy_SmallImageDiskCacheConfig();
    }

    public final ImageDecoderConfig getImageDecoderConfig() {
        return getLazy_ImageDecoderConfig();
    }

    public final ImagePipelineExperiments getImagePipelineExperiments() {
        return getLazy_ImagePipelineExperiments();
    }

    public final Boolean getIsSplitMemCache() {
        return getLazy_IsSplitMemCache();
    }

    public final Boolean getEnableSingleMemCache() {
        return getLazy_EnableSingleMemCache();
    }

    public final Supplier<MemoryCacheParams> getSingleBitmapMemoryCacheParams() {
        return getLazy_SingleBitmapMemoryCacheParamsSupplier();
    }

    public final Boolean getAnimatedHeifIndividualCacheEnabled() {
        return getLazy_AnimatedHeifIndividualCacheEnabled();
    }

    public final Boolean getShowHeifDebugLog() {
        return getLazy_ShowHeifDebugLog();
    }

    public final Boolean getAnimatedHeifIndividualCacheForImageRequestEnabled() {
        return getLazy_AnimatedHeifIndividualCacheForImageRequestEnabled();
    }

    public final Boolean getDiskCacheEnabled() {
        return getLazy_DiskCacheEnabled();
    }

    public final Boolean getWasImmediate() {
        return getLazy_WasImmediate();
    }

    public final Boolean getUseSingleImageRequest() {
        return getLazy_useSingleImageRequest();
    }

    public final Boolean getEnableBigImgCache() {
        return getLazy_EnableBigImgCache();
    }

    public final Supplier<MemoryCacheParams> getBigBitmapMemoryCacheParams() {
        return getLazy_BigImgBitmapMemoryCacheParamsSupplier();
    }

    public final Boolean getEnablePrefetchImgCache() {
        return getLazy_EnablePrefetchImgCache();
    }

    public final Supplier<MemoryCacheParams> getPrefetchImgBitmapMemoryCacheParams() {
        return getLazy_PrefetchImgBitmapMemoryCacheParamsSupplier();
    }

    public final Long getBigImgSizeLimit() {
        return getLazy_BigImgSizeLimit();
    }

    public final Boolean getRetainPreviousImage() {
        return getLazy_RetainPreviousImage();
    }

    public final Boolean getEnableNewLocalVideoThumbnailOpt() {
        return getLazy_EnableNewLocalVideoThumbnailOpt();
    }

    public final HashMap<String, DiskCacheConfig> getCustomImageDiskCacheConfigMap() {
        return getLazy_CustomImageDiskCacheConfigMap();
    }

    public final Boolean getUseOptHeifBitmap() {
        return getLazy_UseOptHeifBitmap();
    }
}
