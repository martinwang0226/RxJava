package martinwang.rxjava.fundamental;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by martinwang on 2018/9/13.
 */

public class HotActivity extends Activity {

    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        Cold();
    }

    public void Cold() {
        connectableObservable.connect();

        Observable<Long> observable = connectableObservable.refCount();

        Disposable disposable1 = observable.subscribe(subsriber1);
        Disposable disposable2 = observable.subscribe(subsriber2);
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        disposable1.dispose();
        disposable2.dispose();

        Log.i("重新开始数据流","true");

        disposable1 = observable.subscribe(subsriber1);
        disposable2 = observable.subscribe(subsriber2);

        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    Consumer<Long> subsriber1 = new Consumer<Long>() {
        @Override
        public void accept(@NonNull Long aLong) throws Exception {
            Log.i("Cold", "subscriber11" + "===========" + aLong);
        }
    };

    Consumer<Long> subsriber2 = new Consumer<Long>() {
        @Override
        public void accept(@NonNull Long aLong) throws Exception {
            Log.i("Cold", "subscriber22" + "===========" + aLong);
        }
    };


    ConnectableObservable<Long> connectableObservable = Observable.create(new ObservableOnSubscribe<Long>() {
        @Override
        public void subscribe(ObservableEmitter<Long> e) throws Exception {
            Observable.interval(10,
                    TimeUnit.MILLISECONDS, Schedulers.computation())
                    .take(Integer.MAX_VALUE)
                    .subscribe(e::onNext);
        }
    }).observeOn(Schedulers.newThread()).publish();


}
