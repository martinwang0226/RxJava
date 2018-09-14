package martinwang.rxjava.operator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by martinwang on 2018/9/14.
 */

public class JustActivity extends Activity {

    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        Create1();
    }

    public void Create() {
        Observable.just("Hello Just")
                .subscribe(s -> Log.i("Just", s));
    }

    public void Create1() {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .subscribe(
                        s -> Log.i("Next", "=======" + s),
                        throwable -> Log.i("Error", "===============" + throwable.getMessage()),
                        () -> Log.i("Just", "=======" + "Sequence complete")
                );
    }


}
