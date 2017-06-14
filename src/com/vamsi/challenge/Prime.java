package com.vamsi.challenge;

import java.util.concurrent.BlockingQueue;

public class Prime implements Runnable {

	private BlockingQueue<Integer> inputQueue;
	private BlockingQueue<String> outputQueue;
	private String answer = "";
	private Boolean isPrime = false;

	public Prime(BlockingQueue<Integer> inputQueue, BlockingQueue<String> outputQueue) {
		// TODO Auto-generated constructor stub
		this.inputQueue = inputQueue;
		this.outputQueue = outputQueue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				if (!inputQueue.isEmpty()) {
					int number = inputQueue.take();
					isPrime = checkPrime(number) ? true : false;
					answer = number + ":";
					answer += isPrime;
					outputQueue.put(answer);
				}

				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	private Boolean checkPrime(int n) {
		if (n == 0 || n == 1 || n < 0) {
			return false;
		}

		if (n == 2) {
			return true;
		}

		if (n % 2 == 0) {
			return false;
		}

		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}