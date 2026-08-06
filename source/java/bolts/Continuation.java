package bolts;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface Continuation<TTaskResult, TContinuationResult> {
    TContinuationResult then(Task<TTaskResult> task) throws Exception;
}
