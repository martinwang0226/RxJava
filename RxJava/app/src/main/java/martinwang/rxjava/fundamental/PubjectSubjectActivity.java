package martinwang.rxjava.fundamental;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by martinwang on 2018/9/14.
 */

public class PubjectSubjectActivity extends Activity {

    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        PublishSubject3();
    }

    public void PublishSubject() {
        PublishSubject<String> subject = PublishSubject.create();
        subject.onNext("publishSubject1");
        subject.onNext("publishSubject2");
        subject.onComplete();
        subject.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.i("publishSubject", s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.i("publishSubject", "publishSubject onError");
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                Log.i("publishSubject", "complete");
            }
        });

        subject.onNext("publicSubject3");
        subject.onNext("publicSubject4");

    }

    public void PublishSubject1() {
        PublishSubject<String> subject = PublishSubject.create();
        subject.onNext("publishSubject1");
        subject.onNext("publishSubject2");

        subject.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.i("publishSubject", s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.i("publishSubject", "publishSubject onError");
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                Log.i("publishSubject", "complete");
            }
        });

        subject.onNext("publicSubject3");
        subject.onNext("publicSubject4");
        subject.onComplete();

    }

    public void PublishSubject2() {
        PublishSubject<String> subject = PublishSubject.create();
//        subject.onNext("publishSubject1");
//        subject.onNext("publishSubject2");

        subject.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.i("publishSubject", s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.i("publishSubject", "publishSubject onError");
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                Log.i("publishSubject", "complete");
            }
        });

        subject.onNext("Foo");
        subject.onNext("Bar");
        subject.onComplete();

    }

    public void PublishSubject3() {
        PublishSubject<String> subject = PublishSubject.create();
//        subject.onNext("publishSubject1");
//        subject.onNext("publishSubject2");

        subject.subscribeOn(Schedulers.io())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.i("publishSubject", s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.i("publishSubject", "publishSubject onError");
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.i("publishSubject", "complete");
                    }
                });

        subject.onNext("Foo");
        subject.onNext("Bar");
        subject.onComplete();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
