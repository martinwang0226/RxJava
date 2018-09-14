package martinwang.rxjava.operator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * Created by martinwang on 2018/9/14.
 */

public class RepeatActivity extends Activity {
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        Repeat1();
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void Repeat() {
        Observable
                .just("Hello Repeat")
                .repeat(3)
                .subscribe(
                        s -> Log.i("Repeat", s)
                );
    }

    public void Repeat1() {
        Observable
                .range(0, 9)
                .repeatWhen(objectObservable ->
                        Observable.timer(10, TimeUnit.SECONDS))
                .subscribe(integer -> System.out.println(integer));
    }

    public void RepeatUntil(){
//        final long
    }


}
