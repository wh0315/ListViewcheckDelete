package com.stx.xhb.listviewcheckdelete.merchantdemo;

import java.util.Comparator;

public class PinyinComparator implements Comparator<GroupMemberBean> {

	@Override
	public int compare(GroupMemberBean lhs, GroupMemberBean rhs) {
		// TODO Auto-generated method stub
		return sort(lhs, rhs);
	}

	private int sort(GroupMemberBean lhs, GroupMemberBean rhs) {
		int lhs_ascii = lhs.getFirstPinYin().toUpperCase().charAt(0);
		int rhs_ascii = rhs.getFirstPinYin().toUpperCase().charAt(0);
		if (lhs_ascii < 65 || lhs_ascii > 90)
			return 1;
		else if (rhs_ascii < 65 || rhs_ascii > 90)
			return -1;
		else
			return lhs.getPinYin().compareTo(rhs.getPinYin());
	}

}
