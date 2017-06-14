package com.vamsi.challenge;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		BlockingQueue<Integer> inputQueue = new LinkedBlockingQueue<Integer>();
		BlockingQueue<String> outputQueue = new LinkedBlockingQueue<String>();

		Randomizer randomizer = new Randomizer(inputQueue, outputQueue);
		Prime prime = new Prime(inputQueue, outputQueue);

		System.out.println("*******START******");
		new Thread(randomizer).start();
		new Thread(prime).start();

	}
}