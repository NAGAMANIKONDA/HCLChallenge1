package com.vamsi.challenge;

import java.util.concurrent.BlockingQueue;

public class Randomizer implements Runnable {

	private BlockingQueue<Integer> inputQueue;
	private BlockingQueue<String> outputQueue;
	private int randomNumber = 0;
	private String answer = "";

	public Randomizer(BlockingQueue<Integer> inputQueue, BlockingQueue<String> outputQueue) {
		// TODO Auto-generated constructor stub
		this.inputQueue = inputQueue;
		this.outputQueue = outputQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				randomNumber = getRandomNumber();
				inputQueue.put(randomNumber);
				
				if (!outputQueue.isEmpty()) {
					answer = outputQueue.take();
					if (answer.split(":")[1].equals("true")) {
						System.out.println(answer.split(":")[0] + " --> " + "Prime");
					} else {
						System.out.println(answer.split(":")[0] + " --> " + "Not Prime");
					}
				}
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private int getRandomNumber() {
		int randomNumber = (int) (Math.random() * (100 + 1));
		return randomNumber;
	}
}