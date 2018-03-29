package com.example.android.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.android.zxingtestapp.R;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observables.GroupedObservable;
import rx.schedulers.Schedulers;

public class RxJavaActivity extends AppCompatActivity {
    private String TAG = "RxJavaActivity";
    private Contributor contributor = new Contributor();

    private TextView topContributor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        topContributor = (TextView) findViewById(R.id.top_contributor);
        //创建被观察者
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello world");
            }

        });
        //创建观察者
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "onNext: " + s);
            }
        };
        //订阅
        observable.subscribe(subscriber);

        create();
        just();
        from();
        defer();
        //throw()--onError,empty/never
        interval();
        range();
        repeat();
        start();
        timer();
        //数据转换
        map();
        flatmap();
        groupby();
        buffer();
        scan();
        window();

        //过滤的操作符
        debounce();
        distinct();
        elementat();
        filter();
        first();
        ignoreelements();
        last();
        sample();
        skip();
        skiplast();
        take();
        takelast();
        //组合操作符
        zip();
        merge();
        startwith();
        combinelatest();
        join();//groupjoin()
        switchonnext();
        //rx_catch异常错误处理
        onerrorreturn();
        onerrorresumenext();
        onexceptionsumenext();
        //rx_retry()重试处理错误
        retry();
        retrywhen();

        //rx调度器
        schedulers_io();
        schedulers_conpution();
        schedulers_immediate();
        schedulers_newthread();
        schedulers_trampoline();
        //android调度器
        androidschedulers();
        //非阻塞IO操作
        storeBitmap();
        
    }

    private void storeBitmap() {
        Schedulers.io().createWorker().schedule(new Action0() {
            @Override
            public void call() {

            }
        });
    }

    //指定观察者在主线程调度 observeOn(AndroidSchedulers.mainThread())
    private void androidschedulers() {

    }

    //按指定顺序运行队列中的任务 repeat retry
    private void schedulers_trampoline() {

    }

    //创建一个新线程执行任务
    private void schedulers_newthread() {

    }

    //立即在当前线程执行任务
    private void schedulers_immediate() {

    }

    //计算 sample distint...
    private void schedulers_conpution() {
    }

    //读写文件等
    private void schedulers_io() {

    }

    //异常时不把异常信息发送给观察者，只有发送完成后才把错误信息发送给观察者
    private void retrywhen() {

    }

    //出现异常时重新发送一遍给观察者
    private void retry() {

    }

    //1 2 3 *----1 2 3 4 5 e(可以捕获异常信息)
    private void onexceptionsumenext() {

    }

    // 1 2 3 *----1 2 3 4 5...(不能捕获到错误信息)
    private void onerrorresumenext() {

    }

    // 1 2 3 *----1 2 3 default
    private void onerrorreturn() {

    }

    private void onerror() {

    }


    // x:1 2 3
    // y: 456---
    //   14263
    private void switchonnext() {

    }

    //
    private void join() {

    }

    //将多组数据按照既定规则合并
    // x:1 2 3          3离下一个O对象最近，就用3+第二个对象的每个元素
    // y: 4 5 6---
    //   3+4 3+5 3+6
    private void combinelatest() {

    }

    //在O对象之前可以插入数据  2 3   1 4----1 4 2 3
    private void startwith() {

    }

    //无序的多组数据按时间间隔组合（平行合并）1 2 3   4 5 6----1 2 3 4 5 6
    private void merge() {

    }

    //将指定时间间隔内的数据组合在一起后发送给观察者 1 2 3   4 5 6 7----1+4 2+5 3+6 当其中一个O对象出现异常时，第二个也会停止发送7对应空，所以停止发送
    private void zip() {

    }

    //获取末尾的某几项
    private void takelast() {

    }

    //获取某几项
    private void take() {

    }

    //跳过数据链中末尾的指定几项
    private void skiplast() {

    }

    //跳过某几项
    private void skip() {

    }

    //定时对数据进行采集，定时发送给观察者，然后清空当前链表，重新采集。直到结束
    private void sample() {
    }

    //取末尾项数据
    private void last() {

    }

    //忽略，不调用onNext（）函数
    private void ignoreelements() {

    }

    //取列表中的第一位
    private void first() {
    }

    //按照指定规则条件过滤
    private void filter() {
    }

    //获取列表中的指定位置值
    private void elementat() {
    }

    //去重的操作符
    private void distinct() {
    }

    //在指定间隔时间类未作任何操作，就将数据发送给观察者
    private void debounce() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                try {
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(1000);
                        subscriber.onNext(i);
                        subscriber.onCompleted();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        })
                .debounce(1, TimeUnit.SECONDS)
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer arg0) {
                        Log.i(TAG, "onNext: " + arg0);//1，9
                    }
                });
    }


    //根据时间的间隔，将指定的数据发送给观察者类似buffer
    private void window() {

    }

    //累加之前的数据，发送总和到观察者
    private void scan() {
        Observable.range(1, 5)
                .scan(new Func2<Integer, Integer, Integer>() {

                    @Override
                    public Integer call(Integer sum, Integer arg) {
                        return sum + arg;
                    }
                })//每次发送两个数据项
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer arg0) {
                        Log.i(TAG, "onNext: " + arg0);//1   3(1+2)   6(1+2+3)   10(1+2+3+4)  15
                    }


                });
    }

    //可以将不同的数据项，分固定组数发送
    private void buffer() {
        Observable.range(1, 5)
                .buffer(2)//每次发送两个数据项
                .subscribe(new Observer<List<Integer>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Integer> arg0) {
                        Log.i(TAG, "onNext: " + arg0);//[1,2][3,4][5]
                    }

                });
    }

    //分组
    private void groupby() {
        Observable.just(1, 2, 3)
                .groupBy(new Func1<Integer, Integer>() {

                    @Override
                    public Integer call(Integer arg0) {
                        return arg0 % 2;
                    }
                })
                .subscribe(new Observer<GroupedObservable<Integer, Integer>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(final GroupedObservable<Integer, Integer> arg0) {
                        arg0.subscribe(new Observer<Integer>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(Integer data) {
                                Log.i(TAG, "onNext: " + arg0.getKey() + " :" + data);//group 1 :1  group 0 :2  group 1 :3
                            }
                        });
                    }
                });
    }

    //一对多的转换对象//多个网络请求
    private void flatmap() {
        Observable.just(1, 2, 3)
                .flatMap(new Func1<Integer, Observable<? extends String>>() {
                    @Override
                    public Observable<? extends String> call(Integer arg0) {
                        return Observable.just(arg0 + "");
                    }
                })
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String integer) {
                        Log.i(TAG, "onNext: " + integer);//int 123转换成String 123
                    }

                });

    }

    //一对一的转换对象
    private void map() {
        Observable.just(123)
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer arg0) {
                        return arg0 + "";
                    }
                })
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String integer) {
                        Log.i(TAG, "onNext: " + integer);//int 123转换成String 123
                    }

                });
    }

    //间隔指定时长发送
    private void timer() {

    }

    //创建一个O
    private void start() {

    }

    //重复的发送
    private void repeat() {
        Observable observable = Observable.range(1, 5).repeat(2);
        observable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "onNext: " + integer);//1,2,3,4,5,1,2,3,4,5
            }

        });
    }

    //创建在一个数据整形范围类的O
    private void range() {
        Observable observable = Observable.range(1, 5);
        observable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "onNext: " + integer);//1,2,3,4,5
            }

        });
    }

    //定时器
    private void interval() {

    }

    //在我们没有调用S之前不会区创建O对象，只有在订阅的时候才会创建O
    //简单理解可以延迟
    String val = "aaa";

    private void defer() {

        final Observable observable = Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                return Observable.just(val);
            }
        });
        val = "bbb";
        observable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "onNext: " + s);//bbb
            }

        });

    }

    //接受数组，列表，文档
    private void from() {
        Observable.from(new Integer[]{1, 2, 3, 4, 5}).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer s) {
                Log.i(TAG, "onNext: " + s);//1  2   3   4   5
            }
        });
    }

    //快捷创建方式
    private void just() {
        Observable.just("rxjava").subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "onNext: " + s);//rxjava
            }
        });
    }

    //创建
    private void create() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("rxjava");
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "onNext: " + s);//rxjava
            }
        });

    }


}