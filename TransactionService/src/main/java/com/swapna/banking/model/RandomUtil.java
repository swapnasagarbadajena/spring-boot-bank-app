package com.swapna.banking.model;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;

public class RandomUtil {


	public static Long generateRandomNumber() {

		Random random = new Random();
		Long rand = Math.round(random.nextFloat() * Math.pow(10,12));
		return rand;
	}
	
	
	public static Double generateDoubleNumber() {
		
		Random random = new Random();
		Double rand = (double) Math.round(random.nextDouble() * Math.pow(2,12));
		return rand;
	}
	
	
	public static Long getRandomNumber(int length) {
		return Long.valueOf(RandomStringUtils.randomNumeric(length));
	}
	
	
	public static Long generateAccountNumber() {
		return Long.valueOf(RandomStringUtils.randomNumeric(14));
	}
	
	

	public static void main(String[] args) {
		//System.out.println(generateRandomNumber());
		//System.out.println(generateDoubleNumber());
		System.out.println(getRandomNumber(12));
		
	}

}
