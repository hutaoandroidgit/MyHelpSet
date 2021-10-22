package com.hutao.myhelpset.mode;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.hutao.helplibrary.log.OsduiLog;
import com.hutao.myhelpset.R;
import com.hutao.myhelpset.base.BaseActivity;
import com.hutao.myhelpset.mode.action_mode.commondmode.Command;
import com.hutao.myhelpset.mode.action_mode.commondmode.Invoker;
import com.hutao.myhelpset.mode.action_mode.commondmode.Receiver;
import com.hutao.myhelpset.mode.action_mode.commondmode.ShutdownCommand;
import com.hutao.myhelpset.mode.action_mode.handlerlinkmode.BJPostman;
import com.hutao.myhelpset.mode.action_mode.handlerlinkmode.GZPostman;
import com.hutao.myhelpset.mode.action_mode.handlerlinkmode.Postman;
import com.hutao.myhelpset.mode.action_mode.handlerlinkmode.SHPostman;
import com.hutao.myhelpset.mode.action_mode.interpretermode.Calculator;
import com.hutao.myhelpset.mode.action_mode.iteratormode.Aggragate;
import com.hutao.myhelpset.mode.action_mode.iteratormode.Iterator;
import com.hutao.myhelpset.mode.action_mode.iteratormode.PackageAggragate;
import com.hutao.myhelpset.mode.action_mode.mediatormode.Landlord;
import com.hutao.myhelpset.mode.action_mode.mediatormode.Lianjia;
import com.hutao.myhelpset.mode.action_mode.mediatormode.Purchaser;
import com.hutao.myhelpset.mode.action_mode.mementomode.Caretaker;
import com.hutao.myhelpset.mode.action_mode.mementomode.Game;
import com.hutao.myhelpset.mode.action_mode.mementomode.Memento;
import com.hutao.myhelpset.mode.action_mode.observermode.newdemo.Boy;
import com.hutao.myhelpset.mode.action_mode.observermode.newdemo.Gril;
import com.hutao.myhelpset.mode.action_mode.observermode.newdemo.Observable;
import com.hutao.myhelpset.mode.action_mode.observermode.newdemo.Observer;
import com.hutao.myhelpset.mode.action_mode.observermode.newdemo.Postman2;
import com.hutao.myhelpset.mode.action_mode.statemode.StateContext;
import com.hutao.myhelpset.mode.action_mode.stragetymode.Context;
import com.hutao.myhelpset.mode.action_mode.stragetymode.EattingStragety;
import com.hutao.myhelpset.mode.action_mode.stragetymode.MovieStragety;
import com.hutao.myhelpset.mode.action_mode.stragetymode.ShoopingStragety;
import com.hutao.myhelpset.mode.action_mode.templatemode.PostToA;
import com.hutao.myhelpset.mode.action_mode.templatemode.PostToB;
import com.hutao.myhelpset.mode.action_mode.templatemode.PostmanTemplate;
import com.hutao.myhelpset.mode.action_mode.visitormode.Busy;
import com.hutao.myhelpset.mode.action_mode.visitormode.Idler;
import com.hutao.myhelpset.mode.action_mode.visitormode.Music;
import com.hutao.myhelpset.mode.action_mode.visitormode.Video;
import com.hutao.myhelpset.mode.action_mode.visitormode.Visitor;
import com.hutao.myhelpset.mode.action_mode.visitormode.Websites;
import com.hutao.myhelpset.mode.create_mode.abstractfactorymode.AsusComptuer;
import com.hutao.myhelpset.mode.create_mode.abstractfactorymode.ComputerFactory;
import com.hutao.myhelpset.mode.create_mode.abstractfactorymode.HpComptuer;
import com.hutao.myhelpset.mode.create_mode.abstractfactorymode.LenovoComptuer;
import com.hutao.myhelpset.mode.create_mode.buildermode.Builder;
import com.hutao.myhelpset.mode.create_mode.buildermode.Computer;
import com.hutao.myhelpset.mode.create_mode.buildermode.ConcreteBuilder;
import com.hutao.myhelpset.mode.create_mode.buildermode.Director;
import com.hutao.myhelpset.mode.create_mode.easyfactorymode.EasyFactory;
import com.hutao.myhelpset.mode.create_mode.easyfactorymode.EasyFactory2;
import com.hutao.myhelpset.mode.create_mode.easyfactorymode.ProductA;
import com.hutao.myhelpset.mode.create_mode.easyfactorymode.ProductB;
import com.hutao.myhelpset.mode.create_mode.factorymode.Factory;
import com.hutao.myhelpset.mode.create_mode.factorymode.FactoryA;
import com.hutao.myhelpset.mode.create_mode.factorymode.FactoryB;
import com.hutao.myhelpset.mode.create_mode.factorymode.MyThreadFactory;
import com.hutao.myhelpset.mode.create_mode.factorymode.Product;
import com.hutao.myhelpset.mode.create_mode.prototypemode.Card;
import com.hutao.myhelpset.mode.create_mode.singelmode.Singleton;
import com.hutao.myhelpset.mode.structure_mode.adaptermode.Adapter;
import com.hutao.myhelpset.mode.structure_mode.adaptermode.Electric;
import com.hutao.myhelpset.mode.structure_mode.adaptermode.PhoneAdapter;
import com.hutao.myhelpset.mode.structure_mode.adaptermode.PhoneAdapter2;
import com.hutao.myhelpset.mode.structure_mode.bridgemode.Clothes;
import com.hutao.myhelpset.mode.structure_mode.bridgemode.Coder;
import com.hutao.myhelpset.mode.structure_mode.bridgemode.Person4;
import com.hutao.myhelpset.mode.structure_mode.bridgemode.Shirt;
import com.hutao.myhelpset.mode.structure_mode.bridgemode.Student;
import com.hutao.myhelpset.mode.structure_mode.bridgemode.Uniform;
import com.hutao.myhelpset.mode.structure_mode.composemode.Column;
import com.hutao.myhelpset.mode.structure_mode.composemode.Content;
import com.hutao.myhelpset.mode.structure_mode.composemode.PageElement;
import com.hutao.myhelpset.mode.structure_mode.decoratormode.Bedroom;
import com.hutao.myhelpset.mode.structure_mode.decoratormode.DecoratorRoom;
import com.hutao.myhelpset.mode.structure_mode.decoratormode.Kitchen;
import com.hutao.myhelpset.mode.structure_mode.decoratormode.NewRoom;
import com.hutao.myhelpset.mode.structure_mode.decoratormode.Room;
import com.hutao.myhelpset.mode.structure_mode.facademode.GameSdk;
import com.hutao.myhelpset.mode.structure_mode.flyweightmode.BikeFactory;
import com.hutao.myhelpset.mode.structure_mode.flyweightmode.IBike;
import com.hutao.myhelpset.mode.structure_mode.proxymode.Domestic;
import com.hutao.myhelpset.mode.structure_mode.proxymode.DynamicProxy;
import com.hutao.myhelpset.mode.structure_mode.proxymode.Oversea;
import com.hutao.myhelpset.mode.structure_mode.proxymode.People;
import com.hutao.myhelpset.tool.annotation.RegisterView;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.concurrent.ThreadFactory;

/**
 * @author: hutao
 * @date: 2021/10/19
 */
public class TestActivity extends BaseActivity {
    @RegisterView(id = R.id.btnSingelton)
    private Button btnSingelton;
    @RegisterView(id = R.id.btnBuild)
    private Button btnBuild;
    @RegisterView(id = R.id.btnAndroidBuild)
    private Button btnAndroidBuild;
    @RegisterView(id = R.id.btnFactory)
    private Button btnFactory;
    @RegisterView(id = R.id.btnThreadFactory)
    private Button btnThreadFactory;
    @RegisterView(id = R.id.btnEasyFactory)
    private Button btnEasyFactory;
    @RegisterView(id = R.id.btnEasyFactory2)
    private Button btnEasyFactory2;
    @RegisterView(id = R.id.btnAbstractFactory)
    private Button btnAbstractFactory;
    @RegisterView(id = R.id.btnPrototype)
    private Button btnPrototype;
    @RegisterView(id = R.id.btnClone)
    private Button btnClone;
    @RegisterView(id = R.id.btnStragety)
    private Button btnStragety;
    @RegisterView(id = R.id.btnState)
    private Button btnState;
    @RegisterView(id = R.id.btnHandlerLink)
    private Button btnHandlerLink;
    @RegisterView(id = R.id.btnObserver)
    private Button btnObserver;
    @RegisterView(id = R.id.btnTemplate)
    private Button btnTemplate;
    @RegisterView(id = R.id.btnIterator)
    private Button btnIterator;
    @RegisterView(id = R.id.btnMemento)
    private Button btnMemento;
    @RegisterView(id = R.id.btnVisitor)
    private Button btnVisitor;
    @RegisterView(id = R.id.btnMediator)
    private Button btnMediator;
    @RegisterView(id = R.id.btnInterpreter)
    private Button btnInterpreter;
    @RegisterView(id = R.id.btnCommand)
    private Button btnCommand;
    @RegisterView(id = R.id.btnProxy)
    private Button btnProxy;
    @RegisterView(id = R.id.btnDynamicProxy)
    private Button btnDynamicProxy;
    @RegisterView(id = R.id.btnCompose)
    private Button btnCompose;
    @RegisterView(id = R.id.btnAdapter)
    private Button btnAdapter;
    @RegisterView(id = R.id.btnDecoretor)
    private Button btnDecoretor;
    @RegisterView(id = R.id.btnFlyweight)
    private Button btnFlyweight;
    @RegisterView(id = R.id.btnFacade)
    private Button btnFacade;
    @RegisterView(id = R.id.btnBridge)
    private Button btnBridge;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initContentComponentValue() {

    }

    @Override
    protected void createListeners() {
        btnSingelton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //单例反射破坏
                try {
                    testSingelton();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        });
        btnBuild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //测试创建者模式
                Builder builder = new ConcreteBuilder(); //创建建造者实例，（装机人员）
                Director director= new Director(builder); //创建指挥者实例，并分配相应的建造者，（老板分配任务）
                Computer computer = director.Construct("i7","三星DDR4","长虹"); //组装电脑
                OsduiLog.mtuiHintLog(TAG,computer.toString());
            }
        });
        btnAndroidBuild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TestActivity.this);//创建一个Builder对象
                builder.setIcon(R.drawable.wifi);
                builder.setTitle("标题");
                builder.setMessage("信息");
                builder.setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                AlertDialog alertDialog = builder.create();//创建AlertDialog对象
                alertDialog.show();//展示AlertDialog
            }
        });
        btnFactory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //产品A
                Factory factoryA = new FactoryA();
                Product productA = factoryA.create();
                productA.show();
                //产品B
                Factory factoryB = new FactoryB();
                Product productB = factoryB.create();
                productB.show();
            }
        });
        btnThreadFactory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //线程工厂MyThreadFactory
                ThreadFactory myThreadFactory = new MyThreadFactory();
                //产品线程 MyThread
                Thread myThread = myThreadFactory.newThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("异步线程"+i);
                        }
                    }
                });
                myThread.start();
            }
        });
        btnEasyFactory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EasyFactory.create("A").show();//生产ProductA
                EasyFactory.create("B").show();//生产ProductB
                try {
                    EasyFactory.create("C").show();//生产ProductC
                }catch (Exception e){
                    System.out.println("没有产品C");//没有ProductC,会报错
                }
            }
        });
        btnEasyFactory2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EasyFactory2.create(ProductA.class).show();
                EasyFactory2.create(ProductB.class).show();
            }
        });

        btnAbstractFactory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("--------------------生产联想电脑-----------------------");
                ComputerFactory mLenovoComptuer = new LenovoComptuer();
                mLenovoComptuer.createCPU().showCPU();
                mLenovoComptuer.createMemory().showMemory();
                mLenovoComptuer.createHD().showHD();
                System.out.println("--------------------生产华硕电脑-----------------------");
                ComputerFactory mAsusComptuer = new AsusComptuer();
                mAsusComptuer.createCPU().showCPU();
                mAsusComptuer.createMemory().showMemory();
                mAsusComptuer.createHD().showHD();
                System.out.println("--------------------生产惠普电脑-----------------------");
                ComputerFactory mHpComptuer = new HpComptuer();
                mHpComptuer.createCPU().showCPU();
                mHpComptuer.createMemory().showMemory();
                mHpComptuer.createHD().showHD();
            }
        });
        btnPrototype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Card card1 = new Card();
                card1.setNum(1211);
                card1.setSpec(20,20);
                System.out.println(card1.toString());
                System.out.println("----------------------");

                try {
                    Card card2 = card1.clone();
                    System.out.println(card2.toString());
                    System.out.println("----------------------");
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        });
        btnClone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Card card1 = new Card();
                card1.setNum(1211);
                card1.setSpec(20,20);
                System.out.println(card1.toString());
                System.out.println("----------------------");

                try {
                    Card card2 = card1.clone();
                    System.out.println(card2.toString());
                    System.out.println("----------------------");

                    card2.setNum(3333);
                    System.out.println(card1.toString());
                    System.out.println(card2.toString());
                    System.out.println("----------------------");

                    card2.setSpec(30,30);
                    System.out.println(card1.toString());
                    System.out.println(card2.toString());
                    System.out.println("----------------------");
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        });
        btnStragety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context;
                System.out.println("遇到爱逛街的妹子:");
                context = new Context(new ShoopingStragety());
                context.chase();
                System.out.println("遇到爱看电影的妹子:");
                context = new Context(new MovieStragety());
                context.chase();
                System.out.println("遇到吃货妹子:");
                context = new Context(new EattingStragety());
                context.chase();
            }
        });

        btnState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StateContext stateContext = new StateContext();
                stateContext.fallInLove();
                stateContext.movies();
                stateContext.shooping();
                stateContext.outLove();
                stateContext.movies();
                stateContext.shooping();
            }
        });

        btnHandlerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建不同的快递员对象
                Postman bjPostman = new BJPostman();
                Postman shPostman = new SHPostman();
                Postman gzPostman = new GZPostman();
                //由于这里上包外访问父类 protected 属性  所以. 不出来  改为public
                bjPostman.nextPostman = shPostman;
                shPostman.nextPostman = gzPostman;

                //处理不同地区的快递，都是从首结点北京快递员开始
                System.out.println("有一个上海快递需要派送:");
                bjPostman.handlerCourrier("SH");
                System.out.println("有一个广州快递需要派送:");
                bjPostman.handlerCourrier("GZ");
                System.out.println("有一个美国快递需要派送:");
                bjPostman.handlerCourrier("USA");
            }
        });

        btnObserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable observable = new Postman2();
                Observer boy = new Boy("hutao");
                Observer gril = new Gril("jmz");

                observable.add(boy);
                observable.add(gril);

                observable.notfiy("快递到了,请下楼领取.");
            }
        });
        btnTemplate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("----派送A----");
                PostmanTemplate postmanTemplateA = new PostToA();
                postmanTemplateA.psot();

                System.out.println("----派送B----");
                PostmanTemplate postmanTemplateB = new PostToB();
                postmanTemplateB.psot();
            }
        });

        btnIterator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aggragate aggragate = new PackageAggragate();
                aggragate.add("11111111111");
                aggragate.add("11111111112");
                aggragate.add("11111111113");

                Iterator iterator = aggragate.iteretor();
                while (iterator.hasNext()){
                    String tel = (String) iterator.next();
                    System.out.println("当前号码为："+tel);
                }
                System.out.println("后面没有了");
            }
        });
        btnMemento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("首次进入游戏");
                Game game = new Game();
                game.play();//玩游戏
                Memento memento = game.createMemento();//创建存档
                Caretaker caretaker = new Caretaker();
                caretaker.setMemento(memento);
                game.exit();//退出游戏

                System.out.println("-------------");

                System.out.println("二次进入游戏");
                Game secondGame = new Game();
                secondGame.setMemento(caretaker.getMemento());//读取存档
                secondGame.play();//继续玩游戏
                secondGame.exit();//不存档
            }
        });

        btnVisitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建不同的元素
                Music wyy = new Music("网易云");
                Music kugou = new Music("酷狗");
                Video youke = new Video("优酷");
                Video iqiyi = new Video("爱奇艺");
                //放入对象结构中
                Websites websites = new Websites();
                websites.addWeb(wyy);
                websites.addWeb(kugou);
                websites.addWeb(youke);
                websites.addWeb(iqiyi);

                Visitor idler = new Idler("闲人1号");
                websites.acceptAll(idler);//集合接受idler1的访问

                Visitor busy = new Busy("忙人1号");
                websites.acceptAll(busy);//集合接受busy1的访问
            }
        });

        btnMediator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lianjia lianjia = new Lianjia();
                Purchaser purchaser = new Purchaser(lianjia);
                Landlord landlord = new Landlord(lianjia);
                lianjia.setLandlord(landlord);
                lianjia.setPurchaser(purchaser);

                landlord.send("出售一套别墅");
                System.out.println("------------------------");
                purchaser.send("求购一套学区房");
            }
        });

        btnInterpreter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculator calculator = new Calculator();
                calculator.read("a = 1024");//读取表达式
                calculator.read("b = 512");
                System.out.println("a = 1024");
                System.out.println("b = 512");

                calculator.read("a + b");
                System.out.println("a + b = " + calculator.calculate());//计算结果
                calculator.read("a - b");
                System.out.println("a - b = " + calculator.calculate());

            }
        });

        btnCommand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Receiver receiver = new Receiver();//创建命令接收者
                Command command = new ShutdownCommand(receiver);//创建一个命令的具体实现对象，并指定命令接收者
                Invoker invoker = new Invoker(command);//创建一个命令调用者，并指定具体命令
                invoker.action();//发起调用命令请求
            }
        });

        btnProxy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                People mDomestic = new Domestic();//创建国内购买人
                People mOversea = new Oversea(mDomestic);//创建海外代购类并将domestic作为构造函数传递
                mOversea.buy(); //调用海外代购的buy()
            }
        });

        btnDynamicProxy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                People mDomestic = new Domestic();//创建国内购买人
                DynamicProxy dynamicProxy = new DynamicProxy(mDomestic); //创建动态代理
                ClassLoader classLoader = mDomestic.getClass().getClassLoader();  //获取ClassLoader
                //通过 Proxy 创建海外代购实例 ，实际上通过反射来实现的
                People mOversea = (People) Proxy.newProxyInstance(classLoader, new Class[]{People.class}, dynamicProxy);
                mOversea.buy();
            }
        });

        btnCompose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建网站根页面 root
                PageElement root = new Column("网站页面");
                //网站页面添加两个栏目：音乐,视屏;以及一个广告内容。
                PageElement music = new Column("音乐");
                PageElement video = new Column("视屏");
                PageElement ad = new Content("广告");
                root.addPageElement(music);
                root.addPageElement(video);
                root.addPageElement(ad);
                //音乐栏目添加两个子栏目：国语,粤语
                PageElement chineseMusic = new Column("国语");
                PageElement cantoneseMusic = new Column("粤语");
                music.addPageElement(chineseMusic);
                music.addPageElement(cantoneseMusic);
                //国语,粤语栏目添加具体内容
                chineseMusic.addPageElement(new Content("十年.mp3"));
                cantoneseMusic.addPageElement(new Content("明年今日.mp3"));
                //视频栏目添加具体内容
                video.addPageElement(new Content("唐伯虎点秋香.avi"));

                //打印整个页面的内容
                root.print("");
            }
        });

        btnAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Electric electric = new Electric();
                System.out.println("默认电压：" + electric.output_220v());
                Adapter phoneAdapter = new PhoneAdapter(electric);//传递一个对象给适配器
                System.out.println("适配转换后的电压：" + phoneAdapter.convert_5v());

                Adapter phoneAdapter2 = new PhoneAdapter2();
                System.out.println("适配转换后的电压：" + phoneAdapter2.convert_5v());
            }
        });

        btnDecoretor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Room room = new NewRoom();//有一间新房间
                DecoratorRoom bedroom = new Bedroom(room);
                bedroom.fitment();//装修成卧室
                DecoratorRoom kitchen = new Kitchen(room);
                kitchen.fitment();//装修成厨房
            }
        });
        btnFlyweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BikeFactory bikeFactory = new BikeFactory();
                IBike ofo = bikeFactory.getBike("ofo");
                ofo.billing(2);
                IBike mobike = bikeFactory.getBike("Mobike");
                mobike.billing(1);
                IBike ofo1 = bikeFactory.getBike("ofo");
                ofo1.billing(3);
            }
        });

        btnFacade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里是游戏研发，通过调用login()和pay()就能调起登录和支付，无需关心支付是使用支付宝还是威信等，这是游戏SDK里面去做的事。
                GameSdk gameSdk = new GameSdk();
                gameSdk.login();
                gameSdk.pay(6);
            }
        });
        btnBridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建各种衣服对象
                Clothes uniform = new Uniform();
                Clothes shirt = new Shirt();

                //不同职业的人穿衣服
                Person4 coder = new Coder();
                coder.setClothes(shirt);
                coder.dress();

                System.out.println("--------------------------------------");
                Person4 student = new Student();
                student.setClothes(uniform);
                student.dress();

                System.out.println("--------------------------------------");
                student.setClothes(shirt);
                student.dress();
            }
        });
    }

    private void testSingelton() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor con = Singleton.class.getDeclaredConstructor();
        con.setAccessible(true);
        // 通过反射获取实例
        Singleton singeton1 = (Singleton) con.newInstance();
        Singleton singeton2 = (Singleton) con.newInstance();
        System.out.println(singeton1==singeton2);//结果为false,singeton1和singeton2将是两个不同的实例
    }
}