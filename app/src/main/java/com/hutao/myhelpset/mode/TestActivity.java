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
                //??????????????????
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
                //?????????????????????
                Builder builder = new ConcreteBuilder(); //??????????????????????????????????????????
                Director director= new Director(builder); //??????????????????????????????????????????????????????????????????????????????
                Computer computer = director.Construct("i7","??????DDR4","??????"); //????????????
                OsduiLog.mtuiHintLog(TAG,computer.toString());
            }
        });
        btnAndroidBuild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TestActivity.this);//????????????Builder??????
                builder.setIcon(R.drawable.wifi);
                builder.setTitle("??????");
                builder.setMessage("??????");
                builder.setPositiveButton("??????",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                AlertDialog alertDialog = builder.create();//??????AlertDialog??????
                alertDialog.show();//??????AlertDialog
            }
        });
        btnFactory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //??????A
                Factory factoryA = new FactoryA();
                Product productA = factoryA.create();
                productA.show();
                //??????B
                Factory factoryB = new FactoryB();
                Product productB = factoryB.create();
                productB.show();
            }
        });
        btnThreadFactory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //????????????MyThreadFactory
                ThreadFactory myThreadFactory = new MyThreadFactory();
                //???????????? MyThread
                Thread myThread = myThreadFactory.newThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("????????????"+i);
                        }
                    }
                });
                myThread.start();
            }
        });
        btnEasyFactory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EasyFactory.create("A").show();//??????ProductA
                EasyFactory.create("B").show();//??????ProductB
                try {
                    EasyFactory.create("C").show();//??????ProductC
                }catch (Exception e){
                    System.out.println("????????????C");//??????ProductC,?????????
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
                System.out.println("--------------------??????????????????-----------------------");
                ComputerFactory mLenovoComptuer = new LenovoComptuer();
                mLenovoComptuer.createCPU().showCPU();
                mLenovoComptuer.createMemory().showMemory();
                mLenovoComptuer.createHD().showHD();
                System.out.println("--------------------??????????????????-----------------------");
                ComputerFactory mAsusComptuer = new AsusComptuer();
                mAsusComptuer.createCPU().showCPU();
                mAsusComptuer.createMemory().showMemory();
                mAsusComptuer.createHD().showHD();
                System.out.println("--------------------??????????????????-----------------------");
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
                System.out.println("????????????????????????:");
                context = new Context(new ShoopingStragety());
                context.chase();
                System.out.println("???????????????????????????:");
                context = new Context(new MovieStragety());
                context.chase();
                System.out.println("??????????????????:");
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
                //??????????????????????????????
                Postman bjPostman = new BJPostman();
                Postman shPostman = new SHPostman();
                Postman gzPostman = new GZPostman();
                //????????????????????????????????? protected ??????  ??????. ?????????  ??????public
                bjPostman.nextPostman = shPostman;
                shPostman.nextPostman = gzPostman;

                //?????????????????????????????????????????????????????????????????????
                System.out.println("?????????????????????????????????:");
                bjPostman.handlerCourrier("SH");
                System.out.println("?????????????????????????????????:");
                bjPostman.handlerCourrier("GZ");
                System.out.println("?????????????????????????????????:");
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

                observable.notfiy("????????????,???????????????.");
            }
        });
        btnTemplate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("----??????A----");
                PostmanTemplate postmanTemplateA = new PostToA();
                postmanTemplateA.psot();

                System.out.println("----??????B----");
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
                    System.out.println("??????????????????"+tel);
                }
                System.out.println("???????????????");
            }
        });
        btnMemento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("??????????????????");
                Game game = new Game();
                game.play();//?????????
                Memento memento = game.createMemento();//????????????
                Caretaker caretaker = new Caretaker();
                caretaker.setMemento(memento);
                game.exit();//????????????

                System.out.println("-------------");

                System.out.println("??????????????????");
                Game secondGame = new Game();
                secondGame.setMemento(caretaker.getMemento());//????????????
                secondGame.play();//???????????????
                secondGame.exit();//?????????
            }
        });

        btnVisitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //?????????????????????
                Music wyy = new Music("?????????");
                Music kugou = new Music("??????");
                Video youke = new Video("??????");
                Video iqiyi = new Video("?????????");
                //?????????????????????
                Websites websites = new Websites();
                websites.addWeb(wyy);
                websites.addWeb(kugou);
                websites.addWeb(youke);
                websites.addWeb(iqiyi);

                Visitor idler = new Idler("??????1???");
                websites.acceptAll(idler);//????????????idler1?????????

                Visitor busy = new Busy("??????1???");
                websites.acceptAll(busy);//????????????busy1?????????
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

                landlord.send("??????????????????");
                System.out.println("------------------------");
                purchaser.send("?????????????????????");
            }
        });

        btnInterpreter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculator calculator = new Calculator();
                calculator.read("a = 1024");//???????????????
                calculator.read("b = 512");
                System.out.println("a = 1024");
                System.out.println("b = 512");

                calculator.read("a + b");
                System.out.println("a + b = " + calculator.calculate());//????????????
                calculator.read("a - b");
                System.out.println("a - b = " + calculator.calculate());

            }
        });

        btnCommand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Receiver receiver = new Receiver();//?????????????????????
                Command command = new ShutdownCommand(receiver);//??????????????????????????????????????????????????????????????????
                Invoker invoker = new Invoker(command);//???????????????????????????????????????????????????
                invoker.action();//????????????????????????
            }
        });

        btnProxy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                People mDomestic = new Domestic();//?????????????????????
                People mOversea = new Oversea(mDomestic);//???????????????????????????domestic????????????????????????
                mOversea.buy(); //?????????????????????buy()
            }
        });

        btnDynamicProxy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                People mDomestic = new Domestic();//?????????????????????
                DynamicProxy dynamicProxy = new DynamicProxy(mDomestic); //??????????????????
                ClassLoader classLoader = mDomestic.getClass().getClassLoader();  //??????ClassLoader
                //?????? Proxy ???????????????????????? ????????????????????????????????????
                People mOversea = (People) Proxy.newProxyInstance(classLoader, new Class[]{People.class}, dynamicProxy);
                mOversea.buy();
            }
        });

        btnCompose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //????????????????????? root
                PageElement root = new Column("????????????");
                //???????????????????????????????????????,??????;???????????????????????????
                PageElement music = new Column("??????");
                PageElement video = new Column("??????");
                PageElement ad = new Content("??????");
                root.addPageElement(music);
                root.addPageElement(video);
                root.addPageElement(ad);
                //??????????????????????????????????????????,??????
                PageElement chineseMusic = new Column("??????");
                PageElement cantoneseMusic = new Column("??????");
                music.addPageElement(chineseMusic);
                music.addPageElement(cantoneseMusic);
                //??????,??????????????????????????????
                chineseMusic.addPageElement(new Content("??????.mp3"));
                cantoneseMusic.addPageElement(new Content("????????????.mp3"));
                //??????????????????????????????
                video.addPageElement(new Content("??????????????????.avi"));

                //???????????????????????????
                root.print("");
            }
        });

        btnAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Electric electric = new Electric();
                System.out.println("???????????????" + electric.output_220v());
                Adapter phoneAdapter = new PhoneAdapter(electric);//??????????????????????????????
                System.out.println("???????????????????????????" + phoneAdapter.convert_5v());

                Adapter phoneAdapter2 = new PhoneAdapter2();
                System.out.println("???????????????????????????" + phoneAdapter2.convert_5v());
            }
        });

        btnDecoretor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Room room = new NewRoom();//??????????????????
                DecoratorRoom bedroom = new Bedroom(room);
                bedroom.fitment();//???????????????
                DecoratorRoom kitchen = new Kitchen(room);
                kitchen.fitment();//???????????????
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
                //????????????????????????????????????login()???pay()????????????????????????????????????????????????????????????????????????????????????????????????SDK?????????????????????
                GameSdk gameSdk = new GameSdk();
                gameSdk.login();
                gameSdk.pay(6);
            }
        });
        btnBridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //????????????????????????
                Clothes uniform = new Uniform();
                Clothes shirt = new Shirt();

                //???????????????????????????
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
        // ????????????????????????
        Singleton singeton1 = (Singleton) con.newInstance();
        Singleton singeton2 = (Singleton) con.newInstance();
        System.out.println(singeton1==singeton2);//?????????false,singeton1???singeton2???????????????????????????
    }
}