package martinwang.rxjava;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by martinwang on 2018/9/13.
 */

public class ColdActivity extends Activity {
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        Cold();
    }

    public void Cold(){

    }

    Consumer<Long> subsriber1 = new Consumer<Long>() {
        @Override
        public void accept(@NonNull  Long aLong) throws Exception {
            Log.i("Cold","subscriber1" + aLong);
        }
    };

    Consumer<Long> subsriber2 = new Consumer<Long>() {
        @Override
        public void accept(@NonNull  Long aLong) throws Exception {
            Log.i("Cold","subscriber2" + aLong);
        }
    };

    Observable<Long> observable = Observable.create(new ObservableOnSubscribe<Long>() {
        @Override
        public void subscribe(ObservableEmitter<Long> e) throws Exception {
            Observable.interval(10,
                    TimeUnit.MILLISECONDS., Schedulers.computation())
                    .take(Integer.MAX_VALUE)
                    .subscribe(e::onNext);
        }
    });



}
