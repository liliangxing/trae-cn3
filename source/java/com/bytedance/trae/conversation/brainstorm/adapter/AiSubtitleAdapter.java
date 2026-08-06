package com.bytedance.trae.conversation.brainstorm.adapter;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.adapter.AiSubtitleAdapter;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AiSubtitleAdapter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003 !\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0007J\u0006\u0010\u001d\u001a\u00020\u0015J&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0006H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006#"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;", "<init>", "()V", "lines", "", "Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;", "translateSpeed", "", "getTranslateSpeed", "()F", "setTranslateSpeed", "(F)V", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", NewTaskTracker.Param.POSITION, "getLastLine", "updateLastLineData", "line", "forceUpdateLastLine", "appendLine", "clearAll", "payloads", "", "SubtitleLine", "Companion", "LineViewHolder", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AiSubtitleAdapter extends RecyclerView.Adapter<LineViewHolder> {
    private static final String PAYLOAD_FORCE_UPDATE = "force_update";
    private final List<SubtitleLine> lines = new ArrayList();
    private float translateSpeed = 0.6f;

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((LineViewHolder) viewHolder, i, (List<Object>) list);
    }

    /* compiled from: AiSubtitleAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;", "", "id", "", "text", "", "isSpecial", "", "<init>", "(ILjava/lang/String;Z)V", "getId", "()I", "getText", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class SubtitleLine {
        private final int id;
        private final boolean isSpecial;
        private final String text;

        public static /* synthetic */ SubtitleLine copy$default(SubtitleLine subtitleLine, int i, String str, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = subtitleLine.id;
            }
            if ((i2 & 2) != 0) {
                str = subtitleLine.text;
            }
            if ((i2 & 4) != 0) {
                z = subtitleLine.isSpecial;
            }
            return subtitleLine.copy(i, str, z);
        }

        /* renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsSpecial() {
            return this.isSpecial;
        }

        public final SubtitleLine copy(int id, String text, boolean isSpecial) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new SubtitleLine(id, text, isSpecial);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubtitleLine)) {
                return false;
            }
            SubtitleLine subtitleLine = (SubtitleLine) other;
            return this.id == subtitleLine.id && Intrinsics.areEqual(this.text, subtitleLine.text) && this.isSpecial == subtitleLine.isSpecial;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.id) * 31) + this.text.hashCode()) * 31) + Boolean.hashCode(this.isSpecial);
        }

        public String toString() {
            return "SubtitleLine(id=" + this.id + ", text=" + this.text + ", isSpecial=" + this.isSpecial + ')';
        }

        public SubtitleLine(int i, String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "text");
            this.id = i;
            this.text = str;
            this.isSpecial = z;
        }

        public /* synthetic */ SubtitleLine(int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, (i2 & 4) != 0 ? false : z);
        }

        public final int getId() {
            return this.id;
        }

        public final String getText() {
            return this.text;
        }

        public final boolean isSpecial() {
            return this.isSpecial;
        }
    }

    public final float getTranslateSpeed() {
        return this.translateSpeed;
    }

    public final void setTranslateSpeed(float f) {
        this.translateSpeed = f;
    }

    public int getItemCount() {
        return this.lines.size();
    }

    public LineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(C0637R.layout.trae_item_brainstorm_ai_subtitle, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new LineViewHolder(inflate, this.translateSpeed);
    }

    public void onBindViewHolder(LineViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bindImmediate(this.lines.get(position));
    }

    public final SubtitleLine getLastLine() {
        return (SubtitleLine) CollectionsKt.lastOrNull(this.lines);
    }

    public final void updateLastLineData(SubtitleLine line) {
        Intrinsics.checkNotNullParameter(line, "line");
        if (!this.lines.isEmpty()) {
            List<SubtitleLine> list = this.lines;
            list.set(CollectionsKt.getLastIndex(list), line);
        }
    }

    public final void forceUpdateLastLine(SubtitleLine line) {
        Intrinsics.checkNotNullParameter(line, "line");
        if (!this.lines.isEmpty()) {
            List<SubtitleLine> list = this.lines;
            list.set(CollectionsKt.getLastIndex(list), line);
            notifyItemChanged(CollectionsKt.getLastIndex(this.lines), PAYLOAD_FORCE_UPDATE);
        }
    }

    public final void appendLine(SubtitleLine line) {
        Intrinsics.checkNotNullParameter(line, "line");
        this.lines.add(line);
        notifyItemInserted(CollectionsKt.getLastIndex(this.lines));
    }

    public final void clearAll() {
        int itemCount = getItemCount();
        this.lines.clear();
        notifyItemRangeRemoved(0, itemCount);
    }

    public void onBindViewHolder(LineViewHolder holder, int position, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.contains(PAYLOAD_FORCE_UPDATE)) {
            holder.bindImmediate(this.lines.get(position));
        } else {
            super.onBindViewHolder(holder, position, payloads);
        }
    }

    /* compiled from: AiSubtitleAdapter.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u000fH\u0002J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u000fJ\u0006\u0010\"\u001a\u00020\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0016\u001a\n \u0018*\u0004\u0018\u00010\u00170\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006#"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "translateSpeed", "", "<init>", "(Landroid/view/View;F)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "measurePaint", "Landroid/graphics/Paint;", "value", "", "displayedText", "getDisplayedText", "()Ljava/lang/String;", "targetTranslationX", "currentTranslationX", "animStartTranslationX", "translateAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "Landroid/animation/ValueAnimator;", "calcCenterTranslationX", "text", "bindImmediate", "", "line", "Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;", "animateAppend", "newFullText", "cancelAnimation", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class LineViewHolder extends RecyclerView.ViewHolder {
        private float animStartTranslationX;
        private float currentTranslationX;
        private String displayedText;
        private final Paint measurePaint;
        private float targetTranslationX;
        private final TextView textView;
        private final ValueAnimator translateAnimator;
        private final float translateSpeed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LineViewHolder(View view, float f) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.translateSpeed = f;
            View findViewById = view.findViewById(C0637R.id.tv_ai_subtitle_line);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.textView = (TextView) findViewById;
            Paint paint = new Paint();
            paint.setTextSize(TypedValue.applyDimension(2, 17.0f, view.getContext().getResources().getDisplayMetrics()));
            paint.setLetterSpacing(-0.014f);
            this.measurePaint = paint;
            this.displayedText = "";
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, -20000.0f);
            ofFloat.setDuration(20000.0f / f);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.trae.conversation.brainstorm.adapter.AiSubtitleAdapter$LineViewHolder$$ExternalSyntheticLambda1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AiSubtitleAdapter.LineViewHolder.translateAnimator$lambda$2$lambda$1(AiSubtitleAdapter.LineViewHolder.this, valueAnimator);
                }
            });
            this.translateAnimator = ofFloat;
        }

        public final TextView getTextView() {
            return this.textView;
        }

        public final String getDisplayedText() {
            return this.displayedText;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void translateAnimator$lambda$2$lambda$1(LineViewHolder lineViewHolder, ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(valueAnimator, "animator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = lineViewHolder.animStartTranslationX + ((Float) animatedValue).floatValue();
            if (floatValue <= lineViewHolder.targetTranslationX) {
                valueAnimator.pause();
                float f = lineViewHolder.targetTranslationX;
                lineViewHolder.currentTranslationX = f;
                lineViewHolder.textView.setTranslationX(f);
                return;
            }
            lineViewHolder.currentTranslationX = floatValue;
            lineViewHolder.textView.setTranslationX(floatValue);
        }

        private final float calcCenterTranslationX(String text) {
            float width = this.itemView.getWidth();
            if (width <= 0.0f) {
                return 0.0f;
            }
            return (width - this.measurePaint.measureText(text)) / 2.0f;
        }

        public final void bindImmediate(final SubtitleLine line) {
            int i;
            Intrinsics.checkNotNullParameter(line, "line");
            this.translateAnimator.cancel();
            if (line.isSpecial()) {
                i = C0637R.color.trae_ai_subtitle_text_special;
            } else {
                i = C0637R.color.trae_ai_subtitle_text_normal;
            }
            TextView textView = this.textView;
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), i));
            this.textView.setText(line.getText());
            this.displayedText = line.getText();
            this.textView.post(new Runnable() { // from class: com.bytedance.trae.conversation.brainstorm.adapter.AiSubtitleAdapter$LineViewHolder$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AiSubtitleAdapter.LineViewHolder.bindImmediate$lambda$3(AiSubtitleAdapter.LineViewHolder.this, line);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindImmediate$lambda$3(LineViewHolder lineViewHolder, SubtitleLine subtitleLine) {
            float calcCenterTranslationX = lineViewHolder.calcCenterTranslationX(subtitleLine.getText());
            lineViewHolder.textView.setTranslationX(calcCenterTranslationX);
            lineViewHolder.currentTranslationX = calcCenterTranslationX;
            lineViewHolder.targetTranslationX = calcCenterTranslationX;
            lineViewHolder.animStartTranslationX = calcCenterTranslationX;
        }

        public final void animateAppend(String newFullText) {
            Intrinsics.checkNotNullParameter(newFullText, "newFullText");
            this.textView.setText(newFullText);
            this.displayedText = newFullText;
            this.targetTranslationX = calcCenterTranslationX(newFullText);
            if (this.translateAnimator.isPaused()) {
                this.animStartTranslationX = this.currentTranslationX;
                this.translateAnimator.cancel();
                this.translateAnimator.start();
            } else {
                if (this.translateAnimator.isStarted() && this.translateAnimator.isRunning()) {
                    return;
                }
                this.animStartTranslationX = this.currentTranslationX;
                this.translateAnimator.start();
            }
        }

        public final void cancelAnimation() {
            this.translateAnimator.cancel();
            this.textView.setTranslationX(0.0f);
            this.currentTranslationX = 0.0f;
            this.targetTranslationX = 0.0f;
            this.animStartTranslationX = 0.0f;
        }
    }
}
