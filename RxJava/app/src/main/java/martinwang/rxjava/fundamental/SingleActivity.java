package martinwang.rxjava.fundamental;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;

/**
 * Created by martinwang on 2018/9/13.
 */

public class SingleActivity extends Activity{
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        Single();
    }

    public void Single(){
        Single.create(new SingleOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<String> e) throws Exception{
                e.onSuccess("test");
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.i(s, "=============");
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull  Throwable throwable) throws Exception {
                throwable.printStackTrace();
            }
        });
    }

    public void SingleEasy(){
        Single.create(new SingleOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<String> e) throws Exception{
                e.onSuccess("test");
            }
        }).subscribe(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable throwable) throws Exception {
                Log.i(s, "=============");
            }
        });
    }
}
