package com.stx.xhb.listviewcheckdelete.merchantdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.stx.xhb.listviewcheckdelete.R;
import com.stx.xhb.listviewcheckdelete.ServiceMerchantActivity;

import java.util.List;

public class SortAdapter extends BaseAdapter {
	private Context context;
	private List<GroupMemberBean> persons;
	private LayoutInflater inflater;
	//定义一个数据源的引用
	private List<GroupMemberBean> data;
	public SortAdapter(Context context, List<GroupMemberBean> persons) {
		this.context = context;
		this.persons = persons;
		this.inflater = LayoutInflater.from(context);
		data=((ServiceMerchantActivity)this.context).getData();
	}
	public void updateListView(List<GroupMemberBean> list) {
		this.persons = list;
		notifyDataSetChanged();
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return persons.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return persons.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewholder = null;
		GroupMemberBean person = persons.get(position);
		if (convertView == null) {
			viewholder = new ViewHolder();
			convertView = inflater.inflate(R.layout.activity_group_member_item, null);
			viewholder.tvTitle = (TextView) convertView.findViewById(R.id.title);
			viewholder.tvLetter = (TextView) convertView.findViewById(R.id.catalog);
			viewholder.ch_delete= (CheckBox) convertView.findViewById(R.id.ch_delete);
			convertView.setTag(viewholder);
		} else {
			viewholder = (ViewHolder) convertView.getTag();
		}
		int selection = person.getFirstPinYin().charAt(0);
		int positionForSelection = getPositionForSelection(selection);
		if (position == positionForSelection) {
			viewholder.tvLetter.setVisibility(View.VISIBLE);
			viewholder.tvLetter.setText(person.getFirstPinYin());
		} else {
			viewholder.tvLetter.setVisibility(View.GONE);

		}
		viewholder.tvTitle.setText(person.getMerName());
		viewholder.ch_delete.setChecked(person.getChecked());
		return convertView;
	}

	public int getPositionForSelection(int selection) {
		for (int i = 0; i < persons.size(); i++) {
			String Fpinyin = persons.get(i).getFirstPinYin();
			char first = Fpinyin.toUpperCase().charAt(0);
			if (first == selection) {
				return i;
			}
		}
		return -1;

	}

	class ViewHolder {
		TextView tvLetter;
		TextView tvTitle;
		CheckBox ch_delete;
	}

}
