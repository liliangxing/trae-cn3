package com.bytedance.ies.bullet.lynx;

import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxClientDelegateChain.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007JH\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\t0\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t0\u000fH\u0002JP\u0010\u0012\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\t0\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J8\u0010\u0014\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\t0\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t0\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/LynxClientDelegateChain;", "", "kitViewService", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "delegates", "", "Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "(Lcom/bytedance/ies/bullet/service/base/IKitViewService;Ljava/util/List;)V", "doLoadImage", "", "iterator", "", "input", "Lcom/bytedance/ies/bullet/lynx/LynxImageInfo;", "resolve", "Lkotlin/Function1;", "reject", "", "doOnReject", "throwable", "loadImage", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxClientDelegateChain {
    private final List<ILynxClientDelegate> delegates;
    private final IKitViewService kitViewService;

    /* JADX WARN: Multi-variable type inference failed */
    public LynxClientDelegateChain(IKitViewService iKitViewService, List<? extends ILynxClientDelegate> list) {
        Intrinsics.checkNotNullParameter(list, "delegates");
        this.kitViewService = iKitViewService;
        this.delegates = list;
    }

    public final void loadImage(LynxImageInfo input, Function1<Object, Unit> resolve, Function1<? super Throwable, Unit> reject) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        Intrinsics.checkNotNullParameter(reject, "reject");
        Iterator<ILynxClientDelegate> it = this.delegates.iterator();
        if (!it.hasNext()) {
            reject.invoke(new Throwable("None of ILynxClientDelegate processor for image " + input.getSrc()));
        } else {
            doLoadImage(it, input, resolve, reject);
        }
    }

    private final void doLoadImage(final Iterator<? extends ILynxClientDelegate> iterator, final LynxImageInfo input, final Function1<Object, Unit> resolve, final Function1<? super Throwable, Unit> reject) {
        try {
            iterator.next().loadImage(this.kitViewService, input.getContext(), input.getCacheKey(), input.getSrc(), input.getWidth(), input.getHeight(), input.getTransformer(), new Function2<Object, Throwable, Unit>() { // from class: com.bytedance.ies.bullet.lynx.LynxClientDelegateChain$doLoadImage$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke(obj, (Throwable) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(Object obj, Throwable th) {
                    if (obj != null) {
                        resolve.invoke(obj);
                        return;
                    }
                    LynxClientDelegateChain lynxClientDelegateChain = LynxClientDelegateChain.this;
                    Iterator<ILynxClientDelegate> it = iterator;
                    LynxImageInfo lynxImageInfo = input;
                    Function1<Object, Unit> function1 = resolve;
                    Function1<Throwable, Unit> function12 = reject;
                    if (th == null) {
                        th = new IllegalStateException("loadImage failed, Bitmap is null");
                    }
                    lynxClientDelegateChain.doOnReject(it, lynxImageInfo, function1, function12, th);
                }
            });
        } catch (Exception e) {
            doOnReject(iterator, input, resolve, reject, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnReject(Iterator<? extends ILynxClientDelegate> iterator, LynxImageInfo input, Function1<Object, Unit> resolve, Function1<? super Throwable, Unit> reject, Throwable throwable) {
        if (iterator.hasNext()) {
            doLoadImage(iterator, input, resolve, reject);
        } else {
            reject.invoke(throwable);
        }
    }
}
