package com.bytedance.sliver;

import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Stack;

/* loaded from: classes5.dex */
class SliverLagStack {
    private static final Stack<SliverLagStack> stacks = new Stack<>();
    private long end;
    private String line;
    private long start;
    private final LinkedList<SliverLagStack> childStack = new LinkedList<>();
    private BufferedWriter fileWriter = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SliverLagStack() {
        stacks.add(this);
    }

    SliverLagStack(long j, String str) {
        this.line = str;
        this.start = j;
    }

    public void onEvent(String str) {
        if (str.startsWith("#")) {
            BufferedWriter bufferedWriter = this.fileWriter;
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.write(str);
                    this.fileWriter.newLine();
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            return;
        }
        long parseLong = Long.parseLong(str.split(Constants.COLON_SEPARATOR)[0]);
        if (str.endsWith(":POP")) {
            onPop(parseLong);
        } else {
            onPush(parseLong, str);
        }
    }

    public void onFinish(long j) {
        while (true) {
            Stack<SliverLagStack> stack = stacks;
            if (stack.peek() == this) {
                break;
            }
            stack.pop().setEnd(j);
            BufferedWriter bufferedWriter = this.fileWriter;
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.write(j + ":POP");
                    this.fileWriter.newLine();
                } catch (Throwable unused) {
                }
            }
        }
        BufferedWriter bufferedWriter2 = this.fileWriter;
        if (bufferedWriter2 != null) {
            try {
                bufferedWriter2.close();
            } catch (Throwable unused2) {
            }
        }
    }

    private void addChildStack(SliverLagStack sliverLagStack) {
        this.childStack.addLast(sliverLagStack);
    }

    private void onPush(long j, String str) {
        SliverLagStack sliverLagStack = new SliverLagStack(j, str);
        Stack<SliverLagStack> stack = stacks;
        stack.peek().addChildStack(sliverLagStack);
        stack.push(sliverLagStack);
        BufferedWriter bufferedWriter = this.fileWriter;
        if (bufferedWriter != null) {
            try {
                bufferedWriter.write(str);
                this.fileWriter.newLine();
            } catch (Throwable unused) {
            }
        }
    }

    private void onPop(long j) {
        Stack<SliverLagStack> stack = stacks;
        if (stack.peek() == this) {
            return;
        }
        stack.pop().setEnd(j);
        BufferedWriter bufferedWriter = this.fileWriter;
        if (bufferedWriter != null) {
            try {
                bufferedWriter.write(j + ":POP");
                this.fileWriter.newLine();
            } catch (Throwable unused) {
            }
        }
    }

    public long getCost() {
        return this.end - this.start;
    }

    public void setEnd(long j) {
        this.end = j;
    }

    public String getLine() {
        return this.line;
    }

    public LinkedList<SliverLagStack> getChildStack() {
        return this.childStack;
    }

    public void setPrintFile(File file) {
        try {
            this.fileWriter = new BufferedWriter(new FileWriter(file));
        } catch (Throwable unused) {
        }
    }
}
