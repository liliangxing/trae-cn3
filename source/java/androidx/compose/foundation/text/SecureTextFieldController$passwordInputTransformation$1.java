package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BasicSecureTextField.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public /* synthetic */ class SecureTextFieldController$passwordInputTransformation$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SecureTextFieldController$passwordInputTransformation$1(Object obj) {
        super(0, obj, SecureTextFieldController.class, "scheduleHide", "scheduleHide()V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1612invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m1612invoke() {
        ((SecureTextFieldController) this.receiver).scheduleHide();
    }
}
