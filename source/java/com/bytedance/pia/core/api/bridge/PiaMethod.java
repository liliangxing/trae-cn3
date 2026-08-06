package com.bytedance.pia.core.api.bridge;

import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IFactory;

/* loaded from: classes4.dex */
public class PiaMethod<Params, Result> {
    public static final int STATUS_FAILED = 0;
    public static final int STATUS_INVALID_PARAMS = -3;
    public static final int STATUS_INVALID_RESULT = -4;
    public static final int STATUS_SETTING_DISABLE = -6;
    public static final int STATUS_SUCCESS = 1;
    public static final int STATUS_UNAUTHORIZED = -1;
    public static final int STATUS_UNREGISTERED = -2;
    private final IFactory<ICall<Params, Result>> callFactory;
    private final String name;
    private final Scope scope;

    /* loaded from: classes4.dex */
    public interface ICall<Params, Result> {
        void invoke(IPiaBridge iPiaBridge, Params params, IConsumer<Result> iConsumer, IConsumer<Error> iConsumer2);
    }

    /* loaded from: classes4.dex */
    public enum Scope {
        Worker,
        Render,
        All
    }

    public PiaMethod(String str, IFactory<ICall<Params, Result>> iFactory) {
        this(str, Scope.Worker, iFactory);
    }

    public PiaMethod(String str, Scope scope, IFactory<ICall<Params, Result>> iFactory) {
        this.name = str;
        this.scope = scope;
        this.callFactory = iFactory;
    }

    public String getName() {
        return this.name;
    }

    public Scope getScope() {
        return this.scope;
    }

    public ICall<Params, Result> makeCall(Object obj) {
        return this.callFactory.create(obj);
    }

    /* loaded from: classes4.dex */
    public static class Error extends RuntimeException {
        private final int code;

        public Error() {
            this("");
        }

        public Error(int i) {
            this(i, "");
        }

        public Error(String str) {
            this(0, str);
        }

        public Error(int i, String str) {
            super(str);
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }
    }

    /* loaded from: classes4.dex */
    public static class UnauthorizedError extends Error {
        public UnauthorizedError() {
            this("");
        }

        public UnauthorizedError(String str) {
            super(-1, str);
        }
    }

    /* loaded from: classes4.dex */
    public static class UnregisteredError extends Error {
        public UnregisteredError() {
            this("");
        }

        public UnregisteredError(String str) {
            super(-2, str);
        }
    }

    /* loaded from: classes4.dex */
    public static class InvalidParamsError extends Error {
        public InvalidParamsError() {
            this("");
        }

        public InvalidParamsError(String str) {
            super(-3, str);
        }
    }

    /* loaded from: classes4.dex */
    public static class InvalidResultError extends Error {
        public InvalidResultError() {
            this("");
        }

        public InvalidResultError(String str) {
            super(-4, str);
        }
    }

    /* loaded from: classes4.dex */
    public static class SettingDisableError extends Error {
        public SettingDisableError() {
            super(-6, "Disable by settings.");
        }
    }
}
