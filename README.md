# HCLChallenge1

## Description:

* This program has two threads which shares two queues.
* Randomizer thread generates random numbers between 1 and 100 (customizable) and sends it to the input queue.
* Prime Thread receives the numbers from the inputQueue, checks if they are prime and writes the result to the output queue 
* Randomizer thread then receives the result from the output queue and displays it. 
* A blocking queue is used for this purpose.
* Threads run infinitely until you stop it. 

## Steps for running
Simply run App.java and see output printing on console
