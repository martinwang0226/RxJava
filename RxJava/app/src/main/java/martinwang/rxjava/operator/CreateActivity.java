package martinwang.rxjava.operator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * Created by martinwang on 2018/9/14.
 */

public class CreateActivity extends Activity {

    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        Create();
    }

    public void Create() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                try {
                    if (!emitter.isDisposed()) {
                        for (int i = 0; i < 10; i++) {
                            emitter.onNext(i);
                        }
                        emitter.onComplete();
                    }
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i("Create", "Next: " + integer);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.i("Create", "Error: " + throwable.getMessage());
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                Log.i("Create", "Sequence complete" );
            }
        });
    }

}
