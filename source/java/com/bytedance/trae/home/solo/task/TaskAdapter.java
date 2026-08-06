package com.bytedance.trae.home.solo.task;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.home.solo.task.TaskAdapter;
import com.bytedance.trae.home.solo.task.TaskSearchTextFormatter;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.settings.api.feature.Feature;
import com.bytedance.trae.settings.api.feature.FeatureCapability;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TaskAdapter.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 &2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002%&Bî\u0001\u0012\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\t\u0012 \b\u0002\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u000b\u0012/\b\u0002\u0010\r\u001a)\u0012\u0004\u0012\u00020\u0002\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00070\u0005\u0012/\b\u0002\u0010\u0012\u001a)\u0012\u0004\u0012\u00020\u0002\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00070\u0005\u0012/\b\u0002\u0010\u0013\u001a)\u0012\u0004\u0012\u00020\u0002\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u001d\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0006H\u0016J\u001c\u0010!\u001a\u00020\u00072\n\u0010\"\u001a\u00060\u0003R\u00020\u00002\u0006\u0010#\u001a\u00020\u0006H\u0016J\u0006\u0010$\u001a\u00020\u0007R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R5\u0010\r\u001a)\u0012\u0004\u0012\u00020\u0002\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R5\u0010\u0012\u001a)\u0012\u0004\u0012\u00020\u0002\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R5\u0010\u0013\u001a)\u0012\u0004\u0012\u00020\u0002\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0018\u00010\u0003R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bytedance/trae/home/solo/task/TaskModel;", "Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;", "onItemClick", "Lkotlin/Function2;", "", "", "onSlideOpen", "Lkotlin/Function1;", "onLongPress", "Lkotlin/Function3;", "", "onPinClick", "Lkotlin/Function0;", "Lkotlin/ParameterName;", "name", "closeAction", "onRenameClick", "onDeleteClick", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "showProductType", "", "getShowProductType", "()Z", "setShowProductType", "(Z)V", "openViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", NewTaskTracker.Param.POSITION, "closeOpenItem", "TaskViewHolder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskAdapter extends ListAdapter<TaskModel, TaskViewHolder> {
    private final Function2<TaskModel, Function0<Unit>, Unit> onDeleteClick;
    private final Function2<TaskModel, Integer, Unit> onItemClick;
    private final Function3<TaskModel, Float, Float, Unit> onLongPress;
    private final Function2<TaskModel, Function0<Unit>, Unit> onPinClick;
    private final Function2<TaskModel, Function0<Unit>, Unit> onRenameClick;
    private final Function1<TaskModel, Unit> onSlideOpen;
    private TaskViewHolder openViewHolder;
    private boolean showProductType;
    public static final int $stable = 8;
    private static final TaskAdapter$Companion$DIFF_CALLBACK$1 DIFF_CALLBACK = new DiffUtil.ItemCallback<TaskModel>() { // from class: com.bytedance.trae.home.solo.task.TaskAdapter$Companion$DIFF_CALLBACK$1
        public boolean areItemsTheSame(TaskModel oldItem, TaskModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getId(), newItem.getId());
        }

        public boolean areContentsTheSame(TaskModel oldItem, TaskModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    public TaskAdapter() {
        this(null, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ TaskAdapter(Function2 function2, Function1 function1, Function3 function3, Function2 function22, Function2 function23, Function2 function24, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function2() { // from class: com.bytedance.trae.home.solo.task.TaskAdapter$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = TaskAdapter._init_$lambda$0((TaskModel) obj, ((Integer) obj2).intValue());
                return _init_$lambda$0;
            }
        } : function2, (i & 2) != 0 ? new Function1() { // from class: com.bytedance.trae.home.solo.task.TaskAdapter$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit _init_$lambda$1;
                _init_$lambda$1 = TaskAdapter._init_$lambda$1((TaskModel) obj);
                return _init_$lambda$1;
            }
        } : function1, (i & 4) != 0 ? new Function3() { // from class: com.bytedance.trae.home.solo.task.TaskAdapter$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit _init_$lambda$2;
                _init_$lambda$2 = TaskAdapter._init_$lambda$2((TaskModel) obj, ((Float) obj2).floatValue(), ((Float) obj3).floatValue());
                return _init_$lambda$2;
            }
        } : function3, (i & 8) != 0 ? new Function2() { // from class: com.bytedance.trae.home.solo.task.TaskAdapter$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2) {
                Unit _init_$lambda$3;
                _init_$lambda$3 = TaskAdapter._init_$lambda$3((TaskModel) obj, (Function0) obj2);
                return _init_$lambda$3;
            }
        } : function22, (i & 16) != 0 ? new Function2() { // from class: com.bytedance.trae.home.solo.task.TaskAdapter$$ExternalSyntheticLambda4
            public final Object invoke(Object obj, Object obj2) {
                Unit _init_$lambda$4;
                _init_$lambda$4 = TaskAdapter._init_$lambda$4((TaskModel) obj, (Function0) obj2);
                return _init_$lambda$4;
            }
        } : function23, (i & 32) != 0 ? new Function2() { // from class: com.bytedance.trae.home.solo.task.TaskAdapter$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2) {
                Unit _init_$lambda$5;
                _init_$lambda$5 = TaskAdapter._init_$lambda$5((TaskModel) obj, (Function0) obj2);
                return _init_$lambda$5;
            }
        } : function24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(TaskModel taskModel, int i) {
        Intrinsics.checkNotNullParameter(taskModel, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(TaskModel taskModel) {
        Intrinsics.checkNotNullParameter(taskModel, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$2(TaskModel taskModel, float f, float f2) {
        Intrinsics.checkNotNullParameter(taskModel, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$3(TaskModel taskModel, Function0 function0) {
        Intrinsics.checkNotNullParameter(taskModel, "<unused var>");
        Intrinsics.checkNotNullParameter(function0, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$4(TaskModel taskModel, Function0 function0) {
        Intrinsics.checkNotNullParameter(taskModel, "<unused var>");
        Intrinsics.checkNotNullParameter(function0, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$5(TaskModel taskModel, Function0 function0) {
        Intrinsics.checkNotNullParameter(taskModel, "<unused var>");
        Intrinsics.checkNotNullParameter(function0, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TaskAdapter(Function2<? super TaskModel, ? super Integer, Unit> function2, Function1<? super TaskModel, Unit> function1, Function3<? super TaskModel, ? super Float, ? super Float, Unit> function3, Function2<? super TaskModel, ? super Function0<Unit>, Unit> function22, Function2<? super TaskModel, ? super Function0<Unit>, Unit> function23, Function2<? super TaskModel, ? super Function0<Unit>, Unit> function24) {
        super(DIFF_CALLBACK);
        Intrinsics.checkNotNullParameter(function2, "onItemClick");
        Intrinsics.checkNotNullParameter(function1, "onSlideOpen");
        Intrinsics.checkNotNullParameter(function3, "onLongPress");
        Intrinsics.checkNotNullParameter(function22, "onPinClick");
        Intrinsics.checkNotNullParameter(function23, "onRenameClick");
        Intrinsics.checkNotNullParameter(function24, "onDeleteClick");
        this.onItemClick = function2;
        this.onSlideOpen = function1;
        this.onLongPress = function3;
        this.onPinClick = function22;
        this.onRenameClick = function23;
        this.onDeleteClick = function24;
    }

    public final boolean getShowProductType() {
        return this.showProductType;
    }

    public final void setShowProductType(boolean z) {
        this.showProductType = z;
    }

    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(C0820R.layout.item_task, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new TaskViewHolder(this, inflate);
    }

    public void onBindViewHolder(TaskViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Object item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind((TaskModel) item);
    }

    public final void closeOpenItem() {
        TaskViewHolder taskViewHolder = this.openViewHolder;
        if (taskViewHolder != null) {
            taskViewHolder.animateClose();
        }
        this.openViewHolder = null;
    }

    /* compiled from: TaskAdapter.kt */
    @Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b\u0087\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020'J\u0010\u00101\u001a\u00020/2\u0006\u00102\u001a\u000203H\u0002J\u0018\u00104\u001a\u00020/2\u0006\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u00020\u001eH\u0002J\b\u00107\u001a\u00020/H\u0002J\b\u00108\u001a\u00020/H\u0002J\u0006\u00109\u001a\u00020/J\b\u0010:\u001a\u00020/H\u0002J\b\u0010;\u001a\u00020/H\u0002J\u0010\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020>H\u0002J(\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020B2\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010EH\u0002R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/trae/home/solo/task/TaskAdapter;Landroid/view/View;)V", "layoutContent", "layoutSwipeActions", "btnPin", "ivPin", "Landroid/widget/ImageView;", "tvPin", "Landroid/widget/TextView;", "btnRename", "btnDelete", "flIconContainer", "Landroid/widget/FrameLayout;", "ivEmojiIcon", "pbLoading", "Landroid/widget/ProgressBar;", "vBadge", "tvTitle", "ivSourceIcon", "ivProduct", "tvSourceDivider", "tvLocation", "tvTime", "tvLocationDefaultMarginStart", "", "startX", "", "startY", "isDragging", "", "isOpen", "swipeThreshold", "getSwipeThreshold", "()F", "currentTask", "Lcom/bytedance/trae/home/solo/task/TaskModel;", "dampingFactor", "longPressHandler", "Landroid/os/Handler;", "longPressRunnable", "Ljava/lang/Runnable;", "longPressTriggered", "bind", "", "task", "handleTouch", Fields.EVENT, "Landroid/view/MotionEvent;", "scheduleLongPress", "rawX", "rawY", "cancelLongPress", "animateOpen", "animateClose", "resetSwipe", "applyNormalContentBackground", "applyCircleStyle", PageDataManager.EXTRA_STATUS, "Lcom/bytedance/trae/home/solo/task/TaskStatus;", "highlightQuery", "", "text", "", "query", "highlightKeywords", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public final class TaskViewHolder extends RecyclerView.ViewHolder {
        private final View btnDelete;
        private final View btnPin;
        private final View btnRename;
        private TaskModel currentTask;
        private final float dampingFactor;
        private final FrameLayout flIconContainer;
        private boolean isDragging;
        private boolean isOpen;
        private final ImageView ivEmojiIcon;
        private final ImageView ivPin;
        private final ImageView ivProduct;
        private final ImageView ivSourceIcon;
        private final View layoutContent;
        private final View layoutSwipeActions;
        private final Handler longPressHandler;
        private Runnable longPressRunnable;
        private boolean longPressTriggered;
        private final ProgressBar pbLoading;
        private float startX;
        private float startY;
        final /* synthetic */ TaskAdapter this$0;
        private final TextView tvLocation;
        private final int tvLocationDefaultMarginStart;
        private final TextView tvPin;
        private final TextView tvSourceDivider;
        private final TextView tvTime;
        private final TextView tvTitle;
        private final View vBadge;

        /* compiled from: TaskAdapter.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CircleBorderStyle.values().length];
                try {
                    iArr[CircleBorderStyle.SOLID.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CircleBorderStyle.DASHED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[CircleBorderStyle.NONE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskViewHolder(final TaskAdapter taskAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = taskAdapter;
            View findViewById = view.findViewById(C0820R.id.layout_content);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.layoutContent = findViewById;
            View findViewById2 = view.findViewById(C0820R.id.layout_swipe_actions);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.layoutSwipeActions = findViewById2;
            View findViewById3 = view.findViewById(C0820R.id.btn_pin);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.btnPin = findViewById3;
            View findViewById4 = view.findViewById(C0820R.id.iv_pin);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.ivPin = (ImageView) findViewById4;
            View findViewById5 = view.findViewById(C0820R.id.tv_pin);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            this.tvPin = (TextView) findViewById5;
            View findViewById6 = view.findViewById(C0820R.id.btn_rename);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
            this.btnRename = findViewById6;
            View findViewById7 = view.findViewById(C0820R.id.btn_delete);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
            this.btnDelete = findViewById7;
            View findViewById8 = view.findViewById(C0820R.id.fl_icon_container);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
            this.flIconContainer = (FrameLayout) findViewById8;
            View findViewById9 = view.findViewById(C0820R.id.iv_emoji_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
            this.ivEmojiIcon = (ImageView) findViewById9;
            View findViewById10 = view.findViewById(C0820R.id.pb_loading);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
            this.pbLoading = (ProgressBar) findViewById10;
            View findViewById11 = view.findViewById(C0820R.id.v_badge);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(...)");
            this.vBadge = findViewById11;
            View findViewById12 = view.findViewById(C0820R.id.tv_title);
            Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(...)");
            this.tvTitle = (TextView) findViewById12;
            View findViewById13 = view.findViewById(C0820R.id.iv_source_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(...)");
            this.ivSourceIcon = (ImageView) findViewById13;
            View findViewById14 = view.findViewById(C0820R.id.iv_product_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(...)");
            this.ivProduct = (ImageView) findViewById14;
            View findViewById15 = view.findViewById(C0820R.id.tv_dot1);
            Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(...)");
            this.tvSourceDivider = (TextView) findViewById15;
            View findViewById16 = view.findViewById(C0820R.id.tv_location);
            Intrinsics.checkNotNullExpressionValue(findViewById16, "findViewById(...)");
            TextView textView = (TextView) findViewById16;
            this.tvLocation = textView;
            View findViewById17 = view.findViewById(C0820R.id.tv_time);
            Intrinsics.checkNotNullExpressionValue(findViewById17, "findViewById(...)");
            this.tvTime = (TextView) findViewById17;
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            this.tvLocationDefaultMarginStart = marginLayoutParams != null ? marginLayoutParams.getMarginStart() : 0;
            this.dampingFactor = 0.45f;
            this.longPressHandler = new Handler(Looper.getMainLooper());
            findViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda8
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    boolean _init_$lambda$0;
                    _init_$lambda$0 = TaskAdapter.TaskViewHolder._init_$lambda$0(TaskAdapter.TaskViewHolder.this, view2, motionEvent);
                    return _init_$lambda$0;
                }
            });
            findViewById.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda9
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    boolean _init_$lambda$2;
                    _init_$lambda$2 = TaskAdapter.TaskViewHolder._init_$lambda$2(TaskAdapter.TaskViewHolder.this, taskAdapter, view2);
                    return _init_$lambda$2;
                }
            });
        }

        private final float getSwipeThreshold() {
            return this.layoutSwipeActions.getWidth();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean _init_$lambda$0(TaskViewHolder taskViewHolder, View view, MotionEvent motionEvent) {
            Intrinsics.checkNotNull(motionEvent);
            taskViewHolder.handleTouch(motionEvent);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean _init_$lambda$2(TaskViewHolder taskViewHolder, TaskAdapter taskAdapter, View view) {
            TaskModel taskModel = taskViewHolder.currentTask;
            if (taskModel == null) {
                return false;
            }
            taskViewHolder.layoutContent.getLocationOnScreen(new int[2]);
            taskAdapter.onLongPress.invoke(taskModel, Float.valueOf(r1[0] + (taskViewHolder.layoutContent.getWidth() / 2.0f)), Float.valueOf(r1[1] + (taskViewHolder.layoutContent.getHeight() / 2.0f)));
            return true;
        }

        public final void bind(TaskModel task) {
            String str;
            int i;
            int i2;
            int i3;
            Intrinsics.checkNotNullParameter(task, "task");
            this.currentTask = task;
            this.tvTitle.setText(highlightQuery(task.getTitle(), task.getSearchQuery(), task.getSearchHighlightKeywords()));
            String searchSnippet = task.getSearchSnippet();
            if (!(!StringsKt.isBlank(searchSnippet))) {
                searchSnippet = null;
            }
            int i4 = 0;
            if (searchSnippet == null) {
                List listOf = CollectionsKt.listOf(new String[]{task.getTag(), task.getLocation()});
                ArrayList arrayList = new ArrayList();
                for (Object obj : listOf) {
                    if (!StringsKt.isBlank((String) obj)) {
                        arrayList.add(obj);
                    }
                }
                str = CollectionsKt.joinToString$default(arrayList, " · ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            } else {
                str = searchSnippet;
            }
            String searchQuery = searchSnippet != null ? task.getSearchQuery() : null;
            if (searchQuery == null) {
                searchQuery = "";
            }
            this.tvLocation.setText(highlightQuery(str, searchQuery, task.getSearchHighlightKeywords()));
            this.tvTime.setText(task.getTime());
            boolean isBlank = StringsKt.isBlank(task.getSearchQuery());
            ImageView imageView = this.ivSourceIcon;
            if (task.isLocal()) {
                i = task.isDeviceOnline() ? C0820R.drawable.ic_solo_computer : C0820R.drawable.ic_solo_computer_offline;
            } else {
                i = C0820R.drawable.ic_solo_cloud_1;
            }
            imageView.setImageResource(i);
            int i5 = 8;
            if (this.this$0.getShowProductType()) {
                String cliType = task.getCliType();
                if (Intrinsics.areEqual(cliType, CliType.IDE.getValue())) {
                    this.ivProduct.setVisibility(0);
                    this.ivProduct.setImageResource(C0820R.drawable.ic_task_product_ide);
                } else if (Intrinsics.areEqual(cliType, CliType.LOCAL.getValue())) {
                    this.ivProduct.setVisibility(0);
                    this.ivProduct.setImageResource(C0820R.drawable.ic_task_product_local);
                } else {
                    this.ivProduct.setVisibility(8);
                }
            } else {
                this.ivProduct.setVisibility(8);
            }
            this.ivSourceIcon.setVisibility(isBlank ? 0 : 8);
            this.tvSourceDivider.setVisibility(isBlank ? 0 : 8);
            ViewGroup.LayoutParams layoutParams = this.tvLocation.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.setMarginStart(isBlank ? this.tvLocationDefaultMarginStart : 0);
                this.tvLocation.setLayoutParams(marginLayoutParams);
            }
            ImageViewCompat.setImageTintList(this.ivSourceIcon, ColorStateList.valueOf(ContextCompat.getColor(this.itemView.getContext(), C0591R.color.trae_icon_icon_tertiary)));
            this.ivEmojiIcon.setImageResource(task.getIconType().getIconRes());
            ImageViewCompat.setImageTintList(this.ivEmojiIcon, ColorStateList.valueOf(ContextCompat.getColor(this.itemView.getContext(), C0591R.color.trae_icon_icon_onbrand)));
            applyCircleStyle(task.getStatus());
            this.vBadge.setVisibility(8);
            if (task.getStatus().getDisplayState() == TaskDisplayState.LOADING) {
                this.pbLoading.setVisibility(0);
            } else {
                this.pbLoading.setVisibility(8);
            }
            resetSwipe();
            View view = this.btnPin;
            if (task.getSupportsPin() && FeatureCapability.INSTANCE.isEnabled(Feature.TASK_LIST_PIN)) {
                i5 = 0;
            }
            view.setVisibility(i5);
            ViewGroup.LayoutParams layoutParams2 = this.btnRename.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
            if (marginLayoutParams2 != null) {
                if (task.getSupportsPin() && FeatureCapability.INSTANCE.isEnabled(Feature.TASK_LIST_PIN)) {
                    i4 = this.itemView.getResources().getDimensionPixelSize(C0820R.dimen.trae_task_swipe_action_gap);
                }
                marginLayoutParams2.setMarginStart(i4);
                this.btnRename.setLayoutParams(marginLayoutParams2);
            }
            TextView textView = this.tvPin;
            Context context = this.itemView.getContext();
            if (task.isPinned()) {
                i2 = C0820R.string.solo_context_menu_unpin;
            } else {
                i2 = C0820R.string.solo_context_menu_pin;
            }
            textView.setText(context.getString(i2));
            ImageView imageView2 = this.ivPin;
            if (task.isPinned()) {
                i3 = C0820R.drawable.ic_solo_unpin;
            } else {
                i3 = C0820R.drawable.ic_solo_pin_1;
            }
            imageView2.setImageResource(i3);
            View view2 = this.btnPin;
            final TaskAdapter taskAdapter = this.this$0;
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    TaskAdapter.TaskViewHolder.bind$lambda$11(TaskAdapter.TaskViewHolder.this, taskAdapter, view3);
                }
            });
            View view3 = this.btnRename;
            final TaskAdapter taskAdapter2 = this.this$0;
            view3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    TaskAdapter.TaskViewHolder.bind$lambda$14(TaskAdapter.TaskViewHolder.this, taskAdapter2, view4);
                }
            });
            View view4 = this.btnDelete;
            final TaskAdapter taskAdapter3 = this.this$0;
            view4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    TaskAdapter.TaskViewHolder.bind$lambda$17(TaskAdapter.TaskViewHolder.this, taskAdapter3, view5);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$11(final TaskViewHolder taskViewHolder, TaskAdapter taskAdapter, View view) {
            TaskModel taskModel = taskViewHolder.currentTask;
            if (taskModel != null) {
                taskAdapter.onPinClick.invoke(taskModel, new Function0() { // from class: com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit bind$lambda$11$lambda$10$lambda$9;
                        bind$lambda$11$lambda$10$lambda$9 = TaskAdapter.TaskViewHolder.bind$lambda$11$lambda$10$lambda$9(TaskAdapter.TaskViewHolder.this);
                        return bind$lambda$11$lambda$10$lambda$9;
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit bind$lambda$11$lambda$10$lambda$9(TaskViewHolder taskViewHolder) {
            taskViewHolder.animateClose();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$14(final TaskViewHolder taskViewHolder, TaskAdapter taskAdapter, View view) {
            TaskModel taskModel = taskViewHolder.currentTask;
            if (taskModel != null) {
                taskAdapter.onRenameClick.invoke(taskModel, new Function0() { // from class: com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit bind$lambda$14$lambda$13$lambda$12;
                        bind$lambda$14$lambda$13$lambda$12 = TaskAdapter.TaskViewHolder.bind$lambda$14$lambda$13$lambda$12(TaskAdapter.TaskViewHolder.this);
                        return bind$lambda$14$lambda$13$lambda$12;
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit bind$lambda$14$lambda$13$lambda$12(TaskViewHolder taskViewHolder) {
            taskViewHolder.animateClose();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$17(final TaskViewHolder taskViewHolder, TaskAdapter taskAdapter, View view) {
            TaskModel taskModel = taskViewHolder.currentTask;
            if (taskModel != null) {
                taskAdapter.onDeleteClick.invoke(taskModel, new Function0() { // from class: com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit bind$lambda$17$lambda$16$lambda$15;
                        bind$lambda$17$lambda$16$lambda$15 = TaskAdapter.TaskViewHolder.bind$lambda$17$lambda$16$lambda$15(TaskAdapter.TaskViewHolder.this);
                        return bind$lambda$17$lambda$16$lambda$15;
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit bind$lambda$17$lambda$16$lambda$15(TaskViewHolder taskViewHolder) {
            taskViewHolder.animateClose();
            return Unit.INSTANCE;
        }

        private final void handleTouch(MotionEvent event) {
            int actionMasked = event.getActionMasked();
            if (actionMasked == 0) {
                this.startX = event.getRawX();
                this.startY = event.getRawY();
                this.isDragging = false;
                this.longPressTriggered = false;
                scheduleLongPress(event.getRawX(), event.getRawY());
                ViewParent parent = this.itemView.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                    return;
                }
                return;
            }
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    float rawX = event.getRawX() - this.startX;
                    float rawY = event.getRawY() - this.startY;
                    if (!this.isDragging && Math.abs(rawX) > 10.0f && Math.abs(rawX) > Math.abs(rawY) * 1.5f) {
                        this.isDragging = true;
                        if (this.this$0.openViewHolder != null && !Intrinsics.areEqual(this.this$0.openViewHolder, this)) {
                            TaskViewHolder taskViewHolder = this.this$0.openViewHolder;
                            if (taskViewHolder != null) {
                                taskViewHolder.animateClose();
                            }
                            this.this$0.openViewHolder = null;
                        }
                        cancelLongPress();
                        this.layoutContent.setBackgroundColor(ContextCompat.getColor(this.itemView.getContext(), C0591R.color.trae_bg_bg_base_secondary));
                        ViewParent parent2 = this.itemView.getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (this.isDragging) {
                        this.layoutContent.setTranslationX(Math.max(-getSwipeThreshold(), Math.min(0.0f, (this.isOpen ? -getSwipeThreshold() : 0.0f) + (rawX * this.dampingFactor))));
                        return;
                    }
                    return;
                }
                if (actionMasked != 3) {
                    return;
                }
            }
            cancelLongPress();
            if (this.isDragging) {
                float swipeThreshold = getSwipeThreshold() / 3;
                float translationX = this.layoutContent.getTranslationX();
                if (this.isOpen) {
                    if (translationX > (-getSwipeThreshold()) + swipeThreshold) {
                        animateClose();
                    } else {
                        animateOpen();
                    }
                } else if (translationX < (-swipeThreshold)) {
                    animateOpen();
                } else {
                    animateClose();
                }
            } else if (event.getActionMasked() == 1 && !this.longPressTriggered) {
                if (this.isOpen) {
                    animateClose();
                } else {
                    TaskModel taskModel = this.currentTask;
                    if (taskModel != null) {
                        this.this$0.onItemClick.invoke(taskModel, Integer.valueOf(getBindingAdapterPosition()));
                    }
                }
            }
            this.isDragging = false;
            ViewParent parent3 = this.itemView.getParent();
            if (parent3 != null) {
                parent3.requestDisallowInterceptTouchEvent(false);
            }
        }

        private final void scheduleLongPress(final float rawX, final float rawY) {
            cancelLongPress();
            final TaskAdapter taskAdapter = this.this$0;
            Runnable runnable = new Runnable() { // from class: com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    TaskAdapter.TaskViewHolder.scheduleLongPress$lambda$19(TaskAdapter.TaskViewHolder.this, taskAdapter, rawX, rawY);
                }
            };
            this.longPressHandler.postDelayed(runnable, ViewConfiguration.getLongPressTimeout());
            this.longPressRunnable = runnable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void scheduleLongPress$lambda$19(TaskViewHolder taskViewHolder, TaskAdapter taskAdapter, float f, float f2) {
            TaskModel taskModel;
            if (taskViewHolder.isDragging || taskViewHolder.isOpen || (taskModel = taskViewHolder.currentTask) == null) {
                return;
            }
            taskViewHolder.longPressTriggered = true;
            taskViewHolder.layoutContent.performHapticFeedback(0);
            taskAdapter.onLongPress.invoke(taskModel, Float.valueOf(f), Float.valueOf(f2));
        }

        private final void cancelLongPress() {
            Runnable runnable = this.longPressRunnable;
            if (runnable != null) {
                this.longPressHandler.removeCallbacks(runnable);
            }
            this.longPressRunnable = null;
        }

        private final void animateOpen() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.layoutContent.getTranslationX(), -getSwipeThreshold());
            ofFloat.setDuration(200L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda6
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TaskAdapter.TaskViewHolder.animateOpen$lambda$23$lambda$22(TaskAdapter.TaskViewHolder.this, valueAnimator);
                }
            });
            ofFloat.start();
            this.isOpen = true;
            this.this$0.openViewHolder = this;
            TaskModel taskModel = this.currentTask;
            if (taskModel != null) {
                this.this$0.onSlideOpen.invoke(taskModel);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void animateOpen$lambda$23$lambda$22(TaskViewHolder taskViewHolder, ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(valueAnimator, "it");
            View view = taskViewHolder.layoutContent;
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            view.setTranslationX(((Float) animatedValue).floatValue());
        }

        public final void animateClose() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.layoutContent.getTranslationX(), 0.0f);
            ofFloat.setDuration(200L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda10
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TaskAdapter.TaskViewHolder.animateClose$lambda$26$lambda$25(TaskAdapter.TaskViewHolder.this, valueAnimator);
                }
            });
            ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder$animateClose$1$2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    TaskAdapter.TaskViewHolder.this.applyNormalContentBackground();
                }
            });
            ofFloat.start();
            this.isOpen = false;
            if (Intrinsics.areEqual(this.this$0.openViewHolder, this)) {
                this.this$0.openViewHolder = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void animateClose$lambda$26$lambda$25(TaskViewHolder taskViewHolder, ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(valueAnimator, "it");
            View view = taskViewHolder.layoutContent;
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            view.setTranslationX(((Float) animatedValue).floatValue());
        }

        private final void resetSwipe() {
            this.layoutContent.setTranslationX(0.0f);
            applyNormalContentBackground();
            this.isOpen = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void applyNormalContentBackground() {
            int i;
            TaskModel taskModel = this.currentTask;
            boolean z = false;
            if (taskModel != null && taskModel.isPinned()) {
                z = true;
            }
            if (z) {
                i = C0591R.color.trae_bg_bg_base_tertiary;
            } else {
                i = C0591R.color.trae_bg_bg_base_secondary;
            }
            this.layoutContent.setBackgroundColor(ContextCompat.getColor(this.itemView.getContext(), i));
        }

        private final void applyCircleStyle(TaskStatus status) {
            Context context = this.itemView.getContext();
            int color = ContextCompat.getColor(context, status.getCircleBgColorRes());
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(color);
            if (status.getDisplayState() != TaskDisplayState.LOADING) {
                int dimensionPixelSize = this.itemView.getResources().getDimensionPixelSize(C0820R.dimen.trae_task_icon_circle_border_width);
                int i = WhenMappings.$EnumSwitchMapping$0[status.getCircleBorderStyle().ordinal()];
                if (i == 1) {
                    gradientDrawable.setStroke(dimensionPixelSize, ContextCompat.getColor(context, status.getCircleBorderColorRes()));
                } else if (i == 2) {
                    gradientDrawable.setStroke(dimensionPixelSize, ContextCompat.getColor(context, status.getCircleBorderColorRes()), this.itemView.getResources().getDimension(C0820R.dimen.trae_task_icon_circle_dash_width), this.itemView.getResources().getDimension(C0820R.dimen.trae_task_icon_circle_dash_gap));
                } else if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            this.flIconContainer.setBackground(gradientDrawable);
        }

        private final CharSequence highlightQuery(String text, String query, List<String> highlightKeywords) {
            String str = text;
            if (StringsKt.isBlank(str) || StringsKt.isBlank(query)) {
                return str;
            }
            String format = TaskSearchTextFormatter.INSTANCE.format(text, query, highlightKeywords);
            SpannableString spannableString = new SpannableString(format);
            int color = ContextCompat.getColor(this.itemView.getContext(), C0591R.color.trae_text_text_brand);
            for (TaskSearchTextFormatter.HighlightRange highlightRange : TaskSearchTextFormatter.INSTANCE.highlightRanges(format, query, highlightKeywords)) {
                spannableString.setSpan(new ForegroundColorSpan(color), highlightRange.getStart(), highlightRange.getEnd(), 33);
            }
            return spannableString;
        }
    }
}
