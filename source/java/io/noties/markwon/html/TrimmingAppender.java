package io.noties.markwon.html;

/* loaded from: classes6.dex */
abstract class TrimmingAppender {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <T extends Appendable & CharSequence> void append(T t, String str);

    TrimmingAppender() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TrimmingAppender create() {
        return new Impl();
    }

    /* loaded from: classes6.dex */
    static class Impl extends TrimmingAppender {
        Impl() {
        }

        @Override // io.noties.markwon.html.TrimmingAppender
        <T extends Appendable & CharSequence> void append(T t, String str) {
            int length;
            T t2 = t;
            int length2 = t2.length();
            int length3 = str.length();
            boolean z = false;
            for (int i = 0; i < length3; i++) {
                char charAt = str.charAt(i);
                if (Character.isWhitespace(charAt)) {
                    z = true;
                } else {
                    if (z && (length = t2.length()) > 0 && !Character.isWhitespace(t2.charAt(length - 1))) {
                        AppendableUtils.appendQuietly((Appendable) t, ' ');
                    }
                    AppendableUtils.appendQuietly(t, charAt);
                    z = false;
                }
            }
            if (!z || length2 >= t2.length()) {
                return;
            }
            AppendableUtils.appendQuietly((Appendable) t, ' ');
        }
    }
}
