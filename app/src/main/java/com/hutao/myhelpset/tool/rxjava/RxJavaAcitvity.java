package com.hutao.myhelpset.tool.rxjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.hutao.helplibrary.log.OsduiLog;
import com.hutao.myhelpset.R;
import com.hutao.myhelpset.base.BaseActivity;
import com.hutao.myhelpset.tool.annotation.RegisterView;

import java.io.Serializable;
import java.sql.Time;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author: hutao
 * @date: 2021/9/17
 */
public class RxJavaAcitvity extends BaseActivity {
    @RegisterView(id = R.id.testRxjava1)
    private Button testRxjava1;
    @RegisterView(id = R.id.testRxjava2)
    private Button testRxjava2;
    @RegisterView(id = R.id.testRxjava3)
    private Button testRxjava3;
    @RegisterView(id = R.id.testRxjava4)
    private Button testRxjava4;
    @RegisterView(id = R.id.testRxjava5)
    private Button testRxjava5;

    @RegisterView(id = R.id.testRxCreate)
    private Button testRxCreate;
    @RegisterView(id = R.id.testRxFrom)
    private Button testRxFrom;
    @RegisterView(id = R.id.testRxJust)
    private Button testRxJust;
    @RegisterView(id = R.id.testRxDefer)
    private Button testRxDefer;
    @RegisterView(id = R.id.testRxInterval)
    private Button testRxInterval;
    @RegisterView(id = R.id.testRange)
    private Button testRange;
    @RegisterView(id = R.id.testRepeat)
    private Button testRepeat;
    @RegisterView(id = R.id.testTimer)
    private Button testTimer;
    @RegisterView(id = R.id.testMap)
    private Button testMap;
    @RegisterView(id = R.id.testFlatMap)
    private Button testFlatMap;
    @RegisterView(id = R.id.testGroupBy)
    private Button testGroupBy;
    @RegisterView(id = R.id.testScan)
    private Button testScan;
    @RegisterView(id = R.id.testBuffer)
    private Button testBuffer;
    @RegisterView(id = R.id.testWindow)
    private Button testWindow;
    @RegisterView(id = R.id.testDebounce)
    private Button testDebounce;
    @RegisterView(id = R.id.testDistinct)
    private Button testDistinct;
    @RegisterView(id = R.id.testElementAt)
    private Button testElementAt;
    @RegisterView(id = R.id.testFilter)
    private Button testFilter;
    @RegisterView(id = R.id.testFirst)
    private Button testFirst;
    @RegisterView(id = R.id.testIgnoreElements)
    private Button testIgnoreElements;
    @RegisterView(id = R.id.testLast)
    private Button testLast;
    @RegisterView(id = R.id.testSample)
    private Button testSample;
    @RegisterView(id = R.id.testSkip)
    private Button testSkip;
    @RegisterView(id = R.id.testSkipLast)
    private Button testSkipLast;
    @RegisterView(id = R.id.testMerga)
    private Button testMerga;
    @RegisterView(id = R.id.testZip)
    private Button testZip;
    @RegisterView(id = R.id.testStartWith)
    private Button testStartWith;
    @RegisterView(id = R.id.testJoin)
    private Button testJoin;
    @RegisterView(id = R.id.testConbineLates)
    private Button testConbineLates;

    @RegisterView(id = R.id.testTvContent)
    private TextView testTvContent;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_rxjava;
    }

    @Override
    protected void initContentComponentValue() {

    }

    @Override
    protected void createListeners() {
        testRxjava1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //rxjava观察者模式 事件发射
                Observable<String> observable = getObservable();
                Observer<String> observer = getObserver();
                observable.subscribe(observer);
            }
        });
        testRxjava2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //rxjava 链式调用
                Observable.create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observable subscribe########");
                        emitter.onNext("创建的时候传入ObservableOnSubscribe接口");
                        emitter.onNext("订阅了一个观察者");
                        emitter.onNext("订阅之后带上发射器接口回调");
                        emitter.onNext("发射器发射消息回调到观察者的方法");
                        emitter.onComplete();
                    }
                }).subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        OsduiLog.mtuiHintLog(TAG,"########Observer onSubscribe########");
                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        OsduiLog.mtuiHintLog(TAG,"########Observer onNext########"+s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }
        });
        testRxjava3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //rxjava 选择调用  下面4个对应的回调方法 可以单独组合运用
                Observable.create(new ObservableOnSubscribe<String>() {

                    @Override
                    public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer subscribe########");
                        emitter.onNext("创建的时候传入ObservableOnSubscribe接口");
                        emitter.onNext("订阅了一个观察者");
                        emitter.onNext("订阅之后带上发射器接口回调");
                        emitter.onNext("发射器发射消息回调到观察者的方法");
                        emitter.onComplete();
                    }
                }).subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer accept（onNext）########"+ s);
                    }
                }, new Consumer<Throwable>() {

                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer accept（onError）########");
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer run（onComplete）########");
                    }
                }, new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer accept（onSubscribe）########");
                    }
                });
            }
        });
        testRxjava3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //rxjava 线程调度器
                Observable.create(new ObservableOnSubscribe<String>() {
                    //默认在主线程运行
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {

                    }
                })//被观察着切换到io子线程
                .subscribeOn(Schedulers.io())
                //观察者切换到UI主线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }
        });
        testRxjava5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //rxjava  事件调节器compositeDisposable
                Disposable subscribe = Observable.create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {

                    }
                }).subscribe(
                        new Consumer<String>() {
                            @Override
                            public void accept(@NonNull String s) throws Exception {
                                //对应onNext()
                                System.out.println("accept=" + s);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(@NonNull Throwable throwable) throws Exception {
                                //对应onError()
                            }
                        }, new Action() {
                            @Override
                            public void run() throws Exception {
                                //对应onComplete()
                            }
                        }, new Consumer<Disposable>() {
                            @Override
                            public void accept(@NonNull Disposable disposable) throws Exception {
                                //对应onSubscribe()
                            }
                        });
                compositeDisposable.add(subscribe);
                compositeDisposable.clear();
            }
        });

        //操作符
        testRxCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                        for (int i = 0; i < 5; i++) {
                            emitter.onNext(i);
                        }
                        emitter.onComplete();
                    }
                }).subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer accept########" + integer.intValue());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer onComplete########" );
                    }
                });
            }
        });
        testRxFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.fromArray(new Integer[]{0,1,2,3,4}).subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer accept########" + integer.intValue());
                    }
                });
            }
        });
        testRxJust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.just(1,2,3,4).subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer accept########" + integer.intValue());
                    }
                });
            }
        });
        testRxDefer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里just已经发送
                Observable<Integer> just = Observable.just(i,i);
                Observable<Object> defer = Observable.defer(new Callable<ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> call() throws Exception {
                        //缓存数据流 这里还没有发送 必须在订阅之后发送
                        return Observable.just(i,i);
                    }
                });

                i = 15;

                just.subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        //这里由于i = 10 已经发送 这里的输出是10
                        OsduiLog.mtuiHintLog(TAG,"########Observer just accept########" + integer.intValue());
                    }
                });

                defer.subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        //这里在订阅之后，全局变量i由于 10到15  这里的输出为15 这里才去回调call方法 拿到的值是15
                        OsduiLog.mtuiHintLog(TAG,"########Observer defer accept########" + (int)o);
                    }
                });

                i = 20;

                defer.subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        //同理这里才回调call方法 使用的是当前i的值
                        OsduiLog.mtuiHintLog(TAG,"########Observer defer accept########" + (int)o);
                    }
                });
            }
        });
        testRxInterval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //第一个参数是时间单位周期，第二个参数是间隔时间单位 （每间隔2秒+1） 无限增值
                Observable.interval(2, TimeUnit.SECONDS).subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer interval accept########" + aLong);
                    }
                });
            }
        });
        testRange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //起始位置与长度
                Observable.range(10,5).subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer range accept########" + integer);
                    }
                });
            }
        });
        testRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //重复3次的range
                Observable.range(1,3).repeat(3).subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer repeat accept########" + integer);
                    }
                });
            }
        });
        testTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OsduiLog.mtuiHintLog(TAG,"########Observer timer start########");
                Observable.timer(5,TimeUnit.SECONDS).subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer timer accept########" + aLong);
                    }
                });
            }
        });
        testMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.just(11).map(new Function<Integer, String>() {
                    @Override
                    public String apply(@NonNull Integer integer) throws Exception {
                        return "转化为string"+integer;
                    }
                }).subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer map accept########" + s);
                    }
                });
            }
        });
        testFlatMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里的flatMap 返回的类型？ 需要指定 不然一直报错
                Observable.just(new UserParams("hutao","123456")).flatMap(new Function<UserParams, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(@NonNull UserParams userParams) throws Exception {
                        return Observable.just(userParams.getUserName() + "suc").delay(2, TimeUnit.SECONDS);
                    }
                }).subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer flatMap accept########" + s);
                    }
                });
            }
        });
        testGroupBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.just("hutao","hujin","jangbing","jangmeiz","康迪").groupBy(new Function<String, Character>() {
                    @Override
                    public Character apply(@NonNull String s) throws Exception {
                        return s.charAt(0);
                    }
                }).subscribe(new Consumer<GroupedObservable<Character, String>>() {
                    @Override
                    public void accept(GroupedObservable<Character, String> characterStringGroupedObservable) throws Exception {
                        characterStringGroupedObservable.sorted().subscribe(new Consumer<String>() {
                            @Override
                            public void accept(String s) throws Exception {
                                OsduiLog.mtuiHintLog(TAG,"########Observer groupBy accept########" + s);
                            }
                        });
                    }
                });
            }
        });
        testScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.just(1,34,21,111,25).scan(new BiFunction<Integer, Integer, Integer>() {
                    @NonNull
                    @Override
                    public Integer apply(@NonNull Integer integer, @NonNull Integer integer2) throws Exception {
                        return integer > integer2 ? integer : integer2;
                    }
                }).subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer scan accept########" + integer);
                    }
                });
            }
        });
        testBuffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.just(1,2,3,4,5,6,7,8).buffer(5,2).subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(List<Integer> integers) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer buffer accept########" + integers.toString());
                    }
                });
            }
        });
        testWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.just(1,2,3,4,5,6,7,8).window(5,2).subscribe(new Consumer<Observable<Integer>>() {
                    @Override
                    public void accept(Observable<Integer> integerObservable) throws Exception {
                        integerObservable.subscribe(new Consumer<Integer>() {
                            @Override
                            public void accept(Integer integer) throws Exception {
                                OsduiLog.mtuiHintLog(TAG,"########Observer window accept########" + integer);
                            }
                        });
                    }
                });
            }
        });

        testDebounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                        for (int j = 0; j < 100; j++) {
                            if (j % 3 == 0){
                                Thread.sleep(3000);
                            }else{
                                Thread.sleep(1000);
                            }
                            emitter.onNext(j);
                        }
                    }
                }).debounce(2,TimeUnit.SECONDS).subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer debounce accept########" + integer);
                    }
                });
            }
        });
        testDistinct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.just(1,2,3,5,3,7,7,8).distinct().subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer distinct accept########" + integer);
                    }
                });
            }
        });

        testElementAt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.just(1,2,3,5,3,7,7,8).elementAt(1).subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer elementAt accept########" + integer);
                    }
                });
            }
        });
        testFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.just(1,5,6,2,3,4).filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(@NonNull Integer integer) throws Exception {
                        return integer > 2;
                    }
                }).subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer filter accept########" + integer);
                    }
                });
            }
        });
        testFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.just(1,5,6,2,3,4).first(1).subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer first accept########" + integer);
                    }
                });
            }
        });
        testIgnoreElements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.just(1,5,6,2,3,4).ignoreElements().subscribe(new Action() {
                    @Override
                    public void run() throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer ignoreElements onComplete########");
                    }
                });
            }
        });
        testLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.just(1,5,6,2,3,4).last(1).subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer last accept########" + integer);
                    }
                });
            }
        });
        testSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.interval(1,TimeUnit.SECONDS).sample(2,TimeUnit.SECONDS).subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer sample accept########" + aLong);
                    }
                });
            }
        });
        testSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.just(1,2,3,4,5,6).skip(3).subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer skip accept########" + integer);
                    }
                });
            }
        });
        testSkipLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.just(1,2,3,4,5,6).skipLast(3).subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer skipLast accept########" + integer);
                    }
                });
            }
        });

        testMerga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable<String> just1 = Observable.just("A","B","C");
                Observable<Integer> just2 = Observable.just(1,2,3);
                Observable.merge(just1,just2).subscribe(new Consumer<Serializable>() {
                    @Override
                    public void accept(Serializable serializable) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer merge accept########" + serializable.toString());
                    }
                });
            }
        });
        testZip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable<String> just1 = Observable.just("A","B","C");
                Observable<Integer> just2 = Observable.just(1,2,3);
                Observable.zip(just1, just2, new BiFunction<String, Integer, String>() {
                    @NonNull
                    @Override
                    public String apply(@NonNull String s, @NonNull Integer integer) throws Exception {
                        return s+integer;
                    }
                }).subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer zip accept########" + s);
                    }
                });
            }
        });
        testStartWith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable<String> just1 = Observable.just("A","B","C");
                Observable<String> just2 = Observable.just("1","2","3");
                just1.startWith(just2).subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer startWith accept########" + s);
                    }
                });
            }
        });
        testJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable<String> just1 = Observable.just("A","B","C","E","F","G");
                Observable<Long> just2 = Observable.interval(1,TimeUnit.SECONDS);
                just1.join(just2, new Function<String, ObservableSource<Long>>() {
                    @Override
                    public ObservableSource<Long> apply(@NonNull String s) throws Exception {
                        return Observable.timer(3,TimeUnit.SECONDS);
                    }
                }, new Function<Long, ObservableSource<Long>>() {
                    @Override
                    public ObservableSource<Long> apply(@NonNull Long l) throws Exception {
                        return Observable.timer(8,TimeUnit.SECONDS);
                    }
                }, new BiFunction<String, Long, String>() {
                    @NonNull
                    @Override
                    public String apply(@NonNull String s, @NonNull Long l) throws Exception {
                        return s+l;
                    }
                }).subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer join accept########" + s);
                    }
                });
            }
        });

        testConbineLates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] str = new String[]{"A","B","C","E","F","G"};
                Observable<String> just1 = Observable.interval(1, TimeUnit.SECONDS).map(new Function<Long, String>() {
                    @Override
                    public String apply(Long aLong) throws Exception {
                        return str[(int) (aLong % 5)];
                    }
                });
                Observable<Long> just2 = Observable.interval(1, TimeUnit.SECONDS);

                Observable.combineLatest(just1, just2, new BiFunction<String, Long, String>() {
                    @Override
                    public String apply(String s, Long l) throws Exception {
                        return s + l;
                    }
                }).subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        OsduiLog.mtuiHintLog(TAG,"########Observer combineLatest accept########" + s);
                    }
                });
            }
        });
    }



    int i = 10;
    /**
     * @description 获取rxjava创建的观察者对象
     * @param
     * @return
     * @author hutao
     * @time 2021/9/17 14:02
     */
    private Observer<String> getObserver() {
        return new Observer<String>() {
            Disposable disposable = null;
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                //观察者被订阅回调
                OsduiLog.mtuiHintLog(TAG,"########Observer onSubscribe########");
                disposable = d;
            }

            @Override
            public void onNext(@NonNull String s) {
                //观察者接受到发布onNext方法回调
                OsduiLog.mtuiHintLog(TAG,"########Observer onNext########"+s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                //观察者接收onError方法回调
                OsduiLog.mtuiHintLog(TAG,"########Observer onError########");
            }

            @Override
            public void onComplete() {
                //观察者接收onComplete方法回调
                OsduiLog.mtuiHintLog(TAG,"########Observer onComplete########");
            }
        };
    }
    /**
     * @description 获取rxjava创建的被观察者对象
     * @param 
     * @return 
     * @author hutao
     * @time 2021/9/17 14:02
     */
    private Observable<String> getObservable() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            /**
             * @description 该方法在主线程运行
             * @param emitter 事件发射器
             * @return io.reactivex.Observable<java.lang.String>
             * @author hutao
             * @time 2021/9/17 14:33
             */
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                OsduiLog.mtuiHintLog(TAG,"########Observable subscribe########");
                emitter.onNext("创建的时候传入ObservableOnSubscribe接口");
                emitter.onNext("订阅了一个观察者");
                emitter.onNext("订阅之后带上发射器接口回调");
                emitter.onNext("发射器发射消息回调到观察者的方法");
                emitter.onComplete();
            }
        });
    }
}