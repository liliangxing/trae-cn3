package me.ele.lancet.base;

/* loaded from: classes8.dex */
public final class Origin {
    public static final String CLASS_NAME = Origin.class.getName().replace('.', '/');

    public static void callVoid() {
    }

    public static <U extends Throwable> void callVoidThrowOne() throws Throwable {
    }

    public static <U extends Throwable, V extends Throwable, W extends Throwable> void callVoidThrowThree() throws Throwable, Throwable, Throwable {
    }

    public static <U extends Throwable, V extends Throwable> void callVoidThrowTwo() throws Throwable, Throwable {
    }

    private Origin() {
        throw new AssertionError();
    }

    public static Object call() {
        return new Object();
    }

    public static <V extends Throwable> Object callThrowOne() throws Throwable {
        return new Object();
    }

    public static <V extends Throwable, U extends Throwable> Object callThrowTwo() throws Throwable, Throwable {
        return new Object();
    }

    public static <V extends Throwable, U extends Throwable, W extends Throwable> Object callThrowThree() throws Throwable, Throwable, Throwable {
        return new Object();
    }
}
