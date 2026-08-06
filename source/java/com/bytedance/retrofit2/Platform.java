package com.bytedance.retrofit2;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.Converter;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import retrofit2.Retrofit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class Platform {
    private static final Platform PLATFORM = findPlatform();
    private static final boolean SQUARE_RETROFIT_EXISTS = findSquareRetrofit();

    /* JADX INFO: Access modifiers changed from: package-private */
    public int defaultCallAdapterFactoriesSize() {
        return 1;
    }

    @Nullable
    public Executor defaultCallbackExecutor() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int defaultConverterFactoriesSize() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isDefaultMethod(Method method) {
        return false;
    }

    Platform() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Platform get() {
        return PLATFORM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean squareRetrofitExists() {
        return SQUARE_RETROFIT_EXISTS;
    }

    private static Platform findPlatform() {
        try {
            Class.forName("android.os.Build");
            return new Android();
        } catch (ClassNotFoundException unused) {
            return new Platform();
        }
    }

    private static boolean findSquareRetrofit() {
        try {
            new Retrofit.Builder();
            return true;
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<? extends CallAdapter.Factory> defaultCallAdapterFactories(@Nullable Executor executor) {
        if (executor != null) {
            return Collections.singletonList(new ExecutorCallAdapterFactory(executor));
        }
        return Collections.singletonList(DefaultCallAdapterFactory.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<? extends Converter.Factory> defaultConverterFactories() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Android extends Platform {
        @Override // com.bytedance.retrofit2.Platform
        int defaultCallAdapterFactoriesSize() {
            return 1;
        }

        @Override // com.bytedance.retrofit2.Platform
        int defaultConverterFactoriesSize() {
            return 0;
        }

        Android() {
        }

        @Override // com.bytedance.retrofit2.Platform
        boolean isDefaultMethod(Method method) {
            return method.isDefault();
        }

        @Override // com.bytedance.retrofit2.Platform
        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        @Override // com.bytedance.retrofit2.Platform
        List<? extends CallAdapter.Factory> defaultCallAdapterFactories(@Nullable Executor executor) {
            if (executor == null) {
                throw new AssertionError();
            }
            return Collections.singletonList(new ExecutorCallAdapterFactory(executor));
        }

        @Override // com.bytedance.retrofit2.Platform
        List<? extends Converter.Factory> defaultConverterFactories() {
            return Collections.emptyList();
        }

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        static class MainThreadExecutor implements Executor {
            private final Handler handler = new Handler(Looper.getMainLooper());

            MainThreadExecutor() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.handler.post(runnable);
            }
        }
    }
}
