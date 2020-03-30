package com.company;

/*
public class Main {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.interrupt();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread main");
	// write your code here
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("thread 8");
    }
}
*/

public class Main {
    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.join(); // метод join. Смысл его в следующем. Одна нить ждет, пока полностью завершится работа второй нити: первая нить (которая вызвала метод) приостанавливает свою работу до окончания работы второй нити (у объекта которой был вызван метод).
        // Thread.yield(); // Когда задача вызывает метод yield(), она меняет состояние потока из running в runnable. Runnable - состояние потока, в котором со стороны программы ему ничего не мешает выполняться. Оно делится на два Ready и Running.
        System.out.println("thread main");
    }
}
class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i< 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("thread 8");
    }
}

// В станні Running знаходиться тільки один потік. Інші - в станні Runnable (в пулі). Потоки можуть переходити із одного стану в інший.
// Потоки можуть бути в стані Waiting/blocked/sleeping
// Ми можемо зрлобити так, щоб тільки текучий потік заснув
// Три основні методи: sleep, yield, join.