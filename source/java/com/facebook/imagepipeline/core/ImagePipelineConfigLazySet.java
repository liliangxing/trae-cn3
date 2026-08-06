package com.facebook.imagepipeline.core;

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
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import com.facebook.imagepipeline.utils.LazySet;
import com.facebook.imagepipeline.utils.LazySetKt;
import com.fackbook.imagepipeline.DefaultImagepipelineConfig;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: ImagePipelineConfigLazySet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R;\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R/\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R;\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR/\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0003\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R/\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u0003\u001a\u0004\u0018\u00010#8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R;\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010\f\u001a\u0004\b+\u0010\b\"\u0004\b,\u0010\nR/\u0010/\u001a\u0004\u0018\u00010.2\b\u0010\u0003\u001a\u0004\u0018\u00010.8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R/\u00106\u001a\u0004\u0018\u0001052\b\u0010\u0003\u001a\u0004\u0018\u0001058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b;\u0010\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R/\u0010=\u001a\u0004\u0018\u00010<2\b\u0010\u0003\u001a\u0004\u0018\u00010<8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bB\u0010\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010ARG\u0010F\u001a\u0010\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020E\u0018\u00010C2\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020E\u0018\u00010C8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010\f\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR/\u0010L\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bO\u0010\f\u001a\u0004\bM\u0010\u0010\"\u0004\bN\u0010\u0012R/\u0010P\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bS\u0010\f\u001a\u0004\bQ\u0010\u0010\"\u0004\bR\u0010\u0012R/\u0010T\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bW\u0010\f\u001a\u0004\bU\u0010\u0010\"\u0004\bV\u0010\u0012R/\u0010X\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b[\u0010\f\u001a\u0004\bY\u0010\u0010\"\u0004\bZ\u0010\u0012R/\u0010\\\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b_\u0010\f\u001a\u0004\b]\u0010\u0010\"\u0004\b^\u0010\u0012R/\u0010`\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bc\u0010\f\u001a\u0004\ba\u0010\u0010\"\u0004\bb\u0010\u0012R;\u0010d\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bg\u0010\f\u001a\u0004\be\u0010\b\"\u0004\bf\u0010\nR/\u0010i\u001a\u0004\u0018\u00010h2\b\u0010\u0003\u001a\u0004\u0018\u00010h8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bn\u0010\f\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR/\u0010p\u001a\u0004\u0018\u00010o2\b\u0010\u0003\u001a\u0004\u0018\u00010o8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bu\u0010\f\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR/\u0010w\u001a\u0004\u0018\u00010v2\b\u0010\u0003\u001a\u0004\u0018\u00010v8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b|\u0010\f\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R3\u0010~\u001a\u0004\u0018\u00010}2\b\u0010\u0003\u001a\u0004\u0018\u00010}8F@FX\u0086\u008e\u0002¢\u0006\u0016\n\u0005\b\u0083\u0001\u0010\f\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R7\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u00012\t\u0010\u0003\u001a\u0005\u0018\u00010\u0084\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\b\u008a\u0001\u0010\f\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R7\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00012\t\u0010\u0003\u001a\u0005\u0018\u00010\u008b\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\b\u0091\u0001\u0010\f\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R7\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u00012\t\u0010\u0003\u001a\u0005\u0018\u00010\u0092\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\b\u0098\u0001\u0010\f\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R7\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u00012\t\u0010\u0003\u001a\u0005\u0018\u00010\u0099\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\b\u009f\u0001\u0010\f\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R3\u0010 \u0001\u001a\u0004\u0018\u00010v2\b\u0010\u0003\u001a\u0004\u0018\u00010v8F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b£\u0001\u0010\f\u001a\u0005\b¡\u0001\u0010y\"\u0005\b¢\u0001\u0010{R?\u0010¤\u0001\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00042\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b§\u0001\u0010\f\u001a\u0005\b¥\u0001\u0010\b\"\u0005\b¦\u0001\u0010\nR3\u0010¨\u0001\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b«\u0001\u0010\f\u001a\u0005\b©\u0001\u0010\u0010\"\u0005\bª\u0001\u0010\u0012R5\u0010¬\u0001\u001a\u0004\u0018\u00010E2\b\u0010\u0003\u001a\u0004\u0018\u00010E8F@FX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\b±\u0001\u0010\f\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R3\u0010²\u0001\u001a\u0004\u0018\u00010v2\b\u0010\u0003\u001a\u0004\u0018\u00010v8F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\bµ\u0001\u0010\f\u001a\u0005\b³\u0001\u0010y\"\u0005\b´\u0001\u0010{R7\u0010·\u0001\u001a\u0005\u0018\u00010¶\u00012\t\u0010\u0003\u001a\u0005\u0018\u00010¶\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\b¼\u0001\u0010\f\u001a\u0006\b¸\u0001\u0010¹\u0001\"\u0006\bº\u0001\u0010»\u0001RI\u0010¿\u0001\u001a\u000e\u0012\u0007\b\u0001\u0012\u00030¾\u0001\u0018\u00010½\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0007\b\u0001\u0012\u00030¾\u0001\u0018\u00010½\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\bÄ\u0001\u0010\f\u001a\u0006\bÀ\u0001\u0010Á\u0001\"\u0006\bÂ\u0001\u0010Ã\u0001R7\u0010Æ\u0001\u001a\u0005\u0018\u00010Å\u00012\t\u0010\u0003\u001a\u0005\u0018\u00010Å\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\bË\u0001\u0010\f\u001a\u0006\bÇ\u0001\u0010È\u0001\"\u0006\bÉ\u0001\u0010Ê\u0001R7\u0010Í\u0001\u001a\u0005\u0018\u00010Ì\u00012\t\u0010\u0003\u001a\u0005\u0018\u00010Ì\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\bÒ\u0001\u0010\f\u001a\u0006\bÎ\u0001\u0010Ï\u0001\"\u0006\bÐ\u0001\u0010Ñ\u0001R?\u0010Ó\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\bÖ\u0001\u0010\f\u001a\u0005\bÔ\u0001\u0010\b\"\u0005\bÕ\u0001\u0010\nR7\u0010Ø\u0001\u001a\u0005\u0018\u00010×\u00012\t\u0010\u0003\u001a\u0005\u0018\u00010×\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\bÝ\u0001\u0010\f\u001a\u0006\bÙ\u0001\u0010Ú\u0001\"\u0006\bÛ\u0001\u0010Ü\u0001RE\u0010à\u0001\u001a\f\u0012\u0005\u0012\u00030ß\u0001\u0018\u00010Þ\u00012\u0010\u0010\u0003\u001a\f\u0012\u0005\u0012\u00030ß\u0001\u0018\u00010Þ\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\bå\u0001\u0010\f\u001a\u0006\bá\u0001\u0010â\u0001\"\u0006\bã\u0001\u0010ä\u0001R3\u0010æ\u0001\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\bé\u0001\u0010\f\u001a\u0005\bç\u0001\u0010\u0010\"\u0005\bè\u0001\u0010\u0012R3\u0010ê\u0001\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\bí\u0001\u0010\f\u001a\u0005\bë\u0001\u0010\u0010\"\u0005\bì\u0001\u0010\u0012R3\u0010î\u0001\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\bñ\u0001\u0010\f\u001a\u0005\bï\u0001\u0010\u0010\"\u0005\bð\u0001\u0010\u0012R?\u0010ò\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\bõ\u0001\u0010\f\u001a\u0005\bó\u0001\u0010\b\"\u0005\bô\u0001\u0010\nR5\u0010ö\u0001\u001a\u0004\u0018\u00010E2\b\u0010\u0003\u001a\u0004\u0018\u00010E8F@FX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\bù\u0001\u0010\f\u001a\u0006\b÷\u0001\u0010®\u0001\"\u0006\bø\u0001\u0010°\u0001R3\u0010ú\u0001\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\bý\u0001\u0010\f\u001a\u0005\bû\u0001\u0010\u0010\"\u0005\bü\u0001\u0010\u0012R3\u0010þ\u0001\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0081\u0002\u0010\f\u001a\u0005\bÿ\u0001\u0010\u0010\"\u0005\b\u0080\u0002\u0010\u0012R3\u0010\u0082\u0002\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0085\u0002\u0010\f\u001a\u0005\b\u0083\u0002\u0010\u0010\"\u0005\b\u0084\u0002\u0010\u0012¨\u0006\u0086\u0002"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineConfigLazySet;", "", "()V", "<set-?>", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/imagepipeline/cache/MemoryCacheParams;", "mAnimBitmapMemoryCacheParamsSupplier", "getMAnimBitmapMemoryCacheParamsSupplier", "()Lcom/facebook/common/internal/Supplier;", "setMAnimBitmapMemoryCacheParamsSupplier", "(Lcom/facebook/common/internal/Supplier;)V", "mAnimBitmapMemoryCacheParamsSupplier$delegate", "Lcom/facebook/imagepipeline/utils/LazySet;", "", "mAnimatedHeifIndividualCacheEnabled", "getMAnimatedHeifIndividualCacheEnabled", "()Ljava/lang/Boolean;", "setMAnimatedHeifIndividualCacheEnabled", "(Ljava/lang/Boolean;)V", "mAnimatedHeifIndividualCacheEnabled$delegate", "mAnimatedHeifIndividualCacheForImageRequestEnabled", "getMAnimatedHeifIndividualCacheForImageRequestEnabled", "setMAnimatedHeifIndividualCacheForImageRequestEnabled", "mAnimatedHeifIndividualCacheForImageRequestEnabled$delegate", "mBigImgBitmapMemoryCacheParamsSupplier", "getMBigImgBitmapMemoryCacheParamsSupplier", "setMBigImgBitmapMemoryCacheParamsSupplier", "mBigImgBitmapMemoryCacheParamsSupplier$delegate", "", "mBigImgSizeLimit", "getMBigImgSizeLimit", "()Ljava/lang/Long;", "setMBigImgSizeLimit", "(Ljava/lang/Long;)V", "mBigImgSizeLimit$delegate", "Landroid/graphics/Bitmap$Config;", "mBitmapConfig", "getMBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "setMBitmapConfig", "(Landroid/graphics/Bitmap$Config;)V", "mBitmapConfig$delegate", "mBitmapMemoryCacheParamsSupplier", "getMBitmapMemoryCacheParamsSupplier", "setMBitmapMemoryCacheParamsSupplier", "mBitmapMemoryCacheParamsSupplier$delegate", "Lcom/facebook/imagepipeline/cache/CountingMemoryCache$CacheTrimStrategy;", "mBitmapMemoryCacheTrimStrategy", "getMBitmapMemoryCacheTrimStrategy", "()Lcom/facebook/imagepipeline/cache/CountingMemoryCache$CacheTrimStrategy;", "setMBitmapMemoryCacheTrimStrategy", "(Lcom/facebook/imagepipeline/cache/CountingMemoryCache$CacheTrimStrategy;)V", "mBitmapMemoryCacheTrimStrategy$delegate", "Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "mCacheKeyFactory", "getMCacheKeyFactory", "()Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "setMCacheKeyFactory", "(Lcom/facebook/imagepipeline/cache/CacheKeyFactory;)V", "mCacheKeyFactory$delegate", "Landroid/content/Context;", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mContext$delegate", "Ljava/util/HashMap;", "", "Lcom/facebook/cache/disk/DiskCacheConfig;", "mCustomImageDiskCacheConfigMap", "getMCustomImageDiskCacheConfigMap", "()Ljava/util/HashMap;", "setMCustomImageDiskCacheConfigMap", "(Ljava/util/HashMap;)V", "mCustomImageDiskCacheConfigMap$delegate", "mDiskCacheEnabled", "getMDiskCacheEnabled", "setMDiskCacheEnabled", "mDiskCacheEnabled$delegate", "mDownsampleEnabled", "getMDownsampleEnabled", "setMDownsampleEnabled", "mDownsampleEnabled$delegate", "mEnableBigImgCache", "getMEnableBigImgCache", "setMEnableBigImgCache", "mEnableBigImgCache$delegate", "mEnableNewLocalVideoThumbnailOpt", "getMEnableNewLocalVideoThumbnailOpt", "setMEnableNewLocalVideoThumbnailOpt", "mEnableNewLocalVideoThumbnailOpt$delegate", "mEnablePrefetchImgCache", "getMEnablePrefetchImgCache", "setMEnablePrefetchImgCache", "mEnablePrefetchImgCache$delegate", "mEnableSingleMemCache", "getMEnableSingleMemCache", "setMEnableSingleMemCache", "mEnableSingleMemCache$delegate", "mEncodedMemoryCacheParamsSupplier", "getMEncodedMemoryCacheParamsSupplier", "setMEncodedMemoryCacheParamsSupplier", "mEncodedMemoryCacheParamsSupplier$delegate", "Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "mExecutorSupplier", "getMExecutorSupplier", "()Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "setMExecutorSupplier", "(Lcom/facebook/imagepipeline/core/ExecutorSupplier;)V", "mExecutorSupplier$delegate", "Lcom/facebook/imagepipeline/core/FileCacheFactory;", "mFileCacheFactory", "getMFileCacheFactory", "()Lcom/facebook/imagepipeline/core/FileCacheFactory;", "setMFileCacheFactory", "(Lcom/facebook/imagepipeline/core/FileCacheFactory;)V", "mFileCacheFactory$delegate", "", "mHttpNetworkTimeout", "getMHttpNetworkTimeout", "()Ljava/lang/Integer;", "setMHttpNetworkTimeout", "(Ljava/lang/Integer;)V", "mHttpNetworkTimeout$delegate", "Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;", "mImageCacheStatsTracker", "getMImageCacheStatsTracker", "()Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;", "setMImageCacheStatsTracker", "(Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;)V", "mImageCacheStatsTracker$delegate", "Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "mImageDecoder", "getMImageDecoder", "()Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "setMImageDecoder", "(Lcom/facebook/imagepipeline/decoder/ImageDecoder;)V", "mImageDecoder$delegate", "Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig;", "mImageDecoderConfig", "getMImageDecoderConfig", "()Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig;", "setMImageDecoderConfig", "(Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig;)V", "mImageDecoderConfig$delegate", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments;", "mImagePipelineExperiments", "getMImagePipelineExperiments", "()Lcom/facebook/imagepipeline/core/ImagePipelineExperiments;", "setMImagePipelineExperiments", "(Lcom/facebook/imagepipeline/core/ImagePipelineExperiments;)V", "mImagePipelineExperiments$delegate", "Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "mImageTranscoderFactory", "getMImageTranscoderFactory", "()Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "setMImageTranscoderFactory", "(Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;)V", "mImageTranscoderFactory$delegate", "mImageTranscoderType", "getMImageTranscoderType", "setMImageTranscoderType", "mImageTranscoderType$delegate", "mIsPrefetchEnabledSupplier", "getMIsPrefetchEnabledSupplier", "setMIsPrefetchEnabledSupplier", "mIsPrefetchEnabledSupplier$delegate", "mIsSplitMemCache", "getMIsSplitMemCache", "setMIsSplitMemCache", "mIsSplitMemCache$delegate", "mMainDiskCacheConfig", "getMMainDiskCacheConfig", "()Lcom/facebook/cache/disk/DiskCacheConfig;", "setMMainDiskCacheConfig", "(Lcom/facebook/cache/disk/DiskCacheConfig;)V", "mMainDiskCacheConfig$delegate", "mMemoryChunkType", "getMMemoryChunkType", "setMMemoryChunkType", "mMemoryChunkType$delegate", "Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "mMemoryTrimmableRegistry", "getMMemoryTrimmableRegistry", "()Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "setMMemoryTrimmableRegistry", "(Lcom/facebook/common/memory/MemoryTrimmableRegistry;)V", "mMemoryTrimmableRegistry$delegate", "Lcom/facebook/imagepipeline/producers/NetworkFetcher;", "Lcom/facebook/imagepipeline/producers/FetchState;", "mNetworkFetcher", "getMNetworkFetcher", "()Lcom/facebook/imagepipeline/producers/NetworkFetcher;", "setMNetworkFetcher", "(Lcom/facebook/imagepipeline/producers/NetworkFetcher;)V", "mNetworkFetcher$delegate", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "mPlatformBitmapFactory", "getMPlatformBitmapFactory", "()Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "setMPlatformBitmapFactory", "(Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;)V", "mPlatformBitmapFactory$delegate", "Lcom/facebook/imagepipeline/memory/PoolFactory;", "mPoolFactory", "getMPoolFactory", "()Lcom/facebook/imagepipeline/memory/PoolFactory;", "setMPoolFactory", "(Lcom/facebook/imagepipeline/memory/PoolFactory;)V", "mPoolFactory$delegate", "mPrefetchImgBitmapMemoryCacheParamsSupplier", "getMPrefetchImgBitmapMemoryCacheParamsSupplier", "setMPrefetchImgBitmapMemoryCacheParamsSupplier", "mPrefetchImgBitmapMemoryCacheParamsSupplier$delegate", "Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "mProgressiveJpegConfig", "getMProgressiveJpegConfig", "()Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "setMProgressiveJpegConfig", "(Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;)V", "mProgressiveJpegConfig$delegate", "", "Lcom/facebook/imagepipeline/listener/RequestListener;", "mRequestListeners", "getMRequestListeners", "()Ljava/util/Set;", "setMRequestListeners", "(Ljava/util/Set;)V", "mRequestListeners$delegate", "mResizeAndRotateEnabledForNetwork", "getMResizeAndRotateEnabledForNetwork", "setMResizeAndRotateEnabledForNetwork", "mResizeAndRotateEnabledForNetwork$delegate", "mRetainPreviousImage", "getMRetainPreviousImage", "setMRetainPreviousImage", "mRetainPreviousImage$delegate", "mShowHeifDebugLog", "getMShowHeifDebugLog", "setMShowHeifDebugLog", "mShowHeifDebugLog$delegate", "mSingleBitmapMemoryCacheParamsSupplier", "getMSingleBitmapMemoryCacheParamsSupplier", "setMSingleBitmapMemoryCacheParamsSupplier", "mSingleBitmapMemoryCacheParamsSupplier$delegate", "mSmallImageDiskCacheConfig", "getMSmallImageDiskCacheConfig", "setMSmallImageDiskCacheConfig", "mSmallImageDiskCacheConfig$delegate", "mUseOptHeifBitmap", "getMUseOptHeifBitmap", "setMUseOptHeifBitmap", "mUseOptHeifBitmap$delegate", "mWasImmediate", "getMWasImmediate", "setMWasImmediate", "mWasImmediate$delegate", "useSingleImageRequest", "getUseSingleImageRequest", "setUseSingleImageRequest", "useSingleImageRequest$delegate", "imagepipeline_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class ImagePipelineConfigLazySet {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mBitmapConfig", "getMBitmapConfig()Landroid/graphics/Bitmap$Config;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mBitmapMemoryCacheParamsSupplier", "getMBitmapMemoryCacheParamsSupplier()Lcom/facebook/common/internal/Supplier;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mAnimBitmapMemoryCacheParamsSupplier", "getMAnimBitmapMemoryCacheParamsSupplier()Lcom/facebook/common/internal/Supplier;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mBitmapMemoryCacheTrimStrategy", "getMBitmapMemoryCacheTrimStrategy()Lcom/facebook/imagepipeline/cache/CountingMemoryCache$CacheTrimStrategy;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mCacheKeyFactory", "getMCacheKeyFactory()Lcom/facebook/imagepipeline/cache/CacheKeyFactory;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mContext", "getMContext()Landroid/content/Context;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mDownsampleEnabled", "getMDownsampleEnabled()Ljava/lang/Boolean;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mFileCacheFactory", "getMFileCacheFactory()Lcom/facebook/imagepipeline/core/FileCacheFactory;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mEncodedMemoryCacheParamsSupplier", "getMEncodedMemoryCacheParamsSupplier()Lcom/facebook/common/internal/Supplier;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mExecutorSupplier", "getMExecutorSupplier()Lcom/facebook/imagepipeline/core/ExecutorSupplier;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mImageCacheStatsTracker", "getMImageCacheStatsTracker()Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mImageDecoder", "getMImageDecoder()Lcom/facebook/imagepipeline/decoder/ImageDecoder;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mImageTranscoderFactory", "getMImageTranscoderFactory()Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mImageTranscoderType", "getMImageTranscoderType()Ljava/lang/Integer;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mIsPrefetchEnabledSupplier", "getMIsPrefetchEnabledSupplier()Lcom/facebook/common/internal/Supplier;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mMainDiskCacheConfig", "getMMainDiskCacheConfig()Lcom/facebook/cache/disk/DiskCacheConfig;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mMemoryTrimmableRegistry", "getMMemoryTrimmableRegistry()Lcom/facebook/common/memory/MemoryTrimmableRegistry;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mMemoryChunkType", "getMMemoryChunkType()Ljava/lang/Integer;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mNetworkFetcher", "getMNetworkFetcher()Lcom/facebook/imagepipeline/producers/NetworkFetcher;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mHttpNetworkTimeout", "getMHttpNetworkTimeout()Ljava/lang/Integer;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mPlatformBitmapFactory", "getMPlatformBitmapFactory()Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mPoolFactory", "getMPoolFactory()Lcom/facebook/imagepipeline/memory/PoolFactory;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mProgressiveJpegConfig", "getMProgressiveJpegConfig()Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mRequestListeners", "getMRequestListeners()Ljava/util/Set;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mResizeAndRotateEnabledForNetwork", "getMResizeAndRotateEnabledForNetwork()Ljava/lang/Boolean;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mSmallImageDiskCacheConfig", "getMSmallImageDiskCacheConfig()Lcom/facebook/cache/disk/DiskCacheConfig;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mImageDecoderConfig", "getMImageDecoderConfig()Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mImagePipelineExperiments", "getMImagePipelineExperiments()Lcom/facebook/imagepipeline/core/ImagePipelineExperiments;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mIsSplitMemCache", "getMIsSplitMemCache()Ljava/lang/Boolean;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mEnableSingleMemCache", "getMEnableSingleMemCache()Ljava/lang/Boolean;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mSingleBitmapMemoryCacheParamsSupplier", "getMSingleBitmapMemoryCacheParamsSupplier()Lcom/facebook/common/internal/Supplier;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mAnimatedHeifIndividualCacheEnabled", "getMAnimatedHeifIndividualCacheEnabled()Ljava/lang/Boolean;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mShowHeifDebugLog", "getMShowHeifDebugLog()Ljava/lang/Boolean;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mAnimatedHeifIndividualCacheForImageRequestEnabled", "getMAnimatedHeifIndividualCacheForImageRequestEnabled()Ljava/lang/Boolean;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mDiskCacheEnabled", "getMDiskCacheEnabled()Ljava/lang/Boolean;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mCustomImageDiskCacheConfigMap", "getMCustomImageDiskCacheConfigMap()Ljava/util/HashMap;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mWasImmediate", "getMWasImmediate()Ljava/lang/Boolean;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "useSingleImageRequest", "getUseSingleImageRequest()Ljava/lang/Boolean;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mEnableBigImgCache", "getMEnableBigImgCache()Ljava/lang/Boolean;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mBigImgBitmapMemoryCacheParamsSupplier", "getMBigImgBitmapMemoryCacheParamsSupplier()Lcom/facebook/common/internal/Supplier;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mEnablePrefetchImgCache", "getMEnablePrefetchImgCache()Ljava/lang/Boolean;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mPrefetchImgBitmapMemoryCacheParamsSupplier", "getMPrefetchImgBitmapMemoryCacheParamsSupplier()Lcom/facebook/common/internal/Supplier;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mBigImgSizeLimit", "getMBigImgSizeLimit()Ljava/lang/Long;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mRetainPreviousImage", "getMRetainPreviousImage()Ljava/lang/Boolean;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mEnableNewLocalVideoThumbnailOpt", "getMEnableNewLocalVideoThumbnailOpt()Ljava/lang/Boolean;")), (KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ImagePipelineConfigLazySet.class), "mUseOptHeifBitmap", "getMUseOptHeifBitmap()Ljava/lang/Boolean;"))};

    /* renamed from: mBitmapConfig$delegate, reason: from kotlin metadata */
    private final LazySet mBitmapConfig = LazySetKt.lazySet(new Function0<Bitmap.Config>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mBitmapConfig$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Bitmap.Config m2647invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getBitmapConfig();
        }
    });

    /* renamed from: mBitmapMemoryCacheParamsSupplier$delegate, reason: from kotlin metadata */
    private final LazySet mBitmapMemoryCacheParamsSupplier = LazySetKt.lazySet(new Function0<Supplier<MemoryCacheParams>>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mBitmapMemoryCacheParamsSupplier$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Supplier<MemoryCacheParams> m2648invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getMemoryCacheParams();
        }
    });

    /* renamed from: mAnimBitmapMemoryCacheParamsSupplier$delegate, reason: from kotlin metadata */
    private final LazySet mAnimBitmapMemoryCacheParamsSupplier = LazySetKt.lazySet(new Function0<Supplier<MemoryCacheParams>>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mAnimBitmapMemoryCacheParamsSupplier$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Supplier<MemoryCacheParams> m2642invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getAnimMemoryCacheParams();
        }
    });

    /* renamed from: mBitmapMemoryCacheTrimStrategy$delegate, reason: from kotlin metadata */
    private final LazySet mBitmapMemoryCacheTrimStrategy = LazySetKt.lazySet(new Function0<CountingMemoryCache.CacheTrimStrategy>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mBitmapMemoryCacheTrimStrategy$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final CountingMemoryCache.CacheTrimStrategy m2649invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getCacheTrimStrategy();
        }
    });

    /* renamed from: mCacheKeyFactory$delegate, reason: from kotlin metadata */
    private final LazySet mCacheKeyFactory = LazySetKt.lazySet(new Function0<CacheKeyFactory>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mCacheKeyFactory$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final CacheKeyFactory m2650invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getCacheKeyFactory();
        }
    });

    /* renamed from: mContext$delegate, reason: from kotlin metadata */
    private final LazySet mContext = LazySetKt.lazySet(new Function0<Context>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mContext$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Context m2651invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getContext();
        }
    });

    /* renamed from: mDownsampleEnabled$delegate, reason: from kotlin metadata */
    private final LazySet mDownsampleEnabled = LazySetKt.lazySet(new Function0<Boolean>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mDownsampleEnabled$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2654invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getDownsampleEnabled();
        }
    });

    /* renamed from: mFileCacheFactory$delegate, reason: from kotlin metadata */
    private final LazySet mFileCacheFactory = LazySetKt.lazySet(new Function0<FileCacheFactory>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mFileCacheFactory$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final FileCacheFactory m2661invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getFileCacheFactory();
        }
    });

    /* renamed from: mEncodedMemoryCacheParamsSupplier$delegate, reason: from kotlin metadata */
    private final LazySet mEncodedMemoryCacheParamsSupplier = LazySetKt.lazySet(new Function0<Supplier<MemoryCacheParams>>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mEncodedMemoryCacheParamsSupplier$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Supplier<MemoryCacheParams> m2659invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getEncodedMemoryCacheParams();
        }
    });

    /* renamed from: mExecutorSupplier$delegate, reason: from kotlin metadata */
    private final LazySet mExecutorSupplier = LazySetKt.lazySet(new Function0<ExecutorSupplier>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mExecutorSupplier$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ExecutorSupplier m2660invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getExecutorSupplier();
        }
    });

    /* renamed from: mImageCacheStatsTracker$delegate, reason: from kotlin metadata */
    private final LazySet mImageCacheStatsTracker = LazySetKt.lazySet(new Function0<ImageCacheStatsTracker>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mImageCacheStatsTracker$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ImageCacheStatsTracker m2663invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getImageCacheStatsTracker();
        }
    });

    /* renamed from: mImageDecoder$delegate, reason: from kotlin metadata */
    private final LazySet mImageDecoder = LazySetKt.lazySet(new Function0<ImageDecoder>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mImageDecoder$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ImageDecoder m2664invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getImageDecoder();
        }
    });

    /* renamed from: mImageTranscoderFactory$delegate, reason: from kotlin metadata */
    private final LazySet mImageTranscoderFactory = LazySetKt.lazySet(new Function0<ImageTranscoderFactory>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mImageTranscoderFactory$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ImageTranscoderFactory m2667invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getImageTranscoderFactory();
        }
    });

    /* renamed from: mImageTranscoderType$delegate, reason: from kotlin metadata */
    private final LazySet mImageTranscoderType = LazySetKt.lazySet(new Function0<Integer>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mImageTranscoderType$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2668invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getImageTranscoderType();
        }
    });

    /* renamed from: mIsPrefetchEnabledSupplier$delegate, reason: from kotlin metadata */
    private final LazySet mIsPrefetchEnabledSupplier = LazySetKt.lazySet(new Function0<Supplier<Boolean>>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mIsPrefetchEnabledSupplier$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Supplier<Boolean> m2669invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getIsPrefetchEnabledSupplier();
        }
    });

    /* renamed from: mMainDiskCacheConfig$delegate, reason: from kotlin metadata */
    private final LazySet mMainDiskCacheConfig = LazySetKt.lazySet(new Function0<DiskCacheConfig>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mMainDiskCacheConfig$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final DiskCacheConfig m2671invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getDiskCacheConfig();
        }
    });

    /* renamed from: mMemoryTrimmableRegistry$delegate, reason: from kotlin metadata */
    private final LazySet mMemoryTrimmableRegistry = LazySetKt.lazySet(new Function0<MemoryTrimmableRegistry>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mMemoryTrimmableRegistry$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MemoryTrimmableRegistry m2673invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getMemoryTrimmableRegistry();
        }
    });

    /* renamed from: mMemoryChunkType$delegate, reason: from kotlin metadata */
    private final LazySet mMemoryChunkType = LazySetKt.lazySet(new Function0<Integer>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mMemoryChunkType$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2672invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getMemoryChunkType();
        }
    });

    /* renamed from: mNetworkFetcher$delegate, reason: from kotlin metadata */
    private final LazySet mNetworkFetcher = LazySetKt.lazySet(new Function0<NetworkFetcher<? extends FetchState>>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mNetworkFetcher$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final NetworkFetcher<? extends FetchState> m2674invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getNetworkFetcher();
        }
    });

    /* renamed from: mHttpNetworkTimeout$delegate, reason: from kotlin metadata */
    private final LazySet mHttpNetworkTimeout = LazySetKt.lazySet(new Function0<Integer>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mHttpNetworkTimeout$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2662invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getHttpNetworkTimeout();
        }
    });

    /* renamed from: mPlatformBitmapFactory$delegate, reason: from kotlin metadata */
    private final LazySet mPlatformBitmapFactory = LazySetKt.lazySet(new Function0<PlatformBitmapFactory>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mPlatformBitmapFactory$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final PlatformBitmapFactory m2675invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getPlatformBitmapFactory();
        }
    });

    /* renamed from: mPoolFactory$delegate, reason: from kotlin metadata */
    private final LazySet mPoolFactory = LazySetKt.lazySet(new Function0<PoolFactory>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mPoolFactory$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final PoolFactory m2676invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getPoolFactory();
        }
    });

    /* renamed from: mProgressiveJpegConfig$delegate, reason: from kotlin metadata */
    private final LazySet mProgressiveJpegConfig = LazySetKt.lazySet(new Function0<ProgressiveJpegConfig>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mProgressiveJpegConfig$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ProgressiveJpegConfig m2678invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getProgressiveJpegConfig();
        }
    });

    /* renamed from: mRequestListeners$delegate, reason: from kotlin metadata */
    private final LazySet mRequestListeners = LazySetKt.lazySet(new Function0<Set<? extends RequestListener>>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mRequestListeners$2
        public final Set<RequestListener> invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getRequestListeners();
        }
    });

    /* renamed from: mResizeAndRotateEnabledForNetwork$delegate, reason: from kotlin metadata */
    private final LazySet mResizeAndRotateEnabledForNetwork = LazySetKt.lazySet(new Function0<Boolean>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mResizeAndRotateEnabledForNetwork$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2680invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getResizeAndRotateEnabledForNetwork();
        }
    });

    /* renamed from: mSmallImageDiskCacheConfig$delegate, reason: from kotlin metadata */
    private final LazySet mSmallImageDiskCacheConfig = LazySetKt.lazySet(new Function0<DiskCacheConfig>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mSmallImageDiskCacheConfig$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final DiskCacheConfig m2684invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getSmallImageDiskCacheConfig();
        }
    });

    /* renamed from: mImageDecoderConfig$delegate, reason: from kotlin metadata */
    private final LazySet mImageDecoderConfig = LazySetKt.lazySet(new Function0<ImageDecoderConfig>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mImageDecoderConfig$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ImageDecoderConfig m2665invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getImageDecoderConfig();
        }
    });

    /* renamed from: mImagePipelineExperiments$delegate, reason: from kotlin metadata */
    private final LazySet mImagePipelineExperiments = LazySetKt.lazySet(new Function0<ImagePipelineExperiments>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mImagePipelineExperiments$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ImagePipelineExperiments m2666invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getImagePipelineExperiments();
        }
    });

    /* renamed from: mIsSplitMemCache$delegate, reason: from kotlin metadata */
    private final LazySet mIsSplitMemCache = LazySetKt.lazySet(new Function0<Boolean>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mIsSplitMemCache$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2670invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getIsSplitMemCache();
        }
    });

    /* renamed from: mEnableSingleMemCache$delegate, reason: from kotlin metadata */
    private final LazySet mEnableSingleMemCache = LazySetKt.lazySet(new Function0<Boolean>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mEnableSingleMemCache$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2658invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getEnableSingleMemCache();
        }
    });

    /* renamed from: mSingleBitmapMemoryCacheParamsSupplier$delegate, reason: from kotlin metadata */
    private final LazySet mSingleBitmapMemoryCacheParamsSupplier = LazySetKt.lazySet(new Function0<Supplier<MemoryCacheParams>>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mSingleBitmapMemoryCacheParamsSupplier$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Supplier<MemoryCacheParams> m2683invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getSingleBitmapMemoryCacheParams();
        }
    });

    /* renamed from: mAnimatedHeifIndividualCacheEnabled$delegate, reason: from kotlin metadata */
    private final LazySet mAnimatedHeifIndividualCacheEnabled = LazySetKt.lazySet(new Function0<Boolean>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mAnimatedHeifIndividualCacheEnabled$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2643invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getAnimatedHeifIndividualCacheEnabled();
        }
    });

    /* renamed from: mShowHeifDebugLog$delegate, reason: from kotlin metadata */
    private final LazySet mShowHeifDebugLog = LazySetKt.lazySet(new Function0<Boolean>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mShowHeifDebugLog$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2682invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getShowHeifDebugLog();
        }
    });

    /* renamed from: mAnimatedHeifIndividualCacheForImageRequestEnabled$delegate, reason: from kotlin metadata */
    private final LazySet mAnimatedHeifIndividualCacheForImageRequestEnabled = LazySetKt.lazySet(new Function0<Boolean>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mAnimatedHeifIndividualCacheForImageRequestEnabled$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2644invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getAnimatedHeifIndividualCacheForImageRequestEnabled();
        }
    });

    /* renamed from: mDiskCacheEnabled$delegate, reason: from kotlin metadata */
    private final LazySet mDiskCacheEnabled = LazySetKt.lazySet(new Function0<Boolean>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mDiskCacheEnabled$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2653invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getDiskCacheEnabled();
        }
    });

    /* renamed from: mCustomImageDiskCacheConfigMap$delegate, reason: from kotlin metadata */
    private final LazySet mCustomImageDiskCacheConfigMap = LazySetKt.lazySet(new Function0<HashMap<String, DiskCacheConfig>>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mCustomImageDiskCacheConfigMap$2
        public final HashMap<String, DiskCacheConfig> invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getCustomImageDiskCacheConfigMap();
        }
    });

    /* renamed from: mWasImmediate$delegate, reason: from kotlin metadata */
    private final LazySet mWasImmediate = LazySetKt.lazySet(new Function0<Boolean>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mWasImmediate$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2686invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getWasImmediate();
        }
    });

    /* renamed from: useSingleImageRequest$delegate, reason: from kotlin metadata */
    private final LazySet useSingleImageRequest = LazySetKt.lazySet(new Function0<Boolean>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$useSingleImageRequest$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2687invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getUseSingleImageRequest();
        }
    });

    /* renamed from: mEnableBigImgCache$delegate, reason: from kotlin metadata */
    private final LazySet mEnableBigImgCache = LazySetKt.lazySet(new Function0<Boolean>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mEnableBigImgCache$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2655invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getEnableBigImgCache();
        }
    });

    /* renamed from: mBigImgBitmapMemoryCacheParamsSupplier$delegate, reason: from kotlin metadata */
    private final LazySet mBigImgBitmapMemoryCacheParamsSupplier = LazySetKt.lazySet(new Function0<Supplier<MemoryCacheParams>>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mBigImgBitmapMemoryCacheParamsSupplier$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Supplier<MemoryCacheParams> m2645invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getBigBitmapMemoryCacheParams();
        }
    });

    /* renamed from: mEnablePrefetchImgCache$delegate, reason: from kotlin metadata */
    private final LazySet mEnablePrefetchImgCache = LazySetKt.lazySet(new Function0<Boolean>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mEnablePrefetchImgCache$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2657invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getEnablePrefetchImgCache();
        }
    });

    /* renamed from: mPrefetchImgBitmapMemoryCacheParamsSupplier$delegate, reason: from kotlin metadata */
    private final LazySet mPrefetchImgBitmapMemoryCacheParamsSupplier = LazySetKt.lazySet(new Function0<Supplier<MemoryCacheParams>>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mPrefetchImgBitmapMemoryCacheParamsSupplier$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Supplier<MemoryCacheParams> m2677invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getPrefetchImgBitmapMemoryCacheParams();
        }
    });

    /* renamed from: mBigImgSizeLimit$delegate, reason: from kotlin metadata */
    private final LazySet mBigImgSizeLimit = LazySetKt.lazySet(new Function0<Long>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mBigImgSizeLimit$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Long m2646invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getBigImgSizeLimit();
        }
    });

    /* renamed from: mRetainPreviousImage$delegate, reason: from kotlin metadata */
    private final LazySet mRetainPreviousImage = LazySetKt.lazySet(new Function0<Boolean>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mRetainPreviousImage$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2681invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getRetainPreviousImage();
        }
    });

    /* renamed from: mEnableNewLocalVideoThumbnailOpt$delegate, reason: from kotlin metadata */
    private final LazySet mEnableNewLocalVideoThumbnailOpt = LazySetKt.lazySet(new Function0<Boolean>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mEnableNewLocalVideoThumbnailOpt$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2656invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getEnableNewLocalVideoThumbnailOpt();
        }
    });

    /* renamed from: mUseOptHeifBitmap$delegate, reason: from kotlin metadata */
    private final LazySet mUseOptHeifBitmap = LazySetKt.lazySet(new Function0<Boolean>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfigLazySet$mUseOptHeifBitmap$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m2685invoke() {
            return DefaultImagepipelineConfig.INSTANCE.getUseOptHeifBitmap();
        }
    });

    public final Bitmap.Config getMBitmapConfig() {
        LazySet lazySet = this.mBitmapConfig;
        KProperty kProperty = $$delegatedProperties[0];
        return (Bitmap.Config) lazySet.getValue();
    }

    public final void setMBitmapConfig(Bitmap.Config config) {
        LazySet lazySet = this.mBitmapConfig;
        KProperty kProperty = $$delegatedProperties[0];
        lazySet.setValue(config);
    }

    public final Supplier<MemoryCacheParams> getMBitmapMemoryCacheParamsSupplier() {
        LazySet lazySet = this.mBitmapMemoryCacheParamsSupplier;
        KProperty kProperty = $$delegatedProperties[1];
        return (Supplier) lazySet.getValue();
    }

    public final void setMBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> supplier) {
        LazySet lazySet = this.mBitmapMemoryCacheParamsSupplier;
        KProperty kProperty = $$delegatedProperties[1];
        lazySet.setValue(supplier);
    }

    public final Supplier<MemoryCacheParams> getMAnimBitmapMemoryCacheParamsSupplier() {
        LazySet lazySet = this.mAnimBitmapMemoryCacheParamsSupplier;
        KProperty kProperty = $$delegatedProperties[2];
        return (Supplier) lazySet.getValue();
    }

    public final void setMAnimBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> supplier) {
        LazySet lazySet = this.mAnimBitmapMemoryCacheParamsSupplier;
        KProperty kProperty = $$delegatedProperties[2];
        lazySet.setValue(supplier);
    }

    public final CountingMemoryCache.CacheTrimStrategy getMBitmapMemoryCacheTrimStrategy() {
        LazySet lazySet = this.mBitmapMemoryCacheTrimStrategy;
        KProperty kProperty = $$delegatedProperties[3];
        return (CountingMemoryCache.CacheTrimStrategy) lazySet.getValue();
    }

    public final void setMBitmapMemoryCacheTrimStrategy(CountingMemoryCache.CacheTrimStrategy cacheTrimStrategy) {
        LazySet lazySet = this.mBitmapMemoryCacheTrimStrategy;
        KProperty kProperty = $$delegatedProperties[3];
        lazySet.setValue(cacheTrimStrategy);
    }

    public final CacheKeyFactory getMCacheKeyFactory() {
        LazySet lazySet = this.mCacheKeyFactory;
        KProperty kProperty = $$delegatedProperties[4];
        return (CacheKeyFactory) lazySet.getValue();
    }

    public final void setMCacheKeyFactory(CacheKeyFactory cacheKeyFactory) {
        LazySet lazySet = this.mCacheKeyFactory;
        KProperty kProperty = $$delegatedProperties[4];
        lazySet.setValue(cacheKeyFactory);
    }

    public final Context getMContext() {
        LazySet lazySet = this.mContext;
        KProperty kProperty = $$delegatedProperties[5];
        return (Context) lazySet.getValue();
    }

    public final void setMContext(Context context) {
        LazySet lazySet = this.mContext;
        KProperty kProperty = $$delegatedProperties[5];
        lazySet.setValue(context);
    }

    public final Boolean getMDownsampleEnabled() {
        LazySet lazySet = this.mDownsampleEnabled;
        KProperty kProperty = $$delegatedProperties[6];
        return (Boolean) lazySet.getValue();
    }

    public final void setMDownsampleEnabled(Boolean bool) {
        LazySet lazySet = this.mDownsampleEnabled;
        KProperty kProperty = $$delegatedProperties[6];
        lazySet.setValue(bool);
    }

    public final FileCacheFactory getMFileCacheFactory() {
        LazySet lazySet = this.mFileCacheFactory;
        KProperty kProperty = $$delegatedProperties[7];
        return (FileCacheFactory) lazySet.getValue();
    }

    public final void setMFileCacheFactory(FileCacheFactory fileCacheFactory) {
        LazySet lazySet = this.mFileCacheFactory;
        KProperty kProperty = $$delegatedProperties[7];
        lazySet.setValue(fileCacheFactory);
    }

    public final Supplier<MemoryCacheParams> getMEncodedMemoryCacheParamsSupplier() {
        LazySet lazySet = this.mEncodedMemoryCacheParamsSupplier;
        KProperty kProperty = $$delegatedProperties[8];
        return (Supplier) lazySet.getValue();
    }

    public final void setMEncodedMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> supplier) {
        LazySet lazySet = this.mEncodedMemoryCacheParamsSupplier;
        KProperty kProperty = $$delegatedProperties[8];
        lazySet.setValue(supplier);
    }

    public final ExecutorSupplier getMExecutorSupplier() {
        LazySet lazySet = this.mExecutorSupplier;
        KProperty kProperty = $$delegatedProperties[9];
        return (ExecutorSupplier) lazySet.getValue();
    }

    public final void setMExecutorSupplier(ExecutorSupplier executorSupplier) {
        LazySet lazySet = this.mExecutorSupplier;
        KProperty kProperty = $$delegatedProperties[9];
        lazySet.setValue(executorSupplier);
    }

    public final ImageCacheStatsTracker getMImageCacheStatsTracker() {
        LazySet lazySet = this.mImageCacheStatsTracker;
        KProperty kProperty = $$delegatedProperties[10];
        return (ImageCacheStatsTracker) lazySet.getValue();
    }

    public final void setMImageCacheStatsTracker(ImageCacheStatsTracker imageCacheStatsTracker) {
        LazySet lazySet = this.mImageCacheStatsTracker;
        KProperty kProperty = $$delegatedProperties[10];
        lazySet.setValue(imageCacheStatsTracker);
    }

    public final ImageDecoder getMImageDecoder() {
        LazySet lazySet = this.mImageDecoder;
        KProperty kProperty = $$delegatedProperties[11];
        return (ImageDecoder) lazySet.getValue();
    }

    public final void setMImageDecoder(ImageDecoder imageDecoder) {
        LazySet lazySet = this.mImageDecoder;
        KProperty kProperty = $$delegatedProperties[11];
        lazySet.setValue(imageDecoder);
    }

    public final ImageTranscoderFactory getMImageTranscoderFactory() {
        LazySet lazySet = this.mImageTranscoderFactory;
        KProperty kProperty = $$delegatedProperties[12];
        return (ImageTranscoderFactory) lazySet.getValue();
    }

    public final void setMImageTranscoderFactory(ImageTranscoderFactory imageTranscoderFactory) {
        LazySet lazySet = this.mImageTranscoderFactory;
        KProperty kProperty = $$delegatedProperties[12];
        lazySet.setValue(imageTranscoderFactory);
    }

    public final Integer getMImageTranscoderType() {
        LazySet lazySet = this.mImageTranscoderType;
        KProperty kProperty = $$delegatedProperties[13];
        return (Integer) lazySet.getValue();
    }

    public final void setMImageTranscoderType(Integer num) {
        LazySet lazySet = this.mImageTranscoderType;
        KProperty kProperty = $$delegatedProperties[13];
        lazySet.setValue(num);
    }

    public final Supplier<Boolean> getMIsPrefetchEnabledSupplier() {
        LazySet lazySet = this.mIsPrefetchEnabledSupplier;
        KProperty kProperty = $$delegatedProperties[14];
        return (Supplier) lazySet.getValue();
    }

    public final void setMIsPrefetchEnabledSupplier(Supplier<Boolean> supplier) {
        LazySet lazySet = this.mIsPrefetchEnabledSupplier;
        KProperty kProperty = $$delegatedProperties[14];
        lazySet.setValue(supplier);
    }

    public final DiskCacheConfig getMMainDiskCacheConfig() {
        LazySet lazySet = this.mMainDiskCacheConfig;
        KProperty kProperty = $$delegatedProperties[15];
        return (DiskCacheConfig) lazySet.getValue();
    }

    public final void setMMainDiskCacheConfig(DiskCacheConfig diskCacheConfig) {
        LazySet lazySet = this.mMainDiskCacheConfig;
        KProperty kProperty = $$delegatedProperties[15];
        lazySet.setValue(diskCacheConfig);
    }

    public final MemoryTrimmableRegistry getMMemoryTrimmableRegistry() {
        LazySet lazySet = this.mMemoryTrimmableRegistry;
        KProperty kProperty = $$delegatedProperties[16];
        return (MemoryTrimmableRegistry) lazySet.getValue();
    }

    public final void setMMemoryTrimmableRegistry(MemoryTrimmableRegistry memoryTrimmableRegistry) {
        LazySet lazySet = this.mMemoryTrimmableRegistry;
        KProperty kProperty = $$delegatedProperties[16];
        lazySet.setValue(memoryTrimmableRegistry);
    }

    public final Integer getMMemoryChunkType() {
        LazySet lazySet = this.mMemoryChunkType;
        KProperty kProperty = $$delegatedProperties[17];
        return (Integer) lazySet.getValue();
    }

    public final void setMMemoryChunkType(Integer num) {
        LazySet lazySet = this.mMemoryChunkType;
        KProperty kProperty = $$delegatedProperties[17];
        lazySet.setValue(num);
    }

    public final NetworkFetcher<? extends FetchState> getMNetworkFetcher() {
        LazySet lazySet = this.mNetworkFetcher;
        KProperty kProperty = $$delegatedProperties[18];
        return (NetworkFetcher) lazySet.getValue();
    }

    public final void setMNetworkFetcher(NetworkFetcher<? extends FetchState> networkFetcher) {
        LazySet lazySet = this.mNetworkFetcher;
        KProperty kProperty = $$delegatedProperties[18];
        lazySet.setValue(networkFetcher);
    }

    public final Integer getMHttpNetworkTimeout() {
        LazySet lazySet = this.mHttpNetworkTimeout;
        KProperty kProperty = $$delegatedProperties[19];
        return (Integer) lazySet.getValue();
    }

    public final void setMHttpNetworkTimeout(Integer num) {
        LazySet lazySet = this.mHttpNetworkTimeout;
        KProperty kProperty = $$delegatedProperties[19];
        lazySet.setValue(num);
    }

    public final PlatformBitmapFactory getMPlatformBitmapFactory() {
        LazySet lazySet = this.mPlatformBitmapFactory;
        KProperty kProperty = $$delegatedProperties[20];
        return (PlatformBitmapFactory) lazySet.getValue();
    }

    public final void setMPlatformBitmapFactory(PlatformBitmapFactory platformBitmapFactory) {
        LazySet lazySet = this.mPlatformBitmapFactory;
        KProperty kProperty = $$delegatedProperties[20];
        lazySet.setValue(platformBitmapFactory);
    }

    public final PoolFactory getMPoolFactory() {
        LazySet lazySet = this.mPoolFactory;
        KProperty kProperty = $$delegatedProperties[21];
        return (PoolFactory) lazySet.getValue();
    }

    public final void setMPoolFactory(PoolFactory poolFactory) {
        LazySet lazySet = this.mPoolFactory;
        KProperty kProperty = $$delegatedProperties[21];
        lazySet.setValue(poolFactory);
    }

    public final ProgressiveJpegConfig getMProgressiveJpegConfig() {
        LazySet lazySet = this.mProgressiveJpegConfig;
        KProperty kProperty = $$delegatedProperties[22];
        return (ProgressiveJpegConfig) lazySet.getValue();
    }

    public final void setMProgressiveJpegConfig(ProgressiveJpegConfig progressiveJpegConfig) {
        LazySet lazySet = this.mProgressiveJpegConfig;
        KProperty kProperty = $$delegatedProperties[22];
        lazySet.setValue(progressiveJpegConfig);
    }

    public final Set<RequestListener> getMRequestListeners() {
        LazySet lazySet = this.mRequestListeners;
        KProperty kProperty = $$delegatedProperties[23];
        return (Set) lazySet.getValue();
    }

    public final void setMRequestListeners(Set<? extends RequestListener> set) {
        LazySet lazySet = this.mRequestListeners;
        KProperty kProperty = $$delegatedProperties[23];
        lazySet.setValue(set);
    }

    public final Boolean getMResizeAndRotateEnabledForNetwork() {
        LazySet lazySet = this.mResizeAndRotateEnabledForNetwork;
        KProperty kProperty = $$delegatedProperties[24];
        return (Boolean) lazySet.getValue();
    }

    public final void setMResizeAndRotateEnabledForNetwork(Boolean bool) {
        LazySet lazySet = this.mResizeAndRotateEnabledForNetwork;
        KProperty kProperty = $$delegatedProperties[24];
        lazySet.setValue(bool);
    }

    public final DiskCacheConfig getMSmallImageDiskCacheConfig() {
        LazySet lazySet = this.mSmallImageDiskCacheConfig;
        KProperty kProperty = $$delegatedProperties[25];
        return (DiskCacheConfig) lazySet.getValue();
    }

    public final void setMSmallImageDiskCacheConfig(DiskCacheConfig diskCacheConfig) {
        LazySet lazySet = this.mSmallImageDiskCacheConfig;
        KProperty kProperty = $$delegatedProperties[25];
        lazySet.setValue(diskCacheConfig);
    }

    public final ImageDecoderConfig getMImageDecoderConfig() {
        LazySet lazySet = this.mImageDecoderConfig;
        KProperty kProperty = $$delegatedProperties[26];
        return (ImageDecoderConfig) lazySet.getValue();
    }

    public final void setMImageDecoderConfig(ImageDecoderConfig imageDecoderConfig) {
        LazySet lazySet = this.mImageDecoderConfig;
        KProperty kProperty = $$delegatedProperties[26];
        lazySet.setValue(imageDecoderConfig);
    }

    public final ImagePipelineExperiments getMImagePipelineExperiments() {
        LazySet lazySet = this.mImagePipelineExperiments;
        KProperty kProperty = $$delegatedProperties[27];
        return (ImagePipelineExperiments) lazySet.getValue();
    }

    public final void setMImagePipelineExperiments(ImagePipelineExperiments imagePipelineExperiments) {
        LazySet lazySet = this.mImagePipelineExperiments;
        KProperty kProperty = $$delegatedProperties[27];
        lazySet.setValue(imagePipelineExperiments);
    }

    public final Boolean getMIsSplitMemCache() {
        LazySet lazySet = this.mIsSplitMemCache;
        KProperty kProperty = $$delegatedProperties[28];
        return (Boolean) lazySet.getValue();
    }

    public final void setMIsSplitMemCache(Boolean bool) {
        LazySet lazySet = this.mIsSplitMemCache;
        KProperty kProperty = $$delegatedProperties[28];
        lazySet.setValue(bool);
    }

    public final Boolean getMEnableSingleMemCache() {
        LazySet lazySet = this.mEnableSingleMemCache;
        KProperty kProperty = $$delegatedProperties[29];
        return (Boolean) lazySet.getValue();
    }

    public final void setMEnableSingleMemCache(Boolean bool) {
        LazySet lazySet = this.mEnableSingleMemCache;
        KProperty kProperty = $$delegatedProperties[29];
        lazySet.setValue(bool);
    }

    public final Supplier<MemoryCacheParams> getMSingleBitmapMemoryCacheParamsSupplier() {
        LazySet lazySet = this.mSingleBitmapMemoryCacheParamsSupplier;
        KProperty kProperty = $$delegatedProperties[30];
        return (Supplier) lazySet.getValue();
    }

    public final void setMSingleBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> supplier) {
        LazySet lazySet = this.mSingleBitmapMemoryCacheParamsSupplier;
        KProperty kProperty = $$delegatedProperties[30];
        lazySet.setValue(supplier);
    }

    public final Boolean getMAnimatedHeifIndividualCacheEnabled() {
        LazySet lazySet = this.mAnimatedHeifIndividualCacheEnabled;
        KProperty kProperty = $$delegatedProperties[31];
        return (Boolean) lazySet.getValue();
    }

    public final void setMAnimatedHeifIndividualCacheEnabled(Boolean bool) {
        LazySet lazySet = this.mAnimatedHeifIndividualCacheEnabled;
        KProperty kProperty = $$delegatedProperties[31];
        lazySet.setValue(bool);
    }

    public final Boolean getMShowHeifDebugLog() {
        LazySet lazySet = this.mShowHeifDebugLog;
        KProperty kProperty = $$delegatedProperties[32];
        return (Boolean) lazySet.getValue();
    }

    public final void setMShowHeifDebugLog(Boolean bool) {
        LazySet lazySet = this.mShowHeifDebugLog;
        KProperty kProperty = $$delegatedProperties[32];
        lazySet.setValue(bool);
    }

    public final Boolean getMAnimatedHeifIndividualCacheForImageRequestEnabled() {
        LazySet lazySet = this.mAnimatedHeifIndividualCacheForImageRequestEnabled;
        KProperty kProperty = $$delegatedProperties[33];
        return (Boolean) lazySet.getValue();
    }

    public final void setMAnimatedHeifIndividualCacheForImageRequestEnabled(Boolean bool) {
        LazySet lazySet = this.mAnimatedHeifIndividualCacheForImageRequestEnabled;
        KProperty kProperty = $$delegatedProperties[33];
        lazySet.setValue(bool);
    }

    public final Boolean getMDiskCacheEnabled() {
        LazySet lazySet = this.mDiskCacheEnabled;
        KProperty kProperty = $$delegatedProperties[34];
        return (Boolean) lazySet.getValue();
    }

    public final void setMDiskCacheEnabled(Boolean bool) {
        LazySet lazySet = this.mDiskCacheEnabled;
        KProperty kProperty = $$delegatedProperties[34];
        lazySet.setValue(bool);
    }

    public final HashMap<String, DiskCacheConfig> getMCustomImageDiskCacheConfigMap() {
        LazySet lazySet = this.mCustomImageDiskCacheConfigMap;
        KProperty kProperty = $$delegatedProperties[35];
        return (HashMap) lazySet.getValue();
    }

    public final void setMCustomImageDiskCacheConfigMap(HashMap<String, DiskCacheConfig> hashMap) {
        LazySet lazySet = this.mCustomImageDiskCacheConfigMap;
        KProperty kProperty = $$delegatedProperties[35];
        lazySet.setValue(hashMap);
    }

    public final Boolean getMWasImmediate() {
        LazySet lazySet = this.mWasImmediate;
        KProperty kProperty = $$delegatedProperties[36];
        return (Boolean) lazySet.getValue();
    }

    public final void setMWasImmediate(Boolean bool) {
        LazySet lazySet = this.mWasImmediate;
        KProperty kProperty = $$delegatedProperties[36];
        lazySet.setValue(bool);
    }

    public final Boolean getUseSingleImageRequest() {
        LazySet lazySet = this.useSingleImageRequest;
        KProperty kProperty = $$delegatedProperties[37];
        return (Boolean) lazySet.getValue();
    }

    public final void setUseSingleImageRequest(Boolean bool) {
        LazySet lazySet = this.useSingleImageRequest;
        KProperty kProperty = $$delegatedProperties[37];
        lazySet.setValue(bool);
    }

    public final Boolean getMEnableBigImgCache() {
        LazySet lazySet = this.mEnableBigImgCache;
        KProperty kProperty = $$delegatedProperties[38];
        return (Boolean) lazySet.getValue();
    }

    public final void setMEnableBigImgCache(Boolean bool) {
        LazySet lazySet = this.mEnableBigImgCache;
        KProperty kProperty = $$delegatedProperties[38];
        lazySet.setValue(bool);
    }

    public final Supplier<MemoryCacheParams> getMBigImgBitmapMemoryCacheParamsSupplier() {
        LazySet lazySet = this.mBigImgBitmapMemoryCacheParamsSupplier;
        KProperty kProperty = $$delegatedProperties[39];
        return (Supplier) lazySet.getValue();
    }

    public final void setMBigImgBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> supplier) {
        LazySet lazySet = this.mBigImgBitmapMemoryCacheParamsSupplier;
        KProperty kProperty = $$delegatedProperties[39];
        lazySet.setValue(supplier);
    }

    public final Boolean getMEnablePrefetchImgCache() {
        LazySet lazySet = this.mEnablePrefetchImgCache;
        KProperty kProperty = $$delegatedProperties[40];
        return (Boolean) lazySet.getValue();
    }

    public final void setMEnablePrefetchImgCache(Boolean bool) {
        LazySet lazySet = this.mEnablePrefetchImgCache;
        KProperty kProperty = $$delegatedProperties[40];
        lazySet.setValue(bool);
    }

    public final Supplier<MemoryCacheParams> getMPrefetchImgBitmapMemoryCacheParamsSupplier() {
        LazySet lazySet = this.mPrefetchImgBitmapMemoryCacheParamsSupplier;
        KProperty kProperty = $$delegatedProperties[41];
        return (Supplier) lazySet.getValue();
    }

    public final void setMPrefetchImgBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> supplier) {
        LazySet lazySet = this.mPrefetchImgBitmapMemoryCacheParamsSupplier;
        KProperty kProperty = $$delegatedProperties[41];
        lazySet.setValue(supplier);
    }

    public final Long getMBigImgSizeLimit() {
        LazySet lazySet = this.mBigImgSizeLimit;
        KProperty kProperty = $$delegatedProperties[42];
        return (Long) lazySet.getValue();
    }

    public final void setMBigImgSizeLimit(Long l) {
        LazySet lazySet = this.mBigImgSizeLimit;
        KProperty kProperty = $$delegatedProperties[42];
        lazySet.setValue(l);
    }

    public final Boolean getMRetainPreviousImage() {
        LazySet lazySet = this.mRetainPreviousImage;
        KProperty kProperty = $$delegatedProperties[43];
        return (Boolean) lazySet.getValue();
    }

    public final void setMRetainPreviousImage(Boolean bool) {
        LazySet lazySet = this.mRetainPreviousImage;
        KProperty kProperty = $$delegatedProperties[43];
        lazySet.setValue(bool);
    }

    public final Boolean getMEnableNewLocalVideoThumbnailOpt() {
        LazySet lazySet = this.mEnableNewLocalVideoThumbnailOpt;
        KProperty kProperty = $$delegatedProperties[44];
        return (Boolean) lazySet.getValue();
    }

    public final void setMEnableNewLocalVideoThumbnailOpt(Boolean bool) {
        LazySet lazySet = this.mEnableNewLocalVideoThumbnailOpt;
        KProperty kProperty = $$delegatedProperties[44];
        lazySet.setValue(bool);
    }

    public final Boolean getMUseOptHeifBitmap() {
        LazySet lazySet = this.mUseOptHeifBitmap;
        KProperty kProperty = $$delegatedProperties[45];
        return (Boolean) lazySet.getValue();
    }

    public final void setMUseOptHeifBitmap(Boolean bool) {
        LazySet lazySet = this.mUseOptHeifBitmap;
        KProperty kProperty = $$delegatedProperties[45];
        lazySet.setValue(bool);
    }
}
