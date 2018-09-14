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

/**
 * Created by martinwang on 2018/9/14.
 */

public class MaybeActivity extends Activity {

    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        Maybe3();
    }

    public void Maybe() {
        Maybe.create(new MaybeOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull MaybeEmitter<String> e) throws Exception {
                e.onSuccess("Hello Maybe");
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                Log.i("Maybe", s);
            }
        });
    }

    public void Maybe1() {
        Maybe.create(new MaybeOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull MaybeEmitter<String> emitter) throws Exception {
                emitter.onSuccess("Hello Maybe A");
                emitter.onSuccess("Hello Maybe B");
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                Log.i("Maybe", s);
            }
        });
    }

    public void Maybe2() {
        Maybe.create(new MaybeOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull MaybeEmitter<String> emitter) throws Exception {
                emitter.onComplete();
                emitter.onSuccess("Hello Maybe A");
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                Log.i("Maybe", s);
            }
        });
    }

    public void Maybe3() {
        Maybe.create(new MaybeOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull MaybeEmitter<String> emitter) throws Exception {
                emitter.onComplete();
                emitter.onSuccess("Hello Maybe A");
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                Log.i("Maybe", s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                Log.i("Maybe", "Maybe onComplete");
            }
        });
    }

}
