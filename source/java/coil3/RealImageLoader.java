package coil3;

import android.content.Context;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import coil3.EventListener;
import coil3.ImageLoader;
import coil3.decode.DataSource;
import coil3.disk.DiskCache;
import coil3.intercept.EngineInterceptor;
import coil3.memory.MemoryCache;
import coil3.request.Disposable;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.ImageRequestsKt;
import coil3.request.ImageResult;
import coil3.request.NullRequestData;
import coil3.request.NullRequestDataException;
import coil3.request.RequestDelegate;
import coil3.request.RequestService;
import coil3.request.RequestServiceKt;
import coil3.request.SuccessResult;
import coil3.size.Size;
import coil3.size.SizeResolver;
import coil3.target.Target;
import coil3.transition.NoneTransition;
import coil3.transition.Transition;
import coil3.transition.TransitionTarget;
import coil3.util.Logger;
import coil3.util.SystemCallbacks;
import coil3.util.SystemCallbacksKt;
import coil3.util.Utils_commonKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.JobKt;

/* compiled from: RealImageLoader.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001;B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0016\u0010'\u001a\u00020(2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010)J\u001e\u0010'\u001a\u00020(2\u0006\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0082@¢\u0006\u0002\u0010-J\b\u0010!\u001a\u00020.H\u0016J\b\u0010/\u001a\u000200H\u0016J\"\u00101\u001a\u00020.2\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u000207H\u0002J\"\u00108\u001a\u00020.2\u0006\u00102\u001a\u0002092\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u000207H\u0002J\u0018\u0010:\u001a\u00020.2\u0006\u0010%\u001a\u00020&2\u0006\u00106\u001a\u000207H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0096\u0084\u0002¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017*\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0096\u0084\u0002¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c*\u0004\b\u001a\u0010\u0015R\u0014\u0010\u001d\u001a\u00020\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\t\u0010!\u001a\u00020\"X\u0082\u0004¨\u0006<"}, d2 = {"Lcoil3/RealImageLoader;", "Lcoil3/ImageLoader;", "options", "Lcoil3/RealImageLoader$Options;", "<init>", "(Lcoil3/RealImageLoader$Options;)V", "getOptions", "()Lcoil3/RealImageLoader$Options;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "systemCallbacks", "Lcoil3/util/SystemCallbacks;", "requestService", "Lcoil3/request/RequestService;", "defaults", "Lcoil3/request/ImageRequest$Defaults;", "getDefaults", "()Lcoil3/request/ImageRequest$Defaults;", "memoryCache", "Lcoil3/memory/MemoryCache;", "getMemoryCache$delegate", "(Lcoil3/RealImageLoader;)Ljava/lang/Object;", "getMemoryCache", "()Lcoil3/memory/MemoryCache;", "diskCache", "Lcoil3/disk/DiskCache;", "getDiskCache$delegate", "getDiskCache", "()Lcoil3/disk/DiskCache;", "components", "Lcoil3/ComponentRegistry;", "getComponents", "()Lcoil3/ComponentRegistry;", "shutdown", "Lkotlinx/atomicfu/AtomicBoolean;", "enqueue", "Lcoil3/request/Disposable;", "request", "Lcoil3/request/ImageRequest;", "execute", "Lcoil3/request/ImageResult;", "(Lcoil3/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initialRequest", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "", "(Lcoil3/request/ImageRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "newBuilder", "Lcoil3/ImageLoader$Builder;", "onSuccess", StrategyConstants.RESULT, "Lcoil3/request/SuccessResult;", "target", "Lcoil3/target/Target;", "eventListener", "Lcoil3/EventListener;", "onError", "Lcoil3/request/ErrorResult;", "onCancel", "Options", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class RealImageLoader implements ImageLoader {
    private static final /* synthetic */ AtomicIntegerFieldUpdater shutdown$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(RealImageLoader.class, "shutdown$volatile");
    private final ComponentRegistry components;
    private final Options options;
    private final RequestService requestService;
    private final CoroutineScope scope;
    private volatile /* synthetic */ int shutdown$volatile;
    private final SystemCallbacks systemCallbacks;

    private final /* synthetic */ int getShutdown$volatile() {
        return this.shutdown$volatile;
    }

    private final /* synthetic */ void setShutdown$volatile(int i) {
        this.shutdown$volatile = i;
    }

    public RealImageLoader(Options options) {
        this.options = options;
        this.scope = RealImageLoaderKt.access$CoroutineScope(options.getLogger());
        SystemCallbacks SystemCallbacks = SystemCallbacksKt.SystemCallbacks(this);
        this.systemCallbacks = SystemCallbacks;
        RealImageLoader realImageLoader = this;
        RequestService RequestService = RequestServiceKt.RequestService(realImageLoader, SystemCallbacks, options.getLogger());
        this.requestService = RequestService;
        options.getMemoryCacheLazy();
        options.getDiskCacheLazy();
        this.components = RealImageLoaderKt.addCommonComponents(RealImageLoader_nonNativeKt.addAppleComponents(RealImageLoader_androidKt.addOhosComponents(RealImageLoader_jvmCommonKt.addJvmComponents(RealImageLoader_androidKt.addAndroidComponents(RealImageLoaderKt.addServiceLoaderComponents(options.getComponentRegistry().newBuilder(), options), options), options), options), options), options).add(new EngineInterceptor(realImageLoader, SystemCallbacks, RequestService, options.getLogger())).build();
        this.shutdown$volatile = 0;
    }

    public final Options getOptions() {
        return this.options;
    }

    @Override // coil3.ImageLoader
    public ImageRequest.Defaults getDefaults() {
        return this.options.getDefaults();
    }

    @Override // coil3.ImageLoader
    public MemoryCache getMemoryCache() {
        return (MemoryCache) this.options.getMemoryCacheLazy().getValue();
    }

    @Override // coil3.ImageLoader
    public DiskCache getDiskCache() {
        return (DiskCache) this.options.getDiskCacheLazy().getValue();
    }

    @Override // coil3.ImageLoader
    public ComponentRegistry getComponents() {
        return this.components;
    }

    @Override // coil3.ImageLoader
    public Disposable enqueue(ImageRequest request) {
        return RealImageLoader_androidKt.getDisposable(request, BuildersKt.async$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new RealImageLoader$enqueue$job$1(this, request, null), 3, (Object) null));
    }

    @Override // coil3.ImageLoader
    public Object execute(ImageRequest imageRequest, Continuation<? super ImageResult> continuation) {
        if (RealImageLoader_androidKt.needsExecuteOnMainDispatcher(imageRequest)) {
            return CoroutineScopeKt.coroutineScope(new RealImageLoader$execute$2(imageRequest, this, null), continuation);
        }
        return execute(imageRequest, 1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0184 A[Catch: all -> 0x004c, TryCatch #4 {all -> 0x004c, blocks: (B:13:0x0047, B:14:0x017e, B:16:0x0184, B:20:0x018f, B:22:0x0193, B:23:0x01a1, B:24:0x01a6), top: B:12:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x018f A[Catch: all -> 0x004c, TryCatch #4 {all -> 0x004c, blocks: (B:13:0x0047, B:14:0x017e, B:16:0x0184, B:20:0x018f, B:22:0x0193, B:23:0x01a1, B:24:0x01a6), top: B:12:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01bb A[Catch: all -> 0x01ce, TRY_LEAVE, TryCatch #5 {all -> 0x01ce, blocks: (B:27:0x01b7, B:29:0x01bb, B:32:0x01ca, B:33:0x01cd), top: B:26:0x01b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01ca A[Catch: all -> 0x01ce, TRY_ENTER, TryCatch #5 {all -> 0x01ce, blocks: (B:27:0x01b7, B:29:0x01bb, B:32:0x01ca, B:33:0x01cd), top: B:26:0x01b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0179 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fa A[Catch: all -> 0x01a7, TryCatch #2 {all -> 0x01a7, blocks: (B:60:0x00f4, B:62:0x00fa, B:64:0x0100, B:66:0x0106, B:67:0x010c, B:70:0x0114, B:71:0x011a, B:73:0x011d, B:75:0x0126, B:76:0x0129), top: B:59:0x00f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0126 A[Catch: all -> 0x01a7, TryCatch #2 {all -> 0x01a7, blocks: (B:60:0x00f4, B:62:0x00fa, B:64:0x0100, B:66:0x0106, B:67:0x010c, B:70:0x0114, B:71:0x011a, B:73:0x011d, B:75:0x0126, B:76:0x0129), top: B:59:0x00f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0146 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object execute(ImageRequest imageRequest, int i, Continuation<? super ImageResult> continuation) {
        RealImageLoader$execute$3 realImageLoader$execute$3;
        Object coroutine_suspended;
        int i2;
        RequestDelegate requestDelegate;
        ImageRequest build;
        RealImageLoader realImageLoader;
        RequestDelegate requestDelegate2;
        EventListener eventListener;
        RealImageLoader realImageLoader2;
        ImageRequest imageRequest2;
        EventListener eventListener2;
        RequestDelegate requestDelegate3;
        Target target;
        ImageRequest.Listener listener;
        Object size;
        Image image;
        SizeResolver sizeResolver;
        MemoryCache memoryCache;
        MemoryCache.Value value;
        ImageResult imageResult;
        try {
            if (continuation instanceof RealImageLoader$execute$3) {
                realImageLoader$execute$3 = (RealImageLoader$execute$3) continuation;
                if ((realImageLoader$execute$3.label & Integer.MIN_VALUE) != 0) {
                    realImageLoader$execute$3.label -= Integer.MIN_VALUE;
                    Object obj = realImageLoader$execute$3.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i2 = realImageLoader$execute$3.label;
                    if (i2 != 0) {
                        ResultKt.throwOnFailure(obj);
                        requestDelegate = this.requestService.requestDelegate(imageRequest, JobKt.getJob(realImageLoader$execute$3.getContext()));
                        requestDelegate.assertActive();
                        build = ImageRequest.newBuilder$default(imageRequest, null, 1, null).defaults(getDefaults()).build();
                        EventListener create = this.options.getEventListenerFactory().create(build);
                        try {
                            if (Intrinsics.areEqual(build.getData(), NullRequestData.INSTANCE)) {
                                throw new NullRequestDataException();
                            }
                            requestDelegate.start();
                            if (i == 0) {
                                realImageLoader$execute$3.L$0 = this;
                                realImageLoader$execute$3.L$1 = requestDelegate;
                                realImageLoader$execute$3.L$2 = build;
                                realImageLoader$execute$3.L$3 = create;
                                realImageLoader$execute$3.label = 1;
                                if (requestDelegate.awaitStarted(realImageLoader$execute$3) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                realImageLoader2 = this;
                                imageRequest2 = build;
                                eventListener2 = create;
                                requestDelegate3 = requestDelegate;
                            } else {
                                realImageLoader2 = this;
                                imageRequest2 = build;
                                eventListener2 = create;
                                MemoryCache.Key placeholderMemoryCacheKey = imageRequest2.getPlaceholderMemoryCacheKey();
                                Image image2 = (placeholderMemoryCacheKey != null || (memoryCache = realImageLoader2.getMemoryCache()) == null || (value = memoryCache.get(placeholderMemoryCacheKey)) == null) ? null : value.getImage();
                                target = imageRequest2.getTarget();
                                if (target != null) {
                                    target.onStart(image2 == null ? imageRequest2.placeholder() : image2);
                                }
                                eventListener2.onStart(imageRequest2);
                                listener = imageRequest2.getListener();
                                if (listener != null) {
                                    listener.onStart(imageRequest2);
                                }
                                SizeResolver sizeResolver2 = realImageLoader2.requestService.sizeResolver(imageRequest2);
                                eventListener2.resolveSizeStart(imageRequest2, sizeResolver2);
                                realImageLoader$execute$3.L$0 = realImageLoader2;
                                realImageLoader$execute$3.L$1 = requestDelegate;
                                realImageLoader$execute$3.L$2 = imageRequest2;
                                realImageLoader$execute$3.L$3 = eventListener2;
                                realImageLoader$execute$3.L$4 = image2;
                                realImageLoader$execute$3.L$5 = sizeResolver2;
                                realImageLoader$execute$3.label = 2;
                                size = sizeResolver2.size(realImageLoader$execute$3);
                                if (size == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                image = image2;
                                sizeResolver = sizeResolver2;
                                requestDelegate3 = requestDelegate;
                                obj = size;
                                Size size2 = (Size) obj;
                                eventListener2.resolveSizeEnd(imageRequest2, size2);
                                CoroutineContext interceptorCoroutineContext = imageRequest2.getInterceptorCoroutineContext();
                                RealImageLoader$execute$result$1 realImageLoader$execute$result$1 = new RealImageLoader$execute$result$1(imageRequest2, realImageLoader2, size2, sizeResolver, eventListener2, image, null);
                                realImageLoader$execute$3.L$0 = realImageLoader2;
                                realImageLoader$execute$3.L$1 = requestDelegate3;
                                realImageLoader$execute$3.L$2 = imageRequest2;
                                realImageLoader$execute$3.L$3 = eventListener2;
                                realImageLoader$execute$3.L$4 = null;
                                realImageLoader$execute$3.L$5 = null;
                                realImageLoader$execute$3.label = 3;
                                obj = BuildersKt.withContext(interceptorCoroutineContext, realImageLoader$execute$result$1, realImageLoader$execute$3);
                                if (obj != coroutine_suspended) {
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            realImageLoader = this;
                            requestDelegate2 = requestDelegate;
                            eventListener = create;
                            if (th instanceof CancellationException) {
                                realImageLoader.onCancel(build, eventListener);
                                throw th;
                            }
                            ErrorResult ErrorResult = Utils_commonKt.ErrorResult(build, th);
                            realImageLoader.onError(ErrorResult, build.getTarget(), eventListener);
                            return ErrorResult;
                        }
                    } else if (i2 == 1) {
                        eventListener2 = (EventListener) realImageLoader$execute$3.L$3;
                        imageRequest2 = (ImageRequest) realImageLoader$execute$3.L$2;
                        requestDelegate3 = (RequestDelegate) realImageLoader$execute$3.L$1;
                        realImageLoader2 = (RealImageLoader) realImageLoader$execute$3.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th2) {
                            th = th2;
                            eventListener = eventListener2;
                            build = imageRequest2;
                            requestDelegate2 = requestDelegate3;
                            realImageLoader = realImageLoader2;
                            if (th instanceof CancellationException) {
                            }
                        }
                    } else if (i2 == 2) {
                        SizeResolver sizeResolver3 = (SizeResolver) realImageLoader$execute$3.L$5;
                        Image image3 = (Image) realImageLoader$execute$3.L$4;
                        EventListener eventListener3 = (EventListener) realImageLoader$execute$3.L$3;
                        imageRequest2 = (ImageRequest) realImageLoader$execute$3.L$2;
                        requestDelegate3 = (RequestDelegate) realImageLoader$execute$3.L$1;
                        realImageLoader2 = (RealImageLoader) realImageLoader$execute$3.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            sizeResolver = sizeResolver3;
                            image = image3;
                            eventListener2 = eventListener3;
                            Size size22 = (Size) obj;
                            eventListener2.resolveSizeEnd(imageRequest2, size22);
                            CoroutineContext interceptorCoroutineContext2 = imageRequest2.getInterceptorCoroutineContext();
                            RealImageLoader$execute$result$1 realImageLoader$execute$result$12 = new RealImageLoader$execute$result$1(imageRequest2, realImageLoader2, size22, sizeResolver, eventListener2, image, null);
                            realImageLoader$execute$3.L$0 = realImageLoader2;
                            realImageLoader$execute$3.L$1 = requestDelegate3;
                            realImageLoader$execute$3.L$2 = imageRequest2;
                            realImageLoader$execute$3.L$3 = eventListener2;
                            realImageLoader$execute$3.L$4 = null;
                            realImageLoader$execute$3.L$5 = null;
                            realImageLoader$execute$3.label = 3;
                            obj = BuildersKt.withContext(interceptorCoroutineContext2, realImageLoader$execute$result$12, realImageLoader$execute$3);
                            if (obj != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            eventListener = eventListener2;
                            build = imageRequest2;
                            requestDelegate2 = requestDelegate3;
                            realImageLoader = realImageLoader2;
                            imageResult = (ImageResult) obj;
                            if (!(imageResult instanceof SuccessResult)) {
                            }
                            return imageResult;
                        } catch (Throwable th3) {
                            th = th3;
                            eventListener = eventListener3;
                            build = imageRequest2;
                            requestDelegate2 = requestDelegate3;
                            realImageLoader = realImageLoader2;
                            if (th instanceof CancellationException) {
                            }
                        }
                    } else {
                        if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        eventListener = (EventListener) realImageLoader$execute$3.L$3;
                        build = (ImageRequest) realImageLoader$execute$3.L$2;
                        requestDelegate2 = (RequestDelegate) realImageLoader$execute$3.L$1;
                        realImageLoader = (RealImageLoader) realImageLoader$execute$3.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            imageResult = (ImageResult) obj;
                            if (!(imageResult instanceof SuccessResult)) {
                                realImageLoader.onSuccess((SuccessResult) imageResult, build.getTarget(), eventListener);
                            } else {
                                if (!(imageResult instanceof ErrorResult)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                realImageLoader.onError((ErrorResult) imageResult, build.getTarget(), eventListener);
                            }
                            return imageResult;
                        } catch (Throwable th4) {
                            th = th4;
                            try {
                                if (th instanceof CancellationException) {
                                }
                            } finally {
                                requestDelegate2.complete();
                            }
                        }
                    }
                    requestDelegate = requestDelegate3;
                    MemoryCache.Key placeholderMemoryCacheKey2 = imageRequest2.getPlaceholderMemoryCacheKey();
                    if (placeholderMemoryCacheKey2 != null) {
                    }
                    target = imageRequest2.getTarget();
                    if (target != null) {
                    }
                    eventListener2.onStart(imageRequest2);
                    listener = imageRequest2.getListener();
                    if (listener != null) {
                    }
                    SizeResolver sizeResolver22 = realImageLoader2.requestService.sizeResolver(imageRequest2);
                    eventListener2.resolveSizeStart(imageRequest2, sizeResolver22);
                    realImageLoader$execute$3.L$0 = realImageLoader2;
                    realImageLoader$execute$3.L$1 = requestDelegate;
                    realImageLoader$execute$3.L$2 = imageRequest2;
                    realImageLoader$execute$3.L$3 = eventListener2;
                    realImageLoader$execute$3.L$4 = image2;
                    realImageLoader$execute$3.L$5 = sizeResolver22;
                    realImageLoader$execute$3.label = 2;
                    size = sizeResolver22.size(realImageLoader$execute$3);
                    if (size == coroutine_suspended) {
                    }
                }
            }
            MemoryCache.Key placeholderMemoryCacheKey22 = imageRequest2.getPlaceholderMemoryCacheKey();
            if (placeholderMemoryCacheKey22 != null) {
            }
            target = imageRequest2.getTarget();
            if (target != null) {
            }
            eventListener2.onStart(imageRequest2);
            listener = imageRequest2.getListener();
            if (listener != null) {
            }
            SizeResolver sizeResolver222 = realImageLoader2.requestService.sizeResolver(imageRequest2);
            eventListener2.resolveSizeStart(imageRequest2, sizeResolver222);
            realImageLoader$execute$3.L$0 = realImageLoader2;
            realImageLoader$execute$3.L$1 = requestDelegate;
            realImageLoader$execute$3.L$2 = imageRequest2;
            realImageLoader$execute$3.L$3 = eventListener2;
            realImageLoader$execute$3.L$4 = image2;
            realImageLoader$execute$3.L$5 = sizeResolver222;
            realImageLoader$execute$3.label = 2;
            size = sizeResolver222.size(realImageLoader$execute$3);
            if (size == coroutine_suspended) {
            }
        } catch (Throwable th5) {
            th = th5;
            requestDelegate2 = requestDelegate;
            eventListener = eventListener2;
            build = imageRequest2;
            realImageLoader = realImageLoader2;
            if (th instanceof CancellationException) {
            }
        }
        realImageLoader$execute$3 = new RealImageLoader$execute$3(this, continuation);
        Object obj2 = realImageLoader$execute$3.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = realImageLoader$execute$3.label;
        if (i2 != 0) {
        }
        requestDelegate = requestDelegate3;
    }

    @Override // coil3.ImageLoader
    public void shutdown() {
        if (shutdown$volatile$FU.getAndSet(this, 1) != 0) {
            return;
        }
        CoroutineScopeKt.cancel$default(this.scope, (CancellationException) null, 1, (Object) null);
        this.systemCallbacks.shutdown();
        MemoryCache memoryCache = getMemoryCache();
        if (memoryCache != null) {
            memoryCache.clear();
        }
    }

    @Override // coil3.ImageLoader
    public ImageLoader.Builder newBuilder() {
        return new ImageLoader.Builder(this.options);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0056, code lost:
    
        if (r8 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void onSuccess(SuccessResult result, Target target, EventListener eventListener) {
        ImageRequest request = result.getRequest();
        DataSource dataSource = result.getDataSource();
        Logger logger = this.options.getLogger();
        if (logger != null) {
            Logger.Level level = Logger.Level.Info;
            if (logger.getMinLevel().compareTo(level) <= 0) {
                logger.log("RealImageLoader", level, Utils_commonKt.getEmoji(dataSource) + " Successful (" + dataSource.name() + ") - " + request.getData(), null);
            }
        }
        if (target instanceof TransitionTarget) {
            SuccessResult successResult = result;
            Transition create = ImageRequestsKt.getTransitionFactory(successResult.getRequest()).create((TransitionTarget) target, successResult);
            if (!(create instanceof NoneTransition)) {
                eventListener.transitionStart(successResult.getRequest(), create);
                create.transition();
                eventListener.transitionEnd(successResult.getRequest(), create);
            }
            target.onSuccess(result.getImage());
        }
        eventListener.onSuccess(request, result);
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onSuccess(request, result);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0047, code lost:
    
        if (r8 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void onError(ErrorResult result, Target target, EventListener eventListener) {
        ImageRequest request = result.getRequest();
        Logger logger = this.options.getLogger();
        if (logger != null) {
            Logger.Level level = Logger.Level.Info;
            if (logger.getMinLevel().compareTo(level) <= 0) {
                logger.log("RealImageLoader", level, "🚨 Failed - " + request.getData() + " - " + result.getThrowable(), null);
            }
        }
        if (target instanceof TransitionTarget) {
            ErrorResult errorResult = result;
            Transition create = ImageRequestsKt.getTransitionFactory(errorResult.getRequest()).create((TransitionTarget) target, errorResult);
            if (!(create instanceof NoneTransition)) {
                eventListener.transitionStart(errorResult.getRequest(), create);
                create.transition();
                eventListener.transitionEnd(errorResult.getRequest(), create);
            }
            target.onError(result.getImage());
        }
        eventListener.onError(request, result);
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onError(request, result);
        }
    }

    private final void onCancel(ImageRequest request, EventListener eventListener) {
        Logger logger = this.options.getLogger();
        if (logger != null) {
            Logger.Level level = Logger.Level.Info;
            if (logger.getMinLevel().compareTo(level) <= 0) {
                logger.log("RealImageLoader", level, "🏗 Cancelled - " + request.getData(), null);
            }
        }
        eventListener.onCancel(request);
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onCancel(request);
        }
    }

    /* compiled from: RealImageLoader.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\n\u0010\u0002\u001a\u00060\u0004j\u0002`\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\"\u001a\u00060\u0004j\u0002`\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bHÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bHÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003J\t\u0010'\u001a\u00020\u000fHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0011HÆ\u0003Jj\u0010)\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0004j\u0002`\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u0017\u0010\u0002\u001a\u00060\u0004j\u0002`\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00062"}, d2 = {"Lcoil3/RealImageLoader$Options;", "", "application", "Lcoil3/PlatformContext;", "Landroid/content/Context;", "defaults", "Lcoil3/request/ImageRequest$Defaults;", "memoryCacheLazy", "Lkotlin/Lazy;", "Lcoil3/memory/MemoryCache;", "diskCacheLazy", "Lcoil3/disk/DiskCache;", "eventListenerFactory", "Lcoil3/EventListener$Factory;", "componentRegistry", "Lcoil3/ComponentRegistry;", "logger", "Lcoil3/util/Logger;", "<init>", "(Landroid/content/Context;Lcoil3/request/ImageRequest$Defaults;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil3/EventListener$Factory;Lcoil3/ComponentRegistry;Lcoil3/util/Logger;)V", "getApplication", "()Landroid/content/Context;", "Landroid/content/Context;", "getDefaults", "()Lcoil3/request/ImageRequest$Defaults;", "getMemoryCacheLazy", "()Lkotlin/Lazy;", "getDiskCacheLazy", "getEventListenerFactory", "()Lcoil3/EventListener$Factory;", "getComponentRegistry", "()Lcoil3/ComponentRegistry;", "getLogger", "()Lcoil3/util/Logger;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Landroid/content/Context;Lcoil3/request/ImageRequest$Defaults;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil3/EventListener$Factory;Lcoil3/ComponentRegistry;Lcoil3/util/Logger;)Lcoil3/RealImageLoader$Options;", "equals", "", "other", "hashCode", "", "toString", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final /* data */ class Options {
        private final Context application;
        private final ComponentRegistry componentRegistry;
        private final ImageRequest.Defaults defaults;
        private final Lazy<DiskCache> diskCacheLazy;
        private final EventListener.Factory eventListenerFactory;
        private final Logger logger;
        private final Lazy<MemoryCache> memoryCacheLazy;

        public static /* synthetic */ Options copy$default(Options options, Context context, ImageRequest.Defaults defaults, Lazy lazy, Lazy lazy2, EventListener.Factory factory, ComponentRegistry componentRegistry, Logger logger, int i, Object obj) {
            if ((i & 1) != 0) {
                context = options.application;
            }
            if ((i & 2) != 0) {
                defaults = options.defaults;
            }
            ImageRequest.Defaults defaults2 = defaults;
            if ((i & 4) != 0) {
                lazy = options.memoryCacheLazy;
            }
            Lazy lazy3 = lazy;
            if ((i & 8) != 0) {
                lazy2 = options.diskCacheLazy;
            }
            Lazy lazy4 = lazy2;
            if ((i & 16) != 0) {
                factory = options.eventListenerFactory;
            }
            EventListener.Factory factory2 = factory;
            if ((i & 32) != 0) {
                componentRegistry = options.componentRegistry;
            }
            ComponentRegistry componentRegistry2 = componentRegistry;
            if ((i & 64) != 0) {
                logger = options.logger;
            }
            return options.copy(context, defaults2, lazy3, lazy4, factory2, componentRegistry2, logger);
        }

        /* renamed from: component1, reason: from getter */
        public final Context getApplication() {
            return this.application;
        }

        /* renamed from: component2, reason: from getter */
        public final ImageRequest.Defaults getDefaults() {
            return this.defaults;
        }

        public final Lazy<MemoryCache> component3() {
            return this.memoryCacheLazy;
        }

        public final Lazy<DiskCache> component4() {
            return this.diskCacheLazy;
        }

        /* renamed from: component5, reason: from getter */
        public final EventListener.Factory getEventListenerFactory() {
            return this.eventListenerFactory;
        }

        /* renamed from: component6, reason: from getter */
        public final ComponentRegistry getComponentRegistry() {
            return this.componentRegistry;
        }

        /* renamed from: component7, reason: from getter */
        public final Logger getLogger() {
            return this.logger;
        }

        public final Options copy(Context application, ImageRequest.Defaults defaults, Lazy<? extends MemoryCache> memoryCacheLazy, Lazy<? extends DiskCache> diskCacheLazy, EventListener.Factory eventListenerFactory, ComponentRegistry componentRegistry, Logger logger) {
            return new Options(application, defaults, memoryCacheLazy, diskCacheLazy, eventListenerFactory, componentRegistry, logger);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Options)) {
                return false;
            }
            Options options = (Options) other;
            return Intrinsics.areEqual(this.application, options.application) && Intrinsics.areEqual(this.defaults, options.defaults) && Intrinsics.areEqual(this.memoryCacheLazy, options.memoryCacheLazy) && Intrinsics.areEqual(this.diskCacheLazy, options.diskCacheLazy) && Intrinsics.areEqual(this.eventListenerFactory, options.eventListenerFactory) && Intrinsics.areEqual(this.componentRegistry, options.componentRegistry) && Intrinsics.areEqual(this.logger, options.logger);
        }

        public int hashCode() {
            int hashCode = ((((((((((this.application.hashCode() * 31) + this.defaults.hashCode()) * 31) + this.memoryCacheLazy.hashCode()) * 31) + this.diskCacheLazy.hashCode()) * 31) + this.eventListenerFactory.hashCode()) * 31) + this.componentRegistry.hashCode()) * 31;
            Logger logger = this.logger;
            return hashCode + (logger == null ? 0 : logger.hashCode());
        }

        public String toString() {
            return "Options(application=" + this.application + ", defaults=" + this.defaults + ", memoryCacheLazy=" + this.memoryCacheLazy + ", diskCacheLazy=" + this.diskCacheLazy + ", eventListenerFactory=" + this.eventListenerFactory + ", componentRegistry=" + this.componentRegistry + ", logger=" + this.logger + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Options(Context context, ImageRequest.Defaults defaults, Lazy<? extends MemoryCache> lazy, Lazy<? extends DiskCache> lazy2, EventListener.Factory factory, ComponentRegistry componentRegistry, Logger logger) {
            this.application = context;
            this.defaults = defaults;
            this.memoryCacheLazy = lazy;
            this.diskCacheLazy = lazy2;
            this.eventListenerFactory = factory;
            this.componentRegistry = componentRegistry;
            this.logger = logger;
        }

        public final Context getApplication() {
            return this.application;
        }

        public final ImageRequest.Defaults getDefaults() {
            return this.defaults;
        }

        public final Lazy<MemoryCache> getMemoryCacheLazy() {
            return this.memoryCacheLazy;
        }

        public final Lazy<DiskCache> getDiskCacheLazy() {
            return this.diskCacheLazy;
        }

        public final EventListener.Factory getEventListenerFactory() {
            return this.eventListenerFactory;
        }

        public final ComponentRegistry getComponentRegistry() {
            return this.componentRegistry;
        }

        public final Logger getLogger() {
            return this.logger;
        }
    }
}
