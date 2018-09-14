package martinwang.rxjava.operator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by martinwang on 2018/9/14.
 */

public class FromActivity extends Activity {

    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        From1();
    }

    public void From() {
        Observable.fromArray("Hello", "Martin")
                .subscribe(
                        s -> Log.i("Frome", "=================>" + s)
                );
    }

    public void From1() {
        List<Integer> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            items.add(i);
        }
        Observable.fromIterable(items)
                .subscribe(
                        integer -> Log.i("From", "Next===========>" + integer)
                        , throwable -> Log.i("From", "Error===========>" + throwable.getMessage())
                        , () -> Log.i("From", "Sequence Complete============>")

                );
    }
}
