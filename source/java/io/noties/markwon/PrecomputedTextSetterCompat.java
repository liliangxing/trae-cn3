package io.noties.markwon;

import android.os.Build;
import android.text.Spanned;
import android.util.Log;
import android.widget.TextView;
import androidx.core.text.PrecomputedTextCompat;
import io.noties.markwon.Markwon;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class PrecomputedTextSetterCompat implements Markwon.TextSetter {
    private final Executor executor;

    public static PrecomputedTextSetterCompat create(Executor executor) {
        return new PrecomputedTextSetterCompat(executor);
    }

    PrecomputedTextSetterCompat(Executor executor) {
        this.executor = executor;
    }

    @Override // io.noties.markwon.Markwon.TextSetter
    public void setText(TextView textView, final Spanned spanned, final TextView.BufferType bufferType, final Runnable runnable) {
        final WeakReference weakReference = new WeakReference(textView);
        this.executor.execute(new Runnable() { // from class: io.noties.markwon.PrecomputedTextSetterCompat.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    PrecomputedTextCompat precomputedText = PrecomputedTextSetterCompat.precomputedText((TextView) weakReference.get(), spanned);
                    if (precomputedText != null) {
                        PrecomputedTextSetterCompat.applyText((TextView) weakReference.get(), precomputedText, bufferType, runnable);
                    }
                } catch (Throwable th) {
                    Log.e("PrecomputdTxtSetterCmpt", "Exception during pre-computing text", th);
                    PrecomputedTextSetterCompat.applyText((TextView) weakReference.get(), spanned, bufferType, runnable);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PrecomputedTextCompat precomputedText(TextView textView, Spanned spanned) {
        PrecomputedTextCompat.Params build;
        if (textView == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            build = new PrecomputedTextCompat.Params(textView.getTextMetricsParams());
        } else {
            PrecomputedTextCompat.Params.Builder builder = new PrecomputedTextCompat.Params.Builder(textView.getPaint());
            builder.setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            build = builder.build();
        }
        return PrecomputedTextCompat.create(spanned, build);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void applyText(final TextView textView, final Spanned spanned, final TextView.BufferType bufferType, final Runnable runnable) {
        if (textView != null) {
            textView.post(new Runnable() { // from class: io.noties.markwon.PrecomputedTextSetterCompat.2
                @Override // java.lang.Runnable
                public void run() {
                    textView.setText(spanned, bufferType);
                    runnable.run();
                }
            });
        }
    }
}
