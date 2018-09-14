package martinwang.rxjava.fundamental;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;


import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by martinwang on 2018/9/13.
 */

public class CompletableActivity extends Activity {
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        Completable();
    }

    public void Completable() {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("Hello World");
            }
        }).subscribe();

        Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(@NonNull CompletableEmitter e) throws Exception {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    e.onComplete();
                } catch (InterruptedException error) {

                }
            }
        }).andThen(Observable.range(1, 10))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        System.out.println(integer);
                    }
                });
    }


}
