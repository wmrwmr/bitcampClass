package com.bitcamp.mvc.domain;

public class SearchType {

	private int value;
	private String text;

	public SearchType() {
	}

	public SearchType(int value, String text) {
		this.value = value;
		this.text = text;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
