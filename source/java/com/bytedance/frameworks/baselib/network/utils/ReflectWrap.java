package com.bytedance.frameworks.baselib.network.utils;

import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.retrofit2.RetrofitMetrics;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class ReflectWrap {
    private static volatile boolean useTTReflect;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface ReflectAdapter {
        ReflectAdapter call(String str) throws TTReflectIOException;

        ReflectAdapter call(String str, Class<?>[] clsArr, Object... objArr) throws TTReflectIOException;

        <T> T get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class TTReflectAdapter implements ReflectAdapter {
        private final RetrofitMetrics metrics;
        private TTReflect ttReflect;

        TTReflectAdapter(TTReflect tTReflect, RetrofitMetrics retrofitMetrics) {
            this.ttReflect = tTReflect;
            this.metrics = retrofitMetrics;
        }

        @Override // com.bytedance.frameworks.baselib.network.utils.ReflectWrap.ReflectAdapter
        public ReflectAdapter call(String str) throws TTReflectIOException {
            long nanoTime = System.nanoTime();
            try {
                try {
                    this.ttReflect = this.ttReflect.call(str);
                    return this;
                } catch (Exception e) {
                    throw new TTReflectIOException(e.getMessage(), e.getCause());
                }
            } finally {
                RetrofitMetrics retrofitMetrics = this.metrics;
                if (retrofitMetrics != null) {
                    if (retrofitMetrics.networklib.innerSpan.reflection == -1) {
                        this.metrics.networklib.innerSpan.reflection = 0L;
                    }
                    this.metrics.networklib.innerSpan.reflection += System.nanoTime() - nanoTime;
                }
            }
        }

        @Override // com.bytedance.frameworks.baselib.network.utils.ReflectWrap.ReflectAdapter
        public ReflectAdapter call(String str, Class<?>[] clsArr, Object... objArr) throws TTReflectIOException {
            long nanoTime = System.nanoTime();
            try {
                try {
                    this.ttReflect = this.ttReflect.call(str, clsArr, objArr);
                    return this;
                } catch (Exception e) {
                    throw new TTReflectIOException(e.getMessage(), e.getCause());
                }
            } finally {
                RetrofitMetrics retrofitMetrics = this.metrics;
                if (retrofitMetrics != null) {
                    if (retrofitMetrics.networklib.innerSpan.reflection == -1) {
                        this.metrics.networklib.innerSpan.reflection = 0L;
                    }
                    this.metrics.networklib.innerSpan.reflection += System.nanoTime() - nanoTime;
                }
            }
        }

        @Override // com.bytedance.frameworks.baselib.network.utils.ReflectWrap.ReflectAdapter
        public <T> T get() {
            return (T) this.ttReflect.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class DefaultReflectAdapter implements ReflectAdapter {
        private final RetrofitMetrics metrics;
        private Reflect reflect;

        DefaultReflectAdapter(Reflect reflect, RetrofitMetrics retrofitMetrics) {
            this.reflect = reflect;
            this.metrics = retrofitMetrics;
        }

        @Override // com.bytedance.frameworks.baselib.network.utils.ReflectWrap.ReflectAdapter
        public ReflectAdapter call(String str) throws TTReflectIOException {
            long nanoTime = System.nanoTime();
            try {
                try {
                    this.reflect = this.reflect.call(str);
                    return this;
                } catch (Exception e) {
                    throw new TTReflectIOException(e.getMessage(), e.getCause());
                }
            } finally {
                RetrofitMetrics retrofitMetrics = this.metrics;
                if (retrofitMetrics != null) {
                    if (retrofitMetrics.networklib.innerSpan.reflection == -1) {
                        this.metrics.networklib.innerSpan.reflection = 0L;
                    }
                    this.metrics.networklib.innerSpan.reflection += System.nanoTime() - nanoTime;
                }
            }
        }

        @Override // com.bytedance.frameworks.baselib.network.utils.ReflectWrap.ReflectAdapter
        public ReflectAdapter call(String str, Class<?>[] clsArr, Object... objArr) throws TTReflectIOException {
            long nanoTime = System.nanoTime();
            try {
                try {
                    this.reflect = this.reflect.call(str, clsArr, objArr);
                    return this;
                } catch (Exception e) {
                    throw new TTReflectIOException(e.getMessage(), e.getCause());
                }
            } finally {
                RetrofitMetrics retrofitMetrics = this.metrics;
                if (retrofitMetrics != null) {
                    if (retrofitMetrics.networklib.innerSpan.reflection == -1) {
                        this.metrics.networklib.innerSpan.reflection = 0L;
                    }
                    this.metrics.networklib.innerSpan.reflection += System.nanoTime() - nanoTime;
                }
            }
        }

        @Override // com.bytedance.frameworks.baselib.network.utils.ReflectWrap.ReflectAdapter
        public <T> T get() {
            return (T) this.reflect.get();
        }
    }

    public static void setUseTTReflect(boolean z) {
        useTTReflect = z;
    }

    /* renamed from: on */
    public static ReflectAdapter m1298on(String str) throws TTReflectIOException {
        try {
            return m1299on(str, (RetrofitMetrics) null);
        } catch (Exception e) {
            throw new TTReflectIOException(e.getMessage(), e.getCause());
        }
    }

    /* renamed from: on */
    public static ReflectAdapter m1299on(String str, RetrofitMetrics retrofitMetrics) throws TTReflectIOException {
        try {
            if (useTTReflect) {
                return new TTReflectAdapter(TTReflect.m1302on(str), retrofitMetrics);
            }
            return new DefaultReflectAdapter(Reflect.on(str), retrofitMetrics);
        } catch (Exception e) {
            throw new TTReflectIOException(e.getMessage(), e.getCause());
        }
    }

    /* renamed from: on */
    public static ReflectAdapter m1294on(Class<?> cls) throws TTReflectIOException {
        try {
            return m1295on(cls, (RetrofitMetrics) null);
        } catch (Exception e) {
            throw new TTReflectIOException(e.getMessage(), e.getCause());
        }
    }

    /* renamed from: on */
    public static ReflectAdapter m1295on(Class<?> cls, RetrofitMetrics retrofitMetrics) throws TTReflectIOException {
        try {
            if (useTTReflect) {
                return new TTReflectAdapter(TTReflect.m1300on(cls), retrofitMetrics);
            }
            return new DefaultReflectAdapter(Reflect.on(cls), retrofitMetrics);
        } catch (Exception e) {
            throw new TTReflectIOException(e.getMessage(), e.getCause());
        }
    }

    /* renamed from: on */
    public static ReflectAdapter m1296on(Object obj) throws TTReflectIOException {
        try {
            return m1297on(obj, (RetrofitMetrics) null);
        } catch (Exception e) {
            throw new TTReflectIOException(e.getMessage(), e.getCause());
        }
    }

    /* renamed from: on */
    public static ReflectAdapter m1297on(Object obj, RetrofitMetrics retrofitMetrics) throws TTReflectIOException {
        try {
            if (useTTReflect) {
                return new TTReflectAdapter(TTReflect.m1301on(obj), retrofitMetrics);
            }
            return new DefaultReflectAdapter(Reflect.on(obj), retrofitMetrics);
        } catch (Exception e) {
            throw new TTReflectIOException(e.getMessage(), e.getCause());
        }
    }
}
