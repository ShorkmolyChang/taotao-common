package com.taotao.common.pojo;

import java.util.List;

public class EasyUIDataGridResult {

	private long total;
	// 如果用<T>表示，需要在类名后面加上<T>,创建类对象时需要指定泛型的类型。<?>不需要。
	private List<?> rows;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
