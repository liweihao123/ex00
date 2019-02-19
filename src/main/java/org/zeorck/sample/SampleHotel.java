package org.zeorck.sample;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@Getter
@RequiredArgsConstructor
public class SampleHotel {
	@NonNull //Null 아닐때 객체를 만들어 달라
	private Chef chef;
	private String name;

	/* @RequiredArgsConstructor를 만들었기 때문에 여기서 생성자를 생략^
	 * public SampleHotel(Chef chef) { this.chef = chef; }
	 */
	
	
	

}
