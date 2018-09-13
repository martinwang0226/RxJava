package martinwang.rxjava;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by martinwang on 2018/9/13.
 */

public class HelloActivity extends Activity{

    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        Hello2();

    }

    public  void Hello2(){
        Observable.just("Hello World")
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i("Hello","subscribe");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.i("Hello","onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("Hello","onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.i("Hello","onComplete");
                    }
                });
    }

    public void Hello(){
        Observable.just("Hello Martin")
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println(throwable.getMessage());
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("onComplete");
                    }
                }, new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        System.out.println("subscribe");
                    }
                });
    }
}
