package com.bytedance.webx.core;

import com.bytedance.webx.ExtensionParam;
import java.util.Stack;

/* loaded from: classes6.dex */
public class ThreadSession {
    public static final ThreadLocal<ExtensionParamStack> sExtensionParamStack = new ThreadLocal<ExtensionParamStack>() { // from class: com.bytedance.webx.core.ThreadSession.1
        private ExtensionParamStack mExtensionParamStack = new ExtensionParamStack();

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public ExtensionParamStack initialValue() {
            return this.mExtensionParamStack;
        }
    };
    public static final ThreadLocal<ExtensionExtendStack> sExtensionExtendStack = new ThreadLocal<ExtensionExtendStack>() { // from class: com.bytedance.webx.core.ThreadSession.2
        private ExtensionExtendStack mExtensionStack = new ExtensionExtendStack();

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public ExtensionExtendStack initialValue() {
            return this.mExtensionStack;
        }
    };

    /* loaded from: classes6.dex */
    public static class ExtensionParamStack {
        private Stack<ExtensionParam[]> mStack = new Stack<>();

        public void push(ExtensionParam[] extensionParamArr) {
            this.mStack.push(extensionParamArr);
        }

        public void pop() {
            this.mStack.pop();
        }

        public ExtensionParam[] peek() {
            if (this.mStack.empty()) {
                return null;
            }
            return this.mStack.peek();
        }
    }

    /* loaded from: classes6.dex */
    public static class ExtensionExtendStack {
        private Stack mStack = new Stack();

        public void push() {
            this.mStack.push(null);
        }

        public void pop() {
            this.mStack.pop();
        }
    }
}
