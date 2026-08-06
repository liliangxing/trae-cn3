package com.bytedance.timonbase;

import java.util.Map;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimonTokenStack.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J$\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/timonbase/TimonTokenStack;", "", "()V", "threadLocal", "Ljava/lang/ThreadLocal;", "Ljava/util/Stack;", "Lcom/bytedance/timonbase/TimonTokenStack$TokenItem;", "currentToken", "pop", "", "token", "", "push", "extras", "", "TokenItem", "timonfoundation_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TimonTokenStack {
    public static final TimonTokenStack INSTANCE = new TimonTokenStack();
    private static final ThreadLocal<Stack<TokenItem>> threadLocal = new ThreadLocal<>();

    private TimonTokenStack() {
    }

    @JvmStatic
    public static final void push(String token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        push(token, MapsKt.emptyMap());
    }

    @JvmStatic
    public static final void push(String token, Map<String, String> extras) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        Intrinsics.checkParameterIsNotNull(extras, "extras");
        ThreadLocal<Stack<TokenItem>> threadLocal2 = threadLocal;
        Stack<TokenItem> stack = threadLocal2.get();
        if (stack == null) {
            stack = new Stack<>();
            threadLocal2.set(stack);
        }
        stack.push(new TokenItem(token, extras));
    }

    @JvmStatic
    public static final void pop(String token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        Stack<TokenItem> stack = threadLocal.get();
        if (stack != null) {
            stack.pop();
        }
    }

    public final TokenItem currentToken() {
        Stack<TokenItem> stack = threadLocal.get();
        if (stack == null || stack.empty()) {
            return null;
        }
        return stack.peek();
    }

    /* compiled from: TimonTokenStack.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J)\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/timonbase/TimonTokenStack$TokenItem;", "", "value", "", "extras", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getExtras", "()Ljava/util/Map;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "timonfoundation_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class TokenItem {
        private final Map<String, String> extras;
        private final String value;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TokenItem copy$default(TokenItem tokenItem, String str, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tokenItem.value;
            }
            if ((i & 2) != 0) {
                map = tokenItem.extras;
            }
            return tokenItem.copy(str, map);
        }

        /* renamed from: component1, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final Map<String, String> component2() {
            return this.extras;
        }

        public final TokenItem copy(String value, Map<String, String> extras) {
            Intrinsics.checkParameterIsNotNull(value, "value");
            Intrinsics.checkParameterIsNotNull(extras, "extras");
            return new TokenItem(value, extras);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TokenItem)) {
                return false;
            }
            TokenItem tokenItem = (TokenItem) other;
            return Intrinsics.areEqual(this.value, tokenItem.value) && Intrinsics.areEqual(this.extras, tokenItem.extras);
        }

        public int hashCode() {
            String str = this.value;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Map<String, String> map = this.extras;
            return hashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            return "TokenItem(value=" + this.value + ", extras=" + this.extras + ")";
        }

        public TokenItem(String str, Map<String, String> map) {
            Intrinsics.checkParameterIsNotNull(str, "value");
            Intrinsics.checkParameterIsNotNull(map, "extras");
            this.value = str;
            this.extras = map;
        }

        public final String getValue() {
            return this.value;
        }

        public final Map<String, String> getExtras() {
            return this.extras;
        }
    }
}
