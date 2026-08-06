package com.bytedance.vcloud.compose;

import com.bytedance.vcloud.strategy.IAppService;
import com.bytedance.vcloud.uniplayer.UniAVEngine;
import com.bytedance.vcloud.uniplayer.UniKitService;
import com.bytedance.vcloud.uniplayer.UniWindowBinder;
import com.bytedance.vcloud.uniplayer.WindowClientNative;
import com.ss.ttm.player.TTAVWindowClient;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniWindow.android.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/vcloud/compose/WindowClientImpl;", "Lcom/bytedance/vcloud/uniplayer/WindowClientNative;", "window", "Lcom/ss/ttm/player/TTAVWindowClient;", "(Lcom/ss/ttm/player/TTAVWindowClient;)V", "nativeWindow", "", "bind", "", "binder", "Lcom/bytedance/vcloud/uniplayer/UniWindowBinder;", "release", "Companion", "uniplayer-ui-trae_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class WindowClientImpl implements WindowClientNative {
    private long nativeWindow;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void bind(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long create(Object obj);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void free(long j);

    public WindowClientImpl(TTAVWindowClient tTAVWindowClient) {
        Intrinsics.checkNotNullParameter(tTAVWindowClient, "window");
        this.nativeWindow = INSTANCE.create(tTAVWindowClient);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniWindowClient
    public void bindEngine(UniAVEngine uniAVEngine) {
        WindowClientNative.DefaultImpls.bindEngine(this, uniAVEngine);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniWindowClient
    public void bind(UniWindowBinder binder) {
        Intrinsics.checkNotNullParameter(binder, "binder");
        long mNativePtr = binder.getMNativePtr();
        long j = this.nativeWindow;
        if (mNativePtr == 0 || j == 0) {
            return;
        }
        INSTANCE.bind(j, mNativePtr);
    }

    @Override // com.bytedance.vcloud.uniplayer.WindowClientNative
    public void release() {
        long j = this.nativeWindow;
        if (j != 0) {
            this.nativeWindow = 0L;
            INSTANCE.free(j);
        }
    }

    /* compiled from: UniWindow.android.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0083 J\u0011\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0001H\u0083 J\u0011\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0083 ¨\u0006\n"}, d2 = {"Lcom/bytedance/vcloud/compose/WindowClientImpl$Companion;", "", "()V", "unip_window_bind_engine", "", "window", "", IAppService.SOURCE_ENGINE, "unip_window_create", "unip_window_release", "uniplayer-ui-trae_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void bind(long j, long j2) {
            WindowClientImpl.bind(j, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long create(Object obj) {
            return WindowClientImpl.create(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void free(long j) {
            WindowClientImpl.free(j);
        }

        private Companion() {
        }
    }

    static {
        UniKitService.INSTANCE.hashCode();
    }
}
