package com.stx.xhb.listviewcheckdelete;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xhb
 * listView中嵌入复选框实现单选、全选删除列表条目
 * 注意事项：
 *1.子布局中的checkBox以下两个属性（会导致onItemClickListener（即单个条目的点击事件）失效）：
 * android:clickable="false"
 * android:focusable="false"
 *2.在删除过程中，首先应该把勾选的删除内容添加到一个新的删除集合中，不能直接在数据源中进行删除，否则会报异常
 *3.在删除之后，并把删除集合中的内容清空
 */
public class MainActivity extends AppCompatActivity {


    private int checkId=-1;
    //定义listview
    private ListView lv_data;
    //定义控件
    private Button btn_delete;
    private CheckBox che_all;
    //声明一个集合（数据源）
    private List<Item> data;
    //定义自定义适配器
    private MyAdapter myAdapter;
    //给数据源添加数据
    private void initdata(){
        data=new ArrayList<>();
        for (int i=0;i<=10;i++){
            data.add(new Item("小明"+i,"110"+i,false));
        }
    }
    //返回数据给MyAdapter使用
    public  List<Item> getData(){
        return this.data;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取listView
        lv_data= (ListView) findViewById(R.id.lv_data);
        //获取控件
        btn_delete= (Button) findViewById(R.id.btn_delete);
        che_all= (CheckBox) findViewById(R.id.che_all);
        //初始化数据源
        initdata();
        //实例化自定义适配器，把listview传到自定义适配器中
        myAdapter =new MyAdapter(this,lv_data);
        //绑定适配器
        lv_data.setAdapter(myAdapter);
        //初始化事件监听
        initlistener();
    }

    /**
     * 初始化事件监听方法
     */
    private void initlistener() {
//listView单个条目事件监听
        lv_data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              /*  if(position==checkId){
                    data.get(position).setChecked(false);
                    checkId= -1 ;
                    Toast.makeText(MainActivity.this, position+"     1111"+"   "+checkId, Toast.LENGTH_SHORT).show();
                }else {
                    data.get(position).setChecked(true);
                    checkId= position ;
                    Toast.makeText(MainActivity.this, position+"     222"+"    "+checkId   , Toast.LENGTH_SHORT).show();
                }*/
              //  boolean a = data.get(position).getChecked()==false ? true : false;
                data.get(position).setChecked(!data.get(position).getChecked());
                myAdapter.notifyDataSetChanged();
            }
        });
        /**
         * 全选复选框设置事件监听
         */
        che_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (data.size()!=0) {//判断列表中是否有数据
                    if (isChecked) {
                        for (int i = 0; i < data.size(); i++) {
                            data.get(i).setChecked(true);
                        }
                        //通知适配器更新UI
                        myAdapter.notifyDataSetChanged();
                    } else {
                        for (int i = 0; i < data.size(); i++) {
                            data.get(i).setChecked(false);
                        }
                        //通知适配器更新UI
                        myAdapter.notifyDataSetChanged();
                    }
                }else{//若列表中没有数据则隐藏全选复选框
                    che_all.setVisibility(View.GONE);
                }
            }
        });
        //删除按钮点击事件
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建一个要删除内容的集合，不能直接在数据源data集合中直接进行操作，否则会报异常
                List<Item> deleSelect = new ArrayList<Item>();

                //把选中的条目要删除的条目放在deleSelect这个集合中
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getChecked()) {
                        deleSelect.add(data.get(i));
                    }
                }
                //判断用户是否选中要删除的数据及是否有数据
                if (deleSelect.size() != 0 && data.size() != 0) {
                    //从数据源data中删除数据
                    data.removeAll(deleSelect);
                    //把deleSelect集合中的数据清空
                    deleSelect.clear();
                    //把全选复选框设置为false
                    che_all.setChecked(false);
                    //通知适配器更新UI
                    myAdapter.notifyDataSetChanged();
                } else if (data.size() == 0) {
                    Toast.makeText(MainActivity.this, "没有要删除的数据", Toast.LENGTH_SHORT).show();
                } else if (deleSelect.size() == 0) {
                    Toast.makeText(MainActivity.this, "请选中要删除的数据", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
