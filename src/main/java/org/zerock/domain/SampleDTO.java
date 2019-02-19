package org.zerock.domain;

import org.springframework.stereotype.Component;

@Component //이걸 써주는것은 이것은 하나의 "객체"다 알려주는 것. 써도되고 안써도됨
public class SampleDTO {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
