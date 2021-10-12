package com.hutao.myhelpset.tool.rxjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.hutao.helplibrary.log.OsduiLog;
import com.hutao.myhelpset.R;
import com.hutao.myhelpset.base.BaseActivity;
import com.hutao.myhelpset.tool.annotation.RegisterView;

import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableOperator;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

/**
 * Rxjava高级运用
 * @author: hutao
 * @date: 2021/10/11
 */
public class RxJavaHighLevelActivity extends BaseActivity {
    @RegisterView(id = R.id.btnOperator)
    private Button btnOperation;
    @RegisterView(id = R.id.btnTransformer)
    private Button btnTransformer;
    @RegisterView(id = R.id.btnPlugin)
    private Button btnPlugin;
    @RegisterView(id = R.id.btnSubject)
    private Button btnSubject;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_rxjavahighlevel;
    }

    @Override
    protected void initContentComponentValue() {

    }

    @Override
    protected void createListeners() {
        btnOperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //自定义Operation  实现list 到string转换
                Observable.create(new ObservableOnSubscribe<List<String>>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<List<String>> emitter) throws Exception {
                        ArrayList<String> list = new ArrayList<>();

                        list.add("1");
                        list.add("2");
                        list.add("3");
                        list.add("4");

                        emitter.onNext(list);
                        emitter.onComplete();
                    }
                }).lift(new CustomOperator())
                        .subscribe(new Observer<String>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

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
                                OsduiLog.mtuiHintLog(TAG,"########Observer onComplete########");
                            }
                        });
            }
        });

        btnTransformer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                        emitter.onNext(1);
                        emitter.onNext(2);
                        emitter.onNext(3);
                    }
                }).compose(new CustomTransformer())
                        .subscribe(new Observer<String>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

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

        btnPlugin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxJavaPlugins.setOnObservableAssembly(new CustomAssembly());//任意操作符都有回调
                RxJavaPlugins.setOnObservableSubscribe(new CustomSubscribe());//每次subscribe时候有回调
                Observable<String> observable = getObservable();
                Observer<String> observer = getObserver();
                OsduiLog.mtuiHintLog("main",observable.toString());
                OsduiLog.mtuiHintLog("main",observer.toString());
                observable.subscribe(observer);


            }
        });

        btnSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*PublishSubject publishSubject = PublishSubject.create();
                publishSubject.subscribe(new SubjectObserver("frist"));
                publishSubject.onNext("1");
                publishSubject.onNext("2");
                publishSubject.subscribe(new SubjectObserver("seconde"));
                publishSubject.onNext("3");
                publishSubject.onComplete();*/

                /*BehaviorSubject behaviorSubjec = BehaviorSubject.createDefault("默认值");
                behaviorSubjec.subscribe(new SubjectObserver("frist"));
                behaviorSubjec.onNext("1");
                behaviorSubjec.onNext("2");
                behaviorSubjec.subscribe(new SubjectObserver("seconde"));
                behaviorSubjec.onNext("3");
                behaviorSubjec.onComplete();*/
                /*ReplaySubject replaySubject = ReplaySubject.create();
                replaySubject.subscribe(new SubjectObserver("frist"));
                replaySubject.onNext("1");
                replaySubject.onNext("2");
                replaySubject.subscribe(new SubjectObserver("seconde"));
                replaySubject.onNext("3");
                replaySubject.onComplete();*/

                /*AsyncSubject asyncSubject = AsyncSubject.create();
                asyncSubject.subscribe(new SubjectObserver("frist"));
                asyncSubject.onNext("1");
                asyncSubject.onNext("2");
                asyncSubject.onNext("3");
                asyncSubject.onComplete();
                asyncSubject.subscribe(new SubjectObserver("seconde"));
                asyncSubject.onComplete();*/


                //组件A 组件A发送数据给组件B
                Observable observableA = Observable.fromArray("123","456","789");
                ReplaySubject replaySubject = ReplaySubject.create();

                //组件A sub ReplaySubject
                observableA.subscribe(replaySubject);
                //ReplaySubject sub 组件B
                replaySubject.subscribe(new SubjectObserver("B"));
            }
        });
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
     * @description 自定义Transformer来实现我们常用的线程切场景
     * @param 
     * @return 
     * @author hutao
     * @time 2021/10/11 16:46
     */
    public static <T> ObservableTransformer<T,T> schedulersTransformer(){
        return new ObservableTransformer<T, T>() {
            @NonNull
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
    public static <T> FlowableTransformer<T,T> schedulersTransformerFlowable(){
        return new FlowableTransformer<T, T>() {
            @NonNull
            @Override
            public Publisher<T> apply(@NonNull Flowable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}