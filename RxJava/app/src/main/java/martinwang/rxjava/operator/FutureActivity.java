package martinwang.rxjava.operator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * Created by martinwang on 2018/9/14.
 */

public class FutureActivity extends Activity {

    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        Future1();
    }

    public void Future() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());
        Observable.fromFuture(future)
                .subscribe(
                        s -> Log.i("Future", "=================>" + s)
                );
    }

    public void Future1() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());
        Observable.fromFuture(future, 4, TimeUnit.SECONDS)
                .subscribe(
                        s -> Log.i("Future", "=================>" + s)
                );
    }

    public class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("模拟一些耗时的任务");
            Thread.sleep(5000);
            return "OK";
        }
    }
}
