package martinwang.rxjava.fundamental;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.ReplaySubject;

/**
 * Created by martinwang on 2018/9/14.
 */

public class AysncSubjectActivity extends Activity {
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        ReplaySubject();
    }

    public void Subject() {
        AsyncSubject<String> subject = AsyncSubject.create();
        subject.onNext("asyncSubject1");
        subject.onNext("asyncSubject2");

        subject.subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                Log.i("Subject", "========" + s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                Log.i("Subject", "aysnSubject onError");//异常才会输出
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                Log.i("Subject", "========" + "asyncSubject:complete");
            }
        });
        subject.onNext("asyncSubject3");
        subject.onNext("asyncSubject4");
        subject.onComplete();
    }

    public void BehaviorSubject() {
        BehaviorSubject<String> subject = BehaviorSubject.createDefault("behaviorSubject1");
        subject.onNext("behaviorSubject2");
        subject.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.i("BehaviorSubject", "========" + s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.i("BehaviorSubject", "BehaviorSubject onError");//异常才会输出
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                Log.i("BehaviorSubject", "BehaviorSubject :complete");
            }
        });

        subject.onNext("behaviorSubject3");
        subject.onNext("behaviorSubject4");
    }

    public void ReplaySubject() {
        ReplaySubject<String> subject = ReplaySubject.createWithSize(1);
        subject.onNext("replaySubject1");
        subject.onNext("replaySubject2");

        subject.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.i("replaySubject", s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.i("replaySubject", "replaySubject onError");
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                Log.i("replaySubject", "replaySubject Complete");
            }
        });
        subject.onNext("replaySubject3");
        subject.onNext("replaySubject4");

    }

}
