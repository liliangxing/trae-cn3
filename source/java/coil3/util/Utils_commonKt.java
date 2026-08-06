package coil3.util;

import coil3.ComponentRegistry;
import coil3.EventListener;
import coil3.Image;
import coil3.Uri;
import coil3.decode.DataSource;
import coil3.decode.Decoder;
import coil3.fetch.Fetcher;
import coil3.intercept.Interceptor;
import coil3.intercept.RealInterceptorChain;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.NullRequestDataException;
import coil3.size.SizeResolver;
import coil3.util.Logger;
import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: utils.common.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0080\b\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00060\u0011j\u0002`\u0010H\u0000¢\u0006\u0002\u0010\u0012\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00060\u0014j\u0002`\u0013H\u0000¢\u0006\u0002\u0010\u0015\u001a*\u0010\u001c\u001a\u00020\u001d*\u00020\u001d2\u001c\u0010\u001e\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030 \u0012\b\u0012\u0006\u0012\u0002\b\u00030!\u0018\u00010\u001fH\u0000\u001a\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0000\u001a\f\u00105\u001a\u00020**\u000206H\u0000\u001a\u0010\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020:H\u0000\u001a\u0018\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0000\"\u0018\u0010\u000b\u001a\u00020\u0004*\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\"\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u000e\u0010$\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010)\u001a\u00020**\u00020+8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b)\u0010,\"\u0018\u0010-\u001a\u00020.*\u00020+8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b/\u00100\"\u0018\u00101\u001a\u000202*\u00020+8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b3\u00104\"\u000e\u00107\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"log", "", "Lcoil3/util/Logger;", "tag", "", "level", "Lcoil3/util/Logger$Level;", "message", "Lkotlin/Function0;", "throwable", "", "emoji", "Lcoil3/decode/DataSource;", "getEmoji", "(Lcoil3/decode/DataSource;)Ljava/lang/String;", "closeQuietly", "Lokio/Closeable;", "Ljava/io/Closeable;", "(Ljava/io/Closeable;)V", "Lkotlin/AutoCloseable;", "Ljava/lang/AutoCloseable;", "(Ljava/lang/AutoCloseable;)V", "EMPTY_IMAGE_FACTORY", "Lkotlin/Function1;", "Lcoil3/request/ImageRequest;", "Lcoil3/Image;", "getEMPTY_IMAGE_FACTORY", "()Lkotlin/jvm/functions/Function1;", "addFirst", "Lcoil3/ComponentRegistry$Builder;", "pair", "Lkotlin/Pair;", "Lcoil3/fetch/Fetcher$Factory;", "Lkotlin/reflect/KClass;", "factory", "Lcoil3/decode/Decoder$Factory;", "MIME_TYPE_JPEG", "MIME_TYPE_WEBP", "MIME_TYPE_HEIC", "MIME_TYPE_HEIF", "MIME_TYPE_XML", "isPlaceholderCached", "", "Lcoil3/intercept/Interceptor$Chain;", "(Lcoil3/intercept/Interceptor$Chain;)Z", "eventListener", "Lcoil3/EventListener;", "getEventListener", "(Lcoil3/intercept/Interceptor$Chain;)Lcoil3/EventListener;", "sizeResolver", "Lcoil3/size/SizeResolver;", "getSizeResolver", "(Lcoil3/intercept/Interceptor$Chain;)Lcoil3/size/SizeResolver;", "isMinOrMax", "", "SCHEME_FILE", "isFileUri", "uri", "Lcoil3/Uri;", "ErrorResult", "Lcoil3/request/ErrorResult;", "request", "coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class Utils_commonKt {
    private static final Function1<ImageRequest, Image> EMPTY_IMAGE_FACTORY = new Function1() { // from class: coil3.util.Utils_commonKt$EMPTY_IMAGE_FACTORY$1
        public final Void invoke(ImageRequest imageRequest) {
            return null;
        }
    };
    public static final String MIME_TYPE_HEIC = "image/heic";
    public static final String MIME_TYPE_HEIF = "image/heif";
    public static final String MIME_TYPE_JPEG = "image/jpeg";
    public static final String MIME_TYPE_WEBP = "image/webp";
    public static final String MIME_TYPE_XML = "text/xml";
    public static final String SCHEME_FILE = "file";

    /* compiled from: utils.common.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DataSource.values().length];
            try {
                iArr[DataSource.MEMORY_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DataSource.MEMORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DataSource.DISK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DataSource.NETWORK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean isMinOrMax(int i) {
        return i == Integer.MIN_VALUE || i == Integer.MAX_VALUE;
    }

    public static final void log(Logger logger, String str, Logger.Level level, Function0<String> function0) {
        if (logger.getMinLevel().compareTo(level) <= 0) {
            logger.log(str, level, (String) function0.invoke(), null);
        }
    }

    public static final void log(Logger logger, String str, Throwable th) {
        if (logger.getMinLevel().compareTo(Logger.Level.Error) <= 0) {
            logger.log(str, Logger.Level.Error, null, th);
        }
    }

    public static final String getEmoji(DataSource dataSource) {
        int i = WhenMappings.$EnumSwitchMapping$0[dataSource.ordinal()];
        if (i == 1 || i == 2) {
            return "🧠";
        }
        if (i == 3) {
            return "💾";
        }
        if (i == 4) {
            return "☁️";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final Function1<ImageRequest, Image> getEMPTY_IMAGE_FACTORY() {
        return EMPTY_IMAGE_FACTORY;
    }

    public static final ComponentRegistry.Builder addFirst(ComponentRegistry.Builder builder, final Pair<? extends Fetcher.Factory<?>, ? extends KClass<?>> pair) {
        if (pair != null) {
            builder.getLazyFetcherFactories$coil_core_release().add(0, new Function0() { // from class: coil3.util.Utils_commonKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    List listOf;
                    listOf = kotlin.collections.CollectionsKt.listOf(pair);
                    return listOf;
                }
            });
        }
        return builder;
    }

    public static final ComponentRegistry.Builder addFirst(ComponentRegistry.Builder builder, final Decoder.Factory factory) {
        if (factory != null) {
            builder.getLazyDecoderFactories$coil_core_release().add(0, new Function0() { // from class: coil3.util.Utils_commonKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    List listOf;
                    listOf = kotlin.collections.CollectionsKt.listOf(Decoder.Factory.this);
                    return listOf;
                }
            });
        }
        return builder;
    }

    public static final boolean isPlaceholderCached(Interceptor.Chain chain) {
        return (chain instanceof RealInterceptorChain) && ((RealInterceptorChain) chain).getIsPlaceholderCached();
    }

    public static final EventListener getEventListener(Interceptor.Chain chain) {
        return chain instanceof RealInterceptorChain ? ((RealInterceptorChain) chain).getEventListener() : EventListener.NONE;
    }

    public static final SizeResolver getSizeResolver(Interceptor.Chain chain) {
        return chain instanceof RealInterceptorChain ? ((RealInterceptorChain) chain).getSizeResolver() : chain.getRequest().getSizeResolver();
    }

    public static final boolean isFileUri(Uri uri) {
        return ((uri.getScheme() != null && !Intrinsics.areEqual(uri.getScheme(), SCHEME_FILE)) || uri.getPath() == null || Utils_androidKt.isAssetUri(uri)) ? false : true;
    }

    public static final ErrorResult ErrorResult(ImageRequest imageRequest, Throwable th) {
        Image error;
        if (th instanceof NullRequestDataException) {
            error = imageRequest.fallback();
            if (error == null) {
                error = imageRequest.error();
            }
        } else {
            error = imageRequest.error();
        }
        return new ErrorResult(error, imageRequest, th);
    }
}
