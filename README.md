# ListViewcheckDeletepackage com.stx.xhb.listviewcheckdelete;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.stx.xhb.listviewcheckdelete.merchantdemo.CharacterParser;
import com.stx.xhb.listviewcheckdelete.merchantdemo.ClearEditText;
import com.stx.xhb.listviewcheckdelete.merchantdemo.GroupMemberBean;
import com.stx.xhb.listviewcheckdelete.merchantdemo.PinyinComparator;
import com.stx.xhb.listviewcheckdelete.merchantdemo.PinyinUtils;
import com.stx.xhb.listviewcheckdelete.merchantdemo.SideBar;
import com.stx.xhb.listviewcheckdelete.merchantdemo.SortAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Created by 皓 on 2017/2/15.
 */

public class ServiceMerchantActivity extends Activity implements View.OnClickListener {
    private List<GroupMemberBean> data  ;
    private List<GroupMemberBean> oldData ;
    private List<GroupMemberBean> newData  = new ArrayList<>();
    List<GroupMemberBean> date ;
    private ListView listView ;
    private SideBar sideBar;
    private TextView dialog;
    private SortAdapter adapter;
    private ClearEditText mClearEditText;
    private TextView tvNofriends;
    /**
     * 汉字转换成拼音的类
     */
    private CharacterParser characterParser;
    /**
     * 根据拼音来排列ListView里面的数据类
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicemerchant);
        date = new ArrayList<>();
        oldData = new ArrayList<>();
        date.add(new GroupMemberBean("1","22","我",false));
        date.add(new GroupMemberBean("2","22","你",false));
        date.add(new GroupMemberBean("3","22","他",false));
        date.add(new GroupMemberBean("4","22","好",false));
        date.add(new GroupMemberBean("5","22","人",false));
        date.add(new GroupMemberBean("6","22","啊",false));
        date.add(new GroupMemberBean("7","22","我",false));
        date.add(new GroupMemberBean("8","22","你",false));
        date.add(new GroupMemberBean("9","22","他",false));
        date.add(new GroupMemberBean("10","22","好",false));
        date.add(new GroupMemberBean("11","22","人",false));
        date.add(new GroupMemberBean("12","22","啊",false));
        date.add(new GroupMemberBean("13","22","我",false));
        date.add(new GroupMemberBean("14","22","你",false));
        date.add(new GroupMemberBean("15","22","他",false));
        date.add(new GroupMemberBean("16","22","好",false));
        date.add(new GroupMemberBean("17","22","人",false));
        date.add(new GroupMemberBean("18","22","啊",false));
        date.add(new GroupMemberBean("19","22","我",false));
        date.add(new GroupMemberBean("20","22","你",false));
        date.add(new GroupMemberBean("21","22","他",false));
        date.add(new GroupMemberBean("22","22","好",false));
        date.add(new GroupMemberBean("23","22","人",false));
        date.add(new GroupMemberBean("24","22","啊",false));
        date.add(new GroupMemberBean("25","22","我",false));
        date.add(new GroupMemberBean("26","22","你",false));
        date.add(new GroupMemberBean("27","22","他",false));
        date.add(new GroupMemberBean("28","22","好",false));
        date.add(new GroupMemberBean("29","22","人",false));
        date.add(new GroupMemberBean("30","22","啊",false));
        date.add(new GroupMemberBean("31","22","我",false));
        date.add(new GroupMemberBean("32","22","你",false));
        date.add(new GroupMemberBean("33","22","他",false));
        date.add(new GroupMemberBean("34","22","好",false));
        date.add(new GroupMemberBean("35","22","人",false));
        date.add(new GroupMemberBean("36","22","啊",false));
        date.add(new GroupMemberBean("37","22","我",false));
        date.add(new GroupMemberBean("38","22","你",false));
        date.add(new GroupMemberBean("39","22","他",false));
        date.add(new GroupMemberBean("40","22","好",false));
        date.add(new GroupMemberBean("41","22","人",false));
        date.add(new GroupMemberBean("42","22","啊",false));
        date.add(new GroupMemberBean("43","22","我",false));
        date.add(new GroupMemberBean("44","22","你",false));
        date.add(new GroupMemberBean("45","22","他",false));
        date.add(new GroupMemberBean("46","22","好",false));
        date.add(new GroupMemberBean("47","22","人",false));
        date.add(new GroupMemberBean("48","22","啊",false));
        date.add(new GroupMemberBean("49","22","我",false));
        date.add(new GroupMemberBean("50","22","你",false));
        date.add(new GroupMemberBean("51","22","他",false));
        date.add(new GroupMemberBean("52","22","好",false));
        date.add(new GroupMemberBean("53","22","人",false));
        date.add(new GroupMemberBean("54","22","啊",false));
        date.add(new GroupMemberBean("55","22","你",false));
        date.add(new GroupMemberBean("56","22","q",false));
        date.add(new GroupMemberBean("57","22","c",false));
        date.add(new GroupMemberBean("58","22","v",false));
        date.add(new GroupMemberBean("59","22","a",false));
        init(date);
    }
    //返回数据给MyAdapter使用
    public  List<GroupMemberBean> getData(){
        return date;
    }
    private List<GroupMemberBean> getData ( List <GroupMemberBean> date) {
        List<GroupMemberBean> listarray = new ArrayList<GroupMemberBean>();
        for (int i = 0; i < date.size(); i++) {
            String pinyin = PinyinUtils.getFirstSpell(date.get(i).getMerName());
            String Fpinyin = pinyin.substring(0, 1).toUpperCase();
            GroupMemberBean person = new GroupMemberBean();
            person.setId(date.get(i).getId());
            person.setLogoPath(date.get(i).getLogoPath());
            person.setMerName(date.get(i).getMerName());
            person.setPinYin(pinyin);
            person.setChecked(date.get(i).getChecked());
//            String pinyin = characterParser.getSelling(dates.get(i).getMerName());
            // 正则表达式，判断首字母是否是英文字母
            if (Fpinyin.matches("[A-Z]")) {
                person.setFirstPinYin(Fpinyin);
            } else {
                person.setFirstPinYin("#");
            }

            listarray.add(person);
        }
        return listarray;

    }

    private void init(final List<GroupMemberBean> date) {
        // TODO Auto-generated method stub
        sideBar = (SideBar) findViewById(R.id.sidrbar);
        listView = (ListView) findViewById(R.id.country_lvcountry);
        tvNofriends = (TextView) this
                .findViewById(R.id.title_layout_no_friends);
        characterParser = CharacterParser.getInstance();
        dialog = (TextView) findViewById(R.id.dialog);
        sideBar.setTextView(dialog);
        // 设置字母导航触摸监听
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {

            @Override
            public void onTouchingLetterChanged(String s) {
                // TODO Auto-generated method stub
                // 该字母首次出现的位置
                int position = adapter.getPositionForSelection(s.charAt(0));

                if (position != -1) {
                    listView.setSelection(position);
                }
            }
        });
        data = getData(date);
        oldData = getData(date);
        // 数据在放在adapter之前需要排序
        Collections.sort(data, new PinyinComparator());
        adapter = new SortAdapter(ServiceMerchantActivity.this, data);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        mClearEditText = (ClearEditText) findViewById(R.id.filter_edit);

        // 根据输入框输入值的改变来过滤搜索
        mClearEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                // 这个时候不需要挤压效果 就把他隐藏掉
//                titleLayout.setVisibility(View.GONE);
                // 当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
                filterData(s.toString());
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(ServiceMerchantActivity.this,"position"+position,Toast.LENGTH_SHORT).show();
                data.get(position).setChecked(!data.get(position).getChecked());
                newData = data ;
                adapter.notifyDataSetChanged();
            }
        });
    }
    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
    /**
     * 根据输入框中的值来过滤数据并更新ListView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
        List<GroupMemberBean> filterDateList = new ArrayList<GroupMemberBean>();
        if (TextUtils.isEmpty(filterStr)) {
            filterDateList = oldData;
            data = oldData ;
            tvNofriends.setVisibility(View.GONE);
        } else {
            filterDateList.clear();
            for (GroupMemberBean sortModel : data) {
                String name = sortModel.getMerName();
                if (name.indexOf(filterStr.toString()) != -1
                        || characterParser.getSelling(name).startsWith(
                        filterStr.toString())) {
                    filterDateList.add(sortModel);
                }
            }
            data = filterDateList ;
        }
        // 根据a-z进行排序
        Collections.sort(filterDateList, new PinyinComparator());
        adapter.updateListView(filterDateList);
        if (filterDateList.size() == 0) {
            tvNofriends.setVisibility(View.VISIBLE);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onClick(View v) {
    }
   ///勾选删除的
 /*   //删除按钮点击事件
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
    });*/



}
